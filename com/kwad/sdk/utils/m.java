package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.kuaishou.weapon.p0.C0438;
import com.kuaishou.weapon.p0.C0453;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes5.dex */
public final class m {
    public static com.kwad.sdk.g.kwai.d a;
    public static Context b;

    /* loaded from: classes5.dex */
    public static class a extends com.kwad.sdk.g.kwai.a {
        public a() {
            a();
        }

        private void a() {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new com.kwad.sdk.g.kwai.a(this.a) { // from class: com.kwad.sdk.utils.m.a.1
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean b(Context context) {
                    int i = (Build.PRODUCT.contains("sdk") || Build.PRODUCT.contains("Andy") || Build.PRODUCT.contains("ttVM_Hdragon") || Build.PRODUCT.contains("google_sdk") || Build.PRODUCT.contains("Droid4X") || Build.PRODUCT.contains("nox") || Build.PRODUCT.contains("sdk_x86") || Build.PRODUCT.contains("sdk_google") || Build.PRODUCT.contains("vbox86p") || Build.PRODUCT.contains("aries")) ? 1 : 0;
                    if (Build.MANUFACTURER.equals("unknown") || Build.MANUFACTURER.equals("Genymotion") || Build.MANUFACTURER.contains("Andy") || Build.MANUFACTURER.contains("MIT") || Build.MANUFACTURER.contains("nox") || Build.MANUFACTURER.contains("TiantianVM")) {
                        i++;
                    }
                    if (Build.BRAND.equals("generic") || Build.BRAND.equals("generic_x86") || Build.BRAND.equals("TTVM") || Build.BRAND.contains("Andy")) {
                        i++;
                    }
                    if (Build.DEVICE.contains("generic") || Build.DEVICE.contains("generic_x86") || Build.DEVICE.contains("Andy") || Build.DEVICE.contains("ttVM_Hdragon") || Build.DEVICE.contains("Droid4X") || Build.DEVICE.contains("nox") || Build.DEVICE.contains("generic_x86_64") || Build.DEVICE.contains("vbox86p") || Build.DEVICE.contains("aries")) {
                        i++;
                    }
                    if (Build.MODEL.equals("sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.equals("google_sdk") || Build.MODEL.contains("Droid4X") || Build.MODEL.contains("TiantianVM") || Build.MODEL.contains("Andy") || Build.MODEL.equals("Android SDK built for x86_64") || Build.MODEL.equals("Android SDK built for x86")) {
                        i++;
                    }
                    if (Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("vbox86") || Build.HARDWARE.contains("nox") || Build.HARDWARE.contains("ttVM_x86")) {
                        i++;
                    }
                    if (Build.FINGERPRINT.contains("generic/sdk/generic") || Build.FINGERPRINT.contains("generic_x86/sdk_x86/generic_x86") || Build.FINGERPRINT.contains("Andy") || Build.FINGERPRINT.contains("ttVM_Hdragon") || Build.FINGERPRINT.contains("generic_x86_64") || Build.FINGERPRINT.contains("generic/google_sdk/generic") || Build.FINGERPRINT.contains("vbox86p") || Build.FINGERPRINT.contains("generic/vbox86p/vbox86p")) {
                        i++;
                    }
                    try {
                        if (new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder").exists()) {
                            i += 10;
                        }
                    } catch (Exception unused) {
                    }
                    return i > 3;
                }
            });
            this.b.add(new com.kwad.sdk.g.kwai.a(this.a) { // from class: com.kwad.sdk.utils.m.a.2
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean b(Context context) {
                    return "1".equals(au.a("ro.kernel.qemu"));
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends com.kwad.sdk.g.kwai.a {
    }

    /* loaded from: classes5.dex */
    public static class c extends com.kwad.sdk.g.kwai.a {
    }

    /* loaded from: classes5.dex */
    public static class d extends com.kwad.sdk.g.kwai.a {
        public d() {
            a();
        }

        private void a() {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new com.kwad.sdk.g.kwai.a(this.a) { // from class: com.kwad.sdk.utils.m.d.1
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean b(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.b.add(new com.kwad.sdk.g.kwai.a(this.a) { // from class: com.kwad.sdk.utils.m.d.2
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean b(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i = 0; i < 5; i++) {
                        if (new File(strArr[i] + C0453.f723).exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.b.add(new com.kwad.sdk.g.kwai.a(this.a) { // from class: com.kwad.sdk.utils.m.d.3
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean b(Context context) {
                    return !TextUtils.isEmpty(m.a(new String[]{"/system/xbin/which", C0453.f723}));
                }
            });
            this.b.add(new com.kwad.sdk.g.kwai.a(this.a) { // from class: com.kwad.sdk.utils.m.d.4
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean b(Context context) {
                    Charset forName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        o.a(file, "ok", forName, false);
                        return o.a(file, forName).equals("ok");
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends com.kwad.sdk.g.kwai.a {
        public e() {
            a();
        }

        private void a() {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new com.kwad.sdk.g.kwai.a(this.a) { // from class: com.kwad.sdk.utils.m.e.1
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean b(Context context) {
                    return af.a(context, "de.robv.android.xposed.installer") || af.a(context, "com.saurik.substrate");
                }
            });
            this.b.add(new com.kwad.sdk.g.kwai.a(this.a) { // from class: com.kwad.sdk.utils.m.e.2
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean b(Context context) {
                    StackTraceElement[] stackTrace;
                    try {
                        throw new Exception(SchemeCollecter.CLASSIFY_EMPTY);
                    } catch (Exception e) {
                        boolean z = false;
                        int i = 0;
                        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            if (className.equals("com.android.internal.os.ZygoteInit") && (i = i + 1) == 2) {
                                z = true;
                            }
                            if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                z = true;
                            }
                            if (className.equals(C0438.f615) && methodName.equals("main")) {
                                z = true;
                            }
                            if (className.equals(C0438.f615) && methodName.equals("handleHookedMethod")) {
                                z = true;
                            }
                        }
                        return z;
                    }
                }
            });
            this.b.add(new com.kwad.sdk.g.kwai.a(this.a) { // from class: com.kwad.sdk.utils.m.e.3
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean b(Context context) {
                    BufferedReader bufferedReader;
                    FileReader fileReader;
                    Throwable th;
                    HashSet<String> hashSet;
                    BufferedReader bufferedReader2 = null;
                    boolean z = false;
                    try {
                        hashSet = new HashSet();
                        fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
                    } catch (Exception unused) {
                        fileReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                        fileReader = null;
                    }
                    try {
                        bufferedReader = new BufferedReader(fileReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                } else if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                                }
                            } catch (Exception unused2) {
                                bufferedReader2 = bufferedReader;
                                com.kwad.sdk.crash.utils.b.a(bufferedReader2);
                                com.kwad.sdk.crash.utils.b.a(fileReader);
                                return z;
                            } catch (Throwable th3) {
                                th = th3;
                                com.kwad.sdk.crash.utils.b.a(bufferedReader);
                                com.kwad.sdk.crash.utils.b.a(fileReader);
                                throw th;
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
                        com.kwad.sdk.crash.utils.b.a(bufferedReader);
                    } catch (Exception unused3) {
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                        th = th;
                        com.kwad.sdk.crash.utils.b.a(bufferedReader);
                        com.kwad.sdk.crash.utils.b.a(fileReader);
                        throw th;
                    }
                    com.kwad.sdk.crash.utils.b.a(fileReader);
                    return z;
                }
            });
        }
    }

    @WorkerThread
    public static synchronized com.kwad.sdk.g.kwai.d a() {
        synchronized (m.class) {
            if (((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).d()) {
                if (a != null) {
                    return a;
                }
                com.kwad.sdk.g.kwai.d dVar = new com.kwad.sdk.g.kwai.d(b);
                boolean a2 = new d().a(b);
                boolean a3 = new e().a(b);
                boolean a4 = new b().a(b);
                boolean a5 = new a().a(b);
                boolean a6 = new c().a(b);
                dVar.a(a2);
                dVar.b(a3);
                dVar.c(a4);
                dVar.d(a5);
                dVar.e(a6);
                a = dVar;
                return dVar;
            }
            return null;
        }
    }

    public static String a(String[] strArr) {
        try {
            return com.kwad.sdk.crash.utils.g.a(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }

    public static synchronized void a(Context context) {
        synchronized (m.class) {
            if (context == null) {
                return;
            }
            b = context.getApplicationContext();
        }
    }
}
