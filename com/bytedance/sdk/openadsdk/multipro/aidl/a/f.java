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
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class f extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, RemoteCallbackList<IRewardAdInteractionListener>> f31728a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f31729b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1225391068, "Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1225391068, "Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/f;");
                return;
            }
        }
        f31728a = Collections.synchronizedMap(new HashMap());
    }

    public f() {
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

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f31729b == null) {
                synchronized (f.class) {
                    if (f31729b == null) {
                        f31729b = new f();
                    }
                }
            }
            return f31729b;
        }
        return (f) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeRewardVideoCallback(String str, String str2, boolean z, int i2, String str3, int i3, String str4) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), str3, Integer.valueOf(i3), str4}) == null) {
            a(str, str2, z, i2, str3, i3, str4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, iRewardAdInteractionListener) == null) {
            synchronized (this) {
                RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
                remoteCallbackList.register(iRewardAdInteractionListener);
                f31728a.put(str, remoteCallbackList);
            }
        }
    }

    private synchronized void a(String str, String str2, boolean z, int i2, String str3, int i3, String str4) {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), str3, Integer.valueOf(i3), str4}) == null) {
            synchronized (this) {
                try {
                    if (f31728a != null) {
                        if ("recycleRes".equals(str2)) {
                            remoteCallbackList = f31728a.remove(str);
                        } else {
                            remoteCallbackList = f31728a.get(str);
                        }
                        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList2 = remoteCallbackList;
                        if (remoteCallbackList2 != null) {
                            int beginBroadcast = remoteCallbackList2.beginBroadcast();
                            for (int i4 = 0; i4 < beginBroadcast; i4++) {
                                IRewardAdInteractionListener broadcastItem = remoteCallbackList2.getBroadcastItem(i4);
                                if (broadcastItem != null) {
                                    if ("onAdShow".equals(str2)) {
                                        broadcastItem.onAdShow();
                                    } else if ("onAdClose".equals(str2)) {
                                        broadcastItem.onAdClose();
                                    } else if ("onVideoComplete".equals(str2)) {
                                        broadcastItem.onVideoComplete();
                                    } else if ("onVideoError".equals(str2)) {
                                        broadcastItem.onVideoError();
                                    } else if ("onAdVideoBarClick".equals(str2)) {
                                        broadcastItem.onAdVideoBarClick();
                                    } else if ("onRewardVerify".equals(str2)) {
                                        broadcastItem.onRewardVerify(z, i2, str3, i3, str4);
                                    } else if ("onSkippedVideo".equals(str2)) {
                                        broadcastItem.onSkippedVideo();
                                    } else if ("recycleRes".equals(str2)) {
                                        broadcastItem.onDestroy();
                                    }
                                }
                            }
                            remoteCallbackList2.finishBroadcast();
                            if ("recycleRes".equals(str2)) {
                                remoteCallbackList2.kill();
                            }
                        }
                    }
                } catch (Throwable th) {
                    k.c("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th);
                }
            }
        }
    }
}
