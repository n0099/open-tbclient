package com.cmic.sso.sdk.b.b;

import com.baidu.tbadk.core.util.TbEnum;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public abstract class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30589a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f30590b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f30591c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f30592d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f30593e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f30594f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f30595g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f30596h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f30597i = "";
    public String j = "0";
    public String k = "1.0";
    public String l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    public String q = "";
    public String r = "";
    public String s = "";
    public String t = "";
    public String u = TbEnum.SystemMessage.EVENT_ID_APPLY_SUC;
    public String v = "";
    public String w = "";

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30591c;
    }

    public void a_(String str) {
        this.v = str;
    }

    public void b(String str) {
        this.f30589a = v(str);
    }

    public void c(String str) {
        this.f30590b = v(str);
    }

    public void d(String str) {
        this.f30591c = v(str);
    }

    public void e(String str) {
        this.f30592d = v(str);
    }

    public void f(String str) {
        this.f30593e = v(str);
    }

    public void g(String str) {
        this.f30594f = v(str);
    }

    public void h(String str) {
        this.f30595g = URLEncoder.encode(v(str));
    }

    public void i(String str) {
        this.f30596h = URLEncoder.encode(v(str));
    }

    public void j(String str) {
        this.f30597i = URLEncoder.encode(v(str));
    }

    public void k(String str) {
        this.j = v(str);
    }

    public void l(String str) {
        this.k = v(str);
    }

    public void m(String str) {
        this.m = v(str);
    }

    public void n(String str) {
        this.n = v(str);
    }

    public void o(String str) {
        this.o = v(str);
    }

    public void p(String str) {
        this.p = v(str);
    }

    public void q(String str) {
        this.q = v(str);
    }

    public void r(String str) {
        this.r = v(str);
    }

    public void s(String str) {
        this.s = v(str);
    }

    public void t(String str) {
        this.t = v(str);
    }

    public void u(String str) {
        this.w = str;
    }

    public final String v(String str) {
        return str == null ? "" : str;
    }
}
