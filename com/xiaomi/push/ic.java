package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ic implements iq<ic, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f638a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f637a = new jg("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f37930a = new iy("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ic icVar) {
        int a2;
        if (ic.class.equals(icVar.getClass())) {
            int compareTo = Boolean.valueOf(m447a()).compareTo(Boolean.valueOf(icVar.m447a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m447a() || (a2 = ir.a(this.f638a, icVar.f638a)) == 0) {
                return 0;
            }
            return a2;
        }
        return ic.class.getName().compareTo(icVar.getClass().getName());
    }

    public List<hq> a() {
        return this.f638a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m446a() {
        if (this.f638a != null) {
            return;
        }
        throw new jc("Required field 'customConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m511a();
        while (true) {
            iy m507a = jbVar.m507a();
            byte b2 = m507a.f38040a;
            if (b2 == 0) {
                jbVar.f();
                m446a();
                return;
            }
            if (m507a.f807a == 1 && b2 == 15) {
                iz m508a = jbVar.m508a();
                this.f638a = new ArrayList(m508a.f808a);
                for (int i2 = 0; i2 < m508a.f808a; i2++) {
                    hq hqVar = new hq();
                    hqVar.a(jbVar);
                    this.f638a.add(hqVar);
                }
                jbVar.i();
            } else {
                je.a(jbVar, b2);
            }
            jbVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m447a() {
        return this.f638a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m448a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m447a = m447a();
        boolean m447a2 = icVar.m447a();
        if (m447a || m447a2) {
            return m447a && m447a2 && this.f638a.equals(icVar.f638a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m446a();
        jbVar.a(f637a);
        if (this.f638a != null) {
            jbVar.a(f37930a);
            jbVar.a(new iz(StandardMessageCodec.LIST, this.f638a.size()));
            for (hq hqVar : this.f638a) {
                hqVar.b(jbVar);
            }
            jbVar.e();
            jbVar.b();
        }
        jbVar.c();
        jbVar.m515a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m448a((ic) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<hq> list = this.f638a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
