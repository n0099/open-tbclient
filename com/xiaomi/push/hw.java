package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class hw implements is<hw, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f553a;

    /* renamed from: d  reason: collision with other field name */
    public String f558d;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f551a = new ji("Target");
    public static final ja a = new ja("", (byte) 10, 1);
    public static final ja b = new ja("", Constants.GZIP_CAST_TYPE, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", (byte) 2, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 7);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f554a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f552a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f556b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f557c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f555a = false;

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
            int compareTo = Boolean.valueOf(m605a()).compareTo(Boolean.valueOf(hwVar.m605a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m605a() || (a7 = it.a(this.f552a, hwVar.f552a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hwVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a6 = it.a(this.f553a, hwVar.f553a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hwVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a5 = it.a(this.f556b, hwVar.f556b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hwVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a4 = it.a(this.f557c, hwVar.f557c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a3 = it.a(this.f555a, hwVar.f555a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a2 = it.a(this.f558d, hwVar.f558d)) == 0) {
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
        if (this.f553a != null) {
            return;
        }
        throw new je("Required field 'userId' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b2 = mo706a.a;
            if (b2 == 0) {
                break;
            }
            short s = mo706a.f809a;
            if (s == 1) {
                if (b2 == 10) {
                    this.f552a = jdVar.mo705a();
                    a(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s == 2) {
                if (b2 == 11) {
                    this.f553a = jdVar.mo711a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s == 3) {
                if (b2 == 11) {
                    this.f556b = jdVar.mo711a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s == 4) {
                if (b2 == 11) {
                    this.f557c = jdVar.mo711a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s != 5) {
                if (s == 7 && b2 == 11) {
                    this.f558d = jdVar.mo711a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else {
                if (b2 == 2) {
                    this.f555a = jdVar.mo716a();
                    b(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
        jdVar.f();
        if (m605a()) {
            a();
            return;
        }
        throw new je("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f554a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m605a() {
        return this.f554a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m606a(hw hwVar) {
        if (hwVar != null && this.f552a == hwVar.f552a) {
            boolean b2 = b();
            boolean b3 = hwVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f553a.equals(hwVar.f553a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hwVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f556b.equals(hwVar.f556b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hwVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f557c.equals(hwVar.f557c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hwVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f555a == hwVar.f555a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hwVar.f();
            if (f2 || f3) {
                return f2 && f3 && this.f558d.equals(hwVar.f558d);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f551a);
        jdVar.a(a);
        jdVar.a(this.f552a);
        jdVar.b();
        if (this.f553a != null) {
            jdVar.a(b);
            jdVar.a(this.f553a);
            jdVar.b();
        }
        if (this.f556b != null && c()) {
            jdVar.a(c);
            jdVar.a(this.f556b);
            jdVar.b();
        }
        if (this.f557c != null && d()) {
            jdVar.a(d);
            jdVar.a(this.f557c);
            jdVar.b();
        }
        if (e()) {
            jdVar.a(e);
            jdVar.a(this.f555a);
            jdVar.b();
        }
        if (this.f558d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f558d);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public void b(boolean z) {
        this.f554a.set(1, z);
    }

    public boolean b() {
        return this.f553a != null;
    }

    public boolean c() {
        return this.f556b != null;
    }

    public boolean d() {
        return this.f557c != null;
    }

    public boolean e() {
        return this.f554a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hw)) {
            return m606a((hw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f558d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f552a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("userId:");
        String str = this.f553a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("server:");
            String str2 = this.f556b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("resource:");
            String str3 = this.f557c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isPreview:");
            sb.append(this.f555a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("token:");
            String str4 = this.f558d;
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
