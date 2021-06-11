package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class hi implements iq<hi, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hj> f475a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f474a = new jg("ClientUploadData");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f41410a = new iy("", (byte) 15, 1);

    public int a() {
        List<hj> list = this.f475a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hi hiVar) {
        int a2;
        if (hi.class.equals(hiVar.getClass())) {
            int compareTo = Boolean.valueOf(m359a()).compareTo(Boolean.valueOf(hiVar.m359a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m359a() || (a2 = ir.a(this.f475a, hiVar.f475a)) == 0) {
                return 0;
            }
            return a2;
        }
        return hi.class.getName().compareTo(hiVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m358a() {
        if (this.f475a != null) {
            return;
        }
        throw new jc("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }

    public void a(hj hjVar) {
        if (this.f475a == null) {
            this.f475a = new ArrayList();
        }
        this.f475a.add(hjVar);
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m510a();
        while (true) {
            iy m506a = jbVar.m506a();
            byte b2 = m506a.f41648a;
            if (b2 == 0) {
                jbVar.f();
                m358a();
                return;
            }
            if (m506a.f807a == 1 && b2 == 15) {
                iz m507a = jbVar.m507a();
                this.f475a = new ArrayList(m507a.f808a);
                for (int i2 = 0; i2 < m507a.f808a; i2++) {
                    hj hjVar = new hj();
                    hjVar.a(jbVar);
                    this.f475a.add(hjVar);
                }
                jbVar.i();
            } else {
                je.a(jbVar, b2);
            }
            jbVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m359a() {
        return this.f475a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m360a(hi hiVar) {
        if (hiVar == null) {
            return false;
        }
        boolean m359a = m359a();
        boolean m359a2 = hiVar.m359a();
        if (m359a || m359a2) {
            return m359a && m359a2 && this.f475a.equals(hiVar.f475a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m358a();
        jbVar.a(f474a);
        if (this.f475a != null) {
            jbVar.a(f41410a);
            jbVar.a(new iz(StandardMessageCodec.LIST, this.f475a.size()));
            for (hj hjVar : this.f475a) {
                hjVar.b(jbVar);
            }
            jbVar.e();
            jbVar.b();
        }
        jbVar.c();
        jbVar.m514a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hi)) {
            return m360a((hi) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<hj> list = this.f475a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
