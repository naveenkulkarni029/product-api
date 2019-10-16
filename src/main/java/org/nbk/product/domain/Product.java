package org.nbk.product.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document("products")
@ApiModel(value = "Product", description = "All detail of the Product")
public class Product {

	@ApiModelProperty(notes = "UUID Generated during saving", name = "productId", dataType = "String")
	private String productId;

	private Category category;

	@ApiModelProperty(notes = "Code of the product", name = "productCode", dataType = "String")
	private String productCode;

	@ApiModelProperty(notes = "Name of the product", name = "productName", dataType = "String")
	private String productName;

	@ApiModelProperty(notes = "product short Description", name = "shortDescription", dataType = "String")
	private String shortDescription;

	@ApiModelProperty(notes = "product long Description", name = "longDescription", dataType = "String")
	private String longDescription;

	@ApiModelProperty(notes = "can be displayed", name = "canDisplay", dataType = "boolean")
	private boolean canDisplay;

	@ApiModelProperty(notes = "is product deleted", name = "isDeleted", dataType = "boolean")
	private boolean isDeleted;

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode
	 *            the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the shortDescription
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * @param shortDescription
	 *            the shortDescription to set
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	/**
	 * @return the longDescription
	 */
	public String getLongDescription() {
		return longDescription;
	}

	/**
	 * @param longDescription
	 *            the longDescription to set
	 */
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	/**
	 * @return the canDisplay
	 */
	public boolean isCanDisplay() {
		return canDisplay;
	}

	/**
	 * @param canDisplay
	 *            the canDisplay to set
	 */
	public void setCanDisplay(boolean canDisplay) {
		this.canDisplay = canDisplay;
	}

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted
	 *            the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (canDisplay ? 1231 : 1237);
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + ((longDescription == null) ? 0 : longDescription.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (canDisplay != other.canDisplay)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (longDescription == null) {
			if (other.longDescription != null)
				return false;
		} else if (!longDescription.equals(other.longDescription))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		return true;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=");
		builder.append(productId);
		builder.append(", category=");
		builder.append(category);
		builder.append(", productCode=");
		builder.append(productCode);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", shortDescription=");
		builder.append(shortDescription);
		builder.append(", longDescription=");
		builder.append(longDescription);
		builder.append(", canDisplay=");
		builder.append(canDisplay);
		builder.append(", isDeleted=");
		builder.append(isDeleted);
		builder.append("]");
		return builder.toString();
	}

}