package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class ie implements is<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hs> f642a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f641a = new ji("XmPushActionCustomConfig");
    public static final ja a = new ja("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        if (ie.class.equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m634a()).compareTo(Boolean.valueOf(ieVar.m634a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m634a() || (a2 = it.a(this.f642a, ieVar.f642a)) == 0) {
                return 0;
            }
            return a2;
        }
        return ie.class.getName().compareTo(ieVar.getClass().getName());
    }

    public List<hs> a() {
        return this.f642a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m633a() {
        if (this.f642a != null) {
            return;
        }
        throw new je("Required field 'customConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b = mo696a.a;
            if (b == 0) {
                jdVar.f();
                m633a();
                return;
            }
            if (mo696a.f814a == 1 && b == 15) {
                jb mo697a = jdVar.mo697a();
                this.f642a = new ArrayList(mo697a.f815a);
                for (int i = 0; i < mo697a.f815a; i++) {
                    hs hsVar = new hs();
                    hsVar.a(jdVar);
                    this.f642a.add(hsVar);
                }
                jdVar.i();
            } else {
                jg.a(jdVar, b);
            }
            jdVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m634a() {
        return this.f642a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m635a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m634a = m634a();
        boolean m634a2 = ieVar.m634a();
        if (m634a || m634a2) {
            return m634a && m634a2 && this.f642a.equals(ieVar.f642a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m633a();
        jdVar.a(f641a);
        if (this.f642a != null) {
            jdVar.a(a);
            jdVar.a(new jb((byte) 12, this.f642a.size()));
            for (hs hsVar : this.f642a) {
                hsVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m635a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<hs> list = this.f642a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
