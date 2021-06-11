package com.yy.mobile.framework.revenuesdk.payapi.payservice;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SkuDetailInfo;
import java.util.List;
/* loaded from: classes7.dex */
public interface IPayMethod {

    /* loaded from: classes7.dex */
    public enum Status {
        OK(0, EventAlias.PayEventAlias.PAY_SUCCESS),
        NOT_SUPPORT(-101, "当前不支持该种支付方式"),
        ERROR(-102, "支付错误"),
        UNKNOWN(-103, "未知错误");
        
        public final int code;
        public final String message;

        Status(int i2, String str) {
            this.code = i2;
            this.message = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static Status valueOf(int i2) {
            if (i2 != 0) {
                switch (i2) {
                    case -103:
                        return UNKNOWN;
                    case -102:
                        return ERROR;
                    case -101:
                        return NOT_SUPPORT;
                    default:
                        return UNKNOWN;
                }
            }
            return OK;
        }
    }

    void appHasReturnToForegroud();

    void clearHangPayJob(Activity activity, int i2, IResult<PurchaseInfo> iResult);

    boolean doHangJob(@NonNull PurchaseInfo purchaseInfo, IResult<String> iResult);

    boolean hasHangPayJobs(Activity activity, IResult<List<PurchaseInfo>> iResult);

    boolean hasHangSubscribeJobs(Activity activity, IResult<List<PurchaseInfo>> iResult);

    boolean isPayingStatus();

    boolean isSupported(Activity activity);

    void onWxPayResult(int i2, String str);

    boolean queryHistoryPurchaseByProductId(String str, IResult<PurchaseInfo> iResult);

    boolean queryHistoryPurchaseBySkuType(@NonNull Activity activity, String str, IResult<List<PurchaseInfo>> iResult);

    boolean querySkuDetails(Activity activity, List<String> list, String str, IResult<List<SkuDetailInfo>> iResult);

    void requestPay(Activity activity, long j, ProductInfo productInfo, String str, boolean z, IPayCallback<PurchaseInfo> iPayCallback);

    void requestPay(Activity activity, long j, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback);

    void requestSubscription(Activity activity, long j, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback);

    void updateSubscription(Activity activity, long j, String str, String str2, int i2, String str3, boolean z, IPayCallback<PurchaseInfo> iPayCallback);
}
