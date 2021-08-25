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
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.KSRelativeLayout;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public class a extends c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f72113b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f72114c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f72115d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f72116e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f72117f;

    /* renamed from: g  reason: collision with root package name */
    public int f72118g;

    /* renamed from: h  reason: collision with root package name */
    public int f72119h;

    /* renamed from: i  reason: collision with root package name */
    public KSRelativeLayout f72120i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f72121j;
    public ImageView k;
    public TextView l;
    public boolean m;
    public boolean n;
    public LinearLayout o;
    public LinearLayout p;
    public ProgressBar q;
    public ImageView r;
    public ViewGroup s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public com.kwad.sdk.core.download.b.b w;
    public b x;
    public InterfaceC1996a y;
    public final com.kwad.sdk.core.download.b.c z;

    /* renamed from: com.kwad.sdk.core.video.videoview.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC1996a {
        void a();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a();

        void a(long j2);

        void b();

        void c();
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
        this.n = false;
        this.z = new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.core.video.videoview.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f72122b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f72122b = this;
            }

            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f72122b.v.setText(com.kwad.sdk.core.response.b.a.b(i4));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f72122b.v.setText(com.kwad.sdk.core.response.b.a.u(this.f72122b.f72115d));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f72122b.v.setText(com.kwad.sdk.core.response.b.a.a(this.f72122b.f72114c));
                }
            }

            @Override // com.kwad.sdk.core.download.b.c, com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadStarted() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f72122b.v.setText(com.kwad.sdk.core.response.b.a.a(0));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    a aVar = this.f72122b;
                    aVar.a(com.kwad.sdk.core.response.b.a.u(aVar.f72115d));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    this.f72122b.v.setText(com.kwad.sdk.core.response.b.a.j(this.f72122b.f72115d));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048582, this, i4) == null) {
                    this.f72122b.v.setText(com.kwad.sdk.core.response.b.a.a(i4));
                }
            }
        };
        this.f72113b = context;
        this.f72114c = adTemplate;
        this.f72115d = com.kwad.sdk.core.response.b.c.i(adTemplate);
        l();
    }

    private void a(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            com.kwad.sdk.core.download.b.a.b(av.a(this), this.f72114c, new a.InterfaceC1986a(this, i2) { // from class: com.kwad.sdk.core.video.videoview.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f72123a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f72124b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f72124b = this;
                    this.f72123a = i2;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f72124b.b(this.f72123a);
                    }
                }
            }, this.w, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) == null) {
            com.kwad.sdk.core.report.a.a(this.f72114c, i2, this.f72120i.getTouchCoords());
            InterfaceC1996a interfaceC1996a = this.y;
            if (interfaceC1996a != null) {
                interfaceC1996a.a();
            }
        }
    }

    private void l() {
        ImageView imageView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            LayoutInflater.from(this.f72113b).inflate(R.layout.ksad_feed_video_palyer_controller, (ViewGroup) this, true);
            this.f72120i = (KSRelativeLayout) findViewById(R.id.ksad_video_root_container);
            this.f72121j = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
            this.l = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
            ImageView imageView2 = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
            this.k = imageView2;
            imageView2.setOnClickListener(this);
            this.o = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
            this.p = (LinearLayout) findViewById(R.id.ksad_video_error_container);
            this.q = (ProgressBar) findViewById(R.id.ksad_video_progress);
            this.r = (ImageView) findViewById(R.id.ksad_video_thumb_image);
            String a2 = com.kwad.sdk.core.response.b.a.T(this.f72115d).a();
            if (TextUtils.isEmpty(a2)) {
                imageView = this.r;
                i2 = 8;
            } else {
                this.r.setImageDrawable(null);
                KSImageLoader.loadImage(this.r, a2, this.f72114c);
                imageView = this.r;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            this.l.setText(aq.a(com.kwad.sdk.core.response.b.a.b(this.f72115d) * 1000));
        }
    }

    private void m() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (viewGroup = this.s) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f72121j.setVisibility(0);
            this.r.setVisibility(0);
            this.f72114c.mVideoPlayerStatus.setVideoPlayerBehavior(2);
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f72121j.setVisibility(8);
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f72143a.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(this.f72114c));
        }
    }

    private void setTopBottomVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65548, this, z) == null) || this.n) {
            return;
        }
        this.q.setVisibility(z ? 0 : 8);
        this.m = z;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (com.kwad.sdk.core.response.b.a.v(this.f72115d)) {
                this.t = (ImageView) findViewById(R.id.ksad_video_complete_app_icon);
                this.u = (TextView) findViewById(R.id.ksad_app_name);
                this.v = (TextView) findViewById(R.id.ksad_app_download);
                KSImageLoader.loadAppIcon(this.t, com.kwad.sdk.core.response.b.c.m(this.f72114c), this.f72114c, 12);
                this.u.setText(com.kwad.sdk.core.response.b.a.ag(this.f72115d));
                this.v.setText(com.kwad.sdk.core.response.b.a.u(this.f72115d));
                this.s = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
                this.t.setOnClickListener(this);
                this.u.setOnClickListener(this);
                this.v.setOnClickListener(this);
                com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.f72114c);
                this.w = bVar;
                bVar.a(this.z);
            } else {
                TextView textView = (TextView) findViewById(R.id.ksad_h5_open);
                this.v = textView;
                textView.setText(com.kwad.sdk.core.response.b.a.u(this.f72115d));
                this.v.setOnClickListener(this);
                this.s = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
            }
            this.s.setOnClickListener(this);
            this.s.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            com.kwad.sdk.core.d.a.a("AdVideoPlayerController", "onPlayStateChanged playState=" + i2);
            if (i2 == -1) {
                k();
                setTopBottomVisible(false);
                this.o.setVisibility(8);
                this.p.setVisibility(0);
                com.kwad.sdk.core.report.d.b(this.f72114c, this.f72118g, this.f72119h);
            } else if (i2 == 4) {
                b bVar = this.x;
                if (bVar != null) {
                    bVar.b();
                }
                this.r.setVisibility(8);
            } else if (i2 == 9) {
                b bVar2 = this.x;
                if (bVar2 != null) {
                    bVar2.c();
                }
                k();
                setTopBottomVisible(false);
                KSImageLoader.loadImage(this.r, com.kwad.sdk.core.response.b.a.f(this.f72115d), this.f72114c);
                this.r.setVisibility(0);
                a();
            } else if (i2 == 1) {
                o();
                this.o.setVisibility(8);
                this.p.setVisibility(8);
                this.q.setVisibility(8);
                m();
            } else if (i2 != 2) {
            } else {
                b bVar3 = this.x;
                if (bVar3 != null) {
                    bVar3.a();
                }
                setTopBottomVisible(true);
                j();
            }
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.f72119h = i3;
            this.f72118g = i2;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            ((TextView) findViewById(R.id.ksad_app_download)).setText(str);
        }
    }

    public void a(boolean z) {
        ProgressBar progressBar;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || this.n) {
            return;
        }
        if (!z) {
            progressBar = this.q;
            i2 = 8;
        } else if (!this.m) {
            return;
        } else {
            progressBar = this.q;
            i2 = 0;
        }
        progressBar.setVisibility(i2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.o.setVisibility(0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.o.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            k();
            this.q.setProgress(0);
            this.q.setSecondaryProgress(0);
            o();
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.f72121j.setVisibility(8);
            this.f72114c.mVideoPlayerStatus.setVideoPlayerBehavior(1);
            m();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!this.f72143a.d()) {
                if (this.f72143a.h() || this.f72143a.f()) {
                    p();
                    this.f72143a.b();
                }
            } else if (!com.ksad.download.d.b.a(this.f72113b)) {
                b();
            } else {
                c();
                if (!com.ksad.download.d.b.b(this.f72113b) && !this.f72117f && !this.f72116e) {
                    n();
                    return;
                }
                p();
                this.f72143a.a();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f72143a.c();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f72143a.l();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            long currentPosition = this.f72143a.getCurrentPosition();
            long duration = this.f72143a.getDuration();
            this.q.setSecondaryProgress(this.f72143a.getBufferPercentage());
            this.q.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
            b bVar = this.x;
            if (bVar != null) {
                bVar.a(currentPosition);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.n = true;
            this.q.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (view == this.k) {
                this.f72116e = true;
                e();
                return;
            }
            if (view == this.t) {
                i2 = 13;
            } else if (view == this.u) {
                i2 = 82;
            } else if (view == this.v) {
                a(true, 83);
                return;
            } else {
                i2 = 108;
            }
            a(false, i2);
        }
    }

    public void setDataFlowAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f72117f = z;
        }
    }

    public void setVideoClickListener(InterfaceC1996a interfaceC1996a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, interfaceC1996a) == null) {
            this.y = interfaceC1996a;
        }
    }

    public void setVideoPlayCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            this.x = bVar;
        }
    }
}
