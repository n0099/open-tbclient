package com.kwad.components.ad.interstitial.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean c(c cVar) {
        InterceptResult invokeL;
        Activity ownerActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cVar)) == null) {
            Dialog dialog = cVar.gi;
            if (dialog != null && (ownerActivity = dialog.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
                AdInfo bQ = d.bQ(cVar.mAdTemplate);
                int cp = com.kwad.components.ad.interstitial.a.b.cp();
                int cq = com.kwad.components.ad.interstitial.a.b.cq();
                if (cp > com.kwad.sdk.core.response.a.a.bp(bQ) && cq < com.kwad.sdk.core.response.a.a.bq(bQ)) {
                    if (com.kwad.sdk.core.response.a.a.br(bQ) == 2) {
                        com.kwad.components.ad.interstitial.widget.d.d(cVar);
                        return true;
                    } else if (com.kwad.sdk.core.response.a.a.br(bQ) == 1) {
                        new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.a.a.bs(bQ), new a.InterfaceC0575a(cVar) { // from class: com.kwad.components.ad.interstitial.c.a.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ c gf;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {cVar};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.gf = cVar;
                            }

                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0575a
                            public final void a(DialogInterface dialogInterface) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                    dialogInterface.dismiss();
                                    com.kwad.sdk.core.report.a.c(this.gf.mAdTemplate, (JSONObject) null, new f().aM(8));
                                }
                            }

                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0575a
                            public final void b(DialogInterface dialogInterface) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                                    dialogInterface.dismiss();
                                    com.kwad.sdk.core.report.a.a(this.gf.mAdTemplate, new f().aK(Cea708Decoder.COMMAND_SWA).aM(8));
                                    this.gf.gi.dismiss();
                                }
                            }

                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0575a
                            public final void c(DialogInterface dialogInterface) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                                }
                            }
                        }).show();
                        com.kwad.sdk.core.report.a.d(cVar.mAdTemplate, new JSONObject(), new f().aK(149).aM(8));
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
