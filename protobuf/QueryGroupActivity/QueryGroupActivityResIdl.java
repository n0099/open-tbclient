package protobuf.QueryGroupActivity;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes23.dex */
public final class QueryGroupActivityResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private QueryGroupActivityResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes23.dex */
    public static final class Builder extends Message.Builder<QueryGroupActivityResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(QueryGroupActivityResIdl queryGroupActivityResIdl) {
            super(queryGroupActivityResIdl);
            if (queryGroupActivityResIdl != null) {
                this.error = queryGroupActivityResIdl.error;
                this.data = queryGroupActivityResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupActivityResIdl build(boolean z) {
            return new QueryGroupActivityResIdl(this, z);
        }
    }
}
