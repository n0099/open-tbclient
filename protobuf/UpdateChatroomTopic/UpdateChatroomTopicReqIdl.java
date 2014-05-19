package protobuf.UpdateChatroomTopic;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class UpdateChatroomTopicReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ UpdateChatroomTopicReqIdl(Builder builder, boolean z, UpdateChatroomTopicReqIdl updateChatroomTopicReqIdl) {
        this(builder, z);
    }

    private UpdateChatroomTopicReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<UpdateChatroomTopicReqIdl> {
        public DataReq data;

        public Builder(UpdateChatroomTopicReqIdl updateChatroomTopicReqIdl) {
            super(updateChatroomTopicReqIdl);
            if (updateChatroomTopicReqIdl != null) {
                this.data = updateChatroomTopicReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateChatroomTopicReqIdl build(boolean z) {
            return new UpdateChatroomTopicReqIdl(this, z, null);
        }
    }
}
