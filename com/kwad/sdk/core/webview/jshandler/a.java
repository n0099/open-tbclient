package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;
    public Handler b;
    public boolean c;
    public List<com.kwad.sdk.core.download.a.b> d;
    @Nullable
    public b.c e;
    @Nullable
    public b.d f;

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable b.c cVar) {
        this(aVar, bVar, cVar, false);
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable b.c cVar, boolean z) {
        this.c = false;
        this.d = new ArrayList();
        this.c = z;
        this.b = new Handler(Looper.getMainLooper());
        this.a = aVar;
        if (bVar != null) {
            bVar.a(1);
            this.d.add(bVar);
        }
        this.e = cVar;
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable List<com.kwad.sdk.core.download.a.b> list, @Nullable b.c cVar) {
        this(aVar, null, cVar, false);
        if (list != null) {
            this.d.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b.a aVar) {
        return aVar.c == 1;
    }

    @Nullable
    public com.kwad.sdk.core.download.a.b a(long j) {
        List<com.kwad.sdk.core.download.a.b> list = this.d;
        if (list == null) {
            return null;
        }
        if (j >= 0 || list.size() != 1) {
            for (com.kwad.sdk.core.download.a.b bVar : this.d) {
                if (com.kwad.sdk.core.response.a.d.y(bVar.e()) == j) {
                    return bVar;
                }
            }
            return null;
        }
        return this.d.get(0);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Handler handler;
        Runnable runnable;
        if (this.a.c()) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        final b.a aVar = new b.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        if (!this.a.h) {
            if (this.e != null) {
                handler = this.b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.e != null) {
                            a.this.e.a(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a.i) {
                    p.a aVar2 = new p.a();
                    b.C0312b c0312b = aVar.d;
                    if (c0312b != null && !TextUtils.isEmpty(c0312b.a)) {
                        aVar2.h = aVar.d.a;
                    }
                    AdBaseFrameLayout adBaseFrameLayout = a.this.a.b;
                    if (adBaseFrameLayout != null) {
                        aVar2.g = adBaseFrameLayout.getTouchCoords();
                    }
                    int i = (aVar.e > 0L ? 1 : (aVar.e == 0L ? 0 : -1));
                    com.kwad.sdk.core.webview.a aVar3 = a.this.a;
                    int a = com.kwad.sdk.core.download.a.a.a(new a.C0295a(a.this.a.d.getContext()).a(i >= 0 ? aVar3.a(aVar.e) : aVar3.a()).a(a.this.a(aVar.e)).a(a.this.a(aVar)).b(a.this.c).a(a.this.a.c).a(aVar.c).c(true).a(aVar2).a(new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            if (a.this.e != null) {
                                a.this.e.a(aVar);
                            }
                        }
                    }));
                    if (a.this.f != null) {
                        a.this.f.a(a);
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
