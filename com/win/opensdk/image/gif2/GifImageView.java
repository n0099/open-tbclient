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
/* loaded from: classes10.dex */
public class GifImageView extends ImageView implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public o0 f76676a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f76677b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f76678c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f76679d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f76680e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f76681f;

    /* renamed from: g  reason: collision with root package name */
    public Thread f76682g;

    /* renamed from: h  reason: collision with root package name */
    public long f76683h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f76684i;

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f76685j;

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
        this.f76678c = new Handler(Looper.getMainLooper());
        this.f76683h = -1L;
        this.f76684i = new s0(this);
        this.f76685j = new t0(this);
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
        this.f76678c = new Handler(Looper.getMainLooper());
        this.f76683h = -1L;
        this.f76684i = new s0(this);
        this.f76685j = new t0(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f76679d = false;
            this.f76680e = false;
            this.f76681f = true;
            d();
            this.f76678c.post(this.f76685j);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            o0 o0Var = this.f76676a;
            if (o0Var.n == i2 || !o0Var.a(i2 - 1) || this.f76679d) {
                return;
            }
            this.f76680e = true;
            c();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f76679d = true;
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((this.f76679d || this.f76680e) && this.f76676a != null && this.f76682g == null) {
                Thread thread = new Thread(this);
                this.f76682g = thread;
                thread.start();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f76679d = false;
            Thread thread = this.f76682g;
            if (thread != null) {
                thread.interrupt();
                this.f76682g = null;
            }
        }
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f76676a.p.f76762c : invokeV.intValue;
    }

    public long getFramesDisplayDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f76683h : invokeV.longValue;
    }

    public int getGifHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f76676a.p.f76766g : invokeV.intValue;
    }

    public int getGifWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f76676a.p.f76765f : invokeV.intValue;
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
                if (!this.f76679d && !this.f76680e) {
                    break;
                }
                o0 o0Var2 = this.f76676a;
                int i5 = o0Var2.p.f76762c;
                int i6 = -1;
                boolean z = true;
                if (i5 > 0) {
                    if (o0Var2.n == i5 - 1) {
                        o0Var2.o++;
                    }
                    int i7 = o0Var2.p.m;
                    if (i7 == -1 || o0Var2.o <= i7) {
                        o0Var2.n = (o0Var2.n + 1) % o0Var2.p.f76762c;
                        long nanoTime = System.nanoTime();
                        this.f76677b = this.f76676a.b();
                        long j2 = (System.nanoTime() - nanoTime) / 1000000;
                        this.f76678c.post(this.f76684i);
                        this.f76680e = false;
                        if (this.f76679d || !z) {
                            this.f76679d = false;
                            break;
                        }
                        try {
                            o0Var = this.f76676a;
                            q0Var = o0Var.p;
                            i2 = q0Var.f76762c;
                        } catch (InterruptedException unused) {
                        }
                        if (i2 > 0 && (i4 = o0Var.n) >= 0) {
                            if (i4 >= 0 && i4 < i2) {
                                i6 = ((p0) q0Var.f76764e.get(i4)).f76755i;
                            }
                            i3 = (int) (i6 - j2);
                            if (i3 > 0) {
                                Thread.sleep(this.f76683h > 0 ? this.f76683h : i3);
                            }
                        }
                        i6 = 0;
                        i3 = (int) (i6 - j2);
                        if (i3 > 0) {
                        }
                    }
                }
                z = false;
                long nanoTime2 = System.nanoTime();
                this.f76677b = this.f76676a.b();
                long j22 = (System.nanoTime() - nanoTime2) / 1000000;
                this.f76678c.post(this.f76684i);
                this.f76680e = false;
                if (this.f76679d) {
                }
                this.f76679d = false;
                break;
            } while (this.f76679d);
            if (this.f76681f) {
                this.f76678c.post(this.f76685j);
            }
            this.f76682g = null;
        }
    }

    public void setBytes(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            o0 o0Var = new o0();
            this.f76676a = o0Var;
            try {
                o0Var.a(bArr);
                if (this.f76679d) {
                    c();
                } else {
                    a(0);
                }
            } catch (Exception unused) {
                this.f76676a = null;
            }
        }
    }

    public void setFramesDisplayDuration(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) {
            this.f76683h = j2;
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
