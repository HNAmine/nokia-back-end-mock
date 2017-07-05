package nokia.org.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nokia.org.dto.Repport;

/**
 * @author Hamza
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/repports")
public class RepportController {

	List<Repport> repports;

	{
		repports = new ArrayList<Repport>();

		Repport r1 = new Repport("#44554FFZ9", "CASABLANCA", "localhost:8080/rapports/RAPPORT.xls");
		Repport r2 = new Repport("#44554FFZ9", "RABAT", "localhost:8080/rapports/RAPPORT.xls");
		Repport r3 = new Repport("#44554FFZ9", "EL JADIDA", "localhost:8080/rapports/RAPPORT.xls");
		Repport r4 = new Repport("#44554FFZ9", "TANGER", "localhost:8080/rapports/RAPPORT.xls");

		repports.add(r1);
		repports.add(r2);
		repports.add(r3);
		repports.add(r4);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Repport>> getAllArticles() {
		return new ResponseEntity<>(this.repports, HttpStatus.OK);
	}

}
