package protobuf.SubscribeLiveGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class SubscribeLiveGroupReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ SubscribeLiveGroupReqIdl(Builder builder, boolean z, SubscribeLiveGroupReqIdl subscribeLiveGroupReqIdl) {
        this(builder, z);
    }

    private SubscribeLiveGroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<SubscribeLiveGroupReqIdl> {
        public DataReq data;

        public Builder(SubscribeLiveGroupReqIdl subscribeLiveGroupReqIdl) {
            super(subscribeLiveGroupReqIdl);
            if (subscribeLiveGroupReqIdl != null) {
                this.data = subscribeLiveGroupReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SubscribeLiveGroupReqIdl build(boolean z) {
            return new SubscribeLiveGroupReqIdl(this, z, null);
        }
    }
}
