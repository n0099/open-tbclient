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
/* loaded from: classes3.dex */
public class l implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f56453b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final b f56454c;

    /* loaded from: classes3.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f56458b;

        /* renamed from: c  reason: collision with root package name */
        public int f56459c;

        /* renamed from: d  reason: collision with root package name */
        public b.C2123b f56460d;
    }

    /* loaded from: classes3.dex */
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
            adTemplate.parseJson(new JSONObject(aVar.f56458b));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (com.kwad.sdk.core.response.a.d.c(adTemplate)) {
            if (this.a.f56377g != null) {
                bVar = this.a.f56377g.a(com.kwad.sdk.core.response.a.d.j(adTemplate).downloadId);
            } else {
                bVar = null;
            }
            if (this.a.f56378h) {
                this.f56453b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.l.1
                    @Override // java.lang.Runnable
                    public void run() {
                        p.a aVar2 = new p.a();
                        aVar2.f56112h = aVar.f56460d.a;
                        com.kwad.sdk.core.download.a.a.a(new a.C2106a(l.this.a.f56374d.getContext()).a(adTemplate).a(bVar).a(aVar.f56459c).a(true).a(aVar2).c(true).a(new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.l.1.1
                            @Override // com.kwad.sdk.core.download.a.a.b
                            public void a() {
                                if (l.this.f56454c != null) {
                                    l.this.f56454c.a();
                                }
                            }
                        }));
                    }
                });
            } else if (this.f56454c != null) {
                this.f56453b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.l.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (l.this.f56454c != null) {
                            l.this.f56454c.a();
                        }
                    }
                });
            }
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f56453b.removeCallbacksAndMessages(null);
    }
}
