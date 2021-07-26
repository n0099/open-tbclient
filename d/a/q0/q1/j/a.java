package d.a.q0.q1.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imrtc.BIMRtcClient;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.b1.f0;
import d.a.p0.b1.i0;
import d.a.v.a.h.f;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a implements ILoginListener {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f62309h = null;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f62310i = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62311e;

    /* renamed from: f  reason: collision with root package name */
    public b f62312f;

    /* renamed from: g  reason: collision with root package name */
    public BroadcastReceiver f62313g;

    /* renamed from: d.a.q0.q1.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1608a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;

        /* renamed from: d.a.q0.q1.j.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1609a extends f0<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C1608a f62314a;

            public C1609a(C1608a c1608a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1608a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f62314a = c1608a;
            }

            @Override // d.a.p0.b1.f0
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.iConnectListener -> onReceive doInBackground");
                    this.f62314a.this$0.d(null);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        public C1608a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.iConnectListener -> onReceive context=" + context + ", intent=" + intent);
                if (intent == null || !"com.baidu.lcp.sdk.broadcast".equals(intent.getAction())) {
                    return;
                }
                boolean z = intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1) == 0;
                Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.iConnectListener -> onReceive connect=" + z);
                Log.d("ImSdkManager", "registerConnectListener connect ：" + intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1));
                if (z) {
                    i0.b(new C1609a(this), null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i2, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1438437347, "Ld/a/q0/q1/j/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1438437347, "Ld/a/q0/q1/j/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62313g = new C1608a(this);
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f62309h == null) {
                synchronized (a.class) {
                    if (f62309h == null) {
                        f62309h = new a();
                    }
                }
            }
            return f62309h;
        }
        return (a) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("test_checkoutImEnvRD", Boolean.FALSE);
            if (hashMap.containsKey("test_checkoutImEnvRD")) {
                return ((Boolean) hashMap.get("test_checkoutImEnvRD")).booleanValue();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init context=" + context);
            int i2 = 0;
            this.f62311e = false;
            String version = TbConfig.getVersion();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(context).registerReceiver(this.f62313g, intentFilter);
            f.y(context, true);
            BIMManager.setProductLine(context, 3, version);
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            BIMManager.enableDebugMode(true);
            if (c()) {
                Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init debug");
                BIMManager.init(context, Constants.APPID_TIEBA, 1, cuidGalaxy2);
                BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
                i2 = 1;
            } else {
                Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init online");
                BIMManager.init(context, Constants.APPID_TIEBA, 0, cuidGalaxy2);
                BIMRtcClient.setRtcDebugAndLogEnable(context, false, false);
            }
            LogUtils.d("imlog", "BIMManager init env:" + i2);
            e(context);
        }
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToIM listener=" + bVar);
            this.f62312f = bVar;
            String from = TbConfig.getFrom();
            String currentFrom = TbConfig.getCurrentFrom();
            if (TbadkCoreApplication.isLogin()) {
                Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToIM login");
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                String currentBduss = TbadkCoreApplication.getCurrentBduss();
                BIMManager.login(currentAccount, currentBduss, 1, from, currentFrom, this);
                LogUtils.d("imlog", "IMSdkManager PassIsLogin loginToIM uid = " + currentAccount + ", bduss = " + currentBduss + ", from = " + from + ", cfrom = " + currentFrom);
                return;
            }
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToIM cuid");
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            BIMManager.login(null, cuidGalaxy2, 6, from, currentFrom, this);
            LogUtils.d("imlog", "IMSdkManager 匿名使用cuid登录 loginToIM , cuid = " + cuidGalaxy2 + ", from = " + from + ", cfrom = " + currentFrom);
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToLCP context=" + context);
            int i2 = f62310i ? 1 : 2;
            f62310i = false;
            d.a.v.a.b.a.a(context, "10773430", TbadkCoreApplication.getInst().getCuidGalaxy2(), i2);
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToLCP connect end");
        }
    }

    @Override // com.baidu.android.imsdk.account.ILoginListener
    public void onLoginResult(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.onLoginResult errno=" + i2 + ", errMsg=" + str);
            b bVar = this.f62312f;
            if (bVar != null) {
                bVar.a(i2, str);
                this.f62312f = null;
            }
        }
    }

    @Override // com.baidu.android.imsdk.account.ILoginListener
    public void onLogoutResult(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.onLogoutResult errno=" + i2 + ", errMsg=" + str + ", type=" + i3);
            if (this.f62311e) {
                return;
            }
            d(null);
        }
    }
}
