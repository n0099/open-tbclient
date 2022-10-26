package com.kwad.components.ad.reward.presenter.c;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.presenter.o;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.webview.b.a;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
/* loaded from: classes7.dex */
public final class b extends a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.components.core.webview.b.d.a mt;
    public ViewGroup tj;
    public ViewGroup tk;
    public ViewGroup tl;
    public View tm;
    public ViewGroup tn;
    public FrameLayout to;
    public com.kwad.components.core.webview.b.c tp;

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
                return;
            }
        }
        this.mt = new com.kwad.components.core.webview.b.d.a(this) { // from class: com.kwad.components.ad.reward.presenter.c.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b tq;

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
                this.tq = this;
            }

            @Override // com.kwad.components.core.webview.b.d.a
            public final void cy() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.tq.tp == null) {
                    return;
                }
                com.kwad.components.core.webview.b.a.a aVar = new com.kwad.components.core.webview.b.a.a();
                aVar.NJ = this.tq.nM.mT ? 1 : 0;
                this.tq.tp.b(aVar);
            }
        };
    }

    private void R(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
            this.nM.mRootContainer.postDelayed(new Runnable(this, i) { // from class: com.kwad.components.ad.reward.presenter.c.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b tq;
                public final /* synthetic */ int tr;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.tq = this;
                    this.tr = i;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int m82if = this.tq.m82if();
                        int S = this.tq.S(this.tr);
                        if (this.tq.to != null) {
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.tq.to.getLayoutParams();
                            layoutParams.width = -1;
                            layoutParams.topMargin = m82if;
                            layoutParams.height = (az.getScreenHeight(this.tq.getContext()) - m82if) - S;
                            this.tq.to.setLayoutParams(layoutParams);
                        }
                    }
                }
            }, 800L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int S(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) ? this.tk.getHeight() > 0 ? this.tk.getHeight() : this.tn.getHeight() > 0 ? this.tn.getHeight() : i > 0 ? i : com.kwad.sdk.b.kwai.a.a(getContext(), 120.0f) : invokeI.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public int m82if() {
        InterceptResult invokeV;
        ViewGroup viewGroup;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (this.tj.getHeight() > 0) {
                viewGroup = this.tj;
            } else if (com.kwad.sdk.core.response.a.a.ao(com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate)) && (height = ((ViewGroup.MarginLayoutParams) this.tm.getLayoutParams()).topMargin + 0 + this.tm.getHeight()) > 0) {
                return height;
            } else {
                viewGroup = this.tl;
            }
            return viewGroup.getHeight();
        }
        return invokeV.intValue;
    }

    private com.kwad.components.core.webview.b.c ig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? new com.kwad.components.core.webview.b.c(this) { // from class: com.kwad.components.ad.reward.presenter.c.b.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b tq;

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
                this.tq = this;
            }

            @Override // com.kwad.components.core.webview.b.c, com.kwad.sdk.core.webview.kwai.a
            public final void a(String str, com.kwad.sdk.core.webview.kwai.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                    super.a(str, cVar);
                    com.kwad.components.core.webview.b.a.a aVar = new com.kwad.components.core.webview.b.a.a();
                    aVar.NJ = this.tq.nM.mT ? 1 : 0;
                    cVar.a(aVar);
                }
            }
        } : (com.kwad.components.core.webview.b.c) invokeV.objValue;
    }

    private com.kwad.components.core.webview.b.b ih() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? new com.kwad.components.core.webview.b.b(this) { // from class: com.kwad.components.ad.reward.presenter.c.b.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b tq;

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
                this.tq = this;
            }

            @Override // com.kwad.components.core.webview.b.b, com.kwad.sdk.core.webview.kwai.a
            public final void a(String str, com.kwad.sdk.core.webview.kwai.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                    super.a(str, cVar);
                    com.kwad.components.core.webview.b.a.c cVar2 = new com.kwad.components.core.webview.b.a.c();
                    cVar2.NL = com.kwad.components.ad.reward.model.b.gK();
                    cVar.a(cVar2);
                }
            }
        } : (com.kwad.components.core.webview.b.b) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, showActionBarResult, view2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            R(layoutParams != null ? layoutParams instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + layoutParams.height : layoutParams.height : 0);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.components.core.webview.b.e
    public final void a(h hVar, com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, bVar) == null) {
            super.a(hVar, bVar);
            this.tp = ig();
            this.nM.a(this.mt);
            hVar.c(this.tp);
            hVar.c(new com.kwad.components.core.webview.b.a(new a.InterfaceC0579a(this) { // from class: com.kwad.components.ad.reward.presenter.c.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b tq;

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
                    this.tq = this;
                }

                @Override // com.kwad.components.core.webview.b.a.InterfaceC0579a
                public final void ii() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.components.ad.reward.model.b.P(this.tq.nM.mContext);
                    }
                }
            }));
            hVar.c(ih());
            hVar.c(new com.kwad.components.core.webview.jshandler.a(new com.kwad.components.core.webview.jshandler.b(this) { // from class: com.kwad.components.ad.reward.presenter.c.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b tq;

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
                    this.tq = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.b
                public final void a(com.kwad.components.core.webview.jshandler.a aVar, String str) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, aVar, str) == null) && TextUtils.equals(str, "autoCallApp")) {
                        AdTemplate adTemplate = this.tq.nM.mAdTemplate;
                        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
                        boolean z = true;
                        aVar.h(!com.kwad.sdk.core.response.a.a.aY(bQ) && (adTemplate.inPlayAgain || adTemplate.mPlayAgain != null), (!com.kwad.sdk.core.response.a.a.aY(bQ) && !com.kwad.components.ad.reward.kwai.b.j(bQ) && com.kwad.sdk.core.response.a.b.cg(bQ) && o.hg() && this.tq.nM.mScreenOrientation == 0) ? false : false);
                    }
                }
            }));
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.aq();
            this.nM.ml.a(this);
            this.to.setVisibility(0);
            R(0);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final String bZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "ksad-video-middle-card" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final FrameLayout ca() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.to : (FrameLayout) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void cb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.to.setVisibility(8);
            com.kwad.components.core.webview.b.c.a.pR().aK(bZ());
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a
    public final boolean cc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onCreate();
            this.to = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0910d8);
            this.tj = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0910da);
            this.tl = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091112);
            this.tk = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0910d7);
            this.tn = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091118);
            this.tm = findViewById(R.id.obfuscated_res_0x7f09107b);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onUnbind();
            this.nM.ml.b(this);
            this.nM.a((com.kwad.components.core.webview.b.d.a) null);
        }
    }
}
