package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class hx implements iq<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f596a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f597a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f598b;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f595a = new jg("XmPushActionCheckClientInfo");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f38649a = new iy("", (byte) 8, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f38650b = new iy("", (byte) 8, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hx hxVar) {
        int a2;
        int a3;
        if (hx.class.equals(hxVar.getClass())) {
            int compareTo = Boolean.valueOf(m415a()).compareTo(Boolean.valueOf(hxVar.m415a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m415a() || (a3 = ir.a(this.f596a, hxVar.f596a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hxVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a2 = ir.a(this.f598b, hxVar.f598b)) == 0) {
                    return 0;
                }
                return a2;
            }
            return a3;
        }
        return hx.class.getName().compareTo(hxVar.getClass().getName());
    }

    public hx a(int i2) {
        this.f596a = i2;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m512a();
        while (true) {
            iy m508a = jbVar.m508a();
            byte b2 = m508a.f38795a;
            if (b2 == 0) {
                break;
            }
            short s = m508a.f807a;
            if (s != 1) {
                if (s == 2 && b2 == 8) {
                    this.f598b = jbVar.m506a();
                    b(true);
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else {
                if (b2 == 8) {
                    this.f596a = jbVar.m506a();
                    a(true);
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            }
        }
        jbVar.f();
        if (!m415a()) {
            throw new jc("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (b()) {
            a();
        } else {
            throw new jc("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        this.f597a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m415a() {
        return this.f597a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m416a(hx hxVar) {
        return hxVar != null && this.f596a == hxVar.f596a && this.f598b == hxVar.f598b;
    }

    public hx b(int i2) {
        this.f598b = i2;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        a();
        jbVar.a(f595a);
        jbVar.a(f38649a);
        jbVar.a(this.f596a);
        jbVar.b();
        jbVar.a(f38650b);
        jbVar.a(this.f598b);
        jbVar.b();
        jbVar.c();
        jbVar.m516a();
    }

    public void b(boolean z) {
        this.f597a.set(1, z);
    }

    public boolean b() {
        return this.f597a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m416a((hx) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f596a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "pluginConfigVersion:" + this.f598b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
