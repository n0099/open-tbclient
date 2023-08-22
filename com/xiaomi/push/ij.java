package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class ij implements is<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f716a;

    /* renamed from: a  reason: collision with other field name */
    public hw f717a;

    /* renamed from: a  reason: collision with other field name */
    public String f718a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f719a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f720b;

    /* renamed from: c  reason: collision with other field name */
    public String f721c;

    /* renamed from: d  reason: collision with other field name */
    public String f722d;

    /* renamed from: e  reason: collision with other field name */
    public String f723e;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f715a = new ji("XmPushActionSendFeedbackResult");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", (byte) 12, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", (byte) 10, 6);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 8);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (ij.class.equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m660a()).compareTo(Boolean.valueOf(ijVar.m660a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m660a() || (a8 = it.a(this.f718a, ijVar.f718a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ijVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a7 = it.a(this.f717a, ijVar.f717a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ijVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a6 = it.a(this.f720b, ijVar.f720b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ijVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a5 = it.a(this.f721c, ijVar.f721c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ijVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a4 = it.a(this.f716a, ijVar.f716a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ijVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a3 = it.a(this.f722d, ijVar.f722d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a2 = it.a(this.f723e, ijVar.f723e)) == 0) {
                                        return 0;
                                    }
                                    return a2;
                                }
                                return a3;
                            }
                            return a4;
                        }
                        return a5;
                    }
                    return a6;
                }
                return a7;
            }
            return a8;
        }
        return ij.class.getName().compareTo(ijVar.getClass().getName());
    }

    public void a() {
        if (this.f720b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f721c != null) {
        } else {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b2 = mo696a.a;
            if (b2 == 0) {
                jdVar.f();
                if (e()) {
                    a();
                    return;
                }
                throw new je("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo696a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f718a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f717a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f720b = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f721c = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f716a = jdVar.mo695a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f722d = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f723e = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
            }
            jg.a(jdVar, b2);
            jdVar.g();
        }
    }

    public void a(boolean z) {
        this.f719a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m660a() {
        return this.f718a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m661a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m660a = m660a();
        boolean m660a2 = ijVar.m660a();
        if ((m660a || m660a2) && !(m660a && m660a2 && this.f718a.equals(ijVar.f718a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ijVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f717a.m596a(ijVar.f717a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ijVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f720b.equals(ijVar.f720b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ijVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f721c.equals(ijVar.f721c))) || this.f716a != ijVar.f716a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ijVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f722d.equals(ijVar.f722d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ijVar.g();
        if (g2 || g3) {
            return g2 && g3 && this.f723e.equals(ijVar.f723e);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f715a);
        if (this.f718a != null && m660a()) {
            jdVar.a(a);
            jdVar.a(this.f718a);
            jdVar.b();
        }
        if (this.f717a != null && b()) {
            jdVar.a(b);
            this.f717a.b(jdVar);
            jdVar.b();
        }
        if (this.f720b != null) {
            jdVar.a(c);
            jdVar.a(this.f720b);
            jdVar.b();
        }
        if (this.f721c != null) {
            jdVar.a(d);
            jdVar.a(this.f721c);
            jdVar.b();
        }
        jdVar.a(e);
        jdVar.a(this.f716a);
        jdVar.b();
        if (this.f722d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f722d);
            jdVar.b();
        }
        if (this.f723e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f723e);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public boolean b() {
        return this.f717a != null;
    }

    public boolean c() {
        return this.f720b != null;
    }

    public boolean d() {
        return this.f721c != null;
    }

    public boolean e() {
        return this.f719a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m661a((ij) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f722d != null;
    }

    public boolean g() {
        return this.f723e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = false;
        if (m660a()) {
            sb.append("debug:");
            String str = this.f718a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f717a;
            if (hwVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hwVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        sb.append("id:");
        String str2 = this.f720b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f721c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("errorCode:");
        sb.append(this.f716a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f722d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str5 = this.f723e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
