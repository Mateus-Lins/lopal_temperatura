package br.dev.mateuslins.temperatura.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.mateuslins.temperatura.model.Temperatura;

public class TelaConversor {

	//criando atributos e os deixando privados
	private JLabel labelCelsius;
	private JTextField textCelsius;

	private JButton buttonKelvin;
	private JButton buttonFahreinheit;

	private JLabel labelResultado;

	private JLabel labelMensagemErro;
	
	//escolhendo a cor no padrão RGB
	private Color labelsColor = new Color(255, 0, 0);

	public void criarTela() {
		
		//dimensionando e posicionando os elementos da tela
		JFrame tela = new JFrame();
		
		Dimension tamanho = new Dimension();
		tamanho.setSize(830, 1000);
		
		tela.setSize(tamanho);
		
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tela.setTitle("conversor de temperatura");
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		
		//JTextField para o celsius
		textCelsius = new JTextField();
		textCelsius.setBounds(40, 140, 720, 100);
		
		//JLabel para o Celsius
		labelCelsius = new JLabel();
		labelCelsius.setText("temperatura em celsius");
		labelCelsius.setBounds(40, 40, 400, 100);
		
		//criando e definindo o tamanho do botão para kelvin
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(400, 300, 350, 200);
		
		//criando e definindo o tamanho do botão para fahreinheit
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("Fahreinheit");
		buttonFahreinheit.setBounds(40, 300, 350, 200);
		
		//criando e posicionando um JLabel para a mensagem do resultado e para a mensagem de erro
		labelResultado = new JLabel();
		labelResultado.setText("");
		labelResultado.setBounds(40, 520, 720, 100);
		
		labelMensagemErro = new JLabel();
		labelMensagemErro.setBounds(40, 520, 720, 100);
		
		//pegando os elementos da tela
		tela.getContentPane().add(labelCelsius);
		tela.getContentPane().add(textCelsius);
		tela.getContentPane().add(buttonFahreinheit);
		tela.getContentPane().add(buttonKelvin);
		labelMensagemErro.setForeground(labelsColor);
		
		//definindo a ação do botão fahreinheit
		buttonFahreinheit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//buscando um erro que o usuário possa ter cometido
				try {
					Temperatura temperatura = new Temperatura();
					double fahreinheit = Double.parseDouble(textCelsius.getText());
					temperatura.setCelsius(fahreinheit);
					double temp = temperatura.converterFahrenheit();
					labelResultado.setText(temp + "Fahreinheit");
					labelMensagemErro.setText("");
					
					//exibe a mensagem de erro para o usuário
				} catch(Exception erro) {
					labelResultado.setText("");
					labelMensagemErro.setText("Erro, insira apenas números");
				}
				
			}
		});
		
		//definindo a ação do botão kelvin
		buttonKelvin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//buscando um erro que o usuário possa ter cometido
				try {
					Temperatura temperatura = new Temperatura();
					double kelvin = Double.parseDouble(textCelsius.getText());
					temperatura.setCelsius(kelvin);
					double temp = temperatura.converterFahrenheit();
					labelResultado.setText(temp + "kelvin");
					labelMensagemErro.setText("");
					
					//exibe a mensagem de erro para o usuário
				} catch(Exception erro) {
					labelResultado.setText("");
					labelMensagemErro.setText("Erro, insira apenas números");
				}
				
			}
		});
		
		
		tela.getContentPane().add(labelResultado);
		tela.getContentPane().add(labelMensagemErro);
		
		//torna a tela visível 
		tela.setVisible(true);
	}
}
