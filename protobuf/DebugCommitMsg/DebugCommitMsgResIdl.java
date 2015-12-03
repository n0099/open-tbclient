package protobuf.DebugCommitMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class DebugCommitMsgResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ DebugCommitMsgResIdl(Builder builder, boolean z, DebugCommitMsgResIdl debugCommitMsgResIdl) {
        this(builder, z);
    }

    private DebugCommitMsgResIdl(Builder builder, boolean z) {
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
    public static final class Builder extends Message.Builder<DebugCommitMsgResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(DebugCommitMsgResIdl debugCommitMsgResIdl) {
            super(debugCommitMsgResIdl);
            if (debugCommitMsgResIdl != null) {
                this.error = debugCommitMsgResIdl.error;
                this.data = debugCommitMsgResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DebugCommitMsgResIdl build(boolean z) {
            return new DebugCommitMsgResIdl(this, z, null);
        }
    }
}
