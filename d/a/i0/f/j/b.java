package d.a.i0.f.j;

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
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.p.b.a.n;
import d.a.i0.a.v2.f0;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.q;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.t;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static long f46675a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f46676b = false;

    /* renamed from: c  reason: collision with root package name */
    public static long f46677c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static GameGuideConfigInfo f46678d = null;

    /* renamed from: e  reason: collision with root package name */
    public static GameGuideView f46679e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f46680f = "";

    /* renamed from: g  reason: collision with root package name */
    public static String f46681g = "";

    /* renamed from: h  reason: collision with root package name */
    public static int f46682h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static GameGuideViewContainer f46683i = null;
    public static String j = null;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = true;
    public static final b o = new b();
    public static d.a.i0.a.w2.c n = new h();

    /* loaded from: classes3.dex */
    public static final class a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            String string;
            int i2;
            Bundle bundle2 = new Bundle();
            if (bundle != null && (string = bundle.getString("type", "")) != null) {
                switch (string.hashCode()) {
                    case -1261832223:
                        if (string.equals("addCoins")) {
                            int i3 = bundle.getInt("coinsNum", 0);
                            b bVar = b.o;
                            b.f46682h += i3;
                            GameGuideConfigInfo z = b.o.z();
                            if (z != null) {
                                b bVar2 = b.o;
                                int i4 = b.f46682h;
                                int i5 = z.maxNums;
                                if (i4 > i5) {
                                    b bVar3 = b.o;
                                    b.f46682h = i5;
                                }
                            }
                            b.o.S(b.f46682h);
                            break;
                        }
                        break;
                    case -977015124:
                        if (string.equals("setHasShowedTips")) {
                            b.o.X(true);
                            break;
                        }
                        break;
                    case -426887517:
                        if (string.equals("setPlayTime")) {
                            b.o.Z(bundle.getLong("playTime", 0L));
                            break;
                        }
                        break;
                    case -338307689:
                        if (string.equals("getPlayTime")) {
                            b bVar4 = b.o;
                            bundle2.putLong("playTime", b.f46675a);
                            break;
                        }
                        break;
                    case 45198779:
                        if (string.equals("onGameTimeUsed")) {
                            b.o.d0();
                            break;
                        }
                        break;
                    case 142663368:
                        if (string.equals("initGameGuideInfo")) {
                            long F = b.o.F();
                            if (0 <= F && SapiWebView.DEFAULT_TIMEOUT_MILLIS >= F) {
                                b bVar5 = b.o;
                                b.f46675a = F;
                            }
                            int J = b.o.J();
                            GameGuideConfigInfo z2 = b.o.z();
                            if (z2 != null && J > (i2 = z2.maxNums)) {
                                b.o.S(i2);
                                J = i2;
                            }
                            b bVar6 = b.o;
                            b.f46682h = J;
                            break;
                        }
                        break;
                    case 854427704:
                        if (string.equals("getHasShowedTips")) {
                            bundle2.putBoolean("hasShowedTips", b.o.E());
                            break;
                        }
                        break;
                    case 1950665292:
                        if (string.equals("getCoins")) {
                            b bVar7 = b.o;
                            bundle2.putInt("coinsNum", b.f46682h);
                            break;
                        }
                        break;
                }
            }
            return bundle2;
        }
    }

    /* renamed from: d.a.i0.f.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class RunnableC0978b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public static final RunnableC0978b f46684e = new RunnableC0978b();

        @Override // java.lang.Runnable
        public final void run() {
            d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
            if (Q == null) {
                if (d.a.i0.a.k.f43025a) {
                    Log.d("GamenowPlaytimeManager", "非法小游戏");
                }
                d.a.i0.f.j.r.b.n().a("小游戏非法");
                b.o.a0(false);
                return;
            }
            String cacheConfig = d.a.i0.f.j.a.c().e(Q.D());
            if (TextUtils.isEmpty(cacheConfig)) {
                d.a.i0.f.j.r.b n = d.a.i0.f.j.r.b.n();
                b bVar = b.o;
                n.d(IntentConfig.START, b.k, "");
                b.o.R();
                return;
            }
            if (d.a.i0.a.k.f43025a) {
                Log.d("GamenowPlaytimeManager", "展示缓存数据， 小游戏为  " + Q.O());
            }
            b bVar2 = b.o;
            b.k = true;
            d.a.i0.f.j.r.b n2 = d.a.i0.f.j.r.b.n();
            b bVar3 = b.o;
            n2.d(IntentConfig.START, b.k, "");
            b bVar4 = b.o;
            Intrinsics.checkNotNullExpressionValue(cacheConfig, "cacheConfig");
            bVar4.O(cacheConfig);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c<T> implements LottieListener<LottieComposition> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GameGuideConfigInfo f46685a;

        public c(GameGuideConfigInfo gameGuideConfigInfo) {
            this.f46685a = gameGuideConfigInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(LottieComposition lottieComposition) {
            GameGuideConfigInfo.ViewInfo viewInfo = this.f46685a.viewInfo;
            if (viewInfo != null) {
                viewInfo.iconDoneLottie = lottieComposition;
            }
            b.o.y(this.f46685a);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d<T> implements LottieListener<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f46686a = new d();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(Throwable th) {
            b.o.a0(false);
            d.a.i0.f.j.r.b n = d.a.i0.f.j.r.b.n();
            b bVar = b.o;
            n.d("fail", b.k, "下发配置中导流view的资源不可用");
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements t.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GameGuideConfigInfo f46687a;

        /* loaded from: classes3.dex */
        public static final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.o.c0(e.this.f46687a);
            }
        }

        public e(GameGuideConfigInfo gameGuideConfigInfo) {
            this.f46687a = gameGuideConfigInfo;
        }

        @Override // d.a.i0.a.v2.t.b
        public final void a(String str, Bitmap bitmap) {
            if (bitmap == null) {
                b.o.a0(false);
                if (d.a.i0.a.k.f43025a) {
                    Log.e("GamenowPlaytimeManager", "下载导流view的图片失败， url = " + str);
                }
                d.a.i0.f.j.r.b n = d.a.i0.f.j.r.b.n();
                b bVar = b.o;
                n.d("fail", b.k, "下发配置中导流view的资源不可用");
                return;
            }
            bitmap.setDensity(480);
            GameGuideConfigInfo.ViewInfo viewInfo = this.f46687a.viewInfo;
            if (viewInfo != null) {
                viewInfo.iconNormalImg = bitmap;
            }
            d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
            if (Q == null) {
                b.o.a0(false);
                d.a.i0.f.j.r.b n2 = d.a.i0.f.j.r.b.n();
                b bVar2 = b.o;
                n2.d("fail", b.k, "小游戏非法");
                return;
            }
            SwanAppActivity x = Q.x();
            Intrinsics.checkNotNullExpressionValue(x, "swanApp.swanActivity");
            if (x.isDestroyed()) {
                b.o.a0(false);
                d.a.i0.f.j.r.b n3 = d.a.i0.f.j.r.b.n();
                b bVar3 = b.o;
                n3.d("fail", b.k, "小游戏非法");
                return;
            }
            b.o.a0(true);
            b.o.T(this.f46687a);
            b.o.K();
            q0.b0(new a());
            b bVar4 = b.o;
            String str2 = b.j;
            if (str2 != null) {
                b bVar5 = b.o;
                if (b.k || this.f46687a.expirationTime <= 0) {
                    return;
                }
                d.a.i0.f.j.a.c().a(Q.D(), str2, SystemClock.elapsedRealtime() + this.f46687a.expirationTime);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends StringResponseCallback {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (str == null || str.length() == 0) {
                if (d.a.i0.a.k.f43025a) {
                    Log.e("GamenowPlaytimeManager", "配置信息下发异常，code = " + i2 + ",  response = " + str);
                }
                b.o.a0(false);
                d.a.i0.f.j.r.b n = d.a.i0.f.j.r.b.n();
                b bVar = b.o;
                n.d("fail", b.k, "下发数据非法");
                return;
            }
            if (d.a.i0.a.k.f43025a) {
                Log.d("GamenowPlaytimeManager", "配置信息 =   " + str);
            }
            b.o.O(str);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.i0.a.k.f43025a) {
                StringBuilder sb = new StringBuilder();
                sb.append("请求配置信息失败，err = ");
                sb.append(exc != null ? exc.getMessage() : null);
                Log.e("GamenowPlaytimeManager", sb.toString());
            }
            b.o.a0(false);
            d.a.i0.f.j.r.b n = d.a.i0.f.j.r.b.n();
            b bVar = b.o;
            n.d("fail", b.k, "网络请求失败");
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public static final g f46689e = new g();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.o.N();
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements d.a.i0.a.w2.c {
        @Override // d.a.i0.a.w2.c
        public void f() {
            b bVar = b.o;
            GameGuideView gameGuideView = b.f46679e;
            if (gameGuideView != null) {
                gameGuideView.p();
            }
            d.a.i0.f.j.s.a.f46781f.k();
        }

        @Override // d.a.i0.a.w2.c
        public void k() {
            b.o.P();
        }

        @Override // d.a.i0.a.w2.c
        public void n() {
            d.a.i0.f.j.s.a.f46781f.j();
            b bVar = b.o;
            GameGuideView gameGuideView = b.f46679e;
            if (gameGuideView != null) {
                gameGuideView.o(d.a.i0.f.j.s.a.f46781f.f());
            }
            d.a.i0.a.g1.f.V().b();
            if (b.o.C()) {
                b.o.Q();
            }
        }
    }

    public final long A() {
        if (ProcessUtils.isMainProcess()) {
            return f46675a;
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

    public final GameGuideViewContainer B() {
        return f46683i;
    }

    public final boolean C() {
        boolean z = d.a.i0.a.k2.g.h.a().getBoolean("hasChoiceNotShow", false);
        l = z;
        return z;
    }

    public final boolean D() {
        boolean z = d.a.i0.a.k2.g.h.a().getBoolean("hasInstallResult", true);
        m = z;
        return z;
    }

    public final boolean E() {
        return d.a.i0.a.k2.g.h.a().getBoolean("key_gt_ths", false);
    }

    public final long F() {
        return d.a.i0.a.k2.g.h.a().getLong("key_l_gt", 0L);
    }

    public final int G() {
        if (ProcessUtils.isMainProcess()) {
            return f46682h;
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

    public final String H() {
        return f46681g;
    }

    public final String I() {
        return f46680f;
    }

    public final int J() {
        return d.a.i0.a.k2.g.h.a().getInt("coinsNum", 0);
    }

    public final void K() {
        int i2;
        if (ProcessUtils.isMainProcess()) {
            long F = F();
            if (0 <= F && SapiWebView.DEFAULT_TIMEOUT_MILLIS >= F) {
                f46675a = F;
            }
            int J = J();
            GameGuideConfigInfo gameGuideConfigInfo = f46678d;
            if (gameGuideConfigInfo != null && J > (i2 = gameGuideConfigInfo.maxNums)) {
                o.S(i2);
                J = i2;
            }
            f46682h = J;
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "initGameGuideInfo");
        Intrinsics.checkNotNullExpressionValue(DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle), "DelegateUtils.callOnMain…tion::class.java, bundle)");
    }

    public final boolean L() {
        if (f46676b) {
            return true;
        }
        if (ProcessUtils.isMainProcess()) {
            boolean E = E();
            f46676b = E;
            return E;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "getHasShowedTips");
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
        Intrinsics.checkNotNullExpressionValue(callOnMainWithContentProvider, "DelegateUtils.callOnMain…tion::class.java, bundle)");
        if (callOnMainWithContentProvider.isOk()) {
            boolean z = callOnMainWithContentProvider.mResult.getBoolean("hasShowedTips", false);
            f46676b = z;
            return z;
        }
        return false;
    }

    public final void M() {
        if (ProcessUtils.isMainProcess()) {
            d0();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "onGameTimeUsed");
        Intrinsics.checkNotNullExpressionValue(DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle), "DelegateUtils.callOnMain…tion::class.java, bundle)");
    }

    public final void N() {
        GameGuideConfigInfo gameGuideConfigInfo = f46678d;
        if (gameGuideConfigInfo != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f46677c < 500) {
                if (d.a.i0.a.k.f43025a) {
                    Log.d("GamenowPlaytimeManager", "快速点击");
                    return;
                }
                return;
            }
            d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
            if (Q != null) {
                f46677c = currentTimeMillis;
                long f2 = d.a.i0.f.j.s.a.f46781f.f() / StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
                if (f2 <= 0) {
                    if (d.a.i0.a.k.f43025a) {
                        Log.d("GamenowPlaytimeManager", "时长没有满足一个豆以上");
                    }
                } else if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
                    if (d.a.i0.a.k.f43025a) {
                        Log.d("GamenowPlaytimeManager", "没有网络");
                    }
                    d.a.i0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "网络异常，请稍后重试").F();
                } else {
                    int i2 = (int) f2;
                    d.a.i0.f.j.r.b.n().i(i2);
                    int i3 = gameGuideConfigInfo.perCoinNum * i2;
                    int G = G();
                    boolean z = G >= gameGuideConfigInfo.maxNums;
                    if (d.a.i0.a.k.f43025a) {
                        Log.d("GamenowPlaytimeManager", "before    expectedRewardCoins = " + i3 + " , currentRewardCoinsNum = " + G + ",  isMax = " + z);
                    }
                    int i4 = i3 + G;
                    int i5 = gameGuideConfigInfo.maxNums;
                    if (i4 > i5) {
                        i3 = i5 - G;
                    }
                    if (d.a.i0.a.k.f43025a) {
                        Log.d("GamenowPlaytimeManager", "after    realRewardCoins = " + i3);
                    }
                    if (!z) {
                        d.a.i0.f.j.s.a.f46781f.h();
                        GameGuideView gameGuideView = f46679e;
                        if (gameGuideView != null) {
                            gameGuideView.r();
                        }
                        v(i3);
                    }
                    d.a.i0.a.g1.f.V().p();
                    Intent intent = new Intent(Q.x(), CoinClickDialog.class);
                    intent.putExtra(CoinClickDialog.KEY_IS_SHOW_MAX, z);
                    intent.putExtra(CoinClickDialog.KEY_COINS_REWARD_THIS_TIME, i3);
                    intent.putExtra(CoinClickDialog.KEY_COINS_REWARD_TOTAL, G + i3);
                    Q.x().startActivity(intent);
                }
            }
        }
    }

    public final void O(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("errno", -1);
            if (optInt != 0) {
                if (d.a.i0.a.k.f43025a) {
                    Log.e("GamenowPlaytimeManager", "返回结果异常，errNo = " + optInt + "， response = " + str);
                }
                d.a.i0.f.j.r.b.n().d("fail", k, "下发数据非法");
                return;
            }
            GameGuideConfigInfo parseData = GameGuideConfigInfo.parseData(jSONObject.optJSONObject("data"));
            if (parseData == null) {
                if (d.a.i0.a.k.f43025a) {
                    Log.d("GamenowPlaytimeManager", "配置信息下发异常");
                }
                d.a.i0.f.j.r.b.n().d("fail", k, "下发数据非法");
                return;
            }
            W(parseData.install_result);
            String str2 = parseData.targetAppPackageId;
            Intrinsics.checkNotNullExpressionValue(str2, "configInfo.targetAppPackageId");
            f46680f = str2;
            String str3 = parseData.targetAppDownloadUrl;
            Intrinsics.checkNotNullExpressionValue(str3, "configInfo.targetAppDownloadUrl");
            f46681g = str3;
            if (parseData.status == 0) {
                if (d.a.i0.a.k.f43025a) {
                    Log.d("GamenowPlaytimeManager", "下发数据 status = 0，不展示");
                }
                d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
                if (!k && parseData.expirationTime > 0 && Q != null) {
                    d.a.i0.f.j.a.c().a(Q.D(), str, SystemClock.elapsedRealtime() + parseData.expirationTime);
                }
                d.a.i0.f.j.r.b.n().d("fail", k, "配置下发不展示");
                return;
            }
            j = str;
            if (parseData.popupSelection == 2) {
                f46678d = parseData;
            } else if (C()) {
                d.a.i0.f.j.r.b.n().a("hasClosedWithNotShow");
                f46678d = parseData;
            } else {
                x(parseData);
            }
            d.a.i0.f.j.r.b.n().d("success", k, "");
        } catch (Throwable th) {
            if (d.a.i0.a.k.f43025a) {
                StringBuilder sb = new StringBuilder();
                sb.append("解析配置信息失败，err = ");
                th.printStackTrace();
                sb.append(Unit.INSTANCE);
                Log.e("GamenowPlaytimeManager", sb.toString());
            }
            d.a.i0.f.j.r.b.n().d("fail", k, "下发数据非法");
        }
    }

    public final void P() {
        f46679e = null;
        f46683i = null;
        k = false;
    }

    public final void Q() {
        GameGuideViewContainer gameGuideViewContainer = f46683i;
        if (gameGuideViewContainer != null) {
            d.a.i0.a.g1.f V = d.a.i0.a.g1.f.V();
            Intrinsics.checkNotNullExpressionValue(V, "SwanAppController.getInstance()");
            V.Y().f(n);
            d.a.i0.a.g1.f V2 = d.a.i0.a.g1.f.V();
            Intrinsics.checkNotNullExpressionValue(V2, "SwanAppController.getInstance()");
            n Y = V2.Y();
            Intrinsics.checkNotNullExpressionValue(Y, "SwanAppController.getIns…swanGameNARootViewManager");
            FrameLayout rootView = Y.getRootView();
            if (rootView != null) {
                rootView.removeView(gameGuideViewContainer);
            }
            o.P();
        }
    }

    public final void R() {
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
        if (i2 == null) {
            d.a.i0.f.j.r.b.n().d("fail", k, "小游戏非法");
            return;
        }
        String i3 = d.a.i0.a.c1.a.a0().i(AppRuntime.getAppContext());
        if (i3 == null) {
            i3 = "";
        }
        String h2 = d.a.i0.a.m2.b.h(1);
        d.a.i0.a.e2.c.h a2 = d.a.i0.a.c1.a.p().a();
        Application b2 = d.a.i0.a.c1.a.b();
        Intrinsics.checkNotNullExpressionValue(b2, "SwanAppRuntime.getAppContext()");
        b.a L = i2.L();
        Intrinsics.checkNotNullExpressionValue(L, "swanApp.info");
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) i2.X().postFormRequest().url("https://gamecenter.baidu.com/api/minigame/get_flowout_config")).cookieManager(a2)).addParam("cuid", i3).addParam("appkey", i2.D()).addParam("host", b2.getPackageName()).addParam("from", L.T()).addParam("gamecore_version", h2).requestFrom(16)).requestSubFrom(1602)).build().executeAsync(new f());
    }

    public final void S(int i2) {
        d.a.i0.a.k2.g.h.a().putInt("coinsNum", i2);
    }

    public final void T(GameGuideConfigInfo gameGuideConfigInfo) {
        f46678d = gameGuideConfigInfo;
    }

    public final void U(long j2) {
        if (ProcessUtils.isMainProcess()) {
            Z(j2);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "setPlayTime");
        bundle.putLong("playTime", j2);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
    }

    public final void V(boolean z) {
        l = z;
        d.a.i0.a.k2.g.h.a().putBoolean("hasChoiceNotShow", z);
    }

    public final void W(boolean z) {
        m = z;
        d.a.i0.a.k2.g.h.a().putBoolean("hasInstallResult", z);
    }

    public final void X(boolean z) {
        d.a.i0.a.k2.g.h.a().putBoolean("key_gt_ths", z);
    }

    public final void Y(long j2) {
        d.a.i0.a.k2.g.h.a().putLong("key_l_gt", j2);
    }

    public final void Z(long j2) {
        if (j2 < 0) {
            if (d.a.i0.a.k.f43025a) {
                Log.d("GamenowPlaytimeManager", "游戏时长不能为负数");
                return;
            }
            return;
        }
        if (j2 > SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
            j2 = 90000;
        }
        f46675a = j2;
        Y(j2);
    }

    public final void a0(boolean z) {
    }

    public final void b0() {
        if (f46676b) {
            return;
        }
        f46676b = true;
        if (ProcessUtils.isMainProcess()) {
            X(true);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "setHasShowedTips");
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
    }

    public final void c0(GameGuideConfigInfo gameGuideConfigInfo) {
        GameGuideConfigInfo.ViewInfo viewInfo = gameGuideConfigInfo.viewInfo;
        if (viewInfo != null) {
            d.a.i0.f.j.r.b.n().l();
            Context appContext = AppRuntime.getAppContext();
            Intrinsics.checkNotNullExpressionValue(appContext, "AppRuntime.getAppContext()");
            Resources resources = appContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(d.a.i0.a.d.aiapps_action_bar_right_menu_bg_radius) + resources.getDimensionPixelSize(d.a.i0.a.d.aigames_action_bar_top_operation_margin) + n0.g(10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388613;
            d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
            if (Q != null) {
                f46683i = new GameGuideViewContainer(d.a.i0.a.c1.a.b());
                int e2 = f0.e(Q.x());
                if (f0.d()) {
                    layoutParams.topMargin = dimensionPixelSize + e2;
                } else {
                    layoutParams.topMargin = dimensionPixelSize;
                }
                d.a.i0.a.g1.f V = d.a.i0.a.g1.f.V();
                Intrinsics.checkNotNullExpressionValue(V, "SwanAppController.getInstance()");
                n Y = V.Y();
                Intrinsics.checkNotNullExpressionValue(Y, "SwanAppController.getIns…swanGameNARootViewManager");
                Y.getRootView().addView(f46683i, layoutParams);
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
                f46679e = gameGuideView;
                GameGuideViewContainer gameGuideViewContainer = f46683i;
                if (gameGuideViewContainer != null) {
                    gameGuideViewContainer.addView(gameGuideView);
                }
                d.a.i0.a.g1.f V2 = d.a.i0.a.g1.f.V();
                Intrinsics.checkNotNullExpressionValue(V2, "SwanAppController.getInstance()");
                V2.Y().e(n);
                GameGuideView gameGuideView2 = f46679e;
                if (gameGuideView2 != null) {
                    gameGuideView2.setOnClickListener(g.f46689e);
                }
                if (d.a.i0.f.j.s.a.f46781f.g()) {
                    return;
                }
                d.a.i0.f.j.s.a.f46781f.j();
                GameGuideView gameGuideView3 = f46679e;
                if (gameGuideView3 != null) {
                    gameGuideView3.o(d.a.i0.f.j.s.a.f46781f.f());
                }
            }
        }
    }

    public final void d0() {
        long j2 = f46675a;
        if (j2 < StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) {
            return;
        }
        long j3 = j2 % StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
        f46675a = j3;
        Y(j3);
    }

    public final void v(int i2) {
        int i3;
        if (ProcessUtils.isMainProcess()) {
            int i4 = f46682h + i2;
            f46682h = i4;
            GameGuideConfigInfo gameGuideConfigInfo = f46678d;
            if (gameGuideConfigInfo != null && i4 > (i3 = gameGuideConfigInfo.maxNums)) {
                f46682h = i3;
            }
            S(f46682h);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "addCoins");
        bundle.putInt("coinsNum", i2);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
    }

    public final void w() {
        q.j(RunnableC0978b.f46684e, "thread_gamenowGuideInitAndCheck");
    }

    public final void x(GameGuideConfigInfo gameGuideConfigInfo) {
        Context appContext = AppRuntime.getAppContext();
        GameGuideConfigInfo.ViewInfo viewInfo = gameGuideConfigInfo.viewInfo;
        LottieCompositionFactory.fromUrl(appContext, viewInfo != null ? viewInfo.iconDoneUrl : null).addListener(new c(gameGuideConfigInfo)).addFailureListener(d.f46686a);
    }

    public final void y(GameGuideConfigInfo gameGuideConfigInfo) {
        GameGuideConfigInfo.ViewInfo viewInfo = gameGuideConfigInfo.viewInfo;
        t.e(viewInfo != null ? viewInfo.iconNormalUrl : null, new e(gameGuideConfigInfo));
    }

    public final GameGuideConfigInfo z() {
        return f46678d;
    }
}
