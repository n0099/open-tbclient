package com.opensource.svgaplayer.entities;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.baidu.mobstat.Config;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONObject;
@h
/* loaded from: classes.dex */
public final class SVGAVideoShapeEntity {
    private Type neN;
    private Map<String, ? extends Object> neO;
    private a neP;
    private Matrix neQ;
    private Path neR;

    @h
    /* loaded from: classes.dex */
    public enum Type {
        shape,
        rect,
        ellipse,
        keep
    }

    @h
    /* loaded from: classes.dex */
    public static final class a {
        private int fill;
        private int neS;
        private int neV;
        private float strokeWidth;
        private String neT = "butt";
        private String neU = "miter";
        private float[] neW = new float[0];

        public final void Jv(int i) {
            this.fill = i;
        }

        public final int dHn() {
            return this.fill;
        }

        public final void Jw(int i) {
            this.neS = i;
        }

        public final int dHo() {
            return this.neS;
        }

        public final void aK(float f) {
            this.strokeWidth = f;
        }

        public final float getStrokeWidth() {
            return this.strokeWidth;
        }

        public final void QK(String str) {
            q.m(str, "<set-?>");
            this.neT = str;
        }

        public final String dHp() {
            return this.neT;
        }

        public final void QL(String str) {
            q.m(str, "<set-?>");
            this.neU = str;
        }

        public final String dHq() {
            return this.neU;
        }

        public final void Jx(int i) {
            this.neV = i;
        }

        public final int dHr() {
            return this.neV;
        }

        public final float[] dHs() {
            return this.neW;
        }

        public final void z(float[] fArr) {
            q.m(fArr, "<set-?>");
            this.neW = fArr;
        }
    }

    public final a dHi() {
        return this.neP;
    }

    public final Matrix dHj() {
        return this.neQ;
    }

    public SVGAVideoShapeEntity(JSONObject jSONObject) {
        q.m(jSONObject, "obj");
        this.neN = Type.shape;
        ea(jSONObject);
        eb(jSONObject);
        ec(jSONObject);
        ed(jSONObject);
    }

    public SVGAVideoShapeEntity(ShapeEntity shapeEntity) {
        q.m(shapeEntity, "obj");
        this.neN = Type.shape;
        a(shapeEntity);
        b(shapeEntity);
        c(shapeEntity);
        d(shapeEntity);
    }

    public final boolean dHk() {
        return this.neN == Type.keep;
    }

    public final Path dHl() {
        return this.neR;
    }

    private final void ea(JSONObject jSONObject) {
        String optString = jSONObject.optString("type");
        if (optString != null) {
            if (!l.H(optString, "shape", true)) {
                if (!l.H(optString, "rect", true)) {
                    if (!l.H(optString, "ellipse", true)) {
                        if (l.H(optString, "keep", true)) {
                            this.neN = Type.keep;
                            return;
                        }
                        return;
                    }
                    this.neN = Type.ellipse;
                    return;
                }
                this.neN = Type.rect;
                return;
            }
            this.neN = Type.shape;
        }
    }

