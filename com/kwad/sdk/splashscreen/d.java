package com.kwad.sdk.splashscreen;

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
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.f;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ax;
/* loaded from: classes2.dex */
public class d extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f66602a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66603b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f66604c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f66605d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdBaseFrameLayout f66606e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f66607f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f66608g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public KsScene f66609h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.j.c f66610i;
    public String j;
    public boolean k;

    public d() {
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

    private boolean e() {
        InterceptResult invokeV;
        DevelopMangerPlugin.DevelopValue a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            DevelopMangerPlugin developMangerPlugin = (DevelopMangerPlugin) f.a(DevelopMangerPlugin.class);
            if (developMangerPlugin == null || (a2 = developMangerPlugin.a("KEY_CLOSE_SPLASH_VPLUS")) == null) {
                return false;
            }
            return ((Boolean) a2.getValue()).booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f66607f) == null) {
            return;
        }
        if (this.j != null) {
            aVar.i();
        } else {
            aVar.h();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (e()) {
                return false;
            }
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f66605d);
            boolean F = com.kwad.sdk.core.response.b.a.F(i2);
            KsScene ksScene = this.f66609h;
            return F && (ksScene instanceof SceneImpl ? ((SceneImpl) ksScene).needShowMiniWindow : false) && com.kwad.sdk.core.response.b.a.b(i2) > 5;
        }
        return invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f66605d);
            boolean b2 = b();
            String a2 = com.kwad.sdk.core.response.b.a.a(i2);
            if (!b2 || an.a(a2)) {
                return null;
            }
            return String.valueOf(a2.hashCode());
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.k) {
                return this.j;
            }
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f66605d);
            boolean b2 = b();
            String a2 = com.kwad.sdk.core.response.b.a.a(i2);
            if (!b2 || an.a(a2) || this.f66607f == null) {
                return null;
            }
            String c2 = c();
            ImageView imageView = (ImageView) this.f66606e.findViewById(R.id.ksad_splash_foreground);
            Bitmap createBitmap = Bitmap.createBitmap(this.f66606e.getWidth(), this.f66606e.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Bitmap bitmap = this.f66607f.a().getBitmap();
            imageView.setVisibility(0);
            imageView.setImageDrawable(new BitmapDrawable(imageView.getResources(), bitmap));
            this.f66606e.invalidate();
            this.f66606e.draw(canvas);
            this.f66607f.f66582a = createBitmap;
            SplashPlayModuleCache.a().a(c2, this.f66607f);
            this.j = c2;
            this.k = true;
            imageView.post(new ax(new Runnable(this, imageView) { // from class: com.kwad.sdk.splashscreen.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ImageView f66611a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f66612b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, imageView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66612b = this;
                    this.f66611a = imageView;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66611a.setVisibility(4);
                    }
                }
            }));
            return c2;
        }
        return (String) invokeV.objValue;
    }
}
