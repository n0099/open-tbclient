package protobuf.QueryGroupDetail;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes4.dex */
public final class QueryGroupDetailReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private QueryGroupDetailReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Builder extends Message.Builder<QueryGroupDetailReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(QueryGroupDetailReqIdl queryGroupDetailReqIdl) {
            super(queryGroupDetailReqIdl);
            if (queryGroupDetailReqIdl != null) {
                this.data = queryGroupDetailReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupDetailReqIdl build(boolean z) {
            return new QueryGroupDetailReqIdl(this, z);
        }
    }
}
