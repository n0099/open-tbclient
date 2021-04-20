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
    public static final iy f40935a = new iy("", (byte) 15, 1);

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
            int compareTo = Boolean.valueOf(m358a()).compareTo(Boolean.valueOf(hiVar.m358a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m358a() || (a2 = ir.a(this.f475a, hiVar.f475a)) == 0) {
                return 0;
            }
            return a2;
        }
        return hi.class.getName().compareTo(hiVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m357a() {
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
        jbVar.m509a();
        while (true) {
            iy m505a = jbVar.m505a();
            byte b2 = m505a.f41156a;
            if (b2 == 0) {
                jbVar.f();
                m357a();
                return;
            }
            if (m505a.f807a == 1 && b2 == 15) {
                iz m506a = jbVar.m506a();
                this.f475a = new ArrayList(m506a.f808a);
                for (int i = 0; i < m506a.f808a; i++) {
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
    public boolean m358a() {
        return this.f475a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m359a(hi hiVar) {
        if (hiVar == null) {
            return false;
        }
        boolean m358a = m358a();
        boolean m358a2 = hiVar.m358a();
        if (m358a || m358a2) {
            return m358a && m358a2 && this.f475a.equals(hiVar.f475a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m357a();
        jbVar.a(f474a);
        if (this.f475a != null) {
            jbVar.a(f40935a);
            jbVar.a(new iz(StandardMessageCodec.LIST, this.f475a.size()));
            for (hj hjVar : this.f475a) {
                hjVar.b(jbVar);
            }
            jbVar.e();
            jbVar.b();
        }
        jbVar.c();
        jbVar.m513a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hi)) {
            return m359a((hi) obj);
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
