package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class hk implements is<hk, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hl> f473a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f472a = new ji("ClientUploadData");
    public static final ja a = new ja("", (byte) 15, 1);

    public int a() {
        List<hl> list = this.f473a;
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
            int compareTo = Boolean.valueOf(m560a()).compareTo(Boolean.valueOf(hkVar.m560a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m560a() || (a2 = it.a(this.f473a, hkVar.f473a)) == 0) {
                return 0;
            }
            return a2;
        }
        return hk.class.getName().compareTo(hkVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m559a() {
        if (this.f473a != null) {
            return;
        }
        throw new je("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }

    public void a(hl hlVar) {
        if (this.f473a == null) {
            this.f473a = new ArrayList();
        }
        this.f473a.add(hlVar);
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b = mo706a.a;
            if (b == 0) {
                jdVar.f();
                m559a();
                return;
            }
            if (mo706a.f809a == 1 && b == 15) {
                jb mo707a = jdVar.mo707a();
                this.f473a = new ArrayList(mo707a.f810a);
                for (int i = 0; i < mo707a.f810a; i++) {
                    hl hlVar = new hl();
                    hlVar.a(jdVar);
                    this.f473a.add(hlVar);
                }
                jdVar.i();
            } else {
                jg.a(jdVar, b);
            }
            jdVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m560a() {
        return this.f473a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m561a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m560a = m560a();
        boolean m560a2 = hkVar.m560a();
        if (m560a || m560a2) {
            return m560a && m560a2 && this.f473a.equals(hkVar.f473a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m559a();
        jdVar.a(f472a);
        if (this.f473a != null) {
            jdVar.a(a);
            jdVar.a(new jb((byte) 12, this.f473a.size()));
            for (hl hlVar : this.f473a) {
                hlVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m561a((hk) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<hl> list = this.f473a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
