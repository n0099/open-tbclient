package protobuf.DelGroupMsgs;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DelGroupMsgsReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ DelGroupMsgsReqIdl(Builder builder, boolean z, DelGroupMsgsReqIdl delGroupMsgsReqIdl) {
        this(builder, z);
    }

    private DelGroupMsgsReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DelGroupMsgsReqIdl> {
        public DataReq data;

        public Builder(DelGroupMsgsReqIdl delGroupMsgsReqIdl) {
            super(delGroupMsgsReqIdl);
            if (delGroupMsgsReqIdl != null) {
                this.data = delGroupMsgsReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DelGroupMsgsReqIdl build(boolean z) {
            return new DelGroupMsgsReqIdl(this, z, null);
        }
    }
}
