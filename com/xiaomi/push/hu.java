package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class hu implements ix<hu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f545a;

    /* renamed from: a  reason: collision with other field name */
    public ho f546a;

    /* renamed from: a  reason: collision with other field name */
    public String f547a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f548a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    private static final jn f544a = new jn("DataCollectionItem");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14106a = new jf("", (byte) 10, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14107b = new jf("", (byte) 8, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hu huVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(huVar.getClass())) {
            int compareTo = Boolean.valueOf(m382a()).compareTo(Boolean.valueOf(huVar.m382a()));
            if (compareTo == 0) {
                if (!m382a() || (a4 = iy.a(this.f545a, huVar.f545a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(huVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f546a, huVar.f546a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(huVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f547a, huVar.f547a)) == 0) {
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
        this.f545a = j;
        a(true);
        return this;
    }

    public hu a(ho hoVar) {
        this.f546a = hoVar;
        return this;
    }

    public hu a(String str) {
        this.f547a = str;
        return this;
    }

    public String a() {
        return this.f547a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m381a() {
        if (this.f546a == null) {
            throw new jj("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f547a == null) {
            throw new jj("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m515a();
        while (true) {
            jf m511a = jiVar.m511a();
            if (m511a.f14171a == 0) {
                jiVar.f();
                if (!m382a()) {
                    throw new jj("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
                }
                m381a();
                return;
            }
            switch (m511a.f857a) {
                case 1:
                    if (m511a.f14171a != 10) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f545a = jiVar.m510a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m511a.f14171a != 8) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f546a = ho.a(jiVar.m509a());
                        break;
                    }
                case 3:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f547a = jiVar.m516a();
                        break;
                    }
                default:
                    jl.a(jiVar, m511a.f14171a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f548a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m382a() {
        return this.f548a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m383a(hu huVar) {
        if (huVar != null && this.f545a == huVar.f545a) {
            boolean b2 = b();
            boolean b3 = huVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f546a.equals(huVar.f546a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = huVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f547a.equals(huVar.f547a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m381a();
        jiVar.a(f544a);
        jiVar.a(f14106a);
        jiVar.a(this.f545a);
        jiVar.b();
        if (this.f546a != null) {
            jiVar.a(f14107b);
            jiVar.a(this.f546a.a());
            jiVar.b();
        }
        if (this.f547a != null) {
            jiVar.a(c);
            jiVar.a(this.f547a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m519a();
    }

    public boolean b() {
        return this.f546a != null;
    }

    public boolean c() {
        return this.f547a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return m383a((hu) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f545a);
        sb.append(", ");
        sb.append("collectionType:");
        if (this.f546a == null) {
            sb.append("null");
        } else {
            sb.append(this.f546a);
        }
        sb.append(", ");
        sb.append("content:");
        if (this.f547a == null) {
            sb.append("null");
        } else {
            sb.append(this.f547a);
        }
        sb.append(")");
        return sb.toString();
    }
}
