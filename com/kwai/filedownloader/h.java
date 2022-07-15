package com.kwai.filedownloader;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<a.InterfaceC0555a> a;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final h a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1185601933, "Lcom/kwai/filedownloader/h$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1185601933, "Lcom/kwai/filedownloader/h$a;");
                    return;
                }
            }
            a = new h((byte) 0);
        }
    }

    public h() {
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
        this.a = new ArrayList<>();
    }

    public /* synthetic */ h(byte b) {
        this();
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (h) invokeV.objValue;
    }

    public final int a(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            synchronized (this.a) {
                Iterator<a.InterfaceC0555a> it = this.a.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    if (it.next().b(i)) {
                        i2++;
                    }
                }
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public final void a(List<a.InterfaceC0555a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this.a) {
                Iterator<a.InterfaceC0555a> it = this.a.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0555a next = it.next();
                    if (!list.contains(next)) {
                        list.add(next);
                    }
                }
                this.a.clear();
            }
        }
    }

    public final boolean a(a.InterfaceC0555a interfaceC0555a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0555a)) == null) ? this.a.isEmpty() || !this.a.contains(interfaceC0555a) : invokeL.booleanValue;
    }

    public final boolean a(a.InterfaceC0555a interfaceC0555a, MessageSnapshot messageSnapshot) {
        InterceptResult invokeLL;
        boolean remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, interfaceC0555a, messageSnapshot)) == null) {
            byte b = messageSnapshot.b();
            synchronized (this.a) {
                remove = this.a.remove(interfaceC0555a);
            }
            if (com.kwai.filedownloader.e.d.a && this.a.size() == 0) {
                com.kwai.filedownloader.e.d.e(this, "remove %s left %d %d", interfaceC0555a, Byte.valueOf(b), Integer.valueOf(this.a.size()));
            }
            if (remove) {
                t c = interfaceC0555a.G().c();
                if (b == -4) {
                    c.g(messageSnapshot);
                } else if (b == -3) {
                    c.e(com.kwai.filedownloader.message.f.a(messageSnapshot));
                } else if (b == -2) {
                    c.i(messageSnapshot);
                } else if (b == -1) {
                    c.h(messageSnapshot);
                }
            } else {
                com.kwai.filedownloader.e.d.a(this, "remove error, not exist: %s %d", interfaceC0555a, Byte.valueOf(b));
            }
            return remove;
        }
        return invokeLL.booleanValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    public final List<a.InterfaceC0555a> b(int i) {
        InterceptResult invokeI;
        byte v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.a) {
                Iterator<a.InterfaceC0555a> it = this.a.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0555a next = it.next();
                    if (next.b(i) && !next.H() && (v = next.F().v()) != 0 && v != 10) {
                        arrayList.add(next);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final void b(a.InterfaceC0555a interfaceC0555a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0555a) == null) {
            if (!interfaceC0555a.F().d()) {
                interfaceC0555a.J();
            }
            if (interfaceC0555a.G().c().a()) {
                c(interfaceC0555a);
            }
        }
    }

    public final List<a.InterfaceC0555a> c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.a) {
                Iterator<a.InterfaceC0555a> it = this.a.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0555a next = it.next();
                    if (next.b(i) && !next.H()) {
                        arrayList.add(next);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final void c(a.InterfaceC0555a interfaceC0555a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interfaceC0555a) == null) || interfaceC0555a.K()) {
            return;
        }
        synchronized (this.a) {
            if (this.a.contains(interfaceC0555a)) {
                com.kwai.filedownloader.e.d.d(this, "already has %s", interfaceC0555a);
            } else {
                interfaceC0555a.L();
                this.a.add(interfaceC0555a);
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.e(this, "add list in all %s %d %d", interfaceC0555a, Byte.valueOf(interfaceC0555a.F().v()), Integer.valueOf(this.a.size()));
                }
            }
        }
    }
}
