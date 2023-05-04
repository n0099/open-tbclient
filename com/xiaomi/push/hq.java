package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes9.dex */
public class hq implements is<hq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f503a;

    /* renamed from: a  reason: collision with other field name */
    public hn f504a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f505a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hs> f506a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f502a = new ji("NormalConfig");
    public static final ja a = new ja("", (byte) 8, 1);
    public static final ja b = new ja("", (byte) 15, 2);
    public static final ja c = new ja("", (byte) 8, 3);

    public int a() {
        return this.f503a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hq hqVar) {
        int a2;
        int a3;
        int a4;
        if (hq.class.equals(hqVar.getClass())) {
            int compareTo = Boolean.valueOf(m488a()).compareTo(Boolean.valueOf(hqVar.m488a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m488a() || (a4 = it.a(this.f503a, hqVar.f503a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hqVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = it.a(this.f506a, hqVar.f506a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hqVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = it.a(this.f504a, hqVar.f504a)) == 0) {
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
    public hn m486a() {
        return this.f504a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m487a() {
        if (this.f506a != null) {
            return;
        }
        throw new je("Required field 'configItems' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo621a();
        while (true) {
            ja mo617a = jdVar.mo617a();
            byte b2 = mo617a.a;
            if (b2 == 0) {
                break;
            }
            short s = mo617a.f813a;
            if (s == 1) {
                if (b2 == 8) {
                    this.f503a = jdVar.mo615a();
                    a(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 8) {
                    this.f504a = hn.a(jdVar.mo615a());
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else {
                if (b2 == 15) {
                    jb mo618a = jdVar.mo618a();
                    this.f506a = new ArrayList(mo618a.f814a);
                    for (int i = 0; i < mo618a.f814a; i++) {
                        hs hsVar = new hs();
                        hsVar.a(jdVar);
                        this.f506a.add(hsVar);
                    }
                    jdVar.i();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
        jdVar.f();
        if (m488a()) {
            m487a();
            return;
        }
        throw new je("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f505a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m488a() {
        return this.f505a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m489a(hq hqVar) {
        if (hqVar != null && this.f503a == hqVar.f503a) {
            boolean b2 = b();
            boolean b3 = hqVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f506a.equals(hqVar.f506a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hqVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f504a.equals(hqVar.f504a);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m487a();
        jdVar.a(f502a);
        jdVar.a(a);
        jdVar.mo626a(this.f503a);
        jdVar.b();
        if (this.f506a != null) {
            jdVar.a(b);
            jdVar.a(new jb((byte) 12, this.f506a.size()));
            for (hs hsVar : this.f506a) {
                hsVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        if (this.f504a != null && c()) {
            jdVar.a(c);
            jdVar.mo626a(this.f504a.a());
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo625a();
    }

    public boolean b() {
        return this.f506a != null;
    }

    public boolean c() {
        return this.f504a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return m489a((hq) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f503a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("configItems:");
        List<hs> list = this.f506a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("type:");
            hn hnVar = this.f504a;
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
