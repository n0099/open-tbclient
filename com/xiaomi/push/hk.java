package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class hk implements is<hk, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hl> f478a;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f477a = new ji("ClientUploadData");
    public static final ja a = new ja("", (byte) 15, 1);

    public int a() {
        List<hl> list = this.f478a;
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
            int compareTo = Boolean.valueOf(m550a()).compareTo(Boolean.valueOf(hkVar.m550a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m550a() || (a2 = it.a(this.f478a, hkVar.f478a)) == 0) {
                return 0;
            }
            return a2;
        }
        return hk.class.getName().compareTo(hkVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m549a() {
        if (this.f478a != null) {
            return;
        }
        throw new je("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }

    public void a(hl hlVar) {
        if (this.f478a == null) {
            this.f478a = new ArrayList();
        }
        this.f478a.add(hlVar);
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b = mo696a.a;
            if (b == 0) {
                jdVar.f();
                m549a();
                return;
            }
            if (mo696a.f814a == 1 && b == 15) {
                jb mo697a = jdVar.mo697a();
                this.f478a = new ArrayList(mo697a.f815a);
                for (int i = 0; i < mo697a.f815a; i++) {
                    hl hlVar = new hl();
                    hlVar.a(jdVar);
                    this.f478a.add(hlVar);
                }
                jdVar.i();
            } else {
                jg.a(jdVar, b);
            }
            jdVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m550a() {
        return this.f478a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m551a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m550a = m550a();
        boolean m550a2 = hkVar.m550a();
        if (m550a || m550a2) {
            return m550a && m550a2 && this.f478a.equals(hkVar.f478a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m549a();
        jdVar.a(f477a);
        if (this.f478a != null) {
            jdVar.a(a);
            jdVar.a(new jb((byte) 12, this.f478a.size()));
            for (hl hlVar : this.f478a) {
                hlVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m551a((hk) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<hl> list = this.f478a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
