package protobuf.GetMaskInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class GetMaskInfoReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ GetMaskInfoReqIdl(Builder builder, boolean z, GetMaskInfoReqIdl getMaskInfoReqIdl) {
        this(builder, z);
    }

    private GetMaskInfoReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<GetMaskInfoReqIdl> {
        public DataReq data;

        public Builder(GetMaskInfoReqIdl getMaskInfoReqIdl) {
            super(getMaskInfoReqIdl);
            if (getMaskInfoReqIdl != null) {
                this.data = getMaskInfoReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetMaskInfoReqIdl build(boolean z) {
            return new GetMaskInfoReqIdl(this, z, null);
        }
    }
}
