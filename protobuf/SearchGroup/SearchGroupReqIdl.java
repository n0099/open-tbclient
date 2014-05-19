package protobuf.SearchGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class SearchGroupReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ SearchGroupReqIdl(Builder builder, boolean z, SearchGroupReqIdl searchGroupReqIdl) {
        this(builder, z);
    }

    private SearchGroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<SearchGroupReqIdl> {
        public DataReq data;

        public Builder(SearchGroupReqIdl searchGroupReqIdl) {
            super(searchGroupReqIdl);
            if (searchGroupReqIdl != null) {
                this.data = searchGroupReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SearchGroupReqIdl build(boolean z) {
            return new SearchGroupReqIdl(this, z, null);
        }
    }
}
