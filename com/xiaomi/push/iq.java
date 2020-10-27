package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class iq implements ix<iq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f700a;

    /* renamed from: a  reason: collision with other field name */
    public String f701a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f702a;

    /* renamed from: b  reason: collision with other field name */
    public String f703b;

    /* renamed from: c  reason: collision with other field name */
    public String f704c;

    /* renamed from: d  reason: collision with other field name */
    public String f705d;

    /* renamed from: e  reason: collision with other field name */
    public String f706e;

    /* renamed from: f  reason: collision with other field name */
    public String f707f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f699a = new jn("XmPushActionSubscription");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4984a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", (byte) 15, 8);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(iq iqVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(iqVar.getClass())) {
            int compareTo = Boolean.valueOf(m462a()).compareTo(Boolean.valueOf(iqVar.m462a()));
            if (compareTo == 0) {
                if (!m462a() || (a9 = iy.a(this.f701a, iqVar.f701a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iqVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f700a, iqVar.f700a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iqVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f703b, iqVar.f703b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f704c, iqVar.f704c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f705d, iqVar.f705d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f706e, iqVar.f706e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f707f, iqVar.f707f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f702a, iqVar.f702a)) == 0) {
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
        return getClass().getName().compareTo(iqVar.getClass().getName());
    }

    public iq a(String str) {
        this.f703b = str;
        return this;
    }

    public void a() {
        if (this.f703b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f704c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f705d == null) {
            throw new jj("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a == 11) {
                        this.f701a = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 2:
                    if (m485a.f4998a == 12) {
                        this.f700a = new ib();
                        this.f700a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 3:
                    if (m485a.f4998a == 11) {
                        this.f703b = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 4:
                    if (m485a.f4998a == 11) {
                        this.f704c = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 5:
                    if (m485a.f4998a == 11) {
                        this.f705d = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 6:
                    if (m485a.f4998a == 11) {
                        this.f706e = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 7:
                    if (m485a.f4998a == 11) {
                        this.f707f = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 8:
                    if (m485a.f4998a == 15) {
                        jg m486a = jiVar.m486a();
                        this.f702a = new ArrayList(m486a.f777a);
                        for (int i = 0; i < m486a.f777a; i++) {
                            this.f702a.add(jiVar.m490a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m462a() {
        return this.f701a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m463a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean m462a = m462a();
        boolean m462a2 = iqVar.m462a();
        if ((m462a || m462a2) && !(m462a && m462a2 && this.f701a.equals(iqVar.f701a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iqVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f700a.m398a(iqVar.f700a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iqVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f703b.equals(iqVar.f703b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iqVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f704c.equals(iqVar.f704c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f705d.equals(iqVar.f705d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f706e.equals(iqVar.f706e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f707f.equals(iqVar.f707f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iqVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f702a.equals(iqVar.f702a));
    }

    public iq b(String str) {
        this.f704c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f699a);
        if (this.f701a != null && m462a()) {
            jiVar.a(f4984a);
            jiVar.a(this.f701a);
            jiVar.b();
        }
        if (this.f700a != null && b()) {
            jiVar.a(b);
            this.f700a.b(jiVar);
            jiVar.b();
        }
        if (this.f703b != null) {
            jiVar.a(c);
            jiVar.a(this.f703b);
            jiVar.b();
        }
        if (this.f704c != null) {
            jiVar.a(d);
            jiVar.a(this.f704c);
            jiVar.b();
        }
        if (this.f705d != null) {
            jiVar.a(e);
            jiVar.a(this.f705d);
            jiVar.b();
        }
        if (this.f706e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f706e);
            jiVar.b();
        }
        if (this.f707f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f707f);
            jiVar.b();
        }
        if (this.f702a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f702a.size()));
            for (String str : this.f702a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public boolean b() {
        return this.f700a != null;
    }

    public iq c(String str) {
        this.f705d = str;
        return this;
    }

    public boolean c() {
        return this.f703b != null;
    }

    public iq d(String str) {
        this.f706e = str;
        return this;
    }

    public boolean d() {
        return this.f704c != null;
    }

    public iq e(String str) {
        this.f707f = str;
        return this;
    }

    public boolean e() {
        return this.f705d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m463a((iq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f706e != null;
    }

    public boolean g() {
        return this.f707f != null;
    }

    public boolean h() {
        return this.f702a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (m462a()) {
            sb.append("debug:");
            if (this.f701a == null) {
                sb.append("null");
            } else {
                sb.append(this.f701a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f700a == null) {
                sb.append("null");
            } else {
                sb.append(this.f700a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f703b == null) {
            sb.append("null");
        } else {
            sb.append(this.f703b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f704c == null) {
            sb.append("null");
        } else {
            sb.append(this.f704c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f705d == null) {
            sb.append("null");
        } else {
            sb.append(this.f705d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f706e == null) {
                sb.append("null");
            } else {
                sb.append(this.f706e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f707f == null) {
                sb.append("null");
            } else {
                sb.append(this.f707f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f702a == null) {
                sb.append("null");
            } else {
                sb.append(this.f702a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
