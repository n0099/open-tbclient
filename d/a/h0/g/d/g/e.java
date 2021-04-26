package d.a.h0.g.d.g;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: i  reason: collision with root package name */
    public static final a f46234i = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public byte[] f46235a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f46236b;

    /* renamed from: c  reason: collision with root package name */
    public byte f46237c;

    /* renamed from: d  reason: collision with root package name */
    public byte f46238d;

    /* renamed from: e  reason: collision with root package name */
    public short f46239e;

    /* renamed from: f  reason: collision with root package name */
    public int f46240f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f46241g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f46242h;

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final e a() {
            e eVar = new e(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            eVar.l(new byte[2]);
            byte[] d2 = eVar.d();
            if (d2 != null) {
                d2[0] = 0;
            }
            byte[] d3 = eVar.d();
            if (d3 != null) {
                d3[1] = 2;
            }
            eVar.k(new byte[2]);
            byte[] c2 = eVar.c();
            if (c2 != null) {
                c2[0] = -27;
            }
            byte[] c3 = eVar.c();
            if (c3 != null) {
                c3[1] = -89;
            }
            return eVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public e(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i2, byte[] bArr3, byte[] bArr4) {
        this.f46235a = bArr;
        this.f46236b = bArr2;
        this.f46237c = b2;
        this.f46238d = b3;
        this.f46239e = s;
        this.f46240f = i2;
        this.f46241g = bArr3;
        this.f46242h = bArr4;
    }

    public final byte[] a() {
        return this.f46242h;
    }

    public final int b() {
        return this.f46240f;
    }

    public final byte[] c() {
        return this.f46236b;
    }

    public final byte[] d() {
        return this.f46235a;
    }

    public final byte[] e() {
        return this.f46241g;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (Intrinsics.areEqual(this.f46235a, eVar.f46235a) && Intrinsics.areEqual(this.f46236b, eVar.f46236b)) {
                    if (this.f46237c == eVar.f46237c) {
                        if (this.f46238d == eVar.f46238d) {
                            if (this.f46239e == eVar.f46239e) {
                                if (!(this.f46240f == eVar.f46240f) || !Intrinsics.areEqual(this.f46241g, eVar.f46241g) || !Intrinsics.areEqual(this.f46242h, eVar.f46242h)) {
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final byte f() {
        return this.f46238d;
    }

    public final short g() {
        return this.f46239e;
    }

    public final byte h() {
        return this.f46237c;
    }

    public int hashCode() {
        byte[] bArr = this.f46235a;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.f46236b;
        int hashCode2 = (((((((((hashCode + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31) + this.f46237c) * 31) + this.f46238d) * 31) + this.f46239e) * 31) + this.f46240f) * 31;
        byte[] bArr3 = this.f46241g;
        int hashCode3 = (hashCode2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0)) * 31;
        byte[] bArr4 = this.f46242h;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public final void i(byte[] bArr) {
        this.f46242h = bArr;
    }

    public final void j(int i2) {
        this.f46240f = i2;
    }

    public final void k(byte[] bArr) {
        this.f46236b = bArr;
    }

    public final void l(byte[] bArr) {
        this.f46235a = bArr;
    }

    public final void m(byte[] bArr) {
        this.f46241g = bArr;
    }

    public final void n(byte b2) {
        this.f46238d = b2;
    }

    public final void o(short s) {
        this.f46239e = s;
    }

    public final void p(byte b2) {
        this.f46237c = b2;
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.f46235a) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeType=" + ((int) this.f46237c) + ", schemeExtType=" + ((int) this.f46238d) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeLen=" + ((int) this.f46239e) + ", contentLen=" + this.f46240f + StringUtil.ARRAY_ELEMENT_SEPARATOR + "scheme=" + Arrays.toString(this.f46241g) + ')';
    }

    public /* synthetic */ e(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i2, byte[] bArr3, byte[] bArr4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new byte[2] : bArr, (i3 & 2) != 0 ? new byte[2] : bArr2, (i3 & 4) != 0 ? (byte) 0 : b2, (i3 & 8) != 0 ? (byte) 0 : b3, (i3 & 16) != 0 ? (short) 0 : s, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? null : bArr3, (i3 & 128) == 0 ? bArr4 : null);
    }
}
