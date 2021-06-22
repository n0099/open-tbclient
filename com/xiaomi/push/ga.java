package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class ga extends gc {

    /* renamed from: a  reason: collision with root package name */
    public a f41404a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, String> f420a;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f41405a = new a("get");

        /* renamed from: b  reason: collision with root package name */
        public static final a f41406b = new a("set");

        /* renamed from: c  reason: collision with root package name */
        public static final a f41407c = new a("result");

        /* renamed from: d  reason: collision with root package name */
        public static final a f41408d = new a("error");

        /* renamed from: e  reason: collision with root package name */
        public static final a f41409e = new a("command");

        /* renamed from: a  reason: collision with other field name */
        public String f421a;

        public a(String str) {
            this.f421a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (f41405a.toString().equals(lowerCase)) {
                return f41405a;
            }
            if (f41406b.toString().equals(lowerCase)) {
                return f41406b;
            }
            if (f41408d.toString().equals(lowerCase)) {
                return f41408d;
            }
            if (f41407c.toString().equals(lowerCase)) {
                return f41407c;
            }
            if (f41409e.toString().equals(lowerCase)) {
                return f41409e;
            }
            return null;
        }

        public String toString() {
            return this.f421a;
        }
    }

    public ga() {
        this.f41404a = a.f41405a;
        this.f420a = new HashMap();
    }

    public ga(Bundle bundle) {
        super(bundle);
        this.f41404a = a.f41405a;
        this.f420a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f41404a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    @Override // com.xiaomi.push.gc
    public Bundle a() {
        Bundle a2 = super.a();
        a aVar = this.f41404a;
        if (aVar != null) {
            a2.putString("ext_iq_type", aVar.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.gc
    public a a() {
        return this.f41404a;
    }

    @Override // com.xiaomi.push.gc
    public String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"");
            sb.append(gn.a(l()));
            sb.append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"");
            sb.append(gn.a(m()));
            sb.append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"");
            sb.append(gn.a(k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f420a.entrySet()) {
            sb.append(gn.a(entry.getKey()));
            sb.append("=\"");
            sb.append(gn.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.f41404a == null) {
            str = "type=\"get\">";
        } else {
            sb.append("type=\"");
            sb.append(a());
            str = "\">";
        }
        sb.append(str);
        String b2 = b();
        if (b2 != null) {
            sb.append(b2);
        }
        sb.append(o());
        gg m329a = m329a();
        if (m329a != null) {
            sb.append(m329a.m333a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public void a(a aVar) {
        if (aVar == null) {
            aVar = a.f41405a;
        }
        this.f41404a = aVar;
    }

    public synchronized void a(Map<String, String> map) {
        this.f420a.putAll(map);
    }

    @Override // com.xiaomi.push.gc
    public String b() {
        return null;
    }
}
