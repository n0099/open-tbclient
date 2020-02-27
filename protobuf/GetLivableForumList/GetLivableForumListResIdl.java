package protobuf.GetLivableForumList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes9.dex */
public final class GetLivableForumListResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private GetLivableForumListResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<GetLivableForumListResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(GetLivableForumListResIdl getLivableForumListResIdl) {
            super(getLivableForumListResIdl);
            if (getLivableForumListResIdl != null) {
                this.error = getLivableForumListResIdl.error;
                this.data = getLivableForumListResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetLivableForumListResIdl build(boolean z) {
            return new GetLivableForumListResIdl(this, z);
        }
    }
}
