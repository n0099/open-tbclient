package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class hw implements is<hw, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f557a;

    /* renamed from: d  reason: collision with other field name */
    public String f562d;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f555a = new ji("Target");
    public static final ja a = new ja("", (byte) 10, 1);
    public static final ja b = new ja("", Constants.GZIP_CAST_TYPE, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", (byte) 2, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 7);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f558a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f556a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f560b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f561c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f559a = false;

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
            int compareTo = Boolean.valueOf(m597a()).compareTo(Boolean.valueOf(hwVar.m597a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m597a() || (a7 = it.a(this.f556a, hwVar.f556a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hwVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a6 = it.a(this.f557a, hwVar.f557a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hwVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a5 = it.a(this.f560b, hwVar.f560b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hwVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a4 = it.a(this.f561c, hwVar.f561c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a3 = it.a(this.f559a, hwVar.f559a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a2 = it.a(this.f562d, hwVar.f562d)) == 0) {
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
        if (this.f557a != null) {
            return;
        }
        throw new je("Required field 'userId' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo702a();
        while (true) {
            ja mo698a = jdVar.mo698a();
            byte b2 = mo698a.a;
            if (b2 == 0) {
                break;
            }
            short s = mo698a.f813a;
            if (s == 1) {
                if (b2 == 10) {
                    this.f556a = jdVar.mo697a();
                    a(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s == 2) {
                if (b2 == 11) {
                    this.f557a = jdVar.mo703a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s == 3) {
                if (b2 == 11) {
                    this.f560b = jdVar.mo703a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s == 4) {
                if (b2 == 11) {
                    this.f561c = jdVar.mo703a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s != 5) {
                if (s == 7 && b2 == 11) {
                    this.f562d = jdVar.mo703a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else {
                if (b2 == 2) {
                    this.f559a = jdVar.mo708a();
                    b(true);
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
        jdVar.f();
        if (m597a()) {
            a();
            return;
        }
        throw new je("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f558a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m597a() {
        return this.f558a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m598a(hw hwVar) {
        if (hwVar != null && this.f556a == hwVar.f556a) {
            boolean b2 = b();
            boolean b3 = hwVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f557a.equals(hwVar.f557a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hwVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f560b.equals(hwVar.f560b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hwVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f561c.equals(hwVar.f561c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hwVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f559a == hwVar.f559a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hwVar.f();
            if (f2 || f3) {
                return f2 && f3 && this.f562d.equals(hwVar.f562d);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f555a);
        jdVar.a(a);
        jdVar.a(this.f556a);
        jdVar.b();
        if (this.f557a != null) {
            jdVar.a(b);
            jdVar.a(this.f557a);
            jdVar.b();
        }
        if (this.f560b != null && c()) {
            jdVar.a(c);
            jdVar.a(this.f560b);
            jdVar.b();
        }
        if (this.f561c != null && d()) {
            jdVar.a(d);
            jdVar.a(this.f561c);
            jdVar.b();
        }
        if (e()) {
            jdVar.a(e);
            jdVar.a(this.f559a);
            jdVar.b();
        }
        if (this.f562d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f562d);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo706a();
    }

    public void b(boolean z) {
        this.f558a.set(1, z);
    }

    public boolean b() {
        return this.f557a != null;
    }

    public boolean c() {
        return this.f560b != null;
    }

    public boolean d() {
        return this.f561c != null;
    }

    public boolean e() {
        return this.f558a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hw)) {
            return m598a((hw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f562d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f556a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("userId:");
        String str = this.f557a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("server:");
            String str2 = this.f560b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("resource:");
            String str3 = this.f561c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isPreview:");
            sb.append(this.f559a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("token:");
            String str4 = this.f562d;
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
