package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ie implements ix<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f567a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f568a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f569b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f566a = new jn("XmPushActionCheckClientInfo");
    private static final jf a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        int a3;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m403a()).compareTo(Boolean.valueOf(ieVar.m403a()));
            if (compareTo == 0) {
                if (!m403a() || (a3 = iy.a(this.f567a, ieVar.f567a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ieVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = iy.a(this.f569b, ieVar.f569b)) == 0) {
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
        this.f567a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m487a();
        while (true) {
            jf m483a = jiVar.m483a();
            if (m483a.a == 0) {
                jiVar.f();
                if (!m403a()) {
                    throw new jj("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jj("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m483a.f777a) {
                case 1:
                    if (m483a.a != 8) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f567a = jiVar.m481a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m483a.a != 8) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f569b = jiVar.m481a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m483a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f568a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m403a() {
        return this.f568a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m404a(ie ieVar) {
        return ieVar != null && this.f567a == ieVar.f567a && this.f569b == ieVar.f569b;
    }

    public ie b(int i) {
        this.f569b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f566a);
        jiVar.a(a);
        jiVar.a(this.f567a);
        jiVar.b();
        jiVar.a(b);
        jiVar.a(this.f569b);
        jiVar.b();
        jiVar.c();
        jiVar.m491a();
    }

    public void b(boolean z) {
        this.f568a.set(1, z);
    }

    public boolean b() {
        return this.f568a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m404a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f567a + ", pluginConfigVersion:" + this.f569b + ")";
    }
}
