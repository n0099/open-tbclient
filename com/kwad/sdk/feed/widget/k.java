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
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ax;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class k extends com.kwad.sdk.feed.widget.base.a implements NestedScrollingChild, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public View.OnClickListener B;
    public KsAdVideoPlayConfig C;
    public a D;
    public View E;
    public Runnable F;
    public ax G;

    /* renamed from: a  reason: collision with root package name */
    public RatioFrameLayout f65756a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f65757f;

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f65758g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f65759h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f65760i;
    public TextView j;
    public ScaleAnimSeekBar k;
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

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ k f65761a;

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
                this.f65761a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f65761a.o.setVisibility(8);
                    this.f65761a.n.setVisibility(8);
                    if (this.f65761a.u != null) {
                        this.f65761a.u.a(true);
                    }
                }
            }
        };
        this.F = runnable;
        this.G = new ax(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.f65758g;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.f65758g.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(((com.kwad.sdk.feed.widget.base.a) this).f65718b, ceil, null);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ k f65762a;

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
                    this.f65762a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f65762a.o.getVisibility() != 8) {
                            if (this.f65762a.getHandler() != null) {
                                this.f65762a.getHandler().removeCallbacks(this.f65762a.F);
                                if (this.f65762a.A) {
                                    return;
                                }
                                this.f65762a.getHandler().postDelayed(this.f65762a.G, 1000L);
                                return;
                            }
                            return;
                        }
                        if (!this.f65762a.p.i()) {
                            this.f65762a.o.setVisibility(0);
                            this.f65762a.n.setVisibility(0);
                            if (this.f65762a.u != null) {
                                this.f65762a.u.a(false);
                            }
                            if (this.f65762a.getHandler() == null) {
                                return;
                            }
                        } else if (this.f65762a.v != 101) {
                            if (this.f65762a.B != null) {
                                this.f65762a.B.onClick(view);
                                return;
                            }
                            return;
                        } else {
                            this.f65762a.o.setVisibility(0);
                            this.f65762a.n.setVisibility(8);
                            if (this.f65762a.u != null) {
                                this.f65762a.u.a(false);
                            }
                            if (this.f65762a.getHandler() == null) {
                                return;
                            }
                        }
                        this.f65762a.getHandler().removeCallbacks(this.f65762a.F);
                        this.f65762a.getHandler().postDelayed(this.f65762a.G, 5000L);
                    }
                }
            });
            aVar.setVideoPlayCallback(new a.b(this, bVar) { // from class: com.kwad.sdk.feed.widget.k.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.b f65763a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f65764b;

                /* renamed from: c  reason: collision with root package name */
                public boolean f65765c;

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
                    this.f65764b = this;
                    this.f65763a = bVar;
                    this.f65765c = false;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) this.f65764b).f65718b);
                        this.f65764b.f65759h.setText(aq.a(this.f65763a.getDuration()));
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        this.f65764b.a(j);
                        float duration = (((float) j) * 100.0f) / ((float) this.f65763a.getDuration());
                        if (!this.f65764b.A) {
                            this.f65764b.k.setProgress((int) duration);
                            this.f65764b.f65760i.setText(aq.a(j));
                        }
                        this.f65764b.f65759h.setText(aq.a(this.f65763a.getDuration()));
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f65765c) {
                        return;
                    }
                    this.f65765c = true;
                    com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) this.f65764b).f65718b, System.currentTimeMillis(), 1);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) this.f65764b).f65718b);
                        this.f65764b.o.setVisibility(8);
                        this.f65764b.n.setVisibility(8);
                        this.f65764b.k.setProgress((int) 100.0f);
                        this.f65764b.f65760i.setText(aq.a(this.f65763a.getDuration()));
                    }
                }
            });
            this.u.setVideoClickListener(new a.InterfaceC1912a(this) { // from class: com.kwad.sdk.feed.widget.k.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ k f65766a;

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
                    this.f65766a = this;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1912a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f65766a.l();
                    }
                }
            });
            this.k.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a(this, bVar) { // from class: com.kwad.sdk.feed.widget.k.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.b f65767a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f65768b;

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
                    this.f65768b = this;
                    this.f65767a = bVar;
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, scaleAnimSeekBar) == null) {
                        this.f65768b.k.a(true);
                        this.f65768b.getHandler().removeCallbacks(this.f65768b.G);
                        this.f65768b.A = true;
                    }
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public void a(ScaleAnimSeekBar scaleAnimSeekBar, int i2, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{scaleAnimSeekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                        this.f65768b.k.a(true);
                        this.f65768b.getHandler().removeCallbacks(this.f65768b.G);
                        this.f65768b.A = true;
                        this.f65768b.f65760i.setText(aq.a((int) ((this.f65767a.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                    }
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public void b(ScaleAnimSeekBar scaleAnimSeekBar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, scaleAnimSeekBar) == null) {
                        this.f65768b.k.a(false);
                        this.f65767a.a((int) ((this.f65767a.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                        if (this.f65768b.getHandler() != null) {
                            this.f65768b.getHandler().removeCallbacks(this.f65768b.G);
                            this.f65768b.getHandler().postDelayed(this.f65768b.G, 5000L);
                        }
                        this.f65768b.A = false;
                    }
                }
            });
            this.l.setOnClickListener(new View.OnClickListener(this, bVar) { // from class: com.kwad.sdk.feed.widget.k.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.b f65769a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f65770b;

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
                    this.f65770b = this;
                    this.f65769a = bVar;
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
                    if (!this.f65769a.h() && !this.f65769a.d()) {
                        if (this.f65769a.g()) {
                            this.f65770b.u.m();
                            this.f65770b.n.setVisibility(0);
                            this.f65770b.n.setImageDrawable(this.f65770b.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
                            imageView = this.f65770b.l;
                            resources = this.f65770b.getContext().getResources();
                            i2 = R.drawable.ksad_video_player_play_btn;
                        }
                        if (this.f65770b.getHandler() == null) {
                            this.f65770b.getHandler().removeCallbacks(this.f65770b.G);
                            this.f65770b.getHandler().postDelayed(this.f65770b.G, 5000L);
                            return;
                        }
                        return;
                    }
                    this.f65770b.u.n();
                    this.f65770b.l.setImageDrawable(this.f65770b.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    imageView = this.f65770b.n;
                    resources = this.f65770b.getContext().getResources();
                    i2 = R.drawable.ksad_video_player_pause_center;
                    imageView.setImageDrawable(resources.getDrawable(i2));
                    if (this.f65770b.getHandler() == null) {
                    }
                }
            });
            this.n.setOnClickListener(new View.OnClickListener(this, bVar) { // from class: com.kwad.sdk.feed.widget.k.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.b f65771a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f65772b;

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
                    this.f65772b = this;
                    this.f65771a = bVar;
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
                    if (!this.f65771a.h() && !this.f65771a.d()) {
                        if (this.f65771a.g()) {
                            this.f65772b.u.m();
                            this.f65772b.n.setVisibility(0);
                            this.f65772b.n.setImageDrawable(this.f65772b.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
                            imageView = this.f65772b.l;
                            resources = this.f65772b.getContext().getResources();
                            i2 = R.drawable.ksad_video_player_play_btn;
                        }
                        if (this.f65772b.getHandler() == null) {
                            this.f65772b.getHandler().removeCallbacks(this.f65772b.G);
                            this.f65772b.getHandler().postDelayed(this.f65772b.G, 5000L);
                            return;
                        }
                        return;
                    }
                    this.f65772b.u.n();
                    this.f65772b.l.setImageDrawable(this.f65772b.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    imageView = this.f65772b.n;
                    resources = this.f65772b.getContext().getResources();
                    i2 = R.drawable.ksad_video_player_pause_center;
                    imageView.setImageDrawable(resources.getDrawable(i2));
                    if (this.f65772b.getHandler() == null) {
                    }
                }
            });
            this.q.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.k.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ k f65773a;

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
                    this.f65773a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f65773a.i();
                    }
                }
            });
            this.m.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.k.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ k f65774a;

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
                    this.f65774a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f65774a.v == 100) {
                            this.f65774a.h();
                        } else if (this.f65774a.v == 101) {
                            this.f65774a.i();
                        }
                    }
                }
            });
        }
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
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
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            a aVar = this.D;
            if (aVar != null) {
                aVar.a();
            }
            if ((this.v == 100) && g()) {
                this.q.setVisibility(0);
                this.r.setText(((com.kwad.sdk.feed.widget.base.a) this).f65719c.adBaseInfo.adDescription);
                boolean z = com.kwad.sdk.core.response.b.a.e(((com.kwad.sdk.feed.widget.base.a) this).f65719c) > com.kwad.sdk.core.response.b.a.d(((com.kwad.sdk.feed.widget.base.a) this).f65719c);
                this.w = ab.a(getContext());
                this.x = ab.e(getContext());
                Context context = getContext();
                if (z) {
                    ab.d(context);
                } else {
                    ab.c(context);
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
                ab.a(getContext(), false);
                Context a2 = av.a(this);
                if (a2 instanceof Activity) {
                    ViewGroup viewGroup2 = (ViewGroup) ((Activity) a2).getWindow().getDecorView();
                    this.s.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                    if (z && viewGroup2.getWidth() != 0) {
                        this.f65756a.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                    }
                    viewGroup2.addView(this.s, new FrameLayout.LayoutParams(-1, -1));
                    setUIWithStateAndMode(101);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if ((this.v == 101) & g()) {
                this.q.setVisibility(8);
                if (this.w) {
                    ab.a(getContext());
                } else {
                    ab.b(getContext());
                }
                if (this.x) {
                    ab.d(getContext());
                } else {
                    ab.c(getContext());
                }
                ab.a(getContext(), true);
                ViewGroup viewGroup = (ViewGroup) this.s.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.s);
                }
                this.s.setLayoutParams(new ViewGroup.LayoutParams(this.t.getWidth(), this.t.getHeight()));
                this.f65756a.setRatio(0.56f);
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

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksAdVideoPlayConfig) == null) {
            com.kwad.sdk.core.response.model.c T = com.kwad.sdk.core.response.b.a.T(((com.kwad.sdk.feed.widget.base.a) this).f65719c);
            this.C = ksAdVideoPlayConfig;
            String a2 = T.a();
            if (TextUtils.isEmpty(a2)) {
                this.f65757f.setVisibility(8);
            } else {
                this.f65757f.setImageDrawable(null);
                KSImageLoader.loadImage(this.f65757f, a2, ((com.kwad.sdk.feed.widget.base.a) this).f65718b);
                this.f65757f.setVisibility(0);
            }
            this.f65758g = com.kwad.sdk.core.response.b.a.I(((com.kwad.sdk.feed.widget.base.a) this).f65719c);
            String a3 = com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) this).f65719c);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            com.kwad.sdk.core.video.videoview.b b2 = AdVideoPlayerViewCache.a().b(a3);
            this.p = b2;
            if (b2 == null) {
                this.p = new com.kwad.sdk.core.video.videoview.b(getContext());
                com.kwad.sdk.core.response.b.a.i(((com.kwad.sdk.feed.widget.base.a) this).f65719c);
                this.p.a(new c.a().a(((com.kwad.sdk.feed.widget.base.a) this).f65718b.mVideoPlayerStatus).a(com.kwad.sdk.core.response.b.c.l(((com.kwad.sdk.feed.widget.base.a) this).f65718b)).b(com.kwad.sdk.core.response.b.e.b(com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.feed.widget.base.a) this).f65718b))).a(new com.kwad.sdk.contentalliance.detail.video.b(((com.kwad.sdk.feed.widget.base.a) this).f65718b, System.currentTimeMillis())).a(), (Map<String, String>) null);
                this.p.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
                j jVar2 = new j(((com.kwad.sdk.feed.widget.base.a) this).f65721e, ((com.kwad.sdk.feed.widget.base.a) this).f65718b, this.p);
                this.u = jVar2;
                jVar2.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
                this.p.setController(this.u);
                jVar = this.u;
            } else {
                if (b2.getTag() != null) {
                    try {
                        this.f65758g = (List) this.p.getTag();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                jVar = (j) this.p.getController();
                this.u = jVar;
            }
            jVar.setAutoRelease(false);
            this.p.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            if (this.p.getParent() != null) {
                ((ViewGroup) this.p.getParent()).removeView(this.p);
            }
            if (this.f65756a.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.f65756a;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.f65756a.setTag(null);
            }
            this.f65756a.addView(this.p);
            this.f65756a.setTag(this.p);
            this.o.setVisibility(8);
            this.n.setVisibility(8);
            if (((com.kwad.sdk.feed.widget.base.a) this).f65719c.adConversionInfo.h5Type == 1) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                this.j.setText(((com.kwad.sdk.feed.widget.base.a) this).f65719c.adBaseInfo.adDescription);
            }
            a(this.u, this.p);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            super.a(adTemplate);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.z = new NestedScrollingChildHelper(this);
            RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
            this.f65756a = ratioFrameLayout;
            ratioFrameLayout.setRatio(0.56f);
            this.f65757f = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
            this.j = (TextView) findViewById(R.id.ksad_video_text_below);
            ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
            this.k = scaleAnimSeekBar;
            scaleAnimSeekBar.setMaxProgress(100);
            this.k.setMinProgress(0);
            this.f65759h = (TextView) findViewById(R.id.ksad_video_control_play_total);
            this.f65760i = (TextView) findViewById(R.id.ksad_video_control_play_duration);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.v == 101) {
                i();
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.z.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.z.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.z.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.z.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? R.layout.ksad_feed_video : invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.z.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.z.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.z.setNestedScrollingEnabled(z);
        }
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.B = onClickListener;
        }
    }

    public void setUIWithStateAndMode(int i2) {
        ImageView imageView;
        Resources resources;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.D = aVar;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? this.z.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.z.stopNestedScroll();
        }
    }
}
