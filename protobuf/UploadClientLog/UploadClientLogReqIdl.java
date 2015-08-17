package protobuf.UploadClientLog;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class UploadClientLogReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ UploadClientLogReqIdl(Builder builder, boolean z, UploadClientLogReqIdl uploadClientLogReqIdl) {
        this(builder, z);
    }

    private UploadClientLogReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<UploadClientLogReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(UploadClientLogReqIdl uploadClientLogReqIdl) {
            super(uploadClientLogReqIdl);
            if (uploadClientLogReqIdl != null) {
                this.data = uploadClientLogReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UploadClientLogReqIdl build(boolean z) {
            return new UploadClientLogReqIdl(this, z, null);
        }
    }
}
