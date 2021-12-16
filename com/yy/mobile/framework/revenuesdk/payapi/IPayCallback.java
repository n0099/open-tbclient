package com.yy.mobile.framework.revenuesdk.payapi;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;", "T", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;", "Lkotlin/Any;", "", "onPayStart", "()V", "Lcom/yy/mobile/framework/revenuesdk/baseapi/PurchaseStatus;", "status", "Lcom/yy/mobile/framework/revenuesdk/baseapi/PayCallBackBean;", "payCallBackBean", "onPayStatus", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/PurchaseStatus;Lcom/yy/mobile/framework/revenuesdk/baseapi/PayCallBackBean;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface IPayCallback<T> extends IResult<T> {
    void onPayStart();

    void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean);
}
