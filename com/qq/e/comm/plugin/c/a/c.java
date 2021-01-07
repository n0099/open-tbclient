package com.qq.e.comm.plugin.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.comm.plugin.ac.d;
import com.qq.e.comm.plugin.ac.e;
import com.qq.e.comm.plugin.util.ay;
import com.qq.e.comm.plugin.util.f;
/* loaded from: classes4.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    protected Context f12223a;

    public c(Context context) {
        this.f12223a = context;
    }

    @Override // com.qq.e.comm.plugin.c.a.a
    public void a() {
        ay.a("未知异常，稍后重试");
    }

    @Override // com.qq.e.comm.plugin.c.a.a
    public void a(int i, b bVar) {
        Activity a2 = f.a(this.f12223a);
        if (a2 == null) {
            return;
        }
        new d(a2, i, bVar).a();
    }

    @Override // com.qq.e.comm.plugin.c.a.a
    public void a(com.qq.e.comm.plugin.s.a aVar) {
    }

    @Override // com.qq.e.comm.plugin.c.a.a
    public void a(String str) {
        if (this.f12223a instanceof Activity) {
            new e(this.f12223a).a(str);
        }
    }

    @Override // com.qq.e.comm.plugin.c.a.a
    public void a(String str, int i) {
        if (com.qq.e.comm.plugin.a.d.d.b(i)) {
            ay.a("正在努力下载，请耐心等待");
        } else if (com.qq.e.comm.plugin.a.d.d.c(i)) {
            ay.a("开始安装" + str);
        } else if (i == 0) {
            ay.a("开始下载" + str);
        }
    }

    @Override // com.qq.e.comm.plugin.c.a.a
    public void a(String str, b bVar) {
    }

    @Override // com.qq.e.comm.plugin.c.a.a
    public void a(String str, com.qq.e.comm.plugin.s.a aVar) {
        com.qq.e.comm.plugin.c.c.a(str, aVar);
    }

    @Override // com.qq.e.comm.plugin.c.a.a
    public void a(boolean z) {
        if (z) {
            return;
        }
        ay.a("跳转失败，可能未安装应用。");
    }

    @Override // com.qq.e.comm.plugin.c.a.a
    public BrowserType b(String str, com.qq.e.comm.plugin.s.a aVar) {
        return com.qq.e.comm.plugin.c.c.a(str, aVar);
    }

    @Override // com.qq.e.comm.plugin.c.a.a
    public void b(com.qq.e.comm.plugin.s.a aVar) {
    }

    @Override // com.qq.e.comm.plugin.c.a.a
    public void b(String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        if (!(this.f12223a instanceof Activity)) {
            intent.setFlags(268435456);
        }
        this.f12223a.startActivity(intent);
    }

    @Override // com.qq.e.comm.plugin.c.a.a
    public void c(String str) {
    }
}
