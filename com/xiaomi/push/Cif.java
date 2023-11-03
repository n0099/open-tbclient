package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes10.dex */
public class Cif implements is<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f643a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f642a = new ji("XmPushActionNormalConfig");
    public static final ja a = new ja("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        if (Cif.class.equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m643a()).compareTo(Boolean.valueOf(cif.m643a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m643a() || (a2 = it.a(this.f643a, cif.f643a)) == 0) {
                return 0;
            }
            return a2;
        }
        return Cif.class.getName().compareTo(cif.getClass().getName());
    }

    public List<hq> a() {
        return this.f643a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m642a() {
        if (this.f643a != null) {
            return;
        }
        throw new je("Required field 'normalConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo706a();
        while (true) {
            ja mo702a = jdVar.mo702a();
            byte b = mo702a.a;
            if (b == 0) {
                jdVar.f();
                m642a();
                return;
            }
            if (mo702a.f813a == 1 && b == 15) {
                jb mo703a = jdVar.mo703a();
                this.f643a = new ArrayList(mo703a.f814a);
                for (int i = 0; i < mo703a.f814a; i++) {
                    hq hqVar = new hq();
                    hqVar.a(jdVar);
                    this.f643a.add(hqVar);
                }
                jdVar.i();
            } else {
                jg.a(jdVar, b);
            }
            jdVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m643a() {
        return this.f643a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m644a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m643a = m643a();
        boolean m643a2 = cif.m643a();
        if (m643a || m643a2) {
            return m643a && m643a2 && this.f643a.equals(cif.f643a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m642a();
        jdVar.a(f642a);
        if (this.f643a != null) {
            jdVar.a(a);
            jdVar.a(new jb((byte) 12, this.f643a.size()));
            for (hq hqVar : this.f643a) {
                hqVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo710a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m644a((Cif) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<hq> list = this.f643a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
