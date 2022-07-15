package com.kwad.components.ad.reward;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.webview.jshandler.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class i extends com.kwad.components.ad.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AdTemplate> e;
    public boolean f;
    public List<com.kwad.components.core.c.a.b> g;
    public c.b h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(List<AdTemplate> list, @Nullable JSONObject jSONObject, c.b bVar) {
        super(jSONObject, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, jSONObject, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((JSONObject) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = new ArrayList();
        this.e = list;
        this.h = bVar;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (AdTemplate adTemplate : this.e) {
            this.g.add(new com.kwad.components.core.c.a.b(adTemplate));
        }
    }

    @Override // com.kwad.components.ad.h.b
    public final String a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adTemplate)) == null) {
            List<AdTemplate> list = this.e;
            return (list == null || list.size() < 2) ? super.a(adTemplate) : com.kwad.sdk.core.response.a.b.d(this.e.get(1));
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.components.ad.h.b
    @SuppressLint({"ClickableViewAccessibility"})
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.a();
            this.a.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.components.ad.reward.i.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ i a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? motionEvent.getAction() == 2 : invokeLL.booleanValue;
                }
            });
        }
    }

    @Override // com.kwad.components.ad.h.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.c.a.b bVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{frameLayout, adBaseFrameLayout, adTemplate, bVar, Integer.valueOf(i)}) == null) {
            super.a(frameLayout, adBaseFrameLayout, this.e, this.g, i);
        }
    }

    @Override // com.kwad.components.ad.h.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            super.a(aVar);
            List<AdTemplate> list = this.e;
            com.kwad.components.core.webview.jshandler.c cVar = new com.kwad.components.core.webview.jshandler.c(new ArrayList(list.subList(1, list.size() - 1)));
            cVar.a(this.h);
            aVar.a(cVar);
        }
    }

    @Override // com.kwad.components.ad.h.b
    public final void a(com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            bVar.a(this.e);
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f = z;
        }
    }

    @Override // com.kwad.components.ad.h.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "MiddlePlayEndCard" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.h.b
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f ? this.d : super.c() : invokeV.booleanValue;
    }
}
