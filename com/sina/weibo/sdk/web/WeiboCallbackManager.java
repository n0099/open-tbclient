package com.sina.weibo.sdk.web;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.auth.WbAuthListener;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class WeiboCallbackManager {
    public static /* synthetic */ Interceptable $ic;
    public static WeiboCallbackManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, WbAuthListener> mWeiboAuthListenerMap;

    public WeiboCallbackManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWeiboAuthListenerMap = new HashMap();
    }

    public static synchronized WeiboCallbackManager getInstance() {
        InterceptResult invokeV;
        WeiboCallbackManager weiboCallbackManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (WeiboCallbackManager.class) {
                if (sInstance == null) {
                    sInstance = new WeiboCallbackManager();
                }
                weiboCallbackManager = sInstance;
            }
            return weiboCallbackManager;
        }
        return (WeiboCallbackManager) invokeV.objValue;
    }

    public String genCallbackKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.valueOf(System.currentTimeMillis()) : (String) invokeV.objValue;
    }

    public synchronized WbAuthListener getWeiboAuthListener(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return this.mWeiboAuthListenerMap.get(str);
            }
        }
        return (WbAuthListener) invokeL.objValue;
    }

    public synchronized void removeWeiboAuthListener(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.mWeiboAuthListenerMap.remove(str);
            }
        }
    }

    public synchronized void setWeiboAuthListener(String str, WbAuthListener wbAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, wbAuthListener) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str) && wbAuthListener != null) {
                    this.mWeiboAuthListenerMap.put(str, wbAuthListener);
                }
            }
        }
    }
}
