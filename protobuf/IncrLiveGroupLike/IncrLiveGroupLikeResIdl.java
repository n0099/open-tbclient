package protobuf.IncrLiveGroupLike;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class IncrLiveGroupLikeResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ IncrLiveGroupLikeResIdl(Builder builder, boolean z, IncrLiveGroupLikeResIdl incrLiveGroupLikeResIdl) {
        this(builder, z);
    }

    private IncrLiveGroupLikeResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<IncrLiveGroupLikeResIdl> {
        public DataRes data;
        public Error error;

        public Builder(IncrLiveGroupLikeResIdl incrLiveGroupLikeResIdl) {
            super(incrLiveGroupLikeResIdl);
            if (incrLiveGroupLikeResIdl != null) {
                this.error = incrLiveGroupLikeResIdl.error;
                this.data = incrLiveGroupLikeResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public IncrLiveGroupLikeResIdl build(boolean z) {
            return new IncrLiveGroupLikeResIdl(this, z, null);
        }
    }
}
