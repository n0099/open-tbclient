package com.xiaomi.push;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.bl;
import com.xiaomi.push.jl;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/* loaded from: classes8.dex */
public class fh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f356a;

    /* renamed from: a  reason: collision with other field name */
    public bl f357a;

    /* renamed from: a  reason: collision with other field name */
    public fg f358a;

    /* renamed from: a  reason: collision with other field name */
    public String f359a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f360a;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final fh a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1658324961, "Lcom/xiaomi/push/fh$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1658324961, "Lcom/xiaomi/push/fh$a;");
                    return;
                }
            }
            a = new fh();
        }
    }

    public fh() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f360a = false;
        this.f357a = bl.a();
    }

    private fa a(bl.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, aVar)) == null) {
            if (aVar.f135a == 0) {
                Object obj = aVar.f136a;
                if (obj instanceof fa) {
                    return (fa) obj;
                }
                return null;
            }
            fa m325a = m325a();
            m325a.a(ez.k.a());
            m325a.c(aVar.f135a);
            m325a.c(aVar.f137a);
            return m325a;
        }
        return (fa) invokeL.objValue;
    }

    private fb a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            fb fbVar = new fb(this.f359a, arrayList);
            if (!bj.e(this.f358a.f353a)) {
                fbVar.a(j.k(this.f358a.f353a));
            }
            jn jnVar = new jn(i);
            jf a2 = new jl.a().a(jnVar);
            try {
                fbVar.b(a2);
            } catch (iz unused) {
            }
            LinkedList<bl.a> m196a = this.f357a.m196a();
            while (m196a.size() > 0) {
                try {
                    fa a3 = a(m196a.getLast());
                    if (a3 != null) {
                        a3.b(a2);
                    }
                    if (jnVar.a_() > i) {
                        break;
                    }
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                    m196a.removeLast();
                } catch (iz | NoSuchElementException unused2) {
                }
            }
            return fbVar;
        }
        return (fb) invokeI.objValue;
    }

    public static fg a() {
        InterceptResult invokeV;
        fg fgVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (a.a) {
                fgVar = a.a.f358a;
            }
            return fgVar;
        }
        return (fg) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static fh m323a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.a : (fh) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m324a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.f360a && System.currentTimeMillis() - this.f356a > this.a) {
            this.f360a = false;
            this.f356a = 0L;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized fa m325a() {
        InterceptResult invokeV;
        fa faVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                faVar = new fa();
                faVar.a(bj.m189a((Context) this.f358a.f353a));
                faVar.f330a = (byte) 0;
                faVar.f334b = 1;
                faVar.d((int) (System.currentTimeMillis() / 1000));
            }
            return faVar;
        }
        return (fa) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized fb m326a() {
        InterceptResult invokeV;
        fb fbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                fbVar = null;
                if (b()) {
                    int i = PassBiometricUtil.k;
                    if (!bj.e(this.f358a.f353a)) {
                        i = 375;
                    }
                    fbVar = a(i);
                }
            }
            return fbVar;
        }
        return (fb) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m327a(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || i <= 0) {
            return;
        }
        int i2 = i * 1000;
        if (i2 > 604800000) {
            i2 = 604800000;
        }
        if (this.a == i2 && this.f360a) {
            return;
        }
        this.f360a = true;
        this.f356a = System.currentTimeMillis();
        this.a = i2;
        com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f356a);
    }

    public synchronized void a(fa faVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, faVar) == null) {
            synchronized (this) {
                this.f357a.a(faVar);
            }
        }
    }

    public synchronized void a(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xMPushService) == null) {
            synchronized (this) {
                this.f358a = new fg(xMPushService);
                this.f359a = "";
                com.xiaomi.push.service.bv.a().a(new fi(this));
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m328a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f360a : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            m324a();
            return this.f360a && this.f357a.m195a() > 0;
        }
        return invokeV.booleanValue;
    }
}
