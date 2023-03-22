package com.yy.mobile.framework.revenuesdk.baseapi;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes9.dex */
public interface IResult<T> {
    void onFail(int i, String str, PayCallBackBean payCallBackBean);

    void onSuccess(T t, PayCallBackBean payCallBackBean);
}
