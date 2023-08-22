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
    public int f504a;

    /* renamed from: a  reason: collision with other field name */
    public hn f505a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f506a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hs> f507a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f503a = new ji("NormalConfig");
    public static final ja a = new ja("", (byte) 8, 1);
    public static final ja b = new ja("", (byte) 15, 2);
    public static final ja c = new ja("", (byte) 8, 3);

    public int a() {
        return this.f504a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hq hqVar) {
        int a2;
        int a3;
        int a4;
        if (hq.class.equals(hqVar.getClass())) {
            int compareTo = Boolean.valueOf(m567a()).compareTo(Boolean.valueOf(hqVar.m567a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m567a() || (a4 = it.a(this.f504a, hqVar.f504a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hqVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = it.a(this.f507a, hqVar.f507a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hqVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = it.a(this.f505a, hqVar.f505a)) == 0) {
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
    public hn m565a() {
        return this.f505a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m566a() {
        if (this.f507a != null) {
            return;
        }
        throw new je("Required field 'configItems' was not present! Struct: " + toString());
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
            if (s == 1) {
                if (b2 == 8) {
                    this.f504a = jdVar.mo694a();
                    a(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 8) {
                    this.f505a = hn.a(jdVar.mo694a());
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else {
                if (b2 == 15) {
                    jb mo697a = jdVar.mo697a();
                    this.f507a = new ArrayList(mo697a.f815a);
                    for (int i = 0; i < mo697a.f815a; i++) {
                        hs hsVar = new hs();
                        hsVar.a(jdVar);
                        this.f507a.add(hsVar);
                    }
                    jdVar.i();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
        jdVar.f();
        if (m567a()) {
            m566a();
            return;
        }
        throw new je("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f506a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m567a() {
        return this.f506a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m568a(hq hqVar) {
        if (hqVar != null && this.f504a == hqVar.f504a) {
            boolean b2 = b();
            boolean b3 = hqVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f507a.equals(hqVar.f507a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hqVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f505a.equals(hqVar.f505a);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m566a();
        jdVar.a(f503a);
        jdVar.a(a);
        jdVar.mo705a(this.f504a);
        jdVar.b();
        if (this.f507a != null) {
            jdVar.a(b);
            jdVar.a(new jb((byte) 12, this.f507a.size()));
            for (hs hsVar : this.f507a) {
                hsVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        if (this.f505a != null && c()) {
            jdVar.a(c);
            jdVar.mo705a(this.f505a.a());
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public boolean b() {
        return this.f507a != null;
    }

    public boolean c() {
        return this.f505a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return m568a((hq) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f504a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("configItems:");
        List<hs> list = this.f507a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("type:");
            hn hnVar = this.f505a;
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
