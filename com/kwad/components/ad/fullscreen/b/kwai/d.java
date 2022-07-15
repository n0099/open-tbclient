package com.kwad.components.ad.fullscreen.b.kwai;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.ad.reward.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView b;
    public TextView c;
    public View d;
    public AdTemplate e;
    public com.kwad.components.ad.reward.c.e f;
    public g g;

    public d() {
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
        this.d = null;
        this.f = new com.kwad.components.ad.reward.c.e(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.c.e
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.e();
                }
            }
        };
        this.g = new h(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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
                this.a = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 < com.kwad.sdk.core.response.a.a.t(com.kwad.sdk.core.response.a.d.i(this.a.e))) {
                    return;
                }
                this.a.e();
            }
        };
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            this.e = lVar.g;
            lVar.j.a(this.g);
            ((com.kwad.components.ad.reward.presenter.a) this).a.r.add(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || this.d.getVisibility() == 0) {
            return;
        }
        this.d.setAlpha(0.0f);
        this.d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    this.a.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ofFloat.start();
        this.d.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (l.b(((com.kwad.components.ad.reward.presenter.a) this).a)) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.a(this);
            } else {
                d();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.c.d
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && "ksad-video-top-bar".equals(str)) {
            d();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        ImageView imageView;
        int i;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i_();
            this.b = (ImageView) b(R.id.obfuscated_res_0x7f091197);
            this.c = (TextView) b(R.id.obfuscated_res_0x7f0911bc);
            if (TextUtils.isEmpty(com.kwad.components.ad.fullscreen.kwai.b.b())) {
                if (com.kwad.components.ad.fullscreen.kwai.b.a() == 0) {
                    imageView = this.b;
                    i = R.drawable.obfuscated_res_0x7f080c07;
                } else {
                    imageView = this.b;
                    i = R.drawable.obfuscated_res_0x7f080c63;
                }
                imageView.setImageResource(i);
                this.c.setVisibility(8);
                view2 = this.b;
            } else {
                this.c.setText(com.kwad.components.ad.fullscreen.kwai.b.b());
                this.b.setVisibility(8);
                view2 = this.c;
            }
            this.d = view2;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this);
            ((com.kwad.components.ad.reward.presenter.a) this).a.j.b(this.g);
            ((com.kwad.components.ad.reward.presenter.a) this).a.r.remove(this.f);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2 == this.d) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            com.kwad.components.ad.reward.presenter.e.a(lVar, false, lVar.l());
        }
    }
}
