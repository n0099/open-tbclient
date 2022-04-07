package com.repackage;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.n03;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes6.dex */
public final class ix2 extends ax2 implements Object {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public final SwanAppProcessInfo b;
    public String c;
    public Messenger d;
    public SwanAppCores e;
    public PrefetchEvent f;
    public boolean g;
    public long h;
    public boolean i;
    public c j;
    public final Deque<Message> k;
    public b l;
    public final Set<String> m;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(ix2 ix2Var);
    }

    /* loaded from: classes6.dex */
    public class c implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix2 a;

        public c(ix2 ix2Var) {
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

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                synchronized (this.a.b) {
                    this.a.d = new Messenger(iBinder);
                    kx2 k = kx2.k();
                    k.m().a("event_puppet_online", this.a);
                    if (ix2.n) {
                        k.u("on main bind to swan: " + this.a.b);
                    }
                    this.a.K();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.a.Z();
            }
        }

        public /* synthetic */ c(ix2 ix2Var, a aVar) {
            this(ix2Var);
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
        n = zw2.b;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ix2(SwanAppProcessInfo swanAppProcessInfo) {
        super(i03.J());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppProcessInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((m03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = "";
        this.d = null;
        this.g = true;
        this.h = 0L;
        this.i = false;
        this.k = new ArrayDeque();
        this.m = ne3.a(new String[0]);
        this.b = swanAppProcessInfo;
        g03 g03Var = new g03();
        g03Var.e(this, "event_messenger_call");
        v(g03Var);
    }

    private ix2 update(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bundle)) == null) {
            Parcelable parcelable = bundle.getParcelable("app_core");
            o0(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
            String string = bundle.getString("app_id");
            if (!TextUtils.isEmpty(string)) {
                T(string);
                kx2.k().g(string, this);
                zw2.e().d(string);
                d0();
            }
            k0();
            return this;
        }
        return (ix2) invokeL.objValue;
    }

    @Override // com.repackage.r03, com.repackage.m03
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.c) : invokeV.booleanValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.m) {
                this.m.clear();
                if (n) {
                    Log.d("SwanClientPuppet", "clear all prefetch ids");
                }
            }
        }
    }

    public ix2 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            U("flushCachedMsgs");
            synchronized (this.b) {
                while (this.d != null && !this.k.isEmpty()) {
                    Message peek = this.k.peek();
                    if (peek.replyTo == null) {
                        peek.replyTo = kx2.k().d;
                    }
                    if (!g0(peek)) {
                        break;
                    }
                    this.k.poll();
                }
            }
            return this;
        }
        return (ix2) invokeV.objValue;
    }

    public Set<String> L() {
        InterceptResult invokeV;
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.m) {
                hashSet = new HashSet(this.m);
                if (this.f != null && !TextUtils.isEmpty(this.f.appId)) {
                    hashSet.add(this.f.appId);
                }
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PrefetchEvent prefetchEvent = this.f;
            return prefetchEvent != null ? prefetchEvent.appId : "";
        }
        return (String) invokeV.objValue;
    }

    public SwanAppProcessInfo N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (SwanAppProcessInfo) invokeV.objValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.b) {
                z = this.d != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f != null : invokeV.booleanValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? O() : invokeV.booleanValue;
    }

    public ix2 T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (!TextUtils.equals(str, this.c)) {
                if (TextUtils.isEmpty(str)) {
                    str = "swan_id_unknown";
                }
                this.c = str;
                kx2.k().m().a("event_puppet_load_app", this);
                this.g = true;
            } else {
                this.g = false;
            }
            return this;
        }
        return (ix2) invokeL.objValue;
    }

    public final void U(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && n) {
            Log.i("SwanClientPuppet", str);
        }
    }

    public ix2 V(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bundle)) == null) ? update(bundle) : (ix2) invokeL.objValue;
    }

    public ix2 W(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bundle)) == null) {
            i0(null);
            J();
            return update(bundle);
        }
        return (ix2) invokeL.objValue;
    }

    public ix2 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            c0();
            kx2.k().m().a("event_puppet_unload_app", this);
            return this;
        }
        return (ix2) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Y */
    public void onCallback(n03.a aVar) {
        String[] p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) && vw2.I(aVar.D(), "swan_multi_preload_on_server") && aVar.i("swan_multi_preload_app_process_index") == this.b.index && (p = aVar.p("swan_multi_preload_app_ids")) != null) {
            synchronized (this.m) {
                this.m.clear();
                for (String str : p) {
                    if (!TextUtils.isEmpty(str)) {
                        this.m.add(str);
                    }
                }
                if (n) {
                    Log.d("SwanClientPuppet", "get all in prefetch ids - " + this.m);
                }
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this.b) {
                this.d = null;
                this.j = null;
                b0();
                kx2 k = kx2.k();
                k.m().a("event_puppet_offline", this);
                if (n) {
                    k.u("onSwanClientConnDown => " + this);
                }
                k.w();
            }
        }
    }

    public ix2 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            this.i = true;
            this.h = 0L;
            b bVar = this.l;
            if (bVar != null) {
                bVar.a(this);
            }
            return this;
        }
        return (ix2) invokeV.objValue;
    }

    public ix2 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this.b) {
                c0();
                this.d = null;
                this.e = null;
                i0(null);
                J();
                d0();
            }
            return this;
        }
        return (ix2) invokeV.objValue;
    }

    public ix2 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            this.c = "";
            i0(null);
            J();
            return this;
        }
        return (ix2) invokeV.objValue;
    }

    public ix2 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            this.i = false;
            this.h = 0L;
            i0(null);
            J();
            return this;
        }
        return (ix2) invokeV.objValue;
    }

    public void e0(@NonNull Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, message) == null) {
            try {
                Application c2 = qj2.c();
                Intent intent = new Intent(c2, this.b.service);
                intent.setAction(SwanAppLocalService.ACTION_RECEIVER_MSG);
                intent.putExtra("data", message);
                c2.startService(intent);
            } catch (Throwable th) {
                jx1.d("SwanClientPuppet", "sendMessageToClientService fail", th);
            }
        }
    }

    public boolean f0(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, message)) == null) {
            this.k.offer(message);
            K();
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0021 A[Catch: all -> 0x0027, TryCatch #1 {, blocks: (B:7:0x0009, B:9:0x000f, B:11:0x0015, B:16:0x001a, B:18:0x0021, B:19:0x0024), top: B:29:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean g0(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, message)) == null) {
            synchronized (this.b) {
                if (message != null) {
                    if (S()) {
                        try {
                            this.d.send(message);
                            return true;
                        } catch (RemoteException e) {
                            e = e;
                            Z();
                            if (n) {
                                e.printStackTrace();
                            }
                            return false;
                        } catch (RuntimeException e2) {
                            e = e2;
                            Z();
                            if (n) {
                            }
                            return false;
                        }
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.r03, com.repackage.m03
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public boolean h0(Collection<Message> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, collection)) == null) {
            for (Message message : collection) {
                this.k.offer(message);
            }
            K();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void i0(PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, prefetchEvent) == null) {
            this.f = prefetchEvent;
        }
    }

    public void j0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public ix2 k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            l0(false, null, null);
            return this;
        }
        return (ix2) invokeV.objValue;
    }

    public ix2 l0(boolean z, Context context, Bundle bundle) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z), context, bundle})) == null) {
            if (n) {
                kx2 k = kx2.k();
                k.u("b4 tryPreBind: " + this.b + " trace=" + Log.getStackTraceString(new Throwable()));
            }
            Application c2 = qj2.c();
            Intent intent = new Intent(c2, this.b.service);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            this.h = System.currentTimeMillis();
            intent.putExtra("call_preload_time", System.currentTimeMillis());
            intent.putExtra("bundle_key_main_pid", Process.myPid());
            intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
            intent.addCategory("android.intent.category.DEFAULT");
            synchronized (this.b) {
                try {
                    if (this.j == null) {
                        c cVar = new c(this, null);
                        this.j = cVar;
                        c2.bindService(intent, cVar, 1);
                    } else if (z) {
                        c2.startService(intent);
                    }
                } catch (Exception e) {
                    if (n) {
                        e.printStackTrace();
                    }
                }
                if (this.d != null) {
                    K();
                }
            }
            return this;
        }
        return (ix2) invokeCommon.objValue;
    }

    public ix2 m0(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, context, bundle)) == null) {
            if (n) {
                kx2 k = kx2.k();
                k.u("b4 preload: " + this.b);
            }
            l0(true, context, bundle);
            return this;
        }
        return (ix2) invokeLL.objValue;
    }

    @Override // com.repackage.r03, com.repackage.m03
    public SwanAppCores n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.e : (SwanAppCores) invokeV.objValue;
    }

    public ix2 n0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048609, this, j)) == null) {
            if (j > 0) {
                kx2.k().m().a("event_puppet_fmp_launch_finish", this);
            }
            return this;
        }
        return (ix2) invokeJ.objValue;
    }

    public ix2 o0(SwanAppCores swanAppCores) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, swanAppCores)) == null) {
            if (swanAppCores != null) {
                this.e = swanAppCores;
            }
            return this;
        }
        return (ix2) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return String.format(Locale.getDefault(), "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", this.b.toString(), Integer.valueOf(S() ? 1 : 0), Integer.valueOf(this.i ? 1 : 0), SimpleDateFormat.getTimeInstance(2).format(new Date(this.h)), this.c);
        }
        return (String) invokeV.objValue;
    }
}
