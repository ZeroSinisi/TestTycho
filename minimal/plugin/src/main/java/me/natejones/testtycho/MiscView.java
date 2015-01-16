package me.natejones.testtycho;

import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

public class MiscView extends ViewPart {

	private Table	colorTable;
	private Label	colorField;
	private Display	display;

	public MiscView() {
		display = Display.getCurrent();
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(5, false));
		Tree tree = new Tree(parent, SWT.BORDER);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		TreeItem trtmA = new TreeItem(tree, SWT.NONE);
		trtmA.setText("A");
		TreeItem treeItem = new TreeItem(trtmA, SWT.NONE);
		treeItem.setText("1");
		TreeItem treeItem_1 = new TreeItem(trtmA, SWT.NONE);
		treeItem_1.setText("2");
		trtmA.setExpanded(true);
		TreeItem trtmB = new TreeItem(tree, SWT.NONE);
		trtmB.setText("B");
		TreeItem trtmI = new TreeItem(trtmB, SWT.NONE);
		trtmI.setText("I");
		TreeItem trtmIi = new TreeItem(trtmI, SWT.NONE);
		trtmIi.setText("II");
		colorField = new Label(parent, SWT.NONE);
		colorField.setText("                        ");
		colorField.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		colorField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		colorField.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {}

			@Override
			public void mouseDown(MouseEvent e) {
				int[] rgb = randomColor();
				colorField.setBackground(new Color(display, rgb[0], rgb[1], rgb[2]));
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {}
		});
		Composite buttons = new Composite(parent, SWT.NONE);
		buttons.setLayout(new GridLayout(1, false));
		buttons.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		Button btnStartJob = new Button(buttons, SWT.NONE);
		btnStartJob.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 1, 1));
		btnStartJob.setText("Start Job");
		Button btnCycleColors = new Button(buttons, SWT.TOGGLE | SWT.CENTER);
		btnCycleColors.addSelectionListener(new SelectionListener() {

			Thread	task;

			@Override
			public void widgetSelected(SelectionEvent e) {
				Button tglBtn = (Button) e.getSource();
				if (tglBtn.getSelection()) {
					task = new Thread() {

						private boolean	working	= true;

						@Override
						public void run() {
							while (working) {
								final int[] rgb = randomColor();
								display.asyncExec(new Runnable() {

									@Override
									public void run() {
										colorField.setBackground(new Color(display, rgb[0], rgb[1], rgb[2]));
									}
								});
								try {
									sleep(500);
								} catch (InterruptedException e) {
									working = false;
								}
							}
						}
					};
					task.start();
				} else {
					while (task.isAlive()) {
						task.interrupt();
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		btnCycleColors.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 1, 1));
		btnCycleColors.setText("Cycle Colors");
		btnStartJob.addSelectionListener(new JobSelectionAdapter(getSite().getShell()));
		Composite dragColors = new Composite(parent, SWT.NONE);
		dragColors.setLayout(new GridLayout(1, false));
		dragColors.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		final Label lblRed = new Label(dragColors, SWT.NONE);
		lblRed.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblRed.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		lblRed.setText("Red");
		DragSource dragSourceRed = new DragSource(lblRed, DND.DROP_MOVE | DND.DROP_COPY);
		Transfer[] types = new Transfer[] { TextTransfer.getInstance() };
		dragSourceRed.setTransfer(types);
		dragSourceRed.addDragListener(new DragSourceListener() {

			@Override
			public void dragStart(DragSourceEvent event) {}

			@Override
			public void dragSetData(DragSourceEvent event) {
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = lblRed.getText();
				}
			}

			@Override
			public void dragFinished(DragSourceEvent event) {
				// TODO Auto-generated method stub
			}
		});
		final Label lblBlue = new Label(dragColors, SWT.NONE);
		lblBlue.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblBlue.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		lblBlue.setText("Blue");
		DragSource dragSourceBlue = new DragSource(lblBlue, DND.DROP_MOVE);
		dragSourceBlue.setTransfer(types);
		dragSourceBlue.addDragListener(new DragSourceListener() {

			@Override
			public void dragStart(DragSourceEvent event) {}

			@Override
			public void dragSetData(DragSourceEvent event) {
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = lblBlue.getText();
				}
			}

			@Override
			public void dragFinished(DragSourceEvent event) {}
		});
		final Label lblGreen = new Label(dragColors, SWT.NONE);
		lblGreen.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblGreen.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		lblGreen.setText("Green");
		DragSource dragSourceGreen = new DragSource(lblGreen, DND.DROP_MOVE);
		dragSourceGreen.setTransfer(types);
		dragSourceGreen.addDragListener(new DragSourceListener() {

			@Override
			public void dragStart(DragSourceEvent event) {}

			@Override
			public void dragSetData(DragSourceEvent event) {
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = lblGreen.getText();
				}
			}

			@Override
			public void dragFinished(DragSourceEvent event) {}
		});
		colorTable = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		colorTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		colorTable.setHeaderVisible(true);
		colorTable.setLinesVisible(true);
		DropTarget dropTargetColorTable = new DropTarget(colorTable, DND.DROP_MOVE);
		final TextTransfer textTransfer = TextTransfer.getInstance();
		types = new TextTransfer[] { textTransfer };
		dropTargetColorTable.setTransfer(types);
		dropTargetColorTable.addDropListener(new DropTargetListener() {

			@Override
			public void dropAccept(DropTargetEvent event) {}

			@Override
			public void drop(DropTargetEvent event) {
				if (TextTransfer.getInstance().isSupportedType(event.currentDataType)) {
					String text = (String) event.data;
					TableItem item = new TableItem(colorTable, SWT.NONE);
					item.setText(text);
					switch (text) {
					case "Red":
						item.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
						break;
					case "Blue":
						item.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
						break;
					case "Green":
						item.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
						break;
					}
				}
			}

			@Override
			public void dragOver(DropTargetEvent event) {}

			@Override
			public void dragOperationChanged(DropTargetEvent event) {}

			@Override
			public void dragLeave(DropTargetEvent event) {}

			@Override
			public void dragEnter(DropTargetEvent event) {}
		});
	}

	@Override
	public void setFocus() {}

	public int[] randomColor() {
		int r, g, b;
		Random rand = new Random();
		r = rand.nextInt(255);
		g = rand.nextInt(255);
		b = rand.nextInt(255);
		int[] rgb = { r, g, b };
		return rgb;
	}
}
