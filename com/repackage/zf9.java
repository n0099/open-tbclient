package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.kwad.sdk.api.KsNativeAd;
import com.repackage.xf9;
/* loaded from: classes7.dex */
public class zf9 implements FunNativeAd2Bridger<KsNativeAd, com.fun.module.ks.x> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xf9.b a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ xf9 c;

    public zf9(xf9 xf9Var, KsNativeAd ksNativeAd, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xf9Var, ksNativeAd, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = xf9Var;
        this.b = context;
        this.a = new xf9.b(xf9Var, ksNativeAd);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.fun.module.ks.x] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.ks.x createExpressView(KsNativeAd ksNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ksNativeAd)) == null) ? this.c.a(this.b, ksNativeAd) : (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, KsNativeAd ksNativeAd, BaseNativeAd2<KsNativeAd, com.fun.module.ks.x> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, ksNativeAd, baseNativeAd2, funAdInteractionListener}) == null) {
            this.c.f(ksNativeAd, str, customInflater.inflate(), customInflater.getClickViews(), this.a, funAdInteractionListener);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, KsNativeAd ksNativeAd, BaseNativeAd2<KsNativeAd, com.fun.module.ks.x> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, ksNativeAd, baseNativeAd2, funAdInteractionListener}) == null) {
            this.c.f(ksNativeAd, str, expressInflater.inflate(), baseNativeAd2.getExpressView().getClickViews(), this.a, funAdInteractionListener);
        }
    }
}
