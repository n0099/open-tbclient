package com.kwad.sdk.fullscreen.a.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public class d extends com.kwad.sdk.reward.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f73391b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f73392c;

    /* renamed from: d  reason: collision with root package name */
    public View f73393d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f73394e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f73395f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.reward.a.d f73396g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f73397h;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73393d = null;
        this.f73396g = new com.kwad.sdk.reward.a.d(this) { // from class: com.kwad.sdk.fullscreen.a.a.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f73398a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f73398a = this;
            }

            @Override // com.kwad.sdk.reward.a.d
            public void a(long j2, long j3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4)}) == null) {
                    this.f73398a.e();
                }
            }
        };
        this.f73397h = new e(this) { // from class: com.kwad.sdk.fullscreen.a.a.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f73399a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f73399a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || j3 < com.kwad.sdk.core.config.c.P()) {
                    return;
                }
                this.f73399a.e();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.f73393d.getVisibility() == 0) {
            return;
        }
        this.f73393d.setAlpha(0.0f);
        this.f73393d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.fullscreen.a.a.d.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f73400a;

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
                this.f73400a = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    this.f73400a.f73393d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ofFloat.start();
        this.f73393d.setOnClickListener(this);
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            com.kwad.sdk.core.report.a.i(this.f73395f, ((com.kwad.sdk.reward.d) this).f73944a.f73605d);
            ((com.kwad.sdk.reward.d) this).f73944a.f73603b.b();
            ((com.kwad.sdk.reward.d) this).f73944a.f73610i.i();
            ((com.kwad.sdk.reward.d) this).f73944a.b();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f73944a;
            this.f73395f = aVar.f73607f;
            aVar.f73610i.a(this.f73397h);
            ((com.kwad.sdk.reward.d) this).f73944a.p.add(this.f73396g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        ImageView imageView;
        int i2;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f73394e = (TextView) a(R.id.ksad_detail_call_btn);
            this.f73391b = (ImageView) a(R.id.ksad_skip_icon);
            this.f73392c = (TextView) a(R.id.ksad_top_toolbar_close_tip);
            if (TextUtils.isEmpty(com.kwad.sdk.core.config.c.S())) {
                if (com.kwad.sdk.core.config.c.O() == 0) {
                    imageView = this.f73391b;
                    i2 = R.drawable.ksad_page_close;
                } else {
                    imageView = this.f73391b;
                    i2 = R.drawable.ksad_video_skip_icon;
                }
                imageView.setImageResource(i2);
                this.f73392c.setVisibility(8);
                view = this.f73391b;
            } else {
                this.f73392c.setText(com.kwad.sdk.core.config.c.S());
                this.f73391b.setVisibility(8);
                view = this.f73392c;
            }
            this.f73393d = view;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((com.kwad.sdk.reward.d) this).f73944a.f73610i.b(this.f73397h);
            ((com.kwad.sdk.reward.d) this).f73944a.p.remove(this.f73396g);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f73393d) {
            f();
        }
    }
}
