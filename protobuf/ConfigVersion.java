package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class ConfigVersion extends Message {
    public static final String DEFAULT_PLUGIN = "";
    public static final String DEFAULT_SYNC = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String plugin;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String sync;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<ConfigVersion> {
        public String plugin;
        public String sync;

        public Builder() {
        }

        public Builder(ConfigVersion configVersion) {
            super(configVersion);
            if (configVersion == null) {
                return;
            }
            this.sync = configVersion.sync;
            this.plugin = configVersion.plugin;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ConfigVersion build(boolean z) {
            return new ConfigVersion(this, z);
        }
    }

    public ConfigVersion(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.sync;
            if (str == null) {
                this.sync = "";
            } else {
                this.sync = str;
            }
            String str2 = builder.plugin;
            if (str2 == null) {
                this.plugin = "";
                return;
            } else {
                this.plugin = str2;
                return;
            }
        }
        this.sync = builder.sync;
        this.plugin = builder.plugin;
    }
}
