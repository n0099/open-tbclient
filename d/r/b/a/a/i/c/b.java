package d.r.b.a.a.i.c;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f67064a;

    /* renamed from: b  reason: collision with root package name */
    public long f67065b;

    /* renamed from: c  reason: collision with root package name */
    public int f67066c;

    /* renamed from: d  reason: collision with root package name */
    public String f67067d;

    /* renamed from: e  reason: collision with root package name */
    public String f67068e;

    /* renamed from: f  reason: collision with root package name */
    public long f67069f;

    /* renamed from: g  reason: collision with root package name */
    public int f67070g;

    /* renamed from: h  reason: collision with root package name */
    public int f67071h;

    /* renamed from: i  reason: collision with root package name */
    public int f67072i;
    public int j;
    public int k;
    public int l;
    public int m;
    public String n;
    public int o;

    public b(String str, long j, int i2, String str2, String str3, long j2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str4, int i10) {
        this.f67064a = str;
        this.f67065b = j;
        this.f67066c = i2;
        this.f67067d = str2;
        this.f67068e = str3;
        this.f67069f = j2;
        this.f67070g = i3;
        this.f67071h = i4;
        this.f67072i = i5;
        this.j = i6;
        this.k = i7;
        this.l = i8;
        this.m = i9;
        this.n = str4;
        this.o = i10;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (Intrinsics.areEqual(this.f67064a, bVar.f67064a)) {
                    if (this.f67065b == bVar.f67065b) {
                        if ((this.f67066c == bVar.f67066c) && Intrinsics.areEqual(this.f67067d, bVar.f67067d) && Intrinsics.areEqual(this.f67068e, bVar.f67068e)) {
                            if (this.f67069f == bVar.f67069f) {
                                if (this.f67070g == bVar.f67070g) {
                                    if (this.f67071h == bVar.f67071h) {
                                        if (this.f67072i == bVar.f67072i) {
                                            if (this.j == bVar.j) {
                                                if (this.k == bVar.k) {
                                                    if (this.l == bVar.l) {
                                                        if ((this.m == bVar.m) && Intrinsics.areEqual(this.n, bVar.n)) {
                                                            if (this.o == bVar.o) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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

    public int hashCode() {
        String str = this.f67064a;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.f67065b;
        int i2 = ((((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.f67066c) * 31;
        String str2 = this.f67067d;
        int hashCode2 = (i2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f67068e;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        long j2 = this.f67069f;
        int i3 = (((((((((((((((((hashCode2 + hashCode3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f67070g) * 31) + this.f67071h) * 31) + this.f67072i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31;
        String str4 = this.n;
        return ((i3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.o;
    }

    public String toString() {
        return "ChargeOrder(rechargeAmount=" + this.f67064a + ", createTime=" + this.f67065b + ", diamondAmount=" + this.f67066c + ", currencySymbol=" + this.f67067d + ", payChannel=" + this.f67068e + ", id=" + this.f67069f + ", status=" + this.f67070g + ", offersType=" + this.f67071h + ", offersRate=" + this.f67072i + ", srcAmount=" + this.j + ", destAmount=" + this.k + ", destCurrencyType=" + this.l + ", payAmount=" + this.m + ", otherChargeOrderId=" + this.n + ", chargeConfigType=" + this.o + SmallTailInfo.EMOTION_SUFFIX;
    }
}
