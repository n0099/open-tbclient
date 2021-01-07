package com.opensource.svgaplayer.entities;

import android.graphics.Matrix;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.Layout;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.p;
import org.json.JSONArray;
import org.json.JSONObject;
@kotlin.e
/* loaded from: classes6.dex */
public final class g {
    private double dkG;
    private Matrix pUf;
    private com.opensource.svgaplayer.b.c pUp;
    private b pUq;
    private List<SVGAVideoShapeEntity> shapes;

    public final double eES() {
        return this.dkG;
    }

    public final com.opensource.svgaplayer.b.c eET() {
        return this.pUp;
    }

    public final Matrix eEG() {
        return this.pUf;
    }

    public final b eEU() {
        return this.pUq;
    }

    public final void gS(List<SVGAVideoShapeEntity> list) {
        p.o(list, "<set-?>");
        this.shapes = list;
    }

    public final List<SVGAVideoShapeEntity> iY() {
        return this.shapes;
    }

    public g(JSONObject jSONObject) {
        p.o(jSONObject, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.pUp = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.pUf = new Matrix();
        this.shapes = n.eMw();
        this.dkG = jSONObject.optDouble("alpha", 0.0d);
        JSONObject optJSONObject = jSONObject.optJSONObject("layout");
        if (optJSONObject != null) {
            this.pUp = new com.opensource.svgaplayer.b.c(optJSONObject.optDouble("x", 0.0d), optJSONObject.optDouble("y", 0.0d), optJSONObject.optDouble("width", 0.0d), optJSONObject.optDouble("height", 0.0d));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("transform");
        if (optJSONObject2 != null) {
            this.pUf.setValues(new float[]{(float) optJSONObject2.optDouble("a", 1.0d), (float) optJSONObject2.optDouble("c", 0.0d), (float) optJSONObject2.optDouble(MapBundleKey.MapObjKey.OBJ_TEXT, 0.0d), (float) optJSONObject2.optDouble(com.baidu.pass.biometrics.face.liveness.d.b.f4081a, 0.0d), (float) optJSONObject2.optDouble("d", 1.0d), (float) optJSONObject2.optDouble("ty", 0.0d), (float) 0.0d, (float) 0.0d, (float) 1.0d});
        }
        String optString = jSONObject.optString("clipPath");
        if (optString != null) {
            if (optString.length() > 0) {
                this.pUq = new b(optString);
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("shapes");
        if (optJSONArray == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
            if (optJSONObject3 != null) {
                arrayList.add(new SVGAVideoShapeEntity(optJSONObject3));
            }
        }
        this.shapes = n.g(arrayList);
    }

    public g(FrameEntity frameEntity) {
        Float f;
        Float f2;
        p.o(frameEntity, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.pUp = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.pUf = new Matrix();
        this.shapes = n.eMw();
        this.dkG = frameEntity.alpha != null ? f.floatValue() : 0.0f;
        Layout layout = frameEntity.layout;
        if (layout != null) {
            Float f3 = layout.x;
            double floatValue = f3 != null ? f3.floatValue() : 0.0f;
            Float f4 = layout.y;
            double floatValue2 = f4 != null ? f4.floatValue() : 0.0f;
            Float f5 = layout.width;
            this.pUp = new com.opensource.svgaplayer.b.c(floatValue, floatValue2, f5 != null ? f5.floatValue() : 0.0f, layout.height != null ? f2.floatValue() : 0.0f);
        }
        Transform transform = frameEntity.transform;
        if (transform != null) {
            float[] fArr = new float[9];
            Float f6 = transform.f11677a;
            float floatValue3 = f6 != null ? f6.floatValue() : 1.0f;
            Float f7 = transform.f11678b;
            float floatValue4 = f7 != null ? f7.floatValue() : 0.0f;
            Float f8 = transform.c;
            float floatValue5 = f8 != null ? f8.floatValue() : 0.0f;
            Float f9 = transform.d;
            float floatValue6 = f9 != null ? f9.floatValue() : 1.0f;
            Float f10 = transform.tx;
            float floatValue7 = f10 != null ? f10.floatValue() : 0.0f;
            Float f11 = transform.ty;
            float floatValue8 = f11 != null ? f11.floatValue() : 0.0f;
            fArr[0] = floatValue3;
            fArr[1] = floatValue5;
            fArr[2] = floatValue7;
            fArr[3] = floatValue4;
            fArr[4] = floatValue6;
            fArr[5] = floatValue8;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            this.pUf.setValues(fArr);
        }
        String str = frameEntity.clipPath;
        if (str != null) {
            str = str.length() > 0 ? str : null;
            if (str != null) {
                this.pUq = new b(str);
            }
        }
        List<ShapeEntity> list = frameEntity.shapes;
        p.n(list, "obj.shapes");
        List<ShapeEntity> list2 = list;
        ArrayList arrayList = new ArrayList(n.a(list2, 10));
        for (ShapeEntity shapeEntity : list2) {
            p.n(shapeEntity, AdvanceSetting.NETWORK_TYPE);
            arrayList.add(new SVGAVideoShapeEntity(shapeEntity));
        }
        this.shapes = arrayList;
    }
}
