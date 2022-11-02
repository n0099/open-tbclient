package com.kwai.filedownloader.download;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.a.a;
import com.kwai.filedownloader.e.c;
import com.kwai.filedownloader.kwai.c;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwai.filedownloader.services.c aut;
    public c.a auu;
    public c.b auv;
    public c.e auw;
    public volatile com.kwai.filedownloader.a.a aux;
    public c.d auy;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final b auz;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-410946426, "Lcom/kwai/filedownloader/download/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-410946426, "Lcom/kwai/filedownloader/download/b$a;");
                    return;
                }
            }
            auz = new b();
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static b Dp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.auz : (b) invokeV.objValue;
    }

    private c.a Du() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            c.a aVar = this.auu;
            if (aVar != null) {
                return aVar;
            }
            synchronized (this) {
                if (this.auu == null) {
                    this.auu = Dx().Eu();
                }
            }
            return this.auu;
        }
        return (c.a) invokeV.objValue;
    }

    private c.b Dv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            c.b bVar = this.auv;
            if (bVar != null) {
                return bVar;
            }
            synchronized (this) {
                if (this.auv == null) {
                    this.auv = Dx().Et();
                }
            }
            return this.auv;
        }
        return (c.b) invokeV.objValue;
    }

    private c.e Dw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            c.e eVar = this.auw;
            if (eVar != null) {
                return eVar;
            }
            synchronized (this) {
                if (this.auw == null) {
                    this.auw = Dx().Es();
                }
            }
            return this.auw;
        }
        return (c.e) invokeV.objValue;
    }

    private com.kwai.filedownloader.services.c Dx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            com.kwai.filedownloader.services.c cVar = this.aut;
            if (cVar != null) {
                return cVar;
            }
            synchronized (this) {
                if (this.aut == null) {
                    this.aut = new com.kwai.filedownloader.services.c();
                }
            }
            return this.aut;
        }
        return (com.kwai.filedownloader.services.c) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
        if (r8.Em() <= 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d8, code lost:
        if (r8.Em() > 0) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0069 A[Catch: all -> 0x0147, TryCatch #2 {all -> 0x0147, blocks: (B:11:0x0038, B:13:0x003f, B:15:0x0046, B:17:0x004d, B:20:0x005a, B:23:0x0069, B:25:0x0074, B:19:0x0057), top: B:89:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0 A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:57:0x00f5, B:58:0x0101, B:60:0x0117, B:62:0x011b, B:63:0x0133, B:64:0x013a, B:37:0x00a7, B:42:0x00c9, B:44:0x00d0, B:48:0x00de, B:51:0x00e9), top: B:87:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0101 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(a.InterfaceC0629a interfaceC0629a) {
        long j;
        long j2;
        String targetFilePath;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, interfaceC0629a) == null) {
            String str = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d";
            Iterator<com.kwai.filedownloader.c.c> it = interfaceC0629a.iterator();
            c.d Dq = Dp().Dq();
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = 0;
            long j4 = 0;
            long j5 = 0;
            while (it.hasNext()) {
                try {
                    com.kwai.filedownloader.c.c next = it.next();
                    String str2 = str;
                    if (next.Ca() != 3) {
                        try {
                            if (next.Ca() != 2) {
                                if (next.Ca() != -1) {
                                    if (next.Ca() == 1) {
                                    }
                                    targetFilePath = next.getTargetFilePath();
                                    if (targetFilePath != null) {
                                        j = currentTimeMillis;
                                        j2 = j3;
                                        z = true;
                                    } else {
                                        File file = new File(targetFilePath);
                                        if (next.Ca() == -2) {
                                            j = currentTimeMillis;
                                            try {
                                                if (com.kwai.filedownloader.e.f.a(next.getId(), next, next.getPath(), null)) {
                                                    File file2 = new File(next.DE());
                                                    if (!file2.exists() && file.exists()) {
                                                        boolean renameTo = file.renameTo(file2);
                                                        if (com.kwai.filedownloader.e.d.awL) {
                                                            j2 = j3;
                                                            com.kwai.filedownloader.e.d.e(com.kwai.filedownloader.a.a.class, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", Boolean.valueOf(renameTo), file.getPath(), file2.getPath());
                                                            if (next.Ca() != 1) {
                                                            }
                                                            if (com.kwai.filedownloader.e.f.b(next.getId(), next) && !file.exists()) {
                                                                z = false;
                                                            }
                                                            z = true;
                                                        }
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                j2 = j3;
                                                str = str2;
                                                com.kwai.filedownloader.e.f.dF(com.kwai.filedownloader.e.c.EJ());
                                                interfaceC0629a.Di();
                                                if (com.kwai.filedownloader.e.d.awL) {
                                                    com.kwai.filedownloader.e.d.e(com.kwai.filedownloader.a.a.class, str, Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j));
                                                }
                                                throw th;
                                            }
                                        } else {
                                            j = currentTimeMillis;
                                        }
                                        j2 = j3;
                                        if (next.Ca() != 1) {
                                        }
                                        if (com.kwai.filedownloader.e.f.b(next.getId(), next)) {
                                            z = false;
                                        }
                                        z = true;
                                    }
                                    if (z) {
                                        int id = next.getId();
                                        int j6 = Dq.j(next.getUrl(), next.getPath(), next.BW());
                                        if (j6 != id) {
                                            if (com.kwai.filedownloader.e.d.awL) {
                                                com.kwai.filedownloader.e.d.e(com.kwai.filedownloader.a.a.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(id), Integer.valueOf(j6));
                                            }
                                            next.setId(j6);
                                            interfaceC0629a.a(id, next);
                                            j5++;
                                        }
                                        interfaceC0629a.c(next);
                                        j3 = j2 + 1;
                                        str = str2;
                                        currentTimeMillis = j;
                                    } else {
                                        try {
                                            it.remove();
                                            j4++;
                                            str = str2;
                                            currentTimeMillis = j;
                                            j3 = j2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            str = str2;
                                            com.kwai.filedownloader.e.f.dF(com.kwai.filedownloader.e.c.EJ());
                                            interfaceC0629a.Di();
                                            if (com.kwai.filedownloader.e.d.awL) {
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            j = currentTimeMillis;
                            j2 = j3;
                            str = str2;
                            com.kwai.filedownloader.e.f.dF(com.kwai.filedownloader.e.c.EJ());
                            interfaceC0629a.Di();
                            if (com.kwai.filedownloader.e.d.awL) {
                            }
                            throw th;
                        }
                    }
                    next.e((byte) -2);
                    targetFilePath = next.getTargetFilePath();
                    if (targetFilePath != null) {
                    }
                    if (z) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    j = currentTimeMillis;
                    j2 = j3;
                }
            }
            String str3 = str;
            long j7 = currentTimeMillis;
            long j8 = j3;
            com.kwai.filedownloader.e.f.dF(com.kwai.filedownloader.e.c.EJ());
            interfaceC0629a.Di();
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(com.kwai.filedownloader.a.a.class, str3, Long.valueOf(j8), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j7));
            }
        }
    }

    public final c.d Dq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.d dVar = this.auy;
            if (dVar != null) {
                return dVar;
            }
            synchronized (this) {
                if (this.auy == null) {
                    this.auy = Dx().Ev();
                }
            }
            return this.auy;
        }
        return (c.d) invokeV.objValue;
    }

    public final synchronized com.kwai.filedownloader.a.a Dr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (this.aux != null) {
                    return this.aux;
                }
                this.aux = Dx().Er();
                a(this.aux.Dh());
                return this.aux;
            }
        }
        return (com.kwai.filedownloader.a.a) invokeV.objValue;
    }

    public final int Ds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Dx().Ds() : invokeV.intValue;
    }

    public final boolean Dt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Dw();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final int a(int i, String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j)})) == null) ? Du().V(j) : invokeCommon.intValue;
    }

    public final void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            synchronized (this) {
                this.aut = new com.kwai.filedownloader.services.c(aVar);
                this.auv = null;
                this.auw = null;
                this.aux = null;
                this.auy = null;
            }
        }
    }

    public final com.kwai.filedownloader.d.a ad(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, file)) == null) ? Dw().ae(file) : (com.kwai.filedownloader.d.a) invokeL.objValue;
    }

    public final void b(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            synchronized (this) {
                this.aut = new com.kwai.filedownloader.services.c(aVar);
            }
        }
    }

    public final com.kwai.filedownloader.kwai.b et(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            try {
                return Dv().r(str);
            } catch (Throwable unused) {
                c.b bVar = new c.b();
                this.auv = bVar;
                return bVar.r(str);
            }
        }
        return (com.kwai.filedownloader.kwai.b) invokeL.objValue;
    }
}
