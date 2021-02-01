package com.kwad.sdk.feed.widget;

import android.app.Activity;
import android.content.Context;
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
/* loaded from: classes3.dex */
public class k extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener, NestedScrollingChild {
    private NestedScrollingChildHelper A;
    private boolean B;
    private View.OnClickListener C;
    private KsAdVideoPlayConfig D;
    private Runnable E;
    private aq F;
    private RatioFrameLayout f;
    private ImageView g;
    private List<Integer> h;
    private TextView i;
    private TextView j;
    private TextView k;
    private ScaleAnimSeekBar l;
    private ImageView m;
    private ImageView n;
    private ImageView o;
    private ViewGroup p;
    private com.kwad.sdk.core.video.videoview.b q;
    private ViewGroup r;
    private TextView s;
    private ViewGroup t;
    private ViewGroup u;
    private j v;
    private int w;
    private boolean x;
    private boolean y;
    private long z;

    public k(@NonNull Context context) {
        super(context);
        this.w = 100;
        this.E = new Runnable() { // from class: com.kwad.sdk.feed.widget.k.1
            @Override // java.lang.Runnable
            public void run() {
                k.this.p.setVisibility(8);
                k.this.o.setVisibility(8);
                if (k.this.v != null) {
                    k.this.v.a(true);
                }
            }
        };
        this.F = new aq(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        if (this.h == null || this.h.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.h.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.b.b(this.f9862a, ceil, null);
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
                    }
                } else if (!k.this.q.i()) {
                    k.this.p.setVisibility(0);
                    k.this.o.setVisibility(0);
                    if (k.this.v != null) {
                        k.this.v.a(false);
                    }
                    if (k.this.getHandler() != null) {
                        k.this.getHandler().removeCallbacks(k.this.E);
                        k.this.getHandler().postDelayed(k.this.F, 5000L);
                    }
                } else if (k.this.w != 101) {
                    if (k.this.C != null) {
                        k.this.C.onClick(view);
                    }
                } else {
                    k.this.p.setVisibility(0);
                    k.this.o.setVisibility(8);
                    if (k.this.v != null) {
                        k.this.v.a(false);
                    }
                    if (k.this.getHandler() != null) {
                        k.this.getHandler().removeCallbacks(k.this.E);
                        k.this.getHandler().postDelayed(k.this.F, 5000L);
                    }
                }
            }
        });
        aVar.setVideoPlayCallback(new a.InterfaceC1105a() { // from class: com.kwad.sdk.feed.widget.k.3
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1105a
            public void a() {
                com.kwad.sdk.core.report.b.h(k.this.f9862a);
                k.this.i.setText(ai.a(bVar.getDuration()));
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1105a
            public void a(long j) {
                k.this.a(j);
                float duration = (((float) j) * 100.0f) / ((float) bVar.getDuration());
                if (!k.this.B) {
                    k.this.l.setProgress((int) duration);
                    k.this.j.setText(ai.a(j));
                }
                k.this.i.setText(ai.a(bVar.getDuration()));
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1105a
            public void b() {
                com.kwad.sdk.core.report.b.i(k.this.f9862a);
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
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bVar.h() || bVar.d()) {
                    k.this.v.l();
                    k.this.m.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    k.this.o.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
                } else if (bVar.g()) {
                    k.this.v.k();
                    k.this.o.setVisibility(0);
                    k.this.o.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
                    k.this.m.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
                }
                if (k.this.getHandler() != null) {
                    k.this.getHandler().removeCallbacks(k.this.F);
                    k.this.getHandler().postDelayed(k.this.F, 5000L);
                }
            }
        });
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bVar.h() || bVar.d()) {
                    k.this.v.l();
                    k.this.m.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    k.this.o.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
                } else if (bVar.g()) {
                    k.this.v.k();
                    k.this.o.setVisibility(0);
                    k.this.o.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_center));
                    k.this.m.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
                }
                if (k.this.getHandler() != null) {
                    k.this.getHandler().removeCallbacks(k.this.F);
                    k.this.getHandler().postDelayed(k.this.F, 5000L);
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
            this.s.setText(this.f9863b.adBaseInfo.adDescription);
            boolean z = com.kwad.sdk.core.response.b.a.e(this.f9863b) > com.kwad.sdk.core.response.b.a.d(this.f9863b);
            this.x = x.a(getContext());
            this.y = x.e(getContext());
            if (z) {
                x.d(getContext());
            } else {
                x.c(getContext());
            }
            ViewGroup viewGroup = (ViewGroup) this.t.getParent();
            this.u = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.t);
            }
            x.a(getContext(), false);
            Activity f = x.f(getContext());
            if (f != null) {
                ViewGroup viewGroup2 = (ViewGroup) f.getWindow().getDecorView();
                this.t.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z && viewGroup2.getWidth() != 0) {
                    this.f.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
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
            this.f.setRatio(0.56f);
            this.u.addView(this.t, new FrameLayout.LayoutParams(-1, -2));
            this.t.requestLayout();
            setUIWithStateAndMode(100);
        }
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.sdk.core.response.model.c U = com.kwad.sdk.core.response.b.a.U(this.f9863b);
        this.D = ksAdVideoPlayConfig;
        String a2 = U.a();
        if (TextUtils.isEmpty(a2)) {
            this.g.setVisibility(8);
        } else {
            this.g.setImageDrawable(null);
            KSImageLoader.loadImage(this.g, a2, this.f9862a);
            this.g.setVisibility(0);
        }
        this.h = com.kwad.sdk.core.response.b.a.M(this.f9863b);
        String a3 = com.kwad.sdk.core.response.b.a.a(this.f9863b);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        this.q = AdVideoPlayerViewCache.a().b(a3);
        if (this.q == null) {
            this.q = new com.kwad.sdk.core.video.videoview.b(getContext());
            this.q.a(new d.a().a(this.f9862a.mVideoPlayerStatus).a(com.kwad.sdk.core.response.b.c.l(this.f9862a)).a(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.f9863b), System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.q.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            this.v = new j(this.d, this.f9862a, this.q);
            this.v.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.q.setController(this.v);
            this.v.setAutoRelease(false);
        } else {
            if (this.q.getTag() != null) {
                try {
                    this.h = (List) this.q.getTag();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.v = (j) this.q.getController();
            this.v.setAutoRelease(false);
        }
        this.q.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.q.getParent() != null) {
            ((ViewGroup) this.q.getParent()).removeView(this.q);
        }
        if (this.f.getTag() != null) {
            this.f.removeView((View) this.f.getTag());
            this.f.setTag(null);
        }
        this.f.addView(this.q);
        this.f.setTag(this.q);
        this.p.setVisibility(8);
        this.o.setVisibility(8);
        if (this.f9863b.adConversionInfo.h5Type == 1) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
            this.k.setText(this.f9863b.adBaseInfo.adDescription);
        }
        a(this.v, this.q);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    protected void c() {
        this.A = new NestedScrollingChildHelper(this);
        this.f = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.f.setRatio(0.56f);
        this.g = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.k = (TextView) findViewById(R.id.ksad_video_text_below);
        this.l = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.l.setMaxProgress(100);
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
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.A.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.A.dispatchNestedPreFling(f, f2);
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
    protected int getLayoutId() {
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

    protected void setUIWithStateAndMode(int i) {
        if (i == 101) {
            this.n.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_exit_fullscreen_btn));
        } else {
            this.n.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_fullscreen_btn));
        }
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
