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
    public hh f632a;

    /* renamed from: a  reason: collision with other field name */
    public hu f633a;

    /* renamed from: a  reason: collision with other field name */
    public hw f634a;

    /* renamed from: a  reason: collision with other field name */
    public String f635a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f636a;

    /* renamed from: b  reason: collision with other field name */
    public String f639b;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f631a = new ji("XmPushActionContainer");
    public static final ja a = new ja("", (byte) 8, 1);
    public static final ja b = new ja("", (byte) 2, 2);
    public static final ja c = new ja("", (byte) 2, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 6);
    public static final ja g = new ja("", (byte) 12, 7);
    public static final ja h = new ja("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f637a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f638a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f640b = true;

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
            int compareTo = Boolean.valueOf(m628a()).compareTo(Boolean.valueOf(idVar.m628a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m628a() || (a9 = it.a(this.f632a, idVar.f632a)) == 0) {
                int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!c() || (a8 = it.a(this.f638a, idVar.f638a)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a7 = it.a(this.f640b, idVar.f640b)) == 0) {
                        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!e() || (a6 = it.a(this.f636a, idVar.f636a)) == 0) {
                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!f() || (a5 = it.a(this.f635a, idVar.f635a)) == 0) {
                                int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!g() || (a4 = it.a(this.f639b, idVar.f639b)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a3 = it.a(this.f634a, idVar.f634a)) == 0) {
                                        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!i() || (a2 = it.a(this.f633a, idVar.f633a)) == 0) {
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
        return this.f632a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hu m624a() {
        return this.f633a;
    }

    public id a(hh hhVar) {
        this.f632a = hhVar;
        return this;
    }

    public id a(hu huVar) {
        this.f633a = huVar;
        return this;
    }

    public id a(hw hwVar) {
        this.f634a = hwVar;
        return this;
    }

    public id a(String str) {
        this.f635a = str;
        return this;
    }

    public id a(ByteBuffer byteBuffer) {
        this.f636a = byteBuffer;
        return this;
    }

    public id a(boolean z) {
        this.f638a = z;
        m627a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m625a() {
        return this.f635a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m626a() {
        if (this.f632a == null) {
            throw new je("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f636a == null) {
            throw new je("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f634a != null) {
        } else {
            throw new je("Required field 'target' was not present! Struct: " + toString());
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
                if (!c()) {
                    throw new je("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m626a();
                    return;
                } else {
                    throw new je("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (mo696a.f814a) {
                case 1:
                    if (b2 == 8) {
                        this.f632a = hh.a(jdVar.mo694a());
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f638a = jdVar.mo706a();
                        m627a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f640b = jdVar.mo706a();
                        m631b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f636a = jdVar.mo702a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f635a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f639b = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f634a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f633a = huVar;
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
    public void m627a(boolean z) {
        this.f637a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m628a() {
        return this.f632a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m629a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m628a = m628a();
        boolean m628a2 = idVar.m628a();
        if (((!m628a && !m628a2) || (m628a && m628a2 && this.f632a.equals(idVar.f632a))) && this.f638a == idVar.f638a && this.f640b == idVar.f640b) {
            boolean e2 = e();
            boolean e3 = idVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f636a.equals(idVar.f636a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = idVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f635a.equals(idVar.f635a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = idVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f639b.equals(idVar.f639b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = idVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f634a.m596a(idVar.f634a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = idVar.i();
            if (i || i2) {
                return i && i2 && this.f633a.m588a(idVar.f633a);
            }
            return true;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m630a() {
        a(it.a(this.f636a));
        return this.f636a.array();
    }

    public id b(String str) {
        this.f639b = str;
        return this;
    }

    public id b(boolean z) {
        this.f640b = z;
        m631b(true);
        return this;
    }

    public String b() {
        return this.f639b;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m626a();
        jdVar.a(f631a);
        if (this.f632a != null) {
            jdVar.a(a);
            jdVar.mo705a(this.f632a.a());
            jdVar.b();
        }
        jdVar.a(b);
        jdVar.a(this.f638a);
        jdVar.b();
        jdVar.a(c);
        jdVar.a(this.f640b);
        jdVar.b();
        if (this.f636a != null) {
            jdVar.a(d);
            jdVar.a(this.f636a);
            jdVar.b();
        }
        if (this.f635a != null && f()) {
            jdVar.a(e);
            jdVar.a(this.f635a);
            jdVar.b();
        }
        if (this.f639b != null && g()) {
            jdVar.a(f);
            jdVar.a(this.f639b);
            jdVar.b();
        }
        if (this.f634a != null) {
            jdVar.a(g);
            this.f634a.b(jdVar);
            jdVar.b();
        }
        if (this.f633a != null && i()) {
            jdVar.a(h);
            this.f633a.b(jdVar);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m631b(boolean z) {
        this.f637a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m632b() {
        return this.f638a;
    }

    public boolean c() {
        return this.f637a.get(0);
    }

    public boolean d() {
        return this.f637a.get(1);
    }

    public boolean e() {
        return this.f636a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m629a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f635a != null;
    }

    public boolean g() {
        return this.f639b != null;
    }

    public boolean h() {
        return this.f634a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f633a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        hh hhVar = this.f632a;
        if (hhVar == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(hhVar);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("encryptAction:");
        sb.append(this.f638a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("isRequest:");
        sb.append(this.f640b);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appid:");
            String str = this.f635a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str2 = this.f639b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("target:");
        hw hwVar = this.f634a;
        if (hwVar == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(hwVar);
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("metaInfo:");
            hu huVar = this.f633a;
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
