package com.kwai.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes2.dex */
public class d implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwai.filedownloader.d.c f66926a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwai.filedownloader.b.a f66927b;

    /* renamed from: c  reason: collision with root package name */
    public final a f66928c;

    /* renamed from: d  reason: collision with root package name */
    public final int f66929d;

    /* renamed from: e  reason: collision with root package name */
    public final int f66930e;

    /* renamed from: f  reason: collision with root package name */
    public final int f66931f;

    /* renamed from: g  reason: collision with root package name */
    public long f66932g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f66933h;

    /* renamed from: i  reason: collision with root package name */
    public HandlerThread f66934i;
    public volatile boolean j;
    public volatile Thread k;
    public volatile long l;
    public final AtomicLong m;
    public volatile boolean n;
    public boolean o;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f66935a;

        /* renamed from: b  reason: collision with root package name */
        public Exception f66936b;

        /* renamed from: c  reason: collision with root package name */
        public int f66937c;

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
                }
            }
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f66937c = i2;
            }
        }

        public void a(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                this.f66936b = exc;
            }
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f66935a = z;
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66935a : invokeV.booleanValue;
        }

        public Exception b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f66936b : (Exception) invokeV.objValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f66937c : invokeV.intValue;
        }
    }

    public d(com.kwai.filedownloader.d.c cVar, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = false;
        this.l = 0L;
        this.m = new AtomicLong();
        this.o = true;
        this.f66926a = cVar;
        this.f66927b = b.a().c();
        this.f66930e = i3 < 5 ? 5 : i3;
        this.f66931f = i4;
        this.f66928c = new a();
        this.f66929d = i2;
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
                com.kwai.filedownloader.message.e.a().a(com.kwai.filedownloader.message.f.a(b2, this.f66926a, this.f66928c));
            } else if (com.kwai.filedownloader.f.d.f66973a) {
                com.kwai.filedownloader.f.d.c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.f66926a.a()));
            }
        }
    }

    private void a(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            if (this.f66926a.g() == this.f66926a.h()) {
                this.f66927b.a(this.f66926a.a(), this.f66926a.g());
                return;
            }
            if (this.n) {
                this.n = false;
                this.f66926a.a((byte) 3);
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
            int a2 = this.f66926a.a();
            if (com.kwai.filedownloader.f.d.f66973a) {
                com.kwai.filedownloader.f.d.c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(a2), sQLiteFullException.toString());
            }
            this.f66926a.c(sQLiteFullException.toString());
            this.f66926a.a((byte) -1);
            this.f66927b.e(a2);
            this.f66927b.d(a2);
        }
    }

    private synchronized void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, message) == null) {
            synchronized (this) {
                if (!this.f66934i.isAlive()) {
                    if (com.kwai.filedownloader.f.d.f66973a) {
                        com.kwai.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                    }
                    return;
                }
                try {
                    this.f66933h.sendMessage(message);
                } catch (IllegalStateException e2) {
                    if (this.f66934i.isAlive()) {
                        throw e2;
                    }
                    if (com.kwai.filedownloader.f.d.f66973a) {
                        com.kwai.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                    }
                }
            }
        }
    }

    private void a(Exception exc, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, this, exc, i2) == null) {
            Exception b2 = b(exc);
            this.f66928c.a(b2);
            this.f66928c.a(this.f66929d - i2);
            this.f66926a.a((byte) 5);
            this.f66926a.c(b2.toString());
            this.f66927b.a(this.f66926a.a(), b2);
            a((byte) 5);
        }
    }

    private Exception b(Exception exc) {
        InterceptResult invokeL;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, exc)) == null) {
            String e2 = this.f66926a.e();
            if ((this.f66926a.i() || com.kwai.filedownloader.f.e.a().f66979f) && (exc instanceof IOException) && new File(e2).exists()) {
                long f2 = com.kwai.filedownloader.f.f.f(e2);
                if (f2 <= 4096) {
                    File file = new File(e2);
                    if (file.exists()) {
                        length = file.length();
                    } else {
                        com.kwai.filedownloader.f.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
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
                return this.f66932g != -1 && this.m.get() >= this.f66932g && j - this.l >= ((long) this.f66930e);
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
                    this.f66926a.a((byte) -1);
                    this.f66926a.c(exc.toString());
                    this.f66927b.a(this.f66926a.a(), b2, this.f66926a.g());
                    exc2 = b2;
                } catch (SQLiteFullException e2) {
                    SQLiteFullException sQLiteFullException = e2;
                    a(sQLiteFullException);
                    exc2 = sQLiteFullException;
                }
            }
            this.f66928c.a(exc2);
            a((byte) -1);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            String e2 = this.f66926a.e();
            String d2 = this.f66926a.d();
            File file = new File(e2);
            try {
                File file2 = new File(d2);
                if (file2.exists()) {
                    long length = file2.length();
                    if (!file2.delete()) {
                        throw new IOException(com.kwai.filedownloader.f.f.a("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", d2, Long.valueOf(length)));
                    }
                    com.kwai.filedownloader.f.d.d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", d2, Long.valueOf(length), Long.valueOf(file.length()));
                }
                if (!file.renameTo(file2)) {
                    throw new IOException(com.kwai.filedownloader.f.f.a("Can't rename the  temp downloaded file(%s) to the target file(%s)", e2, d2));
                }
                if (!file.exists() || file.delete()) {
                    return;
                }
                com.kwai.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", e2);
            } catch (Throwable th) {
                if (file.exists() && !file.delete()) {
                    com.kwai.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", e2);
                }
                throw th;
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            h();
            this.f66926a.a((byte) -3);
            this.f66927b.b(this.f66926a.a(), this.f66926a.h());
            this.f66927b.d(this.f66926a.a());
            a((byte) -3);
            if (com.kwai.filedownloader.f.e.a().f66980g) {
                com.kwai.filedownloader.services.f.a(this.f66926a);
            }
        }
    }

    private boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (this.f66926a.i()) {
                com.kwai.filedownloader.d.c cVar = this.f66926a;
                cVar.c(cVar.g());
            } else if (this.f66926a.g() != this.f66926a.h()) {
                a(new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("sofar[%d] not equal total[%d]", Long.valueOf(this.f66926a.g()), Long.valueOf(this.f66926a.h()))));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.f66926a.a((byte) -2);
            this.f66927b.c(this.f66926a.a(), this.f66926a.g());
            a((byte) -2);
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.m.addAndGet(j);
            this.f66926a.b(j);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean b2 = b(elapsedRealtime);
            Handler handler = this.f66933h;
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

    public void a(Exception exc, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{exc, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.m.set(0L);
            this.f66926a.b(-j);
            Handler handler = this.f66933h;
            if (handler == null) {
                a(exc, i2);
            } else {
                a(handler.obtainMessage(5, i2, 0, exc));
            }
        }
    }

    public void a(boolean z, long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, str2}) == null) {
            String j2 = this.f66926a.j();
            if (j2 != null && !j2.equals(str)) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, j2));
            }
            this.f66928c.a(z);
            this.f66926a.a((byte) 2);
            this.f66926a.c(j);
            this.f66926a.b(str);
            this.f66926a.d(str2);
            this.f66927b.a(this.f66926a.a(), j, str, str2);
            a((byte) 2);
            this.f66932g = a(j, this.f66931f);
            this.n = true;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HandlerThread handlerThread = this.f66934i;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (handler = this.f66933h) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.f66934i.quit();
        this.k = Thread.currentThread();
        while (this.j) {
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
        }
        this.k = null;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f66926a.a((byte) 1);
            this.f66927b.f(this.f66926a.a());
            a((byte) 1);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f66926a.a((byte) 6);
            a((byte) 6);
            this.f66927b.a(this.f66926a.a());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
            this.f66934i = handlerThread;
            handlerThread.start();
            this.f66933h = new Handler(this.f66934i.getLooper(), this);
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
            int i2 = message.what;
            try {
                if (i2 != 3) {
                    if (i2 == 5) {
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
