package com.kwad.sdk.draw.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f58920b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f58921c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f58922d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f58923e;

    public b() {
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
        this.f58922d = new e(this) { // from class: com.kwad.sdk.draw.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.d();
                    if (this.a.f58920b.getVisibility() == 0) {
                        this.a.f58920b.setVisibility(8);
                    }
                }
            }
        };
        this.f58923e = new Runnable(this) { // from class: com.kwad.sdk.draw.a.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int width = this.a.m().getWidth();
                    ViewGroup.LayoutParams layoutParams = this.a.f58920b.getLayoutParams();
                    int c2 = this.a.f58921c.c();
                    int b2 = this.a.f58921c.b();
                    if (c2 == 0 || b2 == 0 || b2 > c2) {
                        layoutParams.width = -1;
                        layoutParams.height = -1;
                        this.a.f58920b.setLayoutParams(layoutParams);
                    } else {
                        layoutParams.width = width;
                        layoutParams.height = (int) ((b2 / (c2 * 1.0f)) * width);
                        this.a.f58920b.setLayoutParams(layoutParams);
                        this.a.f58920b.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }
                    this.a.f58920b.setImageDrawable(null);
                    KSImageLoader.loadImage(this.a.f58920b, this.a.f58921c.a(), ((com.kwad.sdk.draw.kwai.a) this.a).a.f58960c);
                }
            }
        };
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.response.model.c aa = com.kwad.sdk.core.response.a.a.aa(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.draw.kwai.a) this).a.f58960c));
            this.f58921c = aa;
            if (TextUtils.isEmpty(aa.a())) {
                return;
            }
            m().post(this.f58923e);
            this.f58920b.setVisibility(0);
            ((com.kwad.sdk.draw.kwai.a) this).a.f58962e.a(this.f58922d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            m().removeCallbacks(this.f58923e);
            ((com.kwad.sdk.draw.kwai.a) this).a.f58962e.b(this.f58922d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f58920b = (ImageView) a(R.id.ksad_video_first_frame);
        }
    }
}
