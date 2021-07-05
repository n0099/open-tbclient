package com.ksad.lottie.c;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.ColorInt;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.ksad.lottie.c.p$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33731a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1609922416, "Lcom/ksad/lottie/c/p$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1609922416, "Lcom/ksad/lottie/c/p$1;");
                    return;
                }
            }
            int[] iArr = new int[JsonToken.values().length];
            f33731a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33731a[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33731a[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @ColorInt
    public static int a(JsonReader jsonReader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jsonReader)) == null) {
            jsonReader.beginArray();
            int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
            int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
            int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return Color.argb(255, nextDouble, nextDouble2, nextDouble3);
        }
        return invokeL.intValue;
    }

    public static List<PointF> a(JsonReader jsonReader, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, jsonReader, f2)) == null) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                arrayList.add(b(jsonReader, f2));
                jsonReader.endArray();
            }
            jsonReader.endArray();
            return arrayList;
        }
        return (List) invokeLF.objValue;
    }

    public static float b(JsonReader jsonReader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jsonReader)) == null) {
            JsonToken peek = jsonReader.peek();
            int i2 = AnonymousClass1.f33731a[peek.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalArgumentException("Unknown value for token of type " + peek);
                }
                jsonReader.beginArray();
                float nextDouble = (float) jsonReader.nextDouble();
                while (jsonReader.hasNext()) {
                    jsonReader.skipValue();
                }
                jsonReader.endArray();
                return nextDouble;
            }
            return (float) jsonReader.nextDouble();
        }
        return invokeL.floatValue;
    }

    public static PointF b(JsonReader jsonReader, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, jsonReader, f2)) == null) {
            int i2 = AnonymousClass1.f33731a[jsonReader.peek().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return e(jsonReader, f2);
                    }
                    throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
                }
                return d(jsonReader, f2);
            }
            return c(jsonReader, f2);
        }
        return (PointF) invokeLF.objValue;
    }

    public static PointF c(JsonReader jsonReader, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65540, null, jsonReader, f2)) == null) {
            float nextDouble = (float) jsonReader.nextDouble();
            float nextDouble2 = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return new PointF(nextDouble * f2, nextDouble2 * f2);
        }
        return (PointF) invokeLF.objValue;
    }

    public static PointF d(JsonReader jsonReader, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(AdIconUtil.AD_TEXT_ID, null, jsonReader, f2)) == null) {
            jsonReader.beginArray();
            float nextDouble = (float) jsonReader.nextDouble();
            float nextDouble2 = (float) jsonReader.nextDouble();
            while (jsonReader.peek() != JsonToken.END_ARRAY) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return new PointF(nextDouble * f2, nextDouble2 * f2);
        }
        return (PointF) invokeLF.objValue;
    }

    public static PointF e(JsonReader jsonReader, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(AdIconUtil.BAIDU_LOGO_ID, null, jsonReader, f2)) == null) {
            jsonReader.beginObject();
            float f3 = 0.0f;
            float f4 = 0.0f;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c2 = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != 120) {
                    if (hashCode == 121 && nextName.equals("y")) {
                        c2 = 1;
                    }
                } else if (nextName.equals("x")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    f3 = b(jsonReader);
                } else if (c2 != 1) {
                    jsonReader.skipValue();
                } else {
                    f4 = b(jsonReader);
                }
            }
            jsonReader.endObject();
            return new PointF(f3 * f2, f4 * f2);
        }
        return (PointF) invokeLF.objValue;
    }
}
