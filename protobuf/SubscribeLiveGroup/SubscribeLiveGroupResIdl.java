package protobuf.SubscribeLiveGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class SubscribeLiveGroupResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ SubscribeLiveGroupResIdl(Builder builder, boolean z, SubscribeLiveGroupResIdl subscribeLiveGroupResIdl) {
        this(builder, z);
    }

    private SubscribeLiveGroupResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<SubscribeLiveGroupResIdl> {
        public DataRes data;
        public Error error;

        public Builder(SubscribeLiveGroupResIdl subscribeLiveGroupResIdl) {
            super(subscribeLiveGroupResIdl);
            if (subscribeLiveGroupResIdl != null) {
                this.error = subscribeLiveGroupResIdl.error;
                this.data = subscribeLiveGroupResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SubscribeLiveGroupResIdl build(boolean z) {
            return new SubscribeLiveGroupResIdl(this, z, null);
        }
    }
}
