package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.IProgressRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IProgressRemoteView a;

    public c(IProgressRemoteView iProgressRemoteView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iProgressRemoteView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = iProgressRemoteView;
    }

    public static c a(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int sDKType = KsAdSDKImpl.get().getSDKType();
            int apiVersionCode = KsAdSDKImpl.get().getApiVersionCode();
            boolean z2 = true;
            if ((sDKType != 1 || apiVersionCode < 3031000) && (sDKType != 2 || apiVersionCode < 3031800)) {
                z2 = false;
            }
            if (z2) {
                try {
                    cVar = new c(RemoteViewBuilder.createProgressView(context, i2, z));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                    cVar = null;
                }
            } else {
                cVar = new c(RemoteViewBuilder.createProgressView(context));
            }
            if (cVar == null) {
                try {
                    return new c(RemoteViewBuilder.createProgressView(context));
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.a.b(th2);
                    return cVar;
                }
            }
            return cVar;
        }
        return (c) invokeCommon.objValue;
    }

    public RemoteViews a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            IProgressRemoteView iProgressRemoteView = this.a;
            if (iProgressRemoteView != null) {
                return iProgressRemoteView.build();
            }
            return null;
        }
        return (RemoteViews) invokeV.objValue;
    }

    public void a(int i2, int i3, boolean z) {
        IProgressRemoteView iProgressRemoteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || (iProgressRemoteView = this.a) == null) {
            return;
        }
        iProgressRemoteView.setProgress(i2, i3, z);
    }

    public void a(Bitmap bitmap) {
        IProgressRemoteView iProgressRemoteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) || (iProgressRemoteView = this.a) == null) {
            return;
        }
        iProgressRemoteView.setIcon(bitmap);
    }

    public void a(String str) {
        IProgressRemoteView iProgressRemoteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (iProgressRemoteView = this.a) == null) {
            return;
        }
        iProgressRemoteView.setName(str);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            try {
                if (this.a != null) {
                    this.a.setControlBtnPaused(z);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
    }

    public void b(String str) {
        IProgressRemoteView iProgressRemoteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (iProgressRemoteView = this.a) == null) {
            return;
        }
        iProgressRemoteView.setStatus(str);
    }

    public void c(String str) {
        IProgressRemoteView iProgressRemoteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (iProgressRemoteView = this.a) == null) {
            return;
        }
        iProgressRemoteView.setSize(str);
    }

    public void d(String str) {
        IProgressRemoteView iProgressRemoteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (iProgressRemoteView = this.a) == null) {
            return;
        }
        iProgressRemoteView.setPercentNum(str);
    }
}
