package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class hp implements is<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f499a;

    /* renamed from: a  reason: collision with other field name */
    public hj f500a;

    /* renamed from: a  reason: collision with other field name */
    public String f501a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f502a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public static final ji f498a = new ji("DataCollectionItem");
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
            int compareTo = Boolean.valueOf(m563a()).compareTo(Boolean.valueOf(hpVar.m563a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m563a() || (a4 = it.a(this.f499a, hpVar.f499a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hpVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = it.a(this.f500a, hpVar.f500a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hpVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = it.a(this.f501a, hpVar.f501a)) == 0) {
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
        this.f499a = j;
        a(true);
        return this;
    }

    public hp a(hj hjVar) {
        this.f500a = hjVar;
        return this;
    }

    public hp a(String str) {
        this.f501a = str;
        return this;
    }

    public String a() {
        return this.f501a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m562a() {
        if (this.f500a == null) {
            throw new je("Required field 'collectionType' was not present! Struct: " + toString());
        } else if (this.f501a != null) {
        } else {
            throw new je("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b2 = mo696a.a;
            if (b2 == 0) {
                break;
            }
            short s = mo696a.f814a;
            if (s == 1) {
                if (b2 == 10) {
                    this.f499a = jdVar.mo695a();
                    a(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 11) {
                    this.f501a = jdVar.mo701a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else {
                if (b2 == 8) {
                    this.f500a = hj.a(jdVar.mo694a());
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
        jdVar.f();
        if (m563a()) {
            m562a();
            return;
        }
        throw new je("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f502a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m563a() {
        return this.f502a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m564a(hp hpVar) {
        if (hpVar != null && this.f499a == hpVar.f499a) {
            boolean b2 = b();
            boolean b3 = hpVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f500a.equals(hpVar.f500a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hpVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f501a.equals(hpVar.f501a);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m562a();
        jdVar.a(f498a);
        jdVar.a(a);
        jdVar.a(this.f499a);
        jdVar.b();
        if (this.f500a != null) {
            jdVar.a(b);
            jdVar.mo705a(this.f500a.a());
            jdVar.b();
        }
        if (this.f501a != null) {
            jdVar.a(c);
            jdVar.a(this.f501a);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public boolean b() {
        return this.f500a != null;
    }

    public boolean c() {
        return this.f501a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m564a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f499a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("collectionType:");
        hj hjVar = this.f500a;
        if (hjVar == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(hjVar);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("content:");
        String str = this.f501a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
