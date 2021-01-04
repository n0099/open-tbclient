package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class BlockInfo extends Message {
    public static final String DEFAULT_BLOCKCANCEL = "";
    public static final String DEFAULT_BLOCKCONFIRM = "";
    public static final String DEFAULT_BLOCKDEALURL = "";
    public static final String DEFAULT_BLOCKERRMSG = "";
    public static final Integer DEFAULT_BLOCKERRNO = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String blockCancel;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String blockConfirm;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String blockDealurl;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String blockErrmsg;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer blockErrno;

    private BlockInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.blockErrno == null) {
                this.blockErrno = DEFAULT_BLOCKERRNO;
            } else {
                this.blockErrno = builder.blockErrno;
            }
            if (builder.blockErrmsg == null) {
                this.blockErrmsg = "";
            } else {
                this.blockErrmsg = builder.blockErrmsg;
            }
            if (builder.blockDealurl == null) {
                this.blockDealurl = "";
            } else {
                this.blockDealurl = builder.blockDealurl;
            }
            if (builder.blockConfirm == null) {
                this.blockConfirm = "";
            } else {
                this.blockConfirm = builder.blockConfirm;
            }
            if (builder.blockCancel == null) {
                this.blockCancel = "";
                return;
            } else {
                this.blockCancel = builder.blockCancel;
                return;
            }
        }
        this.blockErrno = builder.blockErrno;
        this.blockErrmsg = builder.blockErrmsg;
        this.blockDealurl = builder.blockDealurl;
        this.blockConfirm = builder.blockConfirm;
        this.blockCancel = builder.blockCancel;
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<BlockInfo> {
        public String blockCancel;
        public String blockConfirm;
        public String blockDealurl;
        public String blockErrmsg;
        public Integer blockErrno;

        public Builder() {
        }

        public Builder(BlockInfo blockInfo) {
            super(blockInfo);
            if (blockInfo != null) {
                this.blockErrno = blockInfo.blockErrno;
                this.blockErrmsg = blockInfo.blockErrmsg;
                this.blockDealurl = blockInfo.blockDealurl;
                this.blockConfirm = blockInfo.blockConfirm;
                this.blockCancel = blockInfo.blockCancel;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public BlockInfo build(boolean z) {
            return new BlockInfo(this, z);
        }
    }
}
