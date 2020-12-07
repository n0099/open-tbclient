package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class ie implements ix<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f569a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f570a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f571b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f568a = new jn("XmPushActionCheckClientInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4744a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        int a3;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m398a()).compareTo(Boolean.valueOf(ieVar.m398a()));
            if (compareTo == 0) {
                if (!m398a() || (a3 = iy.a(this.f569a, ieVar.f569a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ieVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = iy.a(this.f571b, ieVar.f571b)) == 0) {
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
        this.f569a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m482a();
        while (true) {
            jf m478a = jiVar.m478a();
            if (m478a.f4770a == 0) {
                jiVar.f();
                if (!m398a()) {
                    throw new jj("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jj("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m478a.f779a) {
                case 1:
                    if (m478a.f4770a != 8) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f569a = jiVar.m476a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m478a.f4770a != 8) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f571b = jiVar.m476a();
                        b(true);
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
        this.f570a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m398a() {
        return this.f570a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m399a(ie ieVar) {
        return ieVar != null && this.f569a == ieVar.f569a && this.f571b == ieVar.f571b;
    }

    public ie b(int i) {
        this.f571b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f568a);
        jiVar.a(f4744a);
        jiVar.a(this.f569a);
        jiVar.b();
        jiVar.a(b);
        jiVar.a(this.f571b);
        jiVar.b();
        jiVar.c();
        jiVar.m486a();
    }

    public void b(boolean z) {
        this.f570a.set(1, z);
    }

    public boolean b() {
        return this.f570a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m399a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f569a + ", pluginConfigVersion:" + this.f571b + ")";
    }
}
