package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.content.res.TypedArray;
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
import java.util.Arrays;
/* loaded from: classes7.dex */
public class KSHalfPageLoadingView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f35838a;

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f35839b;

    /* renamed from: c  reason: collision with root package name */
    public KSPageLoadingView.a f35840c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSHalfPageLoadingView(@NonNull Context context) {
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
    public KSHalfPageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public KSHalfPageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
            FrameLayout.inflate(getContext(), R.layout.ksad_content_half_page_loading, this);
            int i2 = R.attr.ksad_light_style;
            int[] iArr = {i2};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, iArr);
            boolean z = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i2), false);
            obtainStyledAttributes.recycle();
            TextView textView = (TextView) findViewById(R.id.ksad_error_tip);
            this.f35838a = textView;
            textView.setTextColor(getContext().getResources().getColor(z ? R.color.ksad_hale_page_loading_error_title_light_color : R.color.ksad_hale_page_loading_error_title_dark_color));
            this.f35838a.setOnClickListener(this);
            int i3 = z ? R.raw.ksad_page_loading_light_anim : R.raw.ksad_detail_loading_amin_new;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_loading_anim);
            this.f35839b = lottieAnimationView;
            lottieAnimationView.setRepeatMode(1);
            this.f35839b.setRepeatCount(-1);
            this.f35839b.setAnimation(i3);
            setOnClickListener(this);
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, str) == null) {
            g();
            this.f35838a.setText(str);
            this.f35838a.setVisibility(0);
            this.f35838a.setOnClickListener(null);
            setVisibility(0);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            if (!this.f35839b.c()) {
                this.f35839b.d();
            }
            this.f35839b.setVisibility(8);
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
            this.f35838a.setVisibility(8);
            this.f35839b.setVisibility(0);
            if (!this.f35839b.c()) {
                this.f35839b.b();
            }
            setVisibility(0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g();
            this.f35838a.setText(q.j(getContext()));
            this.f35838a.setVisibility(0);
            this.f35838a.setOnClickListener(this);
            p.a(getContext());
            setVisibility(0);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g();
            this.f35838a.setText(q.j(getContext()));
            this.f35838a.setVisibility(0);
            this.f35838a.setOnClickListener(this);
            p.b(getContext());
            setVisibility(0);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a(getContext().getString(R.string.ksad_half_page_loading_no_related_tip));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a(getContext().getString(R.string.ksad_half_page_loading_no_comment_tip));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (!v.a(getContext())) {
                p.a(getContext());
                return;
            }
            KSPageLoadingView.a aVar = this.f35840c;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void setRetryClickListener(KSPageLoadingView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f35840c = aVar;
        }
    }
}
