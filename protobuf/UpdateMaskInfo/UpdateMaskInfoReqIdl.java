package protobuf.UpdateMaskInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class UpdateMaskInfoReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ UpdateMaskInfoReqIdl(Builder builder, boolean z, UpdateMaskInfoReqIdl updateMaskInfoReqIdl) {
        this(builder, z);
    }

    private UpdateMaskInfoReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<UpdateMaskInfoReqIdl> {
        public DataReq data;

        public Builder(UpdateMaskInfoReqIdl updateMaskInfoReqIdl) {
            super(updateMaskInfoReqIdl);
            if (updateMaskInfoReqIdl != null) {
                this.data = updateMaskInfoReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateMaskInfoReqIdl build(boolean z) {
            return new UpdateMaskInfoReqIdl(this, z, null);
        }
    }
}
