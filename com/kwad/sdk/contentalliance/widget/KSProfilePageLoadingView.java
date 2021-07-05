package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.v;
/* loaded from: classes7.dex */
public class KSProfilePageLoadingView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f35850a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35851b;

    /* renamed from: c  reason: collision with root package name */
    public LottieAnimationView f35852c;

    /* renamed from: d  reason: collision with root package name */
    public KSPageLoadingView.a f35853d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSProfilePageLoadingView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSProfilePageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSProfilePageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, attributeSet) == null) {
            FrameLayout.inflate(getContext(), R.layout.ksad_profile_page_loading, this);
            TextView textView = (TextView) findViewById(R.id.ksad_error_title);
            this.f35850a = textView;
            textView.setOnClickListener(this);
            this.f35851b = (TextView) findViewById(R.id.ksad_error_sub_title);
            int i2 = R.raw.ksad_detail_loading_amin_new;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_loading_anim);
            this.f35852c = lottieAnimationView;
            lottieAnimationView.setRepeatMode(1);
            this.f35852c.setRepeatCount(-1);
            this.f35852c.setAnimation(i2);
            setOnClickListener(this);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            if (!this.f35852c.c()) {
                this.f35852c.d();
            }
            this.f35852c.setVisibility(8);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f35850a.setVisibility(8);
            this.f35851b.setVisibility(8);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(8);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f();
            this.f35852c.setVisibility(0);
            if (!this.f35852c.c()) {
                this.f35852c.b();
            }
            setVisibility(0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e();
            this.f35850a.setText(q.d(getContext()));
            this.f35850a.setVisibility(0);
            this.f35851b.setText(q.e(getContext()));
            this.f35851b.setVisibility(0);
            p.a(getContext());
            setVisibility(0);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e();
            this.f35850a.setText(q.g(getContext()));
            this.f35850a.setVisibility(0);
            this.f35851b.setText(q.h(getContext()));
            this.f35851b.setVisibility(0);
            p.b(getContext());
            setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (!v.a(getContext())) {
                c();
                return;
            }
            KSPageLoadingView.a aVar = this.f35853d;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void setRetryClickListener(KSPageLoadingView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f35853d = aVar;
        }
    }
}
