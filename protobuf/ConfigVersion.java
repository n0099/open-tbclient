package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes4.dex */
public final class ConfigVersion extends Message {
    public static final String DEFAULT_PLUGIN = "";
    public static final String DEFAULT_SYNC = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)

    /* renamed from: plugin  reason: collision with root package name */
    public final String f6plugin;
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
            if (builder.f7plugin == null) {
                this.f6plugin = "";
                return;
            } else {
                this.f6plugin = builder.f7plugin;
                return;
            }
        }
        this.sync = builder.sync;
        this.f6plugin = builder.f7plugin;
    }

    /* loaded from: classes4.dex */
    public static final class Builder extends Message.Builder<ConfigVersion> {

        /* renamed from: plugin  reason: collision with root package name */
        public String f7plugin;
        public String sync;

        public Builder() {
        }

        public Builder(ConfigVersion configVersion) {
            super(configVersion);
            if (configVersion != null) {
                this.sync = configVersion.sync;
                this.f7plugin = configVersion.f6plugin;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ConfigVersion build(boolean z) {
            return new ConfigVersion(this, z);
        }
    }
}
