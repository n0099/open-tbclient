package protobuf.HasLikeGroupLiving;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class HasLikeGroupLivingResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ HasLikeGroupLivingResIdl(Builder builder, boolean z, HasLikeGroupLivingResIdl hasLikeGroupLivingResIdl) {
        this(builder, z);
    }

    private HasLikeGroupLivingResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<HasLikeGroupLivingResIdl> {
        public DataRes data;
        public Error error;

        public Builder(HasLikeGroupLivingResIdl hasLikeGroupLivingResIdl) {
            super(hasLikeGroupLivingResIdl);
            if (hasLikeGroupLivingResIdl != null) {
                this.error = hasLikeGroupLivingResIdl.error;
                this.data = hasLikeGroupLivingResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public HasLikeGroupLivingResIdl build(boolean z) {
            return new HasLikeGroupLivingResIdl(this, z, null);
        }
    }
}
