package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class gb extends gc {

    /* renamed from: a  reason: collision with root package name */
    public boolean f38454a;

    /* renamed from: b  reason: collision with root package name */
    public String f38455b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f422b;

    /* renamed from: c  reason: collision with root package name */
    public String f38456c;

    /* renamed from: d  reason: collision with root package name */
    public String f38457d;

    /* renamed from: e  reason: collision with root package name */
    public String f38458e;

    /* renamed from: f  reason: collision with root package name */
    public String f38459f;

    /* renamed from: g  reason: collision with root package name */
    public String f38460g;

    /* renamed from: h  reason: collision with root package name */
    public String f38461h;

    /* renamed from: i  reason: collision with root package name */
    public String f38462i;
    public String j;
    public String k;
    public String l;

    public gb() {
        this.f38455b = null;
        this.f38456c = null;
        this.f38454a = false;
        this.f38462i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f422b = false;
    }

    public gb(Bundle bundle) {
        super(bundle);
        this.f38455b = null;
        this.f38456c = null;
        this.f38454a = false;
        this.f38462i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f422b = false;
        this.f38455b = bundle.getString("ext_msg_type");
        this.f38457d = bundle.getString("ext_msg_lang");
        this.f38456c = bundle.getString("ext_msg_thread");
        this.f38458e = bundle.getString("ext_msg_sub");
        this.f38459f = bundle.getString("ext_msg_body");
        this.f38460g = bundle.getString("ext_body_encode");
        this.f38461h = bundle.getString("ext_msg_appid");
        this.f38454a = bundle.getBoolean("ext_msg_trans", false);
        this.f422b = bundle.getBoolean("ext_msg_encrypt", false);
        this.f38462i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.gc
    public Bundle a() {
        Bundle a2 = super.a();
        if (!TextUtils.isEmpty(this.f38455b)) {
            a2.putString("ext_msg_type", this.f38455b);
        }
        String str = this.f38457d;
        if (str != null) {
            a2.putString("ext_msg_lang", str);
        }
        String str2 = this.f38458e;
        if (str2 != null) {
            a2.putString("ext_msg_sub", str2);
        }
        String str3 = this.f38459f;
        if (str3 != null) {
            a2.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.f38460g)) {
            a2.putString("ext_body_encode", this.f38460g);
        }
        String str4 = this.f38456c;
        if (str4 != null) {
            a2.putString("ext_msg_thread", str4);
        }
        String str5 = this.f38461h;
        if (str5 != null) {
            a2.putString("ext_msg_appid", str5);
        }
        if (this.f38454a) {
            a2.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f38462i)) {
            a2.putString("ext_msg_seq", this.f38462i);
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
        gg m331a;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (this.f38457d != null) {
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
        if (this.f38454a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f38461h)) {
            sb.append(" appid=\"");
            sb.append(c());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.f38455b)) {
            sb.append(" type=\"");
            sb.append(this.f38455b);
            sb.append("\"");
        }
        if (this.f422b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.f38458e != null) {
            sb.append("<subject>");
            sb.append(gn.a(this.f38458e));
            sb.append("</subject>");
        }
        if (this.f38459f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.f38460g)) {
                sb.append(" encode=\"");
                sb.append(this.f38460g);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(gn.a(this.f38459f));
            sb.append("</body>");
        }
        if (this.f38456c != null) {
            sb.append("<thread>");
            sb.append(this.f38456c);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f38455b) && (m331a = m331a()) != null) {
            sb.append(m331a.m335a());
        }
        sb.append(o());
        sb.append("</message>");
        return sb.toString();
    }

    @Override // com.xiaomi.push.gc
    public void a(String str) {
        this.f38461h = str;
    }

    @Override // com.xiaomi.push.gc
    public void a(String str, String str2) {
        this.f38459f = str;
        this.f38460g = str2;
    }

    public void a(boolean z) {
        this.f38454a = z;
    }

    @Override // com.xiaomi.push.gc
    public String b() {
        return this.f38455b;
    }

    public void b(String str) {
        this.f38462i = str;
    }

    public void b(boolean z) {
        this.f422b = z;
    }

    public String c() {
        return this.f38461h;
    }

    public void c(String str) {
        this.j = str;
    }

    public String d() {
        return this.f38462i;
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
            String str = this.f38459f;
            if (str == null ? gbVar.f38459f == null : str.equals(gbVar.f38459f)) {
                String str2 = this.f38457d;
                if (str2 == null ? gbVar.f38457d == null : str2.equals(gbVar.f38457d)) {
                    String str3 = this.f38458e;
                    if (str3 == null ? gbVar.f38458e == null : str3.equals(gbVar.f38458e)) {
                        String str4 = this.f38456c;
                        if (str4 == null ? gbVar.f38456c == null : str4.equals(gbVar.f38456c)) {
                            return this.f38455b == gbVar.f38455b;
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
        this.f38455b = str;
    }

    public String g() {
        return this.l;
    }

    public void g(String str) {
        this.f38458e = str;
    }

    public String h() {
        return this.f38457d;
    }

    public void h(String str) {
        this.f38459f = str;
    }

    @Override // com.xiaomi.push.gc
    public int hashCode() {
        String str = this.f38455b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f38459f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f38456c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f38457d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f38458e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public void i(String str) {
        this.f38456c = str;
    }

    public void j(String str) {
        this.f38457d = str;
    }
}
