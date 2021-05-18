package d.r.b.a.a.f;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f67650a;

    /* renamed from: b  reason: collision with root package name */
    public String f67651b;

    /* renamed from: c  reason: collision with root package name */
    public String f67652c;

    /* renamed from: d  reason: collision with root package name */
    public final long f67653d;

    /* renamed from: e  reason: collision with root package name */
    public final String f67654e;

    /* renamed from: f  reason: collision with root package name */
    public final String f67655f;

    /* renamed from: g  reason: collision with root package name */
    public final String f67656g;

    /* renamed from: h  reason: collision with root package name */
    public final String f67657h;

    /* renamed from: i  reason: collision with root package name */
    public final PurchaseStatus f67658i;

    public b() {
        this(null, null, null, 0L, null, null, null, null, null, 511, null);
    }

    public b(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, PurchaseStatus purchaseStatus) {
        this.f67650a = str;
        this.f67651b = str2;
        this.f67652c = str3;
        this.f67653d = j;
        this.f67654e = str4;
        this.f67655f = str5;
        this.f67656g = str6;
        this.f67657h = str7;
        this.f67658i = purchaseStatus;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (Intrinsics.areEqual(this.f67650a, bVar.f67650a) && Intrinsics.areEqual(this.f67651b, bVar.f67651b) && Intrinsics.areEqual(this.f67652c, bVar.f67652c)) {
                    if (!(this.f67653d == bVar.f67653d) || !Intrinsics.areEqual(this.f67654e, bVar.f67654e) || !Intrinsics.areEqual(this.f67655f, bVar.f67655f) || !Intrinsics.areEqual(this.f67656g, bVar.f67656g) || !Intrinsics.areEqual(this.f67657h, bVar.f67657h) || !Intrinsics.areEqual(this.f67658i, bVar.f67658i)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f67650a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f67651b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f67652c;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        long j = this.f67653d;
        int i2 = (((hashCode2 + hashCode3) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str4 = this.f67654e;
        int hashCode4 = (i2 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f67655f;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f67656g;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f67657h;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        PurchaseStatus purchaseStatus = this.f67658i;
        return hashCode7 + (purchaseStatus != null ? purchaseStatus.hashCode() : 0);
    }

    public String toString() {
        return "PayCallBackBean(orderId=" + this.f67650a + ", productId=" + this.f67651b + ", gpOrder=" + this.f67652c + ", startTime=" + this.f67653d + ", chOrderid=" + this.f67654e + ", payLoad=" + this.f67655f + ", purchaseData=" + this.f67656g + ", purchaseSign=" + this.f67657h + ", purchaseStatus=" + this.f67658i + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ b(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, PurchaseStatus purchaseStatus, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? 0L : j, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) == 0 ? purchaseStatus : null);
    }
}
