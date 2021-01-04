package protobuf.CheckMaskUser;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class CheckMaskUserReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private CheckMaskUserReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<CheckMaskUserReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(CheckMaskUserReqIdl checkMaskUserReqIdl) {
            super(checkMaskUserReqIdl);
            if (checkMaskUserReqIdl != null) {
                this.data = checkMaskUserReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CheckMaskUserReqIdl build(boolean z) {
            return new CheckMaskUserReqIdl(this, z);
        }
    }
}
