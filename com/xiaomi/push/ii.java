package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ii implements ir<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f692a;

    /* renamed from: a  reason: collision with other field name */
    public hv f693a;

    /* renamed from: a  reason: collision with other field name */
    public String f694a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f695a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f696b;

    /* renamed from: c  reason: collision with other field name */
    public String f697c;

    /* renamed from: d  reason: collision with other field name */
    public String f698d;

    /* renamed from: e  reason: collision with other field name */
    public String f699e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f691a = new jh("XmPushActionSendFeedbackResult");
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
            int compareTo = Boolean.valueOf(m437a()).compareTo(Boolean.valueOf(iiVar.m437a()));
            if (compareTo == 0) {
                if (!m437a() || (a8 = is.a(this.f694a, iiVar.f694a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iiVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = is.a(this.f693a, iiVar.f693a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = is.a(this.f696b, iiVar.f696b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = is.a(this.f697c, iiVar.f697c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = is.a(this.f692a, iiVar.f692a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = is.a(this.f698d, iiVar.f698d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = is.a(this.f699e, iiVar.f699e)) == 0) {
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
        if (this.f696b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f697c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f694a = jcVar.m476a();
                        break;
                    }
                case 2:
                    if (m471a.a != 12) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f693a = new hv();
                        this.f693a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f696b = jcVar.m476a();
                        break;
                    }
                case 4:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f697c = jcVar.m476a();
                        break;
                    }
                case 5:
                default:
                    jf.a(jcVar, m471a.a);
                    break;
                case 6:
                    if (m471a.a != 10) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f692a = jcVar.m470a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f698d = jcVar.m476a();
                        break;
                    }
                case 8:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f699e = jcVar.m476a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f695a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m437a() {
        return this.f694a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m438a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m437a = m437a();
        boolean m437a2 = iiVar.m437a();
        if ((m437a || m437a2) && !(m437a && m437a2 && this.f694a.equals(iiVar.f694a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iiVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f693a.m381a(iiVar.f693a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iiVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f696b.equals(iiVar.f696b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iiVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f697c.equals(iiVar.f697c))) || this.f692a != iiVar.f692a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iiVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f698d.equals(iiVar.f698d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iiVar.g();
        return !(g2 || g3) || (g2 && g3 && this.f699e.equals(iiVar.f699e));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f691a);
        if (this.f694a != null && m437a()) {
            jcVar.a(a);
            jcVar.a(this.f694a);
            jcVar.b();
        }
        if (this.f693a != null && b()) {
            jcVar.a(b);
            this.f693a.b(jcVar);
            jcVar.b();
        }
        if (this.f696b != null) {
            jcVar.a(c);
            jcVar.a(this.f696b);
            jcVar.b();
        }
        if (this.f697c != null) {
            jcVar.a(d);
            jcVar.a(this.f697c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f692a);
        jcVar.b();
        if (this.f698d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f698d);
            jcVar.b();
        }
        if (this.f699e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f699e);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    public boolean b() {
        return this.f693a != null;
    }

    public boolean c() {
        return this.f696b != null;
    }

    public boolean d() {
        return this.f697c != null;
    }

    public boolean e() {
        return this.f695a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m438a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f698d != null;
    }

    public boolean g() {
        return this.f699e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = true;
        if (m437a()) {
            sb.append("debug:");
            if (this.f694a == null) {
                sb.append("null");
            } else {
                sb.append(this.f694a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f693a == null) {
                sb.append("null");
            } else {
                sb.append(this.f693a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f696b == null) {
            sb.append("null");
        } else {
            sb.append(this.f696b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f697c == null) {
            sb.append("null");
        } else {
            sb.append(this.f697c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f692a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f698d == null) {
                sb.append("null");
            } else {
                sb.append(this.f698d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f699e == null) {
                sb.append("null");
            } else {
                sb.append(this.f699e);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
