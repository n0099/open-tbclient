package protobuf.QueryLiveGroupByGid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryLiveGroupByGidResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryLiveGroupByGidResIdl(Builder builder, boolean z, QueryLiveGroupByGidResIdl queryLiveGroupByGidResIdl) {
        this(builder, z);
    }

    private QueryLiveGroupByGidResIdl(Builder builder, boolean z) {
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
    public static final class Builder extends Message.Builder<QueryLiveGroupByGidResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(QueryLiveGroupByGidResIdl queryLiveGroupByGidResIdl) {
            super(queryLiveGroupByGidResIdl);
            if (queryLiveGroupByGidResIdl != null) {
                this.error = queryLiveGroupByGidResIdl.error;
                this.data = queryLiveGroupByGidResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupByGidResIdl build(boolean z) {
            return new QueryLiveGroupByGidResIdl(this, z, null);
        }
    }
}
