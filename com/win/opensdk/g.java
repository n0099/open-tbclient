package com.win.opensdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f39578a;

    public g(PBSplash pBSplash) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBSplash};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39578a = pBSplash;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f39578a.k = true;
            PBSplashListener pBSplashListener = this.f39578a.f39446e;
            if (pBSplashListener != null) {
                pBSplashListener.onClicked();
            }
        }
    }

    @Override // com.win.opensdk.r
    public void onDisplayed() {
        PBSplashListener pBSplashListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pBSplashListener = this.f39578a.f39446e) == null) {
            return;
        }
        pBSplashListener.onDisplayed();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                PBSplashListener pBSplashListener = this.f39578a.f39446e;
                if (pBSplashListener != null) {
                    pBSplashListener.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            PBSplash pBSplash = this.f39578a;
            PBSplashListener pBSplashListener2 = pBSplash.f39446e;
            if (pBSplashListener2 == null || pBSplash.j) {
                return;
            }
            pBSplashListener2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f39578a.f39443b.c()) {
            PBSplash pBSplash = this.f39578a;
            Context context = pBSplash.f39442a;
            Y0 y0 = pBSplash.f39443b.f39633a;
            s1.c(context, (y0 == null || !y0.b()) ? 0L : y0.f39522c.getLo_timeout());
            String str = "";
            if (this.f39578a.f39443b.b().equals("image")) {
                Y0 y02 = this.f39578a.f39443b.f39633a;
                if (y02 != null && y02.b()) {
                    str = y02.f39522c.getLoad();
                }
                this.f39578a.b(str);
            } else if (this.f39578a.f39443b.b().equals("gif")) {
                Y0 y03 = this.f39578a.f39443b.f39633a;
                if (y03 != null && y03.b()) {
                    str = y03.f39522c.getLoad();
                }
                this.f39578a.a(str);
            } else {
                PBSplashListener pBSplashListener = this.f39578a.f39446e;
                if (pBSplashListener != null) {
                    pBSplashListener.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
