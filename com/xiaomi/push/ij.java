package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class ij implements is<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f711a;

    /* renamed from: a  reason: collision with other field name */
    public hw f712a;

    /* renamed from: a  reason: collision with other field name */
    public String f713a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f714a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f715b;

    /* renamed from: c  reason: collision with other field name */
    public String f716c;

    /* renamed from: d  reason: collision with other field name */
    public String f717d;

    /* renamed from: e  reason: collision with other field name */
    public String f718e;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f710a = new ji("XmPushActionSendFeedbackResult");
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
            int compareTo = Boolean.valueOf(m670a()).compareTo(Boolean.valueOf(ijVar.m670a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m670a() || (a8 = it.a(this.f713a, ijVar.f713a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ijVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a7 = it.a(this.f712a, ijVar.f712a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ijVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a6 = it.a(this.f715b, ijVar.f715b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ijVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a5 = it.a(this.f716c, ijVar.f716c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ijVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a4 = it.a(this.f711a, ijVar.f711a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ijVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a3 = it.a(this.f717d, ijVar.f717d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a2 = it.a(this.f718e, ijVar.f718e)) == 0) {
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
        if (this.f715b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f716c != null) {
        } else {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
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
                if (e()) {
                    a();
                    return;
                }
                throw new je("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f713a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f712a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f715b = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f716c = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f711a = jdVar.mo705a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f717d = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f718e = jdVar.mo711a();
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
        this.f714a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m670a() {
        return this.f713a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m671a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m670a = m670a();
        boolean m670a2 = ijVar.m670a();
        if ((m670a || m670a2) && !(m670a && m670a2 && this.f713a.equals(ijVar.f713a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ijVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f712a.m606a(ijVar.f712a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ijVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f715b.equals(ijVar.f715b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ijVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f716c.equals(ijVar.f716c))) || this.f711a != ijVar.f711a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ijVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f717d.equals(ijVar.f717d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ijVar.g();
        if (g2 || g3) {
            return g2 && g3 && this.f718e.equals(ijVar.f718e);
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f710a);
        if (this.f713a != null && m670a()) {
            jdVar.a(a);
            jdVar.a(this.f713a);
            jdVar.b();
        }
        if (this.f712a != null && b()) {
            jdVar.a(b);
            this.f712a.b(jdVar);
            jdVar.b();
        }
        if (this.f715b != null) {
            jdVar.a(c);
            jdVar.a(this.f715b);
            jdVar.b();
        }
        if (this.f716c != null) {
            jdVar.a(d);
            jdVar.a(this.f716c);
            jdVar.b();
        }
        jdVar.a(e);
        jdVar.a(this.f711a);
        jdVar.b();
        if (this.f717d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f717d);
            jdVar.b();
        }
        if (this.f718e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f718e);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public boolean b() {
        return this.f712a != null;
    }

    public boolean c() {
        return this.f715b != null;
    }

    public boolean d() {
        return this.f716c != null;
    }

    public boolean e() {
        return this.f714a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m671a((ij) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f717d != null;
    }

    public boolean g() {
        return this.f718e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = false;
        if (m670a()) {
            sb.append("debug:");
            String str = this.f713a;
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
            hw hwVar = this.f712a;
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
        String str2 = this.f715b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f716c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("errorCode:");
        sb.append(this.f711a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f717d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str5 = this.f718e;
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
