package com.kwad.components.ad.draw.a.kwai;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.m.c;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.widget.j;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a extends com.kwad.components.ad.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean aN;
    public List<Integer> bv;
    public volatile boolean bw;
    public j bx;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public g mVideoPlayStateListener;

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
                return;
            }
        }
        this.aN = false;
        this.bw = false;
        this.bx = new j(this) { // from class: com.kwad.components.ad.draw.a.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a by;

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
                this.by = this;
            }

            @Override // com.kwad.sdk.widget.j
            public final void av() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    k.cj(this.by.mAdTemplate);
                }
            }
        };
        this.mVideoPlayStateListener = new h(this) { // from class: com.kwad.components.ad.draw.a.kwai.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a by;

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
                this.by = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.report.a.ax(this.by.mAdTemplate);
                    if (this.by.aK.aJ != null) {
                        try {
                            this.by.aK.aJ.onVideoPlayEnd();
                        } catch (Throwable th) {
                            b.printStackTraceOnly(th);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4) == null) {
                    super.onVideoPlayError(i3, i4);
                    if (this.by.aK.aJ != null) {
                        try {
                            this.by.aK.aJ.onVideoPlayError();
                        } catch (Throwable th) {
                            b.printStackTraceOnly(th);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayPaused() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.onVideoPlayPaused();
                    if (this.by.aK.aJ != null) {
                        try {
                            this.by.aK.aJ.onVideoPlayPause();
                        } catch (Throwable th) {
                            b.printStackTraceOnly(th);
                        }
                    }
                    this.by.aN = true;
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.by.c(j2);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.by.bw = false;
                    if (!this.by.mAdTemplate.mPvReported && this.by.aK.aJ != null) {
                        this.by.aK.aJ.onAdShow();
                    }
                    if (this.by.aK.aJ != null) {
                        try {
                            this.by.aK.aJ.onVideoPlayStart();
                        } catch (Throwable th) {
                            b.printStackTraceOnly(th);
                        }
                        this.by.aN = false;
                    }
                    c.ox().a(this.by.mAdTemplate, null, null);
                    com.kwad.sdk.core.report.a.aw(this.by.mAdTemplate);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlaying() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    super.onVideoPlaying();
                    if (!this.by.aN) {
                        if (this.by.bw) {
                            return;
                        }
                        this.by.bw = true;
                        com.kwad.components.core.j.a.og().a(this.by.mAdTemplate, System.currentTimeMillis(), 1);
                        return;
                    }
                    this.by.aN = false;
                    if (this.by.aK.aJ != null) {
                        try {
                            this.by.aK.aJ.onVideoPlayResume();
                        } catch (Throwable th) {
                            b.printStackTraceOnly(th);
                        }
                    }
                }
            }
        };
    }

    private void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, jVar) == null) {
            View rootView = getRootView();
            if (rootView instanceof AdBasePvFrameLayout) {
                ((AdBasePvFrameLayout) rootView).setVisibleListener(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65544, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.bv;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.bv) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.b(this.mAdTemplate, ceil, (JSONObject) null);
                    this.bv.remove(num);
                    return;
                }
            }
        }
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            AdTemplate adTemplate = this.aK.mAdTemplate;
            this.mAdTemplate = adTemplate;
            AdInfo bQ = d.bQ(adTemplate);
            this.mAdInfo = bQ;
            this.bv = com.kwad.sdk.core.response.a.a.aF(bQ);
            this.aK.aL.a(this.mVideoPlayStateListener);
            a(this.bx);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onUnbind();
            this.aK.aL.b(this.mVideoPlayStateListener);
            a((j) null);
        }
    }
}
