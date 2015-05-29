package protobuf.QueryLiveGroupConfig;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryLiveGroupConfigResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryLiveGroupConfigResIdl(Builder builder, boolean z, QueryLiveGroupConfigResIdl queryLiveGroupConfigResIdl) {
        this(builder, z);
    }

    private QueryLiveGroupConfigResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<QueryLiveGroupConfigResIdl> {
        public DataRes data;
        public Error error;

        public Builder(QueryLiveGroupConfigResIdl queryLiveGroupConfigResIdl) {
            super(queryLiveGroupConfigResIdl);
            if (queryLiveGroupConfigResIdl != null) {
                this.error = queryLiveGroupConfigResIdl.error;
                this.data = queryLiveGroupConfigResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupConfigResIdl build(boolean z) {
            return new QueryLiveGroupConfigResIdl(this, z, null);
        }
    }
}
