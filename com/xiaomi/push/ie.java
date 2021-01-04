package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ie implements ix<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f647a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f648a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f649b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f646a = new jn("XmPushActionCheckClientInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14427a = new jf("", (byte) 8, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14428b = new jf("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        int a3;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m424a()).compareTo(Boolean.valueOf(ieVar.m424a()));
            if (compareTo == 0) {
                if (!m424a() || (a3 = iy.a(this.f647a, ieVar.f647a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ieVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = iy.a(this.f649b, ieVar.f649b)) == 0) {
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
        this.f647a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m508a();
        while (true) {
            jf m504a = jiVar.m504a();
            if (m504a.f14470a == 0) {
                jiVar.f();
                if (!m424a()) {
                    throw new jj("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jj("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m504a.f857a) {
                case 1:
                    if (m504a.f14470a != 8) {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    } else {
                        this.f647a = jiVar.m502a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m504a.f14470a != 8) {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    } else {
                        this.f649b = jiVar.m502a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m504a.f14470a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f648a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m424a() {
        return this.f648a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m425a(ie ieVar) {
        return ieVar != null && this.f647a == ieVar.f647a && this.f649b == ieVar.f649b;
    }

    public ie b(int i) {
        this.f649b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f646a);
        jiVar.a(f14427a);
        jiVar.a(this.f647a);
        jiVar.b();
        jiVar.a(f14428b);
        jiVar.a(this.f649b);
        jiVar.b();
        jiVar.c();
        jiVar.m512a();
    }

    public void b(boolean z) {
        this.f648a.set(1, z);
    }

    public boolean b() {
        return this.f648a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m425a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f647a + ", pluginConfigVersion:" + this.f649b + ")";
    }
}
