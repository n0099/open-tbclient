package com.kwad.sdk.draw.b.c;

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
import com.kwad.sdk.d.c;
import com.kwad.sdk.draw.view.playend.DrawVideoTailFrame;
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.draw.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public DrawVideoTailFrame f66543b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f66544c;

    /* renamed from: d  reason: collision with root package name */
    public d f66545d;

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
        this.f66545d = new e(this) { // from class: com.kwad.sdk.draw.b.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f66546a;

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
                this.f66546a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.f();
                    if (this.f66546a.f66544c == null || !this.f66546a.f66544c.d()) {
                        this.f66546a.e();
                    } else {
                        this.f66546a.f66543b.setVisibility(8);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f66543b.a();
            this.f66543b.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f66473a;
            this.f66544c = bVar.f66480g;
            this.f66543b.a(bVar.f66476c);
            this.f66543b.setAdBaseFrameLayout(((com.kwad.sdk.draw.a.a) this).f66473a.f66475b);
            this.f66543b.setApkDownloadHelper(((com.kwad.sdk.draw.a.a) this).f66473a.f66477d);
            this.f66543b.setVisibility(8);
            this.f66543b.setAdInteractionListener(((com.kwad.sdk.draw.a.a) this).f66473a.f66474a);
            ((com.kwad.sdk.draw.a.a) this).f66473a.f66478e.a(this.f66545d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f66543b = (DrawVideoTailFrame) a(R.id.ksad_video_tail_frame);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((com.kwad.sdk.draw.a.a) this).f66473a.f66478e.b(this.f66545d);
            this.f66543b.b();
        }
    }
}
