package d.a.c.h.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import d.a.c.e.p.f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f39131d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f39132a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public a f39133b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39134c = false;

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Integer, Boolean> {
        public a() {
        }

        public final void b(ArrayList<File> arrayList) {
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            Iterator<File> it = arrayList.iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next != null) {
                    try {
                        f.p(next);
                        d.a.c.h.h.a.b().o("plugin_del_redundance", "delete_redundance", null, next.getAbsolutePath());
                    } catch (IOException e2) {
                        d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
                        b2.o("plugin_del_redundance", "delete_redundance_fail", null, next.getAbsolutePath() + "-" + e2.getMessage());
                    }
                }
            }
        }

        public final ArrayList<File> c() {
            File[] fileArr;
            String str;
            int i2;
            File[] fileArr2;
            int i3;
            String str2;
            int i4;
            int i5;
            PluginSettings l = d.a.c.h.j.g.d.k().l();
            if (l == null || l.getPlugins() == null || l.getPlugins().size() == 0) {
                return null;
            }
            File m = Util.m();
            if (m == null) {
                return null;
            }
            File[] listFiles = m.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            try {
                for (Map.Entry entry : b.this.f39132a.entrySet()) {
                    if (sb.length() > 0) {
                        sb.append("-");
                    }
                    sb.append((String) entry.getKey());
                }
            } catch (Throwable th) {
                sb.append(th.getMessage());
            }
            ArrayList<File> arrayList = new ArrayList<>();
            String c2 = d.a.c.h.j.g.c.b().c();
            int length = listFiles.length;
            int i6 = 0;
            while (i6 < length) {
                File file = listFiles[i6];
                if (file != null) {
                    String absolutePath = file.getAbsolutePath();
                    BdLog.i("ClearRedunceFiles file: " + file.getAbsolutePath());
                    String name = file.getName();
                    if (!absolutePath.equals(c2)) {
                        fileArr = listFiles;
                        if (!"plugin_settings".equals(file.getName()) && System.currentTimeMillis() - file.lastModified() >= 86400000) {
                            if (file.isDirectory()) {
                                if (name.equals("oat")) {
                                    File[] listFiles2 = file.listFiles();
                                    if (listFiles2.length > 0) {
                                        int length2 = listFiles2.length;
                                        int i7 = 0;
                                        while (i7 < length2) {
                                            File file2 = listFiles2[i7];
                                            if (file2.isDirectory()) {
                                                fileArr2 = listFiles2;
                                                String name2 = file2.getName();
                                                i3 = length2;
                                                if ("arm".equals(name2)) {
                                                    str2 = c2;
                                                    i4 = length;
                                                } else {
                                                    d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
                                                    str2 = c2;
                                                    StringBuilder sb4 = new StringBuilder();
                                                    i4 = length;
                                                    sb4.append("oatfile_");
                                                    sb4.append(name2);
                                                    b2.o("plugin_del_redundance", "delate_oat_debug", null, sb4.toString());
                                                }
                                                File[] listFiles3 = file2.listFiles();
                                                if (listFiles3.length > 0) {
                                                    int length3 = listFiles3.length;
                                                    int i8 = 0;
                                                    while (i8 < length3) {
                                                        File file3 = listFiles3[i8];
                                                        String name3 = file3.getName();
                                                        File[] fileArr3 = listFiles3;
                                                        if (name3.endsWith(".vdex") || name3.endsWith(".odex")) {
                                                            i5 = length3;
                                                            name3 = name3.substring(0, name3.length() - 5);
                                                        } else {
                                                            i5 = length3;
                                                        }
                                                        HashMap hashMap = b.this.f39132a;
                                                        if (hashMap.get(name3 + ".apk") == null) {
                                                            arrayList.add(file3);
                                                            if (sb3.length() < 10000) {
                                                                if (sb3.length() > 0) {
                                                                    sb3.append("-");
                                                                }
                                                                sb3.append(file3.getAbsolutePath());
                                                                sb3.append("-");
                                                                sb3.append("isarmfile_not_use");
                                                            }
                                                        }
                                                        i8++;
                                                        listFiles3 = fileArr3;
                                                        length3 = i5;
                                                    }
                                                }
                                            } else {
                                                fileArr2 = listFiles2;
                                                i3 = length2;
                                                str2 = c2;
                                                i4 = length;
                                                String name4 = file2.getName();
                                                if (name4.endsWith(".apk.cur.prof")) {
                                                    name4 = name4.substring(0, name4.length() - 13);
                                                }
                                                HashMap hashMap2 = b.this.f39132a;
                                                if (hashMap2.get(name4 + ".apk") == null) {
                                                    arrayList.add(file2);
                                                    if (sb3.length() < 10000) {
                                                        if (sb3.length() > 0) {
                                                            sb3.append("-");
                                                        }
                                                        sb3.append(file2.getAbsolutePath());
                                                        sb3.append("-");
                                                        sb3.append("isoatfile_not_use");
                                                    }
                                                }
                                            }
                                            i7++;
                                            listFiles2 = fileArr2;
                                            length2 = i3;
                                            c2 = str2;
                                            length = i4;
                                        }
                                    }
                                    str = c2;
                                    i2 = length;
                                } else {
                                    str = c2;
                                    i2 = length;
                                    if (!name.endsWith(".apk")) {
                                        HashMap hashMap3 = b.this.f39132a;
                                        if (hashMap3.get(name + ".apk") == null) {
                                            arrayList.add(file);
                                            if (sb3.length() < 10000) {
                                                if (sb3.length() > 0) {
                                                    sb3.append("-");
                                                }
                                                sb3.append(absolutePath);
                                                sb3.append("-");
                                                sb3.append("isdirectory_not_use");
                                            }
                                        }
                                    }
                                    if (sb2.length() < 10000) {
                                        if (sb2.length() > 0) {
                                            sb2.append("-");
                                        }
                                        sb2.append(absolutePath);
                                    }
                                }
                            } else {
                                str = c2;
                                i2 = length;
                                if (name.endsWith(".apk")) {
                                    if (b.this.f39132a.get(name) == null) {
                                        arrayList.add(file);
                                        if (sb3.length() < 10000) {
                                            if (sb3.length() > 0) {
                                                sb3.append("-");
                                            }
                                            sb3.append(absolutePath);
                                            sb3.append("-");
                                            sb3.append("isapk_not_use");
                                        }
                                    } else if (sb2.length() < 10000) {
                                        if (sb2.length() > 0) {
                                            sb2.append("-");
                                        }
                                        sb2.append(absolutePath);
                                    }
                                } else if (System.currentTimeMillis() - file.lastModified() > 259200000) {
                                    if (name.contains(".apk_") && b.this.f39132a.get(name) != null) {
                                        if (sb2.length() < 10000) {
                                            if (sb2.length() > 0) {
                                                sb2.append("-");
                                            }
                                            sb2.append(absolutePath);
                                        }
                                    } else {
                                        arrayList.add(file);
                                        if (sb3.length() < 10000) {
                                            if (sb3.length() > 0) {
                                                sb3.append("-");
                                            }
                                            sb3.append(absolutePath);
                                            sb3.append("-");
                                            sb3.append("not_use_timemax");
                                        }
                                    }
                                } else if (sb2.length() < 10000) {
                                    if (sb2.length() > 0) {
                                        sb2.append("-");
                                    }
                                    sb2.append(absolutePath);
                                }
                            }
                            i6++;
                            listFiles = fileArr;
                            c2 = str;
                            length = i2;
                        }
                        str = c2;
                        i2 = length;
                        i6++;
                        listFiles = fileArr;
                        c2 = str;
                        length = i2;
                    }
                }
                fileArr = listFiles;
                str = c2;
                i2 = length;
                i6++;
                listFiles = fileArr;
                c2 = str;
                length = i2;
            }
            if (arrayList.size() > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("loadcount");
                sb5.append("-");
                ArrayList<Plugin> allPlugins = PluginCenter.getInstance().getAllPlugins();
                sb5.append(allPlugins == null ? 0 : allPlugins.size());
                if (allPlugins != null && allPlugins.size() > 0) {
                    Iterator<Plugin> it = allPlugins.iterator();
                    while (it.hasNext()) {
                        Plugin next = it.next();
                        if (next != null) {
                            sb5.append("-");
                            sb5.append(next.getPackageName());
                            sb5.append("-");
                            sb5.append(next.getPluginApkFilePath());
                            sb5.append("-");
                            sb5.append(next.isLoaded());
                        }
                    }
                }
                if (l != null) {
                    sb5.append("-");
                    sb5.append(l.getContainerVersion());
                    sb5.append("-");
                    sb5.append(l.getForbiddenFeatures());
                    sb5.append("-");
                    for (Map.Entry<String, PluginSetting> entry2 : l.getPlugins().entrySet()) {
                        PluginSetting value = entry2.getValue();
                        if (value != null) {
                            sb5.append(value.packageName);
                            sb5.append("-");
                            sb5.append(value.apkPath);
                            sb5.append("-");
                            sb5.append(value.getAbandon_apk_path());
                            sb5.append("-");
                            sb5.append(value.versionCode);
                            sb5.append("-");
                            sb5.append(value.tempVersionCode);
                            sb5.append("-");
                        }
                    }
                }
                d.a.c.h.h.a b3 = d.a.c.h.h.a.b();
                b3.o("plugin_del_redundance", "del_redundance_detail", null, "uselist_" + sb.toString() + "_delandreason_" + sb3.toString() + "_jump_" + sb2.toString() + "_setting_" + sb5.toString());
            }
            return arrayList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            ArrayList<File> c2 = c();
            if (c2 != null && c2.size() != 0) {
                b(c2);
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            b.this.f39133b = null;
        }
    }

    public static b d() {
        if (f39131d == null) {
            synchronized (b.class) {
                if (f39131d == null) {
                    f39131d = new b();
                }
            }
        }
        return f39131d;
    }

    public void c(boolean z) {
        if (z && !this.f39134c && this.f39133b == null && e()) {
            a aVar = new a();
            this.f39133b = aVar;
            aVar.execute(new Void[0]);
            this.f39134c = true;
        }
    }

    public final boolean e() {
        String[] split;
        this.f39132a.clear();
        PluginSettings l = d.a.c.h.j.g.d.k().l();
        if (l == null) {
            return false;
        }
        Map<String, PluginSetting> plugins = l.getPlugins();
        if (plugins.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : plugins.entrySet()) {
            PluginSetting value = entry.getValue();
            if (!TextUtils.isEmpty(value.apkPath)) {
                this.f39132a.put(new File(value.apkPath).getName(), "");
            }
            if (!TextUtils.isEmpty(value.getAbandon_apk_path()) && (split = value.getAbandon_apk_path().split(",")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f39132a.put(new File(str).getName(), "");
                    }
                }
            }
            try {
                if (value.tempVersionCode > 0 && value.installStatus > 0) {
                    if (value.installStatus == d.a.c.h.j.g.b.f39151a) {
                        String l2 = Util.l(value);
                        if (!TextUtils.isEmpty(l2) && new File(l2).exists()) {
                            this.f39132a.put(new File(l2).getName(), "");
                        }
                    } else if (value.installStatus == d.a.c.h.j.g.b.f39154d || value.installStatus == d.a.c.h.j.g.b.f39153c) {
                        String str2 = Util.l(value) + ".tmp";
                        if (!TextUtils.isEmpty(str2) && new File(str2).exists()) {
                            this.f39132a.put(new File(str2).getName(), "");
                        }
                    }
                }
            } catch (Exception unused) {
                d.a.c.h.h.a.b().o("plugin_del_redundance", "use_plugin_temp_file", null, "plugin_name-" + value.packageName + "-install_status-" + String.valueOf(value.installStatus) + "-tempversioncode-" + String.valueOf(value.tempVersionCode));
            }
        }
        return true;
    }
}
