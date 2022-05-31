package com.repackage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.channel.model.jy.JYNativeAdView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import java.util.List;
/* loaded from: classes6.dex */
public class hf9 implements FunNativeAd2Bridger<qe9, JYNativeAdView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ kf9 a;
    public final /* synthetic */ gf9 b;

    public hf9(gf9 gf9Var, kf9 kf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gf9Var, kf9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = gf9Var;
        this.a = kf9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.fun.ad.sdk.channel.model.jy.JYNativeAdView, android.view.View] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public JYNativeAdView createExpressView(qe9 qe9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qe9Var)) == null) ? this.b.a(qe9Var) : (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, qe9 qe9Var, BaseNativeAd2<qe9, JYNativeAdView> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, qe9Var, baseNativeAd2, funAdInteractionListener}) == null) {
            qe9 qe9Var2 = qe9Var;
            ViewGroup inflate = customInflater.inflate();
            gf9 gf9Var = this.b;
            View view2 = this.a.d;
            List<View> clickViews = customInflater.getClickViews();
            gf9Var.d(qe9Var2, str, funAdInteractionListener);
            qe9Var2.d(inflate, view2, clickViews);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, qe9 qe9Var, BaseNativeAd2<qe9, JYNativeAdView> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, qe9Var, baseNativeAd2, funAdInteractionListener}) == null) {
            this.b.d(qe9Var, str, funAdInteractionListener);
            expressInflater.inflate();
        }
    }
}
