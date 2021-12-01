package com.kwad.sdk.draw.a.b;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public DrawVideoTailFrame f58343b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f58344c;

    /* renamed from: d  reason: collision with root package name */
    public d f58345d;

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
        this.f58345d = new e(this) { // from class: com.kwad.sdk.draw.a.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.f();
                    if (this.a.f58344c == null || !this.a.f58344c.d()) {
                        this.a.e();
                    } else {
                        this.a.f58343b.setVisibility(8);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f58343b.a();
            this.f58343b.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.draw.kwai.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a;
            this.f58344c = bVar.f58383g;
            this.f58343b.a(bVar.f58379c);
            this.f58343b.setAdBaseFrameLayout(((com.kwad.sdk.draw.kwai.a) this).a.f58378b);
            this.f58343b.setApkDownloadHelper(((com.kwad.sdk.draw.kwai.a) this).a.f58380d);
            this.f58343b.setVisibility(8);
            this.f58343b.setAdInteractionListener(((com.kwad.sdk.draw.kwai.a) this).a.a);
            ((com.kwad.sdk.draw.kwai.a) this).a.f58381e.a(this.f58345d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            ((com.kwad.sdk.draw.kwai.a) this).a.f58381e.b(this.f58345d);
            this.f58343b.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f58343b = (DrawVideoTailFrame) a(R.id.ksad_video_tail_frame);
        }
    }
}
