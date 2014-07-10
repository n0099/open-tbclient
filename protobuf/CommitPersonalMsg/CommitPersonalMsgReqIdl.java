package protobuf.CommitPersonalMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class CommitPersonalMsgReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ CommitPersonalMsgReqIdl(Builder builder, boolean z, CommitPersonalMsgReqIdl commitPersonalMsgReqIdl) {
        this(builder, z);
    }

    private CommitPersonalMsgReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<CommitPersonalMsgReqIdl> {
        public DataReq data;

        public Builder(CommitPersonalMsgReqIdl commitPersonalMsgReqIdl) {
            super(commitPersonalMsgReqIdl);
            if (commitPersonalMsgReqIdl != null) {
                this.data = commitPersonalMsgReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CommitPersonalMsgReqIdl build(boolean z) {
            return new CommitPersonalMsgReqIdl(this, z, null);
        }
    }
}
