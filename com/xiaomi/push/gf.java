package com.xiaomi.push;

import android.os.Bundle;
/* loaded from: classes8.dex */
public class gf extends gd {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private a f412a;

    /* renamed from: a  reason: collision with other field name */
    private b f413a;
    private String b;

    /* loaded from: classes8.dex */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* loaded from: classes8.dex */
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

    public gf(Bundle bundle) {
        super(bundle);
        this.f413a = b.available;
        this.b = null;
        this.a = Integer.MIN_VALUE;
        this.f412a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f413a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f412a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public gf(b bVar) {
        this.f413a = b.available;
        this.b = null;
        this.a = Integer.MIN_VALUE;
        this.f412a = null;
        a(bVar);
    }

    @Override // com.xiaomi.push.gd
    public Bundle a() {
        Bundle a2 = super.a();
        if (this.f413a != null) {
            a2.putString("ext_pres_type", this.f413a.toString());
        }
        if (this.b != null) {
            a2.putString("ext_pres_status", this.b);
        }
        if (this.a != Integer.MIN_VALUE) {
            a2.putInt("ext_pres_prio", this.a);
        }
        if (this.f412a != null && this.f412a != a.available) {
            a2.putString("ext_pres_mode", this.f412a.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.gd
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
            sb.append(" to=\"").append(go.a(l())).append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"").append(go.a(m())).append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"").append(go.a(k())).append("\"");
        }
        if (this.f413a != null) {
            sb.append(" type=\"").append(this.f413a).append("\"");
        }
        sb.append(">");
        if (this.b != null) {
            sb.append("<status>").append(go.a(this.b)).append("</status>");
        }
        if (this.a != Integer.MIN_VALUE) {
            sb.append("<priority>").append(this.a).append("</priority>");
        }
        if (this.f412a != null && this.f412a != a.available) {
            sb.append("<show>").append(this.f412a).append("</show>");
        }
        sb.append(o());
        gh a2 = a();
        if (a2 != null) {
            sb.append(a2.m310a());
        }
        sb.append("</presence>");
        return sb.toString();
    }

    public void a(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.a = i;
    }

    public void a(a aVar) {
        this.f412a = aVar;
    }

    public void a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.f413a = bVar;
    }

    @Override // com.xiaomi.push.gd
    public void a(String str) {
        this.b = str;
    }
}
