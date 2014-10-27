package protobuf.UploadClientLog;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class UploadClientLogResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ UploadClientLogResIdl(Builder builder, boolean z, UploadClientLogResIdl uploadClientLogResIdl) {
        this(builder, z);
    }

    private UploadClientLogResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<UploadClientLogResIdl> {
        public DataRes data;
        public Error error;

        public Builder(UploadClientLogResIdl uploadClientLogResIdl) {
            super(uploadClientLogResIdl);
            if (uploadClientLogResIdl != null) {
                this.error = uploadClientLogResIdl.error;
                this.data = uploadClientLogResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UploadClientLogResIdl build(boolean z) {
            return new UploadClientLogResIdl(this, z, null);
        }
    }
}
