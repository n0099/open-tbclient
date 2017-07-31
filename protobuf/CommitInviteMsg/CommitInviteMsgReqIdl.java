package protobuf.CommitInviteMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class CommitInviteMsgReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private CommitInviteMsgReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<CommitInviteMsgReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(CommitInviteMsgReqIdl commitInviteMsgReqIdl) {
            super(commitInviteMsgReqIdl);
            if (commitInviteMsgReqIdl != null) {
                this.data = commitInviteMsgReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CommitInviteMsgReqIdl build(boolean z) {
            return new CommitInviteMsgReqIdl(this, z);
        }
    }
}
