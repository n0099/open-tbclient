package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class ie implements ix<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f571a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f572a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f573b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f570a = new jn("XmPushActionCheckClientInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4974a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        int a3;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m408a()).compareTo(Boolean.valueOf(ieVar.m408a()));
            if (compareTo == 0) {
                if (!m408a() || (a3 = iy.a(this.f571a, ieVar.f571a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ieVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = iy.a(this.f573b, ieVar.f573b)) == 0) {
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
        this.f571a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                if (!m408a()) {
                    throw new jj("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jj("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a != 8) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f571a = jiVar.m486a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m488a.f5000a != 8) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f573b = jiVar.m486a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f572a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m408a() {
        return this.f572a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m409a(ie ieVar) {
        return ieVar != null && this.f571a == ieVar.f571a && this.f573b == ieVar.f573b;
    }

    public ie b(int i) {
        this.f573b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f570a);
        jiVar.a(f4974a);
        jiVar.a(this.f571a);
        jiVar.b();
        jiVar.a(b);
        jiVar.a(this.f573b);
        jiVar.b();
        jiVar.c();
        jiVar.m496a();
    }

    public void b(boolean z) {
        this.f572a.set(1, z);
    }

    public boolean b() {
        return this.f572a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m409a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f571a + ", pluginConfigVersion:" + this.f573b + ")";
    }
}
