package com.tachikoma.core.component.network;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Function;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.api.IRequestDelegateInner;
import com.tachikoma.core.base.NativeModule;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.component.network.delegate.RequestConnectionDelegate;
import com.tachikoma.core.component.network.delegate.TKBaseResponseInner;
import com.tachikoma.core.utility.V8Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@TK_EXPORT_CLASS
/* loaded from: classes3.dex */
public class Network implements NativeModule {
    public static /* synthetic */ Interceptable $ic = null;
    public static String METHOD_GET = "GET";
    public static String METHOD_POST = "POST";
    public static HashMap<JSContext, IRequestDelegateInner> mRequestMap;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> bodyParameters;
    public Map<String, String> headers;
    public String host;
    public V8Function mGetCallback;
    public final JSContext mJSContext;
    public V8Function mPostCallback;
    public IRequestDelegateInner mRequestDelegate;
    public final TKJSContext mTKJSContext;
    public Map<String, String> parameters;
    public String path;
    public String scheme;
    public int timeoutInterval;
    public Map<String, Object> userInfo;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1476793962, "Lcom/tachikoma/core/component/network/Network;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1476793962, "Lcom/tachikoma/core/component/network/Network;");
                return;
            }
        }
        mRequestMap = new HashMap<>();
    }

    public Network(Context context, @Nullable List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRequestDelegate = new RequestConnectionDelegate();
        TKJSContext tKContext = V8Proxy.getTKContext(list);
        this.mTKJSContext = tKContext;
        JSContext context2 = tKContext.context();
        this.mJSContext = context2;
        IRequestDelegateInner iRequestDelegateInner = mRequestMap.get(context2);
        if (iRequestDelegateInner != null) {
            this.mRequestDelegate = iRequestDelegateInner;
        }
    }

    public static void removeRequestDelegate(JSContext jSContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, jSContext) == null) || jSContext == null) {
            return;
        }
        mRequestMap.remove(jSContext);
    }

    public static void setRequestDelegate(TKJSContext tKJSContext, IRequestDelegateInner iRequestDelegateInner) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, tKJSContext, iRequestDelegateInner) == null) || tKJSContext == null || iRequestDelegateInner == null) {
            return;
        }
        mRequestMap.put(tKJSContext.context(), iRequestDelegateInner);
    }

    @Override // com.tachikoma.core.base.NativeModule
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            V8Function v8Function = this.mPostCallback;
            if (v8Function != null) {
                V8Proxy.release(v8Function);
            }
            V8Function v8Function2 = this.mGetCallback;
            if (v8Function2 != null) {
                V8Proxy.release(v8Function2);
            }
        }
    }

    public void get(V8Function v8Function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8Function) == null) {
            V8Function v8Function2 = this.mGetCallback;
            if (v8Function2 != null) {
                V8Proxy.release(v8Function2);
            }
            this.mGetCallback = v8Function.twin();
            this.mRequestDelegate.get(new ResponseCallBackInner(this) { // from class: com.tachikoma.core.component.network.Network.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Network this$0;

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
                    this.this$0 = this;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                @Override // com.tachikoma.core.component.network.ResponseCallBackInner
                public void onComplete(TKBaseResponseInner tKBaseResponseInner) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tKBaseResponseInner) == null) {
                        if (tKBaseResponseInner != null) {
                            try {
                                if (!this.this$0.mGetCallback.isReleased()) {
                                    V8Array v8Array = new V8Array(this.this$0.mGetCallback.getRuntime());
                                    String jsonString = tKBaseResponseInner.toJsonString();
                                    if (TextUtils.isEmpty(jsonString) || tKBaseResponseInner.equals(StringUtil.EMPTY_ARRAY)) {
                                        jsonString = StringUtil.EMPTY_ARRAY;
                                    }
                                    v8Array.push(jsonString);
                                    this.this$0.mGetCallback.call(null, v8Array);
                                    V8Proxy.release(v8Array);
                                }
                            } finally {
                                try {
                                } finally {
                                }
                            }
                        }
                    }
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                @Override // com.tachikoma.core.component.network.ResponseCallBackInner
                public void onError(TKErrorInner tKErrorInner) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tKErrorInner) == null) {
                        if (tKErrorInner != null) {
                            try {
                                if (!this.this$0.mGetCallback.isReleased()) {
                                    V8Array v8Array = new V8Array(this.this$0.mGetCallback.getRuntime());
                                    v8Array.push(tKErrorInner.toString());
                                    this.this$0.mGetCallback.call(null, v8Array);
                                    V8Proxy.release(v8Array);
                                }
                            } finally {
                                try {
                                } finally {
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.tachikoma.core.base.NativeModule
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "TKRequest" : (String) invokeV.objValue;
    }

    public void post(V8Function v8Function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, v8Function) == null) {
            V8Function v8Function2 = this.mPostCallback;
            if (v8Function2 != null) {
                V8Proxy.release(v8Function2);
            }
            this.mPostCallback = v8Function.twin();
            this.mRequestDelegate.post(new ResponseCallBackInner(this) { // from class: com.tachikoma.core.component.network.Network.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Network this$0;

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
                    this.this$0 = this;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                @Override // com.tachikoma.core.component.network.ResponseCallBackInner
                public void onComplete(TKBaseResponseInner tKBaseResponseInner) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tKBaseResponseInner) == null) {
                        if (tKBaseResponseInner != null) {
                            try {
                                if (!this.this$0.mPostCallback.isReleased()) {
                                    V8Array v8Array = new V8Array(this.this$0.mPostCallback.getRuntime());
                                    String jsonString = tKBaseResponseInner.toJsonString();
                                    if (TextUtils.isEmpty(jsonString)) {
                                        jsonString = StringUtil.EMPTY_ARRAY;
                                    }
                                    v8Array.push(jsonString);
                                    this.this$0.mPostCallback.call(null, v8Array);
                                    V8Proxy.release(v8Array);
                                }
                            } finally {
                                try {
                                } finally {
                                }
                            }
                        }
                    }
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                @Override // com.tachikoma.core.component.network.ResponseCallBackInner
                public void onError(TKErrorInner tKErrorInner) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tKErrorInner) == null) {
                        if (tKErrorInner != null) {
                            try {
                                if (!this.this$0.mPostCallback.isReleased()) {
                                    V8Array v8Array = new V8Array(this.this$0.mPostCallback.getRuntime());
                                    v8Array.push(tKErrorInner.toString());
                                    this.this$0.mPostCallback.call(null, v8Array);
                                    V8Proxy.release(v8Array);
                                }
                            } finally {
                                try {
                                } finally {
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public void setBody(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
            this.mRequestDelegate.setBody(map);
        }
    }

    public void setHeader(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, map) == null) {
            this.mRequestDelegate.setHeader(map);
        }
    }

    public void setHost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mRequestDelegate.setHost(str);
        }
    }

    public void setInterval(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mRequestDelegate.setInterval(i2);
        }
    }

    public void setParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, map) == null) {
            this.mRequestDelegate.setParams(map);
        }
    }

    public void setPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mRequestDelegate.setPath(str);
        }
    }

    public void setScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mRequestDelegate.setScheme(str);
        }
    }

    public void setUserInfo(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, map) == null) {
            this.mRequestDelegate.setUserInfo(map);
        }
    }
}
