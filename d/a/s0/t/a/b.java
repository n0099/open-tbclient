package d.a.s0.t.a;

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
import d.a.r0.m0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class b implements d.a.s0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f65447b;

    /* renamed from: c  reason: collision with root package name */
    public int f65448c;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f65449d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f65450e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f65451f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.r0.k.b f65452g;

    /* loaded from: classes9.dex */
    public class a implements d.a.r0.k.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f65453a;

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
            this.f65453a = bVar;
        }

        @Override // d.a.r0.k.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f65453a.l();
            }
        }
    }

    /* renamed from: d.a.s0.t.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1678b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.k.a f65454a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f65455b;

        public C1678b(b bVar, d.a.r0.k.a aVar) {
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
            this.f65455b = bVar;
            this.f65454a = aVar;
        }

        public final void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                d.a.c.e.n.a a2 = j.a();
                a2.b("type", "gd");
                a2.b("locate", "splash");
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.a.s0.t.a.h.a.c().b()));
                a2.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a2);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rsplashType, i2) == null) {
                d.a.s0.t.a.j.a.j(d.a.s0.t.a.j.a.f65504b, "0", i2);
                this.f65455b.f65451f = AdLoadState.SUCCEED;
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "bes gd loaded success");
                }
                this.f65455b.f65447b = rsplashType;
                if (this.f65455b.f65449d == null || this.f65455b.f65450e == null) {
                    return;
                }
                d.a.s0.t.a.h.a.c().g(this.f65454a);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "bes gd onAdClick");
                }
                d.a.r0.k.a aVar = this.f65454a;
                if (aVar != null) {
                    aVar.b(this.f65455b.f65447b == RsplashType.VIDEO, 1 == this.f65455b.f65448c, 1);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "bes gd onAdDismissed");
                }
                boolean z = this.f65455b.f65451f == AdLoadState.DISMISSED;
                this.f65455b.f65451f = AdLoadState.DISMISSED;
                d.a.r0.k.a aVar = this.f65454a;
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
                d.a.s0.t.a.j.a.j(d.a.s0.t.a.j.a.f65504b, str, 0);
                d.a.s0.t.a.j.a.k(d.a.s0.t.a.j.a.f65504b, "1");
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "bes gd loaded loaded failed :" + str);
                }
                this.f65455b.f65451f = AdLoadState.FAILED;
                d.a.s0.t.a.h.a.c().g(this.f65454a);
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "bes gd present, and time is " + System.currentTimeMillis());
                }
                boolean z = 1 == this.f65455b.f65448c;
                d.a.r0.k.a aVar = this.f65454a;
                if (aVar != null) {
                    aVar.c(this.f65455b.f65447b == RsplashType.VIDEO, z, 1);
                }
                d.a.s0.t.a.j.a.k(d.a.s0.t.a.j.a.f65504b, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.a.r0.k.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f65454a) == null) {
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
        this.f65448c = 1;
        new AdSplashStyle();
        this.f65451f = AdLoadState.INIT;
        this.f65452g = new a(this);
    }

    @Override // d.a.s0.t.a.h.b
    public AdLoadState a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65451f : (AdLoadState) invokeV.objValue;
    }

    @Override // d.a.s0.t.a.h.b
    public void b(d.a.r0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f55352c = this.f65452g;
        d.a.r0.k.a a2 = dVar.a();
        this.f65450e = new WeakReference<>(dVar.b());
        C1678b c1678b = new C1678b(this, a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.a.h0.a.b.a.f45561a.get().e());
            this.f65449d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.a.h0.a.b.a.f45561a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1678b);
            this.f65451f = AdLoadState.LOADING;
            this.f65449d.load();
            d.a.s0.t.a.j.a.i(d.a.s0.t.a.j.a.f65504b);
            if (d.a.s0.t.a.h.b.f65495a) {
                Log.d("IAdSdkSplash", "bes gd start load");
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            if (a2 != null) {
                a2.a("oom");
            }
        }
    }

    @Override // d.a.s0.t.a.h.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "bes_gd" : (String) invokeV.objValue;
    }

    @Override // d.a.s0.t.a.h.b
    public void destroy() {
        SplashAd splashAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (splashAd = this.f65449d) == null) {
            return;
        }
        splashAd.destroy();
    }

    public final void l() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.f65450e) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f65450e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f65450e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.s0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f65449d == null || (weakReference = this.f65450e) == null || weakReference.get() == null || this.f65451f != AdLoadState.SUCCEED) {
            return;
        }
        l();
        if (this.f65450e.get().getChildCount() > 0) {
            this.f65450e.get().removeAllViews();
        }
        this.f65451f = AdLoadState.SHOWED;
        if (d.a.s0.t.a.h.b.f65495a) {
            Log.d("IAdSdkSplash", "bes gd show, and time is " + System.currentTimeMillis());
        }
        this.f65449d.show(this.f65450e.get());
    }
}
