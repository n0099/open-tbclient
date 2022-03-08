package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class l implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f54970b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final b f54971c;

    /* loaded from: classes8.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f54975b;

        /* renamed from: c  reason: collision with root package name */
        public int f54976c;

        /* renamed from: d  reason: collision with root package name */
        public b.C2112b f54977d;
    }

    /* loaded from: classes8.dex */
    public interface b {
        @MainThread
        void a();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        final com.kwad.sdk.core.download.a.b bVar;
        final a aVar = new a();
        final AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.f54975b));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (com.kwad.sdk.core.response.a.d.c(adTemplate)) {
            if (this.a.f54894g != null) {
                bVar = this.a.f54894g.a(com.kwad.sdk.core.response.a.d.j(adTemplate).downloadId);
            } else {
                bVar = null;
            }
            if (this.a.f54895h) {
                this.f54970b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.l.1
                    @Override // java.lang.Runnable
                    public void run() {
                        p.a aVar2 = new p.a();
                        aVar2.f54629h = aVar.f54977d.a;
                        com.kwad.sdk.core.download.a.a.a(new a.C2095a(l.this.a.f54891d.getContext()).a(adTemplate).a(bVar).a(aVar.f54976c).a(true).a(aVar2).c(true).a(new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.l.1.1
                            @Override // com.kwad.sdk.core.download.a.a.b
                            public void a() {
                                if (l.this.f54971c != null) {
                                    l.this.f54971c.a();
                                }
                            }
                        }));
                    }
                });
            } else if (this.f54971c != null) {
                this.f54970b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.l.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (l.this.f54971c != null) {
                            l.this.f54971c.a();
                        }
                    }
                });
            }
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f54970b.removeCallbacksAndMessages(null);
    }
}
