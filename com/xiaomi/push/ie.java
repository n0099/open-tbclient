package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes9.dex */
public class ie implements ix<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f568a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f569a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f570b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f567a = new jn("XmPushActionCheckClientInfo");
    private static final jf a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        int a3;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m405a()).compareTo(Boolean.valueOf(ieVar.m405a()));
            if (compareTo == 0) {
                if (!m405a() || (a3 = iy.a(this.f568a, ieVar.f568a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ieVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = iy.a(this.f570b, ieVar.f570b)) == 0) {
                            return 0;
                        }
                        return a2;
                    }
                    return compareTo2;
                }
                return a3;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ieVar.getClass().getName());
    }

    public ie a(int i) {
        this.f568a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.a == 0) {
                jiVar.f();
                if (!m405a()) {
                    throw new jj("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jj("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m485a.f778a) {
                case 1:
                    if (m485a.a != 8) {
                        jl.a(jiVar, m485a.a);
                        break;
                    } else {
                        this.f568a = jiVar.m483a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m485a.a != 8) {
                        jl.a(jiVar, m485a.a);
                        break;
                    } else {
                        this.f570b = jiVar.m483a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f569a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m405a() {
        return this.f569a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m406a(ie ieVar) {
        return ieVar != null && this.f568a == ieVar.f568a && this.f570b == ieVar.f570b;
    }

    public ie b(int i) {
        this.f570b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f567a);
        jiVar.a(a);
        jiVar.a(this.f568a);
        jiVar.b();
        jiVar.a(b);
        jiVar.a(this.f570b);
        jiVar.b();
        jiVar.c();
        jiVar.m493a();
    }

    public void b(boolean z) {
        this.f569a.set(1, z);
    }

    public boolean b() {
        return this.f569a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m406a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f568a + ", pluginConfigVersion:" + this.f570b + ")";
    }
}
