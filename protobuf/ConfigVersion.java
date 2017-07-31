package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class ConfigVersion extends Message {
    public static final String DEFAULT_PLUGIN = "";
    public static final String DEFAULT_SYNC = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)

    /* renamed from: plugin  reason: collision with root package name */
    public final String f8plugin;
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
            if (builder.f9plugin == null) {
                this.f8plugin = "";
                return;
            } else {
                this.f8plugin = builder.f9plugin;
                return;
            }
        }
        this.sync = builder.sync;
        this.f8plugin = builder.f9plugin;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<ConfigVersion> {

        /* renamed from: plugin  reason: collision with root package name */
        public String f9plugin;
        public String sync;

        public Builder() {
        }

        public Builder(ConfigVersion configVersion) {
            super(configVersion);
            if (configVersion != null) {
                this.sync = configVersion.sync;
                this.f9plugin = configVersion.f8plugin;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ConfigVersion build(boolean z) {
            return new ConfigVersion(this, z);
        }
    }
}
