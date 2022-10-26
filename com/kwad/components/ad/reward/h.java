package com.kwad.components.ad.reward;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class h extends com.kwad.components.ad.i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List mc;
    public boolean md;
    public List me;
    public e.b mf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(List list, JSONObject jSONObject, e.b bVar) {
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
        this.md = false;
        this.me = new ArrayList();
        this.mc = list;
        this.mf = bVar;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (AdTemplate adTemplate : this.mc) {
            this.me.add(new com.kwad.components.core.c.a.c(adTemplate));
        }
    }

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.md = z;
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.c.a.c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{frameLayout, adBaseFrameLayout, adTemplate, cVar, Integer.valueOf(i)}) == null) {
            super.a(frameLayout, adBaseFrameLayout, this.mc, this.me, i);
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            super.a(aVar);
            List list = this.mc;
            com.kwad.components.core.webview.jshandler.e eVar = new com.kwad.components.core.webview.jshandler.e(new ArrayList(list.subList(1, list.size() - 1)));
            eVar.a(this.mf);
            aVar.a(eVar);
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final void b(com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            bVar.setAdTemplateList(this.mc);
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final boolean bs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.md ? this.Cc : super.bs() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.i.b
    public final void fh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.fh();
            this.bF.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.components.ad.reward.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ h mg;

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
                    this.mg = this;
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

    @Override // com.kwad.components.ad.i.b
    public final boolean fi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void fj() {
        aa aaVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aaVar = this.bI) == null) {
            return;
        }
        aaVar.pz();
    }

    @Override // com.kwad.components.ad.i.b
    public final void fk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            com.kwad.components.ad.reward.monitor.a.a(true, "middle_play_end_card");
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final void fl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            com.kwad.components.ad.reward.monitor.a.a(true, "middle_play_end_card", l(this.mAdTemplate));
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final void fm() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            com.kwad.components.ad.reward.monitor.a.b(true, "middle_play_end_card", l(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "MiddlePlayEndCard" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.i.b
    public final String l(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, adTemplate)) == null) {
            List list = this.mc;
            if (list == null || list.size() < 2) {
                return super.l(adTemplate);
            }
            String aR = com.kwad.sdk.core.response.a.b.aR((AdTemplate) this.mc.get(1));
            new StringBuilder("getUrl: ").append(aR);
            return aR;
        }
        return (String) invokeL.objValue;
    }
}
