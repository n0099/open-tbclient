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
/* loaded from: classes3.dex */
public class a implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f56343b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56344c;

    /* renamed from: d  reason: collision with root package name */
    public List<com.kwad.sdk.core.download.a.b> f56345d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public b.c f56346e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b.d f56347f;

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable b.c cVar) {
        this(aVar, bVar, cVar, false);
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable b.c cVar, boolean z) {
        this.f56344c = false;
        this.f56345d = new ArrayList();
        this.f56344c = z;
        this.f56343b = new Handler(Looper.getMainLooper());
        this.a = aVar;
        if (bVar != null) {
            bVar.a(1);
            this.f56345d.add(bVar);
        }
        this.f56346e = cVar;
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable List<com.kwad.sdk.core.download.a.b> list, @Nullable b.c cVar) {
        this(aVar, null, cVar, false);
        if (list != null) {
            this.f56345d.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b.a aVar) {
        return aVar.f56360c == 1;
    }

    @Nullable
    public com.kwad.sdk.core.download.a.b a(long j2) {
        List<com.kwad.sdk.core.download.a.b> list = this.f56345d;
        if (list == null) {
            return null;
        }
        if (j2 >= 0 || list.size() != 1) {
            for (com.kwad.sdk.core.download.a.b bVar : this.f56345d) {
                if (com.kwad.sdk.core.response.a.d.y(bVar.e()) == j2) {
                    return bVar;
                }
            }
            return null;
        }
        return this.f56345d.get(0);
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
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (!this.a.f56333h) {
            if (this.f56346e != null) {
                handler = this.f56343b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f56346e != null) {
                            a.this.f56346e.a(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.f56343b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a.f56334i) {
                    p.a aVar2 = new p.a();
                    b.C2117b c2117b = aVar.f56361d;
                    if (c2117b != null && !TextUtils.isEmpty(c2117b.a)) {
                        aVar2.f56067h = aVar.f56361d.a;
                    }
                    AdBaseFrameLayout adBaseFrameLayout = a.this.a.f56327b;
                    if (adBaseFrameLayout != null) {
                        aVar2.f56066g = adBaseFrameLayout.getTouchCoords();
                    }
                    int i2 = (aVar.f56362e > 0L ? 1 : (aVar.f56362e == 0L ? 0 : -1));
                    com.kwad.sdk.core.webview.a aVar3 = a.this.a;
                    int a = com.kwad.sdk.core.download.a.a.a(new a.C2100a(a.this.a.f56329d.getContext()).a(i2 >= 0 ? aVar3.a(aVar.f56362e) : aVar3.a()).a(a.this.a(aVar.f56362e)).a(a.this.a(aVar)).b(a.this.f56344c).a(a.this.a.f56328c).a(aVar.f56360c).c(true).a(aVar2).a(new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            if (a.this.f56346e != null) {
                                a.this.f56346e.a(aVar);
                            }
                        }
                    }));
                    if (a.this.f56347f != null) {
                        a.this.f56347f.a(a);
                    }
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f56343b.removeCallbacksAndMessages(null);
        this.f56346e = null;
    }
}
