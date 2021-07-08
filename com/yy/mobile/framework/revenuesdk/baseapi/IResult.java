package com.yy.mobile.framework.revenuesdk.baseapi;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes6.dex */
public interface IResult<T> {
    void onFail(int i2, String str, PayCallBackBean payCallBackBean);

    void onSuccess(T t, PayCallBackBean payCallBackBean);
}
