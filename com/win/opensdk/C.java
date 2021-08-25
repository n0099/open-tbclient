package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class C implements PBVideoListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBVideo f76587a;

    public C(PBVideo pBVideo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBVideo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76587a = pBVideo;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBVideoListener pBVideoListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (pBVideoListener = this.f76587a.f76685c) == null) {
            return;
        }
        pBVideoListener.onClicked();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        PBVideoListener pBVideoListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) || (pBVideoListener = this.f76587a.f76685c) == null) {
            return;
        }
        pBVideoListener.onFail(pBError);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        PBVideoListener pBVideoListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pBVideoListener = this.f76587a.f76685c) == null) {
            return;
        }
        pBVideoListener.onLoaded();
    }

    @Override // com.win.opensdk.PBVideoListener
    public void onRewardedAdClosed() {
        PBVideoListener pBVideoListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pBVideoListener = this.f76587a.f76685c) == null) {
            return;
        }
        pBVideoListener.onRewardedAdClosed();
    }

    @Override // com.win.opensdk.PBVideoListener
    public void onRewardedAdOpened() {
        PBVideoListener pBVideoListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (pBVideoListener = this.f76587a.f76685c) == null) {
            return;
        }
        pBVideoListener.onRewardedAdOpened();
    }

    @Override // com.win.opensdk.PBVideoListener
    public void onRewardedShowFail(String str) {
        PBVideoListener pBVideoListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (pBVideoListener = this.f76587a.f76685c) == null) {
            return;
        }
        pBVideoListener.onRewardedShowFail(str);
    }

    @Override // com.win.opensdk.PBVideoListener
    public void onUserEarnedReward(boolean z, long j2) {
        PBVideoListener pBVideoListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) || (pBVideoListener = this.f76587a.f76685c) == null) {
            return;
        }
        pBVideoListener.onUserEarnedReward(z, j2);
    }
}
