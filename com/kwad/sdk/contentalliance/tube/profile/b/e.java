package com.kwad.sdk.contentalliance.tube.profile.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.q;
import java.util.Set;
/* loaded from: classes7.dex */
public class e extends com.kwad.sdk.contentalliance.tube.profile.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.c f35747b;

    /* renamed from: c  reason: collision with root package name */
    public Set<com.kwad.sdk.contentalliance.tube.profile.e> f35748c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f35749d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f35750e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35751f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f35752g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f35753h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f35754i;
    public com.kwad.sdk.contentalliance.tube.profile.a j;
    public TextView k;
    public boolean l;

    public e() {
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
        this.j = new com.kwad.sdk.contentalliance.tube.profile.a(this) { // from class: com.kwad.sdk.contentalliance.tube.profile.b.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f35755a;

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
                this.f35755a = this;
            }

            @Override // com.kwad.sdk.contentalliance.tube.profile.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f35755a.f();
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.profile.a
            public void a(int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str) == null) {
                    this.f35755a.a(i4);
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.profile.a
            public void a(TubeProfileResultData tubeProfileResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, tubeProfileResultData) == null) {
                    com.kwad.sdk.core.d.a.a("TubeProfileUpdatePresenter", "tube/profile OK");
                    for (com.kwad.sdk.contentalliance.tube.profile.e eVar : this.f35755a.f35748c) {
                        eVar.a(tubeProfileResultData);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.profile.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f35755a.e();
                }
            }
        };
        this.l = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
            g();
            if (this.l && !com.ksad.download.d.b.a(o())) {
                p.a(o());
                this.l = false;
            }
            c(i2);
        }
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            this.f35750e.setVisibility(0);
            if (!com.ksad.download.d.b.a(o()) || i2 == com.kwad.sdk.core.network.f.f36358a.k) {
                h();
            } else if (i2 == com.kwad.sdk.core.network.f.j.k) {
                q();
            } else {
                p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            f();
            this.f35749d.setVisibility(8);
            this.f35754i.setVisibility(8);
            this.f35750e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f35754i.setVisibility(0);
            this.f35749d.setVisibility(0);
            if (!this.f35749d.c()) {
                this.f35749d.b();
            }
            this.f35750e.setVisibility(8);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f35754i.setVisibility(8);
            if (!this.f35749d.c()) {
                this.f35749d.d();
            }
            this.f35749d.setVisibility(8);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f35752g.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_content_network_error));
            this.f35751f.setText(q.d(o()));
            this.f35753h.setText(q.e(o()));
            this.k.setText(q.i(o()));
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.f35752g.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_data_img));
            this.f35751f.setText(q.g(o()));
            this.f35753h.setText(q.h(o()));
            this.k.setText(q.i(o()));
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f35752g.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_video_img));
            this.f35751f.setText(o().getString(R.string.ksad_video_no_found));
            this.f35753h.setText(o().getString(R.string.ksad_click_to_next_video));
            this.k.setText(o().getString(R.string.ksad_watch_next_video));
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.tube.profile.a.b bVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f35705a;
            this.f35748c = bVar.f35710e;
            com.kwad.sdk.contentalliance.tube.profile.c cVar = new com.kwad.sdk.contentalliance.tube.profile.c(bVar.f35711f, bVar.f35708c.getTubeId(), this.j);
            this.f35747b = cVar;
            cVar.a();
            this.k.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.tube.profile.b.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f35756a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35756a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f35756a.l = true;
                        this.f35756a.f35747b.a();
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f35747b.b();
            g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35749d = (LottieAnimationView) b(R.id.ksad_center_loading_animation_view);
            this.f35750e = (ViewGroup) b(R.id.ksad_error_container);
            this.f35754i = (ImageView) b(R.id.ksad_tube_loading_mask_view);
            this.k = (TextView) b(R.id.ksad_retry_btn);
            int i2 = R.raw.ksad_detail_loading_amin_new;
            this.f35754i.setVisibility(0);
            this.f35751f = (TextView) b(R.id.ksad_load_error_title);
            this.f35752g = (ImageView) b(R.id.ksad_load_error_img);
            this.f35753h = (TextView) b(R.id.ksad_load_error_tip);
            this.f35749d.setVisibility(0);
            this.f35749d.setRepeatMode(1);
            this.f35749d.setRepeatCount(-1);
            this.f35749d.setAnimation(i2);
        }
    }
}
