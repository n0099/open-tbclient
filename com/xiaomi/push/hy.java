package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class hy implements iq<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hn> f600a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f599a = new jg("XmPushActionCollectData");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f41504a = new iy("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hy hyVar) {
        int a2;
        if (hy.class.equals(hyVar.getClass())) {
            int compareTo = Boolean.valueOf(m415a()).compareTo(Boolean.valueOf(hyVar.m415a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m415a() || (a2 = ir.a(this.f600a, hyVar.f600a)) == 0) {
                return 0;
            }
            return a2;
        }
        return hy.class.getName().compareTo(hyVar.getClass().getName());
    }

    public hy a(List<hn> list) {
        this.f600a = list;
        return this;
    }

    public void a() {
        if (this.f600a != null) {
            return;
        }
        throw new jc("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m510a();
        while (true) {
            iy m506a = jbVar.m506a();
            byte b2 = m506a.f41648a;
            if (b2 == 0) {
                jbVar.f();
                a();
                return;
            }
            if (m506a.f807a == 1 && b2 == 15) {
                iz m507a = jbVar.m507a();
                this.f600a = new ArrayList(m507a.f808a);
                for (int i2 = 0; i2 < m507a.f808a; i2++) {
                    hn hnVar = new hn();
                    hnVar.a(jbVar);
                    this.f600a.add(hnVar);
                }
                jbVar.i();
            } else {
                je.a(jbVar, b2);
            }
            jbVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m415a() {
        return this.f600a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m416a(hy hyVar) {
        if (hyVar == null) {
            return false;
        }
        boolean m415a = m415a();
        boolean m415a2 = hyVar.m415a();
        if (m415a || m415a2) {
            return m415a && m415a2 && this.f600a.equals(hyVar.f600a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        a();
        jbVar.a(f599a);
        if (this.f600a != null) {
            jbVar.a(f41504a);
            jbVar.a(new iz(StandardMessageCodec.LIST, this.f600a.size()));
            for (hn hnVar : this.f600a) {
                hnVar.b(jbVar);
            }
            jbVar.e();
            jbVar.b();
        }
        jbVar.c();
        jbVar.m514a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m416a((hy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<hn> list = this.f600a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
