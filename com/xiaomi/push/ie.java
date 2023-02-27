package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ie implements is<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hs> f641a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f640a = new ji("XmPushActionCustomConfig");
    public static final ja a = new ja("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        if (ie.class.equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m551a()).compareTo(Boolean.valueOf(ieVar.m551a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m551a() || (a2 = it.a(this.f641a, ieVar.f641a)) == 0) {
                return 0;
            }
            return a2;
        }
        return ie.class.getName().compareTo(ieVar.getClass().getName());
    }

    public List<hs> a() {
        return this.f641a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m550a() {
        if (this.f641a != null) {
            return;
        }
        throw new je("Required field 'customConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo617a();
        while (true) {
            ja mo613a = jdVar.mo613a();
            byte b = mo613a.a;
            if (b == 0) {
                jdVar.f();
                m550a();
                return;
            }
            if (mo613a.f813a == 1 && b == 15) {
                jb mo614a = jdVar.mo614a();
                this.f641a = new ArrayList(mo614a.f814a);
                for (int i = 0; i < mo614a.f814a; i++) {
                    hs hsVar = new hs();
                    hsVar.a(jdVar);
                    this.f641a.add(hsVar);
                }
                jdVar.i();
            } else {
                jg.a(jdVar, b);
            }
            jdVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m551a() {
        return this.f641a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m552a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m551a = m551a();
        boolean m551a2 = ieVar.m551a();
        if (m551a || m551a2) {
            return m551a && m551a2 && this.f641a.equals(ieVar.f641a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m550a();
        jdVar.a(f640a);
        if (this.f641a != null) {
            jdVar.a(a);
            jdVar.a(new jb((byte) 12, this.f641a.size()));
            for (hs hsVar : this.f641a) {
                hsVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo621a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m552a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<hs> list = this.f641a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
