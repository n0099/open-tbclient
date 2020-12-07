package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class hu implements ix<hu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f467a;

    /* renamed from: a  reason: collision with other field name */
    public ho f468a;

    /* renamed from: a  reason: collision with other field name */
    public String f469a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f470a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    private static final jn f466a = new jn("DataCollectionItem");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4733a = new jf("", (byte) 10, 1);
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
            int compareTo = Boolean.valueOf(m349a()).compareTo(Boolean.valueOf(huVar.m349a()));
            if (compareTo == 0) {
                if (!m349a() || (a4 = iy.a(this.f467a, huVar.f467a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(huVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f468a, huVar.f468a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(huVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f469a, huVar.f469a)) == 0) {
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
        this.f467a = j;
        a(true);
        return this;
    }

    public hu a(ho hoVar) {
        this.f468a = hoVar;
        return this;
    }

    public hu a(String str) {
        this.f469a = str;
        return this;
    }

    public String a() {
        return this.f469a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m348a() {
        if (this.f468a == null) {
            throw new jj("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f469a == null) {
            throw new jj("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m482a();
        while (true) {
            jf m478a = jiVar.m478a();
            if (m478a.f4770a == 0) {
                jiVar.f();
                if (!m349a()) {
                    throw new jj("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
                }
                m348a();
                return;
            }
            switch (m478a.f779a) {
                case 1:
                    if (m478a.f4770a != 10) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f467a = jiVar.m477a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m478a.f4770a != 8) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f468a = ho.a(jiVar.m476a());
                        break;
                    }
                case 3:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f469a = jiVar.m483a();
                        break;
                    }
                default:
                    jl.a(jiVar, m478a.f4770a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f470a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m349a() {
        return this.f470a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m350a(hu huVar) {
        if (huVar != null && this.f467a == huVar.f467a) {
            boolean b2 = b();
            boolean b3 = huVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f468a.equals(huVar.f468a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = huVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f469a.equals(huVar.f469a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m348a();
        jiVar.a(f466a);
        jiVar.a(f4733a);
        jiVar.a(this.f467a);
        jiVar.b();
        if (this.f468a != null) {
            jiVar.a(b);
            jiVar.a(this.f468a.a());
            jiVar.b();
        }
        if (this.f469a != null) {
            jiVar.a(c);
            jiVar.a(this.f469a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m486a();
    }

    public boolean b() {
        return this.f468a != null;
    }

    public boolean c() {
        return this.f469a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return m350a((hu) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f467a);
        sb.append(", ");
        sb.append("collectionType:");
        if (this.f468a == null) {
            sb.append("null");
        } else {
            sb.append(this.f468a);
        }
        sb.append(", ");
        sb.append("content:");
        if (this.f469a == null) {
            sb.append("null");
        } else {
            sb.append(this.f469a);
        }
        sb.append(")");
        return sb.toString();
    }
}
