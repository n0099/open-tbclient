package com.tencent.open.a;

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
public class a extends i implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f38876a;

    /* renamed from: b  reason: collision with root package name */
    public FileWriter f38877b;

    /* renamed from: c  reason: collision with root package name */
    public File f38878c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f38879d;

    /* renamed from: e  reason: collision with root package name */
    public volatile g f38880e;

    /* renamed from: f  reason: collision with root package name */
    public volatile g f38881f;

    /* renamed from: g  reason: collision with root package name */
    public volatile g f38882g;

    /* renamed from: h  reason: collision with root package name */
    public volatile g f38883h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f38884i;
    public HandlerThread j;
    public Handler k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        this(c.f38898b, true, h.f38916a, bVar);
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
                this(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), (h) objArr2[2], (b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && Thread.currentThread() == this.j && !this.f38884i) {
            this.f38884i = true;
            i();
            try {
                this.f38883h.a(g(), this.f38879d);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f38883h.b();
                throw th;
            }
            this.f38883h.b();
            this.f38884i = false;
        }
    }

    private Writer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            File a2 = c().a();
            if ((a2 != null && !a2.equals(this.f38878c)) || (this.f38877b == null && a2 != null)) {
                this.f38878c = a2;
                h();
                try {
                    this.f38877b = new FileWriter(this.f38878c, true);
                } catch (IOException unused) {
                    return null;
                }
            }
            return this.f38877b;
        }
        return (Writer) invokeV.objValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                if (this.f38877b != null) {
                    this.f38877b.flush();
                    this.f38877b.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            synchronized (this) {
                if (this.f38882g == this.f38880e) {
                    this.f38882g = this.f38881f;
                    this.f38883h = this.f38880e;
                } else {
                    this.f38882g = this.f38880e;
                    this.f38883h = this.f38881f;
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.k.hasMessages(1024)) {
                this.k.removeMessages(1024);
            }
            this.k.sendEmptyMessage(1024);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h();
            this.j.quit();
        }
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38876a : (b) invokeV.objValue;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, message)) == null) {
            if (message.what != 1024) {
                return true;
            }
            f();
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i2, boolean z, h hVar, b bVar) {
        super(i2, z, hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), hVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), (h) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38884i = false;
        a(bVar);
        this.f38880e = new g();
        this.f38881f = new g();
        this.f38882g = this.f38880e;
        this.f38883h = this.f38881f;
        this.f38879d = new char[bVar.d()];
        g();
        HandlerThread handlerThread = new HandlerThread(bVar.c(), bVar.f());
        this.j = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (!this.j.isAlive() || this.j.getLooper() == null) {
            return;
        }
        this.k = new Handler(this.j.getLooper(), this);
    }

    @Override // com.tencent.open.a.i
    public void a(int i2, Thread thread, long j, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), thread, Long.valueOf(j), str, str2, th}) == null) {
            a(e().a(i2, thread, j, str, str2, th));
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f38882g.a(str);
            if (this.f38882g.a() >= c().d()) {
                a();
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f38876a = bVar;
        }
    }
}
