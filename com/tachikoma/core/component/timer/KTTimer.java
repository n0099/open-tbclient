package com.tachikoma.core.component.timer;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Function;
import com.tachikoma.core.base.NativeModule;
import com.tachikoma.core.exception.TKExceptionDispatcher;
import com.tachikoma.core.utility.UIThreadUtil;
import com.tachikoma.core.utility.V8Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
@Keep
/* loaded from: classes8.dex */
public class KTTimer implements NativeModule {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<Integer, V8Function> cMap;
    public List<Runnable> pendingRunnableList;
    public HashMap<Integer, TimerTask> tasks;
    public HashMap<Integer, V8Function> timeoutCallbacks;
    public Timer timer;

    public KTTimer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cMap = new HashMap<>();
        this.tasks = new HashMap<>();
        this.timeoutCallbacks = new HashMap<>();
        this.pendingRunnableList = new ArrayList();
        this.timer = new Timer();
    }

    public void clearInterval(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            try {
                V8Function v8Function = this.cMap.get(Integer.valueOf(i));
                if (v8Function != null) {
                    V8Proxy.release(v8Function);
                }
                this.cMap.remove(Integer.valueOf(i));
                TimerTask timerTask = this.tasks.get(Integer.valueOf(i));
                if (timerTask != null) {
                    timerTask.cancel();
                }
                if (this.timer != null) {
                    this.timer.purge();
                }
            } catch (Throwable th) {
                TKExceptionDispatcher.reportException(null, th);
            }
        }
    }

    public void clearTimeout(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && this.timeoutCallbacks.containsKey(Integer.valueOf(i))) {
            try {
                V8Function v8Function = this.timeoutCallbacks.get(Integer.valueOf(i));
                if (v8Function != null) {
                    V8Proxy.release(v8Function);
                }
                this.timeoutCallbacks.remove(Integer.valueOf(i));
            } catch (Throwable th) {
                TKExceptionDispatcher.reportException(null, th);
            }
        }
    }

    @Override // com.tachikoma.core.base.NativeModule
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (V8Function v8Function : this.cMap.values()) {
                V8Proxy.release(v8Function);
            }
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
            }
            this.cMap.clear();
            this.tasks.clear();
            for (Runnable runnable : this.pendingRunnableList) {
                UIThreadUtil.runOnUiThread(runnable);
            }
            this.pendingRunnableList.clear();
        }
    }

    @Override // com.tachikoma.core.base.NativeModule
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "KTTimer" : (String) invokeV.objValue;
    }

    public int setInterval(V8Function v8Function, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, v8Function, j)) == null) {
            try {
                V8Function twin = v8Function.twin();
                TimerTask timerTask = new TimerTask(this, twin) { // from class: com.tachikoma.core.component.timer.KTTimer.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KTTimer this$0;
                    public final /* synthetic */ V8Function val$intervalCallback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, twin};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$intervalCallback = twin;
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            UIThreadUtil.runOnUiThread(new Runnable(this) { // from class: com.tachikoma.core.component.timer.KTTimer.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            if (V8Proxy.isV8Valid(this.this$1.val$intervalCallback)) {
                                                this.this$1.val$intervalCallback.call(null, null);
                                            }
                                        } catch (Throwable th) {
                                            TKExceptionDispatcher.reportException(null, th);
                                        }
                                    }
                                }
                            });
                        }
                    }
                };
                this.timer.schedule(timerTask, j, j);
                int hashCode = timerTask.hashCode();
                this.cMap.put(Integer.valueOf(hashCode), twin);
                this.tasks.put(Integer.valueOf(hashCode), timerTask);
                return hashCode;
            } catch (Throwable th) {
                TKExceptionDispatcher.reportException(null, th);
                return 0;
            }
        }
        return invokeLJ.intValue;
    }

    public int setTimeout(V8Function v8Function, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, v8Function, j)) == null) {
            try {
                V8Function twin = v8Function.twin();
                int hashCode = twin.hashCode();
                Runnable runnable = new Runnable(this, twin, hashCode) { // from class: com.tachikoma.core.component.timer.KTTimer.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KTTimer this$0;
                    public final /* synthetic */ V8Function val$callback;
                    public final /* synthetic */ int val$hashCode;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, twin, Integer.valueOf(hashCode)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = twin;
                        this.val$hashCode = hashCode;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.pendingRunnableList.remove(this);
                            if (V8Proxy.isV8Valid(this.val$callback) && this.this$0.timeoutCallbacks.containsKey(Integer.valueOf(this.val$hashCode))) {
                                try {
                                    this.val$callback.call(null, null);
                                } catch (Throwable th) {
                                    TKExceptionDispatcher.reportException(null, th);
                                }
                                this.this$0.timeoutCallbacks.remove(Integer.valueOf(this.val$hashCode));
                            }
                        }
                    }
                };
                this.pendingRunnableList.add(runnable);
                UIThreadUtil.postDelay(runnable, j);
                this.timeoutCallbacks.put(Integer.valueOf(hashCode), twin);
                return hashCode;
            } catch (Throwable th) {
                TKExceptionDispatcher.reportException(null, th);
                return 0;
            }
        }
        return invokeLJ.intValue;
    }
}
