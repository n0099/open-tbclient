package com.kwad.components.ad.interstitial.b;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.baidu.tieba.R;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c extends com.kwad.sdk.mvp.a {
    @NonNull
    public KsAdVideoPlayConfig cN;
    public com.kwad.sdk.core.video.videoview.a dp;
    public KsInterstitialAd.AdInteractionListener fo;
    public Dialog gi;
    public com.kwad.components.ad.interstitial.widget.f gj;
    public boolean gl;
    public boolean gm;
    public boolean gn;
    public a go;
    public com.kwad.components.core.webview.b.d.b gp;
    @NonNull
    public KSFrameLayout gq;
    public d gr;
    public com.kwad.components.ad.interstitial.c.b gt;
    public boolean gw;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public volatile boolean gv = false;
    public int gx = -1;
    public List<a.b> gu = new CopyOnWriteArrayList();
    public List<e> gk = new CopyOnWriteArrayList();
    public List<InterfaceC0557c> gs = new ArrayList();

    /* renamed from: com.kwad.components.ad.interstitial.b.c$4  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass4 implements ImageLoadingListener {
        public final /* synthetic */ View dH;
        public final /* synthetic */ Context gC;

        public AnonymousClass4(Context context, View view2) {
            this.gC = context;
            this.dH = view2;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view2) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view2, final DecodedResult decodedResult) {
            com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.c.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.e.b.d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.e.b.d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = AnonymousClass4.this.gC.getResources().getDimension(R.dimen.obfuscated_res_0x7f070376);
                    final RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(AnonymousClass4.this.gC.getResources(), stackBlur);
                    create.setCornerRadius(dimension);
                    AnonymousClass4.this.dH.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.c.4.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass4.this.dH.setBackground(create);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view2, FailReason failReason) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view2) {
        }
    }

    /* loaded from: classes8.dex */
    public interface a {
        void cy();
    }

    /* loaded from: classes8.dex */
    public static class b {
        public final Context context;
        public int gH;
        public boolean gI;
        public int gJ;
        public boolean gK;
        public aa.a gL;
        public double gM;

        public b(Context context) {
            this.context = context;
        }

        public final b a(aa.a aVar) {
            this.gL = aVar;
            return this;
        }

        public final b b(double d) {
            this.gM = d;
            return this;
        }

        public final int cC() {
            return this.gH;
        }

        public final boolean cD() {
            return this.gI;
        }

        public final boolean cE() {
            return this.gK;
        }

        public final int cF() {
            return this.gJ;
        }

        public final double cG() {
            return this.gM;
        }

        public final Context getContext() {
            return this.context;
        }

        public final aa.a getTouchCoords() {
            return this.gL;
        }

        public final b l(boolean z) {
            this.gI = z;
            return this;
        }

        public final b m(boolean z) {
            this.gK = true;
            return this;
        }

        public final b y(int i) {
            this.gH = i;
            return this;
        }

        public final b z(int i) {
            this.gJ = i;
            return this;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0557c {
        void cH();
    }

    /* loaded from: classes8.dex */
    public interface d {
        void cI();
    }

    /* loaded from: classes8.dex */
    public interface e {
        void onError();
    }

    public static int a(long j, @NonNull AdTemplate adTemplate) {
        if (j == -1) {
            return -1;
        }
        float C = ((float) com.kwad.sdk.core.response.a.a.C(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) / 1000.0f;
        if (C != 0.0f) {
            return Math.round((((float) j) / C) * 100.0f);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, Context context) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new com.kwad.sdk.core.report.f().aM(i).aI(i2).aU(ag.cB(context) ? 2 : 1).uw(), (JSONObject) null);
        if (!this.gn && (adInteractionListener = this.fo) != null) {
            adInteractionListener.onAdClicked();
        }
        this.gl = true;
        if (this.gn) {
            return;
        }
        cy();
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.a.av(adInfo) && !ag.cB(context);
    }

    public static long b(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        return aVar.getCurrentPosition();
    }

    public static int c(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1;
        }
        long duration = aVar.getDuration();
        long currentPosition = aVar.getCurrentPosition();
        if (duration != 0) {
            return Math.round((((float) currentPosition) / ((float) duration)) * 100.0f);
        }
        return -1;
    }

    public final boolean K(Context context) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null || context == null) {
            com.kwad.sdk.core.e.b.w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
            return false;
        }
        return com.kwad.sdk.core.response.a.a.aY(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
    }

    public final void a(final Context context, final int i, int i2, int i3) {
        com.kwad.components.core.c.a.a.a(new a.C0593a(context).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(false).ae(2).a(new a.b() { // from class: com.kwad.components.ad.interstitial.b.c.3
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                c.this.a(r2, i, context);
            }
        }));
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, @Nullable View view2) {
        if (view2 == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.a.a.aL(adInfo).getUrl();
        if (ax.dT(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass4(context, view2));
    }

    public final void a(final b bVar) {
        boolean z = bVar.cC() == 1;
        if ((com.kwad.components.ad.interstitial.kwai.b.cl() || z || bVar.cE()) && com.kwad.components.core.c.a.a.a(new a.C0593a(bVar.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(z).ae(bVar.cC()).a(new a.b() { // from class: com.kwad.components.ad.interstitial.b.c.1
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                c.this.b(bVar);
            }
        })) == 0 && this.gi != null && com.kwad.components.ad.interstitial.kwai.b.co()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.gi.dismiss();
                }
            }, 500L);
        }
    }

    public final void a(e eVar) {
        this.gk.add(eVar);
    }

    public final void a(a.b bVar) {
        if (this.gu.contains(bVar)) {
            return;
        }
        this.gu.add(bVar);
    }

    public final void a(boolean z, int i, @Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        long j;
        int a2;
        if (aVar != null) {
            j = b(aVar);
            a2 = c(aVar);
        } else {
            j = i;
            a2 = a(j, this.mAdTemplate);
        }
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, z ? 14 : 1, j, a2, null);
    }

    public final void b(Context context, AdTemplate adTemplate) {
        if (this.gv) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.gv = true;
    }

    public final void b(b bVar) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.report.f fVar = new com.kwad.sdk.core.report.f();
        fVar.b(bVar.getTouchCoords());
        if (!bVar.cD() && !bVar.gK) {
            bVar.z(153);
        }
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new com.kwad.sdk.core.report.f().aI(bVar.cF()).b(bVar.getTouchCoords()).aU(ag.cB(bVar.context) ? 2 : 1).e(bVar.cG()), (JSONObject) null);
        com.kwad.sdk.core.video.videoview.a aVar = this.dp;
        if (aVar != null) {
            long b2 = b(aVar);
            int c = c(this.dp);
            fVar.F(b2);
            fVar.aN(c);
        }
        if (!this.gn && (adInteractionListener = this.fo) != null) {
            adInteractionListener.onAdClicked();
        }
        this.gl = true;
        if (this.gn) {
            return;
        }
        cy();
    }

    public final void b(a.b bVar) {
        this.gu.remove(bVar);
    }

    public final void cA() {
        for (InterfaceC0557c interfaceC0557c : this.gs) {
            interfaceC0557c.cH();
        }
    }

    public final boolean cB() {
        com.kwad.components.ad.interstitial.widget.f fVar = this.gj;
        boolean z = fVar == null || fVar.getParent() == null;
        com.kwad.sdk.core.e.b.d("InterstitialCallerContext", "isH5Interstitial :" + z);
        return z;
    }

    public final void cx() {
        List<e> list = this.gk;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (e eVar : this.gk) {
            if (eVar != null) {
                eVar.onError();
            }
        }
    }

    public final void cy() {
        a aVar = this.go;
        if (aVar != null) {
            aVar.cy();
        }
    }

    public final void cz() {
        d dVar = this.gr;
        if (dVar != null) {
            dVar.cI();
        }
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.gu.clear();
        this.gk.clear();
        this.gs.clear();
        com.kwad.components.ad.interstitial.c.b bVar = this.gt;
        if (bVar != null) {
            bVar.qj();
        }
    }
}
