package protobuf.ApplyJoinGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes17.dex */
public final class ApplyJoinGroupReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private ApplyJoinGroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes17.dex */
    public static final class Builder extends Message.Builder<ApplyJoinGroupReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(ApplyJoinGroupReqIdl applyJoinGroupReqIdl) {
            super(applyJoinGroupReqIdl);
            if (applyJoinGroupReqIdl != null) {
                this.data = applyJoinGroupReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ApplyJoinGroupReqIdl build(boolean z) {
            return new ApplyJoinGroupReqIdl(this, z);
        }
    }
}
