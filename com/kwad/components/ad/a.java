package com.kwad.components.ad;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.adbit.c;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.d;
/* loaded from: classes5.dex */
public class a extends d implements com.kwad.components.ad.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.components.ad.a.a
    public final String a(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ksScene)) == null) ? c.a(ksScene) : (String) invokeL.objValue;
    }

    @Override // com.kwad.components.ad.a.a
    public final boolean a(Activity activity, KsExitInstallListener ksExitInstallListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, ksExitInstallListener)) == null) ? com.kwad.sdk.kwai.kwai.a.a(activity, new DialogInterface.OnDismissListener(this, ksExitInstallListener) { // from class: com.kwad.components.ad.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsExitInstallListener a;
            public final /* synthetic */ a b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, ksExitInstallListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = this;
                this.a = ksExitInstallListener;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                KsExitInstallListener ksExitInstallListener2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || (ksExitInstallListener2 = this.a) == null) {
                    return;
                }
                ksExitInstallListener2.onDialogClose();
            }
        }, new DialogInterface.OnClickListener(this, ksExitInstallListener) { // from class: com.kwad.components.ad.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsExitInstallListener a;
            public final /* synthetic */ a b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, ksExitInstallListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = this;
                this.a = ksExitInstallListener;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                KsExitInstallListener ksExitInstallListener2;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i) == null) && (ksExitInstallListener2 = this.a) != null && i == -1) {
                    ksExitInstallListener2.onInstallClick();
                }
            }
        }) : invokeLL.booleanValue;
    }

    @Override // com.kwad.components.ad.a.a
    public final String b(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksScene)) == null) ? c.b(ksScene) : (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.components.ad.a.a.class : (Class) invokeV.objValue;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, sdkConfig) == null) {
        }
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public int priority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return -100;
        }
        return invokeV.intValue;
    }
}
