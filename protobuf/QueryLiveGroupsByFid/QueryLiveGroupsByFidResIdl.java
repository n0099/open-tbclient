package protobuf.QueryLiveGroupsByFid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryLiveGroupsByFidResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryLiveGroupsByFidResIdl(Builder builder, boolean z, QueryLiveGroupsByFidResIdl queryLiveGroupsByFidResIdl) {
        this(builder, z);
    }

    private QueryLiveGroupsByFidResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<QueryLiveGroupsByFidResIdl> {
        public DataRes data;
        public Error error;

        public Builder(QueryLiveGroupsByFidResIdl queryLiveGroupsByFidResIdl) {
            super(queryLiveGroupsByFidResIdl);
            if (queryLiveGroupsByFidResIdl != null) {
                this.error = queryLiveGroupsByFidResIdl.error;
                this.data = queryLiveGroupsByFidResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupsByFidResIdl build(boolean z) {
            return new QueryLiveGroupsByFidResIdl(this, z, null);
        }
    }
}
