package protobuf.QueryHotLiveGroups;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryHotLiveGroupsResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryHotLiveGroupsResIdl(Builder builder, boolean z, QueryHotLiveGroupsResIdl queryHotLiveGroupsResIdl) {
        this(builder, z);
    }

    private QueryHotLiveGroupsResIdl(Builder builder, boolean z) {
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
    public static final class Builder extends Message.Builder<QueryHotLiveGroupsResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(QueryHotLiveGroupsResIdl queryHotLiveGroupsResIdl) {
            super(queryHotLiveGroupsResIdl);
            if (queryHotLiveGroupsResIdl != null) {
                this.error = queryHotLiveGroupsResIdl.error;
                this.data = queryHotLiveGroupsResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryHotLiveGroupsResIdl build(boolean z) {
            return new QueryHotLiveGroupsResIdl(this, z, null);
        }
    }
}
