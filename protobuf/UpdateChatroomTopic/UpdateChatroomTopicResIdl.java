package protobuf.UpdateChatroomTopic;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class UpdateChatroomTopicResIdl extends Message {
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ UpdateChatroomTopicResIdl(Builder builder, boolean z, UpdateChatroomTopicResIdl updateChatroomTopicResIdl) {
        this(builder, z);
    }

    private UpdateChatroomTopicResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
        } else {
            this.error = builder.error;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<UpdateChatroomTopicResIdl> {
        public Error error;

        public Builder(UpdateChatroomTopicResIdl updateChatroomTopicResIdl) {
            super(updateChatroomTopicResIdl);
            if (updateChatroomTopicResIdl != null) {
                this.error = updateChatroomTopicResIdl.error;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateChatroomTopicResIdl build(boolean z) {
            return new UpdateChatroomTopicResIdl(this, z, null);
        }
    }
}
