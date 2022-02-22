package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.download.a.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f56564b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56565c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.core.download.a.b f56566d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public c f56567e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public d f56568f;

    /* loaded from: classes4.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public boolean a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public boolean f56571b;

        /* renamed from: c  reason: collision with root package name */
        public int f56572c;

        /* renamed from: d  reason: collision with root package name */
        public C2133b f56573d;

        /* renamed from: e  reason: collision with root package name */
        public long f56574e = -1;

        public boolean a() {
            return 1 == this.f56572c;
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.jshandler.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C2133b extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public String a;
    }

    /* loaded from: classes4.dex */
    public interface c {
        @WorkerThread
        void a(@Nullable a aVar);
    }

    /* loaded from: classes4.dex */
    public interface d {
        @MainThread
        void a(int i2);
    }

    public b(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable c cVar) {
        this(aVar, bVar, cVar, false);
    }

    public b(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable c cVar, boolean z) {
        this.f56565c = false;
        this.f56565c = z;
        this.f56564b = new Handler(Looper.getMainLooper());
        this.a = aVar;
        this.f56566d = bVar;
        if (bVar != null) {
            bVar.a(1);
        }
        this.f56567e = cVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Handler handler;
        Runnable runnable;
        if (this.a.c()) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        final a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.a = true;
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (!this.a.f56545h) {
            if (this.f56567e != null) {
                handler = this.f56564b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f56567e != null) {
                            b.this.f56567e.a(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.f56564b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a.f56546i || aVar.f56571b) {
                    int a2 = com.kwad.sdk.core.download.a.a.a(b.this.a.f56541d.getContext(), b.this.a.a(), new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.b.1.1
                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            if (b.this.f56567e != null) {
                                b.this.f56567e.a(aVar);
                            }
                        }
                    }, b.this.f56566d, aVar.f56571b, b.this.f56565c);
                    if (b.this.f56568f != null) {
                        b.this.f56568f.a(a2);
                    }
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f56564b.removeCallbacksAndMessages(null);
        this.f56567e = null;
    }
}
