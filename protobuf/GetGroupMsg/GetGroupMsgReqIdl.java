package protobuf.GetGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class GetGroupMsgReqIdl extends Message {
    public static final String DEFAULT_CUID = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String cuid;
    @ProtoField(tag = 2)
    public final DataReq data;

    /* synthetic */ GetGroupMsgReqIdl(Builder builder, boolean z, GetGroupMsgReqIdl getGroupMsgReqIdl) {
        this(builder, z);
    }

    private GetGroupMsgReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.cuid == null) {
                this.cuid = "";
            } else {
                this.cuid = builder.cuid;
            }
            this.data = builder.data;
            return;
        }
        this.cuid = builder.cuid;
        this.data = builder.data;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<GetGroupMsgReqIdl> {
        public String cuid;
        public DataReq data;

        public Builder() {
        }

        public Builder(GetGroupMsgReqIdl getGroupMsgReqIdl) {
            super(getGroupMsgReqIdl);
            if (getGroupMsgReqIdl != null) {
                this.cuid = getGroupMsgReqIdl.cuid;
                this.data = getGroupMsgReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetGroupMsgReqIdl build(boolean z) {
            return new GetGroupMsgReqIdl(this, z, null);
        }
    }
}
