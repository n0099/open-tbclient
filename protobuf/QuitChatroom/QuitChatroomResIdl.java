package protobuf.QuitChatroom;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QuitChatroomResIdl extends Message {
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QuitChatroomResIdl(Builder builder, boolean z, QuitChatroomResIdl quitChatroomResIdl) {
        this(builder, z);
    }

    private QuitChatroomResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
        } else {
            this.error = builder.error;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QuitChatroomResIdl> {
        public Error error;

        public Builder(QuitChatroomResIdl quitChatroomResIdl) {
            super(quitChatroomResIdl);
            if (quitChatroomResIdl != null) {
                this.error = quitChatroomResIdl.error;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QuitChatroomResIdl build(boolean z) {
            return new QuitChatroomResIdl(this, z, null);
        }
    }
}
