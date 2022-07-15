package com.kwad.sdk.api.loader;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.nps.utils.Constant;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.SecurityChecker;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.f;
import com.kwad.sdk.api.loader.i;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class l {

    /* loaded from: classes5.dex */
    public static abstract class a<T> implements c<T> {
        public c a;

        public a(c cVar) {
            this.a = cVar;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements f<a.C0531a> {
        public IKsAdSDK a;
        public String b;

        public b(String str, IKsAdSDK iKsAdSDK) {
            this.b = str;
            this.a = iKsAdSDK;
        }

        @Override // com.kwad.sdk.api.loader.l.f
        public final void a(final c<a.C0531a> cVar) {
            try {
                final com.kwad.sdk.api.loader.f fVar = new com.kwad.sdk.api.loader.f(this.b, this.a);
                final f.a aVar = new f.a() { // from class: com.kwad.sdk.api.loader.l.b.1
                    @Override // com.kwad.sdk.api.loader.f.a
                    public final void a(a.b bVar) {
                        if (bVar.a == 1 && bVar.c != null) {
                            cVar.a(bVar.c);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            if (b.this.a == null || b.this.a.getContext() == null) {
                                return;
                            }
                            com.kwad.sdk.api.loader.d a = com.kwad.sdk.api.loader.d.a(b.this.a.getContext());
                            if (a.a) {
                                Log.d("test.chen", "AutoRevertHandler cancel:");
                            }
                            a.e.set(true);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                };
                j.a(new Runnable() { // from class: com.kwad.sdk.api.loader.f.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.this.a(aVar);
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c<T> {
        void a(T t);
    }

    /* loaded from: classes5.dex */
    public static class d implements f<a.C0531a> {
        public f<a.C0531a> a;
        public Context b;

        public d(f<a.C0531a> fVar, Context context) {
            this.a = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.l.f
        public final void a(final c<a.C0531a> cVar) {
            this.a.a(new a<a.C0531a>(cVar) { // from class: com.kwad.sdk.api.loader.l.d.1
                @Override // com.kwad.sdk.api.loader.l.c
                public final /* synthetic */ void a(Object obj) {
                    final a.C0531a c0531a = (a.C0531a) obj;
                    Context context = d.this.b;
                    String str = c0531a.e;
                    File a = com.kwad.sdk.api.loader.h.a(context);
                    final File file = new File(a, "dynamic-" + System.currentTimeMillis() + "-" + str + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                    final IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                    if (ksAdSDKImpl != null) {
                        ksAdSDKImpl.reportBatchEvent(60, null);
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    i.a(c0531a.b, file.getPath(), new i.a() { // from class: com.kwad.sdk.api.loader.l.d.1.1
                        @Override // com.kwad.sdk.api.loader.i.a
                        public final void a() {
                            try {
                                com.kwad.sdk.api.loader.h.a(file);
                            } catch (Exception unused) {
                            }
                            if (ksAdSDKImpl != null) {
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                HashMap hashMap = new HashMap();
                                hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(currentTimeMillis2));
                                ksAdSDKImpl.reportBatchEvent(62, hashMap);
                            }
                            new RuntimeException("Download failed.");
                        }

                        @Override // com.kwad.sdk.api.loader.i.a
                        public final void a(File file2) {
                            a.C0531a c0531a2 = c0531a;
                            c0531a2.f = file2;
                            cVar.a(c0531a2);
                            if (ksAdSDKImpl != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                ksAdSDKImpl.reportBatchEvent(61, hashMap);
                            }
                        }
                    });
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements f<Boolean> {
        public f<a.C0531a> a;
        public Context b;

        public e(f<a.C0531a> fVar, Context context) {
            this.a = fVar;
            this.b = context;
        }

        public static String a(@NonNull Context context) {
            String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
            if (TextUtils.isEmpty(processName)) {
                try {
                    Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(null, new Object[0]);
                    if (invoke instanceof String) {
                        processName = (String) invoke;
                    }
                } catch (Throwable unused) {
                }
                if (TextUtils.isEmpty(processName)) {
                    int myPid = Process.myPid();
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                        if (runningAppProcessInfo.pid == myPid) {
                            return runningAppProcessInfo.processName;
                        }
                    }
                    return processName;
                }
                return processName;
            }
            return processName;
        }

        @Override // com.kwad.sdk.api.loader.l.f
        public final void a(final c<Boolean> cVar) {
            this.a.a(new c<a.C0531a>() { // from class: com.kwad.sdk.api.loader.l.e.1
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.kwad.sdk.api.loader.l.c
                public final /* synthetic */ void a(a.C0531a c0531a) {
                    a.C0531a c0531a2 = c0531a;
                    try {
                        Context context = e.this.b;
                        if (!context.getApplicationContext().getPackageName().equals(e.a(context))) {
                            new RuntimeException("not main process");
                            return;
                        }
                        IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                        if (ksAdSDKImpl != null) {
                            ksAdSDKImpl.reportBatchEvent(63, null);
                        }
                        if (!com.kwad.sdk.api.loader.b.a(e.this.b, c0531a2.f.getPath(), c0531a2.e)) {
                            throw new RuntimeException("Apk pre install failed");
                        }
                        com.kwad.sdk.api.loader.g.a(e.this.b, com.kwad.sdk.api.loader.g.a, c0531a2.e);
                        cVar.a(Boolean.TRUE);
                        com.kwad.sdk.api.loader.h.a(c0531a2.f);
                        if (ksAdSDKImpl != null) {
                            ksAdSDKImpl.reportBatchEvent(64, null);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    public interface f<T> {
        void a(c<T> cVar);
    }

    /* loaded from: classes5.dex */
    public static class g implements f<a.C0531a> {
        public f<a.C0531a> a;
        public Context b;

        public g(f<a.C0531a> fVar, Context context) {
            this.a = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.l.f
        public final void a(final c<a.C0531a> cVar) {
            this.a.a(new a<a.C0531a>(cVar) { // from class: com.kwad.sdk.api.loader.l.g.1
                @Override // com.kwad.sdk.api.loader.l.c
                public final /* synthetic */ void a(Object obj) {
                    final File file;
                    final a.C0531a c0531a = (a.C0531a) obj;
                    if (c0531a == null || (file = c0531a.f) == null) {
                        return;
                    }
                    final SecurityChecker.a aVar = new SecurityChecker.a() { // from class: com.kwad.sdk.api.loader.l.g.1.1
                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public final void a(boolean z, SecurityChecker.State state) {
                            if (z) {
                                cVar.a(c0531a);
                                return;
                            }
                            com.kwad.sdk.api.loader.h.a(c0531a.f);
                            new RuntimeException("Security check failed. state = ".concat(String.valueOf(state)));
                        }
                    };
                    j.a(new Runnable() { // from class: com.kwad.sdk.api.loader.SecurityChecker.1
                        /* JADX WARN: Removed duplicated region for block: B:58:0x005b A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #0 {Exception -> 0x0068, blocks: (B:37:0x0004, B:39:0x000a, B:41:0x0012, B:43:0x0018, B:45:0x0024, B:50:0x0033, B:58:0x005b, B:53:0x0045), top: B:64:0x0004 }] */
                        /* JADX WARN: Removed duplicated region for block: B:61:0x0063  */
                        /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void run() {
                            a aVar2;
                            SecurityChecker.a = State.INIT;
                            try {
                                boolean z = true;
                                if (c0531a != null) {
                                    File file2 = file;
                                    SecurityChecker.a = State.DATA_VALID;
                                    if (file2 != null && file2.exists() && file2.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && file2.length() > 0) {
                                        File file3 = file;
                                        String str = c0531a.c;
                                        SecurityChecker.a = State.MD5;
                                        if (TextUtils.isEmpty(str) ? false : str.toLowerCase().equals(q.a(file3).toLowerCase())) {
                                            if (z) {
                                                SecurityChecker.a = State.SUCCESS;
                                            }
                                            aVar2 = aVar;
                                            if (aVar2 == null) {
                                                aVar2.a(z, SecurityChecker.a);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                z = false;
                                if (z) {
                                }
                                aVar2 = aVar;
                                if (aVar2 == null) {
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements f<a.C0531a> {
        public f<a.C0531a> a;
        public Context b;

        public h(f<a.C0531a> fVar, Context context) {
            this.a = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.l.f
        public final void a(final c<a.C0531a> cVar) {
            this.a.a(new c<a.C0531a>() { // from class: com.kwad.sdk.api.loader.l.h.1
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.kwad.sdk.api.loader.l.c
                public final /* synthetic */ void a(a.C0531a c0531a) {
                    a.C0531a c0531a2 = c0531a;
                    if (c0531a2 != null) {
                        r.a(h.this.b, "interval", c0531a2.d);
                        r.a(h.this.b, "lastUpdateTime", System.currentTimeMillis());
                        if (c0531a2.a == -1) {
                            Loader.get();
                            String a = Loader.a(h.this.b);
                            com.kwad.sdk.api.loader.g.a(h.this.b, com.kwad.sdk.api.loader.g.b, "");
                            new RuntimeException("DynamicType == -1, curVersion: ".concat(String.valueOf(a)));
                            return;
                        }
                        String str = c0531a2.e;
                        Loader.get();
                        if (com.kwad.sdk.api.loader.g.a(str, Loader.a(h.this.b))) {
                            if (c0531a2.a == 1) {
                                cVar.a(c0531a2);
                                Log.w("maple", "new Verson: " + c0531a2.e);
                                return;
                            }
                        }
                        StringBuilder sb = new StringBuilder("No new sdkVersion. remote sdkVersion:");
                        sb.append(c0531a2.e);
                        sb.append(" currentDynamicVersion:");
                        Loader.get();
                        sb.append(Loader.a(h.this.b));
                        sb.append(" dynamicType:");
                        sb.append(c0531a2.a);
                        new RuntimeException(sb.toString());
                    }
                }
            });
        }
    }
}
