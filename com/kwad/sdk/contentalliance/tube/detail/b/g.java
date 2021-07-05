package com.kwad.sdk.contentalliance.tube.detail.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.q;
/* loaded from: classes7.dex */
public class g extends com.kwad.sdk.contentalliance.tube.detail.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f35686b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f35687c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f35688d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35689e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f35690f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f35691g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f35692h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35693i;
    public b.a j;
    public View.OnClickListener k;

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
        this.j = new b.a(this) { // from class: com.kwad.sdk.contentalliance.tube.detail.b.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f35694a;

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
                this.f35694a = this;
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) {
                    com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "tube/feed isLoadMore" + z + " code=" + i4 + " msg=" + str);
                    if (z) {
                        return;
                    }
                    this.f35694a.a(i4);
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, @NonNull AdResultData adResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, adResultData) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void b(boolean z) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeZ(1048579, this, z) == null) || z) {
                    return;
                }
                this.f35694a.e();
            }
        };
        this.k = new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.tube.detail.b.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f35695a;

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

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kwad.sdk.contentalliance.tube.b bVar;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this.f35695a).f35629a.f35636g) == null) {
                    return;
                }
                this.f35695a.f35693i = true;
                this.f35695a.f();
                bVar.a(false, 0L);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
            g();
            if (this.f35693i && !com.ksad.download.d.b.a(o())) {
                p.a(o());
                this.f35693i = false;
            }
            c(i2);
        }
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2) == null) {
            this.f35687c.setVisibility(0);
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
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            f();
            this.f35686b.setVisibility(8);
            this.f35688d.setVisibility(8);
            this.f35687c.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f35688d.setVisibility(0);
            this.f35686b.setVisibility(0);
            if (!this.f35686b.c()) {
                this.f35686b.b();
            }
            this.f35687c.setVisibility(8);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f35688d.setVisibility(8);
            if (!this.f35686b.c()) {
                this.f35686b.d();
            }
            this.f35686b.setVisibility(8);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f35690f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_content_network_error));
            this.f35689e.setText(q.d(o()));
            this.f35691g.setText(q.e(o()));
            this.f35692h.setText(q.i(o()));
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f35690f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_data_img));
            this.f35689e.setText(q.g(o()));
            this.f35691g.setText(q.h(o()));
            this.f35692h.setText(q.i(o()));
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.f35690f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_video_img));
            this.f35689e.setText(o().getString(R.string.ksad_video_no_found));
            this.f35691g.setText(o().getString(R.string.ksad_click_to_next_video));
            this.f35692h.setText(o().getString(R.string.ksad_watch_next_video));
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35633d.add(this.j);
            this.f35692h.setOnClickListener(this.k);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35633d.remove(this.j);
            this.f35692h.setOnClickListener(null);
            g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35686b = (LottieAnimationView) b(R.id.ksad_center_loading_animation_view);
            this.f35687c = (ViewGroup) b(R.id.ksad_error_container);
            this.f35688d = (ImageView) b(R.id.ksad_tube_loading_mask_view);
            this.f35689e = (TextView) b(R.id.ksad_load_error_title);
            this.f35690f = (ImageView) b(R.id.ksad_load_error_img);
            this.f35691g = (TextView) b(R.id.ksad_load_error_tip);
            this.f35692h = (TextView) b(R.id.ksad_retry_btn);
            int i2 = R.raw.ksad_detail_loading_amin_new;
            this.f35688d.setVisibility(4);
            this.f35686b.setVisibility(0);
            this.f35686b.setRepeatMode(1);
            this.f35686b.setRepeatCount(-1);
            this.f35686b.setAnimation(i2);
        }
    }
}
