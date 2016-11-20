/**
 * 
 */
package com.github.finalfin.multitimer.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.github.finalfin.multitimer.core.TimerListElement;

/**
 * @author Piotr Sulecki
 *
 */
public class MainPanel extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5841567265614036343L;

	public MainPanel() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(getExtendedState() | Frame.MAXIMIZED_BOTH);

		TimerListModel model = new TimerListModel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		JList<TimerListElement> timerList = new JList<TimerListElement>(model);
		scrollPane.setViewportView(timerList);

		getContentPane().add(getButtonsPanel(), BorderLayout.SOUTH);
		addMainMenuBar();
	}

	private JPanel getButtonsPanel() {
		JPanel buttonsPanel = new JPanel();

		JButton addTimerButton = new JButton("Add timer");
		addTimerButton.addActionListener(this);
		addTimerButton.setActionCommand("newTimer");
		buttonsPanel.add(addTimerButton);

		JButton addAlarmButton = new JButton("Add alarm");
		addAlarmButton.addActionListener(this);
		addAlarmButton.setActionCommand("newAlarm");
		buttonsPanel.add(addAlarmButton);

		JButton addStopperButton = new JButton("Add stopper");
		addStopperButton.addActionListener(this);
		addStopperButton.setActionCommand("newStopper");
		buttonsPanel.add(addStopperButton);
		return buttonsPanel;
	}

	private void addMainMenuBar() {
		MenuBar mb = new MenuBar();
		Menu fileMenu = new Menu("File");
		MenuItem mi = new MenuItem("Exit", new MenuShortcut(KeyEvent.VK_X));
		mi.setActionCommand("exit");
		fileMenu.add(mi);
		fileMenu.addActionListener(this);
		mb.add(fileMenu);
		this.setMenuBar(mb);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		switch (event) {
		case "exit":
			System.exit(0);
			break;
		default:
			throw new UnsupportedOperationException("Handler for event '" + event + "' not implemented");
		}
	}

}
