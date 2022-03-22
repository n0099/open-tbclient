package com.tachikoma.core.event;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Function;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8Value;
import com.kwad.v8.utils.V8ObjectUtils;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.event.base.IBaseEvent;
import com.tachikoma.core.exception.TKExceptionDispatcher;
import com.tachikoma.core.manager.TKExportManager;
import com.tachikoma.core.utility.V8Proxy;
/* loaded from: classes7.dex */
public class TKEventProcess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface EventInterface {
        void callBackEvent(IBaseEvent iBaseEvent);
    }

    public TKEventProcess() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Object processEventCallBack(V8Function v8Function, String str, JSContext jSContext, Context context, EventInterface eventInterface) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, v8Function, str, jSContext, context, eventInterface)) == null) {
            Object obj = null;
            if (v8Function != null) {
                String eventName = TKEventCollection.getInstance().getEventName(str);
                IBaseEvent iBaseEvent = (IBaseEvent) TKExportManager.getInstance().getIFactory(eventName).newInstance(context, null);
                eventInterface.callBackEvent(iBaseEvent);
                V8Object v8Object = V8ObjectUtils.toV8Object(v8Function.getRuntime(), TKExportManager.getInstance().retrieveEvent(eventName, iBaseEvent));
                V8Array push = jSContext.makeV8Array().push((V8Value) v8Object);
                try {
                    obj = v8Function.call(null, push);
                } catch (Exception e2) {
                    TKExceptionDispatcher.dispatchJSException(e2, jSContext.getTKJsContextHashcode());
                }
                V8Proxy.release(v8Object);
                V8Proxy.release(push);
            }
            return obj;
        }
        return invokeLLLLL.objValue;
    }
}
