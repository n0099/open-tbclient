package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ho implements ir<ho, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f482a;

    /* renamed from: a  reason: collision with other field name */
    public hi f483a;

    /* renamed from: a  reason: collision with other field name */
    public String f484a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f485a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    private static final jh f481a = new jh("DataCollectionItem");
    private static final iz a = new iz("", (byte) 10, 1);
    private static final iz b = new iz("", (byte) 8, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ho hoVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hoVar.getClass())) {
            int compareTo = Boolean.valueOf(m340a()).compareTo(Boolean.valueOf(hoVar.m340a()));
            if (compareTo == 0) {
                if (!m340a() || (a4 = is.a(this.f482a, hoVar.f482a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hoVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = is.a(this.f483a, hoVar.f483a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hoVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = is.a(this.f484a, hoVar.f484a)) == 0) {
                                    return 0;
                                }
                                return a2;
                            }
                            return compareTo3;
                        }
                        return a3;
                    }
                    return compareTo2;
                }
                return a4;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hoVar.getClass().getName());
    }

    public ho a(long j) {
        this.f482a = j;
        a(true);
        return this;
    }

    public ho a(hi hiVar) {
        this.f483a = hiVar;
        return this;
    }

    public ho a(String str) {
        this.f484a = str;
        return this;
    }

    public String a() {
        return this.f484a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m339a() {
        if (this.f483a == null) {
            throw new jd("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f484a == null) {
            throw new jd("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                if (!m340a()) {
                    throw new jd("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
                }
                m339a();
                return;
            }
            switch (m463a.f791a) {
                case 1:
                    if (m463a.a != 10) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f482a = jcVar.m462a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m463a.a != 8) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f483a = hi.a(jcVar.m461a());
                        break;
                    }
                case 3:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f484a = jcVar.m468a();
                        break;
                    }
                default:
                    jf.a(jcVar, m463a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f485a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m340a() {
        return this.f485a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m341a(ho hoVar) {
        if (hoVar != null && this.f482a == hoVar.f482a) {
            boolean b2 = b();
            boolean b3 = hoVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f483a.equals(hoVar.f483a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hoVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f484a.equals(hoVar.f484a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m339a();
        jcVar.a(f481a);
        jcVar.a(a);
        jcVar.a(this.f482a);
        jcVar.b();
        if (this.f483a != null) {
            jcVar.a(b);
            jcVar.a(this.f483a.a());
            jcVar.b();
        }
        if (this.f484a != null) {
            jcVar.a(c);
            jcVar.a(this.f484a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public boolean b() {
        return this.f483a != null;
    }

    public boolean c() {
        return this.f484a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ho)) {
            return m341a((ho) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f482a);
        sb.append(", ");
        sb.append("collectionType:");
        if (this.f483a == null) {
            sb.append("null");
        } else {
            sb.append(this.f483a);
        }
        sb.append(", ");
        sb.append("content:");
        if (this.f484a == null) {
            sb.append("null");
        } else {
            sb.append(this.f484a);
        }
        sb.append(")");
        return sb.toString();
    }
}
