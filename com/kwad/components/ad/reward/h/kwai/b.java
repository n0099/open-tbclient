package com.kwad.components.ad.reward.h.kwai;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.webview.b.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public final class b extends com.kwad.components.core.webview.b.b.d {
    public static /* synthetic */ Interceptable $ic;
    public static WeakReference tT;
    public transient /* synthetic */ FieldHolder $fh;
    public long tS;

    public b() {
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

    public static b a(Activity activity, AdTemplate adTemplate, long j, DialogInterface.OnDismissListener onDismissListener, com.kwad.components.core.webview.b.d.c cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{activity, adTemplate, Long.valueOf(j), onDismissListener, cVar})) == null) {
            if (activity == null || activity.isFinishing() || il()) {
                return null;
            }
            d.b bVar = new d.b();
            bVar.setAdTemplate(adTemplate);
            bVar.aI("ksad-video-secondclick-card");
            b a = a(bVar);
            a.Of = cVar;
            a.On = onDismissListener;
            a.g(j);
            a.show(activity.getFragmentManager(), "tkExtraReward");
            tT = new WeakReference(a);
            return a;
        }
        return (b) invokeCommon.objValue;
    }

    public static b a(b bVar, Activity activity, long j, com.kwad.components.core.webview.b.d.c cVar, d.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bVar, activity, Long.valueOf(j), cVar, aVar})) == null) {
            if (activity == null || activity.isFinishing()) {
                return null;
            }
            bVar.Of = cVar;
            bVar.Og = aVar;
            bVar.show(activity.getFragmentManager(), "tkCloseDialog");
            if (j > 0) {
                bVar.g(j);
            }
            return bVar;
        }
        return (b) invokeCommon.objValue;
    }

    public static b a(d.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) {
            b bVar2 = new b();
            bVar2.mAdTemplate = bVar.getAdTemplate();
            bVar2.Od = bVar.getTemplateId();
            bVar2.Oe = bVar.pP();
            bVar2.Oo = bVar.pQ();
            Bundle bundle = new Bundle();
            bundle.putString("templateId", bVar.getTemplateId());
            bVar2.setArguments(bundle);
            return bVar2;
        }
        return (b) invokeL.objValue;
    }

    private void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j) == null) {
            this.tS = j;
            com.kwad.components.core.webview.b.b.b bVar = this.Ob;
            if (bVar != null) {
                bVar.tS = j;
            }
        }
    }

    public static boolean il() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            WeakReference weakReference = tT;
            return (weakReference == null || weakReference.get() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.core.webview.b.b.d
    public final com.kwad.components.core.webview.b.b.b im() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a() : (com.kwad.components.core.webview.b.b.b) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.b.d
    public final com.kwad.components.core.webview.b.b.c in() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new c() : (com.kwad.components.core.webview.b.b.c) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.b.d
    public final void io() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.io();
            this.Ob.tS = this.tS;
        }
    }

    @Override // com.kwad.components.core.webview.b.b.d, android.app.Fragment
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            tT = null;
        }
    }
}
