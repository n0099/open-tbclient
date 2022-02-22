package com.kwad.sdk.api.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.SecurityChecker;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.e;
import com.kwad.sdk.api.loader.h;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class k {

    /* loaded from: classes4.dex */
    public static abstract class a<T> implements c<T> {
        public c a;

        public a(c cVar) {
            this.a = cVar;
        }

        @Override // com.kwad.sdk.api.loader.k.c
        public void a(Throwable th) {
            this.a.a(th);
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements f<a.C2104a> {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public IKsAdSDK f55620b;

        public b(String str, IKsAdSDK iKsAdSDK) {
            this.a = str;
            this.f55620b = iKsAdSDK;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C2104a> cVar) {
            try {
                new com.kwad.sdk.api.loader.e(this.a, this.f55620b).a(new e.a() { // from class: com.kwad.sdk.api.loader.k.b.1
                    @Override // com.kwad.sdk.api.loader.e.a
                    public void a(a.b bVar) {
                        if (bVar == null || !bVar.a()) {
                            cVar.a((Throwable) new RuntimeException("UpdateData is illegal"));
                        } else {
                            cVar.a((c) bVar.f55602c);
                        }
                    }

                    @Override // com.kwad.sdk.api.loader.e.a
                    public void a(Exception exc) {
                        cVar.a((Throwable) exc);
                    }
                });
            } catch (Exception e2) {
                cVar.a(e2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c<T> {
        void a(T t);

        void a(Throwable th);
    }

    /* loaded from: classes4.dex */
    public static class d implements f<a.C2104a> {
        public f<a.C2104a> a;

        /* renamed from: b  reason: collision with root package name */
        public Context f55622b;

        public d(f<a.C2104a> fVar, Context context) {
            this.a = fVar;
            this.f55622b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C2104a> cVar) {
            this.a.a(new a<a.C2104a>(cVar) { // from class: com.kwad.sdk.api.loader.k.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C2104a c2104a) {
                    final File a = com.kwad.sdk.api.loader.g.a(d.this.f55622b, c2104a.f55599e);
                    final IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                    if (ksAdSDKImpl != null) {
                        ksAdSDKImpl.reportBatchEvent(60, null);
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    com.kwad.sdk.api.loader.h.a(c2104a.f55596b, a.getPath(), new h.a() { // from class: com.kwad.sdk.api.loader.k.d.1.1
                        @Override // com.kwad.sdk.api.loader.h.a
                        public void a() {
                            try {
                                com.kwad.sdk.api.loader.g.a(a);
                            } catch (Exception unused) {
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
                            a.C2104a c2104a2 = c2104a;
                            c2104a2.f55600f = file;
                            cVar.a((c) c2104a2);
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

    /* loaded from: classes4.dex */
    public static class e implements f<Boolean> {
        public f<a.C2104a> a;

        /* renamed from: b  reason: collision with root package name */
        public Context f55629b;

        public e(f<a.C2104a> fVar, Context context) {
            this.a = fVar;
            this.f55629b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(@NonNull Context context) {
            return context.getApplicationContext().getPackageName().equals(b(context));
        }

        private String b(@NonNull Context context) {
            int myPid = Process.myPid();
            String str = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    str = runningAppProcessInfo.processName;
                }
            }
            return str;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<Boolean> cVar) {
            this.a.a(new c<a.C2104a>() { // from class: com.kwad.sdk.api.loader.k.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C2104a c2104a) {
                    try {
                        if (!e.this.a(e.this.f55629b)) {
                            cVar.a((Throwable) new RuntimeException("not main process"));
                            return;
                        }
                        IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                        if (ksAdSDKImpl != null) {
                            ksAdSDKImpl.reportBatchEvent(63, null);
                        }
                        if (!com.kwad.sdk.api.loader.b.a(e.this.f55629b, c2104a.f55600f.getPath(), c2104a.f55599e)) {
                            throw new RuntimeException("Apk pre install failed");
                        }
                        com.kwad.sdk.api.loader.f.a(e.this.f55629b, com.kwad.sdk.api.loader.f.a, c2104a.f55599e);
                        cVar.a((c) Boolean.TRUE);
                        com.kwad.sdk.api.loader.g.a(c2104a.f55600f);
                        if (ksAdSDKImpl != null) {
                            ksAdSDKImpl.reportBatchEvent(64, null);
                        }
                    } catch (Exception e2) {
                        cVar.a((Throwable) e2);
                    }
                }

                @Override // com.kwad.sdk.api.loader.k.c
                public void a(Throwable th) {
                    cVar.a(th);
                }
            });
        }
    }

    /* loaded from: classes4.dex */
    public interface f<T> {
        void a(c<T> cVar);
    }

    /* loaded from: classes4.dex */
    public static class g implements f<a.C2104a> {
        public f<a.C2104a> a;

        /* renamed from: b  reason: collision with root package name */
        public Context f55631b;

        public g(f<a.C2104a> fVar, Context context) {
            this.a = fVar;
            this.f55631b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C2104a> cVar) {
            this.a.a(new a<a.C2104a>(cVar) { // from class: com.kwad.sdk.api.loader.k.g.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C2104a c2104a) {
                    File file;
                    if (c2104a == null || (file = c2104a.f55600f) == null) {
                        return;
                    }
                    SecurityChecker.a(file, c2104a, new SecurityChecker.a() { // from class: com.kwad.sdk.api.loader.k.g.1.1
                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(Exception exc) {
                            cVar.a((Throwable) exc);
                        }

                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(boolean z, SecurityChecker.State state) {
                            if (z) {
                                cVar.a((c) c2104a);
                                return;
                            }
                            com.kwad.sdk.api.loader.g.a(c2104a.f55600f);
                            c cVar2 = cVar;
                            cVar2.a((Throwable) new RuntimeException("Security check failed. state = " + state));
                        }
                    });
                }
            });
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements f<a.C2104a> {
        public f<a.C2104a> a;

        /* renamed from: b  reason: collision with root package name */
        public Context f55635b;

        public h(f<a.C2104a> fVar, Context context) {
            this.a = fVar;
            this.f55635b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C2104a> cVar) {
            this.a.a(new c<a.C2104a>() { // from class: com.kwad.sdk.api.loader.k.h.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C2104a c2104a) {
                    c cVar2;
                    RuntimeException runtimeException;
                    if (c2104a == null) {
                        return;
                    }
                    q.a(h.this.f55635b, "interval", c2104a.f55598d);
                    q.a(h.this.f55635b, "lastUpdateTime", System.currentTimeMillis());
                    if (c2104a.b()) {
                        String a = Loader.get().a(h.this.f55635b);
                        com.kwad.sdk.api.loader.f.a(h.this.f55635b, com.kwad.sdk.api.loader.f.f55608b, "");
                        cVar2 = cVar;
                        runtimeException = new RuntimeException("DynamicType == -1, curVersion: " + a);
                    } else if (com.kwad.sdk.api.loader.f.a(c2104a.f55599e, Loader.get().a(h.this.f55635b)) && c2104a.a()) {
                        cVar.a((c) c2104a);
                        String str = "new Verson: " + c2104a.f55599e;
                        return;
                    } else {
                        cVar2 = cVar;
                        runtimeException = new RuntimeException("No new sdkVersion. remote sdkVersion:" + c2104a.f55599e + " currentDynamicVersion:" + Loader.get().a(h.this.f55635b) + " dynamicType:" + c2104a.a);
                    }
                    cVar2.a((Throwable) runtimeException);
                }

                @Override // com.kwad.sdk.api.loader.k.c
                public void a(Throwable th) {
                    cVar.a(th);
                }
            });
        }
    }

    public static f<Boolean> a(String str, IKsAdSDK iKsAdSDK) {
        Context context = Loader.get().getContext();
        return new e(new g(new d(new h(new b(str, iKsAdSDK), context), context), context), context);
    }
}
