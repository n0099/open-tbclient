package tbclient.GetBackground;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class GetBackgroundReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ GetBackgroundReqIdl(Builder builder, boolean z, GetBackgroundReqIdl getBackgroundReqIdl) {
        this(builder, z);
    }

    private GetBackgroundReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<GetBackgroundReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(GetBackgroundReqIdl getBackgroundReqIdl) {
            super(getBackgroundReqIdl);
            if (getBackgroundReqIdl != null) {
                this.data = getBackgroundReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetBackgroundReqIdl build(boolean z) {
            return new GetBackgroundReqIdl(this, z, null);
        }
    }
}
