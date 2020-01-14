package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class hy implements ir<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f583a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f584a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f585b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f582a = new jh("XmPushActionCheckClientInfo");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hy hyVar) {
        int a2;
        int a3;
        if (getClass().equals(hyVar.getClass())) {
            int compareTo = Boolean.valueOf(m380a()).compareTo(Boolean.valueOf(hyVar.m380a()));
            if (compareTo == 0) {
                if (!m380a() || (a3 = is.a(this.f583a, hyVar.f583a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hyVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = is.a(this.f585b, hyVar.f585b)) == 0) {
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
        this.f583a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                if (!m380a()) {
                    throw new jd("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jd("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a != 8) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f583a = jcVar.m461a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m463a.a != 8) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f585b = jcVar.m461a();
                        b(true);
                        break;
                    }
                default:
                    jf.a(jcVar, m463a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f584a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m380a() {
        return this.f584a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m381a(hy hyVar) {
        return hyVar != null && this.f583a == hyVar.f583a && this.f585b == hyVar.f585b;
    }

    public hy b(int i) {
        this.f585b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f582a);
        jcVar.a(a);
        jcVar.a(this.f583a);
        jcVar.b();
        jcVar.a(b);
        jcVar.a(this.f585b);
        jcVar.b();
        jcVar.c();
        jcVar.m471a();
    }

    public void b(boolean z) {
        this.f584a.set(1, z);
    }

    public boolean b() {
        return this.f584a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m381a((hy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f583a + ", pluginConfigVersion:" + this.f585b + ")";
    }
}
