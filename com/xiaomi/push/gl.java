package com.xiaomi.push;

import android.os.Bundle;
/* loaded from: classes6.dex */
public class gl extends gj {

    /* renamed from: a  reason: collision with root package name */
    private int f14352a;

    /* renamed from: a  reason: collision with other field name */
    private a f478a;

    /* renamed from: a  reason: collision with other field name */
    private b f479a;

    /* renamed from: b  reason: collision with root package name */
    private String f14353b;

    /* loaded from: classes6.dex */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* loaded from: classes6.dex */
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
        this.f479a = b.available;
        this.f14353b = null;
        this.f14352a = Integer.MIN_VALUE;
        this.f478a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f479a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f14353b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f14352a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f478a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public gl(b bVar) {
        this.f479a = b.available;
        this.f14353b = null;
        this.f14352a = Integer.MIN_VALUE;
        this.f478a = null;
        a(bVar);
    }

    @Override // com.xiaomi.push.gj
    public Bundle a() {
        Bundle a2 = super.a();
        if (this.f479a != null) {
            a2.putString("ext_pres_type", this.f479a.toString());
        }
        if (this.f14353b != null) {
            a2.putString("ext_pres_status", this.f14353b);
        }
        if (this.f14352a != Integer.MIN_VALUE) {
            a2.putInt("ext_pres_prio", this.f14352a);
        }
        if (this.f478a != null && this.f478a != a.available) {
            a2.putString("ext_pres_mode", this.f478a.toString());
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
        if (this.f479a != null) {
            sb.append(" type=\"").append(this.f479a).append("\"");
        }
        sb.append(">");
        if (this.f14353b != null) {
            sb.append("<status>").append(gu.a(this.f14353b)).append("</status>");
        }
        if (this.f14352a != Integer.MIN_VALUE) {
            sb.append("<priority>").append(this.f14352a).append("</priority>");
        }
        if (this.f478a != null && this.f478a != a.available) {
            sb.append("<show>").append(this.f478a).append("</show>");
        }
        sb.append(o());
        gn a2 = a();
        if (a2 != null) {
            sb.append(a2.m348a());
        }
        sb.append("</presence>");
        return sb.toString();
    }

    public void a(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.f14352a = i;
    }

    public void a(a aVar) {
        this.f478a = aVar;
    }

    public void a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.f479a = bVar;
    }

    @Override // com.xiaomi.push.gj
    public void a(String str) {
        this.f14353b = str;
    }
}
