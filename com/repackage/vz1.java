package com.repackage;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public class vz1 implements gn1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<wz1> a;
    public final Lock b;
    public volatile boolean c;
    public volatile boolean d;
    public c e;
    public WebKitFactory.IForceInitZeusListener f;

    /* loaded from: classes7.dex */
    public class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz1 a;

        public a(vz1 vz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz1Var;
        }

        @Override // com.repackage.vz1.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.b.lock();
                    this.a.d = true;
                    this.a.j();
                    this.a.p();
                } finally {
                    this.a.b.unlock();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements WebKitFactory.IForceInitZeusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz1 a;

        public b(vz1 vz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz1Var;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusFinish(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                try {
                    this.a.b.lock();
                    this.a.c = true;
                    this.a.p();
                    this.a.b.unlock();
                    BdSailor.getInstance().removeForceInitListener(this.a.f);
                } catch (Throwable th) {
                    this.a.b.unlock();
                    throw th;
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusStart() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && vz1.g) {
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
        public static final vz1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(88819300, "Lcom/repackage/vz1$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(88819300, "Lcom/repackage/vz1$d;");
                    return;
                }
            }
            a = new vz1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755213980, "Lcom/repackage/vz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755213980, "Lcom/repackage/vz1;");
                return;
            }
        }
        g = eh1.a;
    }

    public /* synthetic */ vz1(a aVar) {
        this();
    }

    public static vz1 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? d.a : (vz1) invokeV.objValue;
    }

    @Override // com.repackage.gn1
    public void a(wz1 wz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wz1Var) == null) {
            try {
                this.b.lock();
                if (wz1Var != null && this.a.contains(wz1Var)) {
                    this.a.remove(wz1Var);
                }
            } finally {
                this.b.unlock();
            }
        }
    }

    @Override // com.repackage.gn1
    public void b(wz1 wz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wz1Var) == null) {
            try {
                this.b.lock();
                if (wz1Var == null) {
                    return;
                }
                if (!this.a.contains(wz1Var)) {
                    this.a.add(wz1Var);
                }
                if (n()) {
                    p();
                }
            } finally {
                this.b.unlock();
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
            bk2.g().d(z);
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
                this.b.lock();
                if (g) {
                    Log.d("NgWebViewInitHelper", "isLoaded() mIsBlinkInited: " + this.d);
                    Log.d("NgWebViewInitHelper", "isLoaded() mIsZeusForceInited: " + this.c + " ,isZeusForceInited: " + o());
                }
                if (this.d) {
                    if (!this.c) {
                    }
                    z = true;
                    return z;
                }
                z = false;
                return z;
            } finally {
                this.b.unlock();
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (g) {
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
                this.b.lock();
                if (n()) {
                    Iterator<wz1> it = this.a.iterator();
                    while (it.hasNext()) {
                        wz1 next = it.next();
                        if (next != null) {
                            next.a();
                        }
                    }
                    this.a.clear();
                }
            } finally {
                this.b.unlock();
            }
        }
    }

    public vz1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.b = new ReentrantLock();
        this.c = false;
        this.d = false;
        this.e = new a(this);
        b bVar = new b(this);
        this.f = bVar;
        BdSailor.addForceInitListener(bVar);
        bk2.g().h(this.e);
    }
}
