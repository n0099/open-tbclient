package protobuf.QueryGroupLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes17.dex */
public final class QueryGroupLocationResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

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

    /* loaded from: classes17.dex */
    public static final class Builder extends Message.Builder<QueryGroupLocationResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

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
            return new QueryGroupLocationResIdl(this, z);
        }
    }
}
