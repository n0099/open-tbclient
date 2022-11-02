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
/* loaded from: classes7.dex */
public final class h extends com.kwad.sdk.mvp.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    public List<g> ye;
    public String yf;
    public boolean yg;

    /* loaded from: classes7.dex */
    public interface a {
        void b(@NonNull com.kwad.sdk.core.report.f fVar);
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
        this.ye = new CopyOnWriteArrayList();
    }

    public static boolean jA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
            return false;
        }
        return invokeV.booleanValue;
    }

    private void jH() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            for (g gVar : this.ye) {
                gVar.jy();
            }
        }
    }

    public final void a(Context context, int i, int i2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), aVar}) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0577a(context).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(i2).aj(false).a(new a.b(this, com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate), i, aVar) { // from class: com.kwad.components.ad.splashscreen.h.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdInfo pE;
                public final /* synthetic */ h yi;
                public final /* synthetic */ int yj;
                public final /* synthetic */ a yk;

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
                    this.yi = this;
                    this.pE = r7;
                    this.yj = i;
                    this.yk = aVar;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    String jC;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.yi.xT != null) {
                            this.yi.xT.onAdClicked();
                        }
                        if (!com.kwad.sdk.core.response.a.a.am(this.pE) && (jC = this.yi.jC()) != null) {
                            h hVar = this.yi;
                            hVar.yb = true;
                            hVar.mAdTemplate.mMiniWindowId = jC;
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (this.yi.yc != null) {
                                jSONObject.put("duration", this.yi.yc.getCurrentPosition());
                            }
                        } catch (JSONException e) {
                            com.kwad.sdk.core.e.b.printStackTrace(e);
                        }
                        com.kwad.sdk.core.report.f b = new com.kwad.sdk.core.report.f().aI(this.yj).b(this.yi.mRootContainer.getTouchCoords());
                        com.kwad.sdk.core.report.a.a(this.yi.mAdTemplate, b, jSONObject);
                        a aVar2 = this.yk;
                        if (aVar2 != null) {
                            aVar2.b(b);
                        }
                    }
                }
            }));
        }
    }

    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            this.ye.add(gVar);
        }
    }

    public final void b(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.ye.remove(gVar);
        }
    }

    public final void c(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, context, i, i2) == null) {
            a(context, i, i2, null);
        }
    }

    @MainThread
    public final void e(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.xT;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowError(0, str);
            }
            jH();
        }
    }

    public final String jB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
            boolean jz = jz();
            String A = com.kwad.sdk.core.response.a.a.A(bQ);
            if (!jz || ax.dT(A)) {
                return null;
            }
            return String.valueOf(A.hashCode());
        }
        return (String) invokeV.objValue;
    }

    public final String jC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
            ImageView imageView = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091225);
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
            imageView.post(new o(new Runnable(this, imageView) { // from class: com.kwad.components.ad.splashscreen.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageView yh;
                public final /* synthetic */ h yi;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, imageView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.yi = this;
                    this.yh = imageView;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.yh.setVisibility(4);
                    }
                }
            }));
            return jB;
        }
        return (String) invokeV.objValue;
    }

    @MainThread
    public final void jD() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (splashScreenAdInteractionListener = this.xT) == null) {
            return;
        }
        splashScreenAdInteractionListener.onAdClicked();
    }

    @MainThread
    public final void jE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            com.kwad.components.splash.monitor.a.qG();
            com.kwad.components.splash.monitor.a.f(this.mAdTemplate, SystemClock.elapsedRealtime() - this.mAdTemplate.showStartTime);
            com.kwad.sdk.kwai.kwai.c.rd().aI(true);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.xT;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
            }
        }
    }

    @MainThread
    public final void jF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.xT;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
            jH();
        }
    }

    @MainThread
    public final void jG() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.xT;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onSkippedAd();
            }
            jH();
        }
    }

    public final boolean jz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (jA()) {
                return false;
            }
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
            boolean aB = com.kwad.sdk.core.response.a.a.aB(bQ);
            KsScene ksScene = this.fn;
            return aB && (ksScene instanceof SceneImpl ? ((SceneImpl) ksScene).needShowMiniWindow : false) && com.kwad.sdk.core.response.a.a.B(bQ) > 5;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.ad.splashscreen.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.yc) == null) {
            return;
        }
        if (this.yf != null) {
            aVar.kz();
        } else {
            aVar.release();
        }
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, splashScreenAdInteractionListener) == null) {
            this.xT = splashScreenAdInteractionListener;
        }
    }
}
