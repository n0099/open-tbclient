package protobuf.QueryForumDetail;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryForumDetailReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryForumDetailReqIdl(Builder builder, boolean z, QueryForumDetailReqIdl queryForumDetailReqIdl) {
        this(builder, z);
    }

    private QueryForumDetailReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<QueryForumDetailReqIdl> {
        public DataReq data;

        public Builder(QueryForumDetailReqIdl queryForumDetailReqIdl) {
            super(queryForumDetailReqIdl);
            if (queryForumDetailReqIdl != null) {
                this.data = queryForumDetailReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryForumDetailReqIdl build(boolean z) {
            return new QueryForumDetailReqIdl(this, z, null);
        }
    }
}
