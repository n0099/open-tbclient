package protobuf.SendXiubaSysMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class SendXiubaSysMsgReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ SendXiubaSysMsgReqIdl(Builder builder, boolean z, SendXiubaSysMsgReqIdl sendXiubaSysMsgReqIdl) {
        this(builder, z);
    }

    private SendXiubaSysMsgReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<SendXiubaSysMsgReqIdl> {
        public DataReq data;

        public Builder(SendXiubaSysMsgReqIdl sendXiubaSysMsgReqIdl) {
            super(sendXiubaSysMsgReqIdl);
            if (sendXiubaSysMsgReqIdl != null) {
                this.data = sendXiubaSysMsgReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SendXiubaSysMsgReqIdl build(boolean z) {
            return new SendXiubaSysMsgReqIdl(this, z, null);
        }
    }
}
