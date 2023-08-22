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
    public long f608a;

    /* renamed from: a  reason: collision with other field name */
    public hw f609a;

    /* renamed from: a  reason: collision with other field name */
    public String f610a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f612a;

    /* renamed from: b  reason: collision with other field name */
    public String f614b;

    /* renamed from: c  reason: collision with other field name */
    public String f616c;

    /* renamed from: d  reason: collision with other field name */
    public String f617d;

    /* renamed from: e  reason: collision with other field name */
    public String f618e;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f607a = new ji("XmPushActionCommand");
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
    public BitSet f611a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f613a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f615b = true;

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
            int compareTo = Boolean.valueOf(m616a()).compareTo(Boolean.valueOf(ibVar.m616a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m616a() || (a11 = it.a(this.f609a, ibVar.f609a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ibVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a10 = it.a(this.f610a, ibVar.f610a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = it.a(this.f614b, ibVar.f614b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = it.a(this.f616c, ibVar.f616c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = it.a(this.f612a, ibVar.f612a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = it.a(this.f617d, ibVar.f617d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ibVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = it.a(this.f618e, ibVar.f618e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = it.a(this.f613a, ibVar.f613a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ibVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = it.a(this.f615b, ibVar.f615b)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ibVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = it.a(this.f608a, ibVar.f608a)) == 0) {
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
        this.f610a = str;
        return this;
    }

    public String a() {
        return this.f616c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m614a() {
        if (this.f610a == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f614b == null) {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f616c != null) {
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
                m614a();
                return;
            }
            switch (mo696a.f814a) {
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f609a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f610a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f614b = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f616c = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 15) {
                        jb mo697a = jdVar.mo697a();
                        this.f612a = new ArrayList(mo697a.f815a);
                        for (int i2 = 0; i2 < mo697a.f815a; i2++) {
                            this.f612a.add(jdVar.mo701a());
                        }
                        jdVar.i();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f617d = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f618e = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 2) {
                        this.f613a = jdVar.mo706a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f615b = jdVar.mo706a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f608a = jdVar.mo695a();
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
    public void m615a(String str) {
        if (this.f612a == null) {
            this.f612a = new ArrayList();
        }
        this.f612a.add(str);
    }

    public void a(boolean z) {
        this.f611a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m616a() {
        return this.f609a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m617a(ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        boolean m616a = m616a();
        boolean m616a2 = ibVar.m616a();
        if ((m616a || m616a2) && !(m616a && m616a2 && this.f609a.m596a(ibVar.f609a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ibVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f610a.equals(ibVar.f610a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ibVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f614b.equals(ibVar.f614b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ibVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f616c.equals(ibVar.f616c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ibVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f612a.equals(ibVar.f612a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ibVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f617d.equals(ibVar.f617d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ibVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f618e.equals(ibVar.f618e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ibVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f613a == ibVar.f613a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ibVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f615b == ibVar.f615b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ibVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f608a == ibVar.f608a;
        }
        return true;
    }

    public ib b(String str) {
        this.f614b = str;
        return this;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m614a();
        jdVar.a(f607a);
        if (this.f609a != null && m616a()) {
            jdVar.a(a);
            this.f609a.b(jdVar);
            jdVar.b();
        }
        if (this.f610a != null) {
            jdVar.a(b);
            jdVar.a(this.f610a);
            jdVar.b();
        }
        if (this.f614b != null) {
            jdVar.a(c);
            jdVar.a(this.f614b);
            jdVar.b();
        }
        if (this.f616c != null) {
            jdVar.a(d);
            jdVar.a(this.f616c);
            jdVar.b();
        }
        if (this.f612a != null && e()) {
            jdVar.a(e);
            jdVar.a(new jb(Constants.GZIP_CAST_TYPE, this.f612a.size()));
            for (String str : this.f612a) {
                jdVar.a(str);
            }
            jdVar.e();
            jdVar.b();
        }
        if (this.f617d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f617d);
            jdVar.b();
        }
        if (this.f618e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f618e);
            jdVar.b();
        }
        if (h()) {
            jdVar.a(h);
            jdVar.a(this.f613a);
            jdVar.b();
        }
        if (i()) {
            jdVar.a(i);
            jdVar.a(this.f615b);
            jdVar.b();
        }
        if (j()) {
            jdVar.a(j);
            jdVar.a(this.f608a);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public void b(boolean z) {
        this.f611a.set(1, z);
    }

    public boolean b() {
        return this.f610a != null;
    }

    public ib c(String str) {
        this.f616c = str;
        return this;
    }

    public void c(boolean z) {
        this.f611a.set(2, z);
    }

    public boolean c() {
        return this.f614b != null;
    }

    public ib d(String str) {
        this.f617d = str;
        return this;
    }

    public boolean d() {
        return this.f616c != null;
    }

    public ib e(String str) {
        this.f618e = str;
        return this;
    }

    public boolean e() {
        return this.f612a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m617a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f617d != null;
    }

    public boolean g() {
        return this.f618e != null;
    }

    public boolean h() {
        return this.f611a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f611a.get(1);
    }

    public boolean j() {
        return this.f611a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m616a()) {
            sb.append("target:");
            hw hwVar = this.f609a;
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
        String str = this.f610a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str2 = this.f614b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("cmdName:");
        String str3 = this.f616c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdArgs:");
            List<String> list = this.f612a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str4 = this.f617d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str5 = this.f618e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("updateCache:");
            sb.append(this.f613a);
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("response2Client:");
            sb.append(this.f615b);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("createdTs:");
            sb.append(this.f608a);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
