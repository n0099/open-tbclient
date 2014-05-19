package protobuf.ApplyJoinGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class ApplyJoinGroupReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ ApplyJoinGroupReqIdl(Builder builder, boolean z, ApplyJoinGroupReqIdl applyJoinGroupReqIdl) {
        this(builder, z);
    }

    private ApplyJoinGroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<ApplyJoinGroupReqIdl> {
        public DataReq data;

        public Builder(ApplyJoinGroupReqIdl applyJoinGroupReqIdl) {
            super(applyJoinGroupReqIdl);
            if (applyJoinGroupReqIdl != null) {
                this.data = applyJoinGroupReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ApplyJoinGroupReqIdl build(boolean z) {
            return new ApplyJoinGroupReqIdl(this, z, null);
        }
    }
}
