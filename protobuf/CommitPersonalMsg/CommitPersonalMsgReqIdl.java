package protobuf.CommitPersonalMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes22.dex */
public final class CommitPersonalMsgReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private CommitPersonalMsgReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes22.dex */
    public static final class Builder extends Message.Builder<CommitPersonalMsgReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(CommitPersonalMsgReqIdl commitPersonalMsgReqIdl) {
            super(commitPersonalMsgReqIdl);
            if (commitPersonalMsgReqIdl != null) {
                this.data = commitPersonalMsgReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CommitPersonalMsgReqIdl build(boolean z) {
            return new CommitPersonalMsgReqIdl(this, z);
        }
    }
}
