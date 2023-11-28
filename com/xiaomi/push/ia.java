package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class ia implements is<ia, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hp> f601a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f600a = new ji("XmPushActionCollectData");
    public static final ja a = new ja("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ia iaVar) {
        int a2;
        if (ia.class.equals(iaVar.getClass())) {
            int compareTo = Boolean.valueOf(m622a()).compareTo(Boolean.valueOf(iaVar.m622a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m622a() || (a2 = it.a(this.f601a, iaVar.f601a)) == 0) {
                return 0;
            }
            return a2;
        }
        return ia.class.getName().compareTo(iaVar.getClass().getName());
    }

    public ia a(List<hp> list) {
        this.f601a = list;
        return this;
    }

    public void a() {
        if (this.f601a != null) {
            return;
        }
        throw new je("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b = mo706a.a;
            if (b == 0) {
                jdVar.f();
                a();
                return;
            }
            if (mo706a.f809a == 1 && b == 15) {
                jb mo707a = jdVar.mo707a();
                this.f601a = new ArrayList(mo707a.f810a);
                for (int i = 0; i < mo707a.f810a; i++) {
                    hp hpVar = new hp();
                    hpVar.a(jdVar);
                    this.f601a.add(hpVar);
                }
                jdVar.i();
            } else {
                jg.a(jdVar, b);
            }
            jdVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m622a() {
        return this.f601a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m623a(ia iaVar) {
        if (iaVar == null) {
            return false;
        }
        boolean m622a = m622a();
        boolean m622a2 = iaVar.m622a();
        if (m622a || m622a2) {
            return m622a && m622a2 && this.f601a.equals(iaVar.f601a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f600a);
        if (this.f601a != null) {
            jdVar.a(a);
            jdVar.a(new jb((byte) 12, this.f601a.size()));
            for (hp hpVar : this.f601a) {
                hpVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ia)) {
            return m623a((ia) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<hp> list = this.f601a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
