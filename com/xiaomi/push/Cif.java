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
    public List<hq> f639a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f638a = new ji("XmPushActionNormalConfig");
    public static final ja a = new ja("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        if (Cif.class.equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m647a()).compareTo(Boolean.valueOf(cif.m647a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m647a() || (a2 = it.a(this.f639a, cif.f639a)) == 0) {
                return 0;
            }
            return a2;
        }
        return Cif.class.getName().compareTo(cif.getClass().getName());
    }

    public List<hq> a() {
        return this.f639a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m646a() {
        if (this.f639a != null) {
            return;
        }
        throw new je("Required field 'normalConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b = mo706a.a;
            if (b == 0) {
                jdVar.f();
                m646a();
                return;
            }
            if (mo706a.f809a == 1 && b == 15) {
                jb mo707a = jdVar.mo707a();
                this.f639a = new ArrayList(mo707a.f810a);
                for (int i = 0; i < mo707a.f810a; i++) {
                    hq hqVar = new hq();
                    hqVar.a(jdVar);
                    this.f639a.add(hqVar);
                }
                jdVar.i();
            } else {
                jg.a(jdVar, b);
            }
            jdVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m647a() {
        return this.f639a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m648a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m647a = m647a();
        boolean m647a2 = cif.m647a();
        if (m647a || m647a2) {
            return m647a && m647a2 && this.f639a.equals(cif.f639a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m646a();
        jdVar.a(f638a);
        if (this.f639a != null) {
            jdVar.a(a);
            jdVar.a(new jb((byte) 12, this.f639a.size()));
            for (hq hqVar : this.f639a) {
                hqVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m648a((Cif) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<hq> list = this.f639a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
