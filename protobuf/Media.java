package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class Media extends Message {
    public static final String DEFAULT_BIGPIC = "";
    public static final String DEFAULT_BSIZE = "";
    public static final String DEFAULT_DYNAMICPIC = "";
    public static final Double DEFAULT_HTHMIDLOC;
    public static final String DEFAULT_ORIGINPIC = "";
    public static final String DEFAULT_SMALLPIC = "";
    public static final String DEFAULT_SRCPIC = "";
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_VHSRC = "";
    public static final String DEFAULT_VPIC = "";
    public static final String DEFAULT_VSRC = "";
    public static final String DEFAULT_WATERPIC = "";
    public static final Double DEFAULT_WTHMIDLOC;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String bigPic;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String bsize;
    @ProtoField(tag = 13, type = Message.Datatype.UINT32)
    public final Integer duringTime;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String dynamicPic;
    @ProtoField(tag = 14, type = Message.Datatype.UINT32)
    public final Integer eType;
    @ProtoField(tag = 11, type = Message.Datatype.UINT32)
    public final Integer height;
    @ProtoField(tag = 23, type = Message.Datatype.DOUBLE)
    public final Double hthMidLoc;
    @ProtoField(tag = 21, type = Message.Datatype.UINT32)
    public final Integer isBlockedPic;
    @ProtoField(tag = 19, type = Message.Datatype.UINT32)
    public final Integer isLongPic;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String originPic;
    @ProtoField(tag = 16, type = Message.Datatype.UINT32)
    public final Integer originSize;
    @ProtoField(tag = 17, type = Message.Datatype.INT64)
    public final Long postId;
    @ProtoField(tag = 20, type = Message.Datatype.UINT32)
    public final Integer showOriginalBtn;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String smallPic;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String srcPic;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String vhsrc;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String vpic;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String vsrc;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String waterPic;
    @ProtoField(tag = 10, type = Message.Datatype.UINT32)
    public final Integer width;
    @ProtoField(tag = 22, type = Message.Datatype.DOUBLE)
    public final Double wthMidLoc;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_WIDTH = 0;
    public static final Integer DEFAULT_HEIGHT = 0;
    public static final Integer DEFAULT_DURINGTIME = 0;
    public static final Integer DEFAULT_ETYPE = 0;
    public static final Integer DEFAULT_ORIGINSIZE = 0;
    public static final Long DEFAULT_POSTID = 0L;
    public static final Integer DEFAULT_ISLONGPIC = 0;
    public static final Integer DEFAULT_SHOWORIGINALBTN = 0;
    public static final Integer DEFAULT_ISBLOCKEDPIC = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<Media> {
        public String bigPic;
        public String bsize;
        public Integer duringTime;
        public String dynamicPic;
        public Integer eType;
        public Integer height;
        public Double hthMidLoc;
        public Integer isBlockedPic;
        public Integer isLongPic;
        public String originPic;
        public Integer originSize;
        public Long postId;
        public Integer showOriginalBtn;
        public String smallPic;
        public String srcPic;
        public String text;
        public Integer type;
        public String vhsrc;
        public String vpic;
        public String vsrc;
        public String waterPic;
        public Integer width;
        public Double wthMidLoc;

        public Builder() {
        }

        public Builder(Media media) {
            super(media);
            if (media == null) {
                return;
            }
            this.type = media.type;
            this.smallPic = media.smallPic;
            this.bigPic = media.bigPic;
            this.waterPic = media.waterPic;
            this.vpic = media.vpic;
            this.vsrc = media.vsrc;
            this.vhsrc = media.vhsrc;
            this.srcPic = media.srcPic;
            this.text = media.text;
            this.width = media.width;
            this.height = media.height;
            this.bsize = media.bsize;
            this.duringTime = media.duringTime;
            this.eType = media.eType;
            this.originPic = media.originPic;
            this.originSize = media.originSize;
            this.postId = media.postId;
            this.dynamicPic = media.dynamicPic;
            this.isLongPic = media.isLongPic;
            this.showOriginalBtn = media.showOriginalBtn;
            this.isBlockedPic = media.isBlockedPic;
            this.wthMidLoc = media.wthMidLoc;
            this.hthMidLoc = media.hthMidLoc;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Media build(boolean z) {
            return new Media(this, z);
        }
    }

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_WTHMIDLOC = valueOf;
        DEFAULT_HTHMIDLOC = valueOf;
    }

    public Media(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.type;
            if (num == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = num;
            }
            String str = builder.smallPic;
            if (str == null) {
                this.smallPic = "";
            } else {
                this.smallPic = str;
            }
            String str2 = builder.bigPic;
            if (str2 == null) {
                this.bigPic = "";
            } else {
                this.bigPic = str2;
            }
            String str3 = builder.waterPic;
            if (str3 == null) {
                this.waterPic = "";
            } else {
                this.waterPic = str3;
            }
            String str4 = builder.vpic;
            if (str4 == null) {
                this.vpic = "";
            } else {
                this.vpic = str4;
            }
            String str5 = builder.vsrc;
            if (str5 == null) {
                this.vsrc = "";
            } else {
                this.vsrc = str5;
            }
            String str6 = builder.vhsrc;
            if (str6 == null) {
                this.vhsrc = "";
            } else {
                this.vhsrc = str6;
            }
            String str7 = builder.srcPic;
            if (str7 == null) {
                this.srcPic = "";
            } else {
                this.srcPic = str7;
            }
            String str8 = builder.text;
            if (str8 == null) {
                this.text = "";
            } else {
                this.text = str8;
            }
            Integer num2 = builder.width;
            if (num2 == null) {
                this.width = DEFAULT_WIDTH;
            } else {
                this.width = num2;
            }
            Integer num3 = builder.height;
            if (num3 == null) {
                this.height = DEFAULT_HEIGHT;
            } else {
                this.height = num3;
            }
            String str9 = builder.bsize;
            if (str9 == null) {
                this.bsize = "";
            } else {
                this.bsize = str9;
            }
            Integer num4 = builder.duringTime;
            if (num4 == null) {
                this.duringTime = DEFAULT_DURINGTIME;
            } else {
                this.duringTime = num4;
            }
            Integer num5 = builder.eType;
            if (num5 == null) {
                this.eType = DEFAULT_ETYPE;
            } else {
                this.eType = num5;
            }
            String str10 = builder.originPic;
            if (str10 == null) {
                this.originPic = "";
            } else {
                this.originPic = str10;
            }
            Integer num6 = builder.originSize;
            if (num6 == null) {
                this.originSize = DEFAULT_ORIGINSIZE;
            } else {
                this.originSize = num6;
            }
            Long l = builder.postId;
            if (l == null) {
                this.postId = DEFAULT_POSTID;
            } else {
                this.postId = l;
            }
            String str11 = builder.dynamicPic;
            if (str11 == null) {
                this.dynamicPic = "";
            } else {
                this.dynamicPic = str11;
            }
            Integer num7 = builder.isLongPic;
            if (num7 == null) {
                this.isLongPic = DEFAULT_ISLONGPIC;
            } else {
                this.isLongPic = num7;
            }
            Integer num8 = builder.showOriginalBtn;
            if (num8 == null) {
                this.showOriginalBtn = DEFAULT_SHOWORIGINALBTN;
            } else {
                this.showOriginalBtn = num8;
            }
            Integer num9 = builder.isBlockedPic;
            if (num9 == null) {
                this.isBlockedPic = DEFAULT_ISBLOCKEDPIC;
            } else {
                this.isBlockedPic = num9;
            }
            Double d = builder.wthMidLoc;
            if (d == null) {
                this.wthMidLoc = DEFAULT_WTHMIDLOC;
            } else {
                this.wthMidLoc = d;
            }
            Double d2 = builder.hthMidLoc;
            if (d2 == null) {
                this.hthMidLoc = DEFAULT_HTHMIDLOC;
                return;
            } else {
                this.hthMidLoc = d2;
                return;
            }
        }
        this.type = builder.type;
        this.smallPic = builder.smallPic;
        this.bigPic = builder.bigPic;
        this.waterPic = builder.waterPic;
        this.vpic = builder.vpic;
        this.vsrc = builder.vsrc;
        this.vhsrc = builder.vhsrc;
        this.srcPic = builder.srcPic;
        this.text = builder.text;
        this.width = builder.width;
        this.height = builder.height;
        this.bsize = builder.bsize;
        this.duringTime = builder.duringTime;
        this.eType = builder.eType;
        this.originPic = builder.originPic;
        this.originSize = builder.originSize;
        this.postId = builder.postId;
        this.dynamicPic = builder.dynamicPic;
        this.isLongPic = builder.isLongPic;
        this.showOriginalBtn = builder.showOriginalBtn;
        this.isBlockedPic = builder.isBlockedPic;
        this.wthMidLoc = builder.wthMidLoc;
        this.hthMidLoc = builder.hthMidLoc;
    }
}
