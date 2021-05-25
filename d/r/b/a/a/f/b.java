package d.r.b.a.a.f;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f67693a;

    /* renamed from: b  reason: collision with root package name */
    public String f67694b;

    /* renamed from: c  reason: collision with root package name */
    public String f67695c;

    /* renamed from: d  reason: collision with root package name */
    public final long f67696d;

    /* renamed from: e  reason: collision with root package name */
    public final String f67697e;

    /* renamed from: f  reason: collision with root package name */
    public final String f67698f;

    /* renamed from: g  reason: collision with root package name */
    public final String f67699g;

    /* renamed from: h  reason: collision with root package name */
    public final String f67700h;

    /* renamed from: i  reason: collision with root package name */
    public final PurchaseStatus f67701i;

    public b() {
        this(null, null, null, 0L, null, null, null, null, null, 511, null);
    }

    public b(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, PurchaseStatus purchaseStatus) {
        this.f67693a = str;
        this.f67694b = str2;
        this.f67695c = str3;
        this.f67696d = j;
        this.f67697e = str4;
        this.f67698f = str5;
        this.f67699g = str6;
        this.f67700h = str7;
        this.f67701i = purchaseStatus;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (Intrinsics.areEqual(this.f67693a, bVar.f67693a) && Intrinsics.areEqual(this.f67694b, bVar.f67694b) && Intrinsics.areEqual(this.f67695c, bVar.f67695c)) {
                    if (!(this.f67696d == bVar.f67696d) || !Intrinsics.areEqual(this.f67697e, bVar.f67697e) || !Intrinsics.areEqual(this.f67698f, bVar.f67698f) || !Intrinsics.areEqual(this.f67699g, bVar.f67699g) || !Intrinsics.areEqual(this.f67700h, bVar.f67700h) || !Intrinsics.areEqual(this.f67701i, bVar.f67701i)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f67693a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f67694b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f67695c;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        long j = this.f67696d;
        int i2 = (((hashCode2 + hashCode3) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str4 = this.f67697e;
        int hashCode4 = (i2 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f67698f;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f67699g;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f67700h;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        PurchaseStatus purchaseStatus = this.f67701i;
        return hashCode7 + (purchaseStatus != null ? purchaseStatus.hashCode() : 0);
    }

    public String toString() {
        return "PayCallBackBean(orderId=" + this.f67693a + ", productId=" + this.f67694b + ", gpOrder=" + this.f67695c + ", startTime=" + this.f67696d + ", chOrderid=" + this.f67697e + ", payLoad=" + this.f67698f + ", purchaseData=" + this.f67699g + ", purchaseSign=" + this.f67700h + ", purchaseStatus=" + this.f67701i + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ b(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, PurchaseStatus purchaseStatus, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? 0L : j, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) == 0 ? purchaseStatus : null);
    }
}
