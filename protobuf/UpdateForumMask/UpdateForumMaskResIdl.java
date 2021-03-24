package protobuf.UpdateForumMask;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class UpdateForumMaskResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<UpdateForumMaskResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(UpdateForumMaskResIdl updateForumMaskResIdl) {
            super(updateForumMaskResIdl);
            if (updateForumMaskResIdl == null) {
                return;
            }
            this.error = updateForumMaskResIdl.error;
            this.data = updateForumMaskResIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateForumMaskResIdl build(boolean z) {
            return new UpdateForumMaskResIdl(this, z);
        }
    }

    public UpdateForumMaskResIdl(Builder builder, boolean z) {
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
