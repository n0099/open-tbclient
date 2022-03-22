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
/* loaded from: classes7.dex */
public class l implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f40056b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final b f40057c;

    /* loaded from: classes7.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f40061b;

        /* renamed from: c  reason: collision with root package name */
        public int f40062c;

        /* renamed from: d  reason: collision with root package name */
        public b.C1973b f40063d;
    }

    /* loaded from: classes7.dex */
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
            adTemplate.parseJson(new JSONObject(aVar.f40061b));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (com.kwad.sdk.core.response.a.d.c(adTemplate)) {
            if (this.a.f39986g != null) {
                bVar = this.a.f39986g.a(com.kwad.sdk.core.response.a.d.j(adTemplate).downloadId);
            } else {
                bVar = null;
            }
            if (this.a.f39987h) {
                this.f40056b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.l.1
                    @Override // java.lang.Runnable
                    public void run() {
                        p.a aVar2 = new p.a();
                        aVar2.f39738h = aVar.f40063d.a;
                        com.kwad.sdk.core.download.a.a.a(new a.C1956a(l.this.a.f39983d.getContext()).a(adTemplate).a(bVar).a(aVar.f40062c).a(true).a(aVar2).c(true).a(new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.l.1.1
                            @Override // com.kwad.sdk.core.download.a.a.b
                            public void a() {
                                if (l.this.f40057c != null) {
                                    l.this.f40057c.a();
                                }
                            }
                        }));
                    }
                });
            } else if (this.f40057c != null) {
                this.f40056b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.l.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (l.this.f40057c != null) {
                            l.this.f40057c.a();
                        }
                    }
                });
            }
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f40056b.removeCallbacksAndMessages(null);
    }
}
