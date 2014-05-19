package protobuf.QueryChatroomInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryChatroomInfoResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryChatroomInfoResIdl(Builder builder, boolean z, QueryChatroomInfoResIdl queryChatroomInfoResIdl) {
        this(builder, z);
    }

    private QueryChatroomInfoResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<QueryChatroomInfoResIdl> {
        public DataRes data;
        public Error error;

        public Builder(QueryChatroomInfoResIdl queryChatroomInfoResIdl) {
            super(queryChatroomInfoResIdl);
            if (queryChatroomInfoResIdl != null) {
                this.error = queryChatroomInfoResIdl.error;
                this.data = queryChatroomInfoResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryChatroomInfoResIdl build(boolean z) {
            return new QueryChatroomInfoResIdl(this, z, null);
        }
    }
}
