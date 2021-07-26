package com.kwai.filedownloader.services;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import com.kwai.filedownloader.x;
import java.util.List;
/* loaded from: classes6.dex */
public class g implements x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwai.filedownloader.b.a f37137a;

    /* renamed from: b  reason: collision with root package name */
    public final h f37138b;

    public g() {
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
        com.kwai.filedownloader.download.b a2 = com.kwai.filedownloader.download.b.a();
        this.f37137a = a2.c();
        this.f37138b = new h(a2.d());
    }

    @Override // com.kwai.filedownloader.x
    public int a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) ? this.f37138b.a(str, i2) : invokeLI.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            List<Integer> b2 = this.f37138b.b();
            if (com.kwai.filedownloader.f.d.f37034a) {
                com.kwai.filedownloader.f.d.c(this, "pause all tasks %d", Integer.valueOf(b2.size()));
            }
            for (Integer num : b2) {
                b(num.intValue());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0184 A[Catch: all -> 0x01cf, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0014, B:9:0x0026, B:12:0x0035, B:14:0x0045, B:16:0x004f, B:18:0x0053, B:19:0x0066, B:23:0x0073, B:25:0x0079, B:27:0x007d, B:31:0x008e, B:33:0x0097, B:35:0x00a0, B:37:0x00a4, B:42:0x00b7, B:45:0x00c0, B:47:0x00c9, B:49:0x00d8, B:51:0x00dc, B:53:0x00ed, B:57:0x00fb, B:59:0x0102, B:61:0x0109, B:63:0x010f, B:65:0x0116, B:67:0x011c, B:69:0x0122, B:71:0x013c, B:72:0x0140, B:74:0x0146, B:83:0x0184, B:84:0x0189, B:75:0x0155, B:77:0x015f, B:79:0x0165, B:80:0x016a, B:46:0x00c5, B:32:0x0093), top: B:93:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        com.kwai.filedownloader.d.c cVar;
        List<com.kwai.filedownloader.d.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), bVar, Boolean.valueOf(z3)}) == null) {
            synchronized (this) {
                boolean z4 = false;
                if (com.kwai.filedownloader.f.d.f37034a) {
                    com.kwai.filedownloader.f.d.c(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z));
                }
                int a2 = com.kwai.filedownloader.f.f.a(str, str2, z);
                com.kwai.filedownloader.d.c b2 = this.f37137a.b(a2);
                if (z || b2 != null) {
                    cVar = b2;
                    list = null;
                } else {
                    int a3 = com.kwai.filedownloader.f.f.a(str, com.kwai.filedownloader.f.f.h(str2), true);
                    com.kwai.filedownloader.d.c b3 = this.f37137a.b(a3);
                    if (b3 == null || !str2.equals(b3.d())) {
                        list = null;
                    } else {
                        if (com.kwai.filedownloader.f.d.f37034a) {
                            com.kwai.filedownloader.f.d.c(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(a2), Integer.valueOf(a3));
                        }
                        list = this.f37137a.c(a3);
                    }
                    cVar = b3;
                }
                if (com.kwai.filedownloader.f.c.a(a2, cVar, (x) this, true)) {
                    if (com.kwai.filedownloader.f.d.f37034a) {
                        com.kwai.filedownloader.f.d.c(this, "has already started download %d", Integer.valueOf(a2));
                    }
                    return;
                }
                String d2 = cVar != null ? cVar.d() : com.kwai.filedownloader.f.f.a(str2, z, (String) null);
                if (com.kwai.filedownloader.f.c.a(a2, d2, z2, true)) {
                    if (com.kwai.filedownloader.f.d.f37034a) {
                        com.kwai.filedownloader.f.d.c(this, "has already completed downloading %d", Integer.valueOf(a2));
                    }
                    return;
                }
                if (com.kwai.filedownloader.f.c.a(a2, cVar != null ? cVar.g() : 0L, cVar != null ? cVar.e() : com.kwai.filedownloader.f.f.d(d2), d2, this)) {
                    if (com.kwai.filedownloader.f.d.f37034a) {
                        com.kwai.filedownloader.f.d.c(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(a2), d2);
                        if (cVar != null) {
                            this.f37137a.e(a2);
                            this.f37137a.d(a2);
                        }
                    }
                    return;
                }
                if (cVar == null || !(cVar.f() == -2 || cVar.f() == -1 || cVar.f() == 1 || cVar.f() == 6 || cVar.f() == 2)) {
                    if (cVar == null) {
                        cVar = new com.kwai.filedownloader.d.c();
                    }
                    cVar.a(str);
                    cVar.a(str2, z);
                    cVar.a(a2);
                    cVar.a(0L);
                    cVar.c(0L);
                    cVar.a((byte) 1);
                    cVar.b(1);
                } else if (cVar.a() == a2) {
                    if (!TextUtils.equals(str, cVar.b())) {
                        cVar.a(str);
                    }
                    if (z4) {
                        this.f37137a.a(cVar);
                    }
                    this.f37138b.a(new DownloadLaunchRunnable.a().a(cVar).a(bVar).a(this).a(Integer.valueOf(i3)).b(Integer.valueOf(i2)).a(Boolean.valueOf(z2)).b(Boolean.valueOf(z3)).c(Integer.valueOf(i4)).a());
                } else {
                    this.f37137a.e(cVar.a());
                    this.f37137a.d(cVar.a());
                    cVar.a(a2);
                    cVar.a(str2, z);
                    if (list != null) {
                        for (com.kwai.filedownloader.d.a aVar : list) {
                            aVar.a(a2);
                            this.f37137a.a(aVar);
                        }
                    }
                }
                z4 = true;
                if (z4) {
                }
                this.f37138b.a(new DownloadLaunchRunnable.a().a(cVar).a(bVar).a(this).a(Integer.valueOf(i3)).b(Integer.valueOf(i2)).a(Boolean.valueOf(z2)).b(Boolean.valueOf(z3)).c(Integer.valueOf(i4)).a());
            }
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? a(this.f37137a.b(i2)) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.x
    public boolean a(com.kwai.filedownloader.d.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            boolean c2 = this.f37138b.c(cVar.a());
            if (com.kwai.filedownloader.d.d.a(cVar.f())) {
                if (!c2) {
                    return false;
                }
            } else if (!c2) {
                com.kwai.filedownloader.f.d.a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.a()), Byte.valueOf(cVar.f()));
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) ? a(com.kwai.filedownloader.f.f.b(str, str2)) : invokeLL.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37138b.a() <= 0 : invokeV.booleanValue;
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (com.kwai.filedownloader.f.d.f37034a) {
                com.kwai.filedownloader.f.d.c(this, "request pause the task %d", Integer.valueOf(i2));
            }
            com.kwai.filedownloader.d.c b2 = this.f37137a.b(i2);
            if (b2 == null) {
                return false;
            }
            b2.a((byte) -2);
            this.f37138b.b(i2);
            return true;
        }
        return invokeI.booleanValue;
    }

    public long c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            com.kwai.filedownloader.d.c b2 = this.f37137a.b(i2);
            if (b2 == null) {
                return 0L;
            }
            int n = b2.n();
            if (n <= 1) {
                return b2.g();
            }
            List<com.kwai.filedownloader.d.a> c2 = this.f37137a.c(i2);
            if (c2 == null || c2.size() != n) {
                return 0L;
            }
            return com.kwai.filedownloader.d.a.a(c2);
        }
        return invokeI.longValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f37137a.a();
        }
    }

    public long d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            com.kwai.filedownloader.d.c b2 = this.f37137a.b(i2);
            if (b2 == null) {
                return 0L;
            }
            return b2.h();
        }
        return invokeI.longValue;
    }

    public byte e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            com.kwai.filedownloader.d.c b2 = this.f37137a.b(i2);
            if (b2 == null) {
                return (byte) 0;
            }
            return b2.f();
        }
        return invokeI.byteValue;
    }

    public synchronized boolean f(int i2) {
        InterceptResult invokeI;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            synchronized (this) {
                a2 = this.f37138b.a(i2);
            }
            return a2;
        }
        return invokeI.booleanValue;
    }

    public boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (i2 == 0) {
                com.kwai.filedownloader.f.d.d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i2));
                return false;
            } else if (a(i2)) {
                com.kwai.filedownloader.f.d.d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i2));
                return false;
            } else {
                this.f37137a.e(i2);
                this.f37137a.d(i2);
                return true;
            }
        }
        return invokeI.booleanValue;
    }
}
