package com.kwad.sdk.contentalliance.detail.photo.e;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.aq;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34751b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f34752c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f34753d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34754e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34755f;

    /* renamed from: g  reason: collision with root package name */
    public ScaleAnimSeekBar f34756g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f34757h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34758i;
    public long j;
    public boolean k;
    public Runnable l;
    public Runnable m;
    public com.kwad.sdk.contentalliance.a.a n;
    public com.kwad.sdk.contentalliance.home.swipe.a o;
    public com.kwad.sdk.contentalliance.detail.video.e p;
    public ScaleAnimSeekBar.a q;

    public c() {
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
        this.k = false;
        Runnable runnable = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f34759a;

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
                this.f34759a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f34759a.k) {
                    return;
                }
                this.f34759a.q();
            }
        };
        this.l = runnable;
        this.m = new aq(runnable);
        this.n = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f34760a;

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
                this.f34760a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.k();
                    this.f34760a.f();
                    this.f34760a.g();
                }
            }
        };
        this.o = new com.kwad.sdk.contentalliance.home.swipe.b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f34761a;

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
                this.f34761a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.swipe.b, com.kwad.sdk.contentalliance.home.swipe.a
            public void a(float f2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeF(1048576, this, f2) == null) {
                    this.f34761a.a(f2);
                }
            }
        };
        this.p = new f(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f34762a;

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
                this.f34762a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j == 0) {
                    return;
                }
                this.f34762a.j = j;
                int i4 = (int) (((((float) j2) * 1.0f) * 10000.0f) / ((float) j));
                if (this.f34762a.k || !this.f34762a.f34756g.a()) {
                    return;
                }
                this.f34762a.f34756g.setProgress(i4);
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34762a.k = false;
                    this.f34762a.h();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.c();
                    this.f34762a.k = true;
                    if (this.f34762a.f34751b.getVisibility() == 0) {
                        this.f34762a.r();
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f34762a.k = false;
                    this.f34762a.h();
                    this.f34762a.s();
                }
            }
        };
        this.q = new ScaleAnimSeekBar.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.c.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f34763a;

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
                this.f34763a = this;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, scaleAnimSeekBar) == null) {
                    this.f34763a.f34752c.setVisibility(8);
                    this.f34763a.e();
                    this.f34763a.r();
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void a(ScaleAnimSeekBar scaleAnimSeekBar, int i4, boolean z) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{scaleAnimSeekBar, Integer.valueOf(i4), Boolean.valueOf(z)}) == null) && z) {
                    this.f34763a.e();
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void b(ScaleAnimSeekBar scaleAnimSeekBar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, scaleAnimSeekBar) == null) {
                    this.f34763a.f34752c.setVisibility(0);
                    this.f34763a.f();
                    this.f34763a.p();
                    this.f34763a.s();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65538, this, f2) == null) {
            this.f34756g.setAlpha(f2);
            this.f34756g.setThumbEnable(f2 == 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f34754e.setText(ai.a((this.j * this.f34756g.getProgress()) / 10000));
            if (this.f34753d.getVisibility() == 0) {
                return;
            }
            this.f34755f.setText(ai.a(this.j));
            this.f34753d.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f34753d.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f34756g.setProgress(0);
            this.f34756g.setVisibility(8);
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || this.f34756g.getVisibility() == 0) {
            return;
        }
        this.f34756g.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            this.f34757h.a((this.j * this.f34756g.getProgress()) / 10000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            t();
            this.f34756g.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            t();
            this.f34756g.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            t();
            this.f34756g.postDelayed(this.m, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        }
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.f34756g.removeCallbacks(this.m);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
            long longValue = com.kwad.sdk.core.response.b.d.c(com.kwad.sdk.core.response.b.c.k(adTemplate)).longValue();
            this.j = longValue;
            if (longValue < 30000 || com.kwad.sdk.core.response.b.d.F(adTemplate.photoInfo)) {
                return;
            }
            this.f34758i = true;
            this.f34757h = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            f();
            g();
            a(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.l.getSourceType() == 0 ? 1.0f : 0.0f);
            this.f34756g.setOnSeekBarChangeListener(this.q);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.n);
            this.f34757h.a(this.p);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34578e.add(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f34756g.removeCallbacks(this.m);
            if (this.f34758i) {
                this.f34756g.setOnSeekBarChangeListener(null);
                this.f34756g.setVisibility(8);
                ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.n);
                this.f34757h.b(this.p);
                ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34578e.remove(this.o);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34751b = (ImageView) b(R.id.ksad_video_control_button);
            this.f34752c = (ViewGroup) b(R.id.ksad_video_bottom_container);
            this.f34753d = (ViewGroup) b(R.id.ksad_video_seek_tip_layout);
            this.f34754e = (TextView) b(R.id.ksad_video_seek_progress);
            this.f34755f = (TextView) b(R.id.ksad_video_seek_duration);
            ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) b(R.id.ksad_video_seek_bar);
            this.f34756g = scaleAnimSeekBar;
            scaleAnimSeekBar.setMaxProgress(10000);
        }
    }
}
