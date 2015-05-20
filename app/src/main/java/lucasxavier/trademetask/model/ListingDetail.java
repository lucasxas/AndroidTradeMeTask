package lucasxavier.trademetask.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;

import lucasxavier.trademetask.network.DateJsonAdapter;

public class ListingDetail {

    @SerializedName("ListingId")
    private Integer listingId;

    @SerializedName("Title")
    private String title;

    @SerializedName("StartPrice")
    private BigDecimal startPrice;

    @SerializedName("BuyNowPrice")
    private BigDecimal buyNowPrice;

    @SerializedName("MinimumNextBidAmount")
    private BigDecimal minimumNextBidAmount;

    @JsonAdapter(DateJsonAdapter.class)
    @SerializedName("StartDate")
    private Date startDate;

    @JsonAdapter(DateJsonAdapter.class)
    @SerializedName("EndDate")
    private Date endDate;

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(Integer listingId) {
        this.listingId = listingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public BigDecimal getMinimumNextBidAmount() {
        return minimumNextBidAmount;
    }

    public void setMinimumNextBidAmount(BigDecimal minimumNextBidAmount) {
        this.minimumNextBidAmount = minimumNextBidAmount;
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

    @Override
    public String toString() {
        return "ListingDetail{" +
                "listingId=" + listingId +
                ", title='" + title + '\'' +
                ", startPrice=" + startPrice +
                ", buyNowPrice=" + buyNowPrice +
                ", minimumNextBidAmount=" + minimumNextBidAmount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    // TODO add this fields later?
//    {
//        "ListingId": 4124822,
//            "Title": "Abstract 11",
//            "Category": "0339-0491-5859-",
//            "StartPrice": 175,
//            "BuyNowPrice": 295,
//            "StartDate": "/Date(1431558362107)/",
//            "EndDate": "/Date(1432162800000)/",
//            "ListingLength": null,
//            "IsFeatured": true,
//            "HasGallery": true,
//            "IsBold": true,
//            "AsAt": "/Date(1432118779979)/",
//            "CategoryPath": "/Art/Photographs/Abstract",
//            "PhotoId": 1075904,
//            "IsNew": true,
//            "RegionId": 11,
//            "Region": "Wairarapa",
//            "Suburb": "Martinborough",
//            "ViewCount": 7,
//            "HasBuyNow": true,
//            "NoteDate": "/Date(0)/",
//            "CategoryName": "Abstract",
//            "Attributes": [],
//        "OpenHomes": [],
//        "MinimumNextBidAmount": 175,
//            "PriceDisplay": "$175.00",
//            "Member": {
//        "MemberId": 4000129,
//                "Nickname": "abstractus",
//                "DateAddressVerified": "/Date(1380798000000)/",
//                "DateJoined": "/Date(1317726000000)/",
//                "UniqueNegative": 2,
//                "UniquePositive": 52,
//                "FeedbackCount": 50,
//                "IsAddressVerified": true,
//                "Suburb": "Martinborough",
//                "Region": "Wairarapa",
//                "IsAuthenticated": true
//    },
//        "Body": "Abstract 11\r\nStart = 175.00, Reserve = N/A, Buy Now = 295.00",
//            "Photos": [
//        {
//            "Key": 1075904,
//                "Value": {
//            "Thumbnail": "https://images.tmsandbox.co.nz/photoserver/thumb/1075904.jpg",
//                    "List": "https://images.tmsandbox.co.nz/photoserver/lv2/1075904.jpg",
//                    "Medium": "https://images.tmsandbox.co.nz/photoserver/med/1075904.jpg",
//                    "Gallery": "https://images.tmsandbox.co.nz/photoserver/gv/1075904.jpg",
//                    "Large": "https://images.tmsandbox.co.nz/photoserver/tq/1075904.jpg",
//                    "FullSize": "https://images.tmsandbox.co.nz/photoserver/full/1075904.jpg",
//                    "PhotoId": 1075904,
//                    "OriginalWidth": 606,
//                    "OriginalHeight": 650
//        }
//        }
//        ],
//        "AllowsPickups": 1,
//            "ShippingOptions": [
//        {
//            "Type": 4,
//                "Price": 5.67,
//                "Method": "go-cART courier",
//                "ShippingId": 4
//        },
//        {
//            "Type": 4,
//                "Price": 23.45,
//                "Method": "smART Express",
//                "ShippingId": 5
//        },
//        {
//            "Type": 2,
//                "Method": "I intend to pick-up",
//                "ShippingId": 2
//        }
//        ],
//        "PaymentOptions": "NZ Bank Deposit",
//            "AuthenticatedMembersOnly": true,
//            "IsInCart": false,
//            "CanAddToCart": false
//    }
}
