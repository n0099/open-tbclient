package com.bytedance.sdk.openadsdk.f.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.f.a.k;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public WebView f29013a;

    /* renamed from: b  reason: collision with root package name */
    public a f29014b;

    /* renamed from: d  reason: collision with root package name */
    public h f29016d;

    /* renamed from: e  reason: collision with root package name */
    public Context f29017e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29018f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29019g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29020h;
    public m i;
    public n j;
    public boolean n;
    public boolean o;
    public k.b p;

    /* renamed from: c  reason: collision with root package name */
    public String f29015c = "IESJSBridge";
    public String k = "host";
    public final Set<String> l = new LinkedHashSet();
    public final Set<String> m = new LinkedHashSet();

    public j(@NonNull WebView webView) {
        this.f29013a = webView;
    }

    private void c() {
        if ((this.f29013a == null && !this.n && this.f29014b == null) || ((TextUtils.isEmpty(this.f29015c) && this.f29013a != null) || this.f29016d == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }

    public j a(@NonNull String str) {
        this.f29015c = str;
        return this;
    }

    public j b(boolean z) {
        this.f29019g = z;
        return this;
    }

    public j a(@NonNull l lVar) {
        this.f29016d = h.a(lVar);
        return this;
    }

    public q b() {
        c();
        return new q(this);
    }

    public j a(boolean z) {
        this.f29018f = z;
        return this;
    }

    public j a() {
        this.o = true;
        return this;
    }

    public j() {
    }
}
