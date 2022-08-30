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
/* loaded from: classes7.dex */
public final class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String apC;
    public final boolean auF;
    public final int aui;
    public final ConnectTask ave;
    public final f avf;
    public e avg;
    public final int avh;
    public volatile boolean hw;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String apC;
        public Boolean avc;
        public f avf;
        public final ConnectTask.a avi;
        public Integer avj;

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
            this.avi = new ConnectTask.a();
        }

        public final c DG() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.avf == null || this.apC == null || this.avc == null || this.avj == null) {
                    throw new IllegalArgumentException(com.kwai.filedownloader.e.f.h("%s %s %B", this.avf, this.apC, this.avc));
                }
                ConnectTask Do = this.avi.Do();
                return new c(Do.aui, this.avj.intValue(), Do, this.avf, this.avc.booleanValue(), this.apC, (byte) 0);
            }
            return (c) invokeV.objValue;
        }

        public final a a(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
                this.avf = fVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a b(com.kwai.filedownloader.download.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.avi.a(aVar);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a bB(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.avc = Boolean.valueOf(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final a c(com.kwai.filedownloader.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
                this.avi.a(bVar);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a cm(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.avi.cl(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a d(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, num)) == null) {
                this.avj = num;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a eu(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.avi.er(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a ev(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.avi.es(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a ew(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.apC = str;
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
        this.aui = i;
        this.avh = i2;
        this.hw = false;
        this.avf = fVar;
        this.apC = str;
        this.ave = connectTask;
        this.auF = z;
    }

    public /* synthetic */ c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str, byte b) {
        this(i, i2, connectTask, fVar, z, str);
    }

    public final void CP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            pause();
        }
    }

    public final void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.hw = true;
            e eVar = this.avg;
            if (eVar != null) {
                eVar.pause();
            }
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
            long j = this.ave.Dn().aur;
            com.kwai.filedownloader.kwai.b bVar = null;
            boolean z2 = false;
            while (!this.hw) {
                try {
                    try {
                        bVar = this.ave.Dk();
                        int responseCode = bVar.getResponseCode();
                        if (com.kwai.filedownloader.e.d.awL) {
                            com.kwai.filedownloader.e.d.e(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.avh), Integer.valueOf(this.aui), this.ave.Dn(), Integer.valueOf(responseCode));
                        }
                        if (responseCode != 206 && responseCode != 200) {
                            throw new SocketException(com.kwai.filedownloader.e.f.h("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.ave.getRequestHeader(), bVar.V(), Integer.valueOf(responseCode), Integer.valueOf(this.aui), Integer.valueOf(this.avh)));
                            break;
                        }
                    } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e2) {
                        e = e2;
                        z = false;
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e3) {
                    z = z2;
                    e = e3;
                }
                try {
                    e.a aVar = new e.a();
                    if (this.hw) {
                        if (bVar != null) {
                            bVar.W();
                            return;
                        }
                        return;
                    }
                    e DT = aVar.cp(this.aui).co(this.avh).b(this.avf).a(this).bD(this.auF).d(bVar).c(this.ave.Dn()).ex(this.apC).DT();
                    this.avg = DT;
                    DT.run();
                    if (this.hw) {
                        this.avg.pause();
                    }
                    if (bVar != null) {
                        return;
                    }
                    return;
                } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e4) {
                    e = e4;
                    z = true;
                    try {
                        if (!this.avf.d(e)) {
                            this.avf.e(e);
                            if (bVar != null) {
                                bVar.W();
                                return;
                            }
                            return;
                        }
                        if (!z) {
                            this.avf.a(e, 0L);
                        } else if (this.avg == null) {
                            com.kwai.filedownloader.e.d.f(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                            this.avf.e(e);
                            if (bVar != null) {
                                bVar.W();
                                return;
                            }
                            return;
                        } else {
                            this.avf.a(e, this.avg.aur - j);
                        }
                        if (bVar != null) {
                            bVar.W();
                        }
                        z2 = z;
                    } finally {
                        if (bVar != null) {
                            bVar.W();
                        }
                    }
                }
            }
            if (bVar != null) {
                bVar.W();
            }
        }
    }
}
