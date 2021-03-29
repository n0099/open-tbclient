package com.opensource.svgaplayer.entities;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import d.l.a.g.b;
import d.l.a.g.d;
import d.l.a.g.e;
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
/* loaded from: classes6.dex */
public final class SVGAVideoShapeEntity {

    /* renamed from: a  reason: collision with root package name */
    public Type f37962a = Type.shape;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, ? extends Object> f37963b;

    /* renamed from: c  reason: collision with root package name */
    public a f37964c;

    /* renamed from: d  reason: collision with root package name */
    public Matrix f37965d;

    /* renamed from: e  reason: collision with root package name */
    public Path f37966e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "shape", "rect", "ellipse", "keep", "library_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes6.dex */
    public enum Type {
        shape,
        rect,
        ellipse,
        keep
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f37967a;

        /* renamed from: b  reason: collision with root package name */
        public int f37968b;

        /* renamed from: c  reason: collision with root package name */
        public float f37969c;

        /* renamed from: f  reason: collision with root package name */
        public int f37972f;

        /* renamed from: d  reason: collision with root package name */
        public String f37970d = "butt";

        /* renamed from: e  reason: collision with root package name */
        public String f37971e = "miter";

        /* renamed from: g  reason: collision with root package name */
        public float[] f37973g = new float[0];

        public final int a() {
            return this.f37967a;
        }

        public final String b() {
            return this.f37970d;
        }

        public final float[] c() {
            return this.f37973g;
        }

        public final String d() {
            return this.f37971e;
        }

        public final int e() {
            return this.f37972f;
        }

        public final int f() {
            return this.f37968b;
        }

        public final float g() {
            return this.f37969c;
        }

        public final void h(int i) {
            this.f37967a = i;
        }

        public final void i(String str) {
            this.f37970d = str;
        }

        public final void j(float[] fArr) {
            this.f37973g = fArr;
        }

        public final void k(String str) {
            this.f37971e = str;
        }

        public final void l(int i) {
            this.f37972f = i;
        }

        public final void m(int i) {
            this.f37968b = i;
        }

        public final void n(float f2) {
            this.f37969c = f2;
        }
    }

    public SVGAVideoShapeEntity(JSONObject jSONObject) {
        m(jSONObject);
        g(jSONObject);
        i(jSONObject);
        k(jSONObject);
    }

    public final void a() {
        if (this.f37966e != null) {
            return;
        }
        e.a().reset();
        Type type = this.f37962a;
        if (type == Type.shape) {
            Map<String, ? extends Object> map = this.f37963b;
            Object obj = map != null ? map.get("d") : null;
            String str = obj instanceof String ? obj : null;
            if (str != null) {
                new b(str).a(e.a());
            }
        } else if (type == Type.ellipse) {
            Map<String, ? extends Object> map2 = this.f37963b;
            Object obj2 = map2 != null ? map2.get("x") : null;
            if (!(obj2 instanceof Number)) {
                obj2 = null;
            }
            Number number = (Number) obj2;
            if (number == null) {
                return;
            }
            Map<String, ? extends Object> map3 = this.f37963b;
            Object obj3 = map3 != null ? map3.get("y") : null;
            if (!(obj3 instanceof Number)) {
                obj3 = null;
            }
            Number number2 = (Number) obj3;
            if (number2 == null) {
                return;
            }
            Map<String, ? extends Object> map4 = this.f37963b;
            Object obj4 = map4 != null ? map4.get("radiusX") : null;
            if (!(obj4 instanceof Number)) {
                obj4 = null;
            }
            Number number3 = (Number) obj4;
            if (number3 == null) {
                return;
            }
            Map<String, ? extends Object> map5 = this.f37963b;
            Object obj5 = map5 != null ? map5.get("radiusY") : null;
            Number number4 = (Number) (obj5 instanceof Number ? obj5 : null);
            if (number4 == null) {
                return;
            }
            float floatValue = number.floatValue();
            float floatValue2 = number2.floatValue();
            float floatValue3 = number3.floatValue();
            float floatValue4 = number4.floatValue();
            e.a().addOval(new RectF(floatValue - floatValue3, floatValue2 - floatValue4, floatValue + floatValue3, floatValue2 + floatValue4), Path.Direction.CW);
        } else if (type == Type.rect) {
            Map<String, ? extends Object> map6 = this.f37963b;
            Object obj6 = map6 != null ? map6.get("x") : null;
            if (!(obj6 instanceof Number)) {
                obj6 = null;
            }
            Number number5 = (Number) obj6;
            if (number5 == null) {
                return;
            }
            Map<String, ? extends Object> map7 = this.f37963b;
            Object obj7 = map7 != null ? map7.get("y") : null;
            if (!(obj7 instanceof Number)) {
                obj7 = null;
            }
            Number number6 = (Number) obj7;
            if (number6 == null) {
                return;
            }
            Map<String, ? extends Object> map8 = this.f37963b;
            Object obj8 = map8 != null ? map8.get("width") : null;
            if (!(obj8 instanceof Number)) {
                obj8 = null;
            }
            Number number7 = (Number) obj8;
            if (number7 == null) {
                return;
            }
            Map<String, ? extends Object> map9 = this.f37963b;
            Object obj9 = map9 != null ? map9.get("height") : null;
            if (!(obj9 instanceof Number)) {
                obj9 = null;
            }
            Number number8 = (Number) obj9;
            if (number8 == null) {
                return;
            }
            Map<String, ? extends Object> map10 = this.f37963b;
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
            e.a().addRoundRect(new RectF(floatValue5, floatValue6, floatValue7 + floatValue5, floatValue8 + floatValue6), floatValue9, floatValue9, Path.Direction.CW);
        }
        Path path = new Path();
        this.f37966e = path;
        if (path != null) {
            path.set(e.a());
        }
    }

