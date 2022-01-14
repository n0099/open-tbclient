package com.tachikoma.core.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8Value;
import com.tachikoma.core.api.IRenderListenerInner;
import com.tachikoma.core.component.network.Network;
import com.tachikoma.core.debug.TKDebuggerUtils;
import com.tachikoma.core.exception.TKExceptionDispatcher;
import com.tachikoma.core.utility.TKEnv;
import com.tachikoma.core.utility.V8Proxy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public class JSContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Object, V8AssociateReference> associateRefMap;
    public String mDebuggerContext;
    public int mTKJsContextHashcode;
    public MemoryManager memoryManager;
    public final V8 runPtr;
    public Field v8DataField;

    /* renamed from: com.tachikoma.core.bridge.JSContext$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class V8AssociateReference {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final Object nativeObject;
        public AtomicLong referenceCount;
        public final V8Value v8Value;

        public V8AssociateReference(V8Value v8Value, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8Value, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.referenceCount = new AtomicLong(0L);
            this.v8Value = v8Value.twin();
            this.nativeObject = obj;
        }

        public /* synthetic */ V8AssociateReference(V8Value v8Value, Object obj, AnonymousClass1 anonymousClass1) {
            this(v8Value, obj);
        }

        public static void closeAllReference(Iterator<V8AssociateReference> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, null, it) == null) {
                while (it.hasNext()) {
                    it.next().close();
                }
            }
        }

        @Nullable
        public static V8AssociateReference closeByNative(Object obj, Iterator<V8AssociateReference> it) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, it)) == null) {
                while (it.hasNext()) {
                    V8AssociateReference next = it.next();
                    if (next.nativeObject == obj) {
                        it.remove();
                        next.close();
                        return next;
                    }
                }
                return null;
            }
            return (V8AssociateReference) invokeLL.objValue;
        }

        public void close() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.referenceCount.decrementAndGet() == 0) {
                if (this.v8Value.isReleased() && TKEnv.isDebug()) {
                    throw new RuntimeException("V8Value is already released.");
                }
                V8Proxy.release(this.v8Value);
            }
        }
    }

    public JSContext(V8 v8) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.associateRefMap = new HashMap();
        this.runPtr = v8;
        this.memoryManager = new MemoryManager(v8, false);
        onCreateV8Debugger(this);
    }

    public static JSContext create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new JSContext(TKV8.createV8Runtime()) : (JSContext) invokeV.objValue;
    }

    private Object innerEvaluateScript(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    str2 = TKDebuggerUtils.genScriptName(str2);
                }
                onExecuteScript(str, str2);
                return this.runPtr.executeScript(str, str2, 0);
            } catch (Exception e2) {
                TKExceptionDispatcher.dispatchJSException(e2, this.mTKJsContextHashcode);
                return null;
            }
        }
        return invokeLL.objValue;
    }

    private void onCreateV8Debugger(JSContext jSContext) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, jSContext) == null) && TextUtils.isEmpty(this.mDebuggerContext)) {
            this.mDebuggerContext = TKDebuggerUtils.genContextName();
        }
    }

    private void onDestroyV8Debugger() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || TextUtils.isEmpty(this.mDebuggerContext)) {
            return;
        }
        TKDebuggerUtils.disableDebug(this.mDebuggerContext);
    }

    private void onExecuteScript(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, this, str, str2) == null) || TextUtils.isEmpty(this.mDebuggerContext)) {
            return;
        }
        TKDebuggerUtils.onExecuteScript(this.mDebuggerContext, str, str2, null, 0);
    }

    public void attachView(View view) {
        V8 v8;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.mDebuggerContext) || (v8 = this.runPtr) == null) {
            return;
        }
        TKDebuggerUtils.enableDebug(v8, this.mDebuggerContext, view);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.memoryManager.release();
            onDestroyV8Debugger();
            this.runPtr.close();
            Network.removeRequestDelegate(this);
        }
    }

    public Object evaluateScript(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) ? innerEvaluateScript(str, str2) : invokeLL.objValue;
    }

    public void evaluateScript(String str, String str2, IRenderListenerInner iRenderListenerInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, iRenderListenerInner) == null) {
            if (TextUtils.isEmpty(str)) {
                if (iRenderListenerInner != null) {
                    iRenderListenerInner.failed(new Exception("empty bundle script"));
                    return;
                }
                return;
            }
            try {
                innerEvaluateScript(str, str2);
                if (iRenderListenerInner != null) {
                    iRenderListenerInner.success();
                }
            } catch (Throwable th) {
                TKExceptionDispatcher.dispatchJSException(th, this.mTKJsContextHashcode);
                if (iRenderListenerInner != null) {
                    iRenderListenerInner.failed(th);
                }
            }
        }
    }

    public Object evaluateScriptById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return innerEvaluateScript(str, null);
            } catch (Exception e2) {
                TKExceptionDispatcher.dispatchJSException(e2, this.mTKJsContextHashcode);
                return null;
            }
        }
        return invokeL.objValue;
    }

    public void evaluateScriptById(Context context, String str, boolean z, IRenderListenerInner iRenderListenerInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, str, Boolean.valueOf(z), iRenderListenerInner}) == null) {
            evaluateScript(str, null, iRenderListenerInner);
        }
    }

    public V8AssociateReference getAssociateReference(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, v8Object)) == null) {
            Object linkedNativeObject = this.memoryManager.getLinkedNativeObject(v8Object);
            V8AssociateReference v8AssociateReference = this.associateRefMap.get(v8Object);
            if (v8AssociateReference == null) {
                v8AssociateReference = new V8AssociateReference(v8Object, linkedNativeObject, null);
            }
            v8AssociateReference.referenceCount.incrementAndGet();
            return v8AssociateReference;
        }
        return (V8AssociateReference) invokeL.objValue;
    }

    public V8 getContextRef() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.runPtr : (V8) invokeV.objValue;
    }

    public int getTKJsContextHashcode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mTKJsContextHashcode : invokeV.intValue;
    }

    public V8Object makeObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new V8Object(this.runPtr) : (V8Object) invokeV.objValue;
    }

    public V8Array makeV8Array() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new V8Array(this.runPtr) : (V8Array) invokeV.objValue;
    }

    public void registerAssociateObject(V8Object v8Object, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, v8Object, obj) == null) {
            this.memoryManager.linkNativeObject(v8Object, obj);
        }
    }

    public boolean removeAssociateObject(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            Iterator<Map.Entry<Object, V8AssociateReference>> it = this.associateRefMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Object, V8AssociateReference> next = it.next();
                if (next.getValue() != null && next.getValue().nativeObject == obj) {
                    this.associateRefMap.remove(next.getKey());
                    break;
                }
            }
            return this.memoryManager.removeNativeObject(obj);
        }
        return invokeL.booleanValue;
    }

    public void setTKJsContextHashcode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mTKJsContextHashcode = i2;
        }
    }
}
