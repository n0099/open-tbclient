package com.vivo.push.d.d;

import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
/* loaded from: classes10.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, b> a;
    public Integer b;
    public HandlerThread c;
    public Handler d;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static d a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(725510364, "Lcom/vivo/push/d/d/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(725510364, "Lcom/vivo/push/d/d/d$a;");
                    return;
                }
            }
            a = new d((byte) 0);
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
        this.b = null;
        HandlerThread handlerThread = new HandlerThread("request_timer_task——thread");
        this.c = handlerThread;
        handlerThread.start();
        this.d = new e(this, this.c.getLooper());
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a.a;
        }
        return (d) invokeV.objValue;
    }

    public final void a(com.vivo.push.d.a.a aVar) {
        com.vivo.push.d.d.a.a h;
        int b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && aVar != null && aVar.g() && (b = (h = aVar.h()).b()) > 0) {
            this.d.removeMessages(b);
            b remove = this.a.remove(Integer.valueOf(b));
            if (remove != null && remove.b() != null && remove.a() != null && h.c() == 0) {
                try {
                    new com.vivo.push.d.d.a.a.a(aVar.i());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
