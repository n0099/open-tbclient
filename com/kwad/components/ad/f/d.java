package com.kwad.components.ad.f;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.f.b;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.core.AbstractKsNativeAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.components.core.internal.api.a {
    public Vibrator eh;
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public bm mTimerHelper;
    public b.c mi;
    public boolean mm;
    @Nullable
    public KsNativeAd.AdInteractionListener mn;
    public f mo;
    public e mp;
    @Nullable
    public KsNativeAd.VideoPlayListener mq;
    public boolean mr = false;
    public com.kwad.components.core.internal.api.c bZ = new com.kwad.components.core.internal.api.c();
    public int ms = 0;
    public int mt = 0;
    public KsNativeAd.VideoPlayListener mu = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.components.ad.f.d.8
        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            if (d.this.mq != null) {
                d.this.mq.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
            if (d.this.mq != null) {
                try {
                    d.this.mq.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
            if (d.this.mq != null) {
                try {
                    d.this.mq.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
            if (d.this.mq != null) {
                try {
                    d.this.mq.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            if (d.this.mq != null) {
                d.this.mq.onVideoPlayStart();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i, int i2) {
            if (d.this.mq != null) {
                d.this.mq.onVideoPlayError(i, i2);
            }
        }
    };
    public a mv = new a() { // from class: com.kwad.components.ad.f.d.9
        @Override // com.kwad.components.ad.f.d.a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (d.this.mn != null) {
                try {
                    return d.this.mn.handleDownloadDialog(onClickListener);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    return false;
                }
            }
            return false;
        }

        @Override // com.kwad.components.ad.f.d.a
        public final void l(View view2) {
            if (d.this.mn != null) {
                d.this.mn.onAdClicked(new FrameLayout(l.dq(view2.getContext())), d.this);
            }
        }

        @Override // com.kwad.components.ad.f.d.a
        public final void eq() {
            if (d.this.mn != null) {
                d.this.mn.onAdShow(d.this);
            }
        }

        @Override // com.kwad.components.ad.f.d.a
        public final void onDownloadTipsDialogDismiss() {
            if (d.this.mn != null) {
                try {
                    d.this.mn.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.components.ad.f.d.a
        public final void onDownloadTipsDialogShow() {
            if (d.this.mn != null) {
                try {
                    d.this.mn.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void eq();

        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        void l(View view2);

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ag() {
        return true;
    }

    public d(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        this.mAdInfo = dP;
        if (com.kwad.sdk.core.response.b.a.aF(dP)) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            this.mApkDownloadHelper.a(new c.a() { // from class: com.kwad.components.ad.f.d.1
                @Override // com.kwad.components.core.e.d.c.a
                public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return d.this.mv.handleDownloadDialog(onClickListener);
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.O(this.mAdInfo), this.mAdTemplate);
    }

    private void a(final ViewGroup viewGroup) {
        if (!this.mm) {
            this.mm = true;
            com.kwad.sdk.commercial.e.c.bz(this.mAdTemplate);
        }
        if (!com.kwad.sdk.core.config.d.Bd() && com.kwad.sdk.core.config.d.Bc() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0673a() { // from class: com.kwad.components.ad.f.d.5
                @Override // com.kwad.components.core.widget.a.InterfaceC0673a
                public final void ac() {
                    com.kwad.components.ad.h.b.eH().a(d.this);
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0673a
                public final void ad() {
                    if (d.this.mAdTemplate.mPvReported && d.this.mr) {
                        com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, d.this.getTimerHelper().LO(), (JSONObject) null);
                        d.this.mr = false;
                    }
                    d.this.getTimerHelper().LO();
                    d.this.bZ.i(d.this);
                    b.ek().a(d.this.mi);
                    com.kwad.components.ad.h.b.eH().b(d.this);
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0673a
                public final void eo() {
                    if (d.this.mAdTemplate.mPvReported && d.this.mr) {
                        com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, d.this.getTimerHelper().LO(), (JSONObject) null);
                        d.this.mr = false;
                        b.ek().a(d.this.mi);
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0673a
                public final void k(View view2) {
                    if (!d.this.mAdTemplate.mPvReported) {
                        d.this.mv.eq();
                        d.this.en();
                        j jVar = new j();
                        jVar.x(viewGroup.getHeight(), viewGroup.getWidth());
                        if (com.kwad.sdk.core.response.b.a.cJ(d.this.mAdInfo)) {
                            y.a aVar2 = new y.a();
                            aVar2.showLiveStyle = d.this.mt;
                            aVar2.showLiveStatus = d.this.ms;
                            jVar.a(aVar2);
                        }
                        com.kwad.components.core.s.b.qL().a(d.this.mAdTemplate, null, jVar);
                    }
                    if (!d.this.mr) {
                        d.this.j(view2);
                        d.this.getTimerHelper().startTiming();
                        d.this.bZ.h(d.this);
                    }
                    d.this.mr = true;
                }
            });
            aVar.sY();
            return;
        }
        com.kwad.components.core.widget.c b = b(viewGroup);
        if (b == null) {
            b = new com.kwad.components.core.widget.c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b);
        }
        b.setViewCallback(new c.a() { // from class: com.kwad.components.ad.f.d.6
            @Override // com.kwad.components.core.widget.c.a
            public final void ep() {
                if (!d.this.mAdTemplate.mPvReported) {
                    d.this.mv.eq();
                }
                d.this.en();
                j jVar = new j();
                jVar.x(viewGroup.getHeight(), viewGroup.getWidth());
                if (com.kwad.sdk.core.response.b.a.cJ(d.this.mAdInfo)) {
                    y.a aVar2 = new y.a();
                    aVar2.showLiveStyle = d.this.mt;
                    aVar2.showLiveStatus = d.this.ms;
                    jVar.a(aVar2);
                }
                com.kwad.components.core.s.b.qL().a(d.this.mAdTemplate, null, jVar);
                com.kwad.sdk.commercial.e.c.bA(d.this.mAdTemplate);
            }
        });
        b.setNeedCheckingShow(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator D(Context context) {
        if (this.eh == null) {
            this.eh = (Vibrator) context.getSystemService("vibrator");
        }
        return this.eh;
    }

    public static com.kwad.components.core.widget.c b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.c) {
                return (com.kwad.components.core.widget.c) childAt;
            }
        }
        return null;
    }

    public static void c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSourceLogoUrl(int i) {
        AdInfo adInfo = this.mAdInfo;
        if (adInfo == null) {
            return null;
        }
        if (i != 1) {
            return adInfo.adBaseInfo.adMarkIcon;
        }
        return adInfo.adBaseInfo.adGrayMarkIcon;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.mv.onDownloadTipsDialogDismiss();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        a aVar = this.mv;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null && ksAppDownloadListener != null) {
            cVar.b(ksAppDownloadListener);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.mq = videoPlayListener;
    }

    public static /* synthetic */ boolean b(d dVar, ac.a aVar) {
        return c(aVar);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, boolean z) {
        if (context != null && KsAdSDKImpl.get().hasInitFinish()) {
            return getVideoView2(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).build());
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        com.kwad.sdk.core.report.a.k(adTemplate, j2);
    }

    private View a(Context context, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
        if (aVar != null && aVar.oA()) {
            if (this.mp == null) {
                e eVar = new e(context);
                this.mp = eVar;
                eVar.setInnerAdInteractionListener(this.mv);
                this.mp.setVideoPlayListener(this.mu);
                this.mp.a(context, this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
            }
            return this.mp;
        }
        return null;
    }

    private View b(Context context, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            com.kwad.sdk.core.e.c.w("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.mo == null) {
            f fVar = new f(context);
            this.mo = fVar;
            fVar.setInnerAdInteractionListener(this.mv);
            this.mo.setVideoPlayListener(this.mu);
            this.mo.a(this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.mo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@Nullable Activity activity, final View view2, final ac.a aVar, int i, boolean z, final int i2) {
        Context context;
        long j;
        IAdLivePlayModule iAdLivePlayModule;
        if (activity == null) {
            context = view2.getContext();
        }
        a.C0644a ao = new a.C0644a(l.wrapContextIfNeed(context)).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(i).ao(true);
        e eVar = this.mp;
        if (eVar != null && (iAdLivePlayModule = eVar.eV) != null) {
            j = iAdLivePlayModule.getPlayDuration();
        } else {
            j = 0;
        }
        com.kwad.components.core.e.d.a.a(ao.v(j).av(z).a(new a.b() { // from class: com.kwad.components.ad.f.d.4
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, new j().d(aVar).cA(i2), (JSONObject) null);
                d.this.mv.l(view2);
            }
        }));
    }

    private void a(final Activity activity, @NonNull final ViewGroup viewGroup, final int i, final View view2, final boolean z) {
        final ac.a aVar = new ac.a();
        if (view2 == null) {
            return;
        }
        view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.f.d.2
            public int[] mx = new int[2];

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        aVar.g(Math.abs(motionEvent.getRawX() - this.mx[0]), Math.abs(motionEvent.getRawY() - this.mx[1]));
                        if (d.this.b(aVar)) {
                            view2.setPressed(false);
                            d.this.a(activity, view3, aVar, i, z, 153);
                        } else if (com.kwad.sdk.core.config.d.Ao()) {
                            if (d.b(d.this, aVar)) {
                                d.this.a(activity, view3, aVar, i, z, 0);
                            }
                            return true;
                        }
                    }
                } else {
                    aVar.B(viewGroup.getWidth(), viewGroup.getHeight());
                    viewGroup.getLocationOnScreen(this.mx);
                    aVar.f(Math.abs(motionEvent.getRawX() - this.mx[0]), Math.abs(motionEvent.getRawY() - this.mx[1]));
                }
                return false;
            }
        });
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.f.d.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                d.this.a(activity, view3, aVar, i, z, 0);
            }
        });
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list) {
        for (View view2 : list) {
            a(activity, viewGroup, 0, view2, false);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        registerViewForInteraction((Activity) null, viewGroup, list, adInteractionListener);
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map) {
        for (View view2 : map.keySet()) {
            if (map.get(view2) != null) {
                a(activity, viewGroup, map.get(view2).intValue(), view2, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final View view2) {
        if (!com.kwad.sdk.core.response.b.a.ai(this.mAdInfo)) {
            return;
        }
        this.mi = new b.c() { // from class: com.kwad.components.ad.f.d.7
            @Override // com.kwad.components.ad.f.b.c
            public final void f(final double d) {
                if (d.this.mAdInfo.status != 3 && d.this.mAdInfo.status != 2) {
                    com.kwad.components.core.e.d.a.a(new a.C0644a(l.wrapContextIfNeed(view2.getContext())).aq(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).av(false).a(new a.b() { // from class: com.kwad.components.ad.f.d.7.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, new j().cA(Cea708Decoder.COMMAND_DF5).l(d), (JSONObject) null);
                            d.this.mv.l(view2);
                        }
                    }));
                    bn.a(view2.getContext(), d.this.D(view2.getContext()));
                }
            }
        };
        b.ek().a(com.kwad.sdk.core.response.b.a.aj(this.mAdInfo), view2, this.mi);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ac.a aVar) {
        boolean z;
        boolean z2;
        if (Math.abs(aVar.Kt() - aVar.Kv()) > 20) {
            z = true;
        } else {
            z = false;
        }
        if (Math.abs(aVar.Ku() - aVar.Kw()) > 20) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((z || z2) && com.kwad.sdk.core.response.b.d.dE(this.mAdTemplate)) {
            return true;
        }
        return false;
    }

    public static boolean c(ac.a aVar) {
        boolean z;
        boolean z2;
        if (Math.abs(aVar.Kt() - aVar.Kv()) < 20) {
            z = true;
        } else {
            z = false;
        }
        if (Math.abs(aVar.Ku() - aVar.Kw()) < 20) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.b(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    /* renamed from: em */
    public com.kwad.components.core.internal.api.d getVideoCoverImage() {
        AdInfo.AdMaterialInfo.MaterialFeature aV = com.kwad.sdk.core.response.b.a.aV(this.mAdInfo);
        if (!TextUtils.isEmpty(aV.coverUrl)) {
            return new com.kwad.components.core.internal.api.d(aV.width, aV.height, aV.coverUrl);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void en() {
        try {
            this.ms = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStatus;
            this.mt = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getActionDescription() {
        return com.kwad.sdk.core.response.b.a.aE(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdDescription() {
        return com.kwad.sdk.core.response.b.a.au(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSource() {
        return com.kwad.sdk.core.response.b.a.aD(this.mAdInfo);
    }

    @Override // com.kwad.components.core.internal.api.a
    @NonNull
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppDownloadCountDes() {
        return com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppIconUrl() {
        return com.kwad.sdk.core.response.b.a.cf(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppName() {
        return com.kwad.sdk.core.response.b.a.av(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPackageName() {
        return com.kwad.sdk.core.response.b.a.ay(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final long getAppPackageSize() {
        return com.kwad.sdk.core.response.b.a.bG(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPrivacyUrl() {
        return com.kwad.sdk.core.response.b.a.bE(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final float getAppScore() {
        return com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppVersion() {
        return com.kwad.sdk.core.response.b.a.bF(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getCorporationName() {
        return com.kwad.sdk.core.response.b.a.bz(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getIntroductionInfo() {
        return com.kwad.sdk.core.response.b.a.bC(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getIntroductionInfoUrl() {
        return com.kwad.sdk.core.response.b.a.bD(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.AO()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfo() {
        return com.kwad.sdk.core.response.b.a.bA(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfoUrl() {
        return com.kwad.sdk.core.response.b.a.bB(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getProductName() {
        return com.kwad.sdk.core.response.b.a.ax(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final Bitmap getSdkLogo() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.obfuscated_res_0x7f080edf);
    }

    public final bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bm();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoDuration() {
        return com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoHeight() {
        if (com.kwad.sdk.core.response.b.a.cJ(this.mAdInfo)) {
            return 1280;
        }
        return com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getVideoUrl() {
        return com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoWidth() {
        if (com.kwad.sdk.core.response.b.a.cJ(this.mAdInfo)) {
            return 720;
        }
        return com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).videoWidth;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayEnd() {
        com.kwad.sdk.core.report.a.bO(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayStart() {
        com.kwad.sdk.core.report.a.bN(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        int be = com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
        if (be == 2 || be == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : dP.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new com.kwad.components.core.internal.api.d(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public final View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl;
        View b;
        View view2 = null;
        if (context == null || !KsAdSDKImpl.get().hasInitFinish()) {
            return null;
        }
        try {
            context = l.wrapContextIfNeed(context);
            com.kwad.sdk.i.a.ai("native", "show");
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            } else {
                kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
            }
            if (com.kwad.sdk.core.response.b.a.cJ(this.mAdInfo)) {
                b = a(context, kSAdVideoPlayConfigImpl);
            } else {
                b = b(context, kSAdVideoPlayConfigImpl);
            }
            view2 = b;
            com.kwad.sdk.i.a.aj("native", "show");
            return view2;
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("getVideoView fail--context:" + context.getClass().getName() + "--classloader:" + context.getClassLoader().getClass().getName());
            if (KsAdSDKImpl.get().getIsExternal()) {
                if (Build.VERSION.SDK_INT >= 19) {
                    runtimeException.addSuppressed(th);
                }
                com.kwad.components.core.d.a.b(runtimeException);
                return view2;
            }
            throw th;
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.mn = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, list);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.mn = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, map);
    }
}
