package com.kwad.sdk.core.video.videoview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class a extends c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f36628b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f36629c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f36630d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36631e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36632f;

    /* renamed from: g  reason: collision with root package name */
    public int f36633g;

    /* renamed from: h  reason: collision with root package name */
    public int f36634h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f36635i;
    public ImageView j;
    public TextView k;
    public boolean l;
    public LinearLayout m;
    public LinearLayout n;
    public ProgressBar o;
    public ImageView p;
    public ViewGroup q;
    public InterfaceC0439a r;

    /* renamed from: com.kwad.sdk.core.video.videoview.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0439a {
        void a();

        void a(long j);

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull d dVar) {
        super(context, dVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (d) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36628b = context;
        this.f36629c = adTemplate;
        this.f36630d = com.kwad.sdk.core.response.b.c.j(adTemplate);
        j();
    }

    private void j() {
        ImageView imageView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            LayoutInflater.from(this.f36628b).inflate(R.layout.ksad_feed_video_palyer_controller, (ViewGroup) this, true);
            this.f36635i = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
            this.k = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
            ImageView imageView2 = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
            this.j = imageView2;
            imageView2.setOnClickListener(this);
            this.m = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
            this.n = (LinearLayout) findViewById(R.id.ksad_video_error_container);
            this.o = (ProgressBar) findViewById(R.id.ksad_video_progress);
            this.p = (ImageView) findViewById(R.id.ksad_video_thumb_image);
            String a2 = com.kwad.sdk.core.response.b.a.U(this.f36630d).a();
            if (TextUtils.isEmpty(a2)) {
                imageView = this.p;
                i2 = 8;
            } else {
                this.p.setImageDrawable(null);
                KSImageLoader.loadImage(this.p, a2, this.f36629c);
                imageView = this.p;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            this.k.setText(ai.a(com.kwad.sdk.core.response.b.a.b(this.f36630d) * 1000));
        }
    }

    private void k() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (viewGroup = this.q) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void l() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (com.kwad.sdk.core.response.b.a.y(this.f36630d)) {
                linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
                KSImageLoader.loadAppIcon((ImageView) findViewById(R.id.ksad_app_icon), com.kwad.sdk.core.response.b.a.o(this.f36630d), this.f36629c, 12);
                ((TextView) findViewById(R.id.ksad_app_name)).setText(com.kwad.sdk.core.response.b.a.q(this.f36630d));
                ((TextView) findViewById(R.id.ksad_app_download)).setText(com.kwad.sdk.core.response.b.a.w(this.f36630d));
            } else {
                linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
                ((TextView) findViewById(R.id.ksad_h5_open)).setText(com.kwad.sdk.core.response.b.a.w(this.f36630d));
            }
            this.q = linearLayout;
            this.q.setVisibility(0);
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.f36635i.setVisibility(0);
            this.p.setVisibility(0);
            this.f36629c.mVideoPlayerStatus.setVideoPlayerBehavior(2);
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f36635i.setVisibility(8);
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f36652a.setKsPlayLogParam(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.f36630d), System.currentTimeMillis()));
        }
    }

    private void setTopBottomVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, this, z) == null) {
            this.o.setVisibility(z ? 0 : 8);
            this.l = z;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.m.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            com.kwad.sdk.core.d.a.a("AdVideoPlayerController", "onPlayStateChanged playState=" + i2);
            if (i2 == -1) {
                i();
                setTopBottomVisible(false);
                this.m.setVisibility(8);
                this.n.setVisibility(0);
                AdTemplate adTemplate = this.f36629c;
                int i3 = this.f36633g;
                e.b(adTemplate, i3, i3);
            } else if (i2 == 4) {
                this.p.setVisibility(8);
            } else if (i2 == 9) {
                InterfaceC0439a interfaceC0439a = this.r;
                if (interfaceC0439a != null) {
                    interfaceC0439a.b();
                }
                i();
                setTopBottomVisible(false);
                KSImageLoader.loadImage(this.p, com.kwad.sdk.core.response.b.a.f(this.f36630d), this.f36629c);
                this.p.setVisibility(0);
                l();
            } else if (i2 == 1) {
                n();
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                k();
            } else if (i2 != 2) {
            } else {
                InterfaceC0439a interfaceC0439a2 = this.r;
                if (interfaceC0439a2 != null) {
                    interfaceC0439a2.a();
                }
                setTopBottomVisible(true);
                h();
            }
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.f36634h = i3;
            this.f36633g = i2;
        }
    }

    public void a(boolean z) {
        ProgressBar progressBar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (!z) {
                progressBar = this.o;
                i2 = 8;
            } else if (!this.l) {
                return;
            } else {
                progressBar = this.o;
                i2 = 0;
            }
            progressBar.setVisibility(i2);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            i();
            this.o.setProgress(0);
            this.o.setSecondaryProgress(0);
            n();
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.f36635i.setVisibility(8);
            this.f36629c.mVideoPlayerStatus.setVideoPlayerBehavior(1);
            k();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!this.f36652a.d()) {
                if (this.f36652a.h() || this.f36652a.f()) {
                    o();
                    this.f36652a.b();
                }
            } else if (!com.ksad.download.d.b.a(this.f36628b)) {
                a();
            } else {
                b();
                if (!com.ksad.download.d.b.b(this.f36628b) && !this.f36632f && !this.f36631e) {
                    m();
                    return;
                }
                o();
                this.f36652a.a();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f36652a.c();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f36652a.k();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            long currentPosition = this.f36652a.getCurrentPosition();
            long duration = this.f36652a.getDuration();
            this.o.setSecondaryProgress(this.f36652a.getBufferPercentage());
            this.o.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
            InterfaceC0439a interfaceC0439a = this.r;
            if (interfaceC0439a != null) {
                interfaceC0439a.a(currentPosition);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view) == null) && view == this.j) {
            this.f36631e = true;
            d();
        }
    }

    public void setDataFlowAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f36632f = z;
        }
    }

    public void setVideoPlayCallback(InterfaceC0439a interfaceC0439a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC0439a) == null) {
            this.r = interfaceC0439a;
        }
    }
}
