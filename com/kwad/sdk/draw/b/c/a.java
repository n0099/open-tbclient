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
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.draw.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public DrawVideoTailFrame f35692b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f35693c;

    /* renamed from: d  reason: collision with root package name */
    public d f35694d;

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
        this.f35694d = new e(this) { // from class: com.kwad.sdk.draw.b.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35695a;

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
                this.f35695a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.f();
                    if (this.f35695a.f35693c == null || !this.f35695a.f35693c.d()) {
                        this.f35695a.e();
                    } else {
                        this.f35695a.f35692b.setVisibility(8);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f35692b.a();
            this.f35692b.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f35622a;
            this.f35693c = bVar.f35629g;
            this.f35692b.a(bVar.f35625c);
            this.f35692b.setAdBaseFrameLayout(((com.kwad.sdk.draw.a.a) this).f35622a.f35624b);
            this.f35692b.setApkDownloadHelper(((com.kwad.sdk.draw.a.a) this).f35622a.f35626d);
            this.f35692b.setVisibility(8);
            this.f35692b.setAdInteractionListener(((com.kwad.sdk.draw.a.a) this).f35622a.f35623a);
            ((com.kwad.sdk.draw.a.a) this).f35622a.f35627e.a(this.f35694d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f35692b = (DrawVideoTailFrame) a(R.id.ksad_video_tail_frame);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((com.kwad.sdk.draw.a.a) this).f35622a.f35627e.b(this.f35694d);
            this.f35692b.b();
        }
    }
}
