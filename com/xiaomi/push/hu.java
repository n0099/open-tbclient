package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class hu implements iq<hu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f555a;

    /* renamed from: d  reason: collision with other field name */
    public String f560d;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f553a = new jg("Target");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f37870a = new iy("", (byte) 10, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f37871b = new iy("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f37872c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f37873d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f37874e = new iy("", (byte) 2, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f37875f = new iy("", (byte) 11, 7);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f556a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f554a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f558b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f559c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f557a = false;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hu huVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (hu.class.equals(huVar.getClass())) {
            int compareTo = Boolean.valueOf(m405a()).compareTo(Boolean.valueOf(huVar.m405a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m405a() || (a7 = ir.a(this.f554a, huVar.f554a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(huVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a6 = ir.a(this.f555a, huVar.f555a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(huVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a5 = ir.a(this.f558b, huVar.f558b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(huVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a4 = ir.a(this.f559c, huVar.f559c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(huVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a3 = ir.a(this.f557a, huVar.f557a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(huVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a2 = ir.a(this.f560d, huVar.f560d)) == 0) {
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
        return hu.class.getName().compareTo(huVar.getClass().getName());
    }

    public void a() {
        if (this.f555a != null) {
            return;
        }
        throw new jc("Required field 'userId' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m511a();
        while (true) {
            iy m507a = jbVar.m507a();
            byte b2 = m507a.f38040a;
            if (b2 == 0) {
                break;
            }
            short s = m507a.f807a;
            if (s == 1) {
                if (b2 == 10) {
                    this.f554a = jbVar.m506a();
                    a(true);
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else if (s == 2) {
                if (b2 == 11) {
                    this.f555a = jbVar.m512a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else if (s == 3) {
                if (b2 == 11) {
                    this.f558b = jbVar.m512a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else if (s == 4) {
                if (b2 == 11) {
                    this.f559c = jbVar.m512a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else if (s != 5) {
                if (s == 7 && b2 == 11) {
                    this.f560d = jbVar.m512a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else {
                if (b2 == 2) {
                    this.f557a = jbVar.m516a();
                    b(true);
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            }
        }
        jbVar.f();
        if (m405a()) {
            a();
            return;
        }
        throw new jc("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f556a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m405a() {
        return this.f556a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m406a(hu huVar) {
        if (huVar != null && this.f554a == huVar.f554a) {
            boolean b2 = b();
            boolean b3 = huVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f555a.equals(huVar.f555a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = huVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f558b.equals(huVar.f558b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = huVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f559c.equals(huVar.f559c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = huVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f557a == huVar.f557a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = huVar.f();
            if (f2 || f3) {
                return f2 && f3 && this.f560d.equals(huVar.f560d);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        a();
        jbVar.a(f553a);
        jbVar.a(f37870a);
        jbVar.a(this.f554a);
        jbVar.b();
        if (this.f555a != null) {
            jbVar.a(f37871b);
            jbVar.a(this.f555a);
            jbVar.b();
        }
        if (this.f558b != null && c()) {
            jbVar.a(f37872c);
            jbVar.a(this.f558b);
            jbVar.b();
        }
        if (this.f559c != null && d()) {
            jbVar.a(f37873d);
            jbVar.a(this.f559c);
            jbVar.b();
        }
        if (e()) {
            jbVar.a(f37874e);
            jbVar.a(this.f557a);
            jbVar.b();
        }
        if (this.f560d != null && f()) {
            jbVar.a(f37875f);
            jbVar.a(this.f560d);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m515a();
    }

    public void b(boolean z) {
        this.f556a.set(1, z);
    }

    public boolean b() {
        return this.f555a != null;
    }

    public boolean c() {
        return this.f558b != null;
    }

    public boolean d() {
        return this.f559c != null;
    }

    public boolean e() {
        return this.f556a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return m406a((hu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f560d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f554a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("userId:");
        String str = this.f555a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("server:");
            String str2 = this.f558b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("resource:");
            String str3 = this.f559c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isPreview:");
            sb.append(this.f557a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("token:");
            String str4 = this.f560d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
