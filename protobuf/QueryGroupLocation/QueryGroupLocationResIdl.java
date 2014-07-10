package protobuf.QueryGroupLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryGroupLocationResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryGroupLocationResIdl(Builder builder, boolean z, QueryGroupLocationResIdl queryGroupLocationResIdl) {
        this(builder, z);
    }

    private QueryGroupLocationResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<QueryGroupLocationResIdl> {
        public DataRes data;
        public Error error;

        public Builder(QueryGroupLocationResIdl queryGroupLocationResIdl) {
            super(queryGroupLocationResIdl);
            if (queryGroupLocationResIdl != null) {
                this.error = queryGroupLocationResIdl.error;
                this.data = queryGroupLocationResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupLocationResIdl build(boolean z) {
            return new QueryGroupLocationResIdl(this, z, null);
        }
    }
}
