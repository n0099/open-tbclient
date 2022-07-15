package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate a;
    public AdInfo b;
    public View c;
    public ImageView d;
    public KsLogoView e;
    public l f;
    public com.kwad.components.ad.widget.tailframe.appbar.a g;
    public TailFrameBarH5View h;
    public b i;
    public JSONObject j;
    public com.kwad.components.core.c.a.b k;
    public TextProgressBar l;
    public TextView m;
    public View n;
    public int o;

    public a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
        r1 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, this, view2, z) == null) {
            if (d.q(this.a)) {
                this.f.a(this.c.getContext(), z ? 1 : 153, view2 == this.n ? 1 : 2);
            } else if (com.kwad.sdk.core.response.a.a.I(this.b)) {
                com.kwad.components.core.c.a.a.a(new a.C0507a(view2.getContext()).a(this.a).a(this.k).a(view2 == this.l).a(r1).a(new a.b(this, z) { // from class: com.kwad.components.ad.reward.widget.tailframe.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean a;
                    public final /* synthetic */ a b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z)};
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
                        this.a = z;
                    }

                    @Override // com.kwad.components.core.c.a.a.b
                    public final void a() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.b.i == null) {
                            return;
                        }
                        this.b.i.a(this.a);
                    }
                }));
            } else {
                com.kwad.components.core.c.a.a.a(new a.C0507a(view2.getContext()).a(this.a).a(this.k).a(view2 == this.l).a(r1).a(new a.b(this, z) { // from class: com.kwad.components.ad.reward.widget.tailframe.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean a;
                    public final /* synthetic */ a b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = objArr;
                            Object[] objArr = {this, Boolean.valueOf(z)};
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
                        this.a = z;
                    }

                    @Override // com.kwad.components.core.c.a.a.b
                    public final void a() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.b.i == null) {
                            return;
                        }
                        this.b.i.a(this.a);
                    }
                }));
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.k = new com.kwad.components.core.c.a.b(this.a, this.j, new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
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

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void a(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        this.a.g.a(this.a.b);
                        this.a.l.a(com.kwad.sdk.core.response.a.a.b(i), i);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.g.a(this.a.b);
                        this.a.l.a(com.kwad.sdk.core.response.a.a.H(this.a.b), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.a.g.a(this.a.b);
                        this.a.l.a(com.kwad.sdk.core.response.a.a.a(this.a.a), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.a.g.a(this.a.b);
                        this.a.l.a(com.kwad.sdk.core.response.a.a.H(this.a.b), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        this.a.g.a(this.a.b);
                        this.a.l.a(com.kwad.sdk.core.response.a.a.n(this.a.b), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                        this.a.g.a(this.a.b);
                        this.a.l.a(com.kwad.sdk.core.response.a.a.a(i), i);
                    }
                }
            });
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.c.setOnClickListener(null);
            this.k = null;
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (!com.kwad.sdk.core.response.a.a.I(this.b) && !d.q(this.a)) {
                this.h.a(this.a);
                TextView h5OpenBtn = this.h.getH5OpenBtn();
                this.m = h5OpenBtn;
                h5OpenBtn.setClickable(true);
                this.h.setVisibility(0);
                new f(this.m, this);
                return;
            }
            this.g.a(this.a);
            this.g.setVisibility(0);
            this.l = this.g.getTextProgressBar();
            if (!d.q(this.a)) {
                this.l.setClickable(true);
                new f(this.l, this);
                d();
                return;
            }
            View btnInstallContainer = this.g.getBtnInstallContainer();
            this.n = btnInstallContainer;
            btnInstallContainer.setClickable(true);
            new f(this.n, this);
        }
    }

    public final View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(this.o, (ViewGroup) null, false);
            this.c = inflate;
            this.d = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0911e4);
            this.e = (KsLogoView) this.c.findViewById(R.id.obfuscated_res_0x7f0911e1);
            this.g = (com.kwad.components.ad.widget.tailframe.appbar.a) this.c.findViewById(R.id.obfuscated_res_0x7f0911be);
            this.h = (TailFrameBarH5View) this.c.findViewById(R.id.obfuscated_res_0x7f0911d4);
        }
    }

    public final void a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            this.f = lVar;
        }
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, adTemplate, jSONObject, bVar) == null) {
            this.a = adTemplate;
            this.b = d.i(adTemplate);
            this.j = jSONObject;
            this.i = bVar;
            this.e.a(this.a);
            f();
            this.c.setClickable(true);
            new f(this.c, this);
        }
    }

    public final void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.h.a(z, z2);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a_(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            a(view2, true);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.g;
            if (aVar != null) {
                aVar.a();
                this.g.setVisibility(8);
            }
            TailFrameBarH5View tailFrameBarH5View = this.h;
            if (tailFrameBarH5View != null) {
                tailFrameBarH5View.a();
                this.h.setVisibility(8);
            }
            e();
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view2) == null) && com.kwad.sdk.core.response.a.c.d(this.a)) {
            a(view2, false);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.g;
            if (aVar != null) {
                aVar.a();
            }
            TailFrameBarH5View tailFrameBarH5View = this.h;
            if (tailFrameBarH5View != null) {
                tailFrameBarH5View.a();
            }
        }
    }
}
