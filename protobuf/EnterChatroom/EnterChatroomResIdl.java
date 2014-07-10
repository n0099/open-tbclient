package protobuf.EnterChatroom;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class EnterChatroomResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ EnterChatroomResIdl(Builder builder, boolean z, EnterChatroomResIdl enterChatroomResIdl) {
        this(builder, z);
    }

    private EnterChatroomResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<EnterChatroomResIdl> {
        public DataRes data;
        public Error error;

        public Builder(EnterChatroomResIdl enterChatroomResIdl) {
            super(enterChatroomResIdl);
            if (enterChatroomResIdl != null) {
                this.error = enterChatroomResIdl.error;
                this.data = enterChatroomResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public EnterChatroomResIdl build(boolean z) {
            return new EnterChatroomResIdl(this, z, null);
        }
    }
}
