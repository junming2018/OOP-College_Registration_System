import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class staff_eFact_LossKey {
	private controller controller;
	private File file;
	private JFrame frame;
	private JLabel lbl_title;
	private JTextArea txt_report;
	private JButton btn_back;

	public staff_eFact_LossKey() {
		initialize();
	}

	public void staff_eFact_LossKey_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setTitle("eFact - Loss of Room Key Report for Staff");
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("Loss of Room Key Report");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		lbl_title.setBounds(10, 24, 676, 38);
		frame.getContentPane().add(lbl_title);
		
		txt_report = new JTextArea();
		txt_report.setEditable(false);
		txt_report.setBounds(25, 79, 642, 261);
		frame.getContentPane().add(txt_report);
		try {
			file = new File("loss_of_room_key_report.txt");
			FileReader reader =  new FileReader(file);
			BufferedReader show = new BufferedReader(reader);
			txt_report.read (show,null);
			show.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Temporarily No Report");
		}
		
		btn_back = new JButton("Back");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(274, 360, 135, 38);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.staff_eFact();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);
	}
}