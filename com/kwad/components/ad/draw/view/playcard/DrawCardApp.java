package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
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
import com.kwad.components.core.l.n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate a;
    public AdInfo b;
    public b c;
    public KsAppDownloadListener d;
    public a e;
    public int f;
    public ImageView g;
    public ImageView h;
    public TextView i;
    public ViewGroup j;
    public AppScoreView k;
    public TextView l;
    public TextView m;
    public KsLogoView n;
    public DrawDownloadProgressBar o;
    public ValueAnimator p;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawCardApp(Context context) {
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
    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet) {
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
    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i) {
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

    private void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i, i2) == null) {
            d();
            ValueAnimator a2 = n.a(this, i, i2);
            this.p = a2;
            a2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.p.setDuration(300L);
            this.p.start();
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0412, this);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f091007);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f09100c);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f09100d);
            this.j = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09100f);
            this.k = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f09100e);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f09100b);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091009);
            this.n = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091013);
            DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f09100a);
            this.o = drawDownloadProgressBar;
            drawDownloadProgressBar.setTextSize(16);
            this.f = com.kwad.sdk.b.kwai.a.a(context, 156.0f);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            a(this.f, 0);
        }
    }

    private void d() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (valueAnimator = this.p) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.p.cancel();
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.d == null) {
                this.d = new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DrawCardApp a;

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
                            this.a.o.a(com.kwad.sdk.core.response.a.a.a(), i);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.a.o.a(com.kwad.sdk.core.response.a.a.H(this.a.b), this.a.o.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.a.o.a(com.kwad.sdk.core.response.a.a.a(this.a.a), this.a.o.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.a.o.a(com.kwad.sdk.core.response.a.a.H(this.a.b), this.a.o.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.a.o.a(com.kwad.sdk.core.response.a.a.n(this.a.b), this.a.o.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                            DrawDownloadProgressBar drawDownloadProgressBar = this.a.o;
                            drawDownloadProgressBar.a(i + "%", i);
                        }
                    }
                };
            }
            return this.d;
        }
        return (KsAppDownloadListener) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
            this.c = null;
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, aVar) == null) {
            this.a = adTemplate;
            this.b = d.i(adTemplate);
            this.e = aVar;
            this.c = new b(this.a, getAppDownloadListener());
            KSImageLoader.loadAppIcon(this.h, com.kwad.sdk.core.response.a.a.aE(this.b), adTemplate, 11);
            this.i.setText(com.kwad.sdk.core.response.a.a.A(this.b));
            String D = com.kwad.sdk.core.response.a.a.D(this.b);
            float E = com.kwad.sdk.core.response.a.a.E(this.b);
            boolean z = E >= 3.0f;
            if (z) {
                this.k.setScore(E);
                this.k.setVisibility(0);
            }
            boolean z2 = !TextUtils.isEmpty(D);
            if (z2) {
                this.l.setText(D);
                this.l.setVisibility(0);
            }
            if (z || z2) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
            this.n.a(this.a);
            this.m.setText(com.kwad.sdk.core.response.a.a.z(this.b));
            this.g.setOnClickListener(this);
            this.o.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(0, this.f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2 != this.g) {
                com.kwad.components.core.c.a.a.a(new a.C0507a(getContext()).a(this.a).a(this.c).a(view2 == this.o).a(view2 == this.o ? 1 : 2).a(new a.b(this) { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DrawCardApp a;

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
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.e == null) {
                            return;
                        }
                        this.a.e.b();
                    }
                }));
                return;
            }
            c();
            a aVar = this.e;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
