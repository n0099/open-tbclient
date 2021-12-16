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
import com.kwad.sdk.api.core.ICompletedRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ICompletedRemoteView a;

    public b(ICompletedRemoteView iCompletedRemoteView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iCompletedRemoteView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = iCompletedRemoteView;
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? new b(RemoteViewBuilder.createCompletedView(context)) : (b) invokeL.objValue;
    }

    public RemoteViews a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ICompletedRemoteView iCompletedRemoteView = this.a;
            if (iCompletedRemoteView != null) {
                return iCompletedRemoteView.build();
            }
            return null;
        }
        return (RemoteViews) invokeV.objValue;
    }

    public void a(Bitmap bitmap) {
        ICompletedRemoteView iCompletedRemoteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) || (iCompletedRemoteView = this.a) == null) {
            return;
        }
        iCompletedRemoteView.setIcon(bitmap);
    }

    public void a(String str) {
        ICompletedRemoteView iCompletedRemoteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (iCompletedRemoteView = this.a) == null) {
            return;
        }
        iCompletedRemoteView.setName(str);
    }

    public void b(String str) {
        ICompletedRemoteView iCompletedRemoteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (iCompletedRemoteView = this.a) == null) {
            return;
        }
        iCompletedRemoteView.setStatus(str);
    }

    public void c(String str) {
        ICompletedRemoteView iCompletedRemoteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (iCompletedRemoteView = this.a) == null) {
            return;
        }
        iCompletedRemoteView.setSize(str);
    }

    public void d(String str) {
        ICompletedRemoteView iCompletedRemoteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (iCompletedRemoteView = this.a) == null) {
            return;
        }
        iCompletedRemoteView.setInstallText(str);
    }
}
