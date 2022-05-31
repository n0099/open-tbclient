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
import com.repackage.cp9;
import com.repackage.dq9;
import com.repackage.gp9;
import com.repackage.op9;
import com.repackage.sp9;
import com.repackage.vp9;
import com.repackage.yo9;
import com.repackage.zp9;
/* loaded from: classes8.dex */
public class GifImageView extends ImageView implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yo9 a;
    public Bitmap b;
    public final Handler c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Thread g;
    public long h;
    public final Runnable i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new Handler(Looper.getMainLooper());
        this.h = -1L;
        this.i = new op9(this);
        this.j = new sp9(this);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new Handler(Looper.getMainLooper());
        this.h = -1L;
        this.i = new op9(this);
        this.j = new sp9(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = false;
            this.e = false;
            this.f = true;
            f();
            this.c.post(this.j);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            yo9 yo9Var = this.a;
            if (yo9Var.n == i || !yo9Var.g(i - 1) || this.d) {
                return;
            }
            this.e = true;
            e();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d = true;
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((this.d || this.e) && this.a != null && this.g == null) {
                Thread thread = new Thread(this);
                this.g = thread;
                thread.start();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d = false;
            Thread thread = this.g;
            if (thread != null) {
                thread.interrupt();
                this.g = null;
            }
        }
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.p.c : invokeV.intValue;
    }

    public long getFramesDisplayDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.h : invokeV.longValue;
    }

    public int getGifHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.p.g : invokeV.intValue;
    }

    public int getGifWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.p.f : invokeV.intValue;
    }

    public zp9 getOnAnimationStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (zp9) invokeV.objValue;
    }

    public dq9 getOnFrameAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (dq9) invokeV.objValue;
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
        yo9 yo9Var;
        gp9 gp9Var;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            do {
                if (!this.d && !this.e) {
                    break;
                }
                yo9 yo9Var2 = this.a;
                int i4 = yo9Var2.p.c;
                int i5 = -1;
                boolean z = true;
                if (i4 > 0) {
                    if (yo9Var2.n == i4 - 1) {
                        yo9Var2.o++;
                    }
                    int i6 = yo9Var2.p.m;
                    if (i6 == -1 || yo9Var2.o <= i6) {
                        yo9Var2.n = (yo9Var2.n + 1) % yo9Var2.p.c;
                        long nanoTime = System.nanoTime();
                        this.b = this.a.h();
                        long j = (System.nanoTime() - nanoTime) / 1000000;
                        this.c.post(this.i);
                        this.e = false;
                        if (this.d || !z) {
                            this.d = false;
                            break;
                        }
                        try {
                            yo9Var = this.a;
                            gp9Var = yo9Var.p;
                            i = gp9Var.c;
                        } catch (InterruptedException unused) {
                        }
                        if (i > 0 && (i3 = yo9Var.n) >= 0) {
                            if (i3 >= 0 && i3 < i) {
                                i5 = ((cp9) gp9Var.e.get(i3)).i;
                            }
                            i2 = (int) (i5 - j);
                            if (i2 > 0) {
                                Thread.sleep(this.h > 0 ? this.h : i2);
                            }
                        }
                        i5 = 0;
                        i2 = (int) (i5 - j);
                        if (i2 > 0) {
                        }
                    }
                }
                z = false;
                long nanoTime2 = System.nanoTime();
                this.b = this.a.h();
                long j2 = (System.nanoTime() - nanoTime2) / 1000000;
                this.c.post(this.i);
                this.e = false;
                if (this.d) {
                }
                this.d = false;
                break;
            } while (this.d);
            if (this.f) {
                this.c.post(this.j);
            }
            this.g = null;
        }
    }

    public void setBytes(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            yo9 yo9Var = new yo9();
            this.a = yo9Var;
            try {
                yo9Var.a(bArr);
                if (this.d) {
                    e();
                } else {
                    b(0);
                }
            } catch (Exception unused) {
                this.a = null;
            }
        }
    }

    public void setFramesDisplayDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.h = j;
        }
    }

    public void setOnAnimationStart(vp9 vp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, vp9Var) == null) {
        }
    }

    public void setOnAnimationStop(zp9 zp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, zp9Var) == null) {
        }
    }

    public void setOnFrameAvailable(dq9 dq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dq9Var) == null) {
        }
    }
}
