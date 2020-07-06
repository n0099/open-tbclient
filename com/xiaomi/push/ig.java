package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes8.dex */
public class ig implements ix<ig, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f580a;

    /* renamed from: a  reason: collision with other field name */
    public ib f581a;

    /* renamed from: a  reason: collision with other field name */
    public String f582a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f584a;

    /* renamed from: b  reason: collision with other field name */
    public String f586b;

    /* renamed from: c  reason: collision with other field name */
    public String f588c;

    /* renamed from: d  reason: collision with other field name */
    public String f589d;

    /* renamed from: e  reason: collision with other field name */
    public String f590e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f579a = new jn("XmPushActionCommand");
    private static final jf a = new jf("", (byte) 12, 2);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf e = new jf("", (byte) 15, 6);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf h = new jf("", (byte) 2, 10);
    private static final jf i = new jf("", (byte) 2, 11);
    private static final jf j = new jf("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f583a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f585a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f587b = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ig igVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        if (getClass().equals(igVar.getClass())) {
            int compareTo = Boolean.valueOf(m405a()).compareTo(Boolean.valueOf(igVar.m405a()));
            if (compareTo == 0) {
                if (!m405a() || (a11 = iy.a(this.f581a, igVar.f581a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(igVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f582a, igVar.f582a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(igVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f586b, igVar.f586b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f588c, igVar.f588c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f584a, igVar.f584a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f589d, igVar.f589d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f590e, igVar.f590e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f585a, igVar.f585a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f587b, igVar.f587b)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f580a, igVar.f580a)) == 0) {
                                                                                            return 0;
                                                                                        }
                                                                                        return a2;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a3;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a4;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a5;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a6;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a7;
                                            }
                                            return compareTo5;
                                        }
                                        return a8;
                                    }
                                    return compareTo4;
                                }
                                return a9;
                            }
                            return compareTo3;
                        }
                        return a10;
                    }
                    return compareTo2;
                }
                return a11;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(igVar.getClass().getName());
    }

    public ig a(String str) {
        this.f582a = str;
        return this;
    }

    public ig a(List<String> list) {
        this.f584a = list;
        return this;
    }

    public String a() {
        return this.f588c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m403a() {
        if (this.f582a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f586b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f588c == null) {
            throw new jj("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                m403a();
                return;
            }
            switch (m479a.f784a) {
                case 2:
                    if (m479a.a == 12) {
                        this.f581a = new ib();
                        this.f581a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 3:
                    if (m479a.a == 11) {
                        this.f582a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 4:
                    if (m479a.a == 11) {
                        this.f586b = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 5:
                    if (m479a.a == 11) {
                        this.f588c = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 6:
                    if (m479a.a == 15) {
                        jg m480a = jiVar.m480a();
                        this.f584a = new ArrayList(m480a.f785a);
                        for (int i2 = 0; i2 < m480a.f785a; i2++) {
                            this.f584a.add(jiVar.m484a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 7:
                    if (m479a.a == 11) {
                        this.f589d = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 8:
                default:
                    jl.a(jiVar, m479a.a);
                    break;
                case 9:
                    if (m479a.a == 11) {
                        this.f590e = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 10:
                    if (m479a.a == 2) {
                        this.f585a = jiVar.m488a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 11:
                    if (m479a.a == 2) {
                        this.f587b = jiVar.m488a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 12:
                    if (m479a.a == 10) {
                        this.f580a = jiVar.m478a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m404a(String str) {
        if (this.f584a == null) {
            this.f584a = new ArrayList();
        }
        this.f584a.add(str);
    }

    public void a(boolean z) {
        this.f583a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m405a() {
        return this.f581a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m406a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m405a = m405a();
        boolean m405a2 = igVar.m405a();
        if ((m405a || m405a2) && !(m405a && m405a2 && this.f581a.m392a(igVar.f581a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = igVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f582a.equals(igVar.f582a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = igVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f586b.equals(igVar.f586b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f588c.equals(igVar.f588c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f584a.equals(igVar.f584a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = igVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f589d.equals(igVar.f589d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f590e.equals(igVar.f590e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f585a == igVar.f585a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f587b == igVar.f587b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f580a == igVar.f580a);
    }

    public ig b(String str) {
        this.f586b = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m403a();
        jiVar.a(f579a);
        if (this.f581a != null && m405a()) {
            jiVar.a(a);
            this.f581a.b(jiVar);
            jiVar.b();
        }
        if (this.f582a != null) {
            jiVar.a(b);
            jiVar.a(this.f582a);
            jiVar.b();
        }
        if (this.f586b != null) {
            jiVar.a(c);
            jiVar.a(this.f586b);
            jiVar.b();
        }
        if (this.f588c != null) {
            jiVar.a(d);
            jiVar.a(this.f588c);
            jiVar.b();
        }
        if (this.f584a != null && e()) {
            jiVar.a(e);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f584a.size()));
            for (String str : this.f584a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f589d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f589d);
            jiVar.b();
        }
        if (this.f590e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f590e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f585a);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f587b);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f580a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public void b(boolean z) {
        this.f583a.set(1, z);
    }

    public boolean b() {
        return this.f582a != null;
    }

    public ig c(String str) {
        this.f588c = str;
        return this;
    }

    public void c(boolean z) {
        this.f583a.set(2, z);
    }

    public boolean c() {
        return this.f586b != null;
    }

    public ig d(String str) {
        this.f589d = str;
        return this;
    }

    public boolean d() {
        return this.f588c != null;
    }

    public ig e(String str) {
        this.f590e = str;
        return this;
    }

    public boolean e() {
        return this.f584a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m406a((ig) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f589d != null;
    }

    public boolean g() {
        return this.f590e != null;
    }

    public boolean h() {
        return this.f583a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f583a.get(1);
    }

    public boolean j() {
        return this.f583a.get(2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        boolean z = true;
        if (m405a()) {
            sb.append("target:");
            if (this.f581a == null) {
                sb.append("null");
            } else {
                sb.append(this.f581a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f582a == null) {
            sb.append("null");
        } else {
            sb.append(this.f582a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f586b == null) {
            sb.append("null");
        } else {
            sb.append(this.f586b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f588c == null) {
            sb.append("null");
        } else {
            sb.append(this.f588c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f584a == null) {
                sb.append("null");
            } else {
                sb.append(this.f584a);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f589d == null) {
                sb.append("null");
            } else {
                sb.append(this.f589d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f590e == null) {
                sb.append("null");
            } else {
                sb.append(this.f590e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f585a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f587b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f580a);
        }
        sb.append(")");
        return sb.toString();
    }
}
