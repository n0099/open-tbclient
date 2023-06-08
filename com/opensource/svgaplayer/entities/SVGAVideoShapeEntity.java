package com.opensource.svgaplayer.entities;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.vcb;
import com.baidu.tieba.xcb;
import com.baidu.tieba.ycb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000:\u000278B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b6\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b6\u0010\u0007J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u0017\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\tRF\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0018\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R.\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0010\u001a\u0004\u0018\u00010!8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R.\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u0010\u001a\u0004\u0018\u00010(8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u00100\u001a\u00020/2\u0006\u0010\u0010\u001a\u00020/8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity;", "", "buildPath", "()V", "Lcom/opensource/svgaplayer/proto/ShapeEntity;", "obj", "parseArgs", "(Lcom/opensource/svgaplayer/proto/ShapeEntity;)V", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "parseStyles", "parseTransform", "parseType", "", "", "", "<set-?>", WebChromeClient.KEY_ARG_ARRAY, "Ljava/util/Map;", "getArgs", "()Ljava/util/Map;", "setArgs", "(Ljava/util/Map;)V", "", "isKeep", "()Z", "Landroid/graphics/Path;", "shapePath", "Landroid/graphics/Path;", "getShapePath", "()Landroid/graphics/Path;", "setShapePath", "(Landroid/graphics/Path;)V", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;", "styles", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;", "getStyles", "()Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;", "setStyles", "(Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;)V", "Landroid/graphics/Matrix;", "transform", "Landroid/graphics/Matrix;", "getTransform", "()Landroid/graphics/Matrix;", "setTransform", "(Landroid/graphics/Matrix;)V", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "type", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "getType", "()Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "setType", "(Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;)V", "<init>", "Styles", "Type", "library_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
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
    /* loaded from: classes10.dex */
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
    }

    /* loaded from: classes10.dex */
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        public final float[] c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.g;
            }
            return (float[]) invokeV.objValue;
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.e;
            }
            return (String) invokeV.objValue;
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.f;
            }
            return invokeV.intValue;
        }

        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        public final float g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.c;
            }
            return invokeV.floatValue;
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

    public final void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            HashMap hashMap = new HashMap();
            JSONObject optJSONObject = jSONObject.optJSONObject(WebChromeClient.KEY_ARG_ARRAY);
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

    public final void l(ShapeEntity shapeEntity) {
        ShapeEntity.ShapeType shapeType;
        Type type;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, shapeEntity) == null) && (shapeType = shapeEntity.type) != null) {
            int i = xcb.$EnumSwitchMapping$0[shapeType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            type = Type.keep;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        type = Type.ellipse;
                    }
                } else {
                    type = Type.rect;
                }
            } else {
                type = Type.shape;
            }
            this.a = type;
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
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.e != null) {
            return;
        }
        ycb.a().reset();
        Type type = this.a;
        String str = null;
        if (type == Type.shape) {
            Map<String, ? extends Object> map = this.b;
            if (map != null) {
                obj10 = map.get("d");
            } else {
                obj10 = null;
            }
            if (obj10 instanceof String) {
                str = obj10;
            }
            String str2 = str;
            if (str2 != null) {
                new vcb(str2).a(ycb.a());
            }
        } else if (type == Type.ellipse) {
            Map<String, ? extends Object> map2 = this.b;
            if (map2 != null) {
                obj6 = map2.get("x");
            } else {
                obj6 = null;
            }
            if (!(obj6 instanceof Number)) {
                obj6 = null;
            }
            Number number = (Number) obj6;
            if (number != null) {
                Map<String, ? extends Object> map3 = this.b;
                if (map3 != null) {
                    obj7 = map3.get("y");
                } else {
                    obj7 = null;
                }
                if (!(obj7 instanceof Number)) {
                    obj7 = null;
                }
                Number number2 = (Number) obj7;
                if (number2 != null) {
                    Map<String, ? extends Object> map4 = this.b;
                    if (map4 != null) {
                        obj8 = map4.get("radiusX");
                    } else {
                        obj8 = null;
                    }
                    if (!(obj8 instanceof Number)) {
                        obj8 = null;
                    }
                    Number number3 = (Number) obj8;
                    if (number3 != null) {
                        Map<String, ? extends Object> map5 = this.b;
                        if (map5 != null) {
                            obj9 = map5.get("radiusY");
                        } else {
                            obj9 = null;
                        }
                        if (obj9 instanceof Number) {
                            str = obj9;
                        }
                        Number number4 = (Number) str;
                        if (number4 != null) {
                            float floatValue = number.floatValue();
                            float floatValue2 = number2.floatValue();
                            float floatValue3 = number3.floatValue();
                            float floatValue4 = number4.floatValue();
                            ycb.a().addOval(new RectF(floatValue - floatValue3, floatValue2 - floatValue4, floatValue + floatValue3, floatValue2 + floatValue4), Path.Direction.CW);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (type == Type.rect) {
            Map<String, ? extends Object> map6 = this.b;
            if (map6 != null) {
                obj = map6.get("x");
            } else {
                obj = null;
            }
            if (!(obj instanceof Number)) {
                obj = null;
            }
            Number number5 = (Number) obj;
            if (number5 != null) {
                Map<String, ? extends Object> map7 = this.b;
                if (map7 != null) {
                    obj2 = map7.get("y");
                } else {
                    obj2 = null;
                }
                if (!(obj2 instanceof Number)) {
                    obj2 = null;
                }
                Number number6 = (Number) obj2;
                if (number6 != null) {
                    Map<String, ? extends Object> map8 = this.b;
                    if (map8 != null) {
                        obj3 = map8.get("width");
                    } else {
                        obj3 = null;
                    }
                    if (!(obj3 instanceof Number)) {
                        obj3 = null;
                    }
                    Number number7 = (Number) obj3;
                    if (number7 != null) {
                        Map<String, ? extends Object> map9 = this.b;
                        if (map9 != null) {
                            obj4 = map9.get("height");
                        } else {
                            obj4 = null;
                        }
                        if (!(obj4 instanceof Number)) {
                            obj4 = null;
                        }
                        Number number8 = (Number) obj4;
                        if (number8 != null) {
                            Map<String, ? extends Object> map10 = this.b;
                            if (map10 != null) {
                                obj5 = map10.get("cornerRadius");
                            } else {
                                obj5 = null;
                            }
                            if (obj5 instanceof Number) {
                                str = obj5;
                            }
                            Number number9 = str;
                            if (number9 != null) {
                                float floatValue5 = number5.floatValue();
                                float floatValue6 = number6.floatValue();
                                float floatValue7 = number7.floatValue();
                                float floatValue8 = number8.floatValue();
                                float floatValue9 = number9.floatValue();
                                ycb.a().addRoundRect(new RectF(floatValue5, floatValue6, floatValue7 + floatValue5, floatValue8 + floatValue6), floatValue9, floatValue9, Path.Direction.CW);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Path path = new Path();
        this.e = path;
        if (path != null) {
            path.set(ycb.a());
        }
    }

    public final Path b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (Path) invokeV.objValue;
    }

    public final a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (a) invokeV.objValue;
    }

    public final Matrix d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (Matrix) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == Type.keep) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final Type getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (Type) invokeV.objValue;
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

    public final void h(ShapeEntity shapeEntity) {
        ShapeEntity.ShapeStyle shapeStyle;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shapeEntity) == null) && (shapeStyle = shapeEntity.styles) != null) {
            a aVar = new a();
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor = shapeStyle.fill;
            float f10 = 0.0f;
            if (rGBAColor != null) {
                Float f11 = rGBAColor.a;
                if (f11 != null) {
                    f6 = f11.floatValue();
                } else {
                    f6 = 0.0f;
                }
                float f12 = 255;
                int i = (int) (f6 * f12);
                Float f13 = rGBAColor.r;
                if (f13 != null) {
                    f7 = f13.floatValue();
                } else {
                    f7 = 0.0f;
                }
                int i2 = (int) (f7 * f12);
                Float f14 = rGBAColor.g;
                if (f14 != null) {
                    f8 = f14.floatValue();
                } else {
                    f8 = 0.0f;
                }
                int i3 = (int) (f8 * f12);
                Float f15 = rGBAColor.b;
                if (f15 != null) {
                    f9 = f15.floatValue();
                } else {
                    f9 = 0.0f;
                }
                aVar.h(Color.argb(i, i2, i3, (int) (f9 * f12)));
            }
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor2 = shapeStyle.stroke;
            if (rGBAColor2 != null) {
                Float f16 = rGBAColor2.a;
                if (f16 != null) {
                    f2 = f16.floatValue();
                } else {
                    f2 = 0.0f;
                }
                float f17 = 255;
                int i4 = (int) (f2 * f17);
                Float f18 = rGBAColor2.r;
                if (f18 != null) {
                    f3 = f18.floatValue();
                } else {
                    f3 = 0.0f;
                }
                int i5 = (int) (f3 * f17);
                Float f19 = rGBAColor2.g;
                if (f19 != null) {
                    f4 = f19.floatValue();
                } else {
                    f4 = 0.0f;
                }
                int i6 = (int) (f4 * f17);
                Float f20 = rGBAColor2.b;
                if (f20 != null) {
                    f5 = f20.floatValue();
                } else {
                    f5 = 0.0f;
                }
                aVar.m(Color.argb(i4, i5, i6, (int) (f5 * f17)));
            }
            Float f21 = shapeStyle.strokeWidth;
            if (f21 != null) {
                f = f21.floatValue();
            } else {
                f = 0.0f;
            }
            aVar.n(f);
            ShapeEntity.ShapeStyle.LineCap lineCap = shapeStyle.lineCap;
            if (lineCap != null) {
                int i7 = xcb.$EnumSwitchMapping$1[lineCap.ordinal()];
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 == 3) {
                            aVar.i("square");
                        }
                    } else {
                        aVar.i("round");
                    }
                } else {
                    aVar.i("butt");
                }
            }
            ShapeEntity.ShapeStyle.LineJoin lineJoin = shapeStyle.lineJoin;
            if (lineJoin != null) {
                int i8 = xcb.$EnumSwitchMapping$2[lineJoin.ordinal()];
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 == 3) {
                            aVar.k("round");
                        }
                    } else {
                        aVar.k("miter");
                    }
                } else {
                    aVar.k("bevel");
                }
            }
            Float f22 = shapeStyle.miterLimit;
            if (f22 != null) {
                f10 = f22.floatValue();
            }
            aVar.l((int) f10);
            aVar.j(new float[3]);
            Float f23 = shapeStyle.lineDashI;
            if (f23 != null) {
                aVar.c()[0] = f23.floatValue();
            }
            Float f24 = shapeStyle.lineDashII;
            if (f24 != null) {
                aVar.c()[1] = f24.floatValue();
            }
            Float f25 = shapeStyle.lineDashIII;
            if (f25 != null) {
                aVar.c()[2] = f25.floatValue();
            }
            this.c = aVar;
        }
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
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, shapeEntity) == null) && (transform = shapeEntity.transform) != null) {
            Matrix matrix = new Matrix();
            float[] fArr = new float[9];
            Float f7 = transform.a;
            if (f7 != null) {
                f = f7.floatValue();
            } else {
                f = 1.0f;
            }
            Float f8 = transform.b;
            if (f8 != null) {
                f2 = f8.floatValue();
            } else {
                f2 = 0.0f;
            }
            Float f9 = transform.c;
            if (f9 != null) {
                f3 = f9.floatValue();
            } else {
                f3 = 0.0f;
            }
            Float f10 = transform.d;
            if (f10 != null) {
                f4 = f10.floatValue();
            } else {
                f4 = 1.0f;
            }
            Float f11 = transform.tx;
            if (f11 != null) {
                f5 = f11.floatValue();
            } else {
                f5 = 0.0f;
            }
            Float f12 = transform.ty;
            if (f12 != null) {
                f6 = f12.floatValue();
            } else {
                f6 = 0.0f;
            }
            fArr[0] = f;
            fArr[1] = f3;
            fArr[2] = f5;
            fArr[3] = f2;
            fArr[4] = f4;
            fArr[5] = f6;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            matrix.setValues(fArr);
            this.d = matrix;
        }
    }

    public final void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject("transform")) != null) {
            Matrix matrix = new Matrix();
            float f = (float) 0.0d;
            matrix.setValues(new float[]{(float) optJSONObject.optDouble("a", 1.0d), (float) optJSONObject.optDouble("c", 0.0d), (float) optJSONObject.optDouble(MapBundleKey.MapObjKey.OBJ_TEXT, 0.0d), (float) optJSONObject.optDouble("b", 0.0d), (float) optJSONObject.optDouble("d", 1.0d), (float) optJSONObject.optDouble("ty", 0.0d), f, f, (float) 1.0d});
            this.d = matrix;
        }
    }

    public final void m(JSONObject jSONObject) {
        String optString;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) && (optString = jSONObject.optString("type")) != null) {
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
    }
}
