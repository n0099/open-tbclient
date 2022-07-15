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
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.kwad.sdk.api.KsNativeAd;
import com.repackage.ph9;
/* loaded from: classes7.dex */
public class rh9 extends FunNativeAd2Bridger<KsNativeAd, com.fun.module.ks.x> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ph9.b b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ ph9 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rh9(ph9 ph9Var, ReporterPidLoader reporterPidLoader, KsNativeAd ksNativeAd, Context context) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ph9Var, reporterPidLoader, ksNativeAd, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ReporterPidLoader) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = ph9Var;
        this.c = context;
        this.b = new ph9.b(ph9Var, ksNativeAd);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.fun.module.ks.x] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.ks.x createExpressView(KsNativeAd ksNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ksNativeAd)) == null) ? this.d.e(this.c, ksNativeAd) : (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, KsNativeAd ksNativeAd, BaseNativeAd2<KsNativeAd, com.fun.module.ks.x> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, ksNativeAd, baseNativeAd2, funAdInteractionListener}) == null) {
            this.d.i(ksNativeAd, str, customInflater.inflate(), customInflater.getClickViews(), this.b, funAdInteractionListener);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, KsNativeAd ksNativeAd, BaseNativeAd2<KsNativeAd, com.fun.module.ks.x> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, ksNativeAd, baseNativeAd2, funAdInteractionListener}) == null) {
            this.d.i(ksNativeAd, str, expressInflater.inflate(), baseNativeAd2.getExpressView().getClickViews(), this.b, funAdInteractionListener);
        }
    }
}
