package plugin.writeSettings;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class Plugin_setting extends Message {
    public static final String DEFAULT_ABANDON_APK_PATH = "";
    public static final String DEFAULT_APK_PATH = "";
    public static final String DEFAULT_CMD_RANGE = "";
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final String DEFAULT_MD5 = "";
    public static final String DEFAULT_PACKAGE_NAME = "";
    public static final String DEFAULT_REQUIRELOAD = "";
    public static final String DEFAULT_TEMP_MD5 = "";
    public static final String DEFAULT_URL = "";
    public static final String DEFAULT_VERSION = "";
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String abandon_apk_path;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String apk_path;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String cmd_range;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String display_name;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer enable;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer forbidden;
    @ProtoField(tag = 20, type = Message.Datatype.UINT32)
    public final Integer has_res;
    @ProtoField(tag = 18, type = Message.Datatype.UINT32)
    public final Integer install_fail_count;
    @ProtoField(tag = 9, type = Message.Datatype.UINT32)
    public final Integer install_status;
    @ProtoField(tag = 23, type = Message.Datatype.UINT32)
    public final Integer is_Patch;
    @ProtoField(tag = 16, type = Message.Datatype.UINT32)
    public final Integer is_inject_classloader;
    @ProtoField(tag = 21, type = Message.Datatype.UINT32)
    public final Integer is_third;
    @ProtoField(tag = 22, type = Message.Datatype.UINT32)
    public final Integer load_priority;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String md5;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String package_name;
    @ProtoField(tag = 19, type = Message.Datatype.UINT32)
    public final Integer priority;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String requireLoad;
    @ProtoField(tag = 8, type = Message.Datatype.UINT32)
    public final Integer size;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String temp_md5;
    @ProtoField(tag = 10, type = Message.Datatype.UINT32)
    public final Integer temp_version_code;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String url;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String version;
    @ProtoField(tag = 15, type = Message.Datatype.UINT32)
    public final Integer version_code;
    public static final Integer DEFAULT_ENABLE = 0;
    public static final Integer DEFAULT_FORBIDDEN = 0;
    public static final Integer DEFAULT_SIZE = 0;
    public static final Integer DEFAULT_INSTALL_STATUS = 0;
    public static final Integer DEFAULT_TEMP_VERSION_CODE = 0;
    public static final Integer DEFAULT_VERSION_CODE = 0;
    public static final Integer DEFAULT_IS_INJECT_CLASSLOADER = 0;
    public static final Integer DEFAULT_INSTALL_FAIL_COUNT = 0;
    public static final Integer DEFAULT_PRIORITY = 1000;
    public static final Integer DEFAULT_HAS_RES = 0;
    public static final Integer DEFAULT_IS_THIRD = 0;
    public static final Integer DEFAULT_LOAD_PRIORITY = 1000;
    public static final Integer DEFAULT_IS_PATCH = 0;

    /* synthetic */ Plugin_setting(Builder builder, boolean z, Plugin_setting plugin_setting) {
        this(builder, z);
    }

    private Plugin_setting(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.package_name == null) {
                this.package_name = "";
            } else {
                this.package_name = builder.package_name;
            }
            if (builder.display_name == null) {
                this.display_name = "";
            } else {
                this.display_name = builder.display_name;
            }
            if (builder.apk_path == null) {
                this.apk_path = "";
            } else {
                this.apk_path = builder.apk_path;
            }
            if (builder.version == null) {
                this.version = "";
            } else {
                this.version = builder.version;
            }
            if (builder.enable == null) {
                this.enable = DEFAULT_ENABLE;
            } else {
                this.enable = builder.enable;
            }
            if (builder.forbidden == null) {
                this.forbidden = DEFAULT_FORBIDDEN;
            } else {
                this.forbidden = builder.forbidden;
            }
            if (builder.md5 == null) {
                this.md5 = "";
            } else {
                this.md5 = builder.md5;
            }
            if (builder.size == null) {
                this.size = DEFAULT_SIZE;
            } else {
                this.size = builder.size;
            }
            if (builder.install_status == null) {
                this.install_status = DEFAULT_INSTALL_STATUS;
            } else {
                this.install_status = builder.install_status;
            }
            if (builder.temp_version_code == null) {
                this.temp_version_code = DEFAULT_TEMP_VERSION_CODE;
            } else {
                this.temp_version_code = builder.temp_version_code;
            }
            if (builder.temp_md5 == null) {
                this.temp_md5 = "";
            } else {
                this.temp_md5 = builder.temp_md5;
            }
            if (builder.url == null) {
                this.url = "";
            } else {
                this.url = builder.url;
            }
            if (builder.requireLoad == null) {
                this.requireLoad = "";
            } else {
                this.requireLoad = builder.requireLoad;
            }
            if (builder.cmd_range == null) {
                this.cmd_range = "";
            } else {
                this.cmd_range = builder.cmd_range;
            }
            if (builder.version_code == null) {
                this.version_code = DEFAULT_VERSION_CODE;
            } else {
                this.version_code = builder.version_code;
            }
            if (builder.is_inject_classloader == null) {
                this.is_inject_classloader = DEFAULT_IS_INJECT_CLASSLOADER;
            } else {
                this.is_inject_classloader = builder.is_inject_classloader;
            }
            if (builder.abandon_apk_path == null) {
                this.abandon_apk_path = "";
            } else {
                this.abandon_apk_path = builder.abandon_apk_path;
            }
            if (builder.install_fail_count == null) {
                this.install_fail_count = DEFAULT_INSTALL_FAIL_COUNT;
            } else {
                this.install_fail_count = builder.install_fail_count;
            }
            if (builder.priority == null) {
                this.priority = DEFAULT_PRIORITY;
            } else {
                this.priority = builder.priority;
            }
            if (builder.has_res == null) {
                this.has_res = DEFAULT_HAS_RES;
            } else {
                this.has_res = builder.has_res;
            }
            if (builder.is_third == null) {
                this.is_third = DEFAULT_IS_THIRD;
            } else {
                this.is_third = builder.is_third;
            }
            if (builder.load_priority == null) {
                this.load_priority = DEFAULT_LOAD_PRIORITY;
            } else {
                this.load_priority = builder.load_priority;
            }
            if (builder.is_Patch == null) {
                this.is_Patch = DEFAULT_IS_PATCH;
                return;
            } else {
                this.is_Patch = builder.is_Patch;
                return;
            }
        }
        this.package_name = builder.package_name;
        this.display_name = builder.display_name;
        this.apk_path = builder.apk_path;
        this.version = builder.version;
        this.enable = builder.enable;
        this.forbidden = builder.forbidden;
        this.md5 = builder.md5;
        this.size = builder.size;
        this.install_status = builder.install_status;
        this.temp_version_code = builder.temp_version_code;
        this.temp_md5 = builder.temp_md5;
        this.url = builder.url;
        this.requireLoad = builder.requireLoad;
        this.cmd_range = builder.cmd_range;
        this.version_code = builder.version_code;
        this.is_inject_classloader = builder.is_inject_classloader;
        this.abandon_apk_path = builder.abandon_apk_path;
        this.install_fail_count = builder.install_fail_count;
        this.priority = builder.priority;
        this.has_res = builder.has_res;
        this.is_third = builder.is_third;
        this.load_priority = builder.load_priority;
        this.is_Patch = builder.is_Patch;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<Plugin_setting> {
        public String abandon_apk_path;
        public String apk_path;
        public String cmd_range;
        public String display_name;
        public Integer enable;
        public Integer forbidden;
        public Integer has_res;
        public Integer install_fail_count;
        public Integer install_status;
        public Integer is_Patch;
        public Integer is_inject_classloader;
        public Integer is_third;
        public Integer load_priority;
        public String md5;
        public String package_name;
        public Integer priority;
        public String requireLoad;
        public Integer size;
        public String temp_md5;
        public Integer temp_version_code;
        public String url;
        public String version;
        public Integer version_code;

        public Builder() {
        }

        public Builder(Plugin_setting plugin_setting) {
            super(plugin_setting);
            if (plugin_setting != null) {
                this.package_name = plugin_setting.package_name;
                this.display_name = plugin_setting.display_name;
                this.apk_path = plugin_setting.apk_path;
                this.version = plugin_setting.version;
                this.enable = plugin_setting.enable;
                this.forbidden = plugin_setting.forbidden;
                this.md5 = plugin_setting.md5;
                this.size = plugin_setting.size;
                this.install_status = plugin_setting.install_status;
                this.temp_version_code = plugin_setting.temp_version_code;
                this.temp_md5 = plugin_setting.temp_md5;
                this.url = plugin_setting.url;
                this.requireLoad = plugin_setting.requireLoad;
                this.cmd_range = plugin_setting.cmd_range;
                this.version_code = plugin_setting.version_code;
                this.is_inject_classloader = plugin_setting.is_inject_classloader;
                this.abandon_apk_path = plugin_setting.abandon_apk_path;
                this.install_fail_count = plugin_setting.install_fail_count;
                this.priority = plugin_setting.priority;
                this.has_res = plugin_setting.has_res;
                this.is_third = plugin_setting.is_third;
                this.load_priority = plugin_setting.load_priority;
                this.is_Patch = plugin_setting.is_Patch;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Plugin_setting build(boolean z) {
            return new Plugin_setting(this, z, null);
        }
    }
}
