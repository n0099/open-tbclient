package protobuf.QueryUserInfos;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes21.dex */
public final class QueryUserInfosReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private QueryUserInfosReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes21.dex */
    public static final class Builder extends Message.Builder<QueryUserInfosReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(QueryUserInfosReqIdl queryUserInfosReqIdl) {
            super(queryUserInfosReqIdl);
            if (queryUserInfosReqIdl != null) {
                this.data = queryUserInfosReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryUserInfosReqIdl build(boolean z) {
            return new QueryUserInfosReqIdl(this, z);
        }
    }
}
