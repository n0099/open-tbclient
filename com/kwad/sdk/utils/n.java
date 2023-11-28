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
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes10.dex */
public final class n {
    public static com.kwad.sdk.k.a.d aNd;

    /* loaded from: classes10.dex */
    public static class b extends com.kwad.sdk.k.a.a {
    }

    /* loaded from: classes10.dex */
    public static class c extends com.kwad.sdk.k.a.a {
    }

    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.k.a.a {
        public a() {
            JG();
        }

        private void JG() {
            ArrayList arrayList = new ArrayList();
            this.aLh = arrayList;
            arrayList.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.1
                @Override // com.kwad.sdk.k.a.a
                public final boolean bB(Context context) {
                    int i;
                    if (!Build.PRODUCT.contains("sdk") && !Build.PRODUCT.contains("Andy") && !Build.PRODUCT.contains("ttVM_Hdragon") && !Build.PRODUCT.contains("google_sdk") && !Build.PRODUCT.contains("Droid4X") && !Build.PRODUCT.contains("nox") && !Build.PRODUCT.contains("sdk_x86") && !Build.PRODUCT.contains("sdk_google") && !Build.PRODUCT.contains("vbox86p") && !Build.PRODUCT.contains("aries")) {
                        i = 0;
                    } else {
                        i = 1;
                    }
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
                    if (i <= 3) {
                        return false;
                    }
                    return true;
                }
            });
            this.aLh.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.2
                @Override // com.kwad.sdk.k.a.a
                public final boolean bB(Context context) {
                    return "1".equals(bh.get("ro.kernel.qemu"));
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    public static class d extends com.kwad.sdk.k.a.a {
        public d() {
            JG();
        }

        private void JG() {
            ArrayList arrayList = new ArrayList();
            this.aLh = arrayList;
            arrayList.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.1
                @Override // com.kwad.sdk.k.a.a
                public final boolean bB(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.aLh.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.2
                @Override // com.kwad.sdk.k.a.a
                public final boolean bB(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i = 0; i < 5; i++) {
                        if (new File(strArr[i] + com.kuaishou.weapon.p0.bi.y).exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.aLh.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.3
                @Override // com.kwad.sdk.k.a.a
                public final boolean bB(Context context) {
                    if (!TextUtils.isEmpty(n.g(new String[]{"/system/xbin/which", com.kuaishou.weapon.p0.bi.y}))) {
                        return true;
                    }
                    return false;
                }
            });
            this.aLh.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.4
                @Override // com.kwad.sdk.k.a.a
                public final boolean bB(Context context) {
                    Charset forName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        q.a(file, DnsModel.MSG_OK, forName, false);
                        return q.a(file, forName).equals(DnsModel.MSG_OK);
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    public static class e extends com.kwad.sdk.k.a.a {
        public e() {
            JG();
        }

        private void JG() {
            ArrayList arrayList = new ArrayList();
            this.aLh = arrayList;
            arrayList.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.1
                @Override // com.kwad.sdk.k.a.a
                public final boolean bB(Context context) {
                    if (!ak.an(context, "de.robv.android.xposed.installer") && !ak.an(context, "com.saurik.substrate")) {
                        return false;
                    }
                    return true;
                }
            });
            this.aLh.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.2
                @Override // com.kwad.sdk.k.a.a
                public final boolean bB(Context context) {
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
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals("main")) {
                                z = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals("handleHookedMethod")) {
                                z = true;
                            }
                        }
                        return z;
                    }
                }
            });
            this.aLh.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.3
                @Override // com.kwad.sdk.k.a.a
                public final boolean bB(Context context) {
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

    @WorkerThread
    public static synchronized com.kwad.sdk.k.a.d JF() {
        synchronized (n.class) {
            if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yn()) {
                return null;
            }
            if (aNd != null) {
                return aNd;
            }
            Context applicationContext = ServiceProvider.getContext().getApplicationContext();
            com.kwad.sdk.k.a.d dVar = new com.kwad.sdk.k.a.d(applicationContext);
            boolean bA = new d().bA(applicationContext);
            boolean bA2 = new e().bA(applicationContext);
            boolean bA3 = new b().bA(applicationContext);
            boolean bA4 = new a().bA(applicationContext);
            boolean bA5 = new c().bA(applicationContext);
            dVar.bG(bA);
            dVar.bH(bA2);
            dVar.bI(bA3);
            dVar.bK(bA4);
            dVar.bL(bA5);
            aNd = dVar;
            return dVar;
        }
    }

    public static String g(String[] strArr) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }
}
