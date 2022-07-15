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
/* loaded from: classes5.dex */
public final class a extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

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
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) t();
            KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(true).build();
            com.kwad.components.core.widget.d dVar = (com.kwad.components.core.widget.d) q();
            dVar.a(eVar.c);
            dVar.a(build, eVar.a);
            dVar.setVisibility(0);
            dVar.setOnEndBtnClickListener(new View.OnClickListener(this, eVar) { // from class: com.kwad.components.core.page.kwai.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.page.recycle.e a;
                public final /* synthetic */ a b;

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
                    this.b = this;
                    this.a = eVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (com.kwad.sdk.core.response.a.a.I(com.kwad.sdk.core.response.a.d.i(this.a.c))) {
                            if (this.a.a != null) {
                                this.a.a.a(new a.C0507a(this.b.s()).a(false).b(false).a(this.a.c).d(false));
                                return;
                            }
                            return;
                        }
                        RecyclerView recyclerView = this.a.b;
                        if (recyclerView == null || recyclerView.getAdapter() == null || this.a.b.getAdapter().getItemCount() <= 1) {
                            return;
                        }
                        this.a.b.scrollToPosition(1);
                    }
                }
            });
            dVar.setWindowFullScreenListener(new d.a(this, eVar) { // from class: com.kwad.components.core.page.kwai.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.page.recycle.e a;
                public final /* synthetic */ a b;

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
                    this.b = this;
                    this.a = eVar;
                }

                @Override // com.kwad.components.core.widget.d.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.b.a = this.a.b.computeVerticalScrollOffset();
                    }
                }

                @Override // com.kwad.components.core.widget.d.a
                public final void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.b.scrollToPosition(this.b.a);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
        }
    }
}
