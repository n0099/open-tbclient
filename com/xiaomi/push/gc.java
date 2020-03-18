package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes8.dex */
public class gc extends gd {
    private boolean a;
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f405b;
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

    public gc() {
        this.b = null;
        this.c = null;
        this.a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f405b = false;
    }

    public gc(Bundle bundle) {
        super(bundle);
        this.b = null;
        this.c = null;
        this.a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f405b = false;
        this.b = bundle.getString("ext_msg_type");
        this.d = bundle.getString("ext_msg_lang");
        this.c = bundle.getString("ext_msg_thread");
        this.e = bundle.getString("ext_msg_sub");
        this.f = bundle.getString("ext_msg_body");
        this.g = bundle.getString("ext_body_encode");
        this.h = bundle.getString("ext_msg_appid");
        this.a = bundle.getBoolean("ext_msg_trans", false);
        this.f405b = bundle.getBoolean("ext_msg_encrypt", false);
        this.i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.gd
    public Bundle a() {
        Bundle a = super.a();
        if (!TextUtils.isEmpty(this.b)) {
            a.putString("ext_msg_type", this.b);
        }
        if (this.d != null) {
            a.putString("ext_msg_lang", this.d);
        }
        if (this.e != null) {
            a.putString("ext_msg_sub", this.e);
        }
        if (this.f != null) {
            a.putString("ext_msg_body", this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            a.putString("ext_body_encode", this.g);
        }
        if (this.c != null) {
            a.putString("ext_msg_thread", this.c);
        }
        if (this.h != null) {
            a.putString("ext_msg_appid", this.h);
        }
        if (this.a) {
            a.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.i)) {
            a.putString("ext_msg_seq", this.i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            a.putString("ext_msg_mseq", this.j);
        }
        if (!TextUtils.isEmpty(this.k)) {
            a.putString("ext_msg_fseq", this.k);
        }
        if (this.f405b) {
            a.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.l)) {
            a.putString("ext_msg_status", this.l);
        }
        return a;
    }

    @Override // com.xiaomi.push.gd
    public String a() {
        gh a;
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
            sb.append(" to=\"").append(go.a(l())).append("\"");
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
            sb.append(" from=\"").append(go.a(m())).append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"").append(go.a(k())).append("\"");
        }
        if (this.a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.h)) {
            sb.append(" appid=\"").append(c()).append("\"");
        }
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" type=\"").append(this.b).append("\"");
        }
        if (this.f405b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.e != null) {
            sb.append("<subject>").append(go.a(this.e));
            sb.append("</subject>");
        }
        if (this.f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.g)) {
                sb.append(" encode=\"").append(this.g).append("\"");
            }
            sb.append(">").append(go.a(this.f)).append("</body>");
        }
        if (this.c != null) {
            sb.append("<thread>").append(this.c).append("</thread>");
        }
        if (BdStatsConstant.StatsType.ERROR.equalsIgnoreCase(this.b) && (a = a()) != null) {
            sb.append(a.m305a());
        }
        sb.append(o());
        sb.append("</message>");
        return sb.toString();
    }

    @Override // com.xiaomi.push.gd
    public void a(String str) {
        this.h = str;
    }

    @Override // com.xiaomi.push.gd
    public void a(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    public void a(boolean z) {
        this.a = z;
    }

    @Override // com.xiaomi.push.gd
    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.i = str;
    }

    public void b(boolean z) {
        this.f405b = z;
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

    @Override // com.xiaomi.push.gd
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gc gcVar = (gc) obj;
        if (super.equals(gcVar)) {
            if (this.f != null) {
                if (!this.f.equals(gcVar.f)) {
                    return false;
                }
            } else if (gcVar.f != null) {
                return false;
            }
            if (this.d != null) {
                if (!this.d.equals(gcVar.d)) {
                    return false;
                }
            } else if (gcVar.d != null) {
                return false;
            }
            if (this.e != null) {
                if (!this.e.equals(gcVar.e)) {
                    return false;
                }
            } else if (gcVar.e != null) {
                return false;
            }
            if (this.c != null) {
                if (!this.c.equals(gcVar.c)) {
                    return false;
                }
            } else if (gcVar.c != null) {
                return false;
            }
            return this.b == gcVar.b;
        }
        return false;
    }

    public String f() {
        return this.k;
    }

    public void f(String str) {
        this.b = str;
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

    @Override // com.xiaomi.push.gd
    public int hashCode() {
        return (((this.d != null ? this.d.hashCode() : 0) + (((this.c != null ? this.c.hashCode() : 0) + (((this.f != null ? this.f.hashCode() : 0) + ((this.b != null ? this.b.hashCode() : 0) * 31)) * 31)) * 31)) * 31) + (this.e != null ? this.e.hashCode() : 0);
    }

    public void i(String str) {
        this.c = str;
    }

    public void j(String str) {
        this.d = str;
    }
}
