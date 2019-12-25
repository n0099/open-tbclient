package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class io implements ir<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f764a;

    /* renamed from: a  reason: collision with other field name */
    public String f765a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f766a;

    /* renamed from: b  reason: collision with other field name */
    public String f767b;

    /* renamed from: c  reason: collision with other field name */
    public String f768c;

    /* renamed from: d  reason: collision with other field name */
    public String f769d;

    /* renamed from: e  reason: collision with other field name */
    public String f770e;

    /* renamed from: f  reason: collision with other field name */
    public String f771f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f763a = new jh("XmPushActionUnSubscription");
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
            int compareTo = Boolean.valueOf(m442a()).compareTo(Boolean.valueOf(ioVar.m442a()));
            if (compareTo == 0) {
                if (!m442a() || (a9 = is.a(this.f765a, ioVar.f765a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = is.a(this.f764a, ioVar.f764a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = is.a(this.f767b, ioVar.f767b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = is.a(this.f768c, ioVar.f768c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = is.a(this.f769d, ioVar.f769d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = is.a(this.f770e, ioVar.f770e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = is.a(this.f771f, ioVar.f771f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = is.a(this.f766a, ioVar.f766a)) == 0) {
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
        this.f767b = str;
        return this;
    }

    public void a() {
        if (this.f767b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f768c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f769d == null) {
            throw new jd("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 11) {
                        this.f765a = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 2:
                    if (m454a.a == 12) {
                        this.f764a = new hv();
                        this.f764a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 3:
                    if (m454a.a == 11) {
                        this.f767b = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 4:
                    if (m454a.a == 11) {
                        this.f768c = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 5:
                    if (m454a.a == 11) {
                        this.f769d = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 6:
                    if (m454a.a == 11) {
                        this.f770e = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 7:
                    if (m454a.a == 11) {
                        this.f771f = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 8:
                    if (m454a.a == 15) {
                        ja m455a = jcVar.m455a();
                        this.f766a = new ArrayList(m455a.f796a);
                        for (int i = 0; i < m455a.f796a; i++) {
                            this.f766a.add(jcVar.m459a());
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m454a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m442a() {
        return this.f765a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m443a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m442a = m442a();
        boolean m442a2 = ioVar.m442a();
        if ((m442a || m442a2) && !(m442a && m442a2 && this.f765a.equals(ioVar.f765a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f764a.m364a(ioVar.f764a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f767b.equals(ioVar.f767b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f768c.equals(ioVar.f768c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ioVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f769d.equals(ioVar.f769d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f770e.equals(ioVar.f770e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f771f.equals(ioVar.f771f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ioVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f766a.equals(ioVar.f766a));
    }

    public io b(String str) {
        this.f768c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f763a);
        if (this.f765a != null && m442a()) {
            jcVar.a(a);
            jcVar.a(this.f765a);
            jcVar.b();
        }
        if (this.f764a != null && b()) {
            jcVar.a(b);
            this.f764a.b(jcVar);
            jcVar.b();
        }
        if (this.f767b != null) {
            jcVar.a(c);
            jcVar.a(this.f767b);
            jcVar.b();
        }
        if (this.f768c != null) {
            jcVar.a(d);
            jcVar.a(this.f768c);
            jcVar.b();
        }
        if (this.f769d != null) {
            jcVar.a(e);
            jcVar.a(this.f769d);
            jcVar.b();
        }
        if (this.f770e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f770e);
            jcVar.b();
        }
        if (this.f771f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f771f);
            jcVar.b();
        }
        if (this.f766a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f766a.size()));
            for (String str : this.f766a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public boolean b() {
        return this.f764a != null;
    }

    public io c(String str) {
        this.f769d = str;
        return this;
    }

    public boolean c() {
        return this.f767b != null;
    }

    public io d(String str) {
        this.f770e = str;
        return this;
    }

    public boolean d() {
        return this.f768c != null;
    }

    public io e(String str) {
        this.f771f = str;
        return this;
    }

    public boolean e() {
        return this.f769d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m443a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f770e != null;
    }

    public boolean g() {
        return this.f771f != null;
    }

    public boolean h() {
        return this.f766a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = true;
        if (m442a()) {
            sb.append("debug:");
            if (this.f765a == null) {
                sb.append("null");
            } else {
                sb.append(this.f765a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f764a == null) {
                sb.append("null");
            } else {
                sb.append(this.f764a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f767b == null) {
            sb.append("null");
        } else {
            sb.append(this.f767b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f768c == null) {
            sb.append("null");
        } else {
            sb.append(this.f768c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f769d == null) {
            sb.append("null");
        } else {
            sb.append(this.f769d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f770e == null) {
                sb.append("null");
            } else {
                sb.append(this.f770e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f771f == null) {
                sb.append("null");
            } else {
                sb.append(this.f771f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f766a == null) {
                sb.append("null");
            } else {
                sb.append(this.f766a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
