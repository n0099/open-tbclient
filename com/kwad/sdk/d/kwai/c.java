package com.kwad.sdk.d.kwai;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.z;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f58830b;

    /* renamed from: c  reason: collision with root package name */
    public Dialog f58831c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58832d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.d.a.b f58833e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58834f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public KsAdVideoPlayConfig f58835g;

    /* renamed from: h  reason: collision with root package name */
    public List<a.b> f58836h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f58837i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f58838j;

    /* renamed from: k  reason: collision with root package name */
    public a f58839k;
    public b l;
    public Handler m;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new Handler(Looper.getMainLooper());
        this.f58838j = false;
        this.f58836h = new CopyOnWriteArrayList();
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.m.removeCallbacksAndMessages(null);
            this.f58836h.clear();
        }
    }

    public void a(Context context, AdInfo adInfo, AdTemplate adTemplate, @Nullable View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, adInfo, adTemplate, view) == null) || view == null) {
            return;
        }
        String a2 = com.kwad.sdk.core.response.a.a.aa(adInfo).a();
        if (at.a(a2)) {
            return;
        }
        KSImageLoader.loadImage(a2, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new ImageLoadingListener(this, context, view) { // from class: com.kwad.sdk.d.kwai.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f58841b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f58842c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, view};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58842c = this;
                this.a = context;
                this.f58841b = view;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str, inputStream, decodedResult)) == null) {
                    return false;
                }
                return invokeLLL.booleanValue;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingCancelled(String str, View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2) == null) {
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, view2, decodedResult) == null) {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.d.a.a("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.d.a.a("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = this.a.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                    RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(this.a.getResources(), stackBlur);
                    create.setCornerRadius(dimension);
                    this.f58841b.setBackground(create);
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view2, FailReason failReason) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, str, view2, failReason) == null) {
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048580, this, str, view2) == null) {
                }
            }
        });
    }

    public void a(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, adTemplate) == null) || this.f58838j) {
            return;
        }
        com.kwad.sdk.core.page.a.a(context, adTemplate);
        this.f58838j = true;
    }

    public void a(View view, boolean z, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            if ((com.kwad.sdk.core.config.b.ak() || z) && com.kwad.sdk.core.download.a.a.a(new a.C2076a(bb.a(view)).a(this.a).a(this.f58832d).a(z).a(i2).a(new a.b(this, z2) { // from class: com.kwad.sdk.d.kwai.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f58840b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58840b = this;
                    this.a = z2;
                }

                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f58840b.a(this.a);
                    }
                }
            })) == 0 && this.f58831c != null && com.kwad.sdk.core.config.b.aC()) {
                this.m.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.d.kwai.c.2
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
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.f58831c.dismiss();
                        }
                    }
                }, 500L);
            }
        }
    }

    public void a(a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || this.f58836h.contains(bVar)) {
            return;
        }
        this.f58836h.add(bVar);
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f58839k = aVar;
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                com.kwad.sdk.core.report.a.a(this.a, (z.a) null);
            } else {
                com.kwad.sdk.core.report.a.a(this.a, 153, (z.a) null);
            }
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.f58830b;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, @Nullable com.kwad.sdk.core.video.videoview.b bVar) {
        long j2;
        long j3;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, bVar) == null) {
            if (bVar != null) {
                long duration = bVar.getDuration();
                j2 = bVar.getCurrentPosition();
                if (duration != 0) {
                    i2 = Math.round((((float) j2) / ((float) duration)) * 100.0f);
                    j3 = j2;
                    com.kwad.sdk.core.report.a.a(this.a, !z ? 14 : 1, j3, i2, (JSONObject) null);
                }
            } else {
                j2 = -1;
            }
            j3 = j2;
            i2 = -1;
            com.kwad.sdk.core.report.a.a(this.a, !z ? 14 : 1, j3, i2, (JSONObject) null);
        }
    }

    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            AdTemplate adTemplate = this.a;
            if (adTemplate == null || context == null) {
                com.kwad.sdk.core.d.a.d("InterstitialCallerContext", "isPlayable illegal params: " + this.a + ", context: " + context);
                return false;
            }
            return com.kwad.sdk.core.response.a.a.an(com.kwad.sdk.core.response.a.d.j(adTemplate));
        }
        return invokeL.booleanValue;
    }

    public boolean a(Context context, AdInfo adInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, context, adInfo)) == null) ? com.kwad.sdk.core.response.a.a.K(adInfo) && !af.e(context) : invokeLL.booleanValue;
    }

    public void b() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (aVar = this.f58839k) == null) {
            return;
        }
        aVar.a();
    }

    public void b(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f58836h.remove(bVar);
        }
    }

    public void c() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bVar = this.l) == null) {
            return;
        }
        bVar.a();
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            com.kwad.sdk.d.a.b bVar = this.f58833e;
            boolean z = bVar == null || bVar.getParent() == null;
            com.kwad.sdk.core.d.a.a("InterstitialCallerContext", "isH5Interstitial :" + z);
            return z;
        }
        return invokeV.booleanValue;
    }
}
