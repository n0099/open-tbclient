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
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class k extends com.kwad.sdk.feed.widget.base.a implements NestedScrollingChild, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NestedScrollingChildHelper A;
    public boolean B;
    public View.OnClickListener C;
    public KsAdVideoPlayConfig D;
    public Runnable E;
    public aq F;

    /* renamed from: f  reason: collision with root package name */
    public RatioFrameLayout f37483f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f37484g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f37485h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f37486i;
    public TextView j;
    public TextView k;
    public ScaleAnimSeekBar l;
    public ImageView m;
    public ImageView n;
    public ImageView o;
    public ViewGroup p;
    public com.kwad.sdk.core.video.videoview.b q;
    public ViewGroup r;
    public TextView s;
    public ViewGroup t;
    public ViewGroup u;
    public j v;
    public int w;
    public boolean x;
    public boolean y;
    public long z;

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
        this.w = 100;
        Runnable runnable = new Runnable(this) { // from class: com.kwad.sdk.feed.widget.k.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ k f37487a;

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
                this.f37487a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f37487a.p.setVisibility(8);
                    this.f37487a.o.setVisibility(8);
                    if (this.f37487a.v != null) {
                        this.f37487a.v.a(true);
                    }
                }
            }
        };
        this.E = runnable;
        this.F = new aq(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.f37485h;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.f37485h.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.b.b(((com.kwad.sdk.feed.widget.base.a) this).f37439a, ceil, null);
                    it.remove();
                    return;
                }
            }
        }
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, com.kwad.sdk.core.video.videoview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, aVar, bVar) == null) {
            this.t.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.k.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ k f37488a;

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
                    this.f37488a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f37488a.p.getVisibility() != 8) {
                            if (this.f37488a.getHandler() != null) {
                                this.f37488a.getHandler().removeCallbacks(this.f37488a.E);
                                if (this.f37488a.B) {
                                    return;
                                }
                                this.f37488a.getHandler().postDelayed(this.f37488a.F, 1000L);
                                return;
                            }
                            return;
                        }
                        if (!this.f37488a.q.i()) {
                            this.f37488a.p.setVisibility(0);
                            this.f37488a.o.setVisibility(0);
                            if (this.f37488a.v != null) {
                                this.f37488a.v.a(false);
                            }
                            if (this.f37488a.getHandler() == null) {
                                return;
                            }
                        } else if (this.f37488a.w != 101) {
                            if (this.f37488a.C != null) {
                                this.f37488a.C.onClick(view);
                                return;
                            }
                            return;
                        } else {
                            this.f37488a.p.setVisibility(0);
                            this.f37488a.o.setVisibility(8);
                            if (this.f37488a.v != null) {
                                this.f37488a.v.a(false);
                            }
                            if (this.f37488a.getHandler() == null) {
                                return;
                            }
                        }
                        this.f37488a.getHandler().removeCallbacks(this.f37488a.E);
                        this.f37488a.getHandler().postDelayed(this.f37488a.F, 5000L);
                    }
                }
            });
            aVar.setVideoPlayCallback(new a.InterfaceC0439a(this, bVar) { // from class: com.kwad.sdk.feed.widget.k.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.b f37489a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f37490b;

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
                    this.f37490b = this;
                    this.f37489a = bVar;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) this.f37490b).f37439a);
                        this.f37490b.f37486i.setText(ai.a(this.f37489a.getDuration()));
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                public void a(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        this.f37490b.a(j);
                        float duration = (((float) j) * 100.0f) / ((float) this.f37489a.getDuration());
                        if (!this.f37490b.B) {
                            this.f37490b.l.setProgress((int) duration);
                            this.f37490b.j.setText(ai.a(j));
                        }
                        this.f37490b.f37486i.setText(ai.a(this.f37489a.getDuration()));
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) this.f37490b).f37439a);
                        this.f37490b.p.setVisibility(8);
                        this.f37490b.o.setVisibility(8);
                        this.f37490b.l.setProgress((int) 100.0f);
                        this.f37490b.j.setText(ai.a(this.f37489a.getDuration()));
                    }
                }
            });
            this.l.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a(this, bVar) { // from class: com.kwad.sdk.feed.widget.k.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.b f37491a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f37492b;

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
                    this.f37492b = this;
                    this.f37491a = bVar;
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, scaleAnimSeekBar) == null) {
                        this.f37492b.l.a(true);
                        this.f37492b.getHandler().removeCallbacks(this.f37492b.F);
                        this.f37492b.B = true;
                    }
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public void a(ScaleAnimSeekBar scaleAnimSeekBar, int i2, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{scaleAnimSeekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                        this.f37492b.l.a(true);
                        this.f37492b.getHandler().removeCallbacks(this.f37492b.F);
                        this.f37492b.B = true;
                        this.f37492b.j.setText(ai.a((int) ((this.f37491a.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                    }
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public void b(ScaleAnimSeekBar scaleAnimSeekBar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, scaleAnimSeekBar) == null) {
                        this.f37492b.l.a(false);
                        this.f37491a.a((int) ((this.f37491a.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                        if (this.f37492b.getHandler() != null) {
                            this.f37492b.getHandler().removeCallbacks(this.f37492b.F);
                            this.f37492b.getHandler().postDelayed(this.f37492b.F, 5000L);
                        }
                        this.f37492b.B = false;
                    }
                }
            });
            this.m.setOnClickListener(new View.OnClickListener(this, bVar) { // from class: com.kwad.sdk.feed.widget.k.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.b f37493a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f37494b;

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
                    this.f37494b = this;
                    this.f37493a = bVar;
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
                    if (!this.f37493a.h() && !this.f37493a.d()) {
                        if (this.f37493a.g()) {
                            this.f37494b.v.k();
                            this.f37494b.o.setVisibility(0);
                            this.f37494b.o.setImageDrawable(this.f37494b.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
                            imageView = this.f37494b.m;
                            resources = this.f37494b.getContext().getResources();
                            i2 = R.drawable.ksad_video_player_play_btn;
                        }
                        if (this.f37494b.getHandler() == null) {
                            this.f37494b.getHandler().removeCallbacks(this.f37494b.F);
                            this.f37494b.getHandler().postDelayed(this.f37494b.F, 5000L);
                            return;
                        }
                        return;
                    }
                    this.f37494b.v.l();
                    this.f37494b.m.setImageDrawable(this.f37494b.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    imageView = this.f37494b.o;
                    resources = this.f37494b.getContext().getResources();
                    i2 = R.drawable.ksad_video_player_pause_center;
                    imageView.setImageDrawable(resources.getDrawable(i2));
                    if (this.f37494b.getHandler() == null) {
                    }
                }
            });
            this.o.setOnClickListener(new View.OnClickListener(this, bVar) { // from class: com.kwad.sdk.feed.widget.k.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.b f37495a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f37496b;

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
                    this.f37496b = this;
                    this.f37495a = bVar;
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
                    if (!this.f37495a.h() && !this.f37495a.d()) {
                        if (this.f37495a.g()) {
                            this.f37496b.v.k();
                            this.f37496b.o.setVisibility(0);
                            this.f37496b.o.setImageDrawable(this.f37496b.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
                            imageView = this.f37496b.m;
                            resources = this.f37496b.getContext().getResources();
                            i2 = R.drawable.ksad_video_player_play_btn;
                        }
                        if (this.f37496b.getHandler() == null) {
                            this.f37496b.getHandler().removeCallbacks(this.f37496b.F);
                            this.f37496b.getHandler().postDelayed(this.f37496b.F, 5000L);
                            return;
                        }
                        return;
                    }
                    this.f37496b.v.l();
                    this.f37496b.m.setImageDrawable(this.f37496b.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    imageView = this.f37496b.o;
                    resources = this.f37496b.getContext().getResources();
                    i2 = R.drawable.ksad_video_player_pause_center;
                    imageView.setImageDrawable(resources.getDrawable(i2));
                    if (this.f37496b.getHandler() == null) {
                    }
                }
            });
            this.r.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.k.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ k f37497a;

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
                    this.f37497a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f37497a.i();
                    }
                }
            });
            this.n.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.k.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ k f37498a;

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
                    this.f37498a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f37498a.w == 100) {
                            this.f37498a.h();
                        } else if (this.f37498a.w == 101) {
                            this.f37498a.i();
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
            int i2 = ((elapsedRealtime - this.z) > 888L ? 1 : ((elapsedRealtime - this.z) == 888L ? 0 : -1));
            if (i2 > 0) {
                this.z = elapsedRealtime;
            }
            return i2 > 0;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if ((this.w == 100) && g()) {
                this.r.setVisibility(0);
                this.s.setText(this.f37440b.adBaseInfo.adDescription);
                boolean z = com.kwad.sdk.core.response.b.a.e(this.f37440b) > com.kwad.sdk.core.response.b.a.d(this.f37440b);
                this.x = x.a(getContext());
                this.y = x.e(getContext());
                Context context = getContext();
                if (z) {
                    x.d(context);
                } else {
                    x.c(context);
                }
                ViewGroup viewGroup = (ViewGroup) this.t.getParent();
                this.u = viewGroup;
                if (viewGroup != null) {
                    viewGroup.removeView(this.t);
                }
                x.a(getContext(), false);
                Activity f2 = x.f(getContext());
                if (f2 != null) {
                    ViewGroup viewGroup2 = (ViewGroup) f2.getWindow().getDecorView();
                    this.t.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                    if (z && viewGroup2.getWidth() != 0) {
                        this.f37483f.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                    }
                    viewGroup2.addView(this.t, new FrameLayout.LayoutParams(-1, -1));
                    setUIWithStateAndMode(101);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if ((this.w == 101) && g()) {
                this.r.setVisibility(8);
                if (this.x) {
                    x.a(getContext());
                } else {
                    x.b(getContext());
                }
                if (this.y) {
                    x.d(getContext());
                } else {
                    x.c(getContext());
                }
                x.a(getContext(), true);
                ViewGroup viewGroup = (ViewGroup) this.t.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.t);
                }
                this.t.setLayoutParams(new ViewGroup.LayoutParams(this.u.getWidth(), this.u.getHeight()));
                this.f37483f.setRatio(0.56f);
                this.u.addView(this.t, new FrameLayout.LayoutParams(-1, -2));
                this.t.requestLayout();
                setUIWithStateAndMode(100);
            }
        }
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksAdVideoPlayConfig) == null) {
            com.kwad.sdk.core.response.model.c U = com.kwad.sdk.core.response.b.a.U(this.f37440b);
            this.D = ksAdVideoPlayConfig;
            String a2 = U.a();
            if (TextUtils.isEmpty(a2)) {
                this.f37484g.setVisibility(8);
            } else {
                this.f37484g.setImageDrawable(null);
                KSImageLoader.loadImage(this.f37484g, a2, ((com.kwad.sdk.feed.widget.base.a) this).f37439a);
                this.f37484g.setVisibility(0);
            }
            this.f37485h = com.kwad.sdk.core.response.b.a.M(this.f37440b);
            String a3 = com.kwad.sdk.core.response.b.a.a(this.f37440b);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            com.kwad.sdk.core.video.videoview.b b2 = AdVideoPlayerViewCache.a().b(a3);
            this.q = b2;
            if (b2 == null) {
                this.q = new com.kwad.sdk.core.video.videoview.b(getContext());
                this.q.a(new d.a().a(((com.kwad.sdk.feed.widget.base.a) this).f37439a.mVideoPlayerStatus).a(com.kwad.sdk.core.response.b.c.l(((com.kwad.sdk.feed.widget.base.a) this).f37439a)).a(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.f37440b), System.currentTimeMillis())).a(), (Map<String, String>) null);
                this.q.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
                j jVar2 = new j(this.f37442d, ((com.kwad.sdk.feed.widget.base.a) this).f37439a, this.q);
                this.v = jVar2;
                jVar2.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
                this.q.setController(this.v);
                jVar = this.v;
            } else {
                if (b2.getTag() != null) {
                    try {
                        this.f37485h = (List) this.q.getTag();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                jVar = (j) this.q.getController();
                this.v = jVar;
            }
            jVar.setAutoRelease(false);
            this.q.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            if (this.q.getParent() != null) {
                ((ViewGroup) this.q.getParent()).removeView(this.q);
            }
            if (this.f37483f.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.f37483f;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.f37483f.setTag(null);
            }
            this.f37483f.addView(this.q);
            this.f37483f.setTag(this.q);
            this.p.setVisibility(8);
            this.o.setVisibility(8);
            if (this.f37440b.adConversionInfo.h5Type == 1) {
                this.k.setVisibility(8);
            } else {
                this.k.setVisibility(0);
                this.k.setText(this.f37440b.adBaseInfo.adDescription);
            }
            a(this.v, this.q);
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
            this.A = new NestedScrollingChildHelper(this);
            RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
            this.f37483f = ratioFrameLayout;
            ratioFrameLayout.setRatio(0.56f);
            this.f37484g = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
            this.k = (TextView) findViewById(R.id.ksad_video_text_below);
            ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
            this.l = scaleAnimSeekBar;
            scaleAnimSeekBar.setMaxProgress(100);
            this.l.setMinProgress(0);
            this.f37486i = (TextView) findViewById(R.id.ksad_video_control_play_total);
            this.j = (TextView) findViewById(R.id.ksad_video_control_play_duration);
            this.m = (ImageView) findViewById(R.id.ksad_video_control_play_button);
            this.o = (ImageView) findViewById(R.id.ksad_video_control_play_status);
            this.n = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
            this.p = (ViewGroup) findViewById(R.id.ksad_video_control_container);
            this.t = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
            this.r = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
            this.s = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.A.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.A.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.A.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.A.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.w == 101) {
                i();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.A.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.A.isNestedScrollingEnabled() : invokeV.booleanValue;
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
            this.A.setNestedScrollingEnabled(z);
        }
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.C = onClickListener;
        }
    }

    public void setUIWithStateAndMode(int i2) {
        ImageView imageView;
        Resources resources;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (i2 == 101) {
                imageView = this.n;
                resources = getContext().getResources();
                i3 = R.drawable.ksad_video_player_exit_fullscreen_btn;
            } else {
                imageView = this.n;
                resources = getContext().getResources();
                i3 = R.drawable.ksad_video_player_fullscreen_btn;
            }
            imageView.setImageDrawable(resources.getDrawable(i3));
            this.w = i2;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? this.A.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.A.stopNestedScroll();
        }
    }
}
