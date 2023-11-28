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
    public hh f627a;

    /* renamed from: a  reason: collision with other field name */
    public hu f628a;

    /* renamed from: a  reason: collision with other field name */
    public hw f629a;

    /* renamed from: a  reason: collision with other field name */
    public String f630a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f631a;

    /* renamed from: b  reason: collision with other field name */
    public String f634b;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f626a = new ji("XmPushActionContainer");
    public static final ja a = new ja("", (byte) 8, 1);
    public static final ja b = new ja("", (byte) 2, 2);
    public static final ja c = new ja("", (byte) 2, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 6);
    public static final ja g = new ja("", (byte) 12, 7);
    public static final ja h = new ja("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f632a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f633a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f635b = true;

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
            int compareTo = Boolean.valueOf(m638a()).compareTo(Boolean.valueOf(idVar.m638a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m638a() || (a9 = it.a(this.f627a, idVar.f627a)) == 0) {
                int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!c() || (a8 = it.a(this.f633a, idVar.f633a)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a7 = it.a(this.f635b, idVar.f635b)) == 0) {
                        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!e() || (a6 = it.a(this.f631a, idVar.f631a)) == 0) {
                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!f() || (a5 = it.a(this.f630a, idVar.f630a)) == 0) {
                                int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!g() || (a4 = it.a(this.f634b, idVar.f634b)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a3 = it.a(this.f629a, idVar.f629a)) == 0) {
                                        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!i() || (a2 = it.a(this.f628a, idVar.f628a)) == 0) {
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
        return this.f627a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hu m634a() {
        return this.f628a;
    }

    public id a(hh hhVar) {
        this.f627a = hhVar;
        return this;
    }

    public id a(hu huVar) {
        this.f628a = huVar;
        return this;
    }

    public id a(hw hwVar) {
        this.f629a = hwVar;
        return this;
    }

    public id a(String str) {
        this.f630a = str;
        return this;
    }

    public id a(ByteBuffer byteBuffer) {
        this.f631a = byteBuffer;
        return this;
    }

    public id a(boolean z) {
        this.f633a = z;
        m637a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m635a() {
        return this.f630a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m636a() {
        if (this.f627a == null) {
            throw new je("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f631a == null) {
            throw new je("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f629a != null) {
        } else {
            throw new je("Required field 'target' was not present! Struct: " + toString());
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
                if (!c()) {
                    throw new je("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m636a();
                    return;
                } else {
                    throw new je("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 8) {
                        this.f627a = hh.a(jdVar.mo704a());
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f633a = jdVar.mo716a();
                        m637a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f635b = jdVar.mo716a();
                        m641b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f631a = jdVar.mo712a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f630a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f634b = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f629a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f628a = huVar;
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
    public void m637a(boolean z) {
        this.f632a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m638a() {
        return this.f627a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m639a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m638a = m638a();
        boolean m638a2 = idVar.m638a();
        if (((!m638a && !m638a2) || (m638a && m638a2 && this.f627a.equals(idVar.f627a))) && this.f633a == idVar.f633a && this.f635b == idVar.f635b) {
            boolean e2 = e();
            boolean e3 = idVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f631a.equals(idVar.f631a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = idVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f630a.equals(idVar.f630a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = idVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f634b.equals(idVar.f634b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = idVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f629a.m606a(idVar.f629a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = idVar.i();
            if (i || i2) {
                return i && i2 && this.f628a.m598a(idVar.f628a);
            }
            return true;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m640a() {
        a(it.a(this.f631a));
        return this.f631a.array();
    }

    public id b(String str) {
        this.f634b = str;
        return this;
    }

    public id b(boolean z) {
        this.f635b = z;
        m641b(true);
        return this;
    }

    public String b() {
        return this.f634b;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m636a();
        jdVar.a(f626a);
        if (this.f627a != null) {
            jdVar.a(a);
            jdVar.mo715a(this.f627a.a());
            jdVar.b();
        }
        jdVar.a(b);
        jdVar.a(this.f633a);
        jdVar.b();
        jdVar.a(c);
        jdVar.a(this.f635b);
        jdVar.b();
        if (this.f631a != null) {
            jdVar.a(d);
            jdVar.a(this.f631a);
            jdVar.b();
        }
        if (this.f630a != null && f()) {
            jdVar.a(e);
            jdVar.a(this.f630a);
            jdVar.b();
        }
        if (this.f634b != null && g()) {
            jdVar.a(f);
            jdVar.a(this.f634b);
            jdVar.b();
        }
        if (this.f629a != null) {
            jdVar.a(g);
            this.f629a.b(jdVar);
            jdVar.b();
        }
        if (this.f628a != null && i()) {
            jdVar.a(h);
            this.f628a.b(jdVar);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m641b(boolean z) {
        this.f632a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m642b() {
        return this.f633a;
    }

    public boolean c() {
        return this.f632a.get(0);
    }

    public boolean d() {
        return this.f632a.get(1);
    }

    public boolean e() {
        return this.f631a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m639a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f630a != null;
    }

    public boolean g() {
        return this.f634b != null;
    }

    public boolean h() {
        return this.f629a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f628a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        hh hhVar = this.f627a;
        if (hhVar == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(hhVar);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("encryptAction:");
        sb.append(this.f633a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("isRequest:");
        sb.append(this.f635b);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appid:");
            String str = this.f630a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str2 = this.f634b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("target:");
        hw hwVar = this.f629a;
        if (hwVar == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(hwVar);
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("metaInfo:");
            hu huVar = this.f628a;
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
