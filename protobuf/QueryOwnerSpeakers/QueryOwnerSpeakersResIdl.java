package protobuf.QueryOwnerSpeakers;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class QueryOwnerSpeakersResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ QueryOwnerSpeakersResIdl(Builder builder, boolean z, QueryOwnerSpeakersResIdl queryOwnerSpeakersResIdl) {
        this(builder, z);
    }

    private QueryOwnerSpeakersResIdl(Builder builder, boolean z) {
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
    public static final class Builder extends Message.Builder<QueryOwnerSpeakersResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(QueryOwnerSpeakersResIdl queryOwnerSpeakersResIdl) {
            super(queryOwnerSpeakersResIdl);
            if (queryOwnerSpeakersResIdl != null) {
                this.error = queryOwnerSpeakersResIdl.error;
                this.data = queryOwnerSpeakersResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryOwnerSpeakersResIdl build(boolean z) {
            return new QueryOwnerSpeakersResIdl(this, z, null);
        }
    }
}
