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
/* loaded from: classes5.dex */
public class k {

    /* loaded from: classes5.dex */
    private static abstract class a<T> implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        c f8512a;

        a(c cVar) {
            this.f8512a = cVar;
        }

        @Override // com.kwad.sdk.api.loader.k.c
        public void a(Throwable th) {
            this.f8512a.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements f<a.C1081a> {

        /* renamed from: a  reason: collision with root package name */
        private String f8513a;

        b(String str) {
            this.f8513a = str;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C1081a> cVar) {
            try {
                new com.kwad.sdk.api.loader.e(this.f8513a).a(new e.a() { // from class: com.kwad.sdk.api.loader.k.b.1
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

    /* loaded from: classes5.dex */
    public interface c<T> {
        void a(T t);

        void a(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class d implements f<a.C1081a> {

        /* renamed from: a  reason: collision with root package name */
        f<a.C1081a> f8516a;

        /* renamed from: b  reason: collision with root package name */
        Context f8517b;

        d(f<a.C1081a> fVar, Context context) {
            this.f8516a = fVar;
            this.f8517b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C1081a> cVar) {
            this.f8516a.a(new a<a.C1081a>(cVar) { // from class: com.kwad.sdk.api.loader.k.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C1081a c1081a) {
                    final File a2 = com.kwad.sdk.api.loader.g.a(d.this.f8517b, c1081a.e);
                    final IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                    if (ksAdSDKImpl != null) {
                        ksAdSDKImpl.reportBatchEvent(60, null);
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    com.kwad.sdk.api.loader.h.a(c1081a.f8490b, a2.getPath(), new h.a() { // from class: com.kwad.sdk.api.loader.k.d.1.1
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
                            c1081a.f = file;
                            cVar.a((c) c1081a);
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
    /* loaded from: classes5.dex */
    public static class e implements f<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        f<a.C1081a> f8521a;

        /* renamed from: b  reason: collision with root package name */
        Context f8522b;

        e(f<a.C1081a> fVar, Context context) {
            this.f8521a = fVar;
            this.f8522b = context;
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
            this.f8521a.a(new c<a.C1081a>() { // from class: com.kwad.sdk.api.loader.k.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C1081a c1081a) {
                    try {
                        if (!e.this.a(e.this.f8522b)) {
                            cVar.a((Throwable) new RuntimeException("not main process"));
                            return;
                        }
                        IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                        if (ksAdSDKImpl != null) {
                            ksAdSDKImpl.reportBatchEvent(63, null);
                        }
                        if (!com.kwad.sdk.api.loader.b.a(e.this.f8522b, c1081a.f.getPath(), c1081a.e)) {
                            throw new RuntimeException("Apk pre install failed");
                        }
                        com.kwad.sdk.api.loader.f.a(e.this.f8522b, com.kwad.sdk.api.loader.f.f8499a, c1081a.e);
                        cVar.a((c) true);
                        com.kwad.sdk.api.loader.g.a(c1081a.f);
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

    /* loaded from: classes5.dex */
    public interface f<T> {
        void a(c<T> cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class g implements f<a.C1081a> {

        /* renamed from: a  reason: collision with root package name */
        f<a.C1081a> f8525a;

        /* renamed from: b  reason: collision with root package name */
        Context f8526b;

        g(f<a.C1081a> fVar, Context context) {
            this.f8525a = fVar;
            this.f8526b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C1081a> cVar) {
            this.f8525a.a(new a<a.C1081a>(cVar) { // from class: com.kwad.sdk.api.loader.k.g.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(final a.C1081a c1081a) {
                    if (c1081a == null || c1081a.f == null) {
                        return;
                    }
                    SecurityChecker.a(c1081a.f, c1081a, new SecurityChecker.a() { // from class: com.kwad.sdk.api.loader.k.g.1.1
                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(Exception exc) {
                            cVar.a((Throwable) exc);
                        }

                        @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                        public void a(boolean z, SecurityChecker.State state) {
                            if (z) {
                                cVar.a((c) c1081a);
                                return;
                            }
                            com.kwad.sdk.api.loader.g.a(c1081a.f);
                            cVar.a((Throwable) new RuntimeException("Security check failed. state = " + state));
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class h implements f<a.C1081a> {

        /* renamed from: a  reason: collision with root package name */
        f<a.C1081a> f8530a;

        /* renamed from: b  reason: collision with root package name */
        Context f8531b;

        h(f<a.C1081a> fVar, Context context) {
            this.f8530a = fVar;
            this.f8531b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(final c<a.C1081a> cVar) {
            this.f8530a.a(new c<a.C1081a>() { // from class: com.kwad.sdk.api.loader.k.h.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.api.loader.k.c
                public void a(a.C1081a c1081a) {
                    if (c1081a == null) {
                        return;
                    }
                    q.a(h.this.f8531b, "interval", c1081a.d);
                    q.a(h.this.f8531b, "lastUpdateTime", System.currentTimeMillis());
                    if (c1081a.b()) {
                        String a2 = Loader.get().a(h.this.f8531b);
                        com.kwad.sdk.api.loader.f.a(h.this.f8531b, com.kwad.sdk.api.loader.f.f8500b, "");
                        cVar.a((Throwable) new RuntimeException("DynamicType == -1, curVersion: " + a2));
                    } else if (!com.kwad.sdk.api.loader.f.a(c1081a.e, Loader.get().a(h.this.f8531b)) || !c1081a.a()) {
                        cVar.a((Throwable) new RuntimeException("No new sdkVersion. remote sdkVersion:" + c1081a.e + " currentDynamicVersion:" + Loader.get().a(h.this.f8531b) + " dynamicType:" + c1081a.f8489a));
                    } else {
                        cVar.a((c) c1081a);
                        Log.w("maple", "new Verson: " + c1081a.e);
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
