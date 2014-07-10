package protobuf.QueryGroupsByLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryGroupsByLocationResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryGroupsByLocationResIdl(Builder builder, boolean z, QueryGroupsByLocationResIdl queryGroupsByLocationResIdl) {
        this(builder, z);
    }

    private QueryGroupsByLocationResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<QueryGroupsByLocationResIdl> {
        public DataRes data;
        public Error error;

        public Builder(QueryGroupsByLocationResIdl queryGroupsByLocationResIdl) {
            super(queryGroupsByLocationResIdl);
            if (queryGroupsByLocationResIdl != null) {
                this.error = queryGroupsByLocationResIdl.error;
                this.data = queryGroupsByLocationResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupsByLocationResIdl build(boolean z) {
            return new QueryGroupsByLocationResIdl(this, z, null);
        }
    }
}
