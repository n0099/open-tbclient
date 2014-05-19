package protobuf.QuitChatroom;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QuitChatroomReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QuitChatroomReqIdl(Builder builder, boolean z, QuitChatroomReqIdl quitChatroomReqIdl) {
        this(builder, z);
    }

    private QuitChatroomReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QuitChatroomReqIdl> {
        public DataReq data;

        public Builder(QuitChatroomReqIdl quitChatroomReqIdl) {
            super(quitChatroomReqIdl);
            if (quitChatroomReqIdl != null) {
                this.data = quitChatroomReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QuitChatroomReqIdl build(boolean z) {
            return new QuitChatroomReqIdl(this, z, null);
        }
    }
}
