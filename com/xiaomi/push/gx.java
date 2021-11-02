package com.xiaomi.push;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes2.dex */
public class gx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f71060a;

    /* renamed from: a  reason: collision with other field name */
    public long f466a;

    /* renamed from: a  reason: collision with other field name */
    public bi f467a;

    /* renamed from: a  reason: collision with other field name */
    public gw f468a;

    /* renamed from: a  reason: collision with other field name */
    public String f469a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f470a;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final gx f71061a;
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
            f71061a = new gx();
        }
    }

    public gx() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f470a = false;
        this.f467a = bi.a();
    }

    private ex a(bi.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, aVar)) == null) {
            if (aVar.f158a == 0) {
                Object obj = aVar.f159a;
                if (obj instanceof ex) {
                    return (ex) obj;
                }
                return null;
            }
            ex m368a = m368a();
            m368a.a(ew.k.a());
            m368a.c(aVar.f158a);
            m368a.c(aVar.f160a);
            return m368a;
        }
        return (ex) invokeL.objValue;
    }

    private ey a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            ey eyVar = new ey(this.f469a, arrayList);
            if (!bg.e(this.f468a.f463a)) {
                eyVar.a(i.m(this.f468a.f463a));
            }
            jj jjVar = new jj(i2);
            jb a2 = new jh.a().a(jjVar);
            try {
                eyVar.b(a2);
            } catch (iv unused) {
            }
            LinkedList<bi.a> m182a = this.f467a.m182a();
            while (m182a.size() > 0) {
                try {
                    ex a3 = a(m182a.getLast());
                    if (a3 != null) {
                        a3.b(a2);
                    }
                    if (jjVar.a_() > i2) {
                        break;
                    }
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                    m182a.removeLast();
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
            synchronized (a.f71061a) {
                gwVar = a.f71061a.f468a;
            }
            return gwVar;
        }
        return (gw) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gx m366a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.f71061a : (gx) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m367a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && this.f470a && System.currentTimeMillis() - this.f466a > this.f71060a) {
            this.f470a = false;
            this.f466a = 0L;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ex m368a() {
        InterceptResult invokeV;
        ex exVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                exVar = new ex();
                exVar.a(bg.m175a((Context) this.f468a.f463a));
                exVar.f349a = (byte) 0;
                exVar.f353b = 1;
                exVar.d((int) (System.currentTimeMillis() / 1000));
            }
            return exVar;
        }
        return (ex) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ey m369a() {
        InterceptResult invokeV;
        ey eyVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                eyVar = null;
                if (b()) {
                    eyVar = a(bg.e(this.f468a.f463a) ? 750 : 375);
                }
            }
            return eyVar;
        }
        return (ey) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m370a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 <= 0) {
            return;
        }
        int i3 = i2 * 1000;
        if (i3 > 604800000) {
            i3 = 604800000;
        }
        if (this.f71060a == i3 && this.f470a) {
            return;
        }
        this.f470a = true;
        this.f466a = System.currentTimeMillis();
        this.f71060a = i3;
        com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i3 + " start = " + this.f466a);
    }

    public synchronized void a(ex exVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, exVar) == null) {
            synchronized (this) {
                this.f467a.a(exVar);
            }
        }
    }

    public synchronized void a(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xMPushService) == null) {
            synchronized (this) {
                this.f468a = new gw(xMPushService);
                this.f469a = "";
                com.xiaomi.push.service.bi.a().a(new gy(this));
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m371a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f470a : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            m367a();
            return this.f470a && this.f467a.m181a() > 0;
        }
        return invokeV.booleanValue;
    }
}
