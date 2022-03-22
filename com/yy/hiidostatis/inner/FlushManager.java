package com.yy.hiidostatis.inner;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.Counter;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes7.dex */
public class FlushManager {
    public static /* synthetic */ Interceptable $ic;
    public static final Object OBJ_KEY;
    public static Handler mHandler;
    public transient /* synthetic */ FieldHolder $fh;
    public FlushListener l;
    public ConnectionChangeReceiver mReceiver;
    public ReportTimer mReportTimer;

    /* renamed from: com.yy.hiidostatis.inner.FlushManager$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class ConnectionChangeReceiver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FlushManager this$0;

        public ConnectionChangeReceiver(FlushManager flushManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flushManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flushManager;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && this.this$0.l != null) {
                L.verbose(this, "ConnectionChangeReceiver onReceive .flush cache", new Object[0]);
                this.this$0.l.fluch(context);
            }
        }

        public void registerReceiver(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
                try {
                    L.debug(this, "ConnectionChangeReceiver registerReceiver", new Object[0]);
                    context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Throwable unused) {
                    L.debug(this, "ConnectionChangeReceiver registerReceiver failure", new Object[0]);
                }
            }
        }

        public void unregisterReceiver(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
                try {
                    L.debug(this, "ConnectionChangeReceiver unregisterReceiver", new Object[0]);
                    context.unregisterReceiver(this);
                } catch (Throwable unused) {
                    L.debug(this, "ConnectionChangeReceiver unregisterReceiver failure", new Object[0]);
                }
            }
        }

        public /* synthetic */ ConnectionChangeReceiver(FlushManager flushManager, AnonymousClass1 anonymousClass1) {
            this(flushManager);
        }
    }

    /* loaded from: classes7.dex */
    public interface FlushListener {
        void fluch(Context context);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-433079258, "Lcom/yy/hiidostatis/inner/FlushManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-433079258, "Lcom/yy/hiidostatis/inner/FlushManager;");
                return;
            }
        }
        OBJ_KEY = new Object();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public FlushManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mReportTimer = new ReportTimer(this, null);
    }

    public void regConnectionChangeReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            if (this.mReceiver == null) {
                synchronized (OBJ_KEY) {
                    if (this.mReceiver == null) {
                        ConnectionChangeReceiver connectionChangeReceiver = new ConnectionChangeReceiver(this, null);
                        this.mReceiver = connectionChangeReceiver;
                        connectionChangeReceiver.registerReceiver(context);
                    }
                }
            }
        }
    }

    public void setFlushListener(FlushListener flushListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flushListener) == null) {
            this.l = flushListener;
        }
    }

    public void startTimer(Context context, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, l) == null) {
            this.mReportTimer.start(mHandler, context, l);
        }
    }

    public void stopTimer(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.mReportTimer.stop(context);
        }
    }

    public void unRegConnectionChangeReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            if (this.mReceiver != null) {
                synchronized (OBJ_KEY) {
                    if (this.mReceiver != null) {
                        this.mReceiver.unregisterReceiver(context);
                        this.mReceiver = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class ReportTimer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long DEFAULT_INTERVAL = 1800000;
        public static final long MAX_INTERVAL = 3600000;
        public static final long MIN_INTERVAL = 60000;
        public transient /* synthetic */ FieldHolder $fh;
        public long mInterval;
        public Counter.Callback mReportExecutor;
        public Counter mReportInvoker;
        public final /* synthetic */ FlushManager this$0;

        public ReportTimer(FlushManager flushManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flushManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flushManager;
            this.mInterval = DEFAULT_INTERVAL;
        }

        public void start(Handler handler, Context context, Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, handler, context, l) == null) {
                try {
                    if (this.mReportInvoker != null) {
                        return;
                    }
                    if (l != null && l.longValue() >= 60000 && l.longValue() <= 3600000) {
                        this.mInterval = l.longValue();
                    }
                    this.mReportInvoker = new Counter(handler, 0, this.mInterval, true);
                    Counter.Callback callback = new Counter.Callback(this, context) { // from class: com.yy.hiidostatis.inner.FlushManager.ReportTimer.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ReportTimer this$1;
                        public final /* synthetic */ Context val$c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$c = context;
                        }

                        @Override // com.yy.hiidostatis.inner.util.Counter.Callback
                        public void onCount(int i) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) || this.this$1.this$0.l == null) {
                                return;
                            }
                            L.debug(this, "ReportTimer. flush cache. %d times", Integer.valueOf(i + 1));
                            this.this$1.this$0.l.fluch(this.val$c);
                        }
                    };
                    this.mReportExecutor = callback;
                    this.mReportInvoker.setCallback(callback);
                    this.mReportInvoker.start(this.mInterval);
                    L.brief("ReportTimer start. interval:%d ms", Long.valueOf(this.mInterval));
                } catch (Throwable th) {
                    L.debug(this, th.getMessage(), new Object[0]);
                }
            }
        }

        public void stop(Context context) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || this.mReportInvoker == null) {
                return;
            }
            try {
                L.brief("ReportTimer stop.", new Object[0]);
                this.mReportInvoker.stop();
                this.mReportInvoker = null;
                this.mReportExecutor = null;
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
            }
        }

        public /* synthetic */ ReportTimer(FlushManager flushManager, AnonymousClass1 anonymousClass1) {
            this(flushManager);
        }
    }
}
