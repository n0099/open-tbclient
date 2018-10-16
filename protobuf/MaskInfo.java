package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes4.dex */
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
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userId;
    public static final Long DEFAULT_USERID = 0L;
    public static final Integer DEFAULT_REMINDMASK = 0;
    public static final Integer DEFAULT_SHIELDSTATUS = 0;

    private MaskInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.userId == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = builder.userId;
            }
            if (builder.maskGids == null) {
                this.maskGids = "";
            } else {
                this.maskGids = builder.maskGids;
            }
            if (builder.remindMask == null) {
                this.remindMask = DEFAULT_REMINDMASK;
            } else {
                this.remindMask = builder.remindMask;
            }
            if (builder.maskUids == null) {
                this.maskUids = "";
            } else {
                this.maskUids = builder.maskUids;
            }
            if (builder.shieldStatus == null) {
                this.shieldStatus = DEFAULT_SHIELDSTATUS;
            } else {
                this.shieldStatus = builder.shieldStatus;
            }
            if (builder.maskFids == null) {
                this.maskFids = "";
                return;
            } else {
                this.maskFids = builder.maskFids;
                return;
            }
        }
        this.userId = builder.userId;
        this.maskGids = builder.maskGids;
        this.remindMask = builder.remindMask;
        this.maskUids = builder.maskUids;
        this.shieldStatus = builder.shieldStatus;
        this.maskFids = builder.maskFids;
    }

    /* loaded from: classes4.dex */
    public static final class Builder extends Message.Builder<MaskInfo> {
        public String maskFids;
        public String maskGids;
        public String maskUids;
        public Integer remindMask;
        public Integer shieldStatus;
        public Long userId;

        public Builder() {
        }

        public Builder(MaskInfo maskInfo) {
            super(maskInfo);
            if (maskInfo != null) {
                this.userId = maskInfo.userId;
                this.maskGids = maskInfo.maskGids;
                this.remindMask = maskInfo.remindMask;
                this.maskUids = maskInfo.maskUids;
                this.shieldStatus = maskInfo.shieldStatus;
                this.maskFids = maskInfo.maskFids;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MaskInfo build(boolean z) {
            return new MaskInfo(this, z);
        }
    }
}
