package com.huawei.hms.ads.identifier;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@Keep
/* loaded from: classes8.dex */
public final class a implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    @Keep
    public static final ThreadPoolExecutor a;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public boolean b;
    @Keep
    public final LinkedBlockingQueue<IBinder> c;

    @Keep
    /* renamed from: com.huawei.hms.ads.identifier.a$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Keep
        public final /* synthetic */ IBinder a;
        @Keep
        public final /* synthetic */ a b;

        public AnonymousClass1(a aVar, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, iBinder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aVar;
            this.a = iBinder;
        }

        @Override // java.lang.Runnable
        @Keep
        public native void run();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1911674830, "Lcom/huawei/hms/ads/identifier/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1911674830, "Lcom/huawei/hms/ads/identifier/a;");
                return;
            }
        }
        a = new ThreadPoolExecutor(0, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = new LinkedBlockingQueue<>(1);
    }

    @Keep
    public native IBinder a();

    @Override // android.content.ServiceConnection
    @Keep
    public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

    @Override // android.content.ServiceConnection
    @Keep
    public native void onServiceDisconnected(ComponentName componentName);
}
