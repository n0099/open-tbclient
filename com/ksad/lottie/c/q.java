package com.ksad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f33732a;

    /* renamed from: b  reason: collision with root package name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f33733b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(762569756, "Lcom/ksad/lottie/c/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(762569756, "Lcom/ksad/lottie/c/q;");
                return;
            }
        }
        f33732a = new LinearInterpolator();
    }

    public q() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static SparseArrayCompat<WeakReference<Interpolator>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f33733b == null) {
                f33733b = new SparseArrayCompat<>();
            }
            return f33733b;
        }
        return (SparseArrayCompat) invokeV.objValue;
    }

    public static <T> com.ksad.lottie.e.a<T> a(JsonReader jsonReader, float f2, aj<T> ajVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{jsonReader, Float.valueOf(f2), ajVar})) == null) ? new com.ksad.lottie.e.a<>(ajVar.b(jsonReader, f2)) : (com.ksad.lottie.e.a) invokeCommon.objValue;
    }

    public static <T> com.ksad.lottie.e.a<T> a(JsonReader jsonReader, com.ksad.lottie.d dVar, float f2, aj<T> ajVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{jsonReader, dVar, Float.valueOf(f2), ajVar, Boolean.valueOf(z)})) == null) ? z ? a(dVar, jsonReader, f2, ajVar) : a(jsonReader, f2, ajVar) : (com.ksad.lottie.e.a) invokeCommon.objValue;
    }

    public static <T> com.ksad.lottie.e.a<T> a(com.ksad.lottie.d dVar, JsonReader jsonReader, float f2, aj<T> ajVar) {
        InterceptResult invokeCommon;
        Interpolator interpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{dVar, jsonReader, Float.valueOf(f2), ajVar})) == null) {
            jsonReader.beginObject();
            boolean z = false;
            PointF pointF = null;
            PointF pointF2 = null;
            T t = null;
            T t2 = null;
            float f3 = 0.0f;
            PointF pointF3 = null;
            PointF pointF4 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c2 = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != 101) {
                    if (hashCode != 111) {
                        if (hashCode != 3701) {
                            if (hashCode != 3707) {
                                if (hashCode != 104) {
                                    if (hashCode != 105) {
                                        if (hashCode != 115) {
                                            if (hashCode == 116 && nextName.equals("t")) {
                                                c2 = 0;
                                            }
                                        } else if (nextName.equals("s")) {
                                            c2 = 1;
                                        }
                                    } else if (nextName.equals("i")) {
                                        c2 = 4;
                                    }
                                } else if (nextName.equals("h")) {
                                    c2 = 5;
                                }
                            } else if (nextName.equals("to")) {
                                c2 = 6;
                            }
                        } else if (nextName.equals(Config.FEED_LIST_PART)) {
                            c2 = 7;
                        }
                    } else if (nextName.equals(Config.OS)) {
                        c2 = 3;
                    }
                } else if (nextName.equals("e")) {
                    c2 = 2;
                }
                switch (c2) {
                    case 0:
                        f3 = (float) jsonReader.nextDouble();
                        break;
                    case 1:
                        t = ajVar.b(jsonReader, f2);
                        break;
                    case 2:
                        t2 = ajVar.b(jsonReader, f2);
                        break;
                    case 3:
                        pointF = p.b(jsonReader, f2);
                        break;
                    case 4:
                        pointF2 = p.b(jsonReader, f2);
                        break;
                    case 5:
                        if (jsonReader.nextInt() != 1) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    case 6:
                        pointF3 = p.b(jsonReader, f2);
                        break;
                    case 7:
                        pointF4 = p.b(jsonReader, f2);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (z) {
                interpolator = f33732a;
                t2 = t;
            } else if (pointF == null || pointF2 == null) {
                interpolator = f33732a;
            } else {
                float f4 = -f2;
                pointF.x = com.ksad.lottie.d.e.b(pointF.x, f4, f2);
                pointF.y = com.ksad.lottie.d.e.b(pointF.y, -100.0f, 100.0f);
                pointF2.x = com.ksad.lottie.d.e.b(pointF2.x, f4, f2);
                float b2 = com.ksad.lottie.d.e.b(pointF2.y, -100.0f, 100.0f);
                pointF2.y = b2;
                int a2 = com.ksad.lottie.d.f.a(pointF.x, pointF.y, pointF2.x, b2);
                WeakReference<Interpolator> a3 = a(a2);
                Interpolator interpolator2 = a3 != null ? a3.get() : null;
                if (a3 == null || interpolator2 == null) {
                    interpolator2 = PathInterpolatorCompat.create(pointF.x / f2, pointF.y / f2, pointF2.x / f2, pointF2.y / f2);
                    try {
                        a(a2, new WeakReference(interpolator2));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
                interpolator = interpolator2;
            }
            com.ksad.lottie.e.a<T> aVar = new com.ksad.lottie.e.a<>(dVar, t, t2, interpolator, f3, null);
            aVar.f33779f = pointF3;
            aVar.f33780g = pointF4;
            return aVar;
        }
        return (com.ksad.lottie.e.a) invokeCommon.objValue;
    }

    @Nullable
    public static WeakReference<Interpolator> a(int i2) {
        InterceptResult invokeI;
        WeakReference<Interpolator> weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) {
            synchronized (q.class) {
                weakReference = a().get(i2);
            }
            return weakReference;
        }
        return (WeakReference) invokeI.objValue;
    }

    public static void a(int i2, WeakReference<Interpolator> weakReference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65543, null, i2, weakReference) == null) {
            synchronized (q.class) {
                f33733b.put(i2, weakReference);
            }
        }
    }
}
