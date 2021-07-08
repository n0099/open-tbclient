package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f39617a;

    public l(PBSplash pBSplash) {
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
        this.f39617a = pBSplash;
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) && i2 == 1 && i3 == 0) {
            PBSplash pBSplash = this.f39617a;
            PBSplashListener pBSplashListener = pBSplash.f39446e;
            if (pBSplashListener != null && !pBSplash.f39447f && !pBSplash.k && !PBSplash.isdpl) {
                if (pBSplashListener != null) {
                    pBSplashListener.onTimeOver();
                    return;
                }
                return;
            }
            PBSplash pBSplash2 = this.f39617a;
            if (pBSplash2.f39446e == null || pBSplash2.f39447f || !pBSplash2.k || PBSplash.isdpl) {
                return;
            }
            Y0 y0 = pBSplash2.f39443b.f39633a;
            if (((y0 == null || !y0.b()) ? -1 : y0.f39522c.getOpent()) == 1) {
                PBSplash pBSplash3 = this.f39617a;
                if (pBSplash3.f39446e == null || !pBSplash3.r.isShown()) {
                    return;
                }
                this.f39617a.f39446e.onTimeOver();
            }
        }
    }
}
