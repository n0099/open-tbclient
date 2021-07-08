package d.a.p0.t.a;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RsplashType;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashLpCloseListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.data.AdSplashStyle;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.o0.m0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class b implements d.a.p0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f62225b;

    /* renamed from: c  reason: collision with root package name */
    public int f62226c;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f62227d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f62228e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f62229f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.k.b f62230g;

    /* loaded from: classes8.dex */
    public class a implements d.a.o0.k.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62231a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62231a = bVar;
        }

        @Override // d.a.o0.k.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62231a.l();
            }
        }
    }

    /* renamed from: d.a.p0.t.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1636b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.k.a f62232a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f62233b;

        public C1636b(b bVar, d.a.o0.k.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62233b = bVar;
            this.f62232a = aVar;
        }

        public final void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                d.a.c.e.n.a a2 = j.a();
                a2.b("type", "gd");
                a2.b("locate", "splash");
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.a.p0.t.a.h.a.c().b()));
                a2.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a2);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rsplashType, i2) == null) {
                d.a.p0.t.a.j.a.j(d.a.p0.t.a.j.a.f62285b, "0", i2);
                this.f62233b.f62229f = AdLoadState.SUCCEED;
                if (d.a.p0.t.a.h.b.f62276a) {
                    Log.d("IAdSdkSplash", "bes gd loaded success");
                }
                this.f62233b.f62225b = rsplashType;
                if (this.f62233b.f62227d == null || this.f62233b.f62228e == null) {
                    return;
                }
                d.a.p0.t.a.h.a.c().g(this.f62232a);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (d.a.p0.t.a.h.b.f62276a) {
                    Log.d("IAdSdkSplash", "bes gd onAdClick");
                }
                d.a.o0.k.a aVar = this.f62232a;
                if (aVar != null) {
                    aVar.b(this.f62233b.f62225b == RsplashType.VIDEO, 1 == this.f62233b.f62226c, 1);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (d.a.p0.t.a.h.b.f62276a) {
                    Log.d("IAdSdkSplash", "bes gd onAdDismissed");
                }
                boolean z = this.f62233b.f62229f == AdLoadState.DISMISSED;
                this.f62233b.f62229f = AdLoadState.DISMISSED;
                d.a.o0.k.a aVar = this.f62232a;
                if (aVar == null || z) {
                    return;
                }
                aVar.onAdDismiss();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                d.a.p0.t.a.j.a.j(d.a.p0.t.a.j.a.f62285b, str, 0);
                d.a.p0.t.a.j.a.k(d.a.p0.t.a.j.a.f62285b, "1");
                if (d.a.p0.t.a.h.b.f62276a) {
                    Log.d("IAdSdkSplash", "bes gd loaded loaded failed :" + str);
                }
                this.f62233b.f62229f = AdLoadState.FAILED;
                d.a.p0.t.a.h.a.c().g(this.f62232a);
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (d.a.p0.t.a.h.b.f62276a) {
                    Log.d("IAdSdkSplash", "bes gd present, and time is " + System.currentTimeMillis());
                }
                boolean z = 1 == this.f62233b.f62226c;
                d.a.o0.k.a aVar = this.f62232a;
                if (aVar != null) {
                    aVar.c(this.f62233b.f62225b == RsplashType.VIDEO, z, 1);
                }
                d.a.p0.t.a.j.a.k(d.a.p0.t.a.j.a.f62285b, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.a.o0.k.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f62232a) == null) {
                return;
            }
            aVar.onLpClosed();
        }
    }

    public b() {
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
        this.f62226c = 1;
        new AdSplashStyle();
        this.f62229f = AdLoadState.INIT;
        this.f62230g = new a(this);
    }

    @Override // d.a.p0.t.a.h.b
    public AdLoadState a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62229f : (AdLoadState) invokeV.objValue;
    }

    @Override // d.a.p0.t.a.h.b
    public void b(d.a.o0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f52057c = this.f62230g;
        d.a.o0.k.a a2 = dVar.a();
        this.f62228e = new WeakReference<>(dVar.b());
        C1636b c1636b = new C1636b(this, a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.a.e0.a.b.a.f42209a.get().e());
            this.f62227d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.a.e0.a.b.a.f42209a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1636b);
            this.f62229f = AdLoadState.LOADING;
            this.f62227d.load();
            d.a.p0.t.a.j.a.i(d.a.p0.t.a.j.a.f62285b);
            if (d.a.p0.t.a.h.b.f62276a) {
                Log.d("IAdSdkSplash", "bes gd start load");
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            if (a2 != null) {
                a2.a("oom");
            }
        }
    }

    @Override // d.a.p0.t.a.h.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "bes_gd" : (String) invokeV.objValue;
    }

    @Override // d.a.p0.t.a.h.b
    public void destroy() {
        SplashAd splashAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (splashAd = this.f62227d) == null) {
            return;
        }
        splashAd.destroy();
    }

    public final void l() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.f62228e) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f62228e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f62228e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.p0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f62227d == null || (weakReference = this.f62228e) == null || weakReference.get() == null || this.f62229f != AdLoadState.SUCCEED) {
            return;
        }
        l();
        if (this.f62228e.get().getChildCount() > 0) {
            this.f62228e.get().removeAllViews();
        }
        this.f62229f = AdLoadState.SHOWED;
        if (d.a.p0.t.a.h.b.f62276a) {
            Log.d("IAdSdkSplash", "bes gd show, and time is " + System.currentTimeMillis());
        }
        this.f62227d.show(this.f62228e.get());
    }
}
