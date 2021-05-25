package d.r.b.a.a.j.b;

import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import d.r.b.a.a.f.f.a;
import d.r.b.a.a.i.c.i;
import java.util.Locale;
/* loaded from: classes7.dex */
public class b implements IPayCallback<PurchaseInfo> {

    /* renamed from: a  reason: collision with root package name */
    public IPayCallback f67878a;

    /* renamed from: b  reason: collision with root package name */
    public ChargeCurrencyReqParams f67879b;

    /* renamed from: c  reason: collision with root package name */
    public PayType f67880c;

    /* renamed from: d  reason: collision with root package name */
    public String f67881d;

    /* renamed from: e  reason: collision with root package name */
    public a.c f67882e;

    /* renamed from: f  reason: collision with root package name */
    public long f67883f;

    /* renamed from: g  reason: collision with root package name */
    public String f67884g;

    /* renamed from: h  reason: collision with root package name */
    public i f67885h;

    /* renamed from: i  reason: collision with root package name */
    public a f67886i;
    public d.r.b.a.a.f.f.b j;

    public b(PayType payType, String str, ChargeCurrencyReqParams chargeCurrencyReqParams, String str2, i iVar, String str3, d.r.b.a.a.f.f.b bVar, IAppPayService iAppPayService, a aVar, IPayCallback iPayCallback) {
        this.f67881d = "";
        this.f67880c = payType;
        if (str != null) {
            this.f67881d = str;
        }
        this.f67883f = System.currentTimeMillis();
        this.f67879b = chargeCurrencyReqParams;
        this.f67878a = iPayCallback;
        this.f67884g = str2;
        this.f67885h = iVar;
        this.j = bVar;
        this.f67886i = aVar;
        a.c cVar = new a.c();
        this.f67882e = cVar;
        cVar.f67758e = chargeCurrencyReqParams.getFrom();
        this.f67882e.f67757d = chargeCurrencyReqParams.getUid();
        a.c cVar2 = this.f67882e;
        cVar2.f67761h = this.f67881d;
        cVar2.o = chargeCurrencyReqParams.getTraceid();
        this.f67882e.m = str3;
    }

    public final void a(int i2, String str, d.r.b.a.a.f.b bVar) {
        if (bVar == null) {
            this.f67879b.getProductId();
            PurchaseStatus purchaseStatus = PurchaseStatus.PAY_FAIL;
        }
        if (this.f67878a != null) {
            d.r.b.a.a.f.b bVar2 = new d.r.b.a.a.f.b(this.f67881d, this.f67879b.getProductId(), "", this.f67883f, null, this.f67884g, null, null, PurchaseStatus.PAY_FAIL);
            this.f67878a.onPayStatus(PurchaseStatus.PAY_FAIL, bVar2);
            this.f67878a.onFail(i2, "pay fail! failReason:" + str, bVar2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f67883f;
        d.r.b.a.a.f.d.d.f("AppPayServiceImpl", String.format(Locale.ENGLISH, "---PayCallbackProxy, pay onFail: requestTime = %s, delay = %s, uid = %s, orderid = %s", Long.valueOf(j), (currentTimeMillis - j) + "", Long.valueOf(this.f67879b.getUid()), this.f67881d));
        d.r.b.a.a.f.f.b bVar3 = this.j;
        if (bVar3 != null) {
            bVar3.b("payingaddpaymentrespone", i2 + "", "pay fail! failReason:" + str, this.f67881d, "" + this.f67883f, this.f67879b.getProductId(), this.f67880c.getChannel(), this.f67879b.getTraceid());
        }
        d.r.b.a.a.f.d.d.h("AppPayServiceImpl", "payingaddpaymentrespone pay fail! failReason:" + str + " code:" + i2 + " orderId:" + this.f67881d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    /* renamed from: b */
    public void onSuccess(PurchaseInfo purchaseInfo, d.r.b.a.a.f.b bVar) {
        d.r.b.a.a.f.b bVar2;
        long currentTimeMillis = System.currentTimeMillis() - this.f67883f;
        if (purchaseInfo != null) {
            bVar2 = bVar == null ? new d.r.b.a.a.f.b(this.f67881d, this.f67879b.getProductId(), "", this.f67883f, null, this.f67884g, null, null, PurchaseStatus.PAY_SUCCESS) : bVar;
            this.f67878a.onSuccess("pay success!", bVar2);
            Locale locale = Locale.ENGLISH;
            d.r.b.a.a.f.d.d.f("AppPayServiceImpl", String.format(locale, "---PayCallbackProxy-pay-onSuccess: requestTime = %s, delay = %s, Uid =%s, OrderId =%s", Long.valueOf(this.f67883f), currentTimeMillis + "", Long.valueOf(this.f67879b.getUid()), this.f67881d));
        } else {
            bVar2 = bVar;
        }
        IPayCallback iPayCallback = this.f67878a;
        if (iPayCallback != null) {
            iPayCallback.onPayStatus(PurchaseStatus.PAY_SUCCESS, bVar2);
        }
        this.f67886i.i(this.f67879b, this.f67881d, this.f67885h);
        d.r.b.a.a.f.f.b bVar3 = this.j;
        if (bVar3 != null) {
            String str = this.f67881d;
            bVar3.b("payingaddpaymentrespone", "0", "pay success!", str, "" + this.f67883f, this.f67879b.getProductId(), this.f67880c.getChannel(), this.f67879b.getTraceid());
        }
        d.r.b.a.a.f.d.d.h("AppPayServiceImpl", "payingaddpaymentrespone pay success! orderId=" + this.f67881d);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onFail(int i2, String str, d.r.b.a.a.f.b bVar) {
        a(i2, str, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStart() {
        if (this.f67878a != null) {
            this.f67878a.onPayStatus(PurchaseStatus.PAY_START, new d.r.b.a.a.f.b(this.f67881d, this.f67879b.getProductId(), "", this.f67883f, d.r.b.a.a.j.e.a.a(this.f67884g), this.f67884g, null, null, PurchaseStatus.PAY_START));
            this.f67878a.onPayStart();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f67883f;
        Locale locale = Locale.ENGLISH;
        d.r.b.a.a.f.d.d.f("AppPayServiceImpl", String.format(locale, "---PayCallbackProxy-onPayStart: requestTime = %s, delay = %s, uid = %s, orderid = %s", Long.valueOf(j), (currentTimeMillis - j) + "", Long.valueOf(this.f67879b.getUid()), this.f67881d));
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStatus(PurchaseStatus purchaseStatus, d.r.b.a.a.f.b bVar) {
        this.f67878a.onPayStatus(purchaseStatus, bVar);
    }
}
