package d.b.h0.g.d.g;

import android.util.Log;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.h0.a.k;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f48777a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f48778b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f48779c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f48780d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f48781e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f48782f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f48783g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f48784h;
    public long i;
    public byte[] j;

    public g() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.f48779c = num;
        this.f48780d = num2;
        this.f48781e = num3;
        this.f48782f = num4;
        this.f48783g = bArr;
        this.f48784h = bArr2;
        this.i = j;
        this.j = bArr3;
    }

    public final void a() {
        if (k.f45772a) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.f48778b);
        }
        this.f48778b++;
    }

    public final boolean b() {
        return this.f48778b < 3;
    }

    public final byte[] c() {
        return this.f48783g;
    }

    public final Integer d() {
        return this.f48779c;
    }

    public final Integer e() {
        return this.f48781e;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (Intrinsics.areEqual(this.f48779c, gVar.f48779c) && Intrinsics.areEqual(this.f48780d, gVar.f48780d) && Intrinsics.areEqual(this.f48781e, gVar.f48781e) && Intrinsics.areEqual(this.f48782f, gVar.f48782f) && Intrinsics.areEqual(this.f48783g, gVar.f48783g) && Intrinsics.areEqual(this.f48784h, gVar.f48784h)) {
                    if (!(this.i == gVar.i) || !Intrinsics.areEqual(this.j, gVar.j)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final Integer f() {
        return this.f48780d;
    }

    public final Integer g() {
        return this.f48782f;
    }

    public final int h() {
        return this.f48777a;
    }

    public int hashCode() {
        Integer num = this.f48779c;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.f48780d;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.f48781e;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.f48782f;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        byte[] bArr = this.f48783g;
        int hashCode5 = (hashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        byte[] bArr2 = this.f48784h;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.i;
        int i = (((hashCode5 + hashCode6) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.j;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public final byte[] i() {
        return this.f48784h;
    }

    public final synchronized boolean j() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        z = false;
        if (this.f48783g != null && this.f48784h != null && this.i > currentTimeMillis && this.f48777a == 1) {
            z = true;
        }
        if (d.b.h0.g.d.a.f48749a) {
            Log.d("BDTLS", "isSessionEnable " + this.f48783g + ' ' + this.f48784h + ' ' + this.i + ' ' + this.f48777a);
        }
        return z;
    }

    public final void k() {
        if (k.f45772a) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.f48778b);
        }
        this.f48778b = 0;
    }

    public final void l(byte[] bArr) {
        this.f48783g = bArr;
    }

    public final void m(Integer num) {
        this.f48779c = num;
    }

    public final void n(Integer num) {
        this.f48781e = num;
    }

    public final void o(Integer num) {
        this.f48780d = num;
    }

    public final void p(Integer num) {
        this.f48782f = num;
    }

    public final void q(byte[] bArr) {
        this.j = bArr;
    }

    public final void r(long j) {
        this.i = j;
    }

    public final void s(int i) {
        this.f48777a = i;
    }

    public final void t(byte[] bArr) {
        this.f48784h = bArr;
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.f48779c + ", dhSecretKey=" + this.f48780d + ", dhPublicKey=" + this.f48781e + ", dhServerPublicKey=" + this.f48782f + ", aesSecretKey=" + Arrays.toString(this.f48783g) + ", sessionTicket=" + Arrays.toString(this.f48784h) + ", expireTime=" + this.i + ", entryType=" + Arrays.toString(this.j) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) == 0 ? bArr3 : null);
    }
}
