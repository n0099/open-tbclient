package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ic implements ir<ic, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hg f614a;

    /* renamed from: a  reason: collision with other field name */
    public ht f615a;

    /* renamed from: a  reason: collision with other field name */
    public hv f616a;

    /* renamed from: a  reason: collision with other field name */
    public String f617a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f618a;

    /* renamed from: b  reason: collision with other field name */
    public String f621b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f613a = new jh("XmPushActionContainer");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 2, 2);
    private static final iz c = new iz("", (byte) 2, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", (byte) 12, 7);
    private static final iz h = new iz("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f619a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f620a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f622b = true;

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
            int compareTo = Boolean.valueOf(m400a()).compareTo(Boolean.valueOf(icVar.m400a()));
            if (compareTo == 0) {
                if (!m400a() || (a9 = is.a(this.f614a, icVar.f614a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(icVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a8 = is.a(this.f620a, icVar.f620a)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a7 = is.a(this.f622b, icVar.f622b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a6 = is.a(this.f618a, icVar.f618a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a5 = is.a(this.f617a, icVar.f617a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a4 = is.a(this.f621b, icVar.f621b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a3 = is.a(this.f616a, icVar.f616a)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a2 = is.a(this.f615a, icVar.f615a)) == 0) {
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
        return this.f614a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ht m396a() {
        return this.f615a;
    }

    public ic a(hg hgVar) {
        this.f614a = hgVar;
        return this;
    }

    public ic a(ht htVar) {
        this.f615a = htVar;
        return this;
    }

    public ic a(hv hvVar) {
        this.f616a = hvVar;
        return this;
    }

    public ic a(String str) {
        this.f617a = str;
        return this;
    }

    public ic a(ByteBuffer byteBuffer) {
        this.f618a = byteBuffer;
        return this;
    }

    public ic a(boolean z) {
        this.f620a = z;
        m399a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m397a() {
        return this.f617a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m398a() {
        if (this.f614a == null) {
            throw new jd("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f618a == null) {
            throw new jd("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f616a == null) {
            throw new jd("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                if (!c()) {
                    throw new jd("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new jd("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m398a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a != 8) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f614a = hg.a(jcVar.m461a());
                        break;
                    }
                case 2:
                    if (m463a.a != 2) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f620a = jcVar.m472a();
                        m399a(true);
                        break;
                    }
                case 3:
                    if (m463a.a != 2) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f622b = jcVar.m472a();
                        m403b(true);
                        break;
                    }
                case 4:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f618a = jcVar.m469a();
                        break;
                    }
                case 5:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f617a = jcVar.m468a();
                        break;
                    }
                case 6:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f621b = jcVar.m468a();
                        break;
                    }
                case 7:
                    if (m463a.a != 12) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f616a = new hv();
                        this.f616a.a(jcVar);
                        break;
                    }
                case 8:
                    if (m463a.a != 12) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f615a = new ht();
                        this.f615a.a(jcVar);
                        break;
                    }
                default:
                    jf.a(jcVar, m463a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m399a(boolean z) {
        this.f619a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m400a() {
        return this.f614a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m401a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m400a = m400a();
        boolean m400a2 = icVar.m400a();
        if (((!m400a && !m400a2) || (m400a && m400a2 && this.f614a.equals(icVar.f614a))) && this.f620a == icVar.f620a && this.f622b == icVar.f622b) {
            boolean e2 = e();
            boolean e3 = icVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f618a.equals(icVar.f618a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = icVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f617a.equals(icVar.f617a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = icVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f621b.equals(icVar.f621b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = icVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f616a.m373a(icVar.f616a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = icVar.i();
            return !(i || i2) || (i && i2 && this.f615a.m365a(icVar.f615a));
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m402a() {
        a(is.a(this.f618a));
        return this.f618a.array();
    }

    public ic b(String str) {
        this.f621b = str;
        return this;
    }

    public ic b(boolean z) {
        this.f622b = z;
        m403b(true);
        return this;
    }

    public String b() {
        return this.f621b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m398a();
        jcVar.a(f613a);
        if (this.f614a != null) {
            jcVar.a(a);
            jcVar.a(this.f614a.a());
            jcVar.b();
        }
        jcVar.a(b);
        jcVar.a(this.f620a);
        jcVar.b();
        jcVar.a(c);
        jcVar.a(this.f622b);
        jcVar.b();
        if (this.f618a != null) {
            jcVar.a(d);
            jcVar.a(this.f618a);
            jcVar.b();
        }
        if (this.f617a != null && f()) {
            jcVar.a(e);
            jcVar.a(this.f617a);
            jcVar.b();
        }
        if (this.f621b != null && g()) {
            jcVar.a(f);
            jcVar.a(this.f621b);
            jcVar.b();
        }
        if (this.f616a != null) {
            jcVar.a(g);
            this.f616a.b(jcVar);
            jcVar.b();
        }
        if (this.f615a != null && i()) {
            jcVar.a(h);
            this.f615a.b(jcVar);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m403b(boolean z) {
        this.f619a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m404b() {
        return this.f620a;
    }

    public boolean c() {
        return this.f619a.get(0);
    }

    public boolean d() {
        return this.f619a.get(1);
    }

    public boolean e() {
        return this.f618a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m401a((ic) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f617a != null;
    }

    public boolean g() {
        return this.f621b != null;
    }

    public boolean h() {
        return this.f616a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f615a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.f614a == null) {
            sb.append("null");
        } else {
            sb.append(this.f614a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f620a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f622b);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.f618a == null) {
            sb.append("null");
        } else {
            is.a(this.f618a, sb);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.f617a == null) {
                sb.append("null");
            } else {
                sb.append(this.f617a);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f621b == null) {
                sb.append("null");
            } else {
                sb.append(this.f621b);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.f616a == null) {
            sb.append("null");
        } else {
            sb.append(this.f616a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f615a == null) {
                sb.append("null");
            } else {
                sb.append(this.f615a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
