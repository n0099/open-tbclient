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
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.y;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c extends com.kwad.sdk.mvp.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate a;
    public KsInterstitialAd.AdInteractionListener b;
    public Dialog c;
    public com.kwad.components.core.c.a.b d;
    public com.kwad.components.ad.interstitial.widget.f e;
    public boolean f;
    public boolean g;
    public boolean h;
    public a i;
    @NonNull
    public KsAdVideoPlayConfig j;
    public List<a.b> k;
    public com.kwad.sdk.core.video.videoview.a l;
    public volatile boolean m;
    public int n;
    public List<InterfaceC0469c> o;
    public Handler p;

    /* renamed from: com.kwad.components.ad.interstitial.b.c$4  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass4 implements ImageLoadingListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ View b;
        public final /* synthetic */ c c;

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
            this.c = cVar;
            this.a = context;
            this.b = view2;
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
                com.kwad.sdk.utils.g.a(new Runnable(this, decodedResult) { // from class: com.kwad.components.ad.interstitial.b.c.4.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DecodedResult a;
                    public final /* synthetic */ AnonymousClass4 b;

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
                        this.b = this;
                        this.a = decodedResult;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Bitmap bitmap = this.a.mBitmap;
                            com.kwad.sdk.core.d.b.a("InterstitialCallerContext", "onLoadingComplete before blur");
                            Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                            com.kwad.sdk.core.d.b.a("InterstitialCallerContext", "onLoadingComplete after blur");
                            float dimension = this.b.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070376);
                            RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(this.b.a.getResources(), stackBlur);
                            create.setCornerRadius(dimension);
                            this.b.b.post(new Runnable(this, create) { // from class: com.kwad.components.ad.interstitial.b.c.4.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ RoundedBitmapDrawable a;
                                public final /* synthetic */ AnonymousClass1 b;

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
                                    this.b = this;
                                    this.a = create;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.b.b.b.setBackground(this.a);
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

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;
        public final Context b;
        public int c;
        public boolean d;
        public int e;
        public boolean f;
        public y.a g;

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
            this.b = context;
        }

        public final Context a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (Context) invokeV.objValue;
        }

        public final b a(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d)})) == null) {
                this.a = d;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public final b a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.c = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public final b a(y.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
                this.g = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public final b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.d = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : invokeV.intValue;
        }

        public final b b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.e = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public final b b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f = true;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public final boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : invokeV.booleanValue;
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f : invokeV.booleanValue;
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.e : invokeV.intValue;
        }

        public final y.a f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.g : (y.a) invokeV.objValue;
        }

        public final double g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a : invokeV.doubleValue;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0469c {
        void a();
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
        this.p = new Handler(Looper.getMainLooper());
        this.m = false;
        this.n = -1;
        this.k = new CopyOnWriteArrayList();
        this.o = new CopyOnWriteArrayList();
    }

    public static long a(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            if (aVar == null) {
                return -1L;
            }
            return aVar.getCurrentPosition();
        }
        return invokeL.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, this, i, i2) == null) {
            com.kwad.sdk.core.report.a.a(this.a, new com.kwad.sdk.core.report.f().e(i).a(i2).a(), (JSONObject) null);
            if (!this.h && (adInteractionListener = this.b) != null) {
                adInteractionListener.onAdClicked();
            }
            this.f = true;
            if (this.h) {
                return;
            }
            c();
        }
    }

    public static boolean a(Context context, AdInfo adInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, adInfo)) == null) ? com.kwad.sdk.core.response.a.a.R(adInfo) && !ae.e(context) : invokeLL.booleanValue;
    }

    public static int b(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, aVar)) == null) {
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

    @Override // com.kwad.sdk.mvp.a
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.p.removeCallbacksAndMessages(null);
            this.k.clear();
            this.o.clear();
        }
    }

    public final void a(Context context, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i, i2, i3) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0507a(context).a(this.a).a(this.d).a(false).a(2).a(new a.b(this, 9, i) { // from class: com.kwad.components.ad.interstitial.b.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ int b;
                public final /* synthetic */ c c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r7), Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = r7;
                    this.b = i;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.c.a(this.a, this.b);
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
        String a2 = com.kwad.sdk.core.response.a.a.ae(adInfo).a();
        if (at.a(a2)) {
            return;
        }
        KSImageLoader.loadImage(a2, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass4(this, context, view2));
    }

    public final void a(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, adTemplate) == null) || this.m) {
            return;
        }
        com.kwad.components.core.page.a.a(context, adTemplate);
        this.m = true;
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            boolean z = bVar.b() == 1;
            if ((com.kwad.components.ad.interstitial.kwai.b.d() || z || bVar.d()) && com.kwad.components.core.c.a.a.a(new a.C0507a(bVar.a()).a(this.a).a(this.d).a(z).a(bVar.b()).a(new a.b(this, bVar) { // from class: com.kwad.components.ad.interstitial.b.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;
                public final /* synthetic */ c b;

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
                    this.b = this;
                    this.a = bVar;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.b.b(this.a);
                    }
                }
            })) == 0 && this.c != null && com.kwad.components.ad.interstitial.kwai.b.g()) {
                this.p.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.interstitial.b.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

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
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.c.dismiss();
                        }
                    }
                }, 500L);
            }
        }
    }

    public final void a(InterfaceC0469c interfaceC0469c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interfaceC0469c) == null) {
            this.o.add(interfaceC0469c);
        }
    }

    public final void a(a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || this.k.contains(bVar)) {
            return;
        }
        this.k.add(bVar);
    }

    public final void a(boolean z, @Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, aVar) == null) {
            com.kwad.sdk.core.report.a.a(this.a, z ? 14 : 1, a(aVar), b(aVar), null);
        }
    }

    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            AdTemplate adTemplate = this.a;
            if (adTemplate == null || context == null) {
                com.kwad.sdk.core.d.b.d("InterstitialCallerContext", "isPlayable illegal params: " + this.a + ", context: " + context);
                return false;
            }
            return com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.i(adTemplate));
        }
        return invokeL.booleanValue;
    }

    public final void b() {
        List<InterfaceC0469c> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.o) == null || list.size() <= 0) {
            return;
        }
        for (InterfaceC0469c interfaceC0469c : this.o) {
            if (interfaceC0469c != null) {
                interfaceC0469c.a();
            }
        }
    }

    public final void b(b bVar) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            com.kwad.sdk.core.report.f fVar = new com.kwad.sdk.core.report.f();
            fVar.a(bVar.f());
            if (!bVar.c() && !bVar.f) {
                bVar.b(153);
            }
            com.kwad.sdk.core.report.a.a(this.a, new com.kwad.sdk.core.report.f().a(bVar.e()).a(bVar.f()).a(bVar.g()), (JSONObject) null);
            com.kwad.sdk.core.video.videoview.a aVar = this.l;
            if (aVar != null) {
                long a2 = a(aVar);
                int b2 = b(this.l);
                fVar.a(a2);
                fVar.f(b2);
            }
            if (!this.h && (adInteractionListener = this.b) != null) {
                adInteractionListener.onAdClicked();
            }
            this.f = true;
            if (this.h) {
                return;
            }
            c();
        }
    }

    public final void b(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.k.remove(bVar);
        }
    }

    public final void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.i) == null) {
            return;
        }
        aVar.a();
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            com.kwad.components.ad.interstitial.widget.f fVar = this.e;
            boolean z = fVar == null || fVar.getParent() == null;
            com.kwad.sdk.core.d.b.a("InterstitialCallerContext", "isH5Interstitial :" + z);
            return z;
        }
        return invokeV.booleanValue;
    }
}
