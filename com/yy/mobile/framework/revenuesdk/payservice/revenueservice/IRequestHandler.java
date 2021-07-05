package com.yy.mobile.framework.revenuesdk.payservice.revenueservice;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IRequestHandler;", "Lkotlin/Any;", "", "command", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/IResponse;", "response", "", "onResponse", "(ILcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/IResponse;)V", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "", IAdRequestParam.SEQ, "", "data", "sendData", "(ILjava/lang/String;[B)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public interface IRequestHandler {
    void onResponse(int i2, IResponse iResponse);

    void sendData(int i2, String str, byte[] bArr);
}
