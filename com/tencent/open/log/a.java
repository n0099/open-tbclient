package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes6.dex */
public class a extends Tracer implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f39165a;

    /* renamed from: b  reason: collision with root package name */
    public FileWriter f39166b;

    /* renamed from: c  reason: collision with root package name */
    public FileWriter f39167c;

    /* renamed from: d  reason: collision with root package name */
    public File f39168d;

    /* renamed from: e  reason: collision with root package name */
    public File f39169e;

    /* renamed from: f  reason: collision with root package name */
    public char[] f39170f;

    /* renamed from: g  reason: collision with root package name */
    public volatile f f39171g;

    /* renamed from: h  reason: collision with root package name */
    public volatile f f39172h;

    /* renamed from: i  reason: collision with root package name */
    public volatile f f39173i;
    public volatile f j;
    public volatile boolean k;
    public HandlerThread l;
    public Handler m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        this(c.f39184b, true, g.f39198a, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), (g) objArr2[2], (b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && Thread.currentThread() == this.l && !this.k) {
            this.k = true;
            j();
            try {
                try {
                    this.j.a(g(), this.f39170f);
                } catch (IOException e2) {
                    SLog.e("FileTracer", "flushBuffer exception", e2);
                }
                this.k = false;
            } finally {
                this.j.b();
            }
        }
    }

    private Writer[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            File[] a2 = c().a();
            if (a2 != null && a2.length >= 2) {
                File file = a2[0];
                if ((file != null && !file.equals(this.f39168d)) || (this.f39166b == null && file != null)) {
                    this.f39168d = file;
                    h();
                    try {
                        this.f39166b = new FileWriter(this.f39168d, true);
                    } catch (IOException unused) {
                        this.f39166b = null;
                        SLog.e(SLog.TAG, "-->obtainFileWriter() old log file permission denied");
                    }
                }
                File file2 = a2[1];
                if ((file2 != null && !file2.equals(this.f39169e)) || (this.f39167c == null && file2 != null)) {
                    this.f39169e = file2;
                    i();
                    try {
                        this.f39167c = new FileWriter(this.f39169e, true);
                    } catch (IOException unused2) {
                        this.f39167c = null;
                        SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
                    }
                }
            }
            return new Writer[]{this.f39166b, this.f39167c};
        }
        return (Writer[]) invokeV.objValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            try {
                if (this.f39166b != null) {
                    this.f39166b.flush();
                    this.f39166b.close();
                }
            } catch (IOException e2) {
                SLog.e(SLog.TAG, "-->closeFileWriter() exception:", e2);
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            try {
                if (this.f39167c != null) {
                    this.f39167c.flush();
                    this.f39167c.close();
                }
            } catch (IOException e2) {
                SLog.e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e2);
            }
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            synchronized (this) {
                if (this.f39173i == this.f39171g) {
                    this.f39173i = this.f39172h;
                    this.j = this.f39171g;
                } else {
                    this.f39173i = this.f39171g;
                    this.j = this.f39172h;
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.m.hasMessages(1024)) {
                this.m.removeMessages(1024);
            }
            this.m.sendEmptyMessage(1024);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h();
            i();
            this.l.quit();
        }
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39165a : (b) invokeV.objValue;
    }

    @Override // com.tencent.open.log.Tracer
    public void doTrace(int i2, Thread thread, long j, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), thread, Long.valueOf(j), str, str2, th}) == null) {
            a(e().a(i2, thread, j, str, str2, th));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, message)) == null) {
            if (message.what != 1024) {
                return true;
            }
            f();
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i2, boolean z, g gVar, b bVar) {
        super(i2, z, gVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), gVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), (g) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        a(bVar);
        this.f39171g = new f();
        this.f39172h = new f();
        this.f39173i = this.f39171g;
        this.j = this.f39172h;
        this.f39170f = new char[bVar.d()];
        HandlerThread handlerThread = new HandlerThread(bVar.c(), bVar.f());
        this.l = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (!this.l.isAlive() || this.l.getLooper() == null) {
            return;
        }
        this.m = new Handler(this.l.getLooper(), this);
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            this.f39173i.a(str);
            if (this.f39173i.a() >= c().d()) {
                a();
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f39165a = bVar;
        }
    }
}
