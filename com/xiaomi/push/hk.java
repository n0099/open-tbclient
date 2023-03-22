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
            int compareTo = Boolean.valueOf(m469a()).compareTo(Boolean.valueOf(hkVar.m469a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m469a() || (a2 = it.a(this.f477a, hkVar.f477a)) == 0) {
                return 0;
            }
            return a2;
        }
        return hk.class.getName().compareTo(hkVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m468a() {
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
        jdVar.mo619a();
        while (true) {
            ja mo615a = jdVar.mo615a();
            byte b = mo615a.a;
            if (b == 0) {
                jdVar.f();
                m468a();
                return;
            }
            if (mo615a.f813a == 1 && b == 15) {
                jb mo616a = jdVar.mo616a();
                this.f477a = new ArrayList(mo616a.f814a);
                for (int i = 0; i < mo616a.f814a; i++) {
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
    public boolean m469a() {
        return this.f477a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m470a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m469a = m469a();
        boolean m469a2 = hkVar.m469a();
        if (m469a || m469a2) {
            return m469a && m469a2 && this.f477a.equals(hkVar.f477a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m468a();
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
        jdVar.mo623a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m470a((hk) obj);
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
