package com.repackage;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ki5;
import com.repackage.rb1;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sj5 implements hk5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v91 l;
    public static volatile boolean m;
    public static volatile q91 n;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public volatile AdLoadState c;
    public WeakReference<ViewGroup> d;
    public ok4 e;
    public boolean f;
    public long g;
    public final SplashNativePolicy h;
    public int i;
    public boolean j;
    public String k;

    /* loaded from: classes7.dex */
    public class a implements q91 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sj5 a;

        /* renamed from: com.repackage.sj5$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0517a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0517a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    gk5.e().n(this.a.a.e);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    gk5.e().n(this.a.a.e);
                }
            }
        }

        public a(sj5 sj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sj5Var;
        }

        @Override // com.repackage.q91
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                if (hk5.a) {
                    System.out.println("IAdSdkSplash prologue ad onskip");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 2).param(TiebaStatic.Params.OBJ_PARAM2, this.a.e == null ? 0 : this.a.e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 3).param(TiebaStatic.Params.OBJ_TO, fb5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
            }
        }

        @Override // com.repackage.q91
        public void b() {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (hk5.a) {
                    System.out.println("IAdSdkSplash prologue ad onclick");
                }
                if (this.a.e != null) {
                    if (sj5.l == null || sj5.l.b() == null) {
                        z = false;
                        z2 = false;
                    } else {
                        z = sj5.l.b().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                        z2 = sj5.l.b().optInt("full_type", 0) == 1;
                    }
                    ok4 ok4Var = this.a.e;
                    sj5 sj5Var = this.a;
                    ok4Var.e(z, z2, sj5Var.b, null, fb5.m(sj5Var.i), null);
                }
            }
        }

        @Override // com.repackage.q91
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                mk5.i(mk5.b, "1", str, null, 1, 0, this.a.f, this.a.g);
                mk5.j(mk5.b, "1", str, null, null, null, this.a.g);
                if (hk5.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash prologue ad loaded failed: " + str);
                }
                if (this.a.e != null) {
                    this.a.e.f(mk5.b, false);
                }
                this.a.c = AdLoadState.FAILED;
                if (li.C()) {
                    gk5.e().n(this.a.e);
                } else {
                    mg.a().post(new b(this));
                }
                i("advert_show", 0);
                if (this.a.h != null) {
                    this.a.h.onSplashEvent(66);
                }
            }
        }

        @Override // com.repackage.q91
        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.q91
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (hk5.a) {
                    System.out.println("IAdSdkSplash prologue ad finish");
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.e == null ? 0 : this.a.e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 2).param(TiebaStatic.Params.OBJ_TO, fb5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
                if (this.a.e != null) {
                    this.a.e.onAdDismiss();
                }
            }
        }

        @Override // com.repackage.q91
        public void f(jc1 jc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, jc1Var) == null) {
                if (hk5.a) {
                    System.out.println("IAdSdkSplash prologue gd loaded success");
                }
                this.a.c = AdLoadState.SUCCEED;
                if (this.a.e != null) {
                    this.a.e.f(mk5.b, true);
                }
                if (li.C()) {
                    gk5.e().n(this.a.e);
                } else {
                    mg.a().post(new RunnableC0517a(this));
                }
                i("advert_load", 1);
                if (this.a.h != null) {
                    if (jc1Var == null) {
                        this.a.h.onSplashEvent(66);
                    } else {
                        z91 a = jc1Var.a();
                        if (a != null) {
                            this.a.k = a.e();
                        }
                        JSONObject b2 = jc1Var.b();
                        this.a.i = b2 != null ? b2.optInt("source", -1) : -1;
                        this.a.h.onSplashEvent(65, this.a.i);
                    }
                }
                mk5.i(mk5.b, "0", null, fb5.m(this.a.i), 0, 0, this.a.f, this.a.g);
                lk5.f(this.a.i, this.a.g);
            }
        }

        @Override // com.repackage.q91
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (hk5.a) {
                    System.out.println("IAdSdkSplash prologue ad onAdPlayError");
                }
                if (this.a.e != null) {
                    this.a.e.c("play error");
                }
            }
        }

        @Override // com.repackage.q91
        @NonNull
        public ViewGroup h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (ViewGroup) this.a.d.get() : (ViewGroup) invokeV.objValue;
        }

        public final void i(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i) == null) {
                rg a = c85.a();
                a.b("type", "prologue");
                a.b("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                a.c("switch", Integer.valueOf(gk5.e().d()));
                a.c("isSuccess", Integer.valueOf(i));
                BdStatisticsManager.getInstance().debug(str, a);
            }
        }

        @Override // com.repackage.q91
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                if (hk5.a) {
                    System.out.println("IAdSdkSplash prologue ad show");
                }
                if (this.a.e != null) {
                    this.a.e.g(true, false, this.a.b);
                }
                if (!this.a.j) {
                    this.a.j = true;
                    mk5.j(mk5.b, "0", null, fb5.m(this.a.i), null, null, this.a.g);
                }
                i("advert_show", 1);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.a.e != null ? this.a.e.hashCode() : 0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements q91 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sj5 a;

        public b(sj5 sj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sj5Var;
        }

        @Override // com.repackage.q91
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || sj5.n == null) {
                return;
            }
            sj5.n.a();
        }

        @Override // com.repackage.q91
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || sj5.n == null) {
                return;
            }
            sj5.n.b();
        }

        @Override // com.repackage.q91
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (sj5.n != null) {
                    if (sj5.n != null) {
                        sj5.n.c(str);
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", str);
                ki5.c().a(this.a.f(), "onAdLoadFailed", hashMap);
            }
        }

        @Override // com.repackage.q91
        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.q91
        public void e() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || sj5.n == null) {
                return;
            }
            sj5.n.e();
        }

        @Override // com.repackage.q91
        public void f(jc1 jc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, jc1Var) == null) {
                if (sj5.n != null) {
                    if (sj5.n != null) {
                        sj5.n.f(jc1Var);
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", jc1Var);
                ki5.c().a(this.a.f(), "onAdLoaded", hashMap);
            }
        }

        @Override // com.repackage.q91
        public void g() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || sj5.n == null) {
                return;
            }
            sj5.n.g();
        }

        @Override // com.repackage.q91
        @NonNull
        public ViewGroup h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (sj5.n != null) {
                    return sj5.n.h();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // com.repackage.q91
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || sj5.n == null) {
                return;
            }
            sj5.n.onAdShow();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755318605, "Lcom/repackage/sj5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755318605, "Lcom/repackage/sj5;");
        }
    }

    public sj5(SplashNativePolicy splashNativePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {splashNativePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 5;
        this.c = AdLoadState.INIT;
        this.e = null;
        this.f = false;
        this.g = -1L;
        this.i = -1;
        this.j = false;
        this.k = null;
        this.h = splashNativePolicy;
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            u8.f().g();
        }
    }

    @Override // com.repackage.hk5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m = true;
            x(new b(this), null);
        }
    }

    @Override // com.repackage.hk5
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d.get() != null && this.d.get().getChildCount() > 0 : invokeV.booleanValue;
    }

    @Override // com.repackage.hk5
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? fb5.m(this.i) : (String) invokeV.objValue;
    }

    @Override // com.repackage.hk5
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (AdLoadState) invokeV.objValue;
    }

    @Override // com.repackage.hk5
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (l != null) {
                l.h();
                l = null;
            }
            n = null;
        }
    }

    @Override // com.repackage.hk5
    public void e(rk4 rk4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, rk4Var) == null) || rk4Var == null || rk4Var.b() == null || rk4Var.b().getContext() == null) {
            return;
        }
        this.e = rk4Var.a();
        this.f = rk4Var.d();
        this.g = rk4Var.c();
        this.d = new WeakReference<>(rk4Var.b());
        a aVar = new a(this);
        n = aVar;
        if (m) {
            t();
            m = false;
            return;
        }
        x(aVar, this.e);
    }

    @Override // com.repackage.hk5
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    public final void s() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (weakReference = this.d) == null || weakReference.get().getParent() == null || !(this.d.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.d.get().setLayoutParams(layoutParams);
    }

    @Override // com.repackage.hk5
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || l == null || (weakReference = this.d) == null || weakReference.get() == null || this.c != AdLoadState.SUCCEED) {
            return;
        }
        s();
        this.c = AdLoadState.SHOWED;
        if (hk5.a) {
            System.out.println("IAdSdkSplash prologue ad start show");
        }
        l.n(this.d.get());
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || n == null || ki5.c().d(f()).isEmpty()) {
            return;
        }
        for (ki5.a aVar : ki5.c().d(f())) {
            String str = aVar.a;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -610376507) {
                if (hashCode == 861234439 && str.equals("onAdLoaded")) {
                    c = 0;
                }
            } else if (str.equals("onAdLoadFailed")) {
                c = 1;
            }
            if (c == 0) {
                n.f((jc1) aVar.b.get("data"));
            } else if (c == 1) {
                n.c((String) aVar.b.get("data"));
            }
        }
        ki5.c().b(f());
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (ki5.c().d(f()).isEmpty()) {
                return false;
            }
            for (ki5.a aVar : ki5.c().d(f())) {
                if ("onAdLoaded".equals(aVar.a)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? !ki5.c().d(f()).isEmpty() : invokeV.booleanValue;
    }

    public final void x(q91 q91Var, ok4 ok4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, q91Var, ok4Var) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                rb1.b bVar = new rb1.b();
                bVar.j(li.k(context));
                bVar.k(li.i(context));
                l = new v91(context, y91.m(), bVar.i(), q91Var);
                this.c = AdLoadState.LOADING;
                l.i();
                if (hk5.a) {
                    System.out.println("IAdSdkSplash prologue ad start load");
                }
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (ok4Var != null) {
                    ok4Var.c("oom");
                }
            }
        }
    }
}
