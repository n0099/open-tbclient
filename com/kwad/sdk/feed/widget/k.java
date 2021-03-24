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
/* loaded from: classes6.dex */
public class k extends com.kwad.sdk.feed.widget.base.a implements NestedScrollingChild, View.OnClickListener {
    public NestedScrollingChildHelper A;
    public boolean B;
    public View.OnClickListener C;
    public KsAdVideoPlayConfig D;
    public Runnable E;
    public aq F;

    /* renamed from: f  reason: collision with root package name */
    public RatioFrameLayout f34951f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f34952g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f34953h;
    public TextView i;
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
        this.E = runnable;
        this.F = new aq(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f34953h;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f34953h.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.b.b(((com.kwad.sdk.feed.widget.base.a) this).f34912a, ceil, null);
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
                        k.this.getHandler().removeCallbacks(k.this.E);
                        if (k.this.B) {
                            return;
                        }
                        k.this.getHandler().postDelayed(k.this.F, 1000L);
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
                k.this.getHandler().removeCallbacks(k.this.E);
                k.this.getHandler().postDelayed(k.this.F, 5000L);
            }
        });
        aVar.setVideoPlayCallback(new a.InterfaceC0391a() { // from class: com.kwad.sdk.feed.widget.k.3
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0391a
            public void a() {
                com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) k.this).f34912a);
                k.this.i.setText(ai.a(bVar.getDuration()));
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0391a
            public void a(long j) {
                k.this.a(j);
                float duration = (((float) j) * 100.0f) / ((float) bVar.getDuration());
                if (!k.this.B) {
                    k.this.l.setProgress((int) duration);
                    k.this.j.setText(ai.a(j));
                }
                k.this.i.setText(ai.a(bVar.getDuration()));
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0391a
            public void b() {
                com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) k.this).f34912a);
                k.this.p.setVisibility(8);
                k.this.o.setVisibility(8);
                k.this.l.setProgress((int) 100.0f);
                k.this.j.setText(ai.a(bVar.getDuration()));
            }
        });
        this.l.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.sdk.feed.widget.k.4
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                k.this.l.a(true);
                k.this.getHandler().removeCallbacks(k.this.F);
                k.this.B = true;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void a(ScaleAnimSeekBar scaleAnimSeekBar, int i, boolean z) {
                if (z) {
                    k.this.l.a(true);
                    k.this.getHandler().removeCallbacks(k.this.F);
                    k.this.B = true;
                    k.this.j.setText(ai.a((int) ((bVar.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public void b(ScaleAnimSeekBar scaleAnimSeekBar) {
                k.this.l.a(false);
                bVar.a((int) ((bVar.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                if (k.this.getHandler() != null) {
                    k.this.getHandler().removeCallbacks(k.this.F);
                    k.this.getHandler().postDelayed(k.this.F, 5000L);
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
                int i;
                if (!bVar.h() && !bVar.d()) {
                    if (bVar.g()) {
                        k.this.v.k();
                        k.this.o.setVisibility(0);
                        k.this.o.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
                        imageView = k.this.m;
                        resources = k.this.getContext().getResources();
                        i = R.drawable.ksad_video_player_play_btn;
                    }
                    if (k.this.getHandler() == null) {
                        k.this.getHandler().removeCallbacks(k.this.F);
                        k.this.getHandler().postDelayed(k.this.F, 5000L);
                        return;
                    }
                    return;
                }
                k.this.v.l();
                k.this.m.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                imageView = k.this.o;
                resources = k.this.getContext().getResources();
                i = R.drawable.ksad_video_player_pause_center;
                imageView.setImageDrawable(resources.getDrawable(i));
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
                int i;
                if (!bVar.h() && !bVar.d()) {
                    if (bVar.g()) {
                        k.this.v.k();
                        k.this.o.setVisibility(0);
                        k.this.o.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
                        imageView = k.this.m;
                        resources = k.this.getContext().getResources();
                        i = R.drawable.ksad_video_player_play_btn;
                    }
                    if (k.this.getHandler() == null) {
                        k.this.getHandler().removeCallbacks(k.this.F);
                        k.this.getHandler().postDelayed(k.this.F, 5000L);
                        return;
                    }
                    return;
                }
                k.this.v.l();
                k.this.m.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                imageView = k.this.o;
                resources = k.this.getContext().getResources();
                i = R.drawable.ksad_video_player_pause_center;
                imageView.setImageDrawable(resources.getDrawable(i));
                if (k.this.getHandler() == null) {
                }
            }
        });
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.i();
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.w == 100) {
                    k.this.h();
                } else if (k.this.w == 101) {
                    k.this.i();
                }
            }
        });
    }

    private boolean g() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.z;
        if (j > 888) {
            this.z = elapsedRealtime;
        }
        return j > 888;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if ((this.w == 100) && g()) {
            this.r.setVisibility(0);
            this.s.setText(this.f34913b.adBaseInfo.adDescription);
            boolean z = com.kwad.sdk.core.response.b.a.e(this.f34913b) > com.kwad.sdk.core.response.b.a.d(this.f34913b);
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
                    this.f34951f.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.t, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
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
            this.f34951f.setRatio(0.56f);
            this.u.addView(this.t, new FrameLayout.LayoutParams(-1, -2));
            this.t.requestLayout();
            setUIWithStateAndMode(100);
        }
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        j jVar;
        com.kwad.sdk.core.response.model.c U = com.kwad.sdk.core.response.b.a.U(this.f34913b);
        this.D = ksAdVideoPlayConfig;
        String a2 = U.a();
        if (TextUtils.isEmpty(a2)) {
            this.f34952g.setVisibility(8);
        } else {
            this.f34952g.setImageDrawable(null);
            KSImageLoader.loadImage(this.f34952g, a2, ((com.kwad.sdk.feed.widget.base.a) this).f34912a);
            this.f34952g.setVisibility(0);
        }
        this.f34953h = com.kwad.sdk.core.response.b.a.M(this.f34913b);
        String a3 = com.kwad.sdk.core.response.b.a.a(this.f34913b);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.b b2 = AdVideoPlayerViewCache.a().b(a3);
        this.q = b2;
        if (b2 == null) {
            this.q = new com.kwad.sdk.core.video.videoview.b(getContext());
            this.q.a(new d.a().a(((com.kwad.sdk.feed.widget.base.a) this).f34912a.mVideoPlayerStatus).a(com.kwad.sdk.core.response.b.c.l(((com.kwad.sdk.feed.widget.base.a) this).f34912a)).a(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.f34913b), System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.q.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            j jVar2 = new j(this.f34915d, ((com.kwad.sdk.feed.widget.base.a) this).f34912a, this.q);
            this.v = jVar2;
            jVar2.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.q.setController(this.v);
            jVar = this.v;
        } else {
            if (b2.getTag() != null) {
                try {
                    this.f34953h = (List) this.q.getTag();
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
        if (this.f34951f.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.f34951f;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.f34951f.setTag(null);
        }
        this.f34951f.addView(this.q);
        this.f34951f.setTag(this.q);
        this.p.setVisibility(8);
        this.o.setVisibility(8);
        if (this.f34913b.adConversionInfo.h5Type == 1) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
            this.k.setText(this.f34913b.adBaseInfo.adDescription);
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
        this.f34951f = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.56f);
        this.f34952g = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.k = (TextView) findViewById(R.id.ksad_video_text_below);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.l = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.l.setMinProgress(0);
        this.i = (TextView) findViewById(R.id.ksad_video_control_play_total);
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
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.A.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.A.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean f() {
        if (this.w == 101) {
            i();
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

    public void setUIWithStateAndMode(int i) {
        ImageView imageView;
        Resources resources;
        int i2;
        if (i == 101) {
            imageView = this.n;
            resources = getContext().getResources();
            i2 = R.drawable.ksad_video_player_exit_fullscreen_btn;
        } else {
            imageView = this.n;
            resources = getContext().getResources();
            i2 = R.drawable.ksad_video_player_fullscreen_btn;
        }
        imageView.setImageDrawable(resources.getDrawable(i2));
        this.w = i;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.A.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.A.stopNestedScroll();
    }
}
