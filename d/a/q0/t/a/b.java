package d.a.q0.t.a;

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
import d.a.d.e.p.l;
import d.a.p0.o0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class b implements d.a.q0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f62869b;

    /* renamed from: c  reason: collision with root package name */
    public int f62870c;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f62871d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f62872e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f62873f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.l.b f62874g;

    /* loaded from: classes8.dex */
    public class a implements d.a.p0.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62875a;

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
            this.f62875a = bVar;
        }

        @Override // d.a.p0.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62875a.l();
            }
        }
    }

    /* renamed from: d.a.q0.t.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1640b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.l.a f62876a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f62877b;

        public C1640b(b bVar, d.a.p0.l.a aVar) {
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
            this.f62877b = bVar;
            this.f62876a = aVar;
        }

        public final void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                d.a.d.e.n.a a2 = j.a();
                a2.b("type", "gd");
                a2.b("locate", "splash");
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.a.q0.t.a.h.a.c().b()));
                a2.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a2);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rsplashType, i2) == null) {
                d.a.q0.t.a.j.a.j(d.a.q0.t.a.j.a.f62929b, "0", i2);
                this.f62877b.f62873f = AdLoadState.SUCCEED;
                if (d.a.q0.t.a.h.b.f62920a) {
                    Log.d("IAdSdkSplash", "bes gd loaded success");
                }
                this.f62877b.f62869b = rsplashType;
                if (this.f62877b.f62871d == null || this.f62877b.f62872e == null) {
                    return;
                }
                d.a.q0.t.a.h.a.c().g(this.f62876a);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (d.a.q0.t.a.h.b.f62920a) {
                    Log.d("IAdSdkSplash", "bes gd onAdClick");
                }
                d.a.p0.l.a aVar = this.f62876a;
                if (aVar != null) {
                    aVar.b(this.f62877b.f62869b == RsplashType.VIDEO, 1 == this.f62877b.f62870c, 1, null, null);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (d.a.q0.t.a.h.b.f62920a) {
                    Log.d("IAdSdkSplash", "bes gd onAdDismissed");
                }
                boolean z = this.f62877b.f62873f == AdLoadState.DISMISSED;
                this.f62877b.f62873f = AdLoadState.DISMISSED;
                d.a.p0.l.a aVar = this.f62876a;
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
                d.a.q0.t.a.j.a.j(d.a.q0.t.a.j.a.f62929b, str, 0);
                d.a.q0.t.a.j.a.k(d.a.q0.t.a.j.a.f62929b, "1");
                if (d.a.q0.t.a.h.b.f62920a) {
                    Log.d("IAdSdkSplash", "bes gd loaded loaded failed :" + str);
                }
                this.f62877b.f62873f = AdLoadState.FAILED;
                d.a.q0.t.a.h.a.c().g(this.f62876a);
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (d.a.q0.t.a.h.b.f62920a) {
                    Log.d("IAdSdkSplash", "bes gd present, and time is " + System.currentTimeMillis());
                }
                boolean z = 1 == this.f62877b.f62870c;
                d.a.p0.l.a aVar = this.f62876a;
                if (aVar != null) {
                    aVar.c(this.f62877b.f62869b == RsplashType.VIDEO, z, 1);
                }
                d.a.q0.t.a.j.a.k(d.a.q0.t.a.j.a.f62929b, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.a.p0.l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f62876a) == null) {
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
        this.f62870c = 1;
        new AdSplashStyle();
        this.f62873f = AdLoadState.INIT;
        this.f62874g = new a(this);
    }

    @Override // d.a.q0.t.a.h.b
    public AdLoadState a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62873f : (AdLoadState) invokeV.objValue;
    }

    @Override // d.a.q0.t.a.h.b
    public void b(d.a.p0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f52711c = this.f62874g;
        d.a.p0.l.a a2 = dVar.a();
        this.f62872e = new WeakReference<>(dVar.b());
        C1640b c1640b = new C1640b(this, a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.a.f0.a.b.a.f42713a.get().e());
            this.f62871d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.a.f0.a.b.a.f42713a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1640b);
            this.f62873f = AdLoadState.LOADING;
            this.f62871d.load();
            d.a.q0.t.a.j.a.i(d.a.q0.t.a.j.a.f62929b);
            if (d.a.q0.t.a.h.b.f62920a) {
                Log.d("IAdSdkSplash", "bes gd start load");
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            if (a2 != null) {
                a2.a("oom");
            }
        }
    }

    @Override // d.a.q0.t.a.h.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "bes_gd" : (String) invokeV.objValue;
    }

    @Override // d.a.q0.t.a.h.b
    public void destroy() {
        SplashAd splashAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (splashAd = this.f62871d) == null) {
            return;
        }
        splashAd.destroy();
    }

    public final void l() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.f62872e) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f62872e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f62872e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.q0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f62871d == null || (weakReference = this.f62872e) == null || weakReference.get() == null || this.f62873f != AdLoadState.SUCCEED) {
            return;
        }
        l();
        if (this.f62872e.get().getChildCount() > 0) {
            this.f62872e.get().removeAllViews();
        }
        this.f62873f = AdLoadState.SHOWED;
        if (d.a.q0.t.a.h.b.f62920a) {
            Log.d("IAdSdkSplash", "bes gd show, and time is " + System.currentTimeMillis());
        }
        this.f62871d.show(this.f62872e.get());
    }
}
