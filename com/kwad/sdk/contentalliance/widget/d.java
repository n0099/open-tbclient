package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.q;
/* loaded from: classes7.dex */
public class d extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f35879a;

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f35880b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35881c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
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
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35881c = z;
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            FrameLayout.inflate(getContext(), R.layout.ksad_content_page_load_more, this);
            TextView textView = (TextView) findViewById(R.id.ksad_loading_tip);
            this.f35879a = textView;
            textView.setTextColor(getContext().getResources().getColor(this.f35881c ? R.color.ksad_hale_page_loading_error_title_light_color : R.color.ksad_hale_page_loading_error_title_dark_color));
            this.f35880b = (LottieAnimationView) findViewById(R.id.ksad_loading_lottie);
            this.f35880b.setAnimation(this.f35881c ? R.raw.ksad_page_loading_light_anim : R.raw.ksad_detail_loading_amin_new);
            this.f35880b.setRepeatMode(1);
            this.f35880b.setRepeatCount(-1);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (!this.f35880b.c()) {
                this.f35880b.d();
            }
            this.f35880b.setVisibility(8);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.f35880b.c()) {
                this.f35880b.b();
            }
            this.f35880b.setVisibility(0);
            this.f35879a.setVisibility(8);
        }
    }

    public void a(boolean z) {
        TextView textView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            c();
            if (z || com.kwad.sdk.core.config.c.X()) {
                this.f35879a.setText(z ? getContext().getString(R.string.ksad_page_load_more_tip) : q.a(getContext()));
                textView = this.f35879a;
                i2 = 0;
            } else {
                textView = this.f35879a;
                i2 = 8;
            }
            textView.setVisibility(i2);
        }
    }
}
