package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes8.dex */
public class a extends Tracer implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public FileWriter f59109b;

    /* renamed from: c  reason: collision with root package name */
    public FileWriter f59110c;

    /* renamed from: d  reason: collision with root package name */
    public File f59111d;

    /* renamed from: e  reason: collision with root package name */
    public File f59112e;

    /* renamed from: f  reason: collision with root package name */
    public char[] f59113f;

    /* renamed from: g  reason: collision with root package name */
    public volatile f f59114g;

    /* renamed from: h  reason: collision with root package name */
    public volatile f f59115h;

    /* renamed from: i  reason: collision with root package name */
    public volatile f f59116i;

    /* renamed from: j  reason: collision with root package name */
    public volatile f f59117j;
    public volatile boolean k;
    public HandlerThread l;
    public Handler m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        this(c.f59127b, true, g.a, bVar);
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
                    this.f59117j.a(g(), this.f59113f);
                } catch (IOException e2) {
                    SLog.e("FileTracer", "flushBuffer exception", e2);
                }
                this.k = false;
            } finally {
                this.f59117j.b();
            }
        }
    }

    private Writer[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            File[] a = c().a();
            if (a != null && a.length >= 2) {
                File file = a[0];
                if ((file != null && !file.equals(this.f59111d)) || (this.f59109b == null && file != null)) {
                    this.f59111d = file;
                    h();
                    try {
                        this.f59109b = new FileWriter(this.f59111d, true);
                    } catch (IOException unused) {
                        this.f59109b = null;
                        SLog.e(SLog.TAG, "-->obtainFileWriter() old log file permission denied");
                    }
                }
                File file2 = a[1];
                if ((file2 != null && !file2.equals(this.f59112e)) || (this.f59110c == null && file2 != null)) {
                    this.f59112e = file2;
                    i();
                    try {
                        this.f59110c = new FileWriter(this.f59112e, true);
                    } catch (IOException unused2) {
                        this.f59110c = null;
                        SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
                    }
                }
            }
            return new Writer[]{this.f59109b, this.f59110c};
        }
        return (Writer[]) invokeV.objValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            try {
                if (this.f59109b != null) {
                    this.f59109b.flush();
                    this.f59109b.close();
                }
            } catch (IOException e2) {
                SLog.e(SLog.TAG, "-->closeFileWriter() exception:", e2);
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            try {
                if (this.f59110c != null) {
                    this.f59110c.flush();
                    this.f59110c.close();
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
                if (this.f59116i == this.f59114g) {
                    this.f59116i = this.f59115h;
                    this.f59117j = this.f59114g;
                } else {
                    this.f59116i = this.f59114g;
                    this.f59117j = this.f59115h;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (b) invokeV.objValue;
    }

    @Override // com.tencent.open.log.Tracer
    public void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), thread, Long.valueOf(j2), str, str2, th}) == null) {
            a(e().a(i2, thread, j2, str, str2, th));
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
        this.f59114g = new f();
        this.f59115h = new f();
        this.f59116i = this.f59114g;
        this.f59117j = this.f59115h;
        this.f59113f = new char[bVar.d()];
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
            this.f59116i.a(str);
            if (this.f59116i.a() >= c().d()) {
                a();
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.a = bVar;
        }
    }
}
