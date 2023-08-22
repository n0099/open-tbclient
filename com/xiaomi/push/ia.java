package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class ia implements is<ia, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hp> f606a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f605a = new ji("XmPushActionCollectData");
    public static final ja a = new ja("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ia iaVar) {
        int a2;
        if (ia.class.equals(iaVar.getClass())) {
            int compareTo = Boolean.valueOf(m612a()).compareTo(Boolean.valueOf(iaVar.m612a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m612a() || (a2 = it.a(this.f606a, iaVar.f606a)) == 0) {
                return 0;
            }
            return a2;
        }
        return ia.class.getName().compareTo(iaVar.getClass().getName());
    }

    public ia a(List<hp> list) {
        this.f606a = list;
        return this;
    }

    public void a() {
        if (this.f606a != null) {
            return;
        }
        throw new je("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b = mo696a.a;
            if (b == 0) {
                jdVar.f();
                a();
                return;
            }
            if (mo696a.f814a == 1 && b == 15) {
                jb mo697a = jdVar.mo697a();
                this.f606a = new ArrayList(mo697a.f815a);
                for (int i = 0; i < mo697a.f815a; i++) {
                    hp hpVar = new hp();
                    hpVar.a(jdVar);
                    this.f606a.add(hpVar);
                }
                jdVar.i();
            } else {
                jg.a(jdVar, b);
            }
            jdVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m612a() {
        return this.f606a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m613a(ia iaVar) {
        if (iaVar == null) {
            return false;
        }
        boolean m612a = m612a();
        boolean m612a2 = iaVar.m612a();
        if (m612a || m612a2) {
            return m612a && m612a2 && this.f606a.equals(iaVar.f606a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f605a);
        if (this.f606a != null) {
            jdVar.a(a);
            jdVar.a(new jb((byte) 12, this.f606a.size()));
            for (hp hpVar : this.f606a) {
                hpVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ia)) {
            return m613a((ia) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<hp> list = this.f606a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
