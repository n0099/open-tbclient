package d.a.h0.g.d.g;

import android.util.Log;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.h0.a.k;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f46245a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f46246b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f46247c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f46248d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f46249e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f46250f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f46251g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f46252h;

    /* renamed from: i  reason: collision with root package name */
    public long f46253i;
    public byte[] j;

    public g() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.f46247c = num;
        this.f46248d = num2;
        this.f46249e = num3;
        this.f46250f = num4;
        this.f46251g = bArr;
        this.f46252h = bArr2;
        this.f46253i = j;
        this.j = bArr3;
    }

    public final void a() {
        if (k.f43101a) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.f46246b);
        }
        this.f46246b++;
    }

    public final boolean b() {
        return this.f46246b < 3;
    }

    public final byte[] c() {
        return this.f46251g;
    }

    public final Integer d() {
        return this.f46247c;
    }

    public final Integer e() {
        return this.f46249e;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (Intrinsics.areEqual(this.f46247c, gVar.f46247c) && Intrinsics.areEqual(this.f46248d, gVar.f46248d) && Intrinsics.areEqual(this.f46249e, gVar.f46249e) && Intrinsics.areEqual(this.f46250f, gVar.f46250f) && Intrinsics.areEqual(this.f46251g, gVar.f46251g) && Intrinsics.areEqual(this.f46252h, gVar.f46252h)) {
                    if (!(this.f46253i == gVar.f46253i) || !Intrinsics.areEqual(this.j, gVar.j)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final Integer f() {
        return this.f46248d;
    }

    public final Integer g() {
        return this.f46250f;
    }

    public final int h() {
        return this.f46245a;
    }

    public int hashCode() {
        Integer num = this.f46247c;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.f46248d;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.f46249e;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.f46250f;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        byte[] bArr = this.f46251g;
        int hashCode5 = (hashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        byte[] bArr2 = this.f46252h;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.f46253i;
        int i2 = (((hashCode5 + hashCode6) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.j;
        return i2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public final byte[] i() {
        return this.f46252h;
    }

    public final synchronized boolean j() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        z = false;
        if (this.f46251g != null && this.f46252h != null && this.f46253i > currentTimeMillis && this.f46245a == 1) {
            z = true;
        }
        if (d.a.h0.g.d.a.f46216a) {
            Log.d("BDTLS", "isSessionEnable " + this.f46251g + ' ' + this.f46252h + ' ' + this.f46253i + ' ' + this.f46245a);
        }
        return z;
    }

    public final void k() {
        if (k.f43101a) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.f46246b);
        }
        this.f46246b = 0;
    }

    public final void l(byte[] bArr) {
        this.f46251g = bArr;
    }

    public final void m(Integer num) {
        this.f46247c = num;
    }

    public final void n(Integer num) {
        this.f46249e = num;
    }

    public final void o(Integer num) {
        this.f46248d = num;
    }

    public final void p(Integer num) {
        this.f46250f = num;
    }

    public final void q(byte[] bArr) {
        this.j = bArr;
    }

    public final void r(long j) {
        this.f46253i = j;
    }

    public final void s(int i2) {
        this.f46245a = i2;
    }

    public final void t(byte[] bArr) {
        this.f46252h = bArr;
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.f46247c + ", dhSecretKey=" + this.f46248d + ", dhPublicKey=" + this.f46249e + ", dhServerPublicKey=" + this.f46250f + ", aesSecretKey=" + Arrays.toString(this.f46251g) + ", sessionTicket=" + Arrays.toString(this.f46252h) + ", expireTime=" + this.f46253i + ", entryType=" + Arrays.toString(this.j) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : num3, (i2 & 8) != 0 ? null : num4, (i2 & 16) != 0 ? null : bArr, (i2 & 32) != 0 ? null : bArr2, (i2 & 64) != 0 ? 0L : j, (i2 & 128) == 0 ? bArr3 : null);
    }
}
