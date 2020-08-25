package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes16.dex */
public final class ConfigVersion extends Message {
    public static final String DEFAULT_PLUGIN = "";
    public static final String DEFAULT_SYNC = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)

    /* renamed from: plugin  reason: collision with root package name */
    public final String f998plugin;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String sync;

    private ConfigVersion(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.sync == null) {
                this.sync = "";
            } else {
                this.sync = builder.sync;
            }
            if (builder.f999plugin == null) {
                this.f998plugin = "";
                return;
            } else {
                this.f998plugin = builder.f999plugin;
                return;
            }
        }
        this.sync = builder.sync;
        this.f998plugin = builder.f999plugin;
    }

    /* loaded from: classes16.dex */
    public static final class Builder extends Message.Builder<ConfigVersion> {

        /* renamed from: plugin  reason: collision with root package name */
        public String f999plugin;
        public String sync;

        public Builder() {
        }

        public Builder(ConfigVersion configVersion) {
            super(configVersion);
            if (configVersion != null) {
                this.sync = configVersion.sync;
                this.f999plugin = configVersion.f998plugin;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ConfigVersion build(boolean z) {
            return new ConfigVersion(this, z);
        }
    }
}
