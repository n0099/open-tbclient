package com.kwad.components.ad.interstitial.b;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c extends com.kwad.sdk.mvp.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public KsAdVideoPlayConfig cN;
    public com.kwad.sdk.core.video.videoview.a dp;
    public KsInterstitialAd.AdInteractionListener fo;
    public Dialog gi;
    public com.kwad.components.ad.interstitial.widget.f gj;
    public List<e> gk;
    public boolean gl;
    public boolean gm;
    public boolean gn;
    public a go;
    public com.kwad.components.core.webview.b.d.b gp;
    @NonNull
    public KSFrameLayout gq;
    public d gr;
    public List<InterfaceC0561c> gs;
    public com.kwad.components.ad.interstitial.c.b gt;
    public List<a.b> gu;
    public volatile boolean gv;
    public boolean gw;
    public int gx;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public Handler mHandler;

    /* renamed from: com.kwad.components.ad.interstitial.b.c$4  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass4 implements ImageLoadingListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View dH;
        public final /* synthetic */ Context gC;
        public final /* synthetic */ c gz;

        public AnonymousClass4(c cVar, Context context, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.gz = cVar;
            this.gC = context;
            this.dH = view2;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, inputStream, decodedResult)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2) == null) {
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, view2, decodedResult) == null) {
                com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this, decodedResult) { // from class: com.kwad.components.ad.interstitial.b.c.4.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DecodedResult gD;
                    public final /* synthetic */ AnonymousClass4 gE;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, decodedResult};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.gE = this;
                        this.gD = decodedResult;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Bitmap bitmap = this.gD.mBitmap;
                            com.kwad.sdk.core.e.b.d("InterstitialCallerContext", "onLoadingComplete before blur");
                            Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                            com.kwad.sdk.core.e.b.d("InterstitialCallerContext", "onLoadingComplete after blur");
                            float dimension = this.gE.gC.getResources().getDimension(R.dimen.obfuscated_res_0x7f070376);
                            RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(this.gE.gC.getResources(), stackBlur);
                            create.setCornerRadius(dimension);
                            this.gE.dH.post(new Runnable(this, create) { // from class: com.kwad.components.ad.interstitial.b.c.4.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ RoundedBitmapDrawable gF;
                                public final /* synthetic */ AnonymousClass1 gG;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, create};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.gG = this;
                                    this.gF = create;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.gG.gE.dH.setBackground(this.gF);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view2, FailReason failReason) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, view2, failReason) == null) {
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, view2) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface a {
        void cy();
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context context;
        public int gH;
        public boolean gI;
        public int gJ;
        public boolean gK;
        public aa.a gL;
        public double gM;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = context;
        }

        public final b a(aa.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                this.gL = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public final b b(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d)})) == null) {
                this.gM = d;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public final int cC() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.gH : invokeV.intValue;
        }

        public final boolean cD() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.gI : invokeV.booleanValue;
        }

        public final boolean cE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.gK : invokeV.booleanValue;
        }

        public final int cF() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.gJ : invokeV.intValue;
        }

        public final double cG() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.gM : invokeV.doubleValue;
        }

        public final Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.context : (Context) invokeV.objValue;
        }

        public final aa.a getTouchCoords() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.gL : (aa.a) invokeV.objValue;
        }

        public final b l(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.gI = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public final b m(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.gK = true;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public final b y(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                this.gH = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public final b z(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                this.gJ = i;
                return this;
            }
            return (b) invokeI.objValue;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0561c {
        void cH();
    }

    /* loaded from: classes8.dex */
    public interface d {
        void cI();
    }

    /* loaded from: classes8.dex */
    public interface e {
        void onError();
    }

    public c() {
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
        this.mHandler = new Handler(Looper.getMainLooper());
        this.gv = false;
        this.gx = -1;
        this.gu = new CopyOnWriteArrayList();
        this.gk = new CopyOnWriteArrayList();
        this.gs = new ArrayList();
    }

    public static int a(long j, @NonNull AdTemplate adTemplate) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, adTemplate)) == null) {
            if (j == -1) {
                return -1;
            }
            float C = ((float) com.kwad.sdk.core.response.a.a.C(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) / 1000.0f;
            if (C != 0.0f) {
                return Math.round((((float) j) / C) * 100.0f);
            }
            return -1;
        }
        return invokeJL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, Context context) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65538, this, i, i2, context) == null) {
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, new com.kwad.sdk.core.report.f().aM(i).aI(i2).aU(ag.cB(context) ? 2 : 1).uw(), (JSONObject) null);
            if (!this.gn && (adInteractionListener = this.fo) != null) {
                adInteractionListener.onAdClicked();
            }
            this.gl = true;
            if (this.gn) {
                return;
            }
            cy();
        }
    }

    public static boolean a(Context context, AdInfo adInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, adInfo)) == null) ? com.kwad.sdk.core.response.a.a.av(adInfo) && !ag.cB(context) : invokeLL.booleanValue;
    }

    public static long b(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, aVar)) == null) {
            if (aVar == null) {
                return -1L;
            }
            return aVar.getCurrentPosition();
        }
        return invokeL.longValue;
    }

    public static int c(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            if (aVar == null) {
                return -1;
            }
            long duration = aVar.getDuration();
            long currentPosition = aVar.getCurrentPosition();
            if (duration != 0) {
                return Math.round((((float) currentPosition) / ((float) duration)) * 100.0f);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean K(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null || context == null) {
                com.kwad.sdk.core.e.b.w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
                return false;
            }
            return com.kwad.sdk.core.response.a.a.aY(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
        }
        return invokeL.booleanValue;
    }

    public final void a(Context context, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i, i2, i3) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0597a(context).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(false).ae(2).a(new a.b(this, 9, i, context) { // from class: com.kwad.components.ad.interstitial.b.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int gA;
                public final /* synthetic */ int gB;
                public final /* synthetic */ Context gC;
                public final /* synthetic */ c gz;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r7), Integer.valueOf(i), context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.gz = this;
                    this.gA = r7;
                    this.gB = i;
                    this.gC = context;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.gz.a(this.gA, this.gB, this.gC);
                    }
                }
            }));
        }
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, @Nullable View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, adInfo, adTemplate, view2) == null) || view2 == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.a.a.aL(adInfo).getUrl();
        if (ax.dT(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass4(this, context, view2));
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            boolean z = bVar.cC() == 1;
            if ((com.kwad.components.ad.interstitial.kwai.b.cl() || z || bVar.cE()) && com.kwad.components.core.c.a.a.a(new a.C0597a(bVar.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(z).ae(bVar.cC()).a(new a.b(this, bVar) { // from class: com.kwad.components.ad.interstitial.b.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b gy;
                public final /* synthetic */ c gz;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.gz = this;
                    this.gy = bVar;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.gz.b(this.gy);
                    }
                }
            })) == 0 && this.gi != null && com.kwad.components.ad.interstitial.kwai.b.co()) {
                this.mHandler.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.interstitial.b.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c gz;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.gz = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.gz.gi.dismiss();
                        }
                    }
                }, 500L);
            }
        }
    }

    public final void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.gk.add(eVar);
        }
    }

    public final void a(a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || this.gu.contains(bVar)) {
            return;
        }
        this.gu.add(bVar);
    }

    public final void a(boolean z, int i, @Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        long j;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), aVar}) == null) {
            if (aVar != null) {
                j = b(aVar);
                a2 = c(aVar);
            } else {
                j = i;
                a2 = a(j, this.mAdTemplate);
            }
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, z ? 14 : 1, j, a2, null);
        }
    }

    public final void b(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, context, adTemplate) == null) || this.gv) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.gv = true;
    }

    public final void b(b bVar) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            com.kwad.sdk.core.report.f fVar = new com.kwad.sdk.core.report.f();
            fVar.b(bVar.getTouchCoords());
            if (!bVar.cD() && !bVar.gK) {
                bVar.z(153);
            }
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, new com.kwad.sdk.core.report.f().aI(bVar.cF()).b(bVar.getTouchCoords()).aU(ag.cB(bVar.context) ? 2 : 1).e(bVar.cG()), (JSONObject) null);
            com.kwad.sdk.core.video.videoview.a aVar = this.dp;
            if (aVar != null) {
                long b2 = b(aVar);
                int c = c(this.dp);
                fVar.F(b2);
                fVar.aN(c);
            }
            if (!this.gn && (adInteractionListener = this.fo) != null) {
                adInteractionListener.onAdClicked();
            }
            this.gl = true;
            if (this.gn) {
                return;
            }
            cy();
        }
    }

    public final void b(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.gu.remove(bVar);
        }
    }

    public final void cA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            for (InterfaceC0561c interfaceC0561c : this.gs) {
                interfaceC0561c.cH();
            }
        }
    }

    public final boolean cB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            com.kwad.components.ad.interstitial.widget.f fVar = this.gj;
            boolean z = fVar == null || fVar.getParent() == null;
            com.kwad.sdk.core.e.b.d("InterstitialCallerContext", "isH5Interstitial :" + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void cx() {
        List<e> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (list = this.gk) == null || list.size() <= 0) {
            return;
        }
        for (e eVar : this.gk) {
            if (eVar != null) {
                eVar.onError();
            }
        }
    }

    public final void cy() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (aVar = this.go) == null) {
            return;
        }
        aVar.cy();
    }

    public final void cz() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (dVar = this.gr) == null) {
            return;
        }
        dVar.cI();
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.gu.clear();
            this.gk.clear();
            this.gs.clear();
            com.kwad.components.ad.interstitial.c.b bVar = this.gt;
            if (bVar != null) {
                bVar.qj();
            }
        }
    }
}
