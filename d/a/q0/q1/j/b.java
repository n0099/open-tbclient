package d.a.q0.q1.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.q0.q1.j.a;
/* loaded from: classes8.dex */
public class b implements IConnectListener {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static String f62315i = "imlog";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62316e;

    /* renamed from: f  reason: collision with root package name */
    public c f62317f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f62318g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62319h;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62320a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62320a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.f62320a.c();
            }
        }
    }

    /* renamed from: d.a.q0.q1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1610b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62321a;

        public C1610b(b bVar) {
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
            this.f62321a = bVar;
        }

        @Override // d.a.q0.q1.j.a.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.loginToIm -> loginResult errno=" + i2 + ", errMsg=" + str);
                StringBuilder sb = new StringBuilder();
                sb.append(b.f62315i);
                sb.append("LiveIMManager");
                String sb2 = sb.toString();
                LogUtils.d(sb2, "LiveIMManager onLoginResult errno = " + i2 + ", errMsg = " + str + ", isConnected = " + this.f62321a.f62316e);
                if (i2 != 0 || this.f62321a.f62316e) {
                    return;
                }
                this.f62321a.onResult(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mIsDestroy;
        public boolean mIsInit;
        public final /* synthetic */ b this$0;

        public c(b bVar) {
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
            this.this$0 = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                this.mIsDestroy = true;
                try {
                    TbadkCoreApplication.getInst().unregisterReceiver(this);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        private void init() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                this.mIsInit = true;
                this.mIsDestroy = false;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                if (this.mIsInit) {
                    this.mIsInit = false;
                } else if (!j.z() || this.mIsDestroy) {
                } else {
                    BIMManager.tryConnection(context);
                }
            }
        }

        public void register() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                init();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                TbadkCoreApplication.getInst().registerReceiver(this, intentFilter);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1438437378, "Ld/a/q0/q1/j/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1438437378, "Ld/a/q0/q1/j/b;");
        }
    }

    public b() {
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
        this.f62316e = false;
        this.f62318g = new a(this, 2005016);
        this.f62319h = false;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.init id =" + str);
            if (this.f62319h) {
                return;
            }
            this.f62319h = true;
            d.a.q0.q1.j.a.a().b(TbadkCoreApplication.getInst());
            d();
            c();
            if (this.f62317f == null) {
                this.f62317f = new c(this, null);
            }
            this.f62317f.register();
            MessageManager.getInstance().registerListener(this.f62318g);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.q0.q1.j.a.a().d(new C1610b(this));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogUtils.d(f62315i + "LiveIMManager", "registerIMConnectListener");
            this.f62316e = false;
            BIMManager.unregisterConnectListener();
            BIMManager.registerConnectListener(this);
        }
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.onResult statuscode=" + i2);
            LogUtils.d(f62315i + "LiveIMManager", "IConnectListener onResult statusCode=" + i2);
            this.f62316e = true;
            if (i2 == 0) {
                LogUtils.d(f62315i + "LiveIMManager", "IConnectListener net connect");
            } else if (i2 == 1) {
                LogUtils.d(f62315i + "LiveIMManager", "IConnectListener net disconnect");
            }
        }
    }
}
