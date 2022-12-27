package protobuf.CommitGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class CommitGroupMsgReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<CommitGroupMsgReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(CommitGroupMsgReqIdl commitGroupMsgReqIdl) {
            super(commitGroupMsgReqIdl);
            if (commitGroupMsgReqIdl == null) {
                return;
            }
            this.data = commitGroupMsgReqIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CommitGroupMsgReqIdl build(boolean z) {
            return new CommitGroupMsgReqIdl(this, z);
        }
    }

    public CommitGroupMsgReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }
}
