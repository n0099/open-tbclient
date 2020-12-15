package com.opensource.svgaplayer.entities;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONObject;
@kotlin.e
/* loaded from: classes18.dex */
public final class SVGAVideoShapeEntity {
    private Type pzN;
    private Map<String, ? extends Object> pzO;
    private a pzP;
    private Matrix pzQ;
    private Path pzR;

    @kotlin.e
    /* loaded from: classes18.dex */
    public enum Type {
        shape,
        rect,
        ellipse,
        keep
    }

    @kotlin.e
    /* loaded from: classes18.dex */
    public static final class a {
        private int fill;
        private int pzS;
        private int pzV;
        private float strokeWidth;
        private String pzT = "butt";
        private String pzU = "miter";
        private float[] pzW = new float[0];

        public final void RE(int i) {
            this.fill = i;
        }

        public final int eAo() {
            return this.fill;
        }

        public final void RF(int i) {
            this.pzS = i;
        }

        public final int eAp() {
            return this.pzS;
        }

        public final void bB(float f) {
            this.strokeWidth = f;
        }

        public final float getStrokeWidth() {
            return this.strokeWidth;
        }

        public final void ZQ(String str) {
            p.o(str, "<set-?>");
            this.pzT = str;
        }

        public final String eAq() {
            return this.pzT;
        }

        public final void ZR(String str) {
            p.o(str, "<set-?>");
            this.pzU = str;
        }

        public final String eAr() {
            return this.pzU;
        }

        public final void RG(int i) {
            this.pzV = i;
        }

        public final int eAs() {
            return this.pzV;
        }

        public final void B(float[] fArr) {
            p.o(fArr, "<set-?>");
            this.pzW = fArr;
        }

        public final float[] eAt() {
            return this.pzW;
        }
    }

    public final a eAj() {
        return this.pzP;
    }

    public final Matrix eAk() {
        return this.pzQ;
    }

