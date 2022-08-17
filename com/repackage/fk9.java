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
import com.kwad.sdk.api.KsDrawAd;
import com.repackage.dk9;
/* loaded from: classes6.dex */
public class fk9 extends FunNativeAd2Bridger<KsDrawAd, View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public final dk9.b c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ dk9 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fk9(dk9 dk9Var, ReporterPidLoader reporterPidLoader, KsDrawAd ksDrawAd, String str, Context context) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dk9Var, reporterPidLoader, ksDrawAd, str, context};
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
        this.e = dk9Var;
        this.d = context;
        this.c = new dk9.b(dk9Var, ksDrawAd, str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public View createExpressView(KsDrawAd ksDrawAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ksDrawAd)) == null) ? ksDrawAd.getDrawView(this.d) : (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, KsDrawAd ksDrawAd, BaseNativeAd2<KsDrawAd, View> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, ksDrawAd, baseNativeAd2, funAdInteractionListener}) == null) {
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, KsDrawAd ksDrawAd, BaseNativeAd2<KsDrawAd, View> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, ksDrawAd, baseNativeAd2, funAdInteractionListener}) == null) {
            KsDrawAd ksDrawAd2 = ksDrawAd;
            this.e.onShowStart(ksDrawAd2, this.b);
            this.b = true;
            dk9.b bVar = this.c;
            bVar.e = funAdInteractionListener;
            ksDrawAd2.setAdInteractionListener(bVar);
            expressInflater.inflate();
        }
    }
}
