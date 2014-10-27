package plugin.writeSettings;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class ReqData extends Message {
    public static final String DEFAULT_CONTAINER_VERSION = "";
    public static final List<Plugin_setting> DEFAULT_PLUGIN_SETTINGS_LIST = Collections.emptyList();
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String container_version;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<Plugin_setting> plugin_settings_list;

    /* synthetic */ ReqData(Builder builder, boolean z, ReqData reqData) {
        this(builder, z);
    }

    private ReqData(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.plugin_settings_list == null) {
                this.plugin_settings_list = DEFAULT_PLUGIN_SETTINGS_LIST;
            } else {
                this.plugin_settings_list = immutableCopyOf(builder.plugin_settings_list);
            }
            if (builder.container_version == null) {
                this.container_version = "";
                return;
            } else {
                this.container_version = builder.container_version;
                return;
            }
        }
        this.plugin_settings_list = immutableCopyOf(builder.plugin_settings_list);
        this.container_version = builder.container_version;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<ReqData> {
        public String container_version;
        public List<Plugin_setting> plugin_settings_list;

        public Builder(ReqData reqData) {
            super(reqData);
            if (reqData != null) {
                this.plugin_settings_list = ReqData.copyOf(reqData.plugin_settings_list);
                this.container_version = reqData.container_version;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ReqData build(boolean z) {
            return new ReqData(this, z, null);
        }
    }
}
