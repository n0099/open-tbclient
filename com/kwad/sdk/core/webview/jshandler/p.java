package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.download.b.a;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: c  reason: collision with root package name */
    public static Handler f33749c;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f33750a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33751b;

    /* renamed from: d  reason: collision with root package name */
    public b f33752d;

    /* loaded from: classes6.dex */
    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f33756a;
    }

    /* loaded from: classes6.dex */
    public interface b {
        @WorkerThread
        void a(int i2);
    }

    public p(com.kwad.sdk.core.webview.a aVar, com.kwad.sdk.core.download.b.b bVar, b bVar2) {
        this.f33750a = aVar;
        this.f33751b = bVar;
        this.f33752d = bVar2;
        if (f33749c == null) {
            f33749c = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            final int i2 = aVar.f33756a;
            f33749c.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.p.1
                @Override // java.lang.Runnable
                public void run() {
                    com.kwad.sdk.core.download.b.a.a(p.this.f33750a.f33625e.getContext(), p.this.f33750a.f33622b, new a.InterfaceC0376a() { // from class: com.kwad.sdk.core.webview.jshandler.p.1.1
                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                        public void a() {
                            if (p.this.f33752d != null) {
                                p.this.f33752d.a(i2);
                            }
                        }
                    }, p.this.f33751b, false);
                }
            });
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
