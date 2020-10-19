package protobuf.UpdateGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.GroupInfo;
/* loaded from: classes23.dex */
public final class UpdateGroupReqIdl extends Message {
    @ProtoField(tag = 1)
    public final GroupInfo data;

    private UpdateGroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes23.dex */
    public static final class Builder extends Message.Builder<UpdateGroupReqIdl> {
        public GroupInfo data;

        public Builder() {
        }

        public Builder(UpdateGroupReqIdl updateGroupReqIdl) {
            super(updateGroupReqIdl);
            if (updateGroupReqIdl != null) {
                this.data = updateGroupReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateGroupReqIdl build(boolean z) {
            return new UpdateGroupReqIdl(this, z);
        }
    }
}
