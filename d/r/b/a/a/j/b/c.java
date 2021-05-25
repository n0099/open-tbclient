package d.r.b.a.a.j.b;

import android.app.Activity;
import android.os.Looper;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.router.RouterInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.CouponDiscountResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ExchangeResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetUserYbDetailsResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.HasChargeInActivityResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.PayOrderResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.RechargeHistoryResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.RevenueRecordResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.UserCouponStoreResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import d.r.b.a.a.f.f.a;
import d.r.b.a.a.f.h.f;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a.a.i.f.a f67887a;

    /* renamed from: b  reason: collision with root package name */
    public d.r.b.a.a.j.b.a f67888b;

    /* renamed from: c  reason: collision with root package name */
    public String f67889c;

    /* renamed from: d  reason: collision with root package name */
    public String f67890d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.r.b.a.a.i.c.c f67891e;

        public a(d.r.b.a.a.i.c.c cVar) {
            this.f67891e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f67888b.b(this.f67891e);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CurrencyChargeMessage f67893e;

        public b(CurrencyChargeMessage currencyChargeMessage) {
            this.f67893e = currencyChargeMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f67888b.a(this.f67893e);
        }
    }

    /* renamed from: d.r.b.a.a.j.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1905c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.r.b.a.a.i.c.a f67895e;

        public RunnableC1905c(d.r.b.a.a.i.c.a aVar) {
            this.f67895e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f67888b.c(this.f67895e);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IResult f67897e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f67898f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.r.b.a.a.f.b f67899g;

        public d(c cVar, IResult iResult, Object obj, d.r.b.a.a.f.b bVar) {
            this.f67897e = iResult;
            this.f67898f = obj;
            this.f67899g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f67897e.onSuccess(this.f67898f, this.f67899g);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IResult f67900e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f67901f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f67902g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.r.b.a.a.f.b f67903h;

        public e(c cVar, IResult iResult, int i2, String str, d.r.b.a.a.f.b bVar) {
            this.f67900e = iResult;
            this.f67901f = i2;
            this.f67902g = str;
            this.f67903h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f67900e.onFail(this.f67901f, this.f67902g, this.f67903h);
        }
    }

    public c(d.r.b.a.a.i.f.a aVar, d.r.b.a.a.j.b.a aVar2, String str, String str2) {
        this.f67889c = "";
        this.f67890d = "";
        this.f67887a = aVar;
        this.f67888b = aVar2;
        this.f67889c = str;
        this.f67890d = str2;
    }

    public final <T> T b(Class<T> cls, d.r.b.a.a.j.d.g.a aVar) {
        Object b2 = aVar.b();
        if (b2 != null) {
            return cls.cast(b2);
        }
        return null;
    }

    public final void c(d.r.b.a.a.j.d.g.a aVar) {
        d.r.b.a.a.i.c.a aVar2 = (d.r.b.a.a.i.c.a) b(d.r.b.a.a.i.c.a.class, aVar);
        if (aVar2 == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f67888b.c(aVar2);
        } else {
            f.a().b().execute(new RunnableC1905c(aVar2));
        }
    }

    public final void d(d.r.b.a.a.j.d.g.a aVar) {
        d.r.b.a.a.i.c.c cVar = (d.r.b.a.a.i.c.c) b(d.r.b.a.a.i.c.c.class, aVar);
        if (cVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f67888b.b(cVar);
        } else {
            f.a().b().execute(new a(cVar));
        }
    }

    public final void e(d.r.b.a.a.j.d.g.a aVar) {
        CurrencyChargeMessage currencyChargeMessage = (CurrencyChargeMessage) b(CurrencyChargeMessage.class, aVar);
        if (currencyChargeMessage == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f67888b.a(currencyChargeMessage);
        } else {
            f.a().b().execute(new b(currencyChargeMessage));
        }
    }

    public final void f(d.r.b.a.a.j.d.g.a aVar) {
        d.r.b.a.a.j.d.f.a request = aVar.getRequest();
        d.r.b.a.a.f.d.d.f("AppPayServiceImpl", "---onErrorRespone---");
        if (request != null) {
            d.r.b.a.a.f.d.d.f("AppPayServiceImpl", "---onErrorRespone---onFail：" + aVar.getResponseCode());
            h("", aVar.getResponseCode(), aVar.getMessage(), ((RequestParams) request.c()).getCallback(), null);
        }
    }

    public final void g(d.r.b.a.a.j.d.g.a aVar) {
        d.r.b.a.a.j.d.f.a request = aVar.getRequest();
        ExchangeResult exchangeResult = (ExchangeResult) b(ExchangeResult.class, aVar);
        if (request != null) {
            RequestParams requestParams = (RequestParams) request.c();
            if (aVar.a() && exchangeResult != null) {
                u(requestParams, exchangeResult, null);
                d.r.b.a.a.f.d.d.f("AppPayServiceImpl-RespM", "onExchangeCurrency success");
                return;
            }
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-RespM", "onExchangeCurrency fail code = %d, errMsg = %s", Integer.valueOf(aVar.getResponseCode()), aVar.getMessage());
            h("", aVar.getResponseCode(), aVar.getMessage(), requestParams.getCallback(), null);
        }
    }

    public void h(String str, int i2, String str2, IResult iResult, d.r.b.a.a.f.b bVar) {
        if (iResult == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            iResult.onFail(i2, str2, bVar);
        } else {
            f.a().b().execute(new e(this, iResult, i2, str2, bVar));
        }
    }

    public final void i(d.r.b.a.a.j.d.g.a aVar) {
        d.r.b.a.a.j.d.f.a request = aVar.getRequest();
        CouponDiscountResult couponDiscountResult = (CouponDiscountResult) b(CouponDiscountResult.class, aVar);
        if (request != null) {
            RequestParams requestParams = (RequestParams) request.c();
            if (aVar.a() && couponDiscountResult != null) {
                d.r.b.a.a.f.d.d.f("AppPayServiceImpl-RespM", "onGetChargeCouponDiscount success");
                u(requestParams, couponDiscountResult, null);
                return;
            }
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-RespM", "onGetChargeCouponDiscount fail code = %d, errMsg = %s", Integer.valueOf(aVar.getResponseCode()), aVar.getMessage());
            h(request.e(), aVar.getResponseCode(), aVar.getMessage(), requestParams.getCallback(), null);
        }
    }

    public final void j(d.r.b.a.a.j.d.g.a aVar, int i2) {
        GetChargeOrderStatusResult getChargeOrderStatusResult = (GetChargeOrderStatusResult) b(GetChargeOrderStatusResult.class, aVar);
        d.r.b.a.a.j.d.f.a request = aVar.getRequest();
        a.c cVar = new a.c();
        if (request != null) {
            RequestParams requestParams = (RequestParams) request.c();
            if (aVar.a() && getChargeOrderStatusResult != null) {
                u(requestParams, getChargeOrderStatusResult, null);
                d.r.b.a.a.f.d.d.f("AppPayServiceImpl-RespM", "onGetChargeOrderStatus success");
                if (this.f67887a != null) {
                    cVar.f67754a = "-11";
                    cVar.f67759f = "查询充值订单状态成功";
                    cVar.f67755b = aVar.getResponseCode() + "";
                    cVar.f67756c = "onQueryChargeOrderStatus success!" + aVar.getMessage();
                    this.f67887a.e(cVar);
                    return;
                }
                return;
            }
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-RespM", "onGetChargeOrderStatus fail code = %d, errMsg = %s", Integer.valueOf(aVar.getResponseCode()), aVar.getMessage());
            h("", aVar.getResponseCode(), aVar.getMessage(), requestParams.getCallback(), null);
            if (this.f67887a != null) {
                cVar.f67754a = "-12";
                cVar.f67759f = "查询充值订单状态失败";
                cVar.f67755b = aVar.getResponseCode() + "";
                cVar.f67756c = "onQueryChargeOrderStatus fail!" + aVar.getMessage();
                this.f67887a.c(cVar);
            }
        }
    }

    public final void k(d.r.b.a.a.j.d.g.a aVar) {
        d.r.b.a.a.j.d.f.a request = aVar.getRequest();
        HasChargeInActivityResult hasChargeInActivityResult = (HasChargeInActivityResult) b(HasChargeInActivityResult.class, aVar);
        if (request != null) {
            RequestParams requestParams = (RequestParams) request.c();
            if (aVar.a() && hasChargeInActivityResult != null) {
                d.r.b.a.a.f.d.d.f("AppPayServiceImpl-RespM", "onGetHasChargeInActivity success");
                u(requestParams, hasChargeInActivityResult, null);
                return;
            }
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-RespM", "onGetHasChargeInActivity fail code = %d, errMsg = %s", Integer.valueOf(aVar.getResponseCode()), aVar.getMessage());
            h(request.e(), aVar.getResponseCode(), aVar.getMessage(), requestParams.getCallback(), null);
        }
    }

    public final void l(d.r.b.a.a.j.d.g.a aVar) {
        d.r.b.a.a.j.d.f.a request = aVar.getRequest();
        UserCouponStoreResult userCouponStoreResult = (UserCouponStoreResult) b(UserCouponStoreResult.class, aVar);
        if (request != null) {
            RequestParams requestParams = (RequestParams) request.c();
            if (aVar.a() && userCouponStoreResult != null) {
                d.r.b.a.a.f.d.d.f("AppPayServiceImpl-RespM", "onGetUserCouponStore success");
                u(requestParams, userCouponStoreResult, null);
                return;
            }
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-RespM", "onGetUserCouponStore fail code = %d, errMsg = %s", Integer.valueOf(aVar.getResponseCode()), aVar.getMessage());
            h(request.e(), aVar.getResponseCode(), aVar.getMessage(), requestParams.getCallback(), null);
        }
    }

    public final void m(d.r.b.a.a.j.d.g.a aVar, int i2) {
        GetUserYbDetailsResult getUserYbDetailsResult = (GetUserYbDetailsResult) b(GetUserYbDetailsResult.class, aVar);
        d.r.b.a.a.j.d.f.a request = aVar.getRequest();
        a.c cVar = new a.c();
        if (request != null) {
            RequestParams requestParams = (RequestParams) request.c();
            if (aVar.a() && getUserYbDetailsResult != null) {
                u(requestParams, getUserYbDetailsResult, null);
                d.r.b.a.a.f.d.d.f("AppPayServiceImpl-RespM", "onGetUserYbDetails success");
                if (this.f67887a != null) {
                    cVar.f67754a = "-13";
                    cVar.f67759f = "查询Y币明细成功";
                    cVar.f67755b = aVar.getResponseCode() + "";
                    cVar.f67756c = "onQueryUserYbDetails success!" + aVar.getMessage();
                    this.f67887a.c(cVar);
                    return;
                }
                return;
            }
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-RespM", "onGetChargeOrderStatus fail code = %d, errMsg = %s", Integer.valueOf(aVar.getResponseCode()), aVar.getMessage());
            h("", aVar.getResponseCode(), aVar.getMessage(), requestParams.getCallback(), null);
            if (this.f67887a != null) {
                cVar.f67754a = "-14";
                cVar.f67759f = "查询Y币明细失败";
                cVar.f67755b = aVar.getResponseCode() + "";
                cVar.f67756c = "onQueryUserYbDetails fail!" + aVar.getMessage();
                this.f67887a.c(cVar);
            }
        }
    }

    public final void n(d.r.b.a.a.j.d.g.a aVar, int i2) {
        d.r.b.a.a.j.d.f.a request = aVar.getRequest();
        PayOrderResult payOrderResult = (PayOrderResult) b(PayOrderResult.class, aVar);
        if (request != null) {
            ChargeCurrencyReqParams chargeCurrencyReqParams = (ChargeCurrencyReqParams) request.c();
            a.c cVar = new a.c();
            long j = 0;
            if (chargeCurrencyReqParams != null) {
                cVar.f67758e = chargeCurrencyReqParams.getFrom();
                cVar.f67757d = chargeCurrencyReqParams.getUid();
                j = System.currentTimeMillis() - chargeCurrencyReqParams.getRequestTime();
                cVar.f67760g = j + "";
                RouterInfo routerInfo = null;
                Activity context = chargeCurrencyReqParams.getContext();
                if (context != null) {
                    int b2 = request.b();
                    d.r.b.a.a.f.d.d.f("AppPayServiceImpl", "onOrderProduct---getRouterInfo  cmd:" + chargeCurrencyReqParams.getCmd() + "iRequest.getReqCommand:" + b2);
                    if (b2 == 0) {
                        b2 = 1022;
                    }
                    routerInfo = d.r.b.a.a.f.g.b.a(context.getApplicationContext(), b2);
                } else {
                    d.r.b.a.a.f.d.d.e("AppPayServiceImpl", "onOrderProduct---context = null:", new Object[0]);
                }
                if (routerInfo == null) {
                    cVar.k = this.f67889c;
                    cVar.l = this.f67890d;
                } else {
                    cVar.k = routerInfo.serviceName;
                    cVar.l = routerInfo.functionName;
                }
            }
            long j2 = j;
            d.r.b.a.a.f.d.d.f("AppPayServiceImpl", "onOrderProduct---mDefalutServiceName:" + this.f67889c + "---mDefalutFunctionName:" + this.f67890d + "---mRealFunctionName:" + cVar.k + "---mRealFunctionName:" + cVar.l);
            if (payOrderResult != null) {
                cVar.f67761h = payOrderResult.getOrderId();
            }
            if (chargeCurrencyReqParams != null) {
                if (payOrderResult != null) {
                    String b3 = d.r.b.a.a.j.e.a.b(payOrderResult.getExpand());
                    if (b3 != null && !b3.equals("")) {
                        this.f67888b.f(b3, chargeCurrencyReqParams, aVar, request);
                        return;
                    } else {
                        this.f67888b.l(aVar, chargeCurrencyReqParams, payOrderResult, request, cVar, j2);
                        return;
                    }
                }
                this.f67888b.l(aVar, chargeCurrencyReqParams, null, request, cVar, j2);
            }
        }
    }

    public final void o(d.r.b.a.a.j.d.g.a aVar, int i2) {
        d.r.b.a.a.j.d.f.a request = aVar.getRequest();
        ProductListResult productListResult = (ProductListResult) b(ProductListResult.class, aVar);
        a.c cVar = new a.c();
        if (request != null) {
            RequestParams requestParams = (RequestParams) request.c();
            if (aVar.a() && productListResult != null) {
                d.r.b.a.a.f.d.d.f("AppPayServiceImpl-RespM", "onQueryProductList success");
                u(requestParams, productListResult, null);
                if (this.f67887a != null) {
                    cVar.f67754a = "-5";
                    cVar.f67759f = "获取配置列表成功";
                    cVar.f67755b = aVar.getResponseCode() + "";
                    cVar.f67756c = "queryProductList success!" + aVar.getMessage();
                    this.f67887a.b(cVar);
                    return;
                }
                return;
            }
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-RespM", "onQueryProductList fail code = %d, errMsg = %s", Integer.valueOf(aVar.getResponseCode()), aVar.getMessage());
            h(request.e(), aVar.getResponseCode(), aVar.getMessage(), requestParams.getCallback(), null);
            if (this.f67887a != null) {
                cVar.f67754a = "-4";
                cVar.f67759f = "获取配置列表失败";
                cVar.f67755b = aVar.getResponseCode() + "";
                cVar.f67756c = "queryProductList fail!" + aVar.getMessage();
                this.f67887a.b(cVar);
            }
        }
    }

    public final void p(d.r.b.a.a.j.d.g.a aVar, int i2) {
        d.r.b.a.a.j.d.f.a request = aVar.getRequest();
        ProductListResult productListResult = (ProductListResult) b(ProductListResult.class, aVar);
        a.c cVar = new a.c();
        if (request != null) {
            RequestParams requestParams = (RequestParams) request.c();
            if (aVar.a() && productListResult != null) {
                d.r.b.a.a.f.d.d.f("AppPayServiceImpl-RespM", "onQueryProductChannelsList success");
                u(requestParams, productListResult, null);
                if (this.f67887a != null) {
                    cVar.f67754a = "-5";
                    cVar.f67759f = "获取配置列表成功";
                    cVar.f67755b = aVar.getResponseCode() + "";
                    cVar.f67756c = "onQueryProductListChannels success!" + aVar.getMessage();
                    this.f67887a.b(cVar);
                    return;
                }
                return;
            }
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-RespM", "onQueryProductChannelsList fail code = %d, errMsg = %s", Integer.valueOf(aVar.getResponseCode()), aVar.getMessage());
            h(request.e(), aVar.getResponseCode(), aVar.getMessage(), requestParams.getCallback(), null);
            if (this.f67887a != null) {
                cVar.f67754a = "-4";
                cVar.f67759f = "获取配置列表失败";
                cVar.f67755b = aVar.getResponseCode() + "";
                cVar.f67756c = "onQueryProductListChannels fail!" + aVar.getMessage();
                this.f67887a.b(cVar);
            }
        }
    }

    public final void q(d.r.b.a.a.j.d.g.a aVar) {
        d.r.b.a.a.j.d.f.a request = aVar.getRequest();
        RechargeHistoryResult rechargeHistoryResult = (RechargeHistoryResult) b(RechargeHistoryResult.class, aVar);
        if (request != null) {
            RequestParams requestParams = (RequestParams) request.c();
            if (aVar.a() && rechargeHistoryResult != null) {
                u(requestParams, rechargeHistoryResult, null);
                d.r.b.a.a.f.d.d.f("AppPayServiceImpl-RespM", "onQueryRechargeHistory success");
                return;
            }
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-RespM", "onQueryRechargeHistory fail code = %d, errMsg = %s", Integer.valueOf(aVar.getResponseCode()), aVar.getMessage());
            h("", aVar.getResponseCode(), aVar.getMessage(), requestParams.getCallback(), null);
        }
    }

    public final void r(d.r.b.a.a.j.d.g.a aVar) {
        d.r.b.a.a.j.d.f.a request = aVar.getRequest();
        MyBalanceResult myBalanceResult = (MyBalanceResult) b(MyBalanceResult.class, aVar);
        if (request != null) {
            RequestParams requestParams = (RequestParams) request.c();
            if (aVar.a() && myBalanceResult != null) {
                u(requestParams, myBalanceResult, null);
                d.r.b.a.a.f.d.d.f("AppPayServiceImpl-RespM", "onQueryUserAccount success");
                return;
            }
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-RespM", "onQueryUserAccount fail code = %d, errMsg = %s", Integer.valueOf(aVar.getResponseCode()), aVar.getMessage());
            h("", aVar.getResponseCode(), aVar.getMessage(), requestParams.getCallback(), null);
        }
    }

    public final void s(d.r.b.a.a.j.d.g.a aVar) {
        d.r.b.a.a.j.d.f.a request = aVar.getRequest();
        RevenueRecordResult revenueRecordResult = (RevenueRecordResult) b(RevenueRecordResult.class, aVar);
        if (request != null) {
            RequestParams requestParams = (RequestParams) request.c();
            if (aVar.a() && revenueRecordResult != null) {
                d.r.b.a.a.f.d.d.f("AppPayServiceImpl-RespM", "onQueryUserAccountHistory success");
                u(requestParams, revenueRecordResult, null);
                return;
            }
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-RespM", "onQueryUserAccountHistory fail code = %d, errMsg = %s", Integer.valueOf(aVar.getResponseCode()), aVar.getMessage());
            h("", aVar.getResponseCode(), aVar.getMessage(), requestParams.getCallback(), null);
        }
    }

    public void t(int i2, d.r.b.a.a.j.d.g.a aVar) {
        d.r.b.a.a.f.d.d.g("AppPayServiceImpl-RespM", "onRevenueResponse command = %d", Integer.valueOf(i2));
        if (i2 == 1005) {
            r(aVar);
        } else if (i2 == 1052) {
            i(aVar);
        } else if (i2 == 1054) {
            q(aVar);
        } else if (i2 == 1068) {
            m(aVar, 1068);
        } else if (i2 == 40423235) {
            d(aVar);
        } else if (i2 == 40423898) {
            e(aVar);
        } else if (i2 == 40424536) {
            c(aVar);
        } else if (i2 == 1021) {
            o(aVar, 1021);
        } else if (i2 == 1022) {
            n(aVar, 1022);
        } else if (i2 == 1025) {
            g(aVar);
        } else if (i2 == 1026) {
            k(aVar);
        } else if (i2 == 1046) {
            s(aVar);
        } else if (i2 == 1047) {
            l(aVar);
        } else if (i2 == 1060) {
            p(aVar, 1060);
        } else if (i2 != 1061) {
            f(aVar);
        } else {
            j(aVar, 1061);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> void u(RequestParams requestParams, T t, d.r.b.a.a.f.b bVar) {
        IResult<?> callback;
        if (requestParams == null || (callback = requestParams.getCallback()) == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            callback.onSuccess(t, bVar);
        } else {
            f.a().b().execute(new d(this, callback, t, bVar));
        }
    }
}
