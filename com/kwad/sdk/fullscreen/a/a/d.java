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
/* loaded from: classes2.dex */
public class d extends com.kwad.sdk.reward.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f65819b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f65820c;

    /* renamed from: d  reason: collision with root package name */
    public View f65821d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f65822e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f65823f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.reward.a.d f65824g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f65825h;

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
        this.f65821d = null;
        this.f65824g = new com.kwad.sdk.reward.a.d(this) { // from class: com.kwad.sdk.fullscreen.a.a.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f65826a;

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
                this.f65826a = this;
            }

            @Override // com.kwad.sdk.reward.a.d
            public void a(long j, long j2, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i4)}) == null) {
                    this.f65826a.e();
                }
            }
        };
        this.f65825h = new e(this) { // from class: com.kwad.sdk.fullscreen.a.a.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f65827a;

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
                this.f65827a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 < com.kwad.sdk.core.config.c.P()) {
                    return;
                }
                this.f65827a.e();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.f65821d.getVisibility() == 0) {
            return;
        }
        this.f65821d.setAlpha(0.0f);
        this.f65821d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.fullscreen.a.a.d.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f65828a;

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
                this.f65828a = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    this.f65828a.f65821d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ofFloat.start();
        this.f65821d.setOnClickListener(this);
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            com.kwad.sdk.core.report.a.i(this.f65823f, ((com.kwad.sdk.reward.d) this).f66342a.f66013d);
            ((com.kwad.sdk.reward.d) this).f66342a.f66011b.b();
            ((com.kwad.sdk.reward.d) this).f66342a.f66018i.i();
            ((com.kwad.sdk.reward.d) this).f66342a.b();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66342a;
            this.f65823f = aVar.f66015f;
            aVar.f66018i.a(this.f65825h);
            ((com.kwad.sdk.reward.d) this).f66342a.p.add(this.f65824g);
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
            this.f65822e = (TextView) a(R.id.ksad_detail_call_btn);
            this.f65819b = (ImageView) a(R.id.ksad_skip_icon);
            this.f65820c = (TextView) a(R.id.ksad_top_toolbar_close_tip);
            if (TextUtils.isEmpty(com.kwad.sdk.core.config.c.S())) {
                if (com.kwad.sdk.core.config.c.O() == 0) {
                    imageView = this.f65819b;
                    i2 = R.drawable.ksad_page_close;
                } else {
                    imageView = this.f65819b;
                    i2 = R.drawable.ksad_video_skip_icon;
                }
                imageView.setImageResource(i2);
                this.f65820c.setVisibility(8);
                view = this.f65819b;
            } else {
                this.f65820c.setText(com.kwad.sdk.core.config.c.S());
                this.f65819b.setVisibility(8);
                view = this.f65820c;
            }
            this.f65821d = view;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((com.kwad.sdk.reward.d) this).f66342a.f66018i.b(this.f65825h);
            ((com.kwad.sdk.reward.d) this).f66342a.p.remove(this.f65824g);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f65821d) {
            f();
        }
    }
}
