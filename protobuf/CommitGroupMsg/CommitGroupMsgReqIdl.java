package protobuf.CommitGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class CommitGroupMsgReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ CommitGroupMsgReqIdl(Builder builder, boolean z, CommitGroupMsgReqIdl commitGroupMsgReqIdl) {
        this(builder, z);
    }

    private CommitGroupMsgReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<CommitGroupMsgReqIdl> {
        public DataReq data;

        public Builder(CommitGroupMsgReqIdl commitGroupMsgReqIdl) {
            super(commitGroupMsgReqIdl);
            if (commitGroupMsgReqIdl != null) {
                this.data = commitGroupMsgReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CommitGroupMsgReqIdl build(boolean z) {
            return new CommitGroupMsgReqIdl(this, z, null);
        }
    }
}
