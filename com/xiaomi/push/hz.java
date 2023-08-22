package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class hz implements is<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f599a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f600a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f601b;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f598a = new ji("XmPushActionCheckClientInfo");
    public static final ja a = new ja("", (byte) 8, 1);
    public static final ja b = new ja("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
        int a2;
        int a3;
        if (hz.class.equals(hzVar.getClass())) {
            int compareTo = Boolean.valueOf(m604a()).compareTo(Boolean.valueOf(hzVar.m604a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m604a() || (a3 = it.a(this.f599a, hzVar.f599a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hzVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a2 = it.a(this.f601b, hzVar.f601b)) == 0) {
                    return 0;
                }
                return a2;
            }
            return a3;
        }
        return hz.class.getName().compareTo(hzVar.getClass().getName());
    }

    public hz a(int i) {
        this.f599a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b2 = mo696a.a;
            if (b2 == 0) {
                break;
            }
            short s = mo696a.f814a;
            if (s != 1) {
                if (s == 2 && b2 == 8) {
                    this.f601b = jdVar.mo694a();
                    b(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else {
                if (b2 == 8) {
                    this.f599a = jdVar.mo694a();
                    a(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
        jdVar.f();
        if (!m604a()) {
            throw new je("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (b()) {
            a();
        } else {
            throw new je("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        this.f600a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m604a() {
        return this.f600a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m605a(hz hzVar) {
        return hzVar != null && this.f599a == hzVar.f599a && this.f601b == hzVar.f601b;
    }

    public hz b(int i) {
        this.f601b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f598a);
        jdVar.a(a);
        jdVar.mo705a(this.f599a);
        jdVar.b();
        jdVar.a(b);
        jdVar.mo705a(this.f601b);
        jdVar.b();
        jdVar.c();
        jdVar.mo704a();
    }

    public void b(boolean z) {
        this.f600a.set(1, z);
    }

    public boolean b() {
        return this.f600a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m605a((hz) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f599a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "pluginConfigVersion:" + this.f601b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
