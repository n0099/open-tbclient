package protobuf.QueryGroupsByLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryGroupsByLocationReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryGroupsByLocationReqIdl(Builder builder, boolean z, QueryGroupsByLocationReqIdl queryGroupsByLocationReqIdl) {
        this(builder, z);
    }

    private QueryGroupsByLocationReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QueryGroupsByLocationReqIdl> {
        public DataReq data;

        public Builder(QueryGroupsByLocationReqIdl queryGroupsByLocationReqIdl) {
            super(queryGroupsByLocationReqIdl);
            if (queryGroupsByLocationReqIdl != null) {
                this.data = queryGroupsByLocationReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupsByLocationReqIdl build(boolean z) {
            return new QueryGroupsByLocationReqIdl(this, z, null);
        }
    }
}
