package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class fa implements is<fa, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f352a;

    /* renamed from: a  reason: collision with other field name */
    public List<ez> f353a;

    /* renamed from: b  reason: collision with other field name */
    public String f354b;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f351a = new ji("StatsEvents");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", Constants.GZIP_CAST_TYPE, 2);
    public static final ja c = new ja("", (byte) 15, 3);

    public fa() {
    }

    public fa(String str, List<ez> list) {
        this();
        this.f352a = str;
        this.f353a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fa faVar) {
        int a2;
        int a3;
        int a4;
        if (fa.class.equals(faVar.getClass())) {
            int compareTo = Boolean.valueOf(m410a()).compareTo(Boolean.valueOf(faVar.m410a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m410a() || (a4 = it.a(this.f352a, faVar.f352a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(faVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = it.a(this.f354b, faVar.f354b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(faVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = it.a(this.f353a, faVar.f353a)) == 0) {
                        return 0;
                    }
                    return a2;
                }
                return a3;
            }
            return a4;
        }
        return fa.class.getName().compareTo(faVar.getClass().getName());
    }

    public fa a(String str) {
        this.f354b = str;
        return this;
    }

    public void a() {
        if (this.f352a == null) {
            throw new je("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f353a != null) {
        } else {
            throw new je("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo640a();
        while (true) {
            ja mo636a = jdVar.mo636a();
            byte b2 = mo636a.a;
            if (b2 == 0) {
                jdVar.f();
                a();
                return;
            }
            short s = mo636a.f813a;
            if (s == 1) {
                if (b2 == 11) {
                    this.f352a = jdVar.mo641a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 15) {
                    jb mo637a = jdVar.mo637a();
                    this.f353a = new ArrayList(mo637a.f814a);
                    for (int i = 0; i < mo637a.f814a; i++) {
                        ez ezVar = new ez();
                        ezVar.a(jdVar);
                        this.f353a.add(ezVar);
                    }
                    jdVar.i();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else {
                if (b2 == 11) {
                    this.f354b = jdVar.mo641a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m410a() {
        return this.f352a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m411a(fa faVar) {
        if (faVar == null) {
            return false;
        }
        boolean m410a = m410a();
        boolean m410a2 = faVar.m410a();
        if ((m410a || m410a2) && !(m410a && m410a2 && this.f352a.equals(faVar.f352a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = faVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f354b.equals(faVar.f354b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = faVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f353a.equals(faVar.f353a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f351a);
        if (this.f352a != null) {
            jdVar.a(a);
            jdVar.a(this.f352a);
            jdVar.b();
        }
        if (this.f354b != null && b()) {
            jdVar.a(b);
            jdVar.a(this.f354b);
            jdVar.b();
        }
        if (this.f353a != null) {
            jdVar.a(c);
            jdVar.a(new jb((byte) 12, this.f353a.size()));
            for (ez ezVar : this.f353a) {
                ezVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo644a();
    }

    public boolean b() {
        return this.f354b != null;
    }

    public boolean c() {
        return this.f353a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fa)) {
            return m411a((fa) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f352a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("operator:");
            String str2 = this.f354b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("events:");
        List<ez> list = this.f353a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
