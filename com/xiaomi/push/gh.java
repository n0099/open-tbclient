package com.xiaomi.push;

import android.os.Bundle;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class gh extends gj {

    /* renamed from: a  reason: collision with root package name */
    private a f14345a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, String> f470a;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f14346a = new a("get");

        /* renamed from: b  reason: collision with root package name */
        public static final a f14347b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a(BdStatsConstant.StatsType.ERROR);
        public static final a e = new a("command");

        /* renamed from: a  reason: collision with other field name */
        private String f471a;

        private a(String str) {
            this.f471a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (f14346a.toString().equals(lowerCase)) {
                return f14346a;
            }
            if (f14347b.toString().equals(lowerCase)) {
                return f14347b;
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
            return this.f471a;
        }
    }

    public gh() {
        this.f14345a = a.f14346a;
        this.f470a = new HashMap();
    }

    public gh(Bundle bundle) {
        super(bundle);
        this.f14345a = a.f14346a;
        this.f470a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f14345a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    @Override // com.xiaomi.push.gj
    public Bundle a() {
        Bundle a2 = super.a();
        if (this.f14345a != null) {
            a2.putString("ext_iq_type", this.f14345a.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.gj
    public a a() {
        return this.f14345a;
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
        for (Map.Entry<String, String> entry : this.f470a.entrySet()) {
            sb.append(gu.a(entry.getKey())).append("=\"");
            sb.append(gu.a(entry.getValue())).append("\" ");
        }
        if (this.f14345a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"").append(a()).append("\">");
        }
        String b2 = b();
        if (b2 != null) {
            sb.append(b2);
        }
        sb.append(o());
        gn a2 = a();
        if (a2 != null) {
            sb.append(a2.m348a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.f14345a = a.f14346a;
        } else {
            this.f14345a = aVar;
        }
    }

    public synchronized void a(Map<String, String> map) {
        this.f470a.putAll(map);
    }

    @Override // com.xiaomi.push.gj
    public String b() {
        return null;
    }
}
