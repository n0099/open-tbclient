package com.repackage;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.dialog.CoinClickDialog;
import com.baidu.swan.game.guide.view.GameGuideView;
import com.baidu.swan.game.guide.view.GameGuideViewContainer;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rd3;
import com.repackage.rl2;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class sq3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 0;
    public static boolean b = false;
    public static long c = 0;
    public static GameGuideConfigInfo d = null;
    public static GameGuideView e = null;
    public static String f = "";
    public static String g = "";
    public static int h = 0;
    public static GameGuideViewContainer i = null;
    public static String j = null;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = true;
    public static tf3 n;
    public static final sq3 o;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            String string;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                Bundle bundle2 = new Bundle();
                if (bundle != null && (string = bundle.getString("type", "")) != null) {
                    switch (string.hashCode()) {
                        case -1261832223:
                            if (string.equals("addCoins")) {
                                int i2 = bundle.getInt("coinsNum", 0);
                                sq3 sq3Var = sq3.o;
                                sq3.h += i2;
                                GameGuideConfigInfo z = sq3.o.z();
                                if (z != null) {
                                    sq3 sq3Var2 = sq3.o;
                                    int i3 = sq3.h;
                                    int i4 = z.maxNums;
                                    if (i3 > i4) {
                                        sq3 sq3Var3 = sq3.o;
                                        sq3.h = i4;
                                    }
                                }
                                sq3.o.S(sq3.h);
                                break;
                            }
                            break;
                        case -977015124:
                            if (string.equals("setHasShowedTips")) {
                                sq3.o.X(true);
                                break;
                            }
                            break;
                        case -426887517:
                            if (string.equals("setPlayTime")) {
                                sq3.o.Z(bundle.getLong("playTime", 0L));
                                break;
                            }
                            break;
                        case -338307689:
                            if (string.equals("getPlayTime")) {
                                sq3 sq3Var4 = sq3.o;
                                bundle2.putLong("playTime", sq3.a);
                                break;
                            }
                            break;
                        case 45198779:
                            if (string.equals("onGameTimeUsed")) {
                                sq3.o.d0();
                                break;
                            }
                            break;
                        case 142663368:
                            if (string.equals("initGameGuideInfo")) {
                                long F = sq3.o.F();
                                if (0 <= F && SapiWebView.DEFAULT_TIMEOUT_MILLIS >= F) {
                                    sq3 sq3Var5 = sq3.o;
                                    sq3.a = F;
                                }
                                int J = sq3.o.J();
                                GameGuideConfigInfo z2 = sq3.o.z();
                                if (z2 != null && J > (i = z2.maxNums)) {
                                    sq3.o.S(i);
                                    J = i;
                                }
                                sq3 sq3Var6 = sq3.o;
                                sq3.h = J;
                                break;
                            }
                            break;
                        case 854427704:
                            if (string.equals("getHasShowedTips")) {
                                bundle2.putBoolean("hasShowedTips", sq3.o.E());
                                break;
                            }
                            break;
                        case 1950665292:
                            if (string.equals("getCoins")) {
                                sq3 sq3Var7 = sq3.o;
                                bundle2.putInt("coinsNum", sq3.h);
                                break;
                            }
                            break;
                    }
                }
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-5320322, "Lcom/repackage/sq3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-5320322, "Lcom/repackage/sq3$b;");
                    return;
                }
            }
            a = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u03 a0 = u03.a0();
                if (a0 == null) {
                    if (eh1.a) {
                        Log.d("GamenowPlaytimeManager", "非法小游戏");
                    }
                    pr3.n().a("小游戏非法");
                    sq3.o.a0(false);
                    return;
                }
                String cacheConfig = rq3.c().e(a0.N());
                if (TextUtils.isEmpty(cacheConfig)) {
                    pr3 n = pr3.n();
                    sq3 sq3Var = sq3.o;
                    n.d("start", sq3.k, "");
                    sq3.o.R();
                    return;
                }
                if (eh1.a) {
                    Log.d("GamenowPlaytimeManager", "展示缓存数据， 小游戏为  " + a0.Y());
                }
                sq3 sq3Var2 = sq3.o;
                sq3.k = true;
                pr3 n2 = pr3.n();
                sq3 sq3Var3 = sq3.o;
                n2.d("start", sq3.k, "");
                sq3 sq3Var4 = sq3.o;
                Intrinsics.checkNotNullExpressionValue(cacheConfig, "cacheConfig");
                sq3Var4.O(cacheConfig);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements LottieListener<LottieComposition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameGuideConfigInfo a;

        public c(GameGuideConfigInfo gameGuideConfigInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideConfigInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameGuideConfigInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                GameGuideConfigInfo.ViewInfo viewInfo = this.a.viewInfo;
                if (viewInfo != null) {
                    viewInfo.iconDoneLottie = lottieComposition;
                }
                sq3.o.y(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-5320260, "Lcom/repackage/sq3$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-5320260, "Lcom/repackage/sq3$d;");
                    return;
                }
            }
            a = new d();
        }

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                sq3.o.a0(false);
                pr3 n = pr3.n();
                sq3 sq3Var = sq3.o;
                n.d(com.baidu.pass.biometrics.face.liveness.b.a.g0, sq3.k, "下发配置中导流view的资源不可用");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements rd3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameGuideConfigInfo a;

        /* loaded from: classes7.dex */
        public static final class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    sq3.o.c0(this.a.a);
                }
            }
        }

        public e(GameGuideConfigInfo gameGuideConfigInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideConfigInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameGuideConfigInfo;
        }

        @Override // com.repackage.rd3.b
        public final void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    sq3.o.a0(false);
                    if (eh1.a) {
                        Log.e("GamenowPlaytimeManager", "下载导流view的图片失败， url = " + str);
                    }
                    pr3 n = pr3.n();
                    sq3 sq3Var = sq3.o;
                    n.d(com.baidu.pass.biometrics.face.liveness.b.a.g0, sq3.k, "下发配置中导流view的资源不可用");
                    return;
                }
                bitmap.setDensity(480);
                GameGuideConfigInfo.ViewInfo viewInfo = this.a.viewInfo;
                if (viewInfo != null) {
                    viewInfo.iconNormalImg = bitmap;
                }
                u03 a0 = u03.a0();
                if (a0 == null) {
                    sq3.o.a0(false);
                    pr3 n2 = pr3.n();
                    sq3 sq3Var2 = sq3.o;
                    n2.d(com.baidu.pass.biometrics.face.liveness.b.a.g0, sq3.k, "小游戏非法");
                    return;
                }
                SwanAppActivity x = a0.x();
                Intrinsics.checkNotNullExpressionValue(x, "swanApp.swanActivity");
                if (x.isDestroyed()) {
                    sq3.o.a0(false);
                    pr3 n3 = pr3.n();
                    sq3 sq3Var3 = sq3.o;
                    n3.d(com.baidu.pass.biometrics.face.liveness.b.a.g0, sq3.k, "小游戏非法");
                    return;
                }
                sq3.o.a0(true);
                sq3.o.T(this.a);
                sq3.o.K();
                oe3.e0(new a(this));
                sq3 sq3Var4 = sq3.o;
                String str2 = sq3.j;
                if (str2 != null) {
                    sq3 sq3Var5 = sq3.o;
                    if (sq3.k || this.a.expirationTime <= 0) {
                        return;
                    }
                    rq3.c().a(a0.N(), str2, SystemClock.elapsedRealtime() + this.a.expirationTime);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (str == null || str.length() == 0) {
                    if (eh1.a) {
                        Log.e("GamenowPlaytimeManager", "配置信息下发异常，code = " + i + ",  response = " + str);
                    }
                    sq3.o.a0(false);
                    pr3 n = pr3.n();
                    sq3 sq3Var = sq3.o;
                    n.d(com.baidu.pass.biometrics.face.liveness.b.a.g0, sq3.k, "下发数据非法");
                    return;
                }
                if (eh1.a) {
                    Log.d("GamenowPlaytimeManager", "配置信息 =   " + str);
                }
                sq3.o.O(str);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (eh1.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("请求配置信息失败，err = ");
                    sb.append(exc != null ? exc.getMessage() : null);
                    Log.e("GamenowPlaytimeManager", sb.toString());
                }
                sq3.o.a0(false);
                pr3 n = pr3.n();
                sq3 sq3Var = sq3.o;
                n.d(com.baidu.pass.biometrics.face.liveness.b.a.g0, sq3.k, "网络请求失败");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public static final g a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-5320167, "Lcom/repackage/sq3$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-5320167, "Lcom/repackage/sq3$g;");
                    return;
                }
            }
            a = new g();
        }

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                sq3.o.N();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class h implements tf3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.repackage.tf3
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sq3.o.P();
            }
        }

        @Override // com.repackage.tf3
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                sq3 sq3Var = sq3.o;
                GameGuideView gameGuideView = sq3.e;
                if (gameGuideView != null) {
                    gameGuideView.p();
                }
                rr3.f.k();
            }
        }

        @Override // com.repackage.tf3
        public void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                rr3.f.j();
                sq3 sq3Var = sq3.o;
                GameGuideView gameGuideView = sq3.e;
                if (gameGuideView != null) {
                    gameGuideView.o(rr3.f.f());
                }
                hm2.U().c();
                if (sq3.o.C()) {
                    sq3.o.Q();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755311940, "Lcom/repackage/sq3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755311940, "Lcom/repackage/sq3;");
                return;
            }
        }
        o = new sq3();
        n = new h();
    }

    public sq3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final long A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return a;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "getPlayTime");
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
            Intrinsics.checkNotNullExpressionValue(callOnMainWithContentProvider, "DelegateUtils.callOnMain…tion::class.java, bundle)");
            if (callOnMainWithContentProvider.isOk()) {
                return callOnMainWithContentProvider.mResult.getLong("playTime", 0L);
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final GameGuideViewContainer B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? i : (GameGuideViewContainer) invokeV.objValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            boolean z = i93.a().getBoolean("hasChoiceNotShow", false);
            l = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = i93.a().getBoolean("hasInstallResult", true);
            m = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? i93.a().getBoolean("key_gt_ths", false) : invokeV.booleanValue;
    }

    public final long F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? i93.a().getLong("key_l_gt", 0L) : invokeV.longValue;
    }

    public final int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return h;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "getCoins");
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
            Intrinsics.checkNotNullExpressionValue(callOnMainWithContentProvider, "DelegateUtils.callOnMain…tion::class.java, bundle)");
            if (callOnMainWithContentProvider.isOk()) {
                return callOnMainWithContentProvider.mResult.getInt("coinsNum", 0);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? g : (String) invokeV.objValue;
    }

    public final String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? f : (String) invokeV.objValue;
    }

    public final int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? i93.a().getInt("coinsNum", 0) : invokeV.intValue;
    }

    public final void K() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (ProcessUtils.isMainProcess()) {
                long F = F();
                if (0 <= F && SapiWebView.DEFAULT_TIMEOUT_MILLIS >= F) {
                    a = F;
                }
                int J = J();
                GameGuideConfigInfo gameGuideConfigInfo = d;
                if (gameGuideConfigInfo != null && J > (i2 = gameGuideConfigInfo.maxNums)) {
                    o.S(i2);
                    J = i2;
                }
                h = J;
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "initGameGuideInfo");
            Intrinsics.checkNotNullExpressionValue(DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle), "DelegateUtils.callOnMain…tion::class.java, bundle)");
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (b) {
                return true;
            }
            if (ProcessUtils.isMainProcess()) {
                boolean E = E();
                b = E;
                return E;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "getHasShowedTips");
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
            Intrinsics.checkNotNullExpressionValue(callOnMainWithContentProvider, "DelegateUtils.callOnMain…tion::class.java, bundle)");
            if (callOnMainWithContentProvider.isOk()) {
                boolean z = callOnMainWithContentProvider.mResult.getBoolean("hasShowedTips", false);
                b = z;
                return z;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (ProcessUtils.isMainProcess()) {
                d0();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "onGameTimeUsed");
            Intrinsics.checkNotNullExpressionValue(DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle), "DelegateUtils.callOnMain…tion::class.java, bundle)");
        }
    }

    public final void N() {
        GameGuideConfigInfo gameGuideConfigInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (gameGuideConfigInfo = d) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - c < 500) {
            if (eh1.a) {
                Log.d("GamenowPlaytimeManager", "快速点击");
                return;
            }
            return;
        }
        u03 a0 = u03.a0();
        if (a0 != null) {
            c = currentTimeMillis;
            long f2 = rr3.f.f() / 30000;
            if (f2 <= 0) {
                if (eh1.a) {
                    Log.d("GamenowPlaytimeManager", "时长没有满足一个豆以上");
                }
            } else if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
                if (eh1.a) {
                    Log.d("GamenowPlaytimeManager", "没有网络");
                }
                m03.g(AppRuntime.getAppContext(), "网络异常，请稍后重试").G();
            } else {
                int i2 = (int) f2;
                pr3.n().i(i2);
                int i3 = gameGuideConfigInfo.perCoinNum * i2;
                int G = G();
                boolean z = G >= gameGuideConfigInfo.maxNums;
                if (eh1.a) {
                    Log.d("GamenowPlaytimeManager", "before    expectedRewardCoins = " + i3 + " , currentRewardCoinsNum = " + G + ",  isMax = " + z);
                }
                int i4 = i3 + G;
                int i5 = gameGuideConfigInfo.maxNums;
                if (i4 > i5) {
                    i3 = i5 - G;
                }
                if (eh1.a) {
                    Log.d("GamenowPlaytimeManager", "after    realRewardCoins = " + i3);
                }
                if (!z) {
                    rr3.f.h();
                    GameGuideView gameGuideView = e;
                    if (gameGuideView != null) {
                        gameGuideView.r();
                    }
                    v(i3);
                }
                hm2.U().p();
                Intent intent = new Intent(a0.x(), CoinClickDialog.class);
                intent.putExtra(CoinClickDialog.KEY_IS_SHOW_MAX, z);
                intent.putExtra(CoinClickDialog.KEY_COINS_REWARD_THIS_TIME, i3);
                intent.putExtra(CoinClickDialog.KEY_COINS_REWARD_TOTAL, G + i3);
                a0.x().startActivity(intent);
            }
        }
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt != 0) {
                    if (eh1.a) {
                        Log.e("GamenowPlaytimeManager", "返回结果异常，errNo = " + optInt + "， response = " + str);
                    }
                    pr3.n().d(com.baidu.pass.biometrics.face.liveness.b.a.g0, k, "下发数据非法");
                    return;
                }
                GameGuideConfigInfo parseData = GameGuideConfigInfo.parseData(jSONObject.optJSONObject("data"));
                if (parseData == null) {
                    if (eh1.a) {
                        Log.d("GamenowPlaytimeManager", "配置信息下发异常");
                    }
                    pr3.n().d(com.baidu.pass.biometrics.face.liveness.b.a.g0, k, "下发数据非法");
                    return;
                }
                W(parseData.install_result);
                String str2 = parseData.targetAppPackageId;
                Intrinsics.checkNotNullExpressionValue(str2, "configInfo.targetAppPackageId");
                f = str2;
                String str3 = parseData.targetAppDownloadUrl;
                Intrinsics.checkNotNullExpressionValue(str3, "configInfo.targetAppDownloadUrl");
                g = str3;
                if (parseData.status == 0) {
                    if (eh1.a) {
                        Log.d("GamenowPlaytimeManager", "下发数据 status = 0，不展示");
                    }
                    u03 a0 = u03.a0();
                    if (!k && parseData.expirationTime > 0 && a0 != null) {
                        rq3.c().a(a0.N(), str, SystemClock.elapsedRealtime() + parseData.expirationTime);
                    }
                    pr3.n().d(com.baidu.pass.biometrics.face.liveness.b.a.g0, k, "配置下发不展示");
                    return;
                }
                j = str;
                if (parseData.popupSelection == 2) {
                    d = parseData;
                } else if (C()) {
                    pr3.n().a("hasClosedWithNotShow");
                    d = parseData;
                } else {
                    x(parseData);
                }
                pr3.n().d("success", k, "");
            } catch (Throwable th) {
                if (eh1.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("解析配置信息失败，err = ");
                    th.printStackTrace();
                    sb.append(Unit.INSTANCE);
                    Log.e("GamenowPlaytimeManager", sb.toString());
                }
                pr3.n().d(com.baidu.pass.biometrics.face.liveness.b.a.g0, k, "下发数据非法");
            }
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            e = null;
            i = null;
            k = false;
        }
    }

    public final void Q() {
        GameGuideViewContainer gameGuideViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (gameGuideViewContainer = i) == null) {
            return;
        }
        hm2 U = hm2.U();
        Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
        U.X().f(n);
        hm2 U2 = hm2.U();
        Intrinsics.checkNotNullExpressionValue(U2, "SwanAppController.getInstance()");
        li1 X = U2.X();
        Intrinsics.checkNotNullExpressionValue(X, "SwanAppController.getIns…swanGameNARootViewManager");
        FrameLayout rootView = X.getRootView();
        if (rootView != null) {
            rootView.removeView(gameGuideViewContainer);
        }
        o.P();
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            u03 L = u03.L();
            if (L == null) {
                pr3.n().d(com.baidu.pass.biometrics.face.liveness.b.a.g0, k, "小游戏非法");
                return;
            }
            String i2 = bk2.h0().i(AppRuntime.getAppContext());
            if (i2 == null) {
                i2 = "";
            }
            String h2 = z93.h(1);
            w53 a2 = bk2.q().a();
            Application c2 = bk2.c();
            Intrinsics.checkNotNullExpressionValue(c2, "SwanAppRuntime.getAppContext()");
            rl2.a V = L.V();
            Intrinsics.checkNotNullExpressionValue(V, "swanApp.info");
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) L.h0().postFormRequest().url("https://gamecenter.baidu.com/api/minigame/get_flowout_config")).cookieManager(a2)).addParam("cuid", i2).addParam("appkey", L.N()).addParam("host", c2.getPackageName()).addParam("from", V.T()).addParam("gamecore_version", h2).requestFrom(16)).requestSubFrom(1602)).build().executeAsync(new f());
        }
    }

    public final void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            i93.a().putInt("coinsNum", i2);
        }
    }

    public final void T(GameGuideConfigInfo gameGuideConfigInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, gameGuideConfigInfo) == null) {
            d = gameGuideConfigInfo;
        }
    }

    public final void U(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            if (ProcessUtils.isMainProcess()) {
                Z(j2);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "setPlayTime");
            bundle.putLong("playTime", j2);
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
        }
    }

    public final void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            l = z;
            i93.a().putBoolean("hasChoiceNotShow", z);
        }
    }

    public final void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            m = z;
            i93.a().putBoolean("hasInstallResult", z);
        }
    }

    public final void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            i93.a().putBoolean("key_gt_ths", z);
        }
    }

    public final void Y(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j2) == null) {
            i93.a().putLong("key_l_gt", j2);
        }
    }

    public final void Z(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) {
            if (j2 < 0) {
                if (eh1.a) {
                    Log.d("GamenowPlaytimeManager", "游戏时长不能为负数");
                    return;
                }
                return;
            }
            if (j2 > SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                j2 = 90000;
            }
            a = j2;
            Y(j2);
        }
    }

    public final void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || b) {
            return;
        }
        b = true;
        if (ProcessUtils.isMainProcess()) {
            X(true);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "setHasShowedTips");
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
    }

    public final void c0(GameGuideConfigInfo gameGuideConfigInfo) {
        GameGuideConfigInfo.ViewInfo viewInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, gameGuideConfigInfo) == null) || (viewInfo = gameGuideConfigInfo.viewInfo) == null) {
            return;
        }
        pr3.n().l();
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "AppRuntime.getAppContext()");
        Resources resources = appContext.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700ed) + resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070171) + le3.g(10.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388613;
        u03 a0 = u03.a0();
        if (a0 != null) {
            i = new GameGuideViewContainer(bk2.c());
            int e2 = de3.e(a0.x());
            if (de3.d()) {
                layoutParams.topMargin = dimensionPixelSize + e2;
            } else {
                layoutParams.topMargin = dimensionPixelSize;
            }
            hm2 U = hm2.U();
            Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
            li1 X = U.X();
            Intrinsics.checkNotNullExpressionValue(X, "SwanAppController.getIns…swanGameNARootViewManager");
            X.getRootView().addView(i, layoutParams);
            Context appContext2 = AppRuntime.getAppContext();
            Intrinsics.checkNotNullExpressionValue(appContext2, "AppRuntime.getAppContext()");
            LottieComposition lottieComposition = viewInfo.iconDoneLottie;
            Intrinsics.checkNotNullExpressionValue(lottieComposition, "it.iconDoneLottie");
            Bitmap bitmap = viewInfo.iconNormalImg;
            Intrinsics.checkNotNullExpressionValue(bitmap, "it.iconNormalImg");
            String str = viewInfo.progressColor;
            Intrinsics.checkNotNullExpressionValue(str, "it.progressColor");
            String str2 = viewInfo.tips;
            Intrinsics.checkNotNullExpressionValue(str2, "it.tips");
            GameGuideView gameGuideView = new GameGuideView(appContext2, lottieComposition, bitmap, str, str2);
            e = gameGuideView;
            GameGuideViewContainer gameGuideViewContainer = i;
            if (gameGuideViewContainer != null) {
                gameGuideViewContainer.addView(gameGuideView);
            }
            hm2 U2 = hm2.U();
            Intrinsics.checkNotNullExpressionValue(U2, "SwanAppController.getInstance()");
            U2.X().e(n);
            GameGuideView gameGuideView2 = e;
            if (gameGuideView2 != null) {
                gameGuideView2.setOnClickListener(g.a);
            }
            if (rr3.f.g()) {
                return;
            }
            rr3.f.j();
            GameGuideView gameGuideView3 = e;
            if (gameGuideView3 != null) {
                gameGuideView3.o(rr3.f.f());
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            long j2 = a;
            if (j2 < 30000) {
                return;
            }
            long j3 = j2 % 30000;
            a = j3;
            Y(j3);
        }
    }

    public final void v(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            if (ProcessUtils.isMainProcess()) {
                int i4 = h + i2;
                h = i4;
                GameGuideConfigInfo gameGuideConfigInfo = d;
                if (gameGuideConfigInfo != null && i4 > (i3 = gameGuideConfigInfo.maxNums)) {
                    h = i3;
                }
                S(h);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "addCoins");
            bundle.putInt("coinsNum", i2);
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            od3.k(b.a, "thread_gamenowGuideInitAndCheck");
        }
    }

    public final void x(GameGuideConfigInfo gameGuideConfigInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, gameGuideConfigInfo) == null) {
            Context appContext = AppRuntime.getAppContext();
            GameGuideConfigInfo.ViewInfo viewInfo = gameGuideConfigInfo.viewInfo;
            LottieCompositionFactory.fromUrl(appContext, viewInfo != null ? viewInfo.iconDoneUrl : null).addListener(new c(gameGuideConfigInfo)).addFailureListener(d.a);
        }
    }

    public final void y(GameGuideConfigInfo gameGuideConfigInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, gameGuideConfigInfo) == null) {
            GameGuideConfigInfo.ViewInfo viewInfo = gameGuideConfigInfo.viewInfo;
            rd3.e(viewInfo != null ? viewInfo.iconNormalUrl : null, new e(gameGuideConfigInfo));
        }
    }

    public final GameGuideConfigInfo z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? d : (GameGuideConfigInfo) invokeV.objValue;
    }
}
