package protobuf.SearchGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes7.dex */
public final class SearchGroupResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private SearchGroupResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<SearchGroupResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(SearchGroupResIdl searchGroupResIdl) {
            super(searchGroupResIdl);
            if (searchGroupResIdl != null) {
                this.error = searchGroupResIdl.error;
                this.data = searchGroupResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SearchGroupResIdl build(boolean z) {
            return new SearchGroupResIdl(this, z);
        }
    }
}
