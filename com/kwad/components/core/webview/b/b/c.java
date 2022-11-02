package com.kwad.components.core.webview.b.b;

import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.webview.b.a.q;
import com.kwad.components.core.webview.b.a.s;
import com.kwad.components.core.webview.b.b.d;
import com.kwad.components.core.webview.b.kwai.j;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.sdk.utils.az;
/* loaded from: classes7.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d Ne;
    public String Od;
    public FrameLayout Oh;
    public j Oi;
    public aa Oj;
    public com.kwad.components.core.webview.b.d.d Ok;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Ok = new com.kwad.components.core.webview.b.d.d(this) { // from class: com.kwad.components.core.webview.b.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c Ol;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.Ol = this;
            }

            @Override // com.kwad.components.core.webview.b.d.d
            public final void fH() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.Ol.Oj == null) {
                    return;
                }
                this.Ol.Oj.py();
                this.Ol.Oj.pz();
            }

            @Override // com.kwad.components.core.webview.b.d.d
            public final void pO() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.Ol.Oj == null) {
                    return;
                }
                this.Ol.Oj.pA();
                this.Ol.Oj.pB();
            }
        };
    }

    @Override // com.kwad.components.core.webview.b.b.a, com.kwad.components.core.webview.b.e
    public final void a(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) {
            super.a(qVar);
            d dVar = this.Ne;
            if (dVar != null) {
                dVar.dismiss();
            }
            com.kwad.components.core.webview.b.d.c cVar = this.Ob.Of;
            if (cVar != null) {
                cVar.G(true);
            }
        }
    }

    @Override // com.kwad.components.core.webview.b.b.a
    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            super.a(bVar);
            b bVar2 = this.Ob;
            this.Od = bVar2.Od;
            this.Ne = bVar2.Ne;
        }
    }

    @Override // com.kwad.components.core.webview.b.b.a, com.kwad.components.core.webview.b.e
    public final void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar) == null) {
            this.Oi = jVar;
            long j = this.Ob.tS;
            if (jVar == null || j <= 0) {
                return;
            }
            s sVar = new s();
            sVar.kD = (int) (j / 1000);
            this.Oi.a(sVar);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(aa aaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aaVar) == null) {
            this.Oj = aaVar;
        }
    }

    @Override // com.kwad.components.core.webview.b.b.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.aq();
            d dVar = this.Ne;
            if (dVar != null) {
                dVar.a(this.Ok);
            }
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            float aI = com.kwad.sdk.b.kwai.a.aI(getContext());
            aVar.width = (int) ((az.getScreenWidth(getContext()) / aI) + 0.5f);
            aVar.height = (int) ((az.getScreenHeight(getContext()) / aI) + 0.5f);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final String bZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.Od : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final FrameLayout ca() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.Oh : (FrameLayout) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void cb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a aVar = this.Ob.Og;
            if (aVar != null) {
                aVar.fG();
            }
            com.kwad.components.core.webview.b.c.a.pR().aK(bZ());
            d dVar = this.Ne;
            if (dVar != null) {
                dVar.dismiss();
            }
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.b.a, com.kwad.components.core.webview.b.e
    public final void dI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.dI();
            b bVar = this.Ob;
            if (bVar.Oe) {
                com.kwad.components.core.webview.b.d.c cVar = bVar.Of;
                if (cVar != null) {
                    cVar.G(true);
                    return;
                }
                return;
            }
            d dVar = this.Ne;
            if (dVar != null) {
                dVar.dismiss();
            }
            com.kwad.components.core.webview.b.d.c cVar2 = this.Ob.Of;
            if (cVar2 != null) {
                cVar2.fI();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onCreate();
            this.Oh = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091238);
        }
    }
}
