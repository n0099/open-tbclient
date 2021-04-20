package com.win.opensdk;

import android.content.Context;
/* loaded from: classes7.dex */
public class PBVideo implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f40057a;

    /* renamed from: b  reason: collision with root package name */
    public m2 f40058b;

    /* renamed from: c  reason: collision with root package name */
    public PBVideoListener f40059c;

    public PBVideo(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f40057a = str;
        m2 m2Var = new m2(applicationContext, str);
        this.f40058b = m2Var;
        m2Var.f40271h = new o(this);
    }

    public void destroy() {
        m2 m2Var = this.f40058b;
        m2Var.f40268e = false;
        m2Var.f40266c = false;
        m2Var.f40267d = false;
        n1 n1Var = m2Var.i;
        if (n1Var != null) {
            n1Var.a();
        }
    }

    public String getPid() {
        return this.f40057a;
    }

    public boolean isReady() {
        m2 m2Var = this.f40058b;
        return m2Var.a() || m2Var.e();
    }

    public void load() {
        m2 m2Var = this.f40058b;
        if (m2Var.b() && m2Var.f40269f.isEffective() && !m2Var.f40269f.isShown()) {
            m2Var.a(m2Var.f40269f);
            return;
        }
        if (m2Var.i == null) {
            m2Var.i = new n1(m2Var.f40265b, m2Var.f40264a, F.Video);
        }
        m2Var.i.f40279g = new j2(m2Var);
        m2Var.i.b();
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        this.f40059c = pBVideoListener;
    }

    public void show() {
        m2 m2Var = this.f40058b;
        if (!G.g(m2Var.f40265b)) {
            PBVideoListener pBVideoListener = m2Var.f40271h;
            if (pBVideoListener != null) {
                pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (m2Var.c()) {
            if (m2Var.a() && m2Var.b()) {
                m2Var.f40266c = false;
                B2.a().a(B2.a(m2Var.f40269f.getTraceid(), m2Var.f40269f.getId(), m2Var.f40269f.getPid()), m2Var.f40270g);
                m2Var.f();
            }
        } else if (m2Var.d() && m2Var.e() && m2Var.b()) {
            m2Var.f40267d = false;
            m2Var.f();
        }
    }
}
