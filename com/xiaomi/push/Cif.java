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
    public List<hq> f644a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f643a = new ji("XmPushActionNormalConfig");
    public static final ja a = new ja("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        if (Cif.class.equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m637a()).compareTo(Boolean.valueOf(cif.m637a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m637a() || (a2 = it.a(this.f644a, cif.f644a)) == 0) {
                return 0;
            }
            return a2;
        }
        return Cif.class.getName().compareTo(cif.getClass().getName());
    }

    public List<hq> a() {
        return this.f644a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m636a() {
        if (this.f644a != null) {
            return;
        }
        throw new je("Required field 'normalConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b = mo696a.a;
            if (b == 0) {
                jdVar.f();
                m636a();
                return;
            }
            if (mo696a.f814a == 1 && b == 15) {
                jb mo697a = jdVar.mo697a();
                this.f644a = new ArrayList(mo697a.f815a);
                for (int i = 0; i < mo697a.f815a; i++) {
                    hq hqVar = new hq();
                    hqVar.a(jdVar);
                    this.f644a.add(hqVar);
                }
                jdVar.i();
            } else {
                jg.a(jdVar, b);
            }
            jdVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m637a() {
        return this.f644a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m638a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m637a = m637a();
        boolean m637a2 = cif.m637a();
        if (m637a || m637a2) {
            return m637a && m637a2 && this.f644a.equals(cif.f644a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m636a();
        jdVar.a(f643a);
        if (this.f644a != null) {
            jdVar.a(a);
            jdVar.a(new jb((byte) 12, this.f644a.size()));
            for (hq hqVar : this.f644a) {
                hqVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m638a((Cif) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<hq> list = this.f644a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
