package d.a.q0.a.v1.c.f;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.ipc.SwanProcessCallStub;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f51265h;

    /* renamed from: i  reason: collision with root package name */
    public static final long f51266i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<SwanAppProcessInfo, d.a.q0.a.v1.c.f.c> f51267a;

    /* renamed from: b  reason: collision with root package name */
    public final Deque<Long> f51268b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f51269c;

    /* renamed from: d  reason: collision with root package name */
    public final Messenger f51270d;

    /* renamed from: e  reason: collision with root package name */
    public final SwanProcessCallStub f51271e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d.a.q0.a.v1.c.f.a> f51272f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.q0.a.v1.c.f.a f51273g;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v1.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f51274a;

        /* renamed from: d.a.q0.a.v1.c.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1002a implements d.a.q0.a.v2.e1.b<d.a.q0.a.v1.c.f.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f51275e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.v1.c.f.c f51276f;

            public C1002a(a aVar, String str, d.a.q0.a.v1.c.f.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f51275e = str;
                this.f51276f = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.q0.a.v1.c.f.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.a(this.f51275e, this.f51276f);
                }
            }
        }

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51274a = eVar;
        }

        @Override // d.a.q0.a.v1.c.f.a
        public void a(String str, d.a.q0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
                if (e.f51265h) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + this.f51274a.f51272f.size() + " event=" + str + " client=" + cVar.f51259f);
                }
                synchronized (this.f51274a.f51272f) {
                    d.a.q0.a.v2.e1.a.a(d.a.q0.a.a2.d.i(), new C1002a(this, str, cVar), this.f51274a.f51272f);
                }
            }
        }

        @Override // d.a.q0.a.v1.c.f.a
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v1.c.f.a f51277e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f51278f;

        public b(e eVar, d.a.q0.a.v1.c.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51278f = eVar;
            this.f51277e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f51278f.f51272f) {
                    if (this.f51278f.f51272f.contains(this.f51277e)) {
                        if (e.f51265h) {
                            Log.i("SwanPuppetManager", "timeout: callback = " + this.f51277e);
                        }
                        this.f51278f.h(this.f51277e);
                        this.f51277e.timeout();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c<FILTER> {
        boolean a(FILTER filter, d.a.q0.a.v1.c.f.c cVar);
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static e f51279a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(538343974, "Ld/a/q0/a/v1/c/f/e$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(538343974, "Ld/a/q0/a/v1/c/f/e$d;");
                    return;
                }
            }
            f51279a = new e(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1394972070, "Ld/a/q0/a/v1/c/f/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1394972070, "Ld/a/q0/a/v1/c/f/e;");
                return;
            }
        }
        f51265h = k.f49133a;
        f51266i = TimeUnit.MINUTES.toMillis(5L);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (!f51265h || ProcessUtils.isMainProcess()) {
                return d.f51279a;
            }
            throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
        }
        return (e) invokeV.objValue;
    }

    public void b(d.a.q0.a.v1.c.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            c(aVar, -1L);
        }
    }

    public void c(d.a.q0.a.v1.c.f.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, j) == null) {
            synchronized (this.f51272f) {
                this.f51272f.add(aVar);
                if (f51265h) {
                    Log.i("SwanPuppetManager", "addCallback: after = " + this.f51272f.size());
                }
            }
            if (j > 0) {
                d.a.q0.a.a2.d.i().postDelayed(new b(this, aVar), j);
            }
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.f51268b) {
                t("checkRescuable ===>");
                if (this.f51268b.size() < 3) {
                    t(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.f51268b.size()), 3));
                    return true;
                }
                int size = this.f51268b.size() - 3;
                t("after offer purgeCount=" + size);
                if (size > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        t("purge: " + this.f51268b.poll());
                    }
                }
                t("after purge");
                Long peek = this.f51268b.peek();
                if (peek == null) {
                    t("allowRescue by null oldestRecord is should not happen");
                    return true;
                }
                long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
                boolean z = currentTimeMillis > f51266i;
                t("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
                return z;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized d.a.q0.a.v1.c.f.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                u("b4 computNextAvailableProcess");
                d.a.q0.a.v1.c.f.c cVar = null;
                d.a.q0.a.v1.c.f.c cVar2 = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    d.a.q0.a.v1.c.f.c cVar3 = this.f51267a.get(SwanAppProcessInfo.indexOf(i2));
                    if (cVar3 != null && cVar3.f51259f.isSwanAppProcess() && !cVar3.C()) {
                        if (cVar3.G()) {
                            if (f51265h) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + cVar3);
                            }
                            return cVar3;
                        }
                        if (cVar == null && cVar3.H()) {
                            cVar = cVar3;
                        }
                        if (cVar2 == null) {
                            cVar2 = cVar3;
                        }
                    }
                }
                if (cVar != null) {
                    if (f51265h) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + cVar);
                    }
                    return cVar;
                } else if (cVar2 != null) {
                    if (f51265h) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstEmptyClient=" + cVar2);
                    }
                    return cVar2;
                } else {
                    for (d.a.q0.a.v1.c.f.c cVar4 : this.f51267a.values()) {
                        if (cVar4 != null) {
                            if (f51265h) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: lruClient=" + cVar4);
                            }
                            return cVar4;
                        }
                    }
                    if (f51265h) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: P0");
                    }
                    return o(SwanAppProcessInfo.P0);
                }
            }
        }
        return (d.a.q0.a.v1.c.f.c) invokeV.objValue;
    }

    @Nullable
    public synchronized d.a.q0.a.v1.c.f.c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                u("b4 computNextPreloadProcess");
                d.a.q0.a.v1.c.f.c cVar = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    d.a.q0.a.v1.c.f.c cVar2 = this.f51267a.get(SwanAppProcessInfo.indexOf(i2));
                    if (cVar2 != null && cVar2.f51259f.isSwanAppProcess() && !cVar2.C()) {
                        if (cVar2.G()) {
                            if (f51265h) {
                                Log.i("SwanPuppetManager", "computNextPreloadProcess: return null by found empty process=" + cVar2);
                            }
                            return null;
                        } else if (cVar == null) {
                            cVar = cVar2;
                        }
                    }
                }
                if (f51265h) {
                    Log.i("SwanPuppetManager", "computNextPreloadProcess: firstPreloadableClient=" + cVar);
                }
                return cVar;
            }
        }
        return (d.a.q0.a.v1.c.f.c) invokeV.objValue;
    }

    public synchronized void g(String str, d.a.q0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, cVar) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                List<d.a.q0.a.v1.c.f.c> j = k().j(str);
                if (j.isEmpty()) {
                    return;
                }
                for (d.a.q0.a.v1.c.f.c cVar2 : j) {
                    if (cVar2 != cVar && cVar2 != null && cVar2.C()) {
                        if (f51265h) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                        }
                        cVar2.S();
                        cVar2.R();
                        if (cVar2.H()) {
                            d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
                            d.a.q0.a.v1.c.c cVar3 = new d.a.q0.a.v1.c.c(110, new Bundle());
                            cVar3.b(cVar2.f51259f);
                            e2.h(cVar3);
                        }
                    }
                }
            }
        }
    }

    public void h(d.a.q0.a.v1.c.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            synchronized (this.f51272f) {
                this.f51272f.remove(aVar);
                if (f51265h) {
                    Log.i("SwanPuppetManager", "delCallback: after = " + this.f51272f.size());
                }
            }
        }
    }

    @Nullable
    public synchronized d.a.q0.a.v1.c.f.c i(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                List<d.a.q0.a.v1.c.f.c> j = j(str);
                if (j.isEmpty()) {
                    return null;
                }
                return j.get(j.size() - 1);
            }
        }
        return (d.a.q0.a.v1.c.f.c) invokeL.objValue;
    }

    @NonNull
    public synchronized List<d.a.q0.a.v1.c.f.c> j(@Nullable String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    for (d.a.q0.a.v1.c.f.c cVar : this.f51267a.values()) {
                        if (TextUtils.equals(cVar.getAppId(), str)) {
                            arrayList.add(cVar);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public synchronized d.a.q0.a.v1.c.f.c l(@Nullable String str) {
        InterceptResult invokeL;
        d.a.q0.a.v1.c.f.c i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            synchronized (this) {
                i2 = i(str);
                if (i2 == null) {
                    i2 = e();
                }
            }
            return i2;
        }
        return (d.a.q0.a.v1.c.f.c) invokeL.objValue;
    }

    public d.a.q0.a.v1.c.f.a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f51273g : (d.a.q0.a.v1.c.f.a) invokeV.objValue;
    }

    public synchronized d.a.q0.a.v1.c.f.c n(int i2) {
        InterceptResult invokeI;
        d.a.q0.a.v1.c.f.c o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            synchronized (this) {
                o = o(SwanAppProcessInfo.indexOf(i2));
            }
            return o;
        }
        return (d.a.q0.a.v1.c.f.c) invokeI.objValue;
    }

    public synchronized d.a.q0.a.v1.c.f.c o(SwanAppProcessInfo swanAppProcessInfo) {
        InterceptResult invokeL;
        d.a.q0.a.v1.c.f.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, swanAppProcessInfo)) == null) {
            synchronized (this) {
                cVar = this.f51267a.get(swanAppProcessInfo);
            }
            return cVar;
        }
        return (d.a.q0.a.v1.c.f.c) invokeL.objValue;
    }

    public synchronized <FILTER> d.a.q0.a.v1.c.f.c p(FILTER filter, c<FILTER> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, filter, cVar)) == null) {
            synchronized (this) {
                for (d.a.q0.a.v1.c.f.c cVar2 : this.f51267a.values()) {
                    if (cVar.a(filter, cVar2)) {
                        return cVar2;
                    }
                }
                return null;
            }
        }
        return (d.a.q0.a.v1.c.f.c) invokeLL.objValue;
    }

    public synchronized LinkedHashSet<d.a.q0.a.v1.c.f.c> q() {
        InterceptResult invokeV;
        LinkedHashSet<d.a.q0.a.v1.c.f.c> linkedHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                linkedHashSet = new LinkedHashSet<>(this.f51267a.values());
            }
            return linkedHashSet;
        }
        return (LinkedHashSet) invokeV.objValue;
    }

    @NonNull
    public synchronized d.a.q0.a.v1.c.f.c r(@Nullable String str) {
        InterceptResult invokeL;
        d.a.q0.a.v1.c.f.c l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
                l = l(str);
                v(l.f51259f);
            }
            return l;
        }
        return (d.a.q0.a.v1.c.f.c) invokeL.objValue;
    }

    public void s(Message message) {
        d.a.q0.a.v1.c.f.c o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, message) == null) || message == null) {
            return;
        }
        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
        if (indexOf.isSwanAppProcess() && (o = o(indexOf)) != null) {
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(e.class.getClassLoader());
                o.d0(bundle.getLong("property_launch_cost", -1L));
            }
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && f51265h) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.f51268b.iterator();
            while (it.hasNext()) {
                Log.i("SwanPuppetManager", "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            LinkedHashSet<d.a.q0.a.v1.c.f.c> q = q();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(":");
            sb.append("\n-> clients: ");
            for (d.a.q0.a.v1.c.f.c cVar : q) {
                sb.append("\n--> ");
                sb.append(cVar.toString());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && f51265h) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public synchronized void v(SwanAppProcessInfo swanAppProcessInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, swanAppProcessInfo) == null) {
            synchronized (this) {
                d.a.q0.a.v1.c.f.c remove = this.f51267a.remove(swanAppProcessInfo);
                if (remove != null) {
                    this.f51267a.put(swanAppProcessInfo, remove);
                }
                if (f51265h) {
                    u("lru -> " + swanAppProcessInfo);
                }
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this.f51268b) {
                if (d()) {
                    this.f51268b.offer(Long.valueOf(System.currentTimeMillis()));
                    Bundle bundle = new Bundle();
                    bundle.putString("bundle_key_preload_preload_scene", "1");
                    d.a.q0.a.v1.c.f.b.n(d.a.q0.a.c1.a.b(), bundle);
                }
            }
        }
    }

    public e() {
        SwanAppProcessInfo[] indices;
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
        this.f51267a = new LinkedHashMap<>();
        this.f51268b = new ArrayDeque();
        this.f51269c = new SwanAppMessengerService.a();
        this.f51270d = new Messenger(this.f51269c);
        this.f51271e = new SwanProcessCallStub(this.f51269c);
        this.f51272f = new HashSet();
        this.f51273g = new a(this);
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.f51267a.put(swanAppProcessInfo, new d.a.q0.a.v1.c.f.c(swanAppProcessInfo));
            }
        }
    }
}
