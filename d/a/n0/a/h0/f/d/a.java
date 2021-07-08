package d.a.n0.a.h0.f.d;

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
import d.a.n0.a.k;
import d.a.n0.a.p.e.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public class a implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f44598g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.n0.a.h0.f.d.b> f44599a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f44600b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f44601c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f44602d;

    /* renamed from: e  reason: collision with root package name */
    public c f44603e;

    /* renamed from: f  reason: collision with root package name */
    public WebKitFactory.IForceInitZeusListener f44604f;

    /* renamed from: d.a.n0.a.h0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0714a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f44605a;

        public C0714a(a aVar) {
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
            this.f44605a = aVar;
        }

        @Override // d.a.n0.a.h0.f.d.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f44605a.f44600b.lock();
                    this.f44605a.f44602d = true;
                    this.f44605a.j();
                    this.f44605a.p();
                } finally {
                    this.f44605a.f44600b.unlock();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements WebKitFactory.IForceInitZeusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f44606a;

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
            this.f44606a = aVar;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusFinish(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                try {
                    this.f44606a.f44600b.lock();
                    this.f44606a.f44601c = true;
                    this.f44606a.p();
                    this.f44606a.f44600b.unlock();
                    BdSailor.getInstance().removeForceInitListener(this.f44606a.f44604f);
                } catch (Throwable th) {
                    this.f44606a.f44600b.unlock();
                    throw th;
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusStart() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && a.f44598g) {
                Log.d("NgWebViewInitHelper", "onForceInitZeusStart");
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f44607a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1764905793, "Ld/a/n0/a/h0/f/d/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1764905793, "Ld/a/n0/a/h0/f/d/a$d;");
                    return;
                }
            }
            f44607a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(789224063, "Ld/a/n0/a/h0/f/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(789224063, "Ld/a/n0/a/h0/f/d/a;");
                return;
            }
        }
        f44598g = k.f45831a;
    }

    public /* synthetic */ a(C0714a c0714a) {
        this();
    }

    public static a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? d.f44607a : (a) invokeV.objValue;
    }

    @Override // d.a.n0.a.p.e.h
    public void a(d.a.n0.a.h0.f.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            try {
                this.f44600b.lock();
                if (bVar != null && this.f44599a.contains(bVar)) {
                    this.f44599a.remove(bVar);
                }
            } finally {
                this.f44600b.unlock();
            }
        }
    }

    @Override // d.a.n0.a.p.e.h
    public void b(d.a.n0.a.h0.f.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            try {
                this.f44600b.lock();
                if (bVar == null) {
                    return;
                }
                if (!this.f44599a.contains(bVar)) {
                    this.f44599a.add(bVar);
                }
                if (n()) {
                    p();
                }
            } finally {
                this.f44600b.unlock();
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
            d.a.n0.a.c1.a.f().d(z);
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
                this.f44600b.lock();
                if (f44598g) {
                    Log.d("NgWebViewInitHelper", "isLoaded() mIsBlinkInited: " + this.f44602d);
                    Log.d("NgWebViewInitHelper", "isLoaded() mIsZeusForceInited: " + this.f44601c + " ,isZeusForceInited: " + o());
                }
                if (this.f44602d) {
                    if (!this.f44601c) {
                    }
                    z = true;
                    return z;
                }
                z = false;
                return z;
            } finally {
                this.f44600b.unlock();
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (f44598g) {
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
                this.f44600b.lock();
                if (n()) {
                    Iterator<d.a.n0.a.h0.f.d.b> it = this.f44599a.iterator();
                    while (it.hasNext()) {
                        d.a.n0.a.h0.f.d.b next = it.next();
                        if (next != null) {
                            next.a();
                        }
                    }
                    this.f44599a.clear();
                }
            } finally {
                this.f44600b.unlock();
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
        this.f44599a = new ArrayList<>();
        this.f44600b = new ReentrantLock();
        this.f44601c = false;
        this.f44602d = false;
        this.f44603e = new C0714a(this);
        b bVar = new b(this);
        this.f44604f = bVar;
        BdSailor.addForceInitListener(bVar);
        d.a.n0.a.c1.a.f().h(this.f44603e);
    }
}
