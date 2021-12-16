package com.kwad.v8.inspector;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8;
import com.kwad.v8.V8Object;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class V8Inspector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<DebuggerConnectionListener> debuggerConnectionListeners;
    public long inspectorPtr;
    public V8 runtime;
    public boolean waitingForConnection;

    public V8Inspector(V8 v8, V8InspectorDelegate v8InspectorDelegate, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8, v8InspectorDelegate, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.inspectorPtr = 0L;
        this.waitingForConnection = true;
        this.runtime = v8;
        this.inspectorPtr = v8.createInspector(v8InspectorDelegate, str);
        this.debuggerConnectionListeners = new ArrayList();
    }

    public static V8Inspector createV8Inspector(V8 v8, V8InspectorDelegate v8InspectorDelegate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, v8, v8InspectorDelegate)) == null) ? new V8Inspector(v8, v8InspectorDelegate, null) : (V8Inspector) invokeLL.objValue;
    }

    public static V8Inspector createV8Inspector(V8 v8, V8InspectorDelegate v8InspectorDelegate, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, v8, v8InspectorDelegate, str)) == null) ? new V8Inspector(v8, v8InspectorDelegate, str) : (V8Inspector) invokeLLL.objValue;
    }

    private void verifyDebuggerConnection(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            V8Object v8Object = null;
            try {
                V8 v8 = this.runtime;
                v8Object = v8.executeObjectScript("JSON.parse(JSON.stringify(" + str + "))");
                if (v8Object.getString("method").equals("Runtime.runIfWaitingForDebugger")) {
                    this.waitingForConnection = false;
                    this.runtime.schedulePauseOnNextStatement(this.inspectorPtr, "");
                    for (DebuggerConnectionListener debuggerConnectionListener : this.debuggerConnectionListeners) {
                        debuggerConnectionListener.onDebuggerConnected();
                    }
                }
            } finally {
                if (v8Object != null) {
                    v8Object.close();
                }
            }
        }
    }

    public void addDebuggerConnectionListener(DebuggerConnectionListener debuggerConnectionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, debuggerConnectionListener) == null) {
            this.debuggerConnectionListeners.add(debuggerConnectionListener);
        }
    }

    public void dispatchProtocolMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                this.runtime.dispatchProtocolMessage(this.inspectorPtr, str);
                if (this.waitingForConnection) {
                    verifyDebuggerConnection(str);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void removeDebuggerConnectionListener(DebuggerConnectionListener debuggerConnectionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, debuggerConnectionListener) == null) {
            this.debuggerConnectionListeners.remove(debuggerConnectionListener);
        }
    }
}
