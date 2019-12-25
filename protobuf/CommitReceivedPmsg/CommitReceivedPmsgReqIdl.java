package protobuf.CommitReceivedPmsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes6.dex */
public final class CommitReceivedPmsgReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private CommitReceivedPmsgReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Builder extends Message.Builder<CommitReceivedPmsgReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(CommitReceivedPmsgReqIdl commitReceivedPmsgReqIdl) {
            super(commitReceivedPmsgReqIdl);
            if (commitReceivedPmsgReqIdl != null) {
                this.data = commitReceivedPmsgReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CommitReceivedPmsgReqIdl build(boolean z) {
            return new CommitReceivedPmsgReqIdl(this, z);
        }
    }
}
