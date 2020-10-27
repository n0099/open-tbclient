package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes12.dex */
public class hu implements ix<hu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f464a;

    /* renamed from: a  reason: collision with other field name */
    public ho f465a;

    /* renamed from: a  reason: collision with other field name */
    public String f466a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f467a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    private static final jn f463a = new jn("DataCollectionItem");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4961a = new jf("", (byte) 10, 1);
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
                if (!m356a() || (a4 = iy.a(this.f464a, huVar.f464a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(huVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f465a, huVar.f465a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(huVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f466a, huVar.f466a)) == 0) {
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
        this.f464a = j;
        a(true);
        return this;
    }

    public hu a(ho hoVar) {
        this.f465a = hoVar;
        return this;
    }

    public hu a(String str) {
        this.f466a = str;
        return this;
    }

    public String a() {
        return this.f466a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m355a() {
        if (this.f465a == null) {
            throw new jj("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f466a == null) {
            throw new jj("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                if (!m356a()) {
                    throw new jj("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
                }
                m355a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a != 10) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f464a = jiVar.m484a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m485a.f4998a != 8) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f465a = ho.a(jiVar.m483a());
                        break;
                    }
                case 3:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f466a = jiVar.m490a();
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f467a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m356a() {
        return this.f467a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m357a(hu huVar) {
        if (huVar != null && this.f464a == huVar.f464a) {
            boolean b2 = b();
            boolean b3 = huVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f465a.equals(huVar.f465a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = huVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f466a.equals(huVar.f466a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m355a();
        jiVar.a(f463a);
        jiVar.a(f4961a);
        jiVar.a(this.f464a);
        jiVar.b();
        if (this.f465a != null) {
            jiVar.a(b);
            jiVar.a(this.f465a.a());
            jiVar.b();
        }
        if (this.f466a != null) {
            jiVar.a(c);
            jiVar.a(this.f466a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public boolean b() {
        return this.f465a != null;
    }

    public boolean c() {
        return this.f466a != null;
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
        sb.append(this.f464a);
        sb.append(", ");
        sb.append("collectionType:");
        if (this.f465a == null) {
            sb.append("null");
        } else {
            sb.append(this.f465a);
        }
        sb.append(", ");
        sb.append("content:");
        if (this.f466a == null) {
            sb.append("null");
        } else {
            sb.append(this.f466a);
        }
        sb.append(")");
        return sb.toString();
    }
}
