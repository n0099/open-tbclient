package com.qq.e.comm.plugin.a.a;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.ab.a.b;
import com.qq.e.comm.plugin.ab.c;
import com.qq.e.comm.plugin.ab.c.i;
import com.qq.e.comm.plugin.ab.c.j;
import com.qq.e.comm.plugin.ab.c.l;
import com.qq.e.comm.plugin.ab.c.m;
import com.qq.e.comm.plugin.ab.c.o;
import com.qq.e.comm.plugin.ab.c.p;
import com.qq.e.comm.plugin.ab.e;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a implements ACTD, b, c {

    /* renamed from: a  reason: collision with root package name */
    private h f11886a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f11887b;

    public a(Activity activity) {
        this.f11887b = activity;
    }

    private void d() {
        this.f11887b.finish();
    }

    private void e() {
        this.f11886a.a(f());
    }

    private String f() {
        StringBuilder sb = new StringBuilder("http://qzonestyle.gtimg.cn/qzone/biz/gdt/mob/sdk/v2/android01/download.html");
        GDTLogger.d("DownloadURL=" + ((Object) sb));
        return sb.toString();
    }

    private void g() {
        this.f11886a = new e(this.f11887b.getApplicationContext(), this).a(this).a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(i.a());
        arrayList.add(m.a());
        arrayList.add(j.a());
        arrayList.add(l.a());
        arrayList.add(o.a());
        arrayList.add(p.a());
        this.f11886a.a(arrayList);
    }

    @Override // com.qq.e.comm.plugin.ab.c
    public String a() {
        return "";
    }

    @Override // com.qq.e.comm.plugin.ab.a.b
    public void a(com.qq.e.comm.plugin.ab.a.a aVar) {
        switch (aVar.a()) {
            case DownloadClosed:
                d();
                return;
            default:
                return;
        }
    }

    @Override // com.qq.e.comm.plugin.ab.c
    public String b() {
        return "";
    }

    @Override // com.qq.e.comm.plugin.ab.c
    public com.qq.e.comm.plugin.ad.e c() {
        return null;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        g();
        if (this.f11886a.a().getParent() != null) {
            ((ViewGroup) this.f11886a.a().getParent()).removeView(this.f11886a.a());
        }
        this.f11887b.setContentView(this.f11886a.a());
        e();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        d();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        com.qq.e.comm.plugin.a.l.a().c();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        if (this.f11886a != null) {
            this.f11886a.c();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }
}
