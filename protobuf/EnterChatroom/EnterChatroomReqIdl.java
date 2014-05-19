package protobuf.EnterChatroom;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class EnterChatroomReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq dataReq;

    /* synthetic */ EnterChatroomReqIdl(Builder builder, boolean z, EnterChatroomReqIdl enterChatroomReqIdl) {
        this(builder, z);
    }

    private EnterChatroomReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.dataReq = builder.dataReq;
        } else {
            this.dataReq = builder.dataReq;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<EnterChatroomReqIdl> {
        public DataReq dataReq;

        public Builder(EnterChatroomReqIdl enterChatroomReqIdl) {
            super(enterChatroomReqIdl);
            if (enterChatroomReqIdl != null) {
                this.dataReq = enterChatroomReqIdl.dataReq;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public EnterChatroomReqIdl build(boolean z) {
            return new EnterChatroomReqIdl(this, z, null);
        }
    }
}
