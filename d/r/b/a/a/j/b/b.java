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
    public IPayCallback f67835a;

    /* renamed from: b  reason: collision with root package name */
    public ChargeCurrencyReqParams f67836b;

    /* renamed from: c  reason: collision with root package name */
    public PayType f67837c;

    /* renamed from: d  reason: collision with root package name */
    public String f67838d;

    /* renamed from: e  reason: collision with root package name */
    public a.c f67839e;

    /* renamed from: f  reason: collision with root package name */
    public long f67840f;

    /* renamed from: g  reason: collision with root package name */
    public String f67841g;

    /* renamed from: h  reason: collision with root package name */
    public i f67842h;

    /* renamed from: i  reason: collision with root package name */
    public a f67843i;
    public d.r.b.a.a.f.f.b j;

    public b(PayType payType, String str, ChargeCurrencyReqParams chargeCurrencyReqParams, String str2, i iVar, String str3, d.r.b.a.a.f.f.b bVar, IAppPayService iAppPayService, a aVar, IPayCallback iPayCallback) {
        this.f67838d = "";
        this.f67837c = payType;
        if (str != null) {
            this.f67838d = str;
        }
        this.f67840f = System.currentTimeMillis();
        this.f67836b = chargeCurrencyReqParams;
        this.f67835a = iPayCallback;
        this.f67841g = str2;
        this.f67842h = iVar;
        this.j = bVar;
        this.f67843i = aVar;
        a.c cVar = new a.c();
        this.f67839e = cVar;
        cVar.f67715e = chargeCurrencyReqParams.getFrom();
        this.f67839e.f67714d = chargeCurrencyReqParams.getUid();
        a.c cVar2 = this.f67839e;
        cVar2.f67718h = this.f67838d;
        cVar2.o = chargeCurrencyReqParams.getTraceid();
        this.f67839e.m = str3;
    }

    public final void a(int i2, String str, d.r.b.a.a.f.b bVar) {
        if (bVar == null) {
            this.f67836b.getProductId();
            PurchaseStatus purchaseStatus = PurchaseStatus.PAY_FAIL;
        }
        if (this.f67835a != null) {
            d.r.b.a.a.f.b bVar2 = new d.r.b.a.a.f.b(this.f67838d, this.f67836b.getProductId(), "", this.f67840f, null, this.f67841g, null, null, PurchaseStatus.PAY_FAIL);
            this.f67835a.onPayStatus(PurchaseStatus.PAY_FAIL, bVar2);
            this.f67835a.onFail(i2, "pay fail! failReason:" + str, bVar2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f67840f;
        d.r.b.a.a.f.d.d.f("AppPayServiceImpl", String.format(Locale.ENGLISH, "---PayCallbackProxy, pay onFail: requestTime = %s, delay = %s, uid = %s, orderid = %s", Long.valueOf(j), (currentTimeMillis - j) + "", Long.valueOf(this.f67836b.getUid()), this.f67838d));
        d.r.b.a.a.f.f.b bVar3 = this.j;
        if (bVar3 != null) {
            bVar3.b("payingaddpaymentrespone", i2 + "", "pay fail! failReason:" + str, this.f67838d, "" + this.f67840f, this.f67836b.getProductId(), this.f67837c.getChannel(), this.f67836b.getTraceid());
        }
        d.r.b.a.a.f.d.d.h("AppPayServiceImpl", "payingaddpaymentrespone pay fail! failReason:" + str + " code:" + i2 + " orderId:" + this.f67838d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    /* renamed from: b */
    public void onSuccess(PurchaseInfo purchaseInfo, d.r.b.a.a.f.b bVar) {
        d.r.b.a.a.f.b bVar2;
        long currentTimeMillis = System.currentTimeMillis() - this.f67840f;
        if (purchaseInfo != null) {
            bVar2 = bVar == null ? new d.r.b.a.a.f.b(this.f67838d, this.f67836b.getProductId(), "", this.f67840f, null, this.f67841g, null, null, PurchaseStatus.PAY_SUCCESS) : bVar;
            this.f67835a.onSuccess("pay success!", bVar2);
            Locale locale = Locale.ENGLISH;
            d.r.b.a.a.f.d.d.f("AppPayServiceImpl", String.format(locale, "---PayCallbackProxy-pay-onSuccess: requestTime = %s, delay = %s, Uid =%s, OrderId =%s", Long.valueOf(this.f67840f), currentTimeMillis + "", Long.valueOf(this.f67836b.getUid()), this.f67838d));
        } else {
            bVar2 = bVar;
        }
        IPayCallback iPayCallback = this.f67835a;
        if (iPayCallback != null) {
            iPayCallback.onPayStatus(PurchaseStatus.PAY_SUCCESS, bVar2);
        }
        this.f67843i.i(this.f67836b, this.f67838d, this.f67842h);
        d.r.b.a.a.f.f.b bVar3 = this.j;
        if (bVar3 != null) {
            String str = this.f67838d;
            bVar3.b("payingaddpaymentrespone", "0", "pay success!", str, "" + this.f67840f, this.f67836b.getProductId(), this.f67837c.getChannel(), this.f67836b.getTraceid());
        }
        d.r.b.a.a.f.d.d.h("AppPayServiceImpl", "payingaddpaymentrespone pay success! orderId=" + this.f67838d);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onFail(int i2, String str, d.r.b.a.a.f.b bVar) {
        a(i2, str, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStart() {
        if (this.f67835a != null) {
            this.f67835a.onPayStatus(PurchaseStatus.PAY_START, new d.r.b.a.a.f.b(this.f67838d, this.f67836b.getProductId(), "", this.f67840f, d.r.b.a.a.j.e.a.a(this.f67841g), this.f67841g, null, null, PurchaseStatus.PAY_START));
            this.f67835a.onPayStart();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f67840f;
        Locale locale = Locale.ENGLISH;
        d.r.b.a.a.f.d.d.f("AppPayServiceImpl", String.format(locale, "---PayCallbackProxy-onPayStart: requestTime = %s, delay = %s, uid = %s, orderid = %s", Long.valueOf(j), (currentTimeMillis - j) + "", Long.valueOf(this.f67836b.getUid()), this.f67838d));
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStatus(PurchaseStatus purchaseStatus, d.r.b.a.a.f.b bVar) {
        this.f67835a.onPayStatus(purchaseStatus, bVar);
    }
}
