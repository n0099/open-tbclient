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
/* loaded from: classes10.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<a.InterfaceC0697a> atd;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final h ate;
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
            ate = new h((byte) 0);
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
        this.atd = new ArrayList<>();
    }

    public /* synthetic */ h(byte b) {
        this();
    }

    public static h CG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.ate : (h) invokeV.objValue;
    }

    public final void D(List<a.InterfaceC0697a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            synchronized (this.atd) {
                Iterator<a.InterfaceC0697a> it = this.atd.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0697a next = it.next();
                    if (!list.contains(next)) {
                        list.add(next);
                    }
                }
                this.atd.clear();
            }
        }
    }

    public final boolean a(a.InterfaceC0697a interfaceC0697a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0697a)) == null) ? this.atd.isEmpty() || !this.atd.contains(interfaceC0697a) : invokeL.booleanValue;
    }

    public final boolean a(a.InterfaceC0697a interfaceC0697a, MessageSnapshot messageSnapshot) {
        InterceptResult invokeLL;
        boolean remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0697a, messageSnapshot)) == null) {
            byte Ca = messageSnapshot.Ca();
            synchronized (this.atd) {
                remove = this.atd.remove(interfaceC0697a);
            }
            if (com.kwai.filedownloader.e.d.awL && this.atd.size() == 0) {
                com.kwai.filedownloader.e.d.g(this, "remove %s left %d %d", interfaceC0697a, Byte.valueOf(Ca), Integer.valueOf(this.atd.size()));
            }
            if (remove) {
                t Cy = interfaceC0697a.Cj().Cy();
                if (Ca == -4) {
                    Cy.l(messageSnapshot);
                } else if (Ca == -3) {
                    Cy.j(com.kwai.filedownloader.message.f.t(messageSnapshot));
                } else if (Ca == -2) {
                    Cy.n(messageSnapshot);
                } else if (Ca == -1) {
                    Cy.m(messageSnapshot);
                }
            } else {
                com.kwai.filedownloader.e.d.c(this, "remove error, not exist: %s %d", interfaceC0697a, Byte.valueOf(Ca));
            }
            return remove;
        }
        return invokeLL.booleanValue;
    }

    public final void b(a.InterfaceC0697a interfaceC0697a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0697a) == null) {
            if (!interfaceC0697a.Ci().BT()) {
                interfaceC0697a.Cl();
            }
            if (interfaceC0697a.Cj().Cy().CL()) {
                c(interfaceC0697a);
            }
        }
    }

    public final int bS(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            synchronized (this.atd) {
                Iterator<a.InterfaceC0697a> it = this.atd.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    if (it.next().bR(i)) {
                        i2++;
                    }
                }
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public final List<a.InterfaceC0697a> bT(int i) {
        InterceptResult invokeI;
        byte Ca;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.atd) {
                Iterator<a.InterfaceC0697a> it = this.atd.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0697a next = it.next();
                    if (next.bR(i) && !next.isOver() && (Ca = next.Ci().Ca()) != 0 && Ca != 10) {
                        arrayList.add(next);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final List<a.InterfaceC0697a> bU(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.atd) {
                Iterator<a.InterfaceC0697a> it = this.atd.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0697a next = it.next();
                    if (next.bR(i) && !next.isOver()) {
                        arrayList.add(next);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final void c(a.InterfaceC0697a interfaceC0697a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, interfaceC0697a) == null) || interfaceC0697a.Cm()) {
            return;
        }
        synchronized (this.atd) {
            if (this.atd.contains(interfaceC0697a)) {
                com.kwai.filedownloader.e.d.f(this, "already has %s", interfaceC0697a);
            } else {
                interfaceC0697a.Cn();
                this.atd.add(interfaceC0697a);
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.g(this, "add list in all %s %d %d", interfaceC0697a, Byte.valueOf(interfaceC0697a.Ci().Ca()), Integer.valueOf(this.atd.size()));
                }
            }
        }
    }

    public final int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.atd.size() : invokeV.intValue;
    }
}
