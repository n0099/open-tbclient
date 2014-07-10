package protobuf.QueryOwnerGagList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryOwnerGagListResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryOwnerGagListResIdl(Builder builder, boolean z, QueryOwnerGagListResIdl queryOwnerGagListResIdl) {
        this(builder, z);
    }

    private QueryOwnerGagListResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<QueryOwnerGagListResIdl> {
        public DataRes data;
        public Error error;

        public Builder(QueryOwnerGagListResIdl queryOwnerGagListResIdl) {
            super(queryOwnerGagListResIdl);
            if (queryOwnerGagListResIdl != null) {
                this.error = queryOwnerGagListResIdl.error;
                this.data = queryOwnerGagListResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryOwnerGagListResIdl build(boolean z) {
            return new QueryOwnerGagListResIdl(this, z, null);
        }
    }
}
