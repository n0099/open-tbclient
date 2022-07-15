package com.kwad.components.ad.interstitial.widget;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class a extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<AdTemplate> a;
    public final Dialog b;
    public final KsAdVideoPlayConfig c;
    public final KsInterstitialAd.AdInteractionListener d;
    public final boolean e;
    public b f;
    public InterfaceC0473a g;

    /* renamed from: com.kwad.components.ad.interstitial.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0473a {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(e eVar, int i);
    }

    public a(AdTemplate adTemplate, Dialog dialog, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, dialog, ksAdVideoPlayConfig, adInteractionListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = dialog;
        this.c = ksAdVideoPlayConfig;
        this.d = adInteractionListener;
        this.e = com.kwad.sdk.core.response.a.a.aL(com.kwad.sdk.core.response.a.d.i(adTemplate)) == 1;
    }

    public final void a(InterfaceC0473a interfaceC0473a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0473a) == null) {
            this.g = interfaceC0473a;
        }
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public final void a(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        this.a.clear();
        this.a.addAll(list);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(@NonNull ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) && (obj instanceof View)) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public final Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) {
            e eVar = new e(viewGroup.getContext());
            viewGroup.addView(eVar);
            eVar.setAggregateAdView(i > 0);
            if (i == 0) {
                eVar.setAdConvertListener(new c.a(this) { // from class: com.kwad.components.ad.interstitial.widget.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.components.ad.interstitial.b.c.a
                    public final void a() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.g == null) {
                            return;
                        }
                        this.a.g.a();
                    }
                });
            }
            if (i > 0) {
                int i2 = 7;
                if (i == 1 && this.e) {
                    i2 = 8;
                }
                eVar.setAggregateShowTriggerType(i2);
            }
            eVar.a(this.a.get(i), this.b, this.c, this.d);
            b bVar = this.f;
            if (bVar != null) {
                bVar.a(eVar, i);
            }
            return eVar;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(@NonNull View view2, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }
}
