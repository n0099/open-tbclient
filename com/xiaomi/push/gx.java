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
import com.xiaomi.push.bi;
import com.xiaomi.push.jh;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/* loaded from: classes8.dex */
public class gx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f442a;

    /* renamed from: a  reason: collision with other field name */
    public bi f443a;

    /* renamed from: a  reason: collision with other field name */
    public gw f444a;

    /* renamed from: a  reason: collision with other field name */
    public String f445a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f446a;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final gx a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1659725138, "Lcom/xiaomi/push/gx$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1659725138, "Lcom/xiaomi/push/gx$a;");
                    return;
                }
            }
            a = new gx();
        }
    }

    public gx() {
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
        this.f446a = false;
        this.f443a = bi.a();
    }

    private ex a(bi.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, aVar)) == null) {
            if (aVar.f134a == 0) {
                Object obj = aVar.f135a;
                if (obj instanceof ex) {
                    return (ex) obj;
                }
                return null;
            }
            ex m403a = m403a();
            m403a.a(ew.k.a());
            m403a.c(aVar.f134a);
            m403a.c(aVar.f136a);
            return m403a;
        }
        return (ex) invokeL.objValue;
    }

    private ey a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            ey eyVar = new ey(this.f445a, arrayList);
            if (!bg.e(this.f444a.f439a)) {
                eyVar.a(i.m(this.f444a.f439a));
            }
            jj jjVar = new jj(i);
            jb a2 = new jh.a().a(jjVar);
            try {
                eyVar.b(a2);
            } catch (iv unused) {
            }
            LinkedList<bi.a> m217a = this.f443a.m217a();
            while (m217a.size() > 0) {
                try {
                    ex a3 = a(m217a.getLast());
                    if (a3 != null) {
                        a3.b(a2);
                    }
                    if (jjVar.a_() > i) {
                        break;
                    }
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                    m217a.removeLast();
                } catch (iv | NoSuchElementException unused2) {
                }
            }
            return eyVar;
        }
        return (ey) invokeI.objValue;
    }

    public static gw a() {
        InterceptResult invokeV;
        gw gwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (a.a) {
                gwVar = a.a.f444a;
            }
            return gwVar;
        }
        return (gw) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gx m401a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.a : (gx) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m402a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.f446a && System.currentTimeMillis() - this.f442a > this.a) {
            this.f446a = false;
            this.f442a = 0L;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ex m403a() {
        InterceptResult invokeV;
        ex exVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                exVar = new ex();
                exVar.a(bg.m210a((Context) this.f444a.f439a));
                exVar.f325a = (byte) 0;
                exVar.f329b = 1;
                exVar.d((int) (System.currentTimeMillis() / 1000));
            }
            return exVar;
        }
        return (ex) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ey m404a() {
        InterceptResult invokeV;
        ey eyVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                eyVar = null;
                if (b()) {
                    int i = PassBiometricUtil.k;
                    if (!bg.e(this.f444a.f439a)) {
                        i = 375;
                    }
                    eyVar = a(i);
                }
            }
            return eyVar;
        }
        return (ey) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m405a(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || i <= 0) {
            return;
        }
        int i2 = i * 1000;
        if (i2 > 604800000) {
            i2 = 604800000;
        }
        if (this.a == i2 && this.f446a) {
            return;
        }
        this.f446a = true;
        this.f442a = System.currentTimeMillis();
        this.a = i2;
        com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f442a);
    }

    public synchronized void a(ex exVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, exVar) == null) {
            synchronized (this) {
                this.f443a.a(exVar);
            }
        }
    }

    public synchronized void a(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xMPushService) == null) {
            synchronized (this) {
                this.f444a = new gw(xMPushService);
                this.f445a = "";
                com.xiaomi.push.service.bi.a().a(new gy(this));
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m406a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f446a : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            m402a();
            return this.f446a && this.f443a.m216a() > 0;
        }
        return invokeV.booleanValue;
    }
}
