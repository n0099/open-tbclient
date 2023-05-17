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
            int compareTo = Boolean.valueOf(m577a()).compareTo(Boolean.valueOf(cif.m577a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m577a() || (a2 = it.a(this.f643a, cif.f643a)) == 0) {
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
    public void m576a() {
        if (this.f643a != null) {
            return;
        }
        throw new je("Required field 'normalConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo640a();
        while (true) {
            ja mo636a = jdVar.mo636a();
            byte b = mo636a.a;
            if (b == 0) {
                jdVar.f();
                m576a();
                return;
            }
            if (mo636a.f813a == 1 && b == 15) {
                jb mo637a = jdVar.mo637a();
                this.f643a = new ArrayList(mo637a.f814a);
                for (int i = 0; i < mo637a.f814a; i++) {
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
    public boolean m577a() {
        return this.f643a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m578a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m577a = m577a();
        boolean m577a2 = cif.m577a();
        if (m577a || m577a2) {
            return m577a && m577a2 && this.f643a.equals(cif.f643a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m576a();
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
        jdVar.mo644a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m578a((Cif) obj);
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
