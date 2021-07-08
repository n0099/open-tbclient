package d.a.n0.a.h0.m;

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
    public static final boolean f44950b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<d.a.n0.n.h.e, Set<InterfaceC0744c>> f44951a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static c f44952a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(989587789, "Ld/a/n0/a/h0/m/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(989587789, "Ld/a/n0/a/h0/m/c$b;");
                    return;
                }
            }
            f44952a = new c(null);
        }
    }

    /* renamed from: d.a.n0.a.h0.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0744c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, d.a.n0.a.q2.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318347851, "Ld/a/n0/a/h0/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318347851, "Ld/a/n0/a/h0/m/c;");
                return;
            }
        }
        f44950b = d.a.n0.a.k.f45831a;
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f44952a : (c) invokeV.objValue;
    }

    public synchronized void a(d.a.n0.n.h.e eVar, PMSDownloadType pMSDownloadType, d.a.n0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, pMSDownloadType, aVar) == null) {
            synchronized (this) {
                if (f44950b) {
                    Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<InterfaceC0744c> set = this.f44951a.get(eVar);
                if (set != null) {
                    for (InterfaceC0744c interfaceC0744c : set) {
                        if (interfaceC0744c != null) {
                            interfaceC0744c.b(pMSDownloadType, aVar);
                        }
                    }
                    this.f44951a.remove(eVar);
                }
            }
        }
    }

    public synchronized void b(d.a.n0.n.h.e eVar, PMSDownloadType pMSDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, pMSDownloadType) == null) {
            synchronized (this) {
                if (f44950b) {
                    Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
                }
                Set<InterfaceC0744c> set = this.f44951a.get(eVar);
                if (set != null) {
                    for (InterfaceC0744c interfaceC0744c : set) {
                        if (interfaceC0744c != null) {
                            interfaceC0744c.a(pMSDownloadType);
                        }
                    }
                    this.f44951a.remove(eVar);
                }
            }
        }
    }

    public synchronized void d(d.a.n0.n.h.e eVar, InterfaceC0744c interfaceC0744c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, interfaceC0744c) == null) {
            synchronized (this) {
                if (f44950b) {
                    Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
                }
                if (eVar != null && interfaceC0744c != null) {
                    Set<InterfaceC0744c> set = this.f44951a.get(eVar);
                    if (set != null) {
                        set.add(interfaceC0744c);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(interfaceC0744c);
                        this.f44951a.put(eVar, hashSet);
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
        this.f44951a = new HashMap<>();
    }
}
