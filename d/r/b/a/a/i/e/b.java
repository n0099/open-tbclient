package d.r.b.a.a.i.e;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.i.c.j;
/* loaded from: classes7.dex */
public class b extends a {
    @Override // d.r.b.a.a.i.e.a
    public void clearHangPayJob(Activity activity, int i2, IResult<PurchaseInfo> iResult) {
        d.e("H5PayMethod", "clearHangPayJob be invoked but nothing could be done in H5PayMethod", new Object[0]);
    }

    @Override // d.r.b.a.a.i.e.a
    public boolean doHangJob(PurchaseInfo purchaseInfo, IResult<String> iResult) {
        d.e("H5PayMethod", "doHangJob be invoked but nothing could be done in H5PayMethod", new Object[0]);
        return false;
    }

    @Override // d.r.b.a.a.i.e.a, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isPayingStatus() {
        d.e("H5PayMethod", "isPayingStatus be invoked but nothing could be done in H5PayMethod", new Object[0]);
        return false;
    }

    @Override // d.r.b.a.a.i.e.a, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isSupported(Activity activity) {
        d.e("H5PayMethod", "isSupported be invoked but nothing could be done in H5PayMethod", new Object[0]);
        return true;
    }

    @Override // d.r.b.a.a.i.e.a, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void onWxPayResult(int i2, String str) {
        d.e("H5PayMethod", "onWxPayResult be invoked but nothing could be done in H5PayMethod", new Object[0]);
    }

    @Override // d.r.b.a.a.i.e.a
    public boolean queryHistoryPurchaseByProductId(String str, IResult<PurchaseInfo> iResult) {
        d.e("H5PayMethod", "queryHistoryPurchaseByProductId be invoked but nothing could be done in H5PayMethod", new Object[0]);
        return false;
    }

    @Override // d.r.b.a.a.i.e.a
    public void requestPay(Activity activity, long j, j jVar, String str, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        d.e("H5PayMethod", "requestPay be invoked but nothing could be done in H5PayMethod", new Object[0]);
        if (iPayCallback != null) {
            IPayMethod.Status status = IPayMethod.Status.ERROR;
            iPayCallback.onFail(status.code, status.message, null);
        }
    }

    @Override // d.r.b.a.a.i.e.a
    public void requestSubscription(Activity activity, long j, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        d.e("H5PayMethod", "requestSubscription be invoked but nothing could be done in H5PayMethod", new Object[0]);
        if (iPayCallback != null) {
            IPayMethod.Status status = IPayMethod.Status.ERROR;
            iPayCallback.onFail(status.code, status.message, null);
        }
    }

    @Override // d.r.b.a.a.i.e.a
    public void updateSubscription(Activity activity, long j, String str, String str2, int i2, String str3, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        d.e("H5PayMethod", "updateSubscription be invoked but nothing could be done in H5PayMethod", new Object[0]);
        if (iPayCallback != null) {
            IPayMethod.Status status = IPayMethod.Status.ERROR;
            iPayCallback.onFail(status.code, status.message, null);
        }
    }

    @Override // d.r.b.a.a.i.e.a, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        d.e("H5PayMethod", "requestPay be invoked but nothing could be done in H5PayMethod", new Object[0]);
        if (iPayCallback != null) {
            IPayMethod.Status status = IPayMethod.Status.ERROR;
            iPayCallback.onFail(status.code, status.message, null);
        }
    }
}
