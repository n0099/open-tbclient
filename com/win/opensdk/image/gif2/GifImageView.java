package com.win.opensdk.image.gif2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.o0;
import com.win.opensdk.p0;
import com.win.opensdk.q0;
import com.win.opensdk.s0;
import com.win.opensdk.t0;
import com.win.opensdk.u0;
import com.win.opensdk.v0;
import com.win.opensdk.w0;
/* loaded from: classes6.dex */
public class GifImageView extends ImageView implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public o0 f39834a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f39835b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f39836c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39837d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39838e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39839f;

    /* renamed from: g  reason: collision with root package name */
    public Thread f39840g;

    /* renamed from: h  reason: collision with root package name */
    public long f39841h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f39842i;
    public final Runnable j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39836c = new Handler(Looper.getMainLooper());
        this.f39841h = -1L;
        this.f39842i = new s0(this);
        this.j = new t0(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39836c = new Handler(Looper.getMainLooper());
        this.f39841h = -1L;
        this.f39842i = new s0(this);
        this.j = new t0(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f39837d = false;
            this.f39838e = false;
            this.f39839f = true;
            d();
            this.f39836c.post(this.j);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            o0 o0Var = this.f39834a;
            if (o0Var.n == i2 || !o0Var.a(i2 - 1) || this.f39837d) {
                return;
            }
            this.f39838e = true;
            c();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f39837d = true;
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((this.f39837d || this.f39838e) && this.f39834a != null && this.f39840g == null) {
                Thread thread = new Thread(this);
                this.f39840g = thread;
                thread.start();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f39837d = false;
            Thread thread = this.f39840g;
            if (thread != null) {
                thread.interrupt();
                this.f39840g = null;
            }
        }
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f39834a.p.f39915c : invokeV.intValue;
    }

    public long getFramesDisplayDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39841h : invokeV.longValue;
    }

    public int getGifHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f39834a.p.f39919g : invokeV.intValue;
    }

    public int getGifWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39834a.p.f39918f : invokeV.intValue;
    }

    public v0 getOnAnimationStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (v0) invokeV.objValue;
    }

    public w0 getOnFrameAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (w0) invokeV.objValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            a();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:18|(4:20|(1:22)|23|(8:27|28|29|30|32|33|34|(1:60)(7:37|38|(4:(1:45)|46|(3:48|(1:50)(1:52)|51)|53)|56|46|(0)|53)))|65|28|29|30|32|33|34|(1:59)(1:61)|60) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
        r7 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0088 A[Catch: InterruptedException -> 0x0096, TryCatch #0 {InterruptedException -> 0x0096, blocks: (B:31:0x0066, B:33:0x006e, B:38:0x0077, B:40:0x0083, B:42:0x0088, B:44:0x008e, B:46:0x0092, B:45:0x0091), top: B:61:0x0066 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        o0 o0Var;
        q0 q0Var;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            do {
                if (!this.f39837d && !this.f39838e) {
                    break;
                }
                o0 o0Var2 = this.f39834a;
                int i5 = o0Var2.p.f39915c;
                int i6 = -1;
                boolean z = true;
                if (i5 > 0) {
                    if (o0Var2.n == i5 - 1) {
                        o0Var2.o++;
                    }
                    int i7 = o0Var2.p.m;
                    if (i7 == -1 || o0Var2.o <= i7) {
                        o0Var2.n = (o0Var2.n + 1) % o0Var2.p.f39915c;
                        long nanoTime = System.nanoTime();
                        this.f39835b = this.f39834a.b();
                        long j = (System.nanoTime() - nanoTime) / 1000000;
                        this.f39836c.post(this.f39842i);
                        this.f39838e = false;
                        if (this.f39837d || !z) {
                            this.f39837d = false;
                            break;
                        }
                        try {
                            o0Var = this.f39834a;
                            q0Var = o0Var.p;
                            i2 = q0Var.f39915c;
                        } catch (InterruptedException unused) {
                        }
                        if (i2 > 0 && (i4 = o0Var.n) >= 0) {
                            if (i4 >= 0 && i4 < i2) {
                                i6 = ((p0) q0Var.f39917e.get(i4)).f39909i;
                            }
                            i3 = (int) (i6 - j);
                            if (i3 > 0) {
                                Thread.sleep(this.f39841h > 0 ? this.f39841h : i3);
                            }
                        }
                        i6 = 0;
                        i3 = (int) (i6 - j);
                        if (i3 > 0) {
                        }
                    }
                }
                z = false;
                long nanoTime2 = System.nanoTime();
                this.f39835b = this.f39834a.b();
                long j2 = (System.nanoTime() - nanoTime2) / 1000000;
                this.f39836c.post(this.f39842i);
                this.f39838e = false;
                if (this.f39837d) {
                }
                this.f39837d = false;
                break;
            } while (this.f39837d);
            if (this.f39839f) {
                this.f39836c.post(this.j);
            }
            this.f39840g = null;
        }
    }

    public void setBytes(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            o0 o0Var = new o0();
            this.f39834a = o0Var;
            try {
                o0Var.a(bArr);
                if (this.f39837d) {
                    c();
                } else {
                    a(0);
                }
            } catch (Exception unused) {
                this.f39834a = null;
            }
        }
    }

    public void setFramesDisplayDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.f39841h = j;
        }
    }

    public void setOnAnimationStart(u0 u0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, u0Var) == null) {
        }
    }

    public void setOnAnimationStop(v0 v0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, v0Var) == null) {
        }
    }

    public void setOnFrameAvailable(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, w0Var) == null) {
        }
    }
}
