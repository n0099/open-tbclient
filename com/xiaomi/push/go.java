package com.xiaomi.push;

import android.os.Bundle;
/* loaded from: classes8.dex */
public class go extends gm {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public a f446a;

    /* renamed from: a  reason: collision with other field name */
    public b f447a;
    public String b;

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

    public go(Bundle bundle) {
        super(bundle);
        this.f447a = b.available;
        this.b = null;
        this.a = Integer.MIN_VALUE;
        this.f446a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f447a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f446a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public go(b bVar) {
        this.f447a = b.available;
        this.b = null;
        this.a = Integer.MIN_VALUE;
        this.f446a = null;
        a(bVar);
    }

    @Override // com.xiaomi.push.gm
    public Bundle a() {
        Bundle a2 = super.a();
        b bVar = this.f447a;
        if (bVar != null) {
            a2.putString("ext_pres_type", bVar.toString());
        }
        String str = this.b;
        if (str != null) {
            a2.putString("ext_pres_status", str);
        }
        int i = this.a;
        if (i != Integer.MIN_VALUE) {
            a2.putInt("ext_pres_prio", i);
        }
        a aVar = this.f446a;
        if (aVar != null && aVar != a.available) {
            a2.putString("ext_pres_mode", aVar.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.gm
    /* renamed from: a */
    public String mo446a() {
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
            sb.append(gx.a(l()));
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(gx.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(gx.a(k()));
            sb.append("\"");
        }
        if (this.f447a != null) {
            sb.append(" type=\"");
            sb.append(this.f447a);
            sb.append("\"");
        }
        sb.append(">");
        if (this.b != null) {
            sb.append("<status>");
            sb.append(gx.a(this.b));
            sb.append("</status>");
        }
        if (this.a != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.a);
            sb.append("</priority>");
        }
        a aVar = this.f446a;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>");
            sb.append(this.f446a);
            sb.append("</show>");
        }
        sb.append(o());
        gq m447a = m447a();
        if (m447a != null) {
            sb.append(m447a.m450a());
        }
        sb.append("</presence>");
        return sb.toString();
    }

    public void a(int i) {
        if (i >= -128 && i <= 128) {
            this.a = i;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
    }

    public void a(a aVar) {
        this.f446a = aVar;
    }

    public void a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.f447a = bVar;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.gm.a(Ljava/lang/String;)Lcom/xiaomi/push/gj; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.gm.a(Ljava/lang/String;)Ljava/lang/Object; */
    public void a(String str) {
        this.b = str;
    }
}
