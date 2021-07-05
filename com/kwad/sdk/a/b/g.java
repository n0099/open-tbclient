package com.kwad.sdk.a.b;

import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes7.dex */
public class g extends com.kwad.sdk.a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34116b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f34117c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f34118d;

    public g() {
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
        this.f34118d = new com.kwad.sdk.contentalliance.detail.video.f(this) { // from class: com.kwad.sdk.a.b.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f34119a;

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
                this.f34119a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34119a.e();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            KSImageLoader.loadImage(this.f34116b, com.kwad.sdk.core.response.b.a.f(this.f34117c), ((com.kwad.sdk.a.a.a) this).f34067a.f34071d);
            this.f34116b.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f34117c = com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.a.a.a) this).f34067a.f34071d);
            ((com.kwad.sdk.a.a.a) this).f34067a.f34073f.a(this.f34118d);
            this.f34116b.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.a.a.a) this).f34067a.f34073f.b(this.f34118d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34116b = (ImageView) b(R.id.ksad_video_cover_image);
        }
    }
}
