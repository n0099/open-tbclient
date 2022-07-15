package com.kwad.components.core.video;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.y;
import com.kwad.sdk.widget.KSRelativeLayout;
@SuppressLint({"ViewConstructor"})
@Deprecated
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.core.video.videoview.b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC0518a A;
    public final com.kwad.sdk.core.download.kwai.a B;
    public Context a;
    @NonNull
    public AdTemplate b;
    public AdInfo c;
    public boolean d;
    public boolean e;
    public ImageView f;
    public TextView g;
    public boolean i;
    public boolean j;
    public int k;
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
    public com.kwad.components.core.c.a.b y;
    public b z;

    /* renamed from: com.kwad.components.core.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0518a {
        void a(int i, y.a aVar);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(long j);

        void f_();

        void g_();

        void h_();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.kwad.sdk.core.video.videoview.c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = true;
        this.e = false;
        this.p = false;
        this.B = new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.core.video.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void a(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    this.a.x.setText(com.kwad.sdk.core.response.a.a.a());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.x.setText(com.kwad.sdk.core.response.a.a.H(this.a.c));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.x.setText(com.kwad.sdk.core.response.a.a.a(this.a.b));
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.a.x.setText(com.kwad.sdk.core.response.a.a.a(0));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    a aVar = this.a;
                    aVar.a(com.kwad.sdk.core.response.a.a.H(aVar.c));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    this.a.x.setText(com.kwad.sdk.core.response.a.a.n(this.a.c));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048582, this, i3) == null) {
                    this.a.x.setText(com.kwad.sdk.core.response.a.a.a(i3));
                }
            }
        };
        this.a = context;
        this.b = adTemplate;
        this.c = com.kwad.sdk.core.response.a.d.i(adTemplate);
        m();
    }

    private void b(int i) {
        InterfaceC0518a interfaceC0518a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, this, i) == null) || (interfaceC0518a = this.A) == null) {
            return;
        }
        interfaceC0518a.a(i, this.m.getTouchCoords());
    }

    private void m() {
        ImageView imageView;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0423, (ViewGroup) this, true);
            this.m = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f0911dc);
            this.n = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091023);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091025);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091024);
            this.f = imageView2;
            imageView2.setOnClickListener(this);
            this.q = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911d5);
            this.r = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911d0);
            this.s = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f0911db);
            this.t = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911e3);
            String a = com.kwad.sdk.core.response.a.a.ae(this.c).a();
            if (TextUtils.isEmpty(a)) {
                imageView = this.t;
                i = 8;
            } else {
                this.t.setImageDrawable(null);
                KSImageLoader.loadImage(this.t, a, this.b);
                imageView = this.t;
                i = 0;
            }
            imageView.setVisibility(i);
            this.g.setText(ay.a(com.kwad.sdk.core.response.a.a.c(this.c) * 1000));
            a();
        }
    }

    private void n() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (viewGroup = this.u) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.n.setVisibility(8);
        }
    }

    private void setTopBottomVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65542, this, z) == null) || this.p) {
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

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            com.kwad.sdk.core.d.b.a("AdVideoPlayerController", "onPlayStateChanged playState=" + i);
            if (i == -1) {
                q();
                setTopBottomVisible(false);
                this.q.setVisibility(8);
                this.r.setVisibility(0);
                com.kwad.components.core.i.a.a().b(this.b, this.k, this.l);
            } else if (i == 4) {
                b bVar = this.z;
                if (bVar != null) {
                    bVar.g_();
                }
                this.t.setVisibility(8);
            } else if (i == 9) {
                b bVar2 = this.z;
                if (bVar2 != null) {
                    bVar2.h_();
                }
                q();
                setTopBottomVisible(false);
                KSImageLoader.loadImage(this.t, com.kwad.sdk.core.response.a.a.k(this.c), this.b);
                this.t.setVisibility(0);
                b();
            } else if (i == 1) {
                o();
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                this.s.setVisibility(8);
                n();
            } else if (i != 2) {
            } else {
                b bVar3 = this.z;
                if (bVar3 != null) {
                    bVar3.f_();
                }
                setTopBottomVisible(true);
                p();
            }
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.l = i2;
            this.k = i;
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            ((TextView) findViewById(R.id.obfuscated_res_0x7f090ff2)).setText(str);
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || this.p) {
            return;
        }
        if (!z) {
            this.s.setVisibility(8);
        } else if (this.o) {
            this.s.setVisibility(0);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (com.kwad.sdk.core.response.a.a.I(this.c)) {
                this.v = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911c1);
                this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff7);
                this.x = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff2);
                KSImageLoader.loadAppIcon(this.v, com.kwad.sdk.core.response.a.d.m(this.b), this.b, 12);
                this.w.setText(com.kwad.sdk.core.response.a.a.aC(this.c));
                this.x.setText(com.kwad.sdk.core.response.a.a.H(this.c));
                this.u = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911c0);
                this.v.setOnClickListener(this);
                this.w.setOnClickListener(this);
                this.x.setOnClickListener(this);
                com.kwad.components.core.c.a.b bVar = new com.kwad.components.core.c.a.b(this.b);
                this.y = bVar;
                bVar.a(this.B);
            } else {
                TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09104d);
                this.x = textView;
                textView.setText(com.kwad.sdk.core.response.a.a.H(this.c));
                this.x.setOnClickListener(this);
                this.u = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911c2);
            }
            this.u.setOnClickListener(this);
            this.u.setVisibility(0);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.q.setVisibility(0);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.q.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            q();
            this.s.setProgress(0);
            this.s.setSecondaryProgress(0);
            o();
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            this.n.setVisibility(8);
            this.b.mVideoPlayerStatus.setVideoPlayerBehavior(1);
            n();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.setVisibility(0);
            this.t.setVisibility(0);
            this.b.mVideoPlayerStatus.setVideoPlayerBehavior(2);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!this.h.d()) {
                if (this.h.g() || this.h.e()) {
                    h();
                    this.h.b();
                }
            } else if (!ac.b(this.a)) {
                c();
            } else {
                d();
                if (!this.e && ((!this.j || !ac.c(this.a)) && (!this.j || (!this.i && !this.d)))) {
                    f();
                    return;
                }
                h();
                this.h.a();
            }
        }
    }

    public AdTemplate getAdTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b : (AdTemplate) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.h.setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a.a(this.b));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.h.c();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.h.i();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            long currentPosition = this.h.getCurrentPosition();
            long duration = this.h.getDuration();
            this.s.setSecondaryProgress(this.h.getBufferPercentage());
            this.s.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
            b bVar = this.z;
            if (bVar != null) {
                bVar.a(currentPosition);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.p = true;
            this.s.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            if (view2 == this.f) {
                this.d = true;
                this.j = true;
                g();
            } else if (view2 == this.v) {
                b(1);
            } else if (view2 == this.w) {
                b(2);
            } else if (view2 == this.x) {
                b(3);
            } else {
                b(4);
            }
        }
    }

    public void setAdClickListener(InterfaceC0518a interfaceC0518a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, interfaceC0518a) == null) {
            this.A = interfaceC0518a;
        }
    }

    public void setCanControlPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.e = z;
        }
    }

    public void setDataAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.j = z;
        }
    }

    public void setDataFlowAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.i = z;
        }
    }

    public void setVideoPlayCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            this.z = bVar;
        }
    }
}
