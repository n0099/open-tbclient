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
    public static final String f68749d = "nps" + File.separator + "preset";

    /* renamed from: e  reason: collision with root package name */
    public static final String f68750e = f68749d + File.separator + "info";

    /* renamed from: f  reason: collision with root package name */
    public static final String f68751f = f68749d + File.separator + "bundle";

    /* renamed from: g  reason: collision with root package name */
    public static final int f68752g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static a f68753h = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f68754a = false;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, BundleInfo> f68755b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f68756c = new HashSet();

    /* renamed from: d.a.z.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1882a implements IPackageGetCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f68757a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f68758b;

        public C1882a(a aVar, d dVar, CountDownLatch countDownLatch) {
            this.f68757a = dVar;
            this.f68758b = countDownLatch;
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetFail(int i2, String str) {
            d dVar = this.f68757a;
            dVar.f68773a = i2;
            dVar.f68774b = new ArrayList();
            this.f68758b.countDown();
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetSuccess(List<IBundleInfo> list) {
            d dVar = this.f68757a;
            dVar.f68773a = 0;
            if (list == null) {
                list = new ArrayList<>();
            }
            dVar.f68774b = list;
            this.f68758b.countDown();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IPackageDownloadCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f68759a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f68760b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f68761c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BundleInfo f68762d;

        /* renamed from: d.a.z.g.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1883a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f68763e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f68764f;

            public RunnableC1883a(String str, String str2) {
                this.f68763e = str;
                this.f68764f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context context = b.this.f68759a;
                File g2 = d.a.z.i.c.g(context, this.f68763e + ".apk");
                if (g2.exists()) {
                    g2.delete();
                }
                boolean z = false;
                try {
                    z = new File(this.f68764f).renameTo(g2);
                } catch (Exception unused) {
                }
                if (z) {
                    b.this.f68760b.f68773a = 2;
                } else {
                    b.this.f68760b.f68773a = 11;
                }
                b.this.f68761c.countDown();
            }
        }

        /* renamed from: d.a.z.g.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1884b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f68766e;

            public RunnableC1884b(int i2) {
                this.f68766e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.f68760b.f68773a = this.f68766e;
                bVar.f68761c.countDown();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f68768e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f68769f;

            public c(long j, long j2) {
                this.f68768e = j;
                this.f68769f = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f68759a.getContentResolver().notifyChange(j.c(b.this.f68762d.getPackageName(), this.f68768e, this.f68769f), null);
            }
        }

        public b(a aVar, Context context, d dVar, CountDownLatch countDownLatch, BundleInfo bundleInfo) {
            this.f68759a = context;
            this.f68760b = dVar;
            this.f68761c = countDownLatch;
            this.f68762d = bundleInfo;
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadFail(String str, int i2, String str2) {
            g.a().b().run(new RunnableC1884b(i2));
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadSuccess(String str, String str2) {
            g.a().b().run(new RunnableC1883a(str, str2));
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onProgress(long j, long j2) {
            g.a().b().run(new c(j, j2));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BundleInfo f68771e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f68772f;

        public c(a aVar, BundleInfo bundleInfo, String str) {
            this.f68771e = bundleInfo;
            this.f68772f = str;
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
                jSONObject.put("v_c", this.f68771e.getVersionCode());
                jSONObject.put("name", this.f68771e.getPackageName());
                jSONObject.put(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE, this.f68771e.getUpdateV());
                jSONObject.put("f_u", this.f68771e.needForceUpdate());
                jSONObject.put("f_b", this.f68771e.isForbidden());
                jSONObject.put("visible", this.f68771e.isVisible());
                try {
                    fileOutputStream = new FileOutputStream(file2, true);
                    try {
                        fileOutputStream.write(jSONObject.toString().getBytes());
                        fileOutputStream.write(this.f68772f.getBytes());
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
        public int f68773a;

        /* renamed from: b  reason: collision with root package name */
        public List<IBundleInfo> f68774b;
    }

    public static a d() {
        return f68753h;
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
        dVar.f68773a = 2;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Application applicationContext = ContextHolder.getApplicationContext();
        d.a.z.c.a.c.a().b().downloadBundle(bundleInfo, d.a.z.i.c.h(applicationContext).getAbsolutePath(), i2, new b(this, applicationContext, dVar, countDownLatch, bundleInfo));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return dVar.f68773a;
    }

    public d c(List<IBundleInfo> list) {
        d dVar = new d();
        dVar.f68773a = 0;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d.a.z.c.a.c.a().b().getBundleInfo(list, new C1882a(this, dVar, countDownLatch));
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
        if (this.f68754a) {
            return this.f68755b;
        }
        try {
            AssetManager assets = ContextHolder.getApplicationContext().getAssets();
            InputStream open = assets.open(f68750e + File.separator + "preset.json");
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Xml.Encoding.UTF_8.toString()), 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            this.f68755b = l(new JSONArray(sb.toString()));
            this.f68754a = true;
        } catch (IOException e2) {
            if (d.a.z.i.b.a()) {
                Log.e("PRESET", "e=" + e2.getMessage());
            }
        } catch (JSONException e3) {
            if (d.a.z.i.b.a()) {
                Log.e("PRESET", "e=" + e3.getMessage());
            }
        }
        return this.f68755b;
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
                    String substring = name.substring(f68752g, lastIndexOf);
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
        if (d.a.z.i.c.a(applicationContext, f68751f + File.separator + bundleInfo.getPackageName() + ".apk", g2.getAbsolutePath())) {
            return g(bundleInfo, g2);
        }
        return 11;
    }

    public synchronized boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f68756c.contains(str);
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
        this.f68756c.add(str);
    }

    public final void n(BundleInfo bundleInfo, String str) {
        g.a().b().run(new c(this, bundleInfo, str));
    }
}
