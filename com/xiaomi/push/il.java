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
    public hw f739a;

    /* renamed from: a  reason: collision with other field name */
    public String f740a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f741a;

    /* renamed from: b  reason: collision with other field name */
    public String f742b;

    /* renamed from: c  reason: collision with other field name */
    public String f743c;

    /* renamed from: d  reason: collision with other field name */
    public String f744d;

    /* renamed from: e  reason: collision with other field name */
    public String f745e;

    /* renamed from: f  reason: collision with other field name */
    public String f746f;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f738a = new ji("XmPushActionSubscription");
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
            int compareTo = Boolean.valueOf(m671a()).compareTo(Boolean.valueOf(ilVar.m671a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m671a() || (a9 = it.a(this.f740a, ilVar.f740a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ilVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = it.a(this.f739a, ilVar.f739a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a7 = it.a(this.f742b, ilVar.f742b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a6 = it.a(this.f743c, ilVar.f743c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a5 = it.a(this.f744d, ilVar.f744d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a4 = it.a(this.f745e, ilVar.f745e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a3 = it.a(this.f746f, ilVar.f746f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a2 = it.a(this.f741a, ilVar.f741a)) == 0) {
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
        this.f742b = str;
        return this;
    }

    public void a() {
        if (this.f742b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f743c == null) {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f744d != null) {
        } else {
            throw new je("Required field 'topic' was not present! Struct: " + toString());
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
                a();
                return;
            }
            switch (mo696a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f740a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f739a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f742b = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f743c = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f744d = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f745e = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f746f = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        jb mo697a = jdVar.mo697a();
                        this.f741a = new ArrayList(mo697a.f815a);
                        for (int i = 0; i < mo697a.f815a; i++) {
                            this.f741a.add(jdVar.mo701a());
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
    public boolean m671a() {
        return this.f740a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m672a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m671a = m671a();
        boolean m671a2 = ilVar.m671a();
        if ((m671a || m671a2) && !(m671a && m671a2 && this.f740a.equals(ilVar.f740a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ilVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f739a.m596a(ilVar.f739a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ilVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f742b.equals(ilVar.f742b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f743c.equals(ilVar.f743c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f744d.equals(ilVar.f744d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ilVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f745e.equals(ilVar.f745e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f746f.equals(ilVar.f746f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f741a.equals(ilVar.f741a);
        }
        return true;
    }

    public il b(String str) {
        this.f743c = str;
        return this;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f738a);
        if (this.f740a != null && m671a()) {
            jdVar.a(a);
            jdVar.a(this.f740a);
            jdVar.b();
        }
        if (this.f739a != null && b()) {
            jdVar.a(b);
            this.f739a.b(jdVar);
            jdVar.b();
        }
        if (this.f742b != null) {
            jdVar.a(c);
            jdVar.a(this.f742b);
            jdVar.b();
        }
        if (this.f743c != null) {
            jdVar.a(d);
            jdVar.a(this.f743c);
            jdVar.b();
        }
        if (this.f744d != null) {
            jdVar.a(e);
            jdVar.a(this.f744d);
            jdVar.b();
        }
        if (this.f745e != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f745e);
            jdVar.b();
        }
        if (this.f746f != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f746f);
            jdVar.b();
        }
        if (this.f741a != null && h()) {
            jdVar.a(h);
            jdVar.a(new jb(Constants.GZIP_CAST_TYPE, this.f741a.size()));
            for (String str : this.f741a) {
                jdVar.a(str);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public boolean b() {
        return this.f739a != null;
    }

    public il c(String str) {
        this.f744d = str;
        return this;
    }

    public boolean c() {
        return this.f742b != null;
    }

    public il d(String str) {
        this.f745e = str;
        return this;
    }

    public boolean d() {
        return this.f743c != null;
    }

    public il e(String str) {
        this.f746f = str;
        return this;
    }

    public boolean e() {
        return this.f744d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m672a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f745e != null;
    }

    public boolean g() {
        return this.f746f != null;
    }

    public boolean h() {
        return this.f741a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = false;
        if (m671a()) {
            sb.append("debug:");
            String str = this.f740a;
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
            hw hwVar = this.f739a;
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
        String str2 = this.f742b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f743c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        String str4 = this.f744d;
        if (str4 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f745e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str6 = this.f746f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliases:");
            List<String> list = this.f741a;
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
