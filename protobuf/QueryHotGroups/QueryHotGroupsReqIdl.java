package protobuf.QueryHotGroups;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryHotGroupsReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryHotGroupsReqIdl(Builder builder, boolean z, QueryHotGroupsReqIdl queryHotGroupsReqIdl) {
        this(builder, z);
    }

    private QueryHotGroupsReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QueryHotGroupsReqIdl> {
        public DataReq data;

        public Builder(QueryHotGroupsReqIdl queryHotGroupsReqIdl) {
            super(queryHotGroupsReqIdl);
            if (queryHotGroupsReqIdl != null) {
                this.data = queryHotGroupsReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryHotGroupsReqIdl build(boolean z) {
            return new QueryHotGroupsReqIdl(this, z, null);
        }
    }
}
