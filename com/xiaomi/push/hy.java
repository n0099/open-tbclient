package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class hy implements ir<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f584a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f585a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f586b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f583a = new jh("XmPushActionCheckClientInfo");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hy hyVar) {
        int a2;
        int a3;
        if (getClass().equals(hyVar.getClass())) {
            int compareTo = Boolean.valueOf(m371a()).compareTo(Boolean.valueOf(hyVar.m371a()));
            if (compareTo == 0) {
                if (!m371a() || (a3 = is.a(this.f584a, hyVar.f584a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hyVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = is.a(this.f586b, hyVar.f586b)) == 0) {
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
        return getClass().getName().compareTo(hyVar.getClass().getName());
    }

    public hy a(int i) {
        this.f584a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                if (!m371a()) {
                    throw new jd("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jd("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a != 8) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f584a = jcVar.m452a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m454a.a != 8) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f586b = jcVar.m452a();
                        b(true);
                        break;
                    }
                default:
                    jf.a(jcVar, m454a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f585a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m371a() {
        return this.f585a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m372a(hy hyVar) {
        return hyVar != null && this.f584a == hyVar.f584a && this.f586b == hyVar.f586b;
    }

    public hy b(int i) {
        this.f586b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f583a);
        jcVar.a(a);
        jcVar.a(this.f584a);
        jcVar.b();
        jcVar.a(b);
        jcVar.a(this.f586b);
        jcVar.b();
        jcVar.c();
        jcVar.m462a();
    }

    public void b(boolean z) {
        this.f585a.set(1, z);
    }

    public boolean b() {
        return this.f585a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m372a((hy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f584a + ", pluginConfigVersion:" + this.f586b + ")";
    }
}
