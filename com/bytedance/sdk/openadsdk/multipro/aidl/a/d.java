package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, RemoteCallbackList<ICommonPermissionListener>> f31537a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f31538b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1225391006, "Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1225391006, "Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/d;");
                return;
            }
        }
        f31537a = new HashMap<>();
    }

    public d() {
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

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f31538b == null) {
                synchronized (d.class) {
                    if (f31538b == null) {
                        f31538b = new d();
                    }
                }
            }
            return f31538b;
        }
        return (d) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void broadcastPermissionListener(String str, String str2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            j.b("MultiProcess", "00000 CommonPermissionListenerManagerImpl broadcastDialogListener: 00000" + String.valueOf(str) + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            RemoteCallbackList<ICommonPermissionListener> remove = f31537a.remove(str);
            if (remove == null) {
                return;
            }
            int beginBroadcast = remove.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                ICommonPermissionListener broadcastItem = remove.getBroadcastItem(i2);
                if (broadcastItem != null) {
                    j.b("MultiProcess", "CommonPermissionListenerManagerImpl broadcastDialogListener: " + String.valueOf(str) + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
                    if (str2 == null) {
                        broadcastItem.onGranted();
                    } else {
                        broadcastItem.onDenied(str2);
                    }
                }
            }
            remove.finishBroadcast();
            remove.kill();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, iCommonPermissionListener) == null) || iCommonPermissionListener == null) {
            return;
        }
        j.b("MultiProcess", "CommonPermissionListenerManagerImpl registerPermissionListener");
        RemoteCallbackList<ICommonPermissionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iCommonPermissionListener);
        f31537a.put(str, remoteCallbackList);
    }
}
