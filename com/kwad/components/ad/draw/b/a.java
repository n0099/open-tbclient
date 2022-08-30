package com.kwad.components.ad.draw.b;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.g;
import com.kwad.components.core.widget.kwai.b;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.k;
/* loaded from: classes7.dex */
public final class a extends com.kwad.components.ad.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b aM;
    public long bU;
    public com.kwad.sdk.contentalliance.kwai.kwai.a bV;
    public boolean bW;
    public final com.kwad.sdk.core.h.b bX;
    public Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull AdTemplate adTemplate, @NonNull b bVar, @NonNull DetailVideoView detailVideoView) {
        super(adTemplate, detailVideoView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, bVar, detailVideoView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AdTemplate) objArr2[0], (DetailVideoView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bX = new com.kwad.sdk.core.h.b(this) { // from class: com.kwad.components.ad.draw.b.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a bY;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.bY = this;
            }

            @Override // com.kwad.sdk.core.h.b
            public final void aR() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.bY.bV == null) {
                        a aVar = this.bY;
                        aVar.bV = com.kwad.sdk.contentalliance.kwai.kwai.a.al(aVar.mAdTemplate);
                        this.bY.BL.a(this.bY.bV);
                    }
                    if (this.bY.bW) {
                        return;
                    }
                    this.bY.resume();
                }
            }

            @Override // com.kwad.sdk.core.h.b
            public final void aS() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.bY.pause();
                }
            }
        };
        this.bU = com.kwad.sdk.core.response.a.a.O(d.bQ(this.mAdTemplate));
        this.aM = bVar;
        this.mContext = detailVideoView.getContext();
        aQ();
        this.BL.a(new c.e(this) { // from class: com.kwad.components.ad.draw.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a bY;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.bY = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.bY.start(k.ck(this.bY.mAdTemplate));
                }
            }
        });
    }

    private void aQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.BL.a(new b.a(this.mAdTemplate).bk(d.bS(this.mAdTemplate)).bl(f.b(d.bR(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).rC(), this.mDetailVideoView);
            this.BL.prepareAsync();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65545, this, j) == null) && this.aM.dK()) {
            this.BL.a(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, j));
            this.BL.start();
        }
    }

    @MainThread
    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null) {
            return;
        }
        this.BL.c(gVar);
    }

    public final void aO() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long ck = k.ck(this.mAdTemplate);
            if (this.BL.oT() == null) {
                aQ();
            }
            start(ck);
            this.aM.a(this.bX);
        }
    }

    public final void aP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.bV = null;
            this.aM.b(this.bX);
            this.BL.release();
        }
    }

    @MainThread
    public final void b(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || gVar == null) {
            return;
        }
        this.BL.d(gVar);
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.bW = z;
        }
    }

    public final void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.BL.pause();
        }
    }

    @Override // com.kwad.components.ad.h.a
    @MainThread
    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.release();
            com.kwad.components.core.video.b bVar = this.BL;
            if (bVar != null) {
                bVar.clear();
                this.BL.release();
            }
        }
    }

    public final void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.BL.resume();
            com.kwad.components.core.m.b.at(this.mContext).ay(false);
        }
    }
}
