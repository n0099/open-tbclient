package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class MaskInfo extends Message {
    public static final String DEFAULT_MASKFIDS = "";
    public static final String DEFAULT_MASKGIDS = "";
    public static final String DEFAULT_MASKUIDS = "";
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String maskFids;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String maskGids;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String maskUids;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer remindMask;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer shieldStatus;
    @ProtoField(tag = 7)
    public final PushSignMask signMask;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userId;
    public static final Long DEFAULT_USERID = 0L;
    public static final Integer DEFAULT_REMINDMASK = 0;
    public static final Integer DEFAULT_SHIELDSTATUS = 0;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<MaskInfo> {
        public String maskFids;
        public String maskGids;
        public String maskUids;
        public Integer remindMask;
        public Integer shieldStatus;
        public PushSignMask signMask;
        public Long userId;

        public Builder() {
        }

        public Builder(MaskInfo maskInfo) {
            super(maskInfo);
            if (maskInfo == null) {
                return;
            }
            this.userId = maskInfo.userId;
            this.maskGids = maskInfo.maskGids;
            this.remindMask = maskInfo.remindMask;
            this.maskUids = maskInfo.maskUids;
            this.shieldStatus = maskInfo.shieldStatus;
            this.maskFids = maskInfo.maskFids;
            this.signMask = maskInfo.signMask;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MaskInfo build(boolean z) {
            return new MaskInfo(this, z);
        }
    }

    public MaskInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.userId;
            if (l == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = l;
            }
            String str = builder.maskGids;
            if (str == null) {
                this.maskGids = "";
            } else {
                this.maskGids = str;
            }
            Integer num = builder.remindMask;
            if (num == null) {
                this.remindMask = DEFAULT_REMINDMASK;
            } else {
                this.remindMask = num;
            }
            String str2 = builder.maskUids;
            if (str2 == null) {
                this.maskUids = "";
            } else {
                this.maskUids = str2;
            }
            Integer num2 = builder.shieldStatus;
            if (num2 == null) {
                this.shieldStatus = DEFAULT_SHIELDSTATUS;
            } else {
                this.shieldStatus = num2;
            }
            String str3 = builder.maskFids;
            if (str3 == null) {
                this.maskFids = "";
            } else {
                this.maskFids = str3;
            }
            this.signMask = builder.signMask;
            return;
        }
        this.userId = builder.userId;
        this.maskGids = builder.maskGids;
        this.remindMask = builder.remindMask;
        this.maskUids = builder.maskUids;
        this.shieldStatus = builder.shieldStatus;
        this.maskFids = builder.maskFids;
        this.signMask = builder.signMask;
    }
}
