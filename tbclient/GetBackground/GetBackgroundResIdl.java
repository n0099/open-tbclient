package tbclient.GetBackground;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import tbclient.Error;
/* loaded from: classes.dex */
public final class GetBackgroundResIdl extends Message {
    @ProtoField(tag = 1)
    public final DataRes data;
    @ProtoField(tag = 2)
    public final Error error;

    /* synthetic */ GetBackgroundResIdl(Builder builder, boolean z, GetBackgroundResIdl getBackgroundResIdl) {
        this(builder, z);
    }

    private GetBackgroundResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
            this.error = builder.error;
            return;
        }
        this.data = builder.data;
        this.error = builder.error;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<GetBackgroundResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(GetBackgroundResIdl getBackgroundResIdl) {
            super(getBackgroundResIdl);
            if (getBackgroundResIdl != null) {
                this.data = getBackgroundResIdl.data;
                this.error = getBackgroundResIdl.error;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetBackgroundResIdl build(boolean z) {
            return new GetBackgroundResIdl(this, z, null);
        }
    }
}
