package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class id implements is<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hh f631a;

    /* renamed from: a  reason: collision with other field name */
    public hu f632a;

    /* renamed from: a  reason: collision with other field name */
    public hw f633a;

    /* renamed from: a  reason: collision with other field name */
    public String f634a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f635a;

    /* renamed from: b  reason: collision with other field name */
    public String f638b;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f630a = new ji("XmPushActionContainer");
    public static final ja a = new ja("", (byte) 8, 1);
    public static final ja b = new ja("", (byte) 2, 2);
    public static final ja c = new ja("", (byte) 2, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 6);
    public static final ja g = new ja("", (byte) 12, 7);
    public static final ja h = new ja("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f636a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f637a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f639b = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(id idVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (id.class.equals(idVar.getClass())) {
            int compareTo = Boolean.valueOf(m623a()).compareTo(Boolean.valueOf(idVar.m623a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m623a() || (a9 = it.a(this.f631a, idVar.f631a)) == 0) {
                int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!c() || (a8 = it.a(this.f637a, idVar.f637a)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a7 = it.a(this.f639b, idVar.f639b)) == 0) {
                        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!e() || (a6 = it.a(this.f635a, idVar.f635a)) == 0) {
                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!f() || (a5 = it.a(this.f634a, idVar.f634a)) == 0) {
                                int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!g() || (a4 = it.a(this.f638b, idVar.f638b)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a3 = it.a(this.f633a, idVar.f633a)) == 0) {
                                        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!i() || (a2 = it.a(this.f632a, idVar.f632a)) == 0) {
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
        return id.class.getName().compareTo(idVar.getClass().getName());
    }

    public hh a() {
        return this.f631a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hu m619a() {
        return this.f632a;
    }

    public id a(hh hhVar) {
        this.f631a = hhVar;
        return this;
    }

    public id a(hu huVar) {
        this.f632a = huVar;
        return this;
    }

    public id a(hw hwVar) {
        this.f633a = hwVar;
        return this;
    }

    public id a(String str) {
        this.f634a = str;
        return this;
    }

    public id a(ByteBuffer byteBuffer) {
        this.f635a = byteBuffer;
        return this;
    }

    public id a(boolean z) {
        this.f637a = z;
        m622a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m620a() {
        return this.f634a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m621a() {
        if (this.f631a == null) {
            throw new je("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f635a == null) {
            throw new je("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f633a != null) {
        } else {
            throw new je("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo695a();
        while (true) {
            ja mo691a = jdVar.mo691a();
            byte b2 = mo691a.a;
            if (b2 == 0) {
                jdVar.f();
                if (!c()) {
                    throw new je("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m621a();
                    return;
                } else {
                    throw new je("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (mo691a.f813a) {
                case 1:
                    if (b2 == 8) {
                        this.f631a = hh.a(jdVar.mo689a());
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f637a = jdVar.mo701a();
                        m622a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f639b = jdVar.mo701a();
                        m626b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f635a = jdVar.mo697a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f634a = jdVar.mo696a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f638b = jdVar.mo696a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f633a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f632a = huVar;
                        huVar.a(jdVar);
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
    public void m622a(boolean z) {
        this.f636a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m623a() {
        return this.f631a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m624a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m623a = m623a();
        boolean m623a2 = idVar.m623a();
        if (((!m623a && !m623a2) || (m623a && m623a2 && this.f631a.equals(idVar.f631a))) && this.f637a == idVar.f637a && this.f639b == idVar.f639b) {
            boolean e2 = e();
            boolean e3 = idVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f635a.equals(idVar.f635a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = idVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f634a.equals(idVar.f634a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = idVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f638b.equals(idVar.f638b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = idVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f633a.m591a(idVar.f633a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = idVar.i();
            if (i || i2) {
                return i && i2 && this.f632a.m583a(idVar.f632a);
            }
            return true;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m625a() {
        a(it.a(this.f635a));
        return this.f635a.array();
    }

    public id b(String str) {
        this.f638b = str;
        return this;
    }

    public id b(boolean z) {
        this.f639b = z;
        m626b(true);
        return this;
    }

    public String b() {
        return this.f638b;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m621a();
        jdVar.a(f630a);
        if (this.f631a != null) {
            jdVar.a(a);
            jdVar.mo700a(this.f631a.a());
            jdVar.b();
        }
        jdVar.a(b);
        jdVar.a(this.f637a);
        jdVar.b();
        jdVar.a(c);
        jdVar.a(this.f639b);
        jdVar.b();
        if (this.f635a != null) {
            jdVar.a(d);
            jdVar.a(this.f635a);
            jdVar.b();
        }
        if (this.f634a != null && f()) {
            jdVar.a(e);
            jdVar.a(this.f634a);
            jdVar.b();
        }
        if (this.f638b != null && g()) {
            jdVar.a(f);
            jdVar.a(this.f638b);
            jdVar.b();
        }
        if (this.f633a != null) {
            jdVar.a(g);
            this.f633a.b(jdVar);
            jdVar.b();
        }
        if (this.f632a != null && i()) {
            jdVar.a(h);
            this.f632a.b(jdVar);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo699a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m626b(boolean z) {
        this.f636a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m627b() {
        return this.f637a;
    }

    public boolean c() {
        return this.f636a.get(0);
    }

    public boolean d() {
        return this.f636a.get(1);
    }

    public boolean e() {
        return this.f635a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m624a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f634a != null;
    }

    public boolean g() {
        return this.f638b != null;
    }

    public boolean h() {
        return this.f633a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f632a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        hh hhVar = this.f631a;
        if (hhVar == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(hhVar);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("encryptAction:");
        sb.append(this.f637a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("isRequest:");
        sb.append(this.f639b);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appid:");
            String str = this.f634a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str2 = this.f638b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("target:");
        hw hwVar = this.f633a;
        if (hwVar == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(hwVar);
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("metaInfo:");
            hu huVar = this.f632a;
            if (huVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(huVar);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
