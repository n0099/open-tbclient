package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class gb extends gc {

    /* renamed from: a  reason: collision with root package name */
    public boolean f41410a;

    /* renamed from: b  reason: collision with root package name */
    public String f41411b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f422b;

    /* renamed from: c  reason: collision with root package name */
    public String f41412c;

    /* renamed from: d  reason: collision with root package name */
    public String f41413d;

    /* renamed from: e  reason: collision with root package name */
    public String f41414e;

    /* renamed from: f  reason: collision with root package name */
    public String f41415f;

    /* renamed from: g  reason: collision with root package name */
    public String f41416g;

    /* renamed from: h  reason: collision with root package name */
    public String f41417h;

    /* renamed from: i  reason: collision with root package name */
    public String f41418i;
    public String j;
    public String k;
    public String l;

    public gb() {
        this.f41411b = null;
        this.f41412c = null;
        this.f41410a = false;
        this.f41418i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f422b = false;
    }

    public gb(Bundle bundle) {
        super(bundle);
        this.f41411b = null;
        this.f41412c = null;
        this.f41410a = false;
        this.f41418i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f422b = false;
        this.f41411b = bundle.getString("ext_msg_type");
        this.f41413d = bundle.getString("ext_msg_lang");
        this.f41412c = bundle.getString("ext_msg_thread");
        this.f41414e = bundle.getString("ext_msg_sub");
        this.f41415f = bundle.getString("ext_msg_body");
        this.f41416g = bundle.getString("ext_body_encode");
        this.f41417h = bundle.getString("ext_msg_appid");
        this.f41410a = bundle.getBoolean("ext_msg_trans", false);
        this.f422b = bundle.getBoolean("ext_msg_encrypt", false);
        this.f41418i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.gc
    public Bundle a() {
        Bundle a2 = super.a();
        if (!TextUtils.isEmpty(this.f41411b)) {
            a2.putString("ext_msg_type", this.f41411b);
        }
        String str = this.f41413d;
        if (str != null) {
            a2.putString("ext_msg_lang", str);
        }
        String str2 = this.f41414e;
        if (str2 != null) {
            a2.putString("ext_msg_sub", str2);
        }
        String str3 = this.f41415f;
        if (str3 != null) {
            a2.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.f41416g)) {
            a2.putString("ext_body_encode", this.f41416g);
        }
        String str4 = this.f41412c;
        if (str4 != null) {
            a2.putString("ext_msg_thread", str4);
        }
        String str5 = this.f41417h;
        if (str5 != null) {
            a2.putString("ext_msg_appid", str5);
        }
        if (this.f41410a) {
            a2.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f41418i)) {
            a2.putString("ext_msg_seq", this.f41418i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            a2.putString("ext_msg_mseq", this.j);
        }
        if (!TextUtils.isEmpty(this.k)) {
            a2.putString("ext_msg_fseq", this.k);
        }
        if (this.f422b) {
            a2.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.l)) {
            a2.putString("ext_msg_status", this.l);
        }
        return a2;
    }

    @Override // com.xiaomi.push.gc
    public String a() {
        gg m329a;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (this.f41413d != null) {
            sb.append(" xml:lang=\"");
            sb.append(h());
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
        if (!TextUtils.isEmpty(d())) {
            sb.append(" seq=\"");
            sb.append(d());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            sb.append(" mseq=\"");
            sb.append(e());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb.append(" fseq=\"");
            sb.append(f());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb.append(" status=\"");
            sb.append(g());
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
        if (this.f41410a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f41417h)) {
            sb.append(" appid=\"");
            sb.append(c());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.f41411b)) {
            sb.append(" type=\"");
            sb.append(this.f41411b);
            sb.append("\"");
        }
        if (this.f422b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.f41414e != null) {
            sb.append("<subject>");
            sb.append(gn.a(this.f41414e));
            sb.append("</subject>");
        }
        if (this.f41415f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.f41416g)) {
                sb.append(" encode=\"");
                sb.append(this.f41416g);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(gn.a(this.f41415f));
            sb.append("</body>");
        }
        if (this.f41412c != null) {
            sb.append("<thread>");
            sb.append(this.f41412c);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f41411b) && (m329a = m329a()) != null) {
            sb.append(m329a.m333a());
        }
        sb.append(o());
        sb.append("</message>");
        return sb.toString();
    }

    @Override // com.xiaomi.push.gc
    public void a(String str) {
        this.f41417h = str;
    }

    @Override // com.xiaomi.push.gc
    public void a(String str, String str2) {
        this.f41415f = str;
        this.f41416g = str2;
    }

    public void a(boolean z) {
        this.f41410a = z;
    }

    @Override // com.xiaomi.push.gc
    public String b() {
        return this.f41411b;
    }

    public void b(String str) {
        this.f41418i = str;
    }

    public void b(boolean z) {
        this.f422b = z;
    }

    public String c() {
        return this.f41417h;
    }

    public void c(String str) {
        this.j = str;
    }

    public String d() {
        return this.f41418i;
    }

    public void d(String str) {
        this.k = str;
    }

    public String e() {
        return this.j;
    }

    public void e(String str) {
        this.l = str;
    }

    @Override // com.xiaomi.push.gc
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || gb.class != obj.getClass()) {
            return false;
        }
        gb gbVar = (gb) obj;
        if (super.equals(gbVar)) {
            String str = this.f41415f;
            if (str == null ? gbVar.f41415f == null : str.equals(gbVar.f41415f)) {
                String str2 = this.f41413d;
                if (str2 == null ? gbVar.f41413d == null : str2.equals(gbVar.f41413d)) {
                    String str3 = this.f41414e;
                    if (str3 == null ? gbVar.f41414e == null : str3.equals(gbVar.f41414e)) {
                        String str4 = this.f41412c;
                        if (str4 == null ? gbVar.f41412c == null : str4.equals(gbVar.f41412c)) {
                            return this.f41411b == gbVar.f41411b;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public String f() {
        return this.k;
    }

    public void f(String str) {
        this.f41411b = str;
    }

    public String g() {
        return this.l;
    }

    public void g(String str) {
        this.f41414e = str;
    }

    public String h() {
        return this.f41413d;
    }

    public void h(String str) {
        this.f41415f = str;
    }

    @Override // com.xiaomi.push.gc
    public int hashCode() {
        String str = this.f41411b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f41415f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f41412c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f41413d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f41414e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public void i(String str) {
        this.f41412c = str;
    }

    public void j(String str) {
        this.f41413d = str;
    }
}
