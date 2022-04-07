package com.tachikoma.core.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.JavaCallback;
import com.kwad.v8.JavaVoidCallback;
import com.kwad.v8.V8;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Function;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8Value;
import com.kwad.v8.utils.V8ObjectUtils;
import com.kwad.yoga.YogaAlign;
import com.kwad.yoga.YogaJustify;
import com.kwad.yoga.YogaNode;
import com.tachikoma.core.IV8Function;
import com.tachikoma.core.V8FunctionImpl;
import com.tachikoma.core.api.IBaseBridgeInner;
import com.tachikoma.core.api.IExceptionHandlerInner;
import com.tachikoma.core.api.IHostEnvInner;
import com.tachikoma.core.api.IWebCardBridgeInner;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.common.ILifeCycle;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.exception.TKExceptionDispatcher;
import com.tachikoma.core.log.Logger;
import com.tachikoma.core.manager.TKExportManager;
import com.tachikoma.core.manager.TKModuleManager;
import com.tachikoma.core.manager.W3CMoudleManager;
import com.tachikoma.core.module.handler.IBusinessSchoolBridge;
import com.tachikoma.core.module.handler.TKLifeCycle;
import com.tachikoma.core.utility.TKConverter;
import com.tachikoma.core.utility.TKEnv;
import com.tachikoma.core.utility.V8Proxy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class TKJSContext implements ILifeCycle {
    public static /* synthetic */ Interceptable $ic;
    public static Integer fileIndex;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, V8ClassRegisterSlot> classMethodRegisterMap;
    public float density;
    public List<IComponentRegister> mComponentRegisters;
    public Context mContext;
    public Map<String, V8Function> mCreateViewFunctionMap;
    public IExceptionHandlerInner mExceptionHandler;
    public TKExportManager mExportManager;
    public final HashMap<Class, Object> mHandlerMap;
    public final LruCache<String, Method> mInvokeMethodCache;
    public JSContext mJsContext;
    public ILifeCycle mLifeCycleCallback;
    public V8Function mLinkClass;
    public List<V8Value> mPendingReleaseV8List;
    public String mRootDir;
    @Nullable
    public ViewGroup mRootView;
    @Nullable
    public JSContext.V8AssociateReference mRootViewReference;
    public Context mViewCreateContext;

    /* loaded from: classes8.dex */
    public static class V8ClassRegisterSlot {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final V8Object classObject;
        public final V8Object handleObject;

        public V8ClassRegisterSlot(JSContext jSContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.classObject = jSContext.makeObject();
            this.handleObject = jSContext.makeObject();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1473017852, "Lcom/tachikoma/core/bridge/TKJSContext;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1473017852, "Lcom/tachikoma/core/bridge/TKJSContext;");
                return;
            }
        }
        fileIndex = 0;
    }

    public TKJSContext(@NonNull Context context, @Nullable ViewGroup viewGroup, @NonNull TKExportManager tKExportManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, tKExportManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHandlerMap = new HashMap<>();
        this.mCreateViewFunctionMap = new HashMap();
        this.mRootDir = "";
        this.density = -1.0f;
        this.mInvokeMethodCache = new LruCache<>(100);
        this.classMethodRegisterMap = new HashMap();
        this.mContext = context;
        this.mRootView = viewGroup;
        this.mExportManager = tKExportManager;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TKJSContext(Context context, @NonNull TKExportManager tKExportManager) {
        this(context, null, tKExportManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tKExportManager};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (ViewGroup) objArr2[1], (TKExportManager) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private String createFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            fileIndex = Integer.valueOf(fileIndex.intValue() + 1);
            return "NativeJS" + fileIndex.toString();
        }
        return (String) invokeV.objValue;
    }

    private void dfsDestroyChildren(@Nullable View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, view2) == null) || view2 == null) {
            return;
        }
        if (view2 instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view2;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                dfsDestroyChildren(viewGroup.getChildAt(i));
                i++;
            }
        }
        TKBase tKBaseFromView = TKBase.getTKBaseFromView(view2);
        if (tKBaseFromView != null) {
            tKBaseFromView.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureLinkClassFunction() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65553, this) == null) && this.mLinkClass == null) {
            this.mLinkClass = (V8Function) this.mJsContext.getContextRef().executeObjectScript("(function(a,b){let sourceProp=Object.getPrototypeOf(this);Object.setPrototypeOf(this,Object.assign(sourceProp,a));return new Proxy(this,b)})");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Context getViewCreateContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            Context context = this.mViewCreateContext;
            if (context != null) {
                return context;
            }
            ViewGroup viewGroup = this.mRootView;
            return viewGroup == null ? this.mContext : viewGroup.getContext();
        }
        return (Context) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object invokeMethod(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65555, this, obj, str, clsArr, objArr)) == null) {
            try {
                String str2 = obj.getClass() + "_" + str;
                Method method = this.mInvokeMethodCache.get(str2);
                if (method == null) {
                    method = obj.getClass().getMethod(str, clsArr);
                    this.mInvokeMethodCache.put(str2, method);
                }
                return method.invoke(obj, objArr);
            } catch (Exception e) {
                TKExceptionDispatcher.reportException(this, e);
                return null;
            }
        }
        return invokeLLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logError(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65556, this, str, z) == null) {
            if (z && TKEnv.isDebug(this)) {
                TKExceptionDispatcher.reportException(this, new IllegalStateException(str));
            }
            Logger.logE(str, null);
        }
    }

    private void maybeInitComponentRegister() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.mComponentRegisters == null) {
            ArrayList arrayList = new ArrayList();
            this.mComponentRegisters = arrayList;
            arrayList.add(W3CMoudleManager.getInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeInitDensity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            try {
                if (this.density == -1.0f) {
                    this.density = this.mContext.getResources().getDisplayMetrics().density;
                }
            } catch (Exception e) {
                TKExceptionDispatcher.reportException(this, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V8ClassRegisterSlot registerClassObject(JSContext jSContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, this, jSContext, str)) == null) {
            V8ClassRegisterSlot v8ClassRegisterSlot = this.classMethodRegisterMap.get(str);
            if (v8ClassRegisterSlot != null) {
                return v8ClassRegisterSlot;
            }
            V8ClassRegisterSlot v8ClassRegisterSlot2 = new V8ClassRegisterSlot(jSContext);
            this.classMethodRegisterMap.put(str, v8ClassRegisterSlot2);
            String replaceAll = str.replaceAll(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, "_");
            HashMap<String, Class[]> classMethods = this.mExportManager.getClassMethods(replaceAll);
            if (classMethods != null) {
                for (Map.Entry<String, Class[]> entry : classMethods.entrySet()) {
                    String key = entry.getKey();
                    v8ClassRegisterSlot2.classObject.registerJavaMethod(new JavaCallback(this, entry, key) { // from class: com.tachikoma.core.bridge.TKJSContext.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TKJSContext this$0;
                        public final /* synthetic */ String val$javaMethodName;
                        public final /* synthetic */ Map.Entry val$methodEntry;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, entry, key};
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
                            this.val$methodEntry = entry;
                            this.val$javaMethodName = key;
                        }

                        @Override // com.kwad.v8.JavaCallback
                        public Object invoke(V8Object v8Object, V8Array v8Array) {
                            InterceptResult invokeLL2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, v8Object, v8Array)) == null) {
                                JSContext.V8AssociateReference associateReference = this.this$0.mJsContext.getAssociateReference(v8Object);
                                Object obj = associateReference.nativeObject;
                                associateReference.close();
                                Object[] transferV8Function = this.this$0.transferV8Function((Class[]) this.val$methodEntry.getValue(), v8Array);
                                int i = 0;
                                try {
                                    return this.this$0.invokeMethod(obj, this.val$javaMethodName, (Class[]) this.val$methodEntry.getValue(), transferV8Function);
                                } finally {
                                    int length = transferV8Function.length;
                                    while (i < length) {
                                        Object obj2 = transferV8Function[i];
                                        if (obj2 instanceof V8Value) {
                                            V8Proxy.release((V8Value) obj2);
                                        }
                                        i++;
                                    }
                                }
                            }
                            return invokeLL2.objValue;
                        }
                    }, this.mExportManager.getJsFunctionName(key));
                }
            }
            v8ClassRegisterSlot2.handleObject.registerJavaMethod(new JavaCallback(this, this.mExportManager.getProperties(replaceAll)) { // from class: com.tachikoma.core.bridge.TKJSContext.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKJSContext this$0;
                public final /* synthetic */ List val$classProperties;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
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
                    this.val$classProperties = r7;
                }

                @Override // com.kwad.v8.JavaCallback
                public Object invoke(V8Object v8Object, V8Array v8Array) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, v8Object, v8Array)) == null) {
                        ArrayList arrayList = new ArrayList();
                        try {
                            V8Object v8Object2 = (V8Object) v8Array.get(0);
                            arrayList.add(v8Object2);
                            String string = v8Array.getString(1);
                            JSContext.V8AssociateReference associateReference = this.this$0.mJsContext.getAssociateReference(v8Object2);
                            Object obj = associateReference.nativeObject;
                            arrayList.add(associateReference);
                            Object obj2 = v8Array.get(2);
                            arrayList.add(obj2);
                            if (this.val$classProperties != null && this.val$classProperties.contains(string) && obj != null) {
                                HashMap<String, Object> hashMap = new HashMap<>();
                                hashMap.put(string, V8ObjectUtils.getValue(obj2));
                                this.this$0.mExportManager.applyProperties(obj.getClass().getName(), obj, hashMap);
                            } else if (obj2 instanceof V8Value) {
                                v8Object2.add(string, (V8Value) obj2);
                            } else if (obj2 instanceof Integer) {
                                v8Object2.add(string, ((Integer) obj2).intValue());
                            } else if (obj2 instanceof Boolean) {
                                v8Object2.add(string, ((Boolean) obj2).booleanValue());
                            } else if (obj2 instanceof String) {
                                v8Object2.add(string, (String) obj2);
                            } else if (obj2 instanceof Number) {
                                v8Object2.add(string, ((Number) obj2).doubleValue());
                            } else if (obj2 != null) {
                                throw new RuntimeException("Can not add prop: " + string + " for value: " + obj2);
                            } else {
                                v8Object2.addNull(string);
                            }
                        } catch (Throwable th) {
                            try {
                                TKExceptionDispatcher.reportException(this.this$0, th);
                                for (Object obj3 : arrayList) {
                                    if (obj3 instanceof V8Value) {
                                        ((V8Value) obj3).close();
                                    } else if (obj3 instanceof JSContext.V8AssociateReference) {
                                        ((JSContext.V8AssociateReference) obj3).close();
                                    }
                                }
                            } finally {
                                for (Object obj4 : arrayList) {
                                    if (obj4 instanceof V8Value) {
                                        ((V8Value) obj4).close();
                                    } else if (obj4 instanceof JSContext.V8AssociateReference) {
                                        ((JSContext.V8AssociateReference) obj4).close();
                                    }
                                }
                            }
                        }
                        return Boolean.TRUE;
                    }
                    return invokeLL2.objValue;
                }
            }, "set");
            return v8ClassRegisterSlot2;
        }
        return (V8ClassRegisterSlot) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerGlobalComponent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, str) == null) {
            maybeInitComponentRegister();
            Iterator<IComponentRegister> it = this.mComponentRegisters.iterator();
            while (it.hasNext() && !it.next().register(str)) {
            }
        }
    }

    private void registerSingleJsClass(V8 v8, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65561, this, v8, str, str2) == null) {
            v8.registerJavaMethod(new JavaCallback(this, str2, v8) { // from class: com.tachikoma.core.bridge.TKJSContext.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKJSContext this$0;
                public final /* synthetic */ String val$javaName;
                public final /* synthetic */ V8 val$runtime;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, v8};
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
                    this.val$javaName = str2;
                    this.val$runtime = v8;
                }

                @Override // com.kwad.v8.JavaCallback
                public Object invoke(V8Object v8Object, V8Array v8Array) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, v8Object, v8Array)) == null) {
                        TKJSContext tKJSContext = this.this$0;
                        V8ClassRegisterSlot registerClassObject = tKJSContext.registerClassObject(tKJSContext.mJsContext, this.val$javaName);
                        List<Object> arrayList = v8Array.length() == 0 ? new ArrayList<>() : V8ObjectUtils.toList(v8Array);
                        arrayList.add(this.this$0);
                        arrayList.add(v8Object);
                        Object newInstance = this.this$0.mExportManager.getIFactory(this.val$javaName).newInstance(this.this$0.getViewCreateContext(), arrayList);
                        if (newInstance instanceof ILifeCycle) {
                            ((ILifeCycle) newInstance).onCreate();
                        }
                        this.this$0.mJsContext.registerAssociateObject(v8Object, newInstance);
                        V8Array v8Array2 = new V8Array(this.val$runtime);
                        v8Array2.push((V8Value) registerClassObject.classObject);
                        v8Array2.push((V8Value) registerClassObject.handleObject);
                        this.this$0.ensureLinkClassFunction();
                        V8Object v8Object2 = null;
                        try {
                            v8Object2 = (V8Object) this.this$0.mLinkClass.call(v8Object, v8Array2);
                        } catch (Throwable th) {
                            TKExceptionDispatcher.reportException(this.this$0, th);
                        }
                        v8Array2.close();
                        return v8Object2;
                    }
                    return invokeLL.objValue;
                }
            }, str);
        }
    }

    private void registerUtilMethod(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, v8Object) == null) {
            v8Object.registerJavaMethod(new JavaCallback(this) { // from class: com.tachikoma.core.bridge.TKJSContext.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKJSContext this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.kwad.v8.JavaCallback
                public Object invoke(V8Object v8Object2, V8Array v8Array) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, v8Object2, v8Array)) == null) {
                        V8Object v8Object3 = (V8Object) v8Array.get(0);
                        this.this$0.onRendered(v8Object3);
                        V8Proxy.release(v8Object3);
                        return null;
                    }
                    return invokeLL.objValue;
                }
            }, "render");
            v8Object.registerJavaMethod(new JavaCallback(this) { // from class: com.tachikoma.core.bridge.TKJSContext.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKJSContext this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.kwad.v8.JavaCallback
                public Object invoke(V8Object v8Object2, V8Array v8Array) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, v8Object2, v8Array)) == null) {
                        if (v8Array.length() != 2) {
                            TKJSContext tKJSContext = this.this$0;
                            tKJSContext.logError("JS 调用 Tachikoma.registerView 参数错误，参数个数应该为 2，实际为 " + v8Array.length(), true);
                            return null;
                        }
                        Object obj = v8Array.get(0);
                        Object obj2 = v8Array.get(1);
                        if ((obj2 instanceof V8Function) && (obj instanceof String)) {
                            this.this$0.mCreateViewFunctionMap.put((String) obj, (V8Function) obj2);
                        } else {
                            TKJSContext tKJSContext2 = this.this$0;
                            tKJSContext2.logError("JS 调用 Tachikoma.registerView 参数类型不对，应该为(String, Function) 实际为: " + obj.getClass().getSimpleName() + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj2.getClass().getSimpleName(), true);
                        }
                        return null;
                    }
                    return invokeLL.objValue;
                }
            }, "registerView");
            v8Object.registerJavaMethod(new JavaCallback(this) { // from class: com.tachikoma.core.bridge.TKJSContext.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKJSContext this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.kwad.v8.JavaCallback
                public Object invoke(V8Object v8Object2, V8Array v8Array) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, v8Object2, v8Array)) == null) {
                        this.this$0.maybeInitDensity();
                        return Double.valueOf(((Number) v8Array.get(0)).doubleValue() / this.this$0.density);
                    }
                    return invokeLL.objValue;
                }
            }, "px2Dp");
            v8Object.registerJavaMethod(new JavaCallback(this) { // from class: com.tachikoma.core.bridge.TKJSContext.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKJSContext this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.kwad.v8.JavaCallback
                public Object invoke(V8Object v8Object2, V8Array v8Array) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, v8Object2, v8Array)) == null) {
                        this.this$0.maybeInitDensity();
                        return Integer.valueOf((int) ((this.this$0.density * ((Number) v8Array.get(0)).doubleValue()) + 0.5d));
                    }
                    return invokeLL.objValue;
                }
            }, "dp2Px");
            v8Object.registerJavaMethod(new JavaVoidCallback(this) { // from class: com.tachikoma.core.bridge.TKJSContext.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKJSContext this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.kwad.v8.JavaVoidCallback
                public void invoke(V8Object v8Object2, V8Array v8Array) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, v8Object2, v8Array) == null) {
                        this.this$0.maybeInitDensity();
                        this.this$0.registerGlobalComponent((String) v8Array.get(0));
                    }
                }
            }, "requireGlobalComponent");
            v8Object.registerJavaMethod(new JavaCallback(this) { // from class: com.tachikoma.core.bridge.TKJSContext.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKJSContext this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.kwad.v8.JavaCallback
                public Object invoke(V8Object v8Object2, V8Array v8Array) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, v8Object2, v8Array)) == null) {
                        IHostEnvInner iHostEnvInner = (IHostEnvInner) TKModuleManager.getInstance().getHandler(this.this$0, IHostEnvInner.class);
                        return Boolean.valueOf(iHostEnvInner != null && iHostEnvInner.isDark());
                    }
                    return invokeLL.objValue;
                }
            }, "isDark");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] transferV8Function(Class<?>[] clsArr, V8Array v8Array) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, this, clsArr, v8Array)) == null) {
            Object[] objArr = new Object[v8Array.length()];
            for (int i = 0; i < v8Array.length(); i++) {
                if (clsArr[i].isAssignableFrom(IV8Function.class) && (v8Array.get(i) instanceof V8Function)) {
                    objArr[i] = new V8FunctionImpl((V8Function) v8Array.get(i), this);
                } else {
                    objArr[i] = v8Array.get(i);
                }
            }
            return objArr;
        }
        return (Object[]) invokeLL.objValue;
    }

    private V8Object updateEnv(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        String key;
        double floatValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, this, hashMap)) == null) {
            V8Object makeObject = this.mJsContext.makeObject();
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                Object value = entry.getValue();
                Class<?> cls = value.getClass();
                if (cls.equals(String.class)) {
                    makeObject.add(entry.getKey(), (String) value);
                } else if (cls.equals(Integer.class)) {
                    makeObject.add(entry.getKey(), ((Integer) value).intValue());
                } else {
                    if (cls.equals(Float.class)) {
                        key = entry.getKey();
                        floatValue = ((Float) value).floatValue();
                    } else if (cls.equals(Double.class)) {
                        key = entry.getKey();
                        floatValue = ((Double) value).doubleValue();
                    } else if (cls.equals(Boolean.class)) {
                        makeObject.add(entry.getKey(), ((Boolean) value).booleanValue());
                    }
                    makeObject.add(key, floatValue);
                }
            }
            return makeObject;
        }
        return (V8Object) invokeL.objValue;
    }

    public JSContext context() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mJsContext : (JSContext) invokeV.objValue;
    }

    @Nullable
    public JSContext.V8AssociateReference createView(@Nullable Context context, String str, Object... objArr) {
        InterceptResult invokeLLL;
        V8Array v8Array;
        V8Object v8Object;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, objArr)) != null) {
            return (JSContext.V8AssociateReference) invokeLLL.objValue;
        }
        V8Function v8Function = this.mCreateViewFunctionMap.get(str);
        if (v8Function == null) {
            logError("找不到对应 key: " + str + " 的 view", false);
            return null;
        }
        Context context2 = this.mViewCreateContext;
        try {
            this.mViewCreateContext = context;
            v8Array = this.mJsContext.makeV8Array();
            for (Object obj : objArr) {
                try {
                    v8Array.push(TKConverter.toV8Value(obj, this.mJsContext));
                } catch (Throwable th) {
                    th = th;
                    v8Object = null;
                }
            }
            Object call = v8Function.call(null, v8Array);
            if (call == null) {
                logError("对应 key: " + str + " 的构建返回了 null", false);
                V8Proxy.release(v8Array);
                V8Proxy.release(null);
                this.mViewCreateContext = context2;
                return null;
            } else if (!(call instanceof V8Object)) {
                throw new IllegalStateException("对应 key: " + str + " 的构建返回了非 view 类型");
            } else {
                v8Object = (V8Object) call;
                try {
                    JSContext.V8AssociateReference associateReference = this.mJsContext.getAssociateReference(v8Object);
                    if (associateReference.nativeObject instanceof TKBase) {
                        return associateReference;
                    }
                    String str2 = "对应 key: " + str + " 的构建返回了非 view 类型";
                    associateReference.close();
                    throw new IllegalStateException(str2);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        TKExceptionDispatcher.reportException(this, th);
                        return null;
                    } finally {
                        V8Proxy.release(v8Array);
                        V8Proxy.release(v8Object);
                        this.mViewCreateContext = context2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            v8Array = null;
            v8Object = null;
        }
    }

    @Nullable
    public IExceptionHandlerInner getExceptionHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mExceptionHandler : (IExceptionHandlerInner) invokeV.objValue;
    }

    public <T> T getHandler(Class cls) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            if (cls == null || (t = (T) this.mHandlerMap.get(cls)) == null) {
                return null;
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public String getRootDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!TextUtils.isEmpty(this.mRootDir) && !this.mRootDir.endsWith("/")) {
                this.mRootDir = this.mRootDir.concat("/");
            }
            return this.mRootDir;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.tachikoma.core.common.ILifeCycle
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            JSContext create = JSContext.create();
            this.mJsContext = create;
            create.setTKJsContextHashcode(hashCode());
            this.mJsContext.attachView(this.mRootView);
            if (this.mExportManager == null) {
                this.mExportManager = TKExportManager.getInstance();
            }
            if (!this.mExportManager.isCreate()) {
                this.mExportManager.onCreate();
            }
            this.mPendingReleaseV8List = new ArrayList();
            registerJSClasses(this.mContext, this.mRootView);
            ILifeCycle iLifeCycle = this.mLifeCycleCallback;
            if (iLifeCycle != null) {
                iLifeCycle.onCreate();
            }
        }
    }

    @Override // com.tachikoma.core.common.ILifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ILifeCycle iLifeCycle = this.mLifeCycleCallback;
            if (iLifeCycle != null) {
                iLifeCycle.onDestroy();
            }
            TKLifeCycle.ActivityLifecycleCallbacksProxy.unRegisterLifecycleCallbacks(this);
            ViewGroup viewGroup = this.mRootView;
            if (viewGroup != null) {
                dfsDestroyChildren(viewGroup);
                this.mRootView = null;
            }
            JSContext.V8AssociateReference v8AssociateReference = this.mRootViewReference;
            if (v8AssociateReference != null) {
                v8AssociateReference.close();
            }
            Env.mEnvListener = null;
            for (V8Function v8Function : this.mCreateViewFunctionMap.values()) {
                V8Proxy.release(v8Function);
            }
            this.mCreateViewFunctionMap.clear();
            V8Function v8Function2 = this.mLinkClass;
            if (v8Function2 != null) {
                V8Proxy.release(v8Function2);
                this.mLinkClass = null;
            }
            for (Map.Entry<String, V8ClassRegisterSlot> entry : this.classMethodRegisterMap.entrySet()) {
                if (entry.getValue() != null) {
                    V8Proxy.release(entry.getValue().classObject);
                    V8Proxy.release(entry.getValue().handleObject);
                }
            }
            this.classMethodRegisterMap.clear();
            List<V8Value> list = this.mPendingReleaseV8List;
            if (list != null) {
                for (V8Value v8Value : list) {
                    if (!v8Value.isReleased()) {
                        v8Value.close();
                    }
                }
                this.mPendingReleaseV8List.clear();
                this.mPendingReleaseV8List = null;
            }
            JSContext jSContext = this.mJsContext;
            if (jSContext != null) {
                jSContext.destroy();
                this.mJsContext = null;
            }
            this.mHandlerMap.clear();
            this.mInvokeMethodCache.evictAll();
        }
    }

    public void onRendered(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, v8Object) == null) {
            JSContext.V8AssociateReference associateReference = this.mJsContext.getAssociateReference(v8Object);
            TKBase tKBase = (TKBase) associateReference.nativeObject;
            ViewGroup viewGroup = (ViewGroup) tKBase.getView();
            if (viewGroup != null) {
                YogaNode yogaNode = tKBase.getDomNode().getYogaNode();
                yogaNode.setAlignContent(YogaAlign.CENTER);
                yogaNode.setAlignItems(YogaAlign.CENTER);
                yogaNode.setJustifyContent(YogaJustify.CENTER);
                yogaNode.calculateLayout(0.0f, 0.0f);
            }
            JSContext.V8AssociateReference v8AssociateReference = this.mRootViewReference;
            if (v8AssociateReference != null) {
                v8AssociateReference.close();
            }
            this.mRootViewReference = associateReference;
            ViewGroup viewGroup2 = this.mRootView;
            if (viewGroup2 == null || viewGroup == null) {
                return;
            }
            viewGroup2.removeAllViews();
            this.mRootView.addView(viewGroup);
        }
    }

    public void registerJSClasses(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, viewGroup) == null) {
            V8 contextRef = this.mJsContext.getContextRef();
            V8Object makeObject = this.mJsContext.makeObject();
            registerUtilMethod(makeObject);
            V8Value updateEnv = updateEnv(Env.sContextInfo);
            makeObject.add("env", updateEnv);
            contextRef.add("Tachikoma", makeObject);
            updateEnv.close();
            W3CMoudleManager.getInstance().registerW3CObject(this.mJsContext, this, contextRef);
            makeObject.close();
            for (Map.Entry<String, String> entry : this.mExportManager.allExportClasses().entrySet()) {
                registerSingleJsClass(contextRef, entry.getKey(), entry.getValue());
            }
        }
    }

    public void registerJavaScriptInterface(Object obj, String str, HashMap<String, Class[]> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, obj, str, hashMap) == null) {
            V8 contextRef = this.mJsContext.getContextRef();
            V8Object makeObject = this.mJsContext.makeObject();
            contextRef.add(str, makeObject);
            for (Map.Entry<String, Class[]> entry : hashMap.entrySet()) {
                makeObject.registerJavaMethod(obj, entry.getKey(), entry.getKey(), entry.getValue());
            }
            makeObject.close();
        }
    }

    public View rootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mRootView : (View) invokeV.objValue;
    }

    public void setBaseBridge(@NonNull IBaseBridgeInner iBaseBridgeInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iBaseBridgeInner) == null) {
            this.mHandlerMap.put(IBaseBridgeInner.class, iBaseBridgeInner);
        }
    }

    public void setBusinessSchoolBridge(@NonNull IBusinessSchoolBridge iBusinessSchoolBridge) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iBusinessSchoolBridge) == null) {
            this.mHandlerMap.put(IBusinessSchoolBridge.class, iBusinessSchoolBridge);
        }
    }

    public void setRootDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mRootDir = str;
        }
    }

    public void setWebCardBridge(@NonNull IWebCardBridgeInner iWebCardBridgeInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iWebCardBridgeInner) == null) {
            this.mHandlerMap.put(IWebCardBridgeInner.class, iWebCardBridgeInner);
        }
    }
}
