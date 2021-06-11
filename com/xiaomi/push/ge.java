package com.xiaomi.push;

import android.os.Bundle;
/* loaded from: classes7.dex */
public class ge extends gc {

    /* renamed from: a  reason: collision with root package name */
    public int f41325a;

    /* renamed from: a  reason: collision with other field name */
    public a f428a;

    /* renamed from: a  reason: collision with other field name */
    public b f429a;

    /* renamed from: b  reason: collision with root package name */
    public String f41326b;

    /* loaded from: classes7.dex */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* loaded from: classes7.dex */
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

    public ge(Bundle bundle) {
        super(bundle);
        this.f429a = b.available;
        this.f41326b = null;
        this.f41325a = Integer.MIN_VALUE;
        this.f428a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f429a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f41326b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f41325a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f428a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public ge(b bVar) {
        this.f429a = b.available;
        this.f41326b = null;
        this.f41325a = Integer.MIN_VALUE;
        this.f428a = null;
        a(bVar);
    }

    @Override // com.xiaomi.push.gc
    public Bundle a() {
        Bundle a2 = super.a();
        b bVar = this.f429a;
        if (bVar != null) {
            a2.putString("ext_pres_type", bVar.toString());
        }
        String str = this.f41326b;
        if (str != null) {
            a2.putString("ext_pres_status", str);
        }
        int i2 = this.f41325a;
        if (i2 != Integer.MIN_VALUE) {
            a2.putInt("ext_pres_prio", i2);
        }
        a aVar = this.f428a;
        if (aVar != null && aVar != a.available) {
            a2.putString("ext_pres_mode", aVar.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.gc
    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"");
            sb.append(j());
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"");
            sb.append(gn.a(l()));
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(gn.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(gn.a(k()));
            sb.append("\"");
        }
        if (this.f429a != null) {
            sb.append(" type=\"");
            sb.append(this.f429a);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f41326b != null) {
            sb.append("<status>");
            sb.append(gn.a(this.f41326b));
            sb.append("</status>");
        }
        if (this.f41325a != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.f41325a);
            sb.append("</priority>");
        }
        a aVar = this.f428a;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>");
            sb.append(this.f428a);
            sb.append("</show>");
        }
        sb.append(o());
        gg m329a = m329a();
        if (m329a != null) {
            sb.append(m329a.m333a());
        }
        sb.append("</presence>");
        return sb.toString();
    }

    public void a(int i2) {
        if (i2 >= -128 && i2 <= 128) {
            this.f41325a = i2;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i2 + " is not valid. Valid range is -128 through 128.");
    }

    public void a(a aVar) {
        this.f428a = aVar;
    }

    public void a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.f429a = bVar;
    }

    @Override // com.xiaomi.push.gc
    public void a(String str) {
        this.f41326b = str;
    }
}
