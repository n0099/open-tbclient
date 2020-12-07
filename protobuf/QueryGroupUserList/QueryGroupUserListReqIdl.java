package protobuf.QueryGroupUserList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes23.dex */
public final class QueryGroupUserListReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private QueryGroupUserListReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes23.dex */
    public static final class Builder extends Message.Builder<QueryGroupUserListReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(QueryGroupUserListReqIdl queryGroupUserListReqIdl) {
            super(queryGroupUserListReqIdl);
            if (queryGroupUserListReqIdl != null) {
                this.data = queryGroupUserListReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupUserListReqIdl build(boolean z) {
            return new QueryGroupUserListReqIdl(this, z);
        }
    }
}
