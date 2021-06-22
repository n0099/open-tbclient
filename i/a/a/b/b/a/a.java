package i.a.a.b.b.a;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.api.pay.IMiddlePayService;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Activity f72126a;

    /* renamed from: c  reason: collision with root package name */
    public long f72128c;

    /* renamed from: e  reason: collision with root package name */
    public ProductInfo f72130e;

    /* renamed from: f  reason: collision with root package name */
    public int f72131f;

    /* renamed from: g  reason: collision with root package name */
    public int f72132g;
    public Map<String, Object> k;
    public IPayCallback<String> l;
    public IToken m;
    public AppCustomExpand n;
    public String o;

    /* renamed from: b  reason: collision with root package name */
    public PayType f72127b = PayType.ALI_PAY;

    /* renamed from: d  reason: collision with root package name */
    public String f72129d = "";

    /* renamed from: h  reason: collision with root package name */
    public IMiddlePayService.SubscriptType f72133h = IMiddlePayService.SubscriptType.NORMAL_CHARGE;

    /* renamed from: i  reason: collision with root package name */
    public IMiddlePayService.ChargeSource f72134i = IMiddlePayService.ChargeSource.WALLET_CHARGE;
    public String j = "";

    public final void A(long j) {
        this.f72128c = j;
    }

    public final void B(int i2) {
        this.f72131f = i2;
    }

    public final Activity a() {
        Activity activity = this.f72126a;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        return activity;
    }

    public final AppCustomExpand b() {
        return this.n;
    }

    public final IPayCallback<String> c() {
        return this.l;
    }

    public final IMiddlePayService.ChargeSource d() {
        return this.f72134i;
    }

    public final int e() {
        return this.f72132g;
    }

    public final Map<String, Object> f() {
        return this.k;
    }

    public final ProductInfo g() {
        ProductInfo productInfo = this.f72130e;
        if (productInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("info");
        }
        return productInfo;
    }

    public final PayType h() {
        return this.f72127b;
    }

    public final String i() {
        return this.j;
    }

    public final IMiddlePayService.SubscriptType j() {
        return this.f72133h;
    }

    public final String k() {
        return this.f72129d;
    }

    public final IToken l() {
        return this.m;
    }

    public final String m() {
        return this.o;
    }

    public final long n() {
        return this.f72128c;
    }

    public final int o() {
        return this.f72131f;
    }

    public final void p(Activity activity) {
        this.f72126a = activity;
    }

    public final void q(AppCustomExpand appCustomExpand) {
        this.n = appCustomExpand;
    }

    public final void r(IPayCallback<String> iPayCallback) {
        this.l = iPayCallback;
    }

    public final void s(int i2) {
        this.f72132g = i2;
    }

    public final void t(Map<String, Object> map) {
        this.k = map;
    }

    public final void u(ProductInfo productInfo) {
        this.f72130e = productInfo;
    }

    public final void v(PayType payType) {
        this.f72127b = payType;
    }

    public final void w(String str) {
        this.j = str;
    }

    public final void x(String str) {
        this.f72129d = str;
    }

    public final void y(IToken iToken) {
        this.m = iToken;
    }

    public final void z(String str) {
        this.o = str;
    }
}
