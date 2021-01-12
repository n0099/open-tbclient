package com.qq.e.comm.plugin.ab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import com.qq.e.comm.plugin.ab.h;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class n implements h {

    /* renamed from: a  reason: collision with root package name */
    private l f11828a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.ab.b.a f11829b = new com.qq.e.comm.plugin.ab.b.a(this);
    private a c;

    public n(Context context, c cVar) {
        this.f11828a = new l(context, cVar);
        this.f11828a.a(this.f11829b);
        this.c = new a();
    }

    @SuppressLint({"NewApi"})
    private boolean d(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f11828a.evaluateJavascript(str, null);
            return true;
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public View a() {
        return this.f11828a;
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(int i) {
        this.f11828a.setVisibility(i);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(com.qq.e.comm.plugin.ab.a.a aVar) {
        this.f11828a.a(aVar);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(com.qq.e.comm.plugin.ab.a.b bVar) {
        this.f11828a.a(bVar);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(h.a aVar) {
        this.f11828a.a(aVar);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(String str) {
        this.f11828a.loadUrl(str);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(String str, String str2, String str3, String str4, String str5) {
        this.f11828a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(Collection<com.qq.e.comm.plugin.ab.c.e> collection) {
        this.f11828a.a(collection);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(Set<String> set) {
        this.c.a(set);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(JSONObject jSONObject) {
        this.c.a(jSONObject);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void a(boolean z) {
        this.f11828a.setVerticalScrollBarEnabled(z);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public com.qq.e.comm.plugin.ab.b.a b() {
        return this.f11828a.c();
    }

    @Override // com.qq.e.comm.plugin.ab.k
    public void b(String str) {
        if (this.f11828a.h() || d(str)) {
            return;
        }
        this.f11828a.loadUrl("javascript:" + str);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void b(boolean z) {
        this.f11828a.setHorizontalScrollBarEnabled(z);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void c() {
        this.f11828a.g();
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void c(boolean z) {
        this.f11828a.setClickable(z);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public boolean c(String str) {
        return this.c.a(str);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public List<com.qq.e.comm.plugin.ab.a.b> d() {
        return this.f11828a.d();
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void d(boolean z) {
        this.f11828a.setFocusable(z);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public c e() {
        return this.f11828a.e();
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public void e(boolean z) {
        this.f11828a.setFocusableInTouchMode(z);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public int f() {
        return this.f11828a.getView().getWidth();
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public int f(boolean z) {
        return this.f11828a.a(z);
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public int g() {
        return this.f11828a.getView().getHeight();
    }

    @Override // com.qq.e.comm.plugin.ab.h
    public JSONObject h() {
        return this.c.a();
    }
}
