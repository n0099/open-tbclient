package d.a.o0.a.v1.c.f;

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
import d.a.o0.a.k;
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
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f48467h;

    /* renamed from: i  reason: collision with root package name */
    public static final long f48468i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<SwanAppProcessInfo, d.a.o0.a.v1.c.f.c> f48469a;

    /* renamed from: b  reason: collision with root package name */
    public final Deque<Long> f48470b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f48471c;

    /* renamed from: d  reason: collision with root package name */
    public final Messenger f48472d;

    /* renamed from: e  reason: collision with root package name */
    public final SwanProcessCallStub f48473e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d.a.o0.a.v1.c.f.a> f48474f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.o0.a.v1.c.f.a f48475g;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v1.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f48476a;

        /* renamed from: d.a.o0.a.v1.c.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0960a implements d.a.o0.a.v2.e1.b<d.a.o0.a.v1.c.f.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f48477e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.v1.c.f.c f48478f;

            public C0960a(a aVar, String str, d.a.o0.a.v1.c.f.c cVar) {
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
                this.f48477e = str;
                this.f48478f = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.o0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.o0.a.v1.c.f.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.a(this.f48477e, this.f48478f);
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
            this.f48476a = eVar;
        }

        @Override // d.a.o0.a.v1.c.f.a
        public void a(String str, d.a.o0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
                if (e.f48467h) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + this.f48476a.f48474f.size() + " event=" + str + " client=" + cVar.f48461f);
                }
                synchronized (this.f48476a.f48474f) {
                    d.a.o0.a.v2.e1.a.a(d.a.o0.a.a2.d.i(), new C0960a(this, str, cVar), this.f48476a.f48474f);
                }
            }
        }

        @Override // d.a.o0.a.v1.c.f.a
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v1.c.f.a f48479e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f48480f;

        public b(e eVar, d.a.o0.a.v1.c.f.a aVar) {
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
            this.f48480f = eVar;
            this.f48479e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f48480f.f48474f) {
                    if (this.f48480f.f48474f.contains(this.f48479e)) {
                        if (e.f48467h) {
                            Log.i("SwanPuppetManager", "timeout: callback = " + this.f48479e);
                        }
                        this.f48480f.h(this.f48479e);
                        this.f48479e.timeout();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c<FILTER> {
        boolean a(FILTER filter, d.a.o0.a.v1.c.f.c cVar);
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static e f48481a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1559412328, "Ld/a/o0/a/v1/c/f/e$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1559412328, "Ld/a/o0/a/v1/c/f/e$d;");
                    return;
                }
            }
            f48481a = new e(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1888877976, "Ld/a/o0/a/v1/c/f/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1888877976, "Ld/a/o0/a/v1/c/f/e;");
                return;
            }
        }
        f48467h = k.f46335a;
        f48468i = TimeUnit.MINUTES.toMillis(5L);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!f48467h || ProcessUtils.isMainProcess()) {
                return d.f48481a;
            }
            throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
        }
        return (e) invokeV.objValue;
    }

    public void b(d.a.o0.a.v1.c.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            c(aVar, -1L);
        }
    }

    public void c(d.a.o0.a.v1.c.f.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, j) == null) {
            synchronized (this.f48474f) {
                this.f48474f.add(aVar);
                if (f48467h) {
                    Log.i("SwanPuppetManager", "addCallback: after = " + this.f48474f.size());
                }
            }
            if (j > 0) {
                d.a.o0.a.a2.d.i().postDelayed(new b(this, aVar), j);
            }
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.f48470b) {
                t("checkRescuable ===>");
                if (this.f48470b.size() < 3) {
                    t(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.f48470b.size()), 3));
                    return true;
                }
                int size = this.f48470b.size() - 3;
                t("after offer purgeCount=" + size);
                if (size > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        t("purge: " + this.f48470b.poll());
                    }
                }
                t("after purge");
                Long peek = this.f48470b.peek();
                if (peek == null) {
                    t("allowRescue by null oldestRecord is should not happen");
                    return true;
                }
                long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
                boolean z = currentTimeMillis > f48468i;
                t("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
                return z;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized d.a.o0.a.v1.c.f.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                u("b4 computNextAvailableProcess");
                d.a.o0.a.v1.c.f.c cVar = null;
                d.a.o0.a.v1.c.f.c cVar2 = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    d.a.o0.a.v1.c.f.c cVar3 = this.f48469a.get(SwanAppProcessInfo.indexOf(i2));
                    if (cVar3 != null && cVar3.f48461f.isSwanAppProcess() && !cVar3.C()) {
                        if (cVar3.G()) {
                            if (f48467h) {
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
                    if (f48467h) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + cVar);
                    }
                    return cVar;
                } else if (cVar2 != null) {
                    if (f48467h) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstEmptyClient=" + cVar2);
                    }
                    return cVar2;
                } else {
                    for (d.a.o0.a.v1.c.f.c cVar4 : this.f48469a.values()) {
                        if (cVar4 != null) {
                            if (f48467h) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: lruClient=" + cVar4);
                            }
                            return cVar4;
                        }
                    }
                    if (f48467h) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: P0");
                    }
                    return o(SwanAppProcessInfo.P0);
                }
            }
        }
        return (d.a.o0.a.v1.c.f.c) invokeV.objValue;
    }

    @Nullable
    public synchronized d.a.o0.a.v1.c.f.c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                u("b4 computNextPreloadProcess");
                d.a.o0.a.v1.c.f.c cVar = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    d.a.o0.a.v1.c.f.c cVar2 = this.f48469a.get(SwanAppProcessInfo.indexOf(i2));
                    if (cVar2 != null && cVar2.f48461f.isSwanAppProcess() && !cVar2.C()) {
                        if (cVar2.G()) {
                            if (f48467h) {
                                Log.i("SwanPuppetManager", "computNextPreloadProcess: return null by found empty process=" + cVar2);
                            }
                            return null;
                        } else if (cVar == null) {
                            cVar = cVar2;
                        }
                    }
                }
                if (f48467h) {
                    Log.i("SwanPuppetManager", "computNextPreloadProcess: firstPreloadableClient=" + cVar);
                }
                return cVar;
            }
        }
        return (d.a.o0.a.v1.c.f.c) invokeV.objValue;
    }

    public synchronized void g(String str, d.a.o0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, cVar) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                List<d.a.o0.a.v1.c.f.c> j = k().j(str);
                if (j.isEmpty()) {
                    return;
                }
                for (d.a.o0.a.v1.c.f.c cVar2 : j) {
                    if (cVar2 != cVar && cVar2 != null && cVar2.C()) {
                        if (f48467h) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                        }
                        cVar2.S();
                        cVar2.R();
                        if (cVar2.H()) {
                            d.a.o0.a.v1.c.a e2 = d.a.o0.a.v1.c.a.e();
                            d.a.o0.a.v1.c.c cVar3 = new d.a.o0.a.v1.c.c(110, new Bundle());
                            cVar3.b(cVar2.f48461f);
                            e2.h(cVar3);
                        }
                    }
                }
            }
        }
    }

    public void h(d.a.o0.a.v1.c.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            synchronized (this.f48474f) {
                this.f48474f.remove(aVar);
                if (f48467h) {
                    Log.i("SwanPuppetManager", "delCallback: after = " + this.f48474f.size());
                }
            }
        }
    }

    @Nullable
    public synchronized d.a.o0.a.v1.c.f.c i(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                List<d.a.o0.a.v1.c.f.c> j = j(str);
                if (j.isEmpty()) {
                    return null;
                }
                return j.get(j.size() - 1);
            }
        }
        return (d.a.o0.a.v1.c.f.c) invokeL.objValue;
    }

    @NonNull
    public synchronized List<d.a.o0.a.v1.c.f.c> j(@Nullable String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    for (d.a.o0.a.v1.c.f.c cVar : this.f48469a.values()) {
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

    public synchronized d.a.o0.a.v1.c.f.c l(@Nullable String str) {
        InterceptResult invokeL;
        d.a.o0.a.v1.c.f.c i2;
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
        return (d.a.o0.a.v1.c.f.c) invokeL.objValue;
    }

    public d.a.o0.a.v1.c.f.a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f48475g : (d.a.o0.a.v1.c.f.a) invokeV.objValue;
    }

    public synchronized d.a.o0.a.v1.c.f.c n(int i2) {
        InterceptResult invokeI;
        d.a.o0.a.v1.c.f.c o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            synchronized (this) {
                o = o(SwanAppProcessInfo.indexOf(i2));
            }
            return o;
        }
        return (d.a.o0.a.v1.c.f.c) invokeI.objValue;
    }

    public synchronized d.a.o0.a.v1.c.f.c o(SwanAppProcessInfo swanAppProcessInfo) {
        InterceptResult invokeL;
        d.a.o0.a.v1.c.f.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, swanAppProcessInfo)) == null) {
            synchronized (this) {
                cVar = this.f48469a.get(swanAppProcessInfo);
            }
            return cVar;
        }
        return (d.a.o0.a.v1.c.f.c) invokeL.objValue;
    }

    public synchronized <FILTER> d.a.o0.a.v1.c.f.c p(FILTER filter, c<FILTER> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, filter, cVar)) == null) {
            synchronized (this) {
                for (d.a.o0.a.v1.c.f.c cVar2 : this.f48469a.values()) {
                    if (cVar.a(filter, cVar2)) {
                        return cVar2;
                    }
                }
                return null;
            }
        }
        return (d.a.o0.a.v1.c.f.c) invokeLL.objValue;
    }

    public synchronized LinkedHashSet<d.a.o0.a.v1.c.f.c> q() {
        InterceptResult invokeV;
        LinkedHashSet<d.a.o0.a.v1.c.f.c> linkedHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                linkedHashSet = new LinkedHashSet<>(this.f48469a.values());
            }
            return linkedHashSet;
        }
        return (LinkedHashSet) invokeV.objValue;
    }

    @NonNull
    public synchronized d.a.o0.a.v1.c.f.c r(@Nullable String str) {
        InterceptResult invokeL;
        d.a.o0.a.v1.c.f.c l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
                l = l(str);
                v(l.f48461f);
            }
            return l;
        }
        return (d.a.o0.a.v1.c.f.c) invokeL.objValue;
    }

    public void s(Message message) {
        d.a.o0.a.v1.c.f.c o;
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
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && f48467h) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.f48470b.iterator();
            while (it.hasNext()) {
                Log.i("SwanPuppetManager", "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            LinkedHashSet<d.a.o0.a.v1.c.f.c> q = q();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(":");
            sb.append("\n-> clients: ");
            for (d.a.o0.a.v1.c.f.c cVar : q) {
                sb.append("\n--> ");
                sb.append(cVar.toString());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && f48467h) {
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
                d.a.o0.a.v1.c.f.c remove = this.f48469a.remove(swanAppProcessInfo);
                if (remove != null) {
                    this.f48469a.put(swanAppProcessInfo, remove);
                }
                if (f48467h) {
                    u("lru -> " + swanAppProcessInfo);
                }
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this.f48470b) {
                if (d()) {
                    this.f48470b.offer(Long.valueOf(System.currentTimeMillis()));
                    Bundle bundle = new Bundle();
                    bundle.putString("bundle_key_preload_preload_scene", "1");
                    d.a.o0.a.v1.c.f.b.n(d.a.o0.a.c1.a.b(), bundle);
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
        this.f48469a = new LinkedHashMap<>();
        this.f48470b = new ArrayDeque();
        this.f48471c = new SwanAppMessengerService.a();
        this.f48472d = new Messenger(this.f48471c);
        this.f48473e = new SwanProcessCallStub(this.f48471c);
        this.f48474f = new HashSet();
        this.f48475g = new a(this);
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.f48469a.put(swanAppProcessInfo, new d.a.o0.a.v1.c.f.c(swanAppProcessInfo));
            }
        }
    }
}
