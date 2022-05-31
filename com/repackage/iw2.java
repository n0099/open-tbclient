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
public final class iw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static final long j;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<SwanAppProcessInfo, gw2> a;
    public final Deque<Long> b;
    public final Handler c;
    public final Messenger d;
    public final SwanProcessCallStub e;
    public long f;
    public final Set<ew2> g;
    public final ew2 h;

    /* loaded from: classes6.dex */
    public class a implements ew2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw2 a;

        /* renamed from: com.repackage.iw2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0445a implements ae3<ew2> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ gw2 b;

            public C0445a(a aVar, String str, gw2 gw2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, gw2Var};
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
                this.b = gw2Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.ae3
            /* renamed from: a */
            public void onCallback(ew2 ew2Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ew2Var) == null) {
                    ew2Var.a(this.a, this.b);
                }
            }
        }

        public a(iw2 iw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iw2Var;
        }

        @Override // com.repackage.ew2
        public void a(String str, gw2 gw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, gw2Var) == null) {
                if (iw2.i) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + this.a.g.size() + " event=" + str + " client=" + gw2Var.b);
                }
                synchronized (this.a.g) {
                    zd3.a(gz2.L(), new C0445a(this, str, gw2Var), this.a.g);
                }
            }
        }

        @Override // com.repackage.ew2
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
        public final /* synthetic */ ew2 a;
        public final /* synthetic */ iw2 b;

        public b(iw2 iw2Var, ew2 ew2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw2Var, ew2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iw2Var;
            this.a = ew2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b.g) {
                    if (this.b.g.contains(this.a)) {
                        if (iw2.i) {
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
        boolean a(FILTER filter, gw2 gw2Var);
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static iw2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-286100435, "Lcom/repackage/iw2$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-286100435, "Lcom/repackage/iw2$d;");
                    return;
                }
            }
            a = new iw2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755604115, "Lcom/repackage/iw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755604115, "Lcom/repackage/iw2;");
                return;
            }
        }
        i = rf1.a;
        j = TimeUnit.MINUTES.toMillis(5L);
    }

    public /* synthetic */ iw2(a aVar) {
        this();
    }

    @SuppressLint({"BDThrowableCheck"})
    public static iw2 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!i || ProcessUtils.isMainProcess()) {
                return d.a;
            }
            throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
        }
        return (iw2) invokeV.objValue;
    }

    public void b(ew2 ew2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ew2Var) == null) {
            c(ew2Var, -1L);
        }
    }

    public void c(ew2 ew2Var, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ew2Var, j2) == null) {
            synchronized (this.g) {
                this.g.add(ew2Var);
                if (i) {
                    Log.i("SwanPuppetManager", "addCallback: after = " + this.g.size());
                }
            }
            if (j2 > 0) {
                gz2.L().postDelayed(new b(this, ew2Var), j2);
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

    public synchronized gw2 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                u("b4 computNextAvailableProcess");
                gw2 gw2Var = null;
                gw2 gw2Var2 = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    gw2 gw2Var3 = this.a.get(SwanAppProcessInfo.indexOf(i2));
                    if (gw2Var3 != null && gw2Var3.b.isSwanAppProcess() && !gw2Var3.D()) {
                        if (gw2Var3.R()) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + gw2Var3);
                            }
                            return gw2Var3;
                        }
                        if (gw2Var == null && gw2Var3.S()) {
                            gw2Var = gw2Var3;
                        }
                        if (gw2Var2 == null) {
                            gw2Var2 = gw2Var3;
                        }
                    }
                }
                if (gw2Var != null) {
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + gw2Var);
                    }
                    return gw2Var;
                } else if (gw2Var2 != null) {
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstEmptyClient=" + gw2Var2);
                    }
                    return gw2Var2;
                } else {
                    for (gw2 gw2Var4 : this.a.values()) {
                        if (gw2Var4 != null) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: lruClient=" + gw2Var4);
                            }
                            return gw2Var4;
                        }
                    }
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: P0");
                    }
                    return o(SwanAppProcessInfo.P0);
                }
            }
        }
        return (gw2) invokeV.objValue;
    }

    @Nullable
    public synchronized gw2 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                u("b4 computNextPreloadProcess");
                gw2 gw2Var = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    gw2 gw2Var2 = this.a.get(SwanAppProcessInfo.indexOf(i2));
                    if (gw2Var2 != null && gw2Var2.b.isSwanAppProcess() && !gw2Var2.D()) {
                        if (gw2Var2.R()) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextPreloadProcess: return null by found empty process=" + gw2Var2);
                            }
                            return null;
                        } else if (gw2Var == null) {
                            gw2Var = gw2Var2;
                        }
                    }
                }
                if (i) {
                    Log.i("SwanPuppetManager", "computNextPreloadProcess: firstPreloadableClient=" + gw2Var);
                }
                return gw2Var;
            }
        }
        return (gw2) invokeV.objValue;
    }

    public synchronized void g(String str, gw2 gw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, gw2Var) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                List<gw2> j2 = k().j(str);
                if (j2.isEmpty()) {
                    return;
                }
                for (gw2 gw2Var2 : j2) {
                    if (gw2Var2 != gw2Var && gw2Var2 != null && gw2Var2.D()) {
                        if (i) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + gw2Var);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + gw2Var2);
                        }
                        gw2Var2.d0();
                        gw2Var2.c0();
                        if (gw2Var2.S()) {
                            xv2 e = xv2.e();
                            zv2 zv2Var = new zv2(110, new Bundle());
                            zv2Var.b(gw2Var2.b);
                            e.h(zv2Var);
                        }
                    }
                }
            }
        }
    }

    public void h(ew2 ew2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ew2Var) == null) {
            synchronized (this.g) {
                this.g.remove(ew2Var);
                if (i) {
                    Log.i("SwanPuppetManager", "delCallback: after = " + this.g.size());
                }
            }
        }
    }

    @Nullable
    public synchronized gw2 i(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                List<gw2> j2 = j(str);
                if (j2.isEmpty()) {
                    return null;
                }
                return j2.get(j2.size() - 1);
            }
        }
        return (gw2) invokeL.objValue;
    }

    @NonNull
    public synchronized List<gw2> j(@Nullable String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    for (gw2 gw2Var : this.a.values()) {
                        if (TextUtils.equals(gw2Var.getAppId(), str)) {
                            arrayList.add(gw2Var);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public synchronized gw2 l(@Nullable String str) {
        InterceptResult invokeL;
        gw2 i2;
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
        return (gw2) invokeL.objValue;
    }

    public ew2 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.h : (ew2) invokeV.objValue;
    }

    public synchronized gw2 n(int i2) {
        InterceptResult invokeI;
        gw2 o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            synchronized (this) {
                o = o(SwanAppProcessInfo.indexOf(i2));
            }
            return o;
        }
        return (gw2) invokeI.objValue;
    }

    public synchronized gw2 o(SwanAppProcessInfo swanAppProcessInfo) {
        InterceptResult invokeL;
        gw2 gw2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, swanAppProcessInfo)) == null) {
            synchronized (this) {
                gw2Var = this.a.get(swanAppProcessInfo);
            }
            return gw2Var;
        }
        return (gw2) invokeL.objValue;
    }

    public synchronized <FILTER> gw2 p(FILTER filter, c<FILTER> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, filter, cVar)) == null) {
            synchronized (this) {
                for (gw2 gw2Var : this.a.values()) {
                    if (cVar.a(filter, gw2Var)) {
                        return gw2Var;
                    }
                }
                return null;
            }
        }
        return (gw2) invokeLL.objValue;
    }

    public synchronized LinkedHashSet<gw2> q() {
        InterceptResult invokeV;
        LinkedHashSet<gw2> linkedHashSet;
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
    public synchronized gw2 r(@Nullable String str) {
        InterceptResult invokeL;
        gw2 l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
                l = l(str);
                v(l.b);
            }
            return l;
        }
        return (gw2) invokeL.objValue;
    }

    public void s(Message message) {
        gw2 o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, message) == null) || message == null) {
            return;
        }
        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
        if (indexOf.isSwanAppProcess() && (o = o(indexOf)) != null) {
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(iw2.class.getClassLoader());
                o.n0(bundle.getLong("property_launch_cost", -1L));
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
            LinkedHashSet<gw2> q = q();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(":");
            sb.append("\n-> clients: ");
            for (gw2 gw2Var : q) {
                sb.append("\n--> ");
                sb.append(gw2Var.toString());
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
                gw2 remove = this.a.remove(swanAppProcessInfo);
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
                    fw2.n(oi2.c(), bundle);
                }
            }
        }
    }

    public iw2() {
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
                this.a.put(swanAppProcessInfo, new gw2(swanAppProcessInfo));
            }
        }
    }
}
