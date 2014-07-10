package protobuf.SendForenoticeMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class SendForenoticeMsgReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ SendForenoticeMsgReqIdl(Builder builder, boolean z, SendForenoticeMsgReqIdl sendForenoticeMsgReqIdl) {
        this(builder, z);
    }

    private SendForenoticeMsgReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<SendForenoticeMsgReqIdl> {
        public DataReq data;

        public Builder(SendForenoticeMsgReqIdl sendForenoticeMsgReqIdl) {
            super(sendForenoticeMsgReqIdl);
            if (sendForenoticeMsgReqIdl != null) {
                this.data = sendForenoticeMsgReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SendForenoticeMsgReqIdl build(boolean z) {
            return new SendForenoticeMsgReqIdl(this, z, null);
        }
    }
}
