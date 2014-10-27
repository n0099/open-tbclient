package protobuf.SendXiubaSysMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class SendXiubaSysMsgResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final protobuf.Error error;

    /* synthetic */ SendXiubaSysMsgResIdl(Builder builder, boolean z, SendXiubaSysMsgResIdl sendXiubaSysMsgResIdl) {
        this(builder, z);
    }

    private SendXiubaSysMsgResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<SendXiubaSysMsgResIdl> {
        public DataRes data;
        public protobuf.Error error;

        public Builder(SendXiubaSysMsgResIdl sendXiubaSysMsgResIdl) {
            super(sendXiubaSysMsgResIdl);
            if (sendXiubaSysMsgResIdl != null) {
                this.error = sendXiubaSysMsgResIdl.error;
                this.data = sendXiubaSysMsgResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SendXiubaSysMsgResIdl build(boolean z) {
            return new SendXiubaSysMsgResIdl(this, z, null);
        }
    }
}
