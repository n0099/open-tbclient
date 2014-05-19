package protobuf.QueryHotGroups;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryHotGroupsResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryHotGroupsResIdl(Builder builder, boolean z, QueryHotGroupsResIdl queryHotGroupsResIdl) {
        this(builder, z);
    }

    private QueryHotGroupsResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<QueryHotGroupsResIdl> {
        public DataRes data;
        public Error error;

        public Builder(QueryHotGroupsResIdl queryHotGroupsResIdl) {
            super(queryHotGroupsResIdl);
            if (queryHotGroupsResIdl != null) {
                this.error = queryHotGroupsResIdl.error;
                this.data = queryHotGroupsResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryHotGroupsResIdl build(boolean z) {
            return new QueryHotGroupsResIdl(this, z, null);
        }
    }
}
