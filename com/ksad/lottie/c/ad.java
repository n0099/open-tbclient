package com.ksad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class ad implements aj<com.ksad.lottie.model.content.h> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ad f33725a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2130155386, "Lcom/ksad/lottie/c/ad;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2130155386, "Lcom/ksad/lottie/c/ad;");
                return;
            }
        }
        f33725a = new ad();
    }

    public ad() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.c.aj
    /* renamed from: a */
    public com.ksad.lottie.model.content.h b(JsonReader jsonReader, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048576, this, jsonReader, f2)) == null) {
            if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
            }
            jsonReader.beginObject();
            List<PointF> list = null;
            List<PointF> list2 = null;
            List<PointF> list3 = null;
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c2 = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != 99) {
                    if (hashCode != 105) {
                        if (hashCode != 111) {
                            if (hashCode == 118 && nextName.equals("v")) {
                                c2 = 1;
                            }
                        } else if (nextName.equals(Config.OS)) {
                            c2 = 3;
                        }
                    } else if (nextName.equals("i")) {
                        c2 = 2;
                    }
                } else if (nextName.equals("c")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    z = jsonReader.nextBoolean();
                } else if (c2 == 1) {
                    list = p.a(jsonReader, f2);
                } else if (c2 == 2) {
                    list2 = p.a(jsonReader, f2);
                } else if (c2 == 3) {
                    list3 = p.a(jsonReader, f2);
                }
            }
            jsonReader.endObject();
            if (jsonReader.peek() == JsonToken.END_ARRAY) {
                jsonReader.endArray();
            }
            if (list == null || list2 == null || list3 == null) {
                throw new IllegalArgumentException("Shape data was missing information.");
            }
            if (list.isEmpty()) {
                return new com.ksad.lottie.model.content.h(new PointF(), false, Collections.emptyList());
            }
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 1; i2 < size; i2++) {
                PointF pointF2 = list.get(i2);
                int i3 = i2 - 1;
                arrayList.add(new com.ksad.lottie.model.a(com.ksad.lottie.d.e.a(list.get(i3), list3.get(i3)), com.ksad.lottie.d.e.a(pointF2, list2.get(i2)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i4 = size - 1;
                arrayList.add(new com.ksad.lottie.model.a(com.ksad.lottie.d.e.a(list.get(i4), list3.get(i4)), com.ksad.lottie.d.e.a(pointF3, list2.get(0)), pointF3));
            }
            return new com.ksad.lottie.model.content.h(pointF, z, arrayList);
        }
        return (com.ksad.lottie.model.content.h) invokeLF.objValue;
    }
}
