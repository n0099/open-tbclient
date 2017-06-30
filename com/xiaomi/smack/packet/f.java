package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.support.v4.widget.ExploreByTouchHelper;
/* loaded from: classes2.dex */
public class f extends d {
    private b c;
    private String d;
    private int e;
    private a f;

    /* loaded from: classes2.dex */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* loaded from: classes2.dex */
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

    public f(Bundle bundle) {
        super(bundle);
        this.c = b.available;
        this.d = null;
        this.e = ExploreByTouchHelper.INVALID_ID;
        this.f = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.c = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.d = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.e = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public f(b bVar) {
        this.c = b.available;
        this.d = null;
        this.e = ExploreByTouchHelper.INVALID_ID;
        this.f = null;
        a(bVar);
    }

    public void a(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.e = i;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.c = bVar;
    }

    public void a(String str) {
        this.d = str;
    }

    @Override // com.xiaomi.smack.packet.d
    public Bundle b() {
        Bundle b2 = super.b();
        if (this.c != null) {
            b2.putString("ext_pres_type", this.c.toString());
        }
        if (this.d != null) {
            b2.putString("ext_pres_status", this.d);
        }
        if (this.e != Integer.MIN_VALUE) {
            b2.putInt("ext_pres_prio", this.e);
        }
        if (this.f != null && this.f != a.available) {
            b2.putString("ext_pres_mode", this.f.toString());
        }
        return b2;
    }

    @Override // com.xiaomi.smack.packet.d
    public String c() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (t() != null) {
            sb.append(" xmlns=\"").append(t()).append("\"");
        }
        if (k() != null) {
            sb.append(" id=\"").append(k()).append("\"");
        }
        if (m() != null) {
            sb.append(" to=\"").append(com.xiaomi.smack.util.d.a(m())).append("\"");
        }
        if (n() != null) {
            sb.append(" from=\"").append(com.xiaomi.smack.util.d.a(n())).append("\"");
        }
        if (l() != null) {
            sb.append(" chid=\"").append(com.xiaomi.smack.util.d.a(l())).append("\"");
        }
        if (this.c != null) {
            sb.append(" type=\"").append(this.c).append("\"");
        }
        sb.append(">");
        if (this.d != null) {
            sb.append("<status>").append(com.xiaomi.smack.util.d.a(this.d)).append("</status>");
        }
        if (this.e != Integer.MIN_VALUE) {
            sb.append("<priority>").append(this.e).append("</priority>");
        }
        if (this.f != null && this.f != a.available) {
            sb.append("<show>").append(this.f).append("</show>");
        }
        sb.append(s());
        h p = p();
        if (p != null) {
            sb.append(p.b());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
