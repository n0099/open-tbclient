package com.bytedance.sdk.openadsdk.e.a;

import android.webkit.WebView;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.bytedance.sdk.openadsdk.e.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    static v f4744a;
    @NonNull
    private final a b;
    @Nullable
    private final WebView c;
    @NonNull
    private final j d;
    private o f;
    private final List<n> e = new ArrayList();
    private volatile boolean g = false;

    public static j a(@NonNull WebView webView) {
        return new j(webView);
    }

    @AnyThread
    public <T> void a(@NonNull String str, @Nullable T t) {
        a();
        this.b.a(str, (String) t);
    }

    public q a(String str, @NonNull e<?, ?> eVar) {
        return a(str, (String) null, eVar);
    }

    @NonNull
    @UiThread
    public q a(@NonNull String str, @Nullable String str2, @NonNull e<?, ?> eVar) {
        a();
        this.b.g.a(str, eVar);
        if (this.f != null) {
            this.f.a(str);
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
        this.b.g.a(str, bVar);
        if (this.f != null) {
            this.f.a(str);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(j jVar) {
        this.d = jVar;
        u uVar = null;
        if (jVar.h && f4744a != null) {
            uVar = f4744a.a(jVar.k);
        }
        if (jVar.f4741a != null) {
            this.b = new y();
            this.b.a(jVar, uVar);
        } else {
            this.b = jVar.b;
            this.b.a(jVar, uVar);
        }
        this.c = jVar.f4741a;
        this.e.add(jVar.j);
        i.a(jVar.f);
        x.a(jVar.g);
    }

    private void a() {
        if (this.g) {
            i.a(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
