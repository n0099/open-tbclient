package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class id implements iq<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<ho> f640a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f639a = new jg("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f38686a = new iy("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(id idVar) {
        int a2;
        if (id.class.equals(idVar.getClass())) {
            int compareTo = Boolean.valueOf(m451a()).compareTo(Boolean.valueOf(idVar.m451a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m451a() || (a2 = ir.a(this.f640a, idVar.f640a)) == 0) {
                return 0;
            }
            return a2;
        }
        return id.class.getName().compareTo(idVar.getClass().getName());
    }

    public List<ho> a() {
        return this.f640a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m450a() {
        if (this.f640a != null) {
            return;
        }
        throw new jc("Required field 'normalConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m512a();
        while (true) {
            iy m508a = jbVar.m508a();
            byte b2 = m508a.f38795a;
            if (b2 == 0) {
                jbVar.f();
                m450a();
                return;
            }
            if (m508a.f807a == 1 && b2 == 15) {
                iz m509a = jbVar.m509a();
                this.f640a = new ArrayList(m509a.f808a);
                for (int i2 = 0; i2 < m509a.f808a; i2++) {
                    ho hoVar = new ho();
                    hoVar.a(jbVar);
                    this.f640a.add(hoVar);
                }
                jbVar.i();
            } else {
                je.a(jbVar, b2);
            }
            jbVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m451a() {
        return this.f640a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m452a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m451a = m451a();
        boolean m451a2 = idVar.m451a();
        if (m451a || m451a2) {
            return m451a && m451a2 && this.f640a.equals(idVar.f640a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m450a();
        jbVar.a(f639a);
        if (this.f640a != null) {
            jbVar.a(f38686a);
            jbVar.a(new iz(StandardMessageCodec.LIST, this.f640a.size()));
            for (ho hoVar : this.f640a) {
                hoVar.b(jbVar);
            }
            jbVar.e();
            jbVar.b();
        }
        jbVar.c();
        jbVar.m516a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m452a((id) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<ho> list = this.f640a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
