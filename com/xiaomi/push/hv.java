package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class hv implements ir<hv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f538a;

    /* renamed from: d  reason: collision with other field name */
    public String f543d;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f536a = new jh("Target");
    private static final iz a = new iz("", (byte) 10, 1);
    private static final iz b = new iz("", Constants.GZIP_CAST_TYPE, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", (byte) 2, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 7);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f539a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f537a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f541b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f542c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f540a = false;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hv hvVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (getClass().equals(hvVar.getClass())) {
            int compareTo = Boolean.valueOf(m377a()).compareTo(Boolean.valueOf(hvVar.m377a()));
            if (compareTo == 0) {
                if (!m377a() || (a7 = is.a(this.f537a, hvVar.f537a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a6 = is.a(this.f538a, hvVar.f538a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a5 = is.a(this.f541b, hvVar.f541b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hvVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a4 = is.a(this.f542c, hvVar.f542c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hvVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a3 = is.a(this.f540a, hvVar.f540a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hvVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a2 = is.a(this.f543d, hvVar.f543d)) == 0) {
                                                            return 0;
                                                        }
                                                        return a2;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a3;
                                            }
                                            return compareTo5;
                                        }
                                        return a4;
                                    }
                                    return compareTo4;
                                }
                                return a5;
                            }
                            return compareTo3;
                        }
                        return a6;
                    }
                    return compareTo2;
                }
                return a7;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hvVar.getClass().getName());
    }

    public void a() {
        if (this.f538a == null) {
            throw new jd("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                if (!m377a()) {
                    throw new jd("Required field 'channelId' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m468a.f788a) {
                case 1:
                    if (m468a.a != 10) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f537a = jcVar.m467a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f538a = jcVar.m473a();
                        break;
                    }
                case 3:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f541b = jcVar.m473a();
                        break;
                    }
                case 4:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f542c = jcVar.m473a();
                        break;
                    }
                case 5:
                    if (m468a.a != 2) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f540a = jcVar.m477a();
                        b(true);
                        break;
                    }
                case 6:
                default:
                    jf.a(jcVar, m468a.a);
                    break;
                case 7:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f543d = jcVar.m473a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f539a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m377a() {
        return this.f539a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m378a(hv hvVar) {
        if (hvVar != null && this.f537a == hvVar.f537a) {
            boolean b2 = b();
            boolean b3 = hvVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f538a.equals(hvVar.f538a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hvVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f541b.equals(hvVar.f541b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hvVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f542c.equals(hvVar.f542c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hvVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f540a == hvVar.f540a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hvVar.f();
            return !(f2 || f3) || (f2 && f3 && this.f543d.equals(hvVar.f543d));
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f536a);
        jcVar.a(a);
        jcVar.a(this.f537a);
        jcVar.b();
        if (this.f538a != null) {
            jcVar.a(b);
            jcVar.a(this.f538a);
            jcVar.b();
        }
        if (this.f541b != null && c()) {
            jcVar.a(c);
            jcVar.a(this.f541b);
            jcVar.b();
        }
        if (this.f542c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f542c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f540a);
            jcVar.b();
        }
        if (this.f543d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f543d);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public void b(boolean z) {
        this.f539a.set(1, z);
    }

    public boolean b() {
        return this.f538a != null;
    }

    public boolean c() {
        return this.f541b != null;
    }

    public boolean d() {
        return this.f542c != null;
    }

    public boolean e() {
        return this.f539a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return m378a((hv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f543d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f537a);
        sb.append(", ");
        sb.append("userId:");
        if (this.f538a == null) {
            sb.append("null");
        } else {
            sb.append(this.f538a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            if (this.f541b == null) {
                sb.append("null");
            } else {
                sb.append(this.f541b);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            if (this.f542c == null) {
                sb.append("null");
            } else {
                sb.append(this.f542c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f540a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f543d == null) {
                sb.append("null");
            } else {
                sb.append(this.f543d);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
