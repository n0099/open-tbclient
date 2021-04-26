package d.r.b.a.a.l;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ExchangeResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetUserYbDetailsResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.RechargeHistoryResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.ExchangeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetUserYbDetailsReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyChannelsReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryRechargeHistoryReqParams;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.i.c.j;
import d.r.b.a.a.i.d.c;
import d.r.b.a.a.i.d.e;
import d.r.b.a.a.i.d.h;
/* loaded from: classes7.dex */
public final class b implements IAppPayService {
    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addAlipaySdkProxy(c cVar) {
        d.e("DefaultPayService", "addAlipaySdkProxy be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addDxmPaySdkProxy(e eVar) {
        d.e("DefaultPayService", "addDxmPaySdkProxy be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addPayListener(d.r.b.a.a.i.b bVar) {
        d.e("DefaultPayService", "addPayListener be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addWechatSdkProxy(h hVar) {
        d.e("DefaultPayService", "addWechatSdkProxy be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void exchangeCurrency(ExchangeCurrencyReqParams exchangeCurrencyReqParams, IResult<ExchangeResult> iResult) {
        d.e("DefaultPayService", "exchangeCurrency be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isPayingStatus(PayType payType) {
        d.e("DefaultPayService", "isPayingStatus be invoked but nothing could be done in DefaultPayService", new Object[0]);
        return false;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isSupported(Activity activity, PayType payType) {
        d.e("DefaultPayService", "isSupported be invoked but nothing could be done in DefaultPayService", new Object[0]);
        return false;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onWxPayResult(int i2, String str) {
        d.e("DefaultPayService", "onWxPayResult be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, j jVar, PayType payType, IPayCallback<String> iPayCallback) {
        d.e("DefaultPayService", "payWithProductInfo be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryChargeOrderStatus(GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, IResult<GetChargeOrderStatusResult> iResult) {
        d.e("DefaultPayService", "getChargeOrderStatus be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryMyBalance(QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult) {
        d.e("DefaultPayService", "queryMyBalance be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductList(QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        d.e("DefaultPayService", "queryProductList be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductListChannels(QueryCurrencyChannelsReqParams queryCurrencyChannelsReqParams, IResult<ProductListResult> iResult) {
        d.e("DefaultPayService", "queryProductListChannels be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryRechargeHistory(QueryRechargeHistoryReqParams queryRechargeHistoryReqParams, IResult<RechargeHistoryResult> iResult) {
        d.e("DefaultPayService", "queryRechargeHistory be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryUserYbDetailsRequest(GetUserYbDetailsReqParams getUserYbDetailsReqParams, IResult<GetUserYbDetailsResult> iResult) {
        d.e("DefaultPayService", "getUserYbDetailsRequest be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void registerPayReporter(d.r.b.a.a.i.f.a aVar) {
        d.e("DefaultPayService", "registerPayReporter be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void removePayListener(d.r.b.a.a.i.b bVar) {
        d.e("DefaultPayService", "removePayListener be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void reportPayEntrancePage(int i2) {
        d.e("DefaultPayService", "reportPayEntrancePage be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void requestPay(Activity activity, PayType payType, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        d.e("DefaultPayService", "requestPay be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, j jVar, PayType payType, int i2, int i3, int i4, IPayCallback<String> iPayCallback) {
        d.e("DefaultPayService", "payWithProductInfo be invoked but nothing could be done in DefaultPayService", new Object[0]);
    }
}
