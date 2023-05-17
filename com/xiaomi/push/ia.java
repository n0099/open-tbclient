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
            int compareTo = Boolean.valueOf(m552a()).compareTo(Boolean.valueOf(iaVar.m552a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m552a() || (a2 = it.a(this.f605a, iaVar.f605a)) == 0) {
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
        jdVar.mo640a();
        while (true) {
            ja mo636a = jdVar.mo636a();
            byte b = mo636a.a;
            if (b == 0) {
                jdVar.f();
                a();
                return;
            }
            if (mo636a.f813a == 1 && b == 15) {
                jb mo637a = jdVar.mo637a();
                this.f605a = new ArrayList(mo637a.f814a);
                for (int i = 0; i < mo637a.f814a; i++) {
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
    public boolean m552a() {
        return this.f605a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m553a(ia iaVar) {
        if (iaVar == null) {
            return false;
        }
        boolean m552a = m552a();
        boolean m552a2 = iaVar.m552a();
        if (m552a || m552a2) {
            return m552a && m552a2 && this.f605a.equals(iaVar.f605a);
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
        jdVar.mo644a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ia)) {
            return m553a((ia) obj);
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
