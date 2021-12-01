package com.kwad.sdk.splashscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class g extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsSplashScreenAd.SplashScreenAdInteractionListener a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59575b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f59576c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f59577d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdBaseFrameLayout f59578e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f59579f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59580g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public KsScene f59581h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.j.c f59582i;

    /* renamed from: j  reason: collision with root package name */
    public String f59583j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f59584k;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean a(Context context, AdInfo adInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, adInfo)) == null) {
            com.kwad.sdk.splashscreen.kwai.b b2 = com.kwad.sdk.splashscreen.kwai.a.b(context);
            boolean z = b2 == null || !b2.a();
            boolean b3 = com.kwad.sdk.core.response.a.b.b(adInfo);
            com.kwad.sdk.core.d.a.a("SplashScreenCallerContext", "isNeedShowSplashShake: " + z + " confEnableShake: " + b3);
            return z && b3;
        }
        return invokeLL.booleanValue;
    }

    private boolean e() {
        InterceptResult invokeV;
        DevelopMangerPlugin.DevelopValue a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            DevelopMangerPlugin developMangerPlugin = (DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class);
            if (developMangerPlugin == null || (a = developMangerPlugin.a("KEY_CLOSE_SPLASH_VPLUS")) == null) {
                return false;
            }
            return ((Boolean) a.getValue()).booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f59579f) == null) {
            return;
        }
        if (this.f59583j != null) {
            aVar.i();
        } else {
            aVar.h();
        }
    }

    public void a(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, i3) == null) {
            a(context, i2, i3, 0.0d);
        }
    }

    public void a(Context context, int i2, int i3, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2)}) == null) {
            com.kwad.sdk.core.download.a.a.a(new a.C2015a(context).a(this.f59577d).a(this.f59580g).a(i3).a(false).a(new a.b(this, com.kwad.sdk.core.response.a.d.j(this.f59577d), i2, d2) { // from class: com.kwad.sdk.splashscreen.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdInfo a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f59586b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ double f59587c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ g f59588d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, Integer.valueOf(i2), Double.valueOf(d2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59588d = this;
                    this.a = r7;
                    this.f59586b = i2;
                    this.f59587c = d2;
                }

                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    String d3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f59588d.a;
                        if (splashScreenAdInteractionListener != null) {
                            splashScreenAdInteractionListener.onAdClicked();
                        }
                        if (!com.kwad.sdk.core.response.a.a.B(this.a) && (d3 = this.f59588d.d()) != null) {
                            g gVar = this.f59588d;
                            gVar.f59575b = true;
                            gVar.f59577d.mMiniWindowId = d3;
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (this.f59588d.f59579f != null) {
                                jSONObject.put("duration", this.f59588d.f59579f.c());
                            }
                        } catch (JSONException e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                        p.a aVar = new p.a();
                        aVar.f57681b = this.f59586b;
                        aVar.B = this.f59587c;
                        g gVar2 = this.f59588d;
                        com.kwad.sdk.core.report.a.a(gVar2.f59577d, jSONObject, aVar, gVar2.f59578e.getTouchCoords(), (String) null);
                    }
                }
            }));
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (e()) {
                return false;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f59577d);
            boolean P = com.kwad.sdk.core.response.a.a.P(j2);
            KsScene ksScene = this.f59581h;
            return P && (ksScene instanceof SceneImpl ? ((SceneImpl) ksScene).needShowMiniWindow : false) && com.kwad.sdk.core.response.a.a.b(j2) > 5;
        }
        return invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f59577d);
            boolean b2 = b();
            String a = com.kwad.sdk.core.response.a.a.a(j2);
            if (!b2 || at.a(a)) {
                return null;
            }
            return String.valueOf(a.hashCode());
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f59584k) {
                return this.f59583j;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f59577d);
            boolean b2 = b();
            String a = com.kwad.sdk.core.response.a.a.a(j2);
            if (!b2 || at.a(a) || this.f59579f == null) {
                return null;
            }
            String c2 = c();
            ImageView imageView = (ImageView) this.f59578e.findViewById(R.id.ksad_splash_foreground);
            Bitmap createBitmap = Bitmap.createBitmap(this.f59578e.getWidth(), this.f59578e.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Bitmap bitmap = this.f59579f.a().getBitmap();
            imageView.setVisibility(0);
            imageView.setImageDrawable(new BitmapDrawable(imageView.getResources(), bitmap));
            this.f59578e.invalidate();
            this.f59578e.draw(canvas);
            this.f59579f.a = createBitmap;
            SplashPlayModuleCache.a().a(c2, this.f59579f);
            this.f59583j = c2;
            this.f59584k = true;
            imageView.post(new bd(new Runnable(this, imageView) { // from class: com.kwad.sdk.splashscreen.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageView a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f59585b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, imageView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59585b = this;
                    this.a = imageView;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.setVisibility(4);
                    }
                }
            }));
            return c2;
        }
        return (String) invokeV.objValue;
    }
}
