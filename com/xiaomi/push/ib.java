package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes10.dex */
public class ib implements is<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f607a;

    /* renamed from: a  reason: collision with other field name */
    public hw f608a;

    /* renamed from: a  reason: collision with other field name */
    public String f609a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f611a;

    /* renamed from: b  reason: collision with other field name */
    public String f613b;

    /* renamed from: c  reason: collision with other field name */
    public String f615c;

    /* renamed from: d  reason: collision with other field name */
    public String f616d;

    /* renamed from: e  reason: collision with other field name */
    public String f617e;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f606a = new ji("XmPushActionCommand");
    public static final ja a = new ja("", (byte) 12, 2);
    public static final ja b = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja e = new ja("", (byte) 15, 6);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 9);
    public static final ja h = new ja("", (byte) 2, 10);
    public static final ja i = new ja("", (byte) 2, 11);
    public static final ja j = new ja("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f610a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f612a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f614b = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ib ibVar) {
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
        if (ib.class.equals(ibVar.getClass())) {
            int compareTo = Boolean.valueOf(m618a()).compareTo(Boolean.valueOf(ibVar.m618a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m618a() || (a11 = it.a(this.f608a, ibVar.f608a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ibVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a10 = it.a(this.f609a, ibVar.f609a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = it.a(this.f613b, ibVar.f613b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = it.a(this.f615c, ibVar.f615c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = it.a(this.f611a, ibVar.f611a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = it.a(this.f616d, ibVar.f616d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ibVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = it.a(this.f617e, ibVar.f617e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = it.a(this.f612a, ibVar.f612a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ibVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = it.a(this.f614b, ibVar.f614b)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ibVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = it.a(this.f607a, ibVar.f607a)) == 0) {
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
        return ib.class.getName().compareTo(ibVar.getClass().getName());
    }

    public ib a(String str) {
        this.f609a = str;
        return this;
    }

    public String a() {
        return this.f615c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m616a() {
        if (this.f609a == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f613b == null) {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f615c != null) {
        } else {
            throw new je("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo702a();
        while (true) {
            ja mo698a = jdVar.mo698a();
            byte b2 = mo698a.a;
            if (b2 == 0) {
                jdVar.f();
                m616a();
                return;
            }
            switch (mo698a.f813a) {
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f608a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f609a = jdVar.mo703a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f613b = jdVar.mo703a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f615c = jdVar.mo703a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 15) {
                        jb mo699a = jdVar.mo699a();
                        this.f611a = new ArrayList(mo699a.f814a);
                        for (int i2 = 0; i2 < mo699a.f814a; i2++) {
                            this.f611a.add(jdVar.mo703a());
                        }
                        jdVar.i();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f616d = jdVar.mo703a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f617e = jdVar.mo703a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 2) {
                        this.f612a = jdVar.mo708a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f614b = jdVar.mo708a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f607a = jdVar.mo697a();
                        c(true);
                        continue;
                        jdVar.g();
                    }
                    break;
            }
            jg.a(jdVar, b2);
            jdVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m617a(String str) {
        if (this.f611a == null) {
            this.f611a = new ArrayList();
        }
        this.f611a.add(str);
    }

    public void a(boolean z) {
        this.f610a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m618a() {
        return this.f608a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m619a(ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        boolean m618a = m618a();
        boolean m618a2 = ibVar.m618a();
        if ((m618a || m618a2) && !(m618a && m618a2 && this.f608a.m598a(ibVar.f608a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ibVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f609a.equals(ibVar.f609a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ibVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f613b.equals(ibVar.f613b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ibVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f615c.equals(ibVar.f615c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ibVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f611a.equals(ibVar.f611a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ibVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f616d.equals(ibVar.f616d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ibVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f617e.equals(ibVar.f617e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ibVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f612a == ibVar.f612a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ibVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f614b == ibVar.f614b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ibVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f607a == ibVar.f607a;
        }
        return true;
    }

    public ib b(String str) {
        this.f613b = str;
        return this;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m616a();
        jdVar.a(f606a);
        if (this.f608a != null && m618a()) {
            jdVar.a(a);
            this.f608a.b(jdVar);
            jdVar.b();
        }
        if (this.f609a != null) {
            jdVar.a(b);
            jdVar.a(this.f609a);
            jdVar.b();
        }
        if (this.f613b != null) {
            jdVar.a(c);
            jdVar.a(this.f613b);
            jdVar.b();
        }
        if (this.f615c != null) {
            jdVar.a(d);
            jdVar.a(this.f615c);
            jdVar.b();
        }
        if (this.f611a != null && e()) {
            jdVar.a(e);
            jdVar.a(new jb(Constants.GZIP_CAST_TYPE, this.f611a.size()));
            for (String str : this.f611a) {
                jdVar.a(str);
            }
            jdVar.e();
            jdVar.b();
        }
        if (this.f616d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f616d);
            jdVar.b();
        }
        if (this.f617e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f617e);
            jdVar.b();
        }
        if (h()) {
            jdVar.a(h);
            jdVar.a(this.f612a);
            jdVar.b();
        }
        if (i()) {
            jdVar.a(i);
            jdVar.a(this.f614b);
            jdVar.b();
        }
        if (j()) {
            jdVar.a(j);
            jdVar.a(this.f607a);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo706a();
    }

    public void b(boolean z) {
        this.f610a.set(1, z);
    }

    public boolean b() {
        return this.f609a != null;
    }

    public ib c(String str) {
        this.f615c = str;
        return this;
    }

    public void c(boolean z) {
        this.f610a.set(2, z);
    }

    public boolean c() {
        return this.f613b != null;
    }

    public ib d(String str) {
        this.f616d = str;
        return this;
    }

    public boolean d() {
        return this.f615c != null;
    }

    public ib e(String str) {
        this.f617e = str;
        return this;
    }

    public boolean e() {
        return this.f611a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m619a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f616d != null;
    }

    public boolean g() {
        return this.f617e != null;
    }

    public boolean h() {
        return this.f610a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f610a.get(1);
    }

    public boolean j() {
        return this.f610a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m618a()) {
            sb.append("target:");
            hw hwVar = this.f608a;
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
        String str = this.f609a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str2 = this.f613b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("cmdName:");
        String str3 = this.f615c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdArgs:");
            List<String> list = this.f611a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str4 = this.f616d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str5 = this.f617e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("updateCache:");
            sb.append(this.f612a);
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("response2Client:");
            sb.append(this.f614b);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("createdTs:");
            sb.append(this.f607a);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
