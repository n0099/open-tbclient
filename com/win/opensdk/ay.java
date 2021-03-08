package com.win.opensdk;

import android.content.Context;
/* loaded from: classes14.dex */
public class ay {

    /* renamed from: a  reason: collision with root package name */
    public String f8114a;
    public Cdo qkV;
    public az qkW;

    public ay(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f8114a = str;
        this.qkV = new Cdo(applicationContext, str);
        this.qkV.qlP = new ds(this);
    }

    public void a(az azVar) {
        this.qkW = azVar;
    }

    public void destroy() {
        Cdo cdo = this.qkV;
        cdo.e = false;
        cdo.c = false;
        cdo.d = false;
        dq dqVar = cdo.qlQ;
        if (dqVar != null) {
            dqVar.a();
        }
    }

    public boolean isReady() {
        Cdo cdo = this.qkV;
        return cdo.a() || cdo.e();
    }

    public void load() {
        Cdo cdo = this.qkV;
        if (!cdo.b() || !cdo.qlN.isEffective() || cdo.qlN.isShown()) {
            if (cdo.qlQ == null) {
                cdo.qlQ = new dq(cdo.b, cdo.f8154a, F.Video);
            }
            cdo.qlQ.qlS = new de(cdo);
            cdo.qlQ.b();
            return;
        }
        cdo.d(cdo.qlN);
    }

    public void show() {
        Cdo cdo = this.qkV;
        if (!v.g(cdo.b)) {
            az azVar = cdo.qlP;
            if (azVar != null) {
                azVar.bb(PBError.NO_NETWORK.getMsg());
            }
        } else if (cdo.c()) {
            if (!cdo.a() || !cdo.b()) {
                return;
            }
            cdo.c = false;
            j.eIX().a(j.a(cdo.qlN.getTraceid(), cdo.qlN.getId(), cdo.qlN.getPid()), cdo.qlO);
            cdo.f();
        } else if (!cdo.d() || !cdo.e() || !cdo.b()) {
        } else {
            cdo.d = false;
            cdo.f();
        }
    }
}
