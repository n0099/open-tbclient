package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes8.dex */
public class ic implements is<ic, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f619a;

    /* renamed from: a  reason: collision with other field name */
    public hw f620a;

    /* renamed from: a  reason: collision with other field name */
    public String f621a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f623a;

    /* renamed from: b  reason: collision with other field name */
    public String f625b;

    /* renamed from: c  reason: collision with other field name */
    public String f626c;

    /* renamed from: d  reason: collision with other field name */
    public String f627d;

    /* renamed from: e  reason: collision with other field name */
    public String f628e;

    /* renamed from: f  reason: collision with other field name */
    public String f629f;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f618a = new ji("XmPushActionCommandResult");
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
    public BitSet f622a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f624a = true;

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
            int compareTo = Boolean.valueOf(m537a()).compareTo(Boolean.valueOf(icVar.m537a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m537a() || (a11 = it.a(this.f620a, icVar.f620a)) == 0) {
                int compareTo2 = Boolean.valueOf(m539b()).compareTo(Boolean.valueOf(icVar.m539b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m539b() || (a10 = it.a(this.f621a, icVar.f621a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m540c()).compareTo(Boolean.valueOf(icVar.m540c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m540c() || (a9 = it.a(this.f625b, icVar.f625b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = it.a(this.f626c, icVar.f626c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = it.a(this.f619a, icVar.f619a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = it.a(this.f627d, icVar.f627d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = it.a(this.f628e, icVar.f628e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = it.a(this.f623a, icVar.f623a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = it.a(this.f629f, icVar.f629f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(icVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = it.a(this.f624a, icVar.f624a)) == 0) {
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
        return this.f621a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m535a() {
        return this.f623a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m536a() {
        if (this.f621a == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f625b == null) {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f626c != null) {
        } else {
            throw new je("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo617a();
        while (true) {
            ja mo613a = jdVar.mo613a();
            byte b2 = mo613a.a;
            if (b2 == 0) {
                jdVar.f();
                if (e()) {
                    m536a();
                    return;
                }
                throw new je("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo613a.f813a) {
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f620a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f621a = jdVar.mo618a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f625b = jdVar.mo618a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f626c = jdVar.mo618a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f619a = jdVar.mo612a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f627d = jdVar.mo618a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f628e = jdVar.mo618a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        jb mo614a = jdVar.mo614a();
                        this.f623a = new ArrayList(mo614a.f814a);
                        for (int i2 = 0; i2 < mo614a.f814a; i2++) {
                            this.f623a.add(jdVar.mo618a());
                        }
                        jdVar.i();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f629f = jdVar.mo618a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f624a = jdVar.mo623a();
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
        this.f622a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m537a() {
        return this.f620a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m538a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m537a = m537a();
        boolean m537a2 = icVar.m537a();
        if ((m537a || m537a2) && !(m537a && m537a2 && this.f620a.m513a(icVar.f620a))) {
            return false;
        }
        boolean m539b = m539b();
        boolean m539b2 = icVar.m539b();
        if ((m539b || m539b2) && !(m539b && m539b2 && this.f621a.equals(icVar.f621a))) {
            return false;
        }
        boolean m540c = m540c();
        boolean m540c2 = icVar.m540c();
        if ((m540c || m540c2) && !(m540c && m540c2 && this.f625b.equals(icVar.f625b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = icVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f626c.equals(icVar.f626c))) || this.f619a != icVar.f619a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = icVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f627d.equals(icVar.f627d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = icVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f628e.equals(icVar.f628e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = icVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f623a.equals(icVar.f623a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = icVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f629f.equals(icVar.f629f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = icVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f624a == icVar.f624a;
        }
        return true;
    }

    public String b() {
        return this.f626c;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m536a();
        jdVar.a(f618a);
        if (this.f620a != null && m537a()) {
            jdVar.a(a);
            this.f620a.b(jdVar);
            jdVar.b();
        }
        if (this.f621a != null) {
            jdVar.a(b);
            jdVar.a(this.f621a);
            jdVar.b();
        }
        if (this.f625b != null) {
            jdVar.a(c);
            jdVar.a(this.f625b);
            jdVar.b();
        }
        if (this.f626c != null) {
            jdVar.a(d);
            jdVar.a(this.f626c);
            jdVar.b();
        }
        jdVar.a(e);
        jdVar.a(this.f619a);
        jdVar.b();
        if (this.f627d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f627d);
            jdVar.b();
        }
        if (this.f628e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f628e);
            jdVar.b();
        }
        if (this.f623a != null && h()) {
            jdVar.a(h);
            jdVar.a(new jb(Constants.GZIP_CAST_TYPE, this.f623a.size()));
            for (String str : this.f623a) {
                jdVar.a(str);
            }
            jdVar.e();
            jdVar.b();
        }
        if (this.f629f != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f629f);
            jdVar.b();
        }
        if (j()) {
            jdVar.a(j);
            jdVar.a(this.f624a);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo621a();
    }

    public void b(boolean z) {
        this.f622a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m539b() {
        return this.f621a != null;
    }

    public String c() {
        return this.f629f;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m540c() {
        return this.f625b != null;
    }

    public boolean d() {
        return this.f626c != null;
    }

    public boolean e() {
        return this.f622a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m538a((ic) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f627d != null;
    }

    public boolean g() {
        return this.f628e != null;
    }

    public boolean h() {
        return this.f623a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f629f != null;
    }

    public boolean j() {
        return this.f622a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m537a()) {
            sb.append("target:");
            hw hwVar = this.f620a;
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
        String str = this.f621a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str2 = this.f625b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("cmdName:");
        String str3 = this.f626c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("errorCode:");
        sb.append(this.f619a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f627d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f628e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdArgs:");
            List<String> list = this.f623a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str6 = this.f629f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("response2Client:");
            sb.append(this.f624a);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
