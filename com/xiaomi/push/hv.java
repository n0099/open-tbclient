package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class hv implements ir<hv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f539a;

    /* renamed from: d  reason: collision with other field name */
    public String f544d;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f537a = new jh("Target");
    private static final iz a = new iz("", (byte) 10, 1);
    private static final iz b = new iz("", Constants.GZIP_CAST_TYPE, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", (byte) 2, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 7);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f540a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f538a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f542b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f543c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f541a = false;

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
                if (!m377a() || (a7 = is.a(this.f538a, hvVar.f538a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a6 = is.a(this.f539a, hvVar.f539a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a5 = is.a(this.f542b, hvVar.f542b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hvVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a4 = is.a(this.f543c, hvVar.f543c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hvVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a3 = is.a(this.f541a, hvVar.f541a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hvVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a2 = is.a(this.f544d, hvVar.f544d)) == 0) {
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
        if (this.f539a == null) {
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
            switch (m468a.f789a) {
                case 1:
                    if (m468a.a != 10) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f538a = jcVar.m467a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f539a = jcVar.m473a();
                        break;
                    }
                case 3:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f542b = jcVar.m473a();
                        break;
                    }
                case 4:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f543c = jcVar.m473a();
                        break;
                    }
                case 5:
                    if (m468a.a != 2) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f541a = jcVar.m477a();
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
                        this.f544d = jcVar.m473a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f540a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m377a() {
        return this.f540a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m378a(hv hvVar) {
        if (hvVar != null && this.f538a == hvVar.f538a) {
            boolean b2 = b();
            boolean b3 = hvVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f539a.equals(hvVar.f539a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hvVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f542b.equals(hvVar.f542b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hvVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f543c.equals(hvVar.f543c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hvVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f541a == hvVar.f541a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hvVar.f();
            return !(f2 || f3) || (f2 && f3 && this.f544d.equals(hvVar.f544d));
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f537a);
        jcVar.a(a);
        jcVar.a(this.f538a);
        jcVar.b();
        if (this.f539a != null) {
            jcVar.a(b);
            jcVar.a(this.f539a);
            jcVar.b();
        }
        if (this.f542b != null && c()) {
            jcVar.a(c);
            jcVar.a(this.f542b);
            jcVar.b();
        }
        if (this.f543c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f543c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f541a);
            jcVar.b();
        }
        if (this.f544d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f544d);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public void b(boolean z) {
        this.f540a.set(1, z);
    }

    public boolean b() {
        return this.f539a != null;
    }

    public boolean c() {
        return this.f542b != null;
    }

    public boolean d() {
        return this.f543c != null;
    }

    public boolean e() {
        return this.f540a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return m378a((hv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f544d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f538a);
        sb.append(", ");
        sb.append("userId:");
        if (this.f539a == null) {
            sb.append("null");
        } else {
            sb.append(this.f539a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            if (this.f542b == null) {
                sb.append("null");
            } else {
                sb.append(this.f542b);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            if (this.f543c == null) {
                sb.append("null");
            } else {
                sb.append(this.f543c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f541a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f544d == null) {
                sb.append("null");
            } else {
                sb.append(this.f544d);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
