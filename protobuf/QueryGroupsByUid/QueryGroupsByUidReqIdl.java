package protobuf.QueryGroupsByUid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes25.dex */
public final class QueryGroupsByUidReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private QueryGroupsByUidReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes25.dex */
    public static final class Builder extends Message.Builder<QueryGroupsByUidReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(QueryGroupsByUidReqIdl queryGroupsByUidReqIdl) {
            super(queryGroupsByUidReqIdl);
            if (queryGroupsByUidReqIdl != null) {
                this.data = queryGroupsByUidReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupsByUidReqIdl build(boolean z) {
            return new QueryGroupsByUidReqIdl(this, z);
        }
    }
}
