package com.kwad.sdk.splashscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.bd;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g extends com.kwad.sdk.core.e.b {
    public KsSplashScreenAd.SplashScreenAdInteractionListener a;
    public boolean b;
    @NonNull
    public KsVideoPlayConfig c;
    @NonNull
    public AdTemplate d;
    @NonNull
    public AdBaseFrameLayout e;
    @Nullable
    public com.kwad.sdk.splashscreen.b.a f;
    public com.kwad.sdk.core.download.a.b g;
    @NonNull
    public KsScene h;
    public com.kwad.sdk.core.j.c i;
    public String j;
    public boolean k;

    public static boolean a(Context context, AdInfo adInfo) {
        com.kwad.sdk.splashscreen.kwai.b b = com.kwad.sdk.splashscreen.kwai.a.b(context);
        boolean z = b == null || !b.a();
        boolean b2 = com.kwad.sdk.core.response.a.b.b(adInfo);
        com.kwad.sdk.core.d.a.a("SplashScreenCallerContext", "isNeedShowSplashShake: " + z + " confEnableShake: " + b2);
        return z && b2;
    }

    private boolean e() {
        DevelopMangerPlugin.DevelopValue a;
        DevelopMangerPlugin developMangerPlugin = (DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class);
        if (developMangerPlugin == null || (a = developMangerPlugin.a("KEY_CLOSE_SPLASH_VPLUS")) == null) {
            return false;
        }
        return ((Boolean) a.getValue()).booleanValue();
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.splashscreen.b.a aVar = this.f;
        if (aVar != null) {
            if (this.j != null) {
                aVar.i();
            } else {
                aVar.h();
            }
        }
    }

    public void a(Context context, int i, int i2) {
        a(context, i, i2, 0.0d);
    }

    public void a(Context context, final int i, int i2, final double d) {
        final AdInfo j = com.kwad.sdk.core.response.a.d.j(this.d);
        com.kwad.sdk.core.download.a.a.a(new a.C0295a(context).a(this.d).a(this.g).a(i2).a(false).a(new a.b() { // from class: com.kwad.sdk.splashscreen.g.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                String d2;
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = g.this.a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdClicked();
                }
                if (!com.kwad.sdk.core.response.a.a.B(j) && (d2 = g.this.d()) != null) {
                    g gVar = g.this;
                    gVar.b = true;
                    gVar.d.mMiniWindowId = d2;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (g.this.f != null) {
                        jSONObject.put("duration", g.this.f.c());
                    }
                } catch (JSONException e) {
                    com.kwad.sdk.core.d.a.a(e);
                }
                p.a aVar = new p.a();
                aVar.b = i;
                aVar.B = d;
                g gVar2 = g.this;
                com.kwad.sdk.core.report.a.a(gVar2.d, jSONObject, aVar, gVar2.e.getTouchCoords(), (String) null);
            }
        }));
    }

    public boolean b() {
        if (e()) {
            return false;
        }
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.d);
        boolean P = com.kwad.sdk.core.response.a.a.P(j);
        KsScene ksScene = this.h;
        return P && (ksScene instanceof SceneImpl ? ((SceneImpl) ksScene).needShowMiniWindow : false) && com.kwad.sdk.core.response.a.a.b(j) > 5;
    }

    public String c() {
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.d);
        boolean b = b();
        String a = com.kwad.sdk.core.response.a.a.a(j);
        if (!b || at.a(a)) {
            return null;
        }
        return String.valueOf(a.hashCode());
    }

    public String d() {
        if (this.k) {
            return this.j;
        }
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.d);
        boolean b = b();
        String a = com.kwad.sdk.core.response.a.a.a(j);
        if (!b || at.a(a) || this.f == null) {
            return null;
        }
        String c = c();
        final ImageView imageView = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f09114c);
        Bitmap createBitmap = Bitmap.createBitmap(this.e.getWidth(), this.e.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Bitmap bitmap = this.f.a().getBitmap();
        imageView.setVisibility(0);
        imageView.setImageDrawable(new BitmapDrawable(imageView.getResources(), bitmap));
        this.e.invalidate();
        this.e.draw(canvas);
        this.f.a = createBitmap;
        SplashPlayModuleCache.a().a(c, this.f);
        this.j = c;
        this.k = true;
        imageView.post(new bd(new Runnable() { // from class: com.kwad.sdk.splashscreen.g.1
            @Override // java.lang.Runnable
            public void run() {
                imageView.setVisibility(4);
            }
        }));
        return c;
    }
}
