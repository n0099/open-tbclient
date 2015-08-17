package protobuf.QueryLiveGroupLikeList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryLiveGroupLikeListReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryLiveGroupLikeListReqIdl(Builder builder, boolean z, QueryLiveGroupLikeListReqIdl queryLiveGroupLikeListReqIdl) {
        this(builder, z);
    }

    private QueryLiveGroupLikeListReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<QueryLiveGroupLikeListReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(QueryLiveGroupLikeListReqIdl queryLiveGroupLikeListReqIdl) {
            super(queryLiveGroupLikeListReqIdl);
            if (queryLiveGroupLikeListReqIdl != null) {
                this.data = queryLiveGroupLikeListReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupLikeListReqIdl build(boolean z) {
            return new QueryLiveGroupLikeListReqIdl(this, z, null);
        }
    }
}
