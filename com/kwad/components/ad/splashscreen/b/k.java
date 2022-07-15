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
/* loaded from: classes5.dex */
public final class k extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo b;
    public AdMatrixInfo.SplashSlideInfo c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public com.kwad.components.ad.splashscreen.widget.c g;
    public AdBaseFrameLayout h;
    public KsSplashSlidePathView i;
    public com.kwad.components.core.c.a.b j;
    public com.kwad.components.ad.splashscreen.d.a k;
    public double l;

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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        TextView textView;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65541, this) != null) {
            return;
        }
        AdMatrixInfo.SplashSlideInfo splashSlideInfo = this.b.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
        this.c = splashSlideInfo;
        this.l = splashSlideInfo.convertDistance;
        int i = splashSlideInfo.style;
        com.kwad.components.ad.splashscreen.widget.c cVar = new com.kwad.components.ad.splashscreen.widget.c(u(), i);
        this.g = cVar;
        this.f.setImageDrawable(cVar);
        this.f.post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.k.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

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
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.g();
                    if (this.a.g != null) {
                        this.a.g.start();
                    }
                }
            }
        });
        if (!TextUtils.isEmpty(this.c.title)) {
            textView = this.d;
            str = this.c.title;
        } else if (i == 0) {
            textView = this.d;
            str = "向上滑动";
        } else if (i != 1) {
            if (i == 2) {
                textView = this.d;
                str = "向右滑动";
            }
            if (TextUtils.isEmpty(this.c.subtitle)) {
                this.e.setText(this.c.subtitle);
                return;
            } else if (!com.kwad.sdk.core.response.a.a.I(this.b)) {
                this.e.setText("跳转详情页或者第三方应用");
                return;
            } else {
                this.e.setText(com.kwad.components.ad.splashscreen.e.a(((e) this).a.c, this.b, this.j.a()));
                return;
            }
        } else {
            textView = this.d;
            str = "向左滑动";
        }
        textView.setText(str);
        if (TextUtils.isEmpty(this.c.subtitle)) {
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.kwad.components.ad.splashscreen.d.a aVar = this.k;
            if (aVar != null) {
                aVar.a(((e) this).a.c);
                return;
            }
            com.kwad.components.ad.splashscreen.d.a aVar2 = new com.kwad.components.ad.splashscreen.d.a(this, u(), ((e) this).a.c) { // from class: com.kwad.components.ad.splashscreen.b.k.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k a;

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
                    this.a = this;
                }

                @Override // com.kwad.components.ad.splashscreen.d.a
                public final void a(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        this.a.e.setText(str);
                    }
                }
            };
            this.k = aVar2;
            this.j.a(aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.c == null) {
            return;
        }
        u.b bVar = new u.b();
        bVar.a(this.c.style);
        com.kwad.sdk.core.report.a.a(((e) this).a.c, 190, bVar, (JSONObject) null);
        com.kwad.components.ad.splashscreen.local.b.f(u());
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.components.ad.splashscreen.h hVar = ((e) this).a;
            if (hVar == null) {
                return;
            }
            this.b = com.kwad.sdk.core.response.a.d.i(hVar.c);
            this.j = ((e) this).a.f;
            d();
            if (com.kwad.sdk.core.response.a.a.I(this.b)) {
                e();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
            ((ViewStub) b(R.id.obfuscated_res_0x7f09119c)).inflate();
            this.d = (TextView) b(R.id.obfuscated_res_0x7f0911af);
            this.e = (TextView) b(R.id.obfuscated_res_0x7f0911ae);
            this.f = (ImageView) b(R.id.obfuscated_res_0x7f0911ad);
            this.h = (AdBaseFrameLayout) b(R.id.obfuscated_res_0x7f0911aa);
            KsSplashSlidePathView ksSplashSlidePathView = (KsSplashSlidePathView) ((ViewStub) b(R.id.obfuscated_res_0x7f0911ac)).inflate();
            this.i = ksSplashSlidePathView;
            ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a(this) { // from class: com.kwad.components.ad.splashscreen.b.k.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k a;

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

                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && m.a(this.a.b)) {
                        k kVar = this.a;
                        com.kwad.components.ad.splashscreen.h hVar = ((e) kVar).a;
                        if (hVar != null) {
                            hVar.a(kVar.u(), 53, 2);
                        }
                    }
                }

                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void a(float f, float f2, float f3, float f4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                        float b = com.kwad.sdk.b.kwai.a.b(this.a.u(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                        if (b >= this.a.l) {
                            k kVar = this.a;
                            com.kwad.components.ad.splashscreen.h hVar = ((e) kVar).a;
                            if (hVar != null) {
                                hVar.a(kVar.u(), 153, 2, new h.a(this, b) { // from class: com.kwad.components.ad.splashscreen.b.k.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ float a;
                                    public final /* synthetic */ AnonymousClass1 b;

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
                                        this.b = this;
                                        this.a = b;
                                    }

                                    @Override // com.kwad.components.ad.splashscreen.h.a
                                    public final void a(@NonNull com.kwad.sdk.core.report.f fVar) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeL(1048576, this, fVar) == null) {
                                            fVar.i(this.b.a.c.style);
                                            fVar.j((int) this.a);
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            });
        }
    }
}
