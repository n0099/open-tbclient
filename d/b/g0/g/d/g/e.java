package d.b.g0.g.d.g;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class e {
    public static final a i = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public byte[] f48046a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f48047b;

    /* renamed from: c  reason: collision with root package name */
    public byte f48048c;

    /* renamed from: d  reason: collision with root package name */
    public byte f48049d;

    /* renamed from: e  reason: collision with root package name */
    public short f48050e;

    /* renamed from: f  reason: collision with root package name */
    public int f48051f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f48052g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f48053h;

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
        this.f48046a = bArr;
        this.f48047b = bArr2;
        this.f48048c = b2;
        this.f48049d = b3;
        this.f48050e = s;
        this.f48051f = i2;
        this.f48052g = bArr3;
        this.f48053h = bArr4;
    }

    public final byte[] a() {
        return this.f48053h;
    }

    public final int b() {
        return this.f48051f;
    }

    public final byte[] c() {
        return this.f48047b;
    }

    public final byte[] d() {
        return this.f48046a;
    }

    public final byte[] e() {
        return this.f48052g;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (Intrinsics.areEqual(this.f48046a, eVar.f48046a) && Intrinsics.areEqual(this.f48047b, eVar.f48047b)) {
                    if (this.f48048c == eVar.f48048c) {
                        if (this.f48049d == eVar.f48049d) {
                            if (this.f48050e == eVar.f48050e) {
                                if (!(this.f48051f == eVar.f48051f) || !Intrinsics.areEqual(this.f48052g, eVar.f48052g) || !Intrinsics.areEqual(this.f48053h, eVar.f48053h)) {
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
        return this.f48049d;
    }

    public final short g() {
        return this.f48050e;
    }

    public final byte h() {
        return this.f48048c;
    }

    public int hashCode() {
        byte[] bArr = this.f48046a;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.f48047b;
        int hashCode2 = (((((((((hashCode + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31) + this.f48048c) * 31) + this.f48049d) * 31) + this.f48050e) * 31) + this.f48051f) * 31;
        byte[] bArr3 = this.f48052g;
        int hashCode3 = (hashCode2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0)) * 31;
        byte[] bArr4 = this.f48053h;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public final void i(byte[] bArr) {
        this.f48053h = bArr;
    }

    public final void j(int i2) {
        this.f48051f = i2;
    }

    public final void k(byte[] bArr) {
        this.f48047b = bArr;
    }

    public final void l(byte[] bArr) {
        this.f48046a = bArr;
    }

    public final void m(byte[] bArr) {
        this.f48052g = bArr;
    }

    public final void n(byte b2) {
        this.f48049d = b2;
    }

    public final void o(short s) {
        this.f48050e = s;
    }

    public final void p(byte b2) {
        this.f48048c = b2;
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.f48046a) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeType=" + ((int) this.f48048c) + ", schemeExtType=" + ((int) this.f48049d) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeLen=" + ((int) this.f48050e) + ", contentLen=" + this.f48051f + StringUtil.ARRAY_ELEMENT_SEPARATOR + "scheme=" + Arrays.toString(this.f48052g) + ')';
    }

    public /* synthetic */ e(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i2, byte[] bArr3, byte[] bArr4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new byte[2] : bArr, (i3 & 2) != 0 ? new byte[2] : bArr2, (i3 & 4) != 0 ? (byte) 0 : b2, (i3 & 8) != 0 ? (byte) 0 : b3, (i3 & 16) != 0 ? (short) 0 : s, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? null : bArr3, (i3 & 128) == 0 ? bArr4 : null);
    }
}
