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
/* loaded from: classes7.dex */
public class g extends com.kwad.sdk.core.e.b {
    public KsSplashScreenAd.SplashScreenAdInteractionListener a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41328b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f41329c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f41330d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdBaseFrameLayout f41331e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f41332f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f41333g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public KsScene f41334h;
    public com.kwad.sdk.core.j.c i;
    public String j;
    public boolean k;

    public static boolean a(Context context, AdInfo adInfo) {
        com.kwad.sdk.splashscreen.kwai.b b2 = com.kwad.sdk.splashscreen.kwai.a.b(context);
        boolean z = b2 == null || !b2.a();
        boolean b3 = com.kwad.sdk.core.response.a.b.b(adInfo);
        com.kwad.sdk.core.d.a.a("SplashScreenCallerContext", "isNeedShowSplashShake: " + z + " confEnableShake: " + b3);
        return z && b3;
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
        com.kwad.sdk.splashscreen.b.a aVar = this.f41332f;
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

    public void a(Context context, final int i, int i2, final double d2) {
        final AdInfo j = com.kwad.sdk.core.response.a.d.j(this.f41330d);
        com.kwad.sdk.core.download.a.a.a(new a.C1956a(context).a(this.f41330d).a(this.f41333g).a(i2).a(false).a(new a.b() { // from class: com.kwad.sdk.splashscreen.g.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                String d3;
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = g.this.a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdClicked();
                }
                if (!com.kwad.sdk.core.response.a.a.B(j) && (d3 = g.this.d()) != null) {
                    g gVar = g.this;
                    gVar.f41328b = true;
                    gVar.f41330d.mMiniWindowId = d3;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (g.this.f41332f != null) {
                        jSONObject.put("duration", g.this.f41332f.c());
                    }
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                p.a aVar = new p.a();
                aVar.f39732b = i;
                aVar.B = d2;
                g gVar2 = g.this;
                com.kwad.sdk.core.report.a.a(gVar2.f41330d, jSONObject, aVar, gVar2.f41331e.getTouchCoords(), (String) null);
            }
        }));
    }

    public boolean b() {
        if (e()) {
            return false;
        }
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.f41330d);
        boolean P = com.kwad.sdk.core.response.a.a.P(j);
        KsScene ksScene = this.f41334h;
        return P && (ksScene instanceof SceneImpl ? ((SceneImpl) ksScene).needShowMiniWindow : false) && com.kwad.sdk.core.response.a.a.b(j) > 5;
    }

    public String c() {
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.f41330d);
        boolean b2 = b();
        String a = com.kwad.sdk.core.response.a.a.a(j);
        if (!b2 || at.a(a)) {
            return null;
        }
        return String.valueOf(a.hashCode());
    }

    public String d() {
        if (this.k) {
            return this.j;
        }
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.f41330d);
        boolean b2 = b();
        String a = com.kwad.sdk.core.response.a.a.a(j);
        if (!b2 || at.a(a) || this.f41332f == null) {
            return null;
        }
        String c2 = c();
        final ImageView imageView = (ImageView) this.f41331e.findViewById(R.id.obfuscated_res_0x7f091143);
        Bitmap createBitmap = Bitmap.createBitmap(this.f41331e.getWidth(), this.f41331e.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Bitmap bitmap = this.f41332f.a().getBitmap();
        imageView.setVisibility(0);
        imageView.setImageDrawable(new BitmapDrawable(imageView.getResources(), bitmap));
        this.f41331e.invalidate();
        this.f41331e.draw(canvas);
        this.f41332f.a = createBitmap;
        SplashPlayModuleCache.a().a(c2, this.f41332f);
        this.j = c2;
        this.k = true;
        imageView.post(new bd(new Runnable() { // from class: com.kwad.sdk.splashscreen.g.1
            @Override // java.lang.Runnable
            public void run() {
                imageView.setVisibility(4);
            }
        }));
        return c2;
    }
}
