package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class ic implements ir<ic, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hg f615a;

    /* renamed from: a  reason: collision with other field name */
    public ht f616a;

    /* renamed from: a  reason: collision with other field name */
    public hv f617a;

    /* renamed from: a  reason: collision with other field name */
    public String f618a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f619a;

    /* renamed from: b  reason: collision with other field name */
    public String f622b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f614a = new jh("XmPushActionContainer");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 2, 2);
    private static final iz c = new iz("", (byte) 2, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", (byte) 12, 7);
    private static final iz h = new iz("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f620a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f621a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f623b = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ic icVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(icVar.getClass())) {
            int compareTo = Boolean.valueOf(m391a()).compareTo(Boolean.valueOf(icVar.m391a()));
            if (compareTo == 0) {
                if (!m391a() || (a9 = is.a(this.f615a, icVar.f615a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(icVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a8 = is.a(this.f621a, icVar.f621a)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a7 = is.a(this.f623b, icVar.f623b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a6 = is.a(this.f619a, icVar.f619a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a5 = is.a(this.f618a, icVar.f618a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a4 = is.a(this.f622b, icVar.f622b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a3 = is.a(this.f617a, icVar.f617a)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a2 = is.a(this.f616a, icVar.f616a)) == 0) {
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
        return getClass().getName().compareTo(icVar.getClass().getName());
    }

    public hg a() {
        return this.f615a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ht m387a() {
        return this.f616a;
    }

    public ic a(hg hgVar) {
        this.f615a = hgVar;
        return this;
    }

    public ic a(ht htVar) {
        this.f616a = htVar;
        return this;
    }

    public ic a(hv hvVar) {
        this.f617a = hvVar;
        return this;
    }

    public ic a(String str) {
        this.f618a = str;
        return this;
    }

    public ic a(ByteBuffer byteBuffer) {
        this.f619a = byteBuffer;
        return this;
    }

    public ic a(boolean z) {
        this.f621a = z;
        m390a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m388a() {
        return this.f618a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m389a() {
        if (this.f615a == null) {
            throw new jd("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f619a == null) {
            throw new jd("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f617a == null) {
            throw new jd("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                if (!c()) {
                    throw new jd("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new jd("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m389a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a != 8) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f615a = hg.a(jcVar.m452a());
                        break;
                    }
                case 2:
                    if (m454a.a != 2) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f621a = jcVar.m463a();
                        m390a(true);
                        break;
                    }
                case 3:
                    if (m454a.a != 2) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f623b = jcVar.m463a();
                        m394b(true);
                        break;
                    }
                case 4:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f619a = jcVar.m460a();
                        break;
                    }
                case 5:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f618a = jcVar.m459a();
                        break;
                    }
                case 6:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f622b = jcVar.m459a();
                        break;
                    }
                case 7:
                    if (m454a.a != 12) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f617a = new hv();
                        this.f617a.a(jcVar);
                        break;
                    }
                case 8:
                    if (m454a.a != 12) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f616a = new ht();
                        this.f616a.a(jcVar);
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
    public void m390a(boolean z) {
        this.f620a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m391a() {
        return this.f615a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m392a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m391a = m391a();
        boolean m391a2 = icVar.m391a();
        if (((!m391a && !m391a2) || (m391a && m391a2 && this.f615a.equals(icVar.f615a))) && this.f621a == icVar.f621a && this.f623b == icVar.f623b) {
            boolean e2 = e();
            boolean e3 = icVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f619a.equals(icVar.f619a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = icVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f618a.equals(icVar.f618a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = icVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f622b.equals(icVar.f622b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = icVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f617a.m364a(icVar.f617a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = icVar.i();
            return !(i || i2) || (i && i2 && this.f616a.m356a(icVar.f616a));
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m393a() {
        a(is.a(this.f619a));
        return this.f619a.array();
    }

    public ic b(String str) {
        this.f622b = str;
        return this;
    }

    public ic b(boolean z) {
        this.f623b = z;
        m394b(true);
        return this;
    }

    public String b() {
        return this.f622b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m389a();
        jcVar.a(f614a);
        if (this.f615a != null) {
            jcVar.a(a);
            jcVar.a(this.f615a.a());
            jcVar.b();
        }
        jcVar.a(b);
        jcVar.a(this.f621a);
        jcVar.b();
        jcVar.a(c);
        jcVar.a(this.f623b);
        jcVar.b();
        if (this.f619a != null) {
            jcVar.a(d);
            jcVar.a(this.f619a);
            jcVar.b();
        }
        if (this.f618a != null && f()) {
            jcVar.a(e);
            jcVar.a(this.f618a);
            jcVar.b();
        }
        if (this.f622b != null && g()) {
            jcVar.a(f);
            jcVar.a(this.f622b);
            jcVar.b();
        }
        if (this.f617a != null) {
            jcVar.a(g);
            this.f617a.b(jcVar);
            jcVar.b();
        }
        if (this.f616a != null && i()) {
            jcVar.a(h);
            this.f616a.b(jcVar);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m394b(boolean z) {
        this.f620a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m395b() {
        return this.f621a;
    }

    public boolean c() {
        return this.f620a.get(0);
    }

    public boolean d() {
        return this.f620a.get(1);
    }

    public boolean e() {
        return this.f619a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m392a((ic) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f618a != null;
    }

    public boolean g() {
        return this.f622b != null;
    }

    public boolean h() {
        return this.f617a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f616a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.f615a == null) {
            sb.append("null");
        } else {
            sb.append(this.f615a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f621a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f623b);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.f619a == null) {
            sb.append("null");
        } else {
            is.a(this.f619a, sb);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.f618a == null) {
                sb.append("null");
            } else {
                sb.append(this.f618a);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f622b == null) {
                sb.append("null");
            } else {
                sb.append(this.f622b);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.f617a == null) {
            sb.append("null");
        } else {
            sb.append(this.f617a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f616a == null) {
                sb.append("null");
            } else {
                sb.append(this.f616a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
