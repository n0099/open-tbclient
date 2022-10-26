package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ PBSplash a;

    public y(PBSplash pBSplash) {
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

    public void a(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && i == 1 && i2 == 0) {
            PBSplash pBSplash = this.a;
            PBSplashListener pBSplashListener = pBSplash.e;
            if (pBSplashListener != null && !pBSplash.f && !pBSplash.k && !PBSplash.isdpl) {
                if (pBSplashListener != null) {
                    pBSplashListener.onTimeOver();
                    return;
                }
                return;
            }
            PBSplash pBSplash2 = this.a;
            if (pBSplash2.e != null && !pBSplash2.f && pBSplash2.k && !PBSplash.isdpl) {
                F1 f1 = pBSplash2.b.a;
                if (f1 != null && f1.b()) {
                    i3 = f1.c.getOpent();
                } else {
                    i3 = -1;
                }
                if (i3 == 1) {
                    PBSplash pBSplash3 = this.a;
                    if (pBSplash3.e != null && pBSplash3.r.isShown()) {
                        this.a.e.onTimeOver();
                    }
                }
            }
        }
    }
}
