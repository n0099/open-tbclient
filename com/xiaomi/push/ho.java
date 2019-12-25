package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class ho implements ir<ho, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f484a;

    /* renamed from: a  reason: collision with other field name */
    public hi f485a;

    /* renamed from: a  reason: collision with other field name */
    public String f486a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f487a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    private static final jh f483a = new jh("DataCollectionItem");
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
            int compareTo = Boolean.valueOf(m331a()).compareTo(Boolean.valueOf(hoVar.m331a()));
            if (compareTo == 0) {
                if (!m331a() || (a4 = is.a(this.f484a, hoVar.f484a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hoVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = is.a(this.f485a, hoVar.f485a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hoVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = is.a(this.f486a, hoVar.f486a)) == 0) {
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
        this.f484a = j;
        a(true);
        return this;
    }

    public ho a(hi hiVar) {
        this.f485a = hiVar;
        return this;
    }

    public ho a(String str) {
        this.f486a = str;
        return this;
    }

    public String a() {
        return this.f486a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m330a() {
        if (this.f485a == null) {
            throw new jd("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f486a == null) {
            throw new jd("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                if (!m331a()) {
                    throw new jd("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
                }
                m330a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f484a = jcVar.m453a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m454a.a != 8) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f485a = hi.a(jcVar.m452a());
                        break;
                    }
                case 3:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f486a = jcVar.m459a();
                        break;
                    }
                default:
                    jf.a(jcVar, m454a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f487a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m331a() {
        return this.f487a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m332a(ho hoVar) {
        if (hoVar != null && this.f484a == hoVar.f484a) {
            boolean b2 = b();
            boolean b3 = hoVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f485a.equals(hoVar.f485a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hoVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f486a.equals(hoVar.f486a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m330a();
        jcVar.a(f483a);
        jcVar.a(a);
        jcVar.a(this.f484a);
        jcVar.b();
        if (this.f485a != null) {
            jcVar.a(b);
            jcVar.a(this.f485a.a());
            jcVar.b();
        }
        if (this.f486a != null) {
            jcVar.a(c);
            jcVar.a(this.f486a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public boolean b() {
        return this.f485a != null;
    }

    public boolean c() {
        return this.f486a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ho)) {
            return m332a((ho) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f484a);
        sb.append(", ");
        sb.append("collectionType:");
        if (this.f485a == null) {
            sb.append("null");
        } else {
            sb.append(this.f485a);
        }
        sb.append(", ");
        sb.append("content:");
        if (this.f486a == null) {
            sb.append("null");
        } else {
            sb.append(this.f486a);
        }
        sb.append(")");
        return sb.toString();
    }
}
