package com.win.opensdk;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class j implements P {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f42597a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f42598b;

    public j(PBSplash pBSplash, Bitmap.CompressFormat compressFormat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBSplash, compressFormat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42598b = pBSplash;
        this.f42597a = compressFormat;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    public void a(O o) {
        PBSplash pBSplash;
        PBSplashListener pBSplashListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o) == null) || (pBSplashListener = (pBSplash = this.f42598b).f42432e) == null || pBSplash.j) {
            return;
        }
        pBSplashListener.onFail(PBError.NO_RESUOURCE);
        PBSplash.d(this.f42598b, true);
    }
}
