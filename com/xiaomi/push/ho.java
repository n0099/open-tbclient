package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ho implements ir<ho, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f480a;

    /* renamed from: a  reason: collision with other field name */
    public hi f481a;

    /* renamed from: a  reason: collision with other field name */
    public String f482a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f483a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    private static final jh f479a = new jh("DataCollectionItem");
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
            int compareTo = Boolean.valueOf(m345a()).compareTo(Boolean.valueOf(hoVar.m345a()));
            if (compareTo == 0) {
                if (!m345a() || (a4 = is.a(this.f480a, hoVar.f480a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hoVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = is.a(this.f481a, hoVar.f481a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hoVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = is.a(this.f482a, hoVar.f482a)) == 0) {
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
        this.f480a = j;
        a(true);
        return this;
    }

    public ho a(hi hiVar) {
        this.f481a = hiVar;
        return this;
    }

    public ho a(String str) {
        this.f482a = str;
        return this;
    }

    public String a() {
        return this.f482a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m344a() {
        if (this.f481a == null) {
            throw new jd("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f482a == null) {
            throw new jd("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                if (!m345a()) {
                    throw new jd("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
                }
                m344a();
                return;
            }
            switch (m468a.f789a) {
                case 1:
                    if (m468a.a != 10) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f480a = jcVar.m467a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f481a = hi.a(jcVar.m466a());
                        break;
                    }
                case 3:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f482a = jcVar.m473a();
                        break;
                    }
                default:
                    jf.a(jcVar, m468a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f483a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m345a() {
        return this.f483a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m346a(ho hoVar) {
        if (hoVar != null && this.f480a == hoVar.f480a) {
            boolean b2 = b();
            boolean b3 = hoVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f481a.equals(hoVar.f481a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hoVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f482a.equals(hoVar.f482a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m344a();
        jcVar.a(f479a);
        jcVar.a(a);
        jcVar.a(this.f480a);
        jcVar.b();
        if (this.f481a != null) {
            jcVar.a(b);
            jcVar.a(this.f481a.a());
            jcVar.b();
        }
        if (this.f482a != null) {
            jcVar.a(c);
            jcVar.a(this.f482a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public boolean b() {
        return this.f481a != null;
    }

    public boolean c() {
        return this.f482a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ho)) {
            return m346a((ho) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f480a);
        sb.append(", ");
        sb.append("collectionType:");
        if (this.f481a == null) {
            sb.append("null");
        } else {
            sb.append(this.f481a);
        }
        sb.append(", ");
        sb.append("content:");
        if (this.f482a == null) {
            sb.append("null");
        } else {
            sb.append(this.f482a);
        }
        sb.append(")");
        return sb.toString();
    }
}
