package d.a.o0.a.h0.m;

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
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45454b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<d.a.o0.n.h.e, Set<InterfaceC0753c>> f45455a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static c f45456a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(484029164, "Ld/a/o0/a/h0/m/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(484029164, "Ld/a/o0/a/h0/m/c$b;");
                    return;
                }
            }
            f45456a = new c(null);
        }
    }

    /* renamed from: d.a.o0.a.h0.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0753c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, d.a.o0.a.q2.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447430570, "Ld/a/o0/a/h0/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447430570, "Ld/a/o0/a/h0/m/c;");
                return;
            }
        }
        f45454b = d.a.o0.a.k.f46335a;
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f45456a : (c) invokeV.objValue;
    }

    public synchronized void a(d.a.o0.n.h.e eVar, PMSDownloadType pMSDownloadType, d.a.o0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, pMSDownloadType, aVar) == null) {
            synchronized (this) {
                if (f45454b) {
                    Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<InterfaceC0753c> set = this.f45455a.get(eVar);
                if (set != null) {
                    for (InterfaceC0753c interfaceC0753c : set) {
                        if (interfaceC0753c != null) {
                            interfaceC0753c.b(pMSDownloadType, aVar);
                        }
                    }
                    this.f45455a.remove(eVar);
                }
            }
        }
    }

    public synchronized void b(d.a.o0.n.h.e eVar, PMSDownloadType pMSDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, pMSDownloadType) == null) {
            synchronized (this) {
                if (f45454b) {
                    Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<InterfaceC0753c> set = this.f45455a.get(eVar);
                if (set != null) {
                    for (InterfaceC0753c interfaceC0753c : set) {
                        if (interfaceC0753c != null) {
                            interfaceC0753c.a(pMSDownloadType);
                        }
                    }
                    this.f45455a.remove(eVar);
                }
            }
        }
    }

    public synchronized void d(d.a.o0.n.h.e eVar, InterfaceC0753c interfaceC0753c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, interfaceC0753c) == null) {
            synchronized (this) {
                if (f45454b) {
                    Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
                }
                if (eVar != null && interfaceC0753c != null) {
                    Set<InterfaceC0753c> set = this.f45455a.get(eVar);
                    if (set != null) {
                        set.add(interfaceC0753c);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(interfaceC0753c);
                        this.f45455a.put(eVar, hashSet);
                    }
                }
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45455a = new HashMap<>();
    }
}
