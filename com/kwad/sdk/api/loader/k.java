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
        public c f32452a;

        public a(c cVar) {
            this.f32452a = cVar;
        }

        @Override // com.kwad.sdk.api.loader.k.c
        public void a(Throwable th) {
            this.f32452a.a(th);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements f<a.C0358a> {

        /* renamed from: a  reason: collision with root package name */
        public String f32453a;

        public b(String str) {
            this.f32453a = str;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0358a> cVar) {
            try {
                new com.kwad.sdk.api.loader.e(this.f32453a).a(new e.a() { // from class: com.kwad.sdk.api.loader.k.b.1
                    @Override // com.kwad.sdk.api.loader.e.a
                    public void a(a.b bVar) {
                        if (bVar == null || !bVar.a()) {
                            cVar.a((Throwable) new RuntimeException("UpdateData is illegal"));
                        } else {
                            cVar.a((c) bVar.f32424c);
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
    public static class d implements f<a.C0358a> {

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0358a> f32456a;

        /* renamed from: b  reason: collision with root package name */
        public Context f32457b;

        public d(f<a.C0358a> fVar, Context context) {
            this.f32456a = fVar;
            this.f32457b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0358a> cVar) {
            this.f32456a.a(new a<a.C0358a>(cVar) { // from class: com.kwad.sdk.api.loader.k.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C0358a c0358a) {
                    final File a2 = com.kwad.sdk.api.loader.g.a(d.this.f32457b, c0358a.f32420e);
                    final IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                    if (ksAdSDKImpl != null) {
                        ksAdSDKImpl.reportBatchEvent(60, null);
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    com.kwad.sdk.api.loader.h.a(c0358a.f32417b, a2.getPath(), new h.a() { // from class: com.kwad.sdk.api.loader.k.d.1.1
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
                            a.C0358a c0358a2 = c0358a;
                            c0358a2.f32421f = file;
                            cVar.a((c) c0358a2);
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
        public f<a.C0358a> f32465a;

        /* renamed from: b  reason: collision with root package name */
        public Context f32466b;

        public e(f<a.C0358a> fVar, Context context) {
            this.f32465a = fVar;
            this.f32466b = context;
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
            this.f32465a.a(new c<a.C0358a>() { // from class: com.kwad.sdk.api.loader.k.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C0358a c0358a) {
                    try {
                        if (!e.this.a(e.this.f32466b)) {
                            cVar.a((Throwable) new RuntimeException("not main process"));
                            return;
                        }
                        IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                        if (ksAdSDKImpl != null) {
                            ksAdSDKImpl.reportBatchEvent(63, null);
                        }
                        if (!com.kwad.sdk.api.loader.b.a(e.this.f32466b, c0358a.f32421f.getPath(), c0358a.f32420e)) {
                            throw new RuntimeException("Apk pre install failed");
                        }
                        com.kwad.sdk.api.loader.f.a(e.this.f32466b, com.kwad.sdk.api.loader.f.f32432a, c0358a.f32420e);
                        cVar.a((c) Boolean.TRUE);
                        com.kwad.sdk.api.loader.g.a(c0358a.f32421f);
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
    public static class g implements f<a.C0358a> {

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0358a> f32469a;

        /* renamed from: b  reason: collision with root package name */
        public Context f32470b;

        public g(f<a.C0358a> fVar, Context context) {
            this.f32469a = fVar;
            this.f32470b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0358a> cVar) {
            this.f32469a.a(new a<a.C0358a>(cVar) { // from class: com.kwad.sdk.api.loader.k.g.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C0358a c0358a) {
                    File file;
                    if (c0358a == null || (file = c0358a.f32421f) == null) {
                        return;
                    }
                    SecurityChecker.a(file, c0358a, new SecurityChecker.a() { // from class: com.kwad.sdk.api.loader.k.g.1.1
                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(Exception exc) {
                            cVar.a((Throwable) exc);
                        }

                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(boolean z, SecurityChecker.State state) {
                            if (z) {
                                cVar.a((c) c0358a);
                                return;
                            }
                            com.kwad.sdk.api.loader.g.a(c0358a.f32421f);
                            c cVar2 = cVar;
                            cVar2.a((Throwable) new RuntimeException("Security check failed. state = " + state));
                        }
                    });
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements f<a.C0358a> {

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0358a> f32475a;

        /* renamed from: b  reason: collision with root package name */
        public Context f32476b;

        public h(f<a.C0358a> fVar, Context context) {
            this.f32475a = fVar;
            this.f32476b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0358a> cVar) {
            this.f32475a.a(new c<a.C0358a>() { // from class: com.kwad.sdk.api.loader.k.h.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C0358a c0358a) {
                    c cVar2;
                    RuntimeException runtimeException;
                    if (c0358a == null) {
                        return;
                    }
                    q.a(h.this.f32476b, "interval", c0358a.f32419d);
                    q.a(h.this.f32476b, "lastUpdateTime", System.currentTimeMillis());
                    if (c0358a.b()) {
                        String a2 = Loader.get().a(h.this.f32476b);
                        com.kwad.sdk.api.loader.f.a(h.this.f32476b, com.kwad.sdk.api.loader.f.f32433b, "");
                        cVar2 = cVar;
                        runtimeException = new RuntimeException("DynamicType == -1, curVersion: " + a2);
                    } else if (com.kwad.sdk.api.loader.f.a(c0358a.f32420e, Loader.get().a(h.this.f32476b)) && c0358a.a()) {
                        cVar.a((c) c0358a);
                        Log.w("maple", "new Verson: " + c0358a.f32420e);
                        return;
                    } else {
                        cVar2 = cVar;
                        runtimeException = new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0358a.f32420e + " currentDynamicVersion:" + Loader.get().a(h.this.f32476b) + " dynamicType:" + c0358a.f32416a);
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
