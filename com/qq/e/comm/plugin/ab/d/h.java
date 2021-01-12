package com.qq.e.comm.plugin.ab.d;

import android.content.Context;
import android.view.View;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class h implements a {

    /* renamed from: a  reason: collision with root package name */
    private final i f11761a = new i();

    /* renamed from: b  reason: collision with root package name */
    private final g f11762b = new g();
    private final com.qq.e.comm.plugin.ab.f.i c;

    public h(Context context, JSONObject jSONObject) {
        this.c = new com.qq.e.comm.plugin.ab.f.i(context, this.f11761a, this.f11762b, jSONObject);
    }

    @Override // com.qq.e.comm.plugin.ab.d.a
    public void a() {
        this.c.destroy();
    }

    @Override // com.qq.e.comm.plugin.ab.d.a
    public void a(f fVar) {
        this.f11761a.a(fVar);
        this.f11762b.a(fVar);
    }

    @Override // com.qq.e.comm.plugin.ab.d.a
    public void a(String str) {
        this.c.loadUrl(str);
    }

    @Override // com.qq.e.comm.plugin.ab.d.a
    public void a(String str, String str2, String str3, String str4, String str5) {
        this.c.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.qq.e.comm.plugin.ab.d.a
    public void a(boolean z) {
        View view = this.c.getView();
        if (view != null) {
            view.setHorizontalScrollBarEnabled(z);
            view.setVerticalScrollBarEnabled(z);
        }
        IX5WebViewExtension x5WebViewExtension = this.c.getX5WebViewExtension();
        if (x5WebViewExtension != null) {
            x5WebViewExtension.setHorizontalScrollBarEnabled(z);
            x5WebViewExtension.setVerticalScrollBarEnabled(z);
        }
    }

    @Override // com.qq.e.comm.plugin.ab.d.a
    public View b() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.ab.d.a
    public com.qq.e.comm.plugin.ab.f.e c() {
        return this.c.d();
    }

    @Override // com.qq.e.comm.plugin.ab.d.a
    public boolean d() {
        return this.c.canGoBack();
    }

    @Override // com.qq.e.comm.plugin.ab.d.a
    public void e() {
        this.c.goBack();
    }

    @Override // com.qq.e.comm.plugin.ab.d.a
    public void f() {
        this.f11761a.a();
    }
}
