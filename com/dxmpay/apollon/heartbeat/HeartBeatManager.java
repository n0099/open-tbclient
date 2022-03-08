package com.dxmpay.apollon.heartbeat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
import com.dxmpay.apollon.restnet.a;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.utils.NetworkUtils;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes7.dex */
public final class HeartBeatManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EVENT_KEY = "activity_state_oberserver";
    public static final String a = "HeartBeatManager";

    /* renamed from: b  reason: collision with root package name */
    public static HeartBeatManager f52210b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f52211c;

    /* renamed from: d  reason: collision with root package name */
    public RestHeartBeat f52212d;

    /* renamed from: e  reason: collision with root package name */
    public Timer f52213e;

    /* renamed from: f  reason: collision with root package name */
    public b f52214f;

    /* renamed from: g  reason: collision with root package name */
    public long f52215g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC2050a f52216h;

    /* loaded from: classes7.dex */
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
                String str = HeartBeatManager.a;
                LogUtil.i(str, HeartBeatManager.a + " cfg:" + heartBeatCfgEntity);
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
        this.f52211c = null;
        this.f52212d = new RestHeartBeat();
        this.f52213e = null;
        this.f52214f = new b();
        this.f52215g = 0L;
        this.f52216h = new a.InterfaceC2050a(this) { // from class: com.dxmpay.apollon.heartbeat.HeartBeatManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HeartBeatManager a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.dxmpay.apollon.restnet.a.InterfaceC2050a
            public boolean a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    return TextUtils.equals(a.b().a() + this.a.f52212d.mHeartbeatUrl, str);
                }
                return invokeL.booleanValue;
            }

            @Override // com.dxmpay.apollon.restnet.a.InterfaceC2050a
            public void a(String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, str, str2) == null) || TextUtils.equals(str2, str)) {
                    return;
                }
                if (!a(str)) {
                    this.a.f52212d.reset();
                    long splitTimeMs = this.a.f52212d.getSplitTimeMs();
                    this.a.a(splitTimeMs, splitTimeMs);
                    String str3 = HeartBeatManager.a;
                    LogUtil.i(str3, HeartBeatManager.a + " business request success.");
                    return;
                }
                String str4 = HeartBeatManager.a;
                StringBuilder sb = new StringBuilder();
                sb.append(HeartBeatManager.a);
                sb.append(" heartbeat ");
                sb.append(this.a.f52215g > 0 ? "background " : "");
                sb.append("request success.");
                LogUtil.i(str4, sb.toString());
            }
        };
    }

    public static synchronized HeartBeatManager getInstance() {
        InterceptResult invokeV;
        HeartBeatManager heartBeatManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (HeartBeatManager.class) {
                if (f52210b == null) {
                    f52210b = new HeartBeatManager();
                }
                heartBeatManager = f52210b;
            }
            return heartBeatManager;
        }
        return (HeartBeatManager) invokeV.objValue;
    }

    public synchronized void applyBeating() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                HeartBeatCfgEntity a2 = a.b().a(this.f52211c);
                if (a2 != null && a2.isUsed()) {
                    if (a2.validate()) {
                        this.f52212d.updateCfg(a2);
                        this.f52214f.a(1);
                    } else {
                        String str = a;
                        LogUtil.w(str, a + " start resp isn't validate.");
                    }
                    return;
                }
                String str2 = a;
                LogUtil.w(str2, a + " start resp is null or isn't used.");
                this.f52214f.a(2);
            }
        }
    }

    public void executeInForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            String str = a;
            LogUtil.i(str, a + " onStateChanged isForeground:" + z);
            if (z) {
                if (this.f52212d.isValid()) {
                    this.f52214f.a(1);
                    this.f52214f.a(4);
                }
                a.b().b(this.f52211c);
                return;
            }
            this.f52214f.a(3);
        }
    }

    public void init(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            if (context != null) {
                this.f52211c = context.getApplicationContext();
                a.b().b(str);
                return;
            }
            throw new IllegalArgumentException("context param is null exception.");
        }
    }

    public void startHeartBeat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.dxmpay.apollon.restnet.a.a(this.f52216h);
            a(0L, this.f52212d.getSplitTimeMs());
            String str = a;
            LogUtil.i(str, a + " HeartBeat start.");
        }
    }

    public void stopHeartBeat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Timer timer = this.f52213e;
            if (timer != null) {
                timer.cancel();
                this.f52213e = null;
            }
            this.f52212d.reset();
            a(0L);
            com.dxmpay.apollon.restnet.a.a(null);
            String str = a;
            LogUtil.i(str, a + " HeartBeat end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (this.f52212d.beating()) {
                this.f52214f.a(2);
                String str = a;
                LogUtil.i(str, a + " heartbeat beat enough mKeepAliveMax:" + this.f52212d.mKeepAliveMax + ", costTime:" + this.f52212d.mCostTime);
            } else if (this.f52215g > 0 && Calendar.getInstance().getTimeInMillis() / 1000 > this.f52215g + 180) {
                this.f52214f.a(2);
            } else if (!NetworkUtils.isNetworkAvailable(this.f52211c)) {
                String str2 = a;
                LogUtil.i(str2, a + " schedule the network isn't available.");
            } else {
                RestTemplate restTemplate = new RestTemplate(this.f52211c);
                restTemplate.setMessageConverter(new com.dxmpay.apollon.restnet.converter.b());
                try {
                    String str3 = a;
                    LogUtil.i(str3, a + " send heartbeat request.");
                    restTemplate.a(a.b().a() + this.f52212d.mHeartbeatUrl, null, "utf-8", String.class);
                } catch (RestRuntimeException e2) {
                    String str4 = a;
                    LogUtil.errord(str4, a + " Heart Beat exception:" + e2.getMessage());
                    e2.printStackTrace();
                }
            }
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.f52215g = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            try {
                if (this.f52213e != null) {
                    this.f52213e.cancel();
                }
                Timer timer = new Timer();
                this.f52213e = timer;
                timer.schedule(new TimerTask(this) { // from class: com.dxmpay.apollon.heartbeat.HeartBeatManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ HeartBeatManager a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.b();
                        }
                    }
                }, j2, j3);
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
    }
}
