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
import com.win.opensdk.S;
import com.win.opensdk.T;
import com.win.opensdk.U;
import com.win.opensdk.W;
import com.win.opensdk.X;
import com.win.opensdk.Y;
import com.win.opensdk.Z;
import com.win.opensdk.a0;
/* loaded from: classes7.dex */
public class GifImageView extends ImageView implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public S f42588a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f42589b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f42590c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42591d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42592e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42593f;

    /* renamed from: g  reason: collision with root package name */
    public Thread f42594g;

    /* renamed from: h  reason: collision with root package name */
    public long f42595h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f42596i;
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
        this.f42590c = new Handler(Looper.getMainLooper());
        this.f42595h = -1L;
        this.f42596i = new W(this);
        this.j = new X(this);
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
        this.f42590c = new Handler(Looper.getMainLooper());
        this.f42595h = -1L;
        this.f42596i = new W(this);
        this.j = new X(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f42591d = false;
            this.f42592e = false;
            this.f42593f = true;
            d();
            this.f42590c.post(this.j);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            S s = this.f42588a;
            if (s.n == i2 || !s.a(i2 - 1) || this.f42591d) {
                return;
            }
            this.f42592e = true;
            c();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f42591d = true;
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((this.f42591d || this.f42592e) && this.f42588a != null && this.f42594g == null) {
                Thread thread = new Thread(this);
                this.f42594g = thread;
                thread.start();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f42591d = false;
            Thread thread = this.f42594g;
            if (thread != null) {
                thread.interrupt();
                this.f42594g = null;
            }
        }
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f42588a.p.f42480c : invokeV.intValue;
    }

    public long getFramesDisplayDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f42595h : invokeV.longValue;
    }

    public int getGifHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f42588a.p.f42484g : invokeV.intValue;
    }

    public int getGifWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f42588a.p.f42483f : invokeV.intValue;
    }

    public Z getOnAnimationStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (Z) invokeV.objValue;
    }

    public a0 getOnFrameAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (a0) invokeV.objValue;
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
        S s;
        U u;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            do {
                if (!this.f42591d && !this.f42592e) {
                    break;
                }
                S s2 = this.f42588a;
                int i5 = s2.p.f42480c;
                int i6 = -1;
                boolean z = true;
                if (i5 > 0) {
                    if (s2.n == i5 - 1) {
                        s2.o++;
                    }
                    int i7 = s2.p.m;
                    if (i7 == -1 || s2.o <= i7) {
                        s2.n = (s2.n + 1) % s2.p.f42480c;
                        long nanoTime = System.nanoTime();
                        this.f42589b = this.f42588a.b();
                        long j = (System.nanoTime() - nanoTime) / 1000000;
                        this.f42590c.post(this.f42596i);
                        this.f42592e = false;
                        if (this.f42591d || !z) {
                            this.f42591d = false;
                            break;
                        }
                        try {
                            s = this.f42588a;
                            u = s.p;
                            i2 = u.f42480c;
                        } catch (InterruptedException unused) {
                        }
                        if (i2 > 0 && (i4 = s.n) >= 0) {
                            if (i4 >= 0 && i4 < i2) {
                                i6 = ((T) u.f42482e.get(i4)).f42476i;
                            }
                            i3 = (int) (i6 - j);
                            if (i3 > 0) {
                                Thread.sleep(this.f42595h > 0 ? this.f42595h : i3);
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
                this.f42589b = this.f42588a.b();
                long j2 = (System.nanoTime() - nanoTime2) / 1000000;
                this.f42590c.post(this.f42596i);
                this.f42592e = false;
                if (this.f42591d) {
                }
                this.f42591d = false;
                break;
            } while (this.f42591d);
            if (this.f42593f) {
                this.f42590c.post(this.j);
            }
            this.f42594g = null;
        }
    }

    public void setBytes(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            S s = new S();
            this.f42588a = s;
            try {
                s.a(bArr);
                if (this.f42591d) {
                    c();
                } else {
                    a(0);
                }
            } catch (Exception unused) {
                this.f42588a = null;
            }
        }
    }

    public void setFramesDisplayDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.f42595h = j;
        }
    }

    public void setOnAnimationStart(Y y) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, y) == null) {
        }
    }

    public void setOnAnimationStop(Z z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, z) == null) {
        }
    }

    public void setOnFrameAvailable(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, a0Var) == null) {
        }
    }
}
