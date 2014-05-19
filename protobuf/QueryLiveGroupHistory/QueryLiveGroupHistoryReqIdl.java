package protobuf.QueryLiveGroupHistory;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryLiveGroupHistoryReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryLiveGroupHistoryReqIdl(Builder builder, boolean z, QueryLiveGroupHistoryReqIdl queryLiveGroupHistoryReqIdl) {
        this(builder, z);
    }

    private QueryLiveGroupHistoryReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QueryLiveGroupHistoryReqIdl> {
        public DataReq data;

        public Builder(QueryLiveGroupHistoryReqIdl queryLiveGroupHistoryReqIdl) {
            super(queryLiveGroupHistoryReqIdl);
            if (queryLiveGroupHistoryReqIdl != null) {
                this.data = queryLiveGroupHistoryReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupHistoryReqIdl build(boolean z) {
            return new QueryLiveGroupHistoryReqIdl(this, z, null);
        }
    }
}
