package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes6.dex */
public class gi extends gj {

    /* renamed from: a  reason: collision with root package name */
    private boolean f14050a;

    /* renamed from: b  reason: collision with root package name */
    private String f14051b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f471b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    public gi() {
        this.f14051b = null;
        this.c = null;
        this.f14050a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f471b = false;
    }

    public gi(Bundle bundle) {
        super(bundle);
        this.f14051b = null;
        this.c = null;
        this.f14050a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f471b = false;
        this.f14051b = bundle.getString("ext_msg_type");
        this.d = bundle.getString("ext_msg_lang");
        this.c = bundle.getString("ext_msg_thread");
        this.e = bundle.getString("ext_msg_sub");
        this.f = bundle.getString("ext_msg_body");
        this.g = bundle.getString("ext_body_encode");
        this.h = bundle.getString("ext_msg_appid");
        this.f14050a = bundle.getBoolean("ext_msg_trans", false);
        this.f471b = bundle.getBoolean("ext_msg_encrypt", false);
        this.i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.gj
    public Bundle a() {
        Bundle a2 = super.a();
        if (!TextUtils.isEmpty(this.f14051b)) {
            a2.putString("ext_msg_type", this.f14051b);
        }
        if (this.d != null) {
            a2.putString("ext_msg_lang", this.d);
        }
        if (this.e != null) {
            a2.putString("ext_msg_sub", this.e);
        }
        if (this.f != null) {
            a2.putString("ext_msg_body", this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            a2.putString("ext_body_encode", this.g);
        }
        if (this.c != null) {
            a2.putString("ext_msg_thread", this.c);
        }
        if (this.h != null) {
            a2.putString("ext_msg_appid", this.h);
        }
        if (this.f14050a) {
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
        if (this.f471b) {
            a2.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.l)) {
            a2.putString("ext_msg_status", this.l);
        }
        return a2;
    }

    @Override // com.xiaomi.push.gj
    public String a() {
        gn a2;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (p() != null) {
            sb.append(" xmlns=\"").append(p()).append("\"");
        }
        if (this.d != null) {
            sb.append(" xml:lang=\"").append(h()).append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"").append(j()).append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"").append(gu.a(l())).append("\"");
        }
        if (!TextUtils.isEmpty(d())) {
            sb.append(" seq=\"").append(d()).append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            sb.append(" mseq=\"").append(e()).append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb.append(" fseq=\"").append(f()).append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb.append(" status=\"").append(g()).append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"").append(gu.a(m())).append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"").append(gu.a(k())).append("\"");
        }
        if (this.f14050a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.h)) {
            sb.append(" appid=\"").append(c()).append("\"");
        }
        if (!TextUtils.isEmpty(this.f14051b)) {
            sb.append(" type=\"").append(this.f14051b).append("\"");
        }
        if (this.f471b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.e != null) {
            sb.append("<subject>").append(gu.a(this.e));
            sb.append("</subject>");
        }
        if (this.f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.g)) {
                sb.append(" encode=\"").append(this.g).append("\"");
            }
            sb.append(">").append(gu.a(this.f)).append("</body>");
        }
        if (this.c != null) {
            sb.append("<thread>").append(this.c).append("</thread>");
        }
        if (BdStatsConstant.StatsType.ERROR.equalsIgnoreCase(this.f14051b) && (a2 = a()) != null) {
            sb.append(a2.m343a());
        }
        sb.append(o());
        sb.append("</message>");
        return sb.toString();
    }

    @Override // com.xiaomi.push.gj
    public void a(String str) {
        this.h = str;
    }

    @Override // com.xiaomi.push.gj
    public void a(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    public void a(boolean z) {
        this.f14050a = z;
    }

    @Override // com.xiaomi.push.gj
    public String b() {
        return this.f14051b;
    }

    public void b(String str) {
        this.i = str;
    }

    public void b(boolean z) {
        this.f471b = z;
    }

    public String c() {
        return this.h;
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

    @Override // com.xiaomi.push.gj
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gi giVar = (gi) obj;
        if (super.equals(giVar)) {
            if (this.f != null) {
                if (!this.f.equals(giVar.f)) {
                    return false;
                }
            } else if (giVar.f != null) {
                return false;
            }
            if (this.d != null) {
                if (!this.d.equals(giVar.d)) {
                    return false;
                }
            } else if (giVar.d != null) {
                return false;
            }
            if (this.e != null) {
                if (!this.e.equals(giVar.e)) {
                    return false;
                }
            } else if (giVar.e != null) {
                return false;
            }
            if (this.c != null) {
                if (!this.c.equals(giVar.c)) {
                    return false;
                }
            } else if (giVar.c != null) {
                return false;
            }
            return this.f14051b == giVar.f14051b;
        }
        return false;
    }

    public String f() {
        return this.k;
    }

    public void f(String str) {
        this.f14051b = str;
    }

    public String g() {
        return this.l;
    }

    public void g(String str) {
        this.e = str;
    }

    public String h() {
        return this.d;
    }

    public void h(String str) {
        this.f = str;
    }

    @Override // com.xiaomi.push.gj
    public int hashCode() {
        return (((this.d != null ? this.d.hashCode() : 0) + (((this.c != null ? this.c.hashCode() : 0) + (((this.f != null ? this.f.hashCode() : 0) + ((this.f14051b != null ? this.f14051b.hashCode() : 0) * 31)) * 31)) * 31)) * 31) + (this.e != null ? this.e.hashCode() : 0);
    }

    public void i(String str) {
        this.c = str;
    }

    public void j(String str) {
        this.d = str;
    }
}
