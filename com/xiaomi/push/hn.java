package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class hn implements iq<hn, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f496a;

    /* renamed from: a  reason: collision with other field name */
    public hh f497a;

    /* renamed from: a  reason: collision with other field name */
    public String f498a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f499a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public static final jg f495a = new jg("DataCollectionItem");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f37756a = new iy("", (byte) 10, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f37757b = new iy("", (byte) 8, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f37758c = new iy("", (byte) 11, 3);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hn hnVar) {
        int a2;
        int a3;
        int a4;
        if (hn.class.equals(hnVar.getClass())) {
            int compareTo = Boolean.valueOf(m373a()).compareTo(Boolean.valueOf(hnVar.m373a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m373a() || (a4 = ir.a(this.f496a, hnVar.f496a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hnVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = ir.a(this.f497a, hnVar.f497a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hnVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = ir.a(this.f498a, hnVar.f498a)) == 0) {
                        return 0;
                    }
                    return a2;
                }
                return a3;
            }
            return a4;
        }
        return hn.class.getName().compareTo(hnVar.getClass().getName());
    }

    public hn a(long j) {
        this.f496a = j;
        a(true);
        return this;
    }

    public hn a(hh hhVar) {
        this.f497a = hhVar;
        return this;
    }

    public hn a(String str) {
        this.f498a = str;
        return this;
    }

    public String a() {
        return this.f498a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m372a() {
        if (this.f497a == null) {
            throw new jc("Required field 'collectionType' was not present! Struct: " + toString());
        } else if (this.f498a != null) {
        } else {
            throw new jc("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m511a();
        while (true) {
            iy m507a = jbVar.m507a();
            byte b2 = m507a.f37969a;
            if (b2 == 0) {
                break;
            }
            short s = m507a.f807a;
            if (s == 1) {
                if (b2 == 10) {
                    this.f496a = jbVar.m506a();
                    a(true);
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 11) {
                    this.f498a = jbVar.m512a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else {
                if (b2 == 8) {
                    this.f497a = hh.a(jbVar.m505a());
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            }
        }
        jbVar.f();
        if (m373a()) {
            m372a();
            return;
        }
        throw new jc("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f499a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m373a() {
        return this.f499a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m374a(hn hnVar) {
        if (hnVar != null && this.f496a == hnVar.f496a) {
            boolean b2 = b();
            boolean b3 = hnVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f497a.equals(hnVar.f497a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hnVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f498a.equals(hnVar.f498a);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m372a();
        jbVar.a(f495a);
        jbVar.a(f37756a);
        jbVar.a(this.f496a);
        jbVar.b();
        if (this.f497a != null) {
            jbVar.a(f37757b);
            jbVar.a(this.f497a.a());
            jbVar.b();
        }
        if (this.f498a != null) {
            jbVar.a(f37758c);
            jbVar.a(this.f498a);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m515a();
    }

    public boolean b() {
        return this.f497a != null;
    }

    public boolean c() {
        return this.f498a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hn)) {
            return m374a((hn) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f496a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("collectionType:");
        hh hhVar = this.f497a;
        if (hhVar == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(hhVar);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("content:");
        String str = this.f498a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
