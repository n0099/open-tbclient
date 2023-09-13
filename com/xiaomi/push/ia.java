package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class ia implements is<ia, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hp> f605a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f604a = new ji("XmPushActionCollectData");
    public static final ja a = new ja("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ia iaVar) {
        int a2;
        if (ia.class.equals(iaVar.getClass())) {
            int compareTo = Boolean.valueOf(m613a()).compareTo(Boolean.valueOf(iaVar.m613a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m613a() || (a2 = it.a(this.f605a, iaVar.f605a)) == 0) {
                return 0;
            }
            return a2;
        }
        return ia.class.getName().compareTo(iaVar.getClass().getName());
    }

    public ia a(List<hp> list) {
        this.f605a = list;
        return this;
    }

    public void a() {
        if (this.f605a != null) {
            return;
        }
        throw new je("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo701a();
        while (true) {
            ja mo697a = jdVar.mo697a();
            byte b = mo697a.a;
            if (b == 0) {
                jdVar.f();
                a();
                return;
            }
            if (mo697a.f813a == 1 && b == 15) {
                jb mo698a = jdVar.mo698a();
                this.f605a = new ArrayList(mo698a.f814a);
                for (int i = 0; i < mo698a.f814a; i++) {
                    hp hpVar = new hp();
                    hpVar.a(jdVar);
                    this.f605a.add(hpVar);
                }
                jdVar.i();
            } else {
                jg.a(jdVar, b);
            }
            jdVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m613a() {
        return this.f605a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m614a(ia iaVar) {
        if (iaVar == null) {
            return false;
        }
        boolean m613a = m613a();
        boolean m613a2 = iaVar.m613a();
        if (m613a || m613a2) {
            return m613a && m613a2 && this.f605a.equals(iaVar.f605a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f604a);
        if (this.f605a != null) {
            jdVar.a(a);
            jdVar.a(new jb((byte) 12, this.f605a.size()));
            for (hp hpVar : this.f605a) {
                hpVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo705a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ia)) {
            return m614a((ia) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<hp> list = this.f605a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
