package com.dxmpay.apollon.heartbeat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import c.f.a.g.a;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes3.dex */
public final class HeartBeatManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EVENT_KEY = "activity_state_oberserver";
    public static final String k = "HeartBeatManager";
    public static HeartBeatManager l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f53761e;

    /* renamed from: f  reason: collision with root package name */
    public RestHeartBeat f53762f;

    /* renamed from: g  reason: collision with root package name */
    public Timer f53763g;

    /* renamed from: h  reason: collision with root package name */
    public c.f.a.d.b f53764h;

    /* renamed from: i  reason: collision with root package name */
    public long f53765i;

    /* renamed from: j  reason: collision with root package name */
    public a.InterfaceC1651a f53766j;

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC1651a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeartBeatManager a;

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
            this.a = heartBeatManager;
        }

        @Override // c.f.a.g.a.InterfaceC1651a
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                return TextUtils.equals(c.f.a.d.a.i().d() + this.a.f53762f.mHeartbeatUrl, str);
            }
            return invokeL.booleanValue;
        }

        @Override // c.f.a.g.a.InterfaceC1651a
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.equals(str2, str)) {
                return;
            }
            if (!a(str)) {
                this.a.f53762f.reset();
                long splitTimeMs = this.a.f53762f.getSplitTimeMs();
                this.a.d(splitTimeMs, splitTimeMs);
                String str3 = HeartBeatManager.k;
                LogUtil.i(str3, HeartBeatManager.k + " business request success.");
                return;
            }
            String str4 = HeartBeatManager.k;
            StringBuilder sb = new StringBuilder();
            sb.append(HeartBeatManager.k);
            sb.append(" heartbeat ");
            sb.append(this.a.f53765i > 0 ? "background " : "");
            sb.append("request success.");
            LogUtil.i(str4, sb.toString());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HeartBeatManager f53767e;

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
            this.f53767e = heartBeatManager;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53767e.g();
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
        this.f53761e = null;
        this.f53762f = new RestHeartBeat(this, null);
        this.f53763g = null;
        this.f53764h = new c.f.a.d.b();
        this.f53765i = 0L;
        this.f53766j = new a(this);
    }

    public static synchronized HeartBeatManager getInstance() {
        InterceptResult invokeV;
        HeartBeatManager heartBeatManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
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
                HeartBeatCfgEntity b2 = c.f.a.d.a.i().b(this.f53761e);
                if (b2 != null && b2.isUsed()) {
                    if (b2.validate()) {
                        this.f53762f.updateCfg(b2);
                        this.f53764h.b(1);
                    } else {
                        String str = k;
                        LogUtil.w(str, k + " start resp isn't validate.");
                    }
                    return;
                }
                String str2 = k;
                LogUtil.w(str2, k + " start resp is null or isn't used.");
                this.f53764h.b(2);
            }
        }
    }

    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f53765i = j2;
        }
    }

    public final void d(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            try {
                if (this.f53763g != null) {
                    this.f53763g.cancel();
                }
                Timer timer = new Timer();
                this.f53763g = timer;
                timer.schedule(new b(this), j2, j3);
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
                if (this.f53762f.isValid()) {
                    this.f53764h.b(1);
                    this.f53764h.b(4);
                }
                c.f.a.d.a.i().j(this.f53761e);
                return;
            }
            this.f53764h.b(3);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f53762f.beating()) {
                this.f53764h.b(2);
                String str = k;
                LogUtil.i(str, k + " heartbeat beat enough mKeepAliveMax:" + this.f53762f.mKeepAliveMax + ", costTime:" + this.f53762f.mCostTime);
            } else if (this.f53765i > 0 && Calendar.getInstance().getTimeInMillis() / 1000 > this.f53765i + 180) {
                this.f53764h.b(2);
            } else if (!NetworkUtils.isNetworkAvailable(this.f53761e)) {
                String str2 = k;
                LogUtil.i(str2, k + " schedule the network isn't available.");
            } else {
                RestTemplate restTemplate = new RestTemplate(this.f53761e);
                restTemplate.setMessageConverter(new c.f.a.g.b.b());
                try {
                    String str3 = k;
                    LogUtil.i(str3, k + " send heartbeat request.");
                    restTemplate.d(c.f.a.d.a.i().d() + this.f53762f.mHeartbeatUrl, null, "utf-8", String.class);
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
                this.f53761e = context.getApplicationContext();
                c.f.a.d.a.i().l(str);
                return;
            }
            throw new IllegalArgumentException("context param is null exception.");
        }
    }

    public void startHeartBeat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.f.a.g.a.b(this.f53766j);
            d(0L, this.f53762f.getSplitTimeMs());
            String str = k;
            LogUtil.i(str, k + " HeartBeat start.");
        }
    }

    public void stopHeartBeat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Timer timer = this.f53763g;
            if (timer != null) {
                timer.cancel();
                this.f53763g = null;
            }
            this.f53762f.reset();
            c(0L);
            c.f.a.g.a.b(null);
            String str = k;
            LogUtil.i(str, k + " HeartBeat end.");
        }
    }

    /* loaded from: classes3.dex */
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.mSplitTime * 1000 : invokeV.longValue;
        }

        public boolean beating() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j2 = this.mCostTime + this.mSplitTime;
                this.mCostTime = j2;
                return j2 > ((long) this.mKeepAliveMax);
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
