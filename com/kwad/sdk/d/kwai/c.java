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
import com.baidu.tieba.R;
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
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.core.e.b {
    public AdTemplate a;
    public KsInterstitialAd.AdInteractionListener b;
    public Dialog c;
    public com.kwad.sdk.core.download.a.b d;
    public com.kwad.sdk.d.a.b e;
    public boolean f;
    @NonNull
    public KsAdVideoPlayConfig g;
    public com.kwad.sdk.core.video.videoview.b i;
    public a k;
    public b l;
    public Handler m = new Handler(Looper.getMainLooper());
    public volatile boolean j = false;
    public List<a.b> h = new CopyOnWriteArrayList();

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        this.m.removeCallbacksAndMessages(null);
        this.h.clear();
    }

    public void a(final Context context, AdInfo adInfo, AdTemplate adTemplate, @Nullable final View view2) {
        if (view2 == null) {
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
            public void onLoadingCancelled(String str, View view3) {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view3, DecodedResult decodedResult) {
                Bitmap bitmap = decodedResult.mBitmap;
                com.kwad.sdk.core.d.a.a("InterstitialCallerContext", "onLoadingComplete before blur");
                Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                com.kwad.sdk.core.d.a.a("InterstitialCallerContext", "onLoadingComplete after blur");
                float dimension = context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070369);
                RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(context.getResources(), stackBlur);
                create.setCornerRadius(dimension);
                view2.setBackground(create);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view3, FailReason failReason) {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view3) {
            }
        });
    }

    public void a(Context context, AdTemplate adTemplate) {
        if (this.j) {
            return;
        }
        com.kwad.sdk.core.page.a.a(context, adTemplate);
        this.j = true;
    }

    public void a(View view2, boolean z, int i, final boolean z2) {
        if ((com.kwad.sdk.core.config.b.ak() || z) && com.kwad.sdk.core.download.a.a.a(new a.C0296a(bb.a(view2)).a(this.a).a(this.d).a(z).a(i).a(new a.b() { // from class: com.kwad.sdk.d.kwai.c.1
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                c.this.a(z2);
            }
        })) == 0 && this.c != null && com.kwad.sdk.core.config.b.aC()) {
            this.m.postDelayed(new Runnable() { // from class: com.kwad.sdk.d.kwai.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.c.dismiss();
                }
            }, 500L);
        }
    }

    public void a(a.b bVar) {
        if (this.h.contains(bVar)) {
            return;
        }
        this.h.add(bVar);
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
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.b;
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
        long j;
        long j2;
        int i;
        if (bVar != null) {
            long duration = bVar.getDuration();
            j = bVar.getCurrentPosition();
            if (duration != 0) {
                i = Math.round((((float) j) / ((float) duration)) * 100.0f);
                j2 = j;
                com.kwad.sdk.core.report.a.a(this.a, !z ? 14 : 1, j2, i, (JSONObject) null);
            }
        } else {
            j = -1;
        }
        j2 = j;
        i = -1;
        com.kwad.sdk.core.report.a.a(this.a, !z ? 14 : 1, j2, i, (JSONObject) null);
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
        this.h.remove(bVar);
    }

    public void c() {
        b bVar = this.l;
        if (bVar != null) {
            bVar.a();
        }
    }

    public boolean d() {
        com.kwad.sdk.d.a.b bVar = this.e;
        boolean z = bVar == null || bVar.getParent() == null;
        com.kwad.sdk.core.d.a.a("InterstitialCallerContext", "isH5Interstitial :" + z);
        return z;
    }
}
