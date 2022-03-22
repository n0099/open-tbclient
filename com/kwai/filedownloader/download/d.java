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
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes7.dex */
public class d implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwai.filedownloader.c.c a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwai.filedownloader.a.a f41673b;

    /* renamed from: c  reason: collision with root package name */
    public final a f41674c;

    /* renamed from: d  reason: collision with root package name */
    public final int f41675d;

    /* renamed from: e  reason: collision with root package name */
    public final int f41676e;

    /* renamed from: f  reason: collision with root package name */
    public final int f41677f;

    /* renamed from: g  reason: collision with root package name */
    public long f41678g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f41679h;
    public HandlerThread i;
    public volatile boolean j;
    public volatile Thread k;
    public volatile long l;
    public final AtomicLong m;
    public volatile boolean n;
    public boolean o;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public Exception f41680b;

        /* renamed from: c  reason: collision with root package name */
        public int f41681c;

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

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.f41681c = i;
            }
        }

        public void a(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                this.f41680b = exc;
            }
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.a = z;
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.booleanValue;
        }

        public Exception b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41680b : (Exception) invokeV.objValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41681c : invokeV.intValue;
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
        this.j = false;
        this.l = 0L;
        this.m = new AtomicLong();
        this.o = true;
        this.a = cVar;
        this.f41673b = b.a().c();
        this.f41676e = i2 < 5 ? 5 : i2;
        this.f41677f = i3;
        this.f41674c = new a();
        this.f41675d = i;
    }

    public static long a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
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

    private void a(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(65538, this, b2) == null) {
            if (b2 != -2) {
                com.kwai.filedownloader.message.e.a().a(com.kwai.filedownloader.message.f.a(b2, this.a, this.f41674c));
            } else if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.a.a()));
            }
        }
    }

    private void a(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            if (this.a.g() == this.a.h()) {
                this.f41673b.a(this.a.a(), this.a.g());
                return;
            }
            if (this.n) {
                this.n = false;
                this.a.a((byte) 3);
            }
            if (z) {
                this.l = j;
                a((byte) 3);
                this.m.set(0L);
            }
        }
    }

    private void a(SQLiteFullException sQLiteFullException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, sQLiteFullException) == null) {
            int a2 = this.a.a();
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(a2), sQLiteFullException.toString());
            }
            this.a.c(sQLiteFullException.toString());
            this.a.a((byte) -1);
            this.f41673b.e(a2);
            this.f41673b.d(a2);
        }
    }

    private synchronized void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, message) == null) {
            synchronized (this) {
                if (!this.i.isAlive()) {
                    if (com.kwai.filedownloader.e.d.a) {
                        com.kwai.filedownloader.e.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                    }
                    return;
                }
                try {
                    this.f41679h.sendMessage(message);
                } catch (IllegalStateException e2) {
                    if (this.i.isAlive()) {
                        throw e2;
                    }
                    if (com.kwai.filedownloader.e.d.a) {
                        com.kwai.filedownloader.e.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                    }
                }
            }
        }
    }

    private void a(Exception exc, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, this, exc, i) == null) {
            Exception b2 = b(exc);
            this.f41674c.a(b2);
            this.f41674c.a(this.f41675d - i);
            this.a.a((byte) 5);
            this.a.c(b2.toString());
            this.f41673b.a(this.a.a(), b2);
            a((byte) 5);
        }
    }

    private Exception b(Exception exc) {
        InterceptResult invokeL;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, exc)) == null) {
            String e2 = this.a.e();
            if ((this.a.i() || com.kwai.filedownloader.e.e.a().f41703f) && (exc instanceof IOException) && new File(e2).exists()) {
                long f2 = com.kwai.filedownloader.e.f.f(e2);
                if (f2 <= 4096) {
                    File file = new File(e2);
                    if (file.exists()) {
                        length = file.length();
                    } else {
                        com.kwai.filedownloader.e.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
                        length = 0;
                    }
                    return Build.VERSION.SDK_INT >= 9 ? new FileDownloadOutOfSpaceException(f2, 4096L, length, exc) : new FileDownloadOutOfSpaceException(f2, 4096L, length);
                }
                return exc;
            }
            return exc;
        }
        return (Exception) invokeL.objValue;
    }

    private boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65544, this, j)) == null) {
            if (!this.o) {
                return this.f41678g != -1 && this.m.get() >= this.f41678g && j - this.l >= ((long) this.f41676e);
            }
            this.o = false;
            return true;
        }
        return invokeJ.booleanValue;
    }

    private void c(Exception exc) {
        Exception exc2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, exc) == null) {
            Exception b2 = b(exc);
            if (b2 instanceof SQLiteFullException) {
                a((SQLiteFullException) b2);
                exc2 = b2;
            } else {
                try {
                    this.a.a((byte) -1);
                    this.a.c(exc.toString());
                    this.f41673b.a(this.a.a(), b2, this.a.g());
                    exc2 = b2;
                } catch (SQLiteFullException e2) {
                    SQLiteFullException sQLiteFullException = e2;
                    a(sQLiteFullException);
                    exc2 = sQLiteFullException;
                }
            }
            this.f41674c.a(exc2);
            a((byte) -1);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            String e2 = this.a.e();
            String d2 = this.a.d();
            File file = new File(e2);
            try {
                File file2 = new File(d2);
                if (file2.exists()) {
                    long length = file2.length();
                    if (!file2.delete()) {
                        throw new IOException(com.kwai.filedownloader.e.f.a("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", d2, Long.valueOf(length)));
                    }
                    com.kwai.filedownloader.e.d.d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", d2, Long.valueOf(length), Long.valueOf(file.length()));
                }
                if (!file.renameTo(file2)) {
                    throw new IOException(com.kwai.filedownloader.e.f.a("Can't rename the  temp downloaded file(%s) to the target file(%s)", e2, d2));
                }
                if (!file.exists() || file.delete()) {
                    return;
                }
                com.kwai.filedownloader.e.d.d(this, "delete the temp file(%s) failed, on completed downloading.", e2);
            } catch (Throwable th) {
                if (file.exists() && !file.delete()) {
                    com.kwai.filedownloader.e.d.d(this, "delete the temp file(%s) failed, on completed downloading.", e2);
                }
                throw th;
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            h();
            this.a.a((byte) -3);
            this.f41673b.b(this.a.a(), this.a.h());
            this.f41673b.d(this.a.a());
            a((byte) -3);
            if (com.kwai.filedownloader.e.e.a().f41704g) {
                com.kwai.filedownloader.services.f.a(this.a);
            }
        }
    }

    private boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (this.a.i()) {
                com.kwai.filedownloader.c.c cVar = this.a;
                cVar.c(cVar.g());
            } else if (this.a.g() != this.a.h()) {
                a(new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.a("sofar[%d] not equal total[%d]", Long.valueOf(this.a.g()), Long.valueOf(this.a.h()))));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.a.a((byte) -2);
            this.f41673b.c(this.a.a(), this.a.g());
            a((byte) -2);
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.m.addAndGet(j);
            this.a.b(j);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean b2 = b(elapsedRealtime);
            Handler handler = this.f41679h;
            if (handler == null) {
                a(elapsedRealtime, b2);
            } else if (b2) {
                a(handler.obtainMessage(3));
            }
        }
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            c(exc);
        }
    }

    public void a(Exception exc, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{exc, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.m.set(0L);
            this.a.b(-j);
            Handler handler = this.f41679h;
            if (handler == null) {
                a(exc, i);
            } else {
                a(handler.obtainMessage(5, i, 0, exc));
            }
        }
    }

    public void a(boolean z, long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, str2}) == null) {
            String j2 = this.a.j();
            if (j2 != null && !j2.equals(str)) {
                throw new IllegalArgumentException(com.kwai.filedownloader.e.f.a("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, j2));
            }
            this.f41674c.a(z);
            this.a.a((byte) 2);
            this.a.c(j);
            this.a.b(str);
            this.a.d(str2);
            this.f41673b.a(this.a.a(), j, str, str2);
            a((byte) 2);
            this.f41678g = a(j, this.f41677f);
            this.n = true;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HandlerThread handlerThread = this.i;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (handler = this.f41679h) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.i.quit();
        this.k = Thread.currentThread();
        while (this.j) {
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
        }
        this.k = null;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.a((byte) 1);
            this.f41673b.f(this.a.a());
            a((byte) 1);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.a((byte) 6);
            a((byte) 6);
            this.f41673b.a(this.a.a());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
            this.i = handlerThread;
            handlerThread.start();
            this.f41679h = new Handler(this.i.getLooper(), this);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            k();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || j()) {
            return;
        }
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028 A[DONT_GENERATE] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, message)) == null) {
            this.j = true;
            int i = message.what;
            try {
                if (i != 3) {
                    if (i == 5) {
                        a((Exception) message.obj, message.arg1);
                    }
                    return true;
                }
                a(SystemClock.elapsedRealtime(), true);
                return true;
            } finally {
                this.j = false;
                if (this.k != null) {
                    LockSupport.unpark(this.k);
                }
            }
        }
        return invokeL.booleanValue;
    }
}
