package com.yy.mobile.framework.revenuesdk.baseapi;
/* loaded from: classes8.dex */
public interface IResult {
    void onFail(int i, String str, PayCallBackBean payCallBackBean);

    void onSuccess(Object obj, PayCallBackBean payCallBackBean);
}
