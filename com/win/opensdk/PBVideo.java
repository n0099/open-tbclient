package com.win.opensdk;

import android.content.Context;
/* loaded from: classes7.dex */
public class PBVideo implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f39767a;

    /* renamed from: b  reason: collision with root package name */
    public m2 f39768b;

    /* renamed from: c  reason: collision with root package name */
    public PBVideoListener f39769c;

    public PBVideo(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f39767a = str;
        m2 m2Var = new m2(applicationContext, str);
        this.f39768b = m2Var;
        m2Var.f39981h = new o(this);
    }

    public void destroy() {
        m2 m2Var = this.f39768b;
        m2Var.f39978e = false;
        m2Var.f39976c = false;
        m2Var.f39977d = false;
        n1 n1Var = m2Var.i;
        if (n1Var != null) {
            n1Var.a();
        }
    }

    public String getPid() {
        return this.f39767a;
    }

    public boolean isReady() {
        m2 m2Var = this.f39768b;
        return m2Var.a() || m2Var.e();
    }

    public void load() {
        m2 m2Var = this.f39768b;
        if (m2Var.b() && m2Var.f39979f.isEffective() && !m2Var.f39979f.isShown()) {
            m2Var.a(m2Var.f39979f);
            return;
        }
        if (m2Var.i == null) {
            m2Var.i = new n1(m2Var.f39975b, m2Var.f39974a, F.Video);
        }
        m2Var.i.f39989g = new j2(m2Var);
        m2Var.i.b();
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        this.f39769c = pBVideoListener;
    }

    public void show() {
        m2 m2Var = this.f39768b;
        if (!G.g(m2Var.f39975b)) {
            PBVideoListener pBVideoListener = m2Var.f39981h;
            if (pBVideoListener != null) {
                pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (m2Var.c()) {
            if (m2Var.a() && m2Var.b()) {
                m2Var.f39976c = false;
                B2.a().a(B2.a(m2Var.f39979f.getTraceid(), m2Var.f39979f.getId(), m2Var.f39979f.getPid()), m2Var.f39980g);
                m2Var.f();
            }
        } else if (m2Var.d() && m2Var.e() && m2Var.b()) {
            m2Var.f39977d = false;
            m2Var.f();
        }
    }
}
