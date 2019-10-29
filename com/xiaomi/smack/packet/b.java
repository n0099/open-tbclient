package com.xiaomi.smack.packet;

import android.os.Bundle;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.coloros.mcssdk.mode.CommandMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b extends d {
    private a c;
    private final Map<String, String> d;

    /* loaded from: classes3.dex */
    public static class a {
        public static final a a = new a("get");
        public static final a b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a(BdStatsConstant.StatsType.ERROR);
        public static final a e = new a(CommandMessage.COMMAND);
        private String f;

        private a(String str) {
            this.f = str;
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
            return this.f;
        }
    }

    public b() {
        this.c = a.a;
        this.d = new HashMap();
    }

    public b(Bundle bundle) {
        super(bundle);
        this.c = a.a;
        this.d = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.c = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public a a() {
        return this.c;
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.c = a.a;
        } else {
            this.c = aVar;
        }
    }

    public synchronized void a(Map<String, String> map) {
        this.d.putAll(map);
    }

    @Override // com.xiaomi.smack.packet.d
    public Bundle b() {
        Bundle b = super.b();
        if (this.c != null) {
            b.putString("ext_iq_type", this.c.toString());
        }
        return b;
    }

    @Override // com.xiaomi.smack.packet.d
    public String c() {
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (k() != null) {
            sb.append("id=\"" + k() + "\" ");
        }
        if (m() != null) {
            sb.append("to=\"").append(com.xiaomi.smack.util.d.a(m())).append("\" ");
        }
        if (n() != null) {
            sb.append("from=\"").append(com.xiaomi.smack.util.d.a(n())).append("\" ");
        }
        if (l() != null) {
            sb.append("chid=\"").append(com.xiaomi.smack.util.d.a(l())).append("\" ");
        }
        for (Map.Entry<String, String> entry : this.d.entrySet()) {
            sb.append(com.xiaomi.smack.util.d.a(entry.getKey())).append("=\"");
            sb.append(com.xiaomi.smack.util.d.a(entry.getValue())).append("\" ");
        }
        if (this.c == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"").append(a()).append("\">");
        }
        String d = d();
        if (d != null) {
            sb.append(d);
        }
        sb.append(s());
        h p = p();
        if (p != null) {
            sb.append(p.b());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public String d() {
        return null;
    }
}
