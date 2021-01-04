package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.download.b.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.core.webview.a f9850a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f9851b = new Handler(Looper.getMainLooper());
    @Nullable
    private final com.kwad.sdk.core.download.b.b c;
    @Nullable
    private b d;

    /* renamed from: com.kwad.sdk.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1080a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9857a;
    }

    /* loaded from: classes5.dex */
    public interface b {
        @WorkerThread
        void a();
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable b bVar2) {
        this.f9850a = aVar;
        this.c = bVar;
        if (bVar != null) {
            this.c.a(1);
        }
        this.d = bVar2;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        if (this.f9850a.f9836b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        final C1080a c1080a = new C1080a();
        try {
            c1080a.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        if (this.f9850a.g) {
            this.f9851b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.kwad.sdk.core.download.b.b.a(a.this.c, c1080a.f9857a);
                    com.kwad.sdk.core.download.b.a.a(a.this.f9850a.e.getContext(), a.this.f9850a.f9836b, new a.InterfaceC1064a() { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC1064a
                        public void a() {
                            if (a.this.d != null) {
                                a.this.d.a();
                            }
                        }
                    }, a.this.c);
                }
            });
        } else if (this.d != null) {
            this.f9851b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.kwad.sdk.core.download.b.b.a(a.this.c, c1080a.f9857a);
                    if (a.this.d != null) {
                        a.this.d.a();
                    }
                }
            });
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f9851b.removeCallbacksAndMessages(null);
        this.d = null;
    }
}
