package protobuf.QueryLiveGroupByGid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryLiveGroupByGidReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryLiveGroupByGidReqIdl(Builder builder, boolean z, QueryLiveGroupByGidReqIdl queryLiveGroupByGidReqIdl) {
        this(builder, z);
    }

    private QueryLiveGroupByGidReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QueryLiveGroupByGidReqIdl> {
        public DataReq data;

        public Builder(QueryLiveGroupByGidReqIdl queryLiveGroupByGidReqIdl) {
            super(queryLiveGroupByGidReqIdl);
            if (queryLiveGroupByGidReqIdl != null) {
                this.data = queryLiveGroupByGidReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupByGidReqIdl build(boolean z) {
            return new QueryLiveGroupByGidReqIdl(this, z, null);
        }
    }
}
