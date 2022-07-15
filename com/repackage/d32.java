package com.repackage;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class d32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<d94, Set<c>> a;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static d32 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-492045680, "Lcom/repackage/d32$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-492045680, "Lcom/repackage/d32$b;");
                    return;
                }
            }
            a = new d32(null);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, ac3 ac3Var);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755818418, "Lcom/repackage/d32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755818418, "Lcom/repackage/d32;");
                return;
            }
        }
        b = rg1.a;
    }

    public /* synthetic */ d32(a aVar) {
        this();
    }

    public static d32 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (d32) invokeV.objValue;
    }

    public synchronized void a(d94 d94Var, PMSDownloadType pMSDownloadType, ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, d94Var, pMSDownloadType, ac3Var) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "downloadError:" + d94Var + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<c> set = this.a.get(d94Var);
                if (set != null) {
                    for (c cVar : set) {
                        if (cVar != null) {
                            cVar.b(pMSDownloadType, ac3Var);
                        }
                    }
                    this.a.remove(d94Var);
                }
            }
        }
    }

    public synchronized void b(d94 d94Var, PMSDownloadType pMSDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d94Var, pMSDownloadType) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + d94Var + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<c> set = this.a.get(d94Var);
                if (set != null) {
                    for (c cVar : set) {
                        if (cVar != null) {
                            cVar.a(pMSDownloadType);
                        }
                    }
                    this.a.remove(d94Var);
                }
            }
        }
    }

    public synchronized void d(d94 d94Var, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, d94Var, cVar) == null) {
            synchronized (this) {
                if (b) {
                    Log.i("PMSDownloadRepeatSync", "registerResultListener:" + d94Var);
                }
                if (d94Var != null && cVar != null) {
                    Set<c> set = this.a.get(d94Var);
                    if (set != null) {
                        set.add(cVar);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(cVar);
                        this.a.put(d94Var, hashSet);
                    }
                }
            }
        }
    }

    public d32() {
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
        this.a = new HashMap<>();
    }
}
