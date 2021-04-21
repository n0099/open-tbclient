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
        public c f32193a;

        public a(c cVar) {
            this.f32193a = cVar;
        }

        @Override // com.kwad.sdk.api.loader.k.c
        public void a(Throwable th) {
            this.f32193a.a(th);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements f<a.C0372a> {

        /* renamed from: a  reason: collision with root package name */
        public String f32194a;

        public b(String str) {
            this.f32194a = str;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0372a> cVar) {
            try {
                new com.kwad.sdk.api.loader.e(this.f32194a).a(new e.a() { // from class: com.kwad.sdk.api.loader.k.b.1
                    @Override // com.kwad.sdk.api.loader.e.a
                    public void a(a.b bVar) {
                        if (bVar == null || !bVar.a()) {
                            cVar.a((Throwable) new RuntimeException("UpdateData is illegal"));
                        } else {
                            cVar.a((c) bVar.f32165c);
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
    public static class d implements f<a.C0372a> {

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0372a> f32197a;

        /* renamed from: b  reason: collision with root package name */
        public Context f32198b;

        public d(f<a.C0372a> fVar, Context context) {
            this.f32197a = fVar;
            this.f32198b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0372a> cVar) {
            this.f32197a.a(new a<a.C0372a>(cVar) { // from class: com.kwad.sdk.api.loader.k.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C0372a c0372a) {
                    final File a2 = com.kwad.sdk.api.loader.g.a(d.this.f32198b, c0372a.f32161e);
                    final IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                    if (ksAdSDKImpl != null) {
                        ksAdSDKImpl.reportBatchEvent(60, null);
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    com.kwad.sdk.api.loader.h.a(c0372a.f32158b, a2.getPath(), new h.a() { // from class: com.kwad.sdk.api.loader.k.d.1.1
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
                            a.C0372a c0372a2 = c0372a;
                            c0372a2.f32162f = file;
                            cVar.a((c) c0372a2);
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
        public f<a.C0372a> f32206a;

        /* renamed from: b  reason: collision with root package name */
        public Context f32207b;

        public e(f<a.C0372a> fVar, Context context) {
            this.f32206a = fVar;
            this.f32207b = context;
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
            this.f32206a.a(new c<a.C0372a>() { // from class: com.kwad.sdk.api.loader.k.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C0372a c0372a) {
                    try {
                        if (!e.this.a(e.this.f32207b)) {
                            cVar.a((Throwable) new RuntimeException("not main process"));
                            return;
                        }
                        IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                        if (ksAdSDKImpl != null) {
                            ksAdSDKImpl.reportBatchEvent(63, null);
                        }
                        if (!com.kwad.sdk.api.loader.b.a(e.this.f32207b, c0372a.f32162f.getPath(), c0372a.f32161e)) {
                            throw new RuntimeException("Apk pre install failed");
                        }
                        com.kwad.sdk.api.loader.f.a(e.this.f32207b, com.kwad.sdk.api.loader.f.f32173a, c0372a.f32161e);
                        cVar.a((c) Boolean.TRUE);
                        com.kwad.sdk.api.loader.g.a(c0372a.f32162f);
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
    public static class g implements f<a.C0372a> {

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0372a> f32210a;

        /* renamed from: b  reason: collision with root package name */
        public Context f32211b;

        public g(f<a.C0372a> fVar, Context context) {
            this.f32210a = fVar;
            this.f32211b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0372a> cVar) {
            this.f32210a.a(new a<a.C0372a>(cVar) { // from class: com.kwad.sdk.api.loader.k.g.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C0372a c0372a) {
                    File file;
                    if (c0372a == null || (file = c0372a.f32162f) == null) {
                        return;
                    }
                    SecurityChecker.a(file, c0372a, new SecurityChecker.a() { // from class: com.kwad.sdk.api.loader.k.g.1.1
                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(Exception exc) {
                            cVar.a((Throwable) exc);
                        }

                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(boolean z, SecurityChecker.State state) {
                            if (z) {
                                cVar.a((c) c0372a);
                                return;
                            }
                            com.kwad.sdk.api.loader.g.a(c0372a.f32162f);
                            c cVar2 = cVar;
                            cVar2.a((Throwable) new RuntimeException("Security check failed. state = " + state));
                        }
                    });
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements f<a.C0372a> {

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0372a> f32216a;

        /* renamed from: b  reason: collision with root package name */
        public Context f32217b;

        public h(f<a.C0372a> fVar, Context context) {
            this.f32216a = fVar;
            this.f32217b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C0372a> cVar) {
            this.f32216a.a(new c<a.C0372a>() { // from class: com.kwad.sdk.api.loader.k.h.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C0372a c0372a) {
                    c cVar2;
                    RuntimeException runtimeException;
                    if (c0372a == null) {
                        return;
                    }
                    q.a(h.this.f32217b, "interval", c0372a.f32160d);
                    q.a(h.this.f32217b, "lastUpdateTime", System.currentTimeMillis());
                    if (c0372a.b()) {
                        String a2 = Loader.get().a(h.this.f32217b);
                        com.kwad.sdk.api.loader.f.a(h.this.f32217b, com.kwad.sdk.api.loader.f.f32174b, "");
                        cVar2 = cVar;
                        runtimeException = new RuntimeException("DynamicType == -1, curVersion: " + a2);
                    } else if (com.kwad.sdk.api.loader.f.a(c0372a.f32161e, Loader.get().a(h.this.f32217b)) && c0372a.a()) {
                        cVar.a((c) c0372a);
                        Log.w("maple", "new Verson: " + c0372a.f32161e);
                        return;
                    } else {
                        cVar2 = cVar;
                        runtimeException = new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0372a.f32161e + " currentDynamicVersion:" + Loader.get().a(h.this.f32217b) + " dynamicType:" + c0372a.f32157a);
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
