package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.av;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.download.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC1992a {
        void a();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull InterfaceC1992a interfaceC1992a, @Nullable b bVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, adTemplate, interfaceC1992a, bVar, Boolean.valueOf(z)})) == null) ? a(context, adTemplate, interfaceC1992a, bVar, z, false) : invokeCommon.intValue;
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull InterfaceC1992a interfaceC1992a, @Nullable b bVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, adTemplate, interfaceC1992a, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
            com.kwad.sdk.home.download.a.a().a(true);
            if (d.a(context, adTemplate, 1) == 1) {
                interfaceC1992a.a();
                return 0;
            } else if (!com.kwad.sdk.core.response.b.a.v(i2)) {
                interfaceC1992a.a();
                AdWebViewActivityProxy.launch(context, adTemplate);
                return 0;
            } else if (bVar != null) {
                int a2 = bVar.a(context, z, z2);
                int i3 = i2.status;
                if (i3 != 2 && i3 != 3) {
                    interfaceC1992a.a();
                }
                return a2;
            } else {
                return 0;
            }
        }
        return invokeCommon.intValue;
    }

    public static void b(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull InterfaceC1992a interfaceC1992a, @Nullable b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, adTemplate, interfaceC1992a, bVar, Boolean.valueOf(z)}) == null) {
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
            if (av.a()) {
                return;
            }
            boolean z2 = true;
            if (d.a(context, adTemplate, 1) == 1) {
                interfaceC1992a.a();
                return;
            }
            z2 = (!com.kwad.sdk.core.response.b.a.b(context, adTemplate, i2) || adTemplate.interactLandingPageShowing) ? false : false;
            if (!com.kwad.sdk.core.response.b.a.v(i2) || z2) {
                if (z2) {
                    AdWebViewActivityProxy.launch(context, adTemplate, 4);
                } else if (com.kwad.sdk.core.response.b.a.O(i2)) {
                    AdWebViewVideoActivityProxy.launch(context, adTemplate);
                } else {
                    AdWebViewActivityProxy.launch(context, adTemplate, 0);
                }
                interfaceC1992a.a();
            } else if (bVar != null) {
                if (!com.kwad.sdk.core.response.b.a.O(i2) || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.y(i2))) {
                    bVar.a(context, z);
                } else if (!bVar.c()) {
                    AdWebViewVideoActivityProxy.launch(context, adTemplate);
                }
                int i3 = i2.status;
                if (i3 == 2 || i3 == 3) {
                    return;
                }
                interfaceC1992a.a();
            }
        }
    }
}
