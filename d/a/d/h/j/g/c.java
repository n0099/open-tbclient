package d.a.d.h.j.g;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final BdUniqueId f42240e;

    /* renamed from: f  reason: collision with root package name */
    public static final BdAsyncTaskParallel f42241f;

    /* renamed from: g  reason: collision with root package name */
    public static c f42242g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f42243a;

    /* renamed from: b  reason: collision with root package name */
    public PluginSettings f42244b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42245c;

    /* renamed from: d  reason: collision with root package name */
    public f f42246d;

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public PluginSettings f42247a;

        /* renamed from: b  reason: collision with root package name */
        public e f42248b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f42249c;

        public a(c cVar, PluginSettings pluginSettings, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, pluginSettings, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42249c = cVar;
            this.f42247a = pluginSettings;
            this.f42248b = eVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel();
                e eVar = this.f42248b;
                if (eVar != null) {
                    eVar.a();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                PluginSettings pluginSettings = this.f42247a;
                if (pluginSettings != null && pluginSettings.getPlugins() != null) {
                    ReqData.Builder builder = new ReqData.Builder();
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, PluginSetting> entry : this.f42247a.getPlugins().entrySet()) {
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
                    builder.container_version = this.f42247a.getContainerVersion();
                    builder.forbidden_feature = this.f42247a.getForbiddenFeatures();
                    WriteSettingsReqIdl.Builder builder3 = new WriteSettingsReqIdl.Builder();
                    try {
                        builder3.data = builder.build(false);
                        return Boolean.valueOf(this.f42249c.i(this.f42249c.c(), builder3.build(false).toByteArray()));
                    } catch (Throwable th) {
                        d.a.d.h.h.a.b().g("plugin_settings_write_error");
                        d.a.d.h.h.a.b().o("plugin_setting", "settings_write_error", null, th.getMessage());
                        return Boolean.FALSE;
                    }
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((a) bool);
                if (this.f42248b != null) {
                    if (bool != null && bool.booleanValue()) {
                        this.f42248b.b();
                    } else {
                        this.f42248b.a();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(952645564, "Ld/a/d/h/j/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(952645564, "Ld/a/d/h/j/g/c;");
                return;
            }
        }
        f42240e = BdUniqueId.gen();
        f42241f = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, f42240e);
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42244b = new PluginSettings();
    }

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f42242g == null) {
                synchronized (c.class) {
                    if (f42242g == null) {
                        f42242g = new c();
                    }
                }
            }
            return f42242g;
        }
        return (c) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Util.m() == null) {
                return null;
            }
            return Util.m().getAbsoluteFile() + File.separator + "plugin_settings";
        }
        return (String) invokeV.objValue;
    }

    public PluginSettings d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f42244b : (PluginSettings) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0145, code lost:
        r1 = "res_is_null";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final PluginSettings e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Wire wire = new Wire(new Class[0]);
            try {
                byte[] f2 = f(b().c());
                if (f2 == null) {
                    d.a.d.h.h.b.e("PluginSettingIOManager_read0", "data_is_null");
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
                d.a.d.h.h.b.e("PluginSettingIOManager_read0", str);
                return null;
            } catch (Throwable th) {
                d.a.d.h.h.b.e("PluginSettingIOManager_read0", "exception_" + th.getMessage());
                d.a.d.h.h.a.b().g("plugin_settings_read_error");
                d.a.d.h.h.a.b().o("plugin_setting", "settings_read_error", null, th.getMessage());
                th.printStackTrace();
                return null;
            }
        }
        return (PluginSettings) invokeV.objValue;
    }

    public final byte[] f(String str) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, str)) != null) {
            return (byte[]) invokeL.objValue;
        }
        FileInputStream fileInputStream = null;
        if (TextUtils.isEmpty(str)) {
            d.a.d.h.h.b.e("PluginSettingIOManager_read1", "path_is_null");
            return null;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                d.a.d.h.h.b.e("PluginSettingIOManager_read1", "file_is_null");
                d.a.d.e.m.a.c(null);
                d.a.d.e.m.a.d(null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(1024);
            } catch (Exception e2) {
                fileInputStream = fileInputStream2;
                e = e2;
                byteArrayOutputStream = null;
            } catch (Throwable th) {
                fileInputStream = fileInputStream2;
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr, 0, 1024);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        d.a.d.e.m.a.c(fileInputStream2);
                        d.a.d.e.m.a.d(byteArrayOutputStream);
                        return byteArray;
                    }
                }
            } catch (Exception e3) {
                fileInputStream = fileInputStream2;
                e = e3;
                try {
                    BdLog.e(e.getMessage());
                    throw new RuntimeException(e);
                } catch (Throwable th2) {
                    th = th2;
                    d.a.d.e.m.a.c(fileInputStream);
                    d.a.d.e.m.a.d(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                fileInputStream = fileInputStream2;
                th = th3;
                d.a.d.e.m.a.c(fileInputStream);
                d.a.d.e.m.a.d(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(f fVar) {
        boolean z;
        PluginSettings e2;
        f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) || this.f42245c) {
            return;
        }
        this.f42246d = fVar;
        try {
        } catch (Exception e3) {
            e = e3;
        }
        try {
            z = new File(c()).exists();
        } catch (Exception e4) {
            e = e4;
            d.a.d.h.h.b.e("PluginSettingIOManager_readSettings", "path_" + ((String) null) + "-exception_" + e.getMessage());
            z = true;
            this.f42245c = true;
            e2 = e();
            this.f42245c = false;
            if (e2 == null) {
            }
            fVar2 = this.f42246d;
            if (fVar2 == null) {
            }
        }
        this.f42245c = true;
        e2 = e();
        this.f42245c = false;
        if (e2 == null) {
            this.f42244b = e2;
        } else {
            this.f42245c = true;
            e2 = e();
            this.f42245c = false;
            if (e2 != null) {
                this.f42244b = e2;
            } else {
                d.a.d.h.h.b.e("PluginSettingIOManager_readSettings", "isExist_" + z + "-PluginSettings_is_null");
                if (z) {
                    d.a.d.h.h.a.b().g(PluginPackageManager.O().c0() ? "plugin_setting_read_null_main" : "plugin_setting_read_null");
                    d.a.d.h.h.a.b().o("plugin_setting", "setting_read_null", null, null);
                }
            }
        }
        fVar2 = this.f42246d;
        if (fVar2 == null) {
            fVar2.a(e2);
            this.f42246d = null;
        }
    }

    public void h(PluginSettings pluginSettings, e eVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, pluginSettings, eVar) == null) || pluginSettings == null) {
            return;
        }
        this.f42244b = pluginSettings;
        if (this.f42245c && (fVar = this.f42246d) != null) {
            fVar.a(pluginSettings);
            this.f42246d = null;
            this.f42245c = false;
        }
        a aVar = this.f42243a;
        if (aVar != null) {
            aVar.cancel();
            this.f42243a = null;
        }
        if (TextUtils.isEmpty(pluginSettings.getContainerVersion())) {
            pluginSettings.setContainerSetting("");
        }
        a aVar2 = new a(this, pluginSettings, eVar);
        this.f42243a = aVar2;
        aVar2.setParallel(f42241f);
        this.f42243a.execute(new String[0]);
    }

    public final boolean i(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048582, this, str, bArr)) != null) {
            return invokeLL.booleanValue;
        }
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
                    d.a.d.e.m.a.d(null);
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
                        d.a.d.e.m.a.d(fileOutputStream);
                        throw th;
                    }
                }
                fileOutputStream2.flush();
                d.a.d.e.m.a.d(fileOutputStream2);
                return true;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
