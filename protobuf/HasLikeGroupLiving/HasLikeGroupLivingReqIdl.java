package protobuf.HasLikeGroupLiving;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class HasLikeGroupLivingReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ HasLikeGroupLivingReqIdl(Builder builder, boolean z, HasLikeGroupLivingReqIdl hasLikeGroupLivingReqIdl) {
        this(builder, z);
    }

    private HasLikeGroupLivingReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<HasLikeGroupLivingReqIdl> {
        public DataReq data;

        public Builder(HasLikeGroupLivingReqIdl hasLikeGroupLivingReqIdl) {
            super(hasLikeGroupLivingReqIdl);
            if (hasLikeGroupLivingReqIdl != null) {
                this.data = hasLikeGroupLivingReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public HasLikeGroupLivingReqIdl build(boolean z) {
            return new HasLikeGroupLivingReqIdl(this, z, null);
        }
    }
}
