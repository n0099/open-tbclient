package d.r.b.a.a.i.c;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f67793a;

    /* renamed from: b  reason: collision with root package name */
    public long f67794b;

    /* renamed from: c  reason: collision with root package name */
    public int f67795c;

    /* renamed from: d  reason: collision with root package name */
    public String f67796d;

    /* renamed from: e  reason: collision with root package name */
    public String f67797e;

    /* renamed from: f  reason: collision with root package name */
    public long f67798f;

    /* renamed from: g  reason: collision with root package name */
    public int f67799g;

    /* renamed from: h  reason: collision with root package name */
    public int f67800h;

    /* renamed from: i  reason: collision with root package name */
    public int f67801i;
    public int j;
    public int k;
    public int l;
    public int m;
    public String n;
    public int o;

    public b(String str, long j, int i2, String str2, String str3, long j2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str4, int i10) {
        this.f67793a = str;
        this.f67794b = j;
        this.f67795c = i2;
        this.f67796d = str2;
        this.f67797e = str3;
        this.f67798f = j2;
        this.f67799g = i3;
        this.f67800h = i4;
        this.f67801i = i5;
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
                if (Intrinsics.areEqual(this.f67793a, bVar.f67793a)) {
                    if (this.f67794b == bVar.f67794b) {
                        if ((this.f67795c == bVar.f67795c) && Intrinsics.areEqual(this.f67796d, bVar.f67796d) && Intrinsics.areEqual(this.f67797e, bVar.f67797e)) {
                            if (this.f67798f == bVar.f67798f) {
                                if (this.f67799g == bVar.f67799g) {
                                    if (this.f67800h == bVar.f67800h) {
                                        if (this.f67801i == bVar.f67801i) {
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
        String str = this.f67793a;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.f67794b;
        int i2 = ((((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.f67795c) * 31;
        String str2 = this.f67796d;
        int hashCode2 = (i2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f67797e;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        long j2 = this.f67798f;
        int i3 = (((((((((((((((((hashCode2 + hashCode3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f67799g) * 31) + this.f67800h) * 31) + this.f67801i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31;
        String str4 = this.n;
        return ((i3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.o;
    }

    public String toString() {
        return "ChargeOrder(rechargeAmount=" + this.f67793a + ", createTime=" + this.f67794b + ", diamondAmount=" + this.f67795c + ", currencySymbol=" + this.f67796d + ", payChannel=" + this.f67797e + ", id=" + this.f67798f + ", status=" + this.f67799g + ", offersType=" + this.f67800h + ", offersRate=" + this.f67801i + ", srcAmount=" + this.j + ", destAmount=" + this.k + ", destCurrencyType=" + this.l + ", payAmount=" + this.m + ", otherChargeOrderId=" + this.n + ", chargeConfigType=" + this.o + SmallTailInfo.EMOTION_SUFFIX;
    }
}
