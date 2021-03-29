package com.win.opensdk;

import android.content.Context;
/* loaded from: classes7.dex */
public class PBVideo implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f39768a;

    /* renamed from: b  reason: collision with root package name */
    public m2 f39769b;

    /* renamed from: c  reason: collision with root package name */
    public PBVideoListener f39770c;

    public PBVideo(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f39768a = str;
        m2 m2Var = new m2(applicationContext, str);
        this.f39769b = m2Var;
        m2Var.f39982h = new o(this);
    }

    public void destroy() {
        m2 m2Var = this.f39769b;
        m2Var.f39979e = false;
        m2Var.f39977c = false;
        m2Var.f39978d = false;
        n1 n1Var = m2Var.i;
        if (n1Var != null) {
            n1Var.a();
        }
    }

    public String getPid() {
        return this.f39768a;
    }

    public boolean isReady() {
        m2 m2Var = this.f39769b;
        return m2Var.a() || m2Var.e();
    }

    public void load() {
        m2 m2Var = this.f39769b;
        if (m2Var.b() && m2Var.f39980f.isEffective() && !m2Var.f39980f.isShown()) {
            m2Var.a(m2Var.f39980f);
            return;
        }
        if (m2Var.i == null) {
            m2Var.i = new n1(m2Var.f39976b, m2Var.f39975a, F.Video);
        }
        m2Var.i.f39990g = new j2(m2Var);
        m2Var.i.b();
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        this.f39770c = pBVideoListener;
    }

    public void show() {
        m2 m2Var = this.f39769b;
        if (!G.g(m2Var.f39976b)) {
            PBVideoListener pBVideoListener = m2Var.f39982h;
            if (pBVideoListener != null) {
                pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (m2Var.c()) {
            if (m2Var.a() && m2Var.b()) {
                m2Var.f39977c = false;
                B2.a().a(B2.a(m2Var.f39980f.getTraceid(), m2Var.f39980f.getId(), m2Var.f39980f.getPid()), m2Var.f39981g);
                m2Var.f();
            }
        } else if (m2Var.d() && m2Var.e() && m2Var.b()) {
            m2Var.f39978d = false;
            m2Var.f();
        }
    }
}
