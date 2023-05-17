package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public final class Item extends Message {
    public static final String DEFAULT_APKNAME = "";
    public static final String DEFAULT_BUTTONLINK = "";
    public static final Integer DEFAULT_BUTTONLINKTYPE;
    public static final String DEFAULT_BUTTONNAME = "";
    public static final Integer DEFAULT_CATEGORYID;
    public static final String DEFAULT_FORUMNAME = "";
    public static final Double DEFAULT_ICONSIZE;
    public static final String DEFAULT_ICONURL = "";
    public static final String DEFAULT_ITEMAPPID = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_ITEMNAME = "";
    public static final Double DEFAULT_SCORE;
    public static final Integer DEFAULT_STAR;
    public static final List<String> DEFAULT_TAGS;
    @ProtoField(tag = 15)
    public final ApkDetail apkDetail;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String apkName;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String buttonLink;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer buttonLinkType;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String buttonName;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer categoryId;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String forumName;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double iconSize;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String iconUrl;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String itemAppid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String itemName;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)
    public final Double score;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer star;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.STRING)
    public final List<String> tags;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<Item> {
        public ApkDetail apkDetail;
        public String apkName;
        public String buttonLink;
        public Integer buttonLinkType;
        public String buttonName;
        public Integer categoryId;
        public String forumName;
        public Double iconSize;
        public String iconUrl;
        public String itemAppid;
        public Long itemId;
        public String itemName;
        public Double score;
        public Integer star;
        public List<String> tags;

        public Builder() {
        }

        public Builder(Item item) {
            super(item);
            if (item == null) {
                return;
            }
            this.itemId = item.itemId;
            this.itemName = item.itemName;
            this.iconSize = item.iconSize;
            this.iconUrl = item.iconUrl;
            this.tags = Message.copyOf(item.tags);
            this.score = item.score;
            this.star = item.star;
            this.buttonName = item.buttonName;
            this.buttonLink = item.buttonLink;
            this.itemAppid = item.itemAppid;
            this.categoryId = item.categoryId;
            this.buttonLinkType = item.buttonLinkType;
            this.apkName = item.apkName;
            this.forumName = item.forumName;
            this.apkDetail = item.apkDetail;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Item build(boolean z) {
            return new Item(this, z);
        }
    }

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_ICONSIZE = valueOf;
        DEFAULT_TAGS = Collections.emptyList();
        DEFAULT_SCORE = valueOf;
        DEFAULT_STAR = 0;
        DEFAULT_CATEGORYID = 0;
        DEFAULT_BUTTONLINKTYPE = 0;
    }

    public Item(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.itemId;
            if (l == null) {
                this.itemId = DEFAULT_ITEMID;
            } else {
                this.itemId = l;
            }
            String str = builder.itemName;
            if (str == null) {
                this.itemName = "";
            } else {
                this.itemName = str;
            }
            Double d = builder.iconSize;
            if (d == null) {
                this.iconSize = DEFAULT_ICONSIZE;
            } else {
                this.iconSize = d;
            }
            String str2 = builder.iconUrl;
            if (str2 == null) {
                this.iconUrl = "";
            } else {
                this.iconUrl = str2;
            }
            List<String> list = builder.tags;
            if (list == null) {
                this.tags = DEFAULT_TAGS;
            } else {
                this.tags = Message.immutableCopyOf(list);
            }
            Double d2 = builder.score;
            if (d2 == null) {
                this.score = DEFAULT_SCORE;
            } else {
                this.score = d2;
            }
            Integer num = builder.star;
            if (num == null) {
                this.star = DEFAULT_STAR;
            } else {
                this.star = num;
            }
            String str3 = builder.buttonName;
            if (str3 == null) {
                this.buttonName = "";
            } else {
                this.buttonName = str3;
            }
            String str4 = builder.buttonLink;
            if (str4 == null) {
                this.buttonLink = "";
            } else {
                this.buttonLink = str4;
            }
            String str5 = builder.itemAppid;
            if (str5 == null) {
                this.itemAppid = "";
            } else {
                this.itemAppid = str5;
            }
            Integer num2 = builder.categoryId;
            if (num2 == null) {
                this.categoryId = DEFAULT_CATEGORYID;
            } else {
                this.categoryId = num2;
            }
            Integer num3 = builder.buttonLinkType;
            if (num3 == null) {
                this.buttonLinkType = DEFAULT_BUTTONLINKTYPE;
            } else {
                this.buttonLinkType = num3;
            }
            String str6 = builder.apkName;
            if (str6 == null) {
                this.apkName = "";
            } else {
                this.apkName = str6;
            }
            String str7 = builder.forumName;
            if (str7 == null) {
                this.forumName = "";
            } else {
                this.forumName = str7;
            }
            this.apkDetail = builder.apkDetail;
            return;
        }
        this.itemId = builder.itemId;
        this.itemName = builder.itemName;
        this.iconSize = builder.iconSize;
        this.iconUrl = builder.iconUrl;
        this.tags = Message.immutableCopyOf(builder.tags);
        this.score = builder.score;
        this.star = builder.star;
        this.buttonName = builder.buttonName;
        this.buttonLink = builder.buttonLink;
        this.itemAppid = builder.itemAppid;
        this.categoryId = builder.categoryId;
        this.buttonLinkType = builder.buttonLinkType;
        this.apkName = builder.apkName;
        this.forumName = builder.forumName;
        this.apkDetail = builder.apkDetail;
    }
}
