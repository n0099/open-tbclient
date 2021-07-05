package d.l.a.e.b.g;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class c implements p {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String l = "c";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Service> f74703e;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<List<d.l.a.e.b.n.a>> f74704f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f74705g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f74706h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f74707i;
    public Handler j;
    public Runnable k;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f74708e;

        public a(c cVar) {
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
            this.f74708e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.l.a.e.b.c.a.e()) {
                    d.l.a.e.b.c.a.g(c.l, "tryDownload: 2 try");
                }
                if (this.f74708e.f74705g) {
                    return;
                }
                if (d.l.a.e.b.c.a.e()) {
                    d.l.a.e.b.c.a.g(c.l, "tryDownload: 2 error");
                }
                this.f74708e.e(e.n(), null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1799599071, "Ld/l/a/e/b/g/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1799599071, "Ld/l/a/e/b/g/c;");
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
        this.f74704f = new SparseArray<>();
        this.f74705g = false;
        this.f74707i = false;
        this.j = new Handler(Looper.getMainLooper());
        this.k = new a(this);
    }

    @Override // d.l.a.e.b.g.p
    public void a(Intent intent, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, intent, i2, i3) == null) {
        }
    }

    @Override // d.l.a.e.b.g.p
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f74705g : invokeV.booleanValue;
    }

    @Override // d.l.a.e.b.g.p
    public void b(d.l.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
        }
    }

    @Override // d.l.a.e.b.g.p
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = l;
            d.l.a.e.b.c.a.i(str, "isServiceForeground = " + this.f74706h);
            return this.f74706h;
        }
        return invokeV.booleanValue;
    }

    @Override // d.l.a.e.b.g.p
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // d.l.a.e.b.g.p
    public void c(WeakReference weakReference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, weakReference) == null) {
            this.f74703e = weakReference;
        }
    }

    @Override // d.l.a.e.b.g.p
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f74705g = false;
        }
    }

    @Override // d.l.a.e.b.g.p
    public void d(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, oVar) == null) {
        }
    }

    public abstract void e(Context context, ServiceConnection serviceConnection);

    public void f(d.l.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) || aVar == null) {
            return;
        }
        int I = aVar.I();
        synchronized (this.f74704f) {
            String str = l;
            d.l.a.e.b.c.a.g(str, "pendDownloadTask pendingTasks.size:" + this.f74704f.size() + " downloadId:" + I);
            List<d.l.a.e.b.n.a> list = this.f74704f.get(I);
            if (list == null) {
                list = new ArrayList<>();
                this.f74704f.put(I, list);
            }
            String str2 = l;
            d.l.a.e.b.c.a.g(str2, "before pendDownloadTask taskArray.size:" + list.size());
            list.add(aVar);
            String str3 = l;
            d.l.a.e.b.c.a.g(str3, "after pendDownloadTask pendingTasks.size:" + this.f74704f.size());
        }
    }

    public void g() {
        SparseArray<List<d.l.a.e.b.n.a>> clone;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this.f74704f) {
                String str = l;
                d.l.a.e.b.c.a.g(str, "resumePendingTask pendingTasks.size:" + this.f74704f.size());
                clone = this.f74704f.clone();
                this.f74704f.clear();
            }
            d.l.a.e.b.m.a c2 = e.c();
            if (c2 != null) {
                for (int i2 = 0; i2 < clone.size(); i2++) {
                    List<d.l.a.e.b.n.a> list = clone.get(clone.keyAt(i2));
                    if (list != null) {
                        for (d.l.a.e.b.n.a aVar : list) {
                            String str2 = l;
                            d.l.a.e.b.c.a.g(str2, "resumePendingTask key:" + aVar.I());
                            c2.o(aVar);
                        }
                    }
                }
            }
        }
    }

    @Override // d.l.a.e.b.g.p
    public IBinder a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            d.l.a.e.b.c.a.g(l, "onBind Abs");
            return new Binder();
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.p
    public void a(int i2, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, notification) == null) {
            WeakReference<Service> weakReference = this.f74703e;
            if (weakReference != null && weakReference.get() != null) {
                String str = l;
                d.l.a.e.b.c.a.i(str, "startForeground  id = " + i2 + ", service = " + this.f74703e.get() + ",  isServiceAlive = " + this.f74705g);
                try {
                    this.f74703e.get().startForeground(i2, notification);
                    this.f74706h = true;
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            d.l.a.e.b.c.a.j(l, "startForeground: downloadService is null, do nothing!");
        }
    }

    @Override // d.l.a.e.b.g.p
    public void a(boolean z) {
        WeakReference<Service> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (weakReference = this.f74703e) == null || weakReference.get() == null) {
            return;
        }
        String str = l;
        d.l.a.e.b.c.a.i(str, "stopForeground  service = " + this.f74703e.get() + ",  isServiceAlive = " + this.f74705g);
        try {
            this.f74706h = false;
            this.f74703e.get().stopForeground(z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.p
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f74705g) {
            return;
        }
        if (d.l.a.e.b.c.a.e()) {
            d.l.a.e.b.c.a.g(l, "startService");
        }
        e(e.n(), null);
    }

    @Override // d.l.a.e.b.g.p
    public void a(d.l.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        if (!this.f74705g) {
            if (d.l.a.e.b.c.a.e()) {
                d.l.a.e.b.c.a.g(l, "tryDownload but service is not alive");
            }
            if (d.l.a.e.b.l.a.a(262144)) {
                f(aVar);
                if (!this.f74707i) {
                    if (d.l.a.e.b.c.a.e()) {
                        d.l.a.e.b.c.a.g(l, "tryDownload: 1");
                    }
                    e(e.n(), null);
                    this.f74707i = true;
                    return;
                }
                this.j.removeCallbacks(this.k);
                this.j.postDelayed(this.k, 10L);
                return;
            }
            f(aVar);
            e(e.n(), null);
            return;
        }
        d.l.a.e.b.c.a.g(l, "tryDownload when isServiceAlive");
        g();
        d.l.a.e.b.m.a c2 = e.c();
        if (c2 != null) {
            String str = l;
            d.l.a.e.b.c.a.g(str, "tryDownload current task: " + aVar.I());
            c2.o(aVar);
        }
    }

    @Override // d.l.a.e.b.g.p
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            d.l.a.e.b.c.a.a(i2);
        }
    }
}
