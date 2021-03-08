package com.xiaomi.push;

import android.os.Bundle;
/* loaded from: classes5.dex */
public class gl extends gj {

    /* renamed from: a  reason: collision with root package name */
    private int f8389a;

    /* renamed from: a  reason: collision with other field name */
    private a f398a;

    /* renamed from: a  reason: collision with other field name */
    private b f399a;
    private String b;

    /* loaded from: classes5.dex */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* loaded from: classes5.dex */
    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public gl(Bundle bundle) {
        super(bundle);
        this.f399a = b.available;
        this.b = null;
        this.f8389a = Integer.MIN_VALUE;
        this.f398a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f399a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f8389a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f398a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public gl(b bVar) {
        this.f399a = b.available;
        this.b = null;
        this.f8389a = Integer.MIN_VALUE;
        this.f398a = null;
        a(bVar);
    }

    @Override // com.xiaomi.push.gj
    public Bundle a() {
        Bundle a2 = super.a();
        if (this.f399a != null) {
            a2.putString("ext_pres_type", this.f399a.toString());
        }
        if (this.b != null) {
            a2.putString("ext_pres_status", this.b);
        }
        if (this.f8389a != Integer.MIN_VALUE) {
            a2.putInt("ext_pres_prio", this.f8389a);
        }
        if (this.f398a != null && this.f398a != a.available) {
            a2.putString("ext_pres_mode", this.f398a.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.gj
    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (p() != null) {
            sb.append(" xmlns=\"").append(p()).append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"").append(j()).append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"").append(gu.a(l())).append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"").append(gu.a(m())).append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"").append(gu.a(k())).append("\"");
        }
        if (this.f399a != null) {
            sb.append(" type=\"").append(this.f399a).append("\"");
        }
        sb.append(">");
        if (this.b != null) {
            sb.append("<status>").append(gu.a(this.b)).append("</status>");
        }
        if (this.f8389a != Integer.MIN_VALUE) {
            sb.append("<priority>").append(this.f8389a).append("</priority>");
        }
        if (this.f398a != null && this.f398a != a.available) {
            sb.append("<show>").append(this.f398a).append("</show>");
        }
        sb.append(o());
        gn a2 = a();
        if (a2 != null) {
            sb.append(a2.m322a());
        }
        sb.append("</presence>");
        return sb.toString();
    }

    public void a(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.f8389a = i;
    }

    public void a(a aVar) {
        this.f398a = aVar;
    }

    public void a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.f399a = bVar;
    }

    @Override // com.xiaomi.push.gj
    public void a(String str) {
        this.b = str;
    }
}
