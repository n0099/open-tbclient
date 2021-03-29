package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ey implements iq<ey, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f353a;

    /* renamed from: a  reason: collision with other field name */
    public List<ex> f354a;

    /* renamed from: b  reason: collision with other field name */
    public String f355b;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f352a = new jg("StatsEvents");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40484a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40485b = new iy("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40486c = new iy("", (byte) 15, 3);

    public ey() {
    }

    public ey(String str, List<ex> list) {
        this();
        this.f353a = str;
        this.f354a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ey eyVar) {
        int a2;
        int a3;
        int a4;
        if (ey.class.equals(eyVar.getClass())) {
            int compareTo = Boolean.valueOf(m281a()).compareTo(Boolean.valueOf(eyVar.m281a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m281a() || (a4 = ir.a(this.f353a, eyVar.f353a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(eyVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = ir.a(this.f355b, eyVar.f355b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(eyVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = ir.a(this.f354a, eyVar.f354a)) == 0) {
                        return 0;
                    }
                    return a2;
                }
                return a3;
            }
            return a4;
        }
        return ey.class.getName().compareTo(eyVar.getClass().getName());
    }

    public ey a(String str) {
        this.f355b = str;
        return this;
    }

    public void a() {
        if (this.f353a == null) {
            throw new jc("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f354a != null) {
        } else {
            throw new jc("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m505a();
        while (true) {
            iy m501a = jbVar.m501a();
            byte b2 = m501a.f40867a;
            if (b2 == 0) {
                jbVar.f();
                a();
                return;
            }
            short s = m501a.f807a;
            if (s == 1) {
                if (b2 == 11) {
                    this.f353a = jbVar.m506a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 15) {
                    iz m502a = jbVar.m502a();
                    this.f354a = new ArrayList(m502a.f808a);
                    for (int i = 0; i < m502a.f808a; i++) {
                        ex exVar = new ex();
                        exVar.a(jbVar);
                        this.f354a.add(exVar);
                    }
                    jbVar.i();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else {
                if (b2 == 11) {
                    this.f355b = jbVar.m506a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m281a() {
        return this.f353a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m282a(ey eyVar) {
        if (eyVar == null) {
            return false;
        }
        boolean m281a = m281a();
        boolean m281a2 = eyVar.m281a();
        if ((m281a || m281a2) && !(m281a && m281a2 && this.f353a.equals(eyVar.f353a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = eyVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f355b.equals(eyVar.f355b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = eyVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f354a.equals(eyVar.f354a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        a();
        jbVar.a(f352a);
        if (this.f353a != null) {
            jbVar.a(f40484a);
            jbVar.a(this.f353a);
            jbVar.b();
        }
        if (this.f355b != null && b()) {
            jbVar.a(f40485b);
            jbVar.a(this.f355b);
            jbVar.b();
        }
        if (this.f354a != null) {
            jbVar.a(f40486c);
            jbVar.a(new iz(StandardMessageCodec.LIST, this.f354a.size()));
            for (ex exVar : this.f354a) {
                exVar.b(jbVar);
            }
            jbVar.e();
            jbVar.b();
        }
        jbVar.c();
        jbVar.m509a();
    }

    public boolean b() {
        return this.f355b != null;
    }

    public boolean c() {
        return this.f354a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ey)) {
            return m282a((ey) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f353a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("operator:");
            String str2 = this.f355b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("events:");
        List<ex> list = this.f354a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
