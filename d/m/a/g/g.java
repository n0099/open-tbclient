package d.m.a.g;

import android.graphics.Matrix;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.Layout;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public double f67397a;

    /* renamed from: b  reason: collision with root package name */
    public d.m.a.h.c f67398b;

    /* renamed from: c  reason: collision with root package name */
    public Matrix f67399c;

    /* renamed from: d  reason: collision with root package name */
    public b f67400d;

    /* renamed from: e  reason: collision with root package name */
    public List<SVGAVideoShapeEntity> f67401e;

    public g(JSONObject jSONObject) {
        boolean z;
        g gVar = this;
        gVar.f67398b = new d.m.a.h.c(0.0d, 0.0d, 0.0d, 0.0d);
        gVar.f67399c = new Matrix();
        gVar.f67401e = CollectionsKt__CollectionsKt.emptyList();
        gVar.f67397a = jSONObject.optDouble("alpha", 0.0d);
        JSONObject optJSONObject = jSONObject.optJSONObject("layout");
        if (optJSONObject != null) {
            gVar.f67398b = new d.m.a.h.c(optJSONObject.optDouble("x", 0.0d), optJSONObject.optDouble("y", 0.0d), optJSONObject.optDouble("width", 0.0d), optJSONObject.optDouble("height", 0.0d));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("transform");
        if (optJSONObject2 != null) {
            double optDouble = optJSONObject2.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject2.optDouble("b", 0.0d);
            double optDouble3 = optJSONObject2.optDouble("c", 0.0d);
            double optDouble4 = optJSONObject2.optDouble("d", 1.0d);
            double optDouble5 = optJSONObject2.optDouble("tx", 0.0d);
            double optDouble6 = optJSONObject2.optDouble("ty", 0.0d);
            float f2 = (float) optDouble3;
            z = true;
            float f3 = (float) 0.0d;
            float[] fArr = {(float) optDouble, f2, (float) optDouble5, (float) optDouble2, (float) optDouble4, (float) optDouble6, f3, f3, (float) 1.0d};
            gVar = this;
            gVar.f67399c.setValues(fArr);
        } else {
            z = true;
        }
        String optString = jSONObject.optString("clipPath");
        if (optString != null) {
            if (optString.length() <= 0 ? false : z) {
                gVar.f67400d = new b(optString);
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("shapes");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                if (optJSONObject3 != null) {
                    arrayList.add(new SVGAVideoShapeEntity(optJSONObject3));
                }
            }
            gVar.f67401e = CollectionsKt___CollectionsKt.toList(arrayList);
        }
    }

    public final double a() {
        return this.f67397a;
    }

    public final d.m.a.h.c b() {
        return this.f67398b;
    }

    public final b c() {
        return this.f67400d;
    }

    public final List<SVGAVideoShapeEntity> d() {
        return this.f67401e;
    }

    public final Matrix e() {
        return this.f67399c;
    }

    public final void f(List<SVGAVideoShapeEntity> list) {
        this.f67401e = list;
    }

    public g(FrameEntity frameEntity) {
        Float f2;
        Float f3;
        this.f67398b = new d.m.a.h.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.f67399c = new Matrix();
        this.f67401e = CollectionsKt__CollectionsKt.emptyList();
        this.f67397a = frameEntity.alpha != null ? f2.floatValue() : 0.0f;
        Layout layout = frameEntity.layout;
        if (layout != null) {
            Float f4 = layout.x;
            double floatValue = f4 != null ? f4.floatValue() : 0.0f;
            Float f5 = layout.y;
            double floatValue2 = f5 != null ? f5.floatValue() : 0.0f;
            Float f6 = layout.width;
            this.f67398b = new d.m.a.h.c(floatValue, floatValue2, f6 != null ? f6.floatValue() : 0.0f, layout.height != null ? f3.floatValue() : 0.0f);
        }
        Transform transform = frameEntity.transform;
        if (transform != null) {
            float[] fArr = new float[9];
            Float f7 = transform.f38366a;
            float floatValue3 = f7 != null ? f7.floatValue() : 1.0f;
            Float f8 = transform.f38367b;
            float floatValue4 = f8 != null ? f8.floatValue() : 0.0f;
            Float f9 = transform.f38368c;
            float floatValue5 = f9 != null ? f9.floatValue() : 0.0f;
            Float f10 = transform.f38369d;
            float floatValue6 = f10 != null ? f10.floatValue() : 1.0f;
            Float f11 = transform.tx;
            float floatValue7 = f11 != null ? f11.floatValue() : 0.0f;
            Float f12 = transform.ty;
            float floatValue8 = f12 != null ? f12.floatValue() : 0.0f;
            fArr[0] = floatValue3;
            fArr[1] = floatValue5;
            fArr[2] = floatValue7;
            fArr[3] = floatValue4;
            fArr[4] = floatValue6;
            fArr[5] = floatValue8;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            this.f67399c.setValues(fArr);
        }
        String str = frameEntity.clipPath;
        if (str != null) {
            str = str.length() > 0 ? str : null;
            if (str != null) {
                this.f67400d = new b(str);
            }
        }
        List<ShapeEntity> list = frameEntity.shapes;
        Intrinsics.checkExpressionValueIsNotNull(list, "obj.shapes");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (ShapeEntity it : list) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            arrayList.add(new SVGAVideoShapeEntity(it));
        }
        this.f67401e = arrayList;
    }
}
