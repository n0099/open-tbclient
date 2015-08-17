package protobuf.QueryHotLiveGroups;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryHotLiveGroupsReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryHotLiveGroupsReqIdl(Builder builder, boolean z, QueryHotLiveGroupsReqIdl queryHotLiveGroupsReqIdl) {
        this(builder, z);
    }

    private QueryHotLiveGroupsReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<QueryHotLiveGroupsReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(QueryHotLiveGroupsReqIdl queryHotLiveGroupsReqIdl) {
            super(queryHotLiveGroupsReqIdl);
            if (queryHotLiveGroupsReqIdl != null) {
                this.data = queryHotLiveGroupsReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryHotLiveGroupsReqIdl build(boolean z) {
            return new QueryHotLiveGroupsReqIdl(this, z, null);
        }
    }
}
