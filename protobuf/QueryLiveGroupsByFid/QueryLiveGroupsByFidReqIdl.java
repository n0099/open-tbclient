package protobuf.QueryLiveGroupsByFid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryLiveGroupsByFidReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryLiveGroupsByFidReqIdl(Builder builder, boolean z, QueryLiveGroupsByFidReqIdl queryLiveGroupsByFidReqIdl) {
        this(builder, z);
    }

    private QueryLiveGroupsByFidReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QueryLiveGroupsByFidReqIdl> {
        public DataReq data;

        public Builder(QueryLiveGroupsByFidReqIdl queryLiveGroupsByFidReqIdl) {
            super(queryLiveGroupsByFidReqIdl);
            if (queryLiveGroupsByFidReqIdl != null) {
                this.data = queryLiveGroupsByFidReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupsByFidReqIdl build(boolean z) {
            return new QueryLiveGroupsByFidReqIdl(this, z, null);
        }
    }
}
