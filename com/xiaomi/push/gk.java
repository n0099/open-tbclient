package com.xiaomi.push;

import android.os.Bundle;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class gk extends gm {
    public a a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, String> f438a;

    /* loaded from: classes10.dex */
    public static class a {
        public static final a a = new a(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE);
        public static final a b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a("error");
        public static final a e = new a("command");

        /* renamed from: a  reason: collision with other field name */
        public String f439a;

        public a(String str) {
            this.f439a = str;
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
            return this.f439a;
        }
    }

    public gk() {
        this.a = a.a;
        this.f438a = new HashMap();
    }

    public gk(Bundle bundle) {
        super(bundle);
        this.a = a.a;
        this.f438a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    @Override // com.xiaomi.push.gm
    public Bundle a() {
        Bundle a2 = super.a();
        a aVar = this.a;
        if (aVar != null) {
            a2.putString("ext_iq_type", aVar.toString());
        }
        return a2;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.gm.a()Landroid/os/Bundle; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.gm.a()Lcom/xiaomi/push/gq; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.gm.a()Ljava/lang/String; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.gm.a()Ljava/util/Collection; */
    /* renamed from: a  reason: collision with other method in class */
    public a m523a() {
        return this.a;
    }

    @Override // com.xiaomi.push.gm
    /* renamed from: a  reason: collision with other method in class */
    public String mo524a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"");
            sb.append(gx.a(l()));
            sb.append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"");
            sb.append(gx.a(m()));
            sb.append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"");
            sb.append(gx.a(k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f438a.entrySet()) {
            sb.append(gx.a(entry.getKey()));
            sb.append("=\"");
            sb.append(gx.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.a == null) {
            str = "type=\"get\">";
        } else {
            sb.append("type=\"");
            sb.append(m523a());
            str = "\">";
        }
        sb.append(str);
        String b = b();
        if (b != null) {
            sb.append(b);
        }
        sb.append(o());
        gq m525a = m525a();
        if (m525a != null) {
            sb.append(m525a.m528a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public void a(a aVar) {
        if (aVar == null) {
            aVar = a.a;
        }
        this.a = aVar;
    }

    public synchronized void a(Map<String, String> map) {
        this.f438a.putAll(map);
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.gm.b()Ljava/util/Collection; */
    public String b() {
        return null;
    }
}
