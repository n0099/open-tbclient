package protobuf.QueryUserPermission;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
public final class QueryUserPermissionReqIdl extends Message {
    @ProtoField(tag = 2)
    public final DataReq data;

    private QueryUserPermissionReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<QueryUserPermissionReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(QueryUserPermissionReqIdl queryUserPermissionReqIdl) {
            super(queryUserPermissionReqIdl);
            if (queryUserPermissionReqIdl != null) {
                this.data = queryUserPermissionReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryUserPermissionReqIdl build(boolean z) {
            return new QueryUserPermissionReqIdl(this, z);
        }
    }
}
