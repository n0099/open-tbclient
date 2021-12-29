package com.kwad.sdk.splashscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
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
/* loaded from: classes3.dex */
public class g extends com.kwad.sdk.core.e.b {
    public KsSplashScreenAd.SplashScreenAdInteractionListener a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60156b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f60157c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f60158d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdBaseFrameLayout f60159e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f60160f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f60161g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public KsScene f60162h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.j.c f60163i;

    /* renamed from: j  reason: collision with root package name */
    public String f60164j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f60165k;

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
        com.kwad.sdk.splashscreen.b.a aVar = this.f60160f;
        if (aVar != null) {
            if (this.f60164j != null) {
                aVar.i();
            } else {
                aVar.h();
            }
        }
    }

    public void a(Context context, int i2, int i3) {
        a(context, i2, i3, 0.0d);
    }

    public void a(Context context, final int i2, int i3, final double d2) {
        final AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f60158d);
        com.kwad.sdk.core.download.a.a.a(new a.C2083a(context).a(this.f60158d).a(this.f60161g).a(i3).a(false).a(new a.b() { // from class: com.kwad.sdk.splashscreen.g.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                String d3;
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = g.this.a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdClicked();
                }
                if (!com.kwad.sdk.core.response.a.a.B(j2) && (d3 = g.this.d()) != null) {
                    g gVar = g.this;
                    gVar.f60156b = true;
                    gVar.f60158d.mMiniWindowId = d3;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (g.this.f60160f != null) {
                        jSONObject.put("duration", g.this.f60160f.c());
                    }
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                p.a aVar = new p.a();
                aVar.f58262b = i2;
                aVar.B = d2;
                g gVar2 = g.this;
                com.kwad.sdk.core.report.a.a(gVar2.f60158d, jSONObject, aVar, gVar2.f60159e.getTouchCoords(), (String) null);
            }
        }));
    }

    public boolean b() {
        if (e()) {
            return false;
        }
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f60158d);
        boolean P = com.kwad.sdk.core.response.a.a.P(j2);
        KsScene ksScene = this.f60162h;
        return P && (ksScene instanceof SceneImpl ? ((SceneImpl) ksScene).needShowMiniWindow : false) && com.kwad.sdk.core.response.a.a.b(j2) > 5;
    }

    public String c() {
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f60158d);
        boolean b2 = b();
        String a = com.kwad.sdk.core.response.a.a.a(j2);
        if (!b2 || at.a(a)) {
            return null;
        }
        return String.valueOf(a.hashCode());
    }

    public String d() {
        if (this.f60165k) {
            return this.f60164j;
        }
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f60158d);
        boolean b2 = b();
        String a = com.kwad.sdk.core.response.a.a.a(j2);
        if (!b2 || at.a(a) || this.f60160f == null) {
            return null;
        }
        String c2 = c();
        final ImageView imageView = (ImageView) this.f60159e.findViewById(R.id.ksad_splash_foreground);
        Bitmap createBitmap = Bitmap.createBitmap(this.f60159e.getWidth(), this.f60159e.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Bitmap bitmap = this.f60160f.a().getBitmap();
        imageView.setVisibility(0);
        imageView.setImageDrawable(new BitmapDrawable(imageView.getResources(), bitmap));
        this.f60159e.invalidate();
        this.f60159e.draw(canvas);
        this.f60160f.a = createBitmap;
        SplashPlayModuleCache.a().a(c2, this.f60160f);
        this.f60164j = c2;
        this.f60165k = true;
        imageView.post(new bd(new Runnable() { // from class: com.kwad.sdk.splashscreen.g.1
            @Override // java.lang.Runnable
            public void run() {
                imageView.setVisibility(4);
            }
        }));
        return c2;
    }
}
