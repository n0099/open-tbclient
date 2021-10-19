package com.kwad.sdk.core.page.a;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.page.recycle.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.feed.widget.k;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public class a extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f72385a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            e eVar = (e) l();
            KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(true).build();
            k kVar = (k) j();
            kVar.a(eVar.f72456c);
            kVar.a(build);
            kVar.setVisibility(0);
            kVar.setOnEndBtnClickListener(new View.OnClickListener(this, eVar) { // from class: com.kwad.sdk.core.page.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f72389a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f72390b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, eVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f72390b = this;
                    this.f72389a = eVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (com.kwad.sdk.core.response.b.a.v(c.i(this.f72389a.f72456c))) {
                            com.kwad.sdk.core.download.b.b bVar = this.f72389a.f72454a;
                            if (bVar != null) {
                                bVar.a((Context) this.f72390b.k(), false);
                                return;
                            }
                            return;
                        }
                        RecyclerView recyclerView = this.f72389a.f72455b;
                        if (recyclerView == null || recyclerView.getAdapter() == null || this.f72389a.f72455b.getAdapter().getItemCount() <= 1) {
                            return;
                        }
                        this.f72389a.f72455b.scrollToPosition(1);
                    }
                }
            });
            kVar.setWindowFullScreenListener(new k.a(this, eVar) { // from class: com.kwad.sdk.core.page.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f72391a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f72392b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, eVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f72392b = this;
                    this.f72391a = eVar;
                }

                @Override // com.kwad.sdk.feed.widget.k.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f72392b.f72385a = this.f72391a.f72455b.computeVerticalScrollOffset();
                    }
                }

                @Override // com.kwad.sdk.feed.widget.k.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f72391a.f72455b.scrollToPosition(this.f72392b.f72385a);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
        }
    }
}
