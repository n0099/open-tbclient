package com.dxmpay.apollon.heartbeat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import b.e.a.g.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.NoProguard;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.utils.NetworkUtils;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes11.dex */
public final class HeartBeatManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EVENT_KEY = "activity_state_oberserver";
    public static final String k = "HeartBeatManager";
    public static HeartBeatManager l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f63005e;

    /* renamed from: f  reason: collision with root package name */
    public RestHeartBeat f63006f;

    /* renamed from: g  reason: collision with root package name */
    public Timer f63007g;

    /* renamed from: h  reason: collision with root package name */
    public b.e.a.d.b f63008h;

    /* renamed from: i  reason: collision with root package name */
    public long f63009i;
    public a.InterfaceC1505a j;

    /* loaded from: classes11.dex */
    public class a implements a.InterfaceC1505a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HeartBeatManager f63010a;

        public a(HeartBeatManager heartBeatManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heartBeatManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63010a = heartBeatManager;
        }

        @Override // b.e.a.g.a.InterfaceC1505a
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                return TextUtils.equals(b.e.a.d.a.i().d() + this.f63010a.f63006f.mHeartbeatUrl, str);
            }
            return invokeL.booleanValue;
        }

        @Override // b.e.a.g.a.InterfaceC1505a
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.equals(str2, str)) {
                return;
            }
            if (!a(str)) {
                this.f63010a.f63006f.reset();
                long splitTimeMs = this.f63010a.f63006f.getSplitTimeMs();
                this.f63010a.d(splitTimeMs, splitTimeMs);
                String str3 = HeartBeatManager.k;
                LogUtil.i(str3, HeartBeatManager.k + " business request success.");
                return;
            }
            String str4 = HeartBeatManager.k;
            StringBuilder sb = new StringBuilder();
            sb.append(HeartBeatManager.k);
            sb.append(" heartbeat ");
            sb.append(this.f63010a.f63009i > 0 ? "background " : "");
            sb.append("request success.");
            LogUtil.i(str4, sb.toString());
        }
    }

    /* loaded from: classes11.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HeartBeatManager f63011e;

        public b(HeartBeatManager heartBeatManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heartBeatManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63011e = heartBeatManager;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63011e.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1044320929, "Lcom/dxmpay/apollon/heartbeat/HeartBeatManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1044320929, "Lcom/dxmpay/apollon/heartbeat/HeartBeatManager;");
        }
    }

    public HeartBeatManager() {
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
        this.f63005e = null;
        this.f63006f = new RestHeartBeat(this, null);
        this.f63007g = null;
        this.f63008h = new b.e.a.d.b();
        this.f63009i = 0L;
        this.j = new a(this);
    }

    public static synchronized HeartBeatManager getInstance() {
        InterceptResult invokeV;
        HeartBeatManager heartBeatManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            synchronized (HeartBeatManager.class) {
                if (l == null) {
                    l = new HeartBeatManager();
                }
                heartBeatManager = l;
            }
            return heartBeatManager;
        }
        return (HeartBeatManager) invokeV.objValue;
    }

    public synchronized void applyBeating() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                HeartBeatCfgEntity b2 = b.e.a.d.a.i().b(this.f63005e);
                if (b2 != null && b2.isUsed()) {
                    if (b2.validate()) {
                        this.f63006f.updateCfg(b2);
                        this.f63008h.b(1);
                    } else {
                        String str = k;
                        LogUtil.w(str, k + " start resp isn't validate.");
                    }
                    return;
                }
                String str2 = k;
                LogUtil.w(str2, k + " start resp is null or isn't used.");
                this.f63008h.b(2);
            }
        }
    }

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f63009i = j;
        }
    }

    public final void d(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            try {
                if (this.f63007g != null) {
                    this.f63007g.cancel();
                }
                Timer timer = new Timer();
                this.f63007g = timer;
                timer.schedule(new b(this), j, j2);
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void executeInForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            String str = k;
            LogUtil.i(str, k + " onStateChanged isForeground:" + z);
            if (z) {
                if (this.f63006f.isValid()) {
                    this.f63008h.b(1);
                    this.f63008h.b(4);
                }
                b.e.a.d.a.i().j(this.f63005e);
                return;
            }
            this.f63008h.b(3);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f63006f.beating()) {
                this.f63008h.b(2);
                String str = k;
                LogUtil.i(str, k + " heartbeat beat enough mKeepAliveMax:" + this.f63006f.mKeepAliveMax + ", costTime:" + this.f63006f.mCostTime);
            } else if (this.f63009i > 0 && Calendar.getInstance().getTimeInMillis() / 1000 > this.f63009i + 180) {
                this.f63008h.b(2);
            } else if (!NetworkUtils.isNetworkAvailable(this.f63005e)) {
                String str2 = k;
                LogUtil.i(str2, k + " schedule the network isn't available.");
            } else {
                RestTemplate restTemplate = new RestTemplate(this.f63005e);
                restTemplate.setMessageConverter(new b.e.a.g.b.b());
                try {
                    String str3 = k;
                    LogUtil.i(str3, k + " send heartbeat request.");
                    restTemplate.d(b.e.a.d.a.i().d() + this.f63006f.mHeartbeatUrl, null, "utf-8", String.class);
                } catch (RestRuntimeException e2) {
                    String str4 = k;
                    LogUtil.errord(str4, k + " Heart Beat exception:" + e2.getMessage());
                    e2.printStackTrace();
                }
            }
        }
    }

    public void init(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            if (context != null) {
                this.f63005e = context.getApplicationContext();
                b.e.a.d.a.i().l(str);
                return;
            }
            throw new IllegalArgumentException("context param is null exception.");
        }
    }

    public void startHeartBeat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.e.a.g.a.b(this.j);
            d(0L, this.f63006f.getSplitTimeMs());
            String str = k;
            LogUtil.i(str, k + " HeartBeat start.");
        }
    }

    public void stopHeartBeat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Timer timer = this.f63007g;
            if (timer != null) {
                timer.cancel();
                this.f63007g = null;
            }
            this.f63006f.reset();
            c(0L);
            b.e.a.g.a.b(null);
            String str = k;
            LogUtil.i(str, k + " HeartBeat end.");
        }
    }

    /* loaded from: classes11.dex */
    public final class RestHeartBeat implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public long mCostTime;
        public String mHeartbeatUrl;
        public int mKeepAliveMax;
        public int mSplitTime;
        public final /* synthetic */ HeartBeatManager this$0;

        public RestHeartBeat(HeartBeatManager heartBeatManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heartBeatManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = heartBeatManager;
            this.mHeartbeatUrl = "/heartbeat";
            this.mCostTime = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getSplitTimeMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? this.mSplitTime * 1000 : invokeV.longValue;
        }

        public boolean beating() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j = this.mCostTime + this.mSplitTime;
                this.mCostTime = j;
                return j > ((long) this.mKeepAliveMax);
            }
            return invokeV.booleanValue;
        }

        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSplitTime > 0 && this.mKeepAliveMax > 0 : invokeV.booleanValue;
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mCostTime = 0L;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return " costTime:" + this.mCostTime + ",splitTime:" + this.mSplitTime;
            }
            return (String) invokeV.objValue;
        }

        public void updateCfg(HeartBeatCfgEntity heartBeatCfgEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, heartBeatCfgEntity) == null) {
                if (!TextUtils.isEmpty(heartBeatCfgEntity.KA_INIT)) {
                    this.mSplitTime = Integer.valueOf(heartBeatCfgEntity.KA_INIT).intValue();
                }
                if (!TextUtils.isEmpty(heartBeatCfgEntity.KA_MAX)) {
                    this.mKeepAliveMax = Integer.valueOf(heartBeatCfgEntity.KA_MAX).intValue();
                }
                String str = HeartBeatManager.k;
                LogUtil.i(str, HeartBeatManager.k + " cfg:" + heartBeatCfgEntity);
            }
        }

        public /* synthetic */ RestHeartBeat(HeartBeatManager heartBeatManager, a aVar) {
            this(heartBeatManager);
        }
    }
}
