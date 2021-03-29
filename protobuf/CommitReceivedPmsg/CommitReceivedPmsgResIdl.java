package protobuf.CommitReceivedPmsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes7.dex */
public final class CommitReceivedPmsgResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<CommitReceivedPmsgResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(CommitReceivedPmsgResIdl commitReceivedPmsgResIdl) {
            super(commitReceivedPmsgResIdl);
            if (commitReceivedPmsgResIdl == null) {
                return;
            }
            this.error = commitReceivedPmsgResIdl.error;
            this.data = commitReceivedPmsgResIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CommitReceivedPmsgResIdl build(boolean z) {
            return new CommitReceivedPmsgResIdl(this, z);
        }
    }

    public CommitReceivedPmsgResIdl(Builder builder, boolean z) {
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
