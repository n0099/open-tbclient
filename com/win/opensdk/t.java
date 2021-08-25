package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class t implements PBNativeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBNative f76994a;

    public t(PBNative pBNative) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBNative};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76994a = pBNative;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBNativeListener pBNativeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (pBNativeListener = this.f76994a.f76672b) == null) {
            return;
        }
        pBNativeListener.onClicked();
    }

    @Override // com.win.opensdk.PBNativeListener
    public void onDisplayed() {
        PBNativeListener pBNativeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pBNativeListener = this.f76994a.f76672b) == null) {
            return;
        }
        pBNativeListener.onDisplayed();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        PBNativeListener pBNativeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) || (pBNativeListener = this.f76994a.f76672b) == null) {
            return;
        }
        pBNativeListener.onFail(pBError);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        PBNativeListener pBNativeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pBNativeListener = this.f76994a.f76672b) == null) {
            return;
        }
        pBNativeListener.onLoaded();
    }
}
