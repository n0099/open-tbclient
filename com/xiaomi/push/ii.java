package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ii implements ir<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f695a;

    /* renamed from: a  reason: collision with other field name */
    public hv f696a;

    /* renamed from: a  reason: collision with other field name */
    public String f697a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f698a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f699b;

    /* renamed from: c  reason: collision with other field name */
    public String f700c;

    /* renamed from: d  reason: collision with other field name */
    public String f701d;

    /* renamed from: e  reason: collision with other field name */
    public String f702e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f694a = new jh("XmPushActionSendFeedbackResult");
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
            int compareTo = Boolean.valueOf(m429a()).compareTo(Boolean.valueOf(iiVar.m429a()));
            if (compareTo == 0) {
                if (!m429a() || (a8 = is.a(this.f697a, iiVar.f697a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iiVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = is.a(this.f696a, iiVar.f696a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = is.a(this.f699b, iiVar.f699b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = is.a(this.f700c, iiVar.f700c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = is.a(this.f695a, iiVar.f695a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = is.a(this.f701d, iiVar.f701d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = is.a(this.f702e, iiVar.f702e)) == 0) {
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
        if (this.f699b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f700c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f697a = jcVar.m468a();
                        break;
                    }
                case 2:
                    if (m463a.a != 12) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f696a = new hv();
                        this.f696a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f699b = jcVar.m468a();
                        break;
                    }
                case 4:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f700c = jcVar.m468a();
                        break;
                    }
                case 5:
                default:
                    jf.a(jcVar, m463a.a);
                    break;
                case 6:
                    if (m463a.a != 10) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f695a = jcVar.m462a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f701d = jcVar.m468a();
                        break;
                    }
                case 8:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f702e = jcVar.m468a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f698a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m429a() {
        return this.f697a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m430a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m429a = m429a();
        boolean m429a2 = iiVar.m429a();
        if ((m429a || m429a2) && !(m429a && m429a2 && this.f697a.equals(iiVar.f697a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iiVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f696a.m373a(iiVar.f696a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iiVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f699b.equals(iiVar.f699b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iiVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f700c.equals(iiVar.f700c))) || this.f695a != iiVar.f695a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iiVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f701d.equals(iiVar.f701d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iiVar.g();
        return !(g2 || g3) || (g2 && g3 && this.f702e.equals(iiVar.f702e));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f694a);
        if (this.f697a != null && m429a()) {
            jcVar.a(a);
            jcVar.a(this.f697a);
            jcVar.b();
        }
        if (this.f696a != null && b()) {
            jcVar.a(b);
            this.f696a.b(jcVar);
            jcVar.b();
        }
        if (this.f699b != null) {
            jcVar.a(c);
            jcVar.a(this.f699b);
            jcVar.b();
        }
        if (this.f700c != null) {
            jcVar.a(d);
            jcVar.a(this.f700c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f695a);
        jcVar.b();
        if (this.f701d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f701d);
            jcVar.b();
        }
        if (this.f702e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f702e);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public boolean b() {
        return this.f696a != null;
    }

    public boolean c() {
        return this.f699b != null;
    }

    public boolean d() {
        return this.f700c != null;
    }

    public boolean e() {
        return this.f698a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m430a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f701d != null;
    }

    public boolean g() {
        return this.f702e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = true;
        if (m429a()) {
            sb.append("debug:");
            if (this.f697a == null) {
                sb.append("null");
            } else {
                sb.append(this.f697a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f696a == null) {
                sb.append("null");
            } else {
                sb.append(this.f696a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f699b == null) {
            sb.append("null");
        } else {
            sb.append(this.f699b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f700c == null) {
            sb.append("null");
        } else {
            sb.append(this.f700c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f695a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f701d == null) {
                sb.append("null");
            } else {
                sb.append(this.f701d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f702e == null) {
                sb.append("null");
            } else {
                sb.append(this.f702e);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
