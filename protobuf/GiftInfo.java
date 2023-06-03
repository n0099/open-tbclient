package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class GiftInfo extends Message {
    public static final String DEFAULT_GIFTNAME = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_LARGETHUMBNAILURL = "";
    public static final String DEFAULT_SENDERNAME = "";
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer giftId;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String giftName;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String icon;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String largeThumbnailUrl;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer num;
    @ProtoField(tag = 6, type = Message.Datatype.UINT64)
    public final Long senderId;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String senderName;
    public static final Integer DEFAULT_NUM = 0;
    public static final Integer DEFAULT_GIFTID = 0;
    public static final Long DEFAULT_SENDERID = 0L;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<GiftInfo> {
        public Integer giftId;
        public String giftName;
        public String icon;
        public String largeThumbnailUrl;
        public Integer num;
        public Long senderId;
        public String senderName;

        public Builder() {
        }

        public Builder(GiftInfo giftInfo) {
            super(giftInfo);
            if (giftInfo == null) {
                return;
            }
            this.icon = giftInfo.icon;
            this.num = giftInfo.num;
            this.giftId = giftInfo.giftId;
            this.giftName = giftInfo.giftName;
            this.largeThumbnailUrl = giftInfo.largeThumbnailUrl;
            this.senderId = giftInfo.senderId;
            this.senderName = giftInfo.senderName;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GiftInfo build(boolean z) {
            return new GiftInfo(this, z);
        }
    }

    public GiftInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.icon;
            if (str == null) {
                this.icon = "";
            } else {
                this.icon = str;
            }
            Integer num = builder.num;
            if (num == null) {
                this.num = DEFAULT_NUM;
            } else {
                this.num = num;
            }
            Integer num2 = builder.giftId;
            if (num2 == null) {
                this.giftId = DEFAULT_GIFTID;
            } else {
                this.giftId = num2;
            }
            String str2 = builder.giftName;
            if (str2 == null) {
                this.giftName = "";
            } else {
                this.giftName = str2;
            }
            String str3 = builder.largeThumbnailUrl;
            if (str3 == null) {
                this.largeThumbnailUrl = "";
            } else {
                this.largeThumbnailUrl = str3;
            }
            Long l = builder.senderId;
            if (l == null) {
                this.senderId = DEFAULT_SENDERID;
            } else {
                this.senderId = l;
            }
            String str4 = builder.senderName;
            if (str4 == null) {
                this.senderName = "";
                return;
            } else {
                this.senderName = str4;
                return;
            }
        }
        this.icon = builder.icon;
        this.num = builder.num;
        this.giftId = builder.giftId;
        this.giftName = builder.giftName;
        this.largeThumbnailUrl = builder.largeThumbnailUrl;
        this.senderId = builder.senderId;
        this.senderName = builder.senderName;
    }
}
