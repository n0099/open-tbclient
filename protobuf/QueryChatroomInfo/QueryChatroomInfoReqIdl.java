package protobuf.QueryChatroomInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryChatroomInfoReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryChatroomInfoReqIdl(Builder builder, boolean z, QueryChatroomInfoReqIdl queryChatroomInfoReqIdl) {
        this(builder, z);
    }

    private QueryChatroomInfoReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QueryChatroomInfoReqIdl> {
        public DataReq data;

        public Builder(QueryChatroomInfoReqIdl queryChatroomInfoReqIdl) {
            super(queryChatroomInfoReqIdl);
            if (queryChatroomInfoReqIdl != null) {
                this.data = queryChatroomInfoReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryChatroomInfoReqIdl build(boolean z) {
            return new QueryChatroomInfoReqIdl(this, z, null);
        }
    }
}
