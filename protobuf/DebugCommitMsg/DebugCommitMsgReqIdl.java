package protobuf.DebugCommitMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes22.dex */
public final class DebugCommitMsgReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private DebugCommitMsgReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes22.dex */
    public static final class Builder extends Message.Builder<DebugCommitMsgReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(DebugCommitMsgReqIdl debugCommitMsgReqIdl) {
            super(debugCommitMsgReqIdl);
            if (debugCommitMsgReqIdl != null) {
                this.data = debugCommitMsgReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DebugCommitMsgReqIdl build(boolean z) {
            return new DebugCommitMsgReqIdl(this, z);
        }
    }
}
