package d.a.m0.c.a.i;

import android.util.Log;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.m0.a.k;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f50265a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f50266b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f50267c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f50268d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f50269e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f50270f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f50271g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f50272h;

    /* renamed from: i  reason: collision with root package name */
    public long f50273i;
    public byte[] j;

    public g() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.f50267c = num;
        this.f50268d = num2;
        this.f50269e = num3;
        this.f50270f = num4;
        this.f50271g = bArr;
        this.f50272h = bArr2;
        this.f50273i = j;
        this.j = bArr3;
    }

    public final void a() {
        if (k.f46983a) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.f50266b);
        }
        this.f50266b++;
    }

    public final boolean b() {
        return this.f50266b < 3;
    }

    public final byte[] c() {
        return this.f50271g;
    }

    public final Integer d() {
        return this.f50267c;
    }

    public final Integer e() {
        return this.f50269e;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                return Intrinsics.areEqual(this.f50267c, gVar.f50267c) && Intrinsics.areEqual(this.f50268d, gVar.f50268d) && Intrinsics.areEqual(this.f50269e, gVar.f50269e) && Intrinsics.areEqual(this.f50270f, gVar.f50270f) && Intrinsics.areEqual(this.f50271g, gVar.f50271g) && Intrinsics.areEqual(this.f50272h, gVar.f50272h) && this.f50273i == gVar.f50273i && Intrinsics.areEqual(this.j, gVar.j);
            }
            return false;
        }
        return true;
    }

    public final Integer f() {
        return this.f50268d;
    }

    public final Integer g() {
        return this.f50270f;
    }

    public final int h() {
        return this.f50265a;
    }

    public int hashCode() {
        Integer num = this.f50267c;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.f50268d;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.f50269e;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.f50270f;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        byte[] bArr = this.f50271g;
        int hashCode5 = (hashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        byte[] bArr2 = this.f50272h;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.f50273i;
        int i2 = (((hashCode5 + hashCode6) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.j;
        return i2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public final byte[] i() {
        return this.f50272h;
    }

    public final synchronized boolean j() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        z = false;
        if (this.f50271g != null && this.f50272h != null && this.f50273i > currentTimeMillis && this.f50265a == 1) {
            z = true;
        }
        if (d.a.m0.c.a.a.f50231a) {
            Log.d("BDTLS", "isSessionEnable " + this.f50271g + ' ' + this.f50272h + ' ' + this.f50273i + ' ' + this.f50265a);
        }
        return z;
    }

    public final void k() {
        if (k.f46983a) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.f50266b);
        }
        this.f50266b = 0;
    }

    public final void l(byte[] bArr) {
        this.f50271g = bArr;
    }

    public final void m(Integer num) {
        this.f50267c = num;
    }

    public final void n(Integer num) {
        this.f50269e = num;
    }

    public final void o(Integer num) {
        this.f50268d = num;
    }

    public final void p(Integer num) {
        this.f50270f = num;
    }

    public final void q(byte[] bArr) {
        this.j = bArr;
    }

    public final void r(long j) {
        this.f50273i = j;
    }

    public final void s(int i2) {
        this.f50265a = i2;
    }

    public final void t(byte[] bArr) {
        this.f50272h = bArr;
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.f50267c + ", dhSecretKey=" + this.f50268d + ", dhPublicKey=" + this.f50269e + ", dhServerPublicKey=" + this.f50270f + ", aesSecretKey=" + Arrays.toString(this.f50271g) + ", sessionTicket=" + Arrays.toString(this.f50272h) + ", expireTime=" + this.f50273i + ", entryType=" + Arrays.toString(this.j) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : num3, (i2 & 8) != 0 ? null : num4, (i2 & 16) != 0 ? null : bArr, (i2 & 32) != 0 ? null : bArr2, (i2 & 64) != 0 ? 0L : j, (i2 & 128) == 0 ? bArr3 : null);
    }
}
