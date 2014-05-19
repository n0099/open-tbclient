package protobuf.QueryGroupUserList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryGroupUserListResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryGroupUserListResIdl(Builder builder, boolean z, QueryGroupUserListResIdl queryGroupUserListResIdl) {
        this(builder, z);
    }

    private QueryGroupUserListResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<QueryGroupUserListResIdl> {
        public DataRes data;
        public Error error;

        public Builder(QueryGroupUserListResIdl queryGroupUserListResIdl) {
            super(queryGroupUserListResIdl);
            if (queryGroupUserListResIdl != null) {
                this.error = queryGroupUserListResIdl.error;
                this.data = queryGroupUserListResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupUserListResIdl build(boolean z) {
            return new QueryGroupUserListResIdl(this, z, null);
        }
    }
}
