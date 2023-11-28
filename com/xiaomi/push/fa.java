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
    public String f348a;

    /* renamed from: a  reason: collision with other field name */
    public List<ez> f349a;

    /* renamed from: b  reason: collision with other field name */
    public String f350b;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f347a = new ji("StatsEvents");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", Constants.GZIP_CAST_TYPE, 2);
    public static final ja c = new ja("", (byte) 15, 3);

    public fa() {
    }

    public fa(String str, List<ez> list) {
        this();
        this.f348a = str;
        this.f349a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fa faVar) {
        int a2;
        int a3;
        int a4;
        if (fa.class.equals(faVar.getClass())) {
            int compareTo = Boolean.valueOf(m480a()).compareTo(Boolean.valueOf(faVar.m480a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m480a() || (a4 = it.a(this.f348a, faVar.f348a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(faVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = it.a(this.f350b, faVar.f350b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(faVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = it.a(this.f349a, faVar.f349a)) == 0) {
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
        this.f350b = str;
        return this;
    }

    public void a() {
        if (this.f348a == null) {
            throw new je("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f349a != null) {
        } else {
            throw new je("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b2 = mo706a.a;
            if (b2 == 0) {
                jdVar.f();
                a();
                return;
            }
            short s = mo706a.f809a;
            if (s == 1) {
                if (b2 == 11) {
                    this.f348a = jdVar.mo711a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 15) {
                    jb mo707a = jdVar.mo707a();
                    this.f349a = new ArrayList(mo707a.f810a);
                    for (int i = 0; i < mo707a.f810a; i++) {
                        ez ezVar = new ez();
                        ezVar.a(jdVar);
                        this.f349a.add(ezVar);
                    }
                    jdVar.i();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else {
                if (b2 == 11) {
                    this.f350b = jdVar.mo711a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m480a() {
        return this.f348a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m481a(fa faVar) {
        if (faVar == null) {
            return false;
        }
        boolean m480a = m480a();
        boolean m480a2 = faVar.m480a();
        if ((m480a || m480a2) && !(m480a && m480a2 && this.f348a.equals(faVar.f348a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = faVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f350b.equals(faVar.f350b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = faVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f349a.equals(faVar.f349a);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f347a);
        if (this.f348a != null) {
            jdVar.a(a);
            jdVar.a(this.f348a);
            jdVar.b();
        }
        if (this.f350b != null && b()) {
            jdVar.a(b);
            jdVar.a(this.f350b);
            jdVar.b();
        }
        if (this.f349a != null) {
            jdVar.a(c);
            jdVar.a(new jb((byte) 12, this.f349a.size()));
            for (ez ezVar : this.f349a) {
                ezVar.b(jdVar);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public boolean b() {
        return this.f350b != null;
    }

    public boolean c() {
        return this.f349a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fa)) {
            return m481a((fa) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f348a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("operator:");
            String str2 = this.f350b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("events:");
        List<ez> list = this.f349a;
        if (list == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(list);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
