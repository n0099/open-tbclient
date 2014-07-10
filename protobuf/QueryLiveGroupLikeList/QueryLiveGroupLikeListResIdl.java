package protobuf.QueryLiveGroupLikeList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryLiveGroupLikeListResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryLiveGroupLikeListResIdl(Builder builder, boolean z, QueryLiveGroupLikeListResIdl queryLiveGroupLikeListResIdl) {
        this(builder, z);
    }

    private QueryLiveGroupLikeListResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<QueryLiveGroupLikeListResIdl> {
        public DataRes data;
        public Error error;

        public Builder(QueryLiveGroupLikeListResIdl queryLiveGroupLikeListResIdl) {
            super(queryLiveGroupLikeListResIdl);
            if (queryLiveGroupLikeListResIdl != null) {
                this.error = queryLiveGroupLikeListResIdl.error;
                this.data = queryLiveGroupLikeListResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupLikeListResIdl build(boolean z) {
            return new QueryLiveGroupLikeListResIdl(this, z, null);
        }
    }
}
