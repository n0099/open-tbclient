package protobuf.QueryGroupCount;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryGroupCountReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryGroupCountReqIdl(Builder builder, boolean z, QueryGroupCountReqIdl queryGroupCountReqIdl) {
        this(builder, z);
    }

    private QueryGroupCountReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QueryGroupCountReqIdl> {
        public DataReq data;

        public Builder(QueryGroupCountReqIdl queryGroupCountReqIdl) {
            super(queryGroupCountReqIdl);
            if (queryGroupCountReqIdl != null) {
                this.data = queryGroupCountReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupCountReqIdl build(boolean z) {
            return new QueryGroupCountReqIdl(this, z, null);
        }
    }
}
