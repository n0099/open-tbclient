package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.zui.deviceidservice.a;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f43754b = "OpenDeviceId library";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f43755c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.zui.deviceidservice.a f43756a;

    /* renamed from: d  reason: collision with root package name */
    public a f43757d;

    /* renamed from: com.zui.opendeviceidlibrary.b$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass1 implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f43758a;

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                synchronized (this) {
                    this.f43758a.f43756a = a.AbstractBinderC0576a.a(iBinder);
                    if (this.f43758a.f43757d != null) {
                        this.f43758a.f43757d.a(this.f43758a);
                    }
                    this.f43758a.a("Service onServiceConnected");
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.f43758a.f43756a = null;
                this.f43758a.a("Service onServiceDisconnected");
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface a {
        void a(b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1651678627, "Lcom/zui/opendeviceidlibrary/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1651678627, "Lcom/zui/opendeviceidlibrary/b;");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65540, this, str) == null) && f43755c) {
            Log.i(f43754b, str);
        }
    }
}
