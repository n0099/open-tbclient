package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class hu implements ix<hu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f469a;

    /* renamed from: a  reason: collision with other field name */
    public ho f470a;

    /* renamed from: a  reason: collision with other field name */
    public String f471a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f472a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    private static final jn f468a = new jn("DataCollectionItem");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4963a = new jf("", (byte) 10, 1);
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
            int compareTo = Boolean.valueOf(m359a()).compareTo(Boolean.valueOf(huVar.m359a()));
            if (compareTo == 0) {
                if (!m359a() || (a4 = iy.a(this.f469a, huVar.f469a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(huVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f470a, huVar.f470a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(huVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f471a, huVar.f471a)) == 0) {
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
        this.f469a = j;
        a(true);
        return this;
    }

    public hu a(ho hoVar) {
        this.f470a = hoVar;
        return this;
    }

    public hu a(String str) {
        this.f471a = str;
        return this;
    }

    public String a() {
        return this.f471a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m358a() {
        if (this.f470a == null) {
            throw new jj("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f471a == null) {
            throw new jj("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                if (!m359a()) {
                    throw new jj("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
                }
                m358a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a != 10) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f469a = jiVar.m487a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m488a.f5000a != 8) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f470a = ho.a(jiVar.m486a());
                        break;
                    }
                case 3:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f471a = jiVar.m493a();
                        break;
                    }
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f472a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m359a() {
        return this.f472a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m360a(hu huVar) {
        if (huVar != null && this.f469a == huVar.f469a) {
            boolean b2 = b();
            boolean b3 = huVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f470a.equals(huVar.f470a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = huVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f471a.equals(huVar.f471a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m358a();
        jiVar.a(f468a);
        jiVar.a(f4963a);
        jiVar.a(this.f469a);
        jiVar.b();
        if (this.f470a != null) {
            jiVar.a(b);
            jiVar.a(this.f470a.a());
            jiVar.b();
        }
        if (this.f471a != null) {
            jiVar.a(c);
            jiVar.a(this.f471a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public boolean b() {
        return this.f470a != null;
    }

    public boolean c() {
        return this.f471a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return m360a((hu) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f469a);
        sb.append(", ");
        sb.append("collectionType:");
        if (this.f470a == null) {
            sb.append("null");
        } else {
            sb.append(this.f470a);
        }
        sb.append(", ");
        sb.append("content:");
        if (this.f471a == null) {
            sb.append("null");
        } else {
            sb.append(this.f471a);
        }
        sb.append(")");
        return sb.toString();
    }
}
