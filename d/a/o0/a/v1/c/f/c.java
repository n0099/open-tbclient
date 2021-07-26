package d.a.o0.a.v1.c.f;

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
import d.a.o0.a.a2.h;
import d.a.o0.a.a2.i;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes7.dex */
public final class c extends d.a.o0.a.v1.c.b implements Object {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final SwanAppProcessInfo f48461f;

    /* renamed from: g  reason: collision with root package name */
    public String f48462g;

    /* renamed from: h  reason: collision with root package name */
    public Messenger f48463h;

    /* renamed from: i  reason: collision with root package name */
    public SwanAppCores f48464i;
    public PrefetchEvent j;
    public boolean k;
    public long l;
    public boolean m;
    public ServiceConnectionC0959c n;
    public final Deque<Message> o;
    public b p;
    public final Set<String> q;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(c cVar);
    }

    /* renamed from: d.a.o0.a.v1.c.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ServiceConnectionC0959c implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f48465e;

        public ServiceConnectionC0959c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48465e = cVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                synchronized (this.f48465e.f48461f) {
                    this.f48465e.f48463h = new Messenger(iBinder);
                    e k = e.k();
                    k.m().a("event_puppet_online", this.f48465e);
                    if (c.r) {
                        k.u("on main bind to swan: " + this.f48465e.f48461f);
                    }
                    this.f48465e.h();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.f48465e.O();
            }
        }

        public /* synthetic */ ServiceConnectionC0959c(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1888878038, "Ld/a/o0/a/v1/c/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1888878038, "Ld/a/o0/a/v1/c/f/c;");
                return;
            }
        }
        r = d.a.o0.a.v1.c.a.f48428b;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SwanAppProcessInfo swanAppProcessInfo) {
        super(d.a.o0.a.a2.d.g());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppProcessInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48462g = "";
        this.f48463h = null;
        this.k = true;
        this.l = 0L;
        this.m = false;
        this.o = new ArrayDeque();
        this.q = d.a.o0.a.v2.z0.a.a(new String[0]);
        this.f48461f = swanAppProcessInfo;
        d.a.o0.a.a2.b bVar = new d.a.o0.a.a2.b();
        bVar.e(this, "event_messenger_call");
        v(bVar);
    }

    @Override // d.a.o0.a.a2.m, d.a.o0.a.a2.h
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f48462g) : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.f48461f) {
                z = this.f48463h != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j != null : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? D() : invokeV.booleanValue;
    }

    public c I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (!TextUtils.equals(str, this.f48462g)) {
                if (TextUtils.isEmpty(str)) {
                    str = "swan_id_unknown";
                }
                this.f48462g = str;
                e.k().m().a("event_puppet_load_app", this);
                this.k = true;
            } else {
                this.k = false;
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public final void J(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && r) {
            Log.i("SwanClientPuppet", str);
        }
    }

    public c K(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle)) == null) {
            c0(bundle);
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c L(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bundle)) == null) {
            X(null);
            g();
            c0(bundle);
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            R();
            e.k().m().a("event_puppet_unload_app", this);
            return this;
        }
        return (c) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: N */
    public void onCallback(i.a aVar) {
        String[] p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) && d.a.o0.a.v1.b.c.f(aVar.C(), "swan_multi_preload_on_server") && aVar.i("swan_multi_preload_app_process_index") == this.f48461f.index && (p = aVar.p("swan_multi_preload_app_ids")) != null) {
            synchronized (this.q) {
                this.q.clear();
                for (String str : p) {
                    if (!TextUtils.isEmpty(str)) {
                        this.q.add(str);
                    }
                }
                if (r) {
                    Log.d("SwanClientPuppet", "get all in prefetch ids - " + this.q);
                }
            }
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this.f48461f) {
                this.f48463h = null;
                this.n = null;
                Q();
                e k = e.k();
                k.m().a("event_puppet_offline", this);
                if (r) {
                    k.u("onSwanClientConnDown => " + this);
                }
                k.w();
            }
        }
    }

    public c P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.m = true;
            this.l = 0L;
            b bVar = this.p;
            if (bVar != null) {
                bVar.a(this);
            }
            return this;
        }
        return (c) invokeV.objValue;
    }

    public c Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this.f48461f) {
                R();
                this.f48463h = null;
                this.f48464i = null;
                X(null);
                g();
                S();
            }
            return this;
        }
        return (c) invokeV.objValue;
    }

    public c R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            this.f48462g = "";
            X(null);
            g();
            return this;
        }
        return (c) invokeV.objValue;
    }

    public c S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            this.m = false;
            this.l = 0L;
            X(null);
            g();
            return this;
        }
        return (c) invokeV.objValue;
    }

    public void T(@NonNull Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, message) == null) {
            try {
                Application b2 = d.a.o0.a.c1.a.b();
                Intent intent = new Intent(b2, this.f48461f.service);
                intent.setAction(SwanAppLocalService.ACTION_RECEIVER_MSG);
                intent.putExtra("data", message);
                b2.startService(intent);
            } catch (Throwable th) {
                d.a.o0.a.e0.d.c("SwanClientPuppet", "sendMessageToClientService fail", th);
            }
        }
    }

    public boolean U(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, message)) == null) {
            this.o.offer(message);
            h();
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0021 A[Catch: all -> 0x0027, TryCatch #1 {, blocks: (B:7:0x0009, B:9:0x000f, B:11:0x0015, B:16:0x001a, B:18:0x0021, B:19:0x0024), top: B:29:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean V(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, message)) == null) {
            synchronized (this.f48461f) {
                if (message != null) {
                    if (H()) {
                        try {
                            this.f48463h.send(message);
                            return true;
                        } catch (RemoteException e2) {
                            e = e2;
                            O();
                            if (r) {
                                e.printStackTrace();
                            }
                            return false;
                        } catch (RuntimeException e3) {
                            e = e3;
                            O();
                            if (r) {
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

    public boolean W(Collection<Message> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, collection)) == null) {
            for (Message message : collection) {
                this.o.offer(message);
            }
            h();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void X(PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, prefetchEvent) == null) {
            this.j = prefetchEvent;
        }
    }

    public void Y(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public c Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            a0(false, null, null);
            return this;
        }
        return (c) invokeV.objValue;
    }

    public c a0(boolean z, Context context, Bundle bundle) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), context, bundle})) == null) {
            if (r) {
                e k = e.k();
                k.u("b4 tryPreBind: " + this.f48461f);
            }
            if (context == null) {
                context = d.a.o0.a.c1.a.b();
            }
            Intent intent = new Intent(context, this.f48461f.service);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            this.l = System.currentTimeMillis();
            intent.putExtra("call_preload_time", System.currentTimeMillis());
            intent.putExtra("bundle_key_main_pid", Process.myPid());
            intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
            intent.addCategory("android.intent.category.DEFAULT");
            synchronized (this.f48461f) {
                try {
                    if (this.n == null) {
                        ServiceConnectionC0959c serviceConnectionC0959c = new ServiceConnectionC0959c(this, null);
                        this.n = serviceConnectionC0959c;
                        context.bindService(intent, serviceConnectionC0959c, 1);
                    } else if (z) {
                        context.startService(intent);
                    }
                } catch (Exception e2) {
                    if (r) {
                        e2.printStackTrace();
                    }
                }
                if (this.f48463h != null) {
                    h();
                }
            }
            return this;
        }
        return (c) invokeCommon.objValue;
    }

    public c b0(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, context, bundle)) == null) {
            if (r) {
                e k = e.k();
                k.u("b4 preload: " + this.f48461f);
            }
            a0(true, context, bundle);
            return this;
        }
        return (c) invokeLL.objValue;
    }

    public final c c0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, bundle)) == null) {
            Parcelable parcelable = bundle.getParcelable("app_core");
            e0(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
            String string = bundle.getString("app_id");
            if (!TextUtils.isEmpty(string)) {
                I(string);
                e.k().g(string, this);
                d.a.o0.a.v1.c.a.e().d(string);
                S();
            }
            Z();
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c d0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048603, this, j)) == null) {
            if (j > 0) {
                e.k().m().a("event_puppet_fmp_launch_finish", this);
            }
            return this;
        }
        return (c) invokeJ.objValue;
    }

    public c e0(SwanAppCores swanAppCores) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, swanAppCores)) == null) {
            if (swanAppCores != null) {
                this.f48464i = swanAppCores;
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            synchronized (this.q) {
                this.q.clear();
                if (r) {
                    Log.d("SwanClientPuppet", "clear all prefetch ids");
                }
            }
        }
    }

    @Override // d.a.o0.a.a2.m, d.a.o0.a.a2.h
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f48462g : (String) invokeV.objValue;
    }

    public c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            J("flushCachedMsgs");
            synchronized (this.f48461f) {
                while (this.f48463h != null && !this.o.isEmpty()) {
                    Message peek = this.o.peek();
                    if (peek.replyTo == null) {
                        peek.replyTo = e.k().f48472d;
                    }
                    if (!V(peek)) {
                        break;
                    }
                    this.o.poll();
                }
            }
            return this;
        }
        return (c) invokeV.objValue;
    }

    public Set<String> i() {
        InterceptResult invokeV;
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            synchronized (this.q) {
                hashSet = new HashSet(this.q);
                if (this.j != null && !TextUtils.isEmpty(this.j.appId)) {
                    hashSet.add(this.j.appId);
                }
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            PrefetchEvent prefetchEvent = this.j;
            return prefetchEvent != null ? prefetchEvent.appId : "";
        }
        return (String) invokeV.objValue;
    }

    public SwanAppProcessInfo k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f48461f : (SwanAppProcessInfo) invokeV.objValue;
    }

    @Override // d.a.o0.a.a2.m, d.a.o0.a.a2.h
    public SwanAppCores n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f48464i : (SwanAppCores) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return String.format(Locale.getDefault(), "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", this.f48461f.toString(), Integer.valueOf(H() ? 1 : 0), Integer.valueOf(this.m ? 1 : 0), SimpleDateFormat.getTimeInstance(2).format(new Date(this.l)), this.f48462g);
        }
        return (String) invokeV.objValue;
    }
}
