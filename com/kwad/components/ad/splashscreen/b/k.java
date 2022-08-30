package com.kwad.components.ad.splashscreen.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class k extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView eQ;
    public AdInfo mAdInfo;
    public AdBaseFrameLayout mRootContainer;
    public com.kwad.components.ad.splashscreen.d.a yM;
    public AdMatrixInfo.SplashSlideInfo zd;
    public TextView ze;
    public ImageView zf;
    public com.kwad.components.ad.splashscreen.widget.c zg;
    public KsSplashSlidePathView zh;
    public com.kwad.components.core.c.a.c zi;
    public double zj;

    public k() {
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initView() {
        TextView textView;
        String str;
        TextView textView2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65546, this) != null) {
            return;
        }
        AdMatrixInfo.SplashSlideInfo splashSlideInfo = this.mAdInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
        this.zd = splashSlideInfo;
        this.zj = splashSlideInfo.convertDistance;
        int i = splashSlideInfo.style;
        com.kwad.components.ad.splashscreen.widget.c cVar = new com.kwad.components.ad.splashscreen.widget.c(getContext(), i);
        this.zg = cVar;
        this.zf.setImageDrawable(cVar);
        this.zf.post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.k.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k zk;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.zk = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.zk.ks();
                    if (this.zk.zg != null) {
                        this.zk.zg.start();
                    }
                }
            }
        });
        if (!TextUtils.isEmpty(this.zd.title)) {
            textView = this.eQ;
            str = this.zd.title;
        } else if (i == 0) {
            textView = this.eQ;
            str = "向上滑动";
        } else if (i != 1) {
            if (i == 2) {
                textView = this.eQ;
                str = "向右滑动";
            }
            if (TextUtils.isEmpty(this.zd.subtitle)) {
                textView2 = this.ze;
                str2 = this.zd.subtitle;
            } else if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                this.ze.setText(com.kwad.components.ad.splashscreen.e.a(this.yF.mAdTemplate, this.mAdInfo, this.zi.mI()));
                if (com.kwad.components.ad.splashscreen.d.c.b(this.yF)) {
                    com.kwad.components.ad.splashscreen.d.c.a(findViewById(R.id.obfuscated_res_0x7f0911e1), -1, 60, -1, -1);
                    return;
                }
                return;
            } else {
                textView2 = this.ze;
                str2 = "跳转详情页或者第三方应用";
            }
            textView2.setText(str2);
            if (com.kwad.components.ad.splashscreen.d.c.b(this.yF)) {
            }
        } else {
            textView = this.eQ;
            str = "向左滑动";
        }
        textView.setText(str);
        if (TextUtils.isEmpty(this.zd.subtitle)) {
        }
        textView2.setText(str2);
        if (com.kwad.components.ad.splashscreen.d.c.b(this.yF)) {
        }
    }

    private void kr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            com.kwad.components.ad.splashscreen.d.a aVar = this.yM;
            if (aVar != null) {
                aVar.setAdTemplate(this.yF.mAdTemplate);
                return;
            }
            com.kwad.components.ad.splashscreen.d.a aVar2 = new com.kwad.components.ad.splashscreen.d.a(this, getContext(), this.yF.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.k.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k zk;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (AdTemplate) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.zk = this;
                }

                @Override // com.kwad.components.ad.splashscreen.d.a
                public final void Z(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        this.zk.ze.setText(str);
                    }
                }
            };
            this.yM = aVar2;
            this.zi.b(aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ks() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.zd == null) {
            return;
        }
        u.b bVar = new u.b();
        bVar.aV(this.zd.style);
        com.kwad.sdk.core.report.a.a(this.yF.mAdTemplate, 190, bVar, (JSONObject) null);
        com.kwad.components.ad.splashscreen.local.b.U(getContext());
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            com.kwad.components.ad.splashscreen.h hVar = this.yF;
            if (hVar == null) {
                return;
            }
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(hVar.mAdTemplate);
            this.zi = this.yF.mApkDownloadHelper;
            initView();
            if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                kr();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            ((ViewStub) findViewById(R.id.obfuscated_res_0x7f0911cf)).inflate();
            this.eQ = (TextView) findViewById(R.id.obfuscated_res_0x7f0911e2);
            this.ze = (TextView) findViewById(R.id.obfuscated_res_0x7f0911e1);
            this.zf = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911e0);
            this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0911dd);
            KsSplashSlidePathView ksSplashSlidePathView = (KsSplashSlidePathView) ((ViewStub) findViewById(R.id.obfuscated_res_0x7f0911df)).inflate();
            this.zh = ksSplashSlidePathView;
            ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a(this) { // from class: com.kwad.components.ad.splashscreen.b.k.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k zk;

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
                    this.zk = this;
                }

                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void a(float f, float f2, float f3, float f4) {
                    k kVar;
                    com.kwad.components.ad.splashscreen.h hVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                        float b = com.kwad.sdk.b.kwai.a.b(this.zk.getContext(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                        if (b < this.zk.zj || (hVar = (kVar = this.zk).yF) == null) {
                            return;
                        }
                        hVar.a(kVar.getContext(), 153, 2, new h.a(this, b) { // from class: com.kwad.components.ad.splashscreen.b.k.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ float zl;
                            public final /* synthetic */ AnonymousClass1 zm;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Float.valueOf(b)};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.zm = this;
                                this.zl = b;
                            }

                            @Override // com.kwad.components.ad.splashscreen.h.a
                            public final void b(@NonNull com.kwad.sdk.core.report.f fVar) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, fVar) == null) {
                                    fVar.aQ(this.zm.zk.zd.style);
                                    fVar.aR((int) this.zl);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void kt() {
                    k kVar;
                    com.kwad.components.ad.splashscreen.h hVar;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && m.n(this.zk.mAdInfo) && (hVar = (kVar = this.zk).yF) != null) {
                        hVar.c(kVar.getContext(), 53, 2);
                    }
                }
            });
        }
    }
}
