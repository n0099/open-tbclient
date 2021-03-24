package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
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

    /* loaded from: classes7.dex */
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
            if (blockInfo == null) {
                return;
            }
            this.blockErrno = blockInfo.blockErrno;
            this.blockErrmsg = blockInfo.blockErrmsg;
            this.blockDealurl = blockInfo.blockDealurl;
            this.blockConfirm = blockInfo.blockConfirm;
            this.blockCancel = blockInfo.blockCancel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public BlockInfo build(boolean z) {
            return new BlockInfo(this, z);
        }
    }

    public BlockInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.blockErrno;
            if (num == null) {
                this.blockErrno = DEFAULT_BLOCKERRNO;
            } else {
                this.blockErrno = num;
            }
            String str = builder.blockErrmsg;
            if (str == null) {
                this.blockErrmsg = "";
            } else {
                this.blockErrmsg = str;
            }
            String str2 = builder.blockDealurl;
            if (str2 == null) {
                this.blockDealurl = "";
            } else {
                this.blockDealurl = str2;
            }
            String str3 = builder.blockConfirm;
            if (str3 == null) {
                this.blockConfirm = "";
            } else {
                this.blockConfirm = str3;
            }
            String str4 = builder.blockCancel;
            if (str4 == null) {
                this.blockCancel = "";
                return;
            } else {
                this.blockCancel = str4;
                return;
            }
        }
        this.blockErrno = builder.blockErrno;
        this.blockErrmsg = builder.blockErrmsg;
        this.blockDealurl = builder.blockDealurl;
        this.blockConfirm = builder.blockConfirm;
        this.blockCancel = builder.blockCancel;
    }
}
