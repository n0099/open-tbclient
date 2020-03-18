package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ho implements ir<ho, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f479a;

    /* renamed from: a  reason: collision with other field name */
    public hi f480a;

    /* renamed from: a  reason: collision with other field name */
    public String f481a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f482a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    private static final jh f478a = new jh("DataCollectionItem");
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
            int compareTo = Boolean.valueOf(m343a()).compareTo(Boolean.valueOf(hoVar.m343a()));
            if (compareTo == 0) {
                if (!m343a() || (a4 = is.a(this.f479a, hoVar.f479a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hoVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = is.a(this.f480a, hoVar.f480a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hoVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = is.a(this.f481a, hoVar.f481a)) == 0) {
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
        this.f479a = j;
        a(true);
        return this;
    }

    public ho a(hi hiVar) {
        this.f480a = hiVar;
        return this;
    }

    public ho a(String str) {
        this.f481a = str;
        return this;
    }

    public String a() {
        return this.f481a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m342a() {
        if (this.f480a == null) {
            throw new jd("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f481a == null) {
            throw new jd("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m470a();
        while (true) {
            iz m466a = jcVar.m466a();
            if (m466a.a == 0) {
                jcVar.f();
                if (!m343a()) {
                    throw new jd("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
                }
                m342a();
                return;
            }
            switch (m466a.f788a) {
                case 1:
                    if (m466a.a != 10) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f479a = jcVar.m465a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m466a.a != 8) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f480a = hi.a(jcVar.m464a());
                        break;
                    }
                case 3:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f481a = jcVar.m471a();
                        break;
                    }
                default:
                    jf.a(jcVar, m466a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f482a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m343a() {
        return this.f482a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m344a(ho hoVar) {
        if (hoVar != null && this.f479a == hoVar.f479a) {
            boolean b2 = b();
            boolean b3 = hoVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f480a.equals(hoVar.f480a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hoVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f481a.equals(hoVar.f481a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m342a();
        jcVar.a(f478a);
        jcVar.a(a);
        jcVar.a(this.f479a);
        jcVar.b();
        if (this.f480a != null) {
            jcVar.a(b);
            jcVar.a(this.f480a.a());
            jcVar.b();
        }
        if (this.f481a != null) {
            jcVar.a(c);
            jcVar.a(this.f481a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m474a();
    }

    public boolean b() {
        return this.f480a != null;
    }

    public boolean c() {
        return this.f481a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ho)) {
            return m344a((ho) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f479a);
        sb.append(", ");
        sb.append("collectionType:");
        if (this.f480a == null) {
            sb.append("null");
        } else {
            sb.append(this.f480a);
        }
        sb.append(", ");
        sb.append("content:");
        if (this.f481a == null) {
            sb.append("null");
        } else {
            sb.append(this.f481a);
        }
        sb.append(")");
        return sb.toString();
    }
}
