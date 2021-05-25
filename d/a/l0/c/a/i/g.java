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
    public int f46483a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f46484b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f46485c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f46486d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f46487e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f46488f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f46489g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f46490h;

    /* renamed from: i  reason: collision with root package name */
    public long f46491i;
    public byte[] j;

    public g() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.f46485c = num;
        this.f46486d = num2;
        this.f46487e = num3;
        this.f46488f = num4;
        this.f46489g = bArr;
        this.f46490h = bArr2;
        this.f46491i = j;
        this.j = bArr3;
    }

    public final void a() {
        if (k.f43199a) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.f46484b);
        }
        this.f46484b++;
    }

    public final boolean b() {
        return this.f46484b < 3;
    }

    public final byte[] c() {
        return this.f46489g;
    }

    public final Integer d() {
        return this.f46485c;
    }

    public final Integer e() {
        return this.f46487e;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                return Intrinsics.areEqual(this.f46485c, gVar.f46485c) && Intrinsics.areEqual(this.f46486d, gVar.f46486d) && Intrinsics.areEqual(this.f46487e, gVar.f46487e) && Intrinsics.areEqual(this.f46488f, gVar.f46488f) && Intrinsics.areEqual(this.f46489g, gVar.f46489g) && Intrinsics.areEqual(this.f46490h, gVar.f46490h) && this.f46491i == gVar.f46491i && Intrinsics.areEqual(this.j, gVar.j);
            }
            return false;
        }
        return true;
    }

    public final Integer f() {
        return this.f46486d;
    }

    public final Integer g() {
        return this.f46488f;
    }

    public final int h() {
        return this.f46483a;
    }

    public int hashCode() {
        Integer num = this.f46485c;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.f46486d;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.f46487e;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.f46488f;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        byte[] bArr = this.f46489g;
        int hashCode5 = (hashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        byte[] bArr2 = this.f46490h;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.f46491i;
        int i2 = (((hashCode5 + hashCode6) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.j;
        return i2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public final byte[] i() {
        return this.f46490h;
    }

    public final synchronized boolean j() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        z = false;
        if (this.f46489g != null && this.f46490h != null && this.f46491i > currentTimeMillis && this.f46483a == 1) {
            z = true;
        }
        if (d.a.l0.c.a.a.f46449a) {
            Log.d("BDTLS", "isSessionEnable " + this.f46489g + ' ' + this.f46490h + ' ' + this.f46491i + ' ' + this.f46483a);
        }
        return z;
    }

    public final void k() {
        if (k.f43199a) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.f46484b);
        }
        this.f46484b = 0;
    }

    public final void l(byte[] bArr) {
        this.f46489g = bArr;
    }

    public final void m(Integer num) {
        this.f46485c = num;
    }

    public final void n(Integer num) {
        this.f46487e = num;
    }

    public final void o(Integer num) {
        this.f46486d = num;
    }

    public final void p(Integer num) {
        this.f46488f = num;
    }

    public final void q(byte[] bArr) {
        this.j = bArr;
    }

    public final void r(long j) {
        this.f46491i = j;
    }

    public final void s(int i2) {
        this.f46483a = i2;
    }

    public final void t(byte[] bArr) {
        this.f46490h = bArr;
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.f46485c + ", dhSecretKey=" + this.f46486d + ", dhPublicKey=" + this.f46487e + ", dhServerPublicKey=" + this.f46488f + ", aesSecretKey=" + Arrays.toString(this.f46489g) + ", sessionTicket=" + Arrays.toString(this.f46490h) + ", expireTime=" + this.f46491i + ", entryType=" + Arrays.toString(this.j) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : num3, (i2 & 8) != 0 ? null : num4, (i2 & 16) != 0 ? null : bArr, (i2 & 32) != 0 ? null : bArr2, (i2 & 64) != 0 ? 0L : j, (i2 & 128) == 0 ? bArr3 : null);
    }
}
