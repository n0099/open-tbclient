package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class io implements ir<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f759a;

    /* renamed from: a  reason: collision with other field name */
    public String f760a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f761a;

    /* renamed from: b  reason: collision with other field name */
    public String f762b;

    /* renamed from: c  reason: collision with other field name */
    public String f763c;

    /* renamed from: d  reason: collision with other field name */
    public String f764d;

    /* renamed from: e  reason: collision with other field name */
    public String f765e;

    /* renamed from: f  reason: collision with other field name */
    public String f766f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f758a = new jh("XmPushActionUnSubscription");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz h = new iz("", (byte) 15, 8);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(io ioVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(ioVar.getClass())) {
            int compareTo = Boolean.valueOf(m439a()).compareTo(Boolean.valueOf(ioVar.m439a()));
            if (compareTo == 0) {
                if (!m439a() || (a9 = is.a(this.f760a, ioVar.f760a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = is.a(this.f759a, ioVar.f759a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = is.a(this.f762b, ioVar.f762b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = is.a(this.f763c, ioVar.f763c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = is.a(this.f764d, ioVar.f764d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = is.a(this.f765e, ioVar.f765e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = is.a(this.f766f, ioVar.f766f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = is.a(this.f761a, ioVar.f761a)) == 0) {
                                                                            return 0;
                                                                        }
                                                                        return a2;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a3;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a4;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a5;
                                            }
                                            return compareTo5;
                                        }
                                        return a6;
                                    }
                                    return compareTo4;
                                }
                                return a7;
                            }
                            return compareTo3;
                        }
                        return a8;
                    }
                    return compareTo2;
                }
                return a9;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ioVar.getClass().getName());
    }

    public io a(String str) {
        this.f762b = str;
        return this;
    }

    public void a() {
        if (this.f762b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f763c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f764d == null) {
            throw new jd("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m455a();
        while (true) {
            iz m451a = jcVar.m451a();
            if (m451a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m451a.f788a) {
                case 1:
                    if (m451a.a == 11) {
                        this.f760a = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 2:
                    if (m451a.a == 12) {
                        this.f759a = new hv();
                        this.f759a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 3:
                    if (m451a.a == 11) {
                        this.f762b = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 4:
                    if (m451a.a == 11) {
                        this.f763c = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 5:
                    if (m451a.a == 11) {
                        this.f764d = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 6:
                    if (m451a.a == 11) {
                        this.f765e = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 7:
                    if (m451a.a == 11) {
                        this.f766f = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 8:
                    if (m451a.a == 15) {
                        ja m452a = jcVar.m452a();
                        this.f761a = new ArrayList(m452a.f791a);
                        for (int i = 0; i < m452a.f791a; i++) {
                            this.f761a.add(jcVar.m456a());
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m451a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m439a() {
        return this.f760a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m440a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m439a = m439a();
        boolean m439a2 = ioVar.m439a();
        if ((m439a || m439a2) && !(m439a && m439a2 && this.f760a.equals(ioVar.f760a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f759a.m361a(ioVar.f759a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f762b.equals(ioVar.f762b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f763c.equals(ioVar.f763c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ioVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f764d.equals(ioVar.f764d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f765e.equals(ioVar.f765e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f766f.equals(ioVar.f766f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ioVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f761a.equals(ioVar.f761a));
    }

    public io b(String str) {
        this.f763c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f758a);
        if (this.f760a != null && m439a()) {
            jcVar.a(a);
            jcVar.a(this.f760a);
            jcVar.b();
        }
        if (this.f759a != null && b()) {
            jcVar.a(b);
            this.f759a.b(jcVar);
            jcVar.b();
        }
        if (this.f762b != null) {
            jcVar.a(c);
            jcVar.a(this.f762b);
            jcVar.b();
        }
        if (this.f763c != null) {
            jcVar.a(d);
            jcVar.a(this.f763c);
            jcVar.b();
        }
        if (this.f764d != null) {
            jcVar.a(e);
            jcVar.a(this.f764d);
            jcVar.b();
        }
        if (this.f765e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f765e);
            jcVar.b();
        }
        if (this.f766f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f766f);
            jcVar.b();
        }
        if (this.f761a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f761a.size()));
            for (String str : this.f761a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m459a();
    }

    public boolean b() {
        return this.f759a != null;
    }

    public io c(String str) {
        this.f764d = str;
        return this;
    }

    public boolean c() {
        return this.f762b != null;
    }

    public io d(String str) {
        this.f765e = str;
        return this;
    }

    public boolean d() {
        return this.f763c != null;
    }

    public io e(String str) {
        this.f766f = str;
        return this;
    }

    public boolean e() {
        return this.f764d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m440a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f765e != null;
    }

    public boolean g() {
        return this.f766f != null;
    }

    public boolean h() {
        return this.f761a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = true;
        if (m439a()) {
            sb.append("debug:");
            if (this.f760a == null) {
                sb.append("null");
            } else {
                sb.append(this.f760a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f759a == null) {
                sb.append("null");
            } else {
                sb.append(this.f759a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f762b == null) {
            sb.append("null");
        } else {
            sb.append(this.f762b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f763c == null) {
            sb.append("null");
        } else {
            sb.append(this.f763c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f764d == null) {
            sb.append("null");
        } else {
            sb.append(this.f764d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f765e == null) {
                sb.append("null");
            } else {
                sb.append(this.f765e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f766f == null) {
                sb.append("null");
            } else {
                sb.append(this.f766f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f761a == null) {
                sb.append("null");
            } else {
                sb.append(this.f761a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
