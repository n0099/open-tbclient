package com.xiaomi.push;

import android.os.Bundle;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class gh extends gj {
    private a a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, String> f396a;

    /* loaded from: classes8.dex */
    public static class a {
        public static final a a = new a("get");
        public static final a b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a(BdStatsConstant.StatsType.ERROR);
        public static final a e = new a("command");

        /* renamed from: a  reason: collision with other field name */
        private String f397a;

        private a(String str) {
            this.f397a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (a.toString().equals(lowerCase)) {
                return a;
            }
            if (b.toString().equals(lowerCase)) {
                return b;
            }
            if (d.toString().equals(lowerCase)) {
                return d;
            }
            if (c.toString().equals(lowerCase)) {
                return c;
            }
            if (e.toString().equals(lowerCase)) {
                return e;
            }
            return null;
        }

        public String toString() {
            return this.f397a;
        }
    }

    public gh() {
        this.a = a.a;
        this.f396a = new HashMap();
    }

    public gh(Bundle bundle) {
        super(bundle);
        this.a = a.a;
        this.f396a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    @Override // com.xiaomi.push.gj
    public Bundle a() {
        Bundle a2 = super.a();
        if (this.a != null) {
            a2.putString("ext_iq_type", this.a.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.gj
    public a a() {
        return this.a;
    }

    @Override // com.xiaomi.push.gj
    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"").append(gu.a(l())).append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"").append(gu.a(m())).append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"").append(gu.a(k())).append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f396a.entrySet()) {
            sb.append(gu.a(entry.getKey())).append("=\"");
            sb.append(gu.a(entry.getValue())).append("\" ");
        }
        if (this.a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"").append(a()).append("\">");
        }
        String b = b();
        if (b != null) {
            sb.append(b);
        }
        sb.append(o());
        gn a2 = a();
        if (a2 != null) {
            sb.append(a2.m312a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.a = a.a;
        } else {
            this.a = aVar;
        }
    }

    public synchronized void a(Map<String, String> map) {
        this.f396a.putAll(map);
    }

    @Override // com.xiaomi.push.gj
    public String b() {
        return null;
    }
}
