package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class hy implements ir<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f580a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f581a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f582b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f579a = new jh("XmPushActionCheckClientInfo");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hy hyVar) {
        int a2;
        int a3;
        if (getClass().equals(hyVar.getClass())) {
            int compareTo = Boolean.valueOf(m388a()).compareTo(Boolean.valueOf(hyVar.m388a()));
            if (compareTo == 0) {
                if (!m388a() || (a3 = is.a(this.f580a, hyVar.f580a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hyVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = is.a(this.f582b, hyVar.f582b)) == 0) {
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
        this.f580a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                if (!m388a()) {
                    throw new jd("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jd("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a != 8) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f580a = jcVar.m469a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m471a.a != 8) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f582b = jcVar.m469a();
                        b(true);
                        break;
                    }
                default:
                    jf.a(jcVar, m471a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f581a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m388a() {
        return this.f581a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m389a(hy hyVar) {
        return hyVar != null && this.f580a == hyVar.f580a && this.f582b == hyVar.f582b;
    }

    public hy b(int i) {
        this.f582b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f579a);
        jcVar.a(a);
        jcVar.a(this.f580a);
        jcVar.b();
        jcVar.a(b);
        jcVar.a(this.f582b);
        jcVar.b();
        jcVar.c();
        jcVar.m479a();
    }

    public void b(boolean z) {
        this.f581a.set(1, z);
    }

    public boolean b() {
        return this.f581a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m389a((hy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f580a + ", pluginConfigVersion:" + this.f582b + ")";
    }
}
