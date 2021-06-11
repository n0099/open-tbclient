package d.l.a.g;

import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f70238a;

    /* renamed from: b  reason: collision with root package name */
    public final List<g> f70239b;

    public f(JSONObject jSONObject) {
        this.f70238a = jSONObject.optString("imageKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    g gVar = new g(optJSONObject);
                    if ((!gVar.d().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt___CollectionsKt.first((List<? extends Object>) gVar.d())).e() && arrayList.size() > 0) {
                        gVar.f(((g) CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList)).d());
                    }
                    arrayList.add(gVar);
                }
            }
        }
        this.f70239b = CollectionsKt___CollectionsKt.toList(arrayList);
    }

    public final List<g> a() {
        return this.f70239b;
    }

    public final String b() {
        return this.f70238a;
    }

    public f(SpriteEntity spriteEntity) {
        List<g> emptyList;
        this.f70238a = spriteEntity.imageKey;
        List<FrameEntity> list = spriteEntity.frames;
        if (list != null) {
            emptyList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            g gVar = null;
            for (FrameEntity it : list) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                g gVar2 = new g(it);
                if ((!gVar2.d().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt___CollectionsKt.first((List<? extends Object>) gVar2.d())).e() && gVar != null) {
                    gVar2.f(gVar.d());
                }
                emptyList.add(gVar2);
                gVar = gVar2;
            }
        } else {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.f70239b = emptyList;
    }
}
