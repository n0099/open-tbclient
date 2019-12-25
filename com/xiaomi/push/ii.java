package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class ii implements ir<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f696a;

    /* renamed from: a  reason: collision with other field name */
    public hv f697a;

    /* renamed from: a  reason: collision with other field name */
    public String f698a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f699a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f700b;

    /* renamed from: c  reason: collision with other field name */
    public String f701c;

    /* renamed from: d  reason: collision with other field name */
    public String f702d;

    /* renamed from: e  reason: collision with other field name */
    public String f703e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f695a = new jh("XmPushActionSendFeedbackResult");
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
            int compareTo = Boolean.valueOf(m420a()).compareTo(Boolean.valueOf(iiVar.m420a()));
            if (compareTo == 0) {
                if (!m420a() || (a8 = is.a(this.f698a, iiVar.f698a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iiVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = is.a(this.f697a, iiVar.f697a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = is.a(this.f700b, iiVar.f700b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = is.a(this.f701c, iiVar.f701c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = is.a(this.f696a, iiVar.f696a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = is.a(this.f702d, iiVar.f702d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = is.a(this.f703e, iiVar.f703e)) == 0) {
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
        if (this.f700b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f701c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f698a = jcVar.m459a();
                        break;
                    }
                case 2:
                    if (m454a.a != 12) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f697a = new hv();
                        this.f697a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f700b = jcVar.m459a();
                        break;
                    }
                case 4:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f701c = jcVar.m459a();
                        break;
                    }
                case 5:
                default:
                    jf.a(jcVar, m454a.a);
                    break;
                case 6:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f696a = jcVar.m453a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f702d = jcVar.m459a();
                        break;
                    }
                case 8:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f703e = jcVar.m459a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f699a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m420a() {
        return this.f698a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m421a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m420a = m420a();
        boolean m420a2 = iiVar.m420a();
        if ((m420a || m420a2) && !(m420a && m420a2 && this.f698a.equals(iiVar.f698a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iiVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f697a.m364a(iiVar.f697a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iiVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f700b.equals(iiVar.f700b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iiVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f701c.equals(iiVar.f701c))) || this.f696a != iiVar.f696a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iiVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f702d.equals(iiVar.f702d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iiVar.g();
        return !(g2 || g3) || (g2 && g3 && this.f703e.equals(iiVar.f703e));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f695a);
        if (this.f698a != null && m420a()) {
            jcVar.a(a);
            jcVar.a(this.f698a);
            jcVar.b();
        }
        if (this.f697a != null && b()) {
            jcVar.a(b);
            this.f697a.b(jcVar);
            jcVar.b();
        }
        if (this.f700b != null) {
            jcVar.a(c);
            jcVar.a(this.f700b);
            jcVar.b();
        }
        if (this.f701c != null) {
            jcVar.a(d);
            jcVar.a(this.f701c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f696a);
        jcVar.b();
        if (this.f702d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f702d);
            jcVar.b();
        }
        if (this.f703e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f703e);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public boolean b() {
        return this.f697a != null;
    }

    public boolean c() {
        return this.f700b != null;
    }

    public boolean d() {
        return this.f701c != null;
    }

    public boolean e() {
        return this.f699a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m421a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f702d != null;
    }

    public boolean g() {
        return this.f703e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = true;
        if (m420a()) {
            sb.append("debug:");
            if (this.f698a == null) {
                sb.append("null");
            } else {
                sb.append(this.f698a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f697a == null) {
                sb.append("null");
            } else {
                sb.append(this.f697a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f700b == null) {
            sb.append("null");
        } else {
            sb.append(this.f700b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f701c == null) {
            sb.append("null");
        } else {
            sb.append(this.f701c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f696a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f702d == null) {
                sb.append("null");
            } else {
                sb.append(this.f702d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f703e == null) {
                sb.append("null");
            } else {
                sb.append(this.f703e);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
