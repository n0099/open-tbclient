package com.opensource.svgaplayer.entities;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tieba.qs9;
import com.baidu.tieba.ss9;
import com.baidu.tieba.ts9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000:\u000278B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b6\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b6\u0010\u0007J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u0017\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\tRF\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0018\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R.\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0010\u001a\u0004\u0018\u00010!8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R.\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u0010\u001a\u0004\u0018\u00010(8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u00100\u001a\u00020/2\u0006\u0010\u0010\u001a\u00020/8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity;", "", "buildPath", "()V", "Lcom/opensource/svgaplayer/proto/ShapeEntity;", "obj", "parseArgs", "(Lcom/opensource/svgaplayer/proto/ShapeEntity;)V", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "parseStyles", "parseTransform", "parseType", "", "", "", "<set-?>", "args", "Ljava/util/Map;", "getArgs", "()Ljava/util/Map;", "setArgs", "(Ljava/util/Map;)V", "", "isKeep", "()Z", "Landroid/graphics/Path;", "shapePath", "Landroid/graphics/Path;", "getShapePath", "()Landroid/graphics/Path;", "setShapePath", "(Landroid/graphics/Path;)V", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;", "styles", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;", "getStyles", "()Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;", "setStyles", "(Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;)V", "Landroid/graphics/Matrix;", "transform", "Landroid/graphics/Matrix;", "getTransform", "()Landroid/graphics/Matrix;", "setTransform", "(Landroid/graphics/Matrix;)V", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "type", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "getType", "()Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "setType", "(Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;)V", "<init>", "Styles", "Type", "library_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class SVGAVideoShapeEntity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Type a;
    public Map<String, ? extends Object> b;
    public a c;
    public Matrix d;
    public Path e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "shape", "rect", "ellipse", "keep", "library_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type ellipse;
        public static final Type keep;
        public static final Type rect;
        public static final Type shape;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(321177520, "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(321177520, "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;");
                    return;
                }
            }
            Type type = new Type("shape", 0);
            shape = type;
            Type type2 = new Type("rect", 1);
            rect = type2;
            Type type3 = new Type("ellipse", 2);
            ellipse = type3;
            Type type4 = new Type("keep", 3);
            keep = type4;
            $VALUES = new Type[]{type, type2, type3, type4};
        }

        public Type(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public float c;
        public String d;
        public String e;
        public int f;
        public float[] g;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = "butt";
            this.e = "miter";
            this.g = new float[0];
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (String) invokeV.objValue;
        }

        public final float[] c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (float[]) invokeV.objValue;
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : (String) invokeV.objValue;
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : invokeV.intValue;
        }

        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : invokeV.intValue;
        }

        public final float g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : invokeV.floatValue;
        }

        public final void h(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.a = i;
            }
        }

        public final void i(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.d = str;
            }
        }

        public final void j(float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, fArr) == null) {
                this.g = fArr;
            }
        }

        public final void k(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.e = str;
            }
        }

        public final void l(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                this.f = i;
            }
        }

        public final void m(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
                this.b = i;
            }
        }

        public final void n(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048589, this, f) == null) {
                this.c = f;
            }
        }
    }

    public SVGAVideoShapeEntity(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = Type.shape;
        m(jSONObject);
        g(jSONObject);
        i(jSONObject);
        k(jSONObject);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.e == null) {
            ts9.a().reset();
            Type type = this.a;
            if (type == Type.shape) {
                Map<String, ? extends Object> map = this.b;
                Object obj = map != null ? map.get("d") : null;
                String str = obj instanceof String ? obj : null;
                if (str != null) {
                    new qs9(str).a(ts9.a());
                }
            } else if (type == Type.ellipse) {
                Map<String, ? extends Object> map2 = this.b;
                Object obj2 = map2 != null ? map2.get("x") : null;
                if (!(obj2 instanceof Number)) {
                    obj2 = null;
                }
                Number number = (Number) obj2;
                if (number == null) {
                    return;
                }
                Map<String, ? extends Object> map3 = this.b;
                Object obj3 = map3 != null ? map3.get("y") : null;
                if (!(obj3 instanceof Number)) {
                    obj3 = null;
                }
                Number number2 = (Number) obj3;
                if (number2 == null) {
                    return;
                }
                Map<String, ? extends Object> map4 = this.b;
                Object obj4 = map4 != null ? map4.get("radiusX") : null;
                if (!(obj4 instanceof Number)) {
                    obj4 = null;
                }
                Number number3 = (Number) obj4;
                if (number3 == null) {
                    return;
                }
                Map<String, ? extends Object> map5 = this.b;
                Object obj5 = map5 != null ? map5.get("radiusY") : null;
                Number number4 = (Number) (obj5 instanceof Number ? obj5 : null);
                if (number4 == null) {
                    return;
                }
                float floatValue = number.floatValue();
                float floatValue2 = number2.floatValue();
                float floatValue3 = number3.floatValue();
                float floatValue4 = number4.floatValue();
                ts9.a().addOval(new RectF(floatValue - floatValue3, floatValue2 - floatValue4, floatValue + floatValue3, floatValue2 + floatValue4), Path.Direction.CW);
            } else if (type == Type.rect) {
                Map<String, ? extends Object> map6 = this.b;
                Object obj6 = map6 != null ? map6.get("x") : null;
                if (!(obj6 instanceof Number)) {
                    obj6 = null;
                }
                Number number5 = (Number) obj6;
                if (number5 == null) {
                    return;
                }
                Map<String, ? extends Object> map7 = this.b;
                Object obj7 = map7 != null ? map7.get("y") : null;
                if (!(obj7 instanceof Number)) {
                    obj7 = null;
                }
                Number number6 = (Number) obj7;
                if (number6 == null) {
                    return;
                }
                Map<String, ? extends Object> map8 = this.b;
                Object obj8 = map8 != null ? map8.get("width") : null;
                if (!(obj8 instanceof Number)) {
                    obj8 = null;
                }
                Number number7 = (Number) obj8;
                if (number7 == null) {
                    return;
                }
                Map<String, ? extends Object> map9 = this.b;
                Object obj9 = map9 != null ? map9.get("height") : null;
                if (!(obj9 instanceof Number)) {
                    obj9 = null;
                }
                Number number8 = (Number) obj9;
                if (number8 == null) {
                    return;
                }
                Map<String, ? extends Object> map10 = this.b;
                Object obj10 = map10 != null ? map10.get("cornerRadius") : null;
                Number number9 = obj10 instanceof Number ? obj10 : null;
                if (number9 == null) {
                    return;
                }
                float floatValue5 = number5.floatValue();
                float floatValue6 = number6.floatValue();
                float floatValue7 = number7.floatValue();
                float floatValue8 = number8.floatValue();
                float floatValue9 = number9.floatValue();
                ts9.a().addRoundRect(new RectF(floatValue5, floatValue6, floatValue7 + floatValue5, floatValue8 + floatValue6), floatValue9, floatValue9, Path.Direction.CW);
            }
            Path path = new Path();
            this.e = path;
            if (path != null) {
                path.set(ts9.a());
            }
        }
    }

    public final Path b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (Path) invokeV.objValue;
    }

    public final a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (a) invokeV.objValue;
    }

    public final Matrix d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (Matrix) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a == Type.keep : invokeV.booleanValue;
    }

    public final void f(ShapeEntity shapeEntity) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, shapeEntity) == null) {
            HashMap hashMap = new HashMap();
            ShapeEntity.ShapeArgs shapeArgs = shapeEntity.shape;
            if (shapeArgs != null && (str = shapeArgs.d) != null) {
                hashMap.put("d", str);
            }
            ShapeEntity.EllipseArgs ellipseArgs = shapeEntity.ellipse;
            if (ellipseArgs != null) {
                Float f = ellipseArgs.x;
                if (f == null) {
                    f = Float.valueOf(0.0f);
                }
                hashMap.put("x", f);
                Float f2 = ellipseArgs.y;
                if (f2 == null) {
                    f2 = Float.valueOf(0.0f);
                }
                hashMap.put("y", f2);
                Float f3 = ellipseArgs.radiusX;
                if (f3 == null) {
                    f3 = Float.valueOf(0.0f);
                }
                hashMap.put("radiusX", f3);
                Float f4 = ellipseArgs.radiusY;
                if (f4 == null) {
                    f4 = Float.valueOf(0.0f);
                }
                hashMap.put("radiusY", f4);
            }
            ShapeEntity.RectArgs rectArgs = shapeEntity.rect;
            if (rectArgs != null) {
                Float f5 = rectArgs.x;
                if (f5 == null) {
                    f5 = Float.valueOf(0.0f);
                }
                hashMap.put("x", f5);
                Float f6 = rectArgs.y;
                if (f6 == null) {
                    f6 = Float.valueOf(0.0f);
                }
                hashMap.put("y", f6);
                Float f7 = rectArgs.width;
                if (f7 == null) {
                    f7 = Float.valueOf(0.0f);
                }
                hashMap.put("width", f7);
                Float f8 = rectArgs.height;
                if (f8 == null) {
                    f8 = Float.valueOf(0.0f);
                }
                hashMap.put("height", f8);
                Float f9 = rectArgs.cornerRadius;
                if (f9 == null) {
                    f9 = Float.valueOf(0.0f);
                }
                hashMap.put("cornerRadius", f9);
            }
            this.b = hashMap;
        }
    }

    public final void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            HashMap hashMap = new HashMap();
            JSONObject optJSONObject = jSONObject.optJSONObject("args");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                Intrinsics.checkExpressionValueIsNotNull(keys, "values.keys()");
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = optJSONObject.get(next);
                    if (obj != null) {
                        hashMap.put(next, obj);
                    }
                }
                this.b = hashMap;
            }
        }
    }

    public final Type getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (Type) invokeV.objValue;
    }

    public final void h(ShapeEntity shapeEntity) {
        ShapeEntity.ShapeStyle shapeStyle;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shapeEntity) == null) || (shapeStyle = shapeEntity.styles) == null) {
            return;
        }
        a aVar = new a();
        ShapeEntity.ShapeStyle.RGBAColor rGBAColor = shapeStyle.fill;
        if (rGBAColor != null) {
            Float f = rGBAColor.a;
            float f2 = 255;
            int floatValue = (int) ((f != null ? f.floatValue() : 0.0f) * f2);
            Float f3 = rGBAColor.r;
            int floatValue2 = (int) ((f3 != null ? f3.floatValue() : 0.0f) * f2);
            Float f4 = rGBAColor.g;
            int floatValue3 = (int) ((f4 != null ? f4.floatValue() : 0.0f) * f2);
            Float f5 = rGBAColor.b;
            aVar.h(Color.argb(floatValue, floatValue2, floatValue3, (int) ((f5 != null ? f5.floatValue() : 0.0f) * f2)));
        }
        ShapeEntity.ShapeStyle.RGBAColor rGBAColor2 = shapeStyle.stroke;
        if (rGBAColor2 != null) {
            Float f6 = rGBAColor2.a;
            float f7 = 255;
            int floatValue4 = (int) ((f6 != null ? f6.floatValue() : 0.0f) * f7);
            Float f8 = rGBAColor2.r;
            int floatValue5 = (int) ((f8 != null ? f8.floatValue() : 0.0f) * f7);
            Float f9 = rGBAColor2.g;
            int floatValue6 = (int) ((f9 != null ? f9.floatValue() : 0.0f) * f7);
            Float f10 = rGBAColor2.b;
            aVar.m(Color.argb(floatValue4, floatValue5, floatValue6, (int) ((f10 != null ? f10.floatValue() : 0.0f) * f7)));
        }
        Float f11 = shapeStyle.strokeWidth;
        aVar.n(f11 != null ? f11.floatValue() : 0.0f);
        ShapeEntity.ShapeStyle.LineCap lineCap = shapeStyle.lineCap;
        if (lineCap != null) {
            int i = ss9.$EnumSwitchMapping$1[lineCap.ordinal()];
            if (i == 1) {
                aVar.i("butt");
            } else if (i == 2) {
                aVar.i("round");
            } else if (i == 3) {
                aVar.i("square");
            }
        }
        ShapeEntity.ShapeStyle.LineJoin lineJoin = shapeStyle.lineJoin;
        if (lineJoin != null) {
            int i2 = ss9.$EnumSwitchMapping$2[lineJoin.ordinal()];
            if (i2 == 1) {
                aVar.k("bevel");
            } else if (i2 == 2) {
                aVar.k("miter");
            } else if (i2 == 3) {
                aVar.k("round");
            }
        }
        Float f12 = shapeStyle.miterLimit;
        aVar.l((int) (f12 != null ? f12.floatValue() : 0.0f));
        aVar.j(new float[3]);
        Float f13 = shapeStyle.lineDashI;
        if (f13 != null) {
            aVar.c()[0] = f13.floatValue();
        }
        Float f14 = shapeStyle.lineDashII;
        if (f14 != null) {
            aVar.c()[1] = f14.floatValue();
        }
        Float f15 = shapeStyle.lineDashIII;
        if (f15 != null) {
            aVar.c()[2] = f15.floatValue();
        }
        this.c = aVar;
    }

    public final void i(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject("styles")) != null) {
            a aVar = new a();
            JSONArray optJSONArray = optJSONObject.optJSONArray("fill");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                double d = 255;
                aVar.h(Color.argb((int) (optJSONArray.optDouble(3) * d), (int) (optJSONArray.optDouble(0) * d), (int) (optJSONArray.optDouble(1) * d), (int) (optJSONArray.optDouble(2) * d)));
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("stroke");
            if (optJSONArray2 != null && optJSONArray2.length() == 4) {
                double d2 = 255;
                aVar.m(Color.argb((int) (optJSONArray2.optDouble(3) * d2), (int) (optJSONArray2.optDouble(0) * d2), (int) (optJSONArray2.optDouble(1) * d2), (int) (optJSONArray2.optDouble(2) * d2)));
            }
            aVar.n((float) optJSONObject.optDouble("strokeWidth", 0.0d));
            String optString = optJSONObject.optString("lineCap", "butt");
            Intrinsics.checkExpressionValueIsNotNull(optString, "it.optString(\"lineCap\", \"butt\")");
            aVar.i(optString);
            String optString2 = optJSONObject.optString("lineJoin", "miter");
            Intrinsics.checkExpressionValueIsNotNull(optString2, "it.optString(\"lineJoin\", \"miter\")");
            aVar.k(optString2);
            aVar.l(optJSONObject.optInt("miterLimit", 0));
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("lineDash");
            if (optJSONArray3 != null) {
                aVar.j(new float[optJSONArray3.length()]);
                int length = optJSONArray3.length();
                for (int i = 0; i < length; i++) {
                    aVar.c()[i] = (float) optJSONArray3.optDouble(i, 0.0d);
                }
            }
            this.c = aVar;
        }
    }

    public final void j(ShapeEntity shapeEntity) {
        Transform transform;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, shapeEntity) == null) || (transform = shapeEntity.transform) == null) {
            return;
        }
        Matrix matrix = new Matrix();
        float[] fArr = new float[9];
        Float f = transform.a;
        float floatValue = f != null ? f.floatValue() : 1.0f;
        Float f2 = transform.b;
        float floatValue2 = f2 != null ? f2.floatValue() : 0.0f;
        Float f3 = transform.c;
        float floatValue3 = f3 != null ? f3.floatValue() : 0.0f;
        Float f4 = transform.d;
        float floatValue4 = f4 != null ? f4.floatValue() : 1.0f;
        Float f5 = transform.tx;
        float floatValue5 = f5 != null ? f5.floatValue() : 0.0f;
        Float f6 = transform.ty;
        float floatValue6 = f6 != null ? f6.floatValue() : 0.0f;
        fArr[0] = floatValue;
        fArr[1] = floatValue3;
        fArr[2] = floatValue5;
        fArr[3] = floatValue2;
        fArr[4] = floatValue4;
        fArr[5] = floatValue6;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        matrix.setValues(fArr);
        this.d = matrix;
    }

    public final void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject("transform")) != null) {
            Matrix matrix = new Matrix();
            float f = (float) 0.0d;
            matrix.setValues(new float[]{(float) optJSONObject.optDouble("a", 1.0d), (float) optJSONObject.optDouble("c", 0.0d), (float) optJSONObject.optDouble("tx", 0.0d), (float) optJSONObject.optDouble("b", 0.0d), (float) optJSONObject.optDouble("d", 1.0d), (float) optJSONObject.optDouble(Config.EXCEPTION_CRASH_CHANNEL, 0.0d), f, f, (float) 1.0d});
            this.d = matrix;
        }
    }

    public final void l(ShapeEntity shapeEntity) {
        ShapeEntity.ShapeType shapeType;
        Type type;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, shapeEntity) == null) || (shapeType = shapeEntity.type) == null) {
            return;
        }
        int i = ss9.$EnumSwitchMapping$0[shapeType.ordinal()];
        if (i == 1) {
            type = Type.shape;
        } else if (i == 2) {
            type = Type.rect;
        } else if (i == 3) {
            type = Type.ellipse;
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            type = Type.keep;
        }
        this.a = type;
    }

    public final void m(JSONObject jSONObject) {
        String optString;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) || (optString = jSONObject.optString("type")) == null) {
            return;
        }
        if (StringsKt__StringsJVMKt.equals(optString, "shape", true)) {
            this.a = Type.shape;
        } else if (StringsKt__StringsJVMKt.equals(optString, "rect", true)) {
            this.a = Type.rect;
        } else if (StringsKt__StringsJVMKt.equals(optString, "ellipse", true)) {
            this.a = Type.ellipse;
        } else if (StringsKt__StringsJVMKt.equals(optString, "keep", true)) {
            this.a = Type.keep;
        }
    }

    public SVGAVideoShapeEntity(ShapeEntity shapeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {shapeEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Type.shape;
        l(shapeEntity);
        f(shapeEntity);
        h(shapeEntity);
        j(shapeEntity);
    }
}
