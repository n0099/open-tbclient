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
    public static final iy f40764a = new iy("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ic icVar) {
        int a2;
        if (ic.class.equals(icVar.getClass())) {
            int compareTo = Boolean.valueOf(m441a()).compareTo(Boolean.valueOf(icVar.m441a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m441a() || (a2 = ir.a(this.f638a, icVar.f638a)) == 0) {
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
    public void m440a() {
        if (this.f638a != null) {
            return;
        }
        throw new jc("Required field 'customConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m505a();
        while (true) {
            iy m501a = jbVar.m501a();
            byte b2 = m501a.f40866a;
            if (b2 == 0) {
                jbVar.f();
                m440a();
                return;
            }
            if (m501a.f807a == 1 && b2 == 15) {
                iz m502a = jbVar.m502a();
                this.f638a = new ArrayList(m502a.f808a);
                for (int i = 0; i < m502a.f808a; i++) {
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
    public boolean m441a() {
        return this.f638a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m442a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m441a = m441a();
        boolean m441a2 = icVar.m441a();
        if (m441a || m441a2) {
            return m441a && m441a2 && this.f638a.equals(icVar.f638a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m440a();
        jbVar.a(f637a);
        if (this.f638a != null) {
            jbVar.a(f40764a);
            jbVar.a(new iz(StandardMessageCodec.LIST, this.f638a.size()));
            for (hq hqVar : this.f638a) {
                hqVar.b(jbVar);
            }
            jbVar.e();
            jbVar.b();
        }
        jbVar.c();
        jbVar.m509a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m442a((ic) obj);
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
