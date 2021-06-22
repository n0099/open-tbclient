package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class ih implements iq<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f710a;

    /* renamed from: a  reason: collision with other field name */
    public hu f711a;

    /* renamed from: a  reason: collision with other field name */
    public String f712a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f713a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f714b;

    /* renamed from: c  reason: collision with other field name */
    public String f715c;

    /* renamed from: d  reason: collision with other field name */
    public String f716d;

    /* renamed from: e  reason: collision with other field name */
    public String f717e;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f709a = new jg("XmPushActionSendFeedbackResult");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f41670a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f41671b = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f41672c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f41673d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f41674e = new iy("", (byte) 10, 6);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f41675f = new iy("", (byte) 11, 7);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f41676g = new iy("", (byte) 11, 8);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ih ihVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (ih.class.equals(ihVar.getClass())) {
            int compareTo = Boolean.valueOf(m470a()).compareTo(Boolean.valueOf(ihVar.m470a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m470a() || (a8 = ir.a(this.f712a, ihVar.f712a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ihVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a7 = ir.a(this.f711a, ihVar.f711a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a6 = ir.a(this.f714b, ihVar.f714b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a5 = ir.a(this.f715c, ihVar.f715c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a4 = ir.a(this.f710a, ihVar.f710a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a3 = ir.a(this.f716d, ihVar.f716d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a2 = ir.a(this.f717e, ihVar.f717e)) == 0) {
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
        return ih.class.getName().compareTo(ihVar.getClass().getName());
    }

    public void a() {
        if (this.f714b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f715c != null) {
        } else {
            throw new jc("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m510a();
        while (true) {
            iy m506a = jbVar.m506a();
            byte b2 = m506a.f41751a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m506a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f712a = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f711a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f714b = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f715c = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f710a = jbVar.m505a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f716d = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f717e = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    public void a(boolean z) {
        this.f713a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m470a() {
        return this.f712a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m471a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m470a = m470a();
        boolean m470a2 = ihVar.m470a();
        if ((m470a || m470a2) && !(m470a && m470a2 && this.f712a.equals(ihVar.f712a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ihVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f711a.m405a(ihVar.f711a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ihVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f714b.equals(ihVar.f714b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f715c.equals(ihVar.f715c))) || this.f710a != ihVar.f710a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f716d.equals(ihVar.f716d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if (g2 || g3) {
            return g2 && g3 && this.f717e.equals(ihVar.f717e);
        }
        return true;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        a();
        jbVar.a(f709a);
        if (this.f712a != null && m470a()) {
            jbVar.a(f41670a);
            jbVar.a(this.f712a);
            jbVar.b();
        }
        if (this.f711a != null && b()) {
            jbVar.a(f41671b);
            this.f711a.b(jbVar);
            jbVar.b();
        }
        if (this.f714b != null) {
            jbVar.a(f41672c);
            jbVar.a(this.f714b);
            jbVar.b();
        }
        if (this.f715c != null) {
            jbVar.a(f41673d);
            jbVar.a(this.f715c);
            jbVar.b();
        }
        jbVar.a(f41674e);
        jbVar.a(this.f710a);
        jbVar.b();
        if (this.f716d != null && f()) {
            jbVar.a(f41675f);
            jbVar.a(this.f716d);
            jbVar.b();
        }
        if (this.f717e != null && g()) {
            jbVar.a(f41676g);
            jbVar.a(this.f717e);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m514a();
    }

    public boolean b() {
        return this.f711a != null;
    }

    public boolean c() {
        return this.f714b != null;
    }

    public boolean d() {
        return this.f715c != null;
    }

    public boolean e() {
        return this.f713a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m471a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f716d != null;
    }

    public boolean g() {
        return this.f717e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = false;
        if (m470a()) {
            sb.append("debug:");
            String str = this.f712a;
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
            hu huVar = this.f711a;
            if (huVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(huVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        sb.append("id:");
        String str2 = this.f714b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f715c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("errorCode:");
        sb.append(this.f710a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f716d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str5 = this.f717e;
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
