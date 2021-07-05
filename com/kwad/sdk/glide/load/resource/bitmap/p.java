package com.kwad.sdk.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.kwad.sdk.glide.load.DecodeFormat;
import java.io.File;
/* loaded from: classes7.dex */
public final class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final File f38235a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile p f38236d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f38237b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f38238c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-32649138, "Lcom/kwad/sdk/glide/load/resource/bitmap/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-32649138, "Lcom/kwad/sdk/glide/load/resource/bitmap/p;");
                return;
            }
        }
        f38235a = new File("/proc/self/fd");
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38238c = true;
    }

    public static p a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f38236d == null) {
                synchronized (p.class) {
                    if (f38236d == null) {
                        f38236d = new p();
                    }
                }
            }
            return f38236d;
        }
        return (p) invokeV.objValue;
    }

    private synchronized boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            synchronized (this) {
                boolean z2 = true;
                int i2 = this.f38237b + 1;
                this.f38237b = i2;
                if (i2 >= 50) {
                    this.f38237b = 0;
                    int length = f38235a.list().length;
                    if (length >= 700) {
                        z2 = false;
                    }
                    this.f38238c = z2;
                    if (!this.f38238c && Log.isLoggable(Downsampler.TAG, 5)) {
                        Log.w(Downsampler.TAG, "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
                    }
                }
                z = this.f38238c;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @TargetApi(26)
    public boolean a(int i2, int i3, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), options, decodeFormat, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!z || Build.VERSION.SDK_INT < 26 || z2) {
                return false;
            }
            boolean z3 = i2 >= 128 && i3 >= 128 && b();
            if (z3) {
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                options.inMutable = false;
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }
}
