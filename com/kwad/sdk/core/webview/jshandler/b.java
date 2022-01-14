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
/* loaded from: classes3.dex */
public class b implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f56352b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56353c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.core.download.a.b f56354d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public c f56355e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public d f56356f;

    /* loaded from: classes3.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public boolean a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public boolean f56359b;

        /* renamed from: c  reason: collision with root package name */
        public int f56360c;

        /* renamed from: d  reason: collision with root package name */
        public C2117b f56361d;

        /* renamed from: e  reason: collision with root package name */
        public long f56362e = -1;

        public boolean a() {
            return 1 == this.f56360c;
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.jshandler.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C2117b extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public String a;
    }

    /* loaded from: classes3.dex */
    public interface c {
        @WorkerThread
        void a(@Nullable a aVar);
    }

    /* loaded from: classes3.dex */
    public interface d {
        @MainThread
        void a(int i2);
    }

    public b(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable c cVar) {
        this(aVar, bVar, cVar, false);
    }

    public b(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable c cVar, boolean z) {
        this.f56353c = false;
        this.f56353c = z;
        this.f56352b = new Handler(Looper.getMainLooper());
        this.a = aVar;
        this.f56354d = bVar;
        if (bVar != null) {
            bVar.a(1);
        }
        this.f56355e = cVar;
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
        if (!this.a.f56333h) {
            if (this.f56355e != null) {
                handler = this.f56352b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f56355e != null) {
                            b.this.f56355e.a(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.f56352b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a.f56334i || aVar.f56359b) {
                    int a2 = com.kwad.sdk.core.download.a.a.a(b.this.a.f56329d.getContext(), b.this.a.a(), new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.b.1.1
                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            if (b.this.f56355e != null) {
                                b.this.f56355e.a(aVar);
                            }
                        }
                    }, b.this.f56354d, aVar.f56359b, b.this.f56353c);
                    if (b.this.f56356f != null) {
                        b.this.f56356f.a(a2);
                    }
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f56352b.removeCallbacksAndMessages(null);
        this.f56355e = null;
    }
}
