package com.kwad.sdk.a.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ai;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.a.a.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f34083b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34084c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34085d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f34086e;

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
        this.f34086e = new com.kwad.sdk.contentalliance.detail.video.f(this) { // from class: com.kwad.sdk.a.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34087a;

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
                this.f34087a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.b();
                    this.f34087a.e();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.d();
                    this.f34087a.e();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.f34083b.getVisibility() == 0) {
            this.f34083b.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (!com.ksad.download.d.b.a(this.f34083b.getContext()) || com.ksad.download.d.b.b(this.f34083b.getContext())) {
                this.f34083b.setVisibility(8);
                ((com.kwad.sdk.a.a.a) this).f34067a.f34071d.mVideoPlayerStatus.mVideoPlayerBehavior = 1;
            } else {
                this.f34085d.setText(ai.a(com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.a.a.a) this).f34067a.f34071d)) * 1000));
                this.f34084c.setOnClickListener(this);
                ((com.kwad.sdk.a.a.a) this).f34067a.f34071d.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
                this.f34083b.setVisibility(0);
            }
            ((com.kwad.sdk.a.a.a) this).f34067a.f34073f.a(this.f34086e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.a.a.a) this).f34067a.f34073f.b(this.f34086e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34083b = (ViewGroup) b(R.id.ksad_data_flow_container);
            this.f34084c = (ImageView) b(R.id.ksad_data_flow_play_btn);
            this.f34085d = (TextView) b(R.id.ksad_data_flow_play_tip);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f34084c) {
            ((com.kwad.sdk.a.a.a) this).f34067a.f34073f.f();
        }
    }
}
