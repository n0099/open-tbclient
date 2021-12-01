package com.kwad.sdk.feed.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class k extends com.kwad.sdk.feed.widget.base.a implements NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public View.OnClickListener B;
    public KsAdVideoPlayConfig C;
    public a D;
    public View E;
    public com.kwad.sdk.core.download.a.b F;
    public Runnable G;
    public bd H;
    public RatioFrameLayout a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f58560f;

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f58561g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58562h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f58563i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f58564j;

    /* renamed from: k  reason: collision with root package name */
    public ScaleAnimSeekBar f58565k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public ViewGroup o;
    public com.kwad.sdk.core.video.videoview.b p;
    public ViewGroup q;
    public TextView r;
    public ViewGroup s;
    public ViewGroup t;
    public j u;
    public int v;
    public boolean w;
    public boolean x;
    public long y;
    public NestedScrollingChildHelper z;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = 100;
        Runnable runnable = new Runnable(this) { // from class: com.kwad.sdk.feed.widget.k.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.o.setVisibility(8);
                    this.a.n.setVisibility(8);
                    if (this.a.u != null) {
                        this.a.u.a(true);
                    }
                }
            }
        };
        this.G = runnable;
        this.H = new bd(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
            List<Integer> list = this.f58561g;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.f58561g.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(((com.kwad.sdk.feed.widget.base.a) this).f58528b, ceil, null);
                    it.remove();
                    return;
                }
            }
        }
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, com.kwad.sdk.core.video.videoview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, aVar, bVar) == null) {
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.k.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.a.o.getVisibility() != 8) {
                            if (this.a.getHandler() != null) {
                                this.a.getHandler().removeCallbacks(this.a.G);
                                if (this.a.A) {
                                    return;
                                }
                                this.a.getHandler().postDelayed(this.a.H, 1000L);
                                return;
                            }
                            return;
                        }
                        if (!this.a.p.i()) {
                            this.a.o.setVisibility(0);
                            this.a.n.setVisibility(0);
                            if (this.a.u != null) {
                                this.a.u.a(false);
                            }
                            if (this.a.getHandler() == null) {
                                return;
                            }
                        } else if (this.a.v != 101) {
                            if (this.a.B != null) {
                                this.a.B.onClick(view);
                                return;
                            }
                            return;
                        } else {
                            this.a.o.setVisibility(0);
                            this.a.n.setVisibility(8);
                            if (this.a.u != null) {
                                this.a.u.a(false);
                            }
                            if (this.a.getHandler() == null) {
                                return;
                            }
                        }
                        this.a.getHandler().removeCallbacks(this.a.G);
                        this.a.getHandler().postDelayed(this.a.H, 5000L);
                    }
                }
            });
            aVar.setVideoPlayCallback(new a.b(this, bVar) { // from class: com.kwad.sdk.feed.widget.k.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.b a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f58566b;

                /* renamed from: c  reason: collision with root package name */
                public boolean f58567c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58566b = this;
                    this.a = bVar;
                    this.f58567c = false;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j2) == null) {
                        this.f58566b.a(j2);
                        float duration = (((float) j2) * 100.0f) / ((float) this.a.getDuration());
                        if (!this.f58566b.A) {
                            this.f58566b.f58565k.setProgress((int) duration);
                            this.f58566b.f58563i.setText(aw.a(j2));
                        }
                        this.f58566b.f58562h.setText(aw.a(this.a.getDuration()));
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b_() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) this.f58566b).f58528b);
                        this.f58566b.f58562h.setText(aw.a(this.a.getDuration()));
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void e() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f58567c) {
                        return;
                    }
                    this.f58567c = true;
                    com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) this.f58566b).f58528b, System.currentTimeMillis(), 1);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void f() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) this.f58566b).f58528b);
                        this.f58566b.o.setVisibility(8);
                        this.f58566b.n.setVisibility(8);
                        this.f58566b.f58565k.setProgress((int) 100.0f);
                        this.f58566b.f58563i.setText(aw.a(this.a.getDuration()));
                    }
                }
            });
            this.u.setAdClickListener(new a.InterfaceC2027a(this) { // from class: com.kwad.sdk.feed.widget.k.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC2027a
                public void a(int i2, z.a aVar2) {
                    int i3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, aVar2) == null) {
                        int i4 = 2;
                        boolean z = false;
                        if (i2 == 1) {
                            i3 = 13;
                        } else if (i2 == 2) {
                            i3 = 82;
                        } else if (i2 != 3) {
                            i3 = 108;
                        } else {
                            i3 = 83;
                            i4 = 1;
                            z = true;
                        }
                        p.a aVar3 = new p.a();
                        aVar3.f57686g = aVar2;
                        aVar3.f57681b = i3;
                        com.kwad.sdk.core.download.a.a.a(new a.C2015a(bb.a(this.a.s)).a(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b).a(this.a.F).a(i4).a(z).c(true).a(aVar3).a(new a.b(this) { // from class: com.kwad.sdk.feed.widget.k.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass4 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i5 = newInitContext.flag;
                                    if ((i5 & 1) != 0) {
                                        int i6 = i5 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // com.kwad.sdk.core.download.a.a.b
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.a.a.l();
                                }
                            }
                        }));
                    }
                }
            });
            this.f58565k.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a(this, bVar) { // from class: com.kwad.sdk.feed.widget.k.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.b a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f58568b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58568b = this;
                    this.a = bVar;
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, scaleAnimSeekBar) == null) {
                        this.f58568b.f58565k.a(true);
                        this.f58568b.getHandler().removeCallbacks(this.f58568b.H);
                        this.f58568b.A = true;
                    }
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public void a(ScaleAnimSeekBar scaleAnimSeekBar, int i2, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{scaleAnimSeekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                        this.f58568b.f58565k.a(true);
                        this.f58568b.getHandler().removeCallbacks(this.f58568b.H);
                        this.f58568b.A = true;
                        this.f58568b.f58563i.setText(aw.a((int) ((this.a.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                    }
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public void b(ScaleAnimSeekBar scaleAnimSeekBar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, scaleAnimSeekBar) == null) {
                        this.f58568b.f58565k.a(false);
                        this.a.a((int) ((this.a.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                        if (this.f58568b.getHandler() != null) {
                            this.f58568b.getHandler().removeCallbacks(this.f58568b.H);
                            this.f58568b.getHandler().postDelayed(this.f58568b.H, 5000L);
                        }
                        this.f58568b.A = false;
                    }
                }
            });
            this.l.setOnClickListener(new View.OnClickListener(this, bVar) { // from class: com.kwad.sdk.feed.widget.k.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.b a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f58569b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58569b = this;
                    this.a = bVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:16:0x009f  */
                /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onClick(View view) {
                    ImageView imageView;
                    Resources resources;
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view) != null) {
                        return;
                    }
                    if (!this.a.h() && !this.a.d()) {
                        if (this.a.g()) {
                            this.f58569b.u.n();
                            this.f58569b.n.setVisibility(0);
                            this.f58569b.n.setImageDrawable(this.f58569b.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
                            imageView = this.f58569b.l;
                            resources = this.f58569b.getContext().getResources();
                            i2 = R.drawable.ksad_video_player_play_btn;
                        }
                        if (this.f58569b.getHandler() == null) {
                            this.f58569b.getHandler().removeCallbacks(this.f58569b.H);
                            this.f58569b.getHandler().postDelayed(this.f58569b.H, 5000L);
                            return;
                        }
                        return;
                    }
                    this.f58569b.u.o();
                    this.f58569b.l.setImageDrawable(this.f58569b.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    imageView = this.f58569b.n;
                    resources = this.f58569b.getContext().getResources();
                    i2 = R.drawable.ksad_video_player_pause_center;
                    imageView.setImageDrawable(resources.getDrawable(i2));
                    if (this.f58569b.getHandler() == null) {
                    }
                }
            });
            this.n.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.k.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.a.p.h() || this.a.p.d()) {
                            this.a.g();
                        } else if (this.a.p.g()) {
                            this.a.h();
                        }
                        if (this.a.getHandler() != null) {
                            this.a.getHandler().removeCallbacks(this.a.H);
                            this.a.getHandler().postDelayed(this.a.H, 5000L);
                        }
                    }
                }
            });
            this.q.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.k.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.p();
                    }
                }
            });
            this.m.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.k.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.a.v == 100) {
                            this.a.o();
                        } else if (this.a.v == 101) {
                            this.a.p();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.u.o();
            this.l.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
            this.n.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.u.n();
            this.n.setVisibility(0);
            this.n.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
            this.l.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
        }
    }

    private boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i2 = ((elapsedRealtime - this.y) > 888L ? 1 : ((elapsedRealtime - this.y) == 888L ? 0 : -1));
            if (i2 > 0) {
                this.y = elapsedRealtime;
            }
            return i2 > 0;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            a aVar = this.D;
            if (aVar != null) {
                aVar.a();
            }
            if ((this.v == 100) && i()) {
                this.q.setVisibility(0);
                this.r.setText(((com.kwad.sdk.feed.widget.base.a) this).f58529c.adBaseInfo.adDescription);
                boolean z = com.kwad.sdk.core.response.a.a.f(((com.kwad.sdk.feed.widget.base.a) this).f58529c) > com.kwad.sdk.core.response.a.a.e(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
                this.w = af.a(getContext());
                this.x = af.e(getContext());
                Context context = getContext();
                if (z) {
                    af.d(context);
                } else {
                    af.c(context);
                }
                ViewGroup viewGroup = (ViewGroup) this.s.getParent();
                this.t = viewGroup;
                if (viewGroup != null) {
                    viewGroup.removeView(this.s);
                    View view = new View(this.s.getContext());
                    this.E = view;
                    view.setLayoutParams(new ViewGroup.LayoutParams(this.s.getWidth(), this.s.getHeight()));
                    viewGroup.addView(this.E);
                }
                af.a(getContext(), false);
                Context a2 = bb.a(this);
                if (a2 instanceof Activity) {
                    ViewGroup viewGroup2 = (ViewGroup) ((Activity) a2).getWindow().getDecorView();
                    this.s.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                    if (z && viewGroup2.getWidth() != 0) {
                        this.a.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                    }
                    viewGroup2.addView(this.s, new FrameLayout.LayoutParams(-1, -1));
                    setUIWithStateAndMode(101);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            if ((this.v == 101) & i()) {
                this.q.setVisibility(8);
                if (this.w) {
                    af.a(getContext());
                } else {
                    af.b(getContext());
                }
                if (this.x) {
                    af.d(getContext());
                } else {
                    af.c(getContext());
                }
                af.a(getContext(), true);
                ViewGroup viewGroup = (ViewGroup) this.s.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.s);
                }
                this.s.setLayoutParams(new ViewGroup.LayoutParams(this.t.getWidth(), this.t.getHeight()));
                this.a.setRatio(0.56f);
                View view = this.E;
                if (view != null) {
                    this.t.removeView(view);
                    this.E = null;
                }
                this.t.addView(this.s, new FrameLayout.LayoutParams(-1, -2));
                this.s.requestLayout();
                setUIWithStateAndMode(100);
            }
            a aVar = this.D;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.j
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            super.a(view);
        }
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.sdk.core.download.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksAdVideoPlayConfig, bVar) == null) {
            this.F = bVar;
            com.kwad.sdk.core.response.model.c aa = com.kwad.sdk.core.response.a.a.aa(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
            this.C = ksAdVideoPlayConfig;
            String a2 = aa.a();
            if (TextUtils.isEmpty(a2)) {
                this.f58560f.setVisibility(8);
            } else {
                this.f58560f.setImageDrawable(null);
                KSImageLoader.loadImage(this.f58560f, a2, ((com.kwad.sdk.feed.widget.base.a) this).f58528b);
                this.f58560f.setVisibility(0);
            }
            this.f58561g = com.kwad.sdk.core.response.a.a.S(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
            String a3 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            com.kwad.sdk.core.video.videoview.b b2 = AdVideoPlayerViewCache.a().b(a3);
            this.p = b2;
            if (b2 == null) {
                this.p = new com.kwad.sdk.core.video.videoview.b(getContext());
                com.kwad.sdk.core.response.a.a.l(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
                this.p.a(new c.a(((com.kwad.sdk.feed.widget.base.a) this).f58528b).a(((com.kwad.sdk.feed.widget.base.a) this).f58528b.mVideoPlayerStatus).a(com.kwad.sdk.core.response.a.d.m(((com.kwad.sdk.feed.widget.base.a) this).f58528b)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(((com.kwad.sdk.feed.widget.base.a) this).f58528b))).a(new com.kwad.sdk.contentalliance.detail.video.b(((com.kwad.sdk.feed.widget.base.a) this).f58528b, System.currentTimeMillis())).a(), (Map<String, String>) null);
                this.p.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
                j jVar = new j(((com.kwad.sdk.feed.widget.base.a) this).f58531e, ((com.kwad.sdk.feed.widget.base.a) this).f58528b, this.p);
                this.u = jVar;
                jVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
                this.p.setController(this.u);
                this.u.setAutoRelease(false);
            } else {
                if (b2.getTag() != null) {
                    try {
                        this.f58561g = (List) this.p.getTag();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                j jVar2 = (j) this.p.getController();
                this.u = jVar2;
                jVar2.setAutoRelease(false);
                this.u.getAdTemplate().mAdWebVideoPageShowing = true;
            }
            this.p.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            if (this.p.getParent() != null) {
                ((ViewGroup) this.p.getParent()).removeView(this.p);
            }
            if (this.a.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.a;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.a.setTag(null);
            }
            this.a.addView(this.p);
            this.a.setTag(this.p);
            this.o.setVisibility(8);
            this.n.setVisibility(8);
            if (((com.kwad.sdk.feed.widget.base.a) this).f58529c.adConversionInfo.h5Type == 1) {
                this.f58564j.setVisibility(8);
            } else {
                this.f58564j.setVisibility(0);
                this.f58564j.setText(((com.kwad.sdk.feed.widget.base.a) this).f58529c.adBaseInfo.adDescription);
            }
            a(this.u, this.p);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            super.a(adTemplate);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.z = new NestedScrollingChildHelper(this);
            RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
            this.a = ratioFrameLayout;
            ratioFrameLayout.setRatio(0.56f);
            this.f58560f = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
            this.f58564j = (TextView) findViewById(R.id.ksad_video_text_below);
            ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
            this.f58565k = scaleAnimSeekBar;
            scaleAnimSeekBar.setMaxProgress(100);
            this.f58565k.setMinProgress(0);
            this.f58562h = (TextView) findViewById(R.id.ksad_video_control_play_total);
            this.f58563i = (TextView) findViewById(R.id.ksad_video_control_play_duration);
            this.l = (ImageView) findViewById(R.id.ksad_video_control_play_button);
            this.n = (ImageView) findViewById(R.id.ksad_video_control_play_status);
            this.m = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
            this.o = (ViewGroup) findViewById(R.id.ksad_video_control_container);
            this.s = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
            this.q = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
            this.r = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.v == 101) {
                p();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.z.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.z.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.z.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.z.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.e();
            com.kwad.sdk.core.video.videoview.b bVar = this.p;
            if (bVar == null || bVar.g()) {
                return;
            }
            g();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.H);
                getHandler().postDelayed(this.H, 5000L);
            }
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.core.j.d
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.f();
            if (this.p != null) {
                h();
                if (getHandler() != null) {
                    getHandler().removeCallbacks(this.H);
                    getHandler().postDelayed(this.H, 5000L);
                }
            }
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? R.layout.ksad_feed_video : invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.z.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.z.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.z.setNestedScrollingEnabled(z);
        }
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.B = onClickListener;
        }
    }

    public void setUIWithStateAndMode(int i2) {
        ImageView imageView;
        Resources resources;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (i2 == 101) {
                imageView = this.m;
                resources = getContext().getResources();
                i3 = R.drawable.ksad_video_player_exit_fullscreen_btn;
            } else {
                imageView = this.m;
                resources = getContext().getResources();
                i3 = R.drawable.ksad_video_player_fullscreen_btn;
            }
            imageView.setImageDrawable(resources.getDrawable(i3));
            this.v = i2;
        }
    }

    public void setWindowFullScreenListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.D = aVar;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) ? this.z.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.z.stopNestedScroll();
        }
    }
}
