package com.xiaomi.push;

import android.os.Bundle;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class gh extends gj {

    /* renamed from: a  reason: collision with root package name */
    private a f4922a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, String> f391a;

    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4923a = new a("get");
        public static final a b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a(BdStatsConstant.StatsType.ERROR);
        public static final a e = new a("command");

        /* renamed from: a  reason: collision with other field name */
        private String f392a;

        private a(String str) {
            this.f392a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (f4923a.toString().equals(lowerCase)) {
                return f4923a;
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
            return this.f392a;
        }
    }

    public gh() {
        this.f4922a = a.f4923a;
        this.f391a = new HashMap();
    }

    public gh(Bundle bundle) {
        super(bundle);
        this.f4922a = a.f4923a;
        this.f391a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f4922a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    @Override // com.xiaomi.push.gj
    public Bundle a() {
        Bundle a2 = super.a();
        if (this.f4922a != null) {
            a2.putString("ext_iq_type", this.f4922a.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.gj
    public a a() {
        return this.f4922a;
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
        for (Map.Entry<String, String> entry : this.f391a.entrySet()) {
            sb.append(gu.a(entry.getKey())).append("=\"");
            sb.append(gu.a(entry.getValue())).append("\" ");
        }
        if (this.f4922a == null) {
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
            sb.append(a2.m319a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.f4922a = a.f4923a;
        } else {
            this.f4922a = aVar;
        }
    }

    public synchronized void a(Map<String, String> map) {
        this.f391a.putAll(map);
    }

    @Override // com.xiaomi.push.gj
    public String b() {
        return null;
    }
}
