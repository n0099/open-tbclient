package com.kwad.sdk.glide.load.engine.a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
/* loaded from: classes7.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f37978a;

    /* renamed from: b  reason: collision with root package name */
    public final int f37979b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f37980c;

    /* renamed from: d  reason: collision with root package name */
    public final int f37981d;

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final int f37982a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Context f37983b;

        /* renamed from: c  reason: collision with root package name */
        public ActivityManager f37984c;

        /* renamed from: d  reason: collision with root package name */
        public c f37985d;

        /* renamed from: e  reason: collision with root package name */
        public float f37986e;

        /* renamed from: f  reason: collision with root package name */
        public float f37987f;

        /* renamed from: g  reason: collision with root package name */
        public float f37988g;

        /* renamed from: h  reason: collision with root package name */
        public float f37989h;

        /* renamed from: i  reason: collision with root package name */
        public int f37990i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1538488692, "Lcom/kwad/sdk/glide/load/engine/a/i$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1538488692, "Lcom/kwad/sdk/glide/load/engine/a/i$a;");
                    return;
                }
            }
            f37982a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f37986e = 2.0f;
            this.f37987f = f37982a;
            this.f37988g = 0.4f;
            this.f37989h = 0.33f;
            this.f37990i = 4194304;
            this.f37983b = context;
            this.f37984c = (ActivityManager) context.getSystemService("activity");
            this.f37985d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !i.a(this.f37984c)) {
                return;
            }
            this.f37987f = 0.0f;
        }

        public i a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new i(this) : (i) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final DisplayMetrics f37991a;

        public b(DisplayMetrics displayMetrics) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {displayMetrics};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37991a = displayMetrics;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37991a.widthPixels : invokeV.intValue;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37991a.heightPixels : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        int a();

        int b();
    }

    public i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37980c = aVar.f37983b;
        this.f37981d = a(aVar.f37984c) ? aVar.f37990i / 2 : aVar.f37990i;
        int a2 = a(aVar.f37984c, aVar.f37988g, aVar.f37989h);
        float a3 = aVar.f37985d.a() * aVar.f37985d.b() * 4;
        int round = Math.round(aVar.f37987f * a3);
        int round2 = Math.round(a3 * aVar.f37986e);
        int i4 = a2 - this.f37981d;
        int i5 = round2 + round;
        if (i5 <= i4) {
            this.f37979b = round2;
            this.f37978a = round;
        } else {
            float f2 = i4;
            float f3 = aVar.f37987f;
            float f4 = aVar.f37986e;
            float f5 = f2 / (f3 + f4);
            this.f37979b = Math.round(f4 * f5);
            this.f37978a = Math.round(f5 * aVar.f37987f);
        }
        if (Log.isLoggable(MemorySizeCalculator.TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f37979b));
            sb.append(", pool size: ");
            sb.append(a(this.f37978a));
            sb.append(", byte array size: ");
            sb.append(a(this.f37981d));
            sb.append(", memory class limited? ");
            sb.append(i5 > a2);
            sb.append(", max size: ");
            sb.append(a(a2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f37984c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.f37984c));
            Log.d(MemorySizeCalculator.TAG, sb.toString());
        }
    }

    public static int a(ActivityManager activityManager, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{activityManager, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            boolean a2 = a(activityManager);
            float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
            if (a2) {
                f2 = f3;
            }
            return Math.round(memoryClass * f2);
        }
        return invokeCommon.intValue;
    }

    private String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? Formatter.formatFileSize(this.f37980c, i2) : (String) invokeI.objValue;
    }

    @TargetApi(19)
    public static boolean a(ActivityManager activityManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activityManager)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return activityManager.isLowRamDevice();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37979b : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37978a : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37981d : invokeV.intValue;
    }
}
