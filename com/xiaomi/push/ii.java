package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ii implements ir<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f691a;

    /* renamed from: a  reason: collision with other field name */
    public hv f692a;

    /* renamed from: a  reason: collision with other field name */
    public String f693a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f694a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f695b;

    /* renamed from: c  reason: collision with other field name */
    public String f696c;

    /* renamed from: d  reason: collision with other field name */
    public String f697d;

    /* renamed from: e  reason: collision with other field name */
    public String f698e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f690a = new jh("XmPushActionSendFeedbackResult");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", (byte) 10, 6);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 8);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ii iiVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(iiVar.getClass())) {
            int compareTo = Boolean.valueOf(m432a()).compareTo(Boolean.valueOf(iiVar.m432a()));
            if (compareTo == 0) {
                if (!m432a() || (a8 = is.a(this.f693a, iiVar.f693a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iiVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = is.a(this.f692a, iiVar.f692a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = is.a(this.f695b, iiVar.f695b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = is.a(this.f696c, iiVar.f696c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = is.a(this.f691a, iiVar.f691a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = is.a(this.f697d, iiVar.f697d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = is.a(this.f698e, iiVar.f698e)) == 0) {
                                                                    return 0;
                                                                }
                                                                return a2;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a3;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a4;
                                            }
                                            return compareTo5;
                                        }
                                        return a5;
                                    }
                                    return compareTo4;
                                }
                                return a6;
                            }
                            return compareTo3;
                        }
                        return a7;
                    }
                    return compareTo2;
                }
                return a8;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(iiVar.getClass().getName());
    }

    public void a() {
        if (this.f695b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f696c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m470a();
        while (true) {
            iz m466a = jcVar.m466a();
            if (m466a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m466a.f788a) {
                case 1:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f693a = jcVar.m471a();
                        break;
                    }
                case 2:
                    if (m466a.a != 12) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f692a = new hv();
                        this.f692a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f695b = jcVar.m471a();
                        break;
                    }
                case 4:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f696c = jcVar.m471a();
                        break;
                    }
                case 5:
                default:
                    jf.a(jcVar, m466a.a);
                    break;
                case 6:
                    if (m466a.a != 10) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f691a = jcVar.m465a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f697d = jcVar.m471a();
                        break;
                    }
                case 8:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f698e = jcVar.m471a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f694a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m432a() {
        return this.f693a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m433a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m432a = m432a();
        boolean m432a2 = iiVar.m432a();
        if ((m432a || m432a2) && !(m432a && m432a2 && this.f693a.equals(iiVar.f693a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iiVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f692a.m376a(iiVar.f692a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iiVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f695b.equals(iiVar.f695b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iiVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f696c.equals(iiVar.f696c))) || this.f691a != iiVar.f691a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iiVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f697d.equals(iiVar.f697d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iiVar.g();
        return !(g2 || g3) || (g2 && g3 && this.f698e.equals(iiVar.f698e));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f690a);
        if (this.f693a != null && m432a()) {
            jcVar.a(a);
            jcVar.a(this.f693a);
            jcVar.b();
        }
        if (this.f692a != null && b()) {
            jcVar.a(b);
            this.f692a.b(jcVar);
            jcVar.b();
        }
        if (this.f695b != null) {
            jcVar.a(c);
            jcVar.a(this.f695b);
            jcVar.b();
        }
        if (this.f696c != null) {
            jcVar.a(d);
            jcVar.a(this.f696c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f691a);
        jcVar.b();
        if (this.f697d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f697d);
            jcVar.b();
        }
        if (this.f698e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f698e);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m474a();
    }

    public boolean b() {
        return this.f692a != null;
    }

    public boolean c() {
        return this.f695b != null;
    }

    public boolean d() {
        return this.f696c != null;
    }

    public boolean e() {
        return this.f694a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m433a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f697d != null;
    }

    public boolean g() {
        return this.f698e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = true;
        if (m432a()) {
            sb.append("debug:");
            if (this.f693a == null) {
                sb.append("null");
            } else {
                sb.append(this.f693a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f692a == null) {
                sb.append("null");
            } else {
                sb.append(this.f692a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f695b == null) {
            sb.append("null");
        } else {
            sb.append(this.f695b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f696c == null) {
            sb.append("null");
        } else {
            sb.append(this.f696c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f691a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f697d == null) {
                sb.append("null");
            } else {
                sb.append(this.f697d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f698e == null) {
                sb.append("null");
            } else {
                sb.append(this.f698e);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