    public SVGAVideoShapeEntity(JSONObject jSONObject) {
        p.o(jSONObject, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.pzN = Type.shape;
        eE(jSONObject);
        eF(jSONObject);
        eG(jSONObject);
        eH(jSONObject);
    }

    public SVGAVideoShapeEntity(ShapeEntity shapeEntity) {
        p.o(shapeEntity, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.pzN = Type.shape;
        a(shapeEntity);
        b(shapeEntity);
        c(shapeEntity);
        d(shapeEntity);
    }

    public final boolean eAl() {
        return this.pzN == Type.keep;
    }

    public final Path eAm() {
        return this.pzR;
    }

    private final void eE(JSONObject jSONObject) {
        String optString = jSONObject.optString("type");
        if (optString != null) {
            if (!l.K(optString, "shape", true)) {
                if (!l.K(optString, "rect", true)) {
                    if (!l.K(optString, "ellipse", true)) {
                        if (l.K(optString, "keep", true)) {
                            this.pzN = Type.keep;
                            return;
                        }
                        return;
                    }
                    this.pzN = Type.ellipse;
                    return;
                }
                this.pzN = Type.rect;
                return;
            }
            this.pzN = Type.shape;
        }
    }

    private final void a(ShapeEntity shapeEntity) {
        Type type;
        ShapeEntity.ShapeType shapeType = shapeEntity.type;
        if (shapeType != null) {
            switch (d.pzX[shapeType.ordinal()]) {
                case 1:
                    type = Type.shape;
                    break;
                case 2:
                    type = Type.rect;
                    break;
                case 3:
                    type = Type.ellipse;
                    break;
                case 4:
                    type = Type.keep;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            this.pzN = type;
        }
    }

    private final void eF(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        JSONObject optJSONObject = jSONObject.optJSONObject("args");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            p.n(keys, "values.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = optJSONObject.get(next);
                if (obj != null) {
                    hashMap.put(next, obj);
                }
            }
            this.pzO = hashMap;
        }
    }

    private final void b(ShapeEntity shapeEntity) {
        String str;
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
        this.pzO = hashMap;
    }

    private final void eG(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("styles");
        if (optJSONObject != null) {
            a aVar = new a();
            JSONArray optJSONArray = optJSONObject.optJSONArray("fill");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                aVar.RE(Color.argb((int) (optJSONArray.optDouble(3) * 255), (int) (optJSONArray.optDouble(0) * 255), (int) (optJSONArray.optDouble(1) * 255), (int) (optJSONArray.optDouble(2) * 255)));
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("stroke");
            if (optJSONArray2 != null && optJSONArray2.length() == 4) {
                aVar.RF(Color.argb((int) (optJSONArray2.optDouble(3) * 255), (int) (optJSONArray2.optDouble(0) * 255), (int) (optJSONArray2.optDouble(1) * 255), (int) (optJSONArray2.optDouble(2) * 255)));
            }
            aVar.bB((float) optJSONObject.optDouble("strokeWidth", 0.0d));
            String optString = optJSONObject.optString("lineCap", "butt");
            p.n(optString, "it.optString(\"lineCap\", \"butt\")");
            aVar.ZQ(optString);
            String optString2 = optJSONObject.optString("lineJoin", "miter");
            p.n(optString2, "it.optString(\"lineJoin\", \"miter\")");
            aVar.ZR(optString2);
            aVar.RG(optJSONObject.optInt("miterLimit", 0));
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("lineDash");
            if (optJSONArray3 != null) {
                aVar.B(new float[optJSONArray3.length()]);
                int length = optJSONArray3.length();
                for (int i = 0; i < length; i++) {
                    aVar.eAt()[i] = (float) optJSONArray3.optDouble(i, 0.0d);
                }
            }
            this.pzP = aVar;
        }
    }

    private final void c(ShapeEntity shapeEntity) {
        ShapeEntity.ShapeStyle shapeStyle = shapeEntity.styles;
        if (shapeStyle != null) {
            a aVar = new a();
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor = shapeStyle.fill;
            if (rGBAColor != null) {
                Float f = rGBAColor.f4221a;
                int floatValue = (int) ((f != null ? f.floatValue() : 0.0f) * 255);
                Float f2 = rGBAColor.r;
                int floatValue2 = (int) ((f2 != null ? f2.floatValue() : 0.0f) * 255);
                Float f3 = rGBAColor.g;
                int floatValue3 = (int) ((f3 != null ? f3.floatValue() : 0.0f) * 255);
                Float f4 = rGBAColor.b;
                aVar.RE(Color.argb(floatValue, floatValue2, floatValue3, (int) ((f4 != null ? f4.floatValue() : 0.0f) * 255)));
            }
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor2 = shapeStyle.stroke;
            if (rGBAColor2 != null) {
                Float f5 = rGBAColor2.f4221a;
                int floatValue4 = (int) ((f5 != null ? f5.floatValue() : 0.0f) * 255);
                Float f6 = rGBAColor2.r;
                int floatValue5 = (int) ((f6 != null ? f6.floatValue() : 0.0f) * 255);
                Float f7 = rGBAColor2.g;
                int floatValue6 = (int) ((f7 != null ? f7.floatValue() : 0.0f) * 255);
                Float f8 = rGBAColor2.b;
                aVar.RF(Color.argb(floatValue4, floatValue5, floatValue6, (int) ((f8 != null ? f8.floatValue() : 0.0f) * 255)));
            }
            Float f9 = shapeStyle.strokeWidth;
            aVar.bB(f9 != null ? f9.floatValue() : 0.0f);
            ShapeEntity.ShapeStyle.LineCap lineCap = shapeStyle.lineCap;
            if (lineCap != null) {
                switch (d.pzY[lineCap.ordinal()]) {
                    case 1:
                        aVar.ZQ("butt");
                        break;
                    case 2:
                        aVar.ZQ("round");
                        break;
                    case 3:
                        aVar.ZQ("square");
                        break;
                }
            }
            ShapeEntity.ShapeStyle.LineJoin lineJoin = shapeStyle.lineJoin;
            if (lineJoin != null) {
                switch (d.pzZ[lineJoin.ordinal()]) {
                    case 1:
                        aVar.ZR("bevel");
                        break;
                    case 2:
                        aVar.ZR("miter");
                        break;
                    case 3:
                        aVar.ZR("round");
                        break;
                }
            }
            Float f10 = shapeStyle.miterLimit;
            aVar.RG((int) (f10 != null ? f10.floatValue() : 0.0f));
            aVar.B(new float[3]);
            Float f11 = shapeStyle.lineDashI;
            if (f11 != null) {
                aVar.eAt()[0] = f11.floatValue();
            }
            Float f12 = shapeStyle.lineDashII;
            if (f12 != null) {
                aVar.eAt()[1] = f12.floatValue();
            }
            Float f13 = shapeStyle.lineDashIII;
            if (f13 != null) {
                aVar.eAt()[2] = f13.floatValue();
            }
            this.pzP = aVar;
        }
    }

    private final void eH(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("transform");
        if (optJSONObject != null) {
            Matrix matrix = new Matrix();
            double optDouble = optJSONObject.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject.optDouble(com.baidu.pass.biometrics.face.liveness.d.b.f2755a, 0.0d);
            matrix.setValues(new float[]{(float) optDouble, (float) optJSONObject.optDouble("c", 0.0d), (float) optJSONObject.optDouble(MapBundleKey.MapObjKey.OBJ_TEXT, 0.0d), (float) optDouble2, (float) optJSONObject.optDouble("d", 1.0d), (float) optJSONObject.optDouble("ty", 0.0d), (float) 0.0d, (float) 0.0d, (float) 1.0d});
            this.pzQ = matrix;
        }
    }

    private final void d(ShapeEntity shapeEntity) {
        Transform transform = shapeEntity.transform;
        if (transform != null) {
            Matrix matrix = new Matrix();
            float[] fArr = new float[9];
            Float f = transform.f4223a;
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
            this.pzQ = matrix;
        }
    }

    public final void eAn() {
        if (this.pzR == null) {
            e.eAu().reset();
            if (this.pzN == Type.shape) {
                Map<String, ? extends Object> map = this.pzO;
                Object obj = map != null ? map.get("d") : null;
                if (!(obj instanceof String)) {
                    obj = null;
                }
                String str = (String) obj;
                if (str != null) {
                    new b(str).a(e.eAu());
                }
            } else if (this.pzN == Type.ellipse) {
                Map<String, ? extends Object> map2 = this.pzO;
                Object obj2 = map2 != null ? map2.get("x") : null;
                if (!(obj2 instanceof Number)) {
                    obj2 = null;
                }
                Number number = (Number) obj2;
                if (number != null) {
                    Map<String, ? extends Object> map3 = this.pzO;
                    Object obj3 = map3 != null ? map3.get("y") : null;
                    if (!(obj3 instanceof Number)) {
                        obj3 = null;
                    }
                    Number number2 = (Number) obj3;
                    if (number2 != null) {
                        Map<String, ? extends Object> map4 = this.pzO;
                        Object obj4 = map4 != null ? map4.get("radiusX") : null;
                        if (!(obj4 instanceof Number)) {
                            obj4 = null;
                        }
                        Number number3 = (Number) obj4;
                        if (number3 != null) {
                            Map<String, ? extends Object> map5 = this.pzO;
                            Object obj5 = map5 != null ? map5.get("radiusY") : null;
                            if (!(obj5 instanceof Number)) {
                                obj5 = null;
                            }
                            Number number4 = (Number) obj5;
                            if (number4 != null) {
                                float floatValue = number.floatValue();
                                float floatValue2 = number2.floatValue();
                                float floatValue3 = number3.floatValue();
                                float floatValue4 = number4.floatValue();
                                e.eAu().addOval(new RectF(floatValue - floatValue3, floatValue2 - floatValue4, floatValue + floatValue3, floatValue2 + floatValue4), Path.Direction.CW);
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
            } else if (this.pzN == Type.rect) {
                Map<String, ? extends Object> map6 = this.pzO;
                Object obj6 = map6 != null ? map6.get("x") : null;
                if (!(obj6 instanceof Number)) {
                    obj6 = null;
                }
                Number number5 = (Number) obj6;
                if (number5 != null) {
                    Map<String, ? extends Object> map7 = this.pzO;
                    Object obj7 = map7 != null ? map7.get("y") : null;
                    if (!(obj7 instanceof Number)) {
                        obj7 = null;
                    }
                    Number number6 = (Number) obj7;
                    if (number6 != null) {
                        Map<String, ? extends Object> map8 = this.pzO;
                        Object obj8 = map8 != null ? map8.get("width") : null;
                        if (!(obj8 instanceof Number)) {
                            obj8 = null;
                        }
                        Number number7 = (Number) obj8;
                        if (number7 != null) {
                            Map<String, ? extends Object> map9 = this.pzO;
                            Object obj9 = map9 != null ? map9.get("height") : null;
                            if (!(obj9 instanceof Number)) {
                                obj9 = null;
                            }
                            Number number8 = (Number) obj9;
                            if (number8 != null) {
                                Map<String, ? extends Object> map10 = this.pzO;
                                Object obj10 = map10 != null ? map10.get("cornerRadius") : null;
                                Number number9 = obj10 instanceof Number ? obj10 : null;
                                if (number9 != null) {
                                    float floatValue5 = number5.floatValue();
                                    float floatValue6 = number6.floatValue();
                                    float floatValue7 = number7.floatValue();
                                    float floatValue8 = number8.floatValue();
                                    float floatValue9 = number9.floatValue();
                                    e.eAu().addRoundRect(new RectF(floatValue5, floatValue6, floatValue7 + floatValue5, floatValue8 + floatValue6), floatValue9, floatValue9, Path.Direction.CW);
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
            this.pzR = new Path();
            Path path = this.pzR;
            if (path != null) {
                path.set(e.eAu());
            }
        }
    }
}
