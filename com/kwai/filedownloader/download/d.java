package com.kwai.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.crash.utils.g;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes8.dex */
public final class d implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Thread atY;
    public final com.kwai.filedownloader.c.c auC;
    public volatile long auW;
    public final com.kwai.filedownloader.a.a aux;
    public final a avk;
    public final int avl;
    public final int avm;
    public final int avn;
    public long avo;
    public HandlerThread avp;
    public volatile boolean avq;
    public final AtomicLong avr;
    public volatile boolean avs;
    public boolean avt;
    public Handler handler;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean avu;
        public Exception avv;
        public int avw;

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

        public final int Ce() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.avw : invokeV.intValue;
        }

        public final boolean DR() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.avu : invokeV.booleanValue;
        }

        public final void bC(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.avu = z;
            }
        }

        public final void cn(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.avw = i;
            }
        }

        public final Exception getException() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.avv : (Exception) invokeV.objValue;
        }

        public final void i(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, exc) == null) {
                this.avv = exc;
            }
        }
    }

    public d(com.kwai.filedownloader.c.c cVar, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.avq = false;
        this.auW = 0L;
        this.avr = new AtomicLong();
        this.avt = true;
        this.auC = cVar;
        this.aux = b.Dp().Dr();
        this.avm = i2 < 5 ? 5 : i2;
        this.avn = i3;
        this.avk = new a();
        this.avl = i;
    }

    private void DN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            String DE = this.auC.DE();
            String targetFilePath = this.auC.getTargetFilePath();
            File file = new File(DE);
            try {
                File file2 = new File(targetFilePath);
                if (file2.exists()) {
                    long length = file2.length();
                    if (!file2.delete()) {
                        throw new IOException(com.kwai.filedownloader.e.f.h("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                    }
                    com.kwai.filedownloader.e.d.f(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
                }
                if (!file.renameTo(file2)) {
                    throw new IOException(com.kwai.filedownloader.e.f.h("Can't rename the  temp downloaded file(%s) to the target file(%s)", DE, targetFilePath));
                }
                if (!file.exists() || file.delete()) {
                    return;
                }
                com.kwai.filedownloader.e.d.f(this, "delete the temp file(%s) failed, on completed downloading.", DE);
            } catch (Throwable th) {
                if (file.exists() && !file.delete()) {
                    com.kwai.filedownloader.e.d.f(this, "delete the temp file(%s) failed, on completed downloading.", DE);
                }
                throw th;
            }
        }
    }

    private void DO() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            DN();
            this.auC.e((byte) -3);
            this.aux.d(this.auC.getId(), this.auC.getTotal());
            this.aux.cf(this.auC.getId());
            d((byte) -3);
            if (com.kwai.filedownloader.e.e.EL().awS) {
                com.kwai.filedownloader.services.f.f(this.auC);
            }
        }
    }

    private boolean DP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.auC.isChunked()) {
                com.kwai.filedownloader.c.c cVar = this.auC;
                cVar.ab(cVar.Em());
            } else if (this.auC.Em() != this.auC.getTotal()) {
                f(new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.h("sofar[%d] not equal total[%d]", Long.valueOf(this.auC.Em()), Long.valueOf(this.auC.getTotal()))));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void DQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.auC.e((byte) -2);
            this.aux.e(this.auC.getId(), this.auC.Em());
            d((byte) -2);
        }
    }

    private boolean W(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65541, this, j)) == null) {
            if (!this.avt) {
                return this.avo != -1 && this.avr.get() >= this.avo && j - this.auW >= ((long) this.avm);
            }
            this.avt = false;
            return true;
        }
        return invokeJ.booleanValue;
    }

    private void a(SQLiteFullException sQLiteFullException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, sQLiteFullException) == null) {
            int id = this.auC.getId();
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id), sQLiteFullException.toString());
            }
            this.auC.eA(sQLiteFullException.toString());
            this.auC.e((byte) -1);
            this.aux.cg(id);
            this.aux.cf(id);
        }
    }

    private void a(Exception exc, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, this, exc, i) == null) {
            Exception g = g(exc);
            this.avk.i(g);
            this.avk.cn(this.avl - i);
            this.auC.e((byte) 5);
            this.auC.eA(g.toString());
            this.aux.a(this.auC.getId(), g);
            d((byte) 5);
        }
    }

    private void b(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            if (this.auC.Em() == this.auC.getTotal()) {
                this.aux.c(this.auC.getId(), this.auC.Em());
                return;
            }
            if (this.avs) {
                this.avs = false;
                this.auC.e((byte) 3);
            }
            if (z) {
                this.auW = j;
                d((byte) 3);
                this.avr.set(0L);
            }
        }
    }

    private synchronized void c(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, message) == null) {
            synchronized (this) {
                if (!this.avp.isAlive()) {
                    if (com.kwai.filedownloader.e.d.awL) {
                        com.kwai.filedownloader.e.d.e(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                    }
                    return;
                }
                try {
                    this.handler.sendMessage(message);
                } catch (IllegalStateException e) {
                    if (this.avp.isAlive()) {
                        throw e;
                    }
                    if (com.kwai.filedownloader.e.d.awL) {
                        com.kwai.filedownloader.e.d.e(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                    }
                }
            }
        }
    }

    private void d(byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(65546, this, b) == null) {
            if (b != -2) {
                com.kwai.filedownloader.message.e.Eg().s(com.kwai.filedownloader.message.f.a(b, this.auC, this.avk));
            } else if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.auC.getId()));
            }
        }
    }

    public static long f(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j2 <= 0) {
                return -1L;
            }
            if (j == -1) {
                return 1L;
            }
            long j3 = j / (j2 + 1);
            if (j3 <= 0) {
                return 1L;
            }
            return j3;
        }
        return invokeCommon.longValue;
    }

    private Exception g(Exception exc) {
        InterceptResult invokeL;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, exc)) == null) {
            String DE = this.auC.DE();
            if ((this.auC.isChunked() || com.kwai.filedownloader.e.e.EL().awR) && (exc instanceof IOException) && new File(DE).exists()) {
                long availableBytes = g.getAvailableBytes(DE);
                if (availableBytes <= 4096) {
                    File file = new File(DE);
                    if (file.exists()) {
                        length = file.length();
                    } else {
                        com.kwai.filedownloader.e.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
                        length = 0;
                    }
                    return Build.VERSION.SDK_INT >= 9 ? new FileDownloadOutOfSpaceException(availableBytes, 4096L, length, exc) : new FileDownloadOutOfSpaceException(availableBytes, 4096L, length);
                }
                return exc;
            }
            return exc;
        }
        return (Exception) invokeL.objValue;
    }

    private void h(Exception exc) {
        Exception exc2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, exc) == null) {
            Exception g = g(exc);
            if (g instanceof SQLiteFullException) {
                a((SQLiteFullException) g);
                exc2 = g;
            } else {
                try {
                    this.auC.e((byte) -1);
                    this.auC.eA(exc.toString());
                    this.aux.a(this.auC.getId(), g, this.auC.Em());
                    exc2 = g;
                } catch (SQLiteFullException e) {
                    SQLiteFullException sQLiteFullException = e;
                    a(sQLiteFullException);
                    exc2 = sQLiteFullException;
                }
            }
            this.avk.i(exc2);
            d((byte) -1);
        }
    }

    public final void DH() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (handler = this.handler) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.avp.quit();
        this.atY = Thread.currentThread();
        while (this.avq) {
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
        }
        this.atY = null;
    }

    public final void DI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.auC.e((byte) 1);
            this.aux.ch(this.auC.getId());
            d((byte) 1);
        }
    }

    public final void DJ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.auC.e((byte) 6);
            d((byte) 6);
            this.aux.cc(this.auC.getId());
        }
    }

    public final void DK() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
            this.avp = handlerThread;
            handlerThread.start();
            this.handler = new Handler(this.avp.getLooper(), this);
        }
    }

    public final void DL() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            DQ();
        }
    }

    public final void DM() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || DP()) {
            return;
        }
        DO();
    }

    public final void a(Exception exc, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{exc, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.avr.set(0L);
            this.auC.aa(-j);
            Handler handler = this.handler;
            if (handler == null) {
                a(exc, i);
            } else {
                c(handler.obtainMessage(5, i, 0, exc));
            }
        }
    }

    public final void a(boolean z, long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, str2}) == null) {
            String En = this.auC.En();
            if (En != null && !En.equals(str)) {
                throw new IllegalArgumentException(com.kwai.filedownloader.e.f.h("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, En));
            }
            this.avk.bC(z);
            this.auC.e((byte) 2);
            this.auC.ab(j);
            this.auC.ez(str);
            this.auC.eB(str2);
            this.aux.a(this.auC.getId(), j, str, str2);
            d((byte) 2);
            this.avo = f(j, this.avn);
            this.avs = true;
        }
    }

    public final void f(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            h(exc);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028 A[DONT_GENERATE] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, message)) == null) {
            this.avq = true;
            int i = message.what;
            try {
                if (i != 3) {
                    if (i == 5) {
                        a((Exception) message.obj, message.arg1);
                    }
                    return true;
                }
                b(SystemClock.elapsedRealtime(), true);
                return true;
            } finally {
                this.avq = false;
                if (this.atY != null) {
                    LockSupport.unpark(this.atY);
                }
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean isAlive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            HandlerThread handlerThread = this.avp;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public final void onProgress(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.avr.addAndGet(j);
            this.auC.aa(j);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean W = W(elapsedRealtime);
            Handler handler = this.handler;
            if (handler == null) {
                b(elapsedRealtime, W);
            } else if (W) {
                c(handler.obtainMessage(3));
            }
        }
    }
}
