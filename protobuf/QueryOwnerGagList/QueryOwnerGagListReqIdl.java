package protobuf.QueryOwnerGagList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryOwnerGagListReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryOwnerGagListReqIdl(Builder builder, boolean z, QueryOwnerGagListReqIdl queryOwnerGagListReqIdl) {
        this(builder, z);
    }

    private QueryOwnerGagListReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<QueryOwnerGagListReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(QueryOwnerGagListReqIdl queryOwnerGagListReqIdl) {
            super(queryOwnerGagListReqIdl);
            if (queryOwnerGagListReqIdl != null) {
                this.data = queryOwnerGagListReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryOwnerGagListReqIdl build(boolean z) {
            return new QueryOwnerGagListReqIdl(this, z, null);
        }
    }
}
