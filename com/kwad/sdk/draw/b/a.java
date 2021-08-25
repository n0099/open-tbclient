package com.kwad.sdk.draw.b;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.draw.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f72598b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f72599c;

    /* renamed from: d  reason: collision with root package name */
    public d f72600d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f72601e;

    public a() {
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
        this.f72600d = new e(this) { // from class: com.kwad.sdk.draw.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f72602a;

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
                this.f72602a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.d();
                    if (this.f72602a.f72598b.getVisibility() == 0) {
                        this.f72602a.f72598b.setVisibility(8);
                    }
                }
            }
        };
        this.f72601e = new Runnable(this) { // from class: com.kwad.sdk.draw.b.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f72603a;

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
                this.f72603a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int width = this.f72603a.j().getWidth();
                    ViewGroup.LayoutParams layoutParams = this.f72603a.f72598b.getLayoutParams();
                    int c2 = this.f72603a.f72599c.c();
                    int b2 = this.f72603a.f72599c.b();
                    if (c2 == 0 || b2 == 0 || b2 > c2) {
                        layoutParams.width = -1;
                        layoutParams.height = -1;
                        this.f72603a.f72598b.setLayoutParams(layoutParams);
                    } else {
                        layoutParams.width = width;
                        layoutParams.height = (int) ((b2 / (c2 * 1.0f)) * width);
                        this.f72603a.f72598b.setLayoutParams(layoutParams);
                        this.f72603a.f72598b.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }
                    this.f72603a.f72598b.setImageDrawable(null);
                    KSImageLoader.loadImage(this.f72603a.f72598b, this.f72603a.f72599c.a(), ((com.kwad.sdk.draw.a.a) this.f72603a).f72586a.f72589c);
                }
            }
        };
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.response.model.c T = com.kwad.sdk.core.response.b.a.T(com.kwad.sdk.core.response.b.c.i(((com.kwad.sdk.draw.a.a) this).f72586a.f72589c));
            this.f72599c = T;
            if (TextUtils.isEmpty(T.a())) {
                return;
            }
            j().post(this.f72601e);
            this.f72598b.setVisibility(0);
            ((com.kwad.sdk.draw.a.a) this).f72586a.f72591e.a(this.f72600d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f72598b = (ImageView) a(R.id.ksad_video_first_frame);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            j().removeCallbacks(this.f72601e);
            ((com.kwad.sdk.draw.a.a) this).f72586a.f72591e.b(this.f72600d);
        }
    }
}
