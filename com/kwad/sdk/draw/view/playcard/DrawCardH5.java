package com.kwad.sdk.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes10.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f72871a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f72872b;

    /* renamed from: c  reason: collision with root package name */
    public a f72873c;

    /* renamed from: d  reason: collision with root package name */
    public int f72874d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f72875e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f72876f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f72877g;

    /* renamed from: h  reason: collision with root package name */
    public KsLogoView f72878h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f72879i;

    /* loaded from: classes10.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawCardH5(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }

    private void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3) == null) {
            d();
            ValueAnimator a2 = at.a(this, i2, i3);
            this.f72879i = a2;
            a2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.f72879i.setDuration(300L);
            this.f72879i.start();
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
            this.f72871a = context;
            FrameLayout.inflate(context, R.layout.ksad_draw_card_h5, this);
            this.f72875e = (ImageView) findViewById(R.id.ksad_card_close);
            this.f72876f = (TextView) findViewById(R.id.ksad_card_ad_desc);
            this.f72877g = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
            this.f72878h = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
        }
    }

    private void d() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (valueAnimator = this.f72879i) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.f72879i.cancel();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
        }
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, aVar) == null) {
            this.f72872b = adTemplate;
            AdInfo i2 = c.i(adTemplate);
            this.f72873c = aVar;
            this.f72876f.setText(com.kwad.sdk.core.response.b.a.m(i2));
            this.f72877g.setText(com.kwad.sdk.core.response.b.a.u(i2));
            this.f72875e.setOnClickListener(this);
            this.f72877g.setOnClickListener(this);
            this.f72878h.a(adTemplate);
            setOnClickListener(this);
            this.f72876f.measure(View.MeasureSpec.makeMeasureSpec((ap.k(this.f72871a) - (av.a(this.f72871a, 16.0f) * 2)) - (av.a(this.f72871a, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f72874d = av.a(this.f72871a, 100.0f) + this.f72876f.getMeasuredHeight();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(0, this.f72874d);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a(this.f72874d, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view != this.f72875e) {
                com.kwad.sdk.core.download.b.a.a(getContext(), this.f72872b, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.draw.view.playcard.DrawCardH5.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ DrawCardH5 f72880a;

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
                        this.f72880a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f72880a.f72873c == null) {
                            return;
                        }
                        this.f72880a.f72873c.b();
                    }
                }, null, view == this.f72877g);
                return;
            }
            c();
            a aVar = this.f72873c;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
