package com.yy.mobile.framework.revenuesdk.baseapi;

import androidx.annotation.Keep;
import d.r.b.a.a.f.b;
@Keep
/* loaded from: classes7.dex */
public interface IResult<T> {
    void onFail(int i2, String str, b bVar);

    void onSuccess(T t, b bVar);
}
