package com.win.opensdk.image.gif2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.q.a.b5;
import c.q.a.e4;
import c.q.a.f5;
import c.q.a.i4;
import c.q.a.j5;
import c.q.a.m4;
import c.q.a.u4;
import c.q.a.y4;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class GifImageView extends ImageView implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e4 a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f59400b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f59401c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59402d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59403e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59404f;

    /* renamed from: g  reason: collision with root package name */
    public Thread f59405g;

    /* renamed from: h  reason: collision with root package name */
    public long f59406h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f59407i;

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f59408j;

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
        this.f59401c = new Handler(Looper.getMainLooper());
        this.f59406h = -1L;
        this.f59407i = new u4(this);
        this.f59408j = new y4(this);
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
        this.f59401c = new Handler(Looper.getMainLooper());
        this.f59406h = -1L;
        this.f59407i = new u4(this);
        this.f59408j = new y4(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59402d = false;
            this.f59403e = false;
            this.f59404f = true;
            d();
            this.f59401c.post(this.f59408j);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            e4 e4Var = this.a;
            if (e4Var.n == i2 || !e4Var.g(i2 - 1) || this.f59402d) {
                return;
            }
            this.f59403e = true;
            c();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f59402d = true;
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((this.f59402d || this.f59403e) && this.a != null && this.f59405g == null) {
                Thread thread = new Thread(this);
                this.f59405g = thread;
                thread.start();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f59402d = false;
            Thread thread = this.f59405g;
            if (thread != null) {
                thread.interrupt();
                this.f59405g = null;
            }
        }
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.p.f29031c : invokeV.intValue;
    }

    public long getFramesDisplayDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59406h : invokeV.longValue;
    }

    public int getGifHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.p.f29035g : invokeV.intValue;
    }

    public int getGifWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.p.f29034f : invokeV.intValue;
    }

    public f5 getOnAnimationStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (f5) invokeV.objValue;
    }

    public j5 getOnFrameAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (j5) invokeV.objValue;
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
        e4 e4Var;
        m4 m4Var;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            do {
                if (!this.f59402d && !this.f59403e) {
                    break;
                }
                e4 e4Var2 = this.a;
                int i5 = e4Var2.p.f29031c;
                int i6 = -1;
                boolean z = true;
                if (i5 > 0) {
                    if (e4Var2.n == i5 - 1) {
                        e4Var2.o++;
                    }
                    int i7 = e4Var2.p.m;
                    if (i7 == -1 || e4Var2.o <= i7) {
                        e4Var2.n = (e4Var2.n + 1) % e4Var2.p.f29031c;
                        long nanoTime = System.nanoTime();
                        this.f59400b = this.a.h();
                        long j2 = (System.nanoTime() - nanoTime) / 1000000;
                        this.f59401c.post(this.f59407i);
                        this.f59403e = false;
                        if (this.f59402d || !z) {
                            this.f59402d = false;
                            break;
                        }
                        try {
                            e4Var = this.a;
                            m4Var = e4Var.p;
                            i2 = m4Var.f29031c;
                        } catch (InterruptedException unused) {
                        }
                        if (i2 > 0 && (i4 = e4Var.n) >= 0) {
                            if (i4 >= 0 && i4 < i2) {
                                i6 = ((i4) m4Var.f29033e.get(i4)).f28991i;
                            }
                            i3 = (int) (i6 - j2);
                            if (i3 > 0) {
                                Thread.sleep(this.f59406h > 0 ? this.f59406h : i3);
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
                this.f59400b = this.a.h();
                long j22 = (System.nanoTime() - nanoTime2) / 1000000;
                this.f59401c.post(this.f59407i);
                this.f59403e = false;
                if (this.f59402d) {
                }
                this.f59402d = false;
                break;
            } while (this.f59402d);
            if (this.f59404f) {
                this.f59401c.post(this.f59408j);
            }
            this.f59405g = null;
        }
    }

    public void setBytes(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            e4 e4Var = new e4();
            this.a = e4Var;
            try {
                e4Var.a(bArr);
                if (this.f59402d) {
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
            this.f59406h = j2;
        }
    }

    public void setOnAnimationStart(b5 b5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, b5Var) == null) {
        }
    }

    public void setOnAnimationStop(f5 f5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, f5Var) == null) {
        }
    }

    public void setOnFrameAvailable(j5 j5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, j5Var) == null) {
        }
    }
}
