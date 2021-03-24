package protobuf.UpdateGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class UpdateGroupResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<UpdateGroupResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(UpdateGroupResIdl updateGroupResIdl) {
            super(updateGroupResIdl);
            if (updateGroupResIdl == null) {
                return;
            }
            this.error = updateGroupResIdl.error;
            this.data = updateGroupResIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateGroupResIdl build(boolean z) {
            return new UpdateGroupResIdl(this, z);
        }
    }

    public UpdateGroupResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }
}
