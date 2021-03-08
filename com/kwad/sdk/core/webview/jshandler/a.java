package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.download.b.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.core.webview.a f6328a;
    private Handler b = new Handler(Looper.getMainLooper());
    @Nullable
    private final com.kwad.sdk.core.download.b.b c;
    @Nullable
    private b d;

    /* renamed from: com.kwad.sdk.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1127a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f6332a;
    }

    /* loaded from: classes3.dex */
    public interface b {
        @WorkerThread
        void a();
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable b bVar2) {
        this.f6328a = aVar;
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
        if (this.f6328a.b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        final C1127a c1127a = new C1127a();
        try {
            c1127a.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        if (this.f6328a.g) {
            this.b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.kwad.sdk.core.download.b.b.a(a.this.c, c1127a.f6332a);
                    com.kwad.sdk.core.download.b.a.a(a.this.f6328a.e.getContext(), a.this.f6328a.b, new a.InterfaceC1111a() { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC1111a
                        public void a() {
                            if (a.this.d != null) {
                                a.this.d.a();
                            }
                        }
                    }, a.this.c);
                }
            });
        } else if (this.d != null) {
            this.b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.kwad.sdk.core.download.b.b.a(a.this.c, c1127a.f6332a);
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
        this.b.removeCallbacksAndMessages(null);
        this.d = null;
    }
}
