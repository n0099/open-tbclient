package d.r.b.a.a.f;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f66964a;

    /* renamed from: b  reason: collision with root package name */
    public String f66965b;

    /* renamed from: c  reason: collision with root package name */
    public String f66966c;

    /* renamed from: d  reason: collision with root package name */
    public final long f66967d;

    /* renamed from: e  reason: collision with root package name */
    public final String f66968e;

    /* renamed from: f  reason: collision with root package name */
    public final String f66969f;

    /* renamed from: g  reason: collision with root package name */
    public final String f66970g;

    /* renamed from: h  reason: collision with root package name */
    public final String f66971h;

    /* renamed from: i  reason: collision with root package name */
    public final PurchaseStatus f66972i;

    public b() {
        this(null, null, null, 0L, null, null, null, null, null, 511, null);
    }

    public b(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, PurchaseStatus purchaseStatus) {
        this.f66964a = str;
        this.f66965b = str2;
        this.f66966c = str3;
        this.f66967d = j;
        this.f66968e = str4;
        this.f66969f = str5;
        this.f66970g = str6;
        this.f66971h = str7;
        this.f66972i = purchaseStatus;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (Intrinsics.areEqual(this.f66964a, bVar.f66964a) && Intrinsics.areEqual(this.f66965b, bVar.f66965b) && Intrinsics.areEqual(this.f66966c, bVar.f66966c)) {
                    if (!(this.f66967d == bVar.f66967d) || !Intrinsics.areEqual(this.f66968e, bVar.f66968e) || !Intrinsics.areEqual(this.f66969f, bVar.f66969f) || !Intrinsics.areEqual(this.f66970g, bVar.f66970g) || !Intrinsics.areEqual(this.f66971h, bVar.f66971h) || !Intrinsics.areEqual(this.f66972i, bVar.f66972i)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f66964a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f66965b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f66966c;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        long j = this.f66967d;
        int i2 = (((hashCode2 + hashCode3) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str4 = this.f66968e;
        int hashCode4 = (i2 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f66969f;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f66970g;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f66971h;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        PurchaseStatus purchaseStatus = this.f66972i;
        return hashCode7 + (purchaseStatus != null ? purchaseStatus.hashCode() : 0);
    }

    public String toString() {
        return "PayCallBackBean(orderId=" + this.f66964a + ", productId=" + this.f66965b + ", gpOrder=" + this.f66966c + ", startTime=" + this.f66967d + ", chOrderid=" + this.f66968e + ", payLoad=" + this.f66969f + ", purchaseData=" + this.f66970g + ", purchaseSign=" + this.f66971h + ", purchaseStatus=" + this.f66972i + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ b(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, PurchaseStatus purchaseStatus, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? 0L : j, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) == 0 ? purchaseStatus : null);
    }
}
