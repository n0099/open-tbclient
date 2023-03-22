package com.kwad.components.core.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import com.ksad.download.DownloadTask;
import com.kuaishou.aegon.Aegon;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.config.item.o;
import com.kwad.sdk.core.report.s;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.g;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.ar;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public final class a {
    public static List<Throwable> DD;
    public static volatile boolean mHasInit;

    /* renamed from: com.kwad.components.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0591a {
        public static String ag(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        public static File getDataDir(Context context) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                return new File(context.getExternalFilesDir(null).getAbsolutePath());
            }
            File dataDir = i >= 24 ? context.getDataDir() : null;
            if (dataDir == null) {
                dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                if (!dataDir.exists()) {
                    return new File("/data/data/" + context.getPackageName());
                }
            }
            return dataDir;
        }
    }

    @NonNull
    public static b a(@NonNull Context context, @NonNull final SdkConfig sdkConfig) {
        final Context applicationContext = context.getApplicationContext();
        return new b.a().bI(applicationContext).aR(((j) d.b(applicationContext, c.UM)).sB()).aS(((j) d.b(applicationContext, c.UN)).sB()).aT(KsAdSDKImpl.get().getIsExternal()).cM(((o) d.b(applicationContext, c.UO)).getValue()).cL(((o) d.b(applicationContext, c.UP)).getValue()).cS(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1)).bc(KsAdSDKImpl.get().getSDKVersionCode()).cT(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1)).bd(KsAdSDKImpl.get().getApiVersionCode()).be(1).cR("com.kwad.sdk").cU(sdkConfig.appId).cV(sdkConfig.appName).cW(applicationContext.getPackageName()).cX(com.kwad.sdk.utils.j.cb(applicationContext)).cO(ar.getDeviceId()).cN("Android").cP(sdkConfig.appId).cQ(C0591a.ag(applicationContext)).a(new g() { // from class: com.kwad.components.core.b.a.2
            @Override // com.kwad.sdk.crash.g
            public final com.kwad.sdk.crash.model.message.a mn() {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.cY(s.uG());
                aVar.putString("mKsadAppId", SdkConfig.this.appId);
                aVar.putString("mKsadAppName", SdkConfig.this.appName);
                aVar.putString("mKsadAppPackageName", applicationContext.getPackageName());
                aVar.putString("mKsadAppVersion", com.kwad.sdk.utils.j.cb(applicationContext));
                aVar.putString("mKsadSdkName", "com.kwad.sdk");
                aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1));
                aVar.putInt("mKsadSdKVersionCode", KsAdSDKImpl.get().getSDKVersionCode());
                aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1));
                aVar.putInt("mKsadSdKApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
                aVar.putInt("mKsadSdkType", 1);
                return aVar;
            }
        }).a(new e() { // from class: com.kwad.components.core.b.a.1
            @Override // com.kwad.sdk.crash.e
            public final void a(int i, ExceptionMessage exceptionMessage) {
                com.kwad.sdk.e.qW();
                if (i == 1 || i == 3 || i == 4) {
                    com.kwad.sdk.core.e.b.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i);
                }
            }
        }).d(ml()).e(mm()).wy();
    }

    public static String aj(String str) {
        try {
            int indexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            return null;
        }
    }

    public static void b(Throwable th) {
        com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        if (mHasInit) {
            com.kwad.sdk.crash.a.h(th);
        } else {
            c(th);
        }
    }

    public static void c(Throwable th) {
        if (DD == null) {
            DD = new CopyOnWriteArrayList();
        }
        DD.add(th);
    }

    public static void init(Context context, SdkConfig sdkConfig) {
        if (context == null || sdkConfig == null) {
            return;
        }
        try {
            if (mHasInit) {
                return;
            }
            com.kwad.sdk.core.e.b.d("KsAdExceptionCollectorHelper", "init");
            com.kwad.sdk.crash.a.a(a(context, sdkConfig));
            mk();
            mHasInit = true;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
    }

    public static void mk() {
        List<Throwable> list = DD;
        if (list == null) {
            return;
        }
        for (Throwable th : list) {
            com.kwad.sdk.crash.a.h(th);
        }
        DD.clear();
        DD = null;
    }

    public static String[] ml() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(aj(KsAdSDKImpl.class.getName()));
            arrayList.add(aj(DownloadTask.class.getName()));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
        try {
            arrayList.add(aj(CpuMemoryProfiler.class.getName()));
            arrayList.add(aj(Aegon.class.getName()));
        } catch (Throwable th2) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th2);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] mm() {
        String[] strArr = new String[1];
        try {
            String name = com.kwad.sdk.crash.c.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf("."));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
        return strArr;
    }
}
