package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes10.dex */
public class hq implements is<hq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f499a;

    /* renamed from: a  reason: collision with other field name */
    public hn f500a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f501a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hs> f502a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f498a = new ji("NormalConfig");
    public static final ja a = new ja("", (byte) 8, 1);
    public static final ja b = new ja("", (byte) 15, 2);
    public static final ja c = new ja("", (byte) 8, 3);

    public int a() {
        return this.f499a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hq hqVar) {
        int a2;
        int a3;
        int a4;
        if (hq.class.equals(hqVar.getClass())) {
            int compareTo = Boolean.valueOf(m577a()).compareTo(Boolean.valueOf(hqVar.m577a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m577a() || (a4 = it.a(this.f499a, hqVar.f499a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hqVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = it.a(this.f502a, hqVar.f502a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hqVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = it.a(this.f500a, hqVar.f500a)) == 0) {
                        return 0;
                    }
                    return a2;
                }
                return a3;
            }
            return a4;
        }
        return hq.class.getName().compareTo(hqVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public hn m575a() {
        return this.f500a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m576a() {
        if (this.f502a != null) {
            return;
        }
        throw new je("Required field 'configItems' was not present! Struct: " + toString());
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
            if (s == 1) {
                if (b2 == 8) {
                    this.f499a = jdVar.mo704a();
                    a(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 8) {
                    this.f500a = hn.a(jdVar.mo704a());
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else {
                if (b2 == 15) {
                    jb mo707a = jdVar.mo707a();
                    this.f502a = new ArrayList(mo707a.f810a);
                    for (int i = 0; i < mo707a.f810a; i++) {
                        hs hsVar = new hs();
                        hsVar.a(jdVar);
                        this.f502a.add(hsVar);
                    }
                    jdVar.i();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
        jdVar.f();
        if (m577a()) {
            m576a();
            return;
        }
        throw new je("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f501a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m577a() {
        return this.f501a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m578a(hq hqVar) {
        if (hqVar != null && this.f499a == hqVar.f499a) {
            boolean b2 = b();
            boolean b3 = hqVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f502a.equals(hqVar.f502a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hqVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f500a.equals(hqVar.f500a);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m576a();
        jdVar.a(f498a);
        jdVar.a(a);
        jdVar.mo715a(this.f499a);
        jdVar.b();
        if (this.f502a != null) {
            jdVar.a(b);
            jdVar.a(new jb((byte) 12, this.f502a.size()));
            for (hs hsVar : this.f502a) {
                hsVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        if (this.f500a != null && c()) {
            jdVar.a(c);
            jdVar.mo715a(this.f500a.a());
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public boolean b() {
        return this.f502a != null;
    }

    public boolean c() {
        return this.f500a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return m578a((hq) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f499a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("configItems:");
        List<hs> list = this.f502a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("type:");
            hn hnVar = this.f500a;
            if (hnVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hnVar);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
