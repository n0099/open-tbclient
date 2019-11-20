package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
/* loaded from: classes3.dex */
public class ic implements ir<ic, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hg f610a;

    /* renamed from: a  reason: collision with other field name */
    public ht f611a;

    /* renamed from: a  reason: collision with other field name */
    public hv f612a;

    /* renamed from: a  reason: collision with other field name */
    public String f613a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f614a;

    /* renamed from: b  reason: collision with other field name */
    public String f617b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f609a = new jh("XmPushActionContainer");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 2, 2);
    private static final iz c = new iz("", (byte) 2, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", (byte) 12, 7);
    private static final iz h = new iz("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f615a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f616a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f618b = true;

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
            int compareTo = Boolean.valueOf(m388a()).compareTo(Boolean.valueOf(icVar.m388a()));
            if (compareTo == 0) {
                if (!m388a() || (a9 = is.a(this.f610a, icVar.f610a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(icVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a8 = is.a(this.f616a, icVar.f616a)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a7 = is.a(this.f618b, icVar.f618b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a6 = is.a(this.f614a, icVar.f614a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a5 = is.a(this.f613a, icVar.f613a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a4 = is.a(this.f617b, icVar.f617b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a3 = is.a(this.f612a, icVar.f612a)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a2 = is.a(this.f611a, icVar.f611a)) == 0) {
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
        return this.f610a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ht m384a() {
        return this.f611a;
    }

    public ic a(hg hgVar) {
        this.f610a = hgVar;
        return this;
    }

    public ic a(ht htVar) {
        this.f611a = htVar;
        return this;
    }

    public ic a(hv hvVar) {
        this.f612a = hvVar;
        return this;
    }

    public ic a(String str) {
        this.f613a = str;
        return this;
    }

    public ic a(ByteBuffer byteBuffer) {
        this.f614a = byteBuffer;
        return this;
    }

    public ic a(boolean z) {
        this.f616a = z;
        m387a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m385a() {
        return this.f613a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m386a() {
        if (this.f610a == null) {
            throw new jd("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f614a == null) {
            throw new jd("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f612a == null) {
            throw new jd("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m455a();
        while (true) {
            iz m451a = jcVar.m451a();
            if (m451a.a == 0) {
                jcVar.f();
                if (!c()) {
                    throw new jd("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new jd("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m386a();
                return;
            }
            switch (m451a.f788a) {
                case 1:
                    if (m451a.a != 8) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f610a = hg.a(jcVar.m449a());
                        break;
                    }
                case 2:
                    if (m451a.a != 2) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f616a = jcVar.m460a();
                        m387a(true);
                        break;
                    }
                case 3:
                    if (m451a.a != 2) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f618b = jcVar.m460a();
                        m391b(true);
                        break;
                    }
                case 4:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f614a = jcVar.m457a();
                        break;
                    }
                case 5:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f613a = jcVar.m456a();
                        break;
                    }
                case 6:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f617b = jcVar.m456a();
                        break;
                    }
                case 7:
                    if (m451a.a != 12) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f612a = new hv();
                        this.f612a.a(jcVar);
                        break;
                    }
                case 8:
                    if (m451a.a != 12) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f611a = new ht();
                        this.f611a.a(jcVar);
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
    public void m387a(boolean z) {
        this.f615a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m388a() {
        return this.f610a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m389a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m388a = m388a();
        boolean m388a2 = icVar.m388a();
        if (((!m388a && !m388a2) || (m388a && m388a2 && this.f610a.equals(icVar.f610a))) && this.f616a == icVar.f616a && this.f618b == icVar.f618b) {
            boolean e2 = e();
            boolean e3 = icVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f614a.equals(icVar.f614a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = icVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f613a.equals(icVar.f613a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = icVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f617b.equals(icVar.f617b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = icVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f612a.m361a(icVar.f612a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = icVar.i();
            return !(i || i2) || (i && i2 && this.f611a.m353a(icVar.f611a));
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m390a() {
        a(is.a(this.f614a));
        return this.f614a.array();
    }

    public ic b(String str) {
        this.f617b = str;
        return this;
    }

    public ic b(boolean z) {
        this.f618b = z;
        m391b(true);
        return this;
    }

    public String b() {
        return this.f617b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m386a();
        jcVar.a(f609a);
        if (this.f610a != null) {
            jcVar.a(a);
            jcVar.a(this.f610a.a());
            jcVar.b();
        }
        jcVar.a(b);
        jcVar.a(this.f616a);
        jcVar.b();
        jcVar.a(c);
        jcVar.a(this.f618b);
        jcVar.b();
        if (this.f614a != null) {
            jcVar.a(d);
            jcVar.a(this.f614a);
            jcVar.b();
        }
        if (this.f613a != null && f()) {
            jcVar.a(e);
            jcVar.a(this.f613a);
            jcVar.b();
        }
        if (this.f617b != null && g()) {
            jcVar.a(f);
            jcVar.a(this.f617b);
            jcVar.b();
        }
        if (this.f612a != null) {
            jcVar.a(g);
            this.f612a.b(jcVar);
            jcVar.b();
        }
        if (this.f611a != null && i()) {
            jcVar.a(h);
            this.f611a.b(jcVar);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m459a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m391b(boolean z) {
        this.f615a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m392b() {
        return this.f616a;
    }

    public boolean c() {
        return this.f615a.get(0);
    }

    public boolean d() {
        return this.f615a.get(1);
    }

    public boolean e() {
        return this.f614a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m389a((ic) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f613a != null;
    }

    public boolean g() {
        return this.f617b != null;
    }

    public boolean h() {
        return this.f612a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f611a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.f610a == null) {
            sb.append("null");
        } else {
            sb.append(this.f610a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f616a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f618b);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.f614a == null) {
            sb.append("null");
        } else {
            is.a(this.f614a, sb);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.f613a == null) {
                sb.append("null");
            } else {
                sb.append(this.f613a);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f617b == null) {
                sb.append("null");
            } else {
                sb.append(this.f617b);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.f612a == null) {
            sb.append("null");
        } else {
            sb.append(this.f612a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f611a == null) {
                sb.append("null");
            } else {
                sb.append(this.f611a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
