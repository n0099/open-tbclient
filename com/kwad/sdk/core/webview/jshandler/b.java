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
/* loaded from: classes8.dex */
public class b implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f54914b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54915c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.core.download.a.b f54916d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public c f54917e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public d f54918f;

    /* loaded from: classes8.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public boolean a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public boolean f54921b;

        /* renamed from: c  reason: collision with root package name */
        public int f54922c;

        /* renamed from: d  reason: collision with root package name */
        public C2112b f54923d;

        /* renamed from: e  reason: collision with root package name */
        public long f54924e = -1;

        public boolean a() {
            return 1 == this.f54922c;
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.jshandler.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C2112b extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public String a;
    }

    /* loaded from: classes8.dex */
    public interface c {
        @WorkerThread
        void a(@Nullable a aVar);
    }

    /* loaded from: classes8.dex */
    public interface d {
        @MainThread
        void a(int i2);
    }

    public b(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable c cVar) {
        this(aVar, bVar, cVar, false);
    }

    public b(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable c cVar, boolean z) {
        this.f54915c = false;
        this.f54915c = z;
        this.f54914b = new Handler(Looper.getMainLooper());
        this.a = aVar;
        this.f54916d = bVar;
        if (bVar != null) {
            bVar.a(1);
        }
        this.f54917e = cVar;
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
        if (!this.a.f54895h) {
            if (this.f54917e != null) {
                handler = this.f54914b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f54917e != null) {
                            b.this.f54917e.a(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.f54914b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a.f54896i || aVar.f54921b) {
                    int a2 = com.kwad.sdk.core.download.a.a.a(b.this.a.f54891d.getContext(), b.this.a.a(), new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.b.1.1
                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            if (b.this.f54917e != null) {
                                b.this.f54917e.a(aVar);
                            }
                        }
                    }, b.this.f54916d, aVar.f54921b, b.this.f54915c);
                    if (b.this.f54918f != null) {
                        b.this.f54918f.a(a2);
                    }
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f54914b.removeCallbacksAndMessages(null);
        this.f54917e = null;
    }
}
