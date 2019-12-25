package protobuf.CommitPusherCount;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes6.dex */
public final class CommitPusherCountReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private CommitPusherCountReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Builder extends Message.Builder<CommitPusherCountReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(CommitPusherCountReqIdl commitPusherCountReqIdl) {
            super(commitPusherCountReqIdl);
            if (commitPusherCountReqIdl != null) {
                this.data = commitPusherCountReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CommitPusherCountReqIdl build(boolean z) {
            return new CommitPusherCountReqIdl(this, z);
        }
    }
}
