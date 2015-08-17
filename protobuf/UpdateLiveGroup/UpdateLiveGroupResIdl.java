package protobuf.UpdateLiveGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class UpdateLiveGroupResIdl extends Message {
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ UpdateLiveGroupResIdl(Builder builder, boolean z, UpdateLiveGroupResIdl updateLiveGroupResIdl) {
        this(builder, z);
    }

    private UpdateLiveGroupResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
        } else {
            this.error = builder.error;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<UpdateLiveGroupResIdl> {
        public Error error;

        public Builder() {
        }

        public Builder(UpdateLiveGroupResIdl updateLiveGroupResIdl) {
            super(updateLiveGroupResIdl);
            if (updateLiveGroupResIdl != null) {
                this.error = updateLiveGroupResIdl.error;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateLiveGroupResIdl build(boolean z) {
            return new UpdateLiveGroupResIdl(this, z, null);
        }
    }
}
