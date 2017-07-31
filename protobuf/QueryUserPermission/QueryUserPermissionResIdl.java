package protobuf.QueryUserPermission;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryUserPermissionResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private QueryUserPermissionResIdl(Builder builder, boolean z) {
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
    public static final class Builder extends Message.Builder<QueryUserPermissionResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(QueryUserPermissionResIdl queryUserPermissionResIdl) {
            super(queryUserPermissionResIdl);
            if (queryUserPermissionResIdl != null) {
                this.error = queryUserPermissionResIdl.error;
                this.data = queryUserPermissionResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryUserPermissionResIdl build(boolean z) {
            return new QueryUserPermissionResIdl(this, z);
        }
    }
}
