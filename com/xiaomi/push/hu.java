package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes12.dex */
public class hu implements ix<hu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f466a;

    /* renamed from: a  reason: collision with other field name */
    public ho f467a;

    /* renamed from: a  reason: collision with other field name */
    public String f468a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f469a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    private static final jn f465a = new jn("DataCollectionItem");

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
            int compareTo = Boolean.valueOf(m356a()).compareTo(Boolean.valueOf(huVar.m356a()));
            if (compareTo == 0) {
                if (!m356a() || (a4 = iy.a(this.f466a, huVar.f466a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(huVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f467a, huVar.f467a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(huVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f468a, huVar.f468a)) == 0) {
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
        this.f466a = j;
        a(true);
        return this;
    }

    public hu a(ho hoVar) {
        this.f467a = hoVar;
        return this;
    }

    public hu a(String str) {
        this.f468a = str;
        return this;
    }

    public String a() {
        return this.f468a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m355a() {
        if (this.f467a == null) {
            throw new jj("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f468a == null) {
            throw new jj("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f5000a == 0) {
                jiVar.f();
                if (!m356a()) {
                    throw new jj("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
                }
                m355a();
                return;
            }
            switch (m485a.f778a) {
                case 1:
                    if (m485a.f5000a != 10) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f466a = jiVar.m484a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m485a.f5000a != 8) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f467a = ho.a(jiVar.m483a());
                        break;
                    }
                case 3:
                    if (m485a.f5000a != 11) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f468a = jiVar.m490a();
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f469a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m356a() {
        return this.f469a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m357a(hu huVar) {
        if (huVar != null && this.f466a == huVar.f466a) {
            boolean b2 = b();
            boolean b3 = huVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f467a.equals(huVar.f467a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = huVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f468a.equals(huVar.f468a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m355a();
        jiVar.a(f465a);
        jiVar.a(f4963a);
        jiVar.a(this.f466a);
        jiVar.b();
        if (this.f467a != null) {
            jiVar.a(b);
            jiVar.a(this.f467a.a());
            jiVar.b();
        }
        if (this.f468a != null) {
            jiVar.a(c);
            jiVar.a(this.f468a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public boolean b() {
        return this.f467a != null;
    }

    public boolean c() {
        return this.f468a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return m357a((hu) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f466a);
        sb.append(", ");
        sb.append("collectionType:");
        if (this.f467a == null) {
            sb.append("null");
        } else {
            sb.append(this.f467a);
        }
        sb.append(", ");
        sb.append("content:");
        if (this.f468a == null) {
            sb.append("null");
        } else {
            sb.append(this.f468a);
        }
        sb.append(")");
        return sb.toString();
    }
}
