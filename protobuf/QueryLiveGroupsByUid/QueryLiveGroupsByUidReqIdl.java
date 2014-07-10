package protobuf.QueryLiveGroupsByUid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryLiveGroupsByUidReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryLiveGroupsByUidReqIdl(Builder builder, boolean z, QueryLiveGroupsByUidReqIdl queryLiveGroupsByUidReqIdl) {
        this(builder, z);
    }

    private QueryLiveGroupsByUidReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QueryLiveGroupsByUidReqIdl> {
        public DataReq data;

        public Builder(QueryLiveGroupsByUidReqIdl queryLiveGroupsByUidReqIdl) {
            super(queryLiveGroupsByUidReqIdl);
            if (queryLiveGroupsByUidReqIdl != null) {
                this.data = queryLiveGroupsByUidReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupsByUidReqIdl build(boolean z) {
            return new QueryLiveGroupsByUidReqIdl(this, z, null);
        }
    }
}
