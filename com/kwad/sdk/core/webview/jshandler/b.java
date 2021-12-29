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
    public Handler f58561b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58562c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.core.download.a.b f58563d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public c f58564e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public d f58565f;

    /* loaded from: classes3.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public boolean a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public boolean f58568b;

        /* renamed from: c  reason: collision with root package name */
        public int f58569c;

        /* renamed from: d  reason: collision with root package name */
        public C2100b f58570d;

        /* renamed from: e  reason: collision with root package name */
        public long f58571e = -1;

        public boolean a() {
            return 1 == this.f58569c;
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.jshandler.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C2100b extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
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
        this.f58562c = false;
        this.f58562c = z;
        this.f58561b = new Handler(Looper.getMainLooper());
        this.a = aVar;
        this.f58563d = bVar;
        if (bVar != null) {
            bVar.a(1);
        }
        this.f58564e = cVar;
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
        if (!this.a.f58542h) {
            if (this.f58564e != null) {
                handler = this.f58561b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f58564e != null) {
                            b.this.f58564e.a(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.f58561b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a.f58543i || aVar.f58568b) {
                    int a2 = com.kwad.sdk.core.download.a.a.a(b.this.a.f58538d.getContext(), b.this.a.a(), new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.b.1.1
                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            if (b.this.f58564e != null) {
                                b.this.f58564e.a(aVar);
                            }
                        }
                    }, b.this.f58563d, aVar.f58568b, b.this.f58562c);
                    if (b.this.f58565f != null) {
                        b.this.f58565f.a(a2);
                    }
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f58561b.removeCallbacksAndMessages(null);
        this.f58564e = null;
    }
}