    private final void a(ShapeEntity shapeEntity) {
        Type type;
        ShapeEntity.ShapeType shapeType = shapeEntity.type;
        if (shapeType != null) {
            switch (d.neX[shapeType.ordinal()]) {
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
            this.neN = type;
        }
    }

    private final void eb(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        JSONObject optJSONObject = jSONObject.optJSONObject("args");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            q.l((Object) keys, "values.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = optJSONObject.get(next);
                if (obj != null) {
                    hashMap.put(next, obj);
                }
            }
            this.neO = hashMap;
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
            hashMap.put(Config.EVENT_HEAT_X, f);
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
            hashMap.put(Config.EVENT_HEAT_X, f5);
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
        this.neO = hashMap;
    }

    private final void ec(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("styles");
        if (optJSONObject != null) {
            a aVar = new a();
            JSONArray optJSONArray = optJSONObject.optJSONArray("fill");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                aVar.Jv(Color.argb((int) (optJSONArray.optDouble(3) * 255), (int) (optJSONArray.optDouble(0) * 255), (int) (optJSONArray.optDouble(1) * 255), (int) (optJSONArray.optDouble(2) * 255)));
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("stroke");
            if (optJSONArray2 != null && optJSONArray2.length() == 4) {
                aVar.Jw(Color.argb((int) (optJSONArray2.optDouble(3) * 255), (int) (optJSONArray2.optDouble(0) * 255), (int) (optJSONArray2.optDouble(1) * 255), (int) (optJSONArray2.optDouble(2) * 255)));
            }
            aVar.aK((float) optJSONObject.optDouble("strokeWidth", 0.0d));
            String optString = optJSONObject.optString("lineCap", "butt");
            q.l((Object) optString, "it.optString(\"lineCap\", \"butt\")");
            aVar.QK(optString);
            String optString2 = optJSONObject.optString("lineJoin", "miter");
            q.l((Object) optString2, "it.optString(\"lineJoin\", \"miter\")");
            aVar.QL(optString2);
            aVar.Jx(optJSONObject.optInt("miterLimit", 0));
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("lineDash");
            if (optJSONArray3 != null) {
                aVar.z(new float[optJSONArray3.length()]);
                int length = optJSONArray3.length();
                for (int i = 0; i < length; i++) {
                    aVar.dHs()[i] = (float) optJSONArray3.optDouble(i, 0.0d);
                }
            }
            this.neP = aVar;
        }
    }

    private final void c(ShapeEntity shapeEntity) {
        ShapeEntity.ShapeStyle shapeStyle = shapeEntity.styles;
        if (shapeStyle != null) {
            a aVar = new a();
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor = shapeStyle.fill;
            if (rGBAColor != null) {
                Float f = rGBAColor.a;
                int floatValue = (int) ((f != null ? f.floatValue() : 0.0f) * 255);
                Float f2 = rGBAColor.r;
                int floatValue2 = (int) ((f2 != null ? f2.floatValue() : 0.0f) * 255);
                Float f3 = rGBAColor.g;
                int floatValue3 = (int) ((f3 != null ? f3.floatValue() : 0.0f) * 255);
                Float f4 = rGBAColor.b;
                aVar.Jv(Color.argb(floatValue, floatValue2, floatValue3, (int) ((f4 != null ? f4.floatValue() : 0.0f) * 255)));
            }
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor2 = shapeStyle.stroke;
            if (rGBAColor2 != null) {
                Float f5 = rGBAColor2.a;
                int floatValue4 = (int) ((f5 != null ? f5.floatValue() : 0.0f) * 255);
                Float f6 = rGBAColor2.r;
                int floatValue5 = (int) ((f6 != null ? f6.floatValue() : 0.0f) * 255);
                Float f7 = rGBAColor2.g;
                int floatValue6 = (int) ((f7 != null ? f7.floatValue() : 0.0f) * 255);
                Float f8 = rGBAColor2.b;
                aVar.Jw(Color.argb(floatValue4, floatValue5, floatValue6, (int) ((f8 != null ? f8.floatValue() : 0.0f) * 255)));
            }
            Float f9 = shapeStyle.strokeWidth;
            aVar.aK(f9 != null ? f9.floatValue() : 0.0f);
            ShapeEntity.ShapeStyle.LineCap lineCap = shapeStyle.lineCap;
            if (lineCap != null) {
                switch (d.neY[lineCap.ordinal()]) {
                    case 1:
                        aVar.QK("butt");
                        break;
                    case 2:
                        aVar.QK("round");
                        break;
                    case 3:
                        aVar.QK("square");
                        break;
                }
            }
            ShapeEntity.ShapeStyle.LineJoin lineJoin = shapeStyle.lineJoin;
            if (lineJoin != null) {
                switch (d.neZ[lineJoin.ordinal()]) {
                    case 1:
                        aVar.QL("bevel");
                        break;
                    case 2:
                        aVar.QL("miter");
                        break;
                    case 3:
                        aVar.QL("round");
                        break;
                }
            }
            Float f10 = shapeStyle.miterLimit;
            aVar.Jx((int) (f10 != null ? f10.floatValue() : 0.0f));
            aVar.z(new float[3]);
            Float f11 = shapeStyle.lineDashI;
            if (f11 != null) {
                aVar.dHs()[0] = f11.floatValue();
            }
            Float f12 = shapeStyle.lineDashII;
            if (f12 != null) {
                aVar.dHs()[1] = f12.floatValue();
            }
            Float f13 = shapeStyle.lineDashIII;
            if (f13 != null) {
                aVar.dHs()[2] = f13.floatValue();
            }
            this.neP = aVar;
        }
    }

    private final void ed(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("transform");
        if (optJSONObject != null) {
            Matrix matrix = new Matrix();
            double optDouble = optJSONObject.optDouble(Config.APP_VERSION_CODE, 1.0d);
            double optDouble2 = optJSONObject.optDouble("b", 0.0d);
            matrix.setValues(new float[]{(float) optDouble, (float) optJSONObject.optDouble("c", 0.0d), (float) optJSONObject.optDouble("tx", 0.0d), (float) optDouble2, (float) optJSONObject.optDouble("d", 1.0d), (float) optJSONObject.optDouble(Config.EXCEPTION_CRASH_CHANNEL, 0.0d), (float) 0.0d, (float) 0.0d, (float) 1.0d});
            this.neQ = matrix;
        }
    }

    private final void d(ShapeEntity shapeEntity) {
        Transform transform = shapeEntity.transform;
        if (transform != null) {
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
            this.neQ = matrix;
        }
    }

    public final void dHm() {
        if (this.neR == null) {
            e.dHt().reset();
            if (this.neN == Type.shape) {
                Map<String, ? extends Object> map = this.neO;
                Object obj = map != null ? map.get("d") : null;
                if (!(obj instanceof String)) {
                    obj = null;
                }
                String str = (String) obj;
                if (str != null) {
                    new b(str).a(e.dHt());
                }
            } else if (this.neN == Type.ellipse) {
                Map<String, ? extends Object> map2 = this.neO;
                Object obj2 = map2 != null ? map2.get(Config.EVENT_HEAT_X) : null;
                if (!(obj2 instanceof Number)) {
                    obj2 = null;
                }
                Number number = (Number) obj2;
                if (number != null) {
                    Map<String, ? extends Object> map3 = this.neO;
                    Object obj3 = map3 != null ? map3.get("y") : null;
                    if (!(obj3 instanceof Number)) {
                        obj3 = null;
                    }
                    Number number2 = (Number) obj3;
                    if (number2 != null) {
                        Map<String, ? extends Object> map4 = this.neO;
                        Object obj4 = map4 != null ? map4.get("radiusX") : null;
                        if (!(obj4 instanceof Number)) {
                            obj4 = null;
                        }
                        Number number3 = (Number) obj4;
                        if (number3 != null) {
                            Map<String, ? extends Object> map5 = this.neO;
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
                                e.dHt().addOval(new RectF(floatValue - floatValue3, floatValue2 - floatValue4, floatValue + floatValue3, floatValue2 + floatValue4), Path.Direction.CW);
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
            } else if (this.neN == Type.rect) {
                Map<String, ? extends Object> map6 = this.neO;
                Object obj6 = map6 != null ? map6.get(Config.EVENT_HEAT_X) : null;
                if (!(obj6 instanceof Number)) {
                    obj6 = null;
                }
                Number number5 = (Number) obj6;
                if (number5 != null) {
                    Map<String, ? extends Object> map7 = this.neO;
                    Object obj7 = map7 != null ? map7.get("y") : null;
                    if (!(obj7 instanceof Number)) {
                        obj7 = null;
                    }
                    Number number6 = (Number) obj7;
                    if (number6 != null) {
                        Map<String, ? extends Object> map8 = this.neO;
                        Object obj8 = map8 != null ? map8.get("width") : null;
                        if (!(obj8 instanceof Number)) {
                            obj8 = null;
                        }
                        Number number7 = (Number) obj8;
                        if (number7 != null) {
                            Map<String, ? extends Object> map9 = this.neO;
                            Object obj9 = map9 != null ? map9.get("height") : null;
                            if (!(obj9 instanceof Number)) {
                                obj9 = null;
                            }
                            Number number8 = (Number) obj9;
                            if (number8 != null) {
                                Map<String, ? extends Object> map10 = this.neO;
                                Object obj10 = map10 != null ? map10.get("cornerRadius") : null;
                                Number number9 = obj10 instanceof Number ? obj10 : null;
                                if (number9 != null) {
                                    float floatValue5 = number5.floatValue();
                                    float floatValue6 = number6.floatValue();
                                    float floatValue7 = number7.floatValue();
                                    float floatValue8 = number8.floatValue();
                                    float floatValue9 = number9.floatValue();
                                    e.dHt().addRoundRect(new RectF(floatValue5, floatValue6, floatValue7 + floatValue5, floatValue8 + floatValue6), floatValue9, floatValue9, Path.Direction.CW);
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
            this.neR = new Path();
            Path path = this.neR;
            if (path != null) {
                path.set(e.dHt());
            }
        }
    }
}
