package protobuf.CommitInviteMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes9.dex */
public final class CommitInviteMsgResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<CommitInviteMsgResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(CommitInviteMsgResIdl commitInviteMsgResIdl) {
            super(commitInviteMsgResIdl);
            if (commitInviteMsgResIdl == null) {
                return;
            }
            this.error = commitInviteMsgResIdl.error;
            this.data = commitInviteMsgResIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CommitInviteMsgResIdl build(boolean z) {
            return new CommitInviteMsgResIdl(this, z);
        }
    }

    public CommitInviteMsgResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }
}
