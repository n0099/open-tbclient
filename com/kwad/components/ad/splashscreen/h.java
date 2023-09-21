package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.m.o;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ax;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class h extends com.kwad.sdk.mvp.a {
    @NonNull
    public KsScene fn;
    @NonNull
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    @NonNull
    public AdBaseFrameLayout mRootContainer;
    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;
    public KsSplashScreenAd.SplashScreenAdInteractionListener xT;
    public int xV;
    public boolean yb;
    @Nullable
    public com.kwad.components.ad.splashscreen.c.a yc;
    public com.kwad.sdk.core.h.a yd;
    public List<g> ye = new CopyOnWriteArrayList();
    public String yf;
    public boolean yg;

    /* loaded from: classes10.dex */
    public interface a {
        void b(@NonNull com.kwad.sdk.core.report.f fVar);
    }

    public static boolean jA() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    private void jH() {
        for (g gVar : this.ye) {
            gVar.jy();
        }
    }

    public final void a(Context context, final int i, int i2, final a aVar) {
        final AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
        com.kwad.components.core.c.a.a.a(new a.C0636a(context).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(i2).aj(false).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.h.2
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                String jC;
                if (h.this.xT != null) {
                    h.this.xT.onAdClicked();
                }
                if (!com.kwad.sdk.core.response.a.a.am(bQ) && (jC = h.this.jC()) != null) {
                    h hVar = h.this;
                    hVar.yb = true;
                    hVar.mAdTemplate.mMiniWindowId = jC;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (h.this.yc != null) {
                        jSONObject.put("duration", h.this.yc.getCurrentPosition());
                    }
                } catch (JSONException e) {
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                }
                com.kwad.sdk.core.report.f b = new com.kwad.sdk.core.report.f().aI(i).b(h.this.mRootContainer.getTouchCoords());
                com.kwad.sdk.core.report.a.a(h.this.mAdTemplate, b, jSONObject);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b(b);
                }
            }
        }));
    }

    public final void a(g gVar) {
        this.ye.add(gVar);
    }

    public final void b(g gVar) {
        this.ye.remove(gVar);
    }

    public final void c(Context context, int i, int i2) {
        a(context, i, i2, null);
    }

    @MainThread
    public final void e(int i, String str) {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.xT;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(0, str);
        }
        jH();
    }

    public final String jB() {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
        boolean jz = jz();
        String A = com.kwad.sdk.core.response.a.a.A(bQ);
        if (!jz || ax.dT(A)) {
            return null;
        }
        return String.valueOf(A.hashCode());
    }

    public final String jC() {
        if (this.yg) {
            return this.yf;
        }
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
        boolean jz = jz();
        String A = com.kwad.sdk.core.response.a.a.A(bQ);
        if (!jz || ax.dT(A) || this.yc == null) {
            return null;
        }
        String jB = jB();
        final ImageView imageView = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f09140b);
        Bitmap createBitmap = Bitmap.createBitmap(this.mRootContainer.getWidth(), this.mRootContainer.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Bitmap bitmap = this.yc.ky().getBitmap();
        imageView.setVisibility(0);
        imageView.setImageDrawable(new BitmapDrawable(imageView.getResources(), bitmap));
        this.mRootContainer.invalidate();
        this.mRootContainer.draw(canvas);
        this.yc.mBitmap = createBitmap;
        SplashPlayModuleCache.getInstance().a(jB, this.yc);
        this.yf = jB;
        this.yg = true;
        imageView.post(new o(new Runnable() { // from class: com.kwad.components.ad.splashscreen.h.1
            @Override // java.lang.Runnable
            public final void run() {
                imageView.setVisibility(4);
            }
        }));
        return jB;
    }

    @MainThread
    public final void jD() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.xT;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
    }

    @MainThread
    public final void jE() {
        com.kwad.components.splash.monitor.a.qG();
        com.kwad.components.splash.monitor.a.f(this.mAdTemplate, SystemClock.elapsedRealtime() - this.mAdTemplate.showStartTime);
        com.kwad.sdk.kwai.kwai.c.rd().aI(true);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.xT;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
    }

    @MainThread
    public final void jF() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.xT;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        jH();
    }

    @MainThread
    public final void jG() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.xT;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
        jH();
    }

    public final boolean jz() {
        if (jA()) {
            return false;
        }
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
        boolean aB = com.kwad.sdk.core.response.a.a.aB(bQ);
        KsScene ksScene = this.fn;
        return aB && (ksScene instanceof SceneImpl ? ((SceneImpl) ksScene).needShowMiniWindow : false) && com.kwad.sdk.core.response.a.a.B(bQ) > 5;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.ad.splashscreen.c.a aVar = this.yc;
        if (aVar != null) {
            if (this.yf != null) {
                aVar.kz();
            } else {
                aVar.release();
            }
        }
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.xT = splashScreenAdInteractionListener;
    }
}
