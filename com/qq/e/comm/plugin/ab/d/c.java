package com.qq.e.comm.plugin.ab.d;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final d f11756a = new d();

    /* renamed from: b  reason: collision with root package name */
    private final b f11757b = new b();
    private final com.qq.e.comm.plugin.ab.f.c c;

    public c(Context context, JSONObject jSONObject) {
        com.qq.e.comm.plugin.ab.f.c cVar;
        try {
            cVar = new com.qq.e.comm.plugin.ab.f.c(context, this.f11756a, this.f11757b, jSONObject);
        } catch (Resources.NotFoundException e) {
            cVar = (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT >= 23) ? new com.qq.e.comm.plugin.ab.f.c(context.getApplicationContext(), this.f11756a, this.f11757b, jSONObject) : new com.qq.e.comm.plugin.ab.f.c(context.createConfigurationContext(new Configuration()), this.f11756a, this.f11757b, jSONObject);
        }
        this.c = cVar;
    }

    @Override // com.qq.e.comm.plugin.ab.d.a
    public void a() {
        this.c.destroy();
    }

    @Override // com.qq.e.comm.plugin.ab.d.a
    public void a(f fVar) {
        this.f11756a.a(fVar);
        this.f11757b.a(fVar);
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
        this.c.setHorizontalScrollBarEnabled(z);
        this.c.setVerticalScrollBarEnabled(z);
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
        this.f11756a.a();
    }
}
