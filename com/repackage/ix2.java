package com.repackage;

import android.annotation.SuppressLint;
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
/* loaded from: classes6.dex */
public final class ix2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static final long j;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<SwanAppProcessInfo, gx2> a;
    public final Deque<Long> b;
    public final Handler c;
    public final Messenger d;
    public final SwanProcessCallStub e;
    public long f;
    public final Set<ex2> g;
    public final ex2 h;

    /* loaded from: classes6.dex */
    public class a implements ex2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix2 a;

        /* renamed from: com.repackage.ix2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0657a implements af3<ex2> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ gx2 b;

            public C0657a(a aVar, String str, gx2 gx2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, gx2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = gx2Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(ex2 ex2Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ex2Var) == null) {
                    ex2Var.a(this.a, this.b);
                }
            }
        }

        public a(ix2 ix2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix2Var;
        }

        @Override // com.repackage.ex2
        public void a(String str, gx2 gx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, gx2Var) == null) {
                if (ix2.i) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + this.a.g.size() + " event=" + str + " client=" + gx2Var.b);
                }
                synchronized (this.a.g) {
                    ze3.a(g03.M(), new C0657a(this, str, gx2Var), this.a.g);
                }
            }
        }

        @Override // com.repackage.ex2
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex2 a;
        public final /* synthetic */ ix2 b;

        public b(ix2 ix2Var, ex2 ex2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix2Var, ex2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ix2Var;
            this.a = ex2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b.g) {
                    if (this.b.g.contains(this.a)) {
                        if (ix2.i) {
                            Log.i("SwanPuppetManager", "timeout: callback = " + this.a);
                        }
                        this.b.h(this.a);
                        this.a.timeout();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c<FILTER> {
        boolean a(FILTER filter, gx2 gx2Var);
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static ix2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-285176914, "Lcom/repackage/ix2$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-285176914, "Lcom/repackage/ix2$d;");
                    return;
                }
            }
            a = new ix2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755603154, "Lcom/repackage/ix2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755603154, "Lcom/repackage/ix2;");
                return;
            }
        }
        i = rg1.a;
        j = TimeUnit.MINUTES.toMillis(5L);
    }

    public /* synthetic */ ix2(a aVar) {
        this();
    }

    @SuppressLint({"BDThrowableCheck"})
    public static ix2 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!i || ProcessUtils.isMainProcess()) {
                return d.a;
            }
            throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
        }
        return (ix2) invokeV.objValue;
    }

    public void b(ex2 ex2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ex2Var) == null) {
            c(ex2Var, -1L);
        }
    }

    public void c(ex2 ex2Var, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ex2Var, j2) == null) {
            synchronized (this.g) {
                this.g.add(ex2Var);
                if (i) {
                    Log.i("SwanPuppetManager", "addCallback: after = " + this.g.size());
                }
            }
            if (j2 > 0) {
                g03.M().postDelayed(new b(this, ex2Var), j2);
            }
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.b) {
                t("checkRescuable ===>");
                if (this.f > System.currentTimeMillis()) {
                    t(String.format(Locale.getDefault(), "disallowRescue by mRescueRefractoryUntil(%d)", Long.valueOf(this.f)));
                    return false;
                } else if (this.b.size() < 3) {
                    t(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.b.size()), 3));
                    return true;
                } else {
                    int size = this.b.size() - 3;
                    t("after offer purgeCount=" + size);
                    if (size > 0) {
                        for (int i2 = 0; i2 < size; i2++) {
                            t("purge: " + this.b.poll());
                        }
                    }
                    t("after purge");
                    Long peek = this.b.peek();
                    if (peek == null) {
                        t("allowRescue by null oldestRecord is should not happen");
                        return true;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
                    boolean z = currentTimeMillis > j;
                    t("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
                    return z;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized gx2 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                u("b4 computNextAvailableProcess");
                gx2 gx2Var = null;
                gx2 gx2Var2 = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    gx2 gx2Var3 = this.a.get(SwanAppProcessInfo.indexOf(i2));
                    if (gx2Var3 != null && gx2Var3.b.isSwanAppProcess() && !gx2Var3.E()) {
                        if (gx2Var3.S()) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + gx2Var3);
                            }
                            return gx2Var3;
                        }
                        if (gx2Var == null && gx2Var3.T()) {
                            gx2Var = gx2Var3;
                        }
                        if (gx2Var2 == null) {
                            gx2Var2 = gx2Var3;
                        }
                    }
                }
                if (gx2Var != null) {
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + gx2Var);
                    }
                    return gx2Var;
                } else if (gx2Var2 != null) {
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstEmptyClient=" + gx2Var2);
                    }
                    return gx2Var2;
                } else {
                    for (gx2 gx2Var4 : this.a.values()) {
                        if (gx2Var4 != null) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: lruClient=" + gx2Var4);
                            }
                            return gx2Var4;
                        }
                    }
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: P0");
                    }
                    return o(SwanAppProcessInfo.P0);
                }
            }
        }
        return (gx2) invokeV.objValue;
    }

    @Nullable
    public synchronized gx2 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                u("b4 computNextPreloadProcess");
                gx2 gx2Var = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    gx2 gx2Var2 = this.a.get(SwanAppProcessInfo.indexOf(i2));
                    if (gx2Var2 != null && gx2Var2.b.isSwanAppProcess() && !gx2Var2.E()) {
                        if (gx2Var2.S()) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextPreloadProcess: return null by found empty process=" + gx2Var2);
                            }
                            return null;
                        } else if (gx2Var == null) {
                            gx2Var = gx2Var2;
                        }
                    }
                }
                if (i) {
                    Log.i("SwanPuppetManager", "computNextPreloadProcess: firstPreloadableClient=" + gx2Var);
                }
                return gx2Var;
            }
        }
        return (gx2) invokeV.objValue;
    }

    public synchronized void g(String str, gx2 gx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, gx2Var) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                List<gx2> j2 = k().j(str);
                if (j2.isEmpty()) {
                    return;
                }
                for (gx2 gx2Var2 : j2) {
                    if (gx2Var2 != gx2Var && gx2Var2 != null && gx2Var2.E()) {
                        if (i) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + gx2Var);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + gx2Var2);
                        }
                        gx2Var2.e0();
                        gx2Var2.d0();
                        if (gx2Var2.T()) {
                            xw2 e = xw2.e();
                            zw2 zw2Var = new zw2(110, new Bundle());
                            zw2Var.b(gx2Var2.b);
                            e.h(zw2Var);
                        }
                    }
                }
            }
        }
    }

    public void h(ex2 ex2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ex2Var) == null) {
            synchronized (this.g) {
                this.g.remove(ex2Var);
                if (i) {
                    Log.i("SwanPuppetManager", "delCallback: after = " + this.g.size());
                }
            }
        }
    }

    @Nullable
    public synchronized gx2 i(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                List<gx2> j2 = j(str);
                if (j2.isEmpty()) {
                    return null;
                }
                return j2.get(j2.size() - 1);
            }
        }
        return (gx2) invokeL.objValue;
    }

    @NonNull
    public synchronized List<gx2> j(@Nullable String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    for (gx2 gx2Var : this.a.values()) {
                        if (TextUtils.equals(gx2Var.getAppId(), str)) {
                            arrayList.add(gx2Var);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public synchronized gx2 l(@Nullable String str) {
        InterceptResult invokeL;
        gx2 i2;
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
        return (gx2) invokeL.objValue;
    }

    public ex2 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.h : (ex2) invokeV.objValue;
    }

    public synchronized gx2 n(int i2) {
        InterceptResult invokeI;
        gx2 o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            synchronized (this) {
                o = o(SwanAppProcessInfo.indexOf(i2));
            }
            return o;
        }
        return (gx2) invokeI.objValue;
    }

    public synchronized gx2 o(SwanAppProcessInfo swanAppProcessInfo) {
        InterceptResult invokeL;
        gx2 gx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, swanAppProcessInfo)) == null) {
            synchronized (this) {
                gx2Var = this.a.get(swanAppProcessInfo);
            }
            return gx2Var;
        }
        return (gx2) invokeL.objValue;
    }

    public synchronized <FILTER> gx2 p(FILTER filter, c<FILTER> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, filter, cVar)) == null) {
            synchronized (this) {
                for (gx2 gx2Var : this.a.values()) {
                    if (cVar.a(filter, gx2Var)) {
                        return gx2Var;
                    }
                }
                return null;
            }
        }
        return (gx2) invokeLL.objValue;
    }

    public synchronized LinkedHashSet<gx2> q() {
        InterceptResult invokeV;
        LinkedHashSet<gx2> linkedHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                linkedHashSet = new LinkedHashSet<>(this.a.values());
            }
            return linkedHashSet;
        }
        return (LinkedHashSet) invokeV.objValue;
    }

    @NonNull
    public synchronized gx2 r(@Nullable String str) {
        InterceptResult invokeL;
        gx2 l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
                l = l(str);
                v(l.b);
            }
            return l;
        }
        return (gx2) invokeL.objValue;
    }

    public void s(Message message) {
        gx2 o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, message) == null) || message == null) {
            return;
        }
        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
        if (indexOf.isSwanAppProcess() && (o = o(indexOf)) != null) {
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(ix2.class.getClassLoader());
                o.o0(bundle.getLong("property_launch_cost", -1L));
            }
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && i) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.b.iterator();
            while (it.hasNext()) {
                Log.i("SwanPuppetManager", "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            LinkedHashSet<gx2> q = q();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(":");
            sb.append("\n-> clients: ");
            for (gx2 gx2Var : q) {
                sb.append("\n--> ");
                sb.append(gx2Var.toString());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && i) {
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
                gx2 remove = this.a.remove(swanAppProcessInfo);
                if (remove != null) {
                    this.a.put(swanAppProcessInfo, remove);
                }
                if (i) {
                    u("lru -> " + swanAppProcessInfo);
                }
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this.b) {
                if (d()) {
                    this.b.offer(Long.valueOf(System.currentTimeMillis()));
                    Bundle bundle = new Bundle();
                    bundle.putString("bundle_key_preload_preload_scene", "1");
                    fx2.n(oj2.c(), bundle);
                }
            }
        }
    }

    public ix2() {
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
        this.a = new LinkedHashMap<>();
        this.b = new ArrayDeque();
        this.c = new SwanAppMessengerService.a();
        this.d = new Messenger(this.c);
        this.e = new SwanProcessCallStub(this.c);
        this.f = 0L;
        this.g = new HashSet();
        this.h = new a(this);
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.a.put(swanAppProcessInfo, new gx2(swanAppProcessInfo));
            }
        }
    }
}
