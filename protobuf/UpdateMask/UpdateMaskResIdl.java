package protobuf.UpdateMask;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class UpdateMaskResIdl extends Message {
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ UpdateMaskResIdl(Builder builder, boolean z, UpdateMaskResIdl updateMaskResIdl) {
        this(builder, z);
    }

    private UpdateMaskResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
        } else {
            this.error = builder.error;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<UpdateMaskResIdl> {
        public Error error;

        public Builder() {
        }

        public Builder(UpdateMaskResIdl updateMaskResIdl) {
            super(updateMaskResIdl);
            if (updateMaskResIdl != null) {
                this.error = updateMaskResIdl.error;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateMaskResIdl build(boolean z) {
            return new UpdateMaskResIdl(this, z, null);
        }
    }
}
