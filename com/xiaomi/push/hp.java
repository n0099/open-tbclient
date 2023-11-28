package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class hp implements is<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f494a;

    /* renamed from: a  reason: collision with other field name */
    public hj f495a;

    /* renamed from: a  reason: collision with other field name */
    public String f496a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f497a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public static final ji f493a = new ji("DataCollectionItem");
    public static final ja a = new ja("", (byte) 10, 1);
    public static final ja b = new ja("", (byte) 8, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        int a3;
        int a4;
        if (hp.class.equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m573a()).compareTo(Boolean.valueOf(hpVar.m573a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m573a() || (a4 = it.a(this.f494a, hpVar.f494a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hpVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = it.a(this.f495a, hpVar.f495a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hpVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = it.a(this.f496a, hpVar.f496a)) == 0) {
                        return 0;
                    }
                    return a2;
                }
                return a3;
            }
            return a4;
        }
        return hp.class.getName().compareTo(hpVar.getClass().getName());
    }

    public hp a(long j) {
        this.f494a = j;
        a(true);
        return this;
    }

    public hp a(hj hjVar) {
        this.f495a = hjVar;
        return this;
    }

    public hp a(String str) {
        this.f496a = str;
        return this;
    }

    public String a() {
        return this.f496a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m572a() {
        if (this.f495a == null) {
            throw new je("Required field 'collectionType' was not present! Struct: " + toString());
        } else if (this.f496a != null) {
        } else {
            throw new je("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b2 = mo706a.a;
            if (b2 == 0) {
                break;
            }
            short s = mo706a.f809a;
            if (s == 1) {
                if (b2 == 10) {
                    this.f494a = jdVar.mo705a();
                    a(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 11) {
                    this.f496a = jdVar.mo711a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else {
                if (b2 == 8) {
                    this.f495a = hj.a(jdVar.mo704a());
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
        jdVar.f();
        if (m573a()) {
            m572a();
            return;
        }
        throw new je("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f497a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m573a() {
        return this.f497a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m574a(hp hpVar) {
        if (hpVar != null && this.f494a == hpVar.f494a) {
            boolean b2 = b();
            boolean b3 = hpVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f495a.equals(hpVar.f495a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hpVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f496a.equals(hpVar.f496a);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m572a();
        jdVar.a(f493a);
        jdVar.a(a);
        jdVar.a(this.f494a);
        jdVar.b();
        if (this.f495a != null) {
            jdVar.a(b);
            jdVar.mo715a(this.f495a.a());
            jdVar.b();
        }
        if (this.f496a != null) {
            jdVar.a(c);
            jdVar.a(this.f496a);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public boolean b() {
        return this.f495a != null;
    }

    public boolean c() {
        return this.f496a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m574a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f494a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("collectionType:");
        hj hjVar = this.f495a;
        if (hjVar == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(hjVar);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("content:");
        String str = this.f496a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
