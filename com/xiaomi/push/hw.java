package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class hw implements is<hw, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f558a;

    /* renamed from: d  reason: collision with other field name */
    public String f563d;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f556a = new ji("Target");
    public static final ja a = new ja("", (byte) 10, 1);
    public static final ja b = new ja("", Constants.GZIP_CAST_TYPE, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", (byte) 2, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 7);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f559a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f557a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f561b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f562c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f560a = false;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hw hwVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (hw.class.equals(hwVar.getClass())) {
            int compareTo = Boolean.valueOf(m595a()).compareTo(Boolean.valueOf(hwVar.m595a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m595a() || (a7 = it.a(this.f557a, hwVar.f557a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hwVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a6 = it.a(this.f558a, hwVar.f558a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hwVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a5 = it.a(this.f561b, hwVar.f561b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hwVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a4 = it.a(this.f562c, hwVar.f562c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a3 = it.a(this.f560a, hwVar.f560a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a2 = it.a(this.f563d, hwVar.f563d)) == 0) {
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
        return hw.class.getName().compareTo(hwVar.getClass().getName());
    }

    public void a() {
        if (this.f558a != null) {
            return;
        }
        throw new je("Required field 'userId' was not present! Struct: " + toString());
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
                    this.f557a = jdVar.mo695a();
                    a(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s == 2) {
                if (b2 == 11) {
                    this.f558a = jdVar.mo701a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s == 3) {
                if (b2 == 11) {
                    this.f561b = jdVar.mo701a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s == 4) {
                if (b2 == 11) {
                    this.f562c = jdVar.mo701a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s != 5) {
                if (s == 7 && b2 == 11) {
                    this.f563d = jdVar.mo701a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else {
                if (b2 == 2) {
                    this.f560a = jdVar.mo706a();
                    b(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
        jdVar.f();
        if (m595a()) {
            a();
            return;
        }
        throw new je("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f559a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m595a() {
        return this.f559a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m596a(hw hwVar) {
        if (hwVar != null && this.f557a == hwVar.f557a) {
            boolean b2 = b();
            boolean b3 = hwVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f558a.equals(hwVar.f558a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hwVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f561b.equals(hwVar.f561b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hwVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f562c.equals(hwVar.f562c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hwVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f560a == hwVar.f560a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hwVar.f();
            if (f2 || f3) {
                return f2 && f3 && this.f563d.equals(hwVar.f563d);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f556a);
        jdVar.a(a);
        jdVar.a(this.f557a);
        jdVar.b();
        if (this.f558a != null) {
            jdVar.a(b);
            jdVar.a(this.f558a);
            jdVar.b();
        }
        if (this.f561b != null && c()) {
            jdVar.a(c);
            jdVar.a(this.f561b);
            jdVar.b();
        }
        if (this.f562c != null && d()) {
            jdVar.a(d);
            jdVar.a(this.f562c);
            jdVar.b();
        }
        if (e()) {
            jdVar.a(e);
            jdVar.a(this.f560a);
            jdVar.b();
        }
        if (this.f563d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f563d);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public void b(boolean z) {
        this.f559a.set(1, z);
    }

    public boolean b() {
        return this.f558a != null;
    }

    public boolean c() {
        return this.f561b != null;
    }

    public boolean d() {
        return this.f562c != null;
    }

    public boolean e() {
        return this.f559a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hw)) {
            return m596a((hw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f563d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f557a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("userId:");
        String str = this.f558a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("server:");
            String str2 = this.f561b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("resource:");
            String str3 = this.f562c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isPreview:");
            sb.append(this.f560a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("token:");
            String str4 = this.f563d;
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
