package com.opensource.svgaplayer.entities;

import android.graphics.Matrix;
import com.baidu.mobstat.Config;
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
/* loaded from: classes5.dex */
public final class g {
    private double djG;
    private Matrix qaY;
    private com.opensource.svgaplayer.b.c qbi;
    private b qbj;
    private List<SVGAVideoShapeEntity> shapes;

    public final double eDF() {
        return this.djG;
    }

    public final com.opensource.svgaplayer.b.c eDG() {
        return this.qbi;
    }

    public final Matrix eDt() {
        return this.qaY;
    }

    public final b eDH() {
        return this.qbj;
    }

    public final void gQ(List<SVGAVideoShapeEntity> list) {
        p.p(list, "<set-?>");
        this.shapes = list;
    }

    public final List<SVGAVideoShapeEntity> iX() {
        return this.shapes;
    }

    public g(JSONObject jSONObject) {
        p.p(jSONObject, "obj");
        this.qbi = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.qaY = new Matrix();
        this.shapes = n.eKM();
        this.djG = jSONObject.optDouble("alpha", 0.0d);
        JSONObject optJSONObject = jSONObject.optJSONObject("layout");
        if (optJSONObject != null) {
            this.qbi = new com.opensource.svgaplayer.b.c(optJSONObject.optDouble(Config.EVENT_HEAT_X, 0.0d), optJSONObject.optDouble("y", 0.0d), optJSONObject.optDouble("width", 0.0d), optJSONObject.optDouble("height", 0.0d));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("transform");
        if (optJSONObject2 != null) {
            this.qaY.setValues(new float[]{(float) optJSONObject2.optDouble("a", 1.0d), (float) optJSONObject2.optDouble("c", 0.0d), (float) optJSONObject2.optDouble("tx", 0.0d), (float) optJSONObject2.optDouble(com.baidu.pass.biometrics.face.liveness.d.b.f2804a, 0.0d), (float) optJSONObject2.optDouble("d", 1.0d), (float) optJSONObject2.optDouble(Config.EXCEPTION_CRASH_CHANNEL, 0.0d), (float) 0.0d, (float) 0.0d, (float) 1.0d});
        }
        String optString = jSONObject.optString("clipPath");
        if (optString != null) {
            if (optString.length() > 0) {
                this.qbj = new b(optString);
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
        p.p(frameEntity, "obj");
        this.qbi = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.qaY = new Matrix();
        this.shapes = n.eKM();
        this.djG = frameEntity.alpha != null ? f.floatValue() : 0.0f;
        Layout layout = frameEntity.layout;
        if (layout != null) {
            Float f3 = layout.x;
            double floatValue = f3 != null ? f3.floatValue() : 0.0f;
            Float f4 = layout.y;
            double floatValue2 = f4 != null ? f4.floatValue() : 0.0f;
            Float f5 = layout.width;
            this.qbi = new com.opensource.svgaplayer.b.c(floatValue, floatValue2, f5 != null ? f5.floatValue() : 0.0f, layout.height != null ? f2.floatValue() : 0.0f);
        }
        Transform transform = frameEntity.transform;
        if (transform != null) {
            float[] fArr = new float[9];
            Float f6 = transform.f7467a;
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
            this.qaY.setValues(fArr);
        }
        String str = frameEntity.clipPath;
        if (str != null) {
            str = str.length() > 0 ? str : null;
            if (str != null) {
                this.qbj = new b(str);
            }
        }
        List<ShapeEntity> list = frameEntity.shapes;
        p.o(list, "obj.shapes");
        List<ShapeEntity> list2 = list;
        ArrayList arrayList = new ArrayList(n.a(list2, 10));
        for (ShapeEntity shapeEntity : list2) {
            p.o(shapeEntity, "it");
            arrayList.add(new SVGAVideoShapeEntity(shapeEntity));
        }
        this.shapes = arrayList;
    }
}
