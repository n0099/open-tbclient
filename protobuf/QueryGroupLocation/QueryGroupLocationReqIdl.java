package protobuf.QueryGroupLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes22.dex */
public final class QueryGroupLocationReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private QueryGroupLocationReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes22.dex */
    public static final class Builder extends Message.Builder<QueryGroupLocationReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(QueryGroupLocationReqIdl queryGroupLocationReqIdl) {
            super(queryGroupLocationReqIdl);
            if (queryGroupLocationReqIdl != null) {
                this.data = queryGroupLocationReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupLocationReqIdl build(boolean z) {
            return new QueryGroupLocationReqIdl(this, z);
        }
    }
}
