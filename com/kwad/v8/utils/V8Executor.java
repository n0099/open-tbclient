package com.kwad.v8.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.JavaVoidCallback;
import com.kwad.v8.Releasable;
import com.kwad.v8.V8;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Object;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class V8Executor extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Exception exception;
    public volatile boolean forceTerminating;
    public boolean longRunning;
    public String messageHandler;
    public LinkedList<String[]> messageQueue;
    public String result;
    public V8 runtime;
    public final String script;
    public volatile boolean shuttingDown;
    public volatile boolean terminated;

    /* loaded from: classes7.dex */
    public class ExecutorTermination implements JavaVoidCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ V8Executor this$0;

        public ExecutorTermination(V8Executor v8Executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8Executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = v8Executor;
        }

        @Override // com.kwad.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, v8Object, v8Array) == null) && this.this$0.forceTerminating) {
                throw new RuntimeException("V8Thread Termination");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public V8Executor(String str) {
        this(str, false, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public V8Executor(String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.terminated = false;
        this.shuttingDown = false;
        this.forceTerminating = false;
        this.exception = null;
        this.messageQueue = new LinkedList<>();
        this.script = str;
        this.longRunning = z;
        this.messageHandler = str2;
    }

    public void forceTermination() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.forceTerminating = true;
                this.shuttingDown = true;
                if (this.runtime != null) {
                    this.runtime.terminateExecution();
                }
                notify();
            }
        }
    }

    public Exception getException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.exception : (Exception) invokeV.objValue;
    }

    public String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.result : (String) invokeV.objValue;
    }

    public boolean hasException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.exception != null : invokeV.booleanValue;
    }

    public boolean hasTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.terminated : invokeV.booleanValue;
    }

    public boolean isShuttingDown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.shuttingDown : invokeV.booleanValue;
    }

    public boolean isTerminating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.forceTerminating : invokeV.booleanValue;
    }

    public void postMessage(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, strArr) == null) {
            synchronized (this) {
                this.messageQueue.add(strArr);
                notify();
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
        if (r8.messageQueue.isEmpty() != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009d, code lost:
        r3 = 0;
        r2 = r8.messageQueue.remove(0);
        r4 = new com.kwad.v8.V8Array(r8.runtime);
        r5 = new com.kwad.v8.V8Array(r8.runtime);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b4, code lost:
        r6 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b5, code lost:
        if (r3 >= r6) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b7, code lost:
        r5.push(r2[r3]);
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bf, code lost:
        r4.push((com.kwad.v8.V8Value) r5);
        r8.runtime.executeVoidFunction(r8.messageHandler, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c9, code lost:
        r5.close();
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d0, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d1, code lost:
        r5.close();
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d7, code lost:
        throw r2;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                V8 createV8Runtime = V8.createV8Runtime();
                this.runtime = createV8Runtime;
                createV8Runtime.registerJavaMethod(new ExecutorTermination(this), "__j2v8__checkThreadTerminate");
                setup(this.runtime);
            }
            try {
                try {
                    if (!this.forceTerminating) {
                        V8 v8 = this.runtime;
                        Object executeScript = v8.executeScript("__j2v8__checkThreadTerminate();\n" + this.script, getName(), -1);
                        if (executeScript != null) {
                            this.result = executeScript.toString();
                        }
                        if (executeScript instanceof Releasable) {
                            ((Releasable) executeScript).release();
                        }
                    }
                    while (!this.forceTerminating && this.longRunning) {
                        synchronized (this) {
                            if (this.messageQueue.isEmpty() && !this.shuttingDown) {
                                wait();
                            }
                            if ((!this.messageQueue.isEmpty() || !this.shuttingDown) && !this.forceTerminating) {
                            }
                        }
                        synchronized (this) {
                            if (this.runtime.getLocker().hasLock()) {
                                this.runtime.close();
                                this.runtime = null;
                            }
                            this.terminated = true;
                        }
                        return;
                    }
                    synchronized (this) {
                        if (this.runtime.getLocker().hasLock()) {
                            this.runtime.close();
                            this.runtime = null;
                        }
                        this.terminated = true;
                    }
                } catch (Exception e2) {
                    this.exception = e2;
                    synchronized (this) {
                        if (this.runtime.getLocker().hasLock()) {
                            this.runtime.close();
                            this.runtime = null;
                        }
                        this.terminated = true;
                    }
                }
            } catch (Throwable th) {
                synchronized (this) {
                    if (this.runtime.getLocker().hasLock()) {
                        this.runtime.close();
                        this.runtime = null;
                    }
                    this.terminated = true;
                    throw th;
                }
            }
        }
    }

    public void setup(V8 v8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, v8) == null) {
        }
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.shuttingDown = true;
                notify();
            }
        }
    }
}
