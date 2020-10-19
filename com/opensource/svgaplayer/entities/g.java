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
import kotlin.collections.o;
import kotlin.h;
import kotlin.jvm.internal.q;
import org.json.JSONArray;
import org.json.JSONObject;
@h
/* loaded from: classes15.dex */
public final class g {
    private double cMh;
    private Matrix oDP;
    private com.opensource.svgaplayer.b.c oDZ;
    private b oEa;
    private List<SVGAVideoShapeEntity> shapes;

    public final double ejI() {
        return this.cMh;
    }

    public final com.opensource.svgaplayer.b.c ejJ() {
        return this.oDZ;
    }

    public final Matrix ejw() {
        return this.oDP;
    }

    public final b ejK() {
        return this.oEa;
    }

    public final void gb(List<SVGAVideoShapeEntity> list) {
        q.n(list, "<set-?>");
        this.shapes = list;
    }

    public final List<SVGAVideoShapeEntity> jz() {
        return this.shapes;
    }

    public g(JSONObject jSONObject) {
        q.n(jSONObject, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.oDZ = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.oDP = new Matrix();
        this.shapes = o.enJ();
        this.cMh = jSONObject.optDouble("alpha", 0.0d);
        JSONObject optJSONObject = jSONObject.optJSONObject("layout");
        if (optJSONObject != null) {
            this.oDZ = new com.opensource.svgaplayer.b.c(optJSONObject.optDouble("x", 0.0d), optJSONObject.optDouble("y", 0.0d), optJSONObject.optDouble("width", 0.0d), optJSONObject.optDouble("height", 0.0d));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("transform");
        if (optJSONObject2 != null) {
            this.oDP.setValues(new float[]{(float) optJSONObject2.optDouble("a", 1.0d), (float) optJSONObject2.optDouble("c", 0.0d), (float) optJSONObject2.optDouble(MapBundleKey.MapObjKey.OBJ_TEXT, 0.0d), (float) optJSONObject2.optDouble(com.baidu.pass.biometrics.face.liveness.d.b.f2751a, 0.0d), (float) optJSONObject2.optDouble("d", 1.0d), (float) optJSONObject2.optDouble("ty", 0.0d), (float) 0.0d, (float) 0.0d, (float) 1.0d});
        }
        String optString = jSONObject.optString("clipPath");
        if (optString != null) {
            if (optString.length() > 0) {
                this.oEa = new b(optString);
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
        this.shapes = o.g(arrayList);
    }

    public g(FrameEntity frameEntity) {
        Float f;
        Float f2;
        q.n(frameEntity, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.oDZ = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.oDP = new Matrix();
        this.shapes = o.enJ();
        this.cMh = frameEntity.alpha != null ? f.floatValue() : 0.0f;
        Layout layout = frameEntity.layout;
        if (layout != null) {
            Float f3 = layout.x;
            double floatValue = f3 != null ? f3.floatValue() : 0.0f;
            Float f4 = layout.y;
            double floatValue2 = f4 != null ? f4.floatValue() : 0.0f;
            Float f5 = layout.width;
            this.oDZ = new com.opensource.svgaplayer.b.c(floatValue, floatValue2, f5 != null ? f5.floatValue() : 0.0f, layout.height != null ? f2.floatValue() : 0.0f);
        }
        Transform transform = frameEntity.transform;
        if (transform != null) {
            float[] fArr = new float[9];
            Float f6 = transform.f4453a;
            float floatValue3 = f6 != null ? f6.floatValue() : 1.0f;
            Float f7 = transform.b;
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
            this.oDP.setValues(fArr);
        }
        String str = frameEntity.clipPath;
        if (str != null) {
            str = str.length() > 0 ? str : null;
            if (str != null) {
                this.oEa = new b(str);
            }
        }
        List<ShapeEntity> list = frameEntity.shapes;
        q.m(list, "obj.shapes");
        List<ShapeEntity> list2 = list;
        ArrayList arrayList = new ArrayList(o.a(list2, 10));
        for (ShapeEntity shapeEntity : list2) {
            q.m(shapeEntity, AdvanceSetting.NETWORK_TYPE);
            arrayList.add(new SVGAVideoShapeEntity(shapeEntity));
        }
        this.shapes = arrayList;
    }
}
