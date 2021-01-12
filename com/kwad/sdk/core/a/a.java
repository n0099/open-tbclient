package com.kwad.sdk.core.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import com.ksad.download.DownloadTask;
import com.kuaishou.aegon.Aegon;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.d;
import com.kwad.sdk.utils.ah;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kwad.sdk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1085a {
        public static String a(Context context) {
            File file = new File(b(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        private static File b(Context context) {
            File dataDir = Build.VERSION.SDK_INT >= 24 ? context.getDataDir() : null;
            if (dataDir == null) {
                File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                return !file.exists() ? new File("/data/data/" + context.getPackageName()) : file;
            }
            return dataDir;
        }
    }

    private static String a(String str) {
        try {
            int indexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
        return null;
    }

    public static void a(Context context, SdkConfig sdkConfig) {
        try {
            com.kwad.sdk.core.d.a.a("KsAdExceptionCollectorHelper", "崩溃收集是否打开：" + (c.E()));
            if (c.E()) {
                com.kwad.sdk.crash.a.a(b(context, sdkConfig));
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    public static void a(Throwable th) {
        if (c.E()) {
            com.kwad.sdk.crash.a.a(th);
        }
    }

    private static String[] a() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(a(KsAdSDKImpl.class.getName()));
            arrayList.add(a(DownloadTask.class.getName()));
        } catch (Throwable th) {
        }
        try {
            arrayList.add(a(CpuMemoryProfiler.class.getName()));
            arrayList.add(a(Aegon.class.getName()));
        } catch (Throwable th2) {
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @NonNull
    private static b b(@NonNull Context context, @NonNull final SdkConfig sdkConfig) {
        final Context applicationContext = context.getApplicationContext();
        return new b.a().a(applicationContext).f("3.3.9").a(3030900).g(KsAdSDKImpl.get().getApiVersion()).b(KsAdSDKImpl.get().getApiVersionCode()).c(d.f9669a).e("com.kwad.sdk").h(sdkConfig.appId).i(sdkConfig.appName).j(applicationContext.getPackageName()).k(ah.l(applicationContext)).b(ah.m()).a("Android").c(sdkConfig.appId).d(C1085a.a(applicationContext)).a(new f() { // from class: com.kwad.sdk.core.a.a.2
            @Override // com.kwad.sdk.crash.f
            public com.kwad.sdk.crash.model.message.a a(int i) {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.a(m.b());
                aVar.a("mKsadAppId", SdkConfig.this.appId);
                aVar.a("mKsadAppName", SdkConfig.this.appName);
                aVar.a("mKsadAppPackageName", applicationContext.getPackageName());
                aVar.a("mKsadAppVersion", ah.l(applicationContext));
                aVar.a("mKsadSdkName", "com.kwad.sdk");
                aVar.a("mKsadSdkVersion", "3.3.9");
                aVar.a("mKsadSdKVersionCode", 3030900);
                aVar.a("mKsadSdkApiVersion", KsAdSDKImpl.get().getApiVersion());
                aVar.a("mKsadSdKApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
                aVar.a("mKsadSdkType", d.f9669a);
                return aVar;
            }
        }).a(new e() { // from class: com.kwad.sdk.core.a.a.1
            @Override // com.kwad.sdk.crash.e
            public void a(int i, ExceptionMessage exceptionMessage) {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    default:
                        return;
                }
            }
        }).a(a()).b(b()).a();
    }

    private static String[] b() {
        String[] strArr = new String[1];
        try {
            String name = com.kwad.sdk.crash.c.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf("."));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
        return strArr;
    }
}
