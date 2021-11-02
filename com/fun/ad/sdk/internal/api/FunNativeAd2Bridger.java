package com.fun.ad.sdk.internal.api;

import android.app.Activity;
import android.view.View;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
/* loaded from: classes11.dex */
public interface FunNativeAd2Bridger<A, B extends View> {
    B createExpressView(A a2);

    void showCustom(Activity activity, CustomInflater customInflater, String str, A a2, BaseNativeAd2<A, B> baseNativeAd2, FunAdInteractionListener funAdInteractionListener);

    void showExpress(Activity activity, ExpressInflater expressInflater, String str, A a2, BaseNativeAd2<A, B> baseNativeAd2, FunAdInteractionListener funAdInteractionListener);
}
