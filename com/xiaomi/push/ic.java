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
    public long f615a;

    /* renamed from: a  reason: collision with other field name */
    public hw f616a;

    /* renamed from: a  reason: collision with other field name */
    public String f617a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f619a;

    /* renamed from: b  reason: collision with other field name */
    public String f621b;

    /* renamed from: c  reason: collision with other field name */
    public String f622c;

    /* renamed from: d  reason: collision with other field name */
    public String f623d;

    /* renamed from: e  reason: collision with other field name */
    public String f624e;

    /* renamed from: f  reason: collision with other field name */
    public String f625f;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f614a = new ji("XmPushActionCommandResult");
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
    public BitSet f618a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f620a = true;

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
            int compareTo = Boolean.valueOf(m630a()).compareTo(Boolean.valueOf(icVar.m630a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m630a() || (a11 = it.a(this.f616a, icVar.f616a)) == 0) {
                int compareTo2 = Boolean.valueOf(m632b()).compareTo(Boolean.valueOf(icVar.m632b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m632b() || (a10 = it.a(this.f617a, icVar.f617a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m633c()).compareTo(Boolean.valueOf(icVar.m633c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m633c() || (a9 = it.a(this.f621b, icVar.f621b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = it.a(this.f622c, icVar.f622c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = it.a(this.f615a, icVar.f615a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = it.a(this.f623d, icVar.f623d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = it.a(this.f624e, icVar.f624e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = it.a(this.f619a, icVar.f619a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = it.a(this.f625f, icVar.f625f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(icVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = it.a(this.f620a, icVar.f620a)) == 0) {
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
        return this.f617a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m628a() {
        return this.f619a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m629a() {
        if (this.f617a == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f621b == null) {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f622c != null) {
        } else {
            throw new je("Required field 'cmdName' was not present! Struct: " + toString());
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
                    m629a();
                    return;
                }
                throw new je("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo706a.f809a) {
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f616a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f617a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f621b = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f622c = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f615a = jdVar.mo705a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f623d = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f624e = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        jb mo707a = jdVar.mo707a();
                        this.f619a = new ArrayList(mo707a.f810a);
                        for (int i2 = 0; i2 < mo707a.f810a; i2++) {
                            this.f619a.add(jdVar.mo711a());
                        }
                        jdVar.i();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f625f = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f620a = jdVar.mo716a();
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
        this.f618a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m630a() {
        return this.f616a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m631a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m630a = m630a();
        boolean m630a2 = icVar.m630a();
        if ((m630a || m630a2) && !(m630a && m630a2 && this.f616a.m606a(icVar.f616a))) {
            return false;
        }
        boolean m632b = m632b();
        boolean m632b2 = icVar.m632b();
        if ((m632b || m632b2) && !(m632b && m632b2 && this.f617a.equals(icVar.f617a))) {
            return false;
        }
        boolean m633c = m633c();
        boolean m633c2 = icVar.m633c();
        if ((m633c || m633c2) && !(m633c && m633c2 && this.f621b.equals(icVar.f621b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = icVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f622c.equals(icVar.f622c))) || this.f615a != icVar.f615a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = icVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f623d.equals(icVar.f623d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = icVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f624e.equals(icVar.f624e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = icVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f619a.equals(icVar.f619a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = icVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f625f.equals(icVar.f625f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = icVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f620a == icVar.f620a;
        }
        return true;
    }

    public String b() {
        return this.f622c;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m629a();
        jdVar.a(f614a);
        if (this.f616a != null && m630a()) {
            jdVar.a(a);
            this.f616a.b(jdVar);
            jdVar.b();
        }
        if (this.f617a != null) {
            jdVar.a(b);
            jdVar.a(this.f617a);
            jdVar.b();
        }
        if (this.f621b != null) {
            jdVar.a(c);
            jdVar.a(this.f621b);
            jdVar.b();
        }
        if (this.f622c != null) {
            jdVar.a(d);
            jdVar.a(this.f622c);
            jdVar.b();
        }
        jdVar.a(e);
        jdVar.a(this.f615a);
        jdVar.b();
        if (this.f623d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f623d);
            jdVar.b();
        }
        if (this.f624e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f624e);
            jdVar.b();
        }
        if (this.f619a != null && h()) {
            jdVar.a(h);
            jdVar.a(new jb(Constants.GZIP_CAST_TYPE, this.f619a.size()));
            for (String str : this.f619a) {
                jdVar.a(str);
            }
            jdVar.e();
            jdVar.b();
        }
        if (this.f625f != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f625f);
            jdVar.b();
        }
        if (j()) {
            jdVar.a(j);
            jdVar.a(this.f620a);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public void b(boolean z) {
        this.f618a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m632b() {
        return this.f617a != null;
    }

    public String c() {
        return this.f625f;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m633c() {
        return this.f621b != null;
    }

    public boolean d() {
        return this.f622c != null;
    }

    public boolean e() {
        return this.f618a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m631a((ic) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f623d != null;
    }

    public boolean g() {
        return this.f624e != null;
    }

    public boolean h() {
        return this.f619a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f625f != null;
    }

    public boolean j() {
        return this.f618a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m630a()) {
            sb.append("target:");
            hw hwVar = this.f616a;
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
        String str = this.f617a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str2 = this.f621b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("cmdName:");
        String str3 = this.f622c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("errorCode:");
        sb.append(this.f615a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f623d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f624e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdArgs:");
            List<String> list = this.f619a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str6 = this.f625f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("response2Client:");
            sb.append(this.f620a);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
