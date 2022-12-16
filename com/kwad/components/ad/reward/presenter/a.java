package com.kwad.components.ad.reward.presenter;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes8.dex */
public class a extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.k nM;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            int i = z ? 1 : 153;
            com.kwad.components.ad.reward.k kVar = this.nM;
            com.kwad.sdk.core.report.a.a(kVar.mAdTemplate, i, kVar.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
            this.nM.mAdOpenInteractionListener.bB();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            this.nM = (com.kwad.components.ad.reward.k) xR();
        }
    }

    public final void gR() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (activity = this.nM.getActivity()) == null) {
            return;
        }
        activity.finish();
    }
}
