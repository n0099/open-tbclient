package protobuf.SendForenoticeMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class SendForenoticeMsgResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ SendForenoticeMsgResIdl(Builder builder, boolean z, SendForenoticeMsgResIdl sendForenoticeMsgResIdl) {
        this(builder, z);
    }

    private SendForenoticeMsgResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<SendForenoticeMsgResIdl> {
        public DataRes data;
        public Error error;

        public Builder(SendForenoticeMsgResIdl sendForenoticeMsgResIdl) {
            super(sendForenoticeMsgResIdl);
            if (sendForenoticeMsgResIdl != null) {
                this.error = sendForenoticeMsgResIdl.error;
                this.data = sendForenoticeMsgResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SendForenoticeMsgResIdl build(boolean z) {
            return new SendForenoticeMsgResIdl(this, z, null);
        }
    }
}
