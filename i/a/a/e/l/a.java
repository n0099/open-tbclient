package i.a.a.e.l;

import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ProductInfo f72152a;

    /* renamed from: b  reason: collision with root package name */
    public int f72153b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f72154c;

    public a(boolean z) {
        this.f72153b = Integer.MIN_VALUE;
        this.f72154c = z;
    }

    public double a() {
        ProductInfo productInfo = this.f72152a;
        if (productInfo != null) {
            return productInfo.destAmount / 100.0d;
        }
        return 0.0d;
    }

    public Double b() {
        ProductInfo productInfo = this.f72152a;
        if (productInfo != null) {
            return productInfo.srcAmount;
        }
        return Double.valueOf(0.0d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayAmount{currencyType=");
        sb.append(this.f72153b);
        sb.append(", srcAmount=");
        ProductInfo productInfo = this.f72152a;
        sb.append(productInfo != null ? productInfo.srcAmount.doubleValue() : 0.0d);
        sb.append(", dstAmount=");
        ProductInfo productInfo2 = this.f72152a;
        sb.append(productInfo2 != null ? productInfo2.destAmount : 0L);
        sb.append('}');
        return sb.toString();
    }

    public a(ProductInfo productInfo) {
        this.f72153b = Integer.MIN_VALUE;
        this.f72152a = productInfo;
    }

    public a(ProductInfo productInfo, int i2) {
        this.f72153b = Integer.MIN_VALUE;
        this.f72152a = productInfo;
        this.f72153b = i2;
    }
}
