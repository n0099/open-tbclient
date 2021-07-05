package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
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
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.v;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class KSPageLoadingView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f35841a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35842b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35843c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35844d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35845e;

    /* renamed from: f  reason: collision with root package name */
    public LottieAnimationView f35846f;

    /* renamed from: g  reason: collision with root package name */
    public LottieAnimationView f35847g;

    /* renamed from: h  reason: collision with root package name */
    public a f35848h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35849i;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSPageLoadingView(@NonNull Context context) {
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
        a((AttributeSet) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSPageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        a(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSPageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
            FrameLayout.inflate(getContext(), R.layout.ksad_content_page_loading, this);
            int i2 = R.attr.ksad_light_style;
            int[] iArr = {i2};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, iArr);
            this.f35849i = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i2), false);
            obtainStyledAttributes.recycle();
            View findViewById = findViewById(R.id.ksad_error_container);
            this.f35841a = findViewById;
            findViewById.setOnClickListener(this);
            this.f35841a.setBackgroundColor(getContext().getResources().getColor(this.f35849i ? R.color.ksad_page_loading_error_container_light_color : R.color.ksad_page_loading_error_container_dark_color));
            ImageView imageView = (ImageView) findViewById(R.id.ksad_error_img);
            this.f35842b = imageView;
            imageView.setVisibility(0);
            TextView textView = (TextView) findViewById(R.id.ksad_error_title);
            this.f35843c = textView;
            textView.setTextColor(getContext().getResources().getColor(this.f35849i ? R.color.ksad_page_loading_error_title_light_color : R.color.ksad_page_loading_error_title_dark_color));
            TextView textView2 = (TextView) findViewById(R.id.ksad_error_sub_title);
            this.f35844d = textView2;
            textView2.setTextColor(getContext().getResources().getColor(this.f35849i ? R.color.ksad_page_loading_error_sub_title_light_color : R.color.ksad_page_loading_error_sub_title_dark_color));
            TextView textView3 = (TextView) findViewById(R.id.ksad_error_retry_btn);
            this.f35845e = textView3;
            textView3.setTextColor(getContext().getResources().getColor(this.f35849i ? R.color.ksad_page_loading_error_retry_light_color : R.color.ksad_page_loading_error_retry_dark_color));
            this.f35845e.setBackgroundResource(this.f35849i ? R.drawable.ksad_page_loading_error_retry_light_bg : R.drawable.ksad_page_loading_error_retry_dark_bg);
            this.f35845e.setOnClickListener(this);
            int i3 = this.f35849i ? R.raw.ksad_page_loading_light_anim : R.raw.ksad_detail_loading_amin_new;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_center_loading_anim);
            this.f35846f = lottieAnimationView;
            lottieAnimationView.setRepeatMode(1);
            this.f35846f.setRepeatCount(-1);
            this.f35846f.setAnimation(i3);
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(R.id.ksad_other_loading_anim);
            this.f35847g = lottieAnimationView2;
            lottieAnimationView2.setRepeatMode(1);
            this.f35847g.setRepeatCount(-1);
            this.f35847g.setAnimation(i3);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            if (!this.f35846f.c()) {
                this.f35846f.d();
            }
            this.f35846f.setVisibility(8);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f35841a.setVisibility(8);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if (!this.f35847g.c()) {
                this.f35847g.d();
            }
            this.f35847g.setVisibility(8);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(8);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            f();
            h();
            this.f35842b.setImageDrawable(getContext().getResources().getDrawable(this.f35849i ? R.drawable.ksad_page_loading_network_error : R.drawable.ksad_content_network_error));
            this.f35843c.setText(q.d(getContext()));
            this.f35843c.setVisibility(0);
            this.f35844d.setText(q.e(getContext()));
            this.f35844d.setVisibility(0);
            this.f35845e.setText(q.i(getContext()));
            this.f35845e.setVisibility(0);
            this.f35841a.setVisibility(0);
            if (z) {
                p.a(getContext());
            }
            setVisibility(0);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h();
            g();
            this.f35846f.setVisibility(0);
            if (!this.f35846f.c()) {
                this.f35846f.b();
            }
            setVisibility(0);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            f();
            h();
            this.f35842b.setImageDrawable(getContext().getResources().getDrawable(this.f35849i ? R.drawable.ksad_page_loading_data_error : R.drawable.ksad_no_data_img));
            this.f35843c.setText(q.g(getContext()));
            this.f35843c.setVisibility(0);
            this.f35844d.setText(q.h(getContext()));
            this.f35844d.setVisibility(0);
            this.f35845e.setText(q.i(getContext()));
            this.f35845e.setVisibility(0);
            this.f35841a.setVisibility(0);
            if (z) {
                p.b(getContext());
            }
            setVisibility(0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f();
            h();
            this.f35842b.setImageDrawable(getContext().getResources().getDrawable(this.f35849i ? R.drawable.ksad_page_loading_data_limit_error : R.drawable.ksad_no_video_img));
            this.f35843c.setText(getContext().getString(R.string.ksad_page_loading_data_limit_error_title));
            this.f35843c.setVisibility(0);
            this.f35844d.setVisibility(8);
            this.f35845e.setVisibility(8);
            this.f35841a.setVisibility(0);
            setVisibility(0);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f();
            h();
            this.f35842b.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_no_video_img));
            this.f35843c.setText(getContext().getString(R.string.ksad_video_no_found));
            this.f35843c.setVisibility(0);
            this.f35844d.setText(getContext().getString(R.string.ksad_click_to_next_video));
            this.f35844d.setVisibility(0);
            this.f35845e.setText(getContext().getString(R.string.ksad_watch_next_video));
            this.f35845e.setVisibility(0);
            this.f35841a.setVisibility(0);
            setVisibility(0);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            g();
            f();
            if (!this.f35847g.c()) {
                this.f35847g.b();
            }
            this.f35847g.setVisibility(0);
            setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view) == null) && view == this.f35845e) {
            if (!v.a(getContext())) {
                p.a(getContext());
                return;
            }
            a aVar = this.f35848h;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void setRetryClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f35848h = aVar;
        }
    }
}
