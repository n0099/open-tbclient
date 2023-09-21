package com.kwad.components.core.widget;

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
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.m.o;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d extends b<AdTemplate> implements NestedScrollingChild {
    public NestedScrollingChildHelper GQ;
    public TextView OR;
    public TextView OS;
    public ScaleAnimSeekBar OT;
    public ImageView OU;
    public ImageView OV;
    public ImageView OW;
    public ViewGroup OX;
    public ViewGroup OY;
    public TextView OZ;
    public ViewGroup Pa;
    public ViewGroup Pb;
    public com.kwad.components.core.video.c Pc;
    public int Pd;
    public boolean Pe;
    public boolean Pf;
    public long Pg;
    public boolean Ph;
    public KsAdVideoPlayConfig Pi;
    public a Pj;
    public View Pk;
    public Runnable Pl;
    public o Pm;
    public View.OnClickListener aP;
    public List<Integer> bv;
    public TextView de;
    public RatioFrameLayout dn;

    /* renamed from: do  reason: not valid java name */
    public ImageView f10do;
    public com.kwad.sdk.core.video.videoview.a dp;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    /* loaded from: classes10.dex */
    public interface a {
        void nL();

        void nM();
    }

    public d(@NonNull Context context) {
        super(context);
        this.Pd = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.this.OX.setVisibility(8);
                d.this.OW.setVisibility(8);
                if (d.this.Pc != null) {
                    d.this.Pc.az(true);
                }
            }
        };
        this.Pl = runnable;
        this.Pm = new o(runnable);
    }

    private void a(com.kwad.components.core.video.a aVar, final com.kwad.sdk.core.video.videoview.a aVar2) {
        this.Pa.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.d.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (d.this.OX.getVisibility() != 8) {
                    if (d.this.getHandler() != null) {
                        d.this.getHandler().removeCallbacks(d.this.Pl);
                        if (d.this.Ph) {
                            return;
                        }
                        d.this.getHandler().postDelayed(d.this.Pm, 1000L);
                    }
                } else if (!d.this.dp.isCompleted()) {
                    d.this.OX.setVisibility(0);
                    d.this.OW.setVisibility(0);
                    if (d.this.Pc != null) {
                        d.this.Pc.az(false);
                    }
                    if (d.this.getHandler() != null) {
                        d.this.getHandler().removeCallbacks(d.this.Pl);
                        d.this.getHandler().postDelayed(d.this.Pm, 5000L);
                    }
                } else if (d.this.Pd != 101) {
                    if (d.this.aP != null) {
                        d.this.aP.onClick(view2);
                    }
                } else {
                    d.this.OX.setVisibility(0);
                    d.this.OW.setVisibility(8);
                    if (d.this.Pc != null) {
                        d.this.Pc.az(false);
                    }
                    if (d.this.getHandler() != null) {
                        d.this.getHandler().removeCallbacks(d.this.Pl);
                        d.this.getHandler().postDelayed(d.this.Pm, 5000L);
                    }
                }
            }
        });
        aVar.setVideoPlayCallback(new a.b() { // from class: com.kwad.components.core.widget.d.3
            public boolean bw = false;

            @Override // com.kwad.components.core.video.a.b
            public final void bm() {
                com.kwad.sdk.core.report.a.ax(d.this.mAdTemplate);
                d.this.OX.setVisibility(8);
                d.this.OW.setVisibility(8);
                d.this.OT.setProgress(100);
                d.this.OS.setText(bc.v(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.b
            public final void d(long j) {
                d.this.c(j);
                float duration = (((float) j) * 100.0f) / ((float) aVar2.getDuration());
                if (!d.this.Ph) {
                    d.this.OT.setProgress((int) duration);
                    d.this.OS.setText(bc.v(j));
                }
                d.this.OR.setText(bc.v(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.report.a.aw(d.this.mAdTemplate);
                d.this.OR.setText(bc.v(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlaying() {
                if (this.bw) {
                    return;
                }
                this.bw = true;
                com.kwad.components.core.j.a.og().a(d.this.mAdTemplate, System.currentTimeMillis(), 1);
            }
        });
        this.Pc.setAdClickListener(new a.InterfaceC0647a() { // from class: com.kwad.components.core.widget.d.4
            @Override // com.kwad.components.core.video.a.InterfaceC0647a
            public final void a(int i, aa.a aVar3) {
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
                u.b bVar = new u.b();
                bVar.gL = aVar3;
                bVar.gJ = i2;
                com.kwad.components.core.c.a.a.a(new a.C0636a(com.kwad.sdk.b.kwai.a.x(d.this.Pa)).L(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).ae(i3).aj(z).al(true).a(bVar).a(new a.b() { // from class: com.kwad.components.core.widget.d.4.1
                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        d.this.dx();
                    }
                }));
            }
        });
        this.OT.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.components.core.widget.d.5
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                d.this.OT.aN(false);
                aVar2.seekTo((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                if (d.this.getHandler() != null) {
                    d.this.getHandler().removeCallbacks(d.this.Pm);
                    d.this.getHandler().postDelayed(d.this.Pm, 5000L);
                }
                d.this.Ph = false;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z) {
                if (z) {
                    d.this.OT.aN(true);
                    d.this.getHandler().removeCallbacks(d.this.Pm);
                    d.this.Ph = true;
                    d.this.OS.setText(bc.v((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void qf() {
                d.this.OT.aN(true);
                d.this.getHandler().removeCallbacks(d.this.Pm);
                d.this.Ph = true;
            }
        });
        this.OU.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.d.6
            /* JADX WARN: Removed duplicated region for block: B:14:0x0097  */
            /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void onClick(View view2) {
                ImageView imageView;
                Resources resources;
                int i;
                if (!aVar2.isPaused() && !aVar2.isIdle()) {
                    if (aVar2.isPlaying()) {
                        d.this.Pc.pc();
                        d.this.OW.setVisibility(0);
                        d.this.OW.setImageDrawable(d.this.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ee4));
                        imageView = d.this.OU;
                        resources = d.this.getContext().getResources();
                        i = R.drawable.obfuscated_res_0x7f080eea;
                    }
                    if (d.this.getHandler() == null) {
                        d.this.getHandler().removeCallbacks(d.this.Pm);
                        d.this.getHandler().postDelayed(d.this.Pm, 5000L);
                        return;
                    }
                    return;
                }
                d.this.Pc.pd();
                d.this.OU.setImageDrawable(d.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ee8));
                imageView = d.this.OW;
                resources = d.this.getResources();
                i = R.drawable.obfuscated_res_0x7f080ee9;
                imageView.setImageDrawable(resources.getDrawable(i));
                if (d.this.getHandler() == null) {
                }
            }
        });
        this.OW.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.d.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (d.this.dp.isPaused() || d.this.dp.isIdle()) {
                    d.this.qa();
                } else if (d.this.dp.isPlaying()) {
                    d.this.oQ();
                }
                if (d.this.getHandler() != null) {
                    d.this.getHandler().removeCallbacks(d.this.Pm);
                    d.this.getHandler().postDelayed(d.this.Pm, 5000L);
                }
            }
        });
        this.OY.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.d.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.this.qd();
            }
        });
        this.OV.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.d.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (d.this.Pd == 100) {
                    d.this.qc();
                } else if (d.this.Pd == 101) {
                    d.this.qd();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.bv;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.bv.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.b(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oQ() {
        this.Pc.pc();
        this.OW.setVisibility(0);
        this.OW.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ee4));
        this.OU.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080eea));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
        this.Pc.pd();
        this.OU.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ee8));
        this.OW.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ee9));
    }

    private boolean qb() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = ((elapsedRealtime - this.Pg) > 888L ? 1 : ((elapsedRealtime - this.Pg) == 888L ? 0 : -1));
        if (i > 0) {
            this.Pg = elapsedRealtime;
        }
        return i > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc() {
        a aVar = this.Pj;
        if (aVar != null) {
            aVar.nL();
        }
        if ((this.Pd == 100) && qb()) {
            this.OY.setVisibility(0);
            this.OZ.setText(this.mAdInfo.adBaseInfo.adDescription);
            boolean z = com.kwad.sdk.core.response.a.a.G(this.mAdInfo) > com.kwad.sdk.core.response.a.a.F(this.mAdInfo);
            this.Pe = ag.cx(getContext());
            this.Pf = ag.cB(getContext());
            Context context = getContext();
            if (z) {
                ag.cA(context);
            } else {
                ag.cz(context);
            }
            ViewGroup viewGroup = (ViewGroup) this.Pa.getParent();
            this.Pb = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.Pa);
                View view2 = new View(this.Pa.getContext());
                this.Pk = view2;
                view2.setLayoutParams(new ViewGroup.LayoutParams(this.Pa.getWidth(), this.Pa.getHeight()));
                viewGroup.addView(this.Pk);
            }
            ag.b(getContext(), false);
            Context x = com.kwad.sdk.b.kwai.a.x(this);
            if (x instanceof Activity) {
                ViewGroup viewGroup2 = (ViewGroup) ((Activity) x).getWindow().getDecorView();
                this.Pa.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z && viewGroup2.getWidth() != 0) {
                    this.dn.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.Pa, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd() {
        if ((this.Pd == 101) & qb()) {
            this.OY.setVisibility(8);
            if (this.Pe) {
                ag.cx(getContext());
            } else {
                ag.cy(getContext());
            }
            if (this.Pf) {
                ag.cA(getContext());
            } else {
                ag.cz(getContext());
            }
            ag.b(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.Pa.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.Pa);
            }
            this.Pa.setLayoutParams(new ViewGroup.LayoutParams(this.Pb.getWidth(), this.Pb.getHeight()));
            this.dn.setRatio(0.56f);
            View view2 = this.Pk;
            if (view2 != null) {
                this.Pb.removeView(view2);
                this.Pk = null;
            }
            this.Pb.addView(this.Pa, new FrameLayout.LayoutParams(-1, -2));
            this.Pa.requestLayout();
            setUIWithStateAndMode(100);
        }
        a aVar = this.Pj;
        if (aVar != null) {
            aVar.nM();
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.c.a.c cVar) {
        this.mApkDownloadHelper = cVar;
        com.kwad.sdk.core.response.model.b aL = com.kwad.sdk.core.response.a.a.aL(this.mAdInfo);
        this.Pi = ksAdVideoPlayConfig;
        String url = aL.getUrl();
        if (TextUtils.isEmpty(url)) {
            this.f10do.setVisibility(8);
        } else {
            this.f10do.setImageDrawable(null);
            KSImageLoader.loadImage(this.f10do, url, this.mAdTemplate);
            this.f10do.setVisibility(0);
        }
        this.bv = com.kwad.sdk.core.response.a.a.aF(this.mAdInfo);
        String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
        if (TextUtils.isEmpty(A)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a cw = AdVideoPlayerViewCache.getInstance().cw(A);
        this.dp = cw;
        if (cw == null) {
            this.dp = new com.kwad.sdk.core.video.videoview.a(getContext());
            com.kwad.sdk.core.response.a.a.O(this.mAdInfo);
            this.dp.a(new b.a(this.mAdTemplate).a(this.mAdTemplate.mVideoPlayerStatus).bk(com.kwad.sdk.core.response.a.d.bS(this.mAdTemplate)).bl(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.bR(this.mAdTemplate))).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).rC(), (Map<String, String>) null);
            this.dp.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            com.kwad.components.core.video.c cVar2 = new com.kwad.components.core.video.c(this.mContext, this.mAdTemplate, this.dp, ksAdVideoPlayConfig);
            this.Pc = cVar2;
            cVar2.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.dp.setController(this.Pc);
            this.Pc.setAutoRelease(false);
        } else {
            if (cw.getTag() != null) {
                try {
                    this.bv = (List) this.dp.getTag();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            com.kwad.components.core.video.c cVar3 = (com.kwad.components.core.video.c) this.dp.getController();
            this.Pc = cVar3;
            cVar3.setAutoRelease(false);
            this.Pc.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.dp.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.dp.getParent() != null) {
            ((ViewGroup) this.dp.getParent()).removeView(this.dp);
        }
        if (this.dn.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.dn;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.dn.setTag(null);
        }
        this.dn.addView(this.dp);
        this.dn.setTag(this.dp);
        this.OX.setVisibility(8);
        this.OW.setVisibility(8);
        if (this.mAdInfo.adConversionInfo.h5Type == 1) {
            this.de.setVisibility(8);
        } else {
            this.de.setVisibility(0);
            this.de.setText(this.mAdInfo.adBaseInfo.adDescription);
        }
        a(this.Pc, this.dp);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.b
    public final void aR() {
        super.aR();
        com.kwad.sdk.core.video.videoview.a aVar = this.dp;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        qa();
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.Pm);
            getHandler().postDelayed(this.Pm, 5000L);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.b
    public final void aS() {
        super.aS();
        if (this.dp != null) {
            oQ();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.Pm);
                getHandler().postDelayed(this.Pm, 5000L);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bg() {
        this.GQ = new NestedScrollingChildHelper(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091429);
        this.dn = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.56f);
        this.f10do = (ImageView) findViewById(R.id.obfuscated_res_0x7f091439);
        this.de = (TextView) findViewById(R.id.obfuscated_res_0x7f091446);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.obfuscated_res_0x7f09145b);
        this.OT = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.OT.setMinProgress(0);
        this.OR = (TextView) findViewById(R.id.obfuscated_res_0x7f091432);
        this.OS = (TextView) findViewById(R.id.obfuscated_res_0x7f091430);
        this.OU = (ImageView) findViewById(R.id.obfuscated_res_0x7f09142f);
        this.OW = (ImageView) findViewById(R.id.obfuscated_res_0x7f091431);
        this.OV = (ImageView) findViewById(R.id.obfuscated_res_0x7f09142c);
        this.OX = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09142b);
        this.Pa = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912cc);
        this.OY = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09142d);
        this.OZ = (TextView) findViewById(R.id.obfuscated_res_0x7f09142e);
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdTemplate adTemplate) {
        super.c((d) adTemplate);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.GQ.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float f, float f2) {
        return this.GQ.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.GQ.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.GQ.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d04b0;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.GQ.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.GQ.isNestedScrollingEnabled();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void k(View view2) {
        super.k(view2);
    }

    public final boolean qe() {
        if (this.Pd == 101) {
            qd();
            return true;
        }
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void setNestedScrollingEnabled(boolean z) {
        this.GQ.setNestedScrollingEnabled(z);
    }

    public final void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.aP = onClickListener;
    }

    public final void setUIWithStateAndMode(int i) {
        ImageView imageView;
        Resources resources;
        int i2;
        if (i == 101) {
            imageView = this.OV;
            resources = getContext().getResources();
            i2 = R.drawable.obfuscated_res_0x7f080ee6;
        } else {
            imageView = this.OV;
            resources = getContext().getResources();
            i2 = R.drawable.obfuscated_res_0x7f080ee7;
        }
        imageView.setImageDrawable(resources.getDrawable(i2));
        this.Pd = i;
    }

    public final void setWindowFullScreenListener(a aVar) {
        this.Pj = aVar;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int i) {
        return this.GQ.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.GQ.stopNestedScroll();
    }
}
