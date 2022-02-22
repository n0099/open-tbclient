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
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<a.b> a;

    /* renamed from: com.kwai.filedownloader.h$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
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
            a = new h(null);
        }
    }

    public h() {
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
        this.a = new ArrayList<>();
    }

    public /* synthetic */ h(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (h) invokeV.objValue;
    }

    public int a(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            synchronized (this.a) {
                Iterator<a.b> it = this.a.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    if (it.next().b(i2)) {
                        i3++;
                    }
                }
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public void a(List<a.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this.a) {
                Iterator<a.b> it = this.a.iterator();
                while (it.hasNext()) {
                    a.b next = it.next();
                    if (!list.contains(next)) {
                        list.add(next);
                    }
                }
                this.a.clear();
            }
        }
    }

    public boolean a(a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) ? this.a.isEmpty() || !this.a.contains(bVar) : invokeL.booleanValue;
    }

    public boolean a(a.b bVar, MessageSnapshot messageSnapshot) {
        InterceptResult invokeLL;
        boolean remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, messageSnapshot)) == null) {
            byte b2 = messageSnapshot.b();
            synchronized (this.a) {
                remove = this.a.remove(bVar);
            }
            if (com.kwai.filedownloader.e.d.a && this.a.size() == 0) {
                com.kwai.filedownloader.e.d.e(this, "remove %s left %d %d", bVar, Byte.valueOf(b2), Integer.valueOf(this.a.size()));
            }
            if (remove) {
                t d2 = bVar.G().d();
                if (b2 == -4) {
                    d2.g(messageSnapshot);
                } else if (b2 == -3) {
                    d2.e(com.kwai.filedownloader.message.f.a(messageSnapshot));
                } else if (b2 == -2) {
                    d2.i(messageSnapshot);
                } else if (b2 == -1) {
                    d2.h(messageSnapshot);
                }
            } else {
                com.kwai.filedownloader.e.d.a(this, "remove error, not exist: %s %d", bVar, Byte.valueOf(b2));
            }
            return remove;
        }
        return invokeLL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    public List<a.b> b(int i2) {
        InterceptResult invokeI;
        byte v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.a) {
                Iterator<a.b> it = this.a.iterator();
                while (it.hasNext()) {
                    a.b next = it.next();
                    if (next.b(i2) && !next.H() && (v = next.F().v()) != 0 && v != 10) {
                        arrayList.add(next);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public void b(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            if (!bVar.F().d()) {
                bVar.J();
            }
            if (bVar.G().d().a()) {
                c(bVar);
            }
        }
    }

    public List<a.b> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.a) {
                Iterator<a.b> it = this.a.iterator();
                while (it.hasNext()) {
                    a.b next = it.next();
                    if (next.b(i2) && !next.H()) {
                        arrayList.add(next);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public void c(a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar.K()) {
            return;
        }
        synchronized (this.a) {
            if (this.a.contains(bVar)) {
                com.kwai.filedownloader.e.d.d(this, "already has %s", bVar);
            } else {
                bVar.L();
                this.a.add(bVar);
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.e(this, "add list in all %s %d %d", bVar, Byte.valueOf(bVar.F().v()), Integer.valueOf(this.a.size()));
                }
            }
        }
    }
}
