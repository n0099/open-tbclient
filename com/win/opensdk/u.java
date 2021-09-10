package com.win.opensdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class u implements F {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f77181a;

    public u(PBSplash pBSplash) {
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
        this.f77181a = pBSplash;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f77181a.k = true;
            PBSplashListener pBSplashListener = this.f77181a.f76857e;
            if (pBSplashListener != null) {
                pBSplashListener.onClicked();
            }
        }
    }

    @Override // com.win.opensdk.F
    public void onDisplayed() {
        PBSplashListener pBSplashListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pBSplashListener = this.f77181a.f76857e) == null) {
            return;
        }
        pBSplashListener.onDisplayed();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                PBSplashListener pBSplashListener = this.f77181a.f76857e;
                if (pBSplashListener != null) {
                    pBSplashListener.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            PBSplash pBSplash = this.f77181a;
            PBSplashListener pBSplashListener2 = pBSplash.f76857e;
            if (pBSplashListener2 == null || pBSplash.f76862j) {
                return;
            }
            pBSplashListener2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f77181a.f76854b.c()) {
            PBSplash pBSplash = this.f77181a;
            Context context = pBSplash.f76853a;
            A1 a1 = pBSplash.f76854b.f76779a;
            U1.d(context, (a1 == null || !a1.b()) ? 0L : a1.f76756c.getLo_timeout());
            String str = "";
            if (this.f77181a.f76854b.b().equals("image")) {
                A1 a12 = this.f77181a.f76854b.f76779a;
                if (a12 != null && a12.b()) {
                    str = a12.f76756c.getLoad();
                }
                this.f77181a.b(str);
            } else if (this.f77181a.f76854b.b().equals("gif")) {
                A1 a13 = this.f77181a.f76854b.f76779a;
                if (a13 != null && a13.b()) {
                    str = a13.f76756c.getLoad();
                }
                this.f77181a.a(str);
            } else {
                PBSplashListener pBSplashListener = this.f77181a.f76857e;
                if (pBSplashListener != null) {
                    pBSplashListener.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
