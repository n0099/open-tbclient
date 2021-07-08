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
/* loaded from: classes6.dex */
public class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f36785a;

    /* renamed from: b  reason: collision with root package name */
    public final ConnectTask f36786b;

    /* renamed from: c  reason: collision with root package name */
    public final f f36787c;

    /* renamed from: d  reason: collision with root package name */
    public final String f36788d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f36789e;

    /* renamed from: f  reason: collision with root package name */
    public e f36790f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f36791g;

    /* renamed from: h  reason: collision with root package name */
    public final int f36792h;

    /* renamed from: com.kwai.filedownloader.download.c$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ConnectTask.a f36793a;

        /* renamed from: b  reason: collision with root package name */
        public f f36794b;

        /* renamed from: c  reason: collision with root package name */
        public String f36795c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f36796d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f36797e;

        public a() {
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
            this.f36793a = new ConnectTask.a();
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f36793a.a(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
                this.f36793a.a(bVar);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.f36793a.a(aVar);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
                this.f36794b = fVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, num)) == null) {
                this.f36797e = num;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f36793a.a(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f36796d = Boolean.valueOf(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.f36794b == null || this.f36795c == null || this.f36796d == null || this.f36797e == null) {
                    throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("%s %s %B", this.f36794b, this.f36795c, this.f36796d));
                }
                ConnectTask a2 = this.f36793a.a();
                return new c(a2.f36745a, this.f36797e.intValue(), a2, this.f36794b, this.f36796d.booleanValue(), this.f36795c, null);
            }
            return (c) invokeV.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f36793a.b(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f36795c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public c(int i2, int i3, ConnectTask connectTask, f fVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), connectTask, fVar, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36792h = i2;
        this.f36785a = i3;
        this.f36791g = false;
        this.f36787c = fVar;
        this.f36788d = str;
        this.f36786b = connectTask;
        this.f36789e = z;
    }

    public /* synthetic */ c(int i2, int i3, ConnectTask connectTask, f fVar, boolean z, String str, AnonymousClass1 anonymousClass1) {
        this(i2, i3, connectTask, fVar, z, str);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f36791g = true;
            e eVar = this.f36790f;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Exception e2;
        e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Process.setThreadPriority(10);
            long j = this.f36786b.e().f36775b;
            com.kwai.filedownloader.a.b bVar = null;
            boolean z2 = false;
            while (!this.f36791g) {
                try {
                    try {
                        bVar = this.f36786b.a();
                        int e3 = bVar.e();
                        if (com.kwai.filedownloader.f.d.f36845a) {
                            com.kwai.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.f36785a), Integer.valueOf(this.f36792h), this.f36786b.e(), Integer.valueOf(e3));
                        }
                        if (e3 != 206 && e3 != 200) {
                            throw new SocketException(com.kwai.filedownloader.f.f.a("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.f36786b.d(), bVar.c(), Integer.valueOf(e3), Integer.valueOf(this.f36792h), Integer.valueOf(this.f36785a)));
                            break;
                        }
                    } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e4) {
                        e2 = e4;
                        z = false;
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e5) {
                    z = z2;
                    e2 = e5;
                }
                try {
                    aVar = new e.a();
                } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e6) {
                    e2 = e6;
                    z = true;
                    try {
                        if (this.f36787c.a(e2)) {
                            if (!z) {
                                this.f36787c.a(e2, 0L);
                            } else if (this.f36790f != null) {
                                this.f36787c.a(e2, this.f36790f.f36810a - j);
                            } else {
                                com.kwai.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e2);
                                this.f36787c.b(e2);
                                if (bVar == null) {
                                    return;
                                }
                            }
                            if (bVar != null) {
                                bVar.f();
                            }
                            z2 = z;
                        } else {
                            this.f36787c.b(e2);
                            if (bVar == null) {
                                return;
                            }
                        }
                        return;
                    } finally {
                        if (bVar != null) {
                            bVar.f();
                        }
                    }
                }
                if (this.f36791g) {
                    if (bVar != null) {
                        bVar.f();
                        return;
                    }
                    return;
                }
                e a2 = aVar.b(this.f36792h).a(this.f36785a).a(this.f36787c).a(this).a(this.f36789e).a(bVar).a(this.f36786b.e()).a(this.f36788d).a();
                this.f36790f = a2;
                a2.b();
                if (this.f36791g) {
                    this.f36790f.a();
                }
                if (bVar == null) {
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.f();
            }
        }
    }
}
