package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.p;
import org.json.JSONArray;
import org.json.JSONObject;
@kotlin.e
/* loaded from: classes5.dex */
public final class f {
    private final List<g> frames;
    private final String imageKey;

    public final String getImageKey() {
        return this.imageKey;
    }

    public final List<g> eDE() {
        return this.frames;
    }

    public f(JSONObject jSONObject) {
        p.p(jSONObject, "obj");
        this.imageKey = jSONObject.optString("imageKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    g gVar = new g(optJSONObject);
                    if ((!gVar.iX().isEmpty()) && ((SVGAVideoShapeEntity) n.first(gVar.iX())).eDu() && arrayList.size() > 0) {
                        gVar.gQ(((g) n.last(arrayList)).iX());
                    }
                    arrayList.add(gVar);
                }
            }
        }
        this.frames = n.g(arrayList);
    }

    public f(SpriteEntity spriteEntity) {
        ArrayList eKM;
        p.p(spriteEntity, "obj");
        this.imageKey = spriteEntity.imageKey;
        g gVar = null;
        List<FrameEntity> list = spriteEntity.frames;
        if (list != null) {
            List<FrameEntity> list2 = list;
            ArrayList arrayList = new ArrayList(n.a(list2, 10));
            g gVar2 = gVar;
            for (FrameEntity frameEntity : list2) {
                p.o(frameEntity, "it");
                g gVar3 = new g(frameEntity);
                if ((!gVar3.iX().isEmpty()) && ((SVGAVideoShapeEntity) n.first(gVar3.iX())).eDu() && gVar2 != null) {
                    gVar3.gQ(gVar2.iX());
                }
                arrayList.add(gVar3);
                gVar2 = gVar3;
            }
            eKM = arrayList;
        } else {
            eKM = n.eKM();
        }
        this.frames = eKM;
    }
}
