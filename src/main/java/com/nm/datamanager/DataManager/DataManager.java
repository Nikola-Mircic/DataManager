package com.nm.datamanager.DataManager;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.nm.datamanager.DataManager.Server.DataManagerServer;

public class DataManager {

	public DataManager() {
		
	}
	
	public static void main(String[] args) {
		DataManagerServer server = new DataManagerServer(args);
		
		JFrame frame = new JFrame("Data manager");
		frame.setSize(new Dimension(600, 400));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		
		panel.setSize(new Dimension(600, 400));
		
		JButton btnStart = new JButton("Start server");
		JButton btnStop = new JButton("Stop server");
		
		btnStart.setBounds(225, 120, 150, 75);
		btnStop.setBounds(225, 205, 150, 75);
		
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				server.start();
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				server.stop();
			}
		});
		
		panel.add(btnStart);
		panel.add(btnStop);
		frame.add(panel);
		frame.pack();
		
		frame.setVisible(true);
	}
}
