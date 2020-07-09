package com.example.hospitalmanagementsystem;

import com.example.hospitalmanagementsystem.model.Doctor;
import com.example.hospitalmanagementsystem.model.Patient;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Transient;
import java.util.logging.Logger;

@SpringBootTest
class HospitalManagementSystemApplicationTests {

	Logger log = Logger.getLogger(this.getClass().getName());

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital_details");

	@Test
	@Transient
	public void testCascade() {
		log.info("testCascade");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Doctor d = new Doctor();
		d.setName("Ramaiah");
		d.setPhone_no("9876543210");

		//List<Patient> patients = new ArrayList<Patient>();
		Patient p1 = new Patient();
		p1.setName("Kiran");
		p1.setPhone_no("8976543201");
		p1.setPrescription("crocin");


        /*Patient p2 = new Patient();
        p2.setName("Kiran");
		p2.setPhone_no("8976543201");
		p2.setPrescription("crocin");*/

		p1.setDoctor(d);
		d.addPatients(p1);
		//d.addPatients(p2);

        /*patients.add(p);
        d.setPatient(patients);
        d.getPatient().add(a);*/

		Session session = em.unwrap(Session.class);
		session.saveOrUpdate(d);
		session.saveOrUpdate(p1);


		//em.merge(e);

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}

