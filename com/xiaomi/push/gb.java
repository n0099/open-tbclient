package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class gb extends gc {

    /* renamed from: a  reason: collision with root package name */
    public boolean f40548a;

    /* renamed from: b  reason: collision with root package name */
    public String f40549b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f422b;

    /* renamed from: c  reason: collision with root package name */
    public String f40550c;

    /* renamed from: d  reason: collision with root package name */
    public String f40551d;

    /* renamed from: e  reason: collision with root package name */
    public String f40552e;

    /* renamed from: f  reason: collision with root package name */
    public String f40553f;

    /* renamed from: g  reason: collision with root package name */
    public String f40554g;

    /* renamed from: h  reason: collision with root package name */
    public String f40555h;
    public String i;
    public String j;
    public String k;
    public String l;

    public gb() {
        this.f40549b = null;
        this.f40550c = null;
        this.f40548a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f422b = false;
    }

    public gb(Bundle bundle) {
        super(bundle);
        this.f40549b = null;
        this.f40550c = null;
        this.f40548a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f422b = false;
        this.f40549b = bundle.getString("ext_msg_type");
        this.f40551d = bundle.getString("ext_msg_lang");
        this.f40550c = bundle.getString("ext_msg_thread");
        this.f40552e = bundle.getString("ext_msg_sub");
        this.f40553f = bundle.getString("ext_msg_body");
        this.f40554g = bundle.getString("ext_body_encode");
        this.f40555h = bundle.getString("ext_msg_appid");
        this.f40548a = bundle.getBoolean("ext_msg_trans", false);
        this.f422b = bundle.getBoolean("ext_msg_encrypt", false);
        this.i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.gc
    public Bundle a() {
        Bundle a2 = super.a();
        if (!TextUtils.isEmpty(this.f40549b)) {
            a2.putString("ext_msg_type", this.f40549b);
        }
        String str = this.f40551d;
        if (str != null) {
            a2.putString("ext_msg_lang", str);
        }
        String str2 = this.f40552e;
        if (str2 != null) {
            a2.putString("ext_msg_sub", str2);
        }
        String str3 = this.f40553f;
        if (str3 != null) {
            a2.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.f40554g)) {
            a2.putString("ext_body_encode", this.f40554g);
        }
        String str4 = this.f40550c;
        if (str4 != null) {
            a2.putString("ext_msg_thread", str4);
        }
        String str5 = this.f40555h;
        if (str5 != null) {
            a2.putString("ext_msg_appid", str5);
        }
        if (this.f40548a) {
            a2.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.i)) {
            a2.putString("ext_msg_seq", this.i);
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
        gg m324a;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (this.f40551d != null) {
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
        if (this.f40548a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f40555h)) {
            sb.append(" appid=\"");
            sb.append(c());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.f40549b)) {
            sb.append(" type=\"");
            sb.append(this.f40549b);
            sb.append("\"");
        }
        if (this.f422b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.f40552e != null) {
            sb.append("<subject>");
            sb.append(gn.a(this.f40552e));
            sb.append("</subject>");
        }
        if (this.f40553f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.f40554g)) {
                sb.append(" encode=\"");
                sb.append(this.f40554g);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(gn.a(this.f40553f));
            sb.append("</body>");
        }
        if (this.f40550c != null) {
            sb.append("<thread>");
            sb.append(this.f40550c);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f40549b) && (m324a = m324a()) != null) {
            sb.append(m324a.m328a());
        }
        sb.append(o());
        sb.append("</message>");
        return sb.toString();
    }

    @Override // com.xiaomi.push.gc
    public void a(String str) {
        this.f40555h = str;
    }

    @Override // com.xiaomi.push.gc
    public void a(String str, String str2) {
        this.f40553f = str;
        this.f40554g = str2;
    }

    public void a(boolean z) {
        this.f40548a = z;
    }

    @Override // com.xiaomi.push.gc
    public String b() {
        return this.f40549b;
    }

    public void b(String str) {
        this.i = str;
    }

    public void b(boolean z) {
        this.f422b = z;
    }

    public String c() {
        return this.f40555h;
    }

    public void c(String str) {
        this.j = str;
    }

    public String d() {
        return this.i;
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
            String str = this.f40553f;
            if (str == null ? gbVar.f40553f == null : str.equals(gbVar.f40553f)) {
                String str2 = this.f40551d;
                if (str2 == null ? gbVar.f40551d == null : str2.equals(gbVar.f40551d)) {
                    String str3 = this.f40552e;
                    if (str3 == null ? gbVar.f40552e == null : str3.equals(gbVar.f40552e)) {
                        String str4 = this.f40550c;
                        if (str4 == null ? gbVar.f40550c == null : str4.equals(gbVar.f40550c)) {
                            return this.f40549b == gbVar.f40549b;
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
        this.f40549b = str;
    }

    public String g() {
        return this.l;
    }

    public void g(String str) {
        this.f40552e = str;
    }

    public String h() {
        return this.f40551d;
    }

    public void h(String str) {
        this.f40553f = str;
    }

    @Override // com.xiaomi.push.gc
    public int hashCode() {
        String str = this.f40549b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f40553f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f40550c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f40551d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f40552e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public void i(String str) {
        this.f40550c = str;
    }

    public void j(String str) {
        this.f40551d = str;
    }
}
