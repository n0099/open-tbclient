package com.kwad.sdk.collector.kwai;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.kuaishou.weapon.un.j0;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.q;
import com.kwad.v8.Platform;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes3.dex */
public class c {
    public static com.kwad.sdk.collector.kwai.d a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f57698b;

    /* loaded from: classes3.dex */
    public static class a extends com.kwad.sdk.collector.kwai.a {
        public a() {
            b();
        }

        private void b() {
            ArrayList arrayList = new ArrayList();
            this.f57697b = arrayList;
            arrayList.add(new com.kwad.sdk.collector.kwai.a(this.a) { // from class: com.kwad.sdk.collector.kwai.c.a.1
                @Override // com.kwad.sdk.collector.kwai.a
                public boolean b(Context context) {
                    int i2 = (Build.PRODUCT.contains("sdk") || Build.PRODUCT.contains("Andy") || Build.PRODUCT.contains("ttVM_Hdragon") || Build.PRODUCT.contains("google_sdk") || Build.PRODUCT.contains("Droid4X") || Build.PRODUCT.contains("nox") || Build.PRODUCT.contains("sdk_x86") || Build.PRODUCT.contains("sdk_google") || Build.PRODUCT.contains("vbox86p") || Build.PRODUCT.contains("aries")) ? 1 : 0;
                    if (Build.MANUFACTURER.equals("unknown") || Build.MANUFACTURER.equals("Genymotion") || Build.MANUFACTURER.contains("Andy") || Build.MANUFACTURER.contains("MIT") || Build.MANUFACTURER.contains("nox") || Build.MANUFACTURER.contains("TiantianVM")) {
                        i2++;
                    }
                    if (Build.BRAND.equals("generic") || Build.BRAND.equals("generic_x86") || Build.BRAND.equals("TTVM") || Build.BRAND.contains("Andy")) {
                        i2++;
                    }
                    if (Build.DEVICE.contains("generic") || Build.DEVICE.contains("generic_x86") || Build.DEVICE.contains("Andy") || Build.DEVICE.contains("ttVM_Hdragon") || Build.DEVICE.contains("Droid4X") || Build.DEVICE.contains("nox") || Build.DEVICE.contains("generic_x86_64") || Build.DEVICE.contains("vbox86p") || Build.DEVICE.contains("aries")) {
                        i2++;
                    }
                    if (Build.MODEL.equals("sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.equals("google_sdk") || Build.MODEL.contains("Droid4X") || Build.MODEL.contains("TiantianVM") || Build.MODEL.contains("Andy") || Build.MODEL.equals("Android SDK built for x86_64") || Build.MODEL.equals("Android SDK built for x86")) {
                        i2++;
                    }
                    if (Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("vbox86") || Build.HARDWARE.contains("nox") || Build.HARDWARE.contains("ttVM_x86")) {
                        i2++;
                    }
                    if (Build.FINGERPRINT.contains("generic/sdk/generic") || Build.FINGERPRINT.contains("generic_x86/sdk_x86/generic_x86") || Build.FINGERPRINT.contains("Andy") || Build.FINGERPRINT.contains("ttVM_Hdragon") || Build.FINGERPRINT.contains("generic_x86_64") || Build.FINGERPRINT.contains("generic/google_sdk/generic") || Build.FINGERPRINT.contains("vbox86p") || Build.FINGERPRINT.contains("generic/vbox86p/vbox86p")) {
                        i2++;
                    }
                    try {
                        if (new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + Platform.WINDOWS + File.separatorChar + "BstSharedFolder").exists()) {
                            i2 += 10;
                        }
                    } catch (Exception unused) {
                    }
                    return i2 > 3;
                }
            });
            this.f57697b.add(new com.kwad.sdk.collector.kwai.a(this.a) { // from class: com.kwad.sdk.collector.kwai.c.a.2
                @Override // com.kwad.sdk.collector.kwai.a
                public boolean b(Context context) {
                    return "1".equals(au.a("ro.kernel.qemu"));
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends com.kwad.sdk.collector.kwai.a {
    }

    /* renamed from: com.kwad.sdk.collector.kwai.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2077c extends com.kwad.sdk.collector.kwai.a {
    }

    /* loaded from: classes3.dex */
    public static class d extends com.kwad.sdk.collector.kwai.a {
        public d() {
            b();
        }

        private void b() {
            ArrayList arrayList = new ArrayList();
            this.f57697b = arrayList;
            arrayList.add(new com.kwad.sdk.collector.kwai.a(this.a) { // from class: com.kwad.sdk.collector.kwai.c.d.1
                @Override // com.kwad.sdk.collector.kwai.a
                public boolean b(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.f57697b.add(new com.kwad.sdk.collector.kwai.a(this.a) { // from class: com.kwad.sdk.collector.kwai.c.d.2
                @Override // com.kwad.sdk.collector.kwai.a
                public boolean b(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i2 = 0; i2 < 5; i2++) {
                        if (new File(strArr[i2] + j0.f57257b).exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.f57697b.add(new com.kwad.sdk.collector.kwai.a(this.a) { // from class: com.kwad.sdk.collector.kwai.c.d.3
                @Override // com.kwad.sdk.collector.kwai.a
                public boolean b(Context context) {
                    return c.a(new String[]{"/system/xbin/which", j0.f57257b}) != null;
                }
            });
            this.f57697b.add(new com.kwad.sdk.collector.kwai.a(this.a) { // from class: com.kwad.sdk.collector.kwai.c.d.4
                @Override // com.kwad.sdk.collector.kwai.a
                public boolean b(Context context) {
                    Charset forName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        q.a(file, NewBindCardEntry.BING_CARD_SUCCESS_MSG, forName, false);
                        return q.a(file, forName).equals(NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends com.kwad.sdk.collector.kwai.a {
        public e() {
            b();
        }

        private void b() {
            ArrayList arrayList = new ArrayList();
            this.f57697b = arrayList;
            arrayList.add(new com.kwad.sdk.collector.kwai.a(this.a) { // from class: com.kwad.sdk.collector.kwai.c.e.1
                @Override // com.kwad.sdk.collector.kwai.a
                public boolean b(Context context) {
                    return ag.a(context, "de.robv.android.xposed.installer") || ag.a(context, "com.saurik.substrate");
                }
            });
            this.f57697b.add(new com.kwad.sdk.collector.kwai.a(this.a) { // from class: com.kwad.sdk.collector.kwai.c.e.2
                @Override // com.kwad.sdk.collector.kwai.a
                public boolean b(Context context) {
                    StackTraceElement[] stackTrace;
                    try {
                        throw new Exception(SchemeCollecter.CLASSIFY_EMPTY);
                    } catch (Exception e2) {
                        boolean z = false;
                        int i2 = 0;
                        for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            if (className.equals("com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                                z = true;
                            }
                            if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                z = true;
                            }
                            if (className.equals("de.robv.android.xposed.XposedBridge") && methodName.equals("main")) {
                                z = true;
                            }
                            if (className.equals("de.robv.android.xposed.XposedBridge") && methodName.equals("handleHookedMethod")) {
                                z = true;
                            }
                        }
                        return z;
                    }
                }
            });
            this.f57697b.add(new com.kwad.sdk.collector.kwai.a(this.a) { // from class: com.kwad.sdk.collector.kwai.c.e.3
                @Override // com.kwad.sdk.collector.kwai.a
                public boolean b(Context context) {
                    boolean z = false;
                    try {
                        HashSet<String> hashSet = new HashSet();
                        BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                                hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                            }
                        }
                        for (String str : hashSet) {
                            if (str.contains("com.saurik.substrate")) {
                                Log.wtf("HookDetection", "Substrate shared object found: " + str);
                                z = true;
                            }
                            if (str.contains("XposedBridge.jar")) {
                                Log.wtf("HookDetection", "Xposed JAR found: " + str);
                                z = true;
                            }
                        }
                        bufferedReader.close();
                    } catch (Exception unused) {
                    }
                    return z;
                }
            });
        }
    }

    @WorkerThread
    public static synchronized com.kwad.sdk.collector.kwai.d a() {
        synchronized (c.class) {
            if (com.kwad.sdk.core.config.b.M()) {
                if (a != null) {
                    return a;
                }
                com.kwad.sdk.collector.kwai.d dVar = new com.kwad.sdk.collector.kwai.d(f57698b);
                boolean a2 = new d().a(f57698b);
                boolean a3 = new e().a(f57698b);
                boolean a4 = new b().a(f57698b);
                boolean a5 = new a().a(f57698b);
                boolean a6 = new C2077c().a(f57698b);
                dVar.a(a2);
                dVar.b(a3);
                dVar.c(a4);
                dVar.e(a5);
                dVar.f(a6);
                a = dVar;
                return dVar;
            }
            return null;
        }
    }

    public static ArrayList<String> a(String[] strArr) {
        ArrayList<String> arrayList = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream()));
            try {
                try {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                return arrayList2;
                            }
                            arrayList2.add(readLine);
                        } catch (Exception unused) {
                            arrayList = arrayList2;
                            com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader);
                            return arrayList;
                        }
                    }
                } finally {
                    com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader);
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            return null;
        }
    }

    public static synchronized void a(Context context) {
        synchronized (c.class) {
            if (context == null) {
                return;
            }
            f57698b = context.getApplicationContext();
        }
    }
}
