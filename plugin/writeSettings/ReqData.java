package plugin.writeSettings;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public final class ReqData extends Message {
    public static final String DEFAULT_CONTAINER_VERSION = "";
    public static final String DEFAULT_FORBIDDEN_FEATURE = "";
    public static final List<Plugin_setting> DEFAULT_PLUGIN_SETTINGS_LIST = Collections.emptyList();
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String container_version;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String forbidden_feature;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<Plugin_setting> plugin_settings_list;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<ReqData> {
        public String container_version;
        public String forbidden_feature;
        public List<Plugin_setting> plugin_settings_list;

        public Builder() {
        }

        public Builder(ReqData reqData) {
            super(reqData);
            if (reqData == null) {
                return;
            }
            this.plugin_settings_list = Message.copyOf(reqData.plugin_settings_list);
            this.container_version = reqData.container_version;
            this.forbidden_feature = reqData.forbidden_feature;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ReqData build(boolean z) {
            return new ReqData(this, z);
        }
    }

    public ReqData(Builder builder, boolean z) {
        super(builder);
        if (z) {
            List<Plugin_setting> list = builder.plugin_settings_list;
            if (list == null) {
                this.plugin_settings_list = DEFAULT_PLUGIN_SETTINGS_LIST;
            } else {
                this.plugin_settings_list = Message.immutableCopyOf(list);
            }
            String str = builder.container_version;
            if (str == null) {
                this.container_version = "";
            } else {
                this.container_version = str;
            }
            String str2 = builder.forbidden_feature;
            if (str2 == null) {
                this.forbidden_feature = "";
                return;
            } else {
                this.forbidden_feature = str2;
                return;
            }
        }
        this.plugin_settings_list = Message.immutableCopyOf(builder.plugin_settings_list);
        this.container_version = builder.container_version;
        this.forbidden_feature = builder.forbidden_feature;
    }
}
