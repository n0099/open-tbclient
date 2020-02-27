package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ic implements ir<ic, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hg f611a;

    /* renamed from: a  reason: collision with other field name */
    public ht f612a;

    /* renamed from: a  reason: collision with other field name */
    public hv f613a;

    /* renamed from: a  reason: collision with other field name */
    public String f614a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f615a;

    /* renamed from: b  reason: collision with other field name */
    public String f618b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f610a = new jh("XmPushActionContainer");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 2, 2);
    private static final iz c = new iz("", (byte) 2, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", (byte) 12, 7);
    private static final iz h = new iz("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f616a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f617a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f619b = true;

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
            int compareTo = Boolean.valueOf(m405a()).compareTo(Boolean.valueOf(icVar.m405a()));
            if (compareTo == 0) {
                if (!m405a() || (a9 = is.a(this.f611a, icVar.f611a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(icVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a8 = is.a(this.f617a, icVar.f617a)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a7 = is.a(this.f619b, icVar.f619b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a6 = is.a(this.f615a, icVar.f615a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a5 = is.a(this.f614a, icVar.f614a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a4 = is.a(this.f618b, icVar.f618b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a3 = is.a(this.f613a, icVar.f613a)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a2 = is.a(this.f612a, icVar.f612a)) == 0) {
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
        return this.f611a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ht m401a() {
        return this.f612a;
    }

    public ic a(hg hgVar) {
        this.f611a = hgVar;
        return this;
    }

    public ic a(ht htVar) {
        this.f612a = htVar;
        return this;
    }

    public ic a(hv hvVar) {
        this.f613a = hvVar;
        return this;
    }

    public ic a(String str) {
        this.f614a = str;
        return this;
    }

    public ic a(ByteBuffer byteBuffer) {
        this.f615a = byteBuffer;
        return this;
    }

    public ic a(boolean z) {
        this.f617a = z;
        m404a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m402a() {
        return this.f614a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m403a() {
        if (this.f611a == null) {
            throw new jd("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f615a == null) {
            throw new jd("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f613a == null) {
            throw new jd("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                if (!c()) {
                    throw new jd("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new jd("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m403a();
                return;
            }
            switch (m468a.f789a) {
                case 1:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f611a = hg.a(jcVar.m466a());
                        break;
                    }
                case 2:
                    if (m468a.a != 2) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f617a = jcVar.m477a();
                        m404a(true);
                        break;
                    }
                case 3:
                    if (m468a.a != 2) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f619b = jcVar.m477a();
                        m408b(true);
                        break;
                    }
                case 4:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f615a = jcVar.m474a();
                        break;
                    }
                case 5:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f614a = jcVar.m473a();
                        break;
                    }
                case 6:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f618b = jcVar.m473a();
                        break;
                    }
                case 7:
                    if (m468a.a != 12) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f613a = new hv();
                        this.f613a.a(jcVar);
                        break;
                    }
                case 8:
                    if (m468a.a != 12) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f612a = new ht();
                        this.f612a.a(jcVar);
                        break;
                    }
                default:
                    jf.a(jcVar, m468a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m404a(boolean z) {
        this.f616a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m405a() {
        return this.f611a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m406a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m405a = m405a();
        boolean m405a2 = icVar.m405a();
        if (((!m405a && !m405a2) || (m405a && m405a2 && this.f611a.equals(icVar.f611a))) && this.f617a == icVar.f617a && this.f619b == icVar.f619b) {
            boolean e2 = e();
            boolean e3 = icVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f615a.equals(icVar.f615a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = icVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f614a.equals(icVar.f614a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = icVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f618b.equals(icVar.f618b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = icVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f613a.m378a(icVar.f613a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = icVar.i();
            return !(i || i2) || (i && i2 && this.f612a.m370a(icVar.f612a));
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m407a() {
        a(is.a(this.f615a));
        return this.f615a.array();
    }

    public ic b(String str) {
        this.f618b = str;
        return this;
    }

    public ic b(boolean z) {
        this.f619b = z;
        m408b(true);
        return this;
    }

    public String b() {
        return this.f618b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m403a();
        jcVar.a(f610a);
        if (this.f611a != null) {
            jcVar.a(a);
            jcVar.a(this.f611a.a());
            jcVar.b();
        }
        jcVar.a(b);
        jcVar.a(this.f617a);
        jcVar.b();
        jcVar.a(c);
        jcVar.a(this.f619b);
        jcVar.b();
        if (this.f615a != null) {
            jcVar.a(d);
            jcVar.a(this.f615a);
            jcVar.b();
        }
        if (this.f614a != null && f()) {
            jcVar.a(e);
            jcVar.a(this.f614a);
            jcVar.b();
        }
        if (this.f618b != null && g()) {
            jcVar.a(f);
            jcVar.a(this.f618b);
            jcVar.b();
        }
        if (this.f613a != null) {
            jcVar.a(g);
            this.f613a.b(jcVar);
            jcVar.b();
        }
        if (this.f612a != null && i()) {
            jcVar.a(h);
            this.f612a.b(jcVar);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m408b(boolean z) {
        this.f616a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m409b() {
        return this.f617a;
    }

    public boolean c() {
        return this.f616a.get(0);
    }

    public boolean d() {
        return this.f616a.get(1);
    }

    public boolean e() {
        return this.f615a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m406a((ic) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f614a != null;
    }

    public boolean g() {
        return this.f618b != null;
    }

    public boolean h() {
        return this.f613a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f612a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.f611a == null) {
            sb.append("null");
        } else {
            sb.append(this.f611a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f617a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f619b);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.f615a == null) {
            sb.append("null");
        } else {
            is.a(this.f615a, sb);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.f614a == null) {
                sb.append("null");
            } else {
                sb.append(this.f614a);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f618b == null) {
                sb.append("null");
            } else {
                sb.append(this.f618b);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.f613a == null) {
            sb.append("null");
        } else {
            sb.append(this.f613a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f612a == null) {
                sb.append("null");
            } else {
                sb.append(this.f612a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
