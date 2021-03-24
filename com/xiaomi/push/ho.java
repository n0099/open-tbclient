package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes7.dex */
public class ho implements iq<ho, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f501a;

    /* renamed from: a  reason: collision with other field name */
    public hl f502a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f503a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f504a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f500a = new jg("NormalConfig");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40671a = new iy("", (byte) 8, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40672b = new iy("", (byte) 15, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40673c = new iy("", (byte) 8, 3);

    public int a() {
        return this.f501a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ho hoVar) {
        int a2;
        int a3;
        int a4;
        if (ho.class.equals(hoVar.getClass())) {
            int compareTo = Boolean.valueOf(m371a()).compareTo(Boolean.valueOf(hoVar.m371a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m371a() || (a4 = ir.a(this.f501a, hoVar.f501a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hoVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = ir.a(this.f504a, hoVar.f504a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hoVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = ir.a(this.f502a, hoVar.f502a)) == 0) {
                        return 0;
                    }
                    return a2;
                }
                return a3;
            }
            return a4;
        }
        return ho.class.getName().compareTo(hoVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public hl m369a() {
        return this.f502a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m370a() {
        if (this.f504a != null) {
            return;
        }
        throw new jc("Required field 'configItems' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m505a();
        while (true) {
            iy m501a = jbVar.m501a();
            byte b2 = m501a.f40866a;
            if (b2 == 0) {
                break;
            }
            short s = m501a.f807a;
            if (s == 1) {
                if (b2 == 8) {
                    this.f501a = jbVar.m499a();
                    a(true);
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 8) {
                    this.f502a = hl.a(jbVar.m499a());
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else {
                if (b2 == 15) {
                    iz m502a = jbVar.m502a();
                    this.f504a = new ArrayList(m502a.f808a);
                    for (int i = 0; i < m502a.f808a; i++) {
                        hq hqVar = new hq();
                        hqVar.a(jbVar);
                        this.f504a.add(hqVar);
                    }
                    jbVar.i();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            }
        }
        jbVar.f();
        if (m371a()) {
            m370a();
            return;
        }
        throw new jc("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f503a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m371a() {
        return this.f503a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m372a(ho hoVar) {
        if (hoVar != null && this.f501a == hoVar.f501a) {
            boolean b2 = b();
            boolean b3 = hoVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f504a.equals(hoVar.f504a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hoVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f502a.equals(hoVar.f502a);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m370a();
        jbVar.a(f500a);
        jbVar.a(f40671a);
        jbVar.a(this.f501a);
        jbVar.b();
        if (this.f504a != null) {
            jbVar.a(f40672b);
            jbVar.a(new iz(StandardMessageCodec.LIST, this.f504a.size()));
            for (hq hqVar : this.f504a) {
                hqVar.b(jbVar);
            }
            jbVar.e();
            jbVar.b();
        }
        if (this.f502a != null && c()) {
            jbVar.a(f40673c);
            jbVar.a(this.f502a.a());
            jbVar.b();
        }
        jbVar.c();
        jbVar.m509a();
    }

    public boolean b() {
        return this.f504a != null;
    }

    public boolean c() {
        return this.f502a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ho)) {
            return m372a((ho) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f501a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("configItems:");
        List<hq> list = this.f504a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("type:");
            hl hlVar = this.f502a;
            if (hlVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hlVar);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
