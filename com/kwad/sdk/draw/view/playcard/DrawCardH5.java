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
/* loaded from: classes2.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f66575a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f66576b;

    /* renamed from: c  reason: collision with root package name */
    public a f66577c;

    /* renamed from: d  reason: collision with root package name */
    public int f66578d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f66579e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66580f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66581g;

    /* renamed from: h  reason: collision with root package name */
    public KsLogoView f66582h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f66583i;

    /* loaded from: classes2.dex */
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
            this.f66583i = a2;
            a2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.f66583i.setDuration(300L);
            this.f66583i.start();
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
            this.f66575a = context;
            FrameLayout.inflate(context, R.layout.ksad_draw_card_h5, this);
            this.f66579e = (ImageView) findViewById(R.id.ksad_card_close);
            this.f66580f = (TextView) findViewById(R.id.ksad_card_ad_desc);
            this.f66581g = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
            this.f66582h = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
        }
    }

    private void d() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (valueAnimator = this.f66583i) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.f66583i.cancel();
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
            this.f66576b = adTemplate;
            AdInfo i2 = c.i(adTemplate);
            this.f66577c = aVar;
            this.f66580f.setText(com.kwad.sdk.core.response.b.a.m(i2));
            this.f66581g.setText(com.kwad.sdk.core.response.b.a.u(i2));
            this.f66579e.setOnClickListener(this);
            this.f66581g.setOnClickListener(this);
            this.f66582h.a(adTemplate);
            setOnClickListener(this);
            this.f66580f.measure(View.MeasureSpec.makeMeasureSpec((ap.k(this.f66575a) - (av.a(this.f66575a, 16.0f) * 2)) - (av.a(this.f66575a, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f66578d = av.a(this.f66575a, 100.0f) + this.f66580f.getMeasuredHeight();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(0, this.f66578d);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a(this.f66578d, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view != this.f66579e) {
                com.kwad.sdk.core.download.b.a.a(getContext(), this.f66576b, new a.InterfaceC1941a(this) { // from class: com.kwad.sdk.draw.view.playcard.DrawCardH5.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ DrawCardH5 f66584a;

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
                        this.f66584a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC1941a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f66584a.f66577c == null) {
                            return;
                        }
                        this.f66584a.f66577c.b();
                    }
                }, null, view == this.f66581g);
                return;
            }
            c();
            a aVar = this.f66577c;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
