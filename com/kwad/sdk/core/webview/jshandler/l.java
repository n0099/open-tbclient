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
/* loaded from: classes5.dex */
public class l implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;
    public final Handler b;
    @Nullable
    public final b c;

    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public boolean a;
        public String b;
        public int c;
        public b.C0321b d;
    }

    /* loaded from: classes5.dex */
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
            adTemplate.parseJson(new JSONObject(aVar.b));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        if (com.kwad.sdk.core.response.a.d.c(adTemplate)) {
            if (this.a.g != null) {
                bVar = this.a.g.a(com.kwad.sdk.core.response.a.d.j(adTemplate).downloadId);
            } else {
                bVar = null;
            }
            if (this.a.h) {
                this.b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.l.1
                    @Override // java.lang.Runnable
                    public void run() {
                        p.a aVar2 = new p.a();
                        aVar2.h = aVar.d.a;
                        com.kwad.sdk.core.download.a.a.a(new a.C0304a(l.this.a.d.getContext()).a(adTemplate).a(bVar).a(aVar.c).a(true).a(aVar2).c(true).a(new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.l.1.1
                            @Override // com.kwad.sdk.core.download.a.a.b
                            public void a() {
                                if (l.this.c != null) {
                                    l.this.c.a();
                                }
                            }
                        }));
                    }
                });
            } else if (this.c != null) {
                this.b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.l.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (l.this.c != null) {
                            l.this.c.a();
                        }
                    }
                });
            }
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.b.removeCallbacksAndMessages(null);
    }
}
