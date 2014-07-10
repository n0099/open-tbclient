package protobuf.QueryHistoryMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryHistoryMsgReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryHistoryMsgReqIdl(Builder builder, boolean z, QueryHistoryMsgReqIdl queryHistoryMsgReqIdl) {
        this(builder, z);
    }

    private QueryHistoryMsgReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QueryHistoryMsgReqIdl> {
        public DataReq data;

        public Builder(QueryHistoryMsgReqIdl queryHistoryMsgReqIdl) {
            super(queryHistoryMsgReqIdl);
            if (queryHistoryMsgReqIdl != null) {
                this.data = queryHistoryMsgReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryHistoryMsgReqIdl build(boolean z) {
            return new QueryHistoryMsgReqIdl(this, z, null);
        }
    }
}
