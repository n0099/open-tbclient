package com.kwad.components.core.page.kwai;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.widget.d;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes8.dex */
public final class a extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int Gd;

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

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) xR();
            KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(true).build();
            com.kwad.components.core.widget.d dVar = (com.kwad.components.core.widget.d) getRootView();
            dVar.c(eVar.adTemplate);
            dVar.a(build, eVar.DV);
            dVar.setVisibility(0);
            dVar.setOnEndBtnClickListener(new View.OnClickListener(this, eVar) { // from class: com.kwad.components.core.page.kwai.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.page.recycle.e Ge;
                public final /* synthetic */ a Gf;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, eVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Gf = this;
                    this.Ge = eVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(this.Ge.adTemplate))) {
                            if (this.Ge.DV != null) {
                                this.Ge.DV.m(new a.C0598a(this.Gf.getActivity()).aj(false).ak(false).L(this.Ge.adTemplate).am(false));
                                return;
                            }
                            return;
                        }
                        RecyclerView recyclerView = this.Ge.GU;
                        if (recyclerView == null || recyclerView.getAdapter() == null || this.Ge.GU.getAdapter().getItemCount() <= 1) {
                            return;
                        }
                        this.Ge.GU.scrollToPosition(1);
                    }
                }
            });
            dVar.setWindowFullScreenListener(new d.a(this, eVar) { // from class: com.kwad.components.core.page.kwai.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.page.recycle.e Ge;
                public final /* synthetic */ a Gf;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, eVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Gf = this;
                    this.Ge = eVar;
                }

                @Override // com.kwad.components.core.widget.d.a
                public final void nL() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.Gf.Gd = this.Ge.GU.computeVerticalScrollOffset();
                    }
                }

                @Override // com.kwad.components.core.widget.d.a
                public final void nM() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.Ge.GU.scrollToPosition(this.Gf.Gd);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
        }
    }
}
