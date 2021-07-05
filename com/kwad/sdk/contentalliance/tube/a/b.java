package com.kwad.sdk.contentalliance.tube.a;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f35602b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35603c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35604d;

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
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j.mIsTubeEpisodeList) {
                viewGroup = this.f35602b;
                i2 = 0;
            } else {
                viewGroup = this.f35602b;
                i2 = 8;
            }
            viewGroup.setVisibility(i2);
            this.f35603c.setText(com.kwad.sdk.core.response.b.d.A(com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j)));
            this.f35604d.setText(com.kwad.sdk.core.response.b.d.B(com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j)));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f35602b.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35602b = (ViewGroup) b(R.id.ksad_photo_tube_title_container);
            this.f35603c = (TextView) b(R.id.ksad_content_alliance_tube_title);
            this.f35604d = (TextView) b(R.id.ksad_content_alliance_tube_episode_name);
        }
    }
}
