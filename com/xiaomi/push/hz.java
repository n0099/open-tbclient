package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class hz implements is<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f594a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f595a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f596b;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f593a = new ji("XmPushActionCheckClientInfo");
    public static final ja a = new ja("", (byte) 8, 1);
    public static final ja b = new ja("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
        int a2;
        int a3;
        if (hz.class.equals(hzVar.getClass())) {
            int compareTo = Boolean.valueOf(m614a()).compareTo(Boolean.valueOf(hzVar.m614a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m614a() || (a3 = it.a(this.f594a, hzVar.f594a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hzVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a2 = it.a(this.f596b, hzVar.f596b)) == 0) {
                    return 0;
                }
                return a2;
            }
            return a3;
        }
        return hz.class.getName().compareTo(hzVar.getClass().getName());
    }

    public hz a(int i) {
        this.f594a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b2 = mo706a.a;
            if (b2 == 0) {
                break;
            }
            short s = mo706a.f809a;
            if (s != 1) {
                if (s == 2 && b2 == 8) {
                    this.f596b = jdVar.mo704a();
                    b(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else {
                if (b2 == 8) {
                    this.f594a = jdVar.mo704a();
                    a(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
        jdVar.f();
        if (!m614a()) {
            throw new je("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (b()) {
            a();
        } else {
            throw new je("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        this.f595a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m614a() {
        return this.f595a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m615a(hz hzVar) {
        return hzVar != null && this.f594a == hzVar.f594a && this.f596b == hzVar.f596b;
    }

    public hz b(int i) {
        this.f596b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f593a);
        jdVar.a(a);
        jdVar.mo715a(this.f594a);
        jdVar.b();
        jdVar.a(b);
        jdVar.mo715a(this.f596b);
        jdVar.b();
        jdVar.c();
        jdVar.mo714a();
    }

    public void b(boolean z) {
        this.f595a.set(1, z);
    }

    public boolean b() {
        return this.f595a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m615a((hz) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f594a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "pluginConfigVersion:" + this.f596b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
