package protobuf.CommitPersonalMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class CommitPersonalMsgResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ CommitPersonalMsgResIdl(Builder builder, boolean z, CommitPersonalMsgResIdl commitPersonalMsgResIdl) {
        this(builder, z);
    }

    private CommitPersonalMsgResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<CommitPersonalMsgResIdl> {
        public DataRes data;
        public Error error;

        public Builder(CommitPersonalMsgResIdl commitPersonalMsgResIdl) {
            super(commitPersonalMsgResIdl);
            if (commitPersonalMsgResIdl != null) {
                this.error = commitPersonalMsgResIdl.error;
                this.data = commitPersonalMsgResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CommitPersonalMsgResIdl build(boolean z) {
            return new CommitPersonalMsgResIdl(this, z, null);
        }
    }
}
