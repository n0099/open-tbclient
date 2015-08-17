package protobuf.QueryLiveGroupByGidAndPid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryLiveGroupByGidAndPidReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryLiveGroupByGidAndPidReqIdl(Builder builder, boolean z, QueryLiveGroupByGidAndPidReqIdl queryLiveGroupByGidAndPidReqIdl) {
        this(builder, z);
    }

    private QueryLiveGroupByGidAndPidReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<QueryLiveGroupByGidAndPidReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(QueryLiveGroupByGidAndPidReqIdl queryLiveGroupByGidAndPidReqIdl) {
            super(queryLiveGroupByGidAndPidReqIdl);
            if (queryLiveGroupByGidAndPidReqIdl != null) {
                this.data = queryLiveGroupByGidAndPidReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryLiveGroupByGidAndPidReqIdl build(boolean z) {
            return new QueryLiveGroupByGidAndPidReqIdl(this, z, null);
        }
    }
}
