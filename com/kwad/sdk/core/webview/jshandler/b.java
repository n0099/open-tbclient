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
/* loaded from: classes5.dex */
public class b implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;
    public Handler b;
    public boolean c;
    @Nullable
    public final com.kwad.sdk.core.download.a.b d;
    @Nullable
    public c e;
    @Nullable
    public d f;

    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public boolean a;
        @Deprecated
        public boolean b;
        public int c;
        public C0321b d;
        public long e = -1;

        public boolean a() {
            return 1 == this.c;
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.jshandler.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0321b extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public String a;
    }

    /* loaded from: classes5.dex */
    public interface c {
        @WorkerThread
        void a(@Nullable a aVar);
    }

    /* loaded from: classes5.dex */
    public interface d {
        @MainThread
        void a(int i);
    }

    public b(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable c cVar) {
        this(aVar, bVar, cVar, false);
    }

    public b(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable c cVar, boolean z) {
        this.c = false;
        this.c = z;
        this.b = new Handler(Looper.getMainLooper());
        this.a = aVar;
        this.d = bVar;
        if (bVar != null) {
            bVar.a(1);
        }
        this.e = cVar;
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
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        if (!this.a.h) {
            if (this.e != null) {
                handler = this.b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.e != null) {
                            b.this.e.a(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a.i || aVar.b) {
                    int a2 = com.kwad.sdk.core.download.a.a.a(b.this.a.d.getContext(), b.this.a.a(), new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.b.1.1
                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            if (b.this.e != null) {
                                b.this.e.a(aVar);
                            }
                        }
                    }, b.this.d, aVar.b, b.this.c);
                    if (b.this.f != null) {
                        b.this.f.a(a2);
                    }
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.b.removeCallbacksAndMessages(null);
        this.e = null;
    }
}
