package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.kuaishou.weapon.p0.i1;
import com.kuaishou.weapon.p0.p0;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes8.dex */
public final class m {
    public static Context WF;
    public static com.kwad.sdk.f.kwai.d ane;

    /* loaded from: classes8.dex */
    public static class a extends com.kwad.sdk.f.kwai.a {
        public a() {
            zl();
        }

        private void zl() {
            ArrayList arrayList = new ArrayList();
            this.ams = arrayList;
            arrayList.add(new com.kwad.sdk.f.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.m.a.1
                @Override // com.kwad.sdk.f.kwai.a
                public final boolean bN(Context context) {
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
            this.ams.add(new com.kwad.sdk.f.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.m.a.2
                @Override // com.kwad.sdk.f.kwai.a
                public final boolean bN(Context context) {
                    return "1".equals(ay.get("ro.kernel.qemu"));
                }
            });
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends com.kwad.sdk.f.kwai.a {
    }

    /* loaded from: classes8.dex */
    public static class c extends com.kwad.sdk.f.kwai.a {
    }

    /* loaded from: classes8.dex */
    public static class d extends com.kwad.sdk.f.kwai.a {
        public d() {
            zl();
        }

        private void zl() {
            ArrayList arrayList = new ArrayList();
            this.ams = arrayList;
            arrayList.add(new com.kwad.sdk.f.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.m.d.1
                @Override // com.kwad.sdk.f.kwai.a
                public final boolean bN(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.ams.add(new com.kwad.sdk.f.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.m.d.2
                @Override // com.kwad.sdk.f.kwai.a
                public final boolean bN(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i = 0; i < 5; i++) {
                        if (new File(strArr[i] + i1.w).exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.ams.add(new com.kwad.sdk.f.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.m.d.3
                @Override // com.kwad.sdk.f.kwai.a
                public final boolean bN(Context context) {
                    return !TextUtils.isEmpty(m.g(new String[]{"/system/xbin/which", i1.w}));
                }
            });
            this.ams.add(new com.kwad.sdk.f.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.m.d.4
                @Override // com.kwad.sdk.f.kwai.a
                public final boolean bN(Context context) {
                    Charset forName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        o.a(file, DnsModel.MSG_OK, forName, false);
                        return o.a(file, forName).equals(DnsModel.MSG_OK);
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    /* loaded from: classes8.dex */
    public static class e extends com.kwad.sdk.f.kwai.a {
        public e() {
            zl();
        }

        private void zl() {
            ArrayList arrayList = new ArrayList();
            this.ams = arrayList;
            arrayList.add(new com.kwad.sdk.f.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.m.e.1
                @Override // com.kwad.sdk.f.kwai.a
                public final boolean bN(Context context) {
                    return ai.U(context, "de.robv.android.xposed.installer") || ai.U(context, "com.saurik.substrate");
                }
            });
            this.ams.add(new com.kwad.sdk.f.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.m.e.2
                @Override // com.kwad.sdk.f.kwai.a
                public final boolean bN(Context context) {
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
                            if (className.equals(p0.b) && methodName.equals("main")) {
                                z = true;
                            }
                            if (className.equals(p0.b) && methodName.equals("handleHookedMethod")) {
                                z = true;
                            }
                        }
                        return z;
                    }
                }
            });
            this.ams.add(new com.kwad.sdk.f.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.m.e.3
                @Override // com.kwad.sdk.f.kwai.a
                public final boolean bN(Context context) {
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
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                return z;
                            } catch (Throwable th3) {
                                th = th3;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
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
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    } catch (Exception unused3) {
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                        th = th;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                        throw th;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                    return z;
                }
            });
        }
    }

    public static synchronized void cf(Context context) {
        synchronized (m.class) {
            if (context == null) {
                return;
            }
            WF = context.getApplicationContext();
        }
    }

    public static String g(String[] strArr) {
        try {
            return com.kwad.sdk.crash.utils.g.d(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }

    @WorkerThread
    public static synchronized com.kwad.sdk.f.kwai.d zk() {
        synchronized (m.class) {
            if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).lA()) {
                if (ane != null) {
                    return ane;
                }
                com.kwad.sdk.f.kwai.d dVar = new com.kwad.sdk.f.kwai.d(WF);
                boolean bM = new d().bM(WF);
                boolean bM2 = new e().bM(WF);
                boolean bM3 = new b().bM(WF);
                boolean bM4 = new a().bM(WF);
                boolean bM5 = new c().bM(WF);
                dVar.aZ(bM);
                dVar.ba(bM2);
                dVar.bb(bM3);
                dVar.bd(bM4);
                dVar.be(bM5);
                ane = dVar;
                return dVar;
            }
            return null;
        }
    }
}
