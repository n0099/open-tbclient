package protobuf.SendMenuMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class SendMenuMsgReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private SendMenuMsgReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<SendMenuMsgReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(SendMenuMsgReqIdl sendMenuMsgReqIdl) {
            super(sendMenuMsgReqIdl);
            if (sendMenuMsgReqIdl != null) {
                this.data = sendMenuMsgReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SendMenuMsgReqIdl build(boolean z) {
            return new SendMenuMsgReqIdl(this, z);
        }
    }
}
