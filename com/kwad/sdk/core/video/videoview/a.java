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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.z;
import com.kwad.sdk.widget.KSRelativeLayout;
@SuppressLint({"ViewConstructor"})
@Deprecated
/* loaded from: classes2.dex */
public class a extends c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC2027a A;
    public final com.kwad.sdk.core.download.a.c B;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f57866b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57867c;

    /* renamed from: e  reason: collision with root package name */
    public Context f57868e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f57869f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f57870g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57871h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57872i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57873j;

    /* renamed from: k  reason: collision with root package name */
    public int f57874k;
    public int l;
    public KSRelativeLayout m;
    public RelativeLayout n;
    public boolean o;
    public boolean p;
    public LinearLayout q;
    public LinearLayout r;
    public ProgressBar s;
    public ImageView t;
    public ViewGroup u;
    public ImageView v;
    public TextView w;
    public TextView x;
    public com.kwad.sdk.core.download.a.b y;
    public b z;

    /* renamed from: com.kwad.sdk.core.video.videoview.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC2027a {
        void a(int i2, z.a aVar);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(long j2);

        void b_();

        void e();

        void f();
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
        this.f57873j = true;
        this.a = false;
        this.p = false;
        this.B = new com.kwad.sdk.core.download.a.c(this) { // from class: com.kwad.sdk.core.video.videoview.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f57875b;

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
                this.f57875b = this;
            }

            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f57875b.x.setText(com.kwad.sdk.core.response.a.a.a());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f57875b.x.setText(com.kwad.sdk.core.response.a.a.A(this.f57875b.f57870g));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f57875b.x.setText(com.kwad.sdk.core.response.a.a.a(this.f57875b.f57869f));
                }
            }

            @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadStarted() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f57875b.x.setText(com.kwad.sdk.core.response.a.a.a(0));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    a aVar = this.f57875b;
                    aVar.a(com.kwad.sdk.core.response.a.a.A(aVar.f57870g));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    this.f57875b.x.setText(com.kwad.sdk.core.response.a.a.m(this.f57875b.f57870g));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048582, this, i4) == null) {
                    this.f57875b.x.setText(com.kwad.sdk.core.response.a.a.a(i4));
                }
            }
        };
        this.f57868e = context;
        this.f57869f = adTemplate;
        this.f57870g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        m();
    }

    private void b(int i2) {
        InterfaceC2027a interfaceC2027a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65539, this, i2) == null) || (interfaceC2027a = this.A) == null) {
            return;
        }
        interfaceC2027a.a(i2, this.m.getTouchCoords());
    }

    private void m() {
        ImageView imageView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            LayoutInflater.from(this.f57868e).inflate(R.layout.ksad_feed_video_palyer_controller, (ViewGroup) this, true);
            this.m = (KSRelativeLayout) findViewById(R.id.ksad_video_root_container);
            this.n = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
            this.f57867c = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
            ImageView imageView2 = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
            this.f57866b = imageView2;
            imageView2.setOnClickListener(this);
            this.q = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
            this.r = (LinearLayout) findViewById(R.id.ksad_video_error_container);
            this.s = (ProgressBar) findViewById(R.id.ksad_video_progress);
            this.t = (ImageView) findViewById(R.id.ksad_video_thumb_image);
            String a = com.kwad.sdk.core.response.a.a.aa(this.f57870g).a();
            if (TextUtils.isEmpty(a)) {
                imageView = this.t;
                i2 = 8;
            } else {
                this.t.setImageDrawable(null);
                KSImageLoader.loadImage(this.t, a, this.f57869f);
                imageView = this.t;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            this.f57867c.setText(aw.a(com.kwad.sdk.core.response.a.a.b(this.f57870g) * 1000));
            a();
        }
    }

    private void n() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (viewGroup = this.u) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.n.setVisibility(0);
            this.t.setVisibility(0);
            this.f57869f.mVideoPlayerStatus.setVideoPlayerBehavior(2);
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.n.setVisibility(8);
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f57888d.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(this.f57869f));
        }
    }

    private void setTopBottomVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65546, this, z) == null) || this.p) {
            return;
        }
        this.s.setVisibility(z ? 0 : 8);
        this.o = z;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            com.kwad.sdk.core.d.a.a("AdVideoPlayerController", "onPlayStateChanged playState=" + i2);
            if (i2 == -1) {
                l();
                setTopBottomVisible(false);
                this.q.setVisibility(8);
                this.r.setVisibility(0);
                com.kwad.sdk.core.report.d.b(this.f57869f, this.f57874k, this.l);
            } else if (i2 == 4) {
                b bVar = this.z;
                if (bVar != null) {
                    bVar.e();
                }
                this.t.setVisibility(8);
            } else if (i2 == 9) {
                b bVar2 = this.z;
                if (bVar2 != null) {
                    bVar2.f();
                }
                l();
                setTopBottomVisible(false);
                KSImageLoader.loadImage(this.t, com.kwad.sdk.core.response.a.a.h(this.f57870g), this.f57869f);
                this.t.setVisibility(0);
                b();
            } else if (i2 == 1) {
                p();
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                this.s.setVisibility(8);
                n();
            } else if (i2 != 2) {
            } else {
                b bVar3 = this.z;
                if (bVar3 != null) {
                    bVar3.b_();
                }
                setTopBottomVisible(true);
                k();
            }
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.l = i3;
            this.f57874k = i2;
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
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || this.p) {
            return;
        }
        if (!z) {
            progressBar = this.s;
            i2 = 8;
        } else if (!this.o) {
            return;
        } else {
            progressBar = this.s;
            i2 = 0;
        }
        progressBar.setVisibility(i2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (com.kwad.sdk.core.response.a.a.B(this.f57870g)) {
                this.v = (ImageView) findViewById(R.id.ksad_video_complete_app_icon);
                this.w = (TextView) findViewById(R.id.ksad_app_name);
                this.x = (TextView) findViewById(R.id.ksad_app_download);
                KSImageLoader.loadAppIcon(this.v, com.kwad.sdk.core.response.a.d.o(this.f57869f), this.f57869f, 12);
                this.w.setText(com.kwad.sdk.core.response.a.a.at(this.f57870g));
                this.x.setText(com.kwad.sdk.core.response.a.a.A(this.f57870g));
                this.u = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
                this.v.setOnClickListener(this);
                this.w.setOnClickListener(this);
                this.x.setOnClickListener(this);
                com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.f57869f);
                this.y = bVar;
                bVar.a(this.B);
            } else {
                TextView textView = (TextView) findViewById(R.id.ksad_h5_open);
                this.x = textView;
                textView.setText(com.kwad.sdk.core.response.a.a.A(this.f57870g));
                this.x.setOnClickListener(this);
                this.u = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
            }
            this.u.setOnClickListener(this);
            this.u.setVisibility(0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.q.setVisibility(0);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.q.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            l();
            this.s.setProgress(0);
            this.s.setSecondaryProgress(0);
            p();
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            this.n.setVisibility(8);
            this.f57869f.mVideoPlayerStatus.setVideoPlayerBehavior(1);
            n();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!this.f57888d.d()) {
                if (this.f57888d.h() || this.f57888d.f()) {
                    q();
                    this.f57888d.b();
                }
            } else if (!com.ksad.download.c.b.a(this.f57868e)) {
                c();
            } else {
                d();
                if (!this.a && ((!this.f57873j || !com.ksad.download.c.b.b(this.f57868e)) && (!this.f57873j || (!this.f57872i && !this.f57871h)))) {
                    o();
                    return;
                }
                q();
                this.f57888d.a();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f57888d.c();
        }
    }

    public AdTemplate getAdTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f57869f : (AdTemplate) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f57888d.k();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            long currentPosition = this.f57888d.getCurrentPosition();
            long duration = this.f57888d.getDuration();
            this.s.setSecondaryProgress(this.f57888d.getBufferPercentage());
            this.s.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
            b bVar = this.z;
            if (bVar != null) {
                bVar.a(currentPosition);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.p = true;
            this.s.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            if (view == this.f57866b) {
                this.f57871h = true;
                this.f57873j = true;
                f();
            } else if (view == this.v) {
                b(1);
            } else {
                b(view == this.w ? 2 : view == this.x ? 3 : 4);
            }
        }
    }

    public void setAdClickListener(InterfaceC2027a interfaceC2027a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, interfaceC2027a) == null) {
            this.A = interfaceC2027a;
        }
    }

    public void setCanControlPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.a = z;
        }
    }

    public void setDataAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f57873j = z;
        }
    }

    public void setDataFlowAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f57872i = z;
        }
    }

    public void setVideoPlayCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            this.z = bVar;
        }
    }
}
