package com.kwad.sdk.core.kwai;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import com.ksad.download.DownloadTask;
import com.kuaishou.aegon.Aegon;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.core.config.b;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.av;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.kwad.sdk.core.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2112a {
        public static String a(Context context) {
            File file = new File(b(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        public static File b(Context context) {
            File dataDir = Build.VERSION.SDK_INT >= 24 ? context.getDataDir() : null;
            if (dataDir == null) {
                File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                if (file.exists()) {
                    return file;
                }
                return new File("/data/data/" + context.getPackageName());
            }
            return dataDir;
        }
    }

    public static String a(String str) {
        try {
            int indexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
            return null;
        }
    }

    public static void a(Context context, SdkConfig sdkConfig) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("崩溃收集是否打开：");
            sb.append(b.l());
            com.kwad.sdk.core.d.a.a("KsAdExceptionCollectorHelper", sb.toString());
            com.kwad.sdk.core.d.a.a("ec init s=" + b.l());
            if (b.l()) {
                com.kwad.sdk.crash.a.a(b(context, sdkConfig));
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    public static void a(Throwable th) {
        if (b.l()) {
            com.kwad.sdk.crash.a.a(th);
        }
    }

    public static String[] a() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(a(KsAdSDKImpl.class.getName()));
            arrayList.add(a(DownloadTask.class.getName()));
        } catch (Throwable unused) {
        }
        try {
            arrayList.add(a(CpuMemoryProfiler.class.getName()));
            arrayList.add(a(Aegon.class.getName()));
        } catch (Throwable unused2) {
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @NonNull
    public static com.kwad.sdk.crash.b b(@NonNull Context context, @NonNull final SdkConfig sdkConfig) {
        final Context applicationContext = context.getApplicationContext();
        return new b.a().a(applicationContext).f("3.3.17.4").a(3031704).g(KsAdSDKImpl.get().getApiVersion()).b(KsAdSDKImpl.get().getApiVersionCode()).c(1).e("com.kwad.sdk").h(sdkConfig.appId).i(sdkConfig.appName).j(applicationContext.getPackageName()).k(av.w(applicationContext)).b(av.u()).a("Android").c(sdkConfig.appId).d(C2112a.a(applicationContext)).a(new f() { // from class: com.kwad.sdk.core.kwai.a.2
            @Override // com.kwad.sdk.crash.f
            public com.kwad.sdk.crash.model.message.a a(int i2) {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.a(n.b());
                aVar.a("mKsadAppId", SdkConfig.this.appId);
                aVar.a("mKsadAppName", SdkConfig.this.appName);
                aVar.a("mKsadAppPackageName", applicationContext.getPackageName());
                aVar.a("mKsadAppVersion", av.w(applicationContext));
                aVar.a("mKsadSdkName", "com.kwad.sdk");
                aVar.a("mKsadSdkVersion", "3.3.17.4");
                aVar.a("mKsadSdKVersionCode", 3031704);
                aVar.a("mKsadSdkApiVersion", KsAdSDKImpl.get().getApiVersion());
                aVar.a("mKsadSdKApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
                aVar.a("mKsadSdkType", 1);
                return aVar;
            }
        }).a(new e() { // from class: com.kwad.sdk.core.kwai.a.1
            @Override // com.kwad.sdk.crash.e
            public void a(int i2, ExceptionMessage exceptionMessage) {
            }
        }).a(a()).b(b()).a();
    }

    public static String[] b() {
        String[] strArr = new String[1];
        try {
            String name = c.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf("."));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
        return strArr;
    }
}
