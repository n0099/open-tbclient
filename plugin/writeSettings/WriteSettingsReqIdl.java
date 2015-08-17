package plugin.writeSettings;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class WriteSettingsReqIdl extends Message {
    @ProtoField(tag = 1)
    public final ReqData data;

    /* synthetic */ WriteSettingsReqIdl(Builder builder, boolean z, WriteSettingsReqIdl writeSettingsReqIdl) {
        this(builder, z);
    }

    private WriteSettingsReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<WriteSettingsReqIdl> {
        public ReqData data;

        public Builder() {
        }

        public Builder(WriteSettingsReqIdl writeSettingsReqIdl) {
            super(writeSettingsReqIdl);
            if (writeSettingsReqIdl != null) {
                this.data = writeSettingsReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public WriteSettingsReqIdl build(boolean z) {
            return new WriteSettingsReqIdl(this, z, null);
        }
    }
}
