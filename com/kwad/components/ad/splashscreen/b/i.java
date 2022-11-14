package com.kwad.components.ad.splashscreen.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class i extends h implements com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View yO;
    public KsRotateView yP;
    public TextView yQ;
    public TextView yR;
    public com.kwad.sdk.core.g.c yS;
    public com.kwad.components.ad.splashscreen.e yT;
    public Runnable yU;

    public i() {
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
        this.yU = new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.i.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i yV;

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
                this.yV = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.yV.yS.vb();
                }
            }
        };
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void Y(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (textView = this.yR) == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // com.kwad.sdk.core.g.a
    public final void aa(String str) {
        Runnable runnable;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            boolean qm = this.yF.yd.qm();
            boolean mq = com.kwad.components.core.c.kwai.b.mq();
            if (!qm || mq) {
                runnable = this.yU;
                j = DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT;
            } else {
                this.yP.kF();
                com.kwad.components.ad.splashscreen.h hVar = this.yF;
                if (hVar != null) {
                    hVar.a(getContext(), 161, 2, new h.a(this, str) { // from class: com.kwad.components.ad.splashscreen.b.i.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ i yV;
                        public final /* synthetic */ String yW;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.yV = this;
                            this.yW = str;
                        }

                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.report.f fVar) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, fVar) == null) {
                                fVar.cs(this.yW);
                            }
                        }
                    });
                }
                kn();
                runnable = this.yU;
                j = 2000;
            }
            bd.a(runnable, null, j);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h, com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.aq();
            com.kwad.components.ad.splashscreen.h hVar = this.yF;
            if (hVar != null) {
                hVar.a(this);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.yO = ((ViewStub) findViewById(R.id.obfuscated_res_0x7f09120b)).inflate();
            this.yQ = (TextView) findViewById(R.id.obfuscated_res_0x7f09120c);
            this.yR = (TextView) findViewById(R.id.obfuscated_res_0x7f09120a);
            this.yP = (KsRotateView) findViewById(R.id.obfuscated_res_0x7f09120d);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void jy() {
        com.kwad.sdk.core.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.yS) == null) {
            return;
        }
        cVar.bA(getContext());
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void kf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate);
            getContext();
            com.kwad.components.ad.splashscreen.h hVar = this.yF;
            com.kwad.components.ad.splashscreen.e a = com.kwad.components.ad.splashscreen.e.a(hVar.mAdTemplate, bQ, hVar.mApkDownloadHelper, 1);
            this.yT = a;
            TextView textView = this.yQ;
            if (textView != null) {
                textView.setText(a.getTitle());
            }
            TextView textView2 = this.yR;
            if (textView2 != null) {
                textView2.setText(this.yT.jw());
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void kg() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (view2 = this.yO) == null || this.yF == null) {
            return;
        }
        view2.setVisibility(0);
        com.kwad.sdk.core.report.a.c(this.yF.mAdTemplate, (int) H262Reader.START_GROUP, (JSONObject) null);
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void kh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.kwad.components.ad.splashscreen.local.b.R(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void ki() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AdMatrixInfo.RotateInfo bq = com.kwad.sdk.core.response.a.b.bq(this.yF.mAdTemplate);
            com.kwad.sdk.core.g.c cVar = this.yS;
            if (cVar != null) {
                cVar.a(bq);
                return;
            }
            com.kwad.sdk.core.g.c cVar2 = new com.kwad.sdk.core.g.c(bq);
            this.yS = cVar2;
            cVar2.a(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void kj() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.yS.bz(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void kk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.yP.post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.i.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ i yV;

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
                    this.yV = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.yV.yP.kk();
                    }
                }
            });
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void kl() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && com.kwad.components.ad.splashscreen.d.c.b(this.yF)) {
            com.kwad.components.ad.splashscreen.d.c.a(findViewById(R.id.obfuscated_res_0x7f09120a), -1, 60, -1, -1);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void ko() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.kwad.sdk.core.report.a.az(this.yF.mAdTemplate);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onUnbind();
            com.kwad.sdk.core.e.b.d("SplashRotatePresenter", "onUnbind");
            com.kwad.sdk.core.g.c cVar = this.yS;
            if (cVar != null) {
                cVar.bA(getContext());
            }
            com.kwad.components.ad.splashscreen.h hVar = this.yF;
            if (hVar != null) {
                hVar.b(this);
            }
        }
    }
}
