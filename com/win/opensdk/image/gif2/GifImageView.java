package com.win.opensdk.image.gif2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.q.a.d5;
import c.q.a.g5;
import c.q.a.j4;
import c.q.a.k5;
import c.q.a.n4;
import c.q.a.o5;
import c.q.a.r4;
import c.q.a.z4;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GifImageView extends ImageView implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j4 a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f61050b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f61051c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61052d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61053e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61054f;

    /* renamed from: g  reason: collision with root package name */
    public Thread f61055g;

    /* renamed from: h  reason: collision with root package name */
    public long f61056h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f61057i;

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f61058j;

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
        this.f61051c = new Handler(Looper.getMainLooper());
        this.f61056h = -1L;
        this.f61057i = new z4(this);
        this.f61058j = new d5(this);
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
        this.f61051c = new Handler(Looper.getMainLooper());
        this.f61056h = -1L;
        this.f61057i = new z4(this);
        this.f61058j = new d5(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f61052d = false;
            this.f61053e = false;
            this.f61054f = true;
            d();
            this.f61051c.post(this.f61058j);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            j4 j4Var = this.a;
            if (j4Var.n == i2 || !j4Var.g(i2 - 1) || this.f61052d) {
                return;
            }
            this.f61053e = true;
            c();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f61052d = true;
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((this.f61052d || this.f61053e) && this.a != null && this.f61055g == null) {
                Thread thread = new Thread(this);
                this.f61055g = thread;
                thread.start();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f61052d = false;
            Thread thread = this.f61055g;
            if (thread != null) {
                thread.interrupt();
                this.f61055g = null;
            }
        }
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.p.f30660c : invokeV.intValue;
    }

    public long getFramesDisplayDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f61056h : invokeV.longValue;
    }

    public int getGifHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.p.f30664g : invokeV.intValue;
    }

    public int getGifWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.p.f30663f : invokeV.intValue;
    }

    public k5 getOnAnimationStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (k5) invokeV.objValue;
    }

    public o5 getOnFrameAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (o5) invokeV.objValue;
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
        j4 j4Var;
        r4 r4Var;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            do {
                if (!this.f61052d && !this.f61053e) {
                    break;
                }
                j4 j4Var2 = this.a;
                int i5 = j4Var2.p.f30660c;
                int i6 = -1;
                boolean z = true;
                if (i5 > 0) {
                    if (j4Var2.n == i5 - 1) {
                        j4Var2.o++;
                    }
                    int i7 = j4Var2.p.m;
                    if (i7 == -1 || j4Var2.o <= i7) {
                        j4Var2.n = (j4Var2.n + 1) % j4Var2.p.f30660c;
                        long nanoTime = System.nanoTime();
                        this.f61050b = this.a.h();
                        long j2 = (System.nanoTime() - nanoTime) / 1000000;
                        this.f61051c.post(this.f61057i);
                        this.f61053e = false;
                        if (this.f61052d || !z) {
                            this.f61052d = false;
                            break;
                        }
                        try {
                            j4Var = this.a;
                            r4Var = j4Var.p;
                            i2 = r4Var.f30660c;
                        } catch (InterruptedException unused) {
                        }
                        if (i2 > 0 && (i4 = j4Var.n) >= 0) {
                            if (i4 >= 0 && i4 < i2) {
                                i6 = ((n4) r4Var.f30662e.get(i4)).f30627i;
                            }
                            i3 = (int) (i6 - j2);
                            if (i3 > 0) {
                                Thread.sleep(this.f61056h > 0 ? this.f61056h : i3);
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
                this.f61050b = this.a.h();
                long j22 = (System.nanoTime() - nanoTime2) / 1000000;
                this.f61051c.post(this.f61057i);
                this.f61053e = false;
                if (this.f61052d) {
                }
                this.f61052d = false;
                break;
            } while (this.f61052d);
            if (this.f61054f) {
                this.f61051c.post(this.f61058j);
            }
            this.f61055g = null;
        }
    }

    public void setBytes(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            j4 j4Var = new j4();
            this.a = j4Var;
            try {
                j4Var.a(bArr);
                if (this.f61052d) {
                    c();
                } else {
                    a(0);
                }
            } catch (Exception unused) {
                this.a = null;
            }
        }
    }

    public void setFramesDisplayDuration(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) {
            this.f61056h = j2;
        }
    }

    public void setOnAnimationStart(g5 g5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, g5Var) == null) {
        }
    }

    public void setOnAnimationStop(k5 k5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, k5Var) == null) {
        }
    }

    public void setOnFrameAvailable(o5 o5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, o5Var) == null) {
        }
    }
}
