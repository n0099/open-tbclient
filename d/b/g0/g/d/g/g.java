package d.b.g0.g.d.g;

import android.util.Log;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.g0.a.k;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f48056a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f48057b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f48058c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f48059d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f48060e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f48061f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f48062g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f48063h;
    public long i;
    public byte[] j;

    public g() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.f48058c = num;
        this.f48059d = num2;
        this.f48060e = num3;
        this.f48061f = num4;
        this.f48062g = bArr;
        this.f48063h = bArr2;
        this.i = j;
        this.j = bArr3;
    }

    public final void a() {
        if (k.f45051a) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.f48057b);
        }
        this.f48057b++;
    }

    public final boolean b() {
        return this.f48057b < 3;
    }

    public final byte[] c() {
        return this.f48062g;
    }

    public final Integer d() {
        return this.f48058c;
    }

    public final Integer e() {
        return this.f48060e;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (Intrinsics.areEqual(this.f48058c, gVar.f48058c) && Intrinsics.areEqual(this.f48059d, gVar.f48059d) && Intrinsics.areEqual(this.f48060e, gVar.f48060e) && Intrinsics.areEqual(this.f48061f, gVar.f48061f) && Intrinsics.areEqual(this.f48062g, gVar.f48062g) && Intrinsics.areEqual(this.f48063h, gVar.f48063h)) {
                    if (!(this.i == gVar.i) || !Intrinsics.areEqual(this.j, gVar.j)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final Integer f() {
        return this.f48059d;
    }

    public final Integer g() {
        return this.f48061f;
    }

    public final int h() {
        return this.f48056a;
    }

    public int hashCode() {
        Integer num = this.f48058c;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.f48059d;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.f48060e;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.f48061f;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        byte[] bArr = this.f48062g;
        int hashCode5 = (hashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        byte[] bArr2 = this.f48063h;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.i;
        int i = (((hashCode5 + hashCode6) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.j;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public final byte[] i() {
        return this.f48063h;
    }

    public final synchronized boolean j() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        z = false;
        if (this.f48062g != null && this.f48063h != null && this.i > currentTimeMillis && this.f48056a == 1) {
            z = true;
        }
        if (d.b.g0.g.d.a.f48028a) {
            Log.d("BDTLS", "isSessionEnable " + this.f48062g + ' ' + this.f48063h + ' ' + this.i + ' ' + this.f48056a);
        }
        return z;
    }

    public final void k() {
        if (k.f45051a) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.f48057b);
        }
        this.f48057b = 0;
    }

    public final void l(byte[] bArr) {
        this.f48062g = bArr;
    }

    public final void m(Integer num) {
        this.f48058c = num;
    }

    public final void n(Integer num) {
        this.f48060e = num;
    }

    public final void o(Integer num) {
        this.f48059d = num;
    }

    public final void p(Integer num) {
        this.f48061f = num;
    }

    public final void q(byte[] bArr) {
        this.j = bArr;
    }

    public final void r(long j) {
        this.i = j;
    }

    public final void s(int i) {
        this.f48056a = i;
    }

    public final void t(byte[] bArr) {
        this.f48063h = bArr;
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.f48058c + ", dhSecretKey=" + this.f48059d + ", dhPublicKey=" + this.f48060e + ", dhServerPublicKey=" + this.f48061f + ", aesSecretKey=" + Arrays.toString(this.f48062g) + ", sessionTicket=" + Arrays.toString(this.f48063h) + ", expireTime=" + this.i + ", entryType=" + Arrays.toString(this.j) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) == 0 ? bArr3 : null);
    }
}