    public final Path b() {
        return this.f37966e;
    }

    public final a c() {
        return this.f37964c;
    }

    public final Matrix d() {
        return this.f37965d;
    }

    public final boolean e() {
        return this.f37962a == Type.keep;
    }

    public final void f(ShapeEntity shapeEntity) {
        String str;
        HashMap hashMap = new HashMap();
        ShapeEntity.ShapeArgs shapeArgs = shapeEntity.shape;
        if (shapeArgs != null && (str = shapeArgs.f37974d) != null) {
            hashMap.put("d", str);
        }
        ShapeEntity.EllipseArgs ellipseArgs = shapeEntity.ellipse;
        if (ellipseArgs != null) {
            Float f2 = ellipseArgs.x;
            if (f2 == null) {
                f2 = Float.valueOf(0.0f);
            }
            hashMap.put("x", f2);
            Float f3 = ellipseArgs.y;
            if (f3 == null) {
                f3 = Float.valueOf(0.0f);
            }
            hashMap.put("y", f3);
            Float f4 = ellipseArgs.radiusX;
            if (f4 == null) {
                f4 = Float.valueOf(0.0f);
            }
            hashMap.put("radiusX", f4);
            Float f5 = ellipseArgs.radiusY;
            if (f5 == null) {
                f5 = Float.valueOf(0.0f);
            }
            hashMap.put("radiusY", f5);
        }
        ShapeEntity.RectArgs rectArgs = shapeEntity.rect;
        if (rectArgs != null) {
            Float f6 = rectArgs.x;
            if (f6 == null) {
                f6 = Float.valueOf(0.0f);
            }
            hashMap.put("x", f6);
            Float f7 = rectArgs.y;
            if (f7 == null) {
                f7 = Float.valueOf(0.0f);
            }
            hashMap.put("y", f7);
            Float f8 = rectArgs.width;
            if (f8 == null) {
                f8 = Float.valueOf(0.0f);
            }
            hashMap.put("width", f8);
            Float f9 = rectArgs.height;
            if (f9 == null) {
                f9 = Float.valueOf(0.0f);
            }
            hashMap.put("height", f9);
            Float f10 = rectArgs.cornerRadius;
            if (f10 == null) {
                f10 = Float.valueOf(0.0f);
            }
            hashMap.put("cornerRadius", f10);
        }
        this.f37963b = hashMap;
    }

