package d.a.c.h.j.g;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.squareup.wire.Wire;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import plugin.writeSettings.Plugin_setting;
import plugin.writeSettings.ReqData;
import plugin.writeSettings.WriteSettingsReqIdl;
/* loaded from: classes.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final BdUniqueId f39491e = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public static final BdAsyncTaskParallel f39492f = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, f39491e);

    /* renamed from: g  reason: collision with root package name */
    public static c f39493g;

    /* renamed from: a  reason: collision with root package name */
    public a f39494a;

    /* renamed from: b  reason: collision with root package name */
    public PluginSettings f39495b = new PluginSettings();

    /* renamed from: c  reason: collision with root package name */
    public boolean f39496c;

    /* renamed from: d  reason: collision with root package name */
    public f f39497d;

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public PluginSettings f39498a;

        /* renamed from: b  reason: collision with root package name */
        public e f39499b;

        public a(PluginSettings pluginSettings, e eVar) {
            this.f39498a = pluginSettings;
            this.f39499b = eVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            e eVar = this.f39499b;
            if (eVar != null) {
                eVar.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            PluginSettings pluginSettings = this.f39498a;
            if (pluginSettings != null && pluginSettings.getPlugins() != null) {
                ReqData.Builder builder = new ReqData.Builder();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, PluginSetting> entry : this.f39498a.getPlugins().entrySet()) {
                    PluginSetting value = entry.getValue();
                    if (value != null) {
                        Plugin_setting.Builder builder2 = new Plugin_setting.Builder();
                        builder2.apk_path = value.apkPath;
                        builder2.cmd_range = value.getCmdRange();
                        builder2.display_name = value.displayName;
                        if (value.enable) {
                            builder2.enable = 0;
                        } else {
                            builder2.enable = 1;
                        }
                        if (value.forbidden) {
                            builder2.forbidden = 1;
                        } else {
                            builder2.forbidden = 0;
                        }
                        builder2.install_status = Integer.valueOf(value.installStatus);
                        builder2.md5 = value.md5;
                        builder2.package_name = value.packageName;
                        builder2.requireLoad = value.requireLoad;
                        builder2.size = Integer.valueOf(value.size);
                        builder2.temp_md5 = value.tempMd5;
                        builder2.temp_version_code = Integer.valueOf(value.tempVersionCode);
                        builder2.url = value.url;
                        builder2.version = value.version;
                        builder2.version_code = Integer.valueOf(value.versionCode);
                        builder2.is_inject_classloader = Integer.valueOf(value.isInjectClassloader() ? 1 : 0);
                        builder2.abandon_apk_path = value.getAbandon_apk_path();
                        builder2.install_fail_count = Integer.valueOf(value.install_fail_count);
                        builder2.priority = Integer.valueOf(value.priority);
                        builder2.has_res = Integer.valueOf(value.hasRes ? 1 : 0);
                        builder2.is_third = Integer.valueOf(value.isThird ? 1 : 0);
                        builder2.is_Patch = Integer.valueOf(value.isPatch ? 1 : 0);
                        builder2.load_priority = Integer.valueOf(value.load_priority);
                        builder2.replaceMethodClasses = value.replaceMethodClasses;
                        builder2.ext = value.ext;
                        builder2.rollback = Integer.valueOf(value.rollback);
                        arrayList.add(builder2.build(false));
                    }
                }
                builder.plugin_settings_list = arrayList;
                builder.container_version = this.f39498a.getContainerVersion();
                builder.forbidden_feature = this.f39498a.getForbiddenFeatures();
                WriteSettingsReqIdl.Builder builder3 = new WriteSettingsReqIdl.Builder();
                try {
                    builder3.data = builder.build(false);
                    return Boolean.valueOf(c.this.i(c.this.c(), builder3.build(false).toByteArray()));
                } catch (Throwable th) {
                    d.a.c.h.h.a.b().g("plugin_settings_write_error");
                    d.a.c.h.h.a.b().o("plugin_setting", "settings_write_error", null, th.getMessage());
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            if (this.f39499b != null) {
                if (bool != null && bool.booleanValue()) {
                    this.f39499b.b();
                } else {
                    this.f39499b.a();
                }
            }
        }
    }

    public static c b() {
        if (f39493g == null) {
            synchronized (c.class) {
                if (f39493g == null) {
                    f39493g = new c();
                }
            }
        }
        return f39493g;
    }

    public String c() {
        if (Util.m() == null) {
            return null;
        }
        return Util.m().getAbsoluteFile() + File.separator + "plugin_settings";
    }

    public PluginSettings d() {
        return this.f39495b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0141, code lost:
        r1 = "res_is_null";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final PluginSettings e() {
        Wire wire = new Wire(new Class[0]);
        try {
            byte[] f2 = f(b().c());
            if (f2 == null) {
                d.a.c.h.h.b.e("PluginSettingIOManager_read0", "data_is_null");
                return null;
            }
            WriteSettingsReqIdl writeSettingsReqIdl = (WriteSettingsReqIdl) wire.parseFrom(f2, WriteSettingsReqIdl.class);
            if (writeSettingsReqIdl != null && writeSettingsReqIdl.data != null) {
                PluginSettings pluginSettings = new PluginSettings();
                if (writeSettingsReqIdl.data.container_version != null) {
                    pluginSettings.setContainerSetting(writeSettingsReqIdl.data.container_version);
                }
                if (writeSettingsReqIdl.data.forbidden_feature != null) {
                    pluginSettings.setForbiddenFeatures(writeSettingsReqIdl.data.forbidden_feature);
                }
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                pluginSettings.setPlugins(concurrentHashMap);
                if (writeSettingsReqIdl.data.plugin_settings_list != null) {
                    for (Plugin_setting plugin_setting : writeSettingsReqIdl.data.plugin_settings_list) {
                        if (plugin_setting != null) {
                            PluginSetting pluginSetting = new PluginSetting();
                            pluginSetting.apkPath = plugin_setting.apk_path;
                            pluginSetting.setCmdRange(plugin_setting.cmd_range);
                            pluginSetting.displayName = plugin_setting.display_name;
                            if (plugin_setting.enable.intValue() == 0) {
                                pluginSetting.enable = true;
                            } else {
                                pluginSetting.enable = false;
                            }
                            if (plugin_setting.forbidden.intValue() == 1) {
                                pluginSetting.forbidden = true;
                            } else {
                                pluginSetting.forbidden = false;
                            }
                            pluginSetting.installStatus = plugin_setting.install_status.intValue();
                            pluginSetting.md5 = plugin_setting.md5;
                            pluginSetting.packageName = plugin_setting.package_name;
                            pluginSetting.requireLoad = plugin_setting.requireLoad;
                            pluginSetting.size = plugin_setting.size.intValue();
                            pluginSetting.tempMd5 = plugin_setting.temp_md5;
                            pluginSetting.tempVersionCode = plugin_setting.temp_version_code.intValue();
                            pluginSetting.url = plugin_setting.url;
                            pluginSetting.version = plugin_setting.version;
                            pluginSetting.versionCode = plugin_setting.version_code.intValue();
                            pluginSetting.setInjectClassloader(plugin_setting.is_inject_classloader.intValue() != 0);
                            pluginSetting.setAbandon_apk_path(plugin_setting.abandon_apk_path);
                            pluginSetting.install_fail_count = plugin_setting.install_fail_count.intValue();
                            pluginSetting.priority = plugin_setting.priority.intValue();
                            pluginSetting.hasRes = plugin_setting.has_res.intValue() == 1;
                            pluginSetting.isThird = plugin_setting.is_third.intValue() == 1;
                            pluginSetting.load_priority = plugin_setting.load_priority.intValue();
                            boolean z = plugin_setting.is_Patch.intValue() == 1;
                            pluginSetting.isPatch = z;
                            pluginSetting.replaceMethodClasses = plugin_setting.replaceMethodClasses;
                            pluginSetting.ext = plugin_setting.ext;
                            if (z) {
                                pluginSettings.setPatch(true);
                            }
                            concurrentHashMap.put(pluginSetting.packageName, pluginSetting);
                        }
                    }
                }
                return pluginSettings;
            }
            String str = "res_data_is_null";
            d.a.c.h.h.b.e("PluginSettingIOManager_read0", str);
            return null;
        } catch (Throwable th) {
            d.a.c.h.h.b.e("PluginSettingIOManager_read0", "exception_" + th.getMessage());
            d.a.c.h.h.a.b().g("plugin_settings_read_error");
            d.a.c.h.h.a.b().o("plugin_setting", "settings_read_error", null, th.getMessage());
            th.printStackTrace();
            return null;
        }
    }

    public final byte[] f(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream = null;
        if (TextUtils.isEmpty(str)) {
            d.a.c.h.h.b.e("PluginSettingIOManager_read1", "path_is_null");
            return null;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                d.a.c.h.h.b.e("PluginSettingIOManager_read1", "file_is_null");
                d.a.c.e.m.a.c(null);
                d.a.c.e.m.a.d(null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(1024);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr, 0, 1024);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            d.a.c.e.m.a.c(fileInputStream2);
                            d.a.c.e.m.a.d(byteArrayOutputStream);
                            return byteArray;
                        }
                    }
                } catch (Exception e2) {
                    fileInputStream = fileInputStream2;
                    e = e2;
                    try {
                        BdLog.e(e.getMessage());
                        throw new RuntimeException(e);
                    } catch (Throwable th) {
                        th = th;
                        d.a.c.e.m.a.c(fileInputStream);
                        d.a.c.e.m.a.d(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    fileInputStream = fileInputStream2;
                    th = th2;
                    d.a.c.e.m.a.c(fileInputStream);
                    d.a.c.e.m.a.d(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                fileInputStream = fileInputStream2;
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                fileInputStream = fileInputStream2;
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(f fVar) {
        boolean z;
        PluginSettings e2;
        f fVar2;
        if (this.f39496c) {
            return;
        }
        this.f39497d = fVar;
        try {
        } catch (Exception e3) {
            e = e3;
        }
        try {
            z = new File(c()).exists();
        } catch (Exception e4) {
            e = e4;
            d.a.c.h.h.b.e("PluginSettingIOManager_readSettings", "path_" + ((String) null) + "-exception_" + e.getMessage());
            z = true;
            this.f39496c = true;
            e2 = e();
            this.f39496c = false;
            if (e2 == null) {
            }
            fVar2 = this.f39497d;
            if (fVar2 == null) {
            }
        }
        this.f39496c = true;
        e2 = e();
        this.f39496c = false;
        if (e2 == null) {
            this.f39495b = e2;
        } else {
            this.f39496c = true;
            e2 = e();
            this.f39496c = false;
            if (e2 != null) {
                this.f39495b = e2;
            } else {
                d.a.c.h.h.b.e("PluginSettingIOManager_readSettings", "isExist_" + z + "-PluginSettings_is_null");
                if (z) {
                    d.a.c.h.h.a.b().g(PluginPackageManager.O().c0() ? "plugin_setting_read_null_main" : "plugin_setting_read_null");
                    d.a.c.h.h.a.b().o("plugin_setting", "setting_read_null", null, null);
                }
            }
        }
        fVar2 = this.f39497d;
        if (fVar2 == null) {
            fVar2.a(e2);
            this.f39497d = null;
        }
    }

    public void h(PluginSettings pluginSettings, e eVar) {
        f fVar;
        if (pluginSettings == null) {
            return;
        }
        this.f39495b = pluginSettings;
        if (this.f39496c && (fVar = this.f39497d) != null) {
            fVar.a(pluginSettings);
            this.f39497d = null;
            this.f39496c = false;
        }
        a aVar = this.f39494a;
        if (aVar != null) {
            aVar.cancel();
            this.f39494a = null;
        }
        if (TextUtils.isEmpty(pluginSettings.getContainerVersion())) {
            pluginSettings.setContainerSetting("");
        }
        a aVar2 = new a(pluginSettings, eVar);
        this.f39494a = aVar2;
        aVar2.setParallel(f39492f);
        this.f39494a.execute(new String[0]);
    }

    public final boolean i(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                if (bArr == null) {
                    d.a.c.e.m.a.d(null);
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                if (bArr != null) {
                    try {
                        fileOutputStream2.write(bArr);
                    } catch (Exception e2) {
                        fileOutputStream = fileOutputStream2;
                        e = e2;
                        BdLog.e(e.getMessage());
                        throw new RuntimeException(e);
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        d.a.c.e.m.a.d(fileOutputStream);
                        throw th;
                    }
                }
                fileOutputStream2.flush();
                d.a.c.e.m.a.d(fileOutputStream2);
                return true;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
