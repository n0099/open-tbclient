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
import com.baidu.tieba.R;
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
/* loaded from: classes5.dex */
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
    public ImageView f;
    public List<Integer> g;
    public TextView h;
    public TextView i;
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

    /* loaded from: classes5.dex */
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
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.g;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.g.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.b(((com.kwad.sdk.feed.widget.base.a) this).b, ceil, null);
                it.remove();
                return;
            }
        }
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, final com.kwad.sdk.core.video.videoview.b bVar) {
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
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
                        k.this.B.onClick(view2);
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
            public boolean c = false;

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j) {
                k.this.a(j);
                float duration = (((float) j) * 100.0f) / ((float) bVar.getDuration());
                if (!k.this.A) {
                    k.this.k.setProgress((int) duration);
                    k.this.i.setText(aw.a(j));
                }
                k.this.h.setText(aw.a(bVar.getDuration()));
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) k.this).b);
                k.this.h.setText(aw.a(bVar.getDuration()));
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void e() {
                if (this.c) {
                    return;
                }
                this.c = true;
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) k.this).b, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) k.this).b);
                k.this.o.setVisibility(8);
                k.this.n.setVisibility(8);
                k.this.k.setProgress((int) 100.0f);
                k.this.i.setText(aw.a(bVar.getDuration()));
            }
        });
        this.u.setAdClickListener(new a.InterfaceC0308a() { // from class: com.kwad.sdk.feed.widget.k.4
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0308a
            public void a(int i, z.a aVar2) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i == 1) {
                    i2 = 13;
                } else if (i == 2) {
                    i2 = 82;
                } else if (i != 3) {
                    i2 = 108;
                } else {
                    i2 = 83;
                    i3 = 1;
                    z = true;
                }
                p.a aVar3 = new p.a();
                aVar3.g = aVar2;
                aVar3.b = i2;
                com.kwad.sdk.core.download.a.a.a(new a.C0296a(bb.a(k.this.s)).a(((com.kwad.sdk.feed.widget.base.a) k.this).b).a(k.this.F).a(i3).a(z).c(true).a(aVar3).a(new a.b() { // from class: com.kwad.sdk.feed.widget.k.4.1
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
            public void a(ScaleAnimSeekBar scaleAnimSeekBar, int i, boolean z) {
                if (z) {
                    k.this.k.a(true);
                    k.this.getHandler().removeCallbacks(k.this.H);
                    k.this.A = true;
                    k.this.i.setText(aw.a((int) ((bVar.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
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
            /* JADX WARN: Removed duplicated region for block: B:14:0x009f  */
            /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view2) {
                ImageView imageView;
                Resources resources;
                int i;
                if (!bVar.h() && !bVar.d()) {
                    if (bVar.g()) {
                        k.this.u.n();
                        k.this.n.setVisibility(0);
                        k.this.n.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cf7));
                        imageView = k.this.l;
                        resources = k.this.getContext().getResources();
                        i = R.drawable.obfuscated_res_0x7f080cf6;
                    }
                    if (k.this.getHandler() == null) {
                        k.this.getHandler().removeCallbacks(k.this.H);
                        k.this.getHandler().postDelayed(k.this.H, 5000L);
                        return;
                    }
                    return;
                }
                k.this.u.o();
                k.this.l.setImageDrawable(k.this.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cf4));
                imageView = k.this.n;
                resources = k.this.getContext().getResources();
                i = R.drawable.obfuscated_res_0x7f080cf5;
                imageView.setImageDrawable(resources.getDrawable(i));
                if (k.this.getHandler() == null) {
                }
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
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
            public void onClick(View view2) {
                k.this.p();
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
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
        this.l.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cf4));
        this.n.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cf5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.u.n();
        this.n.setVisibility(0);
        this.n.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cf7));
        this.l.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cf6));
    }

    private boolean i() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = ((elapsedRealtime - this.y) > 888L ? 1 : ((elapsedRealtime - this.y) == 888L ? 0 : -1));
        if (i > 0) {
            this.y = elapsedRealtime;
        }
        return i > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.a();
        }
        if ((this.v == 100) && i()) {
            this.q.setVisibility(0);
            this.r.setText(((com.kwad.sdk.feed.widget.base.a) this).c.adBaseInfo.adDescription);
            boolean z = com.kwad.sdk.core.response.a.a.f(((com.kwad.sdk.feed.widget.base.a) this).c) > com.kwad.sdk.core.response.a.a.e(((com.kwad.sdk.feed.widget.base.a) this).c);
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
                View view2 = new View(this.s.getContext());
                this.E = view2;
                view2.setLayoutParams(new ViewGroup.LayoutParams(this.s.getWidth(), this.s.getHeight()));
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
            View view2 = this.E;
            if (view2 != null) {
                this.t.removeView(view2);
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
    public void a(View view2) {
        super.a(view2);
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.sdk.core.download.a.b bVar) {
        this.F = bVar;
        com.kwad.sdk.core.response.model.c aa = com.kwad.sdk.core.response.a.a.aa(((com.kwad.sdk.feed.widget.base.a) this).c);
        this.C = ksAdVideoPlayConfig;
        String a2 = aa.a();
        if (TextUtils.isEmpty(a2)) {
            this.f.setVisibility(8);
        } else {
            this.f.setImageDrawable(null);
            KSImageLoader.loadImage(this.f, a2, ((com.kwad.sdk.feed.widget.base.a) this).b);
            this.f.setVisibility(0);
        }
        this.g = com.kwad.sdk.core.response.a.a.S(((com.kwad.sdk.feed.widget.base.a) this).c);
        String a3 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).c);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.b b = AdVideoPlayerViewCache.a().b(a3);
        this.p = b;
        if (b == null) {
            this.p = new com.kwad.sdk.core.video.videoview.b(getContext());
            com.kwad.sdk.core.response.a.a.l(((com.kwad.sdk.feed.widget.base.a) this).c);
            this.p.a(new c.a(((com.kwad.sdk.feed.widget.base.a) this).b).a(((com.kwad.sdk.feed.widget.base.a) this).b.mVideoPlayerStatus).a(com.kwad.sdk.core.response.a.d.m(((com.kwad.sdk.feed.widget.base.a) this).b)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(((com.kwad.sdk.feed.widget.base.a) this).b))).a(new com.kwad.sdk.contentalliance.detail.video.b(((com.kwad.sdk.feed.widget.base.a) this).b, System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.p.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            j jVar = new j(((com.kwad.sdk.feed.widget.base.a) this).e, ((com.kwad.sdk.feed.widget.base.a) this).b, this.p);
            this.u = jVar;
            jVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.p.setController(this.u);
            this.u.setAutoRelease(false);
        } else {
            if (b.getTag() != null) {
                try {
                    this.g = (List) this.p.getTag();
                } catch (Exception e) {
                    e.printStackTrace();
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
        if (((com.kwad.sdk.feed.widget.base.a) this).c.adConversionInfo.h5Type == 1) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            this.j.setText(((com.kwad.sdk.feed.widget.base.a) this).c.adBaseInfo.adDescription);
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
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091129);
        this.a = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.56f);
        this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091139);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f09114a);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.obfuscated_res_0x7f09115f);
        this.k = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.k.setMinProgress(0);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091131);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f09112f);
        this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f09112e);
        this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f091130);
        this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f09112b);
        this.o = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09112a);
        this.s = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091052);
        this.q = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09112c);
        this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f09112d);
    }

    public boolean d() {
        if (this.v == 101) {
            p();
            return true;
        }
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.z.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.z.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.z.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.z.dispatchNestedScroll(i, i2, i3, i4, iArr);
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
        return R.layout.obfuscated_res_0x7f0d0424;
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

    public void setUIWithStateAndMode(int i) {
        ImageView imageView;
        Resources resources;
        int i2;
        if (i == 101) {
            imageView = this.m;
            resources = getContext().getResources();
            i2 = R.drawable.obfuscated_res_0x7f080cf2;
        } else {
            imageView = this.m;
            resources = getContext().getResources();
            i2 = R.drawable.obfuscated_res_0x7f080cf3;
        }
        imageView.setImageDrawable(resources.getDrawable(i2));
        this.v = i;
    }

    public void setWindowFullScreenListener(a aVar) {
        this.D = aVar;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.z.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.z.stopNestedScroll();
    }
}
