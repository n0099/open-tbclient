package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class hu implements ix<hu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f472a;

    /* renamed from: a  reason: collision with other field name */
    public ho f473a;

    /* renamed from: a  reason: collision with other field name */
    public String f474a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f475a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    private static final jn f471a = new jn("DataCollectionItem");
    private static final jf a = new jf("", (byte) 10, 1);
    private static final jf b = new jf("", (byte) 8, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hu huVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(huVar.getClass())) {
            int compareTo = Boolean.valueOf(m350a()).compareTo(Boolean.valueOf(huVar.m350a()));
            if (compareTo == 0) {
                if (!m350a() || (a4 = iy.a(this.f472a, huVar.f472a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(huVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f473a, huVar.f473a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(huVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f474a, huVar.f474a)) == 0) {
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
        this.f472a = j;
        a(true);
        return this;
    }

    public hu a(ho hoVar) {
        this.f473a = hoVar;
        return this;
    }

    public hu a(String str) {
        this.f474a = str;
        return this;
    }

    public String a() {
        return this.f474a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m349a() {
        if (this.f473a == null) {
            throw new jj("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f474a == null) {
            throw new jj("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                if (!m350a()) {
                    throw new jj("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
                }
                m349a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f472a = jiVar.m478a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m479a.a != 8) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f473a = ho.a(jiVar.m477a());
                        break;
                    }
                case 3:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f474a = jiVar.m484a();
                        break;
                    }
                default:
                    jl.a(jiVar, m479a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f475a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m350a() {
        return this.f475a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m351a(hu huVar) {
        if (huVar != null && this.f472a == huVar.f472a) {
            boolean b2 = b();
            boolean b3 = huVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f473a.equals(huVar.f473a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = huVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f474a.equals(huVar.f474a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m349a();
        jiVar.a(f471a);
        jiVar.a(a);
        jiVar.a(this.f472a);
        jiVar.b();
        if (this.f473a != null) {
            jiVar.a(b);
            jiVar.a(this.f473a.a());
            jiVar.b();
        }
        if (this.f474a != null) {
            jiVar.a(c);
            jiVar.a(this.f474a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public boolean b() {
        return this.f473a != null;
    }

    public boolean c() {
        return this.f474a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return m351a((hu) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f472a);
        sb.append(", ");
        sb.append("collectionType:");
        if (this.f473a == null) {
            sb.append("null");
        } else {
            sb.append(this.f473a);
        }
        sb.append(", ");
        sb.append("content:");
        if (this.f474a == null) {
            sb.append("null");
        } else {
            sb.append(this.f474a);
        }
        sb.append(")");
        return sb.toString();
    }
}
