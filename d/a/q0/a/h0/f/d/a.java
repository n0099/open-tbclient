package d.a.q0.a.h0.f.d;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.WebKitFactory;
import d.a.q0.a.k;
import d.a.q0.a.p.e.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes8.dex */
public class a implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f47900g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.q0.a.h0.f.d.b> f47901a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f47902b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f47903c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f47904d;

    /* renamed from: e  reason: collision with root package name */
    public c f47905e;

    /* renamed from: f  reason: collision with root package name */
    public WebKitFactory.IForceInitZeusListener f47906f;

    /* renamed from: d.a.q0.a.h0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0765a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47907a;

        public C0765a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47907a = aVar;
        }

        @Override // d.a.q0.a.h0.f.d.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f47907a.f47902b.lock();
                    this.f47907a.f47904d = true;
                    this.f47907a.j();
                    this.f47907a.p();
                } finally {
                    this.f47907a.f47902b.unlock();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements WebKitFactory.IForceInitZeusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47908a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47908a = aVar;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusFinish(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                try {
                    this.f47908a.f47902b.lock();
                    this.f47908a.f47903c = true;
                    this.f47908a.p();
                    this.f47908a.f47902b.unlock();
                    BdSailor.getInstance().removeForceInitListener(this.f47908a.f47906f);
                } catch (Throwable th) {
                    this.f47908a.f47902b.unlock();
                    throw th;
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusStart() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && a.f47900g) {
                Log.d("NgWebViewInitHelper", "onForceInitZeusStart");
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f47909a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(998458972, "Ld/a/q0/a/h0/f/d/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(998458972, "Ld/a/q0/a/h0/f/d/a$d;");
                    return;
                }
            }
            f47909a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-727451812, "Ld/a/q0/a/h0/f/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-727451812, "Ld/a/q0/a/h0/f/d/a;");
                return;
            }
        }
        f47900g = k.f49133a;
    }

    public /* synthetic */ a(C0765a c0765a) {
        this();
    }

    public static a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? d.f47909a : (a) invokeV.objValue;
    }

    @Override // d.a.q0.a.p.e.h
    public void a(d.a.q0.a.h0.f.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            try {
                this.f47902b.lock();
                if (bVar != null && this.f47901a.contains(bVar)) {
                    this.f47901a.remove(bVar);
                }
            } finally {
                this.f47902b.unlock();
            }
        }
    }

    @Override // d.a.q0.a.p.e.h
    public void b(d.a.q0.a.h0.f.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            try {
                this.f47902b.lock();
                if (bVar == null) {
                    return;
                }
                if (!this.f47901a.contains(bVar)) {
                    this.f47901a.add(bVar);
                }
                if (n()) {
                    p();
                }
            } finally {
                this.f47902b.unlock();
            }
        }
    }

    public final synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (!ProcessUtils.isMainProcess()) {
                    WebSettingsGlobalBlink.setFileInIOEnabled(true);
                }
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            m(false);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            d.a.q0.a.c1.a.f().d(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
        if (o() != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                this.f47902b.lock();
                if (f47900g) {
                    Log.d("NgWebViewInitHelper", "isLoaded() mIsBlinkInited: " + this.f47904d);
                    Log.d("NgWebViewInitHelper", "isLoaded() mIsZeusForceInited: " + this.f47903c + " ,isZeusForceInited: " + o());
                }
                if (this.f47904d) {
                    if (!this.f47903c) {
                    }
                    z = true;
                    return z;
                }
                z = false;
                return z;
            } finally {
                this.f47902b.unlock();
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (f47900g) {
                Log.d("NgWebViewInitHelper", "checkZeusForceInit: " + BdSailor.getInstance().checkZeusForceInit());
                Log.d("NgWebViewInitHelper", "isZeusForceInited: " + BdSailor.getInstance().isZeusForceInited());
            }
            return !BdSailor.getInstance().checkZeusForceInit() || (BdSailor.getInstance().checkZeusForceInit() && BdSailor.getInstance().isZeusForceInited());
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.f47902b.lock();
                if (n()) {
                    Iterator<d.a.q0.a.h0.f.d.b> it = this.f47901a.iterator();
                    while (it.hasNext()) {
                        d.a.q0.a.h0.f.d.b next = it.next();
                        if (next != null) {
                            next.a();
                        }
                    }
                    this.f47901a.clear();
                }
            } finally {
                this.f47902b.unlock();
            }
        }
    }

    public a() {
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
        this.f47901a = new ArrayList<>();
        this.f47902b = new ReentrantLock();
        this.f47903c = false;
        this.f47904d = false;
        this.f47905e = new C0765a(this);
        b bVar = new b(this);
        this.f47906f = bVar;
        BdSailor.addForceInitListener(bVar);
        d.a.q0.a.c1.a.f().h(this.f47905e);
    }
}
