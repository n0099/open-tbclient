package d.a.i0.c.a.i;

import android.util.Log;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.i0.a.k;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f46307a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f46308b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f46309c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f46310d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f46311e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f46312f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f46313g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f46314h;

    /* renamed from: i  reason: collision with root package name */
    public long f46315i;
    public byte[] j;

    public g() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.f46309c = num;
        this.f46310d = num2;
        this.f46311e = num3;
        this.f46312f = num4;
        this.f46313g = bArr;
        this.f46314h = bArr2;
        this.f46315i = j;
        this.j = bArr3;
    }

    public final void a() {
        if (k.f43025a) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.f46308b);
        }
        this.f46308b++;
    }

    public final boolean b() {
        return this.f46308b < 3;
    }

    public final byte[] c() {
        return this.f46313g;
    }

    public final Integer d() {
        return this.f46309c;
    }

    public final Integer e() {
        return this.f46311e;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                return Intrinsics.areEqual(this.f46309c, gVar.f46309c) && Intrinsics.areEqual(this.f46310d, gVar.f46310d) && Intrinsics.areEqual(this.f46311e, gVar.f46311e) && Intrinsics.areEqual(this.f46312f, gVar.f46312f) && Intrinsics.areEqual(this.f46313g, gVar.f46313g) && Intrinsics.areEqual(this.f46314h, gVar.f46314h) && this.f46315i == gVar.f46315i && Intrinsics.areEqual(this.j, gVar.j);
            }
            return false;
        }
        return true;
    }

    public final Integer f() {
        return this.f46310d;
    }

    public final Integer g() {
        return this.f46312f;
    }

    public final int h() {
        return this.f46307a;
    }

    public int hashCode() {
        Integer num = this.f46309c;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.f46310d;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.f46311e;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.f46312f;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        byte[] bArr = this.f46313g;
        int hashCode5 = (hashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        byte[] bArr2 = this.f46314h;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.f46315i;
        int i2 = (((hashCode5 + hashCode6) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.j;
        return i2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public final byte[] i() {
        return this.f46314h;
    }

    public final synchronized boolean j() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        z = false;
        if (this.f46313g != null && this.f46314h != null && this.f46315i > currentTimeMillis && this.f46307a == 1) {
            z = true;
        }
        if (d.a.i0.c.a.a.f46273a) {
            Log.d("BDTLS", "isSessionEnable " + this.f46313g + ' ' + this.f46314h + ' ' + this.f46315i + ' ' + this.f46307a);
        }
        return z;
    }

    public final void k() {
        if (k.f43025a) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.f46308b);
        }
        this.f46308b = 0;
    }

    public final void l(byte[] bArr) {
        this.f46313g = bArr;
    }

    public final void m(Integer num) {
        this.f46309c = num;
    }

    public final void n(Integer num) {
        this.f46311e = num;
    }

    public final void o(Integer num) {
        this.f46310d = num;
    }

    public final void p(Integer num) {
        this.f46312f = num;
    }

    public final void q(byte[] bArr) {
        this.j = bArr;
    }

    public final void r(long j) {
        this.f46315i = j;
    }

    public final void s(int i2) {
        this.f46307a = i2;
    }

    public final void t(byte[] bArr) {
        this.f46314h = bArr;
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.f46309c + ", dhSecretKey=" + this.f46310d + ", dhPublicKey=" + this.f46311e + ", dhServerPublicKey=" + this.f46312f + ", aesSecretKey=" + Arrays.toString(this.f46313g) + ", sessionTicket=" + Arrays.toString(this.f46314h) + ", expireTime=" + this.f46315i + ", entryType=" + Arrays.toString(this.j) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : num3, (i2 & 8) != 0 ? null : num4, (i2 & 16) != 0 ? null : bArr, (i2 & 32) != 0 ? null : bArr2, (i2 & 64) != 0 ? 0L : j, (i2 & 128) == 0 ? bArr3 : null);
    }
}
