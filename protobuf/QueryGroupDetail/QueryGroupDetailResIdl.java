package protobuf.QueryGroupDetail;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes4.dex */
public final class QueryGroupDetailResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private QueryGroupDetailResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes4.dex */
    public static final class Builder extends Message.Builder<QueryGroupDetailResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(QueryGroupDetailResIdl queryGroupDetailResIdl) {
            super(queryGroupDetailResIdl);
            if (queryGroupDetailResIdl != null) {
                this.error = queryGroupDetailResIdl.error;
                this.data = queryGroupDetailResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupDetailResIdl build(boolean z) {
            return new QueryGroupDetailResIdl(this, z);
        }
    }
}
