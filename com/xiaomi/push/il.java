package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class il implements is<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hw f734a;

    /* renamed from: a  reason: collision with other field name */
    public String f735a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f736a;

    /* renamed from: b  reason: collision with other field name */
    public String f737b;

    /* renamed from: c  reason: collision with other field name */
    public String f738c;

    /* renamed from: d  reason: collision with other field name */
    public String f739d;

    /* renamed from: e  reason: collision with other field name */
    public String f740e;

    /* renamed from: f  reason: collision with other field name */
    public String f741f;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f733a = new ji("XmPushActionSubscription");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", (byte) 12, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 6);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja h = new ja("", (byte) 15, 8);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(il ilVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (il.class.equals(ilVar.getClass())) {
            int compareTo = Boolean.valueOf(m681a()).compareTo(Boolean.valueOf(ilVar.m681a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m681a() || (a9 = it.a(this.f735a, ilVar.f735a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ilVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = it.a(this.f734a, ilVar.f734a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a7 = it.a(this.f737b, ilVar.f737b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a6 = it.a(this.f738c, ilVar.f738c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a5 = it.a(this.f739d, ilVar.f739d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a4 = it.a(this.f740e, ilVar.f740e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a3 = it.a(this.f741f, ilVar.f741f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a2 = it.a(this.f736a, ilVar.f736a)) == 0) {
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
        return il.class.getName().compareTo(ilVar.getClass().getName());
    }

    public il a(String str) {
        this.f737b = str;
        return this;
    }

    public void a() {
        if (this.f737b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f738c == null) {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f739d != null) {
        } else {
            throw new je("Required field 'topic' was not present! Struct: " + toString());
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
                a();
                return;
            }
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f735a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f734a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f737b = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f738c = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f739d = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f740e = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f741f = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        jb mo707a = jdVar.mo707a();
                        this.f736a = new ArrayList(mo707a.f810a);
                        for (int i = 0; i < mo707a.f810a; i++) {
                            this.f736a.add(jdVar.mo711a());
                        }
                        jdVar.i();
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
    public boolean m681a() {
        return this.f735a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m682a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m681a = m681a();
        boolean m681a2 = ilVar.m681a();
        if ((m681a || m681a2) && !(m681a && m681a2 && this.f735a.equals(ilVar.f735a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ilVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f734a.m606a(ilVar.f734a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ilVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f737b.equals(ilVar.f737b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f738c.equals(ilVar.f738c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f739d.equals(ilVar.f739d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ilVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f740e.equals(ilVar.f740e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f741f.equals(ilVar.f741f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f736a.equals(ilVar.f736a);
        }
        return true;
    }

    public il b(String str) {
        this.f738c = str;
        return this;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f733a);
        if (this.f735a != null && m681a()) {
            jdVar.a(a);
            jdVar.a(this.f735a);
            jdVar.b();
        }
        if (this.f734a != null && b()) {
            jdVar.a(b);
            this.f734a.b(jdVar);
            jdVar.b();
        }
        if (this.f737b != null) {
            jdVar.a(c);
            jdVar.a(this.f737b);
            jdVar.b();
        }
        if (this.f738c != null) {
            jdVar.a(d);
            jdVar.a(this.f738c);
            jdVar.b();
        }
        if (this.f739d != null) {
            jdVar.a(e);
            jdVar.a(this.f739d);
            jdVar.b();
        }
        if (this.f740e != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f740e);
            jdVar.b();
        }
        if (this.f741f != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f741f);
            jdVar.b();
        }
        if (this.f736a != null && h()) {
            jdVar.a(h);
            jdVar.a(new jb(Constants.GZIP_CAST_TYPE, this.f736a.size()));
            for (String str : this.f736a) {
                jdVar.a(str);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public boolean b() {
        return this.f734a != null;
    }

    public il c(String str) {
        this.f739d = str;
        return this;
    }

    public boolean c() {
        return this.f737b != null;
    }

    public il d(String str) {
        this.f740e = str;
        return this;
    }

    public boolean d() {
        return this.f738c != null;
    }

    public il e(String str) {
        this.f741f = str;
        return this;
    }

    public boolean e() {
        return this.f739d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m682a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f740e != null;
    }

    public boolean g() {
        return this.f741f != null;
    }

    public boolean h() {
        return this.f736a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = false;
        if (m681a()) {
            sb.append("debug:");
            String str = this.f735a;
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
            hw hwVar = this.f734a;
            if (hwVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hwVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        sb.append("id:");
        String str2 = this.f737b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f738c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        String str4 = this.f739d;
        if (str4 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f740e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str6 = this.f741f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliases:");
            List<String> list = this.f736a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
