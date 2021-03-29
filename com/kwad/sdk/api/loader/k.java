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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class k {

    /* loaded from: classes6.dex */
    public static abstract class a<T> implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        public c f31809a;

        public a(c cVar) {
            this.f31809a = cVar;
        }

        @Override // com.kwad.sdk.api.loader.k.c
        public void a(Throwable th) {
            this.f31809a.a(th);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements f<a.C0355a> {

        /* renamed from: a  reason: collision with root package name */
        public String f31810a;

        public b(String str) {
            this.f31810a = str;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0355a> cVar) {
            try {
                new com.kwad.sdk.api.loader.e(this.f31810a).a(new e.a() { // from class: com.kwad.sdk.api.loader.k.b.1
                    @Override // com.kwad.sdk.api.loader.e.a
                    public void a(a.b bVar) {
                        if (bVar == null || !bVar.a()) {
                            cVar.a((Throwable) new RuntimeException("UpdateData is illegal"));
                        } else {
                            cVar.a((c) bVar.f31781c);
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

    /* loaded from: classes6.dex */
    public interface c<T> {
        void a(T t);

        void a(Throwable th);
    }

    /* loaded from: classes6.dex */
    public static class d implements f<a.C0355a> {

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0355a> f31813a;

        /* renamed from: b  reason: collision with root package name */
        public Context f31814b;

        public d(f<a.C0355a> fVar, Context context) {
            this.f31813a = fVar;
            this.f31814b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0355a> cVar) {
            this.f31813a.a(new a<a.C0355a>(cVar) { // from class: com.kwad.sdk.api.loader.k.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C0355a c0355a) {
                    final File a2 = com.kwad.sdk.api.loader.g.a(d.this.f31814b, c0355a.f31777e);
                    final IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                    if (ksAdSDKImpl != null) {
                        ksAdSDKImpl.reportBatchEvent(60, null);
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    com.kwad.sdk.api.loader.h.a(c0355a.f31774b, a2.getPath(), new h.a() { // from class: com.kwad.sdk.api.loader.k.d.1.1
                        @Override // com.kwad.sdk.api.loader.h.a
                        public void a() {
                            try {
                                com.kwad.sdk.api.loader.g.a(a2);
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
                            a.C0355a c0355a2 = c0355a;
                            c0355a2.f31778f = file;
                            cVar.a((c) c0355a2);
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

    /* loaded from: classes6.dex */
    public static class e implements f<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0355a> f31822a;

        /* renamed from: b  reason: collision with root package name */
        public Context f31823b;

        public e(f<a.C0355a> fVar, Context context) {
            this.f31822a = fVar;
            this.f31823b = context;
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
            this.f31822a.a(new c<a.C0355a>() { // from class: com.kwad.sdk.api.loader.k.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C0355a c0355a) {
                    try {
                        if (!e.this.a(e.this.f31823b)) {
                            cVar.a((Throwable) new RuntimeException("not main process"));
                            return;
                        }
                        IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                        if (ksAdSDKImpl != null) {
                            ksAdSDKImpl.reportBatchEvent(63, null);
                        }
                        if (!com.kwad.sdk.api.loader.b.a(e.this.f31823b, c0355a.f31778f.getPath(), c0355a.f31777e)) {
                            throw new RuntimeException("Apk pre install failed");
                        }
                        com.kwad.sdk.api.loader.f.a(e.this.f31823b, com.kwad.sdk.api.loader.f.f31789a, c0355a.f31777e);
                        cVar.a((c) Boolean.TRUE);
                        com.kwad.sdk.api.loader.g.a(c0355a.f31778f);
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

    /* loaded from: classes6.dex */
    public interface f<T> {
        void a(c<T> cVar);
    }

    /* loaded from: classes6.dex */
    public static class g implements f<a.C0355a> {

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0355a> f31826a;

        /* renamed from: b  reason: collision with root package name */
        public Context f31827b;

        public g(f<a.C0355a> fVar, Context context) {
            this.f31826a = fVar;
            this.f31827b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0355a> cVar) {
            this.f31826a.a(new a<a.C0355a>(cVar) { // from class: com.kwad.sdk.api.loader.k.g.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C0355a c0355a) {
                    File file;
                    if (c0355a == null || (file = c0355a.f31778f) == null) {
                        return;
                    }
                    SecurityChecker.a(file, c0355a, new SecurityChecker.a() { // from class: com.kwad.sdk.api.loader.k.g.1.1
                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(Exception exc) {
                            cVar.a((Throwable) exc);
                        }

                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(boolean z, SecurityChecker.State state) {
                            if (z) {
                                cVar.a((c) c0355a);
                                return;
                            }
                            com.kwad.sdk.api.loader.g.a(c0355a.f31778f);
                            c cVar2 = cVar;
                            cVar2.a((Throwable) new RuntimeException("Security check failed. state = " + state));
                        }
                    });
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements f<a.C0355a> {

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0355a> f31832a;

        /* renamed from: b  reason: collision with root package name */
        public Context f31833b;

        public h(f<a.C0355a> fVar, Context context) {
            this.f31832a = fVar;
            this.f31833b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0355a> cVar) {
            this.f31832a.a(new c<a.C0355a>() { // from class: com.kwad.sdk.api.loader.k.h.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C0355a c0355a) {
                    c cVar2;
                    RuntimeException runtimeException;
                    if (c0355a == null) {
                        return;
                    }
                    q.a(h.this.f31833b, "interval", c0355a.f31776d);
                    q.a(h.this.f31833b, "lastUpdateTime", System.currentTimeMillis());
                    if (c0355a.b()) {
                        String a2 = Loader.get().a(h.this.f31833b);
                        com.kwad.sdk.api.loader.f.a(h.this.f31833b, com.kwad.sdk.api.loader.f.f31790b, "");
                        cVar2 = cVar;
                        runtimeException = new RuntimeException("DynamicType == -1, curVersion: " + a2);
                    } else if (com.kwad.sdk.api.loader.f.a(c0355a.f31777e, Loader.get().a(h.this.f31833b)) && c0355a.a()) {
                        cVar.a((c) c0355a);
                        Log.w("maple", "new Verson: " + c0355a.f31777e);
                        return;
                    } else {
                        cVar2 = cVar;
                        runtimeException = new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0355a.f31777e + " currentDynamicVersion:" + Loader.get().a(h.this.f31833b) + " dynamicType:" + c0355a.f31773a);
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

    public static f<Boolean> a(String str) {
        Context context = Loader.get().getContext();
        return new e(new g(new d(new h(new b(str), context), context), context), context);
    }
}
