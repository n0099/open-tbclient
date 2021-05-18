package d.r.b.a.a.j;

import android.app.Activity;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IReporter;
import com.yy.mobile.framework.revenuesdk.baseapi.router.RouterInfo;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ExchangeResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetUserYbDetailsResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.PayOrderResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.RechargeHistoryResult;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.ExchangeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetUserYbDetailsReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyChannelsReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryRechargeHistoryReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import com.yy.mobile.framework.revenuesdk.payservice.PayMethodFactory;
import d.r.b.a.a.f.f.a;
import d.r.b.a.a.f.h.f;
import d.r.b.a.a.f.h.g;
import d.r.b.a.a.i.c.i;
import d.r.b.a.a.i.c.j;
import d.r.b.a.a.i.d.e;
import d.r.b.a.a.i.d.h;
import d.r.b.a.a.j.b.d;
import d.r.b.a.a.j.d.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements IAppPayService, d.r.b.a.a.j.b.a, d.r.b.a.a.f.c.c, d.r.b.a.a.j.d.c {

    /* renamed from: a  reason: collision with root package name */
    public int f67818a;

    /* renamed from: c  reason: collision with root package name */
    public String f67820c;

    /* renamed from: d  reason: collision with root package name */
    public String f67821d;

    /* renamed from: e  reason: collision with root package name */
    public d.r.b.a.a.i.f.a f67822e;

    /* renamed from: f  reason: collision with root package name */
    public d f67823f;

    /* renamed from: g  reason: collision with root package name */
    public d.r.b.a.a.j.b.c f67824g;

    /* renamed from: h  reason: collision with root package name */
    public d.r.b.a.a.j.b.d f67825h;

    /* renamed from: i  reason: collision with root package name */
    public d.r.b.a.a.f.f.b f67826i;

    /* renamed from: b  reason: collision with root package name */
    public String f67819b = "";
    public List<d.r.b.a.a.i.b> j = new ArrayList();

    /* renamed from: d.r.b.a.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1900a implements d.InterfaceC1902d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f67827a;

        public C1900a(String str) {
            this.f67827a = str;
        }

        @Override // d.r.b.a.a.j.b.d.InterfaceC1902d
        public void a(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str) {
            if (a.this.f67826i != null) {
                a.this.f67826i.b("paychargeorderStatus", i2 + "", "poller fail! failReason:" + str, this.f67827a, "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
            }
            d.r.b.a.a.f.d.d.h("AppPayServiceImpl", "paychargeorderStatus onFail orderId:" + this.f67827a + " code:" + i2 + " failReason:" + str);
        }

        @Override // d.r.b.a.a.j.b.d.InterfaceC1902d
        public void b(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult) {
            if (a.this.f67826i != null) {
                a.this.f67826i.b("paychargeorderStatus", getChargeOrderStatusResult.getStatus() + "", "poller success!", this.f67827a, "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
            }
            d.r.b.a.a.f.d.d.h("AppPayServiceImpl", "paychargeorderStatus success orderId:" + this.f67827a);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChargeCurrencyReqParams f67829e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PayOrderResult f67830f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.r.b.a.a.f.b f67831g;

        public b(a aVar, ChargeCurrencyReqParams chargeCurrencyReqParams, PayOrderResult payOrderResult, d.r.b.a.a.f.b bVar) {
            this.f67829e = chargeCurrencyReqParams;
            this.f67830f = payOrderResult;
            this.f67831g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((IPayCallback) this.f67829e.getCallback()).onSuccess(this.f67830f, this.f67831g);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChargeCurrencyReqParams f67832e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.r.b.a.a.j.d.g.a f67833f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.r.b.a.a.f.b f67834g;

        public c(a aVar, ChargeCurrencyReqParams chargeCurrencyReqParams, d.r.b.a.a.j.d.g.a aVar2, d.r.b.a.a.f.b bVar) {
            this.f67832e = chargeCurrencyReqParams;
            this.f67833f = aVar2;
            this.f67834g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int responseCode = this.f67833f.getResponseCode();
            ((IPayCallback) this.f67832e.getCallback()).onFail(responseCode, "order fail, fialReason:" + this.f67833f.getMessage(), this.f67834g);
        }
    }

    public a(int i2, int i3, String str, String str2, String str3, String str4, boolean z, boolean z2, d.r.b.a.a.f.c.d dVar, IReporter iReporter, d.r.b.a.a.f.f.b bVar) {
        this.f67820c = "";
        this.f67821d = "";
        this.f67818a = i2;
        this.f67820c = str3;
        this.f67821d = str4;
        this.f67826i = bVar;
        this.f67823f = new d.r.b.a.a.j.d.d(i2, dVar, this, z);
        d.r.b.a.a.j.c.a aVar = new d.r.b.a.a.j.c.a(iReporter, str2, str);
        this.f67822e = aVar;
        this.f67824g = new d.r.b.a.a.j.b.c(aVar, this, this.f67820c, this.f67821d);
        this.f67825h = new d.r.b.a.a.j.b.d(this, this);
        d.r.b.a.a.f.d.d.f("AppPayServiceImpl", "construct versionName:4.1.4-bdpay");
    }

    @Override // d.r.b.a.a.j.b.a
    public void a(CurrencyChargeMessage currencyChargeMessage) {
        for (d.r.b.a.a.i.b bVar : this.j) {
            bVar.a(currencyChargeMessage);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addAlipaySdkProxy(d.r.b.a.a.i.d.c cVar) {
        d.r.b.a.a.i.e.c.d().a(PayType.ALI_PAY, cVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addDxmPaySdkProxy(e eVar) {
        d.r.b.a.a.i.e.c.d().a(PayType.DXM_PAY, eVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public synchronized void addPayListener(d.r.b.a.a.i.b bVar) {
        if (bVar != null) {
            this.j.add(bVar);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addWechatSdkProxy(h hVar) {
        d.r.b.a.a.i.e.c.d().a(PayType.WECHAT_PAY, hVar);
    }

    @Override // d.r.b.a.a.j.b.a
    public void b(d.r.b.a.a.i.c.c cVar) {
        for (d.r.b.a.a.i.b bVar : this.j) {
            bVar.b(cVar);
        }
    }

    @Override // d.r.b.a.a.j.b.a
    public void c(d.r.b.a.a.i.c.a aVar) {
        for (d.r.b.a.a.i.b bVar : this.j) {
            bVar.c(aVar);
        }
    }

    @Override // d.r.b.a.a.j.d.c
    public void d(int i2, d.r.b.a.a.j.d.g.a aVar) {
        d.r.b.a.a.f.d.d.g("AppPayServiceImpl", "onRevenueResponse command = %d", Integer.valueOf(i2));
        this.f67824g.t(i2, aVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void exchangeCurrency(@NonNull ExchangeCurrencyReqParams exchangeCurrencyReqParams, IResult<ExchangeResult> iResult) {
        if (n(exchangeCurrencyReqParams, iResult)) {
            exchangeCurrencyReqParams.setCallback(iResult);
            d.r.b.a.a.j.d.f.a i2 = this.f67823f.i(1025, exchangeCurrencyReqParams);
            i2.a(exchangeCurrencyReqParams);
            this.f67823f.l(i2);
        }
    }

    @Override // d.r.b.a.a.j.b.a
    public void f(String str, ChargeCurrencyReqParams chargeCurrencyReqParams, d.r.b.a.a.j.d.g.a aVar, d.r.b.a.a.j.d.f.a aVar2) {
    }

    @Override // d.r.b.a.a.f.c.c
    public void g(int i2, String str, int i3, int i4, String str2) {
        this.f67823f.g(i2, str, i3, i4, str2);
    }

    @Override // d.r.b.a.a.f.c.c
    public void h(int i2, d.r.b.a.a.f.e.b bVar) {
    }

    @Override // d.r.b.a.a.j.b.a
    public void i(ChargeCurrencyReqParams chargeCurrencyReqParams, String str, i iVar) {
        this.f67825h.f(chargeCurrencyReqParams, this.f67818a, str, iVar, new C1900a(str));
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isPayingStatus(PayType payType) {
        IPayMethod valueOf = PayMethodFactory.valueOf(payType);
        if (valueOf != null) {
            return valueOf.isPayingStatus();
        }
        return false;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isSupported(Activity activity, PayType payType) {
        IPayMethod valueOf = PayMethodFactory.valueOf(payType);
        if (valueOf != null) {
            return valueOf.isSupported(activity);
        }
        return false;
    }

    @Override // d.r.b.a.a.f.c.c
    public void j(int i2, d.r.b.a.a.f.e.e eVar) {
        this.f67823f.j(i2, eVar);
    }

    @Override // d.r.b.a.a.f.c.c
    public void k(int i2, d.r.b.a.a.f.e.d dVar) {
        this.f67823f.k(i2, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    @Override // d.r.b.a.a.j.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(d.r.b.a.a.j.d.g.a aVar, ChargeCurrencyReqParams chargeCurrencyReqParams, PayOrderResult payOrderResult, d.r.b.a.a.j.d.f.a aVar2, a.c cVar, long j) {
        IPayCallback iPayCallback;
        String str;
        if (aVar.a() && chargeCurrencyReqParams != null && payOrderResult != null) {
            d.r.b.a.a.f.d.d.h("AppPayServiceImpl", "payorder --- order sucess! orderid=" + payOrderResult.getOrderId());
            d.r.b.a.a.f.f.b bVar = this.f67826i;
            if (bVar != null) {
                bVar.b("payorder", aVar.getResponseCode() + "", "order success!" + aVar.getMessage(), payOrderResult.getOrderId(), "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
            }
            String payUrl = payOrderResult.getPayUrl();
            d.r.b.a.a.f.b bVar2 = new d.r.b.a.a.f.b(payOrderResult.getOrderId(), chargeCurrencyReqParams.getProductId(), null, chargeCurrencyReqParams.getRequestTime(), d.r.b.a.a.j.e.a.a(payUrl), payUrl, null, null, PurchaseStatus.ORDER_SUCCESS);
            if (chargeCurrencyReqParams.getPayType() == PayType.PAYTM_PAY) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    ((IPayCallback) chargeCurrencyReqParams.getCallback()).onSuccess(payOrderResult, bVar2);
                } else {
                    f.a().b().execute(new b(this, chargeCurrencyReqParams, payOrderResult, bVar2));
                }
                str = "order success!";
            } else {
                String closeRiskEnhance = payOrderResult.getCloseRiskEnhance();
                boolean z = closeRiskEnhance == null || !closeRiskEnhance.equals("true");
                IPayCallback iPayCallback2 = (IPayCallback) chargeCurrencyReqParams.getCallback();
                if (iPayCallback2 != null) {
                    iPayCallback2.onPayStatus(PurchaseStatus.ORDER_SUCCESS, bVar2);
                }
                str = "order success!";
                p(payOrderResult.getOrderId(), chargeCurrencyReqParams.getContext(), chargeCurrencyReqParams, chargeCurrencyReqParams.getPayType(), chargeCurrencyReqParams.getProductId(), payUrl, z, new d.r.b.a.a.j.b.b(chargeCurrencyReqParams.getPayType(), payOrderResult.getOrderId(), chargeCurrencyReqParams, payUrl, payOrderResult.getPollingModeInfo(), this.f67819b, this.f67826i, this, this, iPayCallback2));
            }
            if (this.f67822e != null) {
                cVar.f67711a = "1";
                cVar.f67716f = "支付下单成功";
                cVar.f67712b = aVar.getResponseCode() + "";
                cVar.f67713c = str + aVar.getMessage();
                this.f67822e.g(cVar);
                return;
            }
            return;
        }
        if (chargeCurrencyReqParams != null && payOrderResult != null) {
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl", "payorder -- order fail! orderid=" + payOrderResult.getOrderId() + " code=" + aVar.getResponseCode() + " errMsg=" + aVar.getMessage(), new Object[0]);
        } else {
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl", "payorder -- order fail ! code=" + aVar.getResponseCode() + "errMsg=" + aVar.getMessage(), new Object[0]);
        }
        d.r.b.a.a.f.b bVar3 = new d.r.b.a.a.f.b(null, chargeCurrencyReqParams.getProductId(), null, chargeCurrencyReqParams.getRequestTime(), null, null, null, null, PurchaseStatus.ORDER_FAIL);
        if (chargeCurrencyReqParams.getPayType() == PayType.PAYTM_PAY) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ((IPayCallback) chargeCurrencyReqParams.getCallback()).onFail(aVar.getResponseCode(), "order fail, fialReason:" + aVar.getMessage(), null);
            } else {
                f.a().b().execute(new c(this, chargeCurrencyReqParams, aVar, bVar3));
                if (chargeCurrencyReqParams != null && (iPayCallback = (IPayCallback) chargeCurrencyReqParams.getCallback()) != null) {
                    iPayCallback.onPayStatus(PurchaseStatus.ORDER_FAIL, bVar3);
                }
                this.f67824g.h(aVar2.e(), aVar.getResponseCode(), "order fial, fialReason:" + aVar.getMessage(), chargeCurrencyReqParams.getCallback(), bVar3);
                if (this.f67822e != null) {
                    cVar.f67711a = "2";
                    cVar.f67716f = "支付下单失败";
                    cVar.f67712b = aVar.getResponseCode() + "";
                    cVar.f67713c = "order fial, fialReason:" + aVar.getMessage();
                    this.f67822e.g(cVar);
                    cVar.f67711a = "101";
                    cVar.f67716f = "购买业务失败";
                    this.f67822e.d(cVar);
                }
                if (this.f67826i == null) {
                    String orderId = payOrderResult != null ? payOrderResult.getOrderId() : "";
                    this.f67826i.b("payorder", aVar.getResponseCode() + "", "order fial, fialReason:" + aVar.getMessage(), orderId, "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
                    return;
                }
                return;
            }
        }
        if (chargeCurrencyReqParams != null) {
            iPayCallback.onPayStatus(PurchaseStatus.ORDER_FAIL, bVar3);
        }
        this.f67824g.h(aVar2.e(), aVar.getResponseCode(), "order fial, fialReason:" + aVar.getMessage(), chargeCurrencyReqParams.getCallback(), bVar3);
        if (this.f67822e != null) {
        }
        if (this.f67826i == null) {
        }
    }

    public final boolean n(RequestParams requestParams, IResult iResult) {
        return (requestParams == null || iResult == null) ? false : true;
    }

    public final void o(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull j jVar, @NonNull PayType payType, int i2, int i3, int i4, IPayCallback iPayCallback) {
        String onUpdateToken;
        d.r.b.a.a.f.d.d.f("AppPayServiceImpl", "---doOrderRequest---");
        if (n(chargeCurrencyReqParams, iPayCallback)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!isSupported(activity, payType)) {
                iPayCallback.onFail(IPayMethod.Status.NOT_SUPPORT.getCode(), IPayMethod.Status.NOT_SUPPORT.getMessage(), new d.r.b.a.a.f.b(null, jVar.A, null, currentTimeMillis, null, null, null, null, PurchaseStatus.ORDER_FAIL));
                return;
            }
            chargeCurrencyReqParams.setContext(activity);
            chargeCurrencyReqParams.setCallback(iPayCallback);
            chargeCurrencyReqParams.setPayChannel(payType.getChannel());
            chargeCurrencyReqParams.setPayMethod(payType.getMethod());
            chargeCurrencyReqParams.setSrcAmount(jVar.f67793e.doubleValue());
            chargeCurrencyReqParams.setProductId(jVar.A);
            chargeCurrencyReqParams.setCid(jVar.f67789a);
            chargeCurrencyReqParams.setTraceid(g.a());
            ChargeCurrencyReqParams a2 = ChargeCurrencyReqParams.Companion.a(chargeCurrencyReqParams);
            a2.setPayChannel(payType.getChannel());
            a2.setPayMethod(payType.getMethod());
            a2.setSrcAmount(jVar.f67793e.doubleValue());
            a2.setProductId(jVar.A);
            a2.setCid(jVar.f67789a);
            a2.setRetryCount(i2);
            a2.setIntervalMs(i3);
            a2.setTimeOutMs(i4);
            a2.setPayType(payType);
            a2.setProductId(chargeCurrencyReqParams.getProductId());
            a2.setFrom(chargeCurrencyReqParams.getFrom());
            a2.setSubscriptionType(chargeCurrencyReqParams.getSubscriptionType());
            a2.setOldProductId(chargeCurrencyReqParams.getOldProductId());
            a2.setProrationMode(chargeCurrencyReqParams.getProrationMode());
            a2.setReturnUrl(chargeCurrencyReqParams.getReturnUrl());
            a2.setExpand(chargeCurrencyReqParams.getExpand());
            a2.setRequestTime(currentTimeMillis);
            a2.setTokenCallback(chargeCurrencyReqParams.getTokenCallback());
            a2.setTraceid(chargeCurrencyReqParams.getTraceid());
            a2.setFrom(chargeCurrencyReqParams.getFrom());
            IToken tokenCallback = chargeCurrencyReqParams.getTokenCallback();
            if (tokenCallback != null && (onUpdateToken = tokenCallback.onUpdateToken()) != null) {
                a2.setToken(onUpdateToken);
                d.r.b.a.a.f.d.d.f("AppPayServiceImpl", "doOrderRequest---newToken:" + onUpdateToken);
            }
            a2.setCid(chargeCurrencyReqParams.getCid());
            a2.setCurrencyType(chargeCurrencyReqParams.getCurrencyType());
            a2.setCurrencyType(chargeCurrencyReqParams.getCurrencyType());
            d.r.b.a.a.f.d.d.f("AppPayServiceImpl", "doOrderRequest---reqParams:" + a2.getPayType() + " " + a2.getSubscriptionType() + " " + a2.getCid() + "requestTime:" + currentTimeMillis + "--uid:" + a2.getUid() + "--productId:" + a2.getProductId());
            iPayCallback.onPayStatus(PurchaseStatus.ORDER_START, new d.r.b.a.a.f.b(null, a2.getProductId(), null, a2.getRequestTime(), null, null, null, null, PurchaseStatus.ORDER_START));
            d.r.b.a.a.j.d.f.a i5 = this.f67823f.i(1022, chargeCurrencyReqParams);
            i5.a(a2);
            this.f67823f.l(i5);
            a.c cVar = new a.c();
            cVar.f67715e = chargeCurrencyReqParams.getFrom();
            cVar.f67714d = chargeCurrencyReqParams.getUid();
            cVar.o = chargeCurrencyReqParams.getTraceid();
            cVar.m = this.f67819b;
            RouterInfo a3 = d.r.b.a.a.f.g.b.a(activity.getApplicationContext(), a2.getCmd());
            if (a3 == null) {
                cVar.k = this.f67820c;
                cVar.l = this.f67821d;
            } else {
                cVar.k = a3.serviceName;
                cVar.l = a3.functionName;
            }
            d.r.b.a.a.f.d.d.f("AppPayServiceImpl", "doOrderRequest---mServiceName:" + cVar.k + "---mFunctionName" + cVar.l);
            d.r.b.a.a.i.f.a aVar = this.f67822e;
            if (aVar != null) {
                cVar.f67711a = "0";
                cVar.f67716f = "支付请求";
                cVar.f67712b = "0";
                cVar.f67713c = "doOrderRequest";
                aVar.f(cVar);
            }
            d.r.b.a.a.f.f.b bVar = this.f67826i;
            if (bVar != null) {
                bVar.b("payingstart", "0", "doOrderRequest", "", "" + a2.getRequestTime(), jVar.A, payType.getChannel(), a2.getTraceid());
            }
            d.r.b.a.a.f.d.d.h("AppPayServiceImpl", "payingstart requestTime:" + a2.getRequestTime() + " paychannel:" + payType.getChannel());
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onWxPayResult(int i2, String str) {
        IPayMethod valueOf = PayMethodFactory.valueOf(PayType.WECHAT_PAY);
        if (valueOf != null) {
            valueOf.onWxPayResult(i2, str);
        }
    }

    public final void p(String str, Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, PayType payType, String str2, String str3, boolean z, IPayCallback iPayCallback) {
        PayMethodFactory.valueOf(payType).requestPay(activity, chargeCurrencyReqParams.getUid(), str2, str3, z, iPayCallback);
        d.r.b.a.a.f.d.d.h("AppPayServiceImpl", "payingaddpaymentrequest request sdk Pay orderId:" + str);
        d.r.b.a.a.f.f.b bVar = this.f67826i;
        if (bVar != null) {
            bVar.b("payingaddpaymentrequest", "0", "request sdk pay", str, "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull j jVar, @NonNull PayType payType, IPayCallback<String> iPayCallback) {
        payWithProductInfo(activity, chargeCurrencyReqParams, jVar, payType, 0, 0, 0, iPayCallback);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryChargeOrderStatus(@NonNull GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, IResult<GetChargeOrderStatusResult> iResult) {
        if (n(getChargeOrderStatusReqParams, iResult)) {
            getChargeOrderStatusReqParams.setCallback(iResult);
            getChargeOrderStatusReqParams.setRequestTime(System.currentTimeMillis());
            getChargeOrderStatusReqParams.setTraceid(g.a());
            d.r.b.a.a.j.d.f.a i2 = this.f67823f.i(1061, getChargeOrderStatusReqParams);
            i2.a(getChargeOrderStatusReqParams);
            this.f67823f.l(i2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryMyBalance(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult) {
        if (n(queryCurrencyReqParams, iResult)) {
            queryCurrencyReqParams.setCallback(iResult);
            d.r.b.a.a.j.d.f.a i2 = this.f67823f.i(1005, queryCurrencyReqParams);
            i2.a(queryCurrencyReqParams);
            this.f67823f.l(i2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductList(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        if (n(queryCurrencyReqParams, iResult)) {
            queryCurrencyReqParams.setCallback(iResult);
            queryCurrencyReqParams.setRequestTime(System.currentTimeMillis());
            queryCurrencyReqParams.setTraceid(g.a());
            d.r.b.a.a.j.d.f.a i2 = this.f67823f.i(1021, queryCurrencyReqParams);
            i2.a(queryCurrencyReqParams);
            this.f67823f.l(i2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductListChannels(@NonNull QueryCurrencyChannelsReqParams queryCurrencyChannelsReqParams, IResult<ProductListResult> iResult) {
        if (n(queryCurrencyChannelsReqParams, iResult)) {
            queryCurrencyChannelsReqParams.setCallback(iResult);
            queryCurrencyChannelsReqParams.setRequestTime(System.currentTimeMillis());
            queryCurrencyChannelsReqParams.setTraceid(g.a());
            d.r.b.a.a.j.d.f.a i2 = this.f67823f.i(1060, queryCurrencyChannelsReqParams);
            i2.a(queryCurrencyChannelsReqParams);
            this.f67823f.l(i2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryRechargeHistory(@NonNull QueryRechargeHistoryReqParams queryRechargeHistoryReqParams, IResult<RechargeHistoryResult> iResult) {
        if (n(queryRechargeHistoryReqParams, iResult)) {
            queryRechargeHistoryReqParams.setCallback(iResult);
            d.r.b.a.a.j.d.f.a i2 = this.f67823f.i(1054, queryRechargeHistoryReqParams);
            i2.a(queryRechargeHistoryReqParams);
            this.f67823f.l(i2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryUserYbDetailsRequest(@NonNull GetUserYbDetailsReqParams getUserYbDetailsReqParams, IResult<GetUserYbDetailsResult> iResult) {
        if (n(getUserYbDetailsReqParams, iResult)) {
            getUserYbDetailsReqParams.setCallback(iResult);
            getUserYbDetailsReqParams.setRequestTime(System.currentTimeMillis());
            getUserYbDetailsReqParams.setTraceid(g.a());
            d.r.b.a.a.j.d.f.a i2 = this.f67823f.i(1068, getUserYbDetailsReqParams);
            i2.a(getUserYbDetailsReqParams);
            this.f67823f.l(i2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void registerPayReporter(d.r.b.a.a.i.f.a aVar) {
        this.f67822e = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
        r0.remove();
     */
    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void removePayListener(d.r.b.a.a.i.b bVar) {
        Iterator<d.r.b.a.a.i.b> it = this.j.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (bVar == it.next()) {
                break;
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void reportPayEntrancePage(int i2) {
        this.f67819b = d.r.b.a.a.f.h.d.a();
        a.c cVar = new a.c();
        cVar.f67711a = "-10";
        cVar.f67716f = "支付入口页面";
        cVar.m = this.f67819b;
        cVar.f67715e = i2;
        cVar.f67712b = "0";
        cVar.f67713c = "pay-entrance-page（支付入口页面）";
        d.r.b.a.a.i.f.a aVar = this.f67822e;
        if (aVar != null) {
            aVar.a(cVar);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void requestPay(Activity activity, PayType payType, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        d.r.b.a.a.f.d.d.f("AppPayServiceImpl", "requstPay,payType:" + payType + ",productId:" + str + ",payload:" + str2);
        PayMethodFactory.valueOf(payType).requestPay(activity, 0L, str, str2, z, iPayCallback);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull j jVar, @NonNull PayType payType, int i2, int i3, int i4, IPayCallback<String> iPayCallback) {
        d.r.b.a.a.f.d.d.f("AppPayServiceImpl", "---payWithProductInfo---");
        o(activity, chargeCurrencyReqParams, jVar, payType, i2, i3, i4, iPayCallback);
    }
}
