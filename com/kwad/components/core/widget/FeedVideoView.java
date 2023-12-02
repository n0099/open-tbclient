package com.kwad.components.core.widget;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.s.o;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.m.l;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class FeedVideoView extends b<AdResultData, AdTemplate> implements NestedScrollingChild {
    public NestedScrollingChildHelper PG;
    public com.kwad.components.core.video.e PY;
    public ViewGroup abA;
    public TextView abB;
    public ViewGroup abC;
    public ViewGroup abD;
    public int abE;
    public boolean abF;
    public boolean abG;
    public long abH;
    public boolean abI;
    public KsAdVideoPlayConfig abJ;
    public a abK;
    public View abL;
    public boolean abM;
    public Runnable abN;
    public o abO;
    public RatioFrameLayout abo;
    public TextView abp;
    public TextView abq;
    public TextView abr;
    public View abs;
    public KSCornerImageView abt;
    public TextView abu;
    public ScaleAnimSeekBar abv;
    public ImageView abw;
    public ImageView abx;
    public ImageView aby;
    public ViewGroup abz;
    public View.OnClickListener bU;
    public List<Integer> cB;
    public KsAppDownloadListener cx;
    public TextView eB;
    public ImageView eM;
    public com.kwad.sdk.core.video.videoview.a eN;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* loaded from: classes10.dex */
    public interface a {
        void pf();

        void pg();
    }

    @Override // com.kwad.components.core.widget.b
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d04d3;
    }

    public FeedVideoView(@NonNull Context context) {
        super(context);
        this.abE = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.abz.setVisibility(8);
                FeedVideoView.this.aby.setVisibility(8);
                if (FeedVideoView.this.PY != null) {
                    FeedVideoView.this.PY.aN(true);
                }
            }
        };
        this.abN = runnable;
        this.abO = new o(runnable);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void A(View view2) {
        super.A(view2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.PG.setNestedScrollingEnabled(z);
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.bU = onClickListener;
    }

    public void setUIWithStateAndMode(int i) {
        if (i == 101) {
            this.abx.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f17));
        } else {
            this.abx.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f18));
        }
        this.abE = i;
    }

    public void setWindowFullScreenListener(a aVar) {
        this.abK = aVar;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.PG.startNestedScroll(i);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abE = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.abz.setVisibility(8);
                FeedVideoView.this.aby.setVisibility(8);
                if (FeedVideoView.this.PY != null) {
                    FeedVideoView.this.PY.aN(true);
                }
            }
        };
        this.abN = runnable;
        this.abO = new o(runnable);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.PG.dispatchNestedPreFling(f, f2);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abE = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.abz.setVisibility(8);
                FeedVideoView.this.aby.setVisibility(8);
                if (FeedVideoView.this.PY != null) {
                    FeedVideoView.this.PY.aN(true);
                }
            }
        };
        this.abN = runnable;
        this.abO = new o(runnable);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.PG.dispatchNestedFling(f, f2, z);
    }

    private void a(com.kwad.components.core.video.a aVar, final com.kwad.sdk.core.video.videoview.a aVar2) {
        this.abC.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (FeedVideoView.this.abz.getVisibility() == 8) {
                    if (!FeedVideoView.this.eN.isCompleted()) {
                        FeedVideoView.this.abz.setVisibility(0);
                        FeedVideoView.this.aby.setVisibility(0);
                        if (FeedVideoView.this.PY != null) {
                            FeedVideoView.this.PY.aN(false);
                        }
                        if (FeedVideoView.this.getHandler() != null) {
                            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.abN);
                            FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.abO, 5000L);
                        }
                    } else if (FeedVideoView.this.abE == 101) {
                        FeedVideoView.this.abz.setVisibility(0);
                        FeedVideoView.this.aby.setVisibility(8);
                        if (FeedVideoView.this.PY != null) {
                            FeedVideoView.this.PY.aN(false);
                        }
                        if (FeedVideoView.this.getHandler() != null) {
                            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.abN);
                            FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.abO, 5000L);
                        }
                    } else if (FeedVideoView.this.bU != null) {
                        FeedVideoView.this.bU.onClick(view2);
                    }
                } else if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.abN);
                    if (!FeedVideoView.this.abI) {
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.abO, 1000L);
                    }
                }
            }
        });
        aVar.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            public boolean cC = false;

            @Override // com.kwad.components.core.video.a.c
            public final void bl() {
                if (!FeedVideoView.this.abM) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setVideoSoundEnable(!com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setLooping(com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                    }
                }
                if (!this.cC) {
                    this.cC = true;
                    com.kwad.components.core.o.a.pX().b(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                if (!FeedVideoView.this.abM) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setVideoSoundEnable(true ^ com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setLooping(com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                    }
                }
                com.kwad.sdk.core.report.a.bN(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.abp.setText(bl.X(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bm() {
                com.kwad.sdk.core.report.a.bO(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.abz.setVisibility(8);
                FeedVideoView.this.aby.setVisibility(8);
                FeedVideoView.this.abv.setProgress(100);
                FeedVideoView.this.abq.setText(bl.X(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void e(long j) {
                FeedVideoView.this.c(j);
                float duration = (((float) j) * 100.0f) / ((float) aVar2.getDuration());
                if (!FeedVideoView.this.abI) {
                    FeedVideoView.this.abv.setProgress((int) duration);
                    FeedVideoView.this.abq.setText(bl.X(j));
                }
                FeedVideoView.this.abp.setText(bl.X(aVar2.getDuration()));
            }
        });
        this.PY.setAdClickListener(new a.InterfaceC0662a() { // from class: com.kwad.components.core.widget.FeedVideoView.8
            @Override // com.kwad.components.core.video.a.InterfaceC0662a
            public final void a(int i, ac.a aVar3) {
                int i2 = Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID;
                int i3 = 2;
                boolean z = false;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                                i2 = 108;
                            }
                        } else {
                            if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                                i2 = 50;
                            } else {
                                i2 = 83;
                            }
                            i3 = 1;
                            z = true;
                        }
                    } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                        i2 = 82;
                    }
                } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                    i2 = 13;
                }
                y.b bVar = new y.b();
                bVar.km = aVar3;
                bVar.kk = i2;
                com.kwad.components.core.e.d.a.a(new a.C0644a(FeedVideoView.this.getContext()).aq(FeedVideoView.this.mAdTemplate).at(true).b(FeedVideoView.this.mApkDownloadHelper).an(i3).ao(z).aq(true).a(bVar).a(new a.b() { // from class: com.kwad.components.core.widget.FeedVideoView.8.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        FeedVideoView.this.sZ();
                    }
                }));
            }
        });
        this.abv.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.components.core.widget.FeedVideoView.9
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                FeedVideoView.this.abv.bo(false);
                aVar2.seekTo((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.abO);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.abO, 5000L);
                }
                FeedVideoView.this.abI = false;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z) {
                if (z) {
                    FeedVideoView.this.abv.bo(true);
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.abO);
                    FeedVideoView.this.abI = true;
                    FeedVideoView.this.abq.setText(bl.X((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void th() {
                FeedVideoView.this.abv.bo(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.abO);
                FeedVideoView.this.abI = true;
            }
        });
        this.abw.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (!aVar2.isPaused() && !aVar2.isIdle()) {
                    if (aVar2.isPlaying()) {
                        FeedVideoView.this.PY.rx();
                        FeedVideoView.this.aby.setVisibility(0);
                        FeedVideoView.this.aby.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f15));
                        FeedVideoView.this.abw.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f1b));
                    }
                } else {
                    FeedVideoView.this.PY.ry();
                    FeedVideoView.this.abw.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f19));
                    FeedVideoView.this.aby.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f1a));
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.abO);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.abO, 5000L);
                }
            }
        });
        this.aby.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (!FeedVideoView.this.eN.isPaused() && !FeedVideoView.this.eN.isIdle()) {
                    if (FeedVideoView.this.eN.isPlaying()) {
                        FeedVideoView.this.rc();
                    }
                } else {
                    FeedVideoView.this.pP();
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.abO);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.abO, 5000L);
                }
            }
        });
        this.abA.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeedVideoView.this.tf();
            }
        });
        this.abx.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (FeedVideoView.this.abE == 100) {
                    FeedVideoView.this.te();
                } else if (FeedVideoView.this.abE == 101) {
                    FeedVideoView.this.tf();
                }
            }
        });
    }

    public static /* synthetic */ boolean a(FeedVideoView feedVideoView, boolean z) {
        feedVideoView.abM = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.cB;
        if (list != null && !list.isEmpty()) {
            Iterator<Integer> it = this.cB.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                    it.remove();
                    return;
                }
            }
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cx == null) {
            this.cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.widget.FeedVideoView.1
                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    FeedVideoView.this.abr.setText(com.kwad.sdk.core.response.b.a.cR(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    FeedVideoView.this.abr.setText(com.kwad.sdk.core.response.b.a.cQ(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    FeedVideoView.this.abr.setText(com.kwad.sdk.core.response.b.a.aE(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    FeedVideoView.this.abr.setText(com.kwad.sdk.core.response.b.a.bX(FeedVideoView.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    FeedVideoView.this.abr.setText(com.kwad.sdk.core.response.b.a.aE(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    FeedVideoView.this.abr.setText(com.kwad.sdk.core.response.b.a.ac(FeedVideoView.this.mAdInfo));
                }
            };
        }
        return this.cx;
    }

    private boolean td() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = ((elapsedRealtime - this.abH) > 888L ? 1 : ((elapsedRealtime - this.abH) == 888L ? 0 : -1));
        if (i > 0) {
            this.abH = elapsedRealtime;
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aM() {
        super.aM();
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null && !aVar.isPlaying()) {
            pP();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.abO);
                getHandler().postDelayed(this.abO, 5000L);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aN() {
        super.aN();
        if (this.eN != null) {
            rc();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.abO);
                getHandler().postDelayed(this.abO, 5000L);
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.PG.hasNestedScrollingParent();
    }

    public final boolean isComplete() {
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null) {
            return aVar.isCompleted();
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.PG.isNestedScrollingEnabled();
    }

    public final void pL() {
        this.PY.rv();
    }

    public final void release() {
        com.kwad.components.core.video.e eVar = this.PY;
        if (eVar != null) {
            eVar.release();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.PG.stopNestedScroll();
    }

    public final boolean tg() {
        if (this.abE == 101) {
            tf();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void te() {
        boolean z;
        boolean z2;
        a aVar = this.abK;
        if (aVar != null) {
            aVar.pf();
        }
        if (this.abE == 100) {
            z = true;
        } else {
            z = false;
        }
        if (z & td()) {
            this.abA.setVisibility(0);
            this.abB.setText(this.mAdInfo.adBaseInfo.adDescription);
            if (com.kwad.sdk.core.response.b.a.R(this.mAdInfo) > com.kwad.sdk.core.response.b.a.Q(this.mAdInfo)) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.abF = ai.cl(getContext());
            getContext();
            this.abG = ai.Kx();
            if (!z2) {
                ai.cn(getContext());
            } else {
                ai.co(getContext());
            }
            ViewGroup viewGroup = (ViewGroup) this.abC.getParent();
            this.abD = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.abC);
                View view2 = new View(this.abC.getContext());
                this.abL = view2;
                view2.setLayoutParams(new ViewGroup.LayoutParams(this.abC.getWidth(), this.abC.getHeight()));
                viewGroup.addView(this.abL);
            }
            ai.b(getContext(), false);
            Activity m186do = l.m186do(getContext());
            if (m186do != null) {
                ViewGroup viewGroup2 = (ViewGroup) m186do.getWindow().getDecorView();
                this.abC.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z2 && viewGroup2.getWidth() != 0) {
                    this.abo.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.abC, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.PG = new NestedScrollingChildHelper(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f0914e8);
        this.abo = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.eM = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914f8);
        this.eB = (TextView) findViewById(R.id.obfuscated_res_0x7f091506);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.obfuscated_res_0x7f091522);
        this.abv = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.abv.setMinProgress(0);
        this.abr = (TextView) findViewById(R.id.obfuscated_res_0x7f091507);
        this.abs = findViewById(R.id.obfuscated_res_0x7f091509);
        this.abu = (TextView) findViewById(R.id.obfuscated_res_0x7f09150a);
        this.abt = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f091508);
        this.abp = (TextView) findViewById(R.id.obfuscated_res_0x7f0914f1);
        this.abq = (TextView) findViewById(R.id.obfuscated_res_0x7f0914ef);
        this.abw = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914ee);
        this.aby = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914f0);
        this.abx = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914eb);
        this.abz = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914ea);
        this.abC = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09136c);
        this.abA = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914ec);
        this.abB = (TextView) findViewById(R.id.obfuscated_res_0x7f0914ed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf() {
        boolean z;
        if (this.abE == 101) {
            z = true;
        } else {
            z = false;
        }
        if (z & td()) {
            this.abA.setVisibility(8);
            if (this.abF) {
                ai.cl(getContext());
            } else {
                ai.cm(getContext());
            }
            if (this.abG) {
                ai.co(getContext());
            } else {
                ai.cn(getContext());
            }
            ai.b(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.abC.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.abC);
            }
            this.abC.setLayoutParams(new ViewGroup.LayoutParams(this.abD.getWidth(), this.abD.getHeight()));
            this.abo.setRatio(0.5600000023841858d);
            View view2 = this.abL;
            if (view2 != null) {
                this.abD.removeView(view2);
                this.abL = null;
            }
            this.abD.addView(this.abC, new FrameLayout.LayoutParams(-1, -2));
            this.abC.requestLayout();
            setUIWithStateAndMode(100);
        }
        a aVar = this.abK;
        if (aVar != null) {
            aVar.pg();
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
        this.abM = false;
        com.kwad.sdk.core.response.model.b br = com.kwad.sdk.core.response.b.a.br(this.mAdInfo);
        this.abJ = ksAdVideoPlayConfig;
        String url = br.getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate);
            this.eM.setVisibility(0);
        } else {
            this.eM.setVisibility(8);
        }
        this.cB = com.kwad.sdk.core.response.b.a.bm(this.mAdInfo);
        String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
        if (TextUtils.isEmpty(K)) {
            return;
        }
        this.eN = AdVideoPlayerViewCache.getInstance().eb(K);
        if (com.kwad.sdk.core.response.b.a.aq(this.mAdInfo)) {
            this.eB.setVisibility(8);
            View view2 = this.abs;
            if (view2 != null) {
                view2.setVisibility(0);
                this.abr.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
                this.abu.setText(com.kwad.sdk.core.response.b.a.cc(this.mAdInfo));
                KSImageLoader.loadAppIcon(this.abt, com.kwad.sdk.core.response.b.a.cf(this.mAdInfo), this.mAdTemplate, 4);
                com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
                if (cVar2 != null) {
                    cVar2.b(getAppDownloadListener());
                }
                this.abr.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        if (FeedVideoView.this.bU != null) {
                            FeedVideoView.this.bU.onClick(view3);
                        }
                    }
                });
            }
        } else {
            View view3 = this.abs;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            this.eB.setVisibility(0);
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar == null) {
            this.eN = new com.kwad.sdk.core.video.videoview.a(getContext());
            com.kwad.sdk.core.response.b.a.ab(this.mAdInfo);
            this.eN.a(new b.a(this.mAdTemplate).a(this.mAdTemplate.mVideoPlayerStatus).cD(com.kwad.sdk.core.response.b.e.dR(this.mAdTemplate)).cE(com.kwad.sdk.core.response.b.h.b(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).Ah(), null);
            com.kwad.components.core.video.e eVar = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.eN, ksAdVideoPlayConfig);
            this.PY = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.eN.setController(this.PY);
            this.PY.setAutoRelease(false);
            if (com.kwad.sdk.core.config.d.Am() == 2) {
                AdVideoPlayerViewCache.getInstance().a(K, this.eN);
            }
        } else {
            if (aVar.getTag() != null) {
                try {
                    this.cB = (List) this.eN.getTag();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            com.kwad.components.core.video.e eVar2 = (com.kwad.components.core.video.e) this.eN.getController();
            this.PY = eVar2;
            eVar2.setAutoRelease(false);
            this.PY.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.eN.getParent() != null) {
            ((ViewGroup) this.eN.getParent()).removeView(this.eN);
            this.PY.rv();
        }
        if (this.abo.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.abo;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.abo.setTag(null);
        }
        this.abo.addView(this.eN);
        this.abo.setTag(this.eN);
        this.abz.setVisibility(8);
        this.aby.setVisibility(8);
        if (this.mAdInfo.adConversionInfo.h5Type == 1) {
            this.eB.setVisibility(8);
        } else {
            this.eB.setVisibility(0);
            this.eB.setText(this.mAdInfo.adBaseInfo.adDescription);
        }
        a(this.PY, this.eN);
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((FeedVideoView) adResultData);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.PG.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.PG.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public final void pP() {
        this.PY.ry();
        this.PY.setVisibility(0);
        this.PY.setAlpha(1.0f);
        this.abw.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f19));
        this.aby.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f1a));
    }

    public final void rc() {
        this.PY.rx();
        this.aby.setVisibility(0);
        this.aby.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f15));
        this.abw.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f1b));
    }
}
