package com.kwad.sdk.b.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.utils.av;
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.b.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f64044b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.c f64045c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f64046d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f64047e;

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
        this.f64046d = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.b.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f64048a;

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
                this.f64048a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.d();
                    if (this.f64048a.f64044b.getVisibility() == 0) {
                        this.f64048a.f64044b.setVisibility(8);
                    }
                }
            }
        };
        this.f64047e = new Runnable(this) { // from class: com.kwad.sdk.b.b.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f64049a;

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
                this.f64049a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    av.a(this.f64049a.f64044b, this.f64049a.f64045c.c(), this.f64049a.f64045c.b());
                    this.f64049a.f64044b.setImageDrawable(null);
                    KSImageLoader.loadImage(this.f64049a.f64044b, this.f64049a.f64045c.a(), ((com.kwad.sdk.b.a.a) this.f64049a).f64022a.f64026d);
                }
            }
        };
    }

    @Override // com.kwad.sdk.b.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.response.model.c T = com.kwad.sdk.core.response.b.a.T(com.kwad.sdk.core.response.b.c.i(((com.kwad.sdk.b.a.a) this).f64022a.f64026d));
            this.f64045c = T;
            if (TextUtils.isEmpty(T.a())) {
                return;
            }
            j().post(this.f64047e);
            this.f64044b.setVisibility(0);
            ((com.kwad.sdk.b.a.a) this).f64022a.f64028f.a(this.f64046d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f64044b = (ImageView) a(R.id.ksad_video_first_frame);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            j().removeCallbacks(this.f64047e);
            ((com.kwad.sdk.b.a.a) this).f64022a.f64028f.b(this.f64046d);
        }
    }
}
