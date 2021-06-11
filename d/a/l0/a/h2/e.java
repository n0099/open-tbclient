package d.a.l0.a.h2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.swan.apps.so.SoUtils;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.v2.q0;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipFile;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46377a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f46378b = d.a.l0.a.a1.e.g() + "/v8_so/";

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46379c = d.a.l0.a.c1.a.X().b();

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f46380d = d.a.l0.a.c1.a.X().a();

    /* renamed from: e  reason: collision with root package name */
    public static String f46381e = null;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: d.a.l0.a.h2.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class RunnableC0759a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                e.a();
            }
        }

        public static void a() {
            ExecutorUtilsExt.postOnElastic(new RunnableC0759a(), "V8SoCleaner", 3);
        }
    }

    public static void a() {
        File[] listFiles;
        File file = new File(f46378b);
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        String D = q0.D();
        for (File file2 : listFiles) {
            if (!TextUtils.equals(file2.getName(), D)) {
                d.a.l0.t.d.K(file2);
            }
        }
    }

    @NonNull
    public static ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("v8.engine");
        arrayList.add("zeusv8");
        if (f46379c) {
            arrayList.add("com.baidu.zeus");
        }
        String[] strArr = f46380d;
        if (strArr != null && strArr.length != 0) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return arrayList;
    }

    public static String c() {
        return "v8.engine";
    }

    public static String d() {
        if (f46379c) {
            return f46381e;
        }
        return null;
    }

    public static boolean e(@Nullable String str, @NonNull SoLoader soLoader) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            soLoader.appendErrorLog("loadLibsSo: " + th.getMessage());
            return false;
        }
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static boolean f(@Nullable String str, @NonNull SoLoader soLoader) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.load(str);
            return true;
        } catch (Throwable th) {
            soLoader.appendErrorLog("loadSoByPath: " + th.getMessage());
            return false;
        }
    }

    public static boolean g(@NonNull Context context, @NonNull SoLoader soLoader) {
        if (f46379c) {
            File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, "com.baidu.zeus");
            if (findSoFilesInLibrary == null || findSoFilesInLibrary.length() == 0) {
                return false;
            }
            f46381e = findSoFilesInLibrary.getAbsolutePath();
            m("loadV8EngineSo: v8 dependentFile:" + f46381e);
        }
        return l(null, soLoader) && e("v8.engine", soLoader);
    }

    public static f h(@NonNull Context context, @NonNull SoLoader soLoader) {
        if (g(context, soLoader)) {
            m("loadV8EngineBySystemMethod:success.");
            return f.e();
        }
        f k = k(context, soLoader);
        if (k.b()) {
            m("loadV8EngineSoWithSystemPath:success.");
            return k;
        }
        f j = j(context, soLoader);
        if (!j.b()) {
            SoUtils.onEvent(SoUtils.SO_EVENT_ID_V8_SO, soLoader.getErrorLog());
        } else {
            m("loadV8EngineSoWithCustomPath:success.");
        }
        return j;
    }

    public static f i(@NonNull HashMap<String, String> hashMap, @NonNull SoLoader soLoader) {
        m("loadV8EngineSoByMap:" + hashMap);
        String str = hashMap.get("com.baidu.zeus");
        boolean z = false;
        if (f46379c && str == null) {
            return f.d(false, false);
        }
        boolean f2 = f(hashMap.get("zeusv8"), soLoader);
        boolean l = l(hashMap, soLoader);
        boolean f3 = f(hashMap.get("v8.engine"), soLoader);
        if (f3) {
            f46381e = str;
        }
        if (l && f3) {
            z = true;
        }
        return f.d(f2, z);
    }

    public static f j(@NonNull Context context, @NonNull SoLoader soLoader) {
        f46381e = null;
        HashMap hashMap = new HashMap();
        String D = q0.D();
        File file = new File(f46378b, D);
        Iterator<String> it = b().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            File file2 = new File(file, SoUtils.getFullName(next));
            hashMap.put(next, (!file2.exists() || file2.length() == 0) ? false : false ? file2.getAbsolutePath() : null);
        }
        if (!hashMap.containsValue(null)) {
            return i(hashMap, soLoader);
        }
        String str = "swan_v8so_unzip_times_" + D;
        int i2 = h.a().getInt(str, 0);
        if (i2 >= 3) {
            soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:reach max unzip times.");
            return k(context, soLoader);
        }
        h.a().putInt(str, i2 + 1);
        String str2 = "lib" + File.separator + SoUtils.getCurrentCpuAbi();
        ZipFile apkZipFile = soLoader.getApkZipFile(context);
        if (apkZipFile == null) {
            soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:zipFile is null.");
            return k(context, soLoader);
        }
        try {
            try {
                for (String str3 : hashMap.keySet()) {
                    if (hashMap.get(str3) == null) {
                        String fullName = SoUtils.getFullName(str3);
                        File file3 = new File(file, fullName);
                        if (soLoader.executeRelease(apkZipFile, fullName, str2, file3)) {
                            hashMap.put(str3, file3.getAbsolutePath());
                        }
                    }
                }
            } catch (Exception e2) {
                soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:" + e2.getMessage());
                if (f46377a) {
                    Log.e("V8InnerSoLoader", "loadV8EngineSoWithCustomPath:" + e2);
                }
            }
            return i(hashMap, soLoader);
        } finally {
            d.a.l0.t.d.d(apkZipFile);
        }
    }

    public static f k(@NonNull Context context, @NonNull SoLoader soLoader) {
        f46381e = null;
        HashMap hashMap = new HashMap();
        Iterator<String> it = b().iterator();
        while (it.hasNext()) {
            String next = it.next();
            File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, next);
            hashMap.put(next, findSoFilesInLibrary != null && findSoFilesInLibrary.exists() && (findSoFilesInLibrary.length() > 0L ? 1 : (findSoFilesInLibrary.length() == 0L ? 0 : -1)) != 0 ? findSoFilesInLibrary.getAbsolutePath() : null);
        }
        return i(hashMap, soLoader);
    }

    public static boolean l(@Nullable HashMap<String, String> hashMap, @NonNull SoLoader soLoader) {
        boolean f2;
        String[] strArr = f46380d;
        boolean z = true;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (hashMap == null) {
                    f2 = e(str, soLoader);
                } else {
                    f2 = f(hashMap.get(str), soLoader);
                }
                if (!f2) {
                    z = false;
                }
            }
        }
        return z;
    }

    public static void m(String str) {
        if (f46377a) {
            Log.d("V8InnerSoLoader", str);
        }
    }
}