    public final void g(JSONObject jSONObject) {
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
            this.f37963b = hashMap;
        }
    }

    public final void h(ShapeEntity shapeEntity) {
        ShapeEntity.ShapeStyle shapeStyle = shapeEntity.styles;
        if (shapeStyle != null) {
            a aVar = new a();
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor = shapeStyle.fill;
            if (rGBAColor != null) {
                Float f2 = rGBAColor.f37976a;
                float f3 = 255;
                int floatValue = (int) ((f2 != null ? f2.floatValue() : 0.0f) * f3);
                Float f4 = rGBAColor.r;
                int floatValue2 = (int) ((f4 != null ? f4.floatValue() : 0.0f) * f3);
                Float f5 = rGBAColor.f37978g;
                int floatValue3 = (int) ((f5 != null ? f5.floatValue() : 0.0f) * f3);
                Float f6 = rGBAColor.f37977b;
                aVar.h(Color.argb(floatValue, floatValue2, floatValue3, (int) ((f6 != null ? f6.floatValue() : 0.0f) * f3)));
            }
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor2 = shapeStyle.stroke;
            if (rGBAColor2 != null) {
                Float f7 = rGBAColor2.f37976a;
                float f8 = 255;
                int floatValue4 = (int) ((f7 != null ? f7.floatValue() : 0.0f) * f8);
                Float f9 = rGBAColor2.r;
                int floatValue5 = (int) ((f9 != null ? f9.floatValue() : 0.0f) * f8);
                Float f10 = rGBAColor2.f37978g;
                int floatValue6 = (int) ((f10 != null ? f10.floatValue() : 0.0f) * f8);
                Float f11 = rGBAColor2.f37977b;
                aVar.m(Color.argb(floatValue4, floatValue5, floatValue6, (int) ((f11 != null ? f11.floatValue() : 0.0f) * f8)));
            }
            Float f12 = shapeStyle.strokeWidth;
            aVar.n(f12 != null ? f12.floatValue() : 0.0f);
            ShapeEntity.ShapeStyle.LineCap lineCap = shapeStyle.lineCap;
            if (lineCap != null) {
                int i = d.$EnumSwitchMapping$1[lineCap.ordinal()];
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
                int i2 = d.$EnumSwitchMapping$2[lineJoin.ordinal()];
                if (i2 == 1) {
                    aVar.k("bevel");
                } else if (i2 == 2) {
                    aVar.k("miter");
                } else if (i2 == 3) {
                    aVar.k("round");
                }
            }
            Float f13 = shapeStyle.miterLimit;
            aVar.l((int) (f13 != null ? f13.floatValue() : 0.0f));
            aVar.j(new float[3]);
            Float f14 = shapeStyle.lineDashI;
            if (f14 != null) {
                aVar.c()[0] = f14.floatValue();
            }
            Float f15 = shapeStyle.lineDashII;
            if (f15 != null) {
                aVar.c()[1] = f15.floatValue();
            }
            Float f16 = shapeStyle.lineDashIII;
            if (f16 != null) {
                aVar.c()[2] = f16.floatValue();
            }
            this.f37964c = aVar;
        }
    }

    public final void i(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("styles");
        if (optJSONObject != null) {
            a aVar = new a();
            JSONArray optJSONArray = optJSONObject.optJSONArray("fill");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                double d2 = 255;
                aVar.h(Color.argb((int) (optJSONArray.optDouble(3) * d2), (int) (optJSONArray.optDouble(0) * d2), (int) (optJSONArray.optDouble(1) * d2), (int) (optJSONArray.optDouble(2) * d2)));
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("stroke");
            if (optJSONArray2 != null && optJSONArray2.length() == 4) {
                double d3 = 255;
                aVar.m(Color.argb((int) (optJSONArray2.optDouble(3) * d3), (int) (optJSONArray2.optDouble(0) * d3), (int) (optJSONArray2.optDouble(1) * d3), (int) (optJSONArray2.optDouble(2) * d3)));
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
            this.f37964c = aVar;
        }
    }

    public final void j(ShapeEntity shapeEntity) {
        Transform transform = shapeEntity.transform;
        if (transform != null) {
            Matrix matrix = new Matrix();
            float[] fArr = new float[9];
            Float f2 = transform.f37982a;
            float floatValue = f2 != null ? f2.floatValue() : 1.0f;
            Float f3 = transform.f37983b;
            float floatValue2 = f3 != null ? f3.floatValue() : 0.0f;
            Float f4 = transform.f37984c;
            float floatValue3 = f4 != null ? f4.floatValue() : 0.0f;
            Float f5 = transform.f37985d;
            float floatValue4 = f5 != null ? f5.floatValue() : 1.0f;
            Float f6 = transform.tx;
            float floatValue5 = f6 != null ? f6.floatValue() : 0.0f;
            Float f7 = transform.ty;
            float floatValue6 = f7 != null ? f7.floatValue() : 0.0f;
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
            this.f37965d = matrix;
        }
    }

    public final void k(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("transform");
        if (optJSONObject != null) {
            Matrix matrix = new Matrix();
            double optDouble = optJSONObject.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject.optDouble("b", 0.0d);
            float f2 = (float) 0.0d;
            matrix.setValues(new float[]{(float) optDouble, (float) optJSONObject.optDouble("c", 0.0d), (float) optJSONObject.optDouble("tx", 0.0d), (float) optDouble2, (float) optJSONObject.optDouble("d", 1.0d), (float) optJSONObject.optDouble("ty", 0.0d), f2, f2, (float) 1.0d});
            this.f37965d = matrix;
        }
    }

    public final void l(ShapeEntity shapeEntity) {
        Type type;
        ShapeEntity.ShapeType shapeType = shapeEntity.type;
        if (shapeType != null) {
            int i = d.$EnumSwitchMapping$0[shapeType.ordinal()];
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
            this.f37962a = type;
        }
    }

    public final void m(JSONObject jSONObject) {
        String optString = jSONObject.optString("type");
        if (optString != null) {
            if (StringsKt__StringsJVMKt.equals(optString, "shape", true)) {
                this.f37962a = Type.shape;
            } else if (StringsKt__StringsJVMKt.equals(optString, "rect", true)) {
                this.f37962a = Type.rect;
            } else if (StringsKt__StringsJVMKt.equals(optString, "ellipse", true)) {
                this.f37962a = Type.ellipse;
            } else if (StringsKt__StringsJVMKt.equals(optString, "keep", true)) {
                this.f37962a = Type.keep;
            }
        }
    }

    public SVGAVideoShapeEntity(ShapeEntity shapeEntity) {
        l(shapeEntity);
        f(shapeEntity);
        h(shapeEntity);
        j(shapeEntity);
    }
}
