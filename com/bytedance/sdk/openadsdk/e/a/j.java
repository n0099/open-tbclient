package com.bytedance.sdk.openadsdk.e.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.e.a.k;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    WebView f4741a;
    a b;
    h d;
    Context e;
    boolean f;
    boolean g;
    boolean h;
    m i;
    n j;
    boolean n;
    boolean o;
    k.b p;
    String c = "IESJSBridge";
    String k = "host";
    final Set<String> l = new LinkedHashSet();
    final Set<String> m = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(@NonNull WebView webView) {
        this.f4741a = webView;
    }

    j() {
    }

    public j a(@NonNull String str) {
        this.c = str;
        return this;
    }

    public j a(@NonNull l lVar) {
        this.d = h.a(lVar);
        return this;
    }

    public j a(boolean z) {
        this.f = z;
        return this;
    }

    public j b(boolean z) {
        this.g = z;
        return this;
    }

    public j a() {
        this.o = true;
        return this;
    }

    public q b() {
        c();
        return new q(this);
    }

    private void c() {
        if ((this.f4741a == null && !this.n && this.b == null) || ((TextUtils.isEmpty(this.c) && this.f4741a != null) || this.d == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }
}
