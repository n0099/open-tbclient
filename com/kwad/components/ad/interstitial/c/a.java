package com.kwad.components.ad.interstitial.c;

import android.app.Dialog;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.interstitial.a.b;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cVar)) == null) {
            Dialog dialog = cVar.c;
            if (dialog != null && dialog.getOwnerActivity() != null) {
                AdInfo i = d.i(cVar.a);
                int a = b.a();
                int b = b.b();
                if (a > com.kwad.sdk.core.response.a.a.aG(i) && b < com.kwad.sdk.core.response.a.a.aH(i)) {
                    if (com.kwad.sdk.core.response.a.a.aI(i) == 2) {
                        com.kwad.components.ad.interstitial.widget.d.a(cVar);
                        return true;
                    } else if (com.kwad.sdk.core.response.a.a.aI(i) == 1) {
                        new com.kwad.components.core.page.widget.a(cVar.c.getOwnerActivity(), com.kwad.sdk.core.response.a.a.aJ(i), new a.InterfaceC0516a(cVar) { // from class: com.kwad.components.ad.interstitial.c.a.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ c a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {cVar};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = cVar;
                            }

                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0516a
                            public final void a(DialogInterface dialogInterface) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                    dialogInterface.dismiss();
                                    com.kwad.sdk.core.report.a.b(this.a.a, (JSONObject) null, new f().e(8));
                                }
                            }

                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0516a
                            public final void b(DialogInterface dialogInterface) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                                    dialogInterface.dismiss();
                                    com.kwad.sdk.core.report.a.a(this.a.a, new f().c(Cea708Decoder.COMMAND_SWA).e(8));
                                    this.a.c.dismiss();
                                }
                            }

                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0516a
                            public final void c(DialogInterface dialogInterface) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                                }
                            }
                        }).show();
                        com.kwad.sdk.core.report.a.c(cVar.a, new JSONObject(), new f().c(149).e(8));
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
