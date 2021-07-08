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
/* loaded from: classes6.dex */
public class GifImageView extends ImageView implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public S f39602a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f39603b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f39604c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39605d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39606e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39607f;

    /* renamed from: g  reason: collision with root package name */
    public Thread f39608g;

    /* renamed from: h  reason: collision with root package name */
    public long f39609h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f39610i;
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
        this.f39604c = new Handler(Looper.getMainLooper());
        this.f39609h = -1L;
        this.f39610i = new W(this);
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
        this.f39604c = new Handler(Looper.getMainLooper());
        this.f39609h = -1L;
        this.f39610i = new W(this);
        this.j = new X(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f39605d = false;
            this.f39606e = false;
            this.f39607f = true;
            d();
            this.f39604c.post(this.j);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            S s = this.f39602a;
            if (s.n == i2 || !s.a(i2 - 1) || this.f39605d) {
                return;
            }
            this.f39606e = true;
            c();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f39605d = true;
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((this.f39605d || this.f39606e) && this.f39602a != null && this.f39608g == null) {
                Thread thread = new Thread(this);
                this.f39608g = thread;
                thread.start();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f39605d = false;
            Thread thread = this.f39608g;
            if (thread != null) {
                thread.interrupt();
                this.f39608g = null;
            }
        }
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f39602a.p.f39494c : invokeV.intValue;
    }

    public long getFramesDisplayDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39609h : invokeV.longValue;
    }

    public int getGifHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f39602a.p.f39498g : invokeV.intValue;
    }

    public int getGifWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39602a.p.f39497f : invokeV.intValue;
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
                if (!this.f39605d && !this.f39606e) {
                    break;
                }
                S s2 = this.f39602a;
                int i5 = s2.p.f39494c;
                int i6 = -1;
                boolean z = true;
                if (i5 > 0) {
                    if (s2.n == i5 - 1) {
                        s2.o++;
                    }
                    int i7 = s2.p.m;
                    if (i7 == -1 || s2.o <= i7) {
                        s2.n = (s2.n + 1) % s2.p.f39494c;
                        long nanoTime = System.nanoTime();
                        this.f39603b = this.f39602a.b();
                        long j = (System.nanoTime() - nanoTime) / 1000000;
                        this.f39604c.post(this.f39610i);
                        this.f39606e = false;
                        if (this.f39605d || !z) {
                            this.f39605d = false;
                            break;
                        }
                        try {
                            s = this.f39602a;
                            u = s.p;
                            i2 = u.f39494c;
                        } catch (InterruptedException unused) {
                        }
                        if (i2 > 0 && (i4 = s.n) >= 0) {
                            if (i4 >= 0 && i4 < i2) {
                                i6 = ((T) u.f39496e.get(i4)).f39490i;
                            }
                            i3 = (int) (i6 - j);
                            if (i3 > 0) {
                                Thread.sleep(this.f39609h > 0 ? this.f39609h : i3);
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
                this.f39603b = this.f39602a.b();
                long j2 = (System.nanoTime() - nanoTime2) / 1000000;
                this.f39604c.post(this.f39610i);
                this.f39606e = false;
                if (this.f39605d) {
                }
                this.f39605d = false;
                break;
            } while (this.f39605d);
            if (this.f39607f) {
                this.f39604c.post(this.j);
            }
            this.f39608g = null;
        }
    }

    public void setBytes(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            S s = new S();
            this.f39602a = s;
            try {
                s.a(bArr);
                if (this.f39605d) {
                    c();
                } else {
                    a(0);
                }
            } catch (Exception unused) {
                this.f39602a = null;
            }
        }
    }

    public void setFramesDisplayDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.f39609h = j;
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
