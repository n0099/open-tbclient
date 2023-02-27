package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
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
            int compareTo = Boolean.valueOf(m467a()).compareTo(Boolean.valueOf(hkVar.m467a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m467a() || (a2 = it.a(this.f477a, hkVar.f477a)) == 0) {
                return 0;
            }
            return a2;
        }
        return hk.class.getName().compareTo(hkVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m466a() {
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
        jdVar.mo617a();
        while (true) {
            ja mo613a = jdVar.mo613a();
            byte b = mo613a.a;
            if (b == 0) {
                jdVar.f();
                m466a();
                return;
            }
            if (mo613a.f813a == 1 && b == 15) {
                jb mo614a = jdVar.mo614a();
                this.f477a = new ArrayList(mo614a.f814a);
                for (int i = 0; i < mo614a.f814a; i++) {
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
    public boolean m467a() {
        return this.f477a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m468a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m467a = m467a();
        boolean m467a2 = hkVar.m467a();
        if (m467a || m467a2) {
            return m467a && m467a2 && this.f477a.equals(hkVar.f477a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m466a();
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
        jdVar.mo621a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m468a((hk) obj);
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
