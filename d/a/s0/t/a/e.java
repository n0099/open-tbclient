package d.a.s0.t.a;

import android.app.Application;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.SplashAdFacade;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.m0.j;
import d.a.r0.z0.p0;
import java.lang.ref.WeakReference;
import tbclient.AppPosInfo;
/* loaded from: classes9.dex */
public class e implements d.a.s0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f65473b;

    /* renamed from: c  reason: collision with root package name */
    public volatile AdLoadState f65474c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.b.g.d f65475d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f65476e;

    /* loaded from: classes9.dex */
    public class a implements d.a.h0.b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.k.a f65477a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f65478b;

        public a(e eVar, d.a.r0.k.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65478b = eVar;
            this.f65477a = aVar;
        }

        @Override // d.a.h0.b.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.s0.t.a.j.a.j(d.a.s0.t.a.j.a.f65505c, str, 0);
                d.a.s0.t.a.j.a.k(d.a.s0.t.a.j.a.f65505c, "1");
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "prologue ad loaded failed: " + str);
                }
                if (BdLog.isDebugMode()) {
                    BdLog.e("");
                }
                this.f65478b.f65474c = AdLoadState.FAILED;
                e("advert_show", 0);
            }
        }

        @Override // d.a.h0.b.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "prologue ad finish");
                }
                d.a.r0.k.a aVar = this.f65477a;
                if (aVar != null) {
                    aVar.onAdDismiss();
                }
            }
        }

        @Override // d.a.h0.b.d
        public void c(d.a.k0.a.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                d.a.s0.t.a.j.a.j(d.a.s0.t.a.j.a.f65505c, "0", 0);
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "prologue gd loaded success");
                }
                this.f65478b.f65474c = AdLoadState.SUCCEED;
                d.a.s0.t.a.h.a.c().g(this.f65477a);
                e("advert_load", 1);
            }
        }

        @Override // d.a.h0.b.d
        @NonNull
        public ViewGroup d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (ViewGroup) this.f65478b.f65476e.get() : (ViewGroup) invokeV.objValue;
        }

        public final void e(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, str, i2) == null) {
                d.a.c.e.n.a a2 = j.a();
                a2.b("type", "prologue");
                a2.b("locate", "splash");
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.a.s0.t.a.h.a.c().b()));
                a2.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a2);
            }
        }

        @Override // d.a.h0.b.d
        public void onAdClick() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "prologue ad onclick");
                }
                if (this.f65477a != null) {
                    if (this.f65478b.f65475d == null || this.f65478b.f65475d.f() == null) {
                        z = false;
                    } else {
                        boolean z2 = this.f65478b.f65475d.f().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                        r1 = z2;
                        z = this.f65478b.f65475d.f().optInt("full_type", 0) == 1;
                    }
                    this.f65477a.b(r1, z, this.f65478b.f65473b);
                }
            }
        }

        @Override // d.a.h0.b.d
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "prologue ad show");
                }
                d.a.r0.k.a aVar = this.f65477a;
                if (aVar != null) {
                    aVar.c(true, false, this.f65478b.f65473b);
                }
                d.a.s0.t.a.j.a.k(d.a.s0.t.a.j.a.f65505c, "0");
                e("advert_show", 1);
            }
        }

        @Override // d.a.h0.b.d
        public void onSkip() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "prologue ad onskip");
                }
                if (this.f65478b.f65475d != null) {
                    int i2 = 1;
                    boolean z = this.f65478b.f65475d.f().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                    boolean z2 = this.f65478b.f65475d.f().optInt("full_type", 0) == 1;
                    if (z2 && z) {
                        i2 = 4;
                    } else if (z) {
                        i2 = 3;
                    } else if (z2) {
                        i2 = 2;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 5).param("obj_type", i2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements d.a.h0.a.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Application f65479b;

        public b(Application application) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {application};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65479b = application;
        }

        @Override // d.a.h0.a.b.a
        public String A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "7352842" : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public int B() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.drawable.bg_bes_splash_logo_blue : invokeV.intValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public String C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TbadkCoreApplication.getInst().getImei() : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public String D() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TbConfig.getVersion() : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public int E() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.drawable.bg_bes_splash_logo_white : invokeV.intValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Settings.System.getString(this.f65479b.getContentResolver(), IAdRequestParam.ANDROID_ID) : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "1099a" : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "" : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return 120;
            }
            return invokeV.intValue;
        }

        @Override // d.a.h0.a.b.a
        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.drawable.pic_splash_logo : invokeV.intValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? TbadkCoreApplication.getInst().getCuidGalaxy2() : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public String from() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "1099a" : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Build.VERSION.RELEASE : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                String b2 = p0.b();
                if (TextUtils.isEmpty(b2)) {
                    b2 = "bdtb for Android " + TbConfig.getVersion();
                }
                if (BdLog.isDebugMode()) {
                    BdLog.e("userAgent=" + b2);
                }
                return b2;
            }
            return (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? TbadkCoreApplication.getInst().getPackageName() : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                AppPosInfo a2 = d.a.s0.w2.g0.a.e().a();
                return a2 != null ? a2.coordinate_type : "";
            }
            return (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public String k() {
            CookieManager cookieManager;
            String[] split;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                try {
                    cookieManager = CookieManager.getInstance();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    cookieManager = null;
                }
                if (cookieManager == null) {
                    return "";
                }
                String cookie = cookieManager.getCookie("*.baidu.com");
                if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                    cookie = d.a.r0.l.a.f55367a;
                }
                if (cookie != null) {
                    for (String str : cookie.split(";")) {
                        if (str.contains("BAIDUID=")) {
                            return str.trim().substring(8);
                        }
                    }
                    return "";
                }
                return "";
            }
            return (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "1481698145541" : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public String m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? d.a.t.b.d(TbadkCoreApplication.getInst()).e() : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                int[] b2 = d.a.h0.b.b.a().b();
                return TextUtils.join("_", new String[]{String.valueOf(b2[0]), String.valueOf(b2[1]), "android", D(), String.valueOf(b2[2])});
            }
            return (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public Application o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f65479b : (Application) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public String p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? "2" : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public String q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? Build.MODEL : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public String r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? "bb3808eb" : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public boolean s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? TbadkCoreApplication.getInst().isDebugMode() : invokeV.booleanValue;
        }

        @Override // d.a.h0.a.b.a
        public int t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (int) d.a.s0.t.a.j.a.e() : invokeV.intValue;
        }

        @Override // d.a.h0.a.b.a
        public String u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? "tieba" : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public boolean v(String str, d.a.h0.c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, str, bVar)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, str));
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.h0.a.b.a
        @NonNull
        public String w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                return currentAccount == null ? "" : currentAccount;
            }
            return (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public String[] x() {
            InterceptResult invokeV;
            AppPosInfo a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                if (d.a.s0.w2.g0.a.e() != null && (a2 = d.a.s0.w2.g0.a.e().a()) != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("" + a2.longitude + "|" + a2.latitude);
                    }
                    return new String[]{a2.longitude, a2.latitude};
                }
                if (BdLog.isDebugMode()) {
                    BdLog.e("0, 0");
                }
                return new String[]{"0", "0"};
            }
            return (String[]) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public String y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) ? "" : TbadkCoreApplication.getInst().getAdAdSense().r : (String) invokeV.objValue;
        }

        @Override // d.a.h0.a.b.a
        public boolean z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f65479b.getResources().getConfiguration().orientation == 2 : invokeV.booleanValue;
        }
    }

    public e() {
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
        this.f65473b = 5;
        this.f65474c = AdLoadState.INIT;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, null) == null) {
            SplashAdFacade.e().f(new b(TbadkCoreApplication.getInst()));
        }
    }

    @Override // d.a.s0.t.a.h.b
    public AdLoadState a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65474c : (AdLoadState) invokeV.objValue;
    }

    @Override // d.a.s0.t.a.h.b
    public void b(d.a.r0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        d.a.r0.k.a a2 = dVar.a();
        this.f65476e = new WeakReference<>(dVar.b());
        try {
            this.f65475d = new d.a.h0.b.g.d(TbadkCoreApplication.getInst().getContext(), "1481698145541", new RequestParameters.Builder().setHeight(l.k(dVar.b().getContext())).setWidth(l.i(dVar.b().getContext())).build(), new a(this, a2));
            this.f65474c = AdLoadState.LOADING;
            d.a.s0.t.a.j.a.i(d.a.s0.t.a.j.a.f65505c);
            this.f65475d.g();
            if (d.a.s0.t.a.h.b.f65495a) {
                Log.d("IAdSdkSplash", "prologue ad start load");
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            a2.a("oom");
        }
    }

    @Override // d.a.s0.t.a.h.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    @Override // d.a.s0.t.a.h.b
    public void destroy() {
        d.a.h0.b.g.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (dVar = this.f65475d) == null) {
            return;
        }
        dVar.e();
        this.f65475d = null;
    }

    public final void g() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.f65476e) == null || weakReference.get().getParent() == null || !(this.f65476e.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f65476e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f65476e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.s0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f65475d == null || (weakReference = this.f65476e) == null || weakReference.get() == null || this.f65474c != AdLoadState.SUCCEED) {
            return;
        }
        g();
        this.f65474c = AdLoadState.SHOWED;
        if (d.a.s0.t.a.h.b.f65495a) {
            Log.d("IAdSdkSplash", "prologue ad start show");
        }
        this.f65475d.k(this.f65476e.get());
    }
}
