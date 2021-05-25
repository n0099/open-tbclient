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
    public static final String f64914d = "nps" + File.separator + "preset";

    /* renamed from: e  reason: collision with root package name */
    public static final String f64915e = f64914d + File.separator + "info";

    /* renamed from: f  reason: collision with root package name */
    public static final String f64916f = f64914d + File.separator + "bundle";

    /* renamed from: g  reason: collision with root package name */
    public static final int f64917g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static a f64918h = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f64919a = false;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, BundleInfo> f64920b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f64921c = new HashSet();

    /* renamed from: d.a.z.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1820a implements IPackageGetCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f64922a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f64923b;

        public C1820a(a aVar, d dVar, CountDownLatch countDownLatch) {
            this.f64922a = dVar;
            this.f64923b = countDownLatch;
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetFail(int i2, String str) {
            d dVar = this.f64922a;
            dVar.f64938a = i2;
            dVar.f64939b = new ArrayList();
            this.f64923b.countDown();
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetSuccess(List<IBundleInfo> list) {
            d dVar = this.f64922a;
            dVar.f64938a = 0;
            if (list == null) {
                list = new ArrayList<>();
            }
            dVar.f64939b = list;
            this.f64923b.countDown();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IPackageDownloadCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f64924a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f64925b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f64926c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BundleInfo f64927d;

        /* renamed from: d.a.z.g.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1821a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f64928e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f64929f;

            public RunnableC1821a(String str, String str2) {
                this.f64928e = str;
                this.f64929f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context context = b.this.f64924a;
                File g2 = d.a.z.i.c.g(context, this.f64928e + ".apk");
                if (g2.exists()) {
                    g2.delete();
                }
                boolean z = false;
                try {
                    z = new File(this.f64929f).renameTo(g2);
                } catch (Exception unused) {
                }
                if (z) {
                    b.this.f64925b.f64938a = 2;
                } else {
                    b.this.f64925b.f64938a = 11;
                }
                b.this.f64926c.countDown();
            }
        }

        /* renamed from: d.a.z.g.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1822b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f64931e;

            public RunnableC1822b(int i2) {
                this.f64931e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.f64925b.f64938a = this.f64931e;
                bVar.f64926c.countDown();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f64933e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f64934f;

            public c(long j, long j2) {
                this.f64933e = j;
                this.f64934f = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f64924a.getContentResolver().notifyChange(j.c(b.this.f64927d.getPackageName(), this.f64933e, this.f64934f), null);
            }
        }

        public b(a aVar, Context context, d dVar, CountDownLatch countDownLatch, BundleInfo bundleInfo) {
            this.f64924a = context;
            this.f64925b = dVar;
            this.f64926c = countDownLatch;
            this.f64927d = bundleInfo;
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadFail(String str, int i2, String str2) {
            g.a().b().run(new RunnableC1822b(i2));
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadSuccess(String str, String str2) {
            g.a().b().run(new RunnableC1821a(str, str2));
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onProgress(long j, long j2) {
            g.a().b().run(new c(j, j2));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BundleInfo f64936e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64937f;

        public c(a aVar, BundleInfo bundleInfo, String str) {
            this.f64936e = bundleInfo;
            this.f64937f = str;
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
                jSONObject.put("v_c", this.f64936e.getVersionCode());
                jSONObject.put("name", this.f64936e.getPackageName());
                jSONObject.put(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE, this.f64936e.getUpdateV());
                jSONObject.put("f_u", this.f64936e.needForceUpdate());
                jSONObject.put("f_b", this.f64936e.isForbidden());
                jSONObject.put("visible", this.f64936e.isVisible());
                try {
                    fileOutputStream = new FileOutputStream(file2, true);
                    try {
                        fileOutputStream.write(jSONObject.toString().getBytes());
                        fileOutputStream.write(this.f64937f.getBytes());
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
        public int f64938a;

        /* renamed from: b  reason: collision with root package name */
        public List<IBundleInfo> f64939b;
    }

    public static a d() {
        return f64918h;
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
        dVar.f64938a = 2;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Application applicationContext = ContextHolder.getApplicationContext();
        d.a.z.c.a.c.a().b().downloadBundle(bundleInfo, d.a.z.i.c.h(applicationContext).getAbsolutePath(), i2, new b(this, applicationContext, dVar, countDownLatch, bundleInfo));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return dVar.f64938a;
    }

    public d c(List<IBundleInfo> list) {
        d dVar = new d();
        dVar.f64938a = 0;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d.a.z.c.a.c.a().b().getBundleInfo(list, new C1820a(this, dVar, countDownLatch));
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
        if (this.f64919a) {
            return this.f64920b;
        }
        try {
            AssetManager assets = ContextHolder.getApplicationContext().getAssets();
            InputStream open = assets.open(f64915e + File.separator + "preset.json");
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Xml.Encoding.UTF_8.toString()), 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            this.f64920b = l(new JSONArray(sb.toString()));
            this.f64919a = true;
        } catch (IOException e2) {
            if (d.a.z.i.b.a()) {
                Log.e("PRESET", "e=" + e2.getMessage());
            }
        } catch (JSONException e3) {
            if (d.a.z.i.b.a()) {
                Log.e("PRESET", "e=" + e3.getMessage());
            }
        }
        return this.f64920b;
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
                    String substring = name.substring(f64917g, lastIndexOf);
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
        if (d.a.z.i.c.a(applicationContext, f64916f + File.separator + bundleInfo.getPackageName() + ".apk", g2.getAbsolutePath())) {
            return g(bundleInfo, g2);
        }
        return 11;
    }

    public synchronized boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f64921c.contains(str);
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
        this.f64921c.add(str);
    }

    public final void n(BundleInfo bundleInfo, String str) {
        g.a().b().run(new c(this, bundleInfo, str));
    }
}
