package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class McnAdInfo extends Message {
    public static final String DEFAULT_BUTTONTITLE = "";
    public static final String DEFAULT_CARDTITLE = "";
    public static final String DEFAULT_JUMPURL = "";
    public static final String DEFAULT_PICURL = "";
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long adEndTime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long adStartTime;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String buttonTitle;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String cardTitle;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long effectTime;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long expireTime;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String jumpUrl;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String picUrl;
    public static final Long DEFAULT_ADSTARTTIME = 0L;
    public static final Long DEFAULT_ADENDTIME = 0L;
    public static final Long DEFAULT_EFFECTTIME = 0L;
    public static final Long DEFAULT_EXPIRETIME = 0L;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<McnAdInfo> {
        public Long adEndTime;
        public Long adStartTime;
        public String buttonTitle;
        public String cardTitle;
        public Long effectTime;
        public Long expireTime;
        public String jumpUrl;
        public String picUrl;

        public Builder() {
        }

        public Builder(McnAdInfo mcnAdInfo) {
            super(mcnAdInfo);
            if (mcnAdInfo == null) {
                return;
            }
            this.adStartTime = mcnAdInfo.adStartTime;
            this.adEndTime = mcnAdInfo.adEndTime;
            this.picUrl = mcnAdInfo.picUrl;
            this.jumpUrl = mcnAdInfo.jumpUrl;
            this.cardTitle = mcnAdInfo.cardTitle;
            this.buttonTitle = mcnAdInfo.buttonTitle;
            this.effectTime = mcnAdInfo.effectTime;
            this.expireTime = mcnAdInfo.expireTime;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public McnAdInfo build(boolean z) {
            return new McnAdInfo(this, z);
        }
    }

    public McnAdInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.adStartTime;
            if (l == null) {
                this.adStartTime = DEFAULT_ADSTARTTIME;
            } else {
                this.adStartTime = l;
            }
            Long l2 = builder.adEndTime;
            if (l2 == null) {
                this.adEndTime = DEFAULT_ADENDTIME;
            } else {
                this.adEndTime = l2;
            }
            String str = builder.picUrl;
            if (str == null) {
                this.picUrl = "";
            } else {
                this.picUrl = str;
            }
            String str2 = builder.jumpUrl;
            if (str2 == null) {
                this.jumpUrl = "";
            } else {
                this.jumpUrl = str2;
            }
            String str3 = builder.cardTitle;
            if (str3 == null) {
                this.cardTitle = "";
            } else {
                this.cardTitle = str3;
            }
            String str4 = builder.buttonTitle;
            if (str4 == null) {
                this.buttonTitle = "";
            } else {
                this.buttonTitle = str4;
            }
            Long l3 = builder.effectTime;
            if (l3 == null) {
                this.effectTime = DEFAULT_EFFECTTIME;
            } else {
                this.effectTime = l3;
            }
            Long l4 = builder.expireTime;
            if (l4 == null) {
                this.expireTime = DEFAULT_EXPIRETIME;
                return;
            } else {
                this.expireTime = l4;
                return;
            }
        }
        this.adStartTime = builder.adStartTime;
        this.adEndTime = builder.adEndTime;
        this.picUrl = builder.picUrl;
        this.jumpUrl = builder.jumpUrl;
        this.cardTitle = builder.cardTitle;
        this.buttonTitle = builder.buttonTitle;
        this.effectTime = builder.effectTime;
        this.expireTime = builder.expireTime;
    }
}
