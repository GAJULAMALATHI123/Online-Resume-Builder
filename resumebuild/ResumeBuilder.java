import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

class UserDetails {
    private String name;
    private String contactInformation;
    private String education;
    private String experience;

    public UserDetails() {
        // Default constructor
    }

    // Constructor with parameters
    public UserDetails(String name, String contactInformation, String education, String experience) {
        this.name = name;
        this.contactInformation = contactInformation;
        this.education = education;
        this.experience = experience;
    }

    // Getter and setter methods
    // You can also add additional methods for updating individual fields as per user's needs
}

public class ResumeBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user details
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();

        System.out.println("Please enter your contact information:");
        String contactInformation = scanner.nextLine();

        System.out.println("Please enter your education:");
        String education = scanner.nextLine();

        System.out.println("Please enter your experience:");
        String experience = scanner.nextLine();

        // Create UserDetails object with user input
        UserDetails userDetails = new UserDetails(name, contactInformation, education, experience);

        // Render and publish resume
        publishResume(userDetails);

        scanner.close();
    }

    private static void publishResume(UserDetails userDetails) {
        // Create PDF document
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("resume.pdf"));
            document.open();

            // Add resume content
            document.add(new Paragraph("Name: " + userDetails.getName()));
            document.add(new Paragraph("Contact Information: " + userDetails.getContactInformation()));
            document.add(new Paragraph("Education: " + userDetails.getEducation()));
            document.add(new Paragraph("Experience: " + userDetails.getExperience()));

            document.close();

            System.out.println("Your resume has been published successfully as resume.pdf!");
        } catch (FileNotFoundException | DocumentException e) {
            System.out.println("An error occurred while publishing the resume: " + e.getMessage());
        }
    }
}
