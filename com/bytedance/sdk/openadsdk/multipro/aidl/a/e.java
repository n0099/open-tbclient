package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, RemoteCallbackList<IFullScreenVideoAdInteractionListener>> f31726a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f31727b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1225391037, "Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1225391037, "Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/e;");
                return;
            }
        }
        f31726a = Collections.synchronizedMap(new HashMap());
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f31727b == null) {
                synchronized (e.class) {
                    if (f31727b == null) {
                        f31727b = new e();
                    }
                }
            }
            return f31727b;
        }
        return (e) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeFullVideoCallback(String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            a(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, iFullScreenVideoAdInteractionListener) == null) {
            synchronized (this) {
                RemoteCallbackList<IFullScreenVideoAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
                remoteCallbackList.register(iFullScreenVideoAdInteractionListener);
                f31726a.put(str, remoteCallbackList);
            }
        }
    }

    private synchronized void a(String str, String str2) {
        RemoteCallbackList<IFullScreenVideoAdInteractionListener> remoteCallbackList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, str, str2) == null) {
            synchronized (this) {
                try {
                    if (f31726a != null) {
                        if ("recycleRes".equals(str2)) {
                            remoteCallbackList = f31726a.remove(str);
                        } else {
                            remoteCallbackList = f31726a.get(str);
                        }
                        if (remoteCallbackList != null) {
                            int beginBroadcast = remoteCallbackList.beginBroadcast();
                            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                                IFullScreenVideoAdInteractionListener broadcastItem = remoteCallbackList.getBroadcastItem(i2);
                                if (broadcastItem != null) {
                                    if ("onAdShow".equals(str2)) {
                                        broadcastItem.onAdShow();
                                    } else if ("onAdClose".equals(str2)) {
                                        broadcastItem.onAdClose();
                                    } else if ("onVideoComplete".equals(str2)) {
                                        broadcastItem.onVideoComplete();
                                    } else if ("onSkippedVideo".equals(str2)) {
                                        broadcastItem.onSkippedVideo();
                                    } else if ("onAdVideoBarClick".equals(str2)) {
                                        broadcastItem.onAdVideoBarClick();
                                    } else if ("recycleRes".equals(str2)) {
                                        broadcastItem.onDestroy();
                                    }
                                }
                            }
                            remoteCallbackList.finishBroadcast();
                            if ("recycleRes".equals(str2)) {
                                remoteCallbackList.kill();
                            }
                        }
                    }
                } catch (Throwable th) {
                    k.c("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th);
                }
            }
        }
    }
}
