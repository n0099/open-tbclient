package com.win.opensdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class t implements E {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ PBSplash a;

    public t(PBSplash pBSplash) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBSplash};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pBSplash;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.k = true;
            PBSplashListener pBSplashListener = this.a.e;
            if (pBSplashListener != null) {
                pBSplashListener.onClicked();
            }
        }
    }

    @Override // com.win.opensdk.E
    public void onDisplayed() {
        PBSplashListener pBSplashListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (pBSplashListener = this.a.e) != null) {
            pBSplashListener.onDisplayed();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                PBSplashListener pBSplashListener = this.a.e;
                if (pBSplashListener != null) {
                    pBSplashListener.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            PBSplash pBSplash = this.a;
            PBSplashListener pBSplashListener2 = pBSplash.e;
            if (pBSplashListener2 != null && !pBSplash.j) {
                pBSplashListener2.onFail(PBError.NO_FILL);
            }
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.b.c()) {
            PBSplash pBSplash = this.a;
            Context context = pBSplash.a;
            F1 f1 = pBSplash.b.a;
            if (f1 != null && f1.b()) {
                j = f1.c.getLo_timeout();
            } else {
                j = 0;
            }
            Z1.d(context, j);
            String str = "";
            if (this.a.b.b().equals("image")) {
                F1 f12 = this.a.b.a;
                if (f12 != null && f12.b()) {
                    str = f12.c.getLoad();
                }
                this.a.b(str);
            } else if (this.a.b.b().equals("gif")) {
                F1 f13 = this.a.b.a;
                if (f13 != null && f13.b()) {
                    str = f13.c.getLoad();
                }
                this.a.a(str);
            } else {
                PBSplashListener pBSplashListener = this.a.e;
                if (pBSplashListener != null) {
                    pBSplashListener.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
