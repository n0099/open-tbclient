package com.kwai.filedownloader.download;

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
import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.f.c;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwai.filedownloader.services.c f36778a;

    /* renamed from: b  reason: collision with root package name */
    public c.a f36779b;

    /* renamed from: c  reason: collision with root package name */
    public c.b f36780c;

    /* renamed from: d  reason: collision with root package name */
    public c.e f36781d;

    /* renamed from: e  reason: collision with root package name */
    public volatile com.kwai.filedownloader.b.a f36782e;

    /* renamed from: f  reason: collision with root package name */
    public c.d f36783f;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f36784a;
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
            f36784a = new b();
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.f36784a : (b) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
        if (r8.g() <= 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d8, code lost:
        if (r8.g() > 0) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0069 A[Catch: all -> 0x0145, TryCatch #2 {all -> 0x0145, blocks: (B:11:0x0038, B:13:0x003f, B:15:0x0046, B:17:0x004d, B:20:0x005a, B:23:0x0069, B:25:0x0074, B:19:0x0057), top: B:90:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0 A[Catch: all -> 0x0143, TryCatch #1 {all -> 0x0143, blocks: (B:57:0x00f5, B:58:0x00ff, B:60:0x0115, B:62:0x0119, B:63:0x0131, B:64:0x0138, B:37:0x00a7, B:42:0x00c9, B:44:0x00d0, B:48:0x00de, B:51:0x00e9), top: B:88:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ff A[Catch: all -> 0x0143, TryCatch #1 {all -> 0x0143, blocks: (B:57:0x00f5, B:58:0x00ff, B:60:0x0115, B:62:0x0119, B:63:0x0131, B:64:0x0138, B:37:0x00a7, B:42:0x00c9, B:44:0x00d0, B:48:0x00de, B:51:0x00e9), top: B:88:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(a.InterfaceC0450a interfaceC0450a) {
        long j;
        long j2;
        String d2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, interfaceC0450a) == null) {
            String str = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d";
            Iterator<com.kwai.filedownloader.d.c> it = interfaceC0450a.iterator();
            c.d b2 = a().b();
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = 0;
            long j4 = 0;
            long j5 = 0;
            while (it.hasNext()) {
                try {
                    com.kwai.filedownloader.d.c next = it.next();
                    String str2 = str;
                    if (next.f() != 3) {
                        try {
                            if (next.f() != 2) {
                                if (next.f() != -1) {
                                    if (next.f() == 1) {
                                    }
                                    d2 = next.d();
                                    if (d2 != null) {
                                        j = currentTimeMillis;
                                        j2 = j3;
                                        z = true;
                                    } else {
                                        File file = new File(d2);
                                        if (next.f() == -2) {
                                            j = currentTimeMillis;
                                            try {
                                                if (com.kwai.filedownloader.f.f.a(next.a(), next, next.c(), null)) {
                                                    File file2 = new File(next.e());
                                                    if (!file2.exists() && file.exists()) {
                                                        boolean renameTo = file.renameTo(file2);
                                                        if (com.kwai.filedownloader.f.d.f36845a) {
                                                            j2 = j3;
                                                            com.kwai.filedownloader.f.d.c(com.kwai.filedownloader.b.a.class, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", Boolean.valueOf(renameTo), file.getPath(), file2.getPath());
                                                            if (next.f() != 1) {
                                                            }
                                                            if (com.kwai.filedownloader.f.f.a(next.a(), next) && !file.exists()) {
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
                                                com.kwai.filedownloader.f.f.b(com.kwai.filedownloader.f.c.a());
                                                interfaceC0450a.a();
                                                if (com.kwai.filedownloader.f.d.f36845a) {
                                                    com.kwai.filedownloader.f.d.c(com.kwai.filedownloader.b.a.class, str, Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j));
                                                }
                                                throw th;
                                            }
                                        } else {
                                            j = currentTimeMillis;
                                        }
                                        j2 = j3;
                                        if (next.f() != 1) {
                                        }
                                        if (com.kwai.filedownloader.f.f.a(next.a(), next)) {
                                            z = false;
                                        }
                                        z = true;
                                    }
                                    if (z) {
                                        int a2 = next.a();
                                        int a3 = b2.a(a2, next.b(), next.c(), next.l());
                                        if (a3 != a2) {
                                            if (com.kwai.filedownloader.f.d.f36845a) {
                                                com.kwai.filedownloader.f.d.c(com.kwai.filedownloader.b.a.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(a2), Integer.valueOf(a3));
                                            }
                                            next.a(a3);
                                            interfaceC0450a.a(a2, next);
                                            j5++;
                                        }
                                        interfaceC0450a.b(next);
                                        j3 = j2 + 1;
                                    } else {
                                        try {
                                            it.remove();
                                            interfaceC0450a.a(next);
                                            j4++;
                                            j3 = j2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            str = str2;
                                            com.kwai.filedownloader.f.f.b(com.kwai.filedownloader.f.c.a());
                                            interfaceC0450a.a();
                                            if (com.kwai.filedownloader.f.d.f36845a) {
                                            }
                                            throw th;
                                        }
                                    }
                                    str = str2;
                                    currentTimeMillis = j;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            j = currentTimeMillis;
                            j2 = j3;
                            str = str2;
                            com.kwai.filedownloader.f.f.b(com.kwai.filedownloader.f.c.a());
                            interfaceC0450a.a();
                            if (com.kwai.filedownloader.f.d.f36845a) {
                            }
                            throw th;
                        }
                    }
                    next.a((byte) -2);
                    d2 = next.d();
                    if (d2 != null) {
                    }
                    if (z) {
                    }
                    str = str2;
                    currentTimeMillis = j;
                } catch (Throwable th4) {
                    th = th4;
                    j = currentTimeMillis;
                    j2 = j3;
                }
            }
            String str3 = str;
            long j6 = currentTimeMillis;
            long j7 = j3;
            com.kwai.filedownloader.f.f.b(com.kwai.filedownloader.f.c.a());
            interfaceC0450a.a();
            if (com.kwai.filedownloader.f.d.f36845a) {
                com.kwai.filedownloader.f.d.c(com.kwai.filedownloader.b.a.class, str3, Long.valueOf(j7), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j6));
            }
        }
    }

    private c.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            c.a aVar = this.f36779b;
            if (aVar != null) {
                return aVar;
            }
            synchronized (this) {
                if (this.f36779b == null) {
                    this.f36779b = i().e();
                }
            }
            return this.f36779b;
        }
        return (c.a) invokeV.objValue;
    }

    private c.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            c.b bVar = this.f36780c;
            if (bVar != null) {
                return bVar;
            }
            synchronized (this) {
                if (this.f36780c == null) {
                    this.f36780c = i().d();
                }
            }
            return this.f36780c;
        }
        return (c.b) invokeV.objValue;
    }

    private c.e h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            c.e eVar = this.f36781d;
            if (eVar != null) {
                return eVar;
            }
            synchronized (this) {
                if (this.f36781d == null) {
                    this.f36781d = i().c();
                }
            }
            return this.f36781d;
        }
        return (c.e) invokeV.objValue;
    }

    private com.kwai.filedownloader.services.c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            com.kwai.filedownloader.services.c cVar = this.f36778a;
            if (cVar != null) {
                return cVar;
            }
            synchronized (this) {
                if (this.f36778a == null) {
                    this.f36778a = new com.kwai.filedownloader.services.c();
                }
            }
            return this.f36778a;
        }
        return (com.kwai.filedownloader.services.c) invokeV.objValue;
    }

    public int a(int i2, String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j)})) == null) ? f().a(i2, str, str2, j) : invokeCommon.intValue;
    }

    public com.kwai.filedownloader.a.b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? g().a(str) : (com.kwai.filedownloader.a.b) invokeL.objValue;
    }

    public com.kwai.filedownloader.e.a a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) ? h().a(file) : (com.kwai.filedownloader.e.a) invokeL.objValue;
    }

    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this) {
                this.f36778a = new com.kwai.filedownloader.services.c(aVar);
                this.f36780c = null;
                this.f36781d = null;
                this.f36782e = null;
                this.f36783f = null;
            }
        }
    }

    public c.d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.d dVar = this.f36783f;
            if (dVar != null) {
                return dVar;
            }
            synchronized (this) {
                if (this.f36783f == null) {
                    this.f36783f = i().f();
                }
            }
            return this.f36783f;
        }
        return (c.d) invokeV.objValue;
    }

    public void b(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            synchronized (this) {
                this.f36778a = new com.kwai.filedownloader.services.c(aVar);
            }
        }
    }

    public synchronized com.kwai.filedownloader.b.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.f36782e != null) {
                    return this.f36782e;
                }
                this.f36782e = i().b();
                a(this.f36782e.b());
                return this.f36782e;
            }
        }
        return (com.kwai.filedownloader.b.a) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i().a() : invokeV.intValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? h().a() : invokeV.booleanValue;
    }
}
