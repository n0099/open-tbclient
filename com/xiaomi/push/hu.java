package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class hu implements ix<hu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f546a;

    /* renamed from: a  reason: collision with other field name */
    public ho f547a;

    /* renamed from: a  reason: collision with other field name */
    public String f548a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f549a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    private static final jn f545a = new jn("DataCollectionItem");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14406a = new jf("", (byte) 10, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14407b = new jf("", (byte) 8, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hu huVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(huVar.getClass())) {
            int compareTo = Boolean.valueOf(m386a()).compareTo(Boolean.valueOf(huVar.m386a()));
            if (compareTo == 0) {
                if (!m386a() || (a4 = iy.a(this.f546a, huVar.f546a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(huVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f547a, huVar.f547a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(huVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f548a, huVar.f548a)) == 0) {
                                    return 0;
                                }
                                return a2;
                            }
                            return compareTo3;
                        }
                        return a3;
                    }
                    return compareTo2;
                }
                return a4;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(huVar.getClass().getName());
    }

    public hu a(long j) {
        this.f546a = j;
        a(true);
        return this;
    }

    public hu a(ho hoVar) {
        this.f547a = hoVar;
        return this;
    }

    public hu a(String str) {
        this.f548a = str;
        return this;
    }

    public String a() {
        return this.f548a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m385a() {
        if (this.f547a == null) {
            throw new jj("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f548a == null) {
            throw new jj("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                if (!m386a()) {
                    throw new jj("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
                }
                m385a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a != 10) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f546a = jiVar.m514a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m515a.f14471a != 8) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f547a = ho.a(jiVar.m513a());
                        break;
                    }
                case 3:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f548a = jiVar.m520a();
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f549a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m386a() {
        return this.f549a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m387a(hu huVar) {
        if (huVar != null && this.f546a == huVar.f546a) {
            boolean b2 = b();
            boolean b3 = huVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f547a.equals(huVar.f547a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = huVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f548a.equals(huVar.f548a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m385a();
        jiVar.a(f545a);
        jiVar.a(f14406a);
        jiVar.a(this.f546a);
        jiVar.b();
        if (this.f547a != null) {
            jiVar.a(f14407b);
            jiVar.a(this.f547a.a());
            jiVar.b();
        }
        if (this.f548a != null) {
            jiVar.a(c);
            jiVar.a(this.f548a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public boolean b() {
        return this.f547a != null;
    }

    public boolean c() {
        return this.f548a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return m387a((hu) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f546a);
        sb.append(", ");
        sb.append("collectionType:");
        if (this.f547a == null) {
            sb.append("null");
        } else {
            sb.append(this.f547a);
        }
        sb.append(", ");
        sb.append("content:");
        if (this.f548a == null) {
            sb.append("null");
        } else {
            sb.append(this.f548a);
        }
        sb.append(")");
        return sb.toString();
    }
}
