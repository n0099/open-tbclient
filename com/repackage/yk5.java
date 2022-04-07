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
import com.repackage.tc1;
import com.repackage.yi5;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yk5 implements ml5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xa1 k;
    public static volatile boolean l;
    public static volatile sa1 m;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public volatile AdLoadState c;
    public WeakReference<ViewGroup> d;
    public rl4 e;
    public boolean f;
    public long g;
    public final SplashNativePolicy h;
    public int i;
    public boolean j;

    /* loaded from: classes7.dex */
    public class a implements sa1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk5 a;

        /* renamed from: com.repackage.yk5$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0557a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0557a(a aVar) {
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
                    ll5.e().n(this.a.a.e);
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
                    ll5.e().n(this.a.a.e);
                }
            }
        }

        public a(yk5 yk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yk5Var;
        }

        @Override // com.repackage.sa1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                if (ml5.a) {
                    System.out.println("IAdSdkSplash prologue ad onskip");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 2).param(TiebaStatic.Params.OBJ_PARAM2, this.a.e == null ? 0 : this.a.e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 3).param(TiebaStatic.Params.OBJ_TO, ub5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f ? 2 : 1).param("fid", this.a.g).eventStat();
            }
        }

        @Override // com.repackage.sa1
        public void b() {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (ml5.a) {
                    System.out.println("IAdSdkSplash prologue ad onclick");
                }
                if (this.a.e != null) {
                    if (yk5.k == null || yk5.k.a() == null) {
                        z = false;
                        z2 = false;
                    } else {
                        z = yk5.k.a().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                        z2 = yk5.k.a().optInt("full_type", 0) == 1;
                    }
                    rl4 rl4Var = this.a.e;
                    yk5 yk5Var = this.a;
                    rl4Var.d(z, z2, yk5Var.b, null, ub5.m(yk5Var.i), null);
                }
            }
        }

        @Override // com.repackage.sa1
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                rl5.i(rl5.b, "1", str, null, 1, 0, this.a.f, this.a.g);
                rl5.j(rl5.b, "1", str, null, null, null, this.a.g);
                if (ml5.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash prologue ad loaded failed: " + str);
                }
                if (this.a.e != null) {
                    this.a.e.f(rl5.b);
                }
                this.a.c = AdLoadState.FAILED;
                if (oi.B()) {
                    ll5.e().n(this.a.e);
                } else {
                    pg.a().post(new b(this));
                }
                i("advert_show", 0);
                if (this.a.h != null) {
                    this.a.h.onSplashEvent(66);
                }
            }
        }

        @Override // com.repackage.sa1
        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.sa1
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (ml5.a) {
                    System.out.println("IAdSdkSplash prologue ad finish");
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.e == null ? 0 : this.a.e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 2).param(TiebaStatic.Params.OBJ_TO, ub5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f ? 2 : 1).param("fid", this.a.g).eventStat();
                if (this.a.e != null) {
                    this.a.e.onAdDismiss();
                }
            }
        }

        @Override // com.repackage.sa1
        public void f(ld1 ld1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, ld1Var) == null) {
                if (ml5.a) {
                    System.out.println("IAdSdkSplash prologue gd loaded success");
                }
                this.a.c = AdLoadState.SUCCEED;
                if (this.a.e != null) {
                    this.a.e.f(rl5.b);
                }
                if (oi.B()) {
                    ll5.e().n(this.a.e);
                } else {
                    pg.a().post(new RunnableC0557a(this));
                }
                i("advert_load", 1);
                if (this.a.h != null) {
                    if (ld1Var == null) {
                        this.a.h.onSplashEvent(66);
                    } else {
                        JSONObject a = ld1Var.a();
                        this.a.i = a != null ? a.optInt("source", -1) : -1;
                        this.a.h.onSplashEvent(65, this.a.i);
                    }
                }
                rl5.i(rl5.b, "0", null, ub5.m(this.a.i), 0, 0, this.a.f, this.a.g);
                ql5.f(this.a.i, this.a.g);
            }
        }

        @Override // com.repackage.sa1
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (ml5.a) {
                    System.out.println("IAdSdkSplash prologue ad onAdPlayError");
                }
                if (this.a.e != null) {
                    this.a.e.c("play error");
                }
            }
        }

        @Override // com.repackage.sa1
        @NonNull
        public ViewGroup h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (ViewGroup) this.a.d.get() : (ViewGroup) invokeV.objValue;
        }

        public final void i(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i) == null) {
                ug a = r85.a();
                a.b("type", "prologue");
                a.b("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                a.c("switch", Integer.valueOf(ll5.e().d()));
                a.c("isSuccess", Integer.valueOf(i));
                BdStatisticsManager.getInstance().debug(str, a);
            }
        }

        @Override // com.repackage.sa1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                if (ml5.a) {
                    System.out.println("IAdSdkSplash prologue ad show");
                }
                if (this.a.e != null) {
                    this.a.e.g(true, false, this.a.b);
                }
                if (!this.a.j) {
                    this.a.j = true;
                    rl5.j(rl5.b, "0", null, ub5.m(this.a.i), null, null, this.a.g);
                }
                i("advert_show", 1);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.a.e != null ? this.a.e.hashCode() : 0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements sa1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk5 a;

        public b(yk5 yk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yk5Var;
        }

        @Override // com.repackage.sa1
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || yk5.m == null) {
                return;
            }
            yk5.m.a();
        }

        @Override // com.repackage.sa1
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || yk5.m == null) {
                return;
            }
            yk5.m.b();
        }

        @Override // com.repackage.sa1
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (yk5.m != null) {
                    if (yk5.m != null) {
                        yk5.m.c(str);
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", str);
                yi5.c().a(this.a.f(), "onAdLoadFailed", hashMap);
            }
        }

        @Override // com.repackage.sa1
        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.sa1
        public void e() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || yk5.m == null) {
                return;
            }
            yk5.m.e();
        }

        @Override // com.repackage.sa1
        public void f(ld1 ld1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, ld1Var) == null) {
                if (yk5.m != null) {
                    if (yk5.m != null) {
                        yk5.m.f(ld1Var);
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", ld1Var);
                yi5.c().a(this.a.f(), "onAdLoaded", hashMap);
            }
        }

        @Override // com.repackage.sa1
        public void g() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || yk5.m == null) {
                return;
            }
            yk5.m.g();
        }

        @Override // com.repackage.sa1
        @NonNull
        public ViewGroup h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (yk5.m != null) {
                    return yk5.m.h();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // com.repackage.sa1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || yk5.m == null) {
                return;
            }
            yk5.m.onAdShow();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755138898, "Lcom/repackage/yk5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755138898, "Lcom/repackage/yk5;");
        }
    }

    public yk5(SplashNativePolicy splashNativePolicy) {
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
        this.h = splashNativePolicy;
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            u8.f().g();
        }
    }

    @Override // com.repackage.ml5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l = true;
            v(new b(this), null);
        }
    }

    @Override // com.repackage.ml5
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d.get() != null && this.d.get().getChildCount() > 0 : invokeV.booleanValue;
    }

    @Override // com.repackage.ml5
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ub5.m(this.i) : (String) invokeV.objValue;
    }

    @Override // com.repackage.ml5
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (AdLoadState) invokeV.objValue;
    }

    @Override // com.repackage.ml5
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (k != null) {
                k.g();
                k = null;
            }
            m = null;
        }
    }

    @Override // com.repackage.ml5
    public void e(ul4 ul4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ul4Var) == null) || ul4Var == null || ul4Var.b() == null || ul4Var.b().getContext() == null) {
            return;
        }
        this.e = ul4Var.a();
        this.f = ul4Var.d();
        this.g = ul4Var.c();
        this.d = new WeakReference<>(ul4Var.b());
        a aVar = new a(this);
        m = aVar;
        if (l) {
            t();
            l = false;
            return;
        }
        v(aVar, this.e);
    }

    @Override // com.repackage.ml5
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

    @Override // com.repackage.ml5
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || k == null || (weakReference = this.d) == null || weakReference.get() == null || this.c != AdLoadState.SUCCEED) {
            return;
        }
        s();
        this.c = AdLoadState.SHOWED;
        if (ml5.a) {
            System.out.println("IAdSdkSplash prologue ad start show");
        }
        k.m(this.d.get());
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || m == null || yi5.c().d(f()).isEmpty()) {
            return;
        }
        for (yi5.a aVar : yi5.c().d(f())) {
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
                m.f((ld1) aVar.b.get("data"));
            } else if (c == 1) {
                m.c((String) aVar.b.get("data"));
            }
        }
        yi5.c().b(f());
    }

    public final void v(sa1 sa1Var, rl4 rl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, sa1Var, rl4Var) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                tc1.b bVar = new tc1.b();
                bVar.j(oi.k(context));
                bVar.k(oi.i(context));
                k = new xa1(context, ab1.m(), bVar.i(), sa1Var);
                this.c = AdLoadState.LOADING;
                k.h();
                if (ml5.a) {
                    System.out.println("IAdSdkSplash prologue ad start load");
                }
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (rl4Var != null) {
                    rl4Var.c("oom");
                }
            }
        }
    }
}
