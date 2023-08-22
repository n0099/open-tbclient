package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes10.dex */
public class ic implements is<ic, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f620a;

    /* renamed from: a  reason: collision with other field name */
    public hw f621a;

    /* renamed from: a  reason: collision with other field name */
    public String f622a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f624a;

    /* renamed from: b  reason: collision with other field name */
    public String f626b;

    /* renamed from: c  reason: collision with other field name */
    public String f627c;

    /* renamed from: d  reason: collision with other field name */
    public String f628d;

    /* renamed from: e  reason: collision with other field name */
    public String f629e;

    /* renamed from: f  reason: collision with other field name */
    public String f630f;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f619a = new ji("XmPushActionCommandResult");
    public static final ja a = new ja("", (byte) 12, 2);
    public static final ja b = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja e = new ja("", (byte) 10, 7);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 8);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 9);
    public static final ja h = new ja("", (byte) 15, 10);
    public static final ja i = new ja("", Constants.GZIP_CAST_TYPE, 12);
    public static final ja j = new ja("", (byte) 2, 13);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f623a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f625a = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ic icVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        if (ic.class.equals(icVar.getClass())) {
            int compareTo = Boolean.valueOf(m620a()).compareTo(Boolean.valueOf(icVar.m620a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m620a() || (a11 = it.a(this.f621a, icVar.f621a)) == 0) {
                int compareTo2 = Boolean.valueOf(m622b()).compareTo(Boolean.valueOf(icVar.m622b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m622b() || (a10 = it.a(this.f622a, icVar.f622a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m623c()).compareTo(Boolean.valueOf(icVar.m623c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m623c() || (a9 = it.a(this.f626b, icVar.f626b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = it.a(this.f627c, icVar.f627c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = it.a(this.f620a, icVar.f620a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = it.a(this.f628d, icVar.f628d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = it.a(this.f629e, icVar.f629e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = it.a(this.f624a, icVar.f624a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = it.a(this.f630f, icVar.f630f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(icVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = it.a(this.f625a, icVar.f625a)) == 0) {
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
                    return a9;
                }
                return a10;
            }
            return a11;
        }
        return ic.class.getName().compareTo(icVar.getClass().getName());
    }

    public String a() {
        return this.f622a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m618a() {
        return this.f624a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m619a() {
        if (this.f622a == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f626b == null) {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f627c != null) {
        } else {
            throw new je("Required field 'cmdName' was not present! Struct: " + toString());
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
                    m619a();
                    return;
                }
                throw new je("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo696a.f814a) {
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f621a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f622a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f626b = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f627c = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f620a = jdVar.mo695a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f628d = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f629e = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        jb mo697a = jdVar.mo697a();
                        this.f624a = new ArrayList(mo697a.f815a);
                        for (int i2 = 0; i2 < mo697a.f815a; i2++) {
                            this.f624a.add(jdVar.mo701a());
                        }
                        jdVar.i();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f630f = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f625a = jdVar.mo706a();
                        b(true);
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
        this.f623a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m620a() {
        return this.f621a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m621a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m620a = m620a();
        boolean m620a2 = icVar.m620a();
        if ((m620a || m620a2) && !(m620a && m620a2 && this.f621a.m596a(icVar.f621a))) {
            return false;
        }
        boolean m622b = m622b();
        boolean m622b2 = icVar.m622b();
        if ((m622b || m622b2) && !(m622b && m622b2 && this.f622a.equals(icVar.f622a))) {
            return false;
        }
        boolean m623c = m623c();
        boolean m623c2 = icVar.m623c();
        if ((m623c || m623c2) && !(m623c && m623c2 && this.f626b.equals(icVar.f626b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = icVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f627c.equals(icVar.f627c))) || this.f620a != icVar.f620a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = icVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f628d.equals(icVar.f628d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = icVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f629e.equals(icVar.f629e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = icVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f624a.equals(icVar.f624a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = icVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f630f.equals(icVar.f630f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = icVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f625a == icVar.f625a;
        }
        return true;
    }

    public String b() {
        return this.f627c;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m619a();
        jdVar.a(f619a);
        if (this.f621a != null && m620a()) {
            jdVar.a(a);
            this.f621a.b(jdVar);
            jdVar.b();
        }
        if (this.f622a != null) {
            jdVar.a(b);
            jdVar.a(this.f622a);
            jdVar.b();
        }
        if (this.f626b != null) {
            jdVar.a(c);
            jdVar.a(this.f626b);
            jdVar.b();
        }
        if (this.f627c != null) {
            jdVar.a(d);
            jdVar.a(this.f627c);
            jdVar.b();
        }
        jdVar.a(e);
        jdVar.a(this.f620a);
        jdVar.b();
        if (this.f628d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f628d);
            jdVar.b();
        }
        if (this.f629e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f629e);
            jdVar.b();
        }
        if (this.f624a != null && h()) {
            jdVar.a(h);
            jdVar.a(new jb(Constants.GZIP_CAST_TYPE, this.f624a.size()));
            for (String str : this.f624a) {
                jdVar.a(str);
            }
            jdVar.e();
            jdVar.b();
        }
        if (this.f630f != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f630f);
            jdVar.b();
        }
        if (j()) {
            jdVar.a(j);
            jdVar.a(this.f625a);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public void b(boolean z) {
        this.f623a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m622b() {
        return this.f622a != null;
    }

    public String c() {
        return this.f630f;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m623c() {
        return this.f626b != null;
    }

    public boolean d() {
        return this.f627c != null;
    }

    public boolean e() {
        return this.f623a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m621a((ic) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f628d != null;
    }

    public boolean g() {
        return this.f629e != null;
    }

    public boolean h() {
        return this.f624a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f630f != null;
    }

    public boolean j() {
        return this.f623a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m620a()) {
            sb.append("target:");
            hw hwVar = this.f621a;
            if (hwVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hwVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        sb.append("id:");
        String str = this.f622a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str2 = this.f626b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("cmdName:");
        String str3 = this.f627c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("errorCode:");
        sb.append(this.f620a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f628d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f629e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdArgs:");
            List<String> list = this.f624a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str6 = this.f630f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("response2Client:");
            sb.append(this.f625a);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
