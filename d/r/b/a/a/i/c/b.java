package d.r.b.a.a.i.c;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f67750a;

    /* renamed from: b  reason: collision with root package name */
    public long f67751b;

    /* renamed from: c  reason: collision with root package name */
    public int f67752c;

    /* renamed from: d  reason: collision with root package name */
    public String f67753d;

    /* renamed from: e  reason: collision with root package name */
    public String f67754e;

    /* renamed from: f  reason: collision with root package name */
    public long f67755f;

    /* renamed from: g  reason: collision with root package name */
    public int f67756g;

    /* renamed from: h  reason: collision with root package name */
    public int f67757h;

    /* renamed from: i  reason: collision with root package name */
    public int f67758i;
    public int j;
    public int k;
    public int l;
    public int m;
    public String n;
    public int o;

    public b(String str, long j, int i2, String str2, String str3, long j2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str4, int i10) {
        this.f67750a = str;
        this.f67751b = j;
        this.f67752c = i2;
        this.f67753d = str2;
        this.f67754e = str3;
        this.f67755f = j2;
        this.f67756g = i3;
        this.f67757h = i4;
        this.f67758i = i5;
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
                if (Intrinsics.areEqual(this.f67750a, bVar.f67750a)) {
                    if (this.f67751b == bVar.f67751b) {
                        if ((this.f67752c == bVar.f67752c) && Intrinsics.areEqual(this.f67753d, bVar.f67753d) && Intrinsics.areEqual(this.f67754e, bVar.f67754e)) {
                            if (this.f67755f == bVar.f67755f) {
                                if (this.f67756g == bVar.f67756g) {
                                    if (this.f67757h == bVar.f67757h) {
                                        if (this.f67758i == bVar.f67758i) {
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
        String str = this.f67750a;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.f67751b;
        int i2 = ((((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.f67752c) * 31;
        String str2 = this.f67753d;
        int hashCode2 = (i2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f67754e;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        long j2 = this.f67755f;
        int i3 = (((((((((((((((((hashCode2 + hashCode3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f67756g) * 31) + this.f67757h) * 31) + this.f67758i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31;
        String str4 = this.n;
        return ((i3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.o;
    }

    public String toString() {
        return "ChargeOrder(rechargeAmount=" + this.f67750a + ", createTime=" + this.f67751b + ", diamondAmount=" + this.f67752c + ", currencySymbol=" + this.f67753d + ", payChannel=" + this.f67754e + ", id=" + this.f67755f + ", status=" + this.f67756g + ", offersType=" + this.f67757h + ", offersRate=" + this.f67758i + ", srcAmount=" + this.j + ", destAmount=" + this.k + ", destCurrencyType=" + this.l + ", payAmount=" + this.m + ", otherChargeOrderId=" + this.n + ", chargeConfigType=" + this.o + SmallTailInfo.EMOTION_SUFFIX;
    }
}
