package protobuf.QueryGroupActivity;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes22.dex */
public final class QueryGroupActivityReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private QueryGroupActivityReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes22.dex */
    public static final class Builder extends Message.Builder<QueryGroupActivityReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(QueryGroupActivityReqIdl queryGroupActivityReqIdl) {
            super(queryGroupActivityReqIdl);
            if (queryGroupActivityReqIdl != null) {
                this.data = queryGroupActivityReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupActivityReqIdl build(boolean z) {
            return new QueryGroupActivityReqIdl(this, z);
        }
    }
}
