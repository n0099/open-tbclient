package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class hy implements ir<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f579a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f580a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f581b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f578a = new jh("XmPushActionCheckClientInfo");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hy hyVar) {
        int a2;
        int a3;
        if (getClass().equals(hyVar.getClass())) {
            int compareTo = Boolean.valueOf(m383a()).compareTo(Boolean.valueOf(hyVar.m383a()));
            if (compareTo == 0) {
                if (!m383a() || (a3 = is.a(this.f579a, hyVar.f579a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hyVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = is.a(this.f581b, hyVar.f581b)) == 0) {
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
        this.f579a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m470a();
        while (true) {
            iz m466a = jcVar.m466a();
            if (m466a.a == 0) {
                jcVar.f();
                if (!m383a()) {
                    throw new jd("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jd("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m466a.f788a) {
                case 1:
                    if (m466a.a != 8) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f579a = jcVar.m464a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m466a.a != 8) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f581b = jcVar.m464a();
                        b(true);
                        break;
                    }
                default:
                    jf.a(jcVar, m466a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f580a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m383a() {
        return this.f580a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m384a(hy hyVar) {
        return hyVar != null && this.f579a == hyVar.f579a && this.f581b == hyVar.f581b;
    }

    public hy b(int i) {
        this.f581b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f578a);
        jcVar.a(a);
        jcVar.a(this.f579a);
        jcVar.b();
        jcVar.a(b);
        jcVar.a(this.f581b);
        jcVar.b();
        jcVar.c();
        jcVar.m474a();
    }

    public void b(boolean z) {
        this.f580a.set(1, z);
    }

    public boolean b() {
        return this.f580a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m384a((hy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f579a + ", pluginConfigVersion:" + this.f581b + ")";
    }
}
