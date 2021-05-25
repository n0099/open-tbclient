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
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.v;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class k extends com.kwad.sdk.feed.widget.base.a implements NestedScrollingChild, View.OnClickListener {
    public NestedScrollingChildHelper A;
    public boolean B;
    public View.OnClickListener C;
    public KsAdVideoPlayConfig D;
    public a E;
    public View F;
    public Runnable G;
    public ap H;

    /* renamed from: f  reason: collision with root package name */
    public RatioFrameLayout f33241f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f33242g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f33243h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f33244i;
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

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public k(@NonNull Context context) {
        super(context);
        this.w = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.feed.widget.k.1
            @Override // java.lang.Runnable
            public void run() {
                k.this.p.setVisibility(8);
                k.this.o.setVisibility(8);
                if (k.this.v != null) {
                    k.this.v.a(true);
                }
            }
        };
        this.G = runnable;
        this.H = new ap(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f33243h;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f33243h.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.b.b(((com.kwad.sdk.feed.widget.base.a) this).f33198a, ceil, null);
                it.remove();
                return;
            }
        }
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, final com.kwad.sdk.core.video.videoview.b bVar) {
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.p.getVisibility() != 8) {
                    if (k.this.getHandler() != null) {
                        k.this.getHandler().removeCallbacks(k.this.G);
                        if (k.this.B) {
                            return;
                        }
                        k.this.getHandler().postDelayed(k.this.H, 1000L);
                        return;
                    }
                    return;
                }
                if (!k.this.q.i()) {
                    k.this.p.setVisibility(0);
                    k.this.o.setVisibility(0);
                    if (k.this.v != null) {
                        k.this.v.a(false);
                    }
                    if (k.this.getHandler() == null) {
                        return;
                    }
                } else if (k.this.w != 101) {
                    if (k.this.C != null) {
                        k.this.C.onClick(view);
                        return;
                    }
                    return;
                } else {
                    k.this.p.setVisibility(0);
                    k.this.o.setVisibility(8);
                    if (k.this.v != null) {
                        k.this.v.a(false);
                    }
                    if (k.this.getHandler() == null) {
                        return;
                    }
                }
                k.this.getHandler().removeCallbacks(k.this.G);
                k.this.getHandler().postDelayed(k.this.H, 5000L);
            }
        });
        aVar.setVideoPlayCallback(new a.InterfaceC0371a() { // from class: com.kwad.sdk.feed.widget.k.3
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0371a
            public void a() {
                com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) k.this).f33198a);
                k.this.f33244i.setText(aj.a(bVar.getDuration()));
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0371a
            public void a(long j) {
                k.this.a(j);
                float duration = (((float) j) * 100.0f) / ((float) bVar.getDuration());
                if (!k.this.B) {
                    k.this.l.setProgress((int) duration);
                    k.this.j.setText(aj.a(j));
                }
                k.this.f33244i.setText(aj.a(bVar.getDuration()));
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0371a
            public void b() {
                com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) k.this).f33198a);
                k.this.p.setVisibility(8);
                k.this.o.setVisibility(8);
                k.this.l.setProgress((int) 100.0f);
                k.this.j.setText(aj.a(bVar.getDuration()));
            }
        });
        this.l.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.sdk.feed.widget.k.4
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                k.this.l.a(true);
                k.this.getHandler().removeCallbacks(k.this.H);
                k.this.B = true;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void a(ScaleAnimSeekBar scaleAnimSeekBar, int i2, boolean z) {
                if (z) {
                    k.this.l.a(true);
                    k.this.getHandler().removeCallbacks(k.this.H);
                    k.this.B = true;
                    k.this.j.setText(aj.a((int) ((bVar.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void b(ScaleAnimSeekBar scaleAnimSeekBar) {
                k.this.l.a(false);
                bVar.a((int) ((bVar.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                if (k.this.getHandler() != null) {
                    k.this.getHandler().removeCallbacks(k.this.H);
                    k.this.getHandler().postDelayed(k.this.H, 5000L);
                }
                k.this.B = false;
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.5
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
                        k.this.v.l();
                        k.this.o.setVisibility(0);
                        k.this.o.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
                        imageView = k.this.m;
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
                k.this.v.m();
                k.this.m.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                imageView = k.this.o;
                resources = k.this.getContext().getResources();
                i2 = R.drawable.ksad_video_player_pause_center;
                imageView.setImageDrawable(resources.getDrawable(i2));
                if (k.this.getHandler() == null) {
                }
            }
        });
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.6
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
                        k.this.v.l();
                        k.this.o.setVisibility(0);
                        k.this.o.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
                        imageView = k.this.m;
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
                k.this.v.m();
                k.this.m.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                imageView = k.this.o;
                resources = k.this.getContext().getResources();
                i2 = R.drawable.ksad_video_player_pause_center;
                imageView.setImageDrawable(resources.getDrawable(i2));
                if (k.this.getHandler() == null) {
                }
            }
        });
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.h();
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.w == 100) {
                    k.this.g();
                } else if (k.this.w == 101) {
                    k.this.h();
                }
            }
        });
    }

    private boolean f() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = ((elapsedRealtime - this.z) > 888L ? 1 : ((elapsedRealtime - this.z) == 888L ? 0 : -1));
        if (i2 > 0) {
            this.z = elapsedRealtime;
        }
        return i2 > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        a aVar = this.E;
        if (aVar != null) {
            aVar.a();
        }
        if ((this.w == 100) && f()) {
            this.r.setVisibility(0);
            this.s.setText(this.f33199b.adBaseInfo.adDescription);
            boolean z = com.kwad.sdk.core.response.b.a.e(this.f33199b) > com.kwad.sdk.core.response.b.a.d(this.f33199b);
            this.x = v.a(getContext());
            this.y = v.e(getContext());
            Context context = getContext();
            if (z) {
                v.d(context);
            } else {
                v.c(context);
            }
            ViewGroup viewGroup = (ViewGroup) this.t.getParent();
            this.u = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.t);
                View view = new View(this.t.getContext());
                this.F = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(this.t.getWidth(), this.t.getHeight()));
                viewGroup.addView(this.F);
            }
            v.a(getContext(), false);
            Context a2 = an.a(this);
            if (a2 instanceof Activity) {
                ViewGroup viewGroup2 = (ViewGroup) ((Activity) a2).getWindow().getDecorView();
                this.t.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z && viewGroup2.getWidth() != 0) {
                    this.f33241f.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.t, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if ((this.w == 101) & f()) {
            this.r.setVisibility(8);
            if (this.x) {
                v.a(getContext());
            } else {
                v.b(getContext());
            }
            if (this.y) {
                v.d(getContext());
            } else {
                v.c(getContext());
            }
            v.a(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.t.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.t);
            }
            this.t.setLayoutParams(new ViewGroup.LayoutParams(this.u.getWidth(), this.u.getHeight()));
            this.f33241f.setRatio(0.56f);
            View view = this.F;
            if (view != null) {
                this.u.removeView(view);
                this.F = null;
            }
            this.u.addView(this.t, new FrameLayout.LayoutParams(-1, -2));
            this.t.requestLayout();
            setUIWithStateAndMode(100);
        }
        a aVar = this.E;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        j jVar;
        com.kwad.sdk.core.response.model.c Q = com.kwad.sdk.core.response.b.a.Q(this.f33199b);
        this.D = ksAdVideoPlayConfig;
        String a2 = Q.a();
        if (TextUtils.isEmpty(a2)) {
            this.f33242g.setVisibility(8);
        } else {
            this.f33242g.setImageDrawable(null);
            KSImageLoader.loadImage(this.f33242g, a2, ((com.kwad.sdk.feed.widget.base.a) this).f33198a);
            this.f33242g.setVisibility(0);
        }
        this.f33243h = com.kwad.sdk.core.response.b.a.I(this.f33199b);
        String a3 = com.kwad.sdk.core.response.b.a.a(this.f33199b);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.b b2 = AdVideoPlayerViewCache.a().b(a3);
        this.q = b2;
        if (b2 == null) {
            this.q = new com.kwad.sdk.core.video.videoview.b(getContext());
            this.q.a(new c.a().a(((com.kwad.sdk.feed.widget.base.a) this).f33198a.mVideoPlayerStatus).a(com.kwad.sdk.core.response.b.c.i(((com.kwad.sdk.feed.widget.base.a) this).f33198a)).b(com.kwad.sdk.core.response.b.d.b(com.kwad.sdk.core.response.b.c.h(((com.kwad.sdk.feed.widget.base.a) this).f33198a))).a(new com.kwad.sdk.contentalliance.detail.video.b(com.kwad.sdk.core.response.b.a.i(this.f33199b), System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.q.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            j jVar2 = new j(this.f33201d, ((com.kwad.sdk.feed.widget.base.a) this).f33198a, this.q);
            this.v = jVar2;
            jVar2.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.q.setController(this.v);
            jVar = this.v;
        } else {
            if (b2.getTag() != null) {
                try {
                    this.f33243h = (List) this.q.getTag();
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
        if (this.f33241f.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.f33241f;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.f33241f.setTag(null);
        }
        this.f33241f.addView(this.q);
        this.f33241f.setTag(this.q);
        this.p.setVisibility(8);
        this.o.setVisibility(8);
        if (this.f33199b.adConversionInfo.h5Type == 1) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
            this.k.setText(this.f33199b.adBaseInfo.adDescription);
        }
        a(this.v, this.q);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.A = new NestedScrollingChildHelper(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.f33241f = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.56f);
        this.f33242g = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.k = (TextView) findViewById(R.id.ksad_video_text_below);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.l = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.l.setMinProgress(0);
        this.f33244i = (TextView) findViewById(R.id.ksad_video_control_play_total);
        this.j = (TextView) findViewById(R.id.ksad_video_control_play_duration);
        this.m = (ImageView) findViewById(R.id.ksad_video_control_play_button);
        this.o = (ImageView) findViewById(R.id.ksad_video_control_play_status);
        this.n = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
        this.p = (ViewGroup) findViewById(R.id.ksad_video_control_container);
        this.t = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
        this.r = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
        this.s = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.A.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.A.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.A.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.A.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    public boolean e() {
        if (this.w == 101) {
            h();
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_video;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.A.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.A.isNestedScrollingEnabled();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.A.setNestedScrollingEnabled(z);
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.C = onClickListener;
    }

    public void setUIWithStateAndMode(int i2) {
        ImageView imageView;
        Resources resources;
        int i3;
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

    public void setWindowFullScreenListener(a aVar) {
        this.E = aVar;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.A.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.A.stopNestedScroll();
    }
}
