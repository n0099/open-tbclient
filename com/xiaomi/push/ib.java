package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class ib implements iq<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hf f628a;

    /* renamed from: a  reason: collision with other field name */
    public hs f629a;

    /* renamed from: a  reason: collision with other field name */
    public hu f630a;

    /* renamed from: a  reason: collision with other field name */
    public String f631a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f632a;

    /* renamed from: b  reason: collision with other field name */
    public String f635b;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f627a = new jg("XmPushActionContainer");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40756a = new iy("", (byte) 8, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40757b = new iy("", (byte) 2, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40758c = new iy("", (byte) 2, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f40759d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f40760e = new iy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f40761f = new iy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f40762g = new iy("", StandardMessageCodec.LIST, 7);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f40763h = new iy("", StandardMessageCodec.LIST, 8);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f633a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f634a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f636b = true;

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
        if (ib.class.equals(ibVar.getClass())) {
            int compareTo = Boolean.valueOf(m435a()).compareTo(Boolean.valueOf(ibVar.m435a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m435a() || (a9 = ir.a(this.f628a, ibVar.f628a)) == 0) {
                int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!c() || (a8 = ir.a(this.f634a, ibVar.f634a)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a7 = ir.a(this.f636b, ibVar.f636b)) == 0) {
                        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!e() || (a6 = ir.a(this.f632a, ibVar.f632a)) == 0) {
                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!f() || (a5 = ir.a(this.f631a, ibVar.f631a)) == 0) {
                                int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ibVar.g()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!g() || (a4 = ir.a(this.f635b, ibVar.f635b)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a3 = ir.a(this.f630a, ibVar.f630a)) == 0) {
                                        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ibVar.i()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!i() || (a2 = ir.a(this.f629a, ibVar.f629a)) == 0) {
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
        return ib.class.getName().compareTo(ibVar.getClass().getName());
    }

    public hf a() {
        return this.f628a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hs m431a() {
        return this.f629a;
    }

    public ib a(hf hfVar) {
        this.f628a = hfVar;
        return this;
    }

    public ib a(hs hsVar) {
        this.f629a = hsVar;
        return this;
    }

    public ib a(hu huVar) {
        this.f630a = huVar;
        return this;
    }

    public ib a(String str) {
        this.f631a = str;
        return this;
    }

    public ib a(ByteBuffer byteBuffer) {
        this.f632a = byteBuffer;
        return this;
    }

    public ib a(boolean z) {
        this.f634a = z;
        m434a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m432a() {
        return this.f631a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m433a() {
        if (this.f628a == null) {
            throw new jc("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f632a == null) {
            throw new jc("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f630a != null) {
        } else {
            throw new jc("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m505a();
        while (true) {
            iy m501a = jbVar.m501a();
            byte b2 = m501a.f40866a;
            if (b2 == 0) {
                jbVar.f();
                if (!c()) {
                    throw new jc("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m433a();
                    return;
                } else {
                    throw new jc("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (m501a.f807a) {
                case 1:
                    if (b2 == 8) {
                        this.f628a = hf.a(jbVar.m499a());
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f634a = jbVar.m510a();
                        m434a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f636b = jbVar.m510a();
                        m438b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f632a = jbVar.m507a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f631a = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f635b = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f630a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hs hsVar = new hs();
                        this.f629a = hsVar;
                        hsVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m434a(boolean z) {
        this.f633a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m435a() {
        return this.f628a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m436a(ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        boolean m435a = m435a();
        boolean m435a2 = ibVar.m435a();
        if (((!m435a && !m435a2) || (m435a && m435a2 && this.f628a.equals(ibVar.f628a))) && this.f634a == ibVar.f634a && this.f636b == ibVar.f636b) {
            boolean e2 = e();
            boolean e3 = ibVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f632a.equals(ibVar.f632a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ibVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f631a.equals(ibVar.f631a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ibVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f635b.equals(ibVar.f635b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ibVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f630a.m400a(ibVar.f630a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = ibVar.i();
            if (i || i2) {
                return i && i2 && this.f629a.m392a(ibVar.f629a);
            }
            return true;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m437a() {
        a(ir.a(this.f632a));
        return this.f632a.array();
    }

    public ib b(String str) {
        this.f635b = str;
        return this;
    }

    public ib b(boolean z) {
        this.f636b = z;
        m438b(true);
        return this;
    }

    public String b() {
        return this.f635b;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m433a();
        jbVar.a(f627a);
        if (this.f628a != null) {
            jbVar.a(f40756a);
            jbVar.a(this.f628a.a());
            jbVar.b();
        }
        jbVar.a(f40757b);
        jbVar.a(this.f634a);
        jbVar.b();
        jbVar.a(f40758c);
        jbVar.a(this.f636b);
        jbVar.b();
        if (this.f632a != null) {
            jbVar.a(f40759d);
            jbVar.a(this.f632a);
            jbVar.b();
        }
        if (this.f631a != null && f()) {
            jbVar.a(f40760e);
            jbVar.a(this.f631a);
            jbVar.b();
        }
        if (this.f635b != null && g()) {
            jbVar.a(f40761f);
            jbVar.a(this.f635b);
            jbVar.b();
        }
        if (this.f630a != null) {
            jbVar.a(f40762g);
            this.f630a.b(jbVar);
            jbVar.b();
        }
        if (this.f629a != null && i()) {
            jbVar.a(f40763h);
            this.f629a.b(jbVar);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m509a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m438b(boolean z) {
        this.f633a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m439b() {
        return this.f634a;
    }

    public boolean c() {
        return this.f633a.get(0);
    }

    public boolean d() {
        return this.f633a.get(1);
    }

    public boolean e() {
        return this.f632a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m436a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f631a != null;
    }

    public boolean g() {
        return this.f635b != null;
    }

    public boolean h() {
        return this.f630a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f629a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        hf hfVar = this.f628a;
        if (hfVar == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(hfVar);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("encryptAction:");
        sb.append(this.f634a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("isRequest:");
        sb.append(this.f636b);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("pushAction:");
        ByteBuffer byteBuffer = this.f632a;
        if (byteBuffer == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            ir.a(byteBuffer, sb);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appid:");
            String str = this.f631a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str2 = this.f635b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("target:");
        hu huVar = this.f630a;
        if (huVar == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(huVar);
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("metaInfo:");
            hs hsVar = this.f629a;
            if (hsVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hsVar);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
