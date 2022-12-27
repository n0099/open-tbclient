package protobuf.CommitGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes9.dex */
public final class CommitGroupMsgResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<CommitGroupMsgResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(CommitGroupMsgResIdl commitGroupMsgResIdl) {
            super(commitGroupMsgResIdl);
            if (commitGroupMsgResIdl == null) {
                return;
            }
            this.error = commitGroupMsgResIdl.error;
            this.data = commitGroupMsgResIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CommitGroupMsgResIdl build(boolean z) {
            return new CommitGroupMsgResIdl(this, z);
        }
    }

    public CommitGroupMsgResIdl(Builder builder, boolean z) {
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
