package protobuf.QueryLiveGroupsByUid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryLiveGroupsByUidResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryLiveGroupsByUidResIdl(Builder builder, boolean z, QueryLiveGroupsByUidResIdl queryLiveGroupsByUidResIdl) {
        this(builder, z);
    }

    private QueryLiveGroupsByUidResIdl(Builder builder, boolean z) {
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
    public static final class Builder extends Message.Builder<QueryLiveGroupsByUidResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(QueryLiveGroupsByUidResIdl queryLiveGroupsByUidResIdl) {
            super(queryLiveGroupsByUidResIdl);
            if (queryLiveGroupsByUidResIdl != null) {
                this.error = queryLiveGroupsByUidResIdl.error;
                this.data = queryLiveGroupsByUidResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupsByUidResIdl build(boolean z) {
            return new QueryLiveGroupsByUidResIdl(this, z, null);
        }
    }
}
