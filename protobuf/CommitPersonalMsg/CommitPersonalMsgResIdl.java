package protobuf.CommitPersonalMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes8.dex */
public final class CommitPersonalMsgResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<CommitPersonalMsgResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(CommitPersonalMsgResIdl commitPersonalMsgResIdl) {
            super(commitPersonalMsgResIdl);
            if (commitPersonalMsgResIdl == null) {
                return;
            }
            this.error = commitPersonalMsgResIdl.error;
            this.data = commitPersonalMsgResIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CommitPersonalMsgResIdl build(boolean z) {
            return new CommitPersonalMsgResIdl(this, z);
        }
    }

    public CommitPersonalMsgResIdl(Builder builder, boolean z) {
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
