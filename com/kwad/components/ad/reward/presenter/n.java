package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public final class n extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.c.f, com.kwad.components.ad.reward.c.g, u.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public float c;
    @Nullable
    public a d;
    @Nullable
    public m e;
    @Nullable
    public k f;
    public l g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;

    /* loaded from: classes5.dex */
    public class a extends com.kwad.components.core.video.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;
        public long b;
        public long c;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        public /* synthetic */ a(n nVar, byte b) {
            this(nVar);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void a(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                super.a(j, j2);
                this.b = j2;
                this.c = j;
                if (this.a.j) {
                    return;
                }
                this.a.a(j, j2, false);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(AdTemplate adTemplate) {
        this(adTemplate, true, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((AdTemplate) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public n(AdTemplate adTemplate, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = 0;
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = true;
        this.k = z;
        this.l = z2;
        AdInfo i3 = com.kwad.sdk.core.response.a.d.i(adTemplate);
        if (!com.kwad.sdk.core.response.a.a.ar(i3)) {
            if (com.kwad.sdk.core.response.a.a.as(i3)) {
                return;
            }
            com.kwad.components.core.i.a.a().b(adTemplate);
            return;
        }
        l lVar = new l();
        this.g = lVar;
        a((Presenter) lVar);
        if (this.l) {
            m mVar = new m(this);
            this.e = mVar;
            a((Presenter) mVar);
        }
        if (this.k) {
            k kVar = new k(this);
            this.f = kVar;
            a((Presenter) kVar);
        }
        a(new com.kwad.components.ad.reward.presenter.b.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2, boolean z) {
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            if (i() && j2 >= 10000 && ((float) j2) >= ((float) j) * this.c) {
                if (!com.kwad.components.ad.reward.kwai.b.j()) {
                    k kVar = this.f;
                    if (kVar != null) {
                        kVar.b(!z);
                        this.h = 2;
                    }
                } else if (this.i || (mVar = this.e) == null) {
                } else {
                    mVar.d();
                    this.h = 1;
                    this.i = true;
                }
            }
        }
    }

    private boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.b : invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(this);
            com.kwad.components.core.playable.a aVar = ((com.kwad.components.ad.reward.presenter.a) this).a.l;
            if (aVar != null) {
                aVar.a(this);
            }
            boolean i = com.kwad.components.ad.reward.kwai.b.i();
            this.c = com.kwad.components.ad.reward.kwai.b.h();
            if (i) {
                a aVar2 = new a(this, (byte) 0);
                this.d = aVar2;
                ((com.kwad.components.ad.reward.presenter.a) this).a.j.a(aVar2);
            }
            com.kwad.components.ad.reward.b.a().a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.c.g
    public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.c.k kVar) {
        k kVar2;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playableSource, kVar) == null) {
            this.j = true;
            if (this.h == 1 && (mVar = this.e) != null) {
                mVar.e();
            } else if (this.h != 2 || (kVar2 = this.f) == null) {
            } else {
                kVar2.d();
            }
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.u.b
    public final void a(u.a aVar) {
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            boolean a2 = aVar.a();
            this.b = a2;
            if (!a2 || (aVar2 = this.d) == null) {
                return;
            }
            a(aVar2.c, this.d.b, false);
        }
    }

    @Override // com.kwad.components.ad.reward.c.g
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j = false;
            a aVar = this.d;
            if (aVar == null || this.h != 2) {
                return;
            }
            a(aVar.c, this.d.b, true);
        }
    }

    @Override // com.kwad.components.ad.reward.c.f
    public final void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RewardActionBarControl.ShowActionBarResult b = ((com.kwad.components.ad.reward.presenter.a) this).a.m.b();
            if (b != null) {
                b.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
            }
            if (this.g == null || ((com.kwad.components.ad.reward.presenter.a) this).a.k()) {
                return;
            }
            if (i()) {
                this.g.a(PlayableSource.PLAY_FINISHED_NORMAL);
            } else {
                this.g.d();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.c.g
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            boolean n = ((com.kwad.components.ad.reward.presenter.a) this).a.n();
            if (!this.j || n) {
                return false;
            }
            com.kwad.components.ad.reward.b.a().b();
            this.j = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.k_();
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this);
            com.kwad.components.core.playable.a aVar = ((com.kwad.components.ad.reward.presenter.a) this).a.l;
            if (aVar != null) {
                aVar.b(this);
            }
            a aVar2 = this.d;
            if (aVar2 != null) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.j.b(aVar2);
            }
            com.kwad.components.ad.reward.b.a().b(this);
        }
    }
}
