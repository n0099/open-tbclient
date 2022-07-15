package com.kwai.filedownloader.download;

import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.download.ConnectTask;
import com.kwai.filedownloader.download.e;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.net.SocketException;
/* loaded from: classes5.dex */
public final class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final ConnectTask b;
    public final f c;
    public final String d;
    public final boolean e;
    public e f;
    public volatile boolean g;
    public final int h;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConnectTask.a a;
        public f b;
        public String c;
        public Boolean d;
        public Integer e;

        public a() {
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
            this.a = new ConnectTask.a();
        }

        public final a a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.a.a(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a a(com.kwai.filedownloader.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
                this.a.a(bVar);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(com.kwai.filedownloader.download.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.a.a(aVar);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
                this.b = fVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, num)) == null) {
                this.e = num;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.a.a(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.d = Boolean.valueOf(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.b == null || this.c == null || this.d == null || this.e == null) {
                    throw new IllegalArgumentException(com.kwai.filedownloader.e.f.a("%s %s %B", this.b, this.c, this.d));
                }
                ConnectTask a = this.a.a();
                return new c(a.a, this.e.intValue(), a, this.b, this.d.booleanValue(), this.c, (byte) 0);
            }
            return (c) invokeV.objValue;
        }

        public final a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.a.b(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), connectTask, fVar, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = i;
        this.a = i2;
        this.g = false;
        this.c = fVar;
        this.d = str;
        this.b = connectTask;
        this.e = z;
    }

    public /* synthetic */ c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str, byte b) {
        this(i, i2, connectTask, fVar, z, str);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = true;
            e eVar = this.f;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Process.setThreadPriority(10);
            long j = this.b.e().b;
            com.kwai.filedownloader.kwai.b bVar = null;
            boolean z2 = false;
            while (!this.g) {
                try {
                    try {
                        bVar = this.b.a();
                        int e2 = bVar.e();
                        if (com.kwai.filedownloader.e.d.a) {
                            com.kwai.filedownloader.e.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.a), Integer.valueOf(this.h), this.b.e(), Integer.valueOf(e2));
                        }
                        if (e2 != 206 && e2 != 200) {
                            throw new SocketException(com.kwai.filedownloader.e.f.a("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.b.d(), bVar.c(), Integer.valueOf(e2), Integer.valueOf(this.h), Integer.valueOf(this.a)));
                            break;
                        }
                    } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e3) {
                        e = e3;
                        z = false;
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e4) {
                    z = z2;
                    e = e4;
                }
                try {
                    e.a aVar = new e.a();
                    if (this.g) {
                        if (bVar != null) {
                            bVar.f();
                            return;
                        }
                        return;
                    }
                    e a2 = aVar.b(this.h).a(this.a).a(this.c).a(this).a(this.e).a(bVar).a(this.b.e()).a(this.d).a();
                    this.f = a2;
                    a2.b();
                    if (this.g) {
                        this.f.a();
                    }
                    if (bVar != null) {
                        return;
                    }
                    return;
                } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e5) {
                    e = e5;
                    z = true;
                    try {
                        if (!this.c.a(e)) {
                            this.c.b(e);
                            if (bVar != null) {
                                bVar.f();
                                return;
                            }
                            return;
                        }
                        if (!z) {
                            this.c.a(e, 0L);
                        } else if (this.f == null) {
                            com.kwai.filedownloader.e.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                            this.c.b(e);
                            if (bVar != null) {
                                bVar.f();
                                return;
                            }
                            return;
                        } else {
                            this.c.a(e, this.f.a - j);
                        }
                        if (bVar != null) {
                            bVar.f();
                        }
                        z2 = z;
                    } finally {
                        if (bVar != null) {
                            bVar.f();
                        }
                    }
                }
            }
            if (bVar != null) {
                bVar.f();
            }
        }
    }
}
