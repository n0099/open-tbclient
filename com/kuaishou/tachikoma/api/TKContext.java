package com.kuaishou.tachikoma.api;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.tachikoma.api.app.IRenderListener;
import com.kuaishou.tachikoma.api.app.IRequestCallback;
import com.kuaishou.tachikoma.api.app.IRequestDelegate;
import com.kuaishou.tachikoma.api.app.TKBaseResponse;
import com.kuaishou.tachikoma.api.app.TKError;
import com.kuaishou.tachikoma.api.app.TkBundleInfo;
import com.kuaishou.tachikoma.api.exception.BundleContextMap;
import com.kuaishou.tachikoma.api.model.TKBundle;
import com.kuaishou.tachikoma.api.page.IBaseBridge;
import com.kuaishou.tachikoma.api.page.INewBaseBridge;
import com.kuaishou.tachikoma.api.page.IRouter;
import com.kuaishou.tachikoma.api.page.IWebCardBridge;
import com.kwad.v8.V8;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Function;
import com.kwad.v8.V8Object;
import com.tachikoma.core.api.IBaseBridgeInner;
import com.tachikoma.core.api.IRenderListenerInner;
import com.tachikoma.core.api.IRequestDelegateInner;
import com.tachikoma.core.api.IRouterInner;
import com.tachikoma.core.api.IWebCardBridgeInner;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.component.network.Network;
import com.tachikoma.core.component.network.ResponseCallBackInner;
import com.tachikoma.core.component.network.TKErrorInner;
import com.tachikoma.core.component.network.delegate.TKBaseResponseInner;
import com.tachikoma.core.manager.RouterManager;
import java.util.Map;
/* loaded from: classes2.dex */
public class TKContext {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TKContext";
    public transient /* synthetic */ FieldHolder $fh;
    public final TKJSContext mContext;
    public String mRootDir;
    public LruCache<String, String> mScriptCache;

    public TKContext(TKJSContext tKJSContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tKJSContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mScriptCache = null;
        this.mRootDir = "";
        this.mContext = tKJSContext;
    }

