package protobuf.UpdateMaskInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes9.dex */
public final class UpdateMaskInfoResIdl extends Message {
    @ProtoField(tag = 1)
    public final Error error;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<UpdateMaskInfoResIdl> {
        public Error error;

        public Builder() {
        }

        public Builder(UpdateMaskInfoResIdl updateMaskInfoResIdl) {
            super(updateMaskInfoResIdl);
            if (updateMaskInfoResIdl == null) {
                return;
            }
            this.error = updateMaskInfoResIdl.error;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateMaskInfoResIdl build(boolean z) {
            return new UpdateMaskInfoResIdl(this, z);
        }
    }

    public UpdateMaskInfoResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
        } else {
            this.error = builder.error;
        }
    }
}
