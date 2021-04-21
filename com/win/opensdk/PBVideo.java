package com.win.opensdk;

import android.content.Context;
/* loaded from: classes7.dex */
public class PBVideo implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f40152a;

    /* renamed from: b  reason: collision with root package name */
    public m2 f40153b;

    /* renamed from: c  reason: collision with root package name */
    public PBVideoListener f40154c;

    public PBVideo(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f40152a = str;
        m2 m2Var = new m2(applicationContext, str);
        this.f40153b = m2Var;
        m2Var.f40366h = new o(this);
    }

    public void destroy() {
        m2 m2Var = this.f40153b;
        m2Var.f40363e = false;
        m2Var.f40361c = false;
        m2Var.f40362d = false;
        n1 n1Var = m2Var.i;
        if (n1Var != null) {
            n1Var.a();
        }
    }

    public String getPid() {
        return this.f40152a;
    }

    public boolean isReady() {
        m2 m2Var = this.f40153b;
        return m2Var.a() || m2Var.e();
    }

    public void load() {
        m2 m2Var = this.f40153b;
        if (m2Var.b() && m2Var.f40364f.isEffective() && !m2Var.f40364f.isShown()) {
            m2Var.a(m2Var.f40364f);
            return;
        }
        if (m2Var.i == null) {
            m2Var.i = new n1(m2Var.f40360b, m2Var.f40359a, F.Video);
        }
        m2Var.i.f40374g = new j2(m2Var);
        m2Var.i.b();
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        this.f40154c = pBVideoListener;
    }

    public void show() {
        m2 m2Var = this.f40153b;
        if (!G.g(m2Var.f40360b)) {
            PBVideoListener pBVideoListener = m2Var.f40366h;
            if (pBVideoListener != null) {
                pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (m2Var.c()) {
            if (m2Var.a() && m2Var.b()) {
                m2Var.f40361c = false;
                B2.a().a(B2.a(m2Var.f40364f.getTraceid(), m2Var.f40364f.getId(), m2Var.f40364f.getPid()), m2Var.f40365g);
                m2Var.f();
            }
        } else if (m2Var.d() && m2Var.e() && m2Var.b()) {
            m2Var.f40362d = false;
            m2Var.f();
        }
    }
}
