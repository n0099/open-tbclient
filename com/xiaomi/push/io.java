package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class io implements ir<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f760a;

    /* renamed from: a  reason: collision with other field name */
    public String f761a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f762a;

    /* renamed from: b  reason: collision with other field name */
    public String f763b;

    /* renamed from: c  reason: collision with other field name */
    public String f764c;

    /* renamed from: d  reason: collision with other field name */
    public String f765d;

    /* renamed from: e  reason: collision with other field name */
    public String f766e;

    /* renamed from: f  reason: collision with other field name */
    public String f767f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f759a = new jh("XmPushActionUnSubscription");
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
            int compareTo = Boolean.valueOf(m459a()).compareTo(Boolean.valueOf(ioVar.m459a()));
            if (compareTo == 0) {
                if (!m459a() || (a9 = is.a(this.f761a, ioVar.f761a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = is.a(this.f760a, ioVar.f760a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = is.a(this.f763b, ioVar.f763b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = is.a(this.f764c, ioVar.f764c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = is.a(this.f765d, ioVar.f765d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = is.a(this.f766e, ioVar.f766e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = is.a(this.f767f, ioVar.f767f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = is.a(this.f762a, ioVar.f762a)) == 0) {
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
        this.f763b = str;
        return this;
    }

    public void a() {
        if (this.f763b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f764c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f765d == null) {
            throw new jd("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a == 11) {
                        this.f761a = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 2:
                    if (m471a.a == 12) {
                        this.f760a = new hv();
                        this.f760a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 3:
                    if (m471a.a == 11) {
                        this.f763b = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 4:
                    if (m471a.a == 11) {
                        this.f764c = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 5:
                    if (m471a.a == 11) {
                        this.f765d = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 6:
                    if (m471a.a == 11) {
                        this.f766e = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 7:
                    if (m471a.a == 11) {
                        this.f767f = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 8:
                    if (m471a.a == 15) {
                        ja m472a = jcVar.m472a();
                        this.f762a = new ArrayList(m472a.f792a);
                        for (int i = 0; i < m472a.f792a; i++) {
                            this.f762a.add(jcVar.m476a());
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m471a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m459a() {
        return this.f761a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m460a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m459a = m459a();
        boolean m459a2 = ioVar.m459a();
        if ((m459a || m459a2) && !(m459a && m459a2 && this.f761a.equals(ioVar.f761a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f760a.m381a(ioVar.f760a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f763b.equals(ioVar.f763b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f764c.equals(ioVar.f764c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ioVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f765d.equals(ioVar.f765d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f766e.equals(ioVar.f766e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f767f.equals(ioVar.f767f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ioVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f762a.equals(ioVar.f762a));
    }

    public io b(String str) {
        this.f764c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f759a);
        if (this.f761a != null && m459a()) {
            jcVar.a(a);
            jcVar.a(this.f761a);
            jcVar.b();
        }
        if (this.f760a != null && b()) {
            jcVar.a(b);
            this.f760a.b(jcVar);
            jcVar.b();
        }
        if (this.f763b != null) {
            jcVar.a(c);
            jcVar.a(this.f763b);
            jcVar.b();
        }
        if (this.f764c != null) {
            jcVar.a(d);
            jcVar.a(this.f764c);
            jcVar.b();
        }
        if (this.f765d != null) {
            jcVar.a(e);
            jcVar.a(this.f765d);
            jcVar.b();
        }
        if (this.f766e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f766e);
            jcVar.b();
        }
        if (this.f767f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f767f);
            jcVar.b();
        }
        if (this.f762a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f762a.size()));
            for (String str : this.f762a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    public boolean b() {
        return this.f760a != null;
    }

    public io c(String str) {
        this.f765d = str;
        return this;
    }

    public boolean c() {
        return this.f763b != null;
    }

    public io d(String str) {
        this.f766e = str;
        return this;
    }

    public boolean d() {
        return this.f764c != null;
    }

    public io e(String str) {
        this.f767f = str;
        return this;
    }

    public boolean e() {
        return this.f765d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m460a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f766e != null;
    }

    public boolean g() {
        return this.f767f != null;
    }

    public boolean h() {
        return this.f762a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = true;
        if (m459a()) {
            sb.append("debug:");
            if (this.f761a == null) {
                sb.append("null");
            } else {
                sb.append(this.f761a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f760a == null) {
                sb.append("null");
            } else {
                sb.append(this.f760a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f763b == null) {
            sb.append("null");
        } else {
            sb.append(this.f763b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f764c == null) {
            sb.append("null");
        } else {
            sb.append(this.f764c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f765d == null) {
            sb.append("null");
        } else {
            sb.append(this.f765d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f766e == null) {
                sb.append("null");
            } else {
                sb.append(this.f766e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f767f == null) {
                sb.append("null");
            } else {
                sb.append(this.f767f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f762a == null) {
                sb.append("null");
            } else {
                sb.append(this.f762a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
