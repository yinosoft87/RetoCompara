package com.reto.compare.Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"receta1",
"receta2"
})
@Generated("jsonschema2pojo")
public class DosRecetas {

	@JsonProperty("receta1")
	private List<String> receta1 = null;
	@JsonProperty("receta2")
	private List<String> receta2 = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("receta1")
	public List<String> getReceta1() {
		return receta1;
	}

	@JsonProperty("receta1")
	public void setReceta1(List<String> receta1) {
	this.receta1 = receta1;
	}
	
	@JsonProperty("receta2")
	public List<String> getReceta2() {
	return receta2;
	}
	
	@JsonProperty("receta2")
	public void setReceta2(List<String> receta2) {
	this.receta2 = receta2;
	}
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

}