package d.a.l0.c.a.i;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class e {
    public static final a j = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public byte[] f50146a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f50147b;

    /* renamed from: c  reason: collision with root package name */
    public byte f50148c;

    /* renamed from: d  reason: collision with root package name */
    public byte f50149d;

    /* renamed from: e  reason: collision with root package name */
    public short f50150e;

    /* renamed from: f  reason: collision with root package name */
    public int f50151f;

    /* renamed from: g  reason: collision with root package name */
    public long f50152g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f50153h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f50154i;

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final e a() {
            e eVar = new e(null, null, (byte) 0, (byte) 0, (short) 0, 0, 0L, null, null, 511, null);
            eVar.n(new byte[2]);
            byte[] e2 = eVar.e();
            if (e2 != null) {
                e2[0] = 0;
            }
            byte[] e3 = eVar.e();
            if (e3 != null) {
                e3[1] = 3;
            }
            eVar.m(new byte[2]);
            byte[] d2 = eVar.d();
            if (d2 != null) {
                d2[0] = -27;
            }
            byte[] d3 = eVar.d();
            if (d3 != null) {
                d3[1] = -89;
            }
            return eVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, 0L, null, null, 511, null);
    }

    public e(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i2, long j2, byte[] bArr3, byte[] bArr4) {
        this.f50146a = bArr;
        this.f50147b = bArr2;
        this.f50148c = b2;
        this.f50149d = b3;
        this.f50150e = s;
        this.f50151f = i2;
        this.f50152g = j2;
        this.f50153h = bArr3;
        this.f50154i = bArr4;
    }

    public final byte[] a() {
        return this.f50154i;
    }

    public final int b() {
        return this.f50151f;
    }

    public final long c() {
        return this.f50152g;
    }

    public final byte[] d() {
        return this.f50147b;
    }

    public final byte[] e() {
        return this.f50146a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                return Intrinsics.areEqual(this.f50146a, eVar.f50146a) && Intrinsics.areEqual(this.f50147b, eVar.f50147b) && this.f50148c == eVar.f50148c && this.f50149d == eVar.f50149d && this.f50150e == eVar.f50150e && this.f50151f == eVar.f50151f && this.f50152g == eVar.f50152g && Intrinsics.areEqual(this.f50153h, eVar.f50153h) && Intrinsics.areEqual(this.f50154i, eVar.f50154i);
            }
            return false;
        }
        return true;
    }

    public final byte[] f() {
        return this.f50153h;
    }

    public final byte g() {
        return this.f50149d;
    }

    public final short h() {
        return this.f50150e;
    }

    public int hashCode() {
        byte[] bArr = this.f50146a;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.f50147b;
        int hashCode2 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j2 = this.f50152g;
        int i2 = (((((((((((hashCode + hashCode2) * 31) + this.f50148c) * 31) + this.f50149d) * 31) + this.f50150e) * 31) + this.f50151f) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        byte[] bArr3 = this.f50153h;
        int hashCode3 = (i2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0)) * 31;
        byte[] bArr4 = this.f50154i;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public final byte i() {
        return this.f50148c;
    }

    public final void j(byte[] bArr) {
        this.f50154i = bArr;
    }

    public final void k(int i2) {
        this.f50151f = i2;
    }

    public final void l(long j2) {
        this.f50152g = j2;
    }

    public final void m(byte[] bArr) {
        this.f50147b = bArr;
    }

    public final void n(byte[] bArr) {
        this.f50146a = bArr;
    }

    public final void o(byte[] bArr) {
        this.f50153h = bArr;
    }

    public final void p(byte b2) {
        this.f50149d = b2;
    }

    public final void q(short s) {
        this.f50150e = s;
    }

    public final void r(byte b2) {
        this.f50148c = b2;
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.f50146a) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeType=" + ((int) this.f50148c) + ", schemeExtType=" + ((int) this.f50149d) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeLen=" + ((int) this.f50150e) + ", contentLen=" + this.f50151f + StringUtil.ARRAY_ELEMENT_SEPARATOR + "identity=" + this.f50152g + StringUtil.ARRAY_ELEMENT_SEPARATOR + "scheme=" + Arrays.toString(this.f50153h) + ')';
    }

    public /* synthetic */ e(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i2, long j2, byte[] bArr3, byte[] bArr4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new byte[2] : bArr, (i3 & 2) != 0 ? new byte[2] : bArr2, (i3 & 4) != 0 ? (byte) 0 : b2, (i3 & 8) != 0 ? (byte) 0 : b3, (i3 & 16) != 0 ? (short) 0 : s, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? 0L : j2, (i3 & 128) != 0 ? null : bArr3, (i3 & 256) == 0 ? bArr4 : null);
    }
}
