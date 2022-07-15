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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.l.o;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.at;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class h extends com.kwad.sdk.mvp.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    @NonNull
    public KsVideoPlayConfig b;
    @NonNull
    public AdTemplate c;
    @NonNull
    public AdBaseFrameLayout d;
    @Nullable
    public com.kwad.components.ad.splashscreen.c.a e;
    public com.kwad.components.core.c.a.b f;
    @NonNull
    public KsScene g;
    public com.kwad.sdk.core.g.a h;
    public KsSplashScreenAd.SplashScreenAdInteractionListener i;
    public List<g> j;
    public String k;
    public boolean l;

    /* loaded from: classes5.dex */
    public interface a {
        void a(@NonNull com.kwad.sdk.core.report.f fVar);
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new CopyOnWriteArrayList();
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
            return false;
        }
        return invokeV.booleanValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            for (g gVar : this.j) {
                gVar.e();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.a
    public final void a() {
        com.kwad.components.ad.splashscreen.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.e) == null) {
            return;
        }
        if (this.k != null) {
            aVar.i();
        } else {
            aVar.h();
        }
    }

    @MainThread
    public final void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.i;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowError(0, str);
            }
            j();
        }
    }

    public final void a(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, context, i, i2) == null) {
            a(context, i, i2, null);
        }
    }

    public final void a(Context context, int i, int i2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), aVar}) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0507a(context).a(this.c).a(this.f).a(i2).a(false).a(new a.b(this, com.kwad.sdk.core.response.a.d.i(this.c), i, aVar) { // from class: com.kwad.components.ad.splashscreen.h.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdInfo a;
                public final /* synthetic */ int b;
                public final /* synthetic */ a c;
                public final /* synthetic */ h d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, Integer.valueOf(i), aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.d = this;
                    this.a = r7;
                    this.b = i;
                    this.c = aVar;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void a() {
                    String d;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.d.i != null) {
                            this.d.i.onAdClicked();
                        }
                        if (!com.kwad.sdk.core.response.a.a.I(this.a) && (d = this.d.d()) != null) {
                            h hVar = this.d;
                            hVar.a = true;
                            hVar.c.mMiniWindowId = d;
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (this.d.e != null) {
                                jSONObject.put("duration", this.d.e.e());
                            }
                        } catch (JSONException e) {
                            com.kwad.sdk.core.d.b.a(e);
                        }
                        com.kwad.sdk.core.report.f a2 = new com.kwad.sdk.core.report.f().a(this.b).a(this.d.d.getTouchCoords());
                        com.kwad.sdk.core.report.a.a(this.d.c, a2, jSONObject);
                        a aVar2 = this.c;
                        if (aVar2 != null) {
                            aVar2.a(a2);
                        }
                    }
                }
            }));
        }
    }

    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.j.add(gVar);
        }
    }

    public final void a(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, splashScreenAdInteractionListener) == null) {
            this.i = splashScreenAdInteractionListener;
        }
    }

    public final void b(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) {
            this.j.remove(gVar);
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (i()) {
                return false;
            }
            AdInfo i = com.kwad.sdk.core.response.a.d.i(this.c);
            boolean W = com.kwad.sdk.core.response.a.a.W(i);
            KsScene ksScene = this.g;
            return W && (ksScene instanceof SceneImpl ? ((SceneImpl) ksScene).needShowMiniWindow : false) && com.kwad.sdk.core.response.a.a.c(i) > 5;
        }
        return invokeV.booleanValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            AdInfo i = com.kwad.sdk.core.response.a.d.i(this.c);
            boolean b = b();
            String b2 = com.kwad.sdk.core.response.a.a.b(i);
            if (!b || at.a(b2)) {
                return null;
            }
            return String.valueOf(b2.hashCode());
        }
        return (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.l) {
                return this.k;
            }
            AdInfo i = com.kwad.sdk.core.response.a.d.i(this.c);
            boolean b = b();
            String b2 = com.kwad.sdk.core.response.a.a.b(i);
            if (!b || at.a(b2) || this.e == null) {
                return null;
            }
            String c = c();
            ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0911a6);
            Bitmap createBitmap = Bitmap.createBitmap(this.d.getWidth(), this.d.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Bitmap bitmap = this.e.c().getBitmap();
            imageView.setVisibility(0);
            imageView.setImageDrawable(new BitmapDrawable(imageView.getResources(), bitmap));
            this.d.invalidate();
            this.d.draw(canvas);
            this.e.a = createBitmap;
            SplashPlayModuleCache.a().a(c, this.e);
            this.k = c;
            this.l = true;
            imageView.post(new o(new Runnable(this, imageView) { // from class: com.kwad.components.ad.splashscreen.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageView a;
                public final /* synthetic */ h b;

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
                    this.b = this;
                    this.a = imageView;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.setVisibility(4);
                    }
                }
            }));
            return c;
        }
        return (String) invokeV.objValue;
    }

    @MainThread
    public final void e() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (splashScreenAdInteractionListener = this.i) == null) {
            return;
        }
        splashScreenAdInteractionListener.onAdClicked();
    }

    @MainThread
    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            com.kwad.components.ad.splashscreen.monitor.a.a().a(this.c, SystemClock.elapsedRealtime() - this.c.showStartTime);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.i;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
            }
        }
    }

    @MainThread
    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.i;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
            j();
        }
    }

    @MainThread
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.i;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onSkippedAd();
            }
            j();
        }
    }
}
