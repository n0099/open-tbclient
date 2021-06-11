package plugin.writeSettings;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
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
    @ProtoField(tag = 25, type = Message.Datatype.STRING)
    public final String ext;
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
    @ProtoField(tag = 24, type = Message.Datatype.STRING)
    public final String replaceMethodClasses;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String requireLoad;
    @ProtoField(tag = 26, type = Message.Datatype.UINT32)
    public final int rollback;
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

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<Plugin_setting> {
        public String abandon_apk_path;
        public String apk_path;
        public String cmd_range;
        public String display_name;
        public Integer enable;
        public String ext;
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
        public String replaceMethodClasses;
        public String requireLoad;
        public Integer rollback;
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
            if (plugin_setting == null) {
                return;
            }
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
            this.replaceMethodClasses = plugin_setting.replaceMethodClasses;
            this.ext = plugin_setting.ext;
            this.rollback = Integer.valueOf(plugin_setting.rollback);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Plugin_setting build(boolean z) {
            return new Plugin_setting(this, z);
        }
    }

    public Plugin_setting(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.package_name;
            if (str == null) {
                this.package_name = "";
            } else {
                this.package_name = str;
            }
            String str2 = builder.display_name;
            if (str2 == null) {
                this.display_name = "";
            } else {
                this.display_name = str2;
            }
            String str3 = builder.apk_path;
            if (str3 == null) {
                this.apk_path = "";
            } else {
                this.apk_path = str3;
            }
            String str4 = builder.version;
            if (str4 == null) {
                this.version = "";
            } else {
                this.version = str4;
            }
            Integer num = builder.enable;
            if (num == null) {
                this.enable = DEFAULT_ENABLE;
            } else {
                this.enable = num;
            }
            Integer num2 = builder.forbidden;
            if (num2 == null) {
                this.forbidden = DEFAULT_FORBIDDEN;
            } else {
                this.forbidden = num2;
            }
            String str5 = builder.md5;
            if (str5 == null) {
                this.md5 = "";
            } else {
                this.md5 = str5;
            }
            Integer num3 = builder.size;
            if (num3 == null) {
                this.size = DEFAULT_SIZE;
            } else {
                this.size = num3;
            }
            Integer num4 = builder.install_status;
            if (num4 == null) {
                this.install_status = DEFAULT_INSTALL_STATUS;
            } else {
                this.install_status = num4;
            }
            Integer num5 = builder.temp_version_code;
            if (num5 == null) {
                this.temp_version_code = DEFAULT_TEMP_VERSION_CODE;
            } else {
                this.temp_version_code = num5;
            }
            String str6 = builder.temp_md5;
            if (str6 == null) {
                this.temp_md5 = "";
            } else {
                this.temp_md5 = str6;
            }
            String str7 = builder.url;
            if (str7 == null) {
                this.url = "";
            } else {
                this.url = str7;
            }
            String str8 = builder.requireLoad;
            if (str8 == null) {
                this.requireLoad = "";
            } else {
                this.requireLoad = str8;
            }
            String str9 = builder.cmd_range;
            if (str9 == null) {
                this.cmd_range = "";
            } else {
                this.cmd_range = str9;
            }
            Integer num6 = builder.version_code;
            if (num6 == null) {
                this.version_code = DEFAULT_VERSION_CODE;
            } else {
                this.version_code = num6;
            }
            Integer num7 = builder.is_inject_classloader;
            if (num7 == null) {
                this.is_inject_classloader = DEFAULT_IS_INJECT_CLASSLOADER;
            } else {
                this.is_inject_classloader = num7;
            }
            String str10 = builder.abandon_apk_path;
            if (str10 == null) {
                this.abandon_apk_path = "";
            } else {
                this.abandon_apk_path = str10;
            }
            Integer num8 = builder.install_fail_count;
            if (num8 == null) {
                this.install_fail_count = DEFAULT_INSTALL_FAIL_COUNT;
            } else {
                this.install_fail_count = num8;
            }
            Integer num9 = builder.priority;
            if (num9 == null) {
                this.priority = DEFAULT_PRIORITY;
            } else {
                this.priority = num9;
            }
            Integer num10 = builder.has_res;
            if (num10 == null) {
                this.has_res = DEFAULT_HAS_RES;
            } else {
                this.has_res = num10;
            }
            Integer num11 = builder.is_third;
            if (num11 == null) {
                this.is_third = DEFAULT_IS_THIRD;
            } else {
                this.is_third = num11;
            }
            Integer num12 = builder.load_priority;
            if (num12 == null) {
                this.load_priority = DEFAULT_LOAD_PRIORITY;
            } else {
                this.load_priority = num12;
            }
            Integer num13 = builder.is_Patch;
            if (num13 == null) {
                this.is_Patch = DEFAULT_IS_PATCH;
            } else {
                this.is_Patch = num13;
            }
            this.replaceMethodClasses = builder.replaceMethodClasses;
            this.ext = builder.ext;
            Integer num14 = builder.rollback;
            if (num14 == null) {
                this.rollback = -1;
                return;
            } else {
                this.rollback = num14.intValue();
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
        this.replaceMethodClasses = builder.replaceMethodClasses;
        this.ext = builder.ext;
        this.rollback = builder.rollback.intValue();
    }
}
