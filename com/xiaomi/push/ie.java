package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes9.dex */
public class ie implements ix<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f573a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f574a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f575b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f572a = new jn("XmPushActionCheckClientInfo");
    private static final jf a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        int a3;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m400a()).compareTo(Boolean.valueOf(ieVar.m400a()));
            if (compareTo == 0) {
                if (!m400a() || (a3 = iy.a(this.f573a, ieVar.f573a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ieVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = iy.a(this.f575b, ieVar.f575b)) == 0) {
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
        this.f573a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                if (!m400a()) {
                    throw new jj("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jj("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m480a.f783a) {
                case 1:
                    if (m480a.a != 8) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f573a = jiVar.m478a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m480a.a != 8) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f575b = jiVar.m478a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m480a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f574a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m400a() {
        return this.f574a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m401a(ie ieVar) {
        return ieVar != null && this.f573a == ieVar.f573a && this.f575b == ieVar.f575b;
    }

    public ie b(int i) {
        this.f575b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f572a);
        jiVar.a(a);
        jiVar.a(this.f573a);
        jiVar.b();
        jiVar.a(b);
        jiVar.a(this.f575b);
        jiVar.b();
        jiVar.c();
        jiVar.m488a();
    }

    public void b(boolean z) {
        this.f574a.set(1, z);
    }

    public boolean b() {
        return this.f574a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m401a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f573a + ", pluginConfigVersion:" + this.f575b + ")";
    }
}
