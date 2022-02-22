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
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
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
/* loaded from: classes4.dex */
public class k extends com.kwad.sdk.feed.widget.base.a implements NestedScrollingChild {
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
    public ImageView f57127f;

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f57128g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57129h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f57130i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f57131j;
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

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();
    }

    public k(@NonNull Context context) {
        super(context);
        this.v = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.feed.widget.k.1
            @Override // java.lang.Runnable
            public void run() {
                k.this.o.setVisibility(8);
                k.this.n.setVisibility(8);
                if (k.this.u != null) {
                    k.this.u.a(true);
                }
            }
        };
        this.G = runnable;
        this.H = new bd(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
        List<Integer> list = this.f57128g;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f57128g.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.b(((com.kwad.sdk.feed.widget.base.a) this).f57095b, ceil, null);
                it.remove();
                return;
            }
        }
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, final com.kwad.sdk.core.video.videoview.b bVar) {
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.o.getVisibility() != 8) {
                    if (k.this.getHandler() != null) {
                        k.this.getHandler().removeCallbacks(k.this.G);
                        if (k.this.A) {
                            return;
                        }
                        k.this.getHandler().postDelayed(k.this.H, 1000L);
                        return;
                    }
                    return;
                }
                if (!k.this.p.i()) {
                    k.this.o.setVisibility(0);
                    k.this.n.setVisibility(0);
                    if (k.this.u != null) {
                        k.this.u.a(false);
                    }
                    if (k.this.getHandler() == null) {
                        return;
                    }
                } else if (k.this.v != 101) {
                    if (k.this.B != null) {
                        k.this.B.onClick(view);
                        return;
                    }
                    return;
                } else {
                    k.this.o.setVisibility(0);
                    k.this.n.setVisibility(8);
                    if (k.this.u != null) {
                        k.this.u.a(false);
                    }
                    if (k.this.getHandler() == null) {
                        return;
                    }
                }
                k.this.getHandler().removeCallbacks(k.this.G);
                k.this.getHandler().postDelayed(k.this.H, 5000L);
            }
        });
        aVar.setVideoPlayCallback(new a.b() { // from class: com.kwad.sdk.feed.widget.k.3

            /* renamed from: c  reason: collision with root package name */
            public boolean f57133c = false;

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j2) {
                k.this.a(j2);
                float duration = (((float) j2) * 100.0f) / ((float) bVar.getDuration());
                if (!k.this.A) {
                    k.this.k.setProgress((int) duration);
                    k.this.f57130i.setText(aw.a(j2));
                }
                k.this.f57129h.setText(aw.a(bVar.getDuration()));
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) k.this).f57095b);
                k.this.f57129h.setText(aw.a(bVar.getDuration()));
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void e() {
                if (this.f57133c) {
                    return;
                }
                this.f57133c = true;
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) k.this).f57095b, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) k.this).f57095b);
                k.this.o.setVisibility(8);
                k.this.n.setVisibility(8);
                k.this.k.setProgress((int) 100.0f);
                k.this.f57130i.setText(aw.a(bVar.getDuration()));
            }
        });
        this.u.setAdClickListener(new a.InterfaceC2128a() { // from class: com.kwad.sdk.feed.widget.k.4
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC2128a
            public void a(int i2, z.a aVar2) {
                int i3;
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
                aVar3.f56278g = aVar2;
                aVar3.f56273b = i3;
                com.kwad.sdk.core.download.a.a.a(new a.C2116a(bb.a(k.this.s)).a(((com.kwad.sdk.feed.widget.base.a) k.this).f57095b).a(k.this.F).a(i4).a(z).c(true).a(aVar3).a(new a.b() { // from class: com.kwad.sdk.feed.widget.k.4.1
                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                        k.this.l();
                    }
                }));
            }
        });
        this.k.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.sdk.feed.widget.k.5
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                k.this.k.a(true);
                k.this.getHandler().removeCallbacks(k.this.H);
                k.this.A = true;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void a(ScaleAnimSeekBar scaleAnimSeekBar, int i2, boolean z) {
                if (z) {
                    k.this.k.a(true);
                    k.this.getHandler().removeCallbacks(k.this.H);
                    k.this.A = true;
                    k.this.f57130i.setText(aw.a((int) ((bVar.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void b(ScaleAnimSeekBar scaleAnimSeekBar) {
                k.this.k.a(false);
                bVar.a((int) ((bVar.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                if (k.this.getHandler() != null) {
                    k.this.getHandler().removeCallbacks(k.this.H);
                    k.this.getHandler().postDelayed(k.this.H, 5000L);
                }
                k.this.A = false;
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.6
            /* JADX WARN: Removed duplicated region for block: B:14:0x009b  */
            /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view) {
                ImageView imageView;
                Resources resources;
                int i2;
                if (!bVar.h() && !bVar.d()) {
                    if (bVar.g()) {
                        k.this.u.n();
                        k.this.n.setVisibility(0);
                        k.this.n.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
                        imageView = k.this.l;
                        resources = k.this.getContext().getResources();
                        i2 = R.drawable.ksad_video_player_play_btn;
                    }
                    if (k.this.getHandler() == null) {
                        k.this.getHandler().removeCallbacks(k.this.H);
                        k.this.getHandler().postDelayed(k.this.H, 5000L);
                        return;
                    }
                    return;
                }
                k.this.u.o();
                k.this.l.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                imageView = k.this.n;
                resources = k.this.getContext().getResources();
                i2 = R.drawable.ksad_video_player_pause_center;
                imageView.setImageDrawable(resources.getDrawable(i2));
                if (k.this.getHandler() == null) {
                }
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.p.h() || k.this.p.d()) {
                    k.this.g();
                } else if (k.this.p.g()) {
                    k.this.h();
                }
                if (k.this.getHandler() != null) {
                    k.this.getHandler().removeCallbacks(k.this.H);
                    k.this.getHandler().postDelayed(k.this.H, 5000L);
                }
            }
        });
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.p();
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.v == 100) {
                    k.this.o();
                } else if (k.this.v == 101) {
                    k.this.p();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.u.o();
        this.l.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
        this.n.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.u.n();
        this.n.setVisibility(0);
        this.n.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
        this.l.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
    }

    private boolean i() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = ((elapsedRealtime - this.y) > 888L ? 1 : ((elapsedRealtime - this.y) == 888L ? 0 : -1));
        if (i2 > 0) {
            this.y = elapsedRealtime;
        }
        return i2 > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.a();
        }
        if ((this.v == 100) && i()) {
            this.q.setVisibility(0);
            this.r.setText(((com.kwad.sdk.feed.widget.base.a) this).f57096c.adBaseInfo.adDescription);
            boolean z = com.kwad.sdk.core.response.a.a.f(((com.kwad.sdk.feed.widget.base.a) this).f57096c) > com.kwad.sdk.core.response.a.a.e(((com.kwad.sdk.feed.widget.base.a) this).f57096c);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
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

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.j
    public void a(View view) {
        super.a(view);
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.sdk.core.download.a.b bVar) {
        this.F = bVar;
        com.kwad.sdk.core.response.model.c aa = com.kwad.sdk.core.response.a.a.aa(((com.kwad.sdk.feed.widget.base.a) this).f57096c);
        this.C = ksAdVideoPlayConfig;
        String a2 = aa.a();
        if (TextUtils.isEmpty(a2)) {
            this.f57127f.setVisibility(8);
        } else {
            this.f57127f.setImageDrawable(null);
            KSImageLoader.loadImage(this.f57127f, a2, ((com.kwad.sdk.feed.widget.base.a) this).f57095b);
            this.f57127f.setVisibility(0);
        }
        this.f57128g = com.kwad.sdk.core.response.a.a.S(((com.kwad.sdk.feed.widget.base.a) this).f57096c);
        String a3 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f57096c);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.b b2 = AdVideoPlayerViewCache.a().b(a3);
        this.p = b2;
        if (b2 == null) {
            this.p = new com.kwad.sdk.core.video.videoview.b(getContext());
            com.kwad.sdk.core.response.a.a.l(((com.kwad.sdk.feed.widget.base.a) this).f57096c);
            this.p.a(new c.a(((com.kwad.sdk.feed.widget.base.a) this).f57095b).a(((com.kwad.sdk.feed.widget.base.a) this).f57095b.mVideoPlayerStatus).a(com.kwad.sdk.core.response.a.d.m(((com.kwad.sdk.feed.widget.base.a) this).f57095b)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(((com.kwad.sdk.feed.widget.base.a) this).f57095b))).a(new com.kwad.sdk.contentalliance.detail.video.b(((com.kwad.sdk.feed.widget.base.a) this).f57095b, System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.p.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            j jVar = new j(((com.kwad.sdk.feed.widget.base.a) this).f57098e, ((com.kwad.sdk.feed.widget.base.a) this).f57095b, this.p);
            this.u = jVar;
            jVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.p.setController(this.u);
            this.u.setAutoRelease(false);
        } else {
            if (b2.getTag() != null) {
                try {
                    this.f57128g = (List) this.p.getTag();
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
        if (((com.kwad.sdk.feed.widget.base.a) this).f57096c.adConversionInfo.h5Type == 1) {
            this.f57131j.setVisibility(8);
        } else {
            this.f57131j.setVisibility(0);
            this.f57131j.setText(((com.kwad.sdk.feed.widget.base.a) this).f57096c.adBaseInfo.adDescription);
        }
        a(this.u, this.p);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.z = new NestedScrollingChildHelper(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.a = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.56f);
        this.f57127f = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.f57131j = (TextView) findViewById(R.id.ksad_video_text_below);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.k = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.k.setMinProgress(0);
        this.f57129h = (TextView) findViewById(R.id.ksad_video_control_play_total);
        this.f57130i = (TextView) findViewById(R.id.ksad_video_control_play_duration);
        this.l = (ImageView) findViewById(R.id.ksad_video_control_play_button);
        this.n = (ImageView) findViewById(R.id.ksad_video_control_play_status);
        this.m = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
        this.o = (ViewGroup) findViewById(R.id.ksad_video_control_container);
        this.s = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
        this.q = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
        this.r = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
    }

    public boolean d() {
        if (this.v == 101) {
            p();
            return true;
        }
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.z.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.z.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.z.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.z.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.core.j.d
    public void e() {
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

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.core.j.d
    public void f() {
        super.f();
        if (this.p != null) {
            h();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.H);
                getHandler().postDelayed(this.H, 5000L);
            }
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_video;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.z.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.z.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.z.setNestedScrollingEnabled(z);
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.B = onClickListener;
    }

    public void setUIWithStateAndMode(int i2) {
        ImageView imageView;
        Resources resources;
        int i3;
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

    public void setWindowFullScreenListener(a aVar) {
        this.D = aVar;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.z.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.z.stopNestedScroll();
    }
}
