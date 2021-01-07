package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ie implements ix<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f648a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f649a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f650b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f647a = new jn("XmPushActionCheckClientInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14428a = new jf("", (byte) 8, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14429b = new jf("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        int a3;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m435a()).compareTo(Boolean.valueOf(ieVar.m435a()));
            if (compareTo == 0) {
                if (!m435a() || (a3 = iy.a(this.f648a, ieVar.f648a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ieVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = iy.a(this.f650b, ieVar.f650b)) == 0) {
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
        this.f648a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                if (!m435a()) {
                    throw new jj("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jj("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a != 8) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f648a = jiVar.m513a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m515a.f14471a != 8) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f650b = jiVar.m513a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f649a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m435a() {
        return this.f649a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m436a(ie ieVar) {
        return ieVar != null && this.f648a == ieVar.f648a && this.f650b == ieVar.f650b;
    }

    public ie b(int i) {
        this.f650b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f647a);
        jiVar.a(f14428a);
        jiVar.a(this.f648a);
        jiVar.b();
        jiVar.a(f14429b);
        jiVar.a(this.f650b);
        jiVar.b();
        jiVar.c();
        jiVar.m523a();
    }

    public void b(boolean z) {
        this.f649a.set(1, z);
    }

    public boolean b() {
        return this.f649a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m436a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f648a + ", pluginConfigVersion:" + this.f650b + ")";
    }
}
