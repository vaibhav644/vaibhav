package in.vaibhav.springbootmongodb.model;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="wolfs")
public class Wolf {
	@Id
	private String id;
	private String wolf;
	private String description;
	private Boolean completed;
	private Date createdAt;
	private Date updatedAt;
	
	

}
