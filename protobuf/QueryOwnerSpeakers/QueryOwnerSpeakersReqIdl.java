package protobuf.QueryOwnerSpeakers;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class QueryOwnerSpeakersReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ QueryOwnerSpeakersReqIdl(Builder builder, boolean z, QueryOwnerSpeakersReqIdl queryOwnerSpeakersReqIdl) {
        this(builder, z);
    }

    private QueryOwnerSpeakersReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<QueryOwnerSpeakersReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(QueryOwnerSpeakersReqIdl queryOwnerSpeakersReqIdl) {
            super(queryOwnerSpeakersReqIdl);
            if (queryOwnerSpeakersReqIdl != null) {
                this.data = queryOwnerSpeakersReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryOwnerSpeakersReqIdl build(boolean z) {
            return new QueryOwnerSpeakersReqIdl(this, z, null);
        }
    }
}
