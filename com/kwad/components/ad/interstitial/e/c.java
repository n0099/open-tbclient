package com.kwad.components.ad.interstitial.e;

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
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c extends com.kwad.sdk.mvp.a {
    @NonNull
    public KsAdVideoPlayConfig dU;
    public com.kwad.sdk.core.video.videoview.a eN;
    public com.kwad.components.ad.interstitial.f.b ib;
    public KsInterstitialAd.AdInteractionListener ie;
    public com.kwad.components.ad.interstitial.d io;
    public com.kwad.components.ad.interstitial.g.d jL;
    public boolean jM;
    public boolean jN;
    public boolean jO;
    public a jP;
    public com.kwad.components.core.webview.tachikoma.e.e jR;
    @NonNull
    public KSFrameLayout jS;
    public d jT;
    public boolean jX;
    public AdResultData mAdResultData;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public List<a> jQ = new CopyOnWriteArrayList();
    public Handler fS = new Handler(Looper.getMainLooper());
    public volatile boolean jW = false;
    public int jY = -1;
    public List<a.c> jV = new CopyOnWriteArrayList();
    public List<InterfaceC0601c> jU = new ArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void b(long j, long j2);
    }

    /* renamed from: com.kwad.components.ad.interstitial.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0601c {
        void cZ();
    }

    /* loaded from: classes10.dex */
    public interface d {
        void da();
    }

    /* renamed from: com.kwad.components.ad.interstitial.e.c$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass3 implements ImageLoadingListener {
        public final /* synthetic */ View fo;
        public final /* synthetic */ Context gq;

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view2) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view2, FailReason failReason) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view2) {
        }

        public AnonymousClass3(Context context, View view2) {
            this.gq = context;
            this.fo = view2;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view2, final DecodedResult decodedResult) {
            com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.c.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.e.c.d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.e.c.d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = AnonymousClass3.this.gq.getResources().getDimension(R.dimen.obfuscated_res_0x7f0704d2);
                    final RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(AnonymousClass3.this.gq.getResources(), stackBlur);
                    create.setCornerRadius(dimension);
                    AnonymousClass3.this.fo.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.c.3.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass3.this.fo.setBackground(create);
                        }
                    });
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public final Context context;
        public int ki;
        public boolean kj;
        public int kk;
        public boolean kl;
        public ac.a km;
        public double kn;
        public boolean ko;

        public b(Context context) {
            this.context = context;
        }

        public final b A(int i) {
            this.kk = i;
            return this;
        }

        public final b a(ac.a aVar) {
            this.km = aVar;
            return this;
        }

        public final b k(boolean z) {
            this.kj = z;
            return this;
        }

        public final b l(boolean z) {
            this.kl = true;
            return this;
        }

        public final b m(boolean z) {
            this.ko = true;
            return this;
        }

        public final b z(int i) {
            this.ki = i;
            return this;
        }

        public final b c(double d) {
            this.kn = d;
            return this;
        }

        public final int cU() {
            return this.ki;
        }

        public final boolean cV() {
            return this.kj;
        }

        public final boolean cW() {
            return this.kl;
        }

        public final int cX() {
            return this.kk;
        }

        public final double cY() {
            return this.kn;
        }

        public final Context getContext() {
            return this.context;
        }

        public final ac.a getTouchCoords() {
            return this.km;
        }
    }

    public final void cR() {
        d dVar = this.jT;
        if (dVar != null) {
            dVar.da();
        }
    }

    public final void cS() {
        for (InterfaceC0601c interfaceC0601c : this.jU) {
            interfaceC0601c.cZ();
        }
    }

    public final boolean cT() {
        boolean z;
        com.kwad.components.ad.interstitial.g.d dVar = this.jL;
        if (dVar != null && dVar.getParent() != null) {
            z = false;
        } else {
            z = true;
        }
        com.kwad.sdk.core.e.c.d("InterstitialCallerContext", "isH5Interstitial :" + z);
        return z;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.fS.removeCallbacksAndMessages(null);
        this.jV.clear();
        this.jU.clear();
        com.kwad.components.ad.interstitial.f.b bVar = this.ib;
        if (bVar != null) {
            bVar.tn();
        }
    }

    public static int a(long j, @NonNull AdTemplate adTemplate) {
        if (j == -1) {
            return -1;
        }
        float M = ((float) com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.dP(adTemplate))) / 1000.0f;
        if (M == 0.0f) {
            return -1;
        }
        return Math.round((((float) j) / M) * 100.0f);
    }

    public final void b(long j, long j2) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        for (a aVar : this.jQ) {
            aVar.b(j, j2);
        }
        a aVar2 = this.jP;
        if (aVar2 != null) {
            aVar2.b(j, j2);
        }
        if (!this.jO && (adInteractionListener = this.ie) != null) {
            adInteractionListener.onAdClicked();
        }
    }

    public static long a(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        return aVar.getCurrentPosition();
    }

    public static int b(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1;
        }
        long duration = aVar.getDuration();
        long currentPosition = aVar.getCurrentPosition();
        if (duration == 0) {
            return -1;
        }
        return Math.round((((float) currentPosition) / ((float) duration)) * 100.0f);
    }

    public final boolean K(Context context) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null && context != null) {
            return com.kwad.sdk.core.response.b.a.bH(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        }
        com.kwad.sdk.core.e.c.w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
        return false;
    }

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.m(adResultData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, Context context, long j, long j2) {
        int i3;
        AdTemplate adTemplate = this.mAdTemplate;
        j cA = new j().cH(i).cA(i2);
        if (ai.Kx()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        com.kwad.sdk.core.report.a.a(adTemplate, cA.cO(i3).Dz(), (JSONObject) null);
        this.jM = true;
        if (!this.jO) {
            b(j, j2);
        }
    }

    public static boolean a(Context context, AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.aW(adInfo) && !ai.Kx()) {
            return true;
        }
        return false;
    }

    public final void b(Context context, AdTemplate adTemplate) {
        if (this.jW) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.jW = true;
    }

    public final void a(final Context context, final int i, int i2, int i3) {
        com.kwad.components.ad.interstitial.report.a.dM().a(this.mAdTemplate, 6L, i);
        com.kwad.components.core.e.d.a.a(new a.C0644a(context).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).an(2).al(6).am(i).a(new a.b() { // from class: com.kwad.components.ad.interstitial.e.c.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c cVar = c.this;
                int i4 = r2;
                int i5 = i;
                cVar.a(i4, i5, context, 6L, i5);
            }
        }));
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, @Nullable View view2) {
        if (view2 == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.b.a.br(adInfo).getUrl();
        if (bg.isNullString(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass3(context, view2));
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.jQ.add(aVar);
    }

    public final void b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.jQ.remove(aVar);
    }

    public final void a(final b bVar) {
        boolean z;
        com.kwad.components.ad.interstitial.report.a.dM().a(this.mAdTemplate, 1L, bVar.kk);
        if (bVar.cU() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (com.kwad.components.ad.interstitial.b.b.cH() || z || bVar.cW() || bVar.ko) {
            com.kwad.components.core.e.d.a.a(new a.C0644a(bVar.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(z).al(1).am(bVar.kk).an(bVar.cU()).a(new a.b() { // from class: com.kwad.components.ad.interstitial.e.c.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.b(bVar);
                    if (c.this.io != null && com.kwad.components.ad.interstitial.b.b.cK()) {
                        c cVar = c.this;
                        cVar.a(false, -1, cVar.eN);
                        c.this.fS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.c.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                c.this.io.dismiss();
                            }
                        }, 500L);
                    }
                }
            }));
        }
    }

    public final void b(b bVar) {
        int i;
        j jVar = new j();
        jVar.d(bVar.getTouchCoords());
        if (!bVar.cV() && !bVar.kl) {
            bVar.A(153);
        }
        j d2 = new j().cA(bVar.cX()).d(bVar.getTouchCoords());
        if (ai.Kx()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, d2.cO(i).l(bVar.cY()), (JSONObject) null);
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null) {
            long a2 = a(aVar);
            int b2 = b(this.eN);
            jVar.ai(a2);
            jVar.cI(b2);
        }
        this.jM = true;
        if (!this.jO) {
            b(1L, bVar.kk);
        }
    }

    public final void a(a.c cVar) {
        if (!this.jV.contains(cVar)) {
            this.jV.add(cVar);
        }
    }

    public final void b(a.c cVar) {
        this.jV.remove(cVar);
    }

    public final void a(boolean z, int i, @Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        long j;
        int a2;
        int i2;
        com.kwad.components.ad.interstitial.report.a.dM().l(this.mAdTemplate);
        if (aVar != null) {
            j = a(aVar);
            a2 = b(aVar);
        } else {
            j = i;
            a2 = a(j, this.mAdTemplate);
        }
        int i3 = a2;
        long j2 = j;
        if (z) {
            i2 = 14;
        } else {
            i2 = 1;
        }
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i2, j2, i3, this.io.getTimerHelper().getTime(), null);
    }
}
