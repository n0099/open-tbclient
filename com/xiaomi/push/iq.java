package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class iq implements ix<iq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f701a;

    /* renamed from: a  reason: collision with other field name */
    public String f702a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f703a;

    /* renamed from: b  reason: collision with other field name */
    public String f704b;

    /* renamed from: c  reason: collision with other field name */
    public String f705c;

    /* renamed from: d  reason: collision with other field name */
    public String f706d;

    /* renamed from: e  reason: collision with other field name */
    public String f707e;

    /* renamed from: f  reason: collision with other field name */
    public String f708f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f700a = new jn("XmPushActionSubscription");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m460a()).compareTo(Boolean.valueOf(iqVar.m460a()));
            if (compareTo == 0) {
                if (!m460a() || (a9 = iy.a(this.f702a, iqVar.f702a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iqVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f701a, iqVar.f701a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iqVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f704b, iqVar.f704b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f705c, iqVar.f705c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f706d, iqVar.f706d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f707e, iqVar.f707e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f708f, iqVar.f708f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f703a, iqVar.f703a)) == 0) {
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
        this.f704b = str;
        return this;
    }

    public void a() {
        if (this.f704b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f705c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f706d == null) {
            throw new jj("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m487a();
        while (true) {
            jf m483a = jiVar.m483a();
            if (m483a.a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m483a.f777a) {
                case 1:
                    if (m483a.a == 11) {
                        this.f702a = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 2:
                    if (m483a.a == 12) {
                        this.f701a = new ib();
                        this.f701a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 3:
                    if (m483a.a == 11) {
                        this.f704b = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 4:
                    if (m483a.a == 11) {
                        this.f705c = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 5:
                    if (m483a.a == 11) {
                        this.f706d = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 6:
                    if (m483a.a == 11) {
                        this.f707e = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 7:
                    if (m483a.a == 11) {
                        this.f708f = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 8:
                    if (m483a.a == 15) {
                        jg m484a = jiVar.m484a();
                        this.f703a = new ArrayList(m484a.f778a);
                        for (int i = 0; i < m484a.f778a; i++) {
                            this.f703a.add(jiVar.m488a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m483a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m460a() {
        return this.f702a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m461a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean m460a = m460a();
        boolean m460a2 = iqVar.m460a();
        if ((m460a || m460a2) && !(m460a && m460a2 && this.f702a.equals(iqVar.f702a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iqVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f701a.m396a(iqVar.f701a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iqVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f704b.equals(iqVar.f704b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iqVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f705c.equals(iqVar.f705c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f706d.equals(iqVar.f706d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f707e.equals(iqVar.f707e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f708f.equals(iqVar.f708f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iqVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f703a.equals(iqVar.f703a));
    }

    public iq b(String str) {
        this.f705c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f700a);
        if (this.f702a != null && m460a()) {
            jiVar.a(a);
            jiVar.a(this.f702a);
            jiVar.b();
        }
        if (this.f701a != null && b()) {
            jiVar.a(b);
            this.f701a.b(jiVar);
            jiVar.b();
        }
        if (this.f704b != null) {
            jiVar.a(c);
            jiVar.a(this.f704b);
            jiVar.b();
        }
        if (this.f705c != null) {
            jiVar.a(d);
            jiVar.a(this.f705c);
            jiVar.b();
        }
        if (this.f706d != null) {
            jiVar.a(e);
            jiVar.a(this.f706d);
            jiVar.b();
        }
        if (this.f707e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f707e);
            jiVar.b();
        }
        if (this.f708f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f708f);
            jiVar.b();
        }
        if (this.f703a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f703a.size()));
            for (String str : this.f703a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m491a();
    }

    public boolean b() {
        return this.f701a != null;
    }

    public iq c(String str) {
        this.f706d = str;
        return this;
    }

    public boolean c() {
        return this.f704b != null;
    }

    public iq d(String str) {
        this.f707e = str;
        return this;
    }

    public boolean d() {
        return this.f705c != null;
    }

    public iq e(String str) {
        this.f708f = str;
        return this;
    }

    public boolean e() {
        return this.f706d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m461a((iq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f707e != null;
    }

    public boolean g() {
        return this.f708f != null;
    }

    public boolean h() {
        return this.f703a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (m460a()) {
            sb.append("debug:");
            if (this.f702a == null) {
                sb.append("null");
            } else {
                sb.append(this.f702a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f701a == null) {
                sb.append("null");
            } else {
                sb.append(this.f701a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f704b == null) {
            sb.append("null");
        } else {
            sb.append(this.f704b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f705c == null) {
            sb.append("null");
        } else {
            sb.append(this.f705c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f706d == null) {
            sb.append("null");
        } else {
            sb.append(this.f706d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f707e == null) {
                sb.append("null");
            } else {
                sb.append(this.f707e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f708f == null) {
                sb.append("null");
            } else {
                sb.append(this.f708f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f703a == null) {
                sb.append("null");
            } else {
                sb.append(this.f703a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
