package protobuf.SendMenuMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class SendMenuMsgReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ SendMenuMsgReqIdl(Builder builder, boolean z, SendMenuMsgReqIdl sendMenuMsgReqIdl) {
        this(builder, z);
    }

    private SendMenuMsgReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<SendMenuMsgReqIdl> {
        public DataReq data;

        public Builder(SendMenuMsgReqIdl sendMenuMsgReqIdl) {
            super(sendMenuMsgReqIdl);
            if (sendMenuMsgReqIdl != null) {
                this.data = sendMenuMsgReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SendMenuMsgReqIdl build(boolean z) {
            return new SendMenuMsgReqIdl(this, z, null);
        }
    }
}
