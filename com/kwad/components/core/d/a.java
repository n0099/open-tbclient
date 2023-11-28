package com.kwad.components.core.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kuaishou.aegon.Aegon;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.w;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.d;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.h;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.k;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static boolean JA;
    public static List<Throwable> JC;
    public static final AtomicBoolean JB = new AtomicBoolean(false);
    public static final List<b> JD = new CopyOnWriteArrayList();
    public static final List<c> JE = new CopyOnWriteArrayList();

    /* loaded from: classes10.dex */
    public interface b {
        String getKey();

        JSONObject getValue();
    }

    /* loaded from: classes10.dex */
    public interface c {
        void onCrashOccur(int i, String str);
    }

    /* renamed from: com.kwad.components.core.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0639a {
        public static String W(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        public static File getDataDir(Context context) {
            int i = Build.VERSION.SDK_INT;
            File file = null;
            if (i >= 29) {
                return new File(context.getExternalFilesDir(null).getAbsolutePath());
            }
            if (i >= 24) {
                file = context.getDataDir();
            }
            if (file == null) {
                file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                if (!file.exists()) {
                    return new File("/data/data/" + context.getPackageName());
                }
            }
            return file;
        }
    }

    public static void mK() {
        List<Throwable> list = JC;
        if (list == null) {
            return;
        }
        for (Throwable th : list) {
            com.kwad.sdk.crash.b.m(th);
        }
        JC.clear();
        JC = null;
        ServiceProvider.d(new com.kwad.sdk.g.a<Throwable>() { // from class: com.kwad.components.core.d.a.2
            public static void d(Throwable th2) {
                com.kwad.sdk.crash.b.m(th2);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(Throwable th2) {
                d(th2);
            }
        });
    }

    public static String[] mN() {
        String[] strArr = new String[1];
        try {
            String name = d.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf("."));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        return strArr;
    }

    public static /* synthetic */ com.kwad.sdk.crash.c mO() {
        return mL();
    }

    public static void a(b bVar) {
        JD.add(bVar);
    }

    public static com.kwad.sdk.crash.model.b aa(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.kwad.sdk.crash.model.b();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.crash.model.b bVar = new com.kwad.sdk.crash.model.b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.w("KsAdExceptionCollectorHelper", e);
            return new com.kwad.sdk.crash.model.b();
        }
    }

    public static String ab(String str) {
        try {
            int indexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static void b(Throwable th) {
        com.kwad.sdk.core.e.c.printStackTrace(th);
        if (!JB.get()) {
            c(th);
        } else {
            com.kwad.sdk.crash.b.m(th);
        }
    }

    public static void c(Throwable th) {
        if (JC == null) {
            JC = new CopyOnWriteArrayList();
        }
        JC.add(th);
    }

    public static synchronized void initAsync(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!JB.get() && !JA) {
                    JA = true;
                    g.execute(new ay() { // from class: com.kwad.components.core.d.a.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            if (!com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.aov)) {
                                return;
                            }
                            com.kwad.sdk.core.e.c.d("KsAdExceptionCollectorHelper", "init");
                            com.kwad.sdk.crash.b.a(a.mO());
                            a.JB.set(true);
                            a.mK();
                        }
                    });
                }
            }
        }
    }

    public static void a(c cVar) {
        JE.add(cVar);
    }

    @NonNull
    public static com.kwad.sdk.crash.c mL() {
        String a = com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.apL);
        com.kwad.sdk.core.e.c.d("KsAdExceptionCollectorHelper", "configStr:" + a);
        com.kwad.sdk.crash.model.b aa = aa(a);
        String str = aa.aFf;
        String str2 = aa.aFg;
        boolean a2 = com.kwad.sdk.crash.utils.g.a(aa);
        boolean b2 = com.kwad.sdk.crash.utils.g.b(aa);
        final Context context = ServiceProvider.getContext();
        return new c.a().bv(context).bw(a2).bx(b2).by(KsAdSDKImpl.get().getIsExternal()).eE(str).eD(str2).eL(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1)).da(KsAdSDKImpl.get().getSDKVersionCode()).eM(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1)).db(KsAdSDKImpl.get().getApiVersionCode()).dc(1).eK("com.kwad.sdk").eN(context.getPackageName()).eO(ServiceProvider.Jo().appId).eP(ServiceProvider.Jo().appName).eQ(k.bQ(context)).eR(aa.aFc).eH(av.getDeviceId()).eI(ServiceProvider.Jo().appId).eG(aa.version).eS(aa.aFe).eT(aa.aFd).eF("Android").eJ(C0639a.W(context)).a(new h() { // from class: com.kwad.components.core.d.a.4
            @Override // com.kwad.sdk.crash.h
            public final com.kwad.sdk.crash.model.message.a mT() {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.eU(w.DJ());
                aVar.putString("mKsadAppId", ServiceProvider.Jo().appId);
                aVar.putString("mKsadAppName", ServiceProvider.Jo().appName);
                aVar.putString("mKsadAppPackageName", context.getPackageName());
                aVar.putString("mKsadAppVersion", k.bQ(context));
                aVar.putString("mKsadSdkName", "com.kwad.sdk");
                aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1));
                aVar.putInt("mKsadSdKVersionCode", KsAdSDKImpl.get().getSDKVersionCode());
                aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1));
                aVar.putInt("mKsadSdKApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
                aVar.putInt("mKsadSdkType", 1);
                aVar.putInt("mBuildNumber", 562);
                for (b bVar : a.JD) {
                    String key = bVar.getKey();
                    JSONObject value = bVar.getValue();
                    if (key != null && value != null) {
                        aVar.a(bVar.getKey(), bVar.getValue());
                    }
                }
                return aVar;
            }
        }).a(new f() { // from class: com.kwad.components.core.d.a.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                l.at(context);
                if (i == 1 || i == 3 || i == 4) {
                    com.kwad.sdk.core.e.c.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i);
                }
                for (c cVar : a.JE) {
                    cVar.onCrashOccur(i, exceptionMessage.mCrashDetail);
                }
            }
        }).d(mM()).e(mN()).C(com.kwad.sdk.core.config.d.Av()).m(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqJ)).Gk();
    }

    public static String[] mM() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(ab(KsAdSDKImpl.class.getName()));
            arrayList.add(ab(DownloadTask.class.getName()));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        try {
            arrayList.add(ab(CpuMemoryProfiler.class.getName()));
            arrayList.add(ab(Aegon.class.getName()));
        } catch (Throwable unused) {
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
