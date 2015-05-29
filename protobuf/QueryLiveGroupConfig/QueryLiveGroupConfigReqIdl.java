package protobuf.QueryLiveGroupConfig;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryLiveGroupConfigReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryLiveGroupConfigReqIdl(Builder builder, boolean z, QueryLiveGroupConfigReqIdl queryLiveGroupConfigReqIdl) {
        this(builder, z);
    }

    private QueryLiveGroupConfigReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QueryLiveGroupConfigReqIdl> {
        public DataReq data;

        public Builder(QueryLiveGroupConfigReqIdl queryLiveGroupConfigReqIdl) {
            super(queryLiveGroupConfigReqIdl);
            if (queryLiveGroupConfigReqIdl != null) {
                this.data = queryLiveGroupConfigReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupConfigReqIdl build(boolean z) {
            return new QueryLiveGroupConfigReqIdl(this, z, null);
        }
    }
}
