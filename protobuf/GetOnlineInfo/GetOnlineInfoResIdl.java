package protobuf.GetOnlineInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class GetOnlineInfoResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ GetOnlineInfoResIdl(Builder builder, boolean z, GetOnlineInfoResIdl getOnlineInfoResIdl) {
        this(builder, z);
    }

    private GetOnlineInfoResIdl(Builder builder, boolean z) {
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
    public static final class Builder extends Message.Builder<GetOnlineInfoResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(GetOnlineInfoResIdl getOnlineInfoResIdl) {
            super(getOnlineInfoResIdl);
            if (getOnlineInfoResIdl != null) {
                this.error = getOnlineInfoResIdl.error;
                this.data = getOnlineInfoResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetOnlineInfoResIdl build(boolean z) {
            return new GetOnlineInfoResIdl(this, z, null);
        }
    }
}
