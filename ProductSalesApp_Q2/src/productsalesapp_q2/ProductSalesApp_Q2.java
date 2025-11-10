package productsalesapp_q2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProductSalesApp_Q2 extends JFrame {

    JTextArea textArea;
    JLabel yearsProcessedLabel;
    JLabel totalSalesLabel;
    JLabel averageSalesLabel;
    JLabel salesOverLabel;
    JLabel salesUnderLabel;

    //Inputting of fields
    JTextField y1MicField, y1SpkField, y1MixField;
    JTextField y2MicField, y2SpkField, y2MixField;

    ProductSales productSales;

    public ProductSalesApp_Q2() {
        setTitle("Product Sales Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        createMenuBar();
        createGUI();
    }

    void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");

        loadItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadProductData();
            }
        });

        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveProductData();
            }
        });

        clearItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearData();
            }
        });

        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    void createGUI() {
        setLayout(new BorderLayout());

        //Input panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 7, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Sales Data"));

        inputPanel.add(new JLabel(""));
        inputPanel.add(new JLabel("Microphone"));
        inputPanel.add(new JLabel("Speakers"));
        inputPanel.add(new JLabel("Mixing Desk"));

        inputPanel.add(new JLabel("Year 1:"));
        y1MicField = new JTextField();
        y1SpkField = new JTextField();
        y1MixField = new JTextField();
        inputPanel.add(y1MicField);
        inputPanel.add(y1SpkField);
        inputPanel.add(y1MixField);

        inputPanel.add(new JLabel("Year 2:"));
        y2MicField = new JTextField();
        y2SpkField = new JTextField();
        y2MixField = new JTextField();
        inputPanel.add(y2MicField);
        inputPanel.add(y2SpkField);
        inputPanel.add(y2MixField);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton loadButton = new JButton("Load Product Data");
        JButton saveButton = new JButton("Save Product Data");

        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadProductData();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveProductData();
            }
        });

        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);

        // Text area
        textArea = new JTextArea(8, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

      
        JPanel resultsPanel = new JPanel(new GridLayout(6, 3, 11, 6));
        resultsPanel.setBorder(BorderFactory.createTitledBorder("Results"));

        resultsPanel.add(new JLabel("Total Sales:"));
        totalSalesLabel = new JLabel("0");
        resultsPanel.add(totalSalesLabel);

        resultsPanel.add(new JLabel("Average Sales:"));
        averageSalesLabel = new JLabel("0");
        resultsPanel.add(averageSalesLabel);

        resultsPanel.add(new JLabel("Sales over limit:"));
        salesOverLabel = new JLabel("0");
        resultsPanel.add(salesOverLabel);

        resultsPanel.add(new JLabel("Sales under limit:"));
        salesUnderLabel = new JLabel("0");
        resultsPanel.add(salesUnderLabel);

        resultsPanel.add(new JLabel("Years Processed:"));
        yearsProcessedLabel = new JLabel("0");
        resultsPanel.add(yearsProcessedLabel);

        
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.WEST);
        add(resultsPanel, BorderLayout.EAST);
    }

    void loadProductData() {
        try {
            productSales = new ProductSales();

            // Get values from text fields
            productSales.year1Microphone = Integer.parseInt(y1MicField.getText());
            productSales.year1Speakers = Integer.parseInt(y1SpkField.getText());
            productSales.year1MixingDesk = Integer.parseInt(y1MixField.getText());
            productSales.year2Microphone = Integer.parseInt(y2MicField.getText());
            productSales.year2Speakers = Integer.parseInt(y2SpkField.getText());
            productSales.year2MixingDesk = Integer.parseInt(y2MixField.getText());

            // Display the sales data in text area
            String displayText = "Product Sales Data: ";
            displayText += "Year 1 - Microphone: " + productSales.year1Microphone
                    + ", Speakers: " + productSales.year1Speakers
                    + ", Mixing Desk: " + productSales.year1MixingDesk + " ";
            displayText += "Year 2 - Microphone: " + productSales.year2Microphone
                    + ", Speakers: " + productSales.year2Speakers
                    + ", Mixing Desk: " + productSales.year2MixingDesk + " ";

            // Calculate the results
            int totalSales = productSales.GetTotalSales();
            double averageSales = productSales.GetAverageSales();
            int salesOver = productSales.GetSalesOverLimit();
            int salesUnder = productSales.GetSalesUnderLimit();
            int yearsProcessed = productSales.GetProductsProcessed();

            displayText += "RESULTS: ";
            displayText += "Total Sales: " + totalSales + " ";
            displayText += "Average Sales: " + String.format("%.2f", averageSales) + " ";
            displayText += "Sales over limit: " + salesOver + " ";
            displayText += "Sales under limit: " + salesUnder + " ";

            textArea.setText(displayText);

           
            totalSalesLabel.setText(String.valueOf(totalSales));
            averageSalesLabel.setText(String.format("%.2f", averageSales));
            salesOverLabel.setText(String.valueOf(salesOver));
            salesUnderLabel.setText(String.valueOf(salesUnder));
            yearsProcessedLabel.setText(String.valueOf(yearsProcessed));

        } catch (Exception e) {
            textArea.setText("Error: Please enter valid numbers in all fields");
        }
    }

    void saveProductData() {
        if (productSales == null) {
            textArea.setText("Please load product data first");
            return;
        }

        try {
            FileWriter writer = new FileWriter("data.txt");
            writer.write("DATA LOG");
            writer.write("*******************************");
            writer.write("Total Sales: " + productSales.GetTotalSales() + " ");
            writer.write("Average Sales: " + (int) productSales.GetAverageSales() + " ");
            writer.write("Sales over limit: " + productSales.GetSalesOverLimit() + " ");
            writer.write("Sales under limit: " + productSales.GetSalesUnderLimit() + " ");
            writer.write("*******************************\n");
            writer.close();

            textArea.setText("Data saved to data.txt" + textArea.getText());
        } catch (IOException e) {
            textArea.setText("Error saving file");
        }
    }

    void clearData() {
        textArea.setText("");
        totalSalesLabel.setText("0");
        averageSalesLabel.setText("0");
        salesOverLabel.setText("0");
        salesUnderLabel.setText("0");
        yearsProcessedLabel.setText("0");
        productSales = null;

        // Clearing the input fields
        y1MicField.setText("");
        y1SpkField.setText("");
        y1MixField.setText("");
        y2MicField.setText("");
        y2SpkField.setText("");
        y2MixField.setText("");
    }

    public static void main(String[] args) {
        ProductSalesApp_Q2 app = new ProductSalesApp_Q2();
        app.setVisible(true);
    }
}
