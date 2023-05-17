package protobuf.UpdateClientInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class UpdateClientInfoReqIdl extends Message {
    public static final String DEFAULT_CUID = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String cuid;
    @ProtoField(tag = 2)
    public final DataReq data;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<UpdateClientInfoReqIdl> {
        public String cuid;
        public DataReq data;

        public Builder() {
        }

        public Builder(UpdateClientInfoReqIdl updateClientInfoReqIdl) {
            super(updateClientInfoReqIdl);
            if (updateClientInfoReqIdl == null) {
                return;
            }
            this.cuid = updateClientInfoReqIdl.cuid;
            this.data = updateClientInfoReqIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateClientInfoReqIdl build(boolean z) {
            return new UpdateClientInfoReqIdl(this, z);
        }
    }

    public UpdateClientInfoReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.cuid;
            if (str == null) {
                this.cuid = "";
            } else {
                this.cuid = str;
            }
            this.data = builder.data;
            return;
        }
        this.cuid = builder.cuid;
        this.data = builder.data;
    }
}
