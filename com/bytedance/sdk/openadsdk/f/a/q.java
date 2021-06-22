package com.bytedance.sdk.openadsdk.f.a;

import android.webkit.WebView;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.bytedance.sdk.openadsdk.f.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static v f29287a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final a f29288b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final WebView f29289c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final j f29290d;

    /* renamed from: f  reason: collision with root package name */
    public o f29292f;

    /* renamed from: e  reason: collision with root package name */
    public final List<n> f29291e = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f29293g = false;

    public q(j jVar) {
        v vVar;
        this.f29290d = jVar;
        u a2 = (!jVar.f29270h || (vVar = f29287a) == null) ? null : vVar.a(jVar.k);
        if (jVar.f29263a != null) {
            y yVar = new y();
            this.f29288b = yVar;
            yVar.a(jVar, a2);
        } else {
            a aVar = jVar.f29264b;
            this.f29288b = aVar;
            aVar.a(jVar, a2);
        }
        this.f29289c = jVar.f29263a;
        this.f29291e.add(jVar.j);
        i.a(jVar.f29268f);
        x.a(jVar.f29269g);
    }

    public static j a(@NonNull WebView webView) {
        return new j(webView);
    }

    @AnyThread
    public <T> void a(@NonNull String str, @Nullable T t) {
        a();
        this.f29288b.a(str, (String) t);
    }

    public q a(String str, @NonNull e<?, ?> eVar) {
        return a(str, (String) null, eVar);
    }

    @NonNull
    @UiThread
    public q a(@NonNull String str, @Nullable String str2, @NonNull e<?, ?> eVar) {
        a();
        this.f29288b.f29232g.a(str, eVar);
        o oVar = this.f29292f;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    public q a(String str, @NonNull d.b bVar) {
        return a(str, (String) null, bVar);
    }

    @NonNull
    @UiThread
    public q a(@NonNull String str, @Nullable String str2, @NonNull d.b bVar) {
        a();
        this.f29288b.f29232g.a(str, bVar);
        o oVar = this.f29292f;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    private void a() {
        if (this.f29293g) {
            i.a(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
