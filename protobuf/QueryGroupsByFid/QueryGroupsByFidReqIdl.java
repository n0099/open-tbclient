package protobuf.QueryGroupsByFid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryGroupsByFidReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryGroupsByFidReqIdl(Builder builder, boolean z, QueryGroupsByFidReqIdl queryGroupsByFidReqIdl) {
        this(builder, z);
    }

    private QueryGroupsByFidReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QueryGroupsByFidReqIdl> {
        public DataReq data;

        public Builder(QueryGroupsByFidReqIdl queryGroupsByFidReqIdl) {
            super(queryGroupsByFidReqIdl);
            if (queryGroupsByFidReqIdl != null) {
                this.data = queryGroupsByFidReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupsByFidReqIdl build(boolean z) {
            return new QueryGroupsByFidReqIdl(this, z, null);
        }
    }
}
