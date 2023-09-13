package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
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
            int compareTo = Boolean.valueOf(m635a()).compareTo(Boolean.valueOf(ieVar.m635a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m635a() || (a2 = it.a(this.f641a, ieVar.f641a)) == 0) {
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
    public void m634a() {
        if (this.f641a != null) {
            return;
        }
        throw new je("Required field 'customConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo701a();
        while (true) {
            ja mo697a = jdVar.mo697a();
            byte b = mo697a.a;
            if (b == 0) {
                jdVar.f();
                m634a();
                return;
            }
            if (mo697a.f813a == 1 && b == 15) {
                jb mo698a = jdVar.mo698a();
                this.f641a = new ArrayList(mo698a.f814a);
                for (int i = 0; i < mo698a.f814a; i++) {
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
    public boolean m635a() {
        return this.f641a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m636a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m635a = m635a();
        boolean m635a2 = ieVar.m635a();
        if (m635a || m635a2) {
            return m635a && m635a2 && this.f641a.equals(ieVar.f641a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m634a();
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
        jdVar.mo705a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m636a((ie) obj);
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
