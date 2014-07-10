package protobuf.QueryGroupCount;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryGroupCountResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryGroupCountResIdl(Builder builder, boolean z, QueryGroupCountResIdl queryGroupCountResIdl) {
        this(builder, z);
    }

    private QueryGroupCountResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QueryGroupCountResIdl> {
        public DataRes data;
        public Error error;

        public Builder(QueryGroupCountResIdl queryGroupCountResIdl) {
            super(queryGroupCountResIdl);
            if (queryGroupCountResIdl != null) {
                this.error = queryGroupCountResIdl.error;
                this.data = queryGroupCountResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupCountResIdl build(boolean z) {
            return new QueryGroupCountResIdl(this, z, null);
        }
    }
}
