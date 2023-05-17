package protobuf.UpdateMask;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class UpdateMaskReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<UpdateMaskReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(UpdateMaskReqIdl updateMaskReqIdl) {
            super(updateMaskReqIdl);
            if (updateMaskReqIdl == null) {
                return;
            }
            this.data = updateMaskReqIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateMaskReqIdl build(boolean z) {
            return new UpdateMaskReqIdl(this, z);
        }
    }

    public UpdateMaskReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }
}
