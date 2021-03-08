package com.kwad.sdk.api.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.SecurityChecker;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.e;
import com.kwad.sdk.api.loader.h;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k {

    /* loaded from: classes3.dex */
    private static abstract class a<T> implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        c f5471a;

        a(c cVar) {
            this.f5471a = cVar;
        }

        @Override // com.kwad.sdk.api.loader.k.c
        public void a(Throwable th) {
            this.f5471a.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements f<a.C1087a> {

        /* renamed from: a  reason: collision with root package name */
        private String f5472a;

        b(String str) {
            this.f5472a = str;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C1087a> cVar) {
            try {
                new com.kwad.sdk.api.loader.e(this.f5472a).a(new e.a() { // from class: com.kwad.sdk.api.loader.k.b.1
                    @Override // com.kwad.sdk.api.loader.e.a
                    public void a(a.b bVar) {
                        if (bVar == null || !bVar.a()) {
                            cVar.a((Throwable) new RuntimeException("UpdateData is illegal"));
                        } else {
                            cVar.a((c) bVar.c);
                        }
                    }

                    @Override // com.kwad.sdk.api.loader.e.a
                    public void a(Exception exc) {
                        cVar.a((Throwable) exc);
                    }
                });
            } catch (Exception e) {
                cVar.a(e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c<T> {
        void a(T t);

        void a(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class d implements f<a.C1087a> {

        /* renamed from: a  reason: collision with root package name */
        f<a.C1087a> f5474a;
        Context b;

        d(f<a.C1087a> fVar, Context context) {
            this.f5474a = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C1087a> cVar) {
            this.f5474a.a(new a<a.C1087a>(cVar) { // from class: com.kwad.sdk.api.loader.k.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C1087a c1087a) {
                    final File a2 = com.kwad.sdk.api.loader.g.a(d.this.b, c1087a.e);
                    final IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                    if (ksAdSDKImpl != null) {
                        ksAdSDKImpl.reportBatchEvent(60, null);
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    com.kwad.sdk.api.loader.h.a(c1087a.b, a2.getPath(), new h.a() { // from class: com.kwad.sdk.api.loader.k.d.1.1
                        @Override // com.kwad.sdk.api.loader.h.a
                        public void a() {
                            try {
                                com.kwad.sdk.api.loader.g.a(a2);
                            } catch (Exception e) {
                            }
                            if (ksAdSDKImpl != null) {
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                HashMap hashMap = new HashMap();
                                hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(currentTimeMillis2));
                                ksAdSDKImpl.reportBatchEvent(62, hashMap);
                            }
                            cVar.a((Throwable) new RuntimeException("Download failed."));
                        }

                        @Override // com.kwad.sdk.api.loader.h.a
                        public void a(File file) {
                            c1087a.f = file;
                            cVar.a((c) c1087a);
                            if (ksAdSDKImpl != null) {
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                HashMap hashMap = new HashMap();
                                hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(currentTimeMillis2));
                                ksAdSDKImpl.reportBatchEvent(61, hashMap);
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class e implements f<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        f<a.C1087a> f5476a;
        Context b;

        e(f<a.C1087a> fVar, Context context) {
            this.f5476a = fVar;
            this.b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(@NonNull Context context) {
            return context.getApplicationContext().getPackageName().equals(b(context));
        }

        private String b(@NonNull Context context) {
            int myPid = Process.myPid();
            String str = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                str = runningAppProcessInfo.pid == myPid ? runningAppProcessInfo.processName : str;
            }
            return str;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<Boolean> cVar) {
            this.f5476a.a(new c<a.C1087a>() { // from class: com.kwad.sdk.api.loader.k.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C1087a c1087a) {
                    try {
                        if (!e.this.a(e.this.b)) {
                            cVar.a((Throwable) new RuntimeException("not main process"));
                            return;
                        }
                        IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                        if (ksAdSDKImpl != null) {
                            ksAdSDKImpl.reportBatchEvent(63, null);
                        }
                        if (!com.kwad.sdk.api.loader.b.a(e.this.b, c1087a.f.getPath(), c1087a.e)) {
                            throw new RuntimeException("Apk pre install failed");
                        }
                        com.kwad.sdk.api.loader.f.a(e.this.b, com.kwad.sdk.api.loader.f.f5463a, c1087a.e);
                        cVar.a((c) true);
                        com.kwad.sdk.api.loader.g.a(c1087a.f);
                        if (ksAdSDKImpl != null) {
                            ksAdSDKImpl.reportBatchEvent(64, null);
                        }
                    } catch (Exception e) {
                        cVar.a((Throwable) e);
                    }
                }

                @Override // com.kwad.sdk.api.loader.k.c
                public void a(Throwable th) {
                    cVar.a(th);
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public interface f<T> {
        void a(c<T> cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class g implements f<a.C1087a> {

        /* renamed from: a  reason: collision with root package name */
        f<a.C1087a> f5478a;
        Context b;

        g(f<a.C1087a> fVar, Context context) {
            this.f5478a = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C1087a> cVar) {
            this.f5478a.a(new a<a.C1087a>(cVar) { // from class: com.kwad.sdk.api.loader.k.g.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C1087a c1087a) {
                    if (c1087a == null || c1087a.f == null) {
                        return;
                    }
                    SecurityChecker.a(c1087a.f, c1087a, new SecurityChecker.a() { // from class: com.kwad.sdk.api.loader.k.g.1.1
                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(Exception exc) {
                            cVar.a((Throwable) exc);
                        }

                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(boolean z, SecurityChecker.State state) {
                            if (z) {
                                cVar.a((c) c1087a);
                                return;
                            }
                            com.kwad.sdk.api.loader.g.a(c1087a.f);
                            cVar.a((Throwable) new RuntimeException("Security check failed. state = " + state));
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class h implements f<a.C1087a> {

        /* renamed from: a  reason: collision with root package name */
        f<a.C1087a> f5480a;
        Context b;

        h(f<a.C1087a> fVar, Context context) {
            this.f5480a = fVar;
            this.b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C1087a> cVar) {
            this.f5480a.a(new c<a.C1087a>() { // from class: com.kwad.sdk.api.loader.k.h.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C1087a c1087a) {
                    if (c1087a == null) {
                        return;
                    }
                    q.a(h.this.b, "interval", c1087a.d);
                    q.a(h.this.b, "lastUpdateTime", System.currentTimeMillis());
                    if (c1087a.b()) {
                        String a2 = Loader.get().a(h.this.b);
                        com.kwad.sdk.api.loader.f.a(h.this.b, com.kwad.sdk.api.loader.f.b, "");
                        cVar.a((Throwable) new RuntimeException("DynamicType == -1, curVersion: " + a2));
                    } else if (!com.kwad.sdk.api.loader.f.a(c1087a.e, Loader.get().a(h.this.b)) || !c1087a.a()) {
                        cVar.a((Throwable) new RuntimeException("No new sdkVersion. remote sdkVersion:" + c1087a.e + " currentDynamicVersion:" + Loader.get().a(h.this.b) + " dynamicType:" + c1087a.f5457a));
                    } else {
                        cVar.a((c) c1087a);
                        Log.w("maple", "new Verson: " + c1087a.e);
                    }
                }

                @Override // com.kwad.sdk.api.loader.k.c
                public void a(Throwable th) {
                    cVar.a(th);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f<Boolean> a(String str) {
        Context context = Loader.get().getContext();
        return new e(new g(new d(new h(new b(str), context), context), context), context);
    }
}
