package com.xiaomi.xmpush.thrift;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class k implements Serializable, Cloneable, org.apache.thrift.a<k, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j d = new org.apache.thrift.protocol.j("DataCollectionItem");
    private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b("", (byte) 10, 1);
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("", (byte) 8, 2);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 3);
    public long a;
    public d b;
    public String c;
    private BitSet h = new BitSet(1);

    public k a(long j) {
        this.a = j;
        a(true);
        return this;
    }

    public k a(d dVar) {
        this.b = dVar;
        return this;
    }

    public k a(String str) {
        this.c = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!a()) {
                    throw new org.apache.thrift.protocol.f("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
                }
                e();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.a = eVar.u();
                        a(true);
                        break;
                    }
                case 2:
                    if (i.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.b = d.a(eVar.t());
                        break;
                    }
                case 3:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.c = eVar.w();
                        break;
                    }
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.h.set(0, z);
    }

    public boolean a() {
        return this.h.get(0);
    }

    public boolean a(k kVar) {
        if (kVar != null && this.a == kVar.a) {
            boolean b = b();
            boolean b2 = kVar.b();
            if ((b || b2) && !(b && b2 && this.b.equals(kVar.b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = kVar.d();
            return !(d2 || d3) || (d2 && d3 && this.c.equals(kVar.c));
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(k kVar) {
        int a;
        int a2;
        int a3;
        if (getClass().equals(kVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(kVar.a()));
            if (compareTo == 0) {
                if (!a() || (a3 = org.apache.thrift.b.a(this.a, kVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(kVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = org.apache.thrift.b.a(this.b, kVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(kVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a = org.apache.thrift.b.a(this.c, kVar.c)) == 0) {
                                    return 0;
                                }
                                return a;
                            }
                            return compareTo3;
                        }
                        return a2;
                    }
                    return compareTo2;
                }
                return a3;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(kVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        e();
        eVar.a(d);
        eVar.a(e);
        eVar.a(this.a);
        eVar.b();
        if (this.b != null) {
            eVar.a(f);
            eVar.a(this.b.a());
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(g);
            eVar.a(this.c);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.c != null;
    }

    public void e() {
        if (this.b == null) {
            throw new org.apache.thrift.protocol.f("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'content' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof k)) {
            return a((k) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("collectionType:");
        if (this.b == null) {
            sb.append("null");
        } else {
            sb.append(this.b);
        }
        sb.append(", ");
        sb.append("content:");
        if (this.c == null) {
            sb.append("null");
        } else {
            sb.append(this.c);
        }
        sb.append(")");
        return sb.toString();
    }
}
