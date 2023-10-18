package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class hk implements is<hk, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hl> f477a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f476a = new ji("ClientUploadData");
    public static final ja a = new ja("", (byte) 15, 1);

    public int a() {
        List<hl> list = this.f477a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hk hkVar) {
        int a2;
        if (hk.class.equals(hkVar.getClass())) {
            int compareTo = Boolean.valueOf(m552a()).compareTo(Boolean.valueOf(hkVar.m552a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m552a() || (a2 = it.a(this.f477a, hkVar.f477a)) == 0) {
                return 0;
            }
            return a2;
        }
        return hk.class.getName().compareTo(hkVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m551a() {
        if (this.f477a != null) {
            return;
        }
        throw new je("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }

    public void a(hl hlVar) {
        if (this.f477a == null) {
            this.f477a = new ArrayList();
        }
        this.f477a.add(hlVar);
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo702a();
        while (true) {
            ja mo698a = jdVar.mo698a();
            byte b = mo698a.a;
            if (b == 0) {
                jdVar.f();
                m551a();
                return;
            }
            if (mo698a.f813a == 1 && b == 15) {
                jb mo699a = jdVar.mo699a();
                this.f477a = new ArrayList(mo699a.f814a);
                for (int i = 0; i < mo699a.f814a; i++) {
                    hl hlVar = new hl();
                    hlVar.a(jdVar);
                    this.f477a.add(hlVar);
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
        return this.f477a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m553a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m552a = m552a();
        boolean m552a2 = hkVar.m552a();
        if (m552a || m552a2) {
            return m552a && m552a2 && this.f477a.equals(hkVar.f477a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m551a();
        jdVar.a(f476a);
        if (this.f477a != null) {
            jdVar.a(a);
            jdVar.a(new jb((byte) 12, this.f477a.size()));
            for (hl hlVar : this.f477a) {
                hlVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo706a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m553a((hk) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<hl> list = this.f477a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
