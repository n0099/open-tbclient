package com.kwad.sdk.d.kwai;

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
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.z;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.core.e.b {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f56659b;

    /* renamed from: c  reason: collision with root package name */
    public Dialog f56660c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56661d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.d.a.b f56662e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56663f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public KsAdVideoPlayConfig f56664g;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f56666i;
    public a k;
    public b l;
    public Handler m = new Handler(Looper.getMainLooper());

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f56667j = false;

    /* renamed from: h  reason: collision with root package name */
    public List<a.b> f56665h = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        this.m.removeCallbacksAndMessages(null);
        this.f56665h.clear();
    }

    public void a(final Context context, AdInfo adInfo, AdTemplate adTemplate, @Nullable final View view) {
        if (view == null) {
            return;
        }
        String a2 = com.kwad.sdk.core.response.a.a.aa(adInfo).a();
        if (at.a(a2)) {
            return;
        }
        KSImageLoader.loadImage(a2, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new ImageLoadingListener() { // from class: com.kwad.sdk.d.kwai.c.3
            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                return false;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingCancelled(String str, View view2) {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                Bitmap bitmap = decodedResult.mBitmap;
                com.kwad.sdk.core.d.a.a("InterstitialCallerContext", "onLoadingComplete before blur");
                Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                com.kwad.sdk.core.d.a.a("InterstitialCallerContext", "onLoadingComplete after blur");
                float dimension = context.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(context.getResources(), stackBlur);
                create.setCornerRadius(dimension);
                view.setBackground(create);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view2, FailReason failReason) {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view2) {
            }
        });
    }

    public void a(Context context, AdTemplate adTemplate) {
        if (this.f56667j) {
            return;
        }
        com.kwad.sdk.core.page.a.a(context, adTemplate);
        this.f56667j = true;
    }

    public void a(View view, boolean z, int i2, final boolean z2) {
        if ((com.kwad.sdk.core.config.b.ak() || z) && com.kwad.sdk.core.download.a.a.a(new a.C2106a(bb.a(view)).a(this.a).a(this.f56661d).a(z).a(i2).a(new a.b() { // from class: com.kwad.sdk.d.kwai.c.1
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                c.this.a(z2);
            }
        })) == 0 && this.f56660c != null && com.kwad.sdk.core.config.b.aC()) {
            this.m.postDelayed(new Runnable() { // from class: com.kwad.sdk.d.kwai.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f56660c.dismiss();
                }
            }, 500L);
        }
    }

    public void a(a.b bVar) {
        if (this.f56665h.contains(bVar)) {
            return;
        }
        this.f56665h.add(bVar);
    }

    public void a(a aVar) {
        this.k = aVar;
    }

    public void a(b bVar) {
        this.l = bVar;
    }

    public void a(boolean z) {
        if (z) {
            com.kwad.sdk.core.report.a.a(this.a, (z.a) null);
        } else {
            com.kwad.sdk.core.report.a.a(this.a, 153, (z.a) null);
        }
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.f56659b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, @Nullable com.kwad.sdk.core.video.videoview.b bVar) {
        long j2;
        long j3;
        int i2;
        if (bVar != null) {
            long duration = bVar.getDuration();
            j2 = bVar.getCurrentPosition();
            if (duration != 0) {
                i2 = Math.round((((float) j2) / ((float) duration)) * 100.0f);
                j3 = j2;
                com.kwad.sdk.core.report.a.a(this.a, !z ? 14 : 1, j3, i2, (JSONObject) null);
            }
        } else {
            j2 = -1;
        }
        j3 = j2;
        i2 = -1;
        com.kwad.sdk.core.report.a.a(this.a, !z ? 14 : 1, j3, i2, (JSONObject) null);
    }

    public boolean a(Context context) {
        AdTemplate adTemplate = this.a;
        if (adTemplate == null || context == null) {
            com.kwad.sdk.core.d.a.d("InterstitialCallerContext", "isPlayable illegal params: " + this.a + ", context: " + context);
            return false;
        }
        return com.kwad.sdk.core.response.a.a.an(com.kwad.sdk.core.response.a.d.j(adTemplate));
    }

    public boolean a(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.a.K(adInfo) && !af.e(context);
    }

    public void b() {
        a aVar = this.k;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void b(a.b bVar) {
        this.f56665h.remove(bVar);
    }

    public void c() {
        b bVar = this.l;
        if (bVar != null) {
            bVar.a();
        }
    }

    public boolean d() {
        com.kwad.sdk.d.a.b bVar = this.f56662e;
        boolean z = bVar == null || bVar.getParent() == null;
        com.kwad.sdk.core.d.a.a("InterstitialCallerContext", "isH5Interstitial :" + z);
        return z;
    }
}
