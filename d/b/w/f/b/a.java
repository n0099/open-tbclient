package d.b.w.f.b;

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
import com.baidu.nps.interfa.IPackageGetter;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import d.b.w.c.a.e;
import d.b.w.c.a.g;
import d.b.w.h.h;
import d.b.w.h.i;
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
    public static final String f65555d = "nps" + File.separator + "preset";

    /* renamed from: e  reason: collision with root package name */
    public static final String f65556e = f65555d + File.separator + "info";

    /* renamed from: f  reason: collision with root package name */
    public static final String f65557f = f65555d + File.separator + "bundle";

    /* renamed from: g  reason: collision with root package name */
    public static final int f65558g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static a f65559h = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f65560a = false;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, BundleInfo> f65561b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f65562c = new HashSet();

    /* renamed from: d.b.w.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1790a implements IPackageGetCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65563a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f65564b;

        public C1790a(a aVar, d dVar, CountDownLatch countDownLatch) {
            this.f65563a = dVar;
            this.f65564b = countDownLatch;
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetFail(int i, String str) {
            d dVar = this.f65563a;
            dVar.f65579a = i;
            dVar.f65580b = new ArrayList();
            this.f65564b.countDown();
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetSuccess(List<IBundleInfo> list) {
            d dVar = this.f65563a;
            dVar.f65579a = 0;
            if (list == null) {
                list = new ArrayList<>();
            }
            dVar.f65580b = list;
            this.f65564b.countDown();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IPackageDownloadCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f65565a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f65566b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f65567c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BundleInfo f65568d;

        /* renamed from: d.b.w.f.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1791a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f65569e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f65570f;

            public RunnableC1791a(String str, String str2) {
                this.f65569e = str;
                this.f65570f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context context = b.this.f65565a;
                File g2 = d.b.w.h.c.g(context, this.f65569e + ".apk");
                if (g2.exists()) {
                    g2.delete();
                }
                if (d.b.w.h.c.b(new File(this.f65570f), g2)) {
                    b.this.f65566b.f65579a = 2;
                } else {
                    b.this.f65566b.f65579a = 11;
                }
                b.this.f65567c.countDown();
            }
        }

        /* renamed from: d.b.w.f.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1792b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f65572e;

            public RunnableC1792b(int i) {
                this.f65572e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.f65566b.f65579a = this.f65572e;
                bVar.f65567c.countDown();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f65574e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f65575f;

            public c(long j, long j2) {
                this.f65574e = j;
                this.f65575f = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f65565a.getContentResolver().notifyChange(i.c(b.this.f65568d.getPackageName(), this.f65574e, this.f65575f), null);
            }
        }

        public b(a aVar, Context context, d dVar, CountDownLatch countDownLatch, BundleInfo bundleInfo) {
            this.f65565a = context;
            this.f65566b = dVar;
            this.f65567c = countDownLatch;
            this.f65568d = bundleInfo;
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadFail(String str, int i, String str2) {
            g.a().b().run(new RunnableC1792b(i));
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadSuccess(String str, String str2) {
            g.a().b().run(new RunnableC1791a(str, str2));
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onProgress(long j, long j2) {
            g.a().b().run(new c(j, j2));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BundleInfo f65577e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f65578f;

        public c(a aVar, BundleInfo bundleInfo, String str) {
            this.f65577e = bundleInfo;
            this.f65578f = str;
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
                jSONObject.put("v_c", this.f65577e.getVersionCode());
                jSONObject.put("name", this.f65577e.getPackageName());
                jSONObject.put(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE, this.f65577e.getUpdateV());
                jSONObject.put("f_u", this.f65577e.needForceUpdate());
                jSONObject.put("f_b", this.f65577e.isForbidden());
                jSONObject.put("visible", this.f65577e.isVisible());
                try {
                    fileOutputStream = new FileOutputStream(file2, true);
                    try {
                        fileOutputStream.write(jSONObject.toString().getBytes());
                        fileOutputStream.write(this.f65578f.getBytes());
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
        public int f65579a;

        /* renamed from: b  reason: collision with root package name */
        public List<IBundleInfo> f65580b;
    }

    public static a c() {
        return f65559h;
    }

    public int a(BundleInfo bundleInfo, int i) {
        d dVar = new d();
        dVar.f65579a = 2;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Application applicationContext = ContextHolder.getApplicationContext();
        IPackageGetter b2 = d.b.w.c.a.c.a().b();
        b2.downloadBundle(bundleInfo, d.b.w.h.c.g(applicationContext, bundleInfo.getPackageName() + ".apk").getAbsolutePath(), i, new b(this, applicationContext, dVar, countDownLatch, bundleInfo));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return dVar.f65579a;
    }

    public d b(List<IBundleInfo> list) {
        d dVar = new d();
        dVar.f65579a = 0;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d.b.w.c.a.c.a().b().getBundleInfo(list, new C1790a(this, dVar, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return dVar;
    }

    public final String d() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stackTrace.length; i++) {
            sb.append(stackTrace[i].getClassName());
            sb.append(":");
            sb.append(stackTrace[i].getMethodName());
            sb.append(";");
        }
        return sb.toString();
    }

    public synchronized Map<String, BundleInfo> e() {
        if (this.f65560a) {
            return this.f65561b;
        }
        try {
            AssetManager assets = ContextHolder.getApplicationContext().getAssets();
            InputStream open = assets.open(f65556e + File.separator + "preset.json");
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Xml.Encoding.UTF_8.toString()), 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            this.f65561b = k(new JSONArray(sb.toString()));
            this.f65560a = true;
        } catch (IOException e2) {
            if (d.b.w.h.b.a()) {
                Log.e("PRESET", "e=" + e2.getMessage());
            }
        } catch (JSONException e3) {
            if (d.b.w.h.b.a()) {
                Log.e("PRESET", "e=" + e3.getMessage());
            }
        }
        return this.f65561b;
    }

    public int f(BundleInfo bundleInfo, File file) {
        try {
            m(bundleInfo, d());
        } catch (Exception unused) {
        }
        Application applicationContext = ContextHolder.getApplicationContext();
        PackageInfo a2 = d.b.w.h.d.a(file.getAbsolutePath(), 128);
        if (a2 == null) {
            return 8;
        }
        if (TextUtils.equals(bundleInfo.getPackageName(), a2.packageName)) {
            if (e.a().b().checkSignature(bundleInfo.getPackageName(), h.a(file.getAbsolutePath()))) {
                d.b.w.h.c.f(applicationContext, bundleInfo.getPackageName()).mkdirs();
                File e2 = d.b.w.h.c.e(applicationContext, bundleInfo.getPackageName());
                e2.mkdirs();
                File d2 = d.b.w.h.c.d(applicationContext, bundleInfo.getPackageName() + ".apk");
                if (!d.b.w.h.c.b(file, d2)) {
                    if (d2.exists()) {
                        d2.delete();
                        return 11;
                    }
                    return 11;
                } else if (!h(d2.getAbsolutePath(), e2.getAbsolutePath())) {
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

    public int g(BundleInfo bundleInfo) {
        Application applicationContext = ContextHolder.getApplicationContext();
        File g2 = d.b.w.h.c.g(applicationContext, System.currentTimeMillis() + ".apk");
        if (g2.exists()) {
            g2.delete();
        }
        String apkPath = bundleInfo.getApkPath();
        if (TextUtils.isEmpty(apkPath)) {
            return 6;
        }
        File file = new File(apkPath);
        if (file.exists()) {
            if (d.b.w.h.c.b(file, g2)) {
                return f(bundleInfo, g2);
            }
            return 11;
        }
        return 7;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, IF, INVOKE, IF, IF] complete} */
    public final boolean h(String str, String str2) {
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
                    String substring = name.substring(f65558g, lastIndexOf);
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
                        if (!d.b.w.h.c.c(inputStream, file)) {
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

    public int i(BundleInfo bundleInfo) {
        Application applicationContext = ContextHolder.getApplicationContext();
        File g2 = d.b.w.h.c.g(applicationContext, System.currentTimeMillis() + ".apk");
        if (g2.exists()) {
            g2.delete();
        }
        if (d.b.w.h.c.a(applicationContext, f65557f + File.separator + bundleInfo.getPackageName() + ".apk", g2.getAbsolutePath())) {
            return f(bundleInfo, g2);
        }
        return 11;
    }

    public synchronized boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f65562c.contains(str);
    }

    public final Map<String, BundleInfo> k(JSONArray jSONArray) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
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

    public synchronized void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f65562c.add(str);
    }

    public final void m(BundleInfo bundleInfo, String str) {
        g.a().b().run(new c(this, bundleInfo, str));
    }
}
