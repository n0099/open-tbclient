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
    public static final iy f38557a = new iy("", (byte) 15, 1);

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
            int compareTo = Boolean.valueOf(m361a()).compareTo(Boolean.valueOf(hiVar.m361a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m361a() || (a2 = ir.a(this.f475a, hiVar.f475a)) == 0) {
                return 0;
            }
            return a2;
        }
        return hi.class.getName().compareTo(hiVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m360a() {
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
        jbVar.m512a();
        while (true) {
            iy m508a = jbVar.m508a();
            byte b2 = m508a.f38795a;
            if (b2 == 0) {
                jbVar.f();
                m360a();
                return;
            }
            if (m508a.f807a == 1 && b2 == 15) {
                iz m509a = jbVar.m509a();
                this.f475a = new ArrayList(m509a.f808a);
                for (int i2 = 0; i2 < m509a.f808a; i2++) {
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
    public boolean m361a() {
        return this.f475a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m362a(hi hiVar) {
        if (hiVar == null) {
            return false;
        }
        boolean m361a = m361a();
        boolean m361a2 = hiVar.m361a();
        if (m361a || m361a2) {
            return m361a && m361a2 && this.f475a.equals(hiVar.f475a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m360a();
        jbVar.a(f474a);
        if (this.f475a != null) {
            jbVar.a(f38557a);
            jbVar.a(new iz(StandardMessageCodec.LIST, this.f475a.size()));
            for (hj hjVar : this.f475a) {
                hjVar.b(jbVar);
            }
            jbVar.e();
            jbVar.b();
        }
        jbVar.c();
        jbVar.m516a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hi)) {
            return m362a((hi) obj);
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
