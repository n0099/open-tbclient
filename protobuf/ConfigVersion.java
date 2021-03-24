package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class ConfigVersion extends Message {
    public static final String DEFAULT_PLUGIN = "";
    public static final String DEFAULT_SYNC = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)

    /* renamed from: plugin  reason: collision with root package name */
    public final String f68132plugin;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String sync;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<ConfigVersion> {

        /* renamed from: plugin  reason: collision with root package name */
        public String f68133plugin;
        public String sync;

        public Builder() {
        }

        public Builder(ConfigVersion configVersion) {
            super(configVersion);
            if (configVersion == null) {
                return;
            }
            this.sync = configVersion.sync;
            this.f68133plugin = configVersion.f68132plugin;
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
            String str2 = builder.f68133plugin;
            if (str2 == null) {
                this.f68132plugin = "";
                return;
            } else {
                this.f68132plugin = str2;
                return;
            }
        }
        this.sync = builder.sync;
        this.f68132plugin = builder.f68133plugin;
    }
}
