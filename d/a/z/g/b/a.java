package d.a.z.g.b;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.nps.interfa.IPackageDownloadCallback;
import com.baidu.nps.interfa.IPackageGetCallback;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import d.a.z.c.a.g;
import d.a.z.i.e;
import d.a.z.i.i;
import d.a.z.i.j;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f68645d = "nps" + File.separator + "preset";

    /* renamed from: e  reason: collision with root package name */
    public static final String f68646e = f68645d + File.separator + "info";

    /* renamed from: f  reason: collision with root package name */
    public static final String f68647f = f68645d + File.separator + "bundle";

    /* renamed from: g  reason: collision with root package name */
    public static final int f68648g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static a f68649h = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f68650a = false;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, BundleInfo> f68651b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f68652c = new HashSet();

    /* renamed from: d.a.z.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1879a implements IPackageGetCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f68653a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f68654b;

        public C1879a(a aVar, d dVar, CountDownLatch countDownLatch) {
            this.f68653a = dVar;
            this.f68654b = countDownLatch;
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetFail(int i2, String str) {
            d dVar = this.f68653a;
            dVar.f68669a = i2;
            dVar.f68670b = new ArrayList();
            this.f68654b.countDown();
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetSuccess(List<IBundleInfo> list) {
            d dVar = this.f68653a;
            dVar.f68669a = 0;
            if (list == null) {
                list = new ArrayList<>();
            }
            dVar.f68670b = list;
            this.f68654b.countDown();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IPackageDownloadCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f68655a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f68656b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f68657c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BundleInfo f68658d;

        /* renamed from: d.a.z.g.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1880a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f68659e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f68660f;

            public RunnableC1880a(String str, String str2) {
                this.f68659e = str;
                this.f68660f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context context = b.this.f68655a;
                File g2 = d.a.z.i.c.g(context, this.f68659e + ".apk");
                if (g2.exists()) {
                    g2.delete();
                }
                boolean z = false;
                try {
                    z = new File(this.f68660f).renameTo(g2);
                } catch (Exception unused) {
                }
                if (z) {
                    b.this.f68656b.f68669a = 2;
                } else {
                    b.this.f68656b.f68669a = 11;
                }
                b.this.f68657c.countDown();
            }
        }

        /* renamed from: d.a.z.g.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1881b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f68662e;

            public RunnableC1881b(int i2) {
                this.f68662e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.f68656b.f68669a = this.f68662e;
                bVar.f68657c.countDown();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f68664e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f68665f;

            public c(long j, long j2) {
                this.f68664e = j;
                this.f68665f = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f68655a.getContentResolver().notifyChange(j.c(b.this.f68658d.getPackageName(), this.f68664e, this.f68665f), null);
            }
        }

        public b(a aVar, Context context, d dVar, CountDownLatch countDownLatch, BundleInfo bundleInfo) {
            this.f68655a = context;
            this.f68656b = dVar;
            this.f68657c = countDownLatch;
            this.f68658d = bundleInfo;
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadFail(String str, int i2, String str2) {
            g.a().b().run(new RunnableC1881b(i2));
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadSuccess(String str, String str2) {
            g.a().b().run(new RunnableC1880a(str, str2));
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onProgress(long j, long j2) {
            g.a().b().run(new c(j, j2));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BundleInfo f68667e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f68668f;

        public c(a aVar, BundleInfo bundleInfo, String str) {
            this.f68667e = bundleInfo;
            this.f68668f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            Throwable th;
            try {
                File file = new File(ContextHolder.getApplicationContext().getCacheDir(), "nps");
                file.mkdirs();
                File file2 = new File(file, "ext_nps_upgradle_application");
                if (file2.exists() && file2.length() > 1048576) {
                    file2.delete();
                    file2.createNewFile();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("v_c", this.f68667e.getVersionCode());
                jSONObject.put("name", this.f68667e.getPackageName());
                jSONObject.put(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE, this.f68667e.getUpdateV());
                jSONObject.put("f_u", this.f68667e.needForceUpdate());
                jSONObject.put("f_b", this.f68667e.isForbidden());
                jSONObject.put("visible", this.f68667e.isVisible());
                try {
                    fileOutputStream = new FileOutputStream(file2, true);
                    try {
                        fileOutputStream.write(jSONObject.toString().getBytes());
                        fileOutputStream.write(this.f68668f.getBytes());
                        fileOutputStream.write(String.valueOf(System.currentTimeMillis()).getBytes());
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    fileOutputStream = null;
                    th = th3;
                }
            } catch (IOException | Exception unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f68669a;

        /* renamed from: b  reason: collision with root package name */
        public List<IBundleInfo> f68670b;
    }

    public static a d() {
        return f68649h;
    }

    public final void a(File file, boolean z) {
        File[] listFiles;
        if (!file.exists() || file.isFile() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2].isFile()) {
                listFiles[i2].delete();
            } else {
                a(listFiles[i2], true);
            }
        }
        if (z) {
            file.delete();
        }
    }

    public int b(BundleInfo bundleInfo, int i2) {
        d dVar = new d();
        dVar.f68669a = 2;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Application applicationContext = ContextHolder.getApplicationContext();
        d.a.z.c.a.c.a().b().downloadBundle(bundleInfo, d.a.z.i.c.h(applicationContext).getAbsolutePath(), i2, new b(this, applicationContext, dVar, countDownLatch, bundleInfo));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return dVar.f68669a;
    }

    public d c(List<IBundleInfo> list) {
        d dVar = new d();
        dVar.f68669a = 0;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d.a.z.c.a.c.a().b().getBundleInfo(list, new C1879a(this, dVar, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return dVar;
    }

    public final String e() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < stackTrace.length; i2++) {
            sb.append(stackTrace[i2].getClassName());
            sb.append(":");
            sb.append(stackTrace[i2].getMethodName());
            sb.append(";");
        }
        return sb.toString();
    }

    public synchronized Map<String, BundleInfo> f() {
        if (this.f68650a) {
            return this.f68651b;
        }
        try {
            AssetManager assets = ContextHolder.getApplicationContext().getAssets();
            InputStream open = assets.open(f68646e + File.separator + "preset.json");
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Xml.Encoding.UTF_8.toString()), 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            this.f68651b = l(new JSONArray(sb.toString()));
            this.f68650a = true;
        } catch (IOException e2) {
            if (d.a.z.i.b.a()) {
                Log.e("PRESET", "e=" + e2.getMessage());
            }
        } catch (JSONException e3) {
            if (d.a.z.i.b.a()) {
                Log.e("PRESET", "e=" + e3.getMessage());
            }
        }
        return this.f68651b;
    }

    public int g(BundleInfo bundleInfo, File file) {
        try {
            n(bundleInfo, e());
        } catch (Exception unused) {
        }
        Application applicationContext = ContextHolder.getApplicationContext();
        PackageInfo a2 = e.a(file.getAbsolutePath(), 128);
        if (a2 == null) {
            return 8;
        }
        if (TextUtils.equals(bundleInfo.getPackageName(), a2.packageName)) {
            if (d.a.z.c.a.e.a().b().checkSignature(bundleInfo.getPackageName(), i.a(file.getAbsolutePath()))) {
                d.a.z.i.c.f(applicationContext, bundleInfo.getPackageName()).mkdirs();
                File e2 = d.a.z.i.c.e(applicationContext, bundleInfo.getPackageName());
                e2.mkdirs();
                File d2 = d.a.z.i.c.d(applicationContext, bundleInfo.getPackageName() + ".apk");
                if (!d.a.z.i.c.b(file, d2)) {
                    if (d2.exists()) {
                        d2.delete();
                        return 11;
                    }
                    return 11;
                }
                a(e2, false);
                if (!i(d2.getAbsolutePath(), e2.getAbsolutePath())) {
                    if (d2.exists()) {
                        d2.delete();
                        return 12;
                    }
                    return 12;
                } else if (file.exists()) {
                    file.delete();
                    return 13;
                } else {
                    return 13;
                }
            }
            return 10;
        }
        return 9;
    }

    public int h(BundleInfo bundleInfo) {
        Application applicationContext = ContextHolder.getApplicationContext();
        File g2 = d.a.z.i.c.g(applicationContext, System.currentTimeMillis() + ".apk");
        if (g2.exists()) {
            g2.delete();
        }
        String apkPath = bundleInfo.getApkPath();
        if (TextUtils.isEmpty(apkPath)) {
            return 6;
        }
        File file = new File(apkPath);
        if (file.exists()) {
            if (d.a.z.i.c.b(file, g2)) {
                return g(bundleInfo, g2);
            }
            return 11;
        }
        return 7;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, IF, INVOKE, IF, IF] complete} */
    public final boolean i(String str, String str2) {
        String str3 = Build.CPU_ABI;
        String str4 = Build.CPU_ABI2;
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            boolean z = false;
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && name.endsWith(".so")) {
                    int lastIndexOf = name.lastIndexOf("/");
                    String substring = name.substring(f68648g, lastIndexOf);
                    if (str3.equals(substring)) {
                        z = true;
                    } else if (str4.equals(substring) && !z) {
                    }
                    InputStream inputStream = null;
                    String substring2 = name.substring(lastIndexOf);
                    File file = new File(str2, substring2 + System.currentTimeMillis());
                    File file2 = new File(str2, substring2);
                    try {
                        inputStream = zipFile.getInputStream(nextElement);
                        if (!d.a.z.i.c.c(inputStream, file)) {
                            if (file.exists()) {
                                file.delete();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            return false;
                        }
                        if (file2.exists()) {
                            file2.delete();
                        }
                        file.renameTo(file2);
                        if (file.exists()) {
                            file.delete();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                    } catch (IOException unused3) {
                        if (file.exists()) {
                            file.delete();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        if (file.exists()) {
                            file.delete();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        throw th;
                    }
                }
            }
            try {
                zipFile.close();
            } catch (IOException unused6) {
            }
            return true;
        } catch (IOException unused7) {
            return false;
        }
    }

    public int j(BundleInfo bundleInfo) {
        Application applicationContext = ContextHolder.getApplicationContext();
        File g2 = d.a.z.i.c.g(applicationContext, System.currentTimeMillis() + ".apk");
        if (g2.exists()) {
            g2.delete();
        }
        if (d.a.z.i.c.a(applicationContext, f68647f + File.separator + bundleInfo.getPackageName() + ".apk", g2.getAbsolutePath())) {
            return g(bundleInfo, g2);
        }
        return 11;
    }

    public synchronized boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f68652c.contains(str);
    }

    public final Map<String, BundleInfo> l(JSONArray jSONArray) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                BundleInfo bundleInfo = new BundleInfo();
                bundleInfo.setPackageName(jSONObject.optString(EmotionResourceInfo.JSON_KEY_PKG_NAME));
                bundleInfo.setMd5(jSONObject.optString(PackageTable.MD5));
                bundleInfo.setType(2);
                bundleInfo.setVersionCode(jSONObject.optInt("version_code"));
                bundleInfo.setName(jSONObject.optString("name"));
                bundleInfo.setDescription(jSONObject.optString("description"));
                bundleInfo.setIconUrl(jSONObject.optString("icon_url"));
                hashMap.put(bundleInfo.getPackageName(), bundleInfo);
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    public synchronized void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f68652c.add(str);
    }

    public final void n(BundleInfo bundleInfo, String str) {
        g.a().b().run(new c(this, bundleInfo, str));
    }
}
