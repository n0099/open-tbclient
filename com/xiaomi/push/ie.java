package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ie implements ix<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f574a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f575a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f576b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f573a = new jn("XmPushActionCheckClientInfo");
    private static final jf a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        int a3;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m399a()).compareTo(Boolean.valueOf(ieVar.m399a()));
            if (compareTo == 0) {
                if (!m399a() || (a3 = iy.a(this.f574a, ieVar.f574a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ieVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = iy.a(this.f576b, ieVar.f576b)) == 0) {
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
        this.f574a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                if (!m399a()) {
                    throw new jj("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jj("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a != 8) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f574a = jiVar.m477a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m479a.a != 8) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f576b = jiVar.m477a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m479a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f575a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m399a() {
        return this.f575a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m400a(ie ieVar) {
        return ieVar != null && this.f574a == ieVar.f574a && this.f576b == ieVar.f576b;
    }

    public ie b(int i) {
        this.f576b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f573a);
        jiVar.a(a);
        jiVar.a(this.f574a);
        jiVar.b();
        jiVar.a(b);
        jiVar.a(this.f576b);
        jiVar.b();
        jiVar.c();
        jiVar.m487a();
    }

    public void b(boolean z) {
        this.f575a.set(1, z);
    }

    public boolean b() {
        return this.f575a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m400a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f574a + ", pluginConfigVersion:" + this.f576b + ")";
    }
}
