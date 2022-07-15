package com.kwad.components.ad.draw.view.playend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.a.b;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.download.kwai.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes5.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBaseFrameLayout a;
    public AdTemplate b;
    public AdInfo c;
    @Nullable
    public b d;
    @Nullable
    public KsAppDownloadListener e;
    public ImageView f;
    public ViewGroup g;
    public ImageView h;
    public TextView i;
    public AppScoreView j;
    public TextView k;
    public TextView l;
    public DrawDownloadProgressBar m;
    public ViewGroup n;
    public TextView o;
    public TextView p;
    public KsDrawAd.AdInteractionListener q;
    public KsLogoView r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawVideoTailFrame(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0416, this);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911ce);
            this.g = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090ff0);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ff5);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff7);
            this.j = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f090ff8);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff4);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f090fef);
            DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f090ff3);
            this.m = drawDownloadProgressBar;
            drawDownloadProgressBar.setTextSize(15);
            this.n = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09104b);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f09104a);
            this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f09104e);
            this.r = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09103c);
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? new a(this) { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DrawVideoTailFrame a;

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
                    super.a(i);
                    this.a.m.a(com.kwad.sdk.core.response.a.a.a(), i);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.m.a(com.kwad.sdk.core.response.a.a.H(this.a.c), this.a.m.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.m.a(com.kwad.sdk.core.response.a.a.a(this.a.b), this.a.m.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.a.m.a(com.kwad.sdk.core.response.a.a.H(this.a.c), this.a.m.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.a.m.a(com.kwad.sdk.core.response.a.a.n(this.a.c), this.a.m.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                    DrawDownloadProgressBar drawDownloadProgressBar = this.a.m;
                    drawDownloadProgressBar.a(i + "%", i);
                }
            }
        } : (KsAppDownloadListener) invokeV.objValue;
    }

    public final void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.d) == null) {
            return;
        }
        KsAppDownloadListener ksAppDownloadListener = this.e;
        if (ksAppDownloadListener != null) {
            bVar.c(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener appDownloadListener = getAppDownloadListener();
        this.e = appDownloadListener;
        this.d.a(appDownloadListener);
    }

    public final void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.b = adTemplate;
            AdInfo i = d.i(adTemplate);
            this.c = i;
            AdInfo.AdMaterialInfo.MaterialFeature Q = com.kwad.sdk.core.response.a.a.Q(i);
            String str = Q.coverUrl;
            this.r.a(adTemplate);
            if (!TextUtils.isEmpty(str)) {
                int i2 = Q.width;
                int i3 = Q.height;
                if (i2 > 0 && i2 > i3) {
                    int c = com.kwad.sdk.b.kwai.a.c(getContext());
                    if (getWidth() != 0) {
                        c = getWidth();
                    }
                    ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
                    layoutParams.width = c;
                    layoutParams.height = (int) (c * (i3 / i2));
                }
                KSImageLoader.loadImage(this.f, str, this.b);
            }
            if (com.kwad.sdk.core.response.a.a.I(this.c)) {
                KSImageLoader.loadAppIcon(this.h, com.kwad.sdk.core.response.a.a.aE(this.c), this.b, 11);
                this.i.setText(com.kwad.sdk.core.response.a.a.A(this.c));
                float E = com.kwad.sdk.core.response.a.a.E(this.c);
                if (E >= 3.0f) {
                    this.j.setScore(E);
                    this.j.setVisibility(0);
                }
                this.k.setText(com.kwad.sdk.core.response.a.a.D(this.c));
                this.l.setText(com.kwad.sdk.core.response.a.a.z(this.c));
                this.g.setVisibility(0);
                this.n.setVisibility(8);
            } else {
                this.o.setText(com.kwad.sdk.core.response.a.a.z(this.c));
                this.p.setText(com.kwad.sdk.core.response.a.a.H(this.c));
                this.g.setVisibility(8);
                this.n.setVisibility(0);
            }
            this.m.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    public final void b() {
        b bVar;
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.d) == null || (ksAppDownloadListener = this.e) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0507a(getContext()).a(this.b).a(this.d).a(view2 == this.m ? 1 : 2).a(view2 == this.m).a(new a.b(this) { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DrawVideoTailFrame a;

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

                @Override // com.kwad.components.core.c.a.a.b
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.a.q != null) {
                            this.a.q.onAdClicked();
                        }
                        com.kwad.sdk.core.report.a.a(this.a.b, 2, this.a.a.getTouchCoords());
                    }
                }
            }));
        }
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adBaseFrameLayout) == null) {
            this.a = adBaseFrameLayout;
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adInteractionListener) == null) {
            this.q = adInteractionListener;
        }
    }

    public void setApkDownloadHelper(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.d = bVar;
        }
    }
}
