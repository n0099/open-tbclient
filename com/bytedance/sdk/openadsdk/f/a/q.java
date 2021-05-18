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
    public static v f29173a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final a f29174b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final WebView f29175c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final j f29176d;

    /* renamed from: f  reason: collision with root package name */
    public o f29178f;

    /* renamed from: e  reason: collision with root package name */
    public final List<n> f29177e = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f29179g = false;

    public q(j jVar) {
        v vVar;
        this.f29176d = jVar;
        u a2 = (!jVar.f29156h || (vVar = f29173a) == null) ? null : vVar.a(jVar.k);
        if (jVar.f29149a != null) {
            y yVar = new y();
            this.f29174b = yVar;
            yVar.a(jVar, a2);
        } else {
            a aVar = jVar.f29150b;
            this.f29174b = aVar;
            aVar.a(jVar, a2);
        }
        this.f29175c = jVar.f29149a;
        this.f29177e.add(jVar.j);
        i.a(jVar.f29154f);
        x.a(jVar.f29155g);
    }

    public static j a(@NonNull WebView webView) {
        return new j(webView);
    }

    @AnyThread
    public <T> void a(@NonNull String str, @Nullable T t) {
        a();
        this.f29174b.a(str, (String) t);
    }

    public q a(String str, @NonNull e<?, ?> eVar) {
        return a(str, (String) null, eVar);
    }

    @NonNull
    @UiThread
    public q a(@NonNull String str, @Nullable String str2, @NonNull e<?, ?> eVar) {
        a();
        this.f29174b.f29118g.a(str, eVar);
        o oVar = this.f29178f;
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
        this.f29174b.f29118g.a(str, bVar);
        o oVar = this.f29178f;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    private void a() {
        if (this.f29179g) {
            i.a(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
