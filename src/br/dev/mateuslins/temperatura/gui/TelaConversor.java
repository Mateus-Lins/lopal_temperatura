package br.dev.mateuslins.temperatura.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.mateuslins.temperatura.model.Temperatura;

public class TelaConversor {

	private JLabel labelCelsius;
	private JTextField textCelsius;

	private JButton buttonKelvin;
	private JButton buttonFahreinheit;

	private JLabel labelResultado;

	private JLabel labelMensagemErro;

	public void criarTela() {
		JFrame tela = new JFrame();
		
		Dimension tamanho = new Dimension();
		tamanho.setSize(830, 1000);
		
		tela.setSize(tamanho);
		
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tela.setTitle("conversor de temperatura");
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		
		textCelsius = new JTextField();
		textCelsius.setBounds(40, 140, 720, 100);
		
		labelCelsius = new JLabel();
		labelCelsius.setText("temperatura em celsius");
		labelCelsius.setBounds(40, 40, 400, 100);
		
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(400, 300, 350, 200);
		
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("Fahreinheit");
		buttonFahreinheit.setBounds(40, 300, 350, 200);
		
		labelResultado = new JLabel();
		labelResultado.setText("");
		labelResultado.setBounds(40, 520, 720, 100);
		
		labelMensagemErro = new JLabel();
		labelMensagemErro.setBounds(40, 640, 720, 100);
		
		
		buttonFahreinheit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					Temperatura temperatura = new Temperatura();
					double fahreinheit = Double.parseDouble(textCelsius.getText());
					temperatura.setCelsius(fahreinheit);
					double temp = temperatura.converterFahrenheit();
					labelResultado.setText(temp + "Fahreinheit");
					labelMensagemErro.setText("");
					
				} catch(Exception erro) {
					labelResultado.setText("");
					labelMensagemErro.setText("Erro, insira apenas números");
				}
				
			}
		});
		
		buttonKelvin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					Temperatura temperatura = new Temperatura();
					double kelvin = Double.parseDouble(textCelsius.getText());
					temperatura.setCelsius(kelvin);
					double temp = temperatura.converterFahrenheit();
					labelResultado.setText(temp + "kelvin");
					labelMensagemErro.setText("");
					
				} catch(Exception erro) {
					labelResultado.setText("");
					labelMensagemErro.setText("Erro, insira apenas números");
				}
				
			}
		});
		
		tela.getContentPane().add(labelCelsius);
		tela.getContentPane().add(textCelsius);
		tela.getContentPane().add(buttonFahreinheit);
		tela.getContentPane().add(buttonKelvin);
		tela.getContentPane().add(labelResultado);
		tela.getContentPane().add(labelMensagemErro);
		
		tela.setVisible(true);
	}
}
