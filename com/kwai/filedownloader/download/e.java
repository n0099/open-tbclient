package com.kwai.filedownloader.download;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String apC;
    public final boolean auF;
    public final int aui;
    public final long auq;
    public long aur;
    public final long aus;
    public final com.kwai.filedownloader.a.a aux;
    public volatile long avA;
    public volatile long avB;
    public final f avf;
    public final int avh;
    public final c avx;
    public final com.kwai.filedownloader.kwai.b avy;
    public com.kwai.filedownloader.d.a avz;
    public final long contentLength;
    public volatile boolean hw;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String apC;
        public Integer auo;
        public com.kwai.filedownloader.download.a aup;
        public c avC;
        public Boolean avc;
        public f avf;
        public Integer avj;
        public com.kwai.filedownloader.kwai.b avy;

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
                }
            }
        }

        public final e DT() {
            InterceptResult invokeV;
            com.kwai.filedownloader.kwai.b bVar;
            com.kwai.filedownloader.download.a aVar;
            Integer num;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.avc == null || (bVar = this.avy) == null || (aVar = this.aup) == null || this.avf == null || this.apC == null || (num = this.auo) == null || this.avj == null) {
                    throw new IllegalArgumentException();
                }
                return new e(bVar, aVar, this.avC, num.intValue(), this.avj.intValue(), this.avc.booleanValue(), this.avf, this.apC, (byte) 0);
            }
            return (e) invokeV.objValue;
        }

        public final a a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.avC = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a b(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) {
                this.avf = fVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a bD(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.avc = Boolean.valueOf(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final a c(com.kwai.filedownloader.download.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
                this.aup = aVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a co(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.avj = Integer.valueOf(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a cp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.auo = Integer.valueOf(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a d(com.kwai.filedownloader.kwai.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
                this.avy = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a ex(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.apC = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public e(com.kwai.filedownloader.kwai.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, aVar, cVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), fVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.avA = 0L;
        this.avB = 0L;
        this.avf = fVar;
        this.apC = str;
        this.avy = bVar;
        this.auF = z;
        this.avx = cVar;
        this.avh = i2;
        this.aui = i;
        this.aux = b.Dp().Dr();
        this.auq = aVar.auq;
        this.aus = aVar.aus;
        this.aur = aVar.aur;
        this.contentLength = aVar.contentLength;
    }

    public /* synthetic */ e(com.kwai.filedownloader.kwai.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str, byte b) {
        this(bVar, aVar, cVar, i, i2, z, fVar, str);
    }

    private void DS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (com.kwai.filedownloader.e.f.g(this.aur - this.avA, elapsedRealtime - this.avB)) {
                sync();
                this.avA = this.aur;
                this.avB = elapsedRealtime;
            }
        }
    }

    private void sync() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                this.avz.EI();
                z = true;
            } catch (IOException e) {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
                }
                z = false;
            }
            if (z) {
                if (this.avx != null) {
                    this.aux.a(this.aui, this.avh, this.aur);
                } else {
                    this.avf.DB();
                }
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.aui), Integer.valueOf(this.avh), Long.valueOf(this.aur), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        }
    }

    public final void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.hw = true;
        }
    }

    public final void run() {
        com.kwai.filedownloader.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.hw) {
            return;
        }
        long b = com.kwai.filedownloader.e.f.b(this.avh, this.avy);
        int i = 0;
        if (b == 0) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.h("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.aui), Integer.valueOf(this.avh)));
        }
        long j = this.contentLength;
        if (j > 0 && b != j) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.h("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.aus == 0 ? com.kwai.filedownloader.e.f.h("range[%d-)", Long.valueOf(this.aur)) : com.kwai.filedownloader.e.f.h("range[%d-%d)", Long.valueOf(this.aur), Long.valueOf(this.aus)), Long.valueOf(this.contentLength), Long.valueOf(b), Integer.valueOf(this.aui), Integer.valueOf(this.avh)));
        }
        long j2 = this.aur;
        try {
            boolean Dt = b.Dp().Dt();
            if (this.avx != null && !Dt) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            aVar = com.kwai.filedownloader.e.f.eL(this.apC);
            try {
                this.avz = aVar;
                if (Dt) {
                    aVar.seek(this.aur);
                }
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.avh), Long.valueOf(this.auq), Long.valueOf(this.aus), Long.valueOf(this.aur));
                }
                InputStream inputStream = this.avy.getInputStream();
                byte[] bArr = new byte[4096];
                if (this.hw) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    return;
                }
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        if (aVar != null) {
                            sync();
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                        long j3 = this.aur - j2;
                        if (b != -1 && b != j3) {
                            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.h("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", Long.valueOf(j3), Long.valueOf(b), Long.valueOf(this.auq), Long.valueOf(this.aus), Long.valueOf(this.aur), Long.valueOf(j2)));
                        }
                        this.avf.a(this.avx, this.auq, this.aus);
                        return;
                    }
                    aVar.write(bArr, i, read);
                    long j4 = read;
                    this.aur += j4;
                    this.avf.onProgress(j4);
                    DS();
                    if (this.hw) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                        return;
                    }
                    if (this.auF && com.kwai.filedownloader.e.f.EQ()) {
                        throw new FileDownloadNetworkPolicyException();
                    }
                    i = 0;
                }
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            aVar = null;
        }
    }
}
