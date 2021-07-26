package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, RemoteCallbackList<ITTAppDownloadListener>> f31720a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f31721b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1225390944, "Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1225390944, "Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/b;");
                return;
            }
        }
        f31720a = Collections.synchronizedMap(new HashMap());
    }

    public b() {
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

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f31721b == null) {
                synchronized (b.class) {
                    if (f31721b == null) {
                        f31721b = new b();
                    }
                }
            }
            return f31721b;
        }
        return (b) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeAppDownloadCallback(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), str3, str4}) == null) {
            a(str, str2, j, j2, str3, str4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void registerTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, iTTAppDownloadListener) == null) {
            RemoteCallbackList<ITTAppDownloadListener> remoteCallbackList = f31720a.get(str);
            if (remoteCallbackList == null) {
                remoteCallbackList = new RemoteCallbackList<>();
            }
            remoteCallbackList.register(iTTAppDownloadListener);
            f31720a.put(str, remoteCallbackList);
            k.f("DMLibManager", "aidl registerTTAppDownloadListener, materialMd5:" + str);
            k.f("DMLibManager", "aidl registerTTAppDownloadListener, mListenerMap size:" + f31720a.size());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void unregisterTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, iTTAppDownloadListener) == null) {
            Map<String, RemoteCallbackList<ITTAppDownloadListener>> map = f31720a;
            if (map == null) {
                k.f("DMLibManager", "aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:" + str);
                return;
            }
            RemoteCallbackList<ITTAppDownloadListener> remove = map.remove(str);
            if (remove == null) {
                k.f("DMLibManager", "aidl unregisterTTAppDownloadListener cbs = null, materialMd5:" + str);
                return;
            }
            a(remove);
            k.f("DMLibManager", "aidl unregisterTTAppDownloadListener, materialMd5:" + str);
            k.f("DMLibManager", "aidl unregisterTTAppDownloadListener, mListenerMap size:" + f31720a.size());
        }
    }

    private synchronized void a(String str, String str2, long j, long j2, String str3, String str4) {
        ITTAppDownloadListener broadcastItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), str3, str4}) == null) {
            synchronized (this) {
                try {
                } catch (Throwable th) {
                    k.c("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess2: " + str2 + " throws Exception :", th);
                }
                if (f31720a == null) {
                    return;
                }
                if ("recycleRes".equals(str2)) {
                    a(f31720a.remove(str));
                    k.f("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:" + str);
                    k.f("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:" + f31720a.size());
                    return;
                }
                RemoteCallbackList<ITTAppDownloadListener> remoteCallbackList = f31720a.get(str);
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i2 = 0; i2 < beginBroadcast; i2++) {
                        try {
                            broadcastItem = remoteCallbackList.getBroadcastItem(i2);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (broadcastItem != null) {
                            if ("onIdle".equals(str2)) {
                                broadcastItem.onIdle();
                            } else if ("onDownloadActive".equals(str2)) {
                                broadcastItem.onDownloadActive(j, j2, str3, str4);
                            } else if ("onDownloadPaused".equals(str2)) {
                                broadcastItem.onDownloadPaused(j, j2, str3, str4);
                            } else if ("onDownloadFailed".equals(str2)) {
                                broadcastItem.onDownloadFailed(j, j2, str3, str4);
                            } else {
                                if ("onDownloadFinished".equals(str2)) {
                                    try {
                                        broadcastItem.onDownloadFinished(j, str3, str4);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        k.c("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess1: " + str2 + " throws Exception :", th);
                                    }
                                } else if ("onInstalled".equals(str2)) {
                                    broadcastItem.onInstalled(str3, str4);
                                }
                            }
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                }
            }
        }
    }

    private void a(RemoteCallbackList<ITTAppDownloadListener> remoteCallbackList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, remoteCallbackList) == null) || remoteCallbackList == null) {
            return;
        }
        try {
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                ITTAppDownloadListener broadcastItem = remoteCallbackList.getBroadcastItem(i2);
                if (broadcastItem != null) {
                    ((com.bytedance.sdk.openadsdk.multipro.aidl.b.e) broadcastItem).a();
                }
            }
            remoteCallbackList.finishBroadcast();
            remoteCallbackList.kill();
        } catch (Throwable th) {
            k.c("MultiProcess", "recycleRes2 throw Exception : ", th);
        }
    }
}
