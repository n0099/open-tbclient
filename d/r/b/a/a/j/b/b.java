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
    public IPayCallback f67149a;

    /* renamed from: b  reason: collision with root package name */
    public ChargeCurrencyReqParams f67150b;

    /* renamed from: c  reason: collision with root package name */
    public PayType f67151c;

    /* renamed from: d  reason: collision with root package name */
    public String f67152d;

    /* renamed from: e  reason: collision with root package name */
    public a.c f67153e;

    /* renamed from: f  reason: collision with root package name */
    public long f67154f;

    /* renamed from: g  reason: collision with root package name */
    public String f67155g;

    /* renamed from: h  reason: collision with root package name */
    public i f67156h;

    /* renamed from: i  reason: collision with root package name */
    public a f67157i;
    public d.r.b.a.a.f.f.b j;

    public b(PayType payType, String str, ChargeCurrencyReqParams chargeCurrencyReqParams, String str2, i iVar, String str3, d.r.b.a.a.f.f.b bVar, IAppPayService iAppPayService, a aVar, IPayCallback iPayCallback) {
        this.f67152d = "";
        this.f67151c = payType;
        if (str != null) {
            this.f67152d = str;
        }
        this.f67154f = System.currentTimeMillis();
        this.f67150b = chargeCurrencyReqParams;
        this.f67149a = iPayCallback;
        this.f67155g = str2;
        this.f67156h = iVar;
        this.j = bVar;
        this.f67157i = aVar;
        a.c cVar = new a.c();
        this.f67153e = cVar;
        cVar.f67029e = chargeCurrencyReqParams.getFrom();
        this.f67153e.f67028d = chargeCurrencyReqParams.getUid();
        a.c cVar2 = this.f67153e;
        cVar2.f67032h = this.f67152d;
        cVar2.o = chargeCurrencyReqParams.getTraceid();
        this.f67153e.m = str3;
    }

    public final void a(int i2, String str, d.r.b.a.a.f.b bVar) {
        if (bVar == null) {
            this.f67150b.getProductId();
            PurchaseStatus purchaseStatus = PurchaseStatus.PAY_FAIL;
        }
        if (this.f67149a != null) {
            d.r.b.a.a.f.b bVar2 = new d.r.b.a.a.f.b(this.f67152d, this.f67150b.getProductId(), "", this.f67154f, null, this.f67155g, null, null, PurchaseStatus.PAY_FAIL);
            this.f67149a.onPayStatus(PurchaseStatus.PAY_FAIL, bVar2);
            this.f67149a.onFail(i2, "pay fail! failReason:" + str, bVar2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f67154f;
        d.r.b.a.a.f.d.d.f("AppPayServiceImpl", String.format(Locale.ENGLISH, "---PayCallbackProxy, pay onFail: requestTime = %s, delay = %s, uid = %s, orderid = %s", Long.valueOf(j), (currentTimeMillis - j) + "", Long.valueOf(this.f67150b.getUid()), this.f67152d));
        d.r.b.a.a.f.f.b bVar3 = this.j;
        if (bVar3 != null) {
            bVar3.b("payingaddpaymentrespone", i2 + "", "pay fail! failReason:" + str, this.f67152d, "" + this.f67154f, this.f67150b.getProductId(), this.f67151c.getChannel(), this.f67150b.getTraceid());
        }
        d.r.b.a.a.f.d.d.h("AppPayServiceImpl", "payingaddpaymentrespone pay fail! failReason:" + str + " code:" + i2 + " orderId:" + this.f67152d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    /* renamed from: b */
    public void onSuccess(PurchaseInfo purchaseInfo, d.r.b.a.a.f.b bVar) {
        d.r.b.a.a.f.b bVar2;
        long currentTimeMillis = System.currentTimeMillis() - this.f67154f;
        if (purchaseInfo != null) {
            bVar2 = bVar == null ? new d.r.b.a.a.f.b(this.f67152d, this.f67150b.getProductId(), "", this.f67154f, null, this.f67155g, null, null, PurchaseStatus.PAY_SUCCESS) : bVar;
            this.f67149a.onSuccess("pay success!", bVar2);
            Locale locale = Locale.ENGLISH;
            d.r.b.a.a.f.d.d.f("AppPayServiceImpl", String.format(locale, "---PayCallbackProxy-pay-onSuccess: requestTime = %s, delay = %s, Uid =%s, OrderId =%s", Long.valueOf(this.f67154f), currentTimeMillis + "", Long.valueOf(this.f67150b.getUid()), this.f67152d));
        } else {
            bVar2 = bVar;
        }
        IPayCallback iPayCallback = this.f67149a;
        if (iPayCallback != null) {
            iPayCallback.onPayStatus(PurchaseStatus.PAY_SUCCESS, bVar2);
        }
        this.f67157i.i(this.f67150b, this.f67152d, this.f67156h);
        d.r.b.a.a.f.f.b bVar3 = this.j;
        if (bVar3 != null) {
            String str = this.f67152d;
            bVar3.b("payingaddpaymentrespone", "0", "pay success!", str, "" + this.f67154f, this.f67150b.getProductId(), this.f67151c.getChannel(), this.f67150b.getTraceid());
        }
        d.r.b.a.a.f.d.d.h("AppPayServiceImpl", "payingaddpaymentrespone pay success! orderId=" + this.f67152d);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onFail(int i2, String str, d.r.b.a.a.f.b bVar) {
        a(i2, str, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStart() {
        if (this.f67149a != null) {
            this.f67149a.onPayStatus(PurchaseStatus.PAY_START, new d.r.b.a.a.f.b(this.f67152d, this.f67150b.getProductId(), "", this.f67154f, d.r.b.a.a.j.e.a.a(this.f67155g), this.f67155g, null, null, PurchaseStatus.PAY_START));
            this.f67149a.onPayStart();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f67154f;
        Locale locale = Locale.ENGLISH;
        d.r.b.a.a.f.d.d.f("AppPayServiceImpl", String.format(locale, "---PayCallbackProxy-onPayStart: requestTime = %s, delay = %s, uid = %s, orderid = %s", Long.valueOf(j), (currentTimeMillis - j) + "", Long.valueOf(this.f67150b.getUid()), this.f67152d));
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStatus(PurchaseStatus purchaseStatus, d.r.b.a.a.f.b bVar) {
        this.f67149a.onPayStatus(purchaseStatus, bVar);
    }
}
