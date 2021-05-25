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
        public c f31778a;

        public a(c cVar) {
            this.f31778a = cVar;
        }

        @Override // com.kwad.sdk.api.loader.k.c
        public void a(Throwable th) {
            this.f31778a.a(th);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements f<a.C0351a> {

        /* renamed from: a  reason: collision with root package name */
        public String f31779a;

        public b(String str) {
            this.f31779a = str;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0351a> cVar) {
            try {
                new com.kwad.sdk.api.loader.e(this.f31779a).a(new e.a() { // from class: com.kwad.sdk.api.loader.k.b.1
                    @Override // com.kwad.sdk.api.loader.e.a
                    public void a(a.b bVar) {
                        if (bVar == null || !bVar.a()) {
                            cVar.a((Throwable) new RuntimeException("UpdateData is illegal"));
                        } else {
                            cVar.a((c) bVar.f31750c);
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
    public static class d implements f<a.C0351a> {

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0351a> f31782a;

        /* renamed from: b  reason: collision with root package name */
        public Context f31783b;

        public d(f<a.C0351a> fVar, Context context) {
            this.f31782a = fVar;
            this.f31783b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0351a> cVar) {
            this.f31782a.a(new a<a.C0351a>(cVar) { // from class: com.kwad.sdk.api.loader.k.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C0351a c0351a) {
                    final File a2 = com.kwad.sdk.api.loader.g.a(d.this.f31783b, c0351a.f31746e);
                    final IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                    if (ksAdSDKImpl != null) {
                        ksAdSDKImpl.reportBatchEvent(60, null);
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    com.kwad.sdk.api.loader.h.a(c0351a.f31743b, a2.getPath(), new h.a() { // from class: com.kwad.sdk.api.loader.k.d.1.1
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
                            a.C0351a c0351a2 = c0351a;
                            c0351a2.f31747f = file;
                            cVar.a((c) c0351a2);
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
        public f<a.C0351a> f31791a;

        /* renamed from: b  reason: collision with root package name */
        public Context f31792b;

        public e(f<a.C0351a> fVar, Context context) {
            this.f31791a = fVar;
            this.f31792b = context;
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
            this.f31791a.a(new c<a.C0351a>() { // from class: com.kwad.sdk.api.loader.k.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C0351a c0351a) {
                    try {
                        if (!e.this.a(e.this.f31792b)) {
                            cVar.a((Throwable) new RuntimeException("not main process"));
                            return;
                        }
                        IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                        if (ksAdSDKImpl != null) {
                            ksAdSDKImpl.reportBatchEvent(63, null);
                        }
                        if (!com.kwad.sdk.api.loader.b.a(e.this.f31792b, c0351a.f31747f.getPath(), c0351a.f31746e)) {
                            throw new RuntimeException("Apk pre install failed");
                        }
                        com.kwad.sdk.api.loader.f.a(e.this.f31792b, com.kwad.sdk.api.loader.f.f31758a, c0351a.f31746e);
                        cVar.a((c) Boolean.TRUE);
                        com.kwad.sdk.api.loader.g.a(c0351a.f31747f);
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
    public static class g implements f<a.C0351a> {

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0351a> f31795a;

        /* renamed from: b  reason: collision with root package name */
        public Context f31796b;

        public g(f<a.C0351a> fVar, Context context) {
            this.f31795a = fVar;
            this.f31796b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0351a> cVar) {
            this.f31795a.a(new a<a.C0351a>(cVar) { // from class: com.kwad.sdk.api.loader.k.g.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C0351a c0351a) {
                    File file;
                    if (c0351a == null || (file = c0351a.f31747f) == null) {
                        return;
                    }
                    SecurityChecker.a(file, c0351a, new SecurityChecker.a() { // from class: com.kwad.sdk.api.loader.k.g.1.1
                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(Exception exc) {
                            cVar.a((Throwable) exc);
                        }

                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(boolean z, SecurityChecker.State state) {
                            if (z) {
                                cVar.a((c) c0351a);
                                return;
                            }
                            com.kwad.sdk.api.loader.g.a(c0351a.f31747f);
                            c cVar2 = cVar;
                            cVar2.a((Throwable) new RuntimeException("Security check failed. state = " + state));
                        }
                    });
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements f<a.C0351a> {

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0351a> f31801a;

        /* renamed from: b  reason: collision with root package name */
        public Context f31802b;

        public h(f<a.C0351a> fVar, Context context) {
            this.f31801a = fVar;
            this.f31802b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0351a> cVar) {
            this.f31801a.a(new c<a.C0351a>() { // from class: com.kwad.sdk.api.loader.k.h.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C0351a c0351a) {
                    c cVar2;
                    RuntimeException runtimeException;
                    if (c0351a == null) {
                        return;
                    }
                    q.a(h.this.f31802b, "interval", c0351a.f31745d);
                    q.a(h.this.f31802b, "lastUpdateTime", System.currentTimeMillis());
                    if (c0351a.b()) {
                        String a2 = Loader.get().a(h.this.f31802b);
                        com.kwad.sdk.api.loader.f.a(h.this.f31802b, com.kwad.sdk.api.loader.f.f31759b, "");
                        cVar2 = cVar;
                        runtimeException = new RuntimeException("DynamicType == -1, curVersion: " + a2);
                    } else if (com.kwad.sdk.api.loader.f.a(c0351a.f31746e, Loader.get().a(h.this.f31802b)) && c0351a.a()) {
                        cVar.a((c) c0351a);
                        Log.w("maple", "new Verson: " + c0351a.f31746e);
                        return;
                    } else {
                        cVar2 = cVar;
                        runtimeException = new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0351a.f31746e + " currentDynamicVersion:" + Loader.get().a(h.this.f31802b) + " dynamicType:" + c0351a.f31742a);
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
