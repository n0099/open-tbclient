package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class c extends a implements View.OnClickListener {
    public KsLogoView bq;
    public List<Integer> bv;
    public volatile boolean bw;
    public com.kwad.sdk.widget.j bx;
    public TextView cE;
    public ImageView cw;
    public TextView cx;
    public TextView de;
    public ImageView dg;
    public TextView dh;
    public TextView di;
    public View dj;
    public DownloadProgressView dk;
    public RatioFrameLayout dn;

    /* renamed from: do  reason: not valid java name */
    public ImageView f4do;
    public com.kwad.sdk.core.video.videoview.a dp;
    public com.kwad.components.core.video.c dq;
    public d dr;
    public boolean ds;
    public boolean dt;
    public final a.InterfaceC0621a du;
    public h.a dv;
    public a.b dw;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    public c(@NonNull Context context) {
        super(context);
        this.ds = false;
        this.bw = false;
        this.bx = new com.kwad.sdk.widget.j() { // from class: com.kwad.components.ad.feed.a.c.1
            @Override // com.kwad.sdk.widget.j
            public final void av() {
                com.kwad.sdk.utils.k.cj(c.this.mAdTemplate);
            }
        };
        this.du = new a.InterfaceC0621a() { // from class: com.kwad.components.ad.feed.a.c.2
            @Override // com.kwad.components.core.video.a.InterfaceC0621a
            public final void a(int i, aa.a aVar) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i == 1) {
                    i2 = 15;
                } else if (i == 2) {
                    i2 = 16;
                } else if (i != 3) {
                    i2 = 35;
                } else {
                    i2 = 39;
                    i3 = 1;
                    z = true;
                }
                u.b bVar = new u.b();
                bVar.gL = aVar;
                bVar.gJ = i2;
                com.kwad.components.core.c.a.a.a(new a.C0610a(com.kwad.sdk.b.kwai.a.x(c.this.dp)).L(c.this.mAdTemplate).b(c.this.mApkDownloadHelper).ae(i3).aj(z).al(true).an(true).a(bVar).a(new a.b() { // from class: com.kwad.components.ad.feed.a.c.2.1
                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        c.this.dx();
                    }
                }));
            }
        };
        this.dv = new h.a() { // from class: com.kwad.components.ad.feed.a.c.4
            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                c.a(c.this, false);
                if (c.this.dp != null) {
                    c.this.dp.setVideoSoundEnable(false);
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
            }
        };
        this.dw = new a.b() { // from class: com.kwad.components.ad.feed.a.c.6
            @Override // com.kwad.components.core.video.a.b
            public final void bm() {
                if (com.kwad.components.ad.feed.kwai.b.bc() && c.this.dr == null) {
                    c.this.dr = new d(c.this.getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    c cVar = c.this;
                    cVar.addView(cVar.dr, layoutParams);
                    c.this.dr.bn();
                }
                com.kwad.sdk.core.report.a.ax(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void d(long j) {
                c.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayStart() {
                if (c.this.dr != null && (c.this.dr.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) c.this.dr.getParent()).removeView(c.this.dr);
                    c.this.dr.bo();
                    c.this.dr = null;
                }
                com.kwad.sdk.core.report.a.aw(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlaying() {
                com.kwad.sdk.core.video.videoview.a aVar = c.this.dp;
                c cVar = c.this;
                aVar.setVideoSoundEnable(cVar.h(cVar.ds));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
        if (r7 == r4.dp) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.kwad.sdk.core.video.videoview.a aVar, boolean z, View view2) {
        if (aVar != null) {
            String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
            this.dq.setAutoRelease(false);
            int i = z ? 1 : 2;
            AdVideoPlayerViewCache.getInstance().a(A, this.dp);
            final int i2 = 35;
            if (view2 == this.de) {
                i2 = 25;
            } else {
                if (view2 != this.dn) {
                    if (view2 == this.dk || view2 == this.cE || view2 == this.dj) {
                        i2 = 1;
                    } else if (view2 == this.cw) {
                        i2 = 13;
                    } else if (view2 == this.cx) {
                        i2 = 14;
                    } else if (view2 == this.dh || view2 == this.di) {
                        i2 = 101;
                    }
                }
                i2 = 100;
            }
            com.kwad.components.core.c.a.a.a(new a.C0610a(com.kwad.sdk.b.kwai.a.x(this)).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(z).ae(i).an(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.c.5
                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    c.this.aq(i2);
                }
            }));
        }
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.dt = false;
        return false;
    }

    private void bh() {
        findViewById(R.id.obfuscated_res_0x7f091203).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f091202).setVisibility(8);
        this.di = (TextView) findViewById(R.id.obfuscated_res_0x7f091270);
        this.cE = (TextView) findViewById(R.id.obfuscated_res_0x7f091272);
        this.dj = findViewById(R.id.obfuscated_res_0x7f091273);
        this.di.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
        this.cE.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
        this.dj.setOnClickListener(this);
        this.di.setOnClickListener(this);
        this.cE.setOnClickListener(this);
    }

    private void bi() {
        findViewById(R.id.obfuscated_res_0x7f091202).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f091203).setVisibility(8);
        this.cw = (ImageView) findViewById(R.id.obfuscated_res_0x7f091219);
        this.cx = (TextView) findViewById(R.id.obfuscated_res_0x7f09121d);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091215);
        this.dh = textView;
        com.kwad.sdk.b.kwai.a.a(this, this.cw, this.cx, textView);
        this.cx.setText(com.kwad.sdk.core.response.a.a.ae(this.mAdInfo));
        this.cw.setImageResource(R.drawable.obfuscated_res_0x7f080dd5);
        KSImageLoader.loadAppIcon(this.cw, com.kwad.sdk.core.response.a.a.bn(this.mAdInfo), this.mAdTemplate, 8);
        this.dh.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
        bf();
        this.dk.F(this.mAdTemplate);
        this.dk.setOnClickListener(this);
        com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate, null, this.dk.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.dk.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        g(true);
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
    public boolean h(boolean z) {
        if (z) {
            if (!com.kwad.sdk.core.config.d.fY()) {
                return !com.kwad.components.core.m.b.at(this.mContext).ow() ? com.kwad.components.core.m.b.at(this.mContext).ay(false) : !com.kwad.components.core.m.b.at(this.mContext).ov();
            }
            if (!this.dt) {
                this.dt = com.kwad.components.core.m.b.at(this.mContext).ay(true);
            }
            return this.dt;
        }
        return false;
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i;
        this.ds = (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) ? com.kwad.sdk.core.response.a.a.bh(this.mAdInfo) : ksAdVideoPlayConfig.isVideoSoundEnable();
        String url = com.kwad.sdk.core.response.a.a.aL(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            imageView = this.f4do;
            i = 8;
        } else {
            this.f4do.setImageDrawable(null);
            KSImageLoader.loadImage(this.f4do, url, this.mAdTemplate);
            imageView = this.f4do;
            i = 0;
        }
        imageView.setVisibility(i);
        this.bv = com.kwad.sdk.core.response.a.a.aF(this.mAdInfo);
        com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        this.dp = aVar;
        aVar.setVisibleListener(this.bx);
        this.dp.setOnClickListener(this);
        this.dp.setTag(this.bv);
        String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
        if (TextUtils.isEmpty(A)) {
            return;
        }
        this.dp.a(new b.a(this.mAdTemplate).bk(A).bl(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.bR(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate)).rC(), (Map<String, String>) null);
        this.dp.setVideoSoundEnable(h(this.ds));
        com.kwad.components.core.video.c cVar = new com.kwad.components.core.video.c(this.mContext, this.mAdTemplate, this.dp, ksAdVideoPlayConfig);
        this.dq = cVar;
        cVar.setAdClickListener(this.du);
        this.dq.setVideoPlayCallback(this.dw);
        this.dp.setController(this.dq);
        if (this.dn.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.dn;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.dn.setTag(null);
        }
        this.dn.addView(this.dp);
        this.dn.setTag(this.dp);
        this.dn.setClickable(true);
        this.dn.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.feed.a.c.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (!c.this.dp.isIdle()) {
                    c cVar2 = c.this;
                    cVar2.a(cVar2.dp, false, view2);
                    return;
                }
                com.kwad.sdk.utils.k.ci(c.this.mAdTemplate);
                c.this.dp.setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a.al(c.this.mAdTemplate));
                c.this.dp.start();
            }
        });
        if (this.ds) {
            com.kwad.components.core.m.b.at(this.mContext).a(this.dv);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.b
    public final void aR() {
        super.aR();
        com.kwad.components.core.video.c cVar = this.dq;
        if (cVar != null) {
            cVar.setVideoPlayCallback(this.dw);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void am() {
        super.am();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void an() {
        super.an();
        com.kwad.sdk.utils.k.ch(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bg() {
        this.de = (TextView) findViewById(R.id.obfuscated_res_0x7f0911fe);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f0913c9);
        this.dn = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.56f);
        this.dg = (ImageView) findViewById(R.id.obfuscated_res_0x7f091200);
        this.f4do = (ImageView) findViewById(R.id.obfuscated_res_0x7f0913d9);
        this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091201);
        this.dk = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091217);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bj() {
        super.bj();
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.dk.getAppDownloadListener());
        }
        if (this.ds) {
            com.kwad.components.core.m.b.at(this.mContext).b(this.dv);
        }
        g(false);
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdTemplate adTemplate) {
        super.c((c) adTemplate);
        this.de.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
        this.bq.T(adTemplate);
        if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
            bi();
        } else {
            bh();
        }
        this.de.setOnClickListener(this);
        this.dn.setOnClickListener(this);
        this.dg.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.feed.a.a
    public com.kwad.components.core.c.a.c getApkDownloadHelper() {
        return this.mApkDownloadHelper;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.dg) {
            pX();
            return;
        }
        g(false);
        a(this.dp, view2 == this.dk, view2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.a aVar;
        super.onWindowFocusChanged(z);
        if (!z || (aVar = this.dp) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) aVar.getParent();
        if (this.dp.getParent() != this.dn) {
            viewGroup.removeView(this.dp);
            if (this.dn.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.dn;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.dn.setTag(null);
            }
            this.dn.addView(this.dp);
            this.dn.setTag(this.dp);
            String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
            this.dp.setVideoSoundEnable(this.ds);
            this.dq.setAdClickListener(this.du);
            this.dq.getAdTemplate().mAdWebVideoPageShowing = false;
            this.dq.pe();
            this.dq.setAutoRelease(true);
            AdVideoPlayerViewCache.getInstance().remove(A);
        }
    }
}
