package lucasxavier.trademetask.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lucasxavier.trademetask.network.CurrencyJsonAdapter;
import lucasxavier.trademetask.network.DateJsonAdapter;

public class Listing implements Serializable {

    @SerializedName("ListingId")
    private Integer id;

    @SerializedName("Title")
    private String title;

    @SerializedName("Category")
    private String categoryNumber;

    @JsonAdapter(CurrencyJsonAdapter.class)
    @SerializedName("StartPrice")
    private BigDecimal startPrice;

    @JsonAdapter(CurrencyJsonAdapter.class)
    @SerializedName("BuyNowPrice")
    private BigDecimal buyNowPrice;

    @JsonAdapter(DateJsonAdapter.class)
    @SerializedName("StartDate")
    private Date startDate;

    @JsonAdapter(DateJsonAdapter.class)
    @SerializedName("EndDate")
    private Date endDate;

//    @SerializedName("ListingLength")
//    private TODO not in API docs

    @SerializedName("IsFeatured")
    private Boolean isFeatured;

    @SerializedName("HasGallery")
    private Boolean hasGallery;

    @SerializedName("IsBold")
    private Boolean isBold;

    @SerializedName("IsHighLighted")
    private Boolean isHighLighted;

    @JsonAdapter(DateJsonAdapter.class)
    @SerializedName("AsAt")
    private Date asAt;

    @SerializedName("CategoryPath")
    private String categoryPath;

    @SerializedName("PictureHref")
    private String pictureHref;

    @SerializedName("Region")
    private String region;

    @SerializedName("Suburb")
    private String suburb;

    @SerializedName("HasBuyNow")
    private Boolean hasBuyNow;

    @JsonAdapter(DateJsonAdapter.class)
    @SerializedName("NoteDate")
    private Date noteDate;

    @JsonAdapter(CurrencyJsonAdapter.class)
    @SerializedName("PriceDisplay")
    private BigDecimal priceDisplay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryNumber() {
        return categoryNumber;
    }

    public void setCategoryNumber(String categoryNumber) {
        this.categoryNumber = categoryNumber;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public BigDecimal getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(BigDecimal buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    public Boolean getHasGallery() {
        return hasGallery;
    }

    public void setHasGallery(Boolean hasGallery) {
        this.hasGallery = hasGallery;
    }

    public Boolean getIsBold() {
        return isBold;
    }

    public void setIsBold(Boolean isBold) {
        this.isBold = isBold;
    }

    public Boolean getIsHighLighted() {
        return isHighLighted;
    }

    public void setIsHighLighted(Boolean isHighLighted) {
        this.isHighLighted = isHighLighted;
    }

    public Date getAsAt() {
        return asAt;
    }

    public void setAsAt(Date asAt) {
        this.asAt = asAt;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getPictureHref() {
        return pictureHref;
    }

    public void setPictureHref(String pictureHref) {
        this.pictureHref = pictureHref;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public Boolean getHasBuyNow() {
        return hasBuyNow;
    }

    public void setHasBuyNow(Boolean hasBuyNow) {
        this.hasBuyNow = hasBuyNow;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public BigDecimal getPriceDisplay() {
        return priceDisplay;
    }

    public void setPriceDisplay(BigDecimal priceDisplay) {
        this.priceDisplay = priceDisplay;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", categoryNumber='" + categoryNumber + '\'' +
                ", startPrice=" + startPrice +
                ", buyNowPrice=" + buyNowPrice +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isFeatured=" + isFeatured +
                ", hasGallery=" + hasGallery +
                ", isBold=" + isBold +
                ", isHighLighted=" + isHighLighted +
                ", asAt=" + asAt +
                ", categoryPath='" + categoryPath + '\'' +
                ", pictureHref='" + pictureHref + '\'' +
                ", region='" + region + '\'' +
                ", suburb='" + suburb + '\'' +
                ", hasBuyNow=" + hasBuyNow +
                ", noteDate=" + noteDate +
                ", priceDisplay=" + priceDisplay +
                '}';
    }
}
