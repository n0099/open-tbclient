package d.r.b.a.a.i.e;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.i.c.j;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes7.dex */
public class a implements IPayMethod {
    public static final C1903a Companion = new C1903a(null);
    public static final String TAG = "DefaultPayMethod";

    /* renamed from: d.r.b.a.a.i.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1903a {
        public C1903a() {
        }

        public /* synthetic */ C1903a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void appHasReturnToForegroud() {
        d.h(TAG, "appHasReturnToForegroud be invoked but nothing could be done in DefaultPayMethod");
    }

    public void clearHangPayJob(Activity activity, int i2, IResult<PurchaseInfo> iResult) {
        d.h(TAG, "clearHangPayJob be invoked but nothing could be done in DefaultPayMethod");
    }

    public boolean doHangJob(PurchaseInfo purchaseInfo, IResult<String> iResult) {
        d.h(TAG, "doHangJob be invoked but nothing could be done in DefaultPayMethod");
        return false;
    }

    public boolean hasHangPayJobs(Activity activity, IResult<List<PurchaseInfo>> iResult) {
        d.h(TAG, "hasHangPayJobs be invoked but nothing could be done in DefaultPayMethod");
        return false;
    }

    public boolean hasHangSubscribeJobs(Activity activity, IResult<List<PurchaseInfo>> iResult) {
        d.h(TAG, "hasHangSubscribeJobs be invoked but nothing could be done in DefaultPayMethod");
        return false;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isPayingStatus() {
        d.h(TAG, "isPayingStatus be invoked but nothing could be done in DefaultPayMethod");
        return false;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isSupported(Activity activity) {
        d.h(TAG, "isSupported be invoked but nothing could be done in DefaultPayMethod");
        return false;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void onWxPayResult(int i2, String str) {
        d.h(TAG, "onWxPayResult be invoked but nothing could be done in DefaultPayMethod");
    }

    public boolean queryHistoryPurchaseByProductId(String str, IResult<PurchaseInfo> iResult) {
        d.h(TAG, "queryHistoryPurchaseByProductId be invoked but nothing could be done in DefaultPayMethod");
        return false;
    }

    public boolean queryHistoryPurchaseBySkuType(Activity activity, String str, IResult<List<PurchaseInfo>> iResult) {
        d.h(TAG, "requestPay be invoked but nothing could be done in DefaultPayMethod");
        if (iResult != null) {
            IPayMethod.Status status = IPayMethod.Status.ERROR;
            iResult.onFail(status.code, status.message, null);
            return false;
        }
        return false;
    }

    public boolean querySkuDetails(Activity activity, List<String> list, String str, IResult<List<Object>> iResult) {
        d.h(TAG, "querySkuDetailsAsync be invoked but nothing could be done in DefaultPayMethod");
        return false;
    }

    public void requestPay(Activity activity, long j, j jVar, String str, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        d.h(TAG, "requestPay be invoked but nothing could be done in DefaultPayMethod");
        if (iPayCallback != null) {
            IPayMethod.Status status = IPayMethod.Status.ERROR;
            iPayCallback.onFail(status.code, status.message, null);
        }
    }

    public void requestSubscription(Activity activity, long j, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        d.h(TAG, "requestSubscription be invoked but nothing could be done in DefaultPayMethod");
        if (iPayCallback != null) {
            IPayMethod.Status status = IPayMethod.Status.ERROR;
            iPayCallback.onFail(status.code, status.message, null);
        }
    }

    public void updateSubscription(Activity activity, long j, String str, String str2, int i2, String str3, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        d.h(TAG, "updateSubscription be invoked but nothing could be done in DefaultPayMethod");
        if (iPayCallback != null) {
            IPayMethod.Status status = IPayMethod.Status.ERROR;
            iPayCallback.onFail(status.code, status.message, null);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        d.h(TAG, "requestPay be invoked but nothing could be done in DefaultPayMethod");
        if (iPayCallback != null) {
            IPayMethod.Status status = IPayMethod.Status.ERROR;
            iPayCallback.onFail(status.code, status.message, null);
        }
    }
}
