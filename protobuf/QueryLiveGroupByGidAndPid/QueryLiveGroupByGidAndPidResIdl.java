package protobuf.QueryLiveGroupByGidAndPid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryLiveGroupByGidAndPidResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryLiveGroupByGidAndPidResIdl(Builder builder, boolean z, QueryLiveGroupByGidAndPidResIdl queryLiveGroupByGidAndPidResIdl) {
        this(builder, z);
    }

    private QueryLiveGroupByGidAndPidResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<QueryLiveGroupByGidAndPidResIdl> {
        public DataRes data;
        public Error error;

        public Builder(QueryLiveGroupByGidAndPidResIdl queryLiveGroupByGidAndPidResIdl) {
            super(queryLiveGroupByGidAndPidResIdl);
            if (queryLiveGroupByGidAndPidResIdl != null) {
                this.error = queryLiveGroupByGidAndPidResIdl.error;
                this.data = queryLiveGroupByGidAndPidResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupByGidAndPidResIdl build(boolean z) {
            return new QueryLiveGroupByGidAndPidResIdl(this, z, null);
        }
    }
}
