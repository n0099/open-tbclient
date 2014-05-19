package protobuf.QueryLiveGroupHistory;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryLiveGroupHistoryResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryLiveGroupHistoryResIdl(Builder builder, boolean z, QueryLiveGroupHistoryResIdl queryLiveGroupHistoryResIdl) {
        this(builder, z);
    }

    private QueryLiveGroupHistoryResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<QueryLiveGroupHistoryResIdl> {
        public DataRes data;
        public Error error;

        public Builder(QueryLiveGroupHistoryResIdl queryLiveGroupHistoryResIdl) {
            super(queryLiveGroupHistoryResIdl);
            if (queryLiveGroupHistoryResIdl != null) {
                this.error = queryLiveGroupHistoryResIdl.error;
                this.data = queryLiveGroupHistoryResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupHistoryResIdl build(boolean z) {
            return new QueryLiveGroupHistoryResIdl(this, z, null);
        }
    }
}
