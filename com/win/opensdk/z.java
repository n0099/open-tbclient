package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f39994a;

    public z(PBSplash pBSplash) {
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
        this.f39994a = pBSplash;
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) && i2 == 1 && i3 == 0) {
            PBSplash pBSplash = this.f39994a;
            PBSplashListener pBSplashListener = pBSplash.f39639e;
            if (pBSplashListener != null && !pBSplash.f39640f && !pBSplash.k && !PBSplash.isdpl) {
                if (pBSplashListener != null) {
                    pBSplashListener.onTimeOver();
                    return;
                }
                return;
            }
            PBSplash pBSplash2 = this.f39994a;
            if (pBSplash2.f39639e == null || pBSplash2.f39640f || !pBSplash2.k || PBSplash.isdpl) {
                return;
            }
            A1 a1 = pBSplash2.f39636b.f39563a;
            if (((a1 == null || !a1.b()) ? -1 : a1.f39541c.getOpent()) == 1) {
                PBSplash pBSplash3 = this.f39994a;
                if (pBSplash3.f39639e == null || !pBSplash3.r.isShown()) {
                    return;
                }
                this.f39994a.f39639e.onTimeOver();
            }
        }
    }
}