    private String getBundleScript(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        LruCache<String, String> lruCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, this, context, str, z)) == null) {
            if (z) {
                maybeCreateCache();
            }
            String str2 = (TextUtils.isEmpty(str) || (lruCache = this.mScriptCache) == null) ? null : lruCache.get(str);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return str2;
        }
        return (String) invokeLLZ.objValue;
    }

    private void maybeCreateCache() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.mScriptCache == null) {
            synchronized (this) {
                if (this.mScriptCache == null) {
                    this.mScriptCache = new LruCache<>(3);
                }
            }
        }
    }

    public TKJSBridge buildJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new TKJSBridge(this.mContext) : (TKJSBridge) invokeV.objValue;
    }

    @Nullable
    public TKViewContainer createView(Context context, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, objArr)) == null) {
            JSContext.V8AssociateReference createView = this.mContext.createView(context, str, objArr);
            if (createView == null) {
                return null;
            }
            return new TKViewContainer(createView);
        }
        return (TKViewContainer) invokeLLL.objValue;
    }

    @Deprecated
    public TKViewContainer createView(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, objArr)) == null) ? createView(null, str, objArr) : (TKViewContainer) invokeLL.objValue;
    }

    public Object evaluateScript(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, str3)) == null) {
            if (!TextUtils.isEmpty(str3)) {
                this.mRootDir = str3;
                this.mContext.setRootDir(str3);
            }
            if (this.mContext.context() == null) {
                return null;
            }
            return this.mContext.context().evaluateScript(str, str2);
        }
        return invokeLLL.objValue;
    }

    public void evaluateScript(String str, String str2, String str3, IRenderListener iRenderListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, str3, iRenderListener) == null) {
            if (!TextUtils.isEmpty(str3)) {
                this.mRootDir = str3;
                this.mContext.setRootDir(str3);
            }
            if (this.mContext.context() != null) {
                this.mContext.context().evaluateScript(str, str2, new IRenderListenerInner(this, iRenderListener) { // from class: com.kuaishou.tachikoma.api.TKContext.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TKContext this$0;
                    public final /* synthetic */ IRenderListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iRenderListener};
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
                        this.val$listener = iRenderListener;
                    }

                    @Override // com.tachikoma.core.api.IRenderListenerInner
                    public void failed(Throwable th) {
                        IRenderListener iRenderListener2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, th) == null) || (iRenderListener2 = this.val$listener) == null) {
                            return;
                        }
                        iRenderListener2.failed(th);
                    }

                    @Override // com.tachikoma.core.api.IRenderListenerInner
                    public void success() {
                        IRenderListener iRenderListener2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iRenderListener2 = this.val$listener) == null) {
                            return;
                        }
                        iRenderListener2.success();
                    }
                });
            } else if (iRenderListener != null) {
                iRenderListener.failed(new Throwable("mContext.context() is null"));
            }
        }
    }

    public Object evaluateScriptById(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, context, str, z)) == null) {
            String bundleScript = getBundleScript(context, str, z);
            if (this.mContext.context() == null) {
                return null;
            }
            return this.mContext.context().evaluateScriptById(bundleScript);
        }
        return invokeLLZ.objValue;
    }

    public void evaluateScriptById(Context context, String str, boolean z, IRenderListener iRenderListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, Boolean.valueOf(z), iRenderListener}) == null) {
            if (this.mContext.context() != null) {
                this.mContext.context().evaluateScriptById(context, str, z, new IRenderListenerInner(this, iRenderListener) { // from class: com.kuaishou.tachikoma.api.TKContext.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TKContext this$0;
                    public final /* synthetic */ IRenderListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iRenderListener};
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
                        this.val$listener = iRenderListener;
                    }

                    @Override // com.tachikoma.core.api.IRenderListenerInner
                    public void failed(Throwable th) {
                        IRenderListener iRenderListener2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, th) == null) || (iRenderListener2 = this.val$listener) == null) {
                            return;
                        }
                        iRenderListener2.failed(th);
                    }

                    @Override // com.tachikoma.core.api.IRenderListenerInner
                    public void success() {
                        IRenderListener iRenderListener2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iRenderListener2 = this.val$listener) == null) {
                            return;
                        }
                        iRenderListener2.success();
                    }
                });
            } else if (iRenderListener != null) {
                iRenderListener.failed(new RuntimeException("mContext.context() is null"));
            }
        }
    }

    public TKJSContext getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mContext : (TKJSContext) invokeV.objValue;
    }

    @Nullable
    public V8 getV8Context() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mContext.context() == null) {
                return null;
            }
            return this.mContext.context().getContextRef();
        }
        return (V8) invokeV.objValue;
    }

    public String getmRootDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mRootDir : (String) invokeV.objValue;
    }

    public V8Object makeObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mContext.context().makeObject() : (V8Object) invokeV.objValue;
    }

    public V8Array makeV8Array() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mContext.context().makeV8Array() : (V8Array) invokeV.objValue;
    }

    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.mContext.onCreate();
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            LruCache<String, String> lruCache = this.mScriptCache;
            if (lruCache != null) {
                lruCache.evictAll();
                this.mScriptCache = null;
            }
            RouterManager.getInstance().unRegisterRouter(this.mContext.context());
            BundleContextMap.remove(this.mContext.hashCode());
            this.mContext.onDestroy();
        }
    }

    public void registerOKClient(IRequestDelegate iRequestDelegate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, iRequestDelegate) == null) || iRequestDelegate == null) {
            return;
        }
        Network.setRequestDelegate(this.mContext, new IRequestDelegateInner(this, iRequestDelegate) { // from class: com.kuaishou.tachikoma.api.TKContext.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TKContext this$0;
            public final /* synthetic */ IRequestDelegate val$client;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iRequestDelegate};
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
                this.val$client = iRequestDelegate;
            }

            @Override // com.tachikoma.core.api.IRequestDelegateInner
            public void get(ResponseCallBackInner responseCallBackInner) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, responseCallBackInner) == null) {
                    this.val$client.get(new IRequestCallback(this, responseCallBackInner) { // from class: com.kuaishou.tachikoma.api.TKContext.1.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ ResponseCallBackInner val$callBack;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, responseCallBackInner};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$callBack = responseCallBackInner;
                        }

                        @Override // com.kuaishou.tachikoma.api.app.IRequestCallback
                        public void onComplete(TKBaseResponse tKBaseResponse) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, tKBaseResponse) == null) {
                                TKBaseResponseInner tKBaseResponseInner = new TKBaseResponseInner();
                                if (tKBaseResponse != null) {
                                    tKBaseResponseInner.allHeaderFields = tKBaseResponse.allHeaderFields;
                                    tKBaseResponseInner.body = tKBaseResponse.body;
                                    tKBaseResponseInner.statusCode = tKBaseResponse.statusCode;
                                }
                                this.val$callBack.onComplete(tKBaseResponseInner);
                            }
                        }

                        @Override // com.kuaishou.tachikoma.api.app.IRequestCallback
                        public void onError(TKError tKError) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tKError) == null) {
                                TKErrorInner tKErrorInner = new TKErrorInner();
                                if (tKError != null) {
                                    tKErrorInner.code = tKError.code;
                                    tKErrorInner.msg = tKError.msg;
                                    tKErrorInner.name = tKError.name;
                                }
                                this.val$callBack.onError(tKErrorInner);
                            }
                        }
                    });
                }
            }

            @Override // com.tachikoma.core.api.IRequestDelegateInner
            public void post(ResponseCallBackInner responseCallBackInner) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseCallBackInner) == null) {
                    this.val$client.post(new IRequestCallback(this, responseCallBackInner) { // from class: com.kuaishou.tachikoma.api.TKContext.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ ResponseCallBackInner val$callBack;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, responseCallBackInner};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$callBack = responseCallBackInner;
                        }

                        @Override // com.kuaishou.tachikoma.api.app.IRequestCallback
                        public void onComplete(TKBaseResponse tKBaseResponse) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, tKBaseResponse) == null) {
                                TKBaseResponseInner tKBaseResponseInner = new TKBaseResponseInner();
                                if (tKBaseResponse != null) {
                                    tKBaseResponseInner.allHeaderFields = tKBaseResponse.allHeaderFields;
                                    tKBaseResponseInner.body = tKBaseResponse.body;
                                    tKBaseResponseInner.statusCode = tKBaseResponse.statusCode;
                                }
                                this.val$callBack.onComplete(tKBaseResponseInner);
                            }
                        }

                        @Override // com.kuaishou.tachikoma.api.app.IRequestCallback
                        public void onError(TKError tKError) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tKError) == null) {
                                TKErrorInner tKErrorInner = new TKErrorInner();
                                if (tKError != null) {
                                    tKErrorInner.code = tKError.code;
                                    tKErrorInner.msg = tKError.msg;
                                    tKErrorInner.name = tKError.name;
                                }
                                this.val$callBack.onError(tKErrorInner);
                            }
                        }
                    });
                }
            }

            @Override // com.tachikoma.core.api.IRequestDelegateInner
            public void setBody(Map<String, String> map) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                    this.val$client.setBody(map);
                }
            }

            @Override // com.tachikoma.core.api.IRequestDelegateInner
            public void setHeader(Map<String, String> map) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, map) == null) {
                    this.val$client.setHeader(map);
                }
            }

            @Override // com.tachikoma.core.api.IRequestDelegateInner
            public void setHost(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048580, this, str) == null) {
                    this.val$client.setHost(str);
                }
            }

            @Override // com.tachikoma.core.api.IRequestDelegateInner
            public void setInterval(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                    this.val$client.setInterval(i2);
                }
            }

            @Override // com.tachikoma.core.api.IRequestDelegateInner
            public void setParams(Map<String, String> map) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048582, this, map) == null) {
                    this.val$client.setParams(map);
                }
            }

            @Override // com.tachikoma.core.api.IRequestDelegateInner
            public void setPath(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048583, this, str) == null) {
                    this.val$client.setPath(str);
                }
            }

            @Override // com.tachikoma.core.api.IRequestDelegateInner
            public void setScheme(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                    this.val$client.setScheme(str);
                }
            }

            @Override // com.tachikoma.core.api.IRequestDelegateInner
            public void setUserInfo(Map<String, Object> map) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048585, this, map) == null) {
                    this.val$client.setUserInfo(map);
                }
            }
        });
    }

    public void registerRouter(IRouter iRouter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iRouter) == null) {
            RouterManager.getInstance().registerRouter(this.mContext.context(), new IRouterInner(this, iRouter) { // from class: com.kuaishou.tachikoma.api.TKContext.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKContext this$0;
                public final /* synthetic */ IRouter val$iRouter;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iRouter};
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
                    this.val$iRouter = iRouter;
                }

                @Override // com.tachikoma.core.api.IRouterInner
                public void navigateTo(Uri uri) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, uri) == null) {
                        this.val$iRouter.navigateTo(uri);
                    }
                }
            });
        }
    }

    @Deprecated
    public void setBaseBridge(@NonNull IBaseBridge iBaseBridge) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, iBaseBridge) == null) || iBaseBridge == null) {
            return;
        }
        this.mContext.setBaseBridge(new IBaseBridgeInner(this, iBaseBridge) { // from class: com.kuaishou.tachikoma.api.TKContext.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TKContext this$0;
            public final /* synthetic */ IBaseBridge val$bridge;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iBaseBridge};
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
                this.val$bridge = iBaseBridge;
            }

            @Override // com.tachikoma.core.api.IBaseBridgeInner
            public Object invoke(String str, @Nullable String str2, @Nullable V8Function v8Function) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str, str2, v8Function)) == null) ? this.val$bridge.invoke(str, str2, v8Function) : invokeLLL.objValue;
            }

            @Override // com.tachikoma.core.api.IBaseBridgeInner
            public Object invokeM(String str, String str2, @Nullable String str3, @Nullable V8Function v8Function) {
                InterceptResult invokeLLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, v8Function)) == null) ? this.val$bridge.invoke(str, str2, str3, v8Function) : invokeLLLL.objValue;
            }
        });
    }

    public void setBundleInfo(TkBundleInfo tkBundleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, tkBundleInfo, str) == null) {
            TKBundle tKBundle = new TKBundle(tkBundleInfo.mBundleId, tkBundleInfo.mVersion, String.valueOf(tkBundleInfo.mVersionCode), str, tkBundleInfo.mTaskId);
            TKJSContext tKJSContext = this.mContext;
            if (tKJSContext != null) {
                BundleContextMap.setData(tKJSContext.hashCode(), tKBundle);
            }
        }
    }

    public void setNewBaseBridge(@NonNull INewBaseBridge iNewBaseBridge) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, iNewBaseBridge) == null) || iNewBaseBridge == null) {
            return;
        }
        this.mContext.setBaseBridge(new IBaseBridgeInner(this, iNewBaseBridge) { // from class: com.kuaishou.tachikoma.api.TKContext.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TKContext this$0;
            public final /* synthetic */ INewBaseBridge val$bridge;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iNewBaseBridge};
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
                this.val$bridge = iNewBaseBridge;
            }

            @Override // com.tachikoma.core.api.IBaseBridgeInner
            public Object invoke(String str, @Nullable String str2, @Nullable V8Function v8Function) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str, str2, v8Function)) == null) ? this.val$bridge.invoke(str, str2, new FunctionCallImpl(v8Function)) : invokeLLL.objValue;
            }

            @Override // com.tachikoma.core.api.IBaseBridgeInner
            public Object invokeM(String str, String str2, @Nullable String str3, @Nullable V8Function v8Function) {
                InterceptResult invokeLLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, v8Function)) == null) ? this.val$bridge.invoke(str, str2, str3, new FunctionCallImpl(v8Function)) : invokeLLLL.objValue;
            }
        });
    }

    public void setWebCardBridge(@NonNull IWebCardBridge iWebCardBridge) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, iWebCardBridge) == null) {
            this.mContext.setWebCardBridge(new IWebCardBridgeInner(this, iWebCardBridge) { // from class: com.kuaishou.tachikoma.api.TKContext.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKContext this$0;
                public final /* synthetic */ IWebCardBridge val$bridge;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iWebCardBridge};
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
                    this.val$bridge = iWebCardBridge;
                }

                @Override // com.tachikoma.core.api.IWebCardBridgeInner
                public void close() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$bridge.close();
                    }
                }

                @Override // com.tachikoma.core.api.IWebCardBridgeInner
                public void convert() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.val$bridge.convert();
                    }
                }

                @Override // com.tachikoma.core.api.IWebCardBridgeInner
                public String getData() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.val$bridge.getData() : (String) invokeV.objValue;
                }

                @Override // com.tachikoma.core.api.IWebCardBridgeInner
                public void handleAdUrl(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, str) == null) {
                        this.val$bridge.handleAdUrl(str);
                    }
                }

                @Override // com.tachikoma.core.api.IWebCardBridgeInner
                public void hide() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        this.val$bridge.hide();
                    }
                }

                @Override // com.tachikoma.core.api.IWebCardBridgeInner
                public void log(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048581, this, str) == null) {
                        this.val$bridge.log(str);
                    }
                }

                @Override // com.tachikoma.core.api.IWebCardBridgeInner
                public void nonActionbarClick(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, str) == null) {
                        this.val$bridge.nonActionbarClick(str);
                    }
                }

                @Override // com.tachikoma.core.api.IWebCardBridgeInner
                public void pageStatus(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048583, this, str) == null) {
                        this.val$bridge.pageStatus(str);
                    }
                }

                @Override // com.tachikoma.core.api.IWebCardBridgeInner
                public void registerProgressListener(V8Function v8Function) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v8Function) == null) {
                        this.val$bridge.registerProgressListener(v8Function);
                    }
                }

                @Override // com.tachikoma.core.api.IWebCardBridgeInner
                public void trace(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048585, this, str) == null) {
                        this.val$bridge.trace(str);
                    }
                }
            });
        }
    }
}
