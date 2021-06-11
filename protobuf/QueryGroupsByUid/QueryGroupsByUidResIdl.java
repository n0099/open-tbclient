package protobuf.QueryGroupsByUid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes8.dex */
public final class QueryGroupsByUidResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<QueryGroupsByUidResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(QueryGroupsByUidResIdl queryGroupsByUidResIdl) {
            super(queryGroupsByUidResIdl);
            if (queryGroupsByUidResIdl == null) {
                return;
            }
            this.error = queryGroupsByUidResIdl.error;
            this.data = queryGroupsByUidResIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupsByUidResIdl build(boolean z) {
            return new QueryGroupsByUidResIdl(this, z);
        }
    }

    public QueryGroupsByUidResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }
}
