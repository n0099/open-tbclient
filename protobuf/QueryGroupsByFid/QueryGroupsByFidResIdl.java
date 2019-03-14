package protobuf.QueryGroupsByFid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes5.dex */
public final class QueryGroupsByFidResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private QueryGroupsByFidResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends Message.Builder<QueryGroupsByFidResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(QueryGroupsByFidResIdl queryGroupsByFidResIdl) {
            super(queryGroupsByFidResIdl);
            if (queryGroupsByFidResIdl != null) {
                this.error = queryGroupsByFidResIdl.error;
                this.data = queryGroupsByFidResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupsByFidResIdl build(boolean z) {
            return new QueryGroupsByFidResIdl(this, z);
        }
    }
}
