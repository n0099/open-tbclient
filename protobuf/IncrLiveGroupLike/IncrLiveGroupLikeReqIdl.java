package protobuf.IncrLiveGroupLike;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class IncrLiveGroupLikeReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ IncrLiveGroupLikeReqIdl(Builder builder, boolean z, IncrLiveGroupLikeReqIdl incrLiveGroupLikeReqIdl) {
        this(builder, z);
    }

    private IncrLiveGroupLikeReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<IncrLiveGroupLikeReqIdl> {
        public DataReq data;

        public Builder(IncrLiveGroupLikeReqIdl incrLiveGroupLikeReqIdl) {
            super(incrLiveGroupLikeReqIdl);
            if (incrLiveGroupLikeReqIdl != null) {
                this.data = incrLiveGroupLikeReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public IncrLiveGroupLikeReqIdl build(boolean z) {
            return new IncrLiveGroupLikeReqIdl(this, z, null);
        }
    }
}
