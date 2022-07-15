package com.kwad.components.ad.draw.view.playcard;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.l.n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.j;
/* loaded from: classes5.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public AdTemplate b;
    public a c;
    public int d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public KsLogoView h;
    public ValueAnimator i;

    /* loaded from: classes5.dex */
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
    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet) {
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
    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i) {
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
            this.i = a2;
            a2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.i.setDuration(300L);
            this.i.start();
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            this.a = context;
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0413, this);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091010);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091006);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091012);
            this.h = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09103b);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            a(this.d, 0);
        }
    }

    private void d() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (valueAnimator = this.i) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.i.cancel();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, aVar) == null) {
            this.b = adTemplate;
            AdInfo i = d.i(adTemplate);
            this.c = aVar;
            this.f.setText(com.kwad.sdk.core.response.a.a.z(i));
            this.g.setText(com.kwad.sdk.core.response.a.a.H(i));
            this.e.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.h.a(adTemplate);
            setOnClickListener(this);
            this.f.measure(View.MeasureSpec.makeMeasureSpec((j.b(this.a) - (com.kwad.sdk.b.kwai.a.a(this.a, 16.0f) * 2)) - (com.kwad.sdk.b.kwai.a.a(this.a, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.d = com.kwad.sdk.b.kwai.a.a(this.a, 100.0f) + this.f.getMeasuredHeight();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(0, this.d);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2 != this.e) {
                com.kwad.components.core.c.a.a.a(new a.C0507a(getContext()).a(this.b).a(new a.b(this) { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardH5.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DrawCardH5 a;

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
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.c == null) {
                            return;
                        }
                        this.a.c.b();
                    }
                }));
                return;
            }
            c();
            a aVar = this.c;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
