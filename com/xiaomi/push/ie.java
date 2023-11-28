package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class ie implements is<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hs> f637a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f636a = new ji("XmPushActionCustomConfig");
    public static final ja a = new ja("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        if (ie.class.equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m644a()).compareTo(Boolean.valueOf(ieVar.m644a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m644a() || (a2 = it.a(this.f637a, ieVar.f637a)) == 0) {
                return 0;
            }
            return a2;
        }
        return ie.class.getName().compareTo(ieVar.getClass().getName());
    }

    public List<hs> a() {
        return this.f637a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m643a() {
        if (this.f637a != null) {
            return;
        }
        throw new je("Required field 'customConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b = mo706a.a;
            if (b == 0) {
                jdVar.f();
                m643a();
                return;
            }
            if (mo706a.f809a == 1 && b == 15) {
                jb mo707a = jdVar.mo707a();
                this.f637a = new ArrayList(mo707a.f810a);
                for (int i = 0; i < mo707a.f810a; i++) {
                    hs hsVar = new hs();
                    hsVar.a(jdVar);
                    this.f637a.add(hsVar);
                }
                jdVar.i();
            } else {
                jg.a(jdVar, b);
            }
            jdVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m644a() {
        return this.f637a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m645a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m644a = m644a();
        boolean m644a2 = ieVar.m644a();
        if (m644a || m644a2) {
            return m644a && m644a2 && this.f637a.equals(ieVar.f637a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m643a();
        jdVar.a(f636a);
        if (this.f637a != null) {
            jdVar.a(a);
            jdVar.a(new jb((byte) 12, this.f637a.size()));
            for (hs hsVar : this.f637a) {
                hsVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m645a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<hs> list = this.f637a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
