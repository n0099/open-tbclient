package d.a.l0.c.a.i;

import android.util.Log;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.l0.a.k;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f50157a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f50158b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f50159c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f50160d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f50161e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f50162f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f50163g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f50164h;

    /* renamed from: i  reason: collision with root package name */
    public long f50165i;
    public byte[] j;

    public g() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.f50159c = num;
        this.f50160d = num2;
        this.f50161e = num3;
        this.f50162f = num4;
        this.f50163g = bArr;
        this.f50164h = bArr2;
        this.f50165i = j;
        this.j = bArr3;
    }

    public final void a() {
        if (k.f46875a) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.f50158b);
        }
        this.f50158b++;
    }

    public final boolean b() {
        return this.f50158b < 3;
    }

    public final byte[] c() {
        return this.f50163g;
    }

    public final Integer d() {
        return this.f50159c;
    }

    public final Integer e() {
        return this.f50161e;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                return Intrinsics.areEqual(this.f50159c, gVar.f50159c) && Intrinsics.areEqual(this.f50160d, gVar.f50160d) && Intrinsics.areEqual(this.f50161e, gVar.f50161e) && Intrinsics.areEqual(this.f50162f, gVar.f50162f) && Intrinsics.areEqual(this.f50163g, gVar.f50163g) && Intrinsics.areEqual(this.f50164h, gVar.f50164h) && this.f50165i == gVar.f50165i && Intrinsics.areEqual(this.j, gVar.j);
            }
            return false;
        }
        return true;
    }

    public final Integer f() {
        return this.f50160d;
    }

    public final Integer g() {
        return this.f50162f;
    }

    public final int h() {
        return this.f50157a;
    }

    public int hashCode() {
        Integer num = this.f50159c;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.f50160d;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.f50161e;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.f50162f;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        byte[] bArr = this.f50163g;
        int hashCode5 = (hashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        byte[] bArr2 = this.f50164h;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.f50165i;
        int i2 = (((hashCode5 + hashCode6) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.j;
        return i2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public final byte[] i() {
        return this.f50164h;
    }

    public final synchronized boolean j() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        z = false;
        if (this.f50163g != null && this.f50164h != null && this.f50165i > currentTimeMillis && this.f50157a == 1) {
            z = true;
        }
        if (d.a.l0.c.a.a.f50123a) {
            Log.d("BDTLS", "isSessionEnable " + this.f50163g + ' ' + this.f50164h + ' ' + this.f50165i + ' ' + this.f50157a);
        }
        return z;
    }

    public final void k() {
        if (k.f46875a) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.f50158b);
        }
        this.f50158b = 0;
    }

    public final void l(byte[] bArr) {
        this.f50163g = bArr;
    }

    public final void m(Integer num) {
        this.f50159c = num;
    }

    public final void n(Integer num) {
        this.f50161e = num;
    }

    public final void o(Integer num) {
        this.f50160d = num;
    }

    public final void p(Integer num) {
        this.f50162f = num;
    }

    public final void q(byte[] bArr) {
        this.j = bArr;
    }

    public final void r(long j) {
        this.f50165i = j;
    }

    public final void s(int i2) {
        this.f50157a = i2;
    }

    public final void t(byte[] bArr) {
        this.f50164h = bArr;
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.f50159c + ", dhSecretKey=" + this.f50160d + ", dhPublicKey=" + this.f50161e + ", dhServerPublicKey=" + this.f50162f + ", aesSecretKey=" + Arrays.toString(this.f50163g) + ", sessionTicket=" + Arrays.toString(this.f50164h) + ", expireTime=" + this.f50165i + ", entryType=" + Arrays.toString(this.j) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : num3, (i2 & 8) != 0 ? null : num4, (i2 & 16) != 0 ? null : bArr, (i2 & 32) != 0 ? null : bArr2, (i2 & 64) != 0 ? 0L : j, (i2 & 128) == 0 ? bArr3 : null);
    }
}
